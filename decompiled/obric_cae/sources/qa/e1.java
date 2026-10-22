package qa;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class e1 extends i1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10368b;

    public e1(String r8, f1 r10) {
        super(r10);
        this.f10368b = r8;
    }

    @Override // qa.i1
    public final boolean c() {
        File r8 = new File(this.f10368b);     // Catch: Throwable -> L8
        if (r8.exists() == false) goto L10;
        int r10 = r8.list().length;     // Catch: Throwable -> L8
    L12:
        if (r10 >= 30) goto L14;
        return false;
    L14:
        return true;
    L10:
        r10 = 0;
    L8:
        th = move-exception;
        q.f("fus", "gfn", th);
        goto L10
    }
}
