package com.obric.memorydata.memory.ui.migration;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState;", "", "<init>", "()V", "WaitingForScan", "Error", "Connecting", "Encrypting", "Restoring", "Transferring", "Success", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Connecting;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Encrypting;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Restoring;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Success;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Transferring;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$WaitingForScan;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class b {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Connecting;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11365a = null;

        static {
            f11365a = new a();
        }

        private a() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.migration.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Encrypting;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0611b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0611b f11366a = null;

        static {
            f11366a = new C0611b();
        }

        private C0611b() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState;", "<init>", "()V", "AccountMismatch", "VersionTooLow", "NetworkError", "TransferFailed", "StorageFull", "GenericError", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error$AccountMismatch;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error$GenericError;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error$NetworkError;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error$StorageFull;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error$TransferFailed;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error$VersionTooLow;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class c extends b {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error$AccountMismatch;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f11367a = null;

            static {
                f11367a = new a();
            }

            private a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.migration.b$c$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error$GenericError;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error;", "isExport", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0612b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final boolean f11368a;

            public C0612b(boolean r2) {
                super(null);
                this.f11368a = r2;
            }

            public final boolean a() {
                return this.f11368a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0612b.class) == true) goto L8;
                return false;
            L8:
                C0612b r6 = (C0612b) ZeusTransformUtils.preCheckCast(r5, C0612b.class, "com.obric.memorydata.plugin");
                if (this.f11368a == r6.f11368a) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Boolean.hashCode(this.f11368a);
            }

            public String toString() {
                return "GenericError(isExport=" + this.f11368a + ')';
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.migration.b$c$c, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error$NetworkError;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0613c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0613c f11369a = null;

            static {
                f11369a = new C0613c();
            }

            private C0613c() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error$StorageFull;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f11370a = null;

            static {
                f11370a = new d();
            }

            private d() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error$TransferFailed;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error;", "isExport", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class e extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final boolean f11371a;

            public e(boolean r2) {
                super(null);
                this.f11371a = r2;
            }

            public final boolean a() {
                return this.f11371a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
                return false;
            L8:
                e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
                if (this.f11371a == r6.f11371a) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Boolean.hashCode(this.f11371a);
            }

            public String toString() {
                return "TransferFailed(isExport=" + this.f11371a + ')';
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error$VersionTooLow;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Error;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class f extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f f11372a = null;

            static {
                f11372a = new f();
            }

            private f() {
                super(null);
            }
        }

        private c() {
            super(null);
        }

        public /* synthetic */ c(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Restoring;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f11373a = null;

        static {
            f11373a = new d();
        }

        private d() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Success;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState;", "<init>", "()V", "Import", "Export", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Success$Export;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Success$Import;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class e extends b {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Success$Export;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Success;", "exportScope", "", "<init>", "(Ljava/lang/Integer;)V", "getExportScope", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/obric/memorydata/memory/ui/migration/MigrationState$Success$Export;", "equals", "", "other", "", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Integer f11374a;

            /* JADX WARN: Multi-variable type inference failed */
            public a() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public a(Integer r2) {
                super(null);
                this.f11374a = r2;
            }

            public /* synthetic */ a(Integer r1, int r2, DefaultConstructorMarker r3) {
                if ((r2 & 1) == 0) goto L5;
                r1 = null;
            L5:
                this(r1);
            }

            public final Integer a() {
                return this.f11374a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f11374a, r6.f11374a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                Integer r0 = this.f11374a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public String toString() {
                return "Export(exportScope=" + this.f11374a + ')';
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.migration.b$e$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Success$Import;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Success;", "exportScope", "", "<init>", "(Ljava/lang/Integer;)V", "getExportScope", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/obric/memorydata/memory/ui/migration/MigrationState$Success$Import;", "equals", "", "other", "", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0614b extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Integer f11375a;

            /* JADX WARN: Multi-variable type inference failed */
            public C0614b() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public C0614b(Integer r2) {
                super(null);
                this.f11375a = r2;
            }

            public /* synthetic */ C0614b(Integer r1, int r2, DefaultConstructorMarker r3) {
                if ((r2 & 1) == 0) goto L5;
                r1 = null;
            L5:
                this(r1);
            }

            public final Integer a() {
                return this.f11375a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0614b.class) == true) goto L8;
                return false;
            L8:
                C0614b r6 = (C0614b) ZeusTransformUtils.preCheckCast(r5, C0614b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f11375a, r6.f11375a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                Integer r0 = this.f11375a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public String toString() {
                return "Import(exportScope=" + this.f11375a + ')';
            }
        }

        private e() {
            super(null);
        }

        public /* synthetic */ e(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$Transferring;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState;", "progress", "", "transferredSize", "", "totalSize", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getProgress", "()I", "getTransferredSize", "()Ljava/lang/String;", "getTotalSize", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11377b;
        private final String c;

        public f(int r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "transferredSize");
            Intrinsics.checkNotNullParameter(r4, "totalSize");
            super(null);
            this.f11376a = r2;
            this.f11377b = r3;
            this.c = r4;
        }

        public final int a() {
            return this.f11376a;
        }

        public final String b() {
            return this.f11377b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
            if (this.f11376a == r6.f11376a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11377b, r6.f11377b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f11376a) * 31) + this.f11377b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Transferring(progress=" + this.f11376a + ", transferredSize=" + this.f11377b + ", totalSize=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/MigrationState$WaitingForScan;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState;", "qrText", "", "<init>", "(Ljava/lang/String;)V", "getQrText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11378a;

        /* JADX WARN: Multi-variable type inference failed */
        public g() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public g(String r2) {
            Intrinsics.checkNotNullParameter(r2, "qrText");
            super(null);
            this.f11378a = r2;
        }

        public /* synthetic */ g(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = "";
        L5:
            this(r1);
        }

        public final String a() {
            return this.f11378a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11378a, r6.f11378a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f11378a.hashCode();
        }

        public String toString() {
            return "WaitingForScan(qrText=" + this.f11378a + ')';
        }
    }

    private b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker r1) {
        this();
    }
}
