package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/database/entity/PoiReqRecorderEntity;", "", "timestamp", "", "latitude", "", "longitude", "distance", OaidModel.KEY_ID, "<init>", "(JDDDJ)V", "getTimestamp", "()J", "getLatitude", "()D", "getLongitude", "getDistance", "getId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class en {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f9083b;
    private final double c;
    private final double d;
    private final long e;

    public en(long r1, double r3, double r5, double r7, long r9) {
        this.f9082a = r1;
        this.f9083b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r9;
    }

    public /* synthetic */ en(long r14, double r16, double r18, double r20, long r22, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 16) == 0) goto L5;
        long r11 = 0;
    L6:
        this(r14, r16, r18, r20, r11);
        return;
    L5:
        r11 = r22;
        goto L6
    }

    public final long a() {
        return this.f9082a;
    }

    public final double b() {
        return this.f9083b;
    }

    public final double c() {
        return this.c;
    }

    public final double d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, en.class) == true) goto L8;
        return false;
    L8:
        en r10 = (en) ZeusTransformUtils.preCheckCast(r9, en.class, "com.obric.memorydata.plugin");
        if (this.f9082a == r10.f9082a) goto L12;
        return false;
    L12:
        if (Double.compare(this.f9083b, r10.f9083b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.c, r10.c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.d, r10.d) == 0) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f9082a) * 31) + Double.hashCode(this.f9083b)) * 31) + Double.hashCode(this.c)) * 31) + Double.hashCode(this.d)) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "PoiReqRecorderEntity(timestamp=" + this.f9082a + ", latitude=" + this.f9083b + ", longitude=" + this.c + ", distance=" + this.d + ", id=" + this.e + ')';
    }
}
