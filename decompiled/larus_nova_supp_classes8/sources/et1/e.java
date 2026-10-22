package et1;

import am2.x;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.coupon.balancecoupon.CouponBenefitType;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends com.bytedance.android.livesdk.coupon.a<Object> {
    public static final /* synthetic */ int i = 0;
    public boolean g;
    public c h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void g(com.bytedance.android.livesdk.coupon.balancecoupon.model.b r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final Map<String, Object> b() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("popup_type", 2);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final boolean d() {
        boolean r0 = this.g;
        if (r0 == false) goto L6;
        this.g = true;
    L6:
        return !r0;
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void j() {
        c r0 = this.h;
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
    public final void f(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        ALogger.e("RefundCouponController", "RefundCouponController obtain error, " + Log.getStackTraceString(r3));
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void h(com.bytedance.android.livesdk.coupon.balancecoupon.model.c r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r4.a() == true) goto L5;
        return;
    L5:
        c r0 = new c(this.c.getContext(), r4, new f(this));
        this.h = r0;
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r0);
    L10:
        u.l().sendLog("tobsdk_livesdk_ecom_full_refund_show", null, new Object[]{Room.class, x.class});
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L9:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L10
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final Object i(at1.a r7) {
        Intrinsics.checkNotNullParameter(r7, "couponContext");
        Long r0 = (Long) r7.b.get("data_room_id", 0L);
        IMiddlewareLiveService r1 = k.f(IMiddlewareLiveService.class);
        if (r1 == null) goto L5;
        ILiveOntologyInfoManager r2 = r1.getLiveOntologyRecord();
    L6:
        boolean r3 = false;
        if (r2 == null) goto L9;
        boolean r4 = r2.isFirstRoom(r0.longValue());
    L10:
        if (r4 == true) goto L12;
        return null;
    L12:
        CharSequence r5 = (CharSequence) LiveConfigSettingKeys.LIVE_MOCK_FULL_REFUND_COUPON_PARAM.getValue();
        if (r5 != null) goto L15;
    L16:
        r3 = true;
    L17:
        if (r3 == false) goto L19;
        String r8 = (String) r7.b.get("data_enter_ecom_live_params", "");
        if (TextUtils.isEmpty(r8) == false) goto L23;
        ALogger.i("UgBalanceCouponController", "could not find ecomParams");
        JSONObject r6 = null;
    L24:
        if (r6 == null) goto L31;
        JSONObject r9 = r6.optJSONObject("full_refund_coupon");
        if (r9 != null) goto L28;
        return null;
    L28:
        if (r9.optInt("benefit_type") == CouponBenefitType.COUPON_BENEFIT_TYPE_FULL_REFUND_COUPON.getValue()) goto L30;
        return null;
    L30:
        return new Object();
    L31:
        return null;
    L23:
        r6 = new JSONObject(r8);
        goto L24
    L19:
        return new Object();
    L15:
        if (r5.length() != 0) goto L17;
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static final void k(e r3, boolean r4) {
        r3.getClass();
        LinkedHashMap r5 = new LinkedHashMap();
        if (r4 == false) goto L5;
        String r6 = "order";
    L6:
        r5.put("click_button", r6);
        u.l().sendLog("tobsdk_livesdk_ecom_full_refund_click", r5, new Object[]{Room.class, x.class});
        return;
    L5:
        r6 = "close";
        goto L6
    }

    public e(at1.a r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "couponContext");
        super(r2, r3, r4);
    }
}
