package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006 "}, d2 = {"Lcom/obric/memorydata/database/entity/LightSensorEntity;", "", "dataId", "", "dataVersion", "timestamp", "", EventBody.KEY_VALUE, "", OaidModel.KEY_ID, "<init>", "(IIJFJ)V", "getDataId", "()I", "getDataVersion", "getTimestamp", "()J", "getValue", "()F", "getId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8973b;
    private final long c;
    private final float d;
    private final long e;

    public ci(int r1, int r2, long r3, float r5, long r6) {
        this.f8972a = r1;
        this.f8973b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
    }

    public final int a() {
        return this.f8972a;
    }

    public final int b() {
        return this.f8973b;
    }

    public final long c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ci.class) == true) goto L8;
        return false;
    L8:
        ci r10 = (ci) ZeusTransformUtils.preCheckCast(r9, ci.class, "com.obric.memorydata.plugin");
        if (this.f8972a == r10.f8972a) goto L12;
        return false;
    L12:
        if (this.f8973b == r10.f8973b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r10.d) == 0) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.f8972a) * 31) + Integer.hashCode(this.f8973b)) * 31) + Long.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "LightSensorEntity(dataId=" + this.f8972a + ", dataVersion=" + this.f8973b + ", timestamp=" + this.c + ", value=" + this.d + ", id=" + this.e + ')';
    }
}
