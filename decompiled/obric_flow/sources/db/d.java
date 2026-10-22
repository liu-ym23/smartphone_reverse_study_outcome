package db;

import com.bytedance.gkfs.storage.io.GkFSBlockBuffer;
import com.lynx.tasm.behavior.ui.utils.p;
import java.io.File;
import java.io.FileFilter;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f16632a = null;

    static {
        f16632a = new d();
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r5) {
        if (StringsKt.k(r5.getName(), "-rewriting") == false) goto L7;
        r5.delete();
        return false;
    L7:
        if (StringsKt.k(r5.getName(), "-backup") == false) goto L22;
        com.bytedance.gkfs.io.a r10 = GkFSBlockBuffer.f4940j;
        com.bytedance.gkfs.io.a r11 = p.e(r5);
        if (Intrinsics.areEqual(r11, com.bytedance.gkfs.io.a.f4852b) == false) goto L12;
        r5.delete();
        return false;
    L12:
        File r12 = p.r(r11);
        if (r12 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        if (r12.exists() == false) goto L19;
        r5.delete();
        return false;
    L19:
        r5.renameTo(new File(StringsKt.B(r5.getAbsolutePath(), "-backup")));
        return true;
    L22:
        return Intrinsics.areEqual(FilesKt.getExtension(r5), "gkfsb");
    }
}
