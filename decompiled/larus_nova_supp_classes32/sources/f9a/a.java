package f9a;

import com.bytedance.apm.d;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static void a(String r3, String r4, int r5, Map<String, String> r6) {
        if (d.j() == false) goto L5;
        ps3.b.a(new String[]{"report: commandId=" + r3, ", message=" + r4, ", code=" + r5, ", specificParams=" + r6});
    L5:
        if (r6 == null) goto L7;
        HashMap r0 = new HashMap(r6);
    L8:
        i9a.b r7 = new i9a.b(r3, r0);
        r7.d = r5;
        r7.e = r4;
        g9a.a.c(r7);
        return;
    L7:
        r0 = null;
        goto L8
    }

    public static boolean b(String r12, File r13, String r14, String r15) {
        if (d.j() == false) goto L6;
        ps3.b.a(new String[]{"postFile: commandId=" + r12, "postFile=" + r13.getAbsolutePath(), ", uploadMessage=" + r15, ", fileType=" + r14});
    L6:
        return j9a.a.a(j9a.a.a, r13, 1, r14, r12, r15, System.currentTimeMillis(), null);
    }
}
