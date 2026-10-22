package ju8;

import android.content.Context;
import com.larus.bootprotector.BootProtectorLauncher;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import lu8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    private final void delete(List<String> r14) {
        boolean r0 = BootProtectorLauncher.b;
        Context r1 = BootProtectorLauncher.c;
        if (r1 == null) goto L46;
        File r2 = r1.getFilesDir();
        if (r2 == null) goto L71;
        String r3 = r2.getParent();
        if (r3 == null) goto L74;
        Context r4 = BootProtectorLauncher.c;
        if (r4 == null) goto L72;
        File r5 = r4.getExternalFilesDir(null);
        if (r5 == null) goto L73;
        String r6 = r5.getParent();
        if (r6 == null) goto L75;
        Iterator r7 = CollectionsKt.listOf(new String[]{r3, r6}).iterator();
    L18:
        if (r7.hasNext() == false) goto L76;
        String r8 = (String) r7.next();
        ArrayList r9 = new ArrayList();
        List<File> r10 = b.b(r8, true);
        if (r10 == null) goto L34;
        Iterator<T> r11 = r10.iterator();
    L23:
        if (r11.hasNext() == false) goto L34;
        File r12 = (File) r11.next();
        if (r12.exists() == false) goto L23;
        if (r12.isFile() == false) goto L23;
        String r13 = r12.getAbsolutePath().substring(StringsKt.indexOf$default(r12.getAbsolutePath(), r8, 0, false, 6, null) + r8.length(), r12.getAbsolutePath().length());
        Iterator<String> r15 = r14.iterator();
    L30:
        if (r15.hasNext() == false) goto L23;
        if (new Regex(r15.next()).matches(r13) == false) goto L30;
        nu8.a.a("ClearDataUtils", "matches files : " + r13);
        r9.add(r12.getAbsolutePath());
    L34:
        List<File> r16 = b.b(r8, true);
        if (r16 == null) goto L18;
        Iterator<T> r17 = r16.iterator();
    L38:
        if (r17.hasNext() == false) goto L18;
        File r18 = (File) r17.next();
        if (r18.exists() == false) goto L38;
        if (r18.isFile() == false) goto L38;
        if (r9.contains(r18.getAbsolutePath()) == true) goto L38;
        nu8.a.a("ClearDataUtils", "delete file : " + r18);
        b.a.delete(r18);
        goto L38
    L76:
        return;
    L75:
        return;
    L73:
        return;
    L72:
        return;
    L74:
        return;
    L71:
        return;
    }

    public final void a(List<String> r3) {
        nu8.a.e("ClearDataUtils", "clearAllExcludeWhiteList : " + r3);
        List<String> r0 = r3;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        List<String> r4 = au8.a.a;
        delete(au8.a.a);
        return;
    L11:
        delete(r3);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
