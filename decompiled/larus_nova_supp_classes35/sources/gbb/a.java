package gbb;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends d {
    @Override // gbb.d, gbb.g
    public /* bridge */ /* synthetic */ void delete() throws IOException {
        super.delete();
    }

    @Override // gbb.d, gbb.g
    public final synchronized File c(String r2) throws IOException {
        monitor-enter(this);
        File r3 = ((b) this.a).q(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public a(File r2, int r3, long r4) {
        int r0 = b.q;     // Catch: IOException -> L8
        if (r2.exists() == true) goto L6;
        r2.mkdirs();     // Catch: IOException -> L8
    L6:
        this.a = new b(r2, r3, r4);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
