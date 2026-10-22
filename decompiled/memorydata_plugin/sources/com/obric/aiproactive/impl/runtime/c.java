package com.obric.aiproactive.impl.runtime;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiproactive.api.DoubaoGlassesConnectionSnapshot;
import com.obric.aiproactive.api.DoubaoGlassesConnectionState;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0013J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/aiproactive/impl/runtime/DoubaoGlassesConnectionStateManager;", "", "<init>", "()V", "KEY_CONNECTED", "", "KEY_CONNECTION_GENERATION", "KEY_WEARING", "KEY_ENVIRONMENT_MEMORY_ENABLED", "KEY_EVER_CONNECTED", "logger", "Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "initialized", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "onConnectionChanged", "connected", "onWearingChanged", "wearing", "onEnvironmentMemoryChanged", "enabled", "ensureInitialized", "stateContext", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "stage", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o f6510b = null;
    private static final Lazy c = null;
    private static boolean d;

    static {
        f6509a = new c();
        f6510b = com.obric.memorydata.middleware.api.logging.d.f11613a.a("DoubaoGlassesStateMgr");
        c = LazyKt.lazy($$Lambda$c$Rhj_tImLlQ61Qe7t6DLRHdwkFl0.INSTANCE);
    }

    private c() {
    }

    private final com.obric.memorydata.middleware.api.logging.e a(long r7, String r9) {
        return new com.obric.memorydata.middleware.api.logging.e(null, "connection_" + r7, r9, 1, null);
    }

    private static final Unit a(DoubaoGlassesConnectionSnapshot r2, g r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
        r3.a("connected", Boolean.valueOf(r2.getConnected()));
        r3.a("wearing", Boolean.valueOf(r2.getWearing()));
        r3.a("environment_memory_enabled", Boolean.valueOf(r2.getEnvironmentMemoryEnabled()));
        r3.a("ever_connected", Boolean.valueOf(r2.getEverConnected()));
        r3.a(PendingPersonalInfoNotificationTask.KEY_GENERATION, Long.valueOf(r2.getGeneration()));
        return Unit.INSTANCE;
    }

    private static final Unit a(DoubaoGlassesConnectionSnapshot r2, boolean r3, g r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$mainTrace");
        r4.a("connected", Boolean.valueOf(r2.getConnected()));
        r4.a("reported_wearing", Boolean.valueOf(r3));
        r4.a("wearing", Boolean.valueOf(r2.getWearing()));
        r4.a(PendingPersonalInfoNotificationTask.KEY_GENERATION, Long.valueOf(r2.getGeneration()));
        return Unit.INSTANCE;
    }

    private static final Unit a(boolean r1, DoubaoGlassesConnectionSnapshot r2, g r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
        r3.a("connected", Boolean.valueOf(r1));
        r3.a(PendingPersonalInfoNotificationTask.KEY_GENERATION, Long.valueOf(r2.getGeneration()));
        return Unit.INSTANCE;
    }

    private final IStore b() {
        return (IStore) ZeusTransformUtils.preCheckCast(c.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private static final Unit b(boolean r1, DoubaoGlassesConnectionSnapshot r2, g r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
        r3.a("enabled", Boolean.valueOf(r1));
        r3.a("connected", Boolean.valueOf(r2.getConnected()));
        r3.a("wearing", Boolean.valueOf(r2.getWearing()));
        r3.a(PendingPersonalInfoNotificationTask.KEY_GENERATION, Long.valueOf(r2.getGeneration()));
        return Unit.INSTANCE;
    }

    private final synchronized void c() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (d == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        final DoubaoGlassesConnectionSnapshot r0 = DoubaoGlassesConnectionState.INSTANCE.initializeFromHost(b().getBoolean("glasses_observation_doubao_glasses_connected", false), b().getLong("glasses_observation_doubao_glasses_connection_generation", 1), b().getBoolean("ai_proactive_doubao_glasses_connected", false), b().getBoolean("glasses_observation_environment_memory_enabled", true), b().getBoolean("glasses_observation_doubao_glasses_ever_connected", false));     // Catch: Throwable -> L13
        if (r0.getEverConnected() == false) goto L10;
        b().save("glasses_observation_doubao_glasses_ever_connected", true);     // Catch: Throwable -> L13
    L10:
        d = true;     // Catch: Throwable -> L13
        o.a(f6510b, "眼镜核心状态已初始化", "glasses_state_initialized", a(r0.getGeneration(), "state"), new $$Lambda$c$b9cVlwlBdflkh1i8xLv17EPUX70(r0), null, 16, null);     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    private static final IStore d() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    /* JADX INFO: renamed from: lambda$43CPJDf9UeNVDL-IR_tk-TJCs8s, reason: not valid java name */
    public static /* synthetic */ Unit m240lambda$43CPJDf9UeNVDLIR_tkTJCs8s(boolean r0, DoubaoGlassesConnectionSnapshot r1, g r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$FZKwpTrxsJZY8OdHqjiV4ForRXM(DoubaoGlassesConnectionSnapshot r0, boolean r1, g r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ IStore lambda$Rhj_tImLlQ61Qe7t6DLRHdwkFl0() {
        return d();
    }

    public static /* synthetic */ Unit lambda$b9cVlwlBdflkh1i8xLv17EPUX70(DoubaoGlassesConnectionSnapshot r0, g r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$sQLqCQdT3jV2ZlmZ8HmM7-aMkag, reason: not valid java name */
    public static /* synthetic */ Unit m241lambda$sQLqCQdT3jV2ZlmZ8HmM7aMkag(boolean r0, DoubaoGlassesConnectionSnapshot r1, g r2) {
        return a(r0, r1, r2);
    }

    public final void a() {
        c();
    }

    public final void a(final boolean r13) {
        c();
        final DoubaoGlassesConnectionSnapshot r0 = DoubaoGlassesConnectionState.INSTANCE.updateFromHost(r13);
        if (r0 != null) goto L8;
        o r12 = f6510b;
        com.obric.memorydata.middleware.api.logging.e r6 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L21;
        g r1 = new g();
        r1.a("connected", Boolean.valueOf(r13));
        Unit r14 = Unit.INSTANCE;
        r12.a("忽略未变化的眼镜物理连接状态", r6, r1.a());
        return;
    L21:
        return;
    L8:
        b().save("glasses_observation_doubao_glasses_connection_generation", r0.getGeneration());
        b().save("glasses_observation_doubao_glasses_connected", r13);
        if (r0.getEverConnected() == false) goto L11;
        b().save("glasses_observation_doubao_glasses_ever_connected", true);
    L11:
        o r4 = f6510b;
        if (r13 == false) goto L14;
        String r2 = "眼镜已连接";
    L15:
        String r5 = r2;
        if (r13 == false) goto L18;
        String r3 = "glasses_connected";
    L19:
        o.a(r4, r5, r3, a(r0.getGeneration(), WsConstants.KEY_CONNECTION), new $$Lambda$c$sQLqCQdT3jV2ZlmZ8HmM7aMkag(r13, r0), null, 16, null);
        return;
    L18:
        r3 = "glasses_disconnected";
        goto L19
    L14:
        r2 = "眼镜已断开";
        goto L15
    }

    public final void b(final boolean r18) {
        c();
        final DoubaoGlassesConnectionSnapshot r1 = DoubaoGlassesConnectionState.INSTANCE.updateWearingFromHost(r18);
        b().save("ai_proactive_doubao_glasses_connected", r18);
        if (r1 != null) goto L8;
        o r2 = f6510b;
        com.obric.memorydata.middleware.api.logging.e r8 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L10;
        g r3 = new g();
        r3.a("reported_wearing", Boolean.valueOf(r18));
        Unit r0 = Unit.INSTANCE;
        r2.a("忽略未变化的眼镜佩戴状态", r8, r3.a());
        return;
    L10:
        return;
    L8:
        o.a(f6510b, "眼镜佩戴状态已更新", "glasses_wearing_changed", a(r1.getGeneration(), "wearing"), new $$Lambda$c$FZKwpTrxsJZY8OdHqjiV4ForRXM(r1, r18), null, 16, null);
    }

    public final void c(final boolean r12) {
        c();
        final DoubaoGlassesConnectionSnapshot r0 = DoubaoGlassesConnectionState.INSTANCE.updateEnvironmentMemoryFromHost(r12);
        if (r0 != null) goto L8;
        o r11 = f6510b;
        com.obric.memorydata.middleware.api.logging.e r6 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L10;
        g r1 = new g();
        r1.a("enabled", Boolean.valueOf(r12));
        Unit r13 = Unit.INSTANCE;
        r11.a("眼镜环境记忆状态未变化...", r6, r1.a());
        return;
    L10:
        return;
    L8:
        b().save("glasses_observation_environment_memory_enabled", r12);
        o.a(f6510b, "眼镜环境记忆状态已更新", "glasses_environment_memory_changed", a(r0.getGeneration(), "environment_memory"), new $$Lambda$c$43CPJDf9UeNVDLIR_tkTJCs8s(r12, r0), null, 16, null);
    }
}
