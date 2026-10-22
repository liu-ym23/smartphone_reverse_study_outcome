package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessCalendarState;", "", "weeks", "", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarWeek;", "recordedDayCount", "", "today", "Ljava/time/LocalDate;", "<init>", "(Ljava/util/List;ILjava/time/LocalDate;)V", "getWeeks", "()Ljava/util/List;", "getRecordedDayCount", "()I", "getToday", "()Ljava/time/LocalDate;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.obric.memorydata.memory.ui.list.p> f11263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11264b;
    private final LocalDate c;

    public c(List<com.obric.memorydata.memory.ui.list.p> r3, int r4, LocalDate r5) {
        List<com.obric.memorydata.memory.ui.list.p> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "weeks");
        Intrinsics.checkNotNullParameter(r5, "today");
        this.f11263a = r6;
        this.f11264b = r4;
        this.c = r5;
    }

    public final List<com.obric.memorydata.memory.ui.list.p> a() {
        return this.f11263a;
    }

    public final int b() {
        return this.f11264b;
    }

    public final LocalDate c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11263a, r6.f11263a) == true) goto L12;
        return false;
    L12:
        if (this.f11264b == r6.f11264b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f11263a.hashCode() * 31) + Integer.hashCode(this.f11264b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ContextAwarenessCalendarState(weeks=" + this.f11263a + ", recordedDayCount=" + this.f11264b + ", today=" + this.c + ')';
    }
}
