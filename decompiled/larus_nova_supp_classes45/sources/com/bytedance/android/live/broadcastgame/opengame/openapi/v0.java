package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/openapi/v0;", "", "", LiveSlardarConstants.EXTRA_KEY_URL, "Ljava/lang/String;", "e", "()Ljava/lang/String;", "method", "c", "", "header", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "data", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "dataType", "getDataType", "responseType", "getResponseType", "", "timeout", "J", "d", "()J", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v0 {

    @SerializedName("data")
    private final Object data;

    @SerializedName("dataType")
    private final String dataType;

    @SerializedName("header")
    private final Map<String, String> header;

    @SerializedName("method")
    private final String method;

    @SerializedName("responseType")
    private final String responseType;

    @SerializedName("timeout")
    private final long timeout;

    @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
    private final String url;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof v0) == false) goto L20;
        v0 r6 = (v0) r5;
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.method, r6.method) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.header, r6.header) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.dataType, r6.dataType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.responseType, r6.responseType) == true) goto L18;
        return false;
    L18:
        if (this.timeout == r6.timeout) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.method;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, String> r7 = this.header;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Object r11 = this.data;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.dataType;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.responseType;
        if (r17 == null) goto L25;
        r1 = r17.hashCode();
    L25:
        int r18 = (r16 + r1) * 31;
        long r19 = this.timeout;
        return r18 + ((int) (r19 ^ (r19 >>> 32)));
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RequestParam(url=" + this.url + ", method=" + this.method + ", header=" + this.header + ", data=" + this.data + ", dataType=" + this.dataType + ", responseType=" + this.responseType + ", timeout=" + this.timeout + ")";
    }

    public final Object a() {
        return this.data;
    }

    public final Map<String, String> b() {
        return this.header;
    }

    public final String c() {
        return this.method;
    }

    public final long d() {
        return this.timeout;
    }

    public final String e() {
        return this.url;
    }
}
