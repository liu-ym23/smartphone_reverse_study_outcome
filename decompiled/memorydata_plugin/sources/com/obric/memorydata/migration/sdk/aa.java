package com.obric.memorydata.migration.sdk;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationStoragePolicy;", "", "<init>", "()V", "ZIP_FREE_MULTIPLIER", "", "MIN_FREE_BYTES", "", "requiredFreeBytesByZip", "zipBytes", "multiplier", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aa f11880a = null;

    static {
        f11880a = new aa();
    }

    private aa() {
    }

    public final long a(long r5, double r7) {
        if (r5 > 0) goto L6;
        return 209715200;
    L6:
        return Math.max((long) (r5 * r7), r5 + 209715200);
    }
}
