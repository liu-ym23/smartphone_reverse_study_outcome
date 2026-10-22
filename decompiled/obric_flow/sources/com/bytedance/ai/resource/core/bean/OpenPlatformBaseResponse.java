package com.bytedance.ai.resource.core.bean;

import ai.j0;
import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import kk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J>\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0012\u0010\u0013\u001a\u00020\u00148Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformBaseResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "message", "", "data", "logId", "<init>", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLogId", "success", "", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Lcom/bytedance/ai/resource/core/bean/OpenPlatformBaseResponse;", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OpenPlatformBaseResponse<T> {
    private final int code;
    private final T data;

    @SerializedName("log_id")
    private final String logId;
    private final String message;

    public OpenPlatformBaseResponse() {
        int r5 = 0;
        String r10 = null;
        Object r11 = null;
        String r12 = null;
        this(r5, r10, r11, r12, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformBaseResponse copy$default(OpenPlatformBaseResponse r5, int r10, String r11, Object r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.code;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.message;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.data;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.logId;
    L15:
        return r5.copy(r10, r11, r12, r13);
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

    public final OpenPlatformBaseResponse<T> copy(int r5, String r10, T r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter(r12, "logId");
        return new OpenPlatformBaseResponse(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OpenPlatformBaseResponse) == true) goto L8;
        return false;
    L8:
        OpenPlatformBaseResponse r10 = (OpenPlatformBaseResponse) r5;
        if (this.code == r10.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r10.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r10.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.logId, r10.logId) == true) goto L20;
        return false;
    L20:
        return true;
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

    public final boolean getSuccess() {
        if (getCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        int r5 = Integer.hashCode(this.code) * 31;
        int r10 = a.b(this.message, r5, 31);
        T r11 = this.data;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = this.logId.hashCode();
        return r13 + ((r10 + r12) * 31);
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("OpenPlatformBaseResponse(code=");
        r5.append(this.code);
        r5.append(", message=");
        r5.append(this.message);
        r5.append(", data=");
        r5.append(this.data);
        r5.append(", logId=");
        return j0.p(r5, this.logId, ')');
    }

    public OpenPlatformBaseResponse(int r5, String r10, T r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter(r12, "logId");
        this.code = r5;
        this.message = r10;
        this.data = r11;
        this.logId = r12;
    }

    public /* synthetic */ OpenPlatformBaseResponse(int r5, String r10, Object r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = "";
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = null;
    L12:
        if ((r13 & 8) == 0) goto L14;
        r12 = "";
    L14:
        this(r5, r10, r11, r12);
    }
}
