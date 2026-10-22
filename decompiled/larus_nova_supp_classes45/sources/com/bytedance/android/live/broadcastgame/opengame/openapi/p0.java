package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.opengame.network.AudienceGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p0 extends BaseOpenMethod<JSONObject> {
    public final List<Integer> h;
    public Context i;
    public volatile boolean j;
    public Dialog k;
    public final g0 l;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ p0 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public b(p0 r1, String r2, long r3, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r5, int r6) {
            r5.dismiss();
            int r7 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"confirm pay"});
            OpenPlatformMonitorService r8 = (OpenPlatformMonitorService) this.a.d.o(OpenPlatformMonitorService.class);
            this.a.getClass();
            OpenPlatformMonitorService.k(r8, "payDiamondsV3", 0);
            int r9 = x10.f.a;
            x10.f.e(this.a.d, 2, null, 28);
            p0 r11 = this.a;
            Context r1 = r11.i;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        L5:
            String r12 = s1.C(2131921041, new Object[]{r3.c()});
            com.bytedance.android.livesdk.widget.e1 r0 = new com.bytedance.android.livesdk.widget.e1((Activity) r1);
            r0.c = r12;
            r11.k = r0;
            Dialog r13 = this.a.k;
            if (r13 != null) goto L8;
        L12:
            p0.t(this.a, this.b, this.c, this.d);
            int r14 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
            g0 r15 = this.a.l;
            com.bytedance.android.live.broadcastgame.api.interactgame.n.h(r15.f, String.valueOf(r15.e), jc1.k.n(IUserService.class).user().n(), "confirm");
            return;
        L8:
            if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L15;
            DialogLancet.handleBlockedDialogShow(r13);
            goto L12
        L15:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
        L11:
            DialogLancet.beforeDialogShow(r13);
            r13.show();
            DialogLancet.afterDialogShow(r13);
            goto L12
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ p0 a;
        public final /* synthetic */ String b;

        public c(p0 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r4, int r5) {
            r4.dismiss();
            p0 r6 = this.a;
            OpenApiErrorInfo r7 = OpenApiErrorInfo.PAY_CANCEL;
            p0.x(r6, r7, this.b);
            int r8 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"cancel pay"});
            OpenPlatformMonitorService r0 = (OpenPlatformMonitorService) this.a.d.o(OpenPlatformMonitorService.class);
            this.a.getClass();
            OpenPlatformMonitorService.k(r0, "payDiamondsV3", 1);
            int r9 = x10.f.a;
            x10.f.e(this.a.d, 2, r7, 24);
            int r11 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
            g0 r12 = this.a.l;
            com.bytedance.android.live.broadcastgame.api.interactgame.n.h(r12.f, String.valueOf(r12.e), jc1.k.n(IUserService.class).user().n(), "cancel");
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "payDiamondsV3";
    }

    public static final void v(p0 r21, String r22) {
        r21.getClass();
        int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"show recharge dialog, order id: " + r22});
        Context r2 = r21.i;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L5:
        Activity r3 = ContextUtil.contextToActivity(r2);
        if (r3 != null) goto L8;
        return;
    L8:
        if ((r3 instanceof FragmentActivity) == true) goto L10;
        r3 = null;
    L10:
        FragmentActivity r4 = (FragmentActivity) r3;
        if (r4 == null) goto L17;
        com.bytedance.android.live.recharge.model.d r5 = new com.bytedance.android.live.recharge.model.d(true, "jsb_pay_method", null, 0, true, 0, 0, "openapi", "call", null, null, null, null, 32364);
        if (r21.d.i == null) goto L18;
        jc1.k.n(IRechargeServiceExternal.class).showRechargeDialogFragment(r4, r5, null);
        return;
    L18:
        return;
    }

    public static void y(final p0 r17, Throwable r18) {
        r17.getClass();
        UtilityKotlinExtentionsKt.s(0, false, false, new PayMethodV3$hideLoadingDialog$1(r17), 7);
        String r3 = null;
        if ((r18 instanceof CustomApiServerException) == true) goto L5;
        Throwable r2 = null;
    L6:
        CustomApiServerException r4 = (CustomApiServerException) r2;
        final int r5 = 2131921032;
        if (r4 != null) goto L26;
        f2.c(s1.C(2131921032, new Object[]{r3.c()}), 0);
    L24:
        r17.o(r18);
        r17.j = false;
        return;
    L26:
        JsonElement r6 = GsonHelper.parser().parse(r4.getExtra());     // Catch: Exception -> L22
        if (r6 == null) goto L16;
        JsonObject r7 = r6.getAsJsonObject();     // Catch: Exception -> L22
        if (r7 == null) goto L16;
        JsonElement r8 = r7.get("control_content_msg");     // Catch: Exception -> L22
        if (r8 == null) goto L16;
        String r9 = r8.getAsString();     // Catch: Exception -> L22
        if (r9 == null) goto L16;
    L17:
        JsonObject r11 = GsonHelper.parser().parse(r9).getAsJsonObject();     // Catch: Exception -> L22
        final com.bytedance.android.livesdk.wrds.interact.a.b r12 = (com.bytedance.android.livesdk.wrds.interact.a.b) GsonHelper.get().fromJson(r11, com.bytedance.android.livesdk.wrds.interact.a.b.class);     // Catch: Exception -> L22
        JsonElement r13 = r11.get("toast_msg");     // Catch: Exception -> L22
        if (r13 == null) goto L20;
        r3 = r13.getAsString();     // Catch: Exception -> L22
    L20:
        r12.a = r3;     // Catch: Exception -> L22
        int r14 = GameDataReportHelper.a;     // Catch: Exception -> L22
        g0 r15 = r17.l;     // Catch: Exception -> L22
        GameDataReportHelper.g(r15.f, String.valueOf(r15.e), r12.a(), ((BootInfoService) r17.d.o(BootInfoService.class)).e(), r17.d.o);     // Catch: Exception -> L22
        UtilityKotlinExtentionsKt.s(0, false, false, new PayMethodV3$payFail$$inlined$let$lambda$1(r12, r17, r5), 7);     // Catch: Exception -> L22
    L16:
        r9 = "";
    L22:
        f2.c(s1.C(2131921032, new Object[]{r3.c()}), 0);
        goto L24
    L5:
        r2 = r18;
        goto L6
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r14, CallContext r15) {
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r15, "context");
        this.i = this.d.i();
        int r16 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"on call, params: " + r14});
        int r0 = x10.f.a;
        x10.f.e(this.d, 0, null, 28);
        long r8 = r14.optLong("diamonds");
        String r11 = r14.optString("tag");
        String r17 = r14.optString("orderId");
        if (this.j == false) goto L6;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethodV3", new Object[]{"pay not finished"});
        OpenPlatformMonitorService.j((OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class), "payDiamondsV3", 1);
        PluginContext r1 = this.d;
        OpenApiErrorInfo r2 = OpenApiErrorInfo.EXCEED_FREQ_LIMIT;
        x10.f.e(r1, 1, r2, 24);
        w(r2, r17, 2131921032);
        return;
    L6:
        this.j = true;
        if (r8 < 1) goto L28;
        if (r11 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L28;
        if (r17 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == true) goto L28;
        OpenPlatformMonitorService.j((OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class), "payDiamondsV3", 0);
        x10.f.e(this.d, 1, null, 28);
        Context r5 = this.i;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L26:
        com.bytedance.android.livesdk.widget.x0.b r6 = new com.bytedance.android.livesdk.widget.x0.b(r5, 4);
        r6.a.d = s1.C(2131921038, new Object[]{Long.valueOf(r8), r3.c()});
        r6.i(0, 2131921039, new b(this, r17, r8, r11));
        r6.k(0, true);
        r6.i(1, 2131922826, new c(this, r17));
        r6.n();
        return;
    L17:
        if (r17.length() == 0) goto L20;
        r4 = false;
        goto L21
    L10:
        if (r11.length() == 0) goto L13;
        r3 = false;
    L28:
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"invalid params"});
        OpenPlatformMonitorService.j((OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class), "payDiamondsV3", 1);
        PluginContext r7 = this.d;
        OpenApiErrorInfo r9 = OpenApiErrorInfo.INCORRECT_PARAMS;
        x10.f.e(r7, 1, r9, 24);
        w(r9, r17, 2131921032);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public p0(PluginContext r2, g0 r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "openApi");
        super(r2, r4);
        this.l = r3;
        this.h = CollectionsKt.mutableListOf(new Integer[]{10011, 4014044, 10001, 4014016, 400001, 4014048, 41104, 4005238});
    }

    public static final void u(p0 r6, long r7, String r9) {
        r6.getClass();
        UtilityKotlinExtentionsKt.s(0, false, false, new PayMethodV3$hideLoadingDialog$1(r6), 7);
        f2.c(s1.C(2131921034, new Object[]{Long.valueOf(r7), r3.c()}), 0);
        JSONObject r8 = new JSONObject();
        r8.put("orderId", r9);
        r8.put("pay_status", 2);
        r8.put("payStatus", 2);
        Unit r11 = Unit.INSTANCE;
        r6.r(r8);
        r6.j = false;
        OpenPlatformMonitorService r12 = (OpenPlatformMonitorService) r6.d.o(OpenPlatformMonitorService.class);
        Intrinsics.checkNotNullParameter("payDiamondsV3", "method");
        OpenPlatformMonitorService.p(r12, "payDiamondsV3", "ttlive_open_platform_pay_success", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 48).c();
        int r13 = x10.f.a;
        x10.f.e(r6.d, 4, null, 28);
        DataCenter r14 = r6.d.i;
        if (r14 == null) goto L6;
        r14.put("key_live_game_pay_success", null);
        return;
    }

    public static /* synthetic */ void x(p0 r1, OpenApiErrorInfo r2, String r3) {
        r1.w(r2, r3, 2131921032);
    }

    public final void w(OpenApiErrorInfo r7, String r8, int r9) {
        UtilityKotlinExtentionsKt.s(0, false, false, new PayMethodV3$hideLoadingDialog$1(this), 7);
        f2.c(s1.C(r9, new Object[]{r3.c()}), 0);
        this.j = false;
        JSONObject r11 = new JSONObject();
        r11.put("orderId", r8);
        Unit r12 = Unit.INSTANCE;
        BaseOpenMethod.q(this, r11, r7);
    }

    public static final void s(p0 r9, long r11, String r12, int r13) {
        r9.getClass();
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"fetch order status, order id: ", r12, ", diamonds: ", Long.valueOf(r11), ", query times: ", Integer.valueOf(r13)});
        if (r13 > 0) goto L5;
        OpenApiErrorInfo r14 = OpenApiErrorInfo.UNKNOWN_ORDER_STATUS;
        r9.w(r14, r12, 2131921035);
        int r15 = x10.f.a;
        x10.f.d(r9.d, 4, r14, null, -1);
        return;
    L5:
        Lazy r1 = LiveOpenGameClient.d;
        AudienceGameNetApi r2 = (AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class);
        g0 r3 = r9.l;
        r9.j(r2.queryOrderStatus(r3.a, r12, r3.b).compose(new x10.c(r9.d, "/webcast/openapi/business/diamond/query/")).delaySubscription(200, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new q0(r9, r11, r12, r13), new r0(r9, r12, r11, r13)));
    }

    public static final void t(p0 r16, String r17, long r18, String r21) {
        r16.getClass();
        Lazy r0 = LiveOpenGameClient.d;
        AudienceGameNetApi r7 = (AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class);
        g0 r1 = r16.l;
        String r8 = r1.a;
        long r9 = r1.b;
        JSONObject r2 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.o r3 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r4 = com.bytedance.android.livesdk.log.l0.a("enter_from_merge", r3);
        String r5 = com.bytedance.android.livesdk.log.l0.a("enter_method", r3);
        String r6 = com.bytedance.android.livesdk.log.l0.a("action_type", r3);
        boolean r13 = false;
        if (r4.length() <= 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        r2.put("enter_from_merge", r4);
    L9:
        if (r5.length() <= 0) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L15;
        r2.put("enter_method", r5);
    L15:
        if (r6.length() <= 0) goto L17;
        r13 = true;
    L17:
        if (r13 == false) goto L20;
        r2.put("action_type", r6);
    L20:
        if (r16.d.i == null) goto L22;
        r2.put("live_room_type", com.bytedance.android.live.broadcastgame.api.interactgame.j.a());
    L22:
        r16.j(r7.payDiamondV3(r8, r9, r17, r18, r21, r2.toString()).compose(new x10.c(r16.d, "/webcast/openapi/business/order/pay/")).compose(RxUtil.rxSchedulerHelper()).subscribe(new s0(r16, r17, r18), new t0(r16, r17, r18, r21)));
        return;
    L11:
        r11 = false;
        goto L12
    L5:
        r12 = false;
        goto L6
    }
}
