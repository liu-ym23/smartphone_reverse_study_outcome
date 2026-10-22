package k2;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import okhttp3.r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f10032a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArraySet<String> f10033b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CopyOnWriteArraySet<String> f10034c = null;

    static {
        f10033b = new CopyOnWriteArraySet();
        f10034c = new CopyOnWriteArraySet();
    }

    public static Set<String> a(List<String> r10) {
        CopyOnWriteArraySet<String> r11 = f10033b;
        if (r11.isEmpty() == true) goto L31;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.isEmpty() == true) goto L34;
        HashSet r12 = new HashSet();
        Iterator<String> r13 = r11.iterator();
    L10:
        if (r13.hasNext() == false) goto L20;
        String r14 = r13.next();
        Iterator<String> r15 = r10.iterator();
    L13:
        if (r15.hasNext() == false) goto L10;
        String r16 = r15.next();
        if (r16 == null) goto L13;
        if (r16.contains(r14 + "=") == false) goto L13;
        r12.add(r14);
        goto L13
    L20:
        if (r12.size() > 0) goto L22;
        return null;
    L22:
        return r12;
    L34:
        return null;
    L31:
        return null;
    }

    public static Set<String> b(r r10) {
        CopyOnWriteArraySet<String> r11 = f10034c;
        if (r11.isEmpty() == true) goto L23;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.size() == 0) goto L26;
        HashSet r12 = new HashSet();
        Iterator<String> r13 = r11.iterator();
    L10:
        if (r13.hasNext() == false) goto L15;
        String r14 = r13.next();
        if (r10.b(r14) == null) goto L10;
        r12.add(r14);
        goto L10
    L15:
        if (r12.size() > 0) goto L17;
        return null;
    L17:
        return r12;
    L26:
        return null;
    L23:
        return null;
    }

    public static boolean c() {
        return f10032a;
    }

    public static void d(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        f();
        JSONObject r11 = r10.optJSONObject("insecure_request_control");
        if (r11 != null) goto L7;
        return;
    L7:
        boolean r12 = false;
        if (r11.optInt("disable_share_insecure_cookie", 0) <= 0) goto L10;
        r12 = true;
    L10:
        f10032a = r12;
        e(r11.optJSONArray("secret_cookie_list"), f10033b);
        e(r11.optJSONArray("secret_header_list"), f10034c);
    }

    private static void e(JSONArray r10, CopyOnWriteArraySet<String> r11) {
        if (r10 == null) goto L12;
        if (r11 == null) goto L19;
        int r12 = 0;
    L14:
        if (r12 >= r10.length()) goto L21;
        String r13 = r10.getString(r12);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r13) == true) goto L11;
        r11.add(r13);     // Catch: JSONException -> L13
    L11:
        r12 = r12 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private static void f() {
        f10032a = false;
        f10033b.clear();
        f10034c.clear();
    }
}
