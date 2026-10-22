package com.bytedance.android.live.openplatform.impl.base;

import android.content.Context;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.model.MemoryStatus;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.utils.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.openplatform.LiveOpenApiCallback;
import com.bytedance.live.datacontext.n;
import j70.h;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import jc1.k;
import ko0.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mh1.p;
import org.json.JSONObject;
import po0.e;
import w20.lc;
import yo0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000 n2\u00020\u0001:\u0001oB\u0007¢\u0006\u0004\bl\u0010mJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\fH\u0016J6\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\nH\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0006H\u0016J\"\u0010-\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016J\"\u00100\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010\u00062\u0006\u0010/\u001a\u00020\u001fH\u0016J\b\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\nH\u0016J \u00106\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004H\u0016J\n\u00108\u001a\u0004\u0018\u000107H\u0016J\u0018\u0010;\u001a\u00020\n2\u0006\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020\u001fH\u0016J\u0018\u0010=\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004H\u0016J\b\u0010>\u001a\u00020\nH\u0016J\b\u0010?\u001a\u00020\nH\u0016J\u001a\u0010B\u001a\u00020\n2\u0006\u0010@\u001a\u00020+2\b\u0010\t\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010B\u001a\u00020\n2\u0006\u0010@\u001a\u00020+2\b\u0010\t\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010D\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010AH\u0016J\u0012\u0010D\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010CH\u0016J\b\u0010E\u001a\u00020\nH\u0016J(\u0010I\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020+2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010GH\u0016J\b\u0010J\u001a\u00020\u001fH\u0016J\"\u0010O\u001a\u00020\n2\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u00042\b\u0010N\u001a\u0004\u0018\u00010MH\u0016J\u0018\u0010Q\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0016J\b\u0010R\u001a\u00020\nH\u0016J\b\u0010S\u001a\u00020\nH\u0016J\b\u0010T\u001a\u00020+H\u0016J\b\u0010U\u001a\u00020\nH\u0016J\u001a\u0010W\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010VH\u0016J\u0016\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010XH\u0016J\u001e\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020[\u0018\u00010X2\u0006\u0010Z\u001a\u00020+H\u0016R0\u0010_\u001a\u0004\u0018\u00010]2\n\b\u0001\u0010^\u001a\u0004\u0018\u00010]8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR.\u0010f\u001a\u0004\u0018\u00010e2\b\u0010^\u001a\u0004\u0018\u00010e8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k¨\u0006p"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/OpenPlatformAnchorServiceImpl;", "Lcom/bytedance/android/live/openplatform/api/IOpenPlatformAnchorService;", "Lko0/c;", "getMiniAppLiveCastEntranceInfo", "", "appId", "Lorg/json/JSONObject;", "params", "Lcom/bytedance/android/livesdkapi/openplatform/LiveOpenApiCallback;", "callback", "", "invokeLiveOpenApi", "Lj70/h;", "Lh70/b;", "getAnchorMiniAppWidgetDescriptor", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "containerView", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "previewSourceParam", "shootWay", "Ljo0/a;", "previewMiniAppWidget", "Landroidx/lifecycle/LifecycleObserver;", "getPreviewMiniAppWidgetLifecycleObserver", "schema", "Lko0/b;", "launchParams", "openMiniApp", "openLiveCastingMiniApp", "", "isMiniAppMounted", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo", "mount", "unmount", "getPreviewStarOrderId", "mountData", "openExplainCardSettingDialog", "success", "Landroid/view/Surface;", "surface", "", "fps", "notifyMiniAppStartLinkCastResult", "param", "clearSwitchingLock", "notifyMiniAppStopLinkCastResult", "openShelfManagementPage", "clickAnchorToolbarMiniApp", "mpId", "enterPosition", "exitSource", "reportExitMpBind", "Lcom/bytedance/android/live/openplatform/api/model/MemoryStatus;", "getMemoryStatus", "which", "remember", "updateMemoryStatus", "source", "reportDefaultOpenFirstExplainCardOn", "reportMpShow", "reportMpClick", "newScene", "Lcom/bytedance/android/live/openplatform/api/IOpenPlatformAnchorService$a;", "pauseLinkCastWhenSceneSwitched", "Lcom/bytedance/android/live/openplatform/api/IMiddlewareOpenPlatformAnchorService$a;", "resumeLinkCastWhenSceneSwitched", "closeShelfManagementPage", "scene", "", "appIdList", "openCouponPage", "isMorePanelMiniAppRedDotShowing", "clickSource", "liveType", "Lmh1/p;", "miniAppOuterHelper", "openChoosePage", "type", "reportBubbleShow", "recordSnowFlakeShown", "recordMorePanelSnowFlakeShown", "getCoexistComponent", "clearLocalKVCache", "Lw20/lc$a;", "openLiveMicroApp", "", "getCommonEventParams", "cardType", "", "getMiniAppCommonCardExtraParams", "Lso0/a;", "<set-?>", "miniAppAnchorService", "Lso0/a;", "getMiniAppAnchorService", "()Lso0/a;", "setMiniAppAnchorService", "(Lso0/a;)V", "Lyo0/b;", "openApiService", "Lyo0/b;", "getOpenApiService", "()Lyo0/b;", "setOpenApiService", "(Lyo0/b;)V", "<init>", "()V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OpenPlatformAnchorServiceImpl implements IOpenPlatformAnchorService {
    public static final a Companion = null;
    private static final e diComponent = null;
    private so0.a miniAppAnchorService;
    private yo0.b openApiService;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements yo0.a.InterfaceC0296a {
        public final /* synthetic */ LiveOpenApiCallback a;

        public b(LiveOpenApiCallback r1) {
            this.a = r1;
        }

        @Override // yo0.a.InterfaceC0296a
        public final void a(d r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            this.a.onError(r3.b, r3.a());
        }

        @Override // yo0.a.InterfaceC0296a
        public final void b(d r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a.onSuccess(r2.a());
        }
    }

    static {
        Companion = new a();
        diComponent = po0.a.a();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void clearLocalKVCache() {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.M3;
        Boolean r1 = Boolean.TRUE;
        r0.getClass();
        f.d(r0, r1);
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.b.L3;
        r2.getClass();
        f.d(r2, 0);
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.O3;
        r3.getClass();
        f.d(r3, r1);
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.I3;
        r4.getClass();
        f.d(r4, r1);
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.b.J3;
        r5.getClass();
        f.d(r5, r1);
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.K3;
        r6.getClass();
        f.d(r6, r1);
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void clickAnchorToolbarMiniApp() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.clickAnchorToolbarMiniApp();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void closeShelfManagementPage() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.closeShelfManagementPage();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public h<? extends h70.b> getAnchorMiniAppWidgetDescriptor() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAnchorMiniAppWidgetDescriptor();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public int getCoexistComponent() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCoexistComponent();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public Map<String, String> getCommonEventParams() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCommonEventParams();
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public MemoryStatus getMemoryStatus() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMemoryStatus();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    public c getMiniAppLiveCastEntranceInfo() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMiniAppLiveCastEntranceInfo();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public String getPreviewStarOrderId() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPreviewStarOrderId();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public boolean isMiniAppMounted() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.e();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public boolean isMorePanelMiniAppRedDotShowing() {
        if (((Boolean) ud0.a.getValue()).booleanValue() == false) goto L22;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L11;
        n<MiniAppEntrancePermissionResponse> r1 = r0.getEntranceInfo();
        if (r1 == null) goto L11;
        MiniAppEntrancePermissionResponse r2 = (MiniAppEntrancePermissionResponse) r1.getValue();
        if (r2 == null) goto L11;
        boolean r3 = r2.getPermit();
    L12:
        if (r3 == true) goto L14;
        return false;
    L14:
        if (y3.l().n(ToolbarButton.OPEN_PLATFORM_MINI_APP) == true) goto L24;
        Integer r4 = (Integer) com.bytedance.android.livesdk.sharedpref.b.L3.getValue();
        if (r4 != null) goto L19;
        return false;
    L19:
        if (r4.intValue() != 0) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L11:
        r3 = false;
        goto L12
    L22:
        return false;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void openLiveCastingMiniApp() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.openLiveCastingMiniApp();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openShelfManagementPage() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.openShelfManagementPage();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void recordMorePanelSnowFlakeShown() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L9;
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L9;
        if (r1.isInLive() != true) goto L9;
        int r2 = 2;
    L10:
        int r3 = no0.a.a;
        no0.a.c(r2, 2, 1);
        return;
    L9:
        r2 = 1;
        goto L10
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void recordSnowFlakeShown() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L9;
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L9;
        OpenPlatformPerformanceReportService r2 = (OpenPlatformPerformanceReportService) r1.getService(OpenPlatformPerformanceReportService.class);
        if (r2 == null) goto L9;
        r2.k(true);
    L9:
        so0.a r3 = this.miniAppAnchorService;
        if (r3 == null) goto L16;
        OpenPlatformContext r4 = r3.a();
        if (r4 == null) goto L16;
        if (r4.isInLive() != true) goto L16;
        int r5 = 2;
    L17:
        int r6 = no0.a.a;
        no0.a.c(r5, 1, 1);
        return;
    L16:
        r5 = 1;
        goto L17
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportMpClick() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.reportMpClick();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportMpShow() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.reportMpShow();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void unmount() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.unmount();
        return;
    }

    public OpenPlatformAnchorServiceImpl() {
        po0.a.b r0 = (po0.a.b) diComponent;
        setMiniAppAnchorService((so0.a) r0.b.get());
        setOpenApiService((yo0.b) r0.c.get());
        k.l(IOpenPlatformAnchorService.class, this);
        v.a();
    }

    public static final /* synthetic */ e access$getDiComponent$cp() {
        return diComponent;
    }

    public final so0.a getMiniAppAnchorService() {
        return this.miniAppAnchorService;
    }

    public final yo0.b getOpenApiService() {
        return this.openApiService;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    public Map<String, Object> getMiniAppCommonCardExtraParams(int r1) {
        so0.a r2 = this.miniAppAnchorService;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.c();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void mount(ShelfInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "shelfInfo");
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.mount(r2);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openExplainCardSettingDialog(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "mountData");
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.openExplainCardSettingDialog(r2);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void resumeLinkCastWhenSceneSwitched(IMiddlewareOpenPlatformAnchorService.a r2) {
        if ((r2 instanceof IOpenPlatformAnchorService.a) == false) goto L8;
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L9;
        r0.resumeLinkCastWhenSceneSwitched((IOpenPlatformAnchorService.a) r2);
        return;
    L9:
        return;
    }

    @Inject
    public final void setMiniAppAnchorService(so0.a r1) {
        this.miniAppAnchorService = r1;
    }

    @Inject
    public final void setOpenApiService(yo0.b r1) {
        this.openApiService = r1;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void resumeLinkCastWhenSceneSwitched(IOpenPlatformAnchorService.a r2) {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.resumeLinkCastWhenSceneSwitched(r2);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public void openLiveMicroApp(String r2, lc.a r3) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.openLiveMicroApp(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openMiniApp(String r2, ko0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "launchParams");
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.openMiniApp(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void pauseLinkCastWhenSceneSwitched(int r2, IMiddlewareOpenPlatformAnchorService.a r3) {
        if ((r3 instanceof IOpenPlatformAnchorService.a) == false) goto L8;
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L9;
        r0.pauseLinkCastWhenSceneSwitched(r2, (IOpenPlatformAnchorService.a) r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportBubbleShow(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "mpId");
        Intrinsics.checkNotNullParameter(r3, "type");
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.reportBubbleShow(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportDefaultOpenFirstExplainCardOn(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "mpId");
        Intrinsics.checkNotNullParameter(r3, "source");
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.reportDefaultOpenFirstExplainCardOn(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void updateMemoryStatus(int r2, boolean r3) {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.updateMemoryStatus(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void pauseLinkCastWhenSceneSwitched(int r2, IOpenPlatformAnchorService.a r3) {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.pauseLinkCastWhenSceneSwitched(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public void invokeLiveOpenApi(String r3, JSONObject r4, LiveOpenApiCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        yo0.b r0 = this.openApiService;
        if (r0 == null) goto L6;
        r0.c(r3, r4, new b(r5));
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void notifyMiniAppStartLinkCastResult(boolean r2, Surface r3, int r4) {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.notifyMiniAppStartLinkCastResult(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void notifyMiniAppStopLinkCastResult(boolean r2, JSONObject r3, boolean r4) {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.h(r2, r4, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openChoosePage(String r2, String r3, p r4) {
        Intrinsics.checkNotNullParameter(r2, "clickSource");
        Intrinsics.checkNotNullParameter(r3, "liveType");
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.openChoosePage(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openCouponPage(Context r2, int r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.openCouponPage(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportExitMpBind(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "mpId");
        Intrinsics.checkNotNullParameter(r3, "enterPosition");
        Intrinsics.checkNotNullParameter(r4, "exitSource");
        so0.a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.reportExitMpBind(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public LifecycleObserver getPreviewMiniAppWidgetLifecycleObserver(Context r2, ViewGroup r3, PreviewSourceParam r4, String r5, jo0.a r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "shootWay");
        Intrinsics.checkNotNullParameter(r6, "previewMiniAppWidget");
        so0.a r7 = this.miniAppAnchorService;
        if (r7 != null) goto L7;
        return null;
    L7:
        return r7.d(r2, r3, r4, r5);
    }
}
