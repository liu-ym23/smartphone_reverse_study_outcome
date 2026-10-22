package cv;

import java.sql.Savepoint;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Savepoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16521b;

    public d(int r5) {
        this.f16520a = r5;
        this.f16521b = null;
    }

    @Override // java.sql.Savepoint
    public final int getSavepointId() {
        return this.f16520a;
    }

    @Override // java.sql.Savepoint
    public final String getSavepointName() {
        String r5 = this.f16521b;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return "SQLITE_SAVEPOINT_" + this.f16520a;
    }

    public d(int r5, String r10) {
        this.f16520a = r5;
        this.f16521b = r10;
    }
}
