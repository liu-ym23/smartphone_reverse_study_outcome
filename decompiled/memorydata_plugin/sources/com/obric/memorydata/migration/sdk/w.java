package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationPackage;", "", "file", "Ljava/io/File;", "sizeBytes", "", "checksumSha256", "", "<init>", "(Ljava/io/File;JLjava/lang/String;)V", "getFile", "()Ljava/io/File;", "getSizeBytes", "()J", "getChecksumSha256", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f11985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11986b;
    private final String c;

    public w(File r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "file");
        Intrinsics.checkNotNullParameter(r5, "checksumSha256");
        this.f11985a = r2;
        this.f11986b = r3;
        this.c = r5;
    }

    public final File a() {
        return this.f11985a;
    }

    public final long b() {
        return this.f11986b;
    }

    public final String c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, w.class) == true) goto L8;
        return false;
    L8:
        w r10 = (w) ZeusTransformUtils.preCheckCast(r9, w.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11985a, r10.f11985a) == true) goto L12;
        return false;
    L12:
        if (this.f11986b == r10.f11986b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f11985a.hashCode() * 31) + Long.hashCode(this.f11986b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "MigrationPackage(file=" + this.f11985a + ", sizeBytes=" + this.f11986b + ", checksumSha256=" + this.c + ')';
    }
}
