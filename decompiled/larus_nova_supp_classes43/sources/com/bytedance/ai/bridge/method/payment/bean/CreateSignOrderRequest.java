package com.bytedance.ai.bridge.method.payment.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/bean/CreateSignOrderRequest;", "", "data", "", "dbAuthorization", "appKey", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getDbAuthorization", "getAppKey", "getMessageId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateSignOrderRequest {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("data")
    private final String data;

    @SerializedName("db_authorization")
    private final String dbAuthorization;

    @SerializedName("message_id")
    private final String messageId;

    public CreateSignOrderRequest() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CreateSignOrderRequest copy$default(CreateSignOrderRequest r0, String r1, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r1 = r0.data;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = r0.dbAuthorization;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = r0.appKey;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12 = r0.messageId;
    L15:
        return r0.copy(r1, r10, r11, r12);
    }

    public final String component1() {
        return this.data;
    }

    public final String component2() {
        return this.dbAuthorization;
    }

    public final String component3() {
        return this.appKey;
    }

    public final String component4() {
        return this.messageId;
    }

    public final CreateSignOrderRequest copy(String r10, String r11, String r12, String r13) {
        return new CreateSignOrderRequest(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CreateSignOrderRequest) == true) goto L8;
        return false;
    L8:
        CreateSignOrderRequest r11 = (CreateSignOrderRequest) r10;
        if (Intrinsics.areEqual(this.data, r11.data) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dbAuthorization, r11.dbAuthorization) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.messageId, r11.messageId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.data;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.dbAuthorization;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.appKey;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.messageId;
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
        return "CreateSignOrderRequest(data=" + this.data + ", dbAuthorization=" + this.dbAuthorization + ", appKey=" + this.appKey + ", messageId=" + this.messageId + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getData() {
        return this.data;
    }

    public final String getDbAuthorization() {
        return this.dbAuthorization;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public CreateSignOrderRequest(String r1, String r10, String r11, String r12) {
        this.data = r1;
        this.dbAuthorization = r10;
        this.appKey = r11;
        this.messageId = r12;
    }

    public /* synthetic */ CreateSignOrderRequest(String r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = "";
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = "";
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
