package com.bytedance.android.live.openplatform.impl.miniappanchor.context;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcast.api.model.PreviewSourcePayLoad;
import com.bytedance.android.live.broadcast.api.model.b1;
import com.bytedance.android.live.broadcast.api.model.u0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.MiniAppMemoryApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.memory.MemoryContextService;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.config.zd0;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IStartLiveManager;
import com.bytedance.android.scope.m;
import e33.l;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import va1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001'B3\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0014J\u0006\u0010\r\u001a\u00020\tR$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/context/PreviewAnchorMiniAppContext;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/context/AnchorMiniAppContext;", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "previewSourceParam", "", "previewSourceMount", "isFromXingTu", "", "shootWay", "", "appendMpShootWayToPayload", "appendMountMigrateABInfoToPayLoad", "onCreate", "clearTalentPayload", "starOrderId", "Ljava/lang/String;", "getStarOrderId", "()Ljava/lang/String;", "setStarOrderId", "(Ljava/lang/String;)V", "isInLive", "Z", "()Z", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "getPreviewSourceParam", "()Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "getShootWay", "Ljo0/a;", "previewMiniAppWidget", "Ljo0/a;", "getPreviewMiniAppWidget", "()Ljo0/a;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "containerView", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;Ljava/lang/String;Ljo0/a;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewAnchorMiniAppContext extends AnchorMiniAppContext {
    public static final a Companion = null;
    private static final String TAG = "PreviewAnchorMiniAppContext";
    private final boolean isInLive;
    private final jo0.a previewMiniAppWidget;
    private final PreviewSourceParam previewSourceParam;
    private final String shootWay;
    private String starOrderId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext, com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final jo0.a getPreviewMiniAppWidget() {
        return null;
    }

    private final void appendMountMigrateABInfoToPayLoad() {
        if (((Boolean) ud0.a.getValue()).booleanValue() == false) goto L14;
        Integer r0 = (Integer) zd0.a.getValue();
        if (r0 != null) goto L8;
    L10:
        PreviewSourceParam r1 = this.previewSourceParam;
        if (r1 == null) goto L15;
        r1.getPayLoadArray().a("open_platform", "microapp_list_up", "1");
        return;
    L15:
        return;
    L8:
        if (r0.intValue() != 1) goto L10;
        return;
    }

    private final boolean isFromXingTu() {
        PreviewSourceParam r0 = this.previewSourceParam;
        if (r0 == null) goto L10;
        String r1 = r0.getPayLoad();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (StringsKt.contains$default(r1, "star_app_id", false, 2, null) != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final void clearTalentPayload() {
        PreviewSourceParam r0 = this.previewSourceParam;
        if (r0 == null) goto L5;
        PreviewSourcePayLoad r1 = r0.getPayLoadArray();
    L6:
        if (r1 == null) goto L31;
        Map r2 = r1.a;
        if (r2 == null) goto L32;
        b1 r3 = (b1) ((LinkedHashMap) r2).get("open_platform");
        if (r3 == null) goto L33;
        Map r4 = r3.b;
        if (r4 != null) goto L14;
        return;
    L14:
        if (r4.containsKey("from_open_taskbox") != true) goto L35;
        b1 r5 = (b1) ((LinkedHashMap) r1.a).get("commerce");
        if (r5 == null) goto L20;
        Map r6 = r5.b;
        if (r6 == null) goto L20;
        String r7 = (String) r6.remove("star_order_id");
    L20:
        b1 r8 = (b1) ((LinkedHashMap) r1.a).get("commerce");
        if (r8 == null) goto L25;
        Map r9 = r8.b;
        if (r9 == null) goto L25;
        String r10 = (String) r9.remove("star_demand_id");
    L25:
        b1 r11 = (b1) ((LinkedHashMap) r1.a).get("open_platform");
        if (r11 == null) goto L36;
        Map r12 = r11.b;
        if (r12 == null) goto L37;
        String r13 = (String) r12.remove("from_open_taskbox");
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext, com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onCreate() {
        super.onCreate();
        qo0.a.c(TAG, "onCreate");
        l[] r0 = m13.a.a;
        m r1 = m.e;
        m13.a r2 = m13.a.b;
        r1.getClass();
        m.e(r2);
        appendMpShootWayToPayload(this.shootWay);
        appendMountMigrateABInfoToPayLoad();
        MemoryContextService r3 = (MemoryContextService) getService(MemoryContextService.class);
        r3.getClass();
        IBroadcastService r4 = (IBroadcastService) b.a.a.a(IBroadcastService.class);
        if (r4 == null) goto L7;
        IStartLiveManager r5 = r4.startLiveManager();
        if (r5 == null) goto L7;
        r5.registerPreStartLiveListener(r3);
    L7:
        ((MemoryContextService) getService(MemoryContextService.class)).f("");
        PreviewSourceParam r6 = this.previewSourceParam;
        if (r6 != null) goto L10;
    L11:
        MemoryContextService r7 = (MemoryContextService) getService(MemoryContextService.class);
        r7.getClass();
        qo0.a.c("MemoryContextService", "requestMemoryData begin");
        Lazy r8 = LiveOpenPlatformClient.c;
        r7.autoDispose(((MiniAppMemoryApi) LiveOpenPlatformClient.a.a().a(MiniAppMemoryApi.class)).getMemoryData().compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.openplatform.impl.miniappanchor.memory.a(r7), com.bytedance.android.live.openplatform.impl.miniappanchor.memory.b.a));
        return;
    L10:
        if (previewSourceMount(r6) == false) goto L11;
    }

    public final PreviewSourceParam getPreviewSourceParam() {
        return this.previewSourceParam;
    }

    public final String getShootWay() {
        return this.shootWay;
    }

    public final String getStarOrderId() {
        return this.starOrderId;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public boolean isInLive() {
        return this.isInLive;
    }

    private final void appendMpShootWayToPayload(String r4) {
        PreviewSourceParam r0 = this.previewSourceParam;
        if (r0 == null) goto L13;
        PreviewSourcePayLoad r1 = r0.getPayLoadArray();
        if (isFromXingTu() == false) goto L8;
        String r5 = "task_platform";
    L11:
        r1.a("open_platform", "mp_shoot_way", r5);
        return;
    L8:
        if (Intrinsics.areEqual(r4, "mp_record") == false) goto L10;
        r5 = "mp_record";
        goto L11
    L10:
        r5 = "direct_shoot";
        goto L11
    }

    private final boolean previewSourceMount(PreviewSourceParam r3) {
        b1 r0 = (b1) ((LinkedHashMap) r3.getPayLoadArray().a).get("commerce");
        if (r0 == null) goto L5;
        Object r1 = r0.a(String.class);
    L6:
        this.starOrderId = (String) r1;
        u0 r4 = r3.getOpenPlatform();
        if (r4 == null) goto L9;
        r4.h("mp_taskset_center");
        ((ExplainCardSettingContextService) getService(ExplainCardSettingContextService.class)).g(r4);
        appendMpShootWayToPayload("mp_record");
        return true;
    L9:
        return false;
    L5:
        r1 = "";
        goto L6
    }

    public final void setStarOrderId(String r1) {
        this.starOrderId = r1;
    }

    public PreviewAnchorMiniAppContext(Context r2, ViewGroup r3, PreviewSourceParam r4, String r5, jo0.a r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "shootWay");
        Intrinsics.checkNotNullParameter(r6, "previewMiniAppWidget");
        super(r2, null, r3);
        this.previewSourceParam = r4;
        this.shootWay = r5;
    }
}
