package com.obric.sva.sdk.ohr;

import android.content.Context;
import aoa.a;
import aoa.b;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.plugin_api.BuildConfig;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.e;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sna.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0005J \u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/obric/sva/sdk/ohr/OhrHandStateBridge;", "", "<init>", "()V", "TAG", "", "lock", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "registered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "latestOhrHand", "Ljava/util/concurrent/atomic/AtomicInteger;", "listener", "com/obric/sva/sdk/ohr/OhrHandStateBridge$listener$1", "Lcom/obric/sva/sdk/ohr/OhrHandStateBridge$listener$1;", "switchStateAsync", "", "context", "Landroid/content/Context;", "enabled", "", "reason", "ensureRegisteredAsync", "syncSwitchState", "tryRegister", BuildConfig.BUILD_TYPE, "currentOhrHand", "", "refreshCurrentValue", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class OhrHandStateBridge {
    public static final OhrHandStateBridge INSTANCE = null;
    private static final String TAG = "OhrHandStateBridge";
    private static final ExecutorService executor = null;
    private static final AtomicInteger latestOhrHand = null;
    private static final OhrHandStateBridge$listener$1 listener = null;
    private static final Object lock = null;
    private static final AtomicBoolean registered = null;

    private OhrHandStateBridge() {
    }

    public static /* synthetic */ void a(Context r0, boolean r1, String r2) {
        switchStateAsync$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ Thread b(Runnable r0) {
        return executor$lambda$1(r0);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.sva.sdk.ohr.OhrHandStateBridge$listener$1] */
    static {
        INSTANCE = new OhrHandStateBridge();
        lock = new Object();
        executor = PThreadExecutorsUtils.newSingleThreadExecutor(new a());
        registered = new AtomicBoolean(false);
        latestOhrHand = new AtomicInteger(0);
        listener = new OhrHandStateBridge$listener$1();
    }

    public final int currentOhrHand() {
        if (registered.get() == true) goto L5;
    L7:
        return 0;
    L5:
        if (i.a() == false) goto L7;
        return latestOhrHand.get();
    }

    public static final /* synthetic */ AtomicInteger access$getLatestOhrHand$p() {
        return latestOhrHand;
    }

    private static final Thread executor$lambda$1(Runnable r2) {
        PthreadThreadV2 r0 = new PthreadThreadV2(r2, "sva-ohr-hand-state");
        r0.setDaemon(true);
        return r0;
    }

    private final void refreshCurrentValue(String r8) {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L13
        MemoryResponse r6 = e.a.b("ohr_hand");     // Catch: Throwable -> L13
        if (r6.a() == false) goto L10;
        AtomicInteger r3 = latestOhrHand;     // Catch: Throwable -> L13
        Integer r7 = (Integer) r6.c;     // Catch: Throwable -> L13
        if (r7 == null) goto L8;
        int r9 = r7.intValue();     // Catch: Throwable -> L13
    L9:
        r3.set(r9);     // Catch: Throwable -> L13
        LogUtils.i(TAG, "refresh current value reason=" + r8 + " value=" + r3.get(), new Object[0]);     // Catch: Throwable -> L13
    L11:
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        if (r4 == null) goto L21;
        LogUtils.w(TAG, "refresh current value exception reason=" + r8 + " msg=" + r4.getMessage(), new Object[0]);
        return;
    L21:
        return;
    L8:
        r9 = 0;
        goto L9
    L10:
        LogUtils.w(TAG, "refresh current value failed reason=" + r8 + " code=" + r6.a + " msg=" + r6.b, new Object[0]);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    private final void release(String r11) {
        Object r3 = lock;
        monitor-enter(r3);
        AtomicBoolean r4 = registered;     // Catch: Throwable -> L23
        if (r4.compareAndSet(true, false) == true) goto L27;
        latestOhrHand.set(0);     // Catch: Throwable -> L23
        monitor-exit(r3);
        return;
    L27:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L16
        e r8 = e.a;     // Catch: Throwable -> L16
        MemoryResponse r9 = r8.j(listener);     // Catch: Throwable -> L16
        if (r9.a() == true) goto L14;
        r4.set(true);     // Catch: Throwable -> L16
        LogUtils.w(TAG, "unregister failed reason=" + r11 + " code=" + r9.a + " msg=" + r9.b, new Object[0]);     // Catch: Throwable -> L16
        monitor-exit(r3);
        return;
    L14:
        r8.g();     // Catch: Throwable -> L16
        latestOhrHand.set(0);     // Catch: Throwable -> L16
        LogUtils.i(TAG, "release success reason=" + r11, new Object[0]);     // Catch: Throwable -> L16
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r1 = Result.exceptionOrNull-impl(r0);     // Catch: Throwable -> L23
        if (r1 == null) goto L21;
        registered.set(true);     // Catch: Throwable -> L23
        LogUtils.w(TAG, "release exception reason=" + r11 + " msg=" + r1.getMessage(), new Object[0]);     // Catch: Throwable -> L23
    L21:
        monitor-exit(r3);
        return;
    L16:
        th = move-exception;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L23
        r0 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private final void tryRegister(Context r12, String r13) {
        Object r4 = lock;
        monitor-enter(r4);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (i.a() == true) goto L9;
        LogUtils.i(TAG, "register skipped: truth capture disabled reason=" + r13, new Object[0]);     // Catch: Throwable -> L27
        monitor-exit(r4);
        return;
    L9:
        AtomicBoolean r3 = registered;     // Catch: Throwable -> L27
        if (r3.get() == false) goto L13;
        monitor-exit(r4);
        return;
    L13:
        AtomicInteger r5 = latestOhrHand;     // Catch: Throwable -> L27
        r5.set(0);     // Catch: Throwable -> L27
        OhrHandStateBridge r7 = INSTANCE;     // Catch: Throwable -> L27
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L20
        Context r14 = r12.getApplicationContext();     // Catch: Throwable -> L20
        e r9 = e.a;     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L20
        e.d(r9, r14, new tryRegister.1.1.1(), 0, 4);     // Catch: Throwable -> L20
        MemoryResponse r15 = r9.f(listener);     // Catch: Throwable -> L20
        if (r15.a() == false) goto L17;
        r3.set(true);     // Catch: Throwable -> L20
        r7.refreshCurrentValue("register_success");     // Catch: Throwable -> L20
        LogUtils.i(TAG, "register success reason=" + r13 + " latest=" + r5.get(), new Object[0]);     // Catch: Throwable -> L20
    L18:
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L27
        if (r17 == null) goto L25;
        LogUtils.w(TAG, "register exception reason=" + r13 + " msg=" + r17.getMessage(), new Object[0]);     // Catch: Throwable -> L27
    L25:
        monitor-exit(r4);
        return;
    L17:
        LogUtils.w(TAG, "register failed reason=" + r13 + " code=" + r15.a + " msg=" + r15.b, new Object[0]);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L27
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
        goto L22
    }

    public final void ensureRegisteredAsync(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "reason");
        switchStateAsync(r2, true, r3);
    }

    private static final void switchStateAsync$lambda$2(Context r1, boolean r2, String r3) {
        OhrHandStateBridge r0 = INSTANCE;
        Intrinsics.checkNotNull(r1);
        r0.syncSwitchState(r1, r2, r3);
    }

    private final void syncSwitchState(Context r1, boolean r2, String r3) {
        if (r2 == false) goto L4;
        tryRegister(r1, r3);
        return;
    L4:
        release(r3);
    }

    public final void switchStateAsync(Context r3, final boolean r4, final String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "reason");
        final Context r6 = r3.getApplicationContext();
        if (r4 == true) goto L5;
        latestOhrHand.set(0);
    L5:
        executor.execute(new b(r6, r4, r5));
    }
}
