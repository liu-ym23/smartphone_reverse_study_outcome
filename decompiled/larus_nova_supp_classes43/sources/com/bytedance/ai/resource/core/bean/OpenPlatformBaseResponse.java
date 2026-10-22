package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003JB\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0012\u0010\u0013\u001a\u00020\u00148Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformBaseResponse;", "T", "", "code", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "data", "logId", "<init>", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLogId", "success", "", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Lcom/bytedance/ai/resource/core/bean/OpenPlatformBaseResponse;", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformBaseResponse<T> {
    private final int code;
    private final T data;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_LOG_ID)
    private final String logId;
    private final String message;

    public OpenPlatformBaseResponse() {
        this(0, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformBaseResponse copy$default(OpenPlatformBaseResponse r0, int r1, String r10, Object r11, String r12, int r13, Object r14) {
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

    public final T component3() {
        return this.data;
    }

    public final String component4() {
        return this.logId;
    }

    public final OpenPlatformBaseResponse<T> copy(int r10, String r11, T r12, String r13) {
        return new OpenPlatformBaseResponse(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OpenPlatformBaseResponse) == true) goto L8;
        return false;
    L8:
        OpenPlatformBaseResponse r11 = (OpenPlatformBaseResponse) r10;
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
        T r13 = this.data;
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
        return "OpenPlatformBaseResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ", logId=" + this.logId + ')';
    }

    public final boolean getSuccess() {
        if (getCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMessage() {
        return this.message;
    }

    public OpenPlatformBaseResponse(int r1, String r10, T r11, String r12) {
        this.code = r1;
        this.message = r10;
        this.data = r11;
        this.logId = r12;
    }

    public /* synthetic */ OpenPlatformBaseResponse(int r10, String r11, Object r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = "";
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
