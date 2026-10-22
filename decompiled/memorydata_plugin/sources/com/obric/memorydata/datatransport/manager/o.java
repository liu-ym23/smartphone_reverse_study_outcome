package com.obric.memorydata.datatransport.manager;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J:\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportProgress;", "", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/obric/memorydata/datatransport/manager/DataExportPhase;", "message", "", "percent", "", "statistics", "Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;", "<init>", "(Lcom/obric/memorydata/datatransport/manager/DataExportPhase;Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;)V", "getPhase", "()Lcom/obric/memorydata/datatransport/manager/DataExportPhase;", "getMessage", "()Ljava/lang/String;", "getPercent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatistics", "()Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;", "component1", "component2", "component3", "component4", "copy", "(Lcom/obric/memorydata/datatransport/manager/DataExportPhase;Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;)Lcom/obric/memorydata/datatransport/manager/ExportProgress;", "equals", "", "other", "hashCode", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataExportPhase f9786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9787b;
    private final Integer c;
    private final q d;

    public o(DataExportPhase r2, String r3, Integer r4, q r5) {
        Intrinsics.checkNotNullParameter(r2, TypedValues.CycleType.S_WAVE_PHASE);
        Intrinsics.checkNotNullParameter(r3, "message");
        this.f9786a = r2;
        this.f9787b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ o(DataExportPhase r2, String r3, Integer r4, q r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        this(r2, r3, r4, r5);
    }

    public final DataExportPhase a() {
        return this.f9786a;
    }

    public final String b() {
        return this.f9787b;
    }

    public final Integer c() {
        return this.c;
    }

    public final q d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
        return false;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.memorydata.plugin");
        if (this.f9786a == r6.f9786a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9787b, r6.f9787b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f9786a.hashCode() * 31) + this.f9787b.hashCode()) * 31;
        Integer r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        q r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ExportProgress(phase=" + this.f9786a + ", message=" + this.f9787b + ", percent=" + this.c + ", statistics=" + this.d + ')';
    }
}
