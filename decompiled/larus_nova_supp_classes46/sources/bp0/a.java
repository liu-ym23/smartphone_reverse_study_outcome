package bp0;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcast.api.model.b1;
import com.bytedance.android.live.broadcast.api.model.u0;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.model.MemoryStatus;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.AnchorCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.MiniAppChooseTalentSettingUtil;
import com.bytedance.android.live.openplatform.impl.miniappanchor.context.PreviewAnchorMiniAppContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.coupon.AnchorCouponContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.launch.LiveAnchorLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.launch.PreviewAnchorLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.memory.MemoryContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.widget.PreviewMiniAppWidgetDelegate;
import com.bytedance.android.live.openplatform.impl.miniappcommon.applog.MiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.launch.CommonLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.launch.LaunchContextService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.l90;
import com.bytedance.android.livesdk.config.m90;
import com.bytedance.android.livesdk.config.tc1;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import cp0.d;
import cp0.e;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import jc1.k;
import ko0.c;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import mh1.p;
import org.json.JSONArray;
import org.json.JSONObject;
import w20.lc;
import zo0.f;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements so0.a {
    public OpenPlatformContext a;

    /* JADX INFO: renamed from: bp0.a$a, reason: collision with other inner class name */
    public static final class C0006a {
    }

    static {
    }

    public a() {
    }

    @Override // uo0.a
    public final Map c() {
        LinkedHashMap r0 = new LinkedHashMap();
        int r2 = 0;
        if (getMemoryStatus().c != 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
    L10:
        r0.put("show_live_data", Integer.valueOf(r2));
        IHostContext r3 = k.f(IHostContext.class);
        if (r3 != null) goto L13;
    L15:
        return r0;
    L13:
        if (r3.isOpSandboxDevMode() != true) goto L15;
        r0.put("is_sandbox_dev_mode", "1");
        goto L15
    L8:
        if (((uc1) ee0.a.getValue()).t() != 2) goto L10;
        r2 = 1;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @Override // so0.a
    public final void clickAnchorToolbarMiniApp() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AnchorShelfContextService r1 = (AnchorShelfContextService) r0.getService(AnchorShelfContextService.class);
        if (r1 == null) goto L9;
        r1.clickAnchorToolbarMiniApp();
        return;
    L9:
        return;
    }

    @Override // so0.a
    public final void closeShelfManagementPage() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AnchorShelfContextService r1 = (AnchorShelfContextService) r0.getService(AnchorShelfContextService.class);
        if (r1 == null) goto L9;
        r1.closeShelfManagementPage();
        return;
    L9:
        return;
    }

    @Override // so0.a
    public final boolean e() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L7;
        AnchorShelfContextService r1 = (AnchorShelfContextService) r0.getService(AnchorShelfContextService.class);
        if (r1 == null) goto L7;
        return r1.isMounted();
    L7:
        return false;
    }

    @Override // so0.a
    public final eq0.a getAnchorMiniAppWidgetDescriptor() {
        return new eq0.a();
    }

    @Override // so0.a
    public final int getCoexistComponent() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L30;
        m r2 = null;
        if (r0.isInLive() == false) goto L25;
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r1 = MiniAppDataContext.a.b();
        if (r1 != null) goto L32;
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r3 == null) goto L15;
        j r4 = r3.getCompactTbLoader();
        if (r4 == null) goto L15;
        m r5 = (m) r4.getValue();
    L17:
        if ((r5 instanceof m) == false) goto L20;
        r2 = r5;
    L20:
        if (r2 == null) goto L30;
        if (r2.isComponentShowing(1) != true) goto L30;
        return 1;
    L15:
        r5 = null;
        goto L17
    L32:
        return r1.coexistRoom;
    L25:
        if ((r0 instanceof PreviewAnchorMiniAppContext) == true) goto L27;
        r0 = null;
    L27:
        PreviewAnchorMiniAppContext r6 = (PreviewAnchorMiniAppContext) r0;
        if (r6 == null) goto L30;
        r6.getPreviewMiniAppWidget();
    L30:
        return 0;
    }

    @Override // uo0.a
    public final Map<String, String> getCommonEventParams() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L7;
        MiniAppAppLogContextService r1 = (MiniAppAppLogContextService) r0.getService(MiniAppAppLogContextService.class);
        if (r1 == null) goto L7;
        return r1.getCommonEventParams();
    L7:
        return null;
    }

    @Override // so0.a
    public final MemoryStatus getMemoryStatus() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L9;
        MemoryContextService r1 = (MemoryContextService) r0.getService(MemoryContextService.class);
        if (r1 == null) goto L9;
        MemoryStatus r2 = r1.a;
        if (r2 == null) goto L9;
        return r2;
    L9:
        return new MemoryStatus(0);
    }

    @Override // uo0.a
    public final c getMiniAppLiveCastEntranceInfo() {
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L25;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L25;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L25;
        ShelfMicroAppInfo r3 = r2.appInfo;
        if (r3 == null) goto L25;
        String r4 = r3.appId;
        String r5 = "";
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        String r6 = r3.name;
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        ImageModel r7 = r3.icon;
        if (r7 == null) goto L27;
        List r8 = r7.getUrls();
        if (r8 == null) goto L27;
        String r9 = (String) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L27;
        r5 = r9;
    L27:
        return new c(r4, r6, r5);
    L25:
        return null;
    }

    @Override // so0.a
    public final String getPreviewStarOrderId() {
        OpenPlatformContext r0 = this.a;
        if ((r0 instanceof PreviewAnchorMiniAppContext) == true) goto L5;
        r0 = null;
    L5:
        PreviewAnchorMiniAppContext r1 = (PreviewAnchorMiniAppContext) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getStarOrderId();
    }

    @Override // so0.a
    public final void openLiveCastingMiniApp() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        LiveAnchorLaunchContextService r1 = (LiveAnchorLaunchContextService) r0.getService(LiveAnchorLaunchContextService.class);
        if (r1 == null) goto L9;
        r1.openLiveCastingMiniApp();
        return;
    L9:
        return;
    }

    @Override // so0.a
    public final void openShelfManagementPage() {
        HashMap<String, f> r0 = g.a;
        f r1 = h.b(PerformanceScene.SHELF_MANAGEMENT_PAGE);
        r1.o();
        h.a(r1, "take_page_miniapp");
        OpenPlatformContext r2 = this.a;
        if (r2 == null) goto L14;
        AnchorShelfContextService r3 = (AnchorShelfContextService) r2.getService(AnchorShelfContextService.class);
        if (r3 == null) goto L15;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r4 = AnchorMiniAppDataContext.a.a();
        if (r4 == null) goto L11;
        n<ShelfInfo> r5 = r4.m618getShelfInfo();
        if (r5 == null) goto L11;
        ShelfInfo r6 = (ShelfInfo) r5.getValue();
    L12:
        AnchorShelfContextService.openShelfManagementPage$default(r3, r6, null, 2, null);
        return;
    L11:
        r6 = null;
        goto L12
    L15:
        return;
    }

    @Override // so0.a
    public final void reportMpClick() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L19;
        AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r0.getService(AnchorMiniAppAppLogContextService.class);
        if (r1 == null) goto L20;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r2 = AnchorMiniAppDataContext.a.a();
        if (r2 == null) goto L16;
        n<ShelfInfo> r3 = r2.m618getShelfInfo();
        if (r3 == null) goto L16;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L16;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L16;
        String r6 = r5.appId;
        if (r6 == null) goto L16;
    L17:
        r1.reportMpClick(r6, "shelf_show_page");
        return;
    L16:
        r6 = "";
        goto L17
    L20:
        return;
    }

    @Override // so0.a
    public final void reportMpShow() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L19;
        AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r0.getService(AnchorMiniAppAppLogContextService.class);
        if (r1 == null) goto L20;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r2 = AnchorMiniAppDataContext.a.a();
        if (r2 == null) goto L16;
        n<ShelfInfo> r3 = r2.m618getShelfInfo();
        if (r3 == null) goto L16;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L16;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L16;
        String r6 = r5.appId;
        if (r6 == null) goto L16;
    L17:
        r1.reportMpShow(r6, "shelf_show_page");
        return;
    L16:
        r6 = "";
        goto L17
    L20:
        return;
    }

    @Override // so0.a
    public final void unmount() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AnchorShelfContextService r1 = (AnchorShelfContextService) r0.getService(AnchorShelfContextService.class);
        if (r1 == null) goto L9;
        AnchorShelfContextService.offShelf$default(r1, null, null, 3, null);
        return;
    L9:
        return;
    }

    @Override // uo0.a
    public final OpenPlatformContext a() {
        return this.a;
    }

    @Override // uo0.a
    public final void b(OpenPlatformContext r1) {
        this.a = r1;
    }

    @Override // so0.a
    public final void mount(ShelfInfo r9) {
        Intrinsics.checkNotNullParameter(r9, "shelfInfo");
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AnchorShelfContextService r1 = (AnchorShelfContextService) r0.getService(AnchorShelfContextService.class);
        if (r1 == null) goto L9;
        AnchorShelfContextService.modifyShelf$default(r1, r9, false, null, null, 14, null);
        return;
    L9:
        return;
    }

    @Override // so0.a
    public final void openExplainCardSettingDialog(JSONObject r12) {
        Intrinsics.checkNotNullParameter(r12, "mountData");
        int r0 = qo0.a.a;
        qo0.a.c("MiniAppAnchorServiceImpl", "openExplainCardSettingDialog, params = " + r12);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl((u0) GsonHelper.get().fromJson(r12.optString("open_platform"), u0.class));     // Catch: Throwable -> L5
    L7:
        OpenPlatformContext r3 = null;
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        u0 r4 = (u0) r2;
        if (r4 != null) goto L13;
        return;
    L13:
        r4.h("taskset");
        OpenPlatformContext r5 = this.a;
        if (r5 != null) goto L16;
    L17:
        OpenPlatformContext r6 = this.a;
        if ((r6 instanceof PreviewAnchorMiniAppContext) == true) goto L20;
        r6 = null;
    L20:
        PreviewAnchorMiniAppContext r7 = (PreviewAnchorMiniAppContext) r6;
        if (r7 == null) goto L59;
        PreviewSourceParam r8 = r7.getPreviewSourceParam();
        if (r8 == null) goto L62;
        String r13 = r12.optString("payload");
        List r9 = (List) GsonProtectorUtils.fromJson(GsonHelper.get(), r13, new b().getType());
        if (r9 == null) goto L34;
        IntIterator r10 = CollectionsKt.getIndices(r9).iterator();
    L29:
        if (r10.hasNext() == false) goto L34;
        int r11 = r10.nextInt();
        List r14 = (List) ListProtector.get(r9, r11);
        r8.getPayLoadArray().a(ListProtector.get(r14, 0).toString(), ListProtector.get(r14, 1).toString(), ListProtector.get(r14, 2));     // Catch: ArrayIndexOutOfBoundsException -> L33
    L33:
        int r15 = qo0.a.a;
        qo0.a.b("ExplainCardSettingContextService", "get item error:index[" + r11 + "] for " + r13, null);
    L34:
        OpenPlatformContext r16 = this.a;
        if ((r16 instanceof PreviewAnchorMiniAppContext) == false) goto L38;
        r3 = r16;
    L38:
        PreviewAnchorMiniAppContext r17 = (PreviewAnchorMiniAppContext) r3;
        if (r17 == null) goto L45;
        b1 r18 = (b1) ((LinkedHashMap) r8.getPayLoadArray().a).get("commerce");
        if (r18 == null) goto L43;
        Object r19 = r18.a(String.class);
    L44:
        r17.setStarOrderId((String) r19);
        goto L45
    L43:
        r19 = "";
    L45:
        OpenPlatformContext r110 = this.a;
        if (r110 == null) goto L60;
        ExplainCardSettingContextService r111 = (ExplainCardSettingContextService) r110.getService(ExplainCardSettingContextService.class);
        if (r111 == null) goto L61;
        r111.g(r4);
        return;
    L61:
        return;
    L60:
        return;
    L62:
        return;
    L59:
        return;
    L16:
        if (r5.isInLive() == true) goto L45;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // so0.a
    public final void resumeLinkCastWhenSceneSwitched(IOpenPlatformAnchorService.a r11) {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L64;
        AnchorCastContextService r1 = (AnchorCastContextService) r0.getService(AnchorCastContextService.class);
        if (r1 != null) goto L7;
        return;
    L7:
        if (((AnchorShelfContextService) r1.getOpenPlatformContext().getService(AnchorShelfContextService.class)).isMounted() == true) goto L11;
        qo0.a.c("AnchorCastContextService", "resumeLinkCastWhenSceneSwitched no app mounted");
        if (r11 == null) goto L67;
        r11.a();
        return;
    L67:
        return;
    L11:
        dp0.a r2 = r1.g();
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r3 = AnchorMiniAppDataContext.a.a();
        String r4 = null;
        if (r3 == null) goto L20;
        n<ShelfInfo> r5 = r3.m618getShelfInfo();
        if (r5 == null) goto L20;
        ShelfInfo r6 = (ShelfInfo) r5.getValue();
        if (r6 == null) goto L20;
        ShelfMicroAppInfo r7 = r6.appInfo;
        if (r7 == null) goto L20;
        String r8 = r7.appId;
    L21:
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        d.a r9 = d.a;
        monitor-enter(d.class);
        Intrinsics.checkNotNullParameter(r8, "appId");     // Catch: Throwable -> L61
        Intrinsics.checkNotNullParameter(r2, "strategy");     // Catch: Throwable -> L61
        d.a r10 = d.a;     // Catch: Throwable -> L61
        if (r10 != null) goto L33;
        qo0.a.c("LiveCastSwitcher", "resume cast fail castConfigCache is null");     // Catch: Throwable -> L61
        if (r11 == null) goto L30;
        r11.a();     // Catch: Throwable -> L61
    L30:
        monitor-exit(d.class);
        return;
    L33:
        if ((!Intrinsics.areEqual(r8, r10.a)) == false) goto L43;
        StringBuilder r12 = new StringBuilder("resume cast fail appId:");     // Catch: Throwable -> L61
        r12.append(r8);     // Catch: Throwable -> L61
        r12.append(" not matched castConfig appId:");     // Catch: Throwable -> L61
        d.a r13 = d.a;     // Catch: Throwable -> L61
        if (r13 == null) goto L37;
        r4 = r13.a;     // Catch: Throwable -> L61
    L37:
        r12.append(r4);     // Catch: Throwable -> L61
        String r14 = r12.toString();     // Catch: Throwable -> L61
        if (r11 == null) goto L40;
        r11.a();     // Catch: Throwable -> L61
    L40:
        qo0.a.c("LiveCastSwitcher", r14);     // Catch: Throwable -> L61
        monitor-exit(d.class);
        return;
    L43:
        d.b r15 = d.b;     // Catch: Throwable -> L61
        if (r15 == null) goto L46;
        r15.b = r11;     // Catch: Throwable -> L61
        d.a r16 = d.a;     // Catch: Throwable -> L61
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L61
        int r17 = r16.b;     // Catch: Throwable -> L61
        d.a r18 = d.a;     // Catch: Throwable -> L61
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L61
        r2.h(r8, r17, r18.c, LinkScreenCastType.CAST_TYPE_MINI_APP, true);     // Catch: Throwable -> L61
        int r19 = qo0.a.a;     // Catch: Throwable -> L61
        StringBuilder r20 = new StringBuilder("resumeLinkCastWhenSceneSwitched appId:");     // Catch: Throwable -> L61
        r20.append(r8);     // Catch: Throwable -> L61
        r20.append(" cacheAppId:");     // Catch: Throwable -> L61
        d.a r21 = d.a;     // Catch: Throwable -> L61
        if (r21 == null) goto L54;
        String r22 = r21.a;     // Catch: Throwable -> L61
    L55:
        r20.append(r22);     // Catch: Throwable -> L61
        r20.append(" lockId:");     // Catch: Throwable -> L61
        d.b r23 = d.b;     // Catch: Throwable -> L61
        if (r23 == null) goto L58;
        r4 = r23.c;     // Catch: Throwable -> L61
    L58:
        r20.append(r4);     // Catch: Throwable -> L61
        qo0.a.c("LiveCastSwitcher", r20.toString());     // Catch: Throwable -> L61
        monitor-exit(d.class);
        return;
    L54:
        r22 = null;
        goto L55
    L46:
        if (r11 == null) goto L48;
        r11.a();     // Catch: Throwable -> L61
    L48:
        qo0.a.c("LiveCastSwitcher", "There is no pause lock object");     // Catch: Throwable -> L61
        monitor-exit(d.class);
        return;
    L61:
        th = move-exception;
        throw th;
    L20:
        r8 = null;
        goto L21
    }

    @Override // so0.a
    public final void i(String r3, ko0.b r4) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        Intrinsics.checkNotNullParameter(r4, "launchParams");
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        PreviewAnchorLaunchContextService r1 = (PreviewAnchorLaunchContextService) r0.getService(PreviewAnchorLaunchContextService.class);
        if (r1 == null) goto L9;
        r1.clickMiniApp(r3, r4);
        return;
    L9:
        return;
    }

    @Override // uo0.a
    public final void openLiveMicroApp(String r8, lc.a r9) {
        Intrinsics.checkNotNullParameter(r8, "schema");
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        CommonLaunchContextService r1 = (CommonLaunchContextService) r0.getService(CommonLaunchContextService.class);
        if (r1 == null) goto L9;
        CommonLaunchContextService.openMicroApp$default(r1, r8, r9, null, 4, null);
        return;
    L9:
        return;
    }

    @Override // so0.a
    public final void openMiniApp(String r8, ko0.b r9) {
        Intrinsics.checkNotNullParameter(r8, "schema");
        Intrinsics.checkNotNullParameter(r9, "launchParams");
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        LaunchContextService r1 = (LaunchContextService) r0.getService(LaunchContextService.class);
        if (r1 == null) goto L9;
        LaunchContextService.openMiniApp$default(r1, r8, r9, null, 4, null);
        return;
    L9:
        return;
    }

    @Override // so0.a
    public final void pauseLinkCastWhenSceneSwitched(int r9, IOpenPlatformAnchorService.a r10) {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L73;
        AnchorCastContextService r1 = (AnchorCastContextService) r0.getService(AnchorCastContextService.class);
        if (r1 != null) goto L7;
        return;
    L7:
        if (((AnchorShelfContextService) r1.getOpenPlatformContext().getService(AnchorShelfContextService.class)).isMounted() == true) goto L11;
        qo0.a.c("AnchorCastContextService", "pauseLinkCastWhenSceneSwitched no app mounted");
        if (r10 == null) goto L76;
        r10.a();
        return;
    L76:
        return;
    L11:
        int r2 = 0;
        if (r9 != 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        r2 = 8;
    L17:
        dp0.a r4 = r1.h(r2);
        boolean r5 = r4.a();
        int r6 = qo0.a.a;
        qo0.a.c("AnchorCastContextService", "pauseLinkCastWhenSceneSwitched newScene:" + r9 + " currentScene:" + ((IInteractService) k.n(IInteractService.class)).getCurrentScene() + " singleLiveRoom:" + r3 + " liveCasting:" + r5);
        if (r5 == true) goto L22;
        qo0.a.c("AnchorCastContextService", "no need to stop casting");
        if (r10 == null) goto L78;
        r10.a();
        return;
    L78:
        return;
    L22:
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r11 = AnchorMiniAppDataContext.a.a();
        String r7 = null;
        if (r11 == null) goto L31;
        n<ShelfInfo> r12 = r11.m618getShelfInfo();
        if (r12 == null) goto L31;
        ShelfInfo r13 = (ShelfInfo) r12.getValue();
        if (r13 == null) goto L31;
        ShelfMicroAppInfo r14 = r13.appInfo;
        if (r14 == null) goto L31;
        String r15 = r14.appId;
    L32:
        if (r15 != null) goto L34;
        r15 = "";
    L34:
        d.a r8 = d.a;
        monitor-enter(d.class);
        Intrinsics.checkNotNullParameter(r15, "appId");     // Catch: Throwable -> L70
        Intrinsics.checkNotNullParameter(r4, "oldStrategy");     // Catch: Throwable -> L70
        d.a r16 = d.a;     // Catch: Throwable -> L70
        if (r16 == null) goto L39;
        String r17 = r16.a;     // Catch: Throwable -> L70
    L41:
        if ((!Intrinsics.areEqual(r15, r17)) == false) goto L50;
        StringBuilder r18 = new StringBuilder("pauseLinkCastWhenSceneSwitched appId:");     // Catch: Throwable -> L70
        r18.append(r15);     // Catch: Throwable -> L70
        r18.append(" not matched castConfig appId:");     // Catch: Throwable -> L70
        d.a r19 = d.a;     // Catch: Throwable -> L70
        if (r19 == null) goto L45;
        r7 = r19.a;     // Catch: Throwable -> L70
    L45:
        r18.append(r7);     // Catch: Throwable -> L70
        qo0.a.c("LiveCastSwitcher", r18.toString());     // Catch: Throwable -> L70
        if (r10 == null) goto L48;
        r10.a();     // Catch: Throwable -> L70
    L48:
        monitor-exit(d.class);
        return;
    L50:
        d.b r20 = d.b;     // Catch: Throwable -> L70
        if (r20 == null) goto L60;
        String r21 = "lock object already exists:" + r20.c + " unlock it first";     // Catch: Throwable -> L70
        if (r21 != null) goto L55;
        r21 = "";
    L55:
        qo0.a.c("LiveCastSwitcher", r21);     // Catch: Throwable -> L70
        if (r10 == null) goto L58;
        r10.a();     // Catch: Throwable -> L70
    L58:
        monitor-exit(d.class);
        return;
    L60:
        d.b r22 = new d.b(UUID.randomUUID().toString());     // Catch: Throwable -> L70
        r22.a = r10;     // Catch: Throwable -> L70
        d.b = r22;     // Catch: Throwable -> L70
        r4.i(r15, LinkScreenCastType.CAST_TYPE_MINI_APP, true);     // Catch: Throwable -> L70
        StringBuilder r23 = new StringBuilder("pauseLinkCastWhenSceneSwitched appId:");     // Catch: Throwable -> L70
        r23.append(r15);     // Catch: Throwable -> L70
        r23.append(" cacheAppId:");     // Catch: Throwable -> L70
        d.a r24 = d.a;     // Catch: Throwable -> L70
        if (r24 == null) goto L63;
        String r25 = r24.a;     // Catch: Throwable -> L70
    L64:
        r23.append(r25);     // Catch: Throwable -> L70
        r23.append(" lockId:");     // Catch: Throwable -> L70
        d.b r26 = d.b;     // Catch: Throwable -> L70
        if (r26 == null) goto L67;
        r7 = r26.c;     // Catch: Throwable -> L70
    L67:
        r23.append(r7);     // Catch: Throwable -> L70
        qo0.a.c("LiveCastSwitcher", r23.toString());     // Catch: Throwable -> L70
        monitor-exit(d.class);
        return;
    L63:
        r25 = null;
        goto L64
    L39:
        r17 = null;
    L70:
        th = move-exception;
        throw th;
    L31:
        r15 = null;
        goto L32
    L14:
        r3 = false;
        goto L15
    }

    @Override // so0.a
    public final void reportBubbleShow(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "mpId");
        Intrinsics.checkNotNullParameter(r4, "type");
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r0.getService(AnchorMiniAppAppLogContextService.class);
        if (r1 == null) goto L9;
        r1.reportPageShelfBubblePush(r3, r4);
        return;
    L9:
        return;
    }

    @Override // so0.a
    public final void reportDefaultOpenFirstExplainCardOn(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "mpId");
        Intrinsics.checkNotNullParameter(r4, "source");
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r0.getService(AnchorMiniAppAppLogContextService.class);
        if (r1 == null) goto L9;
        r1.reportDefaultOpenFirstExplainCardOn(r3, r4);
        return;
    L9:
        return;
    }

    @Override // so0.a
    public final void updateMemoryStatus(int r3, boolean r4) {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        MemoryContextService r1 = (MemoryContextService) r0.getService(MemoryContextService.class);
        if (r1 == null) goto L9;
        r1.i(r3, r4);
        return;
    L9:
        return;
    }

    @Override // so0.a
    public final void h(boolean r5, boolean r6, JSONObject r7) {
        OpenPlatformContext r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((AnchorCastContextService) r0.getService(AnchorCastContextService.class)) == null) goto L53;
        int r1 = qo0.a.a;
        qo0.a.c("AnchorCastContextService", "notifyMiniAppStopLinkCastResult success:" + r5 + " clearSwitchingLock:" + r6 + " param:" + r7);
        if (r6 == false) goto L9;
        AnchorCastContextService.f();
    L9:
        d.a r8 = d.a;
        monitor-enter(d.class);
    L47:
        th = move-exception;
        throw th;
    L12:
        String r2 = null;
        if (d.b != null) goto L16;
        monitor-exit(d.class);
        boolean r9 = false;
    L30:
        if (r9 == false) goto L32;
        qo0.a.c("AnchorCastContextService", "LiveCastSwitcher customer stop result");
        return;
    L32:
        qo0.a.c("AnchorCastContextService", "dispatch MiniApp cast stop result");
        IHostLiveOpenPlatform r10 = TTLiveSDK.hostService().hostOpenPlatform();
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r3 = AnchorMiniAppDataContext.a.a();
        if (r3 == null) goto L41;
        n<ShelfInfo> r4 = r3.m618getShelfInfo();
        if (r4 == null) goto L41;
        ShelfInfo r11 = (ShelfInfo) r4.getValue();
        if (r11 == null) goto L41;
        ShelfMicroAppInfo r12 = r11.appInfo;
        if (r12 == null) goto L41;
        r2 = r12.appId;
    L41:
        if (r2 != null) goto L43;
        r2 = "";
    L43:
        Bundle r13 = new Bundle();
        r13.putBoolean("key_is_success", r5);
        if (r7 == null) goto L46;
        r13.putString("key_extra", r7.toString());
    L46:
        Unit r14 = Unit.INSTANCE;
        r10.dispatchStaticCommand(r2, "command_live_cast_stop", r13);
        return;
    L16:
        StringBuilder r15 = new StringBuilder("CustomerStopResult success:");     // Catch: Throwable -> L47
        r15.append(r5);     // Catch: Throwable -> L47
        r15.append(" extra:");     // Catch: Throwable -> L47
        r15.append(r7);     // Catch: Throwable -> L47
        r15.append(" lockId:");     // Catch: Throwable -> L47
        d.b r16 = d.b;     // Catch: Throwable -> L47
        if (r16 == null) goto L19;
        String r17 = r16.c;     // Catch: Throwable -> L47
    L20:
        r15.append(r17);     // Catch: Throwable -> L47
        qo0.a.c("LiveCastSwitcher", r15.toString());     // Catch: Throwable -> L47
        d.b r18 = d.b;     // Catch: Throwable -> L47
        if (r18 == null) goto L28;
        IOpenPlatformAnchorService.a r19 = r18.a;     // Catch: Throwable -> L47
        if (r19 == null) goto L28;
        if (r7 == null) goto L27;
        r7.toString();     // Catch: Throwable -> L47
    L27:
        r19.a();     // Catch: Throwable -> L47
    L28:
        monitor-exit(d.class);
        r9 = true;
        goto L30
    L19:
        r17 = null;
        goto L20
    }

    @Override // so0.a
    public final void notifyMiniAppStartLinkCastResult(boolean r9, Surface r10, int r11) {
        OpenPlatformContext r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L52;
        AnchorCastContextService r2 = (AnchorCastContextService) r0.getService(AnchorCastContextService.class);
        if (r2 == null) goto L52;
        int r3 = qo0.a.a;
        qo0.a.c("AnchorCastContextService", "notifyMiniAppStartLinkCastResult stack trace:" + Log.getStackTraceString(new Throwable()));
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r4 = AnchorMiniAppDataContext.a.a();
        if (r4 == null) goto L15;
        n<ShelfInfo> r5 = r4.m618getShelfInfo();
        if (r5 == null) goto L15;
        ShelfInfo r6 = (ShelfInfo) r5.getValue();
        if (r6 == null) goto L15;
        ShelfMicroAppInfo r7 = r6.appInfo;
        if (r7 == null) goto L15;
        String r8 = r7.appId;
    L16:
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        dp0.a r12 = r2.g();
        d.a r13 = d.a;
        monitor-enter(d.class);
        Intrinsics.checkNotNullParameter(r8, "appId");     // Catch: Throwable -> L49
        if (d.b != null) goto L24;
        monitor-exit(d.class);
        boolean r14 = false;
    L41:
        if (r14 == false) goto L43;
        qo0.a.c("AnchorCastContextService", "LiveCastSwitcher customer start result");
        goto L52
    L43:
        IHostLiveOpenPlatform r15 = TTLiveSDK.hostService().hostOpenPlatform();
        Bundle r16 = new Bundle();
        r16.putBoolean("key_is_success", r9);
        if (r10 == null) goto L46;
        r16.putParcelable("key_surface", r10);
    L46:
        if (r9 == true) goto L48;
        JSONObject r17 = new JSONObject();
        r17.put("errMsg", "start liveCast error");
        Unit r18 = Unit.INSTANCE;
        r16.putString("key_extra", r17.toString());
    L48:
        Unit r19 = Unit.INSTANCE;
        r15.dispatchStaticCommand(r8, "command_live_cast_start", r16);
        goto L52
    L24:
        StringBuilder r20 = new StringBuilder("shouldCustomerStartResult success:");     // Catch: Throwable -> L49
        r20.append(r9);     // Catch: Throwable -> L49
        r20.append(" surface:");     // Catch: Throwable -> L49
        r20.append(r10);     // Catch: Throwable -> L49
        r20.append(" lockId:");     // Catch: Throwable -> L49
        d.b r21 = d.b;     // Catch: Throwable -> L49
        if (r21 == null) goto L27;
        String r22 = r21.c;     // Catch: Throwable -> L49
    L28:
        r20.append(r22);     // Catch: Throwable -> L49
        qo0.a.c("LiveCastSwitcher", r20.toString());     // Catch: Throwable -> L49
        d.b r23 = d.b;     // Catch: Throwable -> L49
        if (r23 == null) goto L33;
        IOpenPlatformAnchorService.a r24 = r23.b;     // Catch: Throwable -> L49
        if (r24 == null) goto L33;
        r24.a();     // Catch: Throwable -> L49
    L33:
        com.bytedance.android.live.openplatform.impl.base.utils.m.f(Observable.create(new e(r8, r10)).subscribeOn(Schedulers.io()), null);     // Catch: Throwable -> L49
        ILiveMiniAppService r25 = k.f(ILiveMiniAppService.class);     // Catch: Throwable -> L49
        if (r25 != null) goto L36;
    L37:
        r12.e(r8, LinkScreenCastType.CAST_TYPE_MINI_APP, "liveRoom switched");     // Catch: Throwable -> L49
    L38:
        d.b = null;     // Catch: Throwable -> L49
        monitor-exit(d.class);
        r14 = true;
        goto L41
    L36:
        if (r25.getMiniAppActivityState() == true) goto L38;
    L27:
        r22 = null;
    L49:
        th = move-exception;
        throw th;
    L15:
        r8 = null;
    L52:
        if (r9 == false) goto L76;
        OpenPlatformContext r26 = this.a;
        if (r26 == null) goto L77;
        AnchorCastContextService r27 = (AnchorCastContextService) r26.getService(AnchorCastContextService.class);
        if (r27 == null) goto L78;
        if (r11 > 0) goto L59;
        return;
    L59:
        if (r27.g().a() == false) goto L80;
        IHostLiveOpenPlatform r28 = TTLiveSDK.hostService().hostOpenPlatform();
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r110 = AnchorMiniAppDataContext.a.a();
        if (r110 == null) goto L70;
        n<ShelfInfo> r111 = r110.m618getShelfInfo();
        if (r111 == null) goto L70;
        ShelfInfo r112 = (ShelfInfo) r111.getValue();
        if (r112 == null) goto L70;
        ShelfMicroAppInfo r113 = r112.appInfo;
        if (r113 == null) goto L70;
        r1 = r113.appId;
    L70:
        if (r1 != null) goto L72;
        r1 = "";
    L72:
        Bundle r114 = new Bundle();
        r114.putInt("key_fps", r11);
        Unit r115 = Unit.INSTANCE;
        r28.dispatchStaticCommand(r1, "command_live_cast_set_fps", r114);
        return;
    L80:
        return;
    L78:
        return;
    L77:
        return;
    }

    @Override // so0.a
    public final void openChoosePage(String r13, String r14, p r15) {
        Intrinsics.checkNotNullParameter(r13, "clickSource");
        Intrinsics.checkNotNullParameter(r14, "liveType");
        OpenPlatformContext r0 = this.a;
        Uri r2 = null;
        Object r3 = null;
        String r4 = "";
        if (r0 == null) goto L76;
        if (r0.isInLive() == true) goto L76;
        l90 r1 = l90.a;
        if (((tc1) r1.getValue()).a() != 1) goto L76;
        no0.a.b("lynx", "begin", "", null, "");
        ILiveActionHandler r16 = k.n(ILiveActionHandler.class);
        OpenPlatformContext r17 = this.a;
        if (r17 == null) goto L11;
        Context r18 = r17.getContext();
    L12:
        String r5 = ((tc1) r1.getValue()).b();
        if (r5 == null) goto L74;
        u6 r6 = new u6(r5);
        r6.b("settings_keys", "live_miniapp_talent_mount_module_show,live_miniapp_talent_mount_popup_show_number,live_mini_app_choose_lynx_task_url,live_mini_app_choose_lynx_config");
        r6.b("selected_tab_index", String.valueOf(MiniAppChooseTalentSettingUtil.a()));
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r7 = AnchorMiniAppDataContext.a.a();
        String r8 = "1";
        if (r7 == null) goto L42;
        n<MiniAppEntrancePermissionResponse> r9 = r7.getEntranceInfo();
        if (r9 == null) goto L42;
        MiniAppEntrancePermissionResponse r10 = (MiniAppEntrancePermissionResponse) r9.getValue();
        if (r10 == null) goto L42;
        Map r11 = r10.getUrl_list();
        if (r11 == null) goto L25;
        String r12 = (String) r11.get("help_url");
        if (r12 == null) goto L25;
    L26:
        r6.b("help_url", r12);
        if (r10.getShowIntroPanel() == false) goto L29;
        String r19 = "1";
    L30:
        r6.b("show_intro", r19);
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L33
        JSONObject r21 = new JSONObject();     // Catch: Throwable -> L33
        r21.put("permit", r10.getPermit());     // Catch: Throwable -> L33
        r21.put("intro_image_url", r10.getIntroImgUrl());     // Catch: Throwable -> L33
        r21.put("use_condition_info_list", new JSONArray(GsonHelper.getDefault().toJson(r10.getIntroInfo())));     // Catch: Throwable -> L33
        Object r22 = Result.constructor-impl(r21.toString());     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r22) == false) goto L38;
        r22 = null;
    L38:
        String r23 = (String) r22;
        if (r23 != null) goto L41;
        r23 = "";
    L41:
        r6.b("intro_info", r23);
        r6.b("permit_status", String.valueOf(r10.getPermitStatus()));
    L33:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L29:
        r19 = "0";
    L25:
        r12 = "";
    L42:
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r25 = AnchorMiniAppDataContext.a.a();
        if (r25 == null) goto L49;
        com.bytedance.live.datacontext.m<Boolean> r26 = r25.getSupportComponentCoexist();
        if (r26 == null) goto L49;
        if (((Boolean) r26.getValue()).booleanValue() != true) goto L49;
        String r27 = "1";
    L50:
        r6.b("support_coexist", r27);
        r6.b("coexist_type", String.valueOf(((IOpenPlatformAnchorService) k.n(IOpenPlatformAnchorService.class)).getCoexistComponent()));
        if (k.n(IHostContext.class).isOpSandboxDevMode() == true) goto L54;
        r8 = "0";
    L54:
        r6.b("is_sandbox_mode", r8);
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L63
        JSONObject r29 = new JSONObject();     // Catch: Throwable -> L63
        r29.put("live_type", r14);     // Catch: Throwable -> L63
        OpenPlatformContext r30 = this.a;     // Catch: Throwable -> L63
        if (r30 != null) goto L58;
    L60:
        String r31 = "before_live";
    L61:
        r29.put("live_status", r31);     // Catch: Throwable -> L63
        r29.put("tab_module", "bind_taskset");     // Catch: Throwable -> L63
        Object r110 = Result.constructor-impl(r29.toString());     // Catch: Throwable -> L63
    L66:
        if (Result.isFailure-impl(r110) == true) goto L69;
        r3 = r110;
    L69:
        String r32 = (String) r3;
        if (r32 == null) goto L73;
        r4 = r32;
    L73:
        r6.b("log_extra", r4);
        r6.b("error_page_theme", "light");
        r2 = r6.c();
        goto L74
    L58:
        if (r30.isInLive() != true) goto L60;
        r31 = "in_live";
    L63:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
    L49:
        r27 = "0";
    L74:
        r16.handle(r18, r2);
        return;
    L11:
        r18 = null;
    L76:
        if (((Boolean) ud0.a.getValue()).booleanValue() == true) goto L82;
        Integer r34 = (Integer) m90.a.getValue();
        if (r34 != null) goto L81;
        return;
    L81:
        if (r34.intValue() == 1) goto L82;
        return;
    L82:
        no0.a.b("native", "begin", "", null, "");
        OpenPlatformContext r35 = this.a;
        if (r35 == null) goto L94;
        AnchorShelfContextService r36 = (AnchorShelfContextService) r35.getService(AnchorShelfContextService.class);
        if (r36 == null) goto L95;
        r36.openChoosePage(r13, r14, r15);
        return;
    L95:
        return;
    }

    @Override // so0.a
    public final void openCouponPage(Context r3, int r4, List<String> r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AnchorCouponContextService r1 = (AnchorCouponContextService) r0.getService(AnchorCouponContextService.class);
        if (r1 == null) goto L9;
        r1.h(r3, r4, r5);
        return;
    L9:
        return;
    }

    @Override // so0.a
    public final void reportExitMpBind(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "mpId");
        Intrinsics.checkNotNullParameter(r4, "enterPosition");
        Intrinsics.checkNotNullParameter(r5, "exitSource");
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r0.getService(AnchorMiniAppAppLogContextService.class);
        if (r1 == null) goto L9;
        r1.reportAnchorExitBindSuccess(r3, r4, r5, "app");
        return;
    L9:
        return;
    }

    @Override // so0.a
    public final PreviewMiniAppWidgetDelegate d(Context r3, ViewGroup r4, PreviewSourceParam r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "shootWay");
        Intrinsics.checkNotNullParameter(null, "previewMiniAppWidget");
        return new PreviewMiniAppWidgetDelegate(r3, r4, r5, r6);
    }
}
