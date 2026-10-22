package gi8;

import com.larus.bmhome.chat.banner.i;
import com.larus.bmhome.chat.banner.m;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(i r9, boolean r10) {
        Integer r0 = r9.d();
        if (r0 == null) goto L79;
        boolean r2 = false;
        if (r0.intValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        String r4 = null;
        if (r1 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L80;
        int r3 = r0.intValue();
        if (r3 == 1) goto L22;
        if (r3 == 2) goto L19;
        if (r10 == false) goto L18;
        String r11 = "action_banner_click";
    L25:
        String r5 = r9.i();
        if (r5 != null) goto L28;
    L29:
        r2 = true;
    L30:
        if (r2 == false) goto L77;
        JSONObject r6 = new JSONObject();
    L44:
        if (r3 == 1) goto L74;
        if (r3 == 2) goto L47;
        r6.put("banner_type", r3);
    L75:
        o.a.reportEvent(r11, r6);
        return;
    L47:
        r6.put("enter_method", "model_selector_quota_entry");
        r6.put("current_page", "chat");
        r6.put("trigger_scene", "fixed_entry");
        r6.put("feature_key", "");
        r6.put("subs_type", "doubao_personal");
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r7 = ICommerceMembershipService.a.a();
        if (r7 == null) goto L56;
        String r8 = r7.A(r9.e());
        if (r8 != null) goto L53;
        r8 = r9.e();
    L53:
        uz8.c r12 = r7.z(r8);
        if (r12 == null) goto L56;
        String r13 = r12.f;
    L57:
        if (r13 != null) goto L59;
    L64:
        m r14 = r9.g();
        if (r14 == null) goto L73;
        String r15 = r14.c();
        if (r15 == null) goto L73;
        if ((!StringsKt.isBlank(r15)) == false) goto L71;
        r4 = r15;
    L71:
        if (r4 == null) goto L73;
        r6.put("button_name", r4);
    L73:
        Unit r16 = Unit.INSTANCE;
        goto L75
    L59:
        if ((!StringsKt.isBlank(r13)) == true) goto L62;
        r13 = null;
    L62:
        if (r13 == null) goto L64;
        r6.put("subs_purchase_id", r13);
    L56:
        r13 = null;
        goto L57
    L74:
        r6.put("current_page", "chat");
        goto L75
    L77:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L34
        Object r18 = Result.constructor-impl(new JSONObject(r5));     // Catch: Throwable -> L34
    L36:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L39;
        FLogger.a.w("BannerNestedMenuTracker", "parse tracking failed, error=" + r19.getMessage());
    L39:
        JSONObject r20 = new JSONObject();
        if (Result.isFailure-impl(r18) == false) goto L42;
        r18 = r20;
    L42:
        r6 = (JSONObject) r18;
    L34:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L28:
        if (StringsKt.isBlank(r5) == false) goto L30;
    L18:
        r11 = "action_banner_show";
        goto L25
    L19:
        if (r10 == false) goto L21;
        r11 = "click_subs_guidance";
        goto L25
    L21:
        r11 = "show_subs_guidance";
        goto L25
    L22:
        if (r10 == false) goto L24;
        r11 = "click_subs_quota_entry";
        goto L25
    L24:
        r11 = "show_subs_quota_entry";
        goto L25
    L80:
        return;
    L7:
        r1 = false;
        goto L8
    }
}
