package com.obric.sva.sdk.ahm;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Skip;
import vendor.bytedance.hardware.ahm.IAHMIDL;
import yna.b;
import yna.c;
import yna.d;
import yna.e;
import yna.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020!J\b\u0010#\u001a\u00020\u001cH\u0002J\u0006\u0010$\u001a\u00020!J\b\u0010%\u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0015H\u0002J\u001c\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010\u00152\b\u0010*\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/sva/sdk/ahm/AhmClient;", "", "<init>", "()V", "TAG", "", "HAL_SERVICE_NAME", "RETRY_INITIAL_DELAY_MS", "", "RETRY_MAX_DELAY_MS", "RETRY_MAX_ATTEMPTS", "", "callback", "Lcom/obric/sva/sdk/ahm/AhmCallback;", "handlerThread", "Landroid/os/HandlerThread;", "handler", "Landroid/os/Handler;", "mAhm", "Lvendor/bytedance/hardware/ahm/IAHMIDL;", "ahmBinder", "Landroid/os/IBinder;", "ahmDeathRecipient", "Landroid/os/IBinder$DeathRecipient;", "lock", "retryAttempt", "Ljava/util/concurrent/atomic/AtomicInteger;", "reconnectEnabled", "", "openTask", "Ljava/lang/Runnable;", "reconnectTask", "initAhm", "", "open", "openInternal", "close", "closeInternal", "onAhmBinderDied", "deadBinder", "unlinkDeathRecipientLocked", "binder", "deathRecipient", "scheduleReconnect", "cancelReconnect", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class AhmClient {
    private static final String HAL_SERVICE_NAME = "vendor.bytedance.hardware.ahm.IAHMIDL/default";
    public static final AhmClient INSTANCE = null;
    private static final long RETRY_INITIAL_DELAY_MS = 500;
    private static final int RETRY_MAX_ATTEMPTS = 20;
    private static final long RETRY_MAX_DELAY_MS = 20000;
    public static final String TAG = "AhmClient";
    private static volatile IBinder ahmBinder;
    private static IBinder.DeathRecipient ahmDeathRecipient;
    private static final AhmCallback callback = null;
    private static final Handler handler = null;
    private static final HandlerThread handlerThread = null;
    private static final Object lock = null;
    private static volatile IAHMIDL mAhm;
    private static final Runnable openTask = null;
    private static volatile boolean reconnectEnabled;
    private static final Runnable reconnectTask = null;
    private static final AtomicInteger retryAttempt = null;

    private AhmClient() {
    }

    public static /* synthetic */ void a() {
        openTask$lambda$1();
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ void b() {
        reconnectTask$lambda$3();
    }

    public static /* synthetic */ void c(IBinder r0) {
        initAhm$lambda$7$lambda$6(r0);
    }

    public static /* synthetic */ void d(IBinder r0) {
        initAhm$lambda$7$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ void e() {
        close$lambda$10();
    }

    public final void close() {
        reconnectEnabled = false;
        retryAttempt.set(0);
        Handler r0 = handler;
        r0.removeCallbacks(openTask);
        r0.removeCallbacks(reconnectTask);
        r0.post(new c());
    }

    public final void open() {
        reconnectEnabled = true;
        retryAttempt.set(0);
        Handler r0 = handler;
        Runnable r1 = openTask;
        r0.removeCallbacks(r1);
        r0.removeCallbacks(reconnectTask);
        r0.post(r1);
    }

    static {
        INSTANCE = new AhmClient();
        callback = new AhmCallback();
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("sva-ahm-client");
        ThreadMethodProxy.start(r0);
        handlerThread = r0;
        handler = new Handler(r0.getLooper());
        lock = new Object();
        retryAttempt = new AtomicInteger(0);
        openTask = new e();
        reconnectTask = new f();
    }

    private final void cancelReconnect() {
        retryAttempt.set(0);
        handler.removeCallbacks(reconnectTask);
    }

    private static final void close$lambda$10() {
        INSTANCE.closeInternal();
    }

    private final void closeInternal() {
        Object r1 = lock;
        monitor-enter(r1);
        IAHMIDL r2 = mAhm;     // Catch: Throwable -> L15
        INSTANCE.unlinkDeathRecipientLocked(ahmBinder, ahmDeathRecipient);     // Catch: Throwable -> L15
        mAhm = null;     // Catch: Throwable -> L15
        ahmBinder = null;     // Catch: Throwable -> L15
        ahmDeathRecipient = null;     // Catch: Throwable -> L15
        monitor-exit(r1);
        if (r2 != null) goto L20;
        LogUtils.i(TAG, "=====mAhm is null =====", new Object[0]);
        return;
    L20:
        LogUtils.i(TAG, "=====ipc_ahm_close ret: " + r2.ipc_ahm_close() + "=====", new Object[0]);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        LogUtils.e(TAG, "Close Ahm failed: " + e.getMessage(), new Object[0]);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private final void initAhm() {
        LogUtils.i(TAG, "===== initAhm =====", new Object[0]);
        Object r3 = lock;
        monitor-enter(r3);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L11
        Method r7 = INVOKESTATIC_com_obric_sva_sdk_ahm_AhmClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class});     // Catch: Throwable -> L11
        r7.setAccessible(true);     // Catch: Throwable -> L11
        Object r8 = r7.invoke(null, new Object[]{HAL_SERVICE_NAME});     // Catch: Throwable -> L11
        if ((r8 instanceof IBinder) == false) goto L8;
        IBinder r9 = (IBinder) r8;     // Catch: Throwable -> L11
    L9:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r10) == false) goto L16;
        r10 = null;
    L16:
        final IBinder r11 = (IBinder) r10;     // Catch: Throwable -> L41
        LogUtils.i(TAG, "=====binder: " + r11 + "=====", new Object[0]);     // Catch: Throwable -> L41
        if (r11 != null) goto L21;
        INSTANCE.unlinkDeathRecipientLocked(ahmBinder, ahmDeathRecipient);     // Catch: Throwable -> L41
        mAhm = null;     // Catch: Throwable -> L41
        ahmBinder = null;     // Catch: Throwable -> L41
        ahmDeathRecipient = null;     // Catch: Throwable -> L41
        monitor-exit(r3);
        return;
    L21:
        IBinder r2 = ahmBinder;     // Catch: Throwable -> L41
        if (r2 == r11) goto L24;
    L31:
        INSTANCE.unlinkDeathRecipientLocked(r2, ahmDeathRecipient);     // Catch: Throwable -> L41
        IBinder.DeathRecipient r4 = new b(r11);     // Catch: Throwable -> L41
        r11.linkToDeath(r4, 0);     // Catch: Exception -> L34 RemoteException -> L36 Throwable -> L41
        IAHMIDL r12 = IAHMIDL.Stub.asInterface(r11);     // Catch: Exception -> L34 RemoteException -> L36 Throwable -> L41
        ahmBinder = r11;     // Catch: Exception -> L34 RemoteException -> L36 Throwable -> L41
        ahmDeathRecipient = r4;     // Catch: Exception -> L34 RemoteException -> L36 Throwable -> L41
        mAhm = r12;     // Catch: Exception -> L34 RemoteException -> L36 Throwable -> L41
    L38:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r3);
        return;
    L36:
        e = move-exception;
        LogUtils.e(TAG, "linkToDeath failed: " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L41
        INSTANCE.unlinkDeathRecipientLocked(r11, r4);     // Catch: Throwable -> L41
        mAhm = null;     // Catch: Throwable -> L41
        ahmBinder = null;     // Catch: Throwable -> L41
        ahmDeathRecipient = null;     // Catch: Throwable -> L41
    L34:
        e = move-exception;
        LogUtils.e(TAG, "initAhm failed: " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L41
        INSTANCE.unlinkDeathRecipientLocked(r11, r4);     // Catch: Throwable -> L41
        mAhm = null;     // Catch: Throwable -> L41
        ahmBinder = null;     // Catch: Throwable -> L41
        ahmDeathRecipient = null;     // Catch: Throwable -> L41
        goto L38
    L24:
        if (mAhm == null) goto L31;
        if (ahmDeathRecipient == null) goto L31;
        if (r11.isBinderAlive() == false) goto L31;
        monitor-exit(r3);
        return;
    L8:
        r9 = null;
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L41
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    private final boolean openInternal() {
        if (reconnectEnabled == true) goto L5;
        return false;
    L5:
        LogUtils.i(TAG, "===== AHM: open =====", new Object[0]);
        initAhm();
        if (reconnectEnabled == true) goto L21;
        return false;
    L21:
        IAHMIDL r1 = mAhm;     // Catch: Exception -> L18
        if (r1 == null) goto L16;
        AhmCallback r3 = callback;     // Catch: Exception -> L18
        r3.setVendorStability();     // Catch: Exception -> L18
        long r6 = r1.ipc_ahm_open_v2(r3, 1);     // Catch: Exception -> L18
        LogUtils.i(TAG, "=====ipc_ahm_open_v2 ret: " + r6 + "=====", new Object[0]);     // Catch: Exception -> L18
        if (r6 != 0) goto L13;
        INSTANCE.cancelReconnect();     // Catch: Exception -> L18
    L13:
        if (r6 != 0) goto L22;
        return true;
    L22:
        return false;
    L16:
        LogUtils.i(TAG, "=====AHM service is null=====", new Object[0]);     // Catch: Exception -> L18
        return false;
    L18:
        e = move-exception;
        LogUtils.e(TAG, "Open Ahm failed: " + e.getMessage(), new Object[0]);
        return false;
    }

    private static final void openTask$lambda$1() {
        INSTANCE.openInternal();
    }

    private static final void reconnectTask$lambda$3() {
        AhmClient r0 = INSTANCE;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(Boolean.valueOf(r0.openInternal()));     // Catch: Throwable -> L5
    L7:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r2) == false) goto L11;
        r2 = r3;
    L11:
        if (((Boolean) r2).booleanValue() == true) goto L16;
        INSTANCE.scheduleReconnect();
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final void scheduleReconnect() {
        if (reconnectEnabled == true) goto L5;
        return;
    L5:
        Handler r0 = handler;
        Runnable r1 = reconnectTask;
        r0.removeCallbacks(r1);
        AtomicInteger r2 = retryAttempt;
        int r3 = r2.get();
        if (r3 < 20) goto L9;
        LogUtils.e(TAG, "reconnect give up, attempt=" + r3, new Object[0]);
        reconnectEnabled = false;
        closeInternal();
        return;
    L9:
        long r7 = RangesKt.coerceAtMost(RETRY_INITIAL_DELAY_MS << RangesKt.coerceAtMost(r3, 5), RETRY_MAX_DELAY_MS);
        r2.incrementAndGet();
        r0.postDelayed(r1, r7);
        LogUtils.i(TAG, "reconnect scheduled, attempt=" + r3 + " delayMs=" + r7, new Object[0]);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_sva_sdk_ahm_AhmClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    private static final void initAhm$lambda$7$lambda$6(IBinder r2) {
        handler.post(new d(r2));
    }

    private static final void initAhm$lambda$7$lambda$6$lambda$5(IBinder r1) {
        INSTANCE.onAhmBinderDied(r1);
    }

    private final void onAhmBinderDied(IBinder r6) {
        Object r1 = lock;
        monitor-enter(r1);
        boolean r3 = false;
        LogUtils.i(TAG, "=====onAhmBinderDied===== dead=" + r6 + " current=" + ahmBinder, new Object[0]);     // Catch: Throwable -> L13
        if (ahmBinder == r6) goto L7;
        LogUtils.i(TAG, "ignore stale AHM binder death", new Object[0]);     // Catch: Throwable -> L13
    L9:
        monitor-exit(r1);
        if (r3 == false) goto L17;
        scheduleReconnect();
        return;
    L17:
        return;
    L7:
        INSTANCE.unlinkDeathRecipientLocked(r6, ahmDeathRecipient);     // Catch: Throwable -> L13
        mAhm = null;     // Catch: Throwable -> L13
        ahmBinder = null;     // Catch: Throwable -> L13
        ahmDeathRecipient = null;     // Catch: Throwable -> L13
        r3 = true;
    L13:
        th = move-exception;
        throw th;
    }

    private final void unlinkDeathRecipientLocked(IBinder r2, IBinder.DeathRecipient r3) {
        if (r2 == null) goto L12;
        if (r3 == null) goto L13;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Result.constructor-impl(Boolean.valueOf(r2.unlinkToDeath(r3, 0)));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L13:
        return;
    }
}
