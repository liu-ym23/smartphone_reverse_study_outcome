package s1;

import androidx.work.impl.WorkDatabase;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class d extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j1.b0 f11961b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f11962m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f11963n;

    public d(j1.b0 r8, String r10, boolean r11) {
        this.f11961b = r8;
        this.f11962m = r10;
        this.f11963n = r11;
    }

    @Override // s1.e
    public final void b() {
        j1.b0 r8 = this.f11961b;
        WorkDatabase r10 = r8.f8453c;
        r10.beginTransaction();
        Iterator r11 = r10.f().e(this.f11962m).iterator();     // Catch: Throwable -> L12
    L5:
        if (r11.hasNext() == false) goto L7;
        e.a(r8, (String) r11.next());     // Catch: Throwable -> L12
        goto L5
    L7:
        r10.setTransactionSuccessful();     // Catch: Throwable -> L12
        r10.endTransaction();
        if (this.f11963n == false) goto L18;
        j1.s.a(r8.f8452b, r8.f8453c, r8.f8455e);
        return;
    L18:
        return;
    L12:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }
}
