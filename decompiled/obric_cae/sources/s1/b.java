package s1;

import androidx.work.impl.WorkDatabase;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class b extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j1.b0 f11950b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ UUID f11951m;

    public b(j1.b0 r8, UUID r10) {
        this.f11950b = r8;
        this.f11951m = r10;
    }

    @Override // s1.e
    public final void b() {
        j1.b0 r8 = this.f11950b;
        WorkDatabase r10 = r8.f8453c;
        r10.beginTransaction();
        e.a(r8, this.f11951m.toString());     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        j1.s.a(r8.f8452b, r8.f8453c, r8.f8455e);
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }
}
