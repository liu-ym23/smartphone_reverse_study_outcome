package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/openapi/n;", "", "", "path", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "envId", "b", "serviceId", "f", "", "header", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "method", "d", "body", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "", "timeout", "J", "g", "()J", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("body")
    private final Object body;

    @SerializedName("envID")
    private final String envId;

    @SerializedName("header")
    private final Map<String, String> header;

    @SerializedName("method")
    private final String method;

    @SerializedName("path")
    private final String path;

    @SerializedName("serviceID")
    private final String serviceId;

    @SerializedName("timeout")
    private final long timeout;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof n) == false) goto L20;
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.path, r6.path) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.envId, r6.envId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.serviceId, r6.serviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.header, r6.header) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.method, r6.method) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.body, r6.body) == true) goto L18;
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
        String r0 = this.path;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.envId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.serviceId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, String> r11 = this.header;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.method;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        Object r17 = this.body;
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
        return "CloudRequestParam(path=" + this.path + ", envId=" + this.envId + ", serviceId=" + this.serviceId + ", header=" + this.header + ", method=" + this.method + ", body=" + this.body + ", timeout=" + this.timeout + ")";
    }

    public final Object a() {
        return this.body;
    }

    public final String b() {
        return this.envId;
    }

    public final Map<String, String> c() {
        return this.header;
    }

    public final String d() {
        return this.method;
    }

    public final String e() {
        return this.path;
    }

    public final String f() {
        return this.serviceId;
    }

    public final long g() {
        return this.timeout;
    }
}
