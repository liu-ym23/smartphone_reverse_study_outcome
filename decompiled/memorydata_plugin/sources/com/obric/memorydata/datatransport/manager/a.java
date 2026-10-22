package com.obric.memorydata.datatransport.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision;", "", "<init>", "()V", "WaitForIdentity", "Discard", "KeepRunning", "RestoreSuccess", "RestoreFailed", "ShowInterrupted", "Restart", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$Discard;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$KeepRunning;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$Restart;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$RestoreFailed;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$RestoreSuccess;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$ShowInterrupted;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$WaitForIdentity;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: com.obric.memorydata.datatransport.manager.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$Discard;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0473a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0473a f9752a = null;

        static {
            f9752a = new C0473a();
        }

        private C0473a() {
            super(null);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, C0473a.class) == true) goto L9;
            return false;
        L9:
            C0473a r2 = (C0473a) ZeusTransformUtils.preCheckCast(r3, C0473a.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return -828364816;
        }

        public String toString() {
            return "Discard";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$KeepRunning;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9753a = null;

        static {
            f9753a = new b();
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
            return 160995532;
        }

        public String toString() {
            return "KeepRunning";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$Restart;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision;", "retryCount", "", "<init>", "(I)V", "getRetryCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9754a;

        public c(int r2) {
            super(null);
            this.f9754a = r2;
        }

        public final int a() {
            return this.f9754a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (this.f9754a == r6.f9754a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.f9754a);
        }

        public String toString() {
            return "Restart(retryCount=" + this.f9754a + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$RestoreFailed;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f9755a = null;

        static {
            f9755a = new d();
        }

        private d() {
            super(null);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, d.class) == true) goto L9;
            return false;
        L9:
            d r2 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return -194868675;
        }

        public String toString() {
            return "RestoreFailed";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$RestoreSuccess;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f9756a = null;

        static {
            f9756a = new e();
        }

        private e() {
            super(null);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, e.class) == true) goto L9;
            return false;
        L9:
            e r2 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return 1768425987;
        }

        public String toString() {
            return "RestoreSuccess";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$ShowInterrupted;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f9757a = null;

        static {
            f9757a = new f();
        }

        private f() {
            super(null);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, f.class) == true) goto L9;
            return false;
        L9:
            f r2 = (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return -1363224489;
        }

        public String toString() {
            return "ShowInterrupted";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision$WaitForIdentity;", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f9758a = null;

        static {
            f9758a = new g();
        }

        private g() {
            super(null);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, g.class) == true) goto L9;
            return false;
        L9:
            g r2 = (g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return -264289980;
        }

        public String toString() {
            return "WaitForIdentity";
        }
    }

    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker r1) {
        this();
    }
}
