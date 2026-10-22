package bb;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements FileFilter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f896b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f897c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f898a;

    static {
        f896b = new d(0);
        f897c = new d(1);
    }

    public /* synthetic */ d(int r5) {
        this.f898a = r5;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r5) {
        switch(this.f898a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return r5.isDirectory();
    L7:
        return r5.isDirectory();
    }
}
