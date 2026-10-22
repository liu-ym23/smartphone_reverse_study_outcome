package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003JQ\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lcom/obric/memorydata/migration/sdk/ReceiverRunConfig;", "", "uid", "", "appVersionCode", "", "connectRequest", "Lcom/obric/memorydata/migration/sdk/ConnectRequest;", "publicResourceRestoreDir", "Ljava/io/File;", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "backupConfigOverride", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "clearNonRestoredTables", "", "<init>", "(Ljava/lang/String;JLcom/obric/memorydata/migration/sdk/ConnectRequest;Ljava/io/File;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lcom/obric/memorydata/migration/sdk/BackupConfig;Z)V", "getUid", "()Ljava/lang/String;", "getAppVersionCode", "()J", "getConnectRequest", "()Lcom/obric/memorydata/migration/sdk/ConnectRequest;", "getPublicResourceRestoreDir", "()Ljava/io/File;", "getCallback", "()Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "getBackupConfigOverride", "()Lcom/obric/memorydata/migration/sdk/BackupConfig;", "getClearNonRestoredTables", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11884b;
    private final d c;
    private final File d;
    private final m e;
    private final b f;
    private final boolean g;

    public ae(String r3, long r4, d r6, File r7, m r8, b r9, boolean r10) {
        m r11 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r6, "connectRequest");
        Intrinsics.checkNotNullParameter(r7, "publicResourceRestoreDir");
        Intrinsics.checkNotNullParameter(r11, "callback");
        this.f11883a = r3;
        this.f11884b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r11;
        this.f = r9;
        this.g = r10;
    }

    public final String a() {
        return this.f11883a;
    }

    public final long b() {
        return this.f11884b;
    }

    public final d c() {
        return this.c;
    }

    public final File d() {
        return this.d;
    }

    public final m e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ae.class) == true) goto L8;
        return false;
    L8:
        ae r10 = (ae) ZeusTransformUtils.preCheckCast(r9, ae.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11883a, r10.f11883a) == true) goto L12;
        return false;
    L12:
        if (this.f11884b == r10.f11884b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final b f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public int hashCode() {
        int r0 = ((((((((this.f11883a.hashCode() * 31) + Long.hashCode(this.f11884b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        b r1 = this.f;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Boolean.hashCode(this.g);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ReceiverRunConfig(uid=" + this.f11883a + ", appVersionCode=" + this.f11884b + ", connectRequest=" + this.c + ", publicResourceRestoreDir=" + this.d + ", callback=" + this.e + ", backupConfigOverride=" + this.f + ", clearNonRestoredTables=" + this.g + ')';
    }
}
