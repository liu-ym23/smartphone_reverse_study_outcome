package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryCalendarWeek;", "", "weekDate", "", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarDay;", "key", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getWeekDate", "()Ljava/util/List;", "getKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<n> f11324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11325b;

    public p(List<n> r3, String r4) {
        List<n> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "weekDate");
        Intrinsics.checkNotNullParameter(r4, "key");
        this.f11324a = r5;
        this.f11325b = r4;
    }

    public static /* synthetic */ p a(p r1, List r2, String r3, int r4, Object r5) {
        List<n> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.f11324a;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.f11325b;
    L9:
        return r1.a(r6, r3);
    }

    public final p a(List<n> r2, String r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "weekDate");
        Intrinsics.checkNotNullParameter(r3, "key");
        return new p(r1, r3);
    }

    public final List<n> a() {
        return this.f11324a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, p.class) == true) goto L8;
        return false;
    L8:
        p r6 = (p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11324a, r6.f11324a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11325b, r6.f11325b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f11324a.hashCode() * 31) + this.f11325b.hashCode();
    }

    public String toString() {
        return "MemoryCalendarWeek(weekDate=" + this.f11324a + ", key=" + this.f11325b + ')';
    }
}
