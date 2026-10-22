package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JD\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0015\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethod;", "Ljava/io/Serializable;", "text", "", "desc", "actionType", "", "disabled", "", "disabledToastText", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getDesc", "getActionType", "()I", "getDisabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisabledToastText", "isIntercepted", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;)Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethod;", "equals", "other", "", "hashCode", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class AuthMethod implements Serializable {
    private final int actionType;
    private final String desc;
    private final Boolean disabled;
    private final String disabledToastText;
    private final String text;

    public AuthMethod() {
        this(null, null, 0, null, null, 31, null);
    }

    public static /* synthetic */ AuthMethod copy$default(AuthMethod r3, String r4, String r5, int r6, Boolean r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.text;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.desc;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.actionType;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.disabled;
    L14:
        Boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.disabledToastText;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.desc;
    }

    public final int component3() {
        return this.actionType;
    }

    public final Boolean component4() {
        return this.disabled;
    }

    public final String component5() {
        return this.disabledToastText;
    }

    public final AuthMethod copy(@JSONField(name = "text") String r8, @JSONField(name = "desc") String r9, @JSONField(name = "action_type") int r10, @JSONField(name = "disabled") Boolean r11, @JSONField(name = "disabled_toast_text") String r12) {
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r9, "desc");
        return new AuthMethod(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AuthMethod) == true) goto L8;
        return false;
    L8:
        AuthMethod r6 = (AuthMethod) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L15;
        return false;
    L15:
        if (this.actionType == r6.actionType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.disabled, r6.disabled) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.disabledToastText, r6.disabledToastText) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.text.hashCode() * 31) + this.desc.hashCode()) * 31) + this.actionType) * 31;
        Boolean r1 = this.disabled;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.disabledToastText;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "AuthMethod(text=" + this.text + ", desc=" + this.desc + ", actionType=" + this.actionType + ", disabled=" + this.disabled + ", disabledToastText=" + this.disabledToastText + ')';
    }

    public final boolean isIntercepted() {
        return Intrinsics.areEqual(this.disabled, Boolean.TRUE);
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Boolean getDisabled() {
        return this.disabled;
    }

    public final String getDisabledToastText() {
        return this.disabledToastText;
    }

    public final String getText() {
        return this.text;
    }

    public AuthMethod(@JSONField(name = "text") String r2, @JSONField(name = "desc") String r3, @JSONField(name = "action_type") int r4, @JSONField(name = "disabled") Boolean r5, @JSONField(name = "disabled_toast_text") String r6) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "desc");
        this.text = r2;
        this.desc = r3;
        this.actionType = r4;
        this.disabled = r5;
        this.disabledToastText = r6;
    }

    public /* synthetic */ AuthMethod(String r4, String r5, int r6, Boolean r7, String r8, int r9, DefaultConstructorMarker r10) {
        String r0 = "";
        if ((r9 & 1) == 0) goto L5;
        String r11 = "";
    L7:
        if ((r9 & 2) != 0) goto L11;
        r0 = r5;
    L11:
        if ((r9 & 4) == 0) goto L13;
        int r1 = 0;
    L15:
        if ((r9 & 8) == 0) goto L17;
        Boolean r2 = null;
    L19:
        if ((r9 & 16) == 0) goto L21;
        String r12 = null;
    L22:
        this(r11, r0, r1, r2, r12);
        return;
    L21:
        r12 = r8;
        goto L22
    L17:
        r2 = r7;
        goto L19
    L13:
        r1 = r6;
        goto L15
    L5:
        r11 = r4;
        goto L7
    }
}
