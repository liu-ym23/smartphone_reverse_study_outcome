package j1;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8446a = null;

    static {
        f8446a = new a();
    }

    public final File a(Context r8) {
        he.i.f(r8, "context");
        File r10 = r8.getNoBackupFilesDir();
        he.i.e(r10, "context.noBackupFilesDir");
        return r10;
    }
}
