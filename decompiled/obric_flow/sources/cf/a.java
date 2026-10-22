package cf;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1184a = null;

    static {
        f1184a = new a();
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r5) {
        return r5.isDirectory();
    }
}
