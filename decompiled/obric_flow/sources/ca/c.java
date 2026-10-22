package ca;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.client.Request;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f1151h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1154c;
    public final HashSet d;
    public final HashSet e;
    public final HashSet f;
    public final HashSet g;

    public c(int r5) {
        this.f1154c = false;
        this.d = new HashSet();
        this.e = new HashSet();
        this.f = new HashSet();
        this.g = new HashSet();
        this.f1152a = r5;
        this.f1153b = r5;
    }

    public static void e(JSONArray r5, HashSet r10) {
        if (r5 == null) goto L12;
        if (r10 == null) goto L19;
        int r11 = 0;
    L14:
        if (r11 >= r5.length()) goto L21;
        String r12 = r5.getString(r11);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r12) == true) goto L11;
        r10.add(r12);     // Catch: JSONException -> L13
    L11:
        r11 = r11 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public abstract boolean a(Request r5, LinkedHashMap r10);

    public final boolean b(Request r10) {
        HashSet r5 = this.d;
        if (r5 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (r11 == true) goto L18;
        Iterator r12 = r5.iterator();
    L14:
        if (r12.hasNext() == false) goto L64;
        if (com.bytedance.frameworks.baselib.network.http.util.c.b(r10.getHost(), (String) r12.next()) == false) goto L14;
    L64:
        Logger.d("c", "Domain not match: " + r10.getHost());
        return false;
    L18:
        if (this.f1154c == true) goto L20;
    L22:
        String r13 = r10.getPath();
        if (TextUtils.isEmpty(r13) == false) goto L26;
        kotlin.collections.a.n("Path is empty: ", r13, "c");
        return false;
    L26:
        int r14 = r13.length();
        if (r14 <= 1) goto L31;
        int r15 = r14 - 1;
        if (r13.substring(r15).equals("/") == false) goto L31;
        r13 = r13.substring(0, r15);
    L31:
        HashSet r16 = this.e;
        if (r16 != null) goto L34;
    L39:
        HashSet r17 = this.f;
        if (r17 != null) goto L42;
    L50:
        HashSet r18 = this.g;
        if (r18 != null) goto L53;
    L63:
        return false;
    L53:
        if (r18.isEmpty() == true) goto L63;
        Iterator r19 = r18.iterator();
    L57:
        if (r19.hasNext() == false) goto L63;
        Pattern r20 = (Pattern) r19.next();
        if (r20 == null) goto L57;
        if (r20.matcher(r13).matches() == false) goto L57;
        return true;
    L42:
        if (r17.isEmpty() == true) goto L50;
        Iterator r21 = r17.iterator();
    L46:
        if (r21.hasNext() == false) goto L50;
        if (r13.startsWith((String) r21.next()) == false) goto L46;
        return true;
    L34:
        if (r16.isEmpty() == true) goto L39;
        if (r16.contains(r13) == false) goto L39;
        return true;
    L20:
        if (f.a().f1161c.get() == true) goto L22;
        return false;
    L5:
        if (r5.isEmpty() == true) goto L8;
        r11 = false;
        goto L10
    }

    public abstract void c(JSONObject r5);

    public final void d(JSONObject r5) {
        e(r5.optJSONArray("host_group"), this.d);
        e(r5.optJSONArray("equal_group"), this.e);
        e(r5.optJSONArray("prefix_group"), this.f);
        JSONArray r10 = r5.optJSONArray("pattern_group");
        HashSet r11 = this.g;
        if (r10 == null) goto L14;
        if (r11 == null) goto L24;
        int r12 = 0;
    L19:
        if (r12 >= r10.length()) goto L26;
        String r13 = r10.getString(r12);     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(r13) == true) goto L13;
        r11.add(Pattern.compile(r13, 2));     // Catch: Throwable -> L15
    L13:
        r12 = r12 + 1;
        goto L19
    L26:
        return;
    L25:
        return;
    L24:
        return;
    }
}
