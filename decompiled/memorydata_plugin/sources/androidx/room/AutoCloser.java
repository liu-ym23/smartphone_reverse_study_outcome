package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J%\u00106\u001a\u0002H7\"\u0004\b\u0000\u001072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H709¢\u0006\u0002\u0010:J\u0006\u0010;\u001a\u00020\rJ\u000e\u0010<\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020\u000bR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020,8\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u00020,8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010.¨\u0006@"}, d2 = {"Landroidx/room/AutoCloser;", "", "autoCloseTimeoutAmount", "", "autoCloseTimeUnit", "Ljava/util/concurrent/TimeUnit;", "autoCloseExecutor", "Ljava/util/concurrent/Executor;", "(JLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/Executor;)V", "autoCloseTimeoutInMs", "autoCloser", "Ljava/lang/Runnable;", "delegateDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getDelegateDatabase$room_runtime_release", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "setDelegateDatabase$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "delegateOpenHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "getDelegateOpenHelper", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "setDelegateOpenHelper", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "executeAutoCloser", "executor", "handler", "Landroid/os/Handler;", "isActive", "", "()Z", "lastDecrementRefCountTimeStamp", "getLastDecrementRefCountTimeStamp$room_runtime_release", "()J", "setLastDecrementRefCountTimeStamp$room_runtime_release", "(J)V", "lock", "manuallyClosed", "onAutoCloseCallback", "getOnAutoCloseCallback$room_runtime_release", "()Ljava/lang/Runnable;", "setOnAutoCloseCallback$room_runtime_release", "(Ljava/lang/Runnable;)V", "refCount", "", "getRefCount$room_runtime_release", "()I", "setRefCount$room_runtime_release", "(I)V", "refCountForTest", "getRefCountForTest$room_runtime_release", "closeDatabaseIfOpen", "", "decrementCountAndScheduleClose", "executeRefCountingFunction", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "incrementCountAndEnsureDbIsOpen", CommonConsts.APM_INNER_EVENT_COST_INIT, "setAutoCloseCallback", "onAutoClose", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AutoCloser {
    public static final Companion Companion = null;
    public static final String autoCloseBug = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";
    private long autoCloseTimeoutInMs;
    private final Runnable autoCloser;
    private SupportSQLiteDatabase delegateDatabase;
    public SupportSQLiteOpenHelper delegateOpenHelper;
    private final Runnable executeAutoCloser;
    private final Executor executor;
    private final Handler handler;
    private long lastDecrementRefCountTimeStamp;
    private final Object lock;
    private boolean manuallyClosed;
    private Runnable onAutoCloseCallback;
    private int refCount;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/AutoCloser$Companion;", "", "()V", "autoCloseBug", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AutoCloser(long r3, TimeUnit r5, Executor r6) {
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r6, Executor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "autoCloseTimeUnit");
        Intrinsics.checkNotNullParameter(r7, "autoCloseExecutor");
        this.handler = new Handler(Looper.getMainLooper());
        this.lock = new Object();
        this.autoCloseTimeoutInMs = r5.toMillis(r3);
        this.executor = r7;
        this.lastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
        this.executeAutoCloser = new $$Lambda$AutoCloser$IDlpiQzGERMyiJhLp9dqH94Jfq8(this);
        this.autoCloser = new $$Lambda$AutoCloser$Xeo1sT4yrRJFpXIV1D3OJ8zyhr8(this);
    }

    private static final void autoCloser$lambda$3(AutoCloser r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Object r0 = r5.lock;
        monitor-enter(r0);
    L28:
        th = move-exception;
        throw th;
    L6:
        if ((SystemClock.uptimeMillis() - r5.lastDecrementRefCountTimeStamp) >= r5.autoCloseTimeoutInMs) goto L10;
        monitor-exit(r0);
        return;
    L10:
        if (r5.refCount == 0) goto L13;
        monitor-exit(r0);
        return;
    L13:
        Runnable r1 = r5.onAutoCloseCallback;     // Catch: Throwable -> L28
        if (r1 == null) goto L16;
        r1.run();     // Catch: Throwable -> L28
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L28
    L17:
        if (r2 == null) goto L27;
        SupportSQLiteDatabase r3 = r5.delegateDatabase;     // Catch: Throwable -> L28
        if (r3 != null) goto L21;
    L23:
        r5.delegateDatabase = null;     // Catch: Throwable -> L28
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r0);
        return;
    L21:
        if (r3.isOpen() == false) goto L23;
        r3.close();     // Catch: Throwable -> L28
        goto L23
    L27:
        throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568".toString());     // Catch: Throwable -> L28
    L16:
        r2 = null;
        goto L17
    }

    private static final void executeAutoCloser$lambda$0(AutoCloser r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.executor.execute(r1.autoCloser);
    }

    public static /* synthetic */ void lambda$IDlpiQzGERMyiJhLp9dqH94Jfq8(AutoCloser r0) {
        executeAutoCloser$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$Xeo1sT4yrRJFpXIV1D3OJ8zyhr8(AutoCloser r0) {
        autoCloser$lambda$3(r0);
    }

    public final void closeDatabaseIfOpen() {
        Object r0 = this.lock;
        monitor-enter(r0);
        this.manuallyClosed = true;     // Catch: Throwable -> L11
        SupportSQLiteDatabase r1 = this.delegateDatabase;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        r1.close();     // Catch: Throwable -> L11
    L8:
        this.delegateDatabase = null;     // Catch: Throwable -> L11
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void decrementCountAndScheduleClose() {
        Object r0 = this.lock;
        monitor-enter(r0);
        int r1 = this.refCount;     // Catch: Throwable -> L21
        if (r1 <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L20;
        int r3 = r1 - 1;     // Catch: Throwable -> L21
        this.refCount = r3;     // Catch: Throwable -> L21
        if (r3 == 0) goto L12;
    L16:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r0);
        return;
    L12:
        if (this.delegateDatabase != null) goto L15;
        monitor-exit(r0);
        return;
    L15:
        this.handler.postDelayed(this.executeAutoCloser, this.autoCloseTimeoutInMs);     // Catch: Throwable -> L21
        goto L16
    L20:
        throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement".toString());     // Catch: Throwable -> L21
    L7:
        r2 = false;
    L21:
        th = move-exception;
        throw th;
    }

    public final <V> V executeRefCountingFunction(Function1<? super SupportSQLiteDatabase, ? extends V> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "block");
        V r5 = (V) r4.invoke(incrementCountAndEnsureDbIsOpen());
        decrementCountAndScheduleClose();
        return r5;
    L6:
        th = move-exception;
        decrementCountAndScheduleClose();
        throw th;
    }

    public final SupportSQLiteDatabase getDelegateDatabase$room_runtime_release() {
        return this.delegateDatabase;
    }

    public final SupportSQLiteOpenHelper getDelegateOpenHelper() {
        SupportSQLiteOpenHelper r0 = this.delegateOpenHelper;
        if (r0 == null) goto L5;
        return r0;
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

    public final int getRefCountForTest$room_runtime_release() {
        Object r0 = this.lock;
        monitor-enter(r0);
        int r1 = this.refCount;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        Object r0 = this.lock;
        monitor-enter(r0);
        this.handler.removeCallbacks(this.executeAutoCloser);     // Catch: Throwable -> L17
        this.refCount++;     // Catch: Throwable -> L17
        if ((!this.manuallyClosed) == false) goto L16;
        SupportSQLiteDatabase r1 = this.delegateDatabase;     // Catch: Throwable -> L17
        if (r1 != null) goto L9;
    L12:
        SupportSQLiteDatabase r2 = getDelegateOpenHelper().getWritableDatabase();     // Catch: Throwable -> L17
        this.delegateDatabase = r2;     // Catch: Throwable -> L17
        monitor-exit(r0);
        return r2;
    L9:
        if (r1.isOpen() == false) goto L12;
        monitor-exit(r0);
        return r1;
    L16:
        throw new IllegalStateException("Attempting to open already closed database.".toString());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final void init(SupportSQLiteOpenHelper r3) {
        SupportSQLiteOpenHelper r4 = (SupportSQLiteOpenHelper) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteOpenHelper.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "delegateOpenHelper");
        setDelegateOpenHelper(r4);
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final void setAutoCloseCallback(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onAutoClose");
        this.onAutoCloseCallback = r4;
    }

    public final void setDelegateDatabase$room_runtime_release(SupportSQLiteDatabase r3) {
        this.delegateDatabase = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
    }

    public final void setDelegateOpenHelper(SupportSQLiteOpenHelper r3) {
        SupportSQLiteOpenHelper r4 = (SupportSQLiteOpenHelper) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteOpenHelper.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.delegateOpenHelper = r4;
    }

    public final void setLastDecrementRefCountTimeStamp$room_runtime_release(long r1) {
        this.lastDecrementRefCountTimeStamp = r1;
    }

    public final void setOnAutoCloseCallback$room_runtime_release(Runnable r3) {
        this.onAutoCloseCallback = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
    }

    public final void setRefCount$room_runtime_release(int r1) {
        this.refCount = r1;
    }
}
