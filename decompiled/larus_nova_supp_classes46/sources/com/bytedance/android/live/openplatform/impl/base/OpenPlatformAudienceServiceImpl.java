package com.bytedance.android.live.openplatform.impl.base;

import android.content.Context;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.ImageLoader;
import com.bytedance.android.live.openplatform.impl.base.utils.v;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfInfoService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar.LittleGameConfig;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.openplatform.LiveOpenApiCallback;
import com.bytedance.ies.sdk.widgets.DataCenter;
import j70.h;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import jc1.k;
import ko0.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import po0.e;
import w20.lc;
import yo0.d;
import zo0.f;
import zo0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000 P2\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\bN\u0010OJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0018\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\nH\u0016J\u0018\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\nH\u0016J\b\u00101\u001a\u000200H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\u001e\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000207\u0018\u0001062\u0006\u00105\u001a\u000204H\u0016J\u001a\u0010;\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010:H\u0016J\u0016\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000106H\u0016J\u001a\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0016R.\u0010A\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010?8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR.\u0010H\u001a\u0004\u0018\u00010G2\b\u0010@\u001a\u0004\u0018\u00010G8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006R"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/OpenPlatformAudienceServiceImpl;", "Lcom/bytedance/android/live/openplatform/api/IOpenPlatformAudienceService;", "Lko0/c;", "getMiniAppLiveCastEntranceInfo", "", "appId", "Lorg/json/JSONObject;", "params", "Lcom/bytedance/android/livesdkapi/openplatform/LiveOpenApiCallback;", "callback", "", "invokeLiveOpenApi", "Lj70/h;", "Lh70/b;", "getAudienceMiniAppWidgetDescriptor", "Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniAppSource;", "source", "openMountedMiniApp", "location", "openSnowFlake", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;", "button", "onSnowFlakeShow", "", "isFromMsg", "onSnowFlakeHide", "reportMpLiveLinkShow", "reportMpLiveLinkClick", "isMiniAppExplainCardShowing", "hideMiniAppExplainCard", "showMiniAppExplainCard", "sei", "onSei", "isGuest", "reportAudienceLiveProjectionWatch", "", "duration", "reportAudienceLiveProjectionWatchDuration", "recordSnowFlakeShown", "showType", "reportExplainCardShown", "deleteMiniAppMountInfo", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "preloadMiniAppContext", "reportSnowFlakeAnimShow", "Lmo0/a;", "getOpenPlatformImageLoader", "Lis2/b;", "getShelfInfoBackendHandler", "", "cardType", "", "", "getMiniAppCommonCardExtraParams", "schema", "Lw20/lc$a;", "openLiveMicroApp", "getCommonEventParams", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/a0;", "createToolbarComponentConfig", "Lto0/a;", "<set-?>", "miniAppAudienceService", "Lto0/a;", "getMiniAppAudienceService", "()Lto0/a;", "setMiniAppAudienceService", "(Lto0/a;)V", "Lyo0/b;", "openApiService", "Lyo0/b;", "getOpenApiService", "()Lyo0/b;", "setOpenApiService", "(Lyo0/b;)V", "<init>", "()V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OpenPlatformAudienceServiceImpl implements IOpenPlatformAudienceService {
    public static final a Companion = null;
    private static final e diComponent = null;
    private to0.a miniAppAudienceService;
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

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void deleteMiniAppMountInfo() {
        MiniAppDataContext.Companion.getClass();
        if (MiniAppDataContext.a.b() != null) goto L5;
        return;
    L5:
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L13;
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L14;
        AudienceShelfInfoService r2 = (AudienceShelfInfoService) r1.getService(AudienceShelfInfoService.class);
        if (r2 == null) goto L15;
        r2.j();
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public h<? extends h70.b> getAudienceMiniAppWidgetDescriptor() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAudienceMiniAppWidgetDescriptor();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public Map<String, String> getCommonEventParams() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCommonEventParams();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    public c getMiniAppLiveCastEntranceInfo() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMiniAppLiveCastEntranceInfo();
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public is2.b getShelfInfoBackendHandler() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getShelfInfoBackendHandler();
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void hideMiniAppExplainCard() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.hideMiniAppExplainCard();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public boolean isMiniAppExplainCardShowing() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isMiniAppExplainCardShowing();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void openSnowFlake() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.openSnowFlake();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void recordSnowFlakeShown() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L9;
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L9;
        OpenPlatformPerformanceReportService r2 = (OpenPlatformPerformanceReportService) r1.getService(OpenPlatformPerformanceReportService.class);
        if (r2 == null) goto L9;
        r2.k(false);
    L9:
        to0.a r3 = this.miniAppAudienceService;
        if (r3 == null) goto L16;
        OpenPlatformContext r4 = r3.a();
        if (r4 == null) goto L16;
        if (r4.isInLive() != true) goto L16;
        int r5 = 4;
    L17:
        int r6 = no0.a.a;
        no0.a.c(r5, 1, 2);
        return;
    L16:
        r5 = 3;
        goto L17
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void reportMpLiveLinkClick() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.reportMpLiveLinkClick();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void reportMpLiveLinkShow() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.reportMpLiveLinkShow();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void reportSnowFlakeAnimShow() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.reportSnowFlakeAnimShow();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void showMiniAppExplainCard() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.showMiniAppExplainCard();
        return;
    }

    public OpenPlatformAudienceServiceImpl() {
        po0.a.b r0 = (po0.a.b) diComponent;
        setMiniAppAudienceService((to0.a) r0.d.get());
        setOpenApiService((yo0.b) r0.c.get());
        k.l(IOpenPlatformAudienceService.class, this);
        v.a();
    }

    public static final /* synthetic */ e access$getDiComponent$cp() {
        return diComponent;
    }

    public final to0.a getMiniAppAudienceService() {
        return this.miniAppAudienceService;
    }

    public final yo0.b getOpenApiService() {
        return this.openApiService;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public mo0.a getOpenPlatformImageLoader() {
        return ImageLoader.a;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    public Map<String, Object> getMiniAppCommonCardExtraParams(int r1) {
        to0.a r2 = this.miniAppAudienceService;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.c();
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void onSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.onSei(r2);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void onSnowFlakeHide(boolean r1) {
        to0.a r2 = this.miniAppAudienceService;
        if (r2 == null) goto L6;
        r2.f();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void onSnowFlakeShow(s r2) {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.onSnowFlakeShow(r2);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void openMountedMiniApp(MountedMiniAppSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.openMountedMiniApp(r2);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void reportAudienceLiveProjectionWatch(boolean r2) {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.reportAudienceLiveProjectionWatch(r2);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void reportExplainCardShown(String r23) {
        Intrinsics.checkNotNullParameter(r23, "showType");
        to0.a r3 = this.miniAppAudienceService;
        if (r3 == null) goto L26;
        OpenPlatformContext r4 = r3.a();
        if (r4 == null) goto L27;
        OpenPlatformPerformanceReportService r5 = (OpenPlatformPerformanceReportService) r4.getService(OpenPlatformPerformanceReportService.class);
        if (r5 == null) goto L28;
        Intrinsics.checkNotNullParameter(r23, "showType");
        HashMap<String, f> r1 = g.a;
        PerformanceScene r2 = PerformanceScene.EXPLAIN_CARD;
        zo0.h.b(r2).b();
        boolean r6 = zo0.h.b(r2).c("is_from_enter");
        PerformanceScene r7 = PerformanceScene.MINI_APP_CONTEXT;
        long r8 = zo0.h.b(r7).g("audience_enter_room_duration");
        if (r6 == false) goto L11;
        long r9 = zo0.h.b(r2).f();
        long r10 = zo0.h.b(r7).h();
    L12:
        long r11 = r9 - r10;
        if (r6 == false) goto L15;
        long r12 = r8 + r11;
    L16:
        long r14 = zo0.h.b(r7).d("context_initialized", "start");
        long r13 = zo0.h.b(r2).d("audience_widget_loaded", "start");
        long r16 = zo0.h.b(r2).d("card_show_finish", "card_show_start");
        long r18 = zo0.h.b(r2).d("toolbar_anim_finish", "toolbar_anim_start");
        long r20 = zo0.h.b(r2).d("finish", "card_anim_start");
        Pair[] r0 = new Pair[9];
        if (r6 == false) goto L19;
        String r15 = "enter";
    L20:
        r0[0] = TuplesKt.to("toolbar_im_source", r15);
        if (r6 == false) goto L23;
        String r17 = String.valueOf(r8);
    L24:
        r0[1] = TuplesKt.to("enter_room_duration", r17);
        r0[2] = TuplesKt.to("duration", String.valueOf(r11));
        r0[3] = TuplesKt.to("total_duration", String.valueOf(r12));
        r0[4] = TuplesKt.to("context_init_duration", String.valueOf(r14));
        r0[5] = TuplesKt.to("ui_init_duration", String.valueOf(r13));
        r0[6] = TuplesKt.to("draw_duration", String.valueOf(r16));
        r0[7] = TuplesKt.to("toolbar_anim_duration", String.valueOf(r18));
        r0[8] = TuplesKt.to("card_anim_duration", String.valueOf(r20));
        Map r19 = MapsKt.mutableMapOf(r0);
        r19.putAll(OpenPlatformPerformanceReportService.g(r6));
        OpenPlatformPerformanceReportService.h(r2, r19, MapsKt.emptyMap());
        com.bytedance.android.livesdk.log.g r21 = u.l();
        Map r22 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("_param_for_special", "micro_app"), TuplesKt.to("room_id", String.valueOf(r5.getOpenPlatformContext().getRoomId())), TuplesKt.to("show_type", r23)});
        r22.putAll(r19);
        Unit r24 = Unit.INSTANCE;
        r21.e("mp_entrance_explain_card_fp_cost", r22, new Object[0]);
        return;
    L23:
        r17 = "0";
        goto L24
    L19:
        r15 = "msg";
        goto L20
    L15:
        r12 = r11;
        goto L16
    L11:
        r9 = zo0.h.b(r2).f();
        r10 = zo0.h.b(PerformanceScene.SHELF_REQUEST).h();
        goto L12
    L28:
        return;
    L27:
        return;
    }

    @Inject
    public final void setMiniAppAudienceService(to0.a r1) {
        this.miniAppAudienceService = r1;
    }

    @Inject
    public final void setOpenApiService(yo0.b r1) {
        this.openApiService = r1;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void openMountedMiniApp(String r2) {
        Intrinsics.checkNotNullParameter(r2, "location");
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.openMountedMiniApp(r2);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public a0 createToolbarComponentConfig(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        return new LittleGameConfig(r3, r2);
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public void openLiveMicroApp(String r2, lc.a r3) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.openLiveMicroApp(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void preloadMiniAppContext(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.g(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void reportAudienceLiveProjectionWatchDuration(long r2, boolean r4) {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L6;
        r0.reportAudienceLiveProjectionWatchDuration(r2, r4);
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
}
