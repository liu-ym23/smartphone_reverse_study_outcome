package com.ss.android.lark.passport.flow.verify.viewmodel;

import androidx.lifecycle.ViewModel;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession;
import com.ss.android.lark.passport.flow.mfa.FlowVerifyFactor;
import com.ss.android.lark.passport.flow.mfa.o;
import com.ss.android.lark.passport.flow.verify.entity.AuthMethod;
import com.ss.android.lark.passport.flow.verify.entity.AuthMethodList;
import com.ss.android.lark.passport.flow.verify.entity.VerifyBean;
import com.ss.android.lark.passport.flow.verify.entity.VerifyListStepInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\b\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_repo", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "flowId", "", "repo", "Lkotlinx/coroutines/flow/StateFlow;", "getRepo", "()Lkotlinx/coroutines/flow/StateFlow;", "init", "", "defaultVerifyItem", "stepInfo", "Lcom/ss/android/lark/passport/flow/verify/entity/VerifyListStepInfo;", "flowSession", "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaFlowSession;", "flowSession$flow_passport_mfa_release", "params", "", "getParams", "()Ljava/util/Map;", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyCommonViewModel extends ViewModel {
    private final z0<xyb.a> _repo;
    private String flowId;
    private final i1<xyb.a> repo;

    public final FlowMfaFlowSession flowSession$flow_passport_mfa_release() {
        String r0 = this.flowId;
        if (r0 != null) goto L7;
        return null;
    L7:
        return o.a(r0);
    }

    public final Map<String, String> getParams() {
        return MapsKt.mapOf(TuplesKt.to("flow_type", ((xyb.a) this._repo.getValue()).e.getFlowType()));
    }

    public VerifyCommonViewModel() {
        StateFlowImpl r0 = j1.a(new xyb.a());
        this._repo = r0;
        this.repo = e.b(r0);
    }

    public final i1<xyb.a> getRepo() {
        return this.repo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final void init(String r10, VerifyListStepInfo r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "stepInfo");
        this.flowId = r12;
        z0<xyb.a> r13 = this._repo;
        xyb.a r1 = new xyb.a();
        Intrinsics.checkNotNullParameter(r11, "stepInfo");
        r1.b = r11;
        String r0 = r11.getDefaultVerifyItem();
        r1.c(ButtonType.VERIFY_FIDO.getValue(), r11.getVerifyFido());
        r1.c(ButtonType.VERIFY_OTP.getValue(), r11.getVerifyOtp());
        r1.c(ButtonType.VERIFY_PHONE.getValue(), r11.getVerifyMobileCode());
        r1.c(ButtonType.VERIFY_EMAIL.getValue(), r11.getVerifyEmailCode());
        r1.c(ButtonType.VERIFY_SPARE.getValue(), r11.getVerifySpare());
        r1.c(ButtonType.VERIFY_MO.getValue(), r11.getVerifyMo());
        r1.c(ButtonType.VERIFY_PASSWORD.getValue(), r11.getVerifyPwd());
        r1.c(ButtonType.QR_LOGIN_SHOW.getValue(), r11.getVerifyQr());
        r1.c(ButtonType.VERIFY_B_IDP.getValue(), r11.getVerifySSO());
        r1.c(ButtonType.VERIFY_GOOGLE.getValue(), r11.getVerifyGoogle());
        r1.c(ButtonType.VERIFY_APPLE_ID.getValue(), r11.getVerifyApple());
        r1.c(ButtonType.VERIFY_DOUBAO.getValue(), r11.getVerifyDoubao());
        AuthMethodList r14 = r11.getAuthMethods();
        Object r3 = null;
        if (r14 == null) goto L22;
        ArrayList<AuthMethod> r4 = r14.getAuthMethodList();
        if (r4 == null) goto L12;
        ?? r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        Object r7 = r6.next();
        FlowVerifyFactor.a r8 = FlowVerifyFactor.Companion;
        int r9 = ((AuthMethod) r7).getActionType();
        r8.getClass();
        if (FlowVerifyFactor.a.b(r9) == false) goto L8;
        r5.add(r7);
    L13:
        if (r5 != 0) goto L15;
        r5 = CollectionsKt.emptyList();
    L15:
        ArrayList r15 = (ArrayList) r5;
        if (r15 == null) goto L21;
        Iterator r16 = r15.iterator();
    L19:
        if (r16.hasNext() == false) goto L21;
        AuthMethod r17 = (AuthMethod) r16.next();
        r1.c.put(Integer.valueOf(r17.getActionType()), r17);
    L21:
        r1.f = new AuthMethodList(r14.getTitle(), r15);
        PassportLog.d("StepInfoRepository", "authMethodList is " + r1.f);
        goto L22
    L12:
        r5 = 0;
    L22:
        String r18 = "server";
        if (r10 == null) goto L36;
        AuthMethodList r19 = r1.f;
        if (r19 == null) goto L34;
        ArrayList<AuthMethod> r20 = r19.getAuthMethodList();
        if (r20 == null) goto L34;
        Iterator r21 = r20.iterator();
    L30:
        if (r21.hasNext() == false) goto L34;
        if (Intrinsics.areEqual(xyb.a.g.get(Integer.valueOf(((AuthMethod) r21.next()).getActionType())), r10) == false) goto L30;
        r18 = "local";
    L35:
        r0 = r10;
    L34:
        r10 = r0;
    L36:
        PassportLog.d("StepInfoRepository", "Identify defaultVerifyItem = " + r0 + ", verifyItemSource = " + r18);
        if (r0 != null) goto L39;
    L89:
        int r110 = ButtonType.NORMAL.getValue();
    L90:
        AuthMethodList r111 = r1.f;
        if (r111 == null) goto L111;
        ArrayList<AuthMethod> r112 = r111.getAuthMethodList();
        if (r112 == null) goto L111;
        Iterator r113 = r112.iterator();
    L96:
        if (r113.hasNext() == false) goto L107;
        Object r2 = r113.next();
        AuthMethod r22 = (AuthMethod) r2;
        if (r22.getActionType() == r110) goto L100;
    L104:
        boolean r23 = false;
    L105:
        if (r23 == false) goto L96;
    L108:
        AuthMethod r24 = (AuthMethod) r2;
        if (r24 == null) goto L111;
        r110 = r24.getActionType();
    L146:
        r1.a = r110;
        VerifyBean r114 = (VerifyBean) ((LinkedHashMap) r1.d).get(Integer.valueOf(r110));
        if (r114 == null) goto L149;
        r1.e = r114;
    L149:
        r13.setValue(r1);
        return;
    L100:
        if (((LinkedHashMap) r1.d).get(Integer.valueOf(r22.getActionType())) == null) goto L104;
        if (r1.d(r22.getActionType()) == true) goto L104;
        r23 = true;
        goto L105
    L107:
        r2 = null;
    L111:
        AuthMethodList r115 = r1.f;
        if (r115 == null) goto L123;
        ArrayList<AuthMethod> r116 = r115.getAuthMethodList();
        if (r116 == null) goto L123;
        Iterator r117 = r116.iterator();
    L117:
        if (r117.hasNext() == false) goto L123;
        AuthMethod r25 = (AuthMethod) r117.next();
        if (((LinkedHashMap) r1.d).get(Integer.valueOf(r25.getActionType())) == null) goto L117;
        if (r1.d(r25.getActionType()) == true) goto L117;
        r110 = r25.getActionType();
    L123:
        AuthMethodList r118 = r1.f;
        if (r118 == null) goto L134;
        ArrayList<AuthMethod> r119 = r118.getAuthMethodList();
        if (r119 == null) goto L134;
        Iterator r120 = r119.iterator();
    L129:
        if (r120.hasNext() == false) goto L134;
        AuthMethod r26 = (AuthMethod) r120.next();
        if (((LinkedHashMap) r1.d).get(Integer.valueOf(r26.getActionType())) == null) goto L129;
        r110 = r26.getActionType();
    L134:
        if (((LinkedHashMap) r1.d).get(Integer.valueOf(r110)) != null) goto L146;
        Iterator r121 = ((LinkedHashMap) r1.d).keySet().iterator();
    L138:
        if (r121.hasNext() == false) goto L142;
        Object r122 = r121.next();
        int r27 = ((Number) r122).intValue();
        FlowVerifyFactor.Companion.getClass();
        if (FlowVerifyFactor.a.b(r27) == false) goto L138;
        r3 = r122;
    L142:
        Integer r28 = (Integer) r3;
        if (r28 == null) goto L145;
        r110 = r28.intValue();
        goto L146
    L145:
        r110 = ButtonType.NORMAL.getValue();
        goto L146
    L39:
        switch(r0.hashCode()) {
            case -1948677996: goto L86;
            case -1695880408: goto L82;
            case -1695880281: goto L78;
            case -1655935408: goto L74;
            case -1642916469: goto L70;
            case -1032682907: goto L66;
            case -1032681865: goto L62;
            case -283873260: goto L58;
            case -283463150: goto L54;
            case -39319361: goto L50;
            case 418849237: goto L46;
            case 436520046: goto L42;
            default: goto L89;
        };
    L42:
        if (r0.equals("verify_code_mobile") == false) goto L89;
        r110 = ButtonType.VERIFY_PHONE.getValue();
        goto L90
    L46:
        if (r0.equals("verify_dou_bao") == false) goto L89;
        r110 = ButtonType.VERIFY_DOUBAO.getValue();
        goto L90
    L50:
        if (r0.equals("verify_google") == false) goto L89;
        r110 = ButtonType.VERIFY_GOOGLE.getValue();
        goto L90
    L54:
        if (r0.equals("verify_b_idp") == false) goto L89;
        r110 = ButtonType.VERIFY_B_IDP.getValue();
        goto L90
    L58:
        if (r0.equals("verify_apple") == false) goto L89;
        r110 = ButtonType.VERIFY_APPLE_ID.getValue();
        goto L90
    L62:
        if (r0.equals("verify_pwd") == false) goto L89;
        r110 = ButtonType.VERIFY_PASSWORD.getValue();
        goto L90
    L66:
        if (r0.equals("verify_otp") == false) goto L89;
        r110 = ButtonType.VERIFY_OTP.getValue();
        goto L90
    L70:
        if (r0.equals("verify_code_spare") == false) goto L89;
        r110 = ButtonType.VERIFY_SPARE.getValue();
        goto L90
    L74:
        if (r0.equals("verify_code_email") == false) goto L89;
        r110 = ButtonType.VERIFY_EMAIL.getValue();
        goto L90
    L78:
        if (r0.equals("verify_qr") == false) goto L89;
        r110 = ButtonType.QR_LOGIN_SHOW.getValue();
        goto L90
    L82:
        if (r0.equals("verify_mo") == false) goto L89;
        r110 = ButtonType.VERIFY_MO.getValue();
        goto L90
    L86:
        if (r0.equals("verify_fido") == false) goto L89;
        r110 = ButtonType.VERIFY_FIDO.getValue();
        goto L90
    }
}
