package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class JavaUrlRequestUtils {

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface CheckedRunnable {
        void run();
    }

    public static final class DirectPreventingExecutor implements Executor {
        private final Executor mDelegate;

        private static final class InlineCheckingRunnable implements Runnable {
            private Thread mCallingThread;
            private final Runnable mCommand;
            private InlineExecutionProhibitedException mExecutedInline;

            private InlineCheckingRunnable(Runnable r10, Thread r11) {
                this.mCommand = r10;
                this.mCallingThread = r11;
            }

            /* synthetic */ InlineCheckingRunnable(Runnable r10, Thread r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            static /* synthetic */ InlineExecutionProhibitedException access$100(InlineCheckingRunnable r10) {
                return r10.mExecutedInline;
            }

            static /* synthetic */ Thread access$202(InlineCheckingRunnable r10, Thread r11) {
                r10.mCallingThread = r11;
                return r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Thread.currentThread() != this.mCallingThread) goto L6;
                this.mExecutedInline = new InlineExecutionProhibitedException();
                return;
            L6:
                this.mCommand.run();
            }
        }

        public DirectPreventingExecutor(Executor r10) {
            this.mDelegate = r10;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            InlineCheckingRunnable r11 = new InlineCheckingRunnable(r10, Thread.currentThread(), null);
            this.mDelegate.execute(r11);
            if (InlineCheckingRunnable.access$100(r11) != null) goto L7;
            InlineCheckingRunnable.access$202(r11, null);
            return;
        L7:
            throw InlineCheckingRunnable.access$100(r11);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int AWAITING_FOLLOW_REDIRECT = 3;
        public static final int AWAITING_READ = 4;
        public static final int CANCELLED = 8;
        public static final int COMPLETE = 7;
        public static final int ERROR = 6;
        public static final int NOT_STARTED = 0;
        public static final int READING = 5;
        public static final int REDIRECT_RECEIVED = 2;
        public static final int STARTED = 1;
    }

    public JavaUrlRequestUtils() {
    }
}
