package com.obric.memorydata.database.index;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003JZ\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018¨\u0006)"}, d2 = {"Lcom/obric/memorydata/database/index/BacklogMetric;", "", TypedValues.Custom.S_DIMENSION, "Lcom/obric/memorydata/database/index/BacklogDimension;", "entityType", "", "buildType", "", "pendingEntityCount", "", "ageBuckets", "", "Lcom/obric/memorydata/database/index/BacklogAgeBucket;", "ageUnknownCount", "<init>", "(Lcom/obric/memorydata/database/index/BacklogDimension;Ljava/lang/Integer;Ljava/lang/String;JLjava/util/Map;J)V", "getDimension", "()Lcom/obric/memorydata/database/index/BacklogDimension;", "getEntityType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBuildType", "()Ljava/lang/String;", "getPendingEntityCount", "()J", "getAgeBuckets", "()Ljava/util/Map;", "getAgeUnknownCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/obric/memorydata/database/index/BacklogDimension;Ljava/lang/Integer;Ljava/lang/String;JLjava/util/Map;J)Lcom/obric/memorydata/database/index/BacklogMetric;", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BacklogDimension f9405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f9406b;
    private final String c;
    private final long d;
    private final Map<BacklogAgeBucket, Long> e;
    private final long f;

    public b(BacklogDimension r3, Integer r4, String r5, long r6, Map<BacklogAgeBucket, Long> r8, long r9) {
        Map<BacklogAgeBucket, Long> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, TypedValues.Custom.S_DIMENSION);
        Intrinsics.checkNotNullParameter(r10, "ageBuckets");
        this.f9405a = r3;
        this.f9406b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r10;
        this.f = r9;
    }

    public final BacklogDimension a() {
        return this.f9405a;
    }

    public final Integer b() {
        return this.f9406b;
    }

    public final String c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final Map<BacklogAgeBucket, Long> e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
        if (this.f9405a == r10.f9405a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9406b, r10.f9406b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final long f() {
        return this.f;
    }

    public int hashCode() {
        int r0 = this.f9405a.hashCode() * 31;
        Integer r1 = this.f9406b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((((r4 + r2) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "BacklogMetric(dimension=" + this.f9405a + ", entityType=" + this.f9406b + ", buildType=" + this.c + ", pendingEntityCount=" + this.d + ", ageBuckets=" + this.e + ", ageUnknownCount=" + this.f + ')';
    }
}
