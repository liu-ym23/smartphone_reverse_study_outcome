package lu8;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static boolean a(File r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.exists() == true) goto L10;
        return true;
    L10:
        if (r4.isDirectory() == true) goto L12;
        return false;
    L12:
        File[] r1 = r4.listFiles();
        if (r1 == null) goto L30;
        if (r1.length == 0) goto L30;
        Iterator r2 = ArrayIteratorKt.iterator(r1);
    L18:
        if (r2.hasNext() == false) goto L30;
        File r3 = (File) r2.next();
        if (r3.isFile() == true) goto L22;
        if (r3.isDirectory() == false) goto L18;
        if (a(r3) == true) goto L18;
        return false;
    L22:
        if (r3.delete() == true) goto L18;
        return false;
    L30:
        return r4.delete();
    }

    public final boolean delete(File r3) {
        boolean r0 = false;
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isDirectory() == false) goto L9;
        return a(r3);
    L9:
        if (r3.exists() == true) goto L11;
    L14:
        r0 = true;
    L16:
        return r0;
    L11:
        if (r3.isFile() == false) goto L16;
        if (r3.delete() == false) goto L16;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [lu8.a] */
    @JvmStatic
    public static final List<File> b(String r4, boolean r5) {
        if (r4 == null) goto L10;
        int r0 = r4.length();
        boolean r1 = false;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L10;
        if (Character.isWhitespace(r4.charAt(r2)) == false) goto L11;
        r2 = r2 + 1;
    L11:
        if (r1 == false) goto L13;
        File r6 = null;
    L15:
        return c(r6, new a(), r5);
    L13:
        r6 = new PolarisFileWrapper(r4);
    L10:
        r1 = true;
        goto L11
    }

    public static List c(File r4, a r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "filter");
        if (r4 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L13;
        return null;
    L13:
        ArrayList r2 = new ArrayList();
        Intrinsics.checkNotNull(r4);
        File[] r7 = r4.listFiles();
        if (r7 != null) goto L16;
    L25:
        return r2;
    L16:
        if (r7.length == 0) goto L25;
        Iterator r8 = ArrayIteratorKt.iterator(r7);
    L19:
        if (r8.hasNext() == false) goto L25;
        File r3 = (File) r8.next();
        Intrinsics.checkNotNull(r3);
        r2.add(r3);
        if (r6 == false) goto L19;
        if (r3.isDirectory() == false) goto L19;
        List r9 = c(r3, r5, true);
        Intrinsics.checkNotNull(r9);
        r2.addAll(r9);
        goto L19
    L5:
        if (r4.exists() == false) goto L9;
        if (r4.isDirectory() == false) goto L9;
        r1 = true;
        goto L10
    }
}
