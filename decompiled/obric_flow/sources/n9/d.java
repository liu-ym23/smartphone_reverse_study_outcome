package n9;

import android.text.TextUtils;
import java.util.Iterator;
import l9.e;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JSONObject f20218a = null;

    static {
        f20218a = new JSONObject();
    }

    public static boolean a(JSONArray r10, e r11) {
        if (mh.e.m(r10) == false) goto L5;
        return false;
    L5:
        int r5 = 0;
    L7:
        if (r5 >= r10.length()) goto L31;
        JSONObject r12 = r10.optJSONObject(r5);
        if (r12 != null) goto L11;
        m.b r13 = com.bytedance.crash.c.f4025a;
        IllegalArgumentException r14 = new IllegalArgumentException("err config: " + r10);
        r13.getClass();
        m.b.h("NPTH_CATCH", r14);
    L30:
        r5 = r5 + 1;
        goto L7
    L11:
        Iterator<String> r15 = r12.keys();
        boolean r16 = false;
    L13:
        if (r15.hasNext() == false) goto L28;
        String r17 = r15.next();
        if (TextUtils.isEmpty(r17) == true) goto L13;
        if (r17.startsWith("header_") == false) goto L23;
        if (b(r12.optJSONObject(r17), r11.a(r17.substring(7))) == false) goto L26;
    L27:
        r16 = true;
    L26:
        r16 = false;
        goto L28
    L23:
        if (r17.startsWith("java_") == false) goto L27;
        if (b(r12.optJSONObject(r17), r11.b(r17.substring(5))) == true) goto L27;
    L28:
        if (r16 == false) goto L30;
        return true;
    L31:
        return false;
    }

    public static boolean b(JSONObject r5, Object r10) {
        JSONArray r11 = r5.optJSONArray("values");
        if (r11.length() != 0) goto L5;
        return false;
    L5:
        String r12 = r5.optString("op");
        String r13 = String.valueOf(r10);
        if (r12.equals("=") == false) goto L10;
        return r13.equals(String.valueOf(r11.opt(0)));
    L10:
        if (r12.equals("in") == false) goto L19;
        int r14 = 0;
    L13:
        if (r14 >= r11.length()) goto L19;
        if (String.valueOf(r11.opt(r14)).equals(r13) == true) goto L16;
        r14 = r14 + 1;
        goto L13
    L16:
        return true;
    L19:
        return false;
    }
}
