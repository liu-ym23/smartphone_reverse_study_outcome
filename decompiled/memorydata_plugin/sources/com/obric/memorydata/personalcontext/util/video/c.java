package com.obric.memorydata.personalcontext.util.video;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/video/KeyFramesInfo;", "", "frameTimeUsList", "", "", "duration", "<init>", "(Ljava/util/List;J)V", "getFrameTimeUsList", "()Ljava/util/List;", "getDuration", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Long> f12386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12387b;

    public c(List<Long> r3, long r4) {
        List<Long> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "frameTimeUsList");
        this.f12386a = r5;
        this.f12387b = r4;
    }

    public final List<Long> a() {
        return this.f12386a;
    }

    public final long b() {
        return this.f12387b;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
        return false;
    L8:
        c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12386a, r8.f12386a) == true) goto L12;
        return false;
    L12:
        if (this.f12387b == r8.f12387b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f12386a.hashCode() * 31) + Long.hashCode(this.f12387b);
    }

    public String toString() {
        return "KeyFramesInfo(frameTimeUsList=" + this.f12386a + ", duration=" + this.f12387b + ')';
    }
}
