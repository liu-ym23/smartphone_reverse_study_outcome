package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/migration/sdk/BackupConfig;", "", "dbs", "", "Lcom/obric/memorydata/migration/sdk/DbConfig;", "extraFiles", "Ljava/io/File;", "kvRepos", "Lcom/obric/memorydata/migration/sdk/KvRepoConfig;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDbs", "()Ljava/util/List;", "getExtraFiles", "getKvRepos", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<g> f11890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<File> f11891b;
    private final List<j> c;

    public b() {
        this(null, null, null, 7, null);
    }

    public b(List<g> r3, List<? extends File> r4, List<j> r5) {
        List<g> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<File> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<j> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "dbs");
        Intrinsics.checkNotNullParameter(r7, "extraFiles");
        Intrinsics.checkNotNullParameter(r8, "kvRepos");
        this.f11890a = r6;
        this.f11891b = r7;
        this.c = r8;
    }

    public /* synthetic */ b(List r2, List r3, List r4, int r5, DefaultConstructorMarker r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = CollectionsKt.emptyList();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = CollectionsKt.emptyList();
    L9:
        if ((r5 & 4) == 0) goto L11;
        r9 = CollectionsKt.emptyList();
    L11:
        this(r7, r8, r9);
    }

    public static /* synthetic */ b a(b r1, List r2, List r3, List r4, int r5, Object r6) {
        List<g> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<File> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<j> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.f11890a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = r1.f11891b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r9 = r1.c;
    L12:
        return r1.a(r7, r8, r9);
    }

    public final b a(List<g> r2, List<? extends File> r3, List<j> r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "dbs");
        Intrinsics.checkNotNullParameter(r5, "extraFiles");
        Intrinsics.checkNotNullParameter(r6, "kvRepos");
        return new b(r1, r5, r6);
    }

    public final List<g> a() {
        return this.f11890a;
    }

    public final List<File> b() {
        return this.f11891b;
    }

    public final List<j> c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11890a, r6.f11890a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11891b, r6.f11891b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f11890a.hashCode() * 31) + this.f11891b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "BackupConfig(dbs=" + this.f11890a + ", extraFiles=" + this.f11891b + ", kvRepos=" + this.c + ')';
    }
}
