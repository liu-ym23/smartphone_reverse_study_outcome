package com.ss.ugc.clientai.aiservice.ohr;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/ohr/OHRServiceInput;", "", "x", "", "y", "timestamp", "", "(FFJ)V", "getTimestamp", "()J", "setTimestamp", "(J)V", "getX", "()F", "setX", "(F)V", "getY", "setY", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f15802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f15803b;
    private long c;

    public f(float r1, float r2, long r3) {
        this.f15802a = r1;
        this.f15803b = r2;
        this.c = r3;
    }

    public final float a() {
        return this.f15802a;
    }

    public final float b() {
        return this.f15803b;
    }

    public final long c() {
        return this.c;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, f.class) == false) goto L13;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin");
        if (Float.compare(this.f15802a, r4.f15802a) == 0) goto L9;
        return false;
    L9:
        if (Float.compare(this.f15803b, r4.f15803b) == 0) goto L11;
        return false;
    L11:
        if (this.c == r4.c) goto L20;
        return false;
    L20:
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        return (((Float.hashCode(this.f15802a) * 31) + Float.hashCode(this.f15803b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "OHRServiceInput(x=" + this.f15802a + ", y=" + this.f15803b + ", timestamp=" + this.c + ")";
    }
}
