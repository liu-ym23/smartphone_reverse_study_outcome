package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0003\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003JÃ\u0001\u0010<\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0003\u0010\u0015\u001a\u00020\u0005HÆ\u0001J\u0013\u0010=\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001b¨\u0006C"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/VerifyListStepInfo;", "Ljava/io/Serializable;", "defaultVerifyItem", "", "enableClientLoginMemory", "", "verifyFido", "Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;", "verifyMobileCode", "verifyEmailCode", "verifySpare", "verifyOtp", "verifyMo", "verifyPwd", "verifyQr", "verifyGoogle", "verifyApple", "verifySSO", "verifyDoubao", "authMethods", "Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethodList;", "usePackageDomain", "<init>", "(Ljava/lang/String;ZLcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethodList;Z)V", "getDefaultVerifyItem", "()Ljava/lang/String;", "getEnableClientLoginMemory", "()Z", "getVerifyFido", "()Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;", "getVerifyMobileCode", "getVerifyEmailCode", "getVerifySpare", "getVerifyOtp", "getVerifyMo", "getVerifyPwd", "getVerifyQr", "getVerifyGoogle", "getVerifyApple", "getVerifySSO", "getVerifyDoubao", "getAuthMethods", "()Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethodList;", "getUsePackageDomain", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "", "hashCode", "", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyListStepInfo implements Serializable {
    private final AuthMethodList authMethods;
    private final String defaultVerifyItem;
    private final boolean enableClientLoginMemory;
    private final boolean usePackageDomain;
    private final VerifyBean verifyApple;
    private final VerifyBean verifyDoubao;
    private final VerifyBean verifyEmailCode;
    private final VerifyBean verifyFido;
    private final VerifyBean verifyGoogle;
    private final VerifyBean verifyMo;
    private final VerifyBean verifyMobileCode;
    private final VerifyBean verifyOtp;
    private final VerifyBean verifyPwd;
    private final VerifyBean verifyQr;
    private final VerifyBean verifySSO;
    private final VerifyBean verifySpare;

    public static /* synthetic */ VerifyListStepInfo copy$default(VerifyListStepInfo r17, String r18, boolean r19, VerifyBean r20, VerifyBean r21, VerifyBean r22, VerifyBean r23, VerifyBean r24, VerifyBean r25, VerifyBean r26, VerifyBean r27, VerifyBean r28, VerifyBean r29, VerifyBean r30, VerifyBean r31, AuthMethodList r32, boolean r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        String r2 = r17.defaultVerifyItem;
    L7:
        if ((r34 & 2) == 0) goto L9;
        boolean r3 = r17.enableClientLoginMemory;
    L11:
        if ((r34 & 4) == 0) goto L13;
        VerifyBean r4 = r17.verifyFido;
    L15:
        if ((r34 & 8) == 0) goto L17;
        VerifyBean r5 = r17.verifyMobileCode;
    L19:
        if ((r34 & 16) == 0) goto L21;
        VerifyBean r6 = r17.verifyEmailCode;
    L23:
        if ((r34 & 32) == 0) goto L25;
        VerifyBean r7 = r17.verifySpare;
    L27:
        if ((r34 & 64) == 0) goto L29;
        VerifyBean r8 = r17.verifyOtp;
    L31:
        if ((r34 & 128) == 0) goto L33;
        VerifyBean r9 = r17.verifyMo;
    L35:
        if ((r34 & 256) == 0) goto L37;
        VerifyBean r10 = r17.verifyPwd;
    L39:
        if ((r34 & 512) == 0) goto L41;
        VerifyBean r11 = r17.verifyQr;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        VerifyBean r12 = r17.verifyGoogle;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        VerifyBean r13 = r17.verifyApple;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        VerifyBean r14 = r17.verifySSO;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        VerifyBean r15 = r17.verifyDoubao;
    L58:
        VerifyBean r36 = r15;
        if ((r34 & 16384) == 0) goto L61;
        AuthMethodList r16 = r17.authMethods;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        boolean r1 = r17.usePackageDomain;
    L67:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r16, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.defaultVerifyItem;
    }

    public final VerifyBean component10() {
        return this.verifyQr;
    }

    public final VerifyBean component11() {
        return this.verifyGoogle;
    }

    public final VerifyBean component12() {
        return this.verifyApple;
    }

    public final VerifyBean component13() {
        return this.verifySSO;
    }

    public final VerifyBean component14() {
        return this.verifyDoubao;
    }

    public final AuthMethodList component15() {
        return this.authMethods;
    }

    public final boolean component16() {
        return this.usePackageDomain;
    }

    public final boolean component2() {
        return this.enableClientLoginMemory;
    }

    public final VerifyBean component3() {
        return this.verifyFido;
    }

    public final VerifyBean component4() {
        return this.verifyMobileCode;
    }

    public final VerifyBean component5() {
        return this.verifyEmailCode;
    }

    public final VerifyBean component6() {
        return this.verifySpare;
    }

    public final VerifyBean component7() {
        return this.verifyOtp;
    }

    public final VerifyBean component8() {
        return this.verifyMo;
    }

    public final VerifyBean component9() {
        return this.verifyPwd;
    }

    public final VerifyListStepInfo copy(@JSONField(name = "default_verify_item") String r20, @JSONField(name = "enable_client_login_method_memory") boolean r21, @JSONField(name = "verify_fido") VerifyBean r22, @JSONField(name = "verify_code_mobile") VerifyBean r23, @JSONField(name = "verify_code_email") VerifyBean r24, @JSONField(name = "verify_code_spare") VerifyBean r25, @JSONField(name = "verify_otp") VerifyBean r26, @JSONField(name = "verify_mo") VerifyBean r27, @JSONField(name = "verify_pwd") VerifyBean r28, @JSONField(name = "verify_qr") VerifyBean r29, @JSONField(name = "verify_google") VerifyBean r30, @JSONField(name = "verify_apple") VerifyBean r31, @JSONField(name = "verify_b_idp") VerifyBean r32, @JSONField(name = "verify_dou_bao") VerifyBean r33, @JSONField(name = "verify_authn_methods") AuthMethodList r34, @JSONField(name = "use_package_domain") boolean r35) {
        Intrinsics.checkNotNullParameter(r20, "defaultVerifyItem");
        return new VerifyListStepInfo(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VerifyListStepInfo) == true) goto L8;
        return false;
    L8:
        VerifyListStepInfo r6 = (VerifyListStepInfo) r5;
        if (Intrinsics.areEqual(this.defaultVerifyItem, r6.defaultVerifyItem) == true) goto L12;
        return false;
    L12:
        if (this.enableClientLoginMemory == r6.enableClientLoginMemory) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.verifyFido, r6.verifyFido) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.verifyMobileCode, r6.verifyMobileCode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.verifyEmailCode, r6.verifyEmailCode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.verifySpare, r6.verifySpare) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.verifyOtp, r6.verifyOtp) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.verifyMo, r6.verifyMo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.verifyPwd, r6.verifyPwd) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.verifyQr, r6.verifyQr) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.verifyGoogle, r6.verifyGoogle) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.verifyApple, r6.verifyApple) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.verifySSO, r6.verifySSO) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.verifyDoubao, r6.verifyDoubao) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.authMethods, r6.authMethods) == true) goto L54;
        return false;
    L54:
        if (this.usePackageDomain == r6.usePackageDomain) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        int r0 = this.defaultVerifyItem.hashCode() * 31;
        int r2 = 1231;
        if (this.enableClientLoginMemory == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        VerifyBean r4 = this.verifyFido;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        VerifyBean r8 = this.verifyMobileCode;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        VerifyBean r11 = this.verifyEmailCode;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        VerifyBean r14 = this.verifySpare;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        VerifyBean r17 = this.verifyOtp;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        VerifyBean r20 = this.verifyMo;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        VerifyBean r23 = this.verifyPwd;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        VerifyBean r26 = this.verifyQr;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        VerifyBean r29 = this.verifyGoogle;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        VerifyBean r32 = this.verifyApple;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        VerifyBean r35 = this.verifySSO;
        if (r35 != null) goto L49;
        int r36 = 0;
    L50:
        int r37 = (r34 + r36) * 31;
        VerifyBean r38 = this.verifyDoubao;
        if (r38 != null) goto L53;
        int r39 = 0;
    L54:
        int r40 = (r37 + r39) * 31;
        AuthMethodList r41 = this.authMethods;
        if (r41 == null) goto L58;
        r5 = r41.hashCode();
    L58:
        int r42 = (r40 + r5) * 31;
        if (this.usePackageDomain == true) goto L63;
        r2 = 1237;
    L63:
        return r42 + r2;
    L53:
        r39 = r38.hashCode();
        goto L54
    L49:
        r36 = r35.hashCode();
        goto L50
    L45:
        r33 = r32.hashCode();
        goto L46
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "VerifyListStepInfo(defaultVerifyItem=" + this.defaultVerifyItem + ", enableClientLoginMemory=" + this.enableClientLoginMemory + ", verifyFido=" + this.verifyFido + ", verifyMobileCode=" + this.verifyMobileCode + ", verifyEmailCode=" + this.verifyEmailCode + ", verifySpare=" + this.verifySpare + ", verifyOtp=" + this.verifyOtp + ", verifyMo=" + this.verifyMo + ", verifyPwd=" + this.verifyPwd + ", verifyQr=" + this.verifyQr + ", verifyGoogle=" + this.verifyGoogle + ", verifyApple=" + this.verifyApple + ", verifySSO=" + this.verifySSO + ", verifyDoubao=" + this.verifyDoubao + ", authMethods=" + this.authMethods + ", usePackageDomain=" + this.usePackageDomain + ')';
    }

    public final AuthMethodList getAuthMethods() {
        return this.authMethods;
    }

    public final String getDefaultVerifyItem() {
        return this.defaultVerifyItem;
    }

    public final boolean getEnableClientLoginMemory() {
        return this.enableClientLoginMemory;
    }

    public final boolean getUsePackageDomain() {
        return this.usePackageDomain;
    }

    public final VerifyBean getVerifyApple() {
        return this.verifyApple;
    }

    public final VerifyBean getVerifyDoubao() {
        return this.verifyDoubao;
    }

    public final VerifyBean getVerifyEmailCode() {
        return this.verifyEmailCode;
    }

    public final VerifyBean getVerifyFido() {
        return this.verifyFido;
    }

    public final VerifyBean getVerifyGoogle() {
        return this.verifyGoogle;
    }

    public final VerifyBean getVerifyMo() {
        return this.verifyMo;
    }

    public final VerifyBean getVerifyMobileCode() {
        return this.verifyMobileCode;
    }

    public final VerifyBean getVerifyOtp() {
        return this.verifyOtp;
    }

    public final VerifyBean getVerifyPwd() {
        return this.verifyPwd;
    }

    public final VerifyBean getVerifyQr() {
        return this.verifyQr;
    }

    public final VerifyBean getVerifySSO() {
        return this.verifySSO;
    }

    public final VerifyBean getVerifySpare() {
        return this.verifySpare;
    }

    public VerifyListStepInfo(@JSONField(name = "default_verify_item") String r4, @JSONField(name = "enable_client_login_method_memory") boolean r5, @JSONField(name = "verify_fido") VerifyBean r6, @JSONField(name = "verify_code_mobile") VerifyBean r7, @JSONField(name = "verify_code_email") VerifyBean r8, @JSONField(name = "verify_code_spare") VerifyBean r9, @JSONField(name = "verify_otp") VerifyBean r10, @JSONField(name = "verify_mo") VerifyBean r11, @JSONField(name = "verify_pwd") VerifyBean r12, @JSONField(name = "verify_qr") VerifyBean r13, @JSONField(name = "verify_google") VerifyBean r14, @JSONField(name = "verify_apple") VerifyBean r15, @JSONField(name = "verify_b_idp") VerifyBean r16, @JSONField(name = "verify_dou_bao") VerifyBean r17, @JSONField(name = "verify_authn_methods") AuthMethodList r18, @JSONField(name = "use_package_domain") boolean r19) {
        Intrinsics.checkNotNullParameter(r4, "defaultVerifyItem");
        this.defaultVerifyItem = r4;
        this.enableClientLoginMemory = r5;
        this.verifyFido = r6;
        this.verifyMobileCode = r7;
        this.verifyEmailCode = r8;
        this.verifySpare = r9;
        this.verifyOtp = r10;
        this.verifyMo = r11;
        this.verifyPwd = r12;
        this.verifyQr = r13;
        this.verifyGoogle = r14;
        this.verifyApple = r15;
        this.verifySSO = r16;
        this.verifyDoubao = r17;
        this.authMethods = r18;
        this.usePackageDomain = r19;
    }

    public /* synthetic */ VerifyListStepInfo(String r19, boolean r20, VerifyBean r21, VerifyBean r22, VerifyBean r23, VerifyBean r24, VerifyBean r25, VerifyBean r26, VerifyBean r27, VerifyBean r28, VerifyBean r29, VerifyBean r30, VerifyBean r31, VerifyBean r32, AuthMethodList r33, boolean r34, int r35, DefaultConstructorMarker r36) {
        if ((r35 & 1) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r35 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r35 & 32768) == 0) goto L13;
        boolean r17 = false;
    L14:
        this(r2, r3, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r17);
        return;
    L13:
        r17 = r34;
        goto L14
    L9:
        r3 = r20;
        goto L11
    L5:
        r2 = r19;
        goto L7
    }
}
