package com.obric.memorydata.memory.ui.settings.contextawareness;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.obric.aiproactive.api.DoubaoGlassesConnectionState;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.recommend.IRecommendApi;
import com.obric.memorydata.recommend.RecommendApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 62\u00020\u0001:\u00016B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00100\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u000204H\u0002J\u0018\u00105\u001a\u00020\u000e2\u0006\u00103\u001a\u0002042\u0006\u0010$\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u00067"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/DefaultContextAwarenessSettingsGateway;", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsGateway;", "contentResolver", "Landroid/content/ContentResolver;", "recommendApi", "Lcom/obric/memorydata/recommend/IRecommendApi;", "memorySettingsStore", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore;", "settingsStore", "Lcom/obric/memorydata/middleware/api/store/IStore;", "<init>", "(Landroid/content/ContentResolver;Lcom/obric/memorydata/recommend/IRecommendApi;Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore;Lcom/obric/memorydata/middleware/api/store/IStore;)V", "screenContentVisible", "Lkotlinx/coroutines/flow/StateFlow;", "", "getScreenContentVisible", "()Lkotlinx/coroutines/flow/StateFlow;", "screenContentEnabled", "getScreenContentEnabled", "ambientVoiceVisible", "getAmbientVoiceVisible", "ambientVoiceEnabled", "getAmbientVoiceEnabled", "cellularUploadEnabled", "getCellularUploadEnabled", "enhancedTimelinessCloudEnabled", "getEnhancedTimelinessCloudEnabled", "smartGlassesConnected", "Lkotlinx/coroutines/flow/Flow;", "getSmartGlassesConnected", "()Lkotlinx/coroutines/flow/Flow;", "readSnapshot", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsSnapshot;", "setSystemAppEnabled", "app", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSystemApp;", "enabled", "setGlobalSourceEnabled", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessGlobalSource;", "setCellularUploadEnabled", "", "setEnhancedTimelinessEnabled", "setRecorderAmbientVoiceCollectionDebugEnabled", "openScreenContentSettings", "context", "Landroid/content/Context;", "openRecorderSettings", "openSmartGlassesSettings", "openBlockMemorySettings", "readGlobalSetting", "key", "", "writeGlobalSetting", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f11462a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContentResolver f11463b;
    private final IRecommendApi c;
    private final com.obric.memorydata.memory.ui.settings.l d;
    private final IStore e;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/DefaultContextAwarenessSettingsGateway$Companion;", "", "<init>", "()V", "DISABLED_INT", "", "RECORDER_PACKAGE_NAME", "", "RECORDER_SETTINGS_ACTIVITY", "OBRIC_DORA_ENV_OBSERVE_BRIDGE_ACTIVITY", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11462a = new a(null);
    }

    public n() {
        this(null, null, null, null, 15, null);
    }

    public n(ContentResolver r3, IRecommendApi r4, com.obric.memorydata.memory.ui.settings.l r5, IStore r6) {
        IRecommendApi r7 = (IRecommendApi) ZeusTransformUtils.wrapperContextForParams(r4, IRecommendApi.class, "com.obric.memorydata.plugin");
        IStore r8 = (IStore) ZeusTransformUtils.wrapperContextForParams(r6, IStore.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "contentResolver");
        Intrinsics.checkNotNullParameter(r7, "recommendApi");
        Intrinsics.checkNotNullParameter(r5, "memorySettingsStore");
        Intrinsics.checkNotNullParameter(r8, "settingsStore");
        this.f11463b = r3;
        this.c = r7;
        this.d = r5;
        this.e = r8;
    }

    public /* synthetic */ n(ContentResolver r3, IRecommendApi r4, com.obric.memorydata.memory.ui.settings.l r5, IStore r6, int r7, DefaultConstructorMarker r8) {
        IRecommendApi r9 = (IRecommendApi) ZeusTransformUtils.wrapperContextForParams(r4, IRecommendApi.class, "com.obric.memorydata.plugin");
        IStore r10 = (IStore) ZeusTransformUtils.wrapperContextForParams(r6, IStore.class, "com.obric.memorydata.plugin");
        if ((r7 & 1) == 0) goto L6;
        r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
    L6:
        if ((r7 & 2) == 0) goto L9;
        r9 = (IRecommendApi) ZeusTransformUtils.preCheckCast(RecommendApi.INSTANCE, IRecommendApi.class, "com.obric.memorydata.plugin");
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = com.obric.memorydata.memory.ui.settings.l.f11479a.a();
    L12:
        if ((r7 & 8) == 0) goto L14;
        r10 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    L14:
        this(r3, r9, r5, r10);
    }

    private final boolean a(String r2) {
        return this.e.getBoolean(r2, false);
    }

    private final boolean a(String r2, boolean r3) {
        this.e.save(r2, r3);
        if (a(r2) != r3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public ar<Boolean> a() {
        return this.d.k();
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.c.openRecommendMemorySettings(r4);
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public void a(boolean r1) {
        this.c.saveScreenObservationCellularEnabled(r1);
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public boolean a(ContextAwarenessGlobalSource r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        return a(h.f11453a.a(r2), r3);
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public boolean a(ContextAwarenessSystemApp r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "app");
        return a(h.f11453a.a(r2), r3);
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public ar<Boolean> b() {
        return this.c.screenObservationEnabled();
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public boolean b(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        com.obric.memorydata.memory.utils.f r5 = com.obric.memorydata.memory.utils.f.f11537a;
        Intent r0 = new Intent().setClassName("com.obric.recorder", "com.bytedanceos.recorder.settings.RecorderAlwaysOnSettingsActivity");
        Intrinsics.checkNotNullExpressionValue(r0, "setClassName(...)");
        return r5.a(r3, r0);
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public boolean b(boolean r1) {
        return c.f11448a.a(r1);
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public ar<Boolean> c() {
        return this.d.l();
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public boolean c(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        com.obric.memorydata.memory.utils.f r5 = com.obric.memorydata.memory.utils.f.f11537a;
        Intent r0 = new Intent().setClassName(r3.getPackageName(), "com.obric.assistant.dora.ObricDoraEnvObserveBridgeActivity");
        Intrinsics.checkNotNullExpressionValue(r0, "setClassName(...)");
        return r5.a(r3, r0);
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public boolean c(boolean r1) {
        return com.obric.memorydata.memory.review.c.f10378a.a(r1);
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public ar<Boolean> d() {
        return this.d.d();
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public void d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.c.openBlockMemorySettings(r4);
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public ar<Boolean> e() {
        return this.c.screenObservationCellularEnabled();
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public ar<Boolean> f() {
        return c.f11448a.a();
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public kotlinx.coroutines.flow.i<Boolean> g() {
        return kotlinx.coroutines.flow.k.b((Function2) ZeusTransformUtils.preCheckCast(new DefaultContextAwarenessSettingsGateway$smartGlassesConnected$1(null), Function2.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.memory.ui.settings.contextawareness.f
    public i h() {
        boolean r5 = ((Boolean) ZeusTransformUtils.preCheckCast(a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(c().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        boolean r4 = false;
        if (Settings.Global.getInt(this.f11463b, "recorder_always_on_enable", 0) == 0) goto L5;
        r4 = true;
    L5:
        com.obric.memorydata.memory.ui.settings.contextawareness.a r8 = new com.obric.memorydata.memory.ui.settings.contextawareness.a(r4);
        boolean r9 = DoubaoGlassesConnectionState.INSTANCE.hasEverConnected();
        boolean r21 = DoubaoGlassesConnectionState.INSTANCE.isConnected();
        boolean r22 = com.obric.memorydata.memory.glasses.a.f10137a.a();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(ContextAwarenessSystemApp.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L10;
        Object r10 = r3.next();
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin");
        ContextAwarenessSystemApp r12 = (ContextAwarenessSystemApp) ZeusTransformUtils.preCheckCast(r10, ContextAwarenessSystemApp.class, "com.obric.memorydata.plugin");
        r11.put(r10, Boolean.valueOf(a(h.f11453a.a(r12))));
        goto L7
    L10:
        return new i(r5, r6, r7, r8, r9, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin"), a("context_awareness_motion_state_enabled"), a("context_awareness_location_enabled"), a("context_awareness_notification_content_enabled"), a("context_awareness_device_state_enabled"), this.c.getScreenObservationCellularEnabled(), ((com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin")).c(), c.f11448a.c(), c.f11448a.b(), com.obric.memorydata.memory.review.c.f10378a.a(), com.obric.memorydata.memory.review.c.f10378a.b(), r21, r22);
    }
}
