package fd;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File r8, String r10) {
        return r10.startsWith(".logCache_");
    }
}
