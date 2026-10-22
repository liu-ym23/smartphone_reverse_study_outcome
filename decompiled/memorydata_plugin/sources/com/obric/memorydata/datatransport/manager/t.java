package com.obric.memorydata.datatransport.manager;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportStatistic;", "", "labelRes", "", CommonConsts.COUNT_TYPE, "", "<init>", "(IJ)V", "getLabelRes", "()I", "getCount", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9797b;

    public t(int r1, long r2) {
        this.f9796a = r1;
        this.f9797b = r2;
    }

    public final int a() {
        return this.f9796a;
    }

    public final long b() {
        return this.f9797b;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, t.class) == true) goto L8;
        return false;
    L8:
        t r8 = (t) ZeusTransformUtils.preCheckCast(r7, t.class, "com.obric.memorydata.plugin");
        if (this.f9796a == r8.f9796a) goto L12;
        return false;
    L12:
        if (this.f9797b == r8.f9797b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f9796a) * 31) + Long.hashCode(this.f9797b);
    }

    public String toString() {
        return "ExportStatistic(labelRes=" + this.f9796a + ", count=" + this.f9797b + ')';
    }
}
