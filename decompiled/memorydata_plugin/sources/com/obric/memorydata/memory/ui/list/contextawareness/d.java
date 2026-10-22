package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;", "", "startTimeInclusive", "", "endTimeExclusive", "<init>", "(JJ)V", "getStartTimeInclusive", "()J", "getEndTimeExclusive", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11265a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11266b;
    private final long c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;", "date", "Ljava/time/LocalDate;", "zoneId", "Ljava/time/ZoneId;", "unbounded", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final d a() {
            return new d(Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public final d a(LocalDate r5, ZoneId r6) {
            Intrinsics.checkNotNullParameter(r5, "date");
            Intrinsics.checkNotNullParameter(r6, "zoneId");
            return new d(r5.atStartOfDay(r6).toInstant().toEpochMilli(), r5.plusDays(1).atStartOfDay(r6).toInstant().toEpochMilli());
        }
    }

    static {
        f11265a = new a(null);
    }

    public d(long r1, long r3) {
        this.f11266b = r1;
        this.c = r3;
        if (r1 >= r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("day range must be non-empty".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final long a() {
        return this.f11266b;
    }

    public final long b() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
        if (this.f11266b == r10.f11266b) goto L12;
        return false;
    L12:
        if (this.c == r10.c) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f11266b) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "ContextAwarenessDayRange(startTimeInclusive=" + this.f11266b + ", endTimeExclusive=" + this.c + ')';
    }
}
