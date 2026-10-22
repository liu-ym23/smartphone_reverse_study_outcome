package androidx.work;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class Logger {
    private static final int MAX_PREFIXED_TAG_LENGTH = 20;
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG_PREFIX = "WM-";
    private static final Object sLock = null;
    private static volatile Logger sLogger;

    public static class LogcatLogger extends Logger {
        private final int mLoggingLevel;

        public LogcatLogger(int r10) {
            super(r10);
            this.mLoggingLevel = r10;
        }

        @Override // androidx.work.Logger
        public void debug(@NonNull String r10, @NonNull String r11) {
            if (this.mLoggingLevel > 3) goto L6;
            Log.d(r10, r11);
            return;
        }

        @Override // androidx.work.Logger
        public void debug(@NonNull String r10, @NonNull String r11, @NonNull Throwable r12) {
            if (this.mLoggingLevel > 3) goto L6;
            Log.d(r10, r11, r12);
            return;
        }

        @Override // androidx.work.Logger
        public void error(@NonNull String r10, @NonNull String r11) {
            if (this.mLoggingLevel > 6) goto L6;
            Log.e(r10, r11);
            return;
        }

        @Override // androidx.work.Logger
        public void error(@NonNull String r10, @NonNull String r11, @NonNull Throwable r12) {
            if (this.mLoggingLevel > 6) goto L6;
            Log.e(r10, r11, r12);
            return;
        }

        @Override // androidx.work.Logger
        public void info(@NonNull String r10, @NonNull String r11) {
            if (this.mLoggingLevel > 4) goto L6;
            Log.i(r10, r11);
            return;
        }

        @Override // androidx.work.Logger
        public void info(@NonNull String r10, @NonNull String r11, @NonNull Throwable r12) {
            if (this.mLoggingLevel > 4) goto L6;
            Log.i(r10, r11, r12);
            return;
        }

        @Override // androidx.work.Logger
        public void verbose(@NonNull String r10, @NonNull String r11) {
            if (this.mLoggingLevel > 2) goto L6;
            Log.v(r10, r11);
            return;
        }

        @Override // androidx.work.Logger
        public void verbose(@NonNull String r10, @NonNull String r11, @NonNull Throwable r12) {
            if (this.mLoggingLevel > 2) goto L6;
            Log.v(r10, r11, r12);
            return;
        }

        @Override // androidx.work.Logger
        public void warning(@NonNull String r10, @NonNull String r11) {
            if (this.mLoggingLevel > 5) goto L6;
            Log.w(r10, r11);
            return;
        }

        @Override // androidx.work.Logger
        public void warning(@NonNull String r10, @NonNull String r11, @NonNull Throwable r12) {
            if (this.mLoggingLevel > 5) goto L6;
            Log.w(r10, r11, r12);
            return;
        }
    }

    static {
        sLock = new Object();
    }

    public Logger(int r10) {
    }

    @NonNull
    public static Logger get() {
        Object r10 = sLock;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sLogger != null) goto L7;
        sLogger = new LogcatLogger(3);     // Catch: Throwable -> L10
    L7:
        Logger r11 = sLogger;     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    }

    public static void setLogger(@NonNull Logger r10) {
        Object r11 = sLock;
        monitor-enter(r11);
        sLogger = r10;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @NonNull
    public static String tagWithPrefix(@NonNull String r10) {
        int r11 = r10.length();
        StringBuilder r12 = new StringBuilder(23);
        r12.append(TAG_PREFIX);
        int r13 = MAX_PREFIXED_TAG_LENGTH;
        if (r11 < r13) goto L5;
        r10 = r10.substring(0, r13);
    L5:
        r12.append(r10);
        return r12.toString();
    }

    public abstract void debug(@NonNull String r10, @NonNull String r11);

    public abstract void debug(@NonNull String r10, @NonNull String r11, @NonNull Throwable r12);

    public abstract void error(@NonNull String r10, @NonNull String r11);

    public abstract void error(@NonNull String r10, @NonNull String r11, @NonNull Throwable r12);

    public abstract void info(@NonNull String r10, @NonNull String r11);

    public abstract void info(@NonNull String r10, @NonNull String r11, @NonNull Throwable r12);

    public abstract void verbose(@NonNull String r10, @NonNull String r11);

    public abstract void verbose(@NonNull String r10, @NonNull String r11, @NonNull Throwable r12);

    public abstract void warning(@NonNull String r10, @NonNull String r11);

    public abstract void warning(@NonNull String r10, @NonNull String r11, @NonNull Throwable r12);
}
