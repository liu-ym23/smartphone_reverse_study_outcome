package com.obric.memorydata.recommend.settings;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationEnhancedTimelinessSettings;", "", "<init>", "()V", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "isEnabled", "", "refreshUploadTaskConditions", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f12618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f12619b = null;

    static {
        f12618a = new p();
        f12619b = LazyKt.lazy($$Lambda$p$d9UYrjsB6Pf3DQc4QCIvUDaVtc.INSTANCE);
    }

    private p() {
    }

    private static final Unit a(boolean r2, boolean r3, com.obric.memorydata.middleware.api.logging.g r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$mainTrace");
        r4.a("cellular_upload_enabled", Boolean.valueOf(r2));
        r4.a("enhanced_timeliness_enabled", Boolean.valueOf(r3));
        r4.a("upload_wifi_required", Boolean.valueOf(!r2));
        r4.a("upload_screen_on_or_charge_required", Boolean.valueOf(!r3));
        if (r3 == false) goto L5;
        String r5 = "memory_extract_power_control";
    L6:
        r4.a("upload_power_control_condition", r5);
        return Unit.INSTANCE;
    L5:
        r5 = "common_power_control";
        goto L6
    }

    private final IStore c() {
        return (IStore) ZeusTransformUtils.preCheckCast(f12619b.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private static final IStore d() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    /* JADX INFO: renamed from: lambda$2SAnvYpBMJvgvw6XFF4X3SNOl-o, reason: not valid java name */
    public static /* synthetic */ Unit m1134lambda$2SAnvYpBMJvgvw6XFF4X3SNOlo(boolean r0, boolean r1, com.obric.memorydata.middleware.api.logging.g r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$d9U-YrjsB6Pf3DQc4QCIvUDaVtc, reason: not valid java name */
    public static /* synthetic */ IStore m1135lambda$d9UYrjsB6Pf3DQc4QCIvUDaVtc() {
        return d();
    }

    public final boolean a() {
        return c().getBoolean("context_awareness_enhanced_timeliness_effective", false);
    }

    public final void b() {
        final boolean r10 = a();
        final boolean r0 = o.f12616a.b();
        com.obric.memorydata.recommend.screenshotupload.e.f12556a.b(r0, r10).a();
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.s.f11634a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "及时性设置变化后已刷新截图上传任务", "enhanced_timeliness_refresh", new com.obric.memorydata.middleware.api.logging.e(null, null, "enhanced_timeliness_refresh", 3, null), new $$Lambda$p$2SAnvYpBMJvgvw6XFF4X3SNOlo(r0, r10), null, 16, null);
    }
}
