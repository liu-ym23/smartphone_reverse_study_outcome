package com.larus.account.saas.security.risk;

import com.google.gson.annotations.SerializedName;
import com.larus.account.saas.core.internal.network.CommonResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0006R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/larus/account/saas/security/risk/j;", "T", "", "", "code", "I", "a", "()I", "setCode", "(I)V", "", "msg", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "data", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "payload", "getPayload", "setPayload", "account-saas-security_release"}, k = 1, mv = {1, 7, 1})
public final class j<T> {

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private T data;

    @SerializedName("msg")
    private String msg;

    @SerializedName("payload")
    private String payload;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.payload, r6.payload) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.code * 31;
        String r1 = this.msg;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        T r5 = this.data;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.payload;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", payload=" + this.payload + ')';
    }

    public j() {
        this.code = CommonResponse.CODE_UNKNOWN;
        this.msg = "";
        this.data = null;
        this.payload = null;
    }

    public final int a() {
        return this.code;
    }

    public final T b() {
        return this.data;
    }

    public final String c() {
        return this.msg;
    }
}
