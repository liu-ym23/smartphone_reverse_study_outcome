package com.obric.memorydata.ability.data;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.database.entity.bx;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\tJ\b\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J'\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u000fHÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006*"}, d2 = {"Lcom/obric/memorydata/ability/data/GeographyStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", "longitude", "", "latitude", "altitude", "<init>", "(DDD)V", "(DD)V", "getLongitude", "()D", "getLatitude", "getAltitude", "dataId", "", "dataVersion", "timestamp", "", LocationMonitorConst.ACCURACY, "", "getAccuracy", "()F", "setAccuracy", "(F)V", "speed", "getSpeed", "setSpeed", "getDataId", "getDataVersion", "collectNewData", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g implements h, com.obric.memorydata.ability.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f8329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f8330b;
    private final double c;
    private final int d;
    private final int e;
    private final long f;
    private float g;
    private float h;

    public g(double r8, double r10) {
        this(r8, r10, 0.0d);
    }

    public g(double r1, double r3, double r5) {
        this.f8329a = r1;
        this.f8330b = r3;
        this.c = r5;
        this.d = 100000001;
        this.e = 1;
        this.f = System.currentTimeMillis();
        this.g = 1000.0f;
    }

    public final double a() {
        return this.f8329a;
    }

    public final void a(float r1) {
        this.g = r1;
    }

    public final double b() {
        return this.f8330b;
    }

    public final void b(float r1) {
        this.h = r1;
    }

    public final float c() {
        return this.g;
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getGeographyDao().insert(new bx(this.d, this.e, this.f, this.f8329a, this.f8330b, 0, 32, null));
    }

    public final float d() {
        return this.h;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
        return false;
    L8:
        g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.memorydata.plugin");
        if (Double.compare(this.f8329a, r10.f8329a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f8330b, r10.f8330b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.c, r10.c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return this.d;
    }

    public int hashCode() {
        return (((Double.hashCode(this.f8329a) * 31) + Double.hashCode(this.f8330b)) * 31) + Double.hashCode(this.c);
    }

    public String toString() {
        return "GeographyStandardData(longitude=" + this.f8329a + ", latitude=" + this.f8330b + ", altitude=" + this.c + ')';
    }
}
