package com.obric.memorydata.database.index;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.cd;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0007\b\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/index/PendingDeleteSpec;", "", "Exact", "RawIds", "BuildType", "EntityTypeBuildType", com.tom_roush.pdfbox.pdmodel.a.d.h.h, "IdTimestamp", "Lcom/obric/memorydata/database/index/LegacyOwnerBuildTypeDeleteSpec;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec$BuildType;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec$Column;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec$EntityTypeBuildType;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec$Exact;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec$IdTimestamp;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec$RawIds;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ax {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/index/PendingDeleteSpec$BuildType;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec;", "rawDbIds", "", "", "entityType", "", "buildType", "", "<init>", "(Ljava/util/List;ILjava/lang/String;)V", "getRawDbIds", "()Ljava/util/List;", "getEntityType", "()I", "getBuildType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements ax {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Long> f9392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9393b;
        private final String c;

        public a(List<Long> r3, int r4, String r5) {
            List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "rawDbIds");
            Intrinsics.checkNotNullParameter(r5, "buildType");
            this.f9392a = r6;
            this.f9393b = r4;
            this.c = r5;
        }

        public final List<Long> a() {
            return this.f9392a;
        }

        public final int b() {
            return this.f9393b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9392a, r6.f9392a) == true) goto L12;
            return false;
        L12:
            if (this.f9393b == r6.f9393b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f9392a.hashCode() * 31) + Integer.hashCode(this.f9393b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "BuildType(rawDbIds=" + this.f9392a + ", entityType=" + this.f9393b + ", buildType=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/database/index/PendingDeleteSpec$Column;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec;", "rawDbId", "", "entityType", "", "column", "", "<init>", "(JILjava/lang/String;)V", "getRawDbId", "()J", "getEntityType", "()I", "getColumn", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements ax {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9395b;
        private final String c;

        public b(long r2, int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "column");
            this.f9394a = r2;
            this.f9395b = r4;
            this.c = r5;
        }

        public final long a() {
            return this.f9394a;
        }

        public final int b() {
            return this.f9395b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (this.f9394a == r10.f9394a) goto L12;
            return false;
        L12:
            if (this.f9395b == r10.f9395b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f9394a) * 31) + Integer.hashCode(this.f9395b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Column(rawDbId=" + this.f9394a + ", entityType=" + this.f9395b + ", column=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/index/PendingDeleteSpec$EntityTypeBuildType;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec;", "entityType", "", "buildType", "", "<init>", "(ILjava/lang/String;)V", "getEntityType", "()I", "getBuildType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements ax {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9397b;

        public c(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "buildType");
            this.f9396a = r2;
            this.f9397b = r3;
        }

        public final int a() {
            return this.f9396a;
        }

        public final String b() {
            return this.f9397b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (this.f9396a == r6.f9396a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9397b, r6.f9397b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f9396a) * 31) + this.f9397b.hashCode();
        }

        public String toString() {
            return "EntityTypeBuildType(entityType=" + this.f9396a + ", buildType=" + this.f9397b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/index/PendingDeleteSpec$Exact;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec;", "rows", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "<init>", "(Ljava/util/List;)V", "fingerprints", "Lcom/obric/memorydata/database/index/PendingExactFingerprint;", "getFingerprints$database_obricRelease", "()Ljava/util/List;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements ax {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<ay> f9398a;

        public d(List<cd> r13) {
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r14, "rows");
            Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r16 = r15.iterator();
        L4:
            if (r16.hasNext() == false) goto L6;
            cd r2 = (cd) ZeusTransformUtils.preCheckCast(r16.next(), cd.class, "com.obric.memorydata.plugin");
            r0.add(new ay(r2.a(), r2.d(), r2.b(), r2.c()));
            goto L4
        L6:
            this.f9398a = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        }

        public final List<ay> a() {
            return this.f9398a;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/index/PendingDeleteSpec$IdTimestamp;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec;", OaidModel.KEY_ID, "", "timestamp", "entityType", "", "<init>", "(JJI)V", "getId", "()J", "getTimestamp", "getEntityType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements ax {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9400b;
        private final int c;

        public e(long r1, long r3, int r5) {
            this.f9399a = r1;
            this.f9400b = r3;
            this.c = r5;
        }

        public final long a() {
            return this.f9399a;
        }

        public final long b() {
            return this.f9400b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
            return false;
        L8:
            e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.memorydata.plugin");
            if (this.f9399a == r10.f9399a) goto L12;
            return false;
        L12:
            if (this.f9400b == r10.f9400b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f9399a) * 31) + Long.hashCode(this.f9400b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "IdTimestamp(id=" + this.f9399a + ", timestamp=" + this.f9400b + ", entityType=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/index/PendingDeleteSpec$RawIds;", "Lcom/obric/memorydata/database/index/PendingDeleteSpec;", "rawDbIds", "", "", "entityType", "", "<init>", "(Ljava/util/List;I)V", "getRawDbIds", "()Ljava/util/List;", "getEntityType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements ax {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Long> f9401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9402b;

        public final List<Long> a() {
            return this.f9401a;
        }

        public final int b() {
            return this.f9402b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9401a, r6.f9401a) == true) goto L12;
            return false;
        L12:
            if (this.f9402b == r6.f9402b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9401a.hashCode() * 31) + Integer.hashCode(this.f9402b);
        }

        public String toString() {
            return "RawIds(rawDbIds=" + this.f9401a + ", entityType=" + this.f9402b + ')';
        }
    }
}
