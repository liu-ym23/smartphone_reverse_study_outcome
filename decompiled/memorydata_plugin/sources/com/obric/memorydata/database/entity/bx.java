package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/obric/memorydata/database/entity/GeographyEntity;", "", "dataId", "", "dataVersion", "timestamp", "", "longitude", "", "latitude", OaidModel.KEY_ID, "<init>", "(IIJDDJ)V", "getDataId", "()I", "getDataVersion", "getTimestamp", "()J", "getLongitude", "()D", "getLatitude", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8953b;
    private final long c;
    private final double d;
    private final double e;
    private final long f;

    public bx(int r1, int r2, long r3, double r5, double r7, long r9) {
        this.f8952a = r1;
        this.f8953b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r7;
        this.f = r9;
    }

    public /* synthetic */ bx(int r14, int r15, long r16, double r18, double r20, long r22, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 32) == 0) goto L5;
        long r11 = 0;
    L6:
        this(r14, r15, r16, r18, r20, r11);
        return;
    L5:
        r11 = r22;
        goto L6
    }

    public final int a() {
        return this.f8952a;
    }

    public final int b() {
        return this.f8953b;
    }

    public final long c() {
        return this.c;
    }

    public final double d() {
        return this.d;
    }

    public final double e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, bx.class) == true) goto L8;
        return false;
    L8:
        bx r10 = (bx) ZeusTransformUtils.preCheckCast(r9, bx.class, "com.obric.memorydata.plugin");
        if (this.f8952a == r10.f8952a) goto L12;
        return false;
    L12:
        if (this.f8953b == r10.f8953b) goto L15;
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
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final long f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.f8952a) * 31) + Integer.hashCode(this.f8953b)) * 31) + Long.hashCode(this.c)) * 31) + Double.hashCode(this.d)) * 31) + Double.hashCode(this.e)) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "GeographyEntity(dataId=" + this.f8952a + ", dataVersion=" + this.f8953b + ", timestamp=" + this.c + ", longitude=" + this.d + ", latitude=" + this.e + ", id=" + this.f + ')';
    }
}
