package com.obric.memorydata.awareness.poi;

import com.bytedance.rpc.model.POIInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/awareness/poi/PoiRespData;", "", "distance", "", "poiInfoList", "", "Lcom/bytedance/rpc/model/POIInfo;", "<init>", "(DLjava/util/List;)V", "getDistance", "()D", "getPoiInfoList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f8791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<POIInfo> f8792b;

    public g(double r3, List<? extends POIInfo> r5) {
        List<POIInfo> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "poiInfoList");
        this.f8791a = r3;
        this.f8792b = r6;
    }

    public final double a() {
        return this.f8791a;
    }

    public final List<POIInfo> b() {
        return this.f8792b;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
        return false;
    L8:
        g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.memorydata.plugin");
        if (Double.compare(this.f8791a, r10.f8791a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8792b, r10.f8792b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Double.hashCode(this.f8791a) * 31) + this.f8792b.hashCode();
    }

    public String toString() {
        return "PoiRespData(distance=" + this.f8791a + ", poiInfoList=" + this.f8792b + ')';
    }
}
