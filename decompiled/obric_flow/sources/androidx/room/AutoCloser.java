package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J%\u00106\u001a\u0002H7\"\u0004\b\u0000\u001072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H709¢\u0006\u0002\u0010:J\u0006\u0010;\u001a\u00020\rJ\u000e\u0010<\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020\u000bR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020,8\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u00020,8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010.¨\u0006@"}, d2 = {"Landroidx/room/AutoCloser;", "", "autoCloseTimeoutAmount", "", "autoCloseTimeUnit", "Ljava/util/concurrent/TimeUnit;", "autoCloseExecutor", "Ljava/util/concurrent/Executor;", "(JLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/Executor;)V", "autoCloseTimeoutInMs", "autoCloser", "Ljava/lang/Runnable;", "delegateDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getDelegateDatabase$room_runtime_release", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "setDelegateDatabase$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "delegateOpenHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "getDelegateOpenHelper", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "setDelegateOpenHelper", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "executeAutoCloser", "executor", "handler", "Landroid/os/Handler;", "isActive", "", "()Z", "lastDecrementRefCountTimeStamp", "getLastDecrementRefCountTimeStamp$room_runtime_release", "()J", "setLastDecrementRefCountTimeStamp$room_runtime_release", "(J)V", "lock", "manuallyClosed", "onAutoCloseCallback", "getOnAutoCloseCallback$room_runtime_release", "()Ljava/lang/Runnable;", "setOnAutoCloseCallback$room_runtime_release", "(Ljava/lang/Runnable;)V", "refCount", "", "getRefCount$room_runtime_release", "()I", "setRefCount$room_runtime_release", "(I)V", "refCountForTest", "getRefCountForTest$room_runtime_release", "closeDatabaseIfOpen", "", "decrementCountAndScheduleClose", "executeRefCountingFunction", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "incrementCountAndEnsureDbIsOpen", "init", "setAutoCloseCallback", "onAutoClose", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/AutoCloser$Companion;", "", "()V", "autoCloseBug", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AutoCloser(long r5, TimeUnit r10, Executor r11) {
        Intrinsics.checkNotNullParameter(r10, "autoCloseTimeUnit");
        Intrinsics.checkNotNullParameter(r11, "autoCloseExecutor");
        this.handler = new Handler(Looper.getMainLooper());
        this.lock = new Object();
        this.autoCloseTimeoutInMs = r10.toMillis(r5);
        this.executor = r11;
        this.lastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
        final int r12 = 0;
        this.executeAutoCloser = new a(this, r12);
        final int r13 = 1;
        this.autoCloser = new a(this, r13);
    }

    public static /* synthetic */ void a(AutoCloser r5) {
        executeAutoCloser$lambda$0(r5);
    }

    private static final void autoCloser$lambda$3(AutoCloser r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Object r10 = r5.lock;
        monitor-enter(r10);
    L16:
        th = move-exception;
        throw th;
    L6:
        if ((SystemClock.uptimeMillis() - r5.lastDecrementRefCountTimeStamp) >= r5.autoCloseTimeoutInMs) goto L10;
        monitor-exit(r10);
        return;
    L10:
        if (r5.refCount == 0) goto L13;
        monitor-exit(r10);
        return;
    L13:
        Runnable r11 = r5.onAutoCloseCallback;     // Catch: Throwable -> L16
        if (r11 == null) goto L18;
        r11.run();     // Catch: Throwable -> L16
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L19:
        if (r12 == null) goto L29;
        SupportSQLiteDatabase r13 = r5.delegateDatabase;     // Catch: Throwable -> L16
        if (r13 != null) goto L23;
    L25:
        r5.delegateDatabase = null;     // Catch: Throwable -> L16
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r10);
        return;
    L23:
        if (r13.isOpen() == false) goto L25;
        r13.close();     // Catch: Throwable -> L16
        goto L25
    L29:
        throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");     // Catch: Throwable -> L16
    L18:
        r12 = null;
        goto L19
    }

    public static /* synthetic */ void b(AutoCloser r5) {
        autoCloser$lambda$3(r5);
    }

    private static final void executeAutoCloser$lambda$0(AutoCloser r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.executor.execute(r5.autoCloser);
    }

    public final void closeDatabaseIfOpen() throws IOException {
        Object r5 = this.lock;
        monitor-enter(r5);
        this.manuallyClosed = true;     // Catch: Throwable -> L8
        SupportSQLiteDatabase r10 = this.delegateDatabase;     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        r10.close();     // Catch: Throwable -> L8
    L10:
        this.delegateDatabase = null;     // Catch: Throwable -> L8
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r5);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void decrementCountAndScheduleClose() {
        Object r5 = this.lock;
        monitor-enter(r5);
        int r10 = this.refCount;     // Catch: Throwable -> L13
        if (r10 <= 0) goto L19;
        int r11 = r10 - 1;     // Catch: Throwable -> L13
        this.refCount = r11;     // Catch: Throwable -> L13
        if (r11 == 0) goto L9;
    L15:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r5);
        return;
    L9:
        if (this.delegateDatabase != null) goto L12;
        monitor-exit(r5);
        return;
    L12:
        this.handler.postDelayed(this.executeAutoCloser, this.autoCloseTimeoutInMs);     // Catch: Throwable -> L13
        goto L15
    L19:
        throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final <V> V executeRefCountingFunction(Function1<? super SupportSQLiteDatabase, ? extends V> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        V r10 = r5.invoke(incrementCountAndEnsureDbIsOpen());     // Catch: Throwable -> L6
        decrementCountAndScheduleClose();
        return r10;
    L6:
        th = move-exception;
        decrementCountAndScheduleClose();
        throw th;
    }

    public final SupportSQLiteDatabase getDelegateDatabase$room_runtime_release() {
        return this.delegateDatabase;
    }

    public final SupportSQLiteOpenHelper getDelegateOpenHelper() {
        SupportSQLiteOpenHelper r5 = this.delegateOpenHelper;
        if (r5 == null) goto L5;
        return r5;
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
        Object r5 = this.lock;
        monitor-enter(r5);
        int r10 = this.refCount;     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        Object r5 = this.lock;
        monitor-enter(r5);
        this.handler.removeCallbacks(this.executeAutoCloser);     // Catch: Throwable -> L12
        this.refCount++;     // Catch: Throwable -> L12
        if (this.manuallyClosed == true) goto L18;
        SupportSQLiteDatabase r10 = this.delegateDatabase;     // Catch: Throwable -> L12
        if (r10 != null) goto L9;
    L14:
        SupportSQLiteDatabase r11 = getDelegateOpenHelper().getWritableDatabase();     // Catch: Throwable -> L12
        this.delegateDatabase = r11;     // Catch: Throwable -> L12
        monitor-exit(r5);
        return r11;
    L9:
        if (r10.isOpen() == false) goto L14;
        monitor-exit(r5);
        return r10;
    L18:
        throw new IllegalStateException("Attempting to open already closed database.");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public final void init(SupportSQLiteOpenHelper r5) {
        Intrinsics.checkNotNullParameter(r5, "delegateOpenHelper");
        setDelegateOpenHelper(r5);
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final void setAutoCloseCallback(Runnable r5) {
        Intrinsics.checkNotNullParameter(r5, "onAutoClose");
        this.onAutoCloseCallback = r5;
    }

    public final void setDelegateDatabase$room_runtime_release(SupportSQLiteDatabase r5) {
        this.delegateDatabase = r5;
    }

    public final void setDelegateOpenHelper(SupportSQLiteOpenHelper r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.delegateOpenHelper = r5;
    }

    public final void setLastDecrementRefCountTimeStamp$room_runtime_release(long r5) {
        this.lastDecrementRefCountTimeStamp = r5;
    }

    public final void setOnAutoCloseCallback$room_runtime_release(Runnable r5) {
        this.onAutoCloseCallback = r5;
    }

    public final void setRefCount$room_runtime_release(int r5) {
        this.refCount = r5;
    }
}
