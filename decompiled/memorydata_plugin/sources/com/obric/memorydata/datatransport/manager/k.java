package com.obric.memorydata.datatransport.manager;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportCategoryProgress;", "", EventBody.KEY_CATEGORY, "Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;", "scannedCount", "", "successCount", "failureCount", "failureReasons", "", "Lcom/obric/memorydata/datatransport/manager/ExportFailureReason;", "<init>", "(Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;JJJLjava/util/Map;)V", "getCategory", "()Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;", "getScannedCount", "()J", "getSuccessCount", "getFailureCount", "getFailureReasons", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExportStatisticsCategory f9779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9780b;
    private final long c;
    private final long d;
    private final Map<ExportFailureReason, Long> e;

    public k(ExportStatisticsCategory r3, long r4, long r6, long r8, Map<ExportFailureReason, Long> r10) {
        Map<ExportFailureReason, Long> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r11, "failureReasons");
        this.f9779a = r3;
        this.f9780b = r4;
        this.c = r6;
        this.d = r8;
        this.e = r11;
    }

    public /* synthetic */ k(ExportStatisticsCategory r9, long r10, long r12, long r14, Map r16, int r17, DefaultConstructorMarker r18) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.memorydata.plugin");
        long r2 = 0;
        if ((r17 & 2) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r17 & 4) == 0) goto L9;
        long r6 = 0;
    L11:
        if ((r17 & 8) != 0) goto L15;
        r2 = r14;
    L15:
        if ((r17 & 16) == 0) goto L17;
        r0 = MapsKt.emptyMap();
    L17:
        this(r9, r4, r6, r2, r0);
        return;
    L9:
        r6 = r12;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    public static /* synthetic */ k a(k r10, ExportStatisticsCategory r11, long r12, long r14, long r16, Map r18, int r19, Object r20) {
        Map<ExportFailureReason, Long> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        if ((r19 & 1) == 0) goto L5;
        ExportStatisticsCategory r2 = r10.f9779a;
    L7:
        if ((r19 & 2) == 0) goto L9;
        long r3 = r10.f9780b;
    L11:
        if ((r19 & 4) == 0) goto L13;
        long r5 = r10.c;
    L15:
        if ((r19 & 8) == 0) goto L17;
        long r7 = r10.d;
    L19:
        if ((r19 & 16) == 0) goto L22;
        r1 = r10.e;
    L22:
        return r10.a(r2, r3, r5, r7, r1);
    L17:
        r7 = r16;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final ExportStatisticsCategory a() {
        return this.f9779a;
    }

    public final k a(ExportStatisticsCategory r11, long r12, long r14, long r16, Map<ExportFailureReason, Long> r18) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r9, "failureReasons");
        return new k(r11, r12, r14, r16, r9);
    }

    public final long b() {
        return this.f9780b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final Map<ExportFailureReason, Long> e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, k.class) == true) goto L8;
        return false;
    L8:
        k r10 = (k) ZeusTransformUtils.preCheckCast(r9, k.class, "com.obric.memorydata.plugin");
        if (this.f9779a == r10.f9779a) goto L12;
        return false;
    L12:
        if (this.f9780b == r10.f9780b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f9779a.hashCode() * 31) + Long.hashCode(this.f9780b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "ExportCategoryProgress(category=" + this.f9779a + ", scannedCount=" + this.f9780b + ", successCount=" + this.c + ", failureCount=" + this.d + ", failureReasons=" + this.e + ')';
    }
}
