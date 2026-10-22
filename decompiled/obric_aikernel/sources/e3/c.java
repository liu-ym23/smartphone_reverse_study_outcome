package e3;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f8576a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static double f8577b = 1.0E-9d;

    static {
    }

    public static b a(JSONObject r23, int r24) {
        if (r23 != null) goto L5;
        return null;
    L5:
        JSONObject r10 = r23.optJSONObject("network_image_modules");
        if (r10 != null) goto L8;
        return null;
    L8:
        JSONObject r11 = r10.optJSONObject("network");
        if (r11 != null) goto L11;
    L40:
        return null;
    L11:
        if (r11.length() <= 0) goto L40;
        if (r24 > 0) goto L15;
        return null;
    L15:
        JSONObject r12 = r11.optJSONObject("api_allow_list");
        if (r12 != null) goto L18;
    L20:
        boolean r13 = true;
    L21:
        ArrayList r14 = new ArrayList();
        boolean r15 = c(r11, "api_allow_list_path_equal", r14) | false;
        ArrayList r16 = new ArrayList();
        boolean r17 = r15 | c(r11, "api_allow_list_path_prefix", r16);
        ArrayList r18 = new ArrayList();
        boolean r19 = r17 | c(r11, "api_allow_list_path_contain", r18);
        ArrayList r110 = new ArrayList();
        boolean r20 = r19 | c(r11, "api_allow_list_path_regexp", r110);
        ArrayList r111 = new ArrayList();
        boolean r21 = r20 | c(r11, "api_allow_list_host_pattern", r111);
        ArrayList r112 = new ArrayList();
        boolean r22 = r21 | c(r11, "api_allow_list_url_regexp", r112);
        if (r13 == true) goto L25;
        if (r22 == true) goto L25;
        return null;
    L25:
        ArrayList r25 = new ArrayList();
        b(r11, "api_block_list", r25);
        if (Math.abs(r11.optDouble("enable_base_api_all")) <= f8577b) goto L28;
        boolean r113 = true;
    L30:
        if (r11.optInt("enable_api_all_upload") != 1) goto L32;
        boolean r114 = true;
    L33:
        b r26 = new b(r24, new a(r113, r114, (String[]) r25.toArray(new String[0]), (String[]) r14.toArray(new String[0]), (String[]) r18.toArray(new String[0]), (String[]) r16.toArray(new String[0]), (String[]) r110.toArray(new String[0]), (String[]) r112.toArray(new String[0]), (String[]) r111.toArray(new String[0])));
        b r27 = f8576a;
        if (r27 != null) goto L36;
    L38:
        f8576a = r26;
        return r26;
    L36:
        if (r27.equals(r26) == false) goto L38;
        return null;
    L32:
        r114 = false;
        goto L33
    L28:
        r113 = false;
        goto L30
    L18:
        if (r12.length() <= 0) goto L20;
        r13 = false;
        goto L21
    }

    private static void b(JSONObject r10, String r11, List<String> r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == true) goto L21;
        if (r12 == null) goto L22;
        JSONArray r13 = r10.optJSONArray(r11);
        if (r13 != null) goto L10;
        return;
    L10:
        int r14 = 0;
    L12:
        if (r14 >= r13.length()) goto L23;
        String r15 = r13.optString(r14);
        if (TextUtils.isEmpty(r15) == true) goto L16;
        r12.add(r15);
    L16:
        r14 = r14 + 1;
        goto L12
    L23:
        return;
    L22:
        return;
    }

    private static boolean c(JSONObject r10, String r11, List<String> r12) {
        if (r10 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L19;
        if (r12 == null) goto L19;
        JSONObject r13 = r10.optJSONObject(r11);
        if (r13 != null) goto L11;
        return false;
    L11:
        Iterator<String> r14 = r13.keys();
    L13:
        if (r14.hasNext() == false) goto L18;
        String r15 = r14.next();
        if (TextUtils.isEmpty(r15) == true) goto L13;
        r12.add(r15);
        goto L13
    L18:
        return !r12.isEmpty();
    }
}
