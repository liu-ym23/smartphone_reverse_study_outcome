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
public final class PayMethod extends BaseOpenMethod<JSONObject> {
    public final DataCenter h;
    public final List<Integer> i;
    public String j;
    public Context k;
    public Dialog l;
    public volatile boolean m;
    public final g0 n;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ PayMethod a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public b(PayMethod r1, long r2, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r8, int r9) {
            r8.dismiss();
            int r11 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"confirm pay"});
            OpenPlatformMonitorService r12 = (OpenPlatformMonitorService) this.a.d.o(OpenPlatformMonitorService.class);
            this.a.getClass();
            OpenPlatformMonitorService.k(r12, "payDiamonds", 0);
            int r13 = x10.f.a;
            x10.f.c(this.a.d, 2, null, 28);
            PayMethod r14 = this.a;
            Context r2 = r14.k;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        L5:
            String r3 = s1.C(2131921041, new Object[]{r3.c()});
            com.bytedance.android.livesdk.widget.e1 r4 = new com.bytedance.android.livesdk.widget.e1((Activity) r2);
            r4.c = r3;
            r14.l = r4;
            Dialog r15 = this.a.l;
            if (r15 != null) goto L8;
        L12:
            PayMethod r16 = this.a;
            long r5 = this.b;
            String r6 = this.c;
            r16.getClass();
            int r7 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"create order id"});
            Lazy r17 = LiveOpenGameClient.d;
            AudienceGameNetApi r18 = (AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class);
            g0 r0 = r16.n;
            r16.j(r18.createOrderId(r0.a, r0.b).compose(new x10.c(r16.d, "/webcast/openapi/business/order/gen_id/")).subscribe(new i0(r16, r5, r6), new j0(r16)));
            int r19 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
            g0 r21 = this.a.n;
            com.bytedance.android.live.broadcastgame.api.interactgame.n.h(r21.f, String.valueOf(r21.e), jc1.k.n(IUserService.class).user().n(), "confirm");
            return;
        L8:
            if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L15;
            DialogLancet.handleBlockedDialogShow(r15);
            goto L12
        L15:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
        L11:
            DialogLancet.beforeDialogShow(r15);
            r15.show();
            DialogLancet.afterDialogShow(r15);
            goto L12
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ PayMethod a;

        public c(PayMethod r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r4, int r5) {
            PayMethod r6 = this.a;
            OpenApiErrorInfo r0 = OpenApiErrorInfo.PAY_CANCEL;
            r6.y(r0);
            r4.dismiss();
            int r7 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"cancel pay"});
            OpenPlatformMonitorService r8 = (OpenPlatformMonitorService) this.a.d.o(OpenPlatformMonitorService.class);
            this.a.getClass();
            OpenPlatformMonitorService.k(r8, "payDiamonds", 1);
            int r9 = x10.f.a;
            x10.f.c(this.a.d, 2, r0, 24);
            int r11 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
            g0 r12 = this.a.n;
            com.bytedance.android.live.broadcastgame.api.interactgame.n.h(r12.f, String.valueOf(r12.e), jc1.k.n(IUserService.class).user().n(), "cancel");
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "payDiamonds";
    }

    public final void x() {
        UtilityKotlinExtentionsKt.s(0, false, false, new PayMethod$hideLoadingDialog$1(this), 7);
    }

    public static final void w(PayMethod r21) {
        r21.getClass();
        int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"show recharge dialog, order id: " + r21.j});
        Context r2 = r21.k;
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
        if (r21.h == null) goto L18;
        jc1.k.n(IRechargeServiceExternal.class).showRechargeDialogFragment(r4, r5, null);
        return;
    L18:
        return;
    }

    public final void y(OpenApiErrorInfo r4) {
        x();
        f2.c(s1.C(2131921032, new Object[]{r3.c()}), 0);
        n(r4, null);
        this.m = false;
    }

    public static final void u(final PayMethod r17, Throwable r18) {
        r17.x();
        String r3 = null;
        if ((r18 instanceof CustomApiServerException) == true) goto L5;
        Throwable r2 = null;
    L6:
        CustomApiServerException r4 = (CustomApiServerException) r2;
        if (r4 != null) goto L26;
        f2.c(s1.C(2131921032, new Object[]{r3.c()}), 0);
    L24:
        r17.o(r18);
        r17.m = false;
        return;
    L26:
        JsonElement r5 = GsonHelper.parser().parse(r4.getExtra());     // Catch: Exception -> L22
        if (r5 == null) goto L16;
        JsonObject r6 = r5.getAsJsonObject();     // Catch: Exception -> L22
        if (r6 == null) goto L16;
        JsonElement r7 = r6.get("control_content_msg");     // Catch: Exception -> L22
        if (r7 == null) goto L16;
        String r8 = r7.getAsString();     // Catch: Exception -> L22
        if (r8 == null) goto L16;
    L17:
        JsonObject r9 = GsonHelper.parser().parse(r8).getAsJsonObject();     // Catch: Exception -> L22
        final com.bytedance.android.livesdk.wrds.interact.a.b r11 = (com.bytedance.android.livesdk.wrds.interact.a.b) GsonHelper.get().fromJson(r9, com.bytedance.android.livesdk.wrds.interact.a.b.class);     // Catch: Exception -> L22
        JsonElement r12 = r9.get("toast_msg");     // Catch: Exception -> L22
        if (r12 == null) goto L20;
        r3 = r12.getAsString();     // Catch: Exception -> L22
    L20:
        r11.a = r3;     // Catch: Exception -> L22
        int r13 = GameDataReportHelper.a;     // Catch: Exception -> L22
        g0 r14 = r17.n;     // Catch: Exception -> L22
        GameDataReportHelper.g(r14.f, String.valueOf(r14.e), r11.a(), ((BootInfoService) r17.d.o(BootInfoService.class)).e(), r17.d.o);     // Catch: Exception -> L22
        UtilityKotlinExtentionsKt.s(0, false, false, new PayMethod$payFail$$inlined$let$lambda$1(r11, r17), 7);     // Catch: Exception -> L22
    L16:
        r8 = "";
    L22:
        f2.c(s1.C(2131921032, new Object[]{r3.c()}), 0);
        goto L24
    L5:
        r2 = r18;
        goto L6
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r12, CallContext r13) {
        Intrinsics.checkNotNullParameter(r12, "json");
        Intrinsics.checkNotNullParameter(r13, "context");
        this.k = this.d.i();
        int r14 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"on call, params: " + r12});
        int r0 = x10.f.a;
        x10.f.c(this.d, 0, null, 28);
        if (this.m == false) goto L6;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethod", new Object[]{"pay not finished"});
        OpenPlatformMonitorService.j((OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class), "payDiamonds", 1);
        PluginContext r15 = this.d;
        OpenApiErrorInfo r1 = OpenApiErrorInfo.EXCEED_FREQ_LIMIT;
        x10.f.c(r15, 1, r1, 24);
        y(r1);
        return;
    L6:
        this.m = true;
        long r7 = r12.optLong("diamonds");
        String r16 = r12.optString("tag");
        if (r7 < 1) goto L21;
        if (r16 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L21;
        OpenPlatformMonitorService.j((OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class), "payDiamonds", 0);
        x10.f.c(this.d, 1, null, 28);
        Context r3 = this.k;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L19:
        com.bytedance.android.livesdk.widget.x0.b r4 = new com.bytedance.android.livesdk.widget.x0.b(r3, 4);
        r4.a.d = s1.C(2131921038, new Object[]{Long.valueOf(r7), r3.c()});
        r4.i(0, 2131921039, new b(this, r7, r16));
        r4.k(0, true);
        r4.i(1, 2131922826, new c(this));
        r4.n();
        return;
    L10:
        if (r16.length() == 0) goto L13;
        r2 = false;
    L21:
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"invalid params"});
        OpenPlatformMonitorService.j((OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class), "payDiamonds", 1);
        PluginContext r17 = this.d;
        OpenApiErrorInfo r5 = OpenApiErrorInfo.INCORRECT_PARAMS;
        x10.f.c(r17, 1, r5, 24);
        y(r5);
    }

    public final void z(OpenApiErrorInfo r4, int r5) {
        x();
        f2.c(s1.C(r5, new Object[]{r3.c()}), 0);
        this.m = false;
        n(r4, null);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public PayMethod(PluginContext r2, g0 r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "openApi");
        super(r2, r4);
        this.n = r3;
        this.h = r2.i;
        this.i = CollectionsKt.mutableListOf(new Integer[]{10011, 4014044, 10001, 4014016, 400001, 4014048});
        this.j = "";
    }

    public static final void s(PayMethod r6, long r7, int r9) {
        r6.getClass();
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"fetch order status, order id: ", r6.j, ", diamonds: ", Long.valueOf(r7), ", query times: ", Integer.valueOf(r9)});
        if (r9 > 0) goto L5;
        OpenApiErrorInfo r8 = OpenApiErrorInfo.UNKNOWN_ORDER_STATUS;
        r6.z(r8, 2131921035);
        int r11 = x10.f.a;
        x10.f.b(r6.d, 4, r8, null, -1);
        return;
    L5:
        Lazy r1 = LiveOpenGameClient.d;
        AudienceGameNetApi r2 = (AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class);
        g0 r3 = r6.n;
        r6.j(r2.queryOrderStatus(r3.a, r6.j, r3.b).compose(new x10.c(r6.d, "/webcast/openapi/business/diamond/query/")).delaySubscription(200, TimeUnit.MILLISECONDS).subscribe(new k0(r6, r7, r9), new l0(r6, r7, r9)));
    }

    public static final void v(PayMethod r2, long r3, String r5) {
        r2.x();
        f2.c(s1.C(2131921034, new Object[]{Long.valueOf(r3), r3.c()}), 0);
        JSONObject r4 = new JSONObject();
        r4.put("orderId", r5);
        Unit r6 = Unit.INSTANCE;
        r2.r(r4);
        r2.m = false;
        OpenPlatformMonitorService r7 = (OpenPlatformMonitorService) r2.d.o(OpenPlatformMonitorService.class);
        Intrinsics.checkNotNullParameter("payDiamonds", "method");
        OpenPlatformMonitorService.p(r7, "payDiamonds", "ttlive_open_platform_pay_success", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 48).c();
        int r8 = x10.f.a;
        x10.f.c(r2.d, 4, null, 28);
        DataCenter r9 = r2.d.i;
        if (r9 == null) goto L6;
        r9.put("key_live_game_pay_success", null);
        return;
    }

    public static final void t(PayMethod r16, String r17, long r18, String r21) {
        r16.getClass();
        Lazy r0 = LiveOpenGameClient.d;
        AudienceGameNetApi r7 = (AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class);
        g0 r1 = r16.n;
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
        r16.j(r7.payDiamond(r8, r9, r17, r18, r21, r2.toString()).compose(new x10.c(r16.d, "/webcast/openapi/business/diamond/pay/")).compose(RxUtil.rxSchedulerHelper()).subscribe(new m0(r16, r17, r18), new n0(r16, r17, r18, r21)));
        return;
    L11:
        r11 = false;
        goto L12
    L5:
        r12 = false;
        goto L6
    }
}
