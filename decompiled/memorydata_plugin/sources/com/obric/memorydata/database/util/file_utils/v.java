package com.obric.memorydata.database.util.file_utils;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PptxPreflightResult;", "", "<init>", "()V", "Accepted", "Rejected", "Lcom/obric/memorydata/database/util/file_utils/PptxPreflightResult$Accepted;", "Lcom/obric/memorydata/database/util/file_utils/PptxPreflightResult$Rejected;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class v {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PptxPreflightResult$Accepted;", "Lcom/obric/memorydata/database/util/file_utils/PptxPreflightResult;", "stats", "Lcom/obric/memorydata/database/util/file_utils/PptxPreflightStats;", "<init>", "(Lcom/obric/memorydata/database/util/file_utils/PptxPreflightStats;)V", "getStats", "()Lcom/obric/memorydata/database/util/file_utils/PptxPreflightStats;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final w f9668a;

        public a(w r2) {
            Intrinsics.checkNotNullParameter(r2, "stats");
            super(null);
            this.f9668a = r2;
        }

        public final w a() {
            return this.f9668a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9668a, r6.f9668a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f9668a.hashCode();
        }

        public String toString() {
            return "Accepted(stats=" + this.f9668a + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PptxPreflightResult$Rejected;", "Lcom/obric/memorydata/database/util/file_utils/PptxPreflightResult;", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/memorydata/database/util/file_utils/PptxPreflightRejectReason;", "stats", "Lcom/obric/memorydata/database/util/file_utils/PptxPreflightStats;", "<init>", "(Lcom/obric/memorydata/database/util/file_utils/PptxPreflightRejectReason;Lcom/obric/memorydata/database/util/file_utils/PptxPreflightStats;)V", "getReason", "()Lcom/obric/memorydata/database/util/file_utils/PptxPreflightRejectReason;", "getStats", "()Lcom/obric/memorydata/database/util/file_utils/PptxPreflightStats;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PptxPreflightRejectReason f9669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final w f9670b;

        public b(PptxPreflightRejectReason r2, w r3) {
            Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
            Intrinsics.checkNotNullParameter(r3, "stats");
            super(null);
            this.f9669a = r2;
            this.f9670b = r3;
        }

        public final PptxPreflightRejectReason a() {
            return this.f9669a;
        }

        public final w b() {
            return this.f9670b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f9669a == r6.f9669a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9670b, r6.f9670b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9669a.hashCode() * 31) + this.f9670b.hashCode();
        }

        public String toString() {
            return "Rejected(reason=" + this.f9669a + ", stats=" + this.f9670b + ')';
        }
    }

    private v() {
    }

    public /* synthetic */ v(DefaultConstructorMarker r1) {
        this();
    }
}
