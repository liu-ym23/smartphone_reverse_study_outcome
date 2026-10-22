package zs1;

import am2.x;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.c5;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends com.bytedance.android.livesdk.coupon.a<com.bytedance.android.livesdk.coupon.balancecoupon.model.a> {
    public static final /* synthetic */ int j = 0;
    public e g;
    public boolean h;
    public String i;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.coupon.a
    public final Map<String, Object> a() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r1 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.b;
        String r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.b());
    L6:
        r0.put("benefit_type", r3);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r4 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.b;
        if (r4 == null) goto L11;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.e r5 = r4.e();
        if (r5 == null) goto L11;
        String r6 = r5.a();
    L12:
        r0.put("domain", r6);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r7 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.b;
        if (r7 == null) goto L17;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.e r8 = r7.e();
        if (r8 == null) goto L17;
        String r9 = r8.b();
    L18:
        r0.put("scene", r9);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r10 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.b;
        if (r10 == null) goto L23;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.e r11 = r10.e();
        if (r11 == null) goto L23;
        Long r12 = Long.valueOf(r11.d());
    L24:
        r0.put("token_type", r12);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r13 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.b;
        if (r13 == null) goto L29;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.e r14 = r13.e();
        if (r14 == null) goto L29;
        String r15 = r14.c();
    L30:
        r0.put("token", r15);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r16 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.b;
        if (r16 == null) goto L33;
        String r17 = r16.a();
    L34:
        r0.put("activity_id", r17);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r18 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.b;
        if (r18 == null) goto L37;
        String r19 = r18.c();
    L38:
        r0.put("category", r19);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r20 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.b;
        if (r20 == null) goto L43;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r21 = r20.d();
        if (r21 == null) goto L43;
        r2 = r21.c();
    L43:
        r0.put("prize_type", r2);
        return r0;
    L37:
        r19 = null;
        goto L38
    L33:
        r17 = null;
    L29:
        r15 = null;
    L23:
        r12 = null;
    L17:
        r9 = null;
    L11:
        r6 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final Map<String, Object> b() {
        if (this.c.c == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        int r1 = 3;
    L9:
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("popup_type", Integer.valueOf(r1));
        return r2;
    L8:
        r1 = 2;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final boolean d() {
        boolean r0 = !this.h;
        if (r0 == false) goto L6;
        this.h = true;
    L6:
        return !r0;
    }

    public final void l() {
        e r0 = this.g;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
        return;
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void j() {
        l();
        this.h = false;
        this.a.dispose();
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void f(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        this.h = false;
        m(false, "", "");
        if (c5.a(r4) == 59151) goto L5;
        f2.b(2131915244, 0);
    L5:
        n(false);
        ALogger.e("UgBalanceCouponController", "exchange coupon code:" + c5.a(r4) + " error: " + r4.getMessage());
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void g(com.bytedance.android.livesdk.coupon.balancecoupon.model.b r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        boolean r0 = false;
        this.h = false;
        if ((!StringsKt.isBlank(r4.d())) == false) goto L5;
        f2.c(r4.d(), 0);
    L5:
        l();
        if (r4.c() != 1) goto L8;
        r0 = true;
    L8:
        String r1 = r4.b();
        if (r0 == true) goto L13;
        String r5 = r4.d();
        if (r5 == null) goto L13;
    L14:
        m(r0, r1, r5);
        n(true);
        return;
    L13:
        r5 = "";
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.coupon.a
    public final void h(com.bytedance.android.livesdk.coupon.balancecoupon.model.c r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r4.a() == true) goto L5;
        return;
    L5:
        this.i = r4.d();
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r5 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.b;
        if (r5 == null) goto L18;
        e r1 = new e(this.c.getContext(), r5, new i(this));
        this.g = r1;
        Intrinsics.checkNotNull(r1);
        r1.setOnDismissListener(new h(this));
        e r6 = this.g;
        Intrinsics.checkNotNull(r6);
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r6);
    L13:
        u.l().sendLog("tobsdk_livesdk_balance_to_coupon_popup_show", null, new Object[]{Room.class, x.class});
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L12:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        goto L13
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final com.bytedance.android.livesdk.coupon.balancecoupon.model.a i(at1.a r8) {
        Intrinsics.checkNotNullParameter(r8, "couponContext");
        Long r1 = (Long) r8.b.get("data_room_id", 0L);
        boolean r3 = false;
        if (r8.c != null) goto L14;
        IMiddlewareLiveService r2 = k.f(IMiddlewareLiveService.class);
        if (r2 == null) goto L7;
        ILiveOntologyInfoManager r4 = r2.getLiveOntologyRecord();
    L8:
        if (r4 == null) goto L10;
        boolean r5 = r4.isFirstRoom(r1.longValue());
    L11:
        if (r5 == true) goto L14;
        return null;
    L10:
        r5 = false;
        goto L11
    L7:
        r4 = null;
    L14:
        if (((Boolean) LiveConfigSettingKeys.LIVE_MOCK_BALANCE_COUPON_PARAM.getValue()).booleanValue() == false) goto L16;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r6 = new com.bytedance.android.livesdk.coupon.balancecoupon.model.a();
        r6.g();
        r6.f();
        r6.h();
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.e r9 = new com.bytedance.android.livesdk.coupon.balancecoupon.model.a.e();
        r9.e();
        r9.f();
        r9.h();
        r9.g();
        r6.j(r9);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r10 = new com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c();
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.b r0 = new com.bytedance.android.livesdk.coupon.balancecoupon.model.a.b();
        r0.b();
        r10.d(r0);
        r10.f();
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r7 = new com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d();
        r7.i();
        r7.h();
        r7.j();
        r7.k();
        r7.g();
        r7.l();
        r10.e(r7);
        r6.i(r10);
        return r6;
    L16:
        JSONObject r11 = r8.c;
        if (r11 != null) goto L22;
        String r12 = (String) r8.b.get("data_enter_ecom_live_params", "");
        if (TextUtils.isEmpty(r12) == false) goto L21;
        ALogger.i("UgBalanceCouponController", "could not find ecomParams");
        JSONObject r13 = null;
    L24:
        if (r13 != null) goto L51;
        String r14 = null;
    L32:
        if (r14 != null) goto L34;
    L35:
        r3 = true;
    L37:
        if ((!r3) == true) goto L40;
        r13 = null;
    L40:
        if (r13 == null) goto L42;
        JSONObject r15 = r13.optJSONObject("balance_coupon");     // Catch: JsonParseException -> L26 JsonSyntaxException -> L28
    L43:
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r16 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) GsonProtectorUtils.fromJson(LiveGsonHelper.get(), String.valueOf(r15), com.bytedance.android.livesdk.coupon.balancecoupon.model.a.class);     // Catch: JsonParseException -> L26 JsonSyntaxException -> L28
        if (f.a(r16) == true) goto L54;
        ALogger.i("UgBalanceCouponController", "invalid coupon type, balanceCoupon:" + r15);     // Catch: JsonParseException -> L26 JsonSyntaxException -> L28
    L28:
        e = move-exception;
        ALogger.e("UgBalanceCouponController", "JsonSyntaxException, " + Log.getStackTraceString(e));
        return null;
    L26:
        e = move-exception;
        ALogger.e("UgBalanceCouponController", "JsonSyntaxException, " + Log.getStackTraceString(e));
        return null;
    L57:
        return null;
    L54:
        return r16;
    L42:
        r15 = null;
        goto L43
    L34:
        if (r14.length() != 0) goto L37;
    L51:
        r14 = r13.toString();     // Catch: JsonParseException -> L26 JsonSyntaxException -> L28
        goto L32
    L21:
        r13 = new JSONObject(r12);
        goto L24
    L22:
        r13 = r11.optJSONObject("ecom_live_params");
        goto L24
    }

    public final void n(boolean r4) {
        if (this.c.c == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        IBrowserService r1 = k.f(IBrowserService.class);
        if (r1 == null) goto L16;
        JSONObject r2 = new JSONObject();
        if (r4 == false) goto L12;
        String r5 = "1";
    L13:
        r2.put("is_success", r5);
        Unit r6 = Unit.INSTANCE;
        r1.enqueueEvent("exchange_coupon_result", r2);
        return;
    L12:
        r5 = "0";
        goto L13
    L16:
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void k(g r3, String r4) {
        r3.getClass();
        HashMap r5 = new HashMap();
        r5.put("button_type", r4);
        u.l().sendLog("tobsdk_livesdk_balance_to_coupon_popup_click", r5, new Object[]{Room.class, x.class});
    }

    public g(at1.a r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "couponContext");
        super(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(boolean r6, String r7, String r8) {
        HashMap r0 = new HashMap();
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r1 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.b;
        String r2 = "success";
        if (r6 == false) goto L5;
        String r3 = "success";
    L6:
        r0.put("result", r3);
        r0.put("coupon_meta_id", r7);
        if (r6 == true) goto L10;
        r2 = "fail + ".concat(r8);
    L10:
        r0.put("coupon_status", r2);
        r0.put("coupon_type", "platform_coupon");
        Long r9 = null;
        if (r1 == null) goto L17;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r10 = r1.d();
        if (r10 == null) goto L17;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.b r11 = r10.a();
        if (r11 == null) goto L17;
        Long r12 = Long.valueOf(r11.a());
    L18:
        r0.put("amount", String.valueOf(r12));
        if (r1 == null) goto L25;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r13 = r1.d();
        if (r13 == null) goto L25;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r14 = r13.b();
        if (r14 == null) goto L25;
        r9 = Long.valueOf(r14.d());
    L25:
        r0.put("coupon_amount", String.valueOf(r9));
        u.l().sendLog("tobsdk_livesdk_balance_to_coupon_result", r0, new Object[]{Room.class, x.class});
        return;
    L17:
        r12 = null;
        goto L18
    L5:
        r3 = "fail";
        goto L6
    }
}
