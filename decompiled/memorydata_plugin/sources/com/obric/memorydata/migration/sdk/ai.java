package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/migration/sdk/TableBackupConfig;", "", "tableName", "", "exportSQL", "resourceExtractors", "", "Lcom/obric/memorydata/migration/sdk/ResourceExtractor;", "autoDiscoverResources", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)V", "getTableName", "()Ljava/lang/String;", "getExportSQL", "getResourceExtractors", "()Ljava/util/Map;", "getAutoDiscoverResources", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11889b;
    private final Map<String, af> c;
    private final boolean d;

    public ai(String r3, String r4, Map<String, ? extends af> r5, boolean r6) {
        Map<String, af> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "tableName");
        Intrinsics.checkNotNullParameter(r7, "resourceExtractors");
        this.f11888a = r3;
        this.f11889b = r4;
        this.c = r7;
        this.d = r6;
    }

    public /* synthetic */ ai(String r2, String r3, Map r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r8 = MapsKt.emptyMap();
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r2, r3, r8, r5);
    }

    public static /* synthetic */ ai a(ai r1, String r2, String r3, Map r4, boolean r5, int r6, Object r7) {
        Map<String, af> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.f11888a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.f11889b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.c;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.d;
    L15:
        return r1.a(r2, r3, r8, r5);
    }

    public final ai a(String r2, String r3, Map<String, ? extends af> r4, boolean r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "tableName");
        Intrinsics.checkNotNullParameter(r1, "resourceExtractors");
        return new ai(r2, r3, r1, r5);
    }

    public final String a() {
        return this.f11888a;
    }

    public final String b() {
        return this.f11889b;
    }

    public final Map<String, af> c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ai.class) == true) goto L8;
        return false;
    L8:
        ai r6 = (ai) ZeusTransformUtils.preCheckCast(r5, ai.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11888a, r6.f11888a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11889b, r6.f11889b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.f11888a.hashCode() * 31;
        String r1 = this.f11889b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "TableBackupConfig(tableName=" + this.f11888a + ", exportSQL=" + this.f11889b + ", resourceExtractors=" + this.c + ", autoDiscoverResources=" + this.d + ')';
    }
}
