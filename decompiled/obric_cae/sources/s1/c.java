package s1;

import androidx.work.impl.WorkDatabase;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j1.b0 f11956b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f11957m;

    public c(j1.b0 r8, String r10) {
        this.f11956b = r8;
        this.f11957m = r10;
    }

    @Override // s1.e
    public final void b() {
        j1.b0 r8 = this.f11956b;
        WorkDatabase r10 = r8.f8453c;
        r10.beginTransaction();
        Iterator r11 = r10.f().h(this.f11957m).iterator();     // Catch: Throwable -> L10
    L5:
        if (r11.hasNext() == false) goto L7;
        e.a(r8, (String) r11.next());     // Catch: Throwable -> L10
        goto L5
    L7:
        r10.setTransactionSuccessful();     // Catch: Throwable -> L10
        r10.endTransaction();
        j1.s.a(r8.f8452b, r8.f8453c, r8.f8455e);
        return;
    L10:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }
}
