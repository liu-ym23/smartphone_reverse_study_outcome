package t6;

import com.bytedance.apm.d;
import e0.e;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(String r10, String r11, int r12, Map<String, String> r13) {
        if (d.D() == false) goto L5;
        e.b("cloudmessage", new String[]{"report: commandId=" + r10, ", message=" + r11, ", code=" + r12, ", specificParams=" + r13});
    L5:
        HashMap r14 = null;
        if (r13 == null) goto L8;
        r14 = new HashMap(r13);
    L8:
        w6.b r15 = new w6.b(0, false, r10, r14);
        r15.h(r12);
        r15.i(r11);
        u6.a.d(r15);
    }

    public static boolean b(String r10, File r11, String r12, String r13) {
        if (d.D() == false) goto L6;
        e.b("cloudmessage", new String[]{"postFile: commandId=" + r10, "postFile=" + r11.getAbsolutePath(), ", uploadMessage=" + r13, ", fileType=" + r12});
    L6:
        return x6.a.d(r11, 1, r12, r10, r13, System.currentTimeMillis(), null);
    }

    public static void c(String r10, n6.a r11) {
        a(r11.b(), r10, 0, null);
    }

    public static void d(String r10, n6.a r11, Map<String, String> r12) {
        a(r11.b(), r10, 0, r12);
    }

    public static void e(String r10) {
        a(r10, "上传成功", 2, null);
    }
}
