package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class AutoCloser {
    public static final Companion Companion = null;
    public static final String autoCloseBug = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";
    private long autoCloseTimeoutInMs;
    private final Runnable autoCloser;

    @GuardedBy("lock")
    private SupportSQLiteDatabase delegateDatabase;
    public SupportSQLiteOpenHelper delegateOpenHelper;
    private final Runnable executeAutoCloser;
    private final Executor executor;
    private final Handler handler;

    @GuardedBy("lock")
    private long lastDecrementRefCountTimeStamp;
    private final Object lock;
    private boolean manuallyClosed;
    private Runnable onAutoCloseCallback;

    @GuardedBy("lock")
    private int refCount;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AutoCloser(long r10, TimeUnit r11, Executor r12) {
        Intrinsics.checkNotNullParameter(r11, "autoCloseTimeUnit");
        Intrinsics.checkNotNullParameter(r12, "autoCloseExecutor");
        this.handler = new Handler(Looper.getMainLooper());
        this.lock = new Object();
        this.autoCloseTimeoutInMs = r11.toMillis(r10);
        this.executor = r12;
        this.lastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
        this.executeAutoCloser = new a(this);
        this.autoCloser = new b(this);
    }

    public static /* synthetic */ void a(AutoCloser r10) {
        executeAutoCloser$lambda$0(r10);
    }

    private static final void autoCloser$lambda$3(AutoCloser r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Object r11 = r10.lock;
        monitor-enter(r11);
    L28:
        th = move-exception;
        throw th;
    L6:
        if ((SystemClock.uptimeMillis() - r10.lastDecrementRefCountTimeStamp) >= r10.autoCloseTimeoutInMs) goto L10;
        monitor-exit(r11);
        return;
    L10:
        if (r10.refCount == 0) goto L13;
        monitor-exit(r11);
        return;
    L13:
        Runnable r12 = r10.onAutoCloseCallback;     // Catch: Throwable -> L28
        if (r12 == null) goto L16;
        r12.run();     // Catch: Throwable -> L28
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L28
    L17:
        if (r13 == null) goto L27;
        SupportSQLiteDatabase r14 = r10.delegateDatabase;     // Catch: Throwable -> L28
        if (r14 != null) goto L21;
    L23:
        r10.delegateDatabase = null;     // Catch: Throwable -> L28
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r11);
        return;
    L21:
        if (r14.isOpen() == false) goto L23;
        r14.close();     // Catch: Throwable -> L28
        goto L23
    L27:
        throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568".toString());     // Catch: Throwable -> L28
    L16:
        r13 = null;
        goto L17
    }

    public static /* synthetic */ void b(AutoCloser r10) {
        autoCloser$lambda$3(r10);
    }

    private static final void executeAutoCloser$lambda$0(AutoCloser r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.executor.execute(r10.autoCloser);
    }

    public final void closeDatabaseIfOpen() {
        Object r10 = this.lock;
        monitor-enter(r10);
        this.manuallyClosed = true;     // Catch: Throwable -> L11
        SupportSQLiteDatabase r11 = this.delegateDatabase;     // Catch: Throwable -> L11
        if (r11 == null) goto L8;
        r11.close();     // Catch: Throwable -> L11
    L8:
        this.delegateDatabase = null;     // Catch: Throwable -> L11
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r10);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void decrementCountAndScheduleClose() {
        Object r10 = this.lock;
        monitor-enter(r10);
        int r11 = this.refCount;     // Catch: Throwable -> L21
        if (r11 <= 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L20;
        int r13 = r11 - 1;     // Catch: Throwable -> L21
        this.refCount = r13;     // Catch: Throwable -> L21
        if (r13 == 0) goto L12;
    L16:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r10);
        return;
    L12:
        if (this.delegateDatabase != null) goto L15;
        monitor-exit(r10);
        return;
    L15:
        this.handler.postDelayed(this.executeAutoCloser, this.autoCloseTimeoutInMs);     // Catch: Throwable -> L21
        goto L16
    L20:
        throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement".toString());     // Catch: Throwable -> L21
    L7:
        r12 = false;
    L21:
        th = move-exception;
        throw th;
    }

    public final <V> V executeRefCountingFunction(Function1<? super SupportSQLiteDatabase, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        V r11 = r10.invoke(incrementCountAndEnsureDbIsOpen());     // Catch: Throwable -> L6
        decrementCountAndScheduleClose();
        return r11;
    L6:
        th = move-exception;
        decrementCountAndScheduleClose();
        throw th;
    }

    public final SupportSQLiteDatabase getDelegateDatabase$room_runtime_release() {
        return this.delegateDatabase;
    }

    public final SupportSQLiteOpenHelper getDelegateOpenHelper() {
        SupportSQLiteOpenHelper r10 = this.delegateOpenHelper;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("delegateOpenHelper");
        return null;
    }

    public final long getLastDecrementRefCountTimeStamp$room_runtime_release() {
        return this.lastDecrementRefCountTimeStamp;
    }

    public final Runnable getOnAutoCloseCallback$room_runtime_release() {
        return this.onAutoCloseCallback;
    }

    public final int getRefCount$room_runtime_release() {
        return this.refCount;
    }

    @VisibleForTesting
    public final int getRefCountForTest$room_runtime_release() {
        Object r10 = this.lock;
        monitor-enter(r10);
        int r11 = this.refCount;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        Object r10 = this.lock;
        monitor-enter(r10);
        this.handler.removeCallbacks(this.executeAutoCloser);     // Catch: Throwable -> L17
        this.refCount++;     // Catch: Throwable -> L17
        if ((!this.manuallyClosed) == false) goto L16;
        SupportSQLiteDatabase r11 = this.delegateDatabase;     // Catch: Throwable -> L17
        if (r11 != null) goto L9;
    L12:
        SupportSQLiteDatabase r12 = getDelegateOpenHelper().getWritableDatabase();     // Catch: Throwable -> L17
        this.delegateDatabase = r12;     // Catch: Throwable -> L17
        monitor-exit(r10);
        return r12;
    L9:
        if (r11.isOpen() == false) goto L12;
        monitor-exit(r10);
        return r11;
    L16:
        throw new IllegalStateException("Attempting to open already closed database.".toString());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final void init(SupportSQLiteOpenHelper r10) {
        Intrinsics.checkNotNullParameter(r10, "delegateOpenHelper");
        setDelegateOpenHelper(r10);
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final void setAutoCloseCallback(Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "onAutoClose");
        this.onAutoCloseCallback = r10;
    }

    public final void setDelegateDatabase$room_runtime_release(SupportSQLiteDatabase r10) {
        this.delegateDatabase = r10;
    }

    public final void setDelegateOpenHelper(SupportSQLiteOpenHelper r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.delegateOpenHelper = r10;
    }

    public final void setLastDecrementRefCountTimeStamp$room_runtime_release(long r10) {
        this.lastDecrementRefCountTimeStamp = r10;
    }

    public final void setOnAutoCloseCallback$room_runtime_release(Runnable r10) {
        this.onAutoCloseCallback = r10;
    }

    public final void setRefCount$room_runtime_release(int r10) {
        this.refCount = r10;
    }
}
