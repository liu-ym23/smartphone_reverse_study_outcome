package com.obric.memorydata.migration.sdk;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationEvent;", "", "<init>", "()V", "State", "Progress", "Error", "SenderRequest", "Artifact", "Lcom/obric/memorydata/migration/sdk/MigrationEvent$Artifact;", "Lcom/obric/memorydata/migration/sdk/MigrationEvent$Error;", "Lcom/obric/memorydata/migration/sdk/MigrationEvent$Progress;", "Lcom/obric/memorydata/migration/sdk/MigrationEvent$SenderRequest;", "Lcom/obric/memorydata/migration/sdk/MigrationEvent$State;", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class p {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationEvent$Artifact;", "Lcom/obric/memorydata/migration/sdk/MigrationEvent;", ActivityLifecycle.NAME, "", "path", "sizeBytes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getPath", "getSizeBytes", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11970b;
        private final long c;

        public a(String r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r3, "path");
            super(null);
            this.f11969a = r2;
            this.f11970b = r3;
            this.c = r4;
        }

        public /* synthetic */ a(String r1, String r2, long r3, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 4) == 0) goto L5;
            r3 = 0;
        L5:
            this(r1, r2, r3);
        }

        public final String a() {
            return this.f11969a;
        }

        public final String b() {
            return this.f11970b;
        }

        public final long c() {
            return this.c;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11969a, r8.f11969a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11970b, r8.f11970b) == true) goto L15;
            return false;
        L15:
            if (this.c == r8.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f11969a.hashCode() * 31) + this.f11970b.hashCode()) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "Artifact(name=" + this.f11969a + ", path=" + this.f11970b + ", sizeBytes=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationEvent$Error;", "Lcom/obric/memorydata/migration/sdk/MigrationEvent;", "step", "Lcom/obric/memorydata/migration/sdk/MigrationStep;", "error", "Lcom/obric/memorydata/migration/sdk/MigrationError;", "<init>", "(Lcom/obric/memorydata/migration/sdk/MigrationStep;Lcom/obric/memorydata/migration/sdk/MigrationError;)V", "getStep", "()Lcom/obric/memorydata/migration/sdk/MigrationStep;", "getError", "()Lcom/obric/memorydata/migration/sdk/MigrationError;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MigrationStep f11971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final o f11972b;

        public b(MigrationStep r2, o r3) {
            Intrinsics.checkNotNullParameter(r2, "step");
            Intrinsics.checkNotNullParameter(r3, "error");
            super(null);
            this.f11971a = r2;
            this.f11972b = r3;
        }

        public final MigrationStep a() {
            return this.f11971a;
        }

        public final o b() {
            return this.f11972b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f11971a == r6.f11971a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11972b, r6.f11972b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11971a.hashCode() * 31) + this.f11972b.hashCode();
        }

        public String toString() {
            return "Error(step=" + this.f11971a + ", error=" + this.f11972b + ')';
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u000fHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationEvent$Progress;", "Lcom/obric/memorydata/migration/sdk/MigrationEvent;", "step", "Lcom/obric/memorydata/migration/sdk/MigrationStep;", "currentBytes", "", "totalBytes", "<init>", "(Lcom/obric/memorydata/migration/sdk/MigrationStep;JJ)V", "getStep", "()Lcom/obric/memorydata/migration/sdk/MigrationStep;", "getCurrentBytes", "()J", "getTotalBytes", "percent", "", "getPercent", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MigrationStep f11973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f11974b;
        private final long c;

        public c(MigrationStep r2, long r3, long r5) {
            Intrinsics.checkNotNullParameter(r2, "step");
            super(null);
            this.f11973a = r2;
            this.f11974b = r3;
            this.c = r5;
        }

        public final MigrationStep a() {
            return this.f11973a;
        }

        public final long b() {
            return this.f11974b;
        }

        public final long c() {
            return this.c;
        }

        public final int d() {
            long r0 = this.c;
            if (r0 > 0) goto L6;
            return 0;
        L6:
            return RangesKt.coerceIn((int) ((this.f11974b * ((long) 100)) / r0), 0, 100);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
            if (this.f11973a == r10.f11973a) goto L12;
            return false;
        L12:
            if (this.f11974b == r10.f11974b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f11973a.hashCode() * 31) + Long.hashCode(this.f11974b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "Progress(step=" + this.f11973a + ", currentBytes=" + this.f11974b + ", totalBytes=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationEvent$SenderRequest;", "Lcom/obric/memorydata/migration/sdk/MigrationEvent;", "qrText", "", "payload", "Lcom/obric/memorydata/migration/sdk/QrPayload;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/migration/sdk/QrPayload;)V", "getQrText", "()Ljava/lang/String;", "getPayload", "()Lcom/obric/memorydata/migration/sdk/QrPayload;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final QrPayload f11976b;

        public d(String r2, QrPayload r3) {
            Intrinsics.checkNotNullParameter(r2, "qrText");
            Intrinsics.checkNotNullParameter(r3, "payload");
            super(null);
            this.f11975a = r2;
            this.f11976b = r3;
        }

        public final String a() {
            return this.f11975a;
        }

        public final QrPayload b() {
            return this.f11976b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11975a, r6.f11975a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11976b, r6.f11976b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11975a.hashCode() * 31) + this.f11976b.hashCode();
        }

        public String toString() {
            return "SenderRequest(qrText=" + this.f11975a + ", payload=" + this.f11976b + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationEvent$State;", "Lcom/obric/memorydata/migration/sdk/MigrationEvent;", "step", "Lcom/obric/memorydata/migration/sdk/MigrationStep;", MemoryListActivity.JUMP_FROM_DETAIL, "", "<init>", "(Lcom/obric/memorydata/migration/sdk/MigrationStep;Ljava/lang/String;)V", "getStep", "()Lcom/obric/memorydata/migration/sdk/MigrationStep;", "getDetail", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MigrationStep f11977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11978b;

        public e(MigrationStep r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "step");
            super(null);
            this.f11977a = r2;
            this.f11978b = r3;
        }

        public final MigrationStep a() {
            return this.f11977a;
        }

        public final String b() {
            return this.f11978b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (this.f11977a == r6.f11977a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11978b, r6.f11978b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f11977a.hashCode() * 31;
            String r1 = this.f11978b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "State(step=" + this.f11977a + ", detail=" + this.f11978b + ')';
        }
    }

    private p() {
    }

    public /* synthetic */ p(DefaultConstructorMarker r1) {
        this();
    }
}
