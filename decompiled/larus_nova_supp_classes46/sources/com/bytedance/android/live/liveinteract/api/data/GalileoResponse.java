package com.bytedance.android.live.liveinteract.api.data;

import am3.g;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.multilink.base.model.h;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J;\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R\u001a\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/data/GalileoResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/h;", "", "component1", "component2", "component3", "component4", "component5", "speedShakeMillSecond", "acceleratedThreshold", "minShakeInterval", "shakeEndTimeIntervalThreshold", "shakeIntervalMillSecond", "copy", "", "toString", "", "hashCode", "", PbRequest.SwitchType.OTHER, "", "equals", "D", "getSpeedShakeMillSecond", "()D", "getAcceleratedThreshold", "getMinShakeInterval", "getShakeEndTimeIntervalThreshold", "getShakeIntervalMillSecond", "<init>", "(DDDDD)V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GalileoResponse extends FlexModelBase<h> implements h, vh7.h {

    @SerializedName("accelerameter_threshold")
    protected double acceleratedThreshold;

    @SerializedName("min_shake_interval")
    protected double minShakeInterval;

    @SerializedName("shake_end_time_interval_threshold")
    protected double shakeEndTimeIntervalThreshold;

    @SerializedName("shake_interval_millsecond")
    protected double shakeIntervalMillSecond;

    @SerializedName("m_speed_shake_mill_seconds")
    protected double speedShakeMillSecond;

    public GalileoResponse(double r2, double r4, double r6, double r8, double r10) {
        super(h.class);
        this.speedShakeMillSecond = r2;
        this.acceleratedThreshold = r4;
        this.minShakeInterval = r6;
        this.shakeEndTimeIntervalThreshold = r8;
        this.shakeIntervalMillSecond = r10;
    }

    public static /* synthetic */ GalileoResponse copy$default(GalileoResponse r11, double r12, double r14, double r16, double r18, double r20, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        double r1 = r11.speedShakeMillSecond;
    L7:
        if ((r22 & 2) == 0) goto L9;
        double r3 = r11.acceleratedThreshold;
    L11:
        if ((r22 & 4) == 0) goto L13;
        double r5 = r11.minShakeInterval;
    L15:
        if ((r22 & 8) == 0) goto L17;
        double r7 = r11.shakeEndTimeIntervalThreshold;
    L19:
        if ((r22 & 16) == 0) goto L21;
        double r9 = r11.shakeIntervalMillSecond;
    L23:
        return r11.copy(r1, r3, r5, r7, r9);
    L21:
        r9 = r20;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    public final double component1() {
        return this.speedShakeMillSecond;
    }

    public final double component2() {
        return this.acceleratedThreshold;
    }

    public final double component3() {
        return this.minShakeInterval;
    }

    public final double component4() {
        return this.shakeEndTimeIntervalThreshold;
    }

    public final double component5() {
        return this.shakeIntervalMillSecond;
    }

    public final GalileoResponse copy(double r13, double r15, double r17, double r19, double r21) {
        return new GalileoResponse(r13, r15, r17, r19, r21);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof GalileoResponse) == false) goto L16;
        GalileoResponse r6 = (GalileoResponse) r5;
        if (Double.compare(this.speedShakeMillSecond, r6.speedShakeMillSecond) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.acceleratedThreshold, r6.acceleratedThreshold) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.minShakeInterval, r6.minShakeInterval) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.shakeEndTimeIntervalThreshold, r6.shakeEndTimeIntervalThreshold) == 0) goto L14;
        return false;
    L14:
        if (Double.compare(this.shakeIntervalMillSecond, r6.shakeIntervalMillSecond) == 0) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        long r0 = Double.doubleToLongBits(this.speedShakeMillSecond);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this.acceleratedThreshold);
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = Double.doubleToLongBits(this.minShakeInterval);
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = Double.doubleToLongBits(this.shakeEndTimeIntervalThreshold);
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = Double.doubleToLongBits(this.shakeIntervalMillSecond);
        return r7 + ((int) (r8 ^ (r8 >>> 32)));
    }

    public String toString() {
        return "GalileoResponse(speedShakeMillSecond=" + this.speedShakeMillSecond + ", acceleratedThreshold=" + this.acceleratedThreshold + ", minShakeInterval=" + this.minShakeInterval + ", shakeEndTimeIntervalThreshold=" + this.shakeEndTimeIntervalThreshold + ", shakeIntervalMillSecond=" + this.shakeIntervalMillSecond + ")";
    }

    public GalileoResponse() {
        super(h.class);
        this.speedShakeMillSecond = 700.0d;
        this.acceleratedThreshold = 0.0d;
        this.minShakeInterval = 1024.0d;
        this.shakeEndTimeIntervalThreshold = 0.0d;
        this.shakeIntervalMillSecond = 55.0d;
    }

    public final double getAcceleratedThreshold() {
        return this.acceleratedThreshold;
    }

    public final double getMinShakeInterval() {
        return this.minShakeInterval;
    }

    public final double getShakeEndTimeIntervalThreshold() {
        return this.shakeEndTimeIntervalThreshold;
    }

    public final double getShakeIntervalMillSecond() {
        return this.shakeIntervalMillSecond;
    }

    public final double getSpeedShakeMillSecond() {
        return this.speedShakeMillSecond;
    }

    public GalileoResponse(g r7) {
        super(h.class);
        int r0 = 0;
        setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L21;
        g.a r4 = decodeExtensionFields(r3, r7);
        if (r3 != 1) goto L8;
        this.speedShakeMillSecond = Double.longBitsToDouble(r7.h());
        r0 = r0 | 1;
        goto L3
    L8:
        if (r3 != 2) goto L10;
        this.acceleratedThreshold = Double.longBitsToDouble(r7.h());
        r0 = r0 | 2;
        goto L3
    L10:
        if (r3 != 3) goto L12;
        this.minShakeInterval = Double.longBitsToDouble(r7.h());
        r0 = r0 | 4;
        goto L3
    L12:
        if (r3 != 4) goto L14;
        this.shakeEndTimeIntervalThreshold = Double.longBitsToDouble(r7.h());
        r0 = r0 | 8;
        goto L3
    L14:
        if (r3 != 5) goto L15;
        this.shakeIntervalMillSecond = Double.longBitsToDouble(r7.h());
        r0 = r0 | 16;
        goto L3
    L15:
        am3.h.d(r4, r7);
        goto L3
    L21:
        r7.d(r1);
        setThreadSafe(true);
        if ((r0 & 1) != 0) goto L25;
        this.speedShakeMillSecond = 700.0d;
    L25:
        if ((r0 & 2) != 0) goto L28;
        this.acceleratedThreshold = 0.0d;
    L28:
        if ((r0 & 4) != 0) goto L31;
        this.minShakeInterval = 1024.0d;
    L31:
        if ((r0 & 8) != 0) goto L34;
        this.shakeEndTimeIntervalThreshold = 0.0d;
    L34:
        if ((r0 & 16) != 0) goto L55;
        this.shakeIntervalMillSecond = 55.0d;
        return;
    }

    public /* synthetic */ GalileoResponse(double r12, double r14, double r16, double r18, double r20, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 1) == 0) goto L5;
        double r0 = 700.0d;
    L6:
        double r3 = 0.0d;
        if ((r22 & 2) == 0) goto L9;
        double r5 = 0.0d;
    L11:
        if ((r22 & 4) == 0) goto L13;
        double r7 = 1024.0d;
    L15:
        if ((r22 & 8) != 0) goto L19;
        r3 = r18;
    L19:
        if ((r22 & 16) == 0) goto L21;
        double r9 = 55.0d;
    L22:
        this(r0, r5, r7, r3, r9);
        return;
    L21:
        r9 = r20;
        goto L22
    L13:
        r7 = r16;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r0 = r12;
        goto L6
    }
}
