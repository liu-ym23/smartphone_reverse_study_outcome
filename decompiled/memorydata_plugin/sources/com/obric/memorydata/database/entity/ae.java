package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003Jw\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0006HÆ\u0001J\u0013\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001dR\u0016\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017¨\u00061"}, d2 = {"Lcom/obric/memorydata/database/entity/BatteryStateEntity;", "", "dataId", "", "dataVersion", "timestamp", "", "event", "chargeType", "level", "", "temperature", "isPowerConnect", "", "isSaveMode", "timeRemaining", OaidModel.KEY_ID, "<init>", "(IIJIIDIZZJJ)V", "getDataId", "()I", "getDataVersion", "getTimestamp", "()J", "getEvent", "getChargeType", "getLevel", "()D", "getTemperature", "()Z", "getTimeRemaining", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8872b;
    private final long c;
    private final int d;
    private final int e;
    private final double f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final long j;
    private final long k;

    public ae(int r1, int r2, long r3, int r5, int r6, double r7, int r9, boolean r10, boolean r11, long r12, long r14) {
        this.f8871a = r1;
        this.f8872b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r14;
    }

    public /* synthetic */ ae(int r19, int r20, long r21, int r23, int r24, double r25, int r27, boolean r28, boolean r29, long r30, long r32, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1024) == 0) goto L5;
        long r16 = 0;
    L6:
        this(r19, r20, r21, r23, r24, r25, r27, r28, r29, r30, r16);
        return;
    L5:
        r16 = r32;
        goto L6
    }

    public final int a() {
        return this.f8871a;
    }

    public final int b() {
        return this.f8872b;
    }

    public final long c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ae.class) == true) goto L8;
        return false;
    L8:
        ae r10 = (ae) ZeusTransformUtils.preCheckCast(r9, ae.class, "com.obric.memorydata.plugin");
        if (this.f8871a == r10.f8871a) goto L12;
        return false;
    L12:
        if (this.f8872b == r10.f8872b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (Double.compare(this.f, r10.f) == 0) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final double f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((((((((Integer.hashCode(this.f8871a) * 31) + Integer.hashCode(this.f8872b)) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Double.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31) + Long.hashCode(this.k);
    }

    public final boolean i() {
        return this.i;
    }

    public final long j() {
        return this.j;
    }

    public final long k() {
        return this.k;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("BatteryStateEntity(dataId=").append(this.f8871a).append(", dataVersion=").append(this.f8872b).append(", timestamp=").append(this.c).append(", event=").append(this.d).append(", chargeType=").append(this.e).append(", level=").append(this.f).append(", temperature=").append(this.g).append(", isPowerConnect=").append(this.h).append(", isSaveMode=").append(this.i).append(", timeRemaining=").append(this.j).append(", id=").append(this.k).append(')');
        return r0.toString();
    }
}
