package swb;

import com.ss.android.lark.vfs.VFSFile;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements Comparator<VFSFile> {
    public f() {
    }

    @Override // java.util.Comparator
    public final int compare(VFSFile r1, VFSFile r2) {
        return g.b(r2.getName(), r1.getName());
    }
}
