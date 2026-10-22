package com.obric.memorydata.datatransport.manager;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u00104\u001a\u00020\u0013HÆ\u0003J\u0086\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\tHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006<"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "", "taskId", "", "userId", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/obric/memorydata/datatransport/manager/DataExportPhase;", "message", "percent", "", "retryCount", "startedAt", "", "updatedAt", "workingFilePaths", "", "result", "Lcom/obric/memorydata/datatransport/manager/PersistedExportResult;", "statistics", "Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/datatransport/manager/DataExportPhase;Ljava/lang/String;Ljava/lang/Integer;IJJLjava/util/List;Lcom/obric/memorydata/datatransport/manager/PersistedExportResult;Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;)V", "getTaskId", "()Ljava/lang/String;", "getUserId", "getPhase", "()Lcom/obric/memorydata/datatransport/manager/DataExportPhase;", "getMessage", "getPercent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRetryCount", "()I", "getStartedAt", "()J", "getUpdatedAt", "getWorkingFilePaths", "()Ljava/util/List;", "getResult", "()Lcom/obric/memorydata/datatransport/manager/PersistedExportResult;", "getStatistics", "()Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/datatransport/manager/DataExportPhase;Ljava/lang/String;Ljava/lang/Integer;IJJLjava/util/List;Lcom/obric/memorydata/datatransport/manager/PersistedExportResult;Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;)Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "equals", "", "other", "hashCode", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9764b;
    private final DataExportPhase c;
    private final String d;
    private final Integer e;
    private final int f;
    private final long g;
    private final long h;
    private final List<String> i;
    private final w j;
    private final q k;

    public d(String r3, String r4, DataExportPhase r5, String r6, Integer r7, int r8, long r9, long r11, List<String> r13, w r14, q r15) {
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, TypedValues.CycleType.S_WAVE_PHASE);
        Intrinsics.checkNotNullParameter(r6, "message");
        Intrinsics.checkNotNullParameter(r16, "workingFilePaths");
        Intrinsics.checkNotNullParameter(r15, "statistics");
        this.f9763a = r3;
        this.f9764b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r11;
        this.i = r16;
        this.j = r14;
        this.k = r15;
    }

    public /* synthetic */ d(String r19, String r20, DataExportPhase r21, String r22, Integer r23, int r24, long r25, long r27, List r29, w r30, q r31, int r32, DefaultConstructorMarker r33) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
        if ((r32 & 16) == 0) goto L5;
        Integer r9 = null;
    L7:
        if ((r32 & 256) == 0) goto L9;
        r1 = CollectionsKt.emptyList();
    L9:
        List r15 = r1;
        if ((r32 & 512) == 0) goto L12;
        w r16 = null;
    L14:
        if ((r32 & 1024) == 0) goto L16;
        q r17 = q.f9792a.a();
    L17:
        this(r19, r20, r21, r22, r9, r24, r25, r27, r15, r16, r17);
        return;
    L16:
        r17 = r31;
        goto L17
    L12:
        r16 = r30;
        goto L14
    L5:
        r9 = r23;
        goto L7
    }

    public static /* synthetic */ d a(d r14, String r15, String r16, DataExportPhase r17, String r18, Integer r19, int r20, long r21, long r23, List r25, w r26, q r27, int r28, Object r29) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        if ((r28 & 1) == 0) goto L5;
        String r3 = r14.f9763a;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r4 = r14.f9764b;
    L11:
        if ((r28 & 4) == 0) goto L13;
        DataExportPhase r5 = r14.c;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r6 = r14.d;
    L19:
        if ((r28 & 16) == 0) goto L21;
        Integer r7 = r14.e;
    L23:
        if ((r28 & 32) == 0) goto L25;
        int r8 = r14.f;
    L27:
        if ((r28 & 64) == 0) goto L29;
        long r9 = r14.g;
    L31:
        if ((r28 & 128) == 0) goto L33;
        long r11 = r14.h;
    L35:
        if ((r28 & 256) == 0) goto L38;
        r2 = r14.i;
    L38:
        if ((r28 & 512) == 0) goto L40;
        w r13 = r14.j;
    L42:
        if ((r28 & 1024) == 0) goto L44;
        q r1 = r14.k;
    L46:
        return r14.a(r3, r4, r5, r6, r7, r8, r9, r11, r2, r13, r1);
    L44:
        r1 = r27;
        goto L46
    L40:
        r13 = r26;
        goto L42
    L33:
        r11 = r23;
        goto L35
    L29:
        r9 = r21;
        goto L31
    L25:
        r8 = r20;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L13:
        r5 = r17;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r3 = r15;
        goto L7
    }

    public final d a(String r16, String r17, DataExportPhase r18, String r19, Integer r20, int r21, long r22, long r24, List<String> r26, w r27, q r28) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "taskId");
        Intrinsics.checkNotNullParameter(r17, "userId");
        Intrinsics.checkNotNullParameter(r18, TypedValues.CycleType.S_WAVE_PHASE);
        Intrinsics.checkNotNullParameter(r19, "message");
        Intrinsics.checkNotNullParameter(r12, "workingFilePaths");
        Intrinsics.checkNotNullParameter(r28, "statistics");
        return new d(r16, r17, r18, r19, r20, r21, r22, r24, r12, r27, r28);
    }

    public final String a() {
        return this.f9763a;
    }

    public final String b() {
        return this.f9764b;
    }

    public final DataExportPhase c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final Integer e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9763a, r10.f9763a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9764b, r10.f9764b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((((((this.f9763a.hashCode() * 31) + this.f9764b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        Integer r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((r0 + r3) * 31) + Integer.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + this.i.hashCode()) * 31;
        w r5 = this.j;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + this.k.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final List<String> i() {
        return this.i;
    }

    public final w j() {
        return this.j;
    }

    public final q k() {
        return this.k;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("DataExportTaskSnapshot(taskId=").append(this.f9763a).append(", userId=").append(this.f9764b).append(", phase=").append(this.c).append(", message=").append(this.d).append(", percent=").append(this.e).append(", retryCount=").append(this.f).append(", startedAt=").append(this.g).append(", updatedAt=").append(this.h).append(", workingFilePaths=").append(this.i).append(", result=").append(this.j).append(", statistics=").append(this.k).append(')');
        return r0.toString();
    }
}
