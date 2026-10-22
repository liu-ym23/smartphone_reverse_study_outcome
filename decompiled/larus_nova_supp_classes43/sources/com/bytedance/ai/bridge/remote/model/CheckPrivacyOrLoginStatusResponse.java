package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/CheckPrivacyOrLoginStatusResponse;", "Ljava/io/Serializable;", "errCode", "", "errMsg", "", "data", "Lcom/bytedance/ai/bridge/remote/model/PrivacyData;", "alreadyLogin", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/PrivacyData;Ljava/lang/Boolean;)V", "getErrCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrMsg", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/ai/bridge/remote/model/PrivacyData;", "getAlreadyLogin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/PrivacyData;Ljava/lang/Boolean;)Lcom/bytedance/ai/bridge/remote/model/CheckPrivacyOrLoginStatusResponse;", "equals", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckPrivacyOrLoginStatusResponse implements Serializable {

    @SerializedName("already_login")
    private final Boolean alreadyLogin;

    @SerializedName("data")
    private final PrivacyData data;

    @SerializedName("err_code")
    private final Integer errCode;

    @SerializedName("err_msg")
    private final String errMsg;

    public CheckPrivacyOrLoginStatusResponse() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CheckPrivacyOrLoginStatusResponse copy$default(CheckPrivacyOrLoginStatusResponse r0, Integer r1, String r10, PrivacyData r11, Boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r1 = r0.errCode;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = r0.errMsg;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = r0.data;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12 = r0.alreadyLogin;
    L15:
        return r0.copy(r1, r10, r11, r12);
    }

    public final Integer component1() {
        return this.errCode;
    }

    public final String component2() {
        return this.errMsg;
    }

    public final PrivacyData component3() {
        return this.data;
    }

    public final Boolean component4() {
        return this.alreadyLogin;
    }

    public final CheckPrivacyOrLoginStatusResponse copy(Integer r10, String r11, PrivacyData r12, Boolean r13) {
        return new CheckPrivacyOrLoginStatusResponse(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CheckPrivacyOrLoginStatusResponse) == true) goto L8;
        return false;
    L8:
        CheckPrivacyOrLoginStatusResponse r11 = (CheckPrivacyOrLoginStatusResponse) r10;
        if (Intrinsics.areEqual(this.errCode, r11.errCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errMsg, r11.errMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r11.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.alreadyLogin, r11.alreadyLogin) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.errCode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.errMsg;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        PrivacyData r15 = this.data;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        Boolean r18 = this.alreadyLogin;
        if (r18 == null) goto L19;
        r1 = r18.hashCode();
    L19:
        return r17 + r1;
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CheckPrivacyOrLoginStatusResponse(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", data=" + this.data + ", alreadyLogin=" + this.alreadyLogin + ')';
    }

    public final Boolean getAlreadyLogin() {
        return this.alreadyLogin;
    }

    public final PrivacyData getData() {
        return this.data;
    }

    public final Integer getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public CheckPrivacyOrLoginStatusResponse(Integer r1, String r10, PrivacyData r11, Boolean r12) {
        this.errCode = r1;
        this.errMsg = r10;
        this.data = r11;
        this.alreadyLogin = r12;
    }

    public /* synthetic */ CheckPrivacyOrLoginStatusResponse(Integer r10, String r11, PrivacyData r12, Boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
