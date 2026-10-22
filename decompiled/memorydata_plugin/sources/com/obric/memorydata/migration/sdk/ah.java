package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017JB\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/obric/memorydata/migration/sdk/SenderRunConfig;", "", "uid", "", "appVersionCode", "", "backupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "exportScope", "", "<init>", "(Ljava/lang/String;JLcom/obric/memorydata/migration/sdk/BackupConfig;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Ljava/lang/Integer;)V", "getUid", "()Ljava/lang/String;", "getAppVersionCode", "()J", "getBackupConfig", "()Lcom/obric/memorydata/migration/sdk/BackupConfig;", "getCallback", "()Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "getExportScope", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;JLcom/obric/memorydata/migration/sdk/BackupConfig;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Ljava/lang/Integer;)Lcom/obric/memorydata/migration/sdk/SenderRunConfig;", "equals", "", "other", "hashCode", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11887b;
    private final b c;
    private final m d;
    private final Integer e;

    public ah(String r3, long r4, b r6, m r7, Integer r8) {
        m r9 = (m) ZeusTransformUtils.wrapperContextForParams(r7, m.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r6, "backupConfig");
        Intrinsics.checkNotNullParameter(r9, "callback");
        this.f11886a = r3;
        this.f11887b = r4;
        this.c = r6;
        this.d = r9;
        this.e = r8;
    }

    public final String a() {
        return this.f11886a;
    }

    public final long b() {
        return this.f11887b;
    }

    public final b c() {
        return this.c;
    }

    public final m d() {
        return this.d;
    }

    public final Integer e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ah.class) == true) goto L8;
        return false;
    L8:
        ah r10 = (ah) ZeusTransformUtils.preCheckCast(r9, ah.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11886a, r10.f11886a) == true) goto L12;
        return false;
    L12:
        if (this.f11887b == r10.f11887b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.f11886a.hashCode() * 31) + Long.hashCode(this.f11887b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        Integer r3 = this.e;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "SenderRunConfig(uid=" + this.f11886a + ", appVersionCode=" + this.f11887b + ", backupConfig=" + this.c + ", callback=" + this.d + ", exportScope=" + this.e + ')';
    }
}
