package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/migration/sdk/DbConfig;", "", "dbName", "", "role", "Lcom/obric/memorydata/migration/sdk/DbRole;", "tables", "", "Lcom/obric/memorydata/migration/sdk/TableBackupConfig;", "snapshotSourceDbName", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/migration/sdk/DbRole;Ljava/util/List;Ljava/lang/String;)V", "getDbName", "()Ljava/lang/String;", "getRole", "()Lcom/obric/memorydata/migration/sdk/DbRole;", "getTables", "()Ljava/util/List;", "getSnapshotSourceDbName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DbRole f11900b;
    private final List<ai> c;
    private final String d;

    public g(String r3, DbRole r4, List<ai> r5, String r6) {
        List<ai> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dbName");
        Intrinsics.checkNotNullParameter(r4, "role");
        Intrinsics.checkNotNullParameter(r7, "tables");
        this.f11899a = r3;
        this.f11900b = r4;
        this.c = r7;
        this.d = r6;
    }

    public /* synthetic */ g(String r2, DbRole r3, List r4, String r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = DbRole.GLOBAL;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r8 = CollectionsKt.emptyList();
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r8, r5);
    }

    public static /* synthetic */ g a(g r1, String r2, DbRole r3, List r4, String r5, int r6, Object r7) {
        List<ai> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.f11899a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.f11900b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.c;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.d;
    L15:
        return r1.a(r2, r3, r8, r5);
    }

    public final g a(String r2, DbRole r3, List<ai> r4, String r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "dbName");
        Intrinsics.checkNotNullParameter(r3, "role");
        Intrinsics.checkNotNullParameter(r1, "tables");
        return new g(r2, r3, r1, r5);
    }

    public final String a() {
        return this.f11899a;
    }

    public final DbRole b() {
        return this.f11900b;
    }

    public final List<ai> c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11899a, r6.f11899a) == true) goto L12;
        return false;
    L12:
        if (this.f11900b == r6.f11900b) goto L15;
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
        int r0 = ((((this.f11899a.hashCode() * 31) + this.f11900b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r2 = this.d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "DbConfig(dbName=" + this.f11899a + ", role=" + this.f11900b + ", tables=" + this.c + ", snapshotSourceDbName=" + this.d + ')';
    }
}
