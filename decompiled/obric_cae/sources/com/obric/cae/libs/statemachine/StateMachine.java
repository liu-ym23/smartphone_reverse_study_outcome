package com.obric.cae.libs.statemachine;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.annotations.VisibleForTesting;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import defpackage.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class StateMachine {
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;
    private static final int SM_INIT_CMD = -2;
    private static final int SM_QUIT_CMD = -1;
    private String mName;
    private SmHandler mSmHandler;
    private HandlerThread mSmThread;

    /* JADX INFO: renamed from: com.obric.cae.libs.statemachine.StateMachine$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class LogRec {
        private IState mDstState;
        private String mInfo;
        private IState mOrgState;
        private StateMachine mSm;
        private IState mState;
        private long mTime;
        private int mWhat;

        public LogRec(StateMachine r8, Message r10, String r11, IState r12, IState r13, IState r14) {
            update(r8, r10, r11, r12, r13, r14);
        }

        public IState getDestState() {
            return this.mDstState;
        }

        public String getInfo() {
            return this.mInfo;
        }

        public IState getOriginalState() {
            return this.mOrgState;
        }

        public IState getState() {
            return this.mState;
        }

        public long getTime() {
            return this.mTime;
        }

        public long getWhat() {
            return this.mWhat;
        }

        public String toString() {
            StringBuilder r8 = new StringBuilder("time=");
            Calendar r10 = Calendar.getInstance();
            r10.setTimeInMillis(this.mTime);
            r8.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[]{r10, r10, r10, r10, r10, r10}));
            r8.append(" processed=");
            IState r11 = this.mState;
            String r12 = "<null>";
            if (r11 != null) goto L5;
            String r13 = "<null>";
        L6:
            r8.append(r13);
            r8.append(" org=");
            IState r14 = this.mOrgState;
            if (r14 != null) goto L9;
            String r15 = "<null>";
        L10:
            r8.append(r15);
            r8.append(" dest=");
            IState r16 = this.mDstState;
            if (r16 == null) goto L14;
            r12 = r16.getName();
        L14:
            r8.append(r12);
            r8.append(" what=");
            StateMachine r17 = this.mSm;
            if (r17 == null) goto L17;
            String r18 = r17.getWhatToString(this.mWhat);
        L19:
            if (TextUtils.isEmpty(r18) == false) goto L21;
            r8.append(this.mWhat);
            r8.append("(0x");
            r8.append(Integer.toHexString(this.mWhat));
            r18 = ")";
        L21:
            r8.append(r18);
            if (TextUtils.isEmpty(this.mInfo) == true) goto L25;
            r8.append(" ");
            r8.append(this.mInfo);
        L25:
            return r8.toString();
        L17:
            r18 = "";
            goto L19
        L9:
            r15 = r14.getName();
            goto L10
        L5:
            r13 = r11.getName();
            goto L6
        }

        public void update(StateMachine r8, Message r10, String r11, IState r12, IState r13, IState r14) {
            this.mSm = r8;
            this.mTime = System.currentTimeMillis();
            if (r10 == null) goto L5;
            int r15 = r10.what;
        L6:
            this.mWhat = r15;
            this.mInfo = r11;
            this.mState = r12;
            this.mOrgState = r13;
            this.mDstState = r14;
            return;
        L5:
            r15 = 0;
            goto L6
        }
    }

    public static class LogRecords {
        private static final int DEFAULT_SIZE = 20;
        private int mCount;
        private boolean mLogOnlyTransitions;
        private Vector<LogRec> mLogRecVector;
        private int mMaxSize;
        private int mOldestIndex;

        private LogRecords() {
            this.mLogRecVector = new Vector();
            this.mMaxSize = 20;
            this.mOldestIndex = 0;
            this.mCount = 0;
            this.mLogOnlyTransitions = false;
        }

        public static /* synthetic */ int access$1800(LogRecords r8) {
            return r8.mMaxSize;
        }

        public static /* synthetic */ Vector access$1900(LogRecords r8) {
            return r8.mLogRecVector;
        }

        public synchronized void add(StateMachine r10, Message r11, String r12, IState r13, IState r14, IState r15) {
            monitor-enter(this);
            this.mCount++;     // Catch: Throwable -> L12
            if (this.mLogRecVector.size() >= this.mMaxSize) goto L6;
            this.mLogRecVector.add(new LogRec(r10, r11, r12, r13, r14, r15));     // Catch: Throwable -> L12
        L10:
            monitor-exit(this);
            return;
        L6:
            LogRec r8 = this.mLogRecVector.get(this.mOldestIndex);     // Catch: Throwable -> L12
            int r16 = this.mOldestIndex + 1;     // Catch: Throwable -> L12
            this.mOldestIndex = r16;     // Catch: Throwable -> L12
            if (r16 < this.mMaxSize) goto L9;
            this.mOldestIndex = 0;     // Catch: Throwable -> L12
        L9:
            r8.update(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        public synchronized void cleanup() {
            monitor-enter(this);
            this.mLogRecVector.clear();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized int count() {
            monitor-enter(this);
            int r8 = this.mCount;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r8;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized LogRec get(int r8) {
            monitor-enter(this);
            int r10 = this.mOldestIndex + r8;     // Catch: Throwable -> L14
            int r11 = this.mMaxSize;     // Catch: Throwable -> L14
            if (r10 < r11) goto L7;
            r10 = r10 - r11;     // Catch: Throwable -> L14
        L7:
            if (r10 < size()) goto L11;
            monitor-exit(this);
            return null;
        L11:
            LogRec r12 = this.mLogRecVector.get(r10);     // Catch: Throwable -> L14
            monitor-exit(this);
            return r12;
        L14:
            th = move-exception;
            throw th;
        }

        public synchronized boolean logOnlyTransitions() {
            monitor-enter(this);
            boolean r8 = this.mLogOnlyTransitions;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r8;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void setLogOnlyTransitions(boolean r8) {
            monitor-enter(this);
            this.mLogOnlyTransitions = r8;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void setSize(int r8) {
            monitor-enter(this);
            this.mMaxSize = r8;     // Catch: Throwable -> L6
            this.mOldestIndex = 0;     // Catch: Throwable -> L6
            this.mCount = 0;     // Catch: Throwable -> L6
            this.mLogRecVector.clear();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized int size() {
            monitor-enter(this);
            int r8 = this.mLogRecVector.size();     // Catch: Throwable -> L6
            monitor-exit(this);
            return r8;
        L6:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ LogRecords(AnonymousClass1 r8) {
            this();
        }
    }

    public static class SmHandler extends Handler {
        private static final Object mSmHandlerObj = null;
        private boolean mDbg;
        private final ArrayList<Message> mDeferredMessages;
        private State mDestState;
        private final HaltingState mHaltingState;
        private boolean mHasQuit;
        private State mInitialState;
        private boolean mIsConstructionCompleted;
        private final LogRecords mLogRecords;
        private Message mMsg;
        private final QuittingState mQuittingState;
        private StateMachine mSm;
        private final HashMap<State, StateInfo> mStateInfo;
        private StateInfo[] mStateStack;
        private int mStateStackTopIndex;
        private StateInfo[] mTempStateStack;
        private int mTempStateStackCount;
        private boolean mTransitionInProgress;

        public class HaltingState extends State {
            final /* synthetic */ SmHandler this$0;

            private HaltingState(SmHandler r8) {
                this.this$0 = r8;
            }

            @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
            public boolean processMessage(Message r8) {
                SmHandler.access$300(this.this$0).haltedProcessMessage(r8);
                return true;
            }

            public /* synthetic */ HaltingState(SmHandler r8, AnonymousClass1 r10) {
                this(r8);
            }
        }

        public static class QuittingState extends State {
            private QuittingState() {
            }

            public /* synthetic */ QuittingState(AnonymousClass1 r8) {
                this();
            }

            @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
            public boolean processMessage(Message r8) {
                return false;
            }
        }

        public static class StateInfo {
            boolean active;
            final StateInfo parentStateInfo;
            final State state;

            public StateInfo(State r8, StateInfo r10) {
                this.active = false;
                this.state = r8;
                this.parentStateInfo = r10;
            }

            public String toString() {
                StringBuilder r8 = new StringBuilder("state=");
                r8.append(this.state.getName());
                r8.append(",active=");
                r8.append(this.active);
                r8.append(",parent=");
                StateInfo r10 = this.parentStateInfo;
                if (r10 != null) goto L5;
                String r11 = "null";
            L6:
                r8.append(r11);
                return r8.toString();
            L5:
                r11 = r10.state.getName();
                goto L6
            }
        }

        static {
            mSmHandlerObj = new Object();
        }

        private SmHandler(Looper r8, StateMachine r10) {
            super(r8);
            this.mHasQuit = false;
            this.mDbg = false;
            AnonymousClass1 r11 = null;
            this.mLogRecords = new LogRecords(r11);
            this.mStateStackTopIndex = -1;
            HaltingState r12 = new HaltingState(this, r11);
            this.mHaltingState = r12;
            QuittingState r13 = new QuittingState(r11);
            this.mQuittingState = r13;
            this.mStateInfo = new HashMap();
            this.mTransitionInProgress = false;
            this.mDeferredMessages = new ArrayList();
            this.mSm = r10;
            addState(r12, null);
            addState(r13, null);
        }

        public static /* synthetic */ boolean a(StateInfo r8, StateInfo r10) {
            return lambda$removeState$0(r8, r10);
        }

        public static /* synthetic */ void access$1000(SmHandler r8, State r10) {
            r8.setInitialState(r10);
        }

        public static /* synthetic */ Message access$1100(SmHandler r8) {
            return r8.getCurrentMessage();
        }

        public static /* synthetic */ IState access$1200(SmHandler r8) {
            return r8.getCurrentState();
        }

        public static /* synthetic */ void access$1300(SmHandler r8, IState r10) {
            r8.transitionTo(r10);
        }

        public static /* synthetic */ HaltingState access$1400(SmHandler r8) {
            return r8.mHaltingState;
        }

        public static /* synthetic */ void access$1500(SmHandler r8, Message r10) {
            r8.deferMessage(r10);
        }

        public static /* synthetic */ boolean access$1600(SmHandler r8) {
            return r8.mDbg;
        }

        public static /* synthetic */ LogRecords access$1700(SmHandler r8) {
            return r8.mLogRecords;
        }

        public static /* synthetic */ StateInfo[] access$2000(SmHandler r8) {
            return r8.mStateStack;
        }

        public static /* synthetic */ int access$2100(SmHandler r8) {
            return r8.mStateStackTopIndex;
        }

        public static /* synthetic */ State access$2200(SmHandler r8) {
            return r8.mDestState;
        }

        public static /* synthetic */ ArrayList access$2300(SmHandler r8) {
            return r8.mDeferredMessages;
        }

        public static /* synthetic */ boolean access$2400(SmHandler r8, Message r10) {
            return r8.isQuit(r10);
        }

        public static /* synthetic */ void access$2500(SmHandler r8) {
            r8.quit();
        }

        public static /* synthetic */ void access$2600(SmHandler r8) {
            r8.quitNow();
        }

        public static /* synthetic */ boolean access$2700(SmHandler r8) {
            return r8.isDbg();
        }

        public static /* synthetic */ void access$2800(SmHandler r8, boolean r10) {
            r8.setDbg(r10);
        }

        public static /* synthetic */ void access$2900(SmHandler r8) {
            r8.completeConstruction();
        }

        public static /* synthetic */ StateMachine access$300(SmHandler r8) {
            return r8.mSm;
        }

        public static /* synthetic */ StateInfo access$800(SmHandler r8, State r10, State r11) {
            return r8.addState(r10, r11);
        }

        public static /* synthetic */ void access$900(SmHandler r8, State r10) {
            r8.removeState(r10);
        }

        private final StateInfo addState(State r8, State r10) {
            if (this.mDbg == false) goto L9;
            StateMachine r11 = this.mSm;
            StringBuilder r12 = new StringBuilder("addStateInternal: E state=");
            r12.append(r8.getName());
            r12.append(",parent=");
            if (r10 != null) goto L7;
            String r13 = "";
        L8:
            r12.append(r13);
            r11.log(r12.toString());
            goto L9
        L7:
            r13 = r10.getName();
        L9:
            StateInfo r14 = null;
            if (r10 == null) goto L15;
            StateInfo r15 = this.mStateInfo.get(r10);
            if (r15 != null) goto L14;
            r14 = addState(r10, null);
            goto L15
        L14:
            r14 = r15;
        L15:
            StateInfo r16 = this.mStateInfo.get(r8);
            if (r16 != null) goto L18;
            r16 = new StateInfo(r8, r14);
            this.mStateInfo.put(r8, r16);
        L18:
            StateInfo r17 = r16.parentStateInfo;
            if (r17 == null) goto L25;
            if (r17 == r14) goto L25;
            throw new RuntimeException("state already added");
        L25:
            if (this.mDbg == false) goto L27;
            this.mSm.log("addStateInternal: X stateInfo: " + r16);
        L27:
            return r16;
        }

        private final void cleanupAfterQuitting() {
            if (StateMachine.access$400(this.mSm) == null) goto L5;
            getLooper().quit();
            StateMachine.access$402(this.mSm, null);
        L5:
            StateMachine.access$502(this.mSm, null);
            this.mSm = null;
            this.mMsg = null;
            this.mLogRecords.cleanup();
            this.mStateStack = null;
            this.mTempStateStack = null;
            this.mStateInfo.clear();
            this.mInitialState = null;
            this.mDestState = null;
            this.mDeferredMessages.clear();
            this.mHasQuit = true;
        }

        private final void completeConstruction() {
            if (this.mDbg == false) goto L5;
            this.mSm.log("completeConstruction: E");
        L5:
            Iterator<StateInfo> r8 = this.mStateInfo.values().iterator();
            int r10 = 0;
        L7:
            if (r8.hasNext() == false) goto L14;
            StateInfo r11 = r8.next();
            int r12 = 0;
        L9:
            if (r11 == null) goto L11;
            r11 = r11.parentStateInfo;
            r12 = r12 + 1;
            goto L9
        L11:
            if (r10 >= r12) goto L7;
            r10 = r12;
            goto L7
        L14:
            if (this.mDbg == false) goto L16;
            this.mSm.log("completeConstruction: maxDepth=" + r10);
        L16:
            this.mStateStack = new StateInfo[r10];
            this.mTempStateStack = new StateInfo[r10];
            setupInitialStateStack();
            sendMessageAtFrontOfQueue(obtainMessage(-2, mSmHandlerObj));
            if (this.mDbg == false) goto L26;
            this.mSm.log("completeConstruction: X");
            return;
        }

        private final void deferMessage(Message r8) {
            if (this.mDbg == false) goto L5;
            this.mSm.log("deferMessage: msg=" + r8.what);
        L5:
            Message r10 = obtainMessage();
            r10.copyFrom(r8);
            this.mDeferredMessages.add(r10);
        }

        private final Message getCurrentMessage() {
            return this.mMsg;
        }

        private final IState getCurrentState() {
            return this.mStateStack[this.mStateStackTopIndex].state;
        }

        private final void invokeEnterMethods(int r8) {
            int r10 = r8;
        L3:
            int r11 = this.mStateStackTopIndex;
            if (r10 > r11) goto L11;
            if (r8 != r11) goto L8;
            this.mTransitionInProgress = false;
        L8:
            if (this.mDbg == false) goto L10;
            this.mSm.log("invokeEnterMethods: " + this.mStateStack[r10].state.getName());
        L10:
            this.mStateStack[r10].state.enter();
            this.mStateStack[r10].active = true;
            r10 = r10 + 1;
            goto L3
        L11:
            this.mTransitionInProgress = false;
        }

        private final void invokeExitMethods(StateInfo r8) {
        L2:
            int r10 = this.mStateStackTopIndex;
            if (r10 < 0) goto L10;
            StateInfo r11 = this.mStateStack[r10];
            if (r11 == r8) goto L15;
            State r12 = r11.state;
            if (this.mDbg == false) goto L9;
            this.mSm.log("invokeExitMethods: " + r12.getName());
        L9:
            r12.exit();
            StateInfo[] r13 = this.mStateStack;
            int r14 = this.mStateStackTopIndex;
            r13[r14].active = false;
            this.mStateStackTopIndex = r14 - 1;
            goto L2
        L15:
            return;
        }

        private final boolean isDbg() {
            return this.mDbg;
        }

        private final boolean isQuit(Message r8) {
            if (r8.what == (-1)) goto L5;
        L7:
            return false;
        L5:
            if (r8.obj != mSmHandlerObj) goto L7;
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
            if (r8 < 0) goto L8;
            Message r10 = this.mDeferredMessages.get(r8);
            if (this.mDbg == false) goto L7;
            this.mSm.log("moveDeferredMessageAtFrontOfQueue; what=" + r10.what);
        L7:
            sendMessageAtFrontOfQueue(r10);
            r8 = r8 - 1;
            goto L3
        L8:
            this.mDeferredMessages.clear();
        }

        private final int moveTempStateStackToStateStack() {
            int r8 = this.mStateStackTopIndex + 1;
            int r10 = this.mTempStateStackCount - 1;
            int r11 = r8;
        L3:
            if (r10 < 0) goto L8;
            if (this.mDbg == false) goto L7;
            this.mSm.log("moveTempStackToStateStack: i=" + r10 + ",j=" + r11);
        L7:
            this.mStateStack[r11] = this.mTempStateStack[r10];
            r11 = r11 + 1;
            r10 = r10 - 1;
            goto L3
        L8:
            this.mStateStackTopIndex = r11 - 1;
            if (this.mDbg == false) goto L11;
            StateMachine r12 = this.mSm;
            StringBuilder r13 = new StringBuilder("moveTempStackToStateStack: X mStateStackTop=");
            b.q(r13, this.mStateStackTopIndex, ",startingIndex=", r8, ",Top=");
            r13.append(this.mStateStack[this.mStateStackTopIndex].state.getName());
            r12.log(r13.toString());
        L11:
            return r8;
        }

        private void performTransitions(State r10, Message r11) {
            State r8 = this.mStateStack[this.mStateStackTopIndex].state;
            if (this.mSm.recordLogRec(r11) == true) goto L5;
        L7:
            boolean r12 = false;
        L9:
            if (this.mLogRecords.logOnlyTransitions() == true) goto L11;
            if (r12 == false) goto L15;
        L14:
            LogRecords r13 = this.mLogRecords;
            StateMachine r14 = this.mSm;
            r13.add(r14, r11, r14.getLogRecString(r11), r10, r8, this.mDestState);
        L15:
            State r15 = this.mDestState;
            if (r15 != null) goto L18;
        L24:
            if (r15 != null) goto L26;
            return;
        L26:
            if (r15 != this.mQuittingState) goto L29;
            this.mSm.onQuitting();
            cleanupAfterQuitting();
            return;
        L29:
            if (r15 != this.mHaltingState) goto L35;
            this.mSm.onHalting();
            return;
        L35:
            return;
        L18:
            if (this.mDbg == false) goto L20;
            this.mSm.log("handleMessage: new destination call exit/enter");
        L20:
            StateInfo r16 = setupTempStateStackWithStatesToEnter(r15);
            this.mTransitionInProgress = true;
            invokeExitMethods(r16);
            invokeEnterMethods(moveTempStateStackToStateStack());
            moveDeferredMessageAtFrontOfQueue();
            State r17 = this.mDestState;
            if (r15 == r17) goto L23;
            r15 = r17;
            goto L18
        L23:
            this.mDestState = null;
            goto L24
        L11:
            if (this.mDestState == null) goto L15;
        L5:
            if (r11.obj == mSmHandlerObj) goto L7;
            r12 = true;
            goto L9
        }

        private final State processMsg(Message r8) {
            StateInfo r10 = this.mStateStack[this.mStateStackTopIndex];
            if (this.mDbg == false) goto L6;
            this.mSm.log("processMsg: " + r10.state.getName());
        L6:
            if (isQuit(r8) == false) goto L9;
            transitionTo(this.mQuittingState);
        L16:
            if (r10 != null) goto L26;
            return null;
        L26:
            return r10.state;
        L9:
            if (r10.state.processMessage(r8) == true) goto L16;
            r10 = r10.parentStateInfo;
            if (r10 == null) goto L12;
            if (this.mDbg == false) goto L9;
            this.mSm.log("processMsg: " + r10.state.getName());
            goto L9
        L12:
            this.mSm.unhandledMessage(r8);
            goto L16
        }

        private final void quit() {
            if (this.mDbg == false) goto L5;
            this.mSm.log("quit:");
        L5:
            sendMessage(obtainMessage(-1, mSmHandlerObj));
        }

        private final void quitNow() {
            if (this.mDbg == false) goto L5;
            this.mSm.log("quitNow:");
        L5:
            sendMessageAtFrontOfQueue(obtainMessage(-1, mSmHandlerObj));
        }

        private void removeState(State r8) {
            final StateInfo r10 = this.mStateInfo.get(r8);
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.active == false) goto L8;
            return;
        L8:
            if (this.mStateInfo.values().stream().anyMatch(new a(r10)) == false) goto L10;
            return;
        L10:
            this.mStateInfo.remove(r8);
        }

        private final void setDbg(boolean r8) {
            this.mDbg = r8;
        }

        private final void setInitialState(State r8) {
            if (this.mDbg == false) goto L5;
            this.mSm.log("setInitialState: initialState=" + r8.getName());
        L5:
            this.mInitialState = r8;
        }

        private final void setupInitialStateStack() {
            if (this.mDbg == false) goto L5;
            this.mSm.log("setupInitialStateStack: E mInitialState=" + this.mInitialState.getName());
        L5:
            StateInfo r8 = this.mStateInfo.get(this.mInitialState);
            this.mTempStateStackCount = 0;
        L6:
            if (r8 == null) goto L8;
            StateInfo[] r10 = this.mTempStateStack;
            int r11 = this.mTempStateStackCount;
            r10[r11] = r8;
            r8 = r8.parentStateInfo;
            this.mTempStateStackCount = r11 + 1;
            goto L6
        L8:
            this.mStateStackTopIndex = -1;
            moveTempStateStackToStateStack();
        }

        private final StateInfo setupTempStateStackWithStatesToEnter(State r8) {
            this.mTempStateStackCount = 0;
            StateInfo r10 = this.mStateInfo.get(r8);
        L3:
            StateInfo[] r11 = this.mTempStateStack;
            int r12 = this.mTempStateStackCount;
            this.mTempStateStackCount = r12 + 1;
            r11[r12] = r10;
            r10 = r10.parentStateInfo;
            if (r10 == null) goto L8;
            if (r10.active == false) goto L3;
        L8:
            if (this.mDbg == false) goto L10;
            this.mSm.log("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.mTempStateStackCount + ",curStateInfo: " + r10);
        L10:
            return r10;
        }

        private final void transitionTo(IState r8) {
            if (this.mTransitionInProgress == false) goto L5;
            Log.wtf(StateMachine.access$600(this.mSm), "transitionTo called while transition already in progress to " + this.mDestState + ", new target state=" + r8);
        L5:
            this.mDestState = (State) r8;
            if (this.mDbg == false) goto L9;
            this.mSm.log("transitionTo: destState=" + this.mDestState.getName());
            return;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
            if (this.mHasQuit == true) goto L37;
            StateMachine r10 = this.mSm;
            if (r10 == null) goto L11;
            int r11 = r8.what;
            if (r11 == (-2)) goto L11;
            if (r11 == (-1)) goto L11;
            r10.onPreHandleMessage(r8);
        L11:
            if (this.mDbg == false) goto L13;
            this.mSm.log("handleMessage: E msg.what=" + r8.what);
        L13:
            Message r12 = obtainMessage();
            this.mMsg = r12;
            r12.copyFrom(r8);
            if (this.mIsConstructionCompleted == true) goto L24;
            int r13 = r8.what;
            if (r13 == (-1)) goto L24;
            if (r13 != (-2)) goto L23;
            if (r8.obj != mSmHandlerObj) goto L23;
            this.mIsConstructionCompleted = true;
            invokeEnterMethods(0);
            State r14 = null;
        L25:
            performTransitions(r14, r8);
            if (this.mDbg == false) goto L30;
            StateMachine r15 = this.mSm;
            if (r15 == null) goto L30;
            r15.log("handleMessage: X");
        L30:
            StateMachine r16 = this.mSm;
            if (r16 == null) goto L38;
            int r17 = r8.what;
            if (r17 == (-2)) goto L39;
            if (r17 == (-1)) goto L40;
            r16.onPostHandleMessage(r8);
            return;
        L40:
            return;
        L39:
            return;
        L38:
            return;
        L23:
            throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + r8);
        L24:
            r14 = processMsg(r8);
            goto L25
        }

        public /* synthetic */ SmHandler(Looper r8, StateMachine r10, AnonymousClass1 r11) {
            this(r8, r10);
        }
    }

    public StateMachine(String r8) {
        HandlerThread r10 = new HandlerThread(r8);
        this.mSmThread = r10;
        r10.start();
        initStateMachine(r8, this.mSmThread.getLooper());
    }

    public static /* synthetic */ HandlerThread access$400(StateMachine r8) {
        return r8.mSmThread;
    }

    public static /* synthetic */ HandlerThread access$402(StateMachine r8, HandlerThread r10) {
        r8.mSmThread = r10;
        return r10;
    }

    public static /* synthetic */ SmHandler access$502(StateMachine r8, SmHandler r10) {
        r8.mSmHandler = r10;
        return r10;
    }

    public static /* synthetic */ String access$600(StateMachine r8) {
        return r8.mName;
    }

    private void initStateMachine(String r8, Looper r10) {
        this.mName = r8;
        this.mSmHandler = new SmHandler(r10, this, null);
    }

    public void addLogRec(String r10) {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L5;
        return;
    L5:
        SmHandler.access$1700(r8).add(this, SmHandler.access$1100(r8), r10, SmHandler.access$1200(r8), SmHandler.access$2000(r8)[SmHandler.access$2100(r8)].state, SmHandler.access$2200(r8));
    }

    public final void addState(State r8) {
        SmHandler.access$800(this.mSmHandler, r8, null);
    }

    public final Collection<LogRec> copyLogRecs() {
        Vector r8 = new Vector();
        SmHandler r10 = this.mSmHandler;
        if (r10 == null) goto L8;
        Iterator r11 = LogRecords.access$1900(SmHandler.access$1700(r10)).iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r8.add((LogRec) r11.next());
    L8:
        return r8;
    }

    public final void deferMessage(Message r8) {
        SmHandler.access$1500(this.mSmHandler, r8);
    }

    public void dump(FileDescriptor r8, PrintWriter r10, String[] r11) {
        r10.println(getName() + BdimCategoryConstants.SEPARATOR_COLON);
        StringBuilder r12 = new StringBuilder(" total records=");
        r12.append(getLogRecCount());
        r10.println(r12.toString());
        int r13 = 0;
    L4:
        if (r13 >= getLogRecSize()) goto L6;
        StringBuilder r14 = b.f(" rec[", r13, "]: ");
        r14.append(getLogRec(r13));
        r10.println(r14.toString());
        r10.flush();
        r13 = r13 + 1;
        goto L4
    L6:
        IState r15 = getCurrentState();
        StringBuilder r16 = new StringBuilder("curState=");
        if (r15 != null) goto L9;
        String r17 = "<QUIT>";
    L10:
        r16.append(r17);
        r10.println(r16.toString());
        return;
    L9:
        r17 = r15.getName();
        goto L10
    }

    public final Message getCurrentMessage() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L7;
        return null;
    L7:
        return SmHandler.access$1100(r8);
    }

    public final IState getCurrentState() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L7;
        return null;
    L7:
        return SmHandler.access$1200(r8);
    }

    public final Handler getHandler() {
        return this.mSmHandler;
    }

    public final LogRec getLogRec(int r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L7;
        return null;
    L7:
        return SmHandler.access$1700(r10).get(r8);
    }

    public final int getLogRecCount() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return SmHandler.access$1700(r8).count();
    }

    @VisibleForTesting
    public final int getLogRecMaxSize() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return LogRecords.access$1800(SmHandler.access$1700(r8));
    }

    public final int getLogRecSize() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return SmHandler.access$1700(r8).size();
    }

    public String getLogRecString(Message r8) {
        return "";
    }

    public final String getName() {
        return this.mName;
    }

    public String getWhatToString(int r8) {
        return null;
    }

    public void haltedProcessMessage(Message r8) {
    }

    public final boolean hasDeferredMessages(int r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L5;
        return false;
    L5:
        Iterator r11 = SmHandler.access$2300(r10).iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        if (((Message) r11.next()).what != r8) goto L7;
        return true;
    L12:
        return false;
    }

    public final boolean hasMessages(int r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.hasMessages(r8);
    }

    public boolean isDbg() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L7;
        return false;
    L7:
        return SmHandler.access$2700(r8);
    }

    public final boolean isQuit(Message r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L10;
        if (r8.what != (-1)) goto L7;
        return true;
    L7:
        return false;
    L10:
        return SmHandler.access$2400(r10, r8);
    }

    public void log(String r8) {
        Log.d(this.mName, r8);
    }

    public void logAndAddLogRec(String r8) {
        addLogRec(r8);
        log(r8);
    }

    public void logd(String r8) {
        Log.d(this.mName, r8);
    }

    public void loge(String r8) {
        Log.e(this.mName, r8);
    }

    public void logi(String r8) {
        Log.i(this.mName, r8);
    }

    public void logv(String r8) {
        Log.v(this.mName, r8);
    }

    public void logw(String r8) {
        Log.w(this.mName, r8);
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
        SmHandler.access$2500(r8);
    }

    public final void quitNow() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L5;
        return;
    L5:
        SmHandler.access$2600(r8);
    }

    public boolean recordLogRec(Message r8) {
        return true;
    }

    public final void removeDeferredMessages(int r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator r11 = SmHandler.access$2300(r10).iterator();
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

    public final void removeState(State r8) {
        SmHandler.access$900(this.mSmHandler, r8);
    }

    public void sendMessage(int r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.sendMessage(obtainMessage(r8));
    }

    public final void sendMessageAtFrontOfQueue(int r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.sendMessageAtFrontOfQueue(obtainMessage(r8));
    }

    public void sendMessageDelayed(int r8, int r10, int r11, long r12) {
        SmHandler r13 = this.mSmHandler;
        if (r13 != null) goto L5;
        return;
    L5:
        r13.sendMessageDelayed(obtainMessage(r8, r10, r11), r12);
    }

    public void setDbg(boolean r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L5;
        return;
    L5:
        SmHandler.access$2800(r10, r8);
    }

    public final void setInitialState(State r8) {
        SmHandler.access$1000(this.mSmHandler, r8);
    }

    public final void setLogOnlyTransitions(boolean r8) {
        SmHandler.access$1700(this.mSmHandler).setLogOnlyTransitions(r8);
    }

    public final void setLogRecSize(int r8) {
        SmHandler.access$1700(this.mSmHandler).setSize(r8);
    }

    public void start() {
        SmHandler r8 = this.mSmHandler;
        if (r8 != null) goto L5;
        return;
    L5:
        SmHandler.access$2900(r8);
    }

    public String toString() {
        String r8 = SmHandler.access$1200(this.mSmHandler).getName().toString();     // Catch: Throwable -> L4
    L6:
        return "name=" + this.mName + " state=" + r8;
    L4:
        r8 = "null";
        goto L6
    }

    public final void transitionTo(IState r8) {
        SmHandler.access$1300(this.mSmHandler, r8);
    }

    public final void transitionToHaltingState() {
        SmHandler r8 = this.mSmHandler;
        SmHandler.access$1300(r8, SmHandler.access$1400(r8));
    }

    public void unhandledMessage(Message r8) {
        if (SmHandler.access$1600(this.mSmHandler) == false) goto L6;
        loge(" - unhandledMessage: msg.what=" + r8.what);
        return;
    }

    public StateMachine(String r8, Handler r10) {
        initStateMachine(r8, r10.getLooper());
    }

    public final void addState(State r8, State r10) {
        SmHandler.access$800(this.mSmHandler, r8, r10);
    }

    public void loge(String r8, Throwable r10) {
        Log.e(this.mName, r8, r10);
    }

    public final Message obtainMessage(int r8) {
        return Message.obtain(this.mSmHandler, r8);
    }

    public void sendMessage(int r8, int r10) {
        SmHandler r11 = this.mSmHandler;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.sendMessage(obtainMessage(r8, r10));
    }

    public final void sendMessageAtFrontOfQueue(int r8, int r10) {
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

    public StateMachine(String r8, Looper r10) {
        initStateMachine(r8, r10);
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

    public final void sendMessageAtFrontOfQueue(int r8, int r10, int r11) {
        SmHandler r12 = this.mSmHandler;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.sendMessageAtFrontOfQueue(obtainMessage(r8, r10, r11));
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

    public final void sendMessageAtFrontOfQueue(int r8, int r10, int r11, Object r12) {
        SmHandler r13 = this.mSmHandler;
        if (r13 != null) goto L5;
        return;
    L5:
        r13.sendMessageAtFrontOfQueue(obtainMessage(r8, r10, r11, r12));
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

    public final void sendMessageAtFrontOfQueue(int r8, Object r10) {
        SmHandler r11 = this.mSmHandler;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.sendMessageAtFrontOfQueue(obtainMessage(r8, r10));
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

    public final void sendMessageAtFrontOfQueue(Message r8) {
        SmHandler r10 = this.mSmHandler;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.sendMessageAtFrontOfQueue(r8);
    }

    public void sendMessageDelayed(Message r8, long r10) {
        SmHandler r11 = this.mSmHandler;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.sendMessageDelayed(r8, r10);
    }
}
