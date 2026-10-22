package com.larus.account.saas.security.risk;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/larus/account/saas/security/risk/l;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "content", "getContent", "", "action", "Ljava/lang/Integer;", "getAction", "()Ljava/lang/Integer;", "h5Url", "getH5Url", "toast", "getToast", "successToast", "getSuccessToast", "failToast", "getFailToast", "account-saas-security_release"}, k = 1, mv = {1, 7, 1})
public final class l {

    @SerializedName("action")
    private final Integer action;

    @SerializedName("content")
    private final String content;

    @SerializedName("failToast")
    private final String failToast;

    @SerializedName("h5_url")
    private final String h5Url;

    @SerializedName("successToast")
    private final String successToast;

    @SerializedName("title")
    private final String title;

    @SerializedName("toast")
    private final String toast;

    public l() {
        this.title = "";
        this.content = "";
        this.action = 3;
        this.h5Url = "";
        this.toast = "";
        this.successToast = "";
        this.failToast = "";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.h5Url, r6.h5Url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.toast, r6.toast) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.successToast, r6.successToast) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.failToast, r6.failToast) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.content;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.action;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.h5Url;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.toast;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.successToast;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r19 = (r15 + r17) * 31;
        String r20 = this.failToast;
        if (r20 == null) goto L31;
        r1 = r20.hashCode();
    L31:
        return r19 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "NetworkRiskInfoResponse(title=" + this.title + ", content=" + this.content + ", action=" + this.action + ", h5Url=" + this.h5Url + ", toast=" + this.toast + ", successToast=" + this.successToast + ", failToast=" + this.failToast + ')';
    }

    public final e48.b a() {
        String r0 = this.title;
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        String r1 = this.content;
        if (r1 != null) goto L9;
        String r3 = "";
    L10:
        Integer r4 = this.action;
        if (r4 == null) goto L13;
        int r5 = r4.intValue();
    L14:
        String r6 = this.h5Url;
        if (r6 != null) goto L17;
        String r7 = "";
    L18:
        String r8 = this.toast;
        if (r8 != null) goto L21;
        String r9 = "";
    L22:
        String r10 = this.successToast;
        if (r10 != null) goto L25;
        String r11 = "";
    L26:
        String r12 = this.failToast;
        if (r12 != null) goto L29;
        String r13 = "";
    L31:
        return new e48.b(r2, r3, r5, r7, r9, r11, r13);
    L29:
        r13 = r12;
        goto L31
    L25:
        r11 = r10;
        goto L26
    L21:
        r9 = r8;
        goto L22
    L17:
        r7 = r6;
        goto L18
    L13:
        r5 = 3;
        goto L14
    L9:
        r3 = r1;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }
}
