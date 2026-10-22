package v0b;

import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(VFSPath r5) {
        if (r5.toFile().exists() == true) goto L6;
        return;
    L6:
        if (r5.toFile().exists() == false) goto L26;
        if (r5.toFile().isDirectory() == false) goto L24;
        VFSFile[] r0 = r5.toFile().listFiles();
        int r1 = r0.length;
        IOException e = null;
        int r3 = 0;
    L10:
        if (r3 >= r1) goto L16;
        c(r0[r3].getVfsPath());     // Catch: IOException -> L14
    L15:
        r3 = r3 + 1;
    L14:
        e = e;
        goto L15
    L16:
        if (e == null) goto L18;
        throw e;
    L18:
        if (r5.toFile().delete() == false) goto L21;
        return;
    L21:
        throw new IOException("Unable to delete directory " + r5.getRealPath() + '.');
    L24:
        throw new IllegalArgumentException(r5.getRealPath() + " is not a directory");
    L26:
        throw new IllegalArgumentException(r5.getRealPath() + " does not exist");
    }

    public static void b(VFSPath r1) {
        Intrinsics.checkNotNullParameter(r1, "path");
        if (r1.toFile().exists() == true) goto L6;
        return;
    L6:
        if (r1.toFile().isDirectory() == false) goto L9;
        a(r1);
        return;
    L9:
        if (r1.toFile().isFile() == false) goto L13;
        c(r1);
        return;
    }

    public static void c(VFSPath r3) {
        if (r3.toFile().exists() == true) goto L6;
        return;
    L6:
        if (r3.toFile().isDirectory() == false) goto L8;
        a(r3);
        return;
    L8:
        boolean r0 = r3.toFile().exists();
        if (r3.toFile().delete() == true) goto L16;
        if (r0 == true) goto L14;
        throw new FileNotFoundException("File does not exist: " + r3.getRealPath());
    L14:
        throw new IOException("Unable to delete file: " + r3.getRealPath());
    }

    public static String d(ChameleonConfig r5) {
        if (r5 == null) goto L7;
        String r6 = r5.getBizName();
        if (r6 == null) goto L7;
        com.ss.android.lark.storage.d r2 = new com.ss.android.lark.storage.d(new String[]{"chameleon", r6, "download"});
    L8:
        String r7 = LarkFileStorage.b().b(com.ss.android.lark.storage.f.d, r2).getRealPath();
        j.e("CML_TAG_D_ChameleonFileUtils", "path:" + r7);
        return r7;
    L7:
        r2 = new com.ss.android.lark.storage.d(new String[]{"chameleon", "download"});
        goto L8
    }

    public static VFSFile e(ChameleonConfig r2) {
        VFSFiles.b.getClass();
        boolean r0 = true;
        VFSFile r3 = VFSFiles.b(true).i(d(r2));
        if (r3 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == true) goto L11;
        if (r3 == null) goto L11;
        r3.mkdirs();
    L11:
        return r3;
    L5:
        if (r3.exists() != true) goto L7;
        goto L7
    }

    public static String f(ChameleonConfig r5) {
        if (r5 == null) goto L7;
        String r6 = r5.getBizName();
        if (r6 == null) goto L7;
        com.ss.android.lark.storage.d r2 = new com.ss.android.lark.storage.d(new String[]{"chameleon", r6, "specific"});
    L8:
        String r7 = LarkFileStorage.b().b(com.ss.android.lark.storage.f.d, r2).getRealPath();
        j.e("CML_TAG_D_ChameleonFileUtils", "path:" + r7);
        return r7;
    L7:
        r2 = new com.ss.android.lark.storage.d(new String[]{"chameleon", "specific"});
        goto L8
    }
}
