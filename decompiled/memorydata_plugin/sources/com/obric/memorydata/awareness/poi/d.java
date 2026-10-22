package com.obric.memorydata.awareness.poi;

import com.bytedance.rpc.model.POIInfo;
import com.obric.memorydata.database.entity.em;
import com.obric.memorydata.database.entity.en;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/awareness/poi/PoiRequestCache;", "", "reqEntity", "Lcom/obric/memorydata/database/entity/PoiReqRecorderEntity;", "groupEntityList", "", "Lcom/obric/memorydata/database/entity/PoiInfoGroupEntity;", "<init>", "(Lcom/obric/memorydata/database/entity/PoiReqRecorderEntity;Ljava/util/List;)V", "getReqEntity", "()Lcom/obric/memorydata/database/entity/PoiReqRecorderEntity;", "getGroupEntityList", "()Ljava/util/List;", "searchPoiInfo", "Lcom/bytedance/rpc/model/POIInfo;", "latitude", "", "longitude", "delta", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final en f8785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<em> f8786b;

    public d(en r3, List<em> r4) {
        List<em> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "reqEntity");
        Intrinsics.checkNotNullParameter(r5, "groupEntityList");
        this.f8785a = r3;
        this.f8786b = r5;
    }

    public final en a() {
        return this.f8785a;
    }

    public final List<POIInfo> a(double r12, double r14, double r16) {
        List<POIInfo> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<em> r1 = this.f8786b.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(((em) ZeusTransformUtils.preCheckCast(r1.next(), em.class, "com.obric.memorydata.plugin")).a(r12, r14, r16), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8785a, r6.f8785a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8786b, r6.f8786b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f8785a.hashCode() * 31) + this.f8786b.hashCode();
    }

    public String toString() {
        return "PoiRequestCache(reqEntity=" + this.f8785a + ", groupEntityList=" + this.f8786b + ')';
    }
}
