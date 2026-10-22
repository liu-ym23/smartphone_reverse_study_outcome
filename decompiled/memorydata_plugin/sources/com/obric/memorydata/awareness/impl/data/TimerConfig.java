package com.obric.memorydata.awareness.impl.data;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0013\u001a\u00020\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0017\u001a\u00020\bHÆ\u0003J:\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/awareness/impl/data/TimerConfig;", "", "type", "", OaidModel.KEY_TIME, "intervalSec", "", "triggerExactly", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)V", "getType", "()Ljava/lang/String;", "getTime", "getIntervalSec", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTriggerExactly", "()Z", "validTimer", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)Lcom/obric/memorydata/awareness/impl/data/TimerConfig;", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TimerConfig {

    @SerializedName("interval_sec")
    private final Long intervalSec;
    private final String time;
    private final boolean triggerExactly;
    private final String type;

    public TimerConfig(String r2, String r3, Long r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.type = r2;
        this.time = r3;
        this.intervalSec = r4;
        this.triggerExactly = r5;
    }

    public /* synthetic */ TimerConfig(String r1, String r2, Long r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r3, r4);
    }

    public static /* synthetic */ TimerConfig copy$default(TimerConfig r0, String r1, String r2, Long r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.time;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.intervalSec;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.triggerExactly;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.time;
    }

    public final Long component3() {
        return this.intervalSec;
    }

    public final boolean component4() {
        return this.triggerExactly;
    }

    public final TimerConfig copy(String r1, String r2, Long r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "type");
        return new TimerConfig(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TimerConfig.class) == true) goto L8;
        return false;
    L8:
        TimerConfig r6 = (TimerConfig) ZeusTransformUtils.preCheckCast(r5, TimerConfig.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.time, r6.time) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.intervalSec, r6.intervalSec) == true) goto L18;
        return false;
    L18:
        if (this.triggerExactly == r6.triggerExactly) goto L20;
        return false;
    L20:
        return true;
    }

    public final Long getIntervalSec() {
        return this.intervalSec;
    }

    public final String getTime() {
        return this.time;
    }

    public final boolean getTriggerExactly() {
        return this.triggerExactly;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = this.type.hashCode() * 31;
        String r1 = this.time;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.intervalSec;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + Boolean.hashCode(this.triggerExactly);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TimerConfig(type=" + this.type + ", time=" + this.time + ", intervalSec=" + this.intervalSec + ", triggerExactly=" + this.triggerExactly + ')';
    }

    public final boolean validTimer() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.type, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        if (at.a(this.time) == true) goto L16;
        Long r7 = this.intervalSec;
        if (r7 == null) goto L15;
        if (r7.longValue() <= 0) goto L15;
        return true;
    L16:
        return true;
    L15:
        return false;
    L5:
        r0 = false;
        goto L6
    }
}
