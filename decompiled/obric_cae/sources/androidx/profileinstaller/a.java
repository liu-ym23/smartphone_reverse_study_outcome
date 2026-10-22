package androidx.profileinstaller;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static boolean a(File r8) {
        if (r8.isDirectory() == false) goto L16;
        File[] r10 = r8.listFiles();
        if (r10 != null) goto L7;
        return false;
    L7:
        int r11 = r10.length;
        int r12 = 0;
        boolean r13 = true;
    L8:
        if (r12 >= r11) goto L15;
        if (a(r10[r12]) == false) goto L13;
        if (r13 == false) goto L13;
        r13 = true;
    L14:
        r12 = r12 + 1;
    L13:
        r13 = false;
        goto L14
    L15:
        return r13;
    L16:
        r8.delete();
        return true;
    }
}
