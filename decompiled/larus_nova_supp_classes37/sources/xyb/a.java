package xyb;

import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.mfa.FlowVerifyFactor;
import com.ss.android.lark.passport.flow.verify.entity.AuthMethod;
import com.ss.android.lark.passport.flow.verify.entity.AuthMethodList;
import com.ss.android.lark.passport.flow.verify.entity.VerifyBean;
import com.ss.android.lark.passport.flow.verify.entity.VerifyListStepInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final Map<Integer, String> g = null;
    public int a;
    public VerifyListStepInfo b;
    public final Map<Integer, AuthMethod> c;
    public final Map<Integer, VerifyBean> d;
    public VerifyBean e;
    public AuthMethodList f;

    /* JADX INFO: renamed from: xyb.a$a, reason: collision with other inner class name */
    public static final class C0205a {
    }

    static {
        g = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_PHONE.getValue()), "verify_code_mobile"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_EMAIL.getValue()), "verify_code_email"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_SPARE.getValue()), "verify_code_spare"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_OTP.getValue()), "verify_otp"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_FIDO.getValue()), "verify_fido"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_PASSWORD.getValue()), "verify_pwd"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_MO.getValue()), "verify_mo"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_B_IDP.getValue()), "verify_b_idp"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_GOOGLE.getValue()), "verify_google"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_APPLE_ID.getValue()), "verify_apple"), TuplesKt.to(Integer.valueOf(ButtonType.QR_LOGIN_SHOW.getValue()), "verify_qr"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_DOUBAO.getValue()), "verify_dou_bao")});
    }

    public a() {
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new VerifyBean("", "", "", Boolean.FALSE, "", null, null, null, null, null, null, null, null, null);
    }

    public final String a(int r6) {
        if (d(r6) == true) goto L5;
        return null;
    L5:
        AuthMethod r0 = (AuthMethod) ((LinkedHashMap) this.c).get(Integer.valueOf(r6));
        boolean r2 = false;
        if (r0 == null) goto L18;
        String r1 = r0.getDisabledToastText();
        if (r1 == null) goto L18;
        if (r1.length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        r1 = null;
    L16:
        if (r1 == null) goto L18;
        return r1;
    L12:
        r4 = false;
    L18:
        VerifyBean r7 = (VerifyBean) ((LinkedHashMap) this.d).get(Integer.valueOf(r6));
        if (r7 == null) goto L29;
        String r8 = r7.getDisabledToastText();
        if (r8 != null) goto L23;
        return null;
    L23:
        if (r8.length() <= 0) goto L25;
        r2 = true;
    L25:
        if (r2 == true) goto L27;
        return null;
    L27:
        return r8;
    L29:
        return null;
    }

    public final AuthMethod b(int r2) {
        Map<Integer, AuthMethod> r0 = this.c;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        return (AuthMethod) r1.get(Integer.valueOf(r2));
    }

    public final boolean d(int r4) {
        Map<Integer, AuthMethod> r0 = this.c;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        AuthMethod r2 = (AuthMethod) r1.get(Integer.valueOf(r4));
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L19;
        Map<Integer, VerifyBean> r5 = this.d;
        LinkedHashMap r6 = (LinkedHashMap) r5;
        VerifyBean r7 = (VerifyBean) r6.get(Integer.valueOf(r4));
        if (r7 != null) goto L12;
    L14:
        boolean r8 = false;
    L15:
        if (r8 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r7.isIntercepted() != true) goto L14;
        r8 = true;
        goto L15
    L19:
        return true;
    L5:
        if (r2.isIntercepted() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void c(int r2, VerifyBean r3) {
        if (r3 == null) goto L7;
        FlowVerifyFactor.Companion.getClass();
        if (FlowVerifyFactor.a.b(r2) == false) goto L8;
        Integer r4 = Integer.valueOf(r2);
        this.d.put(r4, r3);
        return;
    L8:
        return;
    }
}
