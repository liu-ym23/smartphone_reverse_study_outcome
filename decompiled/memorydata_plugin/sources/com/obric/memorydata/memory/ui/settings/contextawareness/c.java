package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.recommend.IRecommendApi;
import com.obric.memorydata.recommend.RecommendApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0016\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001e\u001a\u00020\u0010J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u000e\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010J\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0010R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessEnhancedTimelinessSettings;", "", "<init>", "()V", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "recommendApi", "Lcom/obric/memorydata/recommend/IRecommendApi;", "getRecommendApi", "()Lcom/obric/memorydata/recommend/IRecommendApi;", "_cloudEnabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "cloudEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "getCloudEnabled", "()Lkotlinx/coroutines/flow/StateFlow;", "cloudSettingsChangeListener", "com/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessEnhancedTimelinessSettings$cloudSettingsChangeListener$1", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessEnhancedTimelinessSettings$cloudSettingsChangeListener$1;", "policy", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessEnhancedTimelinessPolicy;", "getPolicy", "()Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessEnhancedTimelinessPolicy;", "policy$delegate", "isPreferenceEnabled", "isCloudEnabled", "readCloudEnabled", "setPreferenceEnabled", "enabled", "refreshForLabVisibility", "labVisible", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11448a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f11449b = null;
    private static final ae<Boolean> c = null;
    private static final ar<Boolean> d = null;
    private static final a e = null;
    private static final Lazy f = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessEnhancedTimelinessSettings$cloudSettingsChangeListener$1", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "onSettingsChanged", "", "key", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements SettingsChangeListener {
        a() {
        }

        @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
        public void onSettingsChanged(String r3) {
            Intrinsics.checkNotNullParameter(r3, "key");
            if (Intrinsics.areEqual(r3, SettingsManager.KEY_COMMON_FEATURE_SETTINGS) == true) goto L5;
            return;
        L5:
            c.d().b(Boolean.valueOf(c.a(c.f11448a)));
            c.f11448a.b(((com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin")).c());
        }
    }

    static {
        c r0 = new c();
        f11448a = r0;
        f11449b = LazyKt.lazy($$Lambda$c$cfzpaXWeyUKHeMnJYWXRUMnLf0Q.INSTANCE);
        ae<Boolean> r1 = at.a(Boolean.valueOf(r0.h()));
        c = r1;
        d = (ar) ZeusTransformUtils.preCheckCast(r1, ar.class, "com.obric.memorydata.plugin");
        a r2 = new a();
        e = r2;
        f = LazyKt.lazy($$Lambda$c$YxQStZNZ4L3n9Df053KUU4CrDiE.INSTANCE);
        SettingsManager.INSTANCE.registerChangeListener(SettingsManager.KEY_COMMON_FEATURE_SETTINGS, (SettingsChangeListener) ZeusTransformUtils.preCheckCast(r2, SettingsChangeListener.class, "com.obric.memorydata.plugin"));
    }

    private c() {
    }

    public static final /* synthetic */ boolean a(c r0) {
        return r0.h();
    }

    private static final Unit c(boolean r2) {
        f11448a.e().save("context_awareness_enhanced_timeliness_enabled", r2);
        return Unit.INSTANCE;
    }

    private static final Unit d(boolean r2) {
        f11448a.e().save("context_awareness_enhanced_timeliness_effective", r2);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ ae d() {
        return c;
    }

    private final IStore e() {
        return (IStore) ZeusTransformUtils.preCheckCast(f11449b.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private final IRecommendApi f() {
        return (IRecommendApi) ZeusTransformUtils.preCheckCast(RecommendApi.INSTANCE, IRecommendApi.class, "com.obric.memorydata.plugin");
    }

    private final b g() {
        return (b) ZeusTransformUtils.preCheckCast(f.getValue(), b.class, "com.obric.memorydata.plugin");
    }

    private final boolean h() {
        return AppSettingsManager.INSTANCE.getCommonFeatureSettings().getEnableContextAwarenessEnhancedTimeliness();
    }

    private static final IStore i() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    private static final boolean j() {
        return f11448a.e().getBoolean("context_awareness_enhanced_timeliness_enabled", false);
    }

    private static final boolean k() {
        return f11448a.e().getBoolean("context_awareness_enhanced_timeliness_effective", false);
    }

    private static final b l() {
        return new b($$Lambda$c$tnhoksI7N6VaRSOkB_A5wTR8moY.INSTANCE, $$Lambda$c$kk3PyId3P2UCjafAjnDgTiap4.INSTANCE, $$Lambda$c$TQoctaXxsTXfOMzQvKN0LgWwRf0.INSTANCE, $$Lambda$c$2Q5TkGvhzuDksWnYlYzlCtZ3eIE.INSTANCE, (Function0) ZeusTransformUtils.preCheckCast(new ContextAwarenessEnhancedTimelinessSettings$policy$2$5(f11448a.f()), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Unit lambda$2Q5TkGvhzuDksWnYlYzlCtZ3eIE(boolean r0) {
        return d(r0);
    }

    public static /* synthetic */ boolean lambda$TQoctaXxsTXfOMzQvKN0LgWwRf0() {
        return k();
    }

    public static /* synthetic */ b lambda$YxQStZNZ4L3n9Df053KUU4CrDiE() {
        return l();
    }

    public static /* synthetic */ IStore lambda$cfzpaXWeyUKHeMnJYWXRUMnLf0Q() {
        return i();
    }

    /* JADX INFO: renamed from: lambda$kk3PyId3P2UCjafAjnDg--Tiap4, reason: not valid java name */
    public static /* synthetic */ Unit m988lambda$kk3PyId3P2UCjafAjnDgTiap4(boolean r0) {
        return c(r0);
    }

    public static /* synthetic */ boolean lambda$tnhoksI7N6VaRSOkB_A5wTR8moY() {
        return j();
    }

    public final ar<Boolean> a() {
        return d;
    }

    public final boolean a(boolean r5) {
        return g().a(r5, ((com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin")).c(), c());
    }

    public final boolean b() {
        return g().a();
    }

    public final boolean b(boolean r2) {
        return g().a(r2, c());
    }

    public final boolean c() {
        boolean r2 = h();
        c.b(Boolean.valueOf(r2));
        return r2;
    }
}
