package com.obric.memorydata.union.build.export;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/union/build/export/MemoryBuildDataPackageExportResult;", "", "file", "Ljava/io/File;", "backupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "<init>", "(Ljava/io/File;Lcom/obric/memorydata/migration/sdk/BackupConfig;)V", "getFile", "()Ljava/io/File;", "getBackupConfig", "()Lcom/obric/memorydata/migration/sdk/BackupConfig;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f13077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.migration.sdk.b f13078b;

    public c(File r2, com.obric.memorydata.migration.sdk.b r3) {
        Intrinsics.checkNotNullParameter(r2, "file");
        Intrinsics.checkNotNullParameter(r3, "backupConfig");
        this.f13077a = r2;
        this.f13078b = r3;
    }

    public final File a() {
        return this.f13077a;
    }

    public final com.obric.memorydata.migration.sdk.b b() {
        return this.f13078b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f13077a, r6.f13077a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f13078b, r6.f13078b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f13077a.hashCode() * 31) + this.f13078b.hashCode();
    }

    public String toString() {
        return "MemoryBuildDataPackageExportResult(file=" + this.f13077a + ", backupConfig=" + this.f13078b + ')';
    }
}
