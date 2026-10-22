package com.obric.memorydata.datatransport.manager;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/PersistedExportStatistic;", "", "labelRes", "", CommonConsts.COUNT_TYPE, "", "<init>", "(IJ)V", "getLabelRes", "()I", "getCount", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9807b;

    public x(int r1, long r2) {
        this.f9806a = r1;
        this.f9807b = r2;
    }

    public final int a() {
        return this.f9806a;
    }

    public final long b() {
        return this.f9807b;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, x.class) == true) goto L8;
        return false;
    L8:
        x r8 = (x) ZeusTransformUtils.preCheckCast(r7, x.class, "com.obric.memorydata.plugin");
        if (this.f9806a == r8.f9806a) goto L12;
        return false;
    L12:
        if (this.f9807b == r8.f9807b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f9806a) * 31) + Long.hashCode(this.f9807b);
    }

    public String toString() {
        return "PersistedExportStatistic(labelRes=" + this.f9806a + ", count=" + this.f9807b + ')';
    }
}
