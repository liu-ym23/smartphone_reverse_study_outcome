package com.sdk.bwdl.StateMachine;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.sdk.bwdl.Utils.BWDLLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLStateMachine {
    public static final boolean HANDLED = true;
    private static final String LOG_TAG = "BWDLStateMachine";
    public static final boolean NOT_HANDLED = false;
    private static final int SM_INIT_CMD = -2;
    private static final int SM_QUIT_CMD = -1;
    private IStateListener mListener;
    private String mName;
    private SmHandler mSmHandler;
    private HandlerThread mSmThread;

    /* JADX INFO: renamed from: com.sdk.bwdl.StateMachine.BWDLStateMachine$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface IStateListener {
        void onStateChanged(IBWDLState r8);
    }

    public class SmHandler extends Handler {
        private boolean mDbg;
        private ArrayList<Message> mDeferredMessages;
        private IBWDLState mDestState;
        private HaltingState mHaltingState;
        private boolean mHasQuit;
        private IBWDLState mInitialState;
        private boolean mIsConstructionCompleted;
        private Message mMsg;
        private QuittingState mQuittingState;
        private BWDLStateMachine mSm;
        private final Object mSmHandlerObj;
        private HashMap<IBWDLState, StateInfo> mStateInfo;
        private StateInfo[] mStateStack;
        private int mStateStackTopIndex;
        private StateInfo[] mTempStateStack;
        private int mTempStateStackCount;
        private boolean mTransitionInProgress;
        final /* synthetic */ BWDLStateMachine this$0;

        public class HaltingState implements IBWDLState {
            final /* synthetic */ SmHandler this$1;

            private HaltingState(SmHandler r8) {
                this.this$1 = r8;
            }

            @Override // com.sdk.bwdl.StateMachine.IBWDLState
            public void enter() {
            }

            @Override // com.sdk.bwdl.StateMachine.IBWDLState
            public void exit() {
            }

            @Override // com.sdk.bwdl.StateMachine.IBWDLState
            public boolean processMessage(Message r8) {
                SmHandler.access$200(this.this$1).haltedProcessMessage(r8);
                return true;
            }

            public /* synthetic */ HaltingState(SmHandler r8, AnonymousClass1 r10) {
                this(r8);
            }
        }

        public class QuittingState implements IBWDLState {
            final /* synthetic */ SmHandler this$1;

            private QuittingState(SmHandler r8) {
                this.this$1 = r8;
            }

            @Override // com.sdk.bwdl.StateMachine.IBWDLState
            public void enter() {
            }

            @Override // com.sdk.bwdl.StateMachine.IBWDLState
            public void exit() {
            }

            @Override // com.sdk.bwdl.StateMachine.IBWDLState
            public boolean processMessage(Message r8) {
                return false;
            }

            public /* synthetic */ QuittingState(SmHandler r8, AnonymousClass1 r10) {
                this(r8);
            }
        }

        public class StateInfo {
            boolean active;
            StateInfo parentStateInfo;
            IBWDLState state;
            final /* synthetic */ SmHandler this$1;

            private StateInfo(SmHandler r8) {
                this.this$1 = r8;
            }

            public /* synthetic */ StateInfo(SmHandler r8, AnonymousClass1 r10) {
                this(r8);
            }
        }

        private SmHandler(BWDLStateMachine r8, Looper r10, BWDLStateMachine r11) {
            this.this$0 = r8;
            super(r10);
            this.mHasQuit = false;
            this.mDbg = false;
            this.mSmHandlerObj = new Object();
            this.mStateStackTopIndex = -1;
            AnonymousClass1 r12 = null;
            this.mHaltingState = new HaltingState(this, r12);
            this.mQuittingState = new QuittingState(this, r12);
            this.mStateInfo = new HashMap();
            this.mTransitionInProgress = false;
            this.mDeferredMessages = new ArrayList();
            this.mSm = r11;
            addState(this.mHaltingState, null);
            addState(this.mQuittingState, null);
        }

        public static /* synthetic */ boolean a(StateInfo r8, StateInfo r10) {
            return lambda$removeState$0(r8, r10);
        }

        public static /* synthetic */ Message access$1000(SmHandler r8) {
            return r8.getCurrentMessage();
        }

        public static /* synthetic */ IBWDLState access$1100(SmHandler r8) {
            return r8.getCurrentState();
        }

        public static /* synthetic */ void access$1200(SmHandler r8, IBWDLState r10) {
            r8.transitionTo(r10);
        }

        public static /* synthetic */ void access$1300(SmHandler r8, Message r10) {
            r8.deferMessage(r10);
        }

        public static /* synthetic */ ArrayList access$1400(SmHandler r8) {
            return r8.mDeferredMessages;
        }

        public static /* synthetic */ void access$1500(SmHandler r8) {
            r8.quit();
        }

        public static /* synthetic */ void access$1600(SmHandler r8) {
            r8.quitNow();
        }

        public static /* synthetic */ void access$1700(SmHandler r8) {
            r8.completeConstruction();
        }

        public static /* synthetic */ BWDLStateMachine access$200(SmHandler r8) {
            return r8.mSm;
        }

        public static /* synthetic */ StateInfo access$700(SmHandler r8, IBWDLState r10, IBWDLState r11) {
            return r8.addState(r10, r11);
        }

        public static /* synthetic */ void access$800(SmHandler r8, IBWDLState r10) {
            r8.removeState(r10);
        }

        public static /* synthetic */ void access$900(SmHandler r8, IBWDLState r10) {
            r8.setInitialState(r10);
        }

        private final StateInfo addState(IBWDLState r8, IBWDLState r10) {
            AnonymousClass1 r11 = null;
            if (r10 == null) goto L7;
            StateInfo r12 = this.mStateInfo.get(r10);
            if (r12 != null) goto L8;
            r12 = addState(r10, null);
        L8:
            StateInfo r13 = this.mStateInfo.get(r8);
            if (r13 != null) goto L11;
            r13 = new StateInfo(this, r11);
            this.mStateInfo.put(r8, r13);
        L11:
            StateInfo r14 = r13.parentStateInfo;
            if (r14 == null) goto L17;
            if (r14 == r12) goto L17;
            throw new RuntimeException("state already added");
        L17:
            r13.state = r8;
            r13.parentStateInfo = r12;
            r13.active = false;
            return r13;
        L7:
            r12 = null;
            goto L8
        }

        private final void cleanupAfterQuitting() {
            if (BWDLStateMachine.access$300(this.mSm) == null) goto L5;
            getLooper().quit();
            BWDLStateMachine.access$302(this.mSm, null);
        L5:
            BWDLStateMachine.access$402(this.mSm, null);
            this.mSm = null;
            this.mMsg = null;
            this.mStateStack = null;
            this.mTempStateStack = null;
            this.mStateInfo.clear();
            this.mInitialState = null;
            this.mDestState = null;
            this.mDeferredMessages.clear();
            this.mHasQuit = true;
        }

        private final void completeConstruction() {
            Iterator<StateInfo> r8 = this.mStateInfo.values().iterator();
            int r10 = 0;
        L4:
            if (r8.hasNext() == false) goto L10;
            StateInfo r11 = r8.next();
            int r12 = 0;
        L6:
            if (r11 == null) goto L8;
            r11 = r11.parentStateInfo;
            r12 = r12 + 1;
            goto L6
        L8:
            if (r10 >= r12) goto L4;
            r10 = r12;
            goto L4
        L10:
            this.mStateStack = new StateInfo[r10];
            this.mTempStateStack = new StateInfo[r10];
            setupInitialStateStack();
            sendMessageAtFrontOfQueue(obtainMessage(-2, this.mSmHandlerObj));
        }

        private final void deferMessage(Message r8) {
            Message r10 = obtainMessage();
            r10.copyFrom(r8);
            this.mDeferredMessages.add(r10);
        }

        private final Message getCurrentMessage() {
            return this.mMsg;
        }

        private final IBWDLState getCurrentState() {
            return this.mStateStack[this.mStateStackTopIndex].state;
        }

        private final void invokeEnterMethods(int r8) {
            int r10 = r8;
        L3:
            int r11 = this.mStateStackTopIndex;
            if (r10 > r11) goto L13;
            if (r8 != r11) goto L7;
            this.mTransitionInProgress = false;
        L7:
            StateInfo[] r12 = this.mStateStack;
            if (r12 == null) goto L12;
            if (r12.length == 0) goto L12;
            r12[r10].state.enter();
            this.mStateStack[r10].active = true;
        L12:
            r10 = r10 + 1;
            goto L3
        L13:
            this.mTransitionInProgress = false;
        }

        private final void invokeExitMethods(StateInfo r8) {
        L2:
            int r10 = this.mStateStackTopIndex;
            if (r10 < 0) goto L7;
            StateInfo r11 = this.mStateStack[r10];
            if (r11 == r8) goto L10;
            r11.state.exit();
            StateInfo[] r12 = this.mStateStack;
            int r13 = this.mStateStackTopIndex;
            r12[r13].active = false;
            this.mStateStackTopIndex = r13 - 1;
            goto L2
        L10:
            return;
        }

        private final boolean isQuit(Message r8) {
            if (r8.what == (-1)) goto L5;
        L7:
            return false;
        L5:
            if (r8.obj != this.mSmHandlerObj) goto L7;
            return true;
        }

        private static /* synthetic */ boolean lambda$removeState$0(StateInfo r8, StateInfo r10) {
            if (r10.parentStateInfo != r8) goto L5;
            return true;
        L5:
            return false;
        }

        private final void moveDeferredMessageAtFrontOfQueue() {
            int r8 = this.mDeferredMessages.size() - 1;
        L3:
            if (r8 < 0) goto L5;
            sendMessageAtFrontOfQueue(this.mDeferredMessages.get(r8));
            r8 = r8 - 1;
            goto L3
        L5:
            this.mDeferredMessages.clear();
        }

        private final int moveTempStateStackToStateStack() {
            int r8 = this.mStateStackTopIndex + 1;
            int r10 = this.mTempStateStackCount - 1;
            int r11 = r8;
        L3:
            if (r10 < 0) goto L5;
            this.mStateStack[r11] = this.mTempStateStack[r10];
            r11 = r11 + 1;
            r10 = r10 - 1;
            goto L3
        L5:
            this.mStateStackTopIndex = r11 - 1;
            return r8;
        }

        private void performTransitions(IBWDLState r8, Message r10) {
            IBWDLState r11 = this.mStateStack[this.mStateStackTopIndex].state;
            IBWDLState r12 = this.mDestState;
            if (r12 == null) goto L8;
        L4:
            StateInfo r13 = setupTempStateStackWithStatesToEnter(r12);
            this.mTransitionInProgress = true;
            invokeExitMethods(r13);
            invokeEnterMethods(moveTempStateStackToStateStack());
            moveDeferredMessageAtFrontOfQueue();
            this.this$0.notifyState(r12);
            IBWDLState r14 = this.mDestState;
            if (r12 == r14) goto L7;
            r12 = r14;
            goto L4
        L7:
            this.mDestState = null;
        L8:
            if (r12 != null) goto L10;
            return;
        L10:
            if (r12 != this.mQuittingState) goto L13;
            this.mSm.onQuitting();
            cleanupAfterQuitting();
            return;
        L13:
            if (r12 != this.mHaltingState) goto L19;
            this.mSm.onHalting();
            return;
        }

        private final IBWDLState processMsg(Message r8) {
            StateInfo r10 = this.mStateStack[this.mStateStackTopIndex];
            if (isQuit(r8) == false) goto L6;
            transitionTo(this.mQuittingState);
        L10:
            if (r10 != null) goto L17;
            return null;
        L17:
            return r10.state;
        L6:
            if (r10.state.processMessage(r8) == true) goto L10;
            r10 = r10.parentStateInfo;
            if (r10 != null) goto L6;
            this.mSm.unhandledMessage(r8);
            goto L10
        }

        private final void quit() {
            sendMessage(obtainMessage(-1, this.mSmHandlerObj));
        }

        private final void quitNow() {
            sendMessageAtFrontOfQueue(obtainMessage(-1, this.mSmHandlerObj));
        }

        private void removeState(IBWDLState r8) {
            final StateInfo r10 = this.mStateInfo.get(r8);
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.active == false) goto L8;
            return;
        L8:
            if (this.mStateInfo.values().stream().filter(new a(r10)).findAny().isPresent() == false) goto L10;
            return;
        L10:
            this.mStateInfo.remove(r8);
        }

        private final void setInitialState(IBWDLState r8) {
            this.mInitialState = r8;
        }

        private final void setupInitialStateStack() {
            StateInfo r8 = this.mStateInfo.get(this.mInitialState);
            this.mTempStateStackCount = 0;
        L3:
            if (r8 == null) goto L5;
            StateInfo[] r10 = this.mTempStateStack;
            int r11 = this.mTempStateStackCount;
            r10[r11] = r8;
            r8 = r8.parentStateInfo;
            this.mTempStateStackCount = r11 + 1;
            goto L3
        L5:
            this.mStateStackTopIndex = -1;
            moveTempStateStackToStateStack();
        }

        private final StateInfo setupTempStateStackWithStatesToEnter(IBWDLState r8) {
            this.mTempStateStackCount = 0;
            StateInfo r10 = this.mStateInfo.get(r8);
        L3:
            StateInfo[] r11 = this.mTempStateStack;
            int r12 = this.mTempStateStackCount;
            this.mTempStateStackCount = r12 + 1;
            r11[r12] = r10;
            if (r10 == null) goto L6;
            r10 = r10.parentStateInfo;
        L6:
            if (r10 == null) goto L9;
            if (r10.active == false) goto L3;
        L9:
            return r10;
        }

        private final void transitionTo(IBWDLState r8) {
            this.mDestState = r8;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
            if (this.mHasQuit == true) goto L30;
            BWDLStateMachine r10 = this.mSm;
            if (r10 == null) goto L10;
            int r11 = r8.what;
            if (r11 == (-2)) goto L10;
            if (r11 == (-1)) goto L10;
            r10.onPreHandleMessage(r8);
        L10:
            this.mMsg = r8;
            boolean r12 = this.mIsConstructionCompleted;
            if (r12 == true) goto L22;
            int r13 = r8.what;
            if (r13 == (-1)) goto L22;
            if (r12 == true) goto L21;
            if (r13 != (-2)) goto L21;
            if (r8.obj != this.mSmHandlerObj) goto L21;
            this.mIsConstructionCompleted = true;
            invokeEnterMethods(0);
            IBWDLState r14 = null;
        L23:
            performTransitions(r14, r8);
            BWDLStateMachine r15 = this.mSm;
            if (r15 == null) goto L31;
            int r16 = r8.what;
            if (r16 == (-2)) goto L32;
            if (r16 == (-1)) goto L33;
            r15.onPostHandleMessage(r8);
            return;
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L21:
            throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + r8);
        L22:
            r14 = processMsg(r8);
            goto L23
        }

        public /* synthetic */ SmHandler(BWDLStateMachine r8, Looper r10, BWDLStateMachine r11, AnonymousClass1 r12) {
            this(r8, r10, r11);
        }
    }

    public BWDLStateMachine(String r8) {
        HandlerThread r10 = new HandlerThread(r8);
        this.mSmThread = r10;
        r10.start();
        initStateMachine(r8, this.mSmThread.getLooper());
    }

    public static /* synthetic */ HandlerThread access$300(BWDLStateMachine r8) {
        return r8.mSmThread;
    }

    public static /* synthetic */ HandlerThread access$302(BWDLStateMachine r8, HandlerThread r10) {
        r8.mSmThread = r10;
        return r10;
    }

    public static /* synthetic */ SmHandler access$402(BWDLStateMachine r8, SmHandler r10) {
        r8.mSmHandler = r10;
        return r10;
    }

    private void initStateMachine(String r8, Looper r10) {
        this.mName = r8;
        this.mSmHandler = new SmHandler(this, r10, this, null);
    }

    public final void addState(IBWDLState r8) {
        SmHandler.access$700(this.mSmHandler, r8, null);
    }

    public final void deferMessage(Message r8) {
        SmHandler.access$1300(this.mSmHandler, r8);
    }

    public final Message getCurrentMessage() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L7;
        return null;
    L7:
        return SmHandler.access$1000(r8);
    }

    public final IBWDLState getCurrentState() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L7;
        return null;
    L7:
        return SmHandler.access$1100(r8);
    }

    public void haltedProcessMessage(Message r8) {
    }

    public final boolean hasMessages(int r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.hasMessages(r8);
    }

    public void notifyState(IBWDLState r8) {
        this.mListener.onStateChanged(r8);
    }

    public final Message obtainMessage() {
        return Message.obtain(this.mSmHandler);
    }

    public void onHalting() {
    }

    public void onPostHandleMessage(Message r8) {
    }

    public void onPreHandleMessage(Message r8) {
    }

    public void onQuitting() {
    }

    public final void quit() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L5;
        return;
    L5:
        SmHandler.access$1500(r8);
    }

    public final void quitNow() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L5;
        return;
    L5:
        SmHandler.access$1600(r8);
    }

    public final void removeDeferredMessages(int r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator r11 = SmHandler.access$1400(r10).iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        if (((Message) r11.next()).what != r8) goto L7;
        r11.remove();
        goto L7
    }

    public final void removeMessages(int r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.removeMessages(r8);
    }

    public final void removeState(IBWDLState r8) {
        SmHandler.access$800(this.mSmHandler, r8);
    }

    public void sendMessage(int r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.sendMessage(obtainMessage(r8));
    }

    public final void sendMessageAtFrontOfQueue(int r8, int r10) {
        SmHandler r11 = this.mSmHandler;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.sendMessageAtFrontOfQueue(obtainMessage(r8, r10));
    }

    public void sendMessageDelayed(int r8, int r10, int r11, long r12) {
        SmHandler r13 = this.mSmHandler;
        if (r13 != null) goto L5;
        return;
    L5:
        r13.sendMessageDelayed(obtainMessage(r8, r10, r11), r12);
    }

    public final void setInitialState(IBWDLState r8) {
        SmHandler.access$900(this.mSmHandler, r8);
    }

    public void setStateListener(IStateListener r8) {
        this.mListener = r8;
    }

    public void start() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L5;
        return;
    L5:
        SmHandler.access$1700(r8);
    }

    public final void transitionTo(IBWDLState r8) {
        SmHandler.access$1200(this.mSmHandler, r8);
    }

    public void unhandledMessage(Message r8) {
        BWDLLog.d(LOG_TAG, "UnhandledMessage:" + r8.what);
    }

    public final void addState(IBWDLState r8, IBWDLState r10) {
        SmHandler.access$700(this.mSmHandler, r8, r10);
    }

    public final Message obtainMessage(int r8) {
        return Message.obtain(this.mSmHandler, r8);
    }

    public final void removeMessages(int r8, Object r10) {
        SmHandler r11 = this.mSmHandler;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.removeMessages(r8, r10);
    }

    public void sendMessage(int r8, int r10) {
        SmHandler r11 = this.mSmHandler;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.sendMessage(obtainMessage(r8, r10));
    }

    public final void sendMessageAtFrontOfQueue(int r8, Object r10) {
        SmHandler r11 = this.mSmHandler;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.sendMessageAtFrontOfQueue(obtainMessage(r8, r10));
    }

    public void sendMessageDelayed(int r8, int r10, int r11, Object r12, long r13) {
        SmHandler r14 = this.mSmHandler;
        if (r14 != null) goto L5;
        return;
    L5:
        r14.sendMessageDelayed(obtainMessage(r8, r10, r11, r12), r13);
    }

    public final Message obtainMessage(int r8, int r10) {
        return Message.obtain(this.mSmHandler, r8, r10, 0);
    }

    public void sendMessage(int r8, int r10, int r11) {
        SmHandler r12 = this.mSmHandler;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.sendMessage(obtainMessage(r8, r10, r11));
    }

    public final void sendMessageAtFrontOfQueue(Message r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.sendMessageAtFrontOfQueue(r8);
    }

    public void sendMessageDelayed(int r8, int r10, long r11) {
        SmHandler r12 = this.mSmHandler;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.sendMessageDelayed(obtainMessage(r8, r10), r11);
    }

    public final Message obtainMessage(int r8, int r10, int r11) {
        return Message.obtain(this.mSmHandler, r8, r10, r11);
    }

    public void sendMessage(int r8, int r10, int r11, Object r12) {
        SmHandler r13 = this.mSmHandler;
        if (r13 != null) goto L5;
        return;
    L5:
        r13.sendMessage(obtainMessage(r8, r10, r11, r12));
    }

    public void sendMessageDelayed(int r8, long r10) {
        SmHandler r11 = this.mSmHandler;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.sendMessageDelayed(obtainMessage(r8), r10);
    }

    public final Message obtainMessage(int r8, int r10, int r11, Object r12) {
        return Message.obtain(this.mSmHandler, r8, r10, r11, r12);
    }

    public void sendMessage(int r8, Object r10) {
        SmHandler r11 = this.mSmHandler;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.sendMessage(obtainMessage(r8, r10));
    }

    public void sendMessageDelayed(int r8, Object r10, long r11) {
        SmHandler r12 = this.mSmHandler;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.sendMessageDelayed(obtainMessage(r8, r10), r11);
    }

    public final Message obtainMessage(int r8, Object r10) {
        return Message.obtain(this.mSmHandler, r8, r10);
    }

    public void sendMessage(Message r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.sendMessage(r8);
    }

    public void sendMessageDelayed(Message r8, long r10) {
        SmHandler r11 = this.mSmHandler;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.sendMessageDelayed(r8, r10);
    }
}
