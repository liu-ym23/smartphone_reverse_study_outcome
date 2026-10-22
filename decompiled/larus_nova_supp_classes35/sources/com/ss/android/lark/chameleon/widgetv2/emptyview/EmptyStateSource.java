package com.ss.android.lark.chameleon.widgetv2.emptyview;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.net.NetworkType;
import java.net.SocketTimeoutException;
import twb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class EmptyStateSource extends LiveData<EmptyState> {
    public static final int STATE_LOADING = 0;
    public static final int STATE_LOADING_FORCE = 8;
    public static final int STATE_LOAD_ERROR = 3;
    public static final int STATE_NO_CONTENT = 1;
    public static final int STATE_NO_EMPTY = 2;
    public static final int STATE_NO_FOUND = 5;
    public static final int STATE_NO_NETWORK = 4;
    public static final int STATE_NO_PERMISSION = 99;
    public static final int STATE_NO_SUPPORT = 10;
    public static final int STATE_TIMEOUT = 7;
    public static final int STATE_WIKI_DELETED = 9;
    private static final String TAG = "EmptyStateSource";
    private StateMachine mStateMachine;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyStateSource$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DefaultStateMachine implements StateMachine {
        private Context mContext;
        private EmptyState mCurrentState;

        @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyStateSource.StateMachine
        public EmptyState current() {
            return this.mCurrentState;
        }

        private DefaultStateMachine(Context r3) {
            this.mCurrentState = new EmptyState(0);
            this.mContext = r3;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyStateSource.StateMachine
        public EmptyState next(Throwable r3) {
            j.b(EmptyStateSource.TAG, r3.toString());
            if (this.mCurrentState.getState() != 2) goto L5;
        L11:
            this.mCurrentState.setError(r3);
            return this.mCurrentState;
        L5:
            if (a.a(this.mContext) != NetworkType.NETWORK_NO) goto L8;
            this.mCurrentState = new EmptyState(4);
            goto L11
        L8:
            if (EmptyStateSource.access$100(r3) == false) goto L10;
            this.mCurrentState = new EmptyState(7);
            goto L11
        L10:
            this.mCurrentState = new EmptyState(3);
            goto L11
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyStateSource.StateMachine
        public EmptyState next(int r3) {
            j.a(EmptyStateSource.TAG, "next: load data : " + r3);
            return next(r3, false);
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyStateSource.StateMachine
        public EmptyState next(boolean r3) {
            j.a(EmptyStateSource.TAG, "next: loading ");
            return next(r3, false);
        }

        public /* synthetic */ DefaultStateMachine(Context r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyStateSource.StateMachine
        public EmptyState next(int r3, boolean r4) {
            j.a(EmptyStateSource.TAG, "next: load data : " + r3 + " isForce=" + r4);
            if (r4 == false) goto L5;
        L8:
            if (r3 > 0) goto L10;
            this.mCurrentState = new EmptyState(1);
        L12:
            return this.mCurrentState;
        L10:
            this.mCurrentState = new EmptyState(2);
            goto L12
        L5:
            if (this.mCurrentState.getState() != 8) goto L8;
            return this.mCurrentState;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyStateSource.StateMachine
        public EmptyState next(boolean r3, boolean r4) {
            j.a(EmptyStateSource.TAG, "next: loading ，isForce=" + r4);
            if (r3 == false) goto L13;
            if (this.mCurrentState.getState() == 2) goto L13;
            if (r4 == false) goto L9;
        L11:
            this.mCurrentState = new EmptyState(8);
            goto L13
        L9:
            if (this.mCurrentState.getState() == 8) goto L11;
            this.mCurrentState = new EmptyState(0);
        L13:
            return this.mCurrentState;
        }
    }

    public static class EmptyState {
        private Throwable mError;
        private int mState;

        public Throwable getError() {
            return this.mError;
        }

        public int getState() {
            return this.mState;
        }

        public EmptyState(int r1) {
            this.mState = r1;
        }

        public void setError(Throwable r1) {
            this.mError = r1;
        }

        public void setState(int r1) {
            this.mState = r1;
        }
    }

    public interface StateMachine {
        EmptyState current();

        EmptyState next(int r1);

        EmptyState next(int r1, boolean r2);

        EmptyState next(Throwable r1);

        EmptyState next(boolean r1);

        EmptyState next(boolean r1, boolean r2);
    }

    public void noEmpty() {
        data(1);
    }

    public void empty() {
        postValue(this.mStateMachine.next(0));
    }

    public void loading() {
        postValue(this.mStateMachine.next(true));
    }

    public void loadingForceNoInterruption() {
        postValue(this.mStateMachine.next(true, true));
    }

    public void onActive() {
        setValue(this.mStateMachine.current());
        super.onActive();
    }

    public void onInactive() {
        super.onInactive();
    }

    public EmptyStateSource(Context r3) {
        this.mStateMachine = new DefaultStateMachine(r3, null);
    }

    public static /* synthetic */ boolean access$100(Throwable r0) {
        return isTimeout(r0);
    }

    private static boolean isTimeout(Throwable r0) {
        return r0 instanceof SocketTimeoutException;
    }

    public void data(int r2) {
        postValue(this.mStateMachine.next(r2));
    }

    public void fail(Throwable r2) {
        postValue(this.mStateMachine.next(r2));
    }

    public void setStateMachine(StateMachine r1) {
        this.mStateMachine = r1;
    }

    public void dataForceNoInterruption(int r2, boolean r3) {
        postValue(this.mStateMachine.next(r2, r3));
    }
}
