package zg4;

import android.os.FileObserver;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class b$d extends FileObserver {
    public final File a;
    public final /* synthetic */ b b;

    public b$d(b r2, File r3) {
        this.b = r2;
        super(r3.getAbsolutePath(), 264);
        this.a = r3;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int r1, String r2) {
        if ((r1 & 8) == 0) goto L6;
        this.b.i();
        return;
    }
}
