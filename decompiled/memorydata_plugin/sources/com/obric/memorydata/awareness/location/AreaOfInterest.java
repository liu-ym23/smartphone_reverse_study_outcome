package com.obric.memorydata.awareness.location;

import androidx.core.app.FrameMetricsAggregator;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006,"}, d2 = {"Lcom/obric/memorydata/awareness/location/AreaOfInterest;", "", "sid", "", OaidModel.KEY_ID, ActivityLifecycle.NAME, "typecode", "distance", "", "location", MemoryKeyInfoEntity.KEY_ADDRESS, "area", "aweme_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "getSid", "()Ljava/lang/String;", "getId", "getName", "getTypecode", "getDistance", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLocation", "getAddress", "getArea", "getAweme_id", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Lcom/obric/memorydata/awareness/location/AreaOfInterest;", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AreaOfInterest {
    private final String address;
    private final Double area;
    private final String aweme_id;
    private final Double distance;
    private final String id;
    private final String location;
    private final String name;
    private final String sid;
    private final String typecode;

    public AreaOfInterest() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public AreaOfInterest(String r1, String r2, String r3, String r4, Double r5, String r6, String r7, Double r8, String r9) {
        this.sid = r1;
        this.id = r2;
        this.name = r3;
        this.typecode = r4;
        this.distance = r5;
        this.location = r6;
        this.address = r7;
        this.area = r8;
        this.aweme_id = r9;
    }

    public /* synthetic */ AreaOfInterest(String r2, String r3, String r4, String r5, Double r6, String r7, String r8, Double r9, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r11 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r11 & 256) == 0) goto L29;
        r10 = null;
    L29:
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ AreaOfInterest copy$default(AreaOfInterest r10, String r11, String r12, String r13, String r14, Double r15, String r16, String r17, Double r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.sid;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.id;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.name;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.typecode;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Double r6 = r10.distance;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.location;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.address;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Double r9 = r10.area;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.aweme_id;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final String component1() {
        return this.sid;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.typecode;
    }

    public final Double component5() {
        return this.distance;
    }

    public final String component6() {
        return this.location;
    }

    public final String component7() {
        return this.address;
    }

    public final Double component8() {
        return this.area;
    }

    public final String component9() {
        return this.aweme_id;
    }

    public final AreaOfInterest copy(String r12, String r13, String r14, String r15, Double r16, String r17, String r18, Double r19, String r20) {
        return new AreaOfInterest(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AreaOfInterest.class) == true) goto L8;
        return false;
    L8:
        AreaOfInterest r6 = (AreaOfInterest) ZeusTransformUtils.preCheckCast(r5, AreaOfInterest.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.sid, r6.sid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.typecode, r6.typecode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.distance, r6.distance) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.location, r6.location) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.address, r6.address) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.area, r6.area) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.aweme_id, r6.aweme_id) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Double getArea() {
        return this.area;
    }

    public final String getAweme_id() {
        return this.aweme_id;
    }

    public final Double getDistance() {
        return this.distance;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getTypecode() {
        return this.typecode;
    }

    public int hashCode() {
        String r0 = this.sid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.id;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.name;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.typecode;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Double r13 = this.distance;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.location;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.address;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Double r22 = this.area;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.aweme_id;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AreaOfInterest(sid=" + this.sid + ", id=" + this.id + ", name=" + this.name + ", typecode=" + this.typecode + ", distance=" + this.distance + ", location=" + this.location + ", address=" + this.address + ", area=" + this.area + ", aweme_id=" + this.aweme_id + ')';
    }
}
