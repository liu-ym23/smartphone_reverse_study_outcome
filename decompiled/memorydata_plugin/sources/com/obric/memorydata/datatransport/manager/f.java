package com.obric.memorydata.datatransport.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskState;", "", "<init>", "()V", "Idle", "Running", "Success", "Failed", "Interrupted", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState$Failed;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState$Idle;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState$Interrupted;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState$Running;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState$Success;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class f {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskState$Failed;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState;", "snapshot", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "message", "", "<init>", "(Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;Ljava/lang/String;)V", "getSnapshot", "()Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.memorydata.datatransport.manager.d f9767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9768b;

        public a(com.obric.memorydata.datatransport.manager.d r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "snapshot");
            Intrinsics.checkNotNullParameter(r3, "message");
            super(null);
            this.f9767a = r2;
            this.f9768b = r3;
        }

        public final com.obric.memorydata.datatransport.manager.d a() {
            return this.f9767a;
        }

        public final String b() {
            return this.f9768b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9767a, r6.f9767a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9768b, r6.f9768b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9767a.hashCode() * 31) + this.f9768b.hashCode();
        }

        public String toString() {
            return "Failed(snapshot=" + this.f9767a + ", message=" + this.f9768b + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskState$Idle;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9769a = null;

        static {
            f9769a = new b();
        }

        private b() {
            super(null);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L9;
            return false;
        L9:
            b r2 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return -601941211;
        }

        public String toString() {
            return "Idle";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskState$Interrupted;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState;", "snapshot", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "message", "", "<init>", "(Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;Ljava/lang/String;)V", "getSnapshot", "()Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.memorydata.datatransport.manager.d f9770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9771b;

        public c(com.obric.memorydata.datatransport.manager.d r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "snapshot");
            Intrinsics.checkNotNullParameter(r3, "message");
            super(null);
            this.f9770a = r2;
            this.f9771b = r3;
        }

        public final com.obric.memorydata.datatransport.manager.d a() {
            return this.f9770a;
        }

        public final String b() {
            return this.f9771b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9770a, r6.f9770a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9771b, r6.f9771b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9770a.hashCode() * 31) + this.f9771b.hashCode();
        }

        public String toString() {
            return "Interrupted(snapshot=" + this.f9770a + ", message=" + this.f9771b + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskState$Running;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState;", "snapshot", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "<init>", "(Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;)V", "getSnapshot", "()Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.memorydata.datatransport.manager.d f9772a;

        public d(com.obric.memorydata.datatransport.manager.d r2) {
            Intrinsics.checkNotNullParameter(r2, "snapshot");
            super(null);
            this.f9772a = r2;
        }

        public final com.obric.memorydata.datatransport.manager.d a() {
            return this.f9772a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9772a, r6.f9772a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f9772a.hashCode();
        }

        public String toString() {
            return "Running(snapshot=" + this.f9772a + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskState$Success;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState;", "snapshot", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "result", "Lcom/obric/memorydata/datatransport/manager/ExportResult;", "<init>", "(Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;Lcom/obric/memorydata/datatransport/manager/ExportResult;)V", "getSnapshot", "()Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "getResult", "()Lcom/obric/memorydata/datatransport/manager/ExportResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.memorydata.datatransport.manager.d f9773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final s f9774b;

        public e(com.obric.memorydata.datatransport.manager.d r2, s r3) {
            Intrinsics.checkNotNullParameter(r2, "snapshot");
            Intrinsics.checkNotNullParameter(r3, "result");
            super(null);
            this.f9773a = r2;
            this.f9774b = r3;
        }

        public final com.obric.memorydata.datatransport.manager.d a() {
            return this.f9773a;
        }

        public final s b() {
            return this.f9774b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9773a, r6.f9773a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9774b, r6.f9774b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9773a.hashCode() * 31) + this.f9774b.hashCode();
        }

        public String toString() {
            return "Success(snapshot=" + this.f9773a + ", result=" + this.f9774b + ')';
        }
    }

    private f() {
    }

    public /* synthetic */ f(DefaultConstructorMarker r1) {
        this();
    }
}
