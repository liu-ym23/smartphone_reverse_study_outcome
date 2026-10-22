package w12;

import com.bytedance.android.livesdk.gift.model.f2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final ArrayList<String> a = null;
    public static f2 b;
    public static boolean c;
    public static boolean d;
    public static String e;
    public static String f;

    static {
        new ArrayList();
        a = new ArrayList();
        d = true;
        e = "webp";
        f = "tplv-obj";
    }

    public static boolean a() {
        f2 r0 = b;
        if (r0 == null) goto L9;
        List<String> r1 = r0.getDomainList();
        if (r1 == null) goto L9;
        if (r1.isEmpty() == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static String b() {
        String r0 = e;
        if (r0 == null) goto L9;
        if (r0.length() <= 1) goto L9;
        return e;
    L9:
        if (c == false) goto L12;
        return "webp";
    L12:
        f2 r1 = b;
        if (r1 == null) goto L19;
        Map<String, String> r2 = r1.getDefaultParams();
        if (r2 == null) goto L21;
        String r3 = r2.get("format");
        if (r3 == null) goto L22;
        return r3;
    L22:
        return "png";
    L21:
        return "png";
    L19:
        return "png";
    }

    public static String c() {
        String r0 = f;
        if (r0 != null) goto L5;
    L8:
        f2 r1 = b;
        if (r1 == null) goto L15;
        Map<String, String> r2 = r1.getDefaultParams();
        if (r2 == null) goto L17;
        String r3 = r2.get("tpl");
        if (r3 == null) goto L18;
        return r3;
    L18:
        return "tplv-obj";
    L17:
        return "tplv-obj";
    L15:
        return "tplv-obj";
    L5:
        if (r0.length() <= 1) goto L8;
        return f;
    }
}
