package com.obric.memorydata.database.index;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/database/index/DurationStats;", "", "sumMs", "", CommonConsts.COUNT_TYPE, "averageMs", "<init>", "(JJJ)V", "getSumMs", "()J", "getCount", "getAverageMs", "plus", "other", "plus$database_obricRelease", "component1", "component2", "component3", "copy", "equals", "", "hashCode", "", "toString", "", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9434a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9435b;
    private final long c;
    private final long d;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/index/DurationStats$Companion;", "", "<init>", "()V", "empty", "Lcom/obric/memorydata/database/index/DurationStats;", "fromDurationMs", "duration", "Lcom/obric/memorydata/database/index/DurationMs;", "fromDurationMs-wXbnSwU", "(J)Lcom/obric/memorydata/database/index/DurationStats;", "fromSumAndCount", "sumMs", "", CommonConsts.COUNT_TYPE, "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final r a() {
            return a(0, 0);
        }

        public final r a(long r3) {
            return a(r3, 1);
        }

        public final r a(long r9, long r11) {
            long r0 = 0;
            if (r11 == 0) goto L7;
            r0 = r9 / r11;
        L7:
            return new r(r9, r11, r0, null);
        }
    }

    static {
        f9434a = new a(null);
    }

    private r(long r1, long r3, long r5) {
        this.f9435b = r1;
        this.c = r3;
        this.d = r5;
    }

    public /* synthetic */ r(long r1, long r3, long r5, DefaultConstructorMarker r7) {
        this(r1, r3, r5);
    }

    public final long a() {
        return this.f9435b;
    }

    public final long b() {
        return this.c;
    }

    public final long c() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, r.class) == true) goto L8;
        return false;
    L8:
        r r10 = (r) ZeusTransformUtils.preCheckCast(r9, r.class, "com.obric.memorydata.plugin");
        if (this.f9435b == r10.f9435b) goto L12;
        return false;
    L12:
        if (this.c == r10.c) goto L15;
        return false;
    L15:
        if (this.d == r10.d) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f9435b) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "DurationStats(sumMs=" + this.f9435b + ", count=" + this.c + ", averageMs=" + this.d + ')';
    }
}
