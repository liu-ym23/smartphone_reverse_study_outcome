package com.bytedance.android.ec.core.hybrid.prefetch;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/q;", "", "", "netStartTime", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "g", "(Ljava/lang/Long;)V", "netEndTime", "b", "f", "configReadStartTime", "getConfigReadStartTime", "setConfigReadStartTime", "configReadEndTime", "getConfigReadEndTime", "setConfigReadEndTime", "jsbStartTime", "getJsbStartTime", "e", "jsbEndTime", "getJsbEndTime", "d", "prefetchStartProcess", "getPrefetchStartProcess", "h", "prefetchStartRequest", "getPrefetchStartRequest", "i", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {
    public transient JSONObject a;
    public final transient Integer b;

    @SerializedName("native_config_read_end_time")
    private Long configReadEndTime;

    @SerializedName("native_config_read_start_time")
    private Long configReadStartTime;

    @SerializedName("native_jsb_end_time")
    private Long jsbEndTime;

    @SerializedName("native_jsb_start_time")
    private Long jsbStartTime;

    @SerializedName("native_net_end_time")
    private Long netEndTime;

    @SerializedName("native_net_start_time")
    private Long netStartTime;

    @SerializedName("na_prefetch_start_process")
    private Long prefetchStartProcess;

    @SerializedName("na_prefetch_start_request")
    private Long prefetchStartRequest;

    public q() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof q) == false) goto L26;
        q r11 = (q) r10;
        if (Intrinsics.areEqual(this.netStartTime, r11.netStartTime) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.netEndTime, r11.netEndTime) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.configReadStartTime, r11.configReadStartTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.configReadEndTime, r11.configReadEndTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.jsbStartTime, r11.jsbStartTime) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.jsbEndTime, r11.jsbEndTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prefetchStartProcess, r11.prefetchStartProcess) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.prefetchStartRequest, r11.prefetchStartRequest) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.netStartTime;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        Long r12 = this.netEndTime;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        Long r15 = this.configReadStartTime;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        Long r18 = this.configReadEndTime;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        Long r21 = this.jsbStartTime;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        Long r24 = this.jsbEndTime;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        Long r27 = this.prefetchStartProcess;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        Long r30 = this.prefetchStartRequest;
        if (r30 == null) goto L33;
        int r31 = r30.hashCode();
    L34:
        int r32 = (r29 + r31) * 31;
        JSONObject r33 = this.a;
        if (r33 == null) goto L37;
        int r34 = r33.hashCode();
    L38:
        int r35 = (r32 + r34) * 31;
        Integer r36 = this.b;
        if (r36 == null) goto L42;
        r1 = r36.hashCode();
    L42:
        return r35 + r1;
    L37:
        r34 = 0;
        goto L38
    L33:
        r31 = 0;
        goto L34
    L29:
        r28 = 0;
        goto L30
    L25:
        r25 = 0;
        goto L26
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "NativePrefetchTimeData(netStartTime=" + this.netStartTime + ", netEndTime=" + this.netEndTime + ", configReadStartTime=" + this.configReadStartTime + ", configReadEndTime=" + this.configReadEndTime + ", jsbStartTime=" + this.jsbStartTime + ", jsbEndTime=" + this.jsbEndTime + ", prefetchStartProcess=" + this.prefetchStartProcess + ", prefetchStartRequest=" + this.prefetchStartRequest + ", netDetail=" + this.a + ", configFrom=" + this.b + ")";
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("native_net_start_time", this.netStartTime);
        r0.putOpt("native_net_end_time", this.netEndTime);
        r0.putOpt("native_jsb_start_time", this.jsbStartTime);
        r0.putOpt("native_jsb_end_time", this.jsbEndTime);
        r0.putOpt("na_prefetch_start_process", this.prefetchStartProcess);
        r0.putOpt("na_prefetch_start_request", this.prefetchStartRequest);
        return r0;
    }

    public final Long b() {
        return this.netEndTime;
    }

    public final Long c() {
        return this.netStartTime;
    }

    public q(int r1) {
        this.netStartTime = null;
        this.netEndTime = null;
        this.configReadStartTime = null;
        this.configReadEndTime = null;
        this.jsbStartTime = null;
        this.jsbEndTime = null;
        this.prefetchStartProcess = null;
        this.prefetchStartRequest = null;
        this.a = null;
        this.b = null;
    }

    public final void d(Long r1) {
        this.jsbEndTime = r1;
    }

    public final void e(Long r1) {
        this.jsbStartTime = r1;
    }

    public final void f(Long r1) {
        this.netEndTime = r1;
    }

    public final void g(Long r1) {
        this.netStartTime = r1;
    }

    public final void h(Long r1) {
        this.prefetchStartProcess = r1;
    }

    public final void i(Long r1) {
        this.prefetchStartRequest = r1;
    }
}
