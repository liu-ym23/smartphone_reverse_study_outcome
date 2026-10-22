package wkb;

import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.dirs.h;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final VFSPath a() {
        int r0 = h.c;
        h r1 = h.a.a(LarkContext.getApplication());
        VFSFiles.b.getClass();
        r1.c(VFSFiles.b(true));
        return r1.b(new a());
    }
}
