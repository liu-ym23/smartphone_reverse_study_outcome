package com.obric.memorydata.migration.sdk.internal.db;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/db/PrivateFileRoot;", "", "packagePrefix", "", "dir", "Ljava/io/File;", "<init>", "(Ljava/lang/String;Ljava/io/File;)V", "getPackagePrefix", "()Ljava/lang/String;", "getDir", "()Ljava/io/File;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f11925b;

    public g(String r2, File r3) {
        Intrinsics.checkNotNullParameter(r3, "dir");
        this.f11924a = r2;
        this.f11925b = r3;
    }

    public final String a() {
        return this.f11924a;
    }

    public final File b() {
        return this.f11925b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11924a, r6.f11924a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11925b, r6.f11925b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f11924a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.f11925b.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "PrivateFileRoot(packagePrefix=" + this.f11924a + ", dir=" + this.f11925b + ')';
    }
}
