package com.obric.memorydata.recommend.settings;

import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0011R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationCellularSettings;", "", "<init>", "()V", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "mutation", "Lcom/obric/memorydata/recommend/settings/ScreenObservationCellularMutation;", "getMutation", "()Lcom/obric/memorydata/recommend/settings/ScreenObservationCellularMutation;", "mutation$delegate", "enabled", "Lkotlinx/coroutines/flow/StateFlow;", "", "getEnabled", "()Lkotlinx/coroutines/flow/StateFlow;", "saveEnabled", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f12616a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f12617b = null;
    private static final Lazy c = null;

    static {
        f12616a = new o();
        f12617b = LazyKt.lazy($$Lambda$o$aLvjCetiwt3XHv17x2KulUUHdy4.INSTANCE);
        c = LazyKt.lazy($$Lambda$o$zXLcyMMrDr8Dr6wVkp1EK75s0bo.INSTANCE);
    }

    private o() {
    }

    private static final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        l.f12612a.a();
    }

    private static final Unit b(boolean r2) {
        f12616a.c().save("recommend_cellular_enabled", r2);
        return Unit.INSTANCE;
    }

    private final IStore c() {
        return (IStore) ZeusTransformUtils.preCheckCast(f12617b.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private static final Unit c(boolean r2) {
        com.obric.memorydata.recommend.screenshotupload.e.f12556a.b(r2, p.f12618a.a()).a();
        return Unit.INSTANCE;
    }

    private final n d() {
        return (n) ZeusTransformUtils.preCheckCast(c.getValue(), n.class, "com.obric.memorydata.plugin");
    }

    private static final IStore e() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), "recommend_store", 0, 2, null);
    }

    private static final n f() {
        return new n(f12616a.c().getBoolean("recommend_cellular_enabled", false), $$Lambda$o$AZmnG9YKCRMgFGdKvqyzrlLhDA.INSTANCE, $$Lambda$o$1F72tzyAnqeHsRSI2MzgxwMhm4w.INSTANCE, $$Lambda$o$fw2rFmSYyrGQSx3pNuErJ1SM4_E.INSTANCE);
    }

    public static /* synthetic */ Unit lambda$1F72tzyAnqeHsRSI2MzgxwMhm4w(boolean r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$AZmnG-9YKCRMgFGdKvqyzrlLhDA, reason: not valid java name */
    public static /* synthetic */ Unit m1133lambda$AZmnG9YKCRMgFGdKvqyzrlLhDA(boolean r0) {
        return b(r0);
    }

    public static /* synthetic */ IStore lambda$aLvjCetiwt3XHv17x2KulUUHdy4() {
        return e();
    }

    public static /* synthetic */ void lambda$fw2rFmSYyrGQSx3pNuErJ1SM4_E(String r0) {
        a(r0);
    }

    public static /* synthetic */ n lambda$zXLcyMMrDr8Dr6wVkp1EK75s0bo() {
        return f();
    }

    public final ar<Boolean> a() {
        return d().a();
    }

    public final void a(boolean r1) {
        d().a(r1);
    }

    public final boolean b() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(d().a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }
}
