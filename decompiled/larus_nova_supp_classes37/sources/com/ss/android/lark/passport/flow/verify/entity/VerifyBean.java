package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.passport.flow.core.security.RsaInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\u001c\b\u0003\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\fHÆ\u0003J\u001d\u0010@\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018HÆ\u0003JÂ\u0001\u0010A\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\f2\u001c\b\u0003\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020GHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R%\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u0006I"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;", "Ljava/io/Serializable;", "title", "", "subTitle", "flowType", "disabled", "", "disabledToastText", "inputBox", "Lcom/ss/android/lark/passport/flow/verify/entity/InputBean;", "nextButton", "Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;", "retrieveButton", "switchButton", "Lcom/ss/android/lark/passport/flow/verify/entity/SwitchButton;", "rsaInfo", "Lcom/ss/android/lark/passport/flow/core/security/RsaInfo;", "regExp", "formatErrText", "sendMoButton", "moTextList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/passport/flow/verify/entity/MoTextBean;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/ss/android/lark/passport/flow/verify/entity/InputBean;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;Lcom/ss/android/lark/passport/flow/verify/entity/SwitchButton;Lcom/ss/android/lark/passport/flow/core/security/RsaInfo;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;Ljava/util/ArrayList;)V", "getTitle", "()Ljava/lang/String;", "getSubTitle", "getFlowType", "getDisabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisabledToastText", "getInputBox", "()Lcom/ss/android/lark/passport/flow/verify/entity/InputBean;", "getNextButton", "()Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;", "getRetrieveButton", "getSwitchButton", "()Lcom/ss/android/lark/passport/flow/verify/entity/SwitchButton;", "getRsaInfo", "()Lcom/ss/android/lark/passport/flow/core/security/RsaInfo;", "getRegExp", "getFormatErrText", "getSendMoButton", "getMoTextList", "()Ljava/util/ArrayList;", "isIntercepted", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/ss/android/lark/passport/flow/verify/entity/InputBean;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;Lcom/ss/android/lark/passport/flow/verify/entity/SwitchButton;Lcom/ss/android/lark/passport/flow/core/security/RsaInfo;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;Ljava/util/ArrayList;)Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;", "equals", "other", "", "hashCode", "", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyBean implements Serializable {
    private final Boolean disabled;
    private final String disabledToastText;
    private final String flowType;
    private final String formatErrText;
    private final InputBean inputBox;
    private final ArrayList<MoTextBean> moTextList;
    private final ButtonBean nextButton;
    private final String regExp;
    private final ButtonBean retrieveButton;
    private final RsaInfo rsaInfo;
    private final ButtonBean sendMoButton;
    private final String subTitle;
    private final SwitchButton switchButton;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VerifyBean copy$default(VerifyBean r15, String r16, String r17, String r18, Boolean r19, String r20, InputBean r21, ButtonBean r22, ButtonBean r23, SwitchButton r24, RsaInfo r25, String r26, String r27, ButtonBean r28, ArrayList r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        String r2 = r15.title;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r3 = r15.subTitle;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r4 = r15.flowType;
    L15:
        if ((r30 & 8) == 0) goto L17;
        Boolean r5 = r15.disabled;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r6 = r15.disabledToastText;
    L23:
        if ((r30 & 32) == 0) goto L25;
        InputBean r7 = r15.inputBox;
    L27:
        if ((r30 & 64) == 0) goto L29;
        ButtonBean r8 = r15.nextButton;
    L31:
        if ((r30 & 128) == 0) goto L33;
        ButtonBean r9 = r15.retrieveButton;
    L35:
        if ((r30 & 256) == 0) goto L37;
        SwitchButton r10 = r15.switchButton;
    L39:
        if ((r30 & 512) == 0) goto L41;
        RsaInfo r11 = r15.rsaInfo;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r12 = r15.regExp;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r13 = r15.formatErrText;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        ButtonBean r14 = r15.sendMoButton;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        ArrayList r1 = r15.moTextList;
    L59:
        return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L57:
        r1 = r29;
        goto L59
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final String component1() {
        return this.title;
    }

    public final RsaInfo component10() {
        return this.rsaInfo;
    }

    public final String component11() {
        return this.regExp;
    }

    public final String component12() {
        return this.formatErrText;
    }

    public final ButtonBean component13() {
        return this.sendMoButton;
    }

    public final ArrayList<MoTextBean> component14() {
        return this.moTextList;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final String component3() {
        return this.flowType;
    }

    public final Boolean component4() {
        return this.disabled;
    }

    public final String component5() {
        return this.disabledToastText;
    }

    public final InputBean component6() {
        return this.inputBox;
    }

    public final ButtonBean component7() {
        return this.nextButton;
    }

    public final ButtonBean component8() {
        return this.retrieveButton;
    }

    public final SwitchButton component9() {
        return this.switchButton;
    }

    public final VerifyBean copy(@JSONField(name = "title") String r17, @JSONField(name = "subtitle") String r18, @JSONField(name = "flow_type") String r19, @JSONField(name = "disabled") Boolean r20, @JSONField(name = "disabled_toast_text") String r21, @JSONField(name = "input_box") InputBean r22, @JSONField(name = "next_button") ButtonBean r23, @JSONField(name = "retrieve_button") ButtonBean r24, @JSONField(name = "switch_button") SwitchButton r25, @JSONField(name = "rsa_info") RsaInfo r26, @JSONField(name = "reg_exp") String r27, @JSONField(name = "format_err_text") String r28, @JSONField(name = "send_mo_button") ButtonBean r29, @JSONField(name = "mo_text") ArrayList<MoTextBean> r30) {
        Intrinsics.checkNotNullParameter(r17, "title");
        Intrinsics.checkNotNullParameter(r18, "subTitle");
        Intrinsics.checkNotNullParameter(r19, "flowType");
        return new VerifyBean(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VerifyBean) == true) goto L8;
        return false;
    L8:
        VerifyBean r6 = (VerifyBean) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitle, r6.subTitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.flowType, r6.flowType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.disabled, r6.disabled) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.disabledToastText, r6.disabledToastText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.inputBox, r6.inputBox) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.nextButton, r6.nextButton) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.retrieveButton, r6.retrieveButton) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.switchButton, r6.switchButton) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.rsaInfo, r6.rsaInfo) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.regExp, r6.regExp) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.formatErrText, r6.formatErrText) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.sendMoButton, r6.sendMoButton) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.moTextList, r6.moTextList) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.title.hashCode() * 31) + this.subTitle.hashCode()) * 31) + this.flowType.hashCode()) * 31;
        Boolean r1 = this.disabled;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.disabledToastText;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        InputBean r8 = this.inputBox;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        ButtonBean r11 = this.nextButton;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        ButtonBean r14 = this.retrieveButton;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        SwitchButton r17 = this.switchButton;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        RsaInfo r20 = this.rsaInfo;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.regExp;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.formatErrText;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        ButtonBean r29 = this.sendMoButton;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        ArrayList<MoTextBean> r32 = this.moTextList;
        if (r32 == null) goto L47;
        r2 = r32.hashCode();
    L47:
        return r31 + r2;
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
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "VerifyBean(title=" + this.title + ", subTitle=" + this.subTitle + ", flowType=" + this.flowType + ", disabled=" + this.disabled + ", disabledToastText=" + this.disabledToastText + ", inputBox=" + this.inputBox + ", nextButton=" + this.nextButton + ", retrieveButton=" + this.retrieveButton + ", switchButton=" + this.switchButton + ", rsaInfo=" + this.rsaInfo + ", regExp=" + this.regExp + ", formatErrText=" + this.formatErrText + ", sendMoButton=" + this.sendMoButton + ", moTextList=" + this.moTextList + ')';
    }

    public final boolean isIntercepted() {
        return Intrinsics.areEqual(this.disabled, Boolean.TRUE);
    }

    public final Boolean getDisabled() {
        return this.disabled;
    }

    public final String getDisabledToastText() {
        return this.disabledToastText;
    }

    public final String getFlowType() {
        return this.flowType;
    }

    public final String getFormatErrText() {
        return this.formatErrText;
    }

    public final InputBean getInputBox() {
        return this.inputBox;
    }

    public final ArrayList<MoTextBean> getMoTextList() {
        return this.moTextList;
    }

    public final ButtonBean getNextButton() {
        return this.nextButton;
    }

    public final String getRegExp() {
        return this.regExp;
    }

    public final ButtonBean getRetrieveButton() {
        return this.retrieveButton;
    }

    public final RsaInfo getRsaInfo() {
        return this.rsaInfo;
    }

    public final ButtonBean getSendMoButton() {
        return this.sendMoButton;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final SwitchButton getSwitchButton() {
        return this.switchButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public VerifyBean(@JSONField(name = "title") String r2, @JSONField(name = "subtitle") String r3, @JSONField(name = "flow_type") String r4, @JSONField(name = "disabled") Boolean r5, @JSONField(name = "disabled_toast_text") String r6, @JSONField(name = "input_box") InputBean r7, @JSONField(name = "next_button") ButtonBean r8, @JSONField(name = "retrieve_button") ButtonBean r9, @JSONField(name = "switch_button") SwitchButton r10, @JSONField(name = "rsa_info") RsaInfo r11, @JSONField(name = "reg_exp") String r12, @JSONField(name = "format_err_text") String r13, @JSONField(name = "send_mo_button") ButtonBean r14, @JSONField(name = "mo_text") ArrayList<MoTextBean> r15) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "subTitle");
        Intrinsics.checkNotNullParameter(r4, "flowType");
        this.title = r2;
        this.subTitle = r3;
        this.flowType = r4;
        this.disabled = r5;
        this.disabledToastText = r6;
        this.inputBox = r7;
        this.nextButton = r8;
        this.retrieveButton = r9;
        this.switchButton = r10;
        this.rsaInfo = r11;
        this.regExp = r12;
        this.formatErrText = r13;
        this.sendMoButton = r14;
        this.moTextList = r15;
    }

    public /* synthetic */ VerifyBean(String r19, String r20, String r21, Boolean r22, String r23, InputBean r24, ButtonBean r25, ButtonBean r26, SwitchButton r27, RsaInfo r28, String r29, String r30, ButtonBean r31, ArrayList r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r33 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r33 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r33 & 8) == 0) goto L17;
        Boolean r7 = null;
    L19:
        if ((r33 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r33 & 1024) == 0) goto L25;
        String r14 = "";
    L27:
        if ((r33 & 2048) == 0) goto L29;
        String r15 = "";
    L31:
        if ((r33 & 8192) == 0) goto L33;
        ArrayList r17 = new ArrayList();
    L34:
        this(r4, r5, r6, r7, r8, r24, r25, r26, r27, r28, r14, r15, r31, r17);
        return;
    L33:
        r17 = r32;
        goto L34
    L29:
        r15 = r30;
        goto L31
    L25:
        r14 = r29;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }
}
