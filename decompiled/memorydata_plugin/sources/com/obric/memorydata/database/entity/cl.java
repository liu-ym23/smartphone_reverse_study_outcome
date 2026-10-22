package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010:\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010<\u001a\u00020\u0006HÆ\u0003Jª\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020\u0003HÖ\u0001J\t\u0010D\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b-\u0010#R\u0016\u0010\u0014\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001b¨\u0006E"}, d2 = {"Lcom/obric/memorydata/database/entity/LocationEntity;", "Lcom/obric/memorydata/database/model/GpsPoint;", "dataId", "", "dataVersion", "timestamp", "", "longitude", "", "latitude", "cellId", "lac", "cellType", "", "bssid", Api.KEY_SSID, LocationMonitorConst.ACCURACY, "", "speed", "harState", OaidModel.KEY_ID, "<init>", "(IIJDDLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;J)V", "getDataId", "()I", "getDataVersion", "getTimestamp", "()J", "getLongitude", "()D", "getLatitude", "getCellId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLac", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCellType", "()Ljava/lang/String;", "getBssid", "getSsid", "getAccuracy", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getSpeed", "getHarState", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(IIJDDLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;J)Lcom/obric/memorydata/database/entity/LocationEntity;", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class cl extends com.obric.memorydata.database.model.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8979b;
    private final long c;
    private final double d;
    private final double e;
    private final Long f;
    private final Integer g;
    private final String h;
    private final String i;
    private final String j;
    private final Float k;
    private final Float l;
    private final Integer m;
    private final long n;

    public cl(int r4, int r5, long r6, double r8, double r10, Long r12, Integer r13, String r14, String r15, String r16, Float r17, Float r18, Integer r19, long r20) {
        this.f8978a = r4;
        this.f8979b = r5;
        this.c = r6;
        this.d = r8;
        this.e = r10;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r19;
        this.n = r20;
    }

    public /* synthetic */ cl(int r23, int r24, long r25, double r27, double r29, Long r31, Integer r32, String r33, String r34, String r35, Float r36, Float r37, Integer r38, long r39, int r41, DefaultConstructorMarker r42) {
        if ((r41 & 1024) == 0) goto L5;
        Float r17 = null;
    L7:
        if ((r41 & 2048) == 0) goto L9;
        Float r18 = null;
    L11:
        if ((r41 & 4096) == 0) goto L13;
        Integer r19 = null;
    L15:
        if ((r41 & 8192) == 0) goto L17;
        long r20 = 0;
    L18:
        this(r23, r24, r25, r27, r29, r31, r32, r33, r34, r35, r17, r18, r19, r20);
        return;
    L17:
        r20 = r39;
        goto L18
    L13:
        r19 = r38;
        goto L15
    L9:
        r18 = r37;
        goto L11
    L5:
        r17 = r36;
        goto L7
    }

    public final int a() {
        return this.f8978a;
    }

    public final int b() {
        return this.f8979b;
    }

    public long c() {
        return this.c;
    }

    public double d() {
        return this.d;
    }

    public double e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, cl.class) == true) goto L8;
        return false;
    L8:
        cl r10 = (cl) ZeusTransformUtils.preCheckCast(r9, cl.class, "com.obric.memorydata.plugin");
        if (this.f8978a == r10.f8978a) goto L12;
        return false;
    L12:
        if (this.f8979b == r10.f8979b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Double.compare(this.d, r10.d) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.e, r10.e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r10.n) goto L50;
        return false;
    L50:
        return true;
    }

    public final Long f() {
        return this.f;
    }

    public final Integer g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((((((((Integer.hashCode(this.f8978a) * 31) + Integer.hashCode(this.f8979b)) * 31) + Long.hashCode(this.c)) * 31) + Double.hashCode(this.d)) * 31) + Double.hashCode(this.e)) * 31;
        Long r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.h;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.i;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.j;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Float r17 = this.k;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Float r20 = this.l;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Integer r23 = this.m;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return ((r22 + r2) * 31) + Long.hashCode(this.n);
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String i() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }

    public final Float k() {
        return this.k;
    }

    public final Float l() {
        return this.l;
    }

    public final Integer m() {
        return this.m;
    }

    public final long n() {
        return this.n;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("LocationEntity(dataId=").append(this.f8978a).append(", dataVersion=").append(this.f8979b).append(", timestamp=").append(this.c).append(", longitude=").append(this.d).append(", latitude=").append(this.e).append(", cellId=").append(this.f).append(", lac=").append(this.g).append(", cellType=").append(this.h).append(", bssid=").append(this.i).append(", ssid=").append(this.j).append(", accuracy=").append(this.k).append(", speed=");
        r0.append(this.l).append(", harState=").append(this.m).append(", id=").append(this.n).append(')');
        return r0.toString();
    }
}
