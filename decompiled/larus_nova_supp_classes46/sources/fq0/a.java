package fq0;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.cast.AudienceCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.context.AudienceMiniAppContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceLynxExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.important.AudienceImportantCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.launch.AudienceLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfInfoService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.SnowToolbarContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.d;
import com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.f;
import com.bytedance.android.live.openplatform.impl.miniappcommon.applog.MiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.launch.CommonLaunchContextService;
import com.bytedance.android.live.room.api.messagewindow.builder.card.b;
import com.bytedance.android.live.room.api.messagewindow.builder.card.c;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.state.CardAction;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.config.d90;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.message.model.e3;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m71.e;
import org.json.JSONObject;
import w20.lc;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements to0.a {
    public OpenPlatformContext a;

    public a() {
    }

    @Override // uo0.a
    public final Map c() {
        LinkedHashMap r0 = new LinkedHashMap();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(tv5.a.a(GsonHelper.get(), d90.a.getValue()));     // Catch: Throwable -> L5
    L7:
        JSONObject r3 = new JSONObject();
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = r3;
    L10:
        r0.put("live_micro_app_explain_card_settings", r2);
        return r0;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // to0.a
    public final void f() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L17;
        SnowToolbarContextService r1 = (SnowToolbarContextService) r0.getService(SnowToolbarContextService.class);
        if (r1 == null) goto L17;
        com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.a r2 = r1.a;
        if (r2 == null) goto L11;
        IAnimationScheduler.Companion r3 = IAnimationScheduler.M0;
        DataCenter r4 = r1.getOpenPlatformContext().getDataCenter();
        r3.getClass();
        IAnimationScheduler r5 = IAnimationScheduler.Companion.a(r4);
        if (r5 == null) goto L11;
        r5.unRegisterListener(r2);
    L11:
        r1.a = null;
        Disposable r6 = r1.b;
        if (r6 == null) goto L14;
        r6.dispose();
    L14:
        HybridDialog r7 = r1.c.a;
        if (r7 == null) goto L17;
        r7.close();
    L17:
        OpenPlatformContext r8 = this.a;
        if (r8 == null) goto L25;
        AudienceImportantCardContextService r9 = (AudienceImportantCardContextService) r8.getService(AudienceImportantCardContextService.class);
        if (r9 == null) goto L26;
        c r10 = r9.b;
        if (r10 == null) goto L27;
        r10.a();
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // to0.a
    public final sq0.a getAudienceMiniAppWidgetDescriptor() {
        return new sq0.a();
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

    @Override // uo0.a
    public final ko0.c getMiniAppLiveCastEntranceInfo() {
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
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
        return new ko0.c(r4, r6, r5);
    L25:
        return null;
    }

    @Override // to0.a
    public final gq0.a getShelfInfoBackendHandler() {
        return new gq0.a();
    }

    @Override // to0.a
    public final void hideMiniAppExplainCard() {
        if (e.c(10) == false) goto L11;
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L17;
        AudienceLynxExplainCardContextService r1 = (AudienceLynxExplainCardContextService) r0.getService(AudienceLynxExplainCardContextService.class);
        if (r1 == null) goto L18;
        c r2 = r1.a;
        if (r2 == null) goto L19;
        b r3 = r2.a;
        r3.getClass();
        xs2.b.a().post(new z61.a(CardAction.HIDE, r3));
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L11:
        OpenPlatformContext r4 = this.a;
        if (r4 == null) goto L21;
        AudienceExplainCardContextService r5 = (AudienceExplainCardContextService) r4.getService(AudienceExplainCardContextService.class);
        if (r5 == null) goto L22;
        int r6 = AudienceExplainCardContextService.h;
        r5.f(false);
        return;
    L22:
        return;
    }

    @Override // to0.a
    public final boolean isMiniAppExplainCardShowing() {
        if (e.c(10) == false) goto L9;
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L14;
        AudienceLynxExplainCardContextService r1 = (AudienceLynxExplainCardContextService) r0.getService(AudienceLynxExplainCardContextService.class);
        if (r1 == null) goto L14;
        return r1.b;
    L14:
        return false;
    L9:
        OpenPlatformContext r2 = this.a;
        if (r2 == null) goto L14;
        AudienceExplainCardContextService r3 = (AudienceExplainCardContextService) r2.getService(AudienceExplainCardContextService.class);
        if (r3 == null) goto L14;
        return r3.b;
    }

    @Override // to0.a
    public final void onDestroy() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispatchLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        return;
    }

    @Override // to0.a
    public final void openSnowFlake() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L95;
        SnowToolbarContextService r1 = (SnowToolbarContextService) r0.getService(SnowToolbarContextService.class);
        if (r1 == null) goto L98;
        HybridDialog r2 = null;
        if (((uc1) ee0.a.getValue()).f() == false) goto L76;
        d r3 = r1.c;
        r3.getClass();
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r4 = AudienceMiniAppDataContext.a.a();
        if (r4 == null) goto L99;
        n<ShelfInfo> r5 = r4.m618getShelfInfo();
        if (r5 == null) goto L100;
        ShelfInfo r6 = (ShelfInfo) r5.getValue();
        if (r6 == null) goto L101;
        String r7 = r6.schema;
        if (r7 == null) goto L107;
        String r8 = UriProtector.parse(r7).getHost();
        if (r8 == null) goto L75;
        int r9 = r8.hashCode();
        if (r9 == (-1665624867)) goto L73;
        if (r9 != 469921128) goto L75;
        if (r8.equals("webcast_lynxview") == false) goto L75;
        Uri.Builder r10 = UriProtector.parse(r7).buildUpon().appendQueryParameter("mix_container_type", "annie");
        JSONObject r11 = new JSONObject();
        int r12 = ln1.a.a.a;
        Gson r13 = GsonHelper.get();
        AudienceMiniAppDataContext r14 = AudienceMiniAppDataContext.a.a();
        if (r14 == null) goto L32;
        n<ShelfInfo> r15 = r14.m618getShelfInfo();
        if (r15 == null) goto L32;
        ShelfInfo r16 = (ShelfInfo) r15.getValue();
    L33:
        r11.put("shelfInfo", ln1.a.a.b(UtilsKt.h(GsonProtectorUtils.toJsonTree(r13, r16))));
        Gson r17 = GsonHelper.get();
        AudienceMiniAppDataContext r18 = AudienceMiniAppDataContext.a.a();
        if (r18 == null) goto L38;
        n<lo0.a> r19 = r18.getPrivateMsgEntranceInfo();
        if (r19 == null) goto L38;
        lo0.a r20 = (lo0.a) r19.getValue();
    L39:
        r11.put("imInfo", ln1.a.a.b(UtilsKt.h(GsonProtectorUtils.toJsonTree(r17, r20))));
        r11.put("screenCastInfo", ((IInteractService) k.n(IInteractService.class)).isLinkCasting());
        JSONObject r21 = new JSONObject();
        am2.n r22 = am2.n.f();
        if (r22 == null) goto L42;
        String r23 = r22.a();
    L43:
        r21.put("ad_id", r23);
        am2.n r24 = am2.n.f();
        if (r24 == null) goto L46;
        String r25 = r24.c();
    L47:
        r21.put("cid", r25);
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L50
        Object r27 = Result.constructor-impl(new JSONObject(am2.n.f().d()));     // Catch: Throwable -> L50
    L53:
        if (Result.isFailure-impl(r27) == false) goto L55;
        r27 = null;
    L55:
        JSONObject r28 = (JSONObject) r27;
        if (r28 == null) goto L58;
        String r29 = r28.optString("clickid");
    L59:
        r21.put("clickid", r29);
        r21.put("log_extra", am2.n.f().d());
        r21.put("is_ad_channel", g4.b());
        Unit r30 = Unit.INSTANCE;
        r11.put("extra", r21);
        HybridDialog r31 = k.n(IBrowserService.class).showHybridDialogWithListener(r3.b.getContext(), r10.appendQueryParameter("initial_data", r11.toString()).build(), null, new com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.e(r3));
        if (r31 == null) goto L71;
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r32 = AudienceMiniAppDataContext.a.a();
        if (r32 == null) goto L70;
        n<ShelfInfo> r33 = r32.m618getShelfInfo();
        if (r33 == null) goto L70;
        Observable r34 = r33.a();
        if (r34 == null) goto L70;
        Disposable r35 = r34.subscribe(new f(r31));
        if (r35 == null) goto L70;
        Intrinsics.checkNotNullParameter(r35, "$this$autoDispose");
        r3.c.a(r35);
    L70:
        r2 = r31;
    L71:
        r3.a = r2;
        return;
    L58:
        r29 = null;
    L50:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L53
    L46:
        r25 = null;
        goto L47
    L42:
        r23 = null;
    L38:
        r20 = null;
    L32:
        r16 = null;
        goto L33
    L73:
        if (r8.equals("microapp") == false) goto L75;
        r3.a();
        return;
    L75:
        r3.a();
        return;
    L107:
        return;
    L101:
        return;
    L100:
        return;
    L99:
        return;
    L76:
        long r37 = 0;
        if (SnowToolbarContextService.k() == true) goto L90;
        AudienceLaunchContextService.openMiniApp$default((AudienceLaunchContextService) r1.getOpenPlatformContext().getService(AudienceLaunchContextService.class), MountedMiniAppSource.ToolbarDirectMicroApp, null, 2, null);
        AudienceShelfInfoService r38 = (AudienceShelfInfoService) r1.getOpenPlatformContext().getService(AudienceShelfInfoService.class);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r39 = AudienceMiniAppDataContext.a.a();
        if (r39 == null) goto L89;
        n<ShelfInfo> r40 = r39.m618getShelfInfo();
        if (r40 == null) goto L89;
        ShelfInfo r41 = (ShelfInfo) r40.getValue();
        if (r41 == null) goto L89;
        List<ShelfCardInfo> r42 = r41.cardInfoList;
        if (r42 == null) goto L89;
        ShelfCardInfo r43 = (ShelfCardInfo) CollectionsKt.firstOrNull(r42);
        if (r43 == null) goto L89;
        r37 = r43.getCardId();
    L89:
        r38.m(2, r37);
        return;
    L90:
        HashMap<String, zo0.f> r44 = g.a;
        h.b(PerformanceScene.SHELF_DIALOG).o();
        AudienceShelfDisplayDialog r45 = new AudienceShelfDisplayDialog();
        Context r46 = r1.getOpenPlatformContext().getContext();
        if (r46 == null) goto L94;
        r45.aa0((FragmentActivity) r46);
        ((AudienceShelfInfoService) r1.getOpenPlatformContext().getService(AudienceShelfInfoService.class)).m(2, 0);
        return;
    L94:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L98:
        return;
    }

    @Override // to0.a
    public final void reportMpLiveLinkClick() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L11;
        SnowToolbarContextService r1 = (SnowToolbarContextService) r0.getService(SnowToolbarContextService.class);
        if (r1 != null) goto L7;
        return;
    L7:
        if (SnowToolbarContextService.k() == true) goto L9;
        ((AudienceMiniAppAppLogContextService) r1.getOpenPlatformContext().getService(AudienceMiniAppAppLogContextService.class)).reportMpLiveLinkClick(MountedMiniAppSource.ToolbarDirectMicroApp);
        return;
    L9:
        ((AudienceMiniAppAppLogContextService) r1.getOpenPlatformContext().getService(AudienceMiniAppAppLogContextService.class)).reportMpLiveLinkClick("live_shelf_card");
        return;
    }

    @Override // to0.a
    public final void reportMpLiveLinkShow() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        SnowToolbarContextService r1 = (SnowToolbarContextService) r0.getService(SnowToolbarContextService.class);
        if (r1 == null) goto L9;
        r1.l();
        return;
    L9:
        return;
    }

    @Override // to0.a
    public final void reportSnowFlakeAnimShow() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AudienceMiniAppAppLogContextService r1 = (AudienceMiniAppAppLogContextService) r0.getService(AudienceMiniAppAppLogContextService.class);
        if (r1 == null) goto L9;
        r1.reportSnowFlakeAnimShow();
        return;
    L9:
        return;
    }

    @Override // to0.a
    public final void showMiniAppExplainCard() {
        if (e.c(10) == false) goto L9;
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L22;
        AudienceLynxExplainCardContextService r1 = (AudienceLynxExplainCardContextService) r0.getService(AudienceLynxExplainCardContextService.class);
        if (r1 == null) goto L23;
        AudienceLynxExplainCardContextService.f(r1, false, null, 3);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        OpenPlatformContext r2 = this.a;
        if (r2 == null) goto L25;
        AudienceExplainCardContextService r3 = (AudienceExplainCardContextService) r2.getService(AudienceExplainCardContextService.class);
        if (r3 == null) goto L26;
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r4 = AudienceMiniAppDataContext.a.a();
        if (r4 == null) goto L27;
        n<ShelfInfo> r5 = r4.m618getShelfInfo();
        if (r5 == null) goto L28;
        ShelfInfo r6 = (ShelfInfo) r5.getValue();
        if (r6 == null) goto L29;
        AudienceExplainCardContextService.i(r3, r6, false, false, 6);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
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

    @Override // to0.a
    public final void onSei(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sei");
        OpenPlatformContext r1 = this.a;
        if (r1 == null) goto L24;
        AudienceCastContextService r2 = (AudienceCastContextService) r1.getService(AudienceCastContextService.class);
        if (r2 == null) goto L25;
        Intrinsics.checkNotNullParameter(r5, "sei");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r6 = Result.constructor-impl(new JSONObject(r5).optJSONObject("miniapp_anchor_operation_page_sei"));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r6) == false) goto L14;
        r6 = null;
    L14:
        JSONObject r7 = (JSONObject) r6;
        if (r7 == null) goto L26;
        String r3 = r7.optString("app_id");
        String r4 = r7.optString("path");
        JSONObject r8 = r7.optJSONObject("query");
        if (r8 == null) goto L19;
        Map r9 = m.h(r8);
    L20:
        r2.a = new uq0.a(r3, r4, r9);
        return;
    L19:
        r9 = new LinkedHashMap();
        goto L20
    L26:
        return;
    L9:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L25:
        return;
    }

    @Override // to0.a
    public final void onSnowFlakeShow(s r8) {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L32;
        SnowToolbarContextService r1 = (SnowToolbarContextService) r0.getService(SnowToolbarContextService.class);
        if (r1 == null) goto L32;
        r1.l();
        if (r8 != null) goto L9;
    L11:
        boolean r9 = false;
    L12:
        ko0.e.e.getClass();
        if (ko0.e.a.b() == false) goto L21;
        if (r1.a != null) goto L21;
        com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.a r4 = new com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.a(r1, r9);
        r1.a = r4;
        IAnimationScheduler.Companion r10 = IAnimationScheduler.M0;
        DataCenter r5 = r1.getOpenPlatformContext().getDataCenter();
        r10.getClass();
        IAnimationScheduler r11 = IAnimationScheduler.Companion.a(r5);
        if (r11 == null) goto L21;
        r11.registerListener(r4);
    L21:
        if (e.c(10) == false) goto L32;
        Disposable r12 = r1.b;
        if (r12 == null) goto L25;
        r12.dispose();
    L25:
        AudienceLynxExplainCardContextService r13 = (AudienceLynxExplainCardContextService) r1.getOpenPlatformContext().getService(AudienceLynxExplainCardContextService.class);
        r13.getClass();
        q71.a r6 = k.n(IMsgWindowService.class).cardStateDispatcher(r13.getOpenPlatformContext().getDataCenter());
        e3 r7 = new e3();
        r7.areaType = 1;
        r7.areaSubType = 3;
        Unit r14 = Unit.INSTANCE;
        q71.d r15 = q71.a.a.a(r6, r7);
        if (r15 == null) goto L30;
        Observable r16 = r15.a();
        if (r16 == null) goto L30;
        Disposable r17 = r16.subscribe(new com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.e(r13));
    L31:
        r1.b = r17;
    L30:
        r17 = null;
        goto L31
    L9:
        if (r8.l.b == true) goto L11;
        r9 = true;
    L32:
        OpenPlatformContext r18 = this.a;
        if (r18 == null) goto L47;
        AudienceImportantCardContextService r19 = (AudienceImportantCardContextService) r18.getService(AudienceImportantCardContextService.class);
        if (r19 != null) goto L37;
        return;
    L37:
        if (r19.a == true) goto L52;
        r19.a = true;
        q71.a r2 = k.n(IMsgWindowService.class).cardStateDispatcher(r19.getOpenPlatformContext().getDataCenter());
        e3 r3 = new e3();
        r3.areaType = 1;
        r3.areaSubType = 3;
        Unit r20 = Unit.INSTANCE;
        q71.d r21 = r2.c(r3, MsgWindowPosition.TOP_RIGHT);
        if (r21 == null) goto L49;
        Observable r22 = r21.a();
        if (r22 == null) goto L50;
        Disposable r23 = r22.subscribe(new com.bytedance.android.live.openplatform.impl.miniappaudience.important.a(r19));
        if (r23 == null) goto L51;
        r19.autoDispose(r23);
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L52:
        return;
    }

    @Override // to0.a
    public final void openMountedMiniApp(MountedMiniAppSource r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AudienceLaunchContextService r1 = (AudienceLaunchContextService) r0.getService(AudienceLaunchContextService.class);
        if (r1 == null) goto L9;
        AudienceLaunchContextService.openMiniApp$default(r1, r4, null, 2, null);
        return;
    L9:
        return;
    }

    @Override // to0.a
    public final void reportAudienceLiveProjectionWatch(boolean r3) {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AudienceMiniAppAppLogContextService r1 = (AudienceMiniAppAppLogContextService) r0.getService(AudienceMiniAppAppLogContextService.class);
        if (r1 == null) goto L9;
        r1.reportAudienceLiveProjectionWatch(r3);
        return;
    L9:
        return;
    }

    @Override // to0.a
    public final void openMountedMiniApp(String r3) {
        Intrinsics.checkNotNullParameter(r3, "location");
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AudienceLaunchContextService r1 = (AudienceLaunchContextService) r0.getService(AudienceLaunchContextService.class);
        if (r1 == null) goto L9;
        r1.openMiniApp(r3);
        return;
    L9:
        return;
    }

    @Override // to0.a
    public final void g(Context r10, DataCenter r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "dataCenter");
        if (this.a != null) goto L19;
        int r2 = qo0.a.a;
        qo0.a.c("Perf", "init mini app context, curr time: " + SystemClock.uptimeMillis());
        ILiveUxTracer r3 = k.f(ILiveUxTracer.class);
        long r4 = 0;
        if (r3 == null) goto L7;
        long r5 = r3.getTimeStamp("enter_room", "start");
    L8:
        HashMap<String, zo0.f> r6 = g.a;
        PerformanceScene r7 = PerformanceScene.MINI_APP_CONTEXT;
        zo0.f r8 = h.b(r7);
        r8.o();
        if (r5 <= 0) goto L12;
        r4 = SystemClock.uptimeMillis() - r5;
    L12:
        monitor-enter(r8);
        Intrinsics.checkNotNullParameter("audience_enter_room_duration", "key");     // Catch: Throwable -> L16
        r8.b.putLong("audience_enter_room_duration", r4);     // Catch: Throwable -> L16
        monitor-exit(r8);
        int r9 = iq0.a.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "dataCenter");
        AudienceMiniAppContext r0 = new AudienceMiniAppContext(r10, r11);
        this.a = r0;
        r0.dispatchLifecycleEvent(Lifecycle.Event.ON_CREATE);
        h.b(r7).l("context_initialized", null);
        return;
    L16:
        th = move-exception;
        throw th;
    L7:
        r5 = 0;
        goto L8
    L19:
        int r12 = qo0.a.a;
        qo0.a.c("Perf", "mini app context is already inited, curr time: " + SystemClock.uptimeMillis());
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

    @Override // to0.a
    public final void reportAudienceLiveProjectionWatchDuration(long r3, boolean r5) {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AudienceMiniAppAppLogContextService r1 = (AudienceMiniAppAppLogContextService) r0.getService(AudienceMiniAppAppLogContextService.class);
        if (r1 == null) goto L9;
        r1.reportAudienceLiveProjectionWatchDuration(r3, r5);
        return;
    L9:
        return;
    }
}
