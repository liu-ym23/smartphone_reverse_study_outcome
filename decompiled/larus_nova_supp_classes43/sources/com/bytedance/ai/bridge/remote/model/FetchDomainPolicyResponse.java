package com.bytedance.ai.bridge.remote.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/FetchDomainPolicyResponse;", "Ljava/io/Serializable;", "code", "", a.KEY_MSG, "", "data", "Lcom/bytedance/ai/bridge/remote/model/FetchDomainPolicyResponse$Data;", "logId", "<init>", "(ILjava/lang/String;Lcom/bytedance/ai/bridge/remote/model/FetchDomainPolicyResponse$Data;Ljava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/ai/bridge/remote/model/FetchDomainPolicyResponse$Data;", "getLogId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "Data", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FetchDomainPolicyResponse implements Serializable {

    @SerializedName("code")
    private final int code;

    @SerializedName("data")
    private final Data data;

    @SerializedName(a.KEY_LOG_ID)
    private final String logId;

    @SerializedName(a.KEY_MSG)
    private final String message;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/FetchDomainPolicyResponse$Data;", "Ljava/io/Serializable;", "signedPayload", "", "signature", "domainVerifySwitch", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getSignedPayload", "()Ljava/lang/String;", "getSignature", "getDomainVerifySwitch", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Data implements Serializable {

        @SerializedName("domain_verify_switch")
        private final boolean domainVerifySwitch;

        @SerializedName("signature")
        private final String signature;

        @SerializedName("signed_payload")
        private final String signedPayload;

        public Data() {
            this(null, null, false, 7, null);
        }

        public static /* synthetic */ Data copy$default(Data r0, String r1, String r10, boolean r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r1 = r0.signedPayload;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r10 = r0.signature;
        L9:
            if ((r12 & 4) == 0) goto L12;
            r11 = r0.domainVerifySwitch;
        L12:
            return r0.copy(r1, r10, r11);
        }

        public final String component1() {
            return this.signedPayload;
        }

        public final String component2() {
            return this.signature;
        }

        public final boolean component3() {
            return this.domainVerifySwitch;
        }

        public final Data copy(String r10, String r11, boolean r12) {
            return new Data(r10, r11, r12);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Data) == true) goto L8;
            return false;
        L8:
            Data r11 = (Data) r10;
            if (Intrinsics.areEqual(this.signedPayload, r11.signedPayload) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.signature, r11.signature) == true) goto L15;
            return false;
        L15:
            if (this.domainVerifySwitch == r11.domainVerifySwitch) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.signedPayload;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            String r12 = this.signature;
            if (r12 == null) goto L10;
            r1 = r12.hashCode();
        L10:
            int r13 = (r11 + r1) * 31;
            if (this.domainVerifySwitch == false) goto L13;
            int r14 = 1231;
        L15:
            return r13 + r14;
        L13:
            r14 = 1237;
            goto L15
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Data(signedPayload=" + this.signedPayload + ", signature=" + this.signature + ", domainVerifySwitch=" + this.domainVerifySwitch + ')';
        }

        public final boolean getDomainVerifySwitch() {
            return this.domainVerifySwitch;
        }

        public final String getSignature() {
            return this.signature;
        }

        public final String getSignedPayload() {
            return this.signedPayload;
        }

        public Data(String r1, String r10, boolean r11) {
            this.signedPayload = r1;
            this.signature = r10;
            this.domainVerifySwitch = r11;
        }

        public /* synthetic */ Data(String r10, String r11, boolean r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = null;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = null;
        L9:
            if ((r13 & 4) == 0) goto L11;
            r12 = true;
        L11:
            this(r10, r11, r12);
        }
    }

    public FetchDomainPolicyResponse() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ FetchDomainPolicyResponse copy$default(FetchDomainPolicyResponse r0, int r1, String r10, Data r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = r0.message;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = r0.data;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12 = r0.logId;
    L15:
        return r0.copy(r1, r10, r11, r12);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final Data component3() {
        return this.data;
    }

    public final String component4() {
        return this.logId;
    }

    public final FetchDomainPolicyResponse copy(int r10, String r11, Data r12, String r13) {
        return new FetchDomainPolicyResponse(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof FetchDomainPolicyResponse) == true) goto L8;
        return false;
    L8:
        FetchDomainPolicyResponse r11 = (FetchDomainPolicyResponse) r10;
        if (this.code == r11.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r11.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r11.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.logId, r11.logId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.code * 31;
        String r1 = this.message;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        Data r13 = this.data;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.logId;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return r15 + r10;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "FetchDomainPolicyResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ", logId=" + this.logId + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public final Data getData() {
        return this.data;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMessage() {
        return this.message;
    }

    public FetchDomainPolicyResponse(int r1, String r10, Data r11, String r12) {
        this.code = r1;
        this.message = r10;
        this.data = r11;
        this.logId = r12;
    }

    public /* synthetic */ FetchDomainPolicyResponse(int r10, String r11, Data r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = 0;
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
