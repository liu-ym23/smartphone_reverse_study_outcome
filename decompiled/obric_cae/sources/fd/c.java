package fd;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File r8, String r10) {
        if (r10.endsWith(".hoting") == false) goto L6;
        return true;
    L6:
        if (r10.endsWith(".hot") == true) goto L8;
        return false;
    L8:
        if (r10.endsWith(".alog.hot") == true) goto L12;
        return true;
    L12:
        return false;
    }
}
