package n2;

import android.net.Uri;
import android.text.TextUtils;
import c2.k;
import com.bytedance.apm.core.ActivityLifeObserver;
import g3.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import m2.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b extends m2.a<o2.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f9428c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9429a = null;

        static {
            f9429a = new b();
        }
    }

    public b() {
    }

    @Override // m2.a, v8.a
    public final void a(JSONObject r10) {
        JSONObject r8 = null;
        if (r10 != null) goto L5;
    L8:
        JSONObject r11 = null;
    L9:
        if (r11 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty("network") == false) goto L13;
        JSONObject r12 = null;
    L14:
        if (r12 == null) goto L45;
        t2.b.N("api_block_list", r12);
        JSONArray r13 = r12.optJSONArray("api_block_list");     // Catch: Exception -> L51
        if (r13 == null) goto L26;
        if (r13.length() <= 0) goto L26;
        int r14 = r13.length();     // Catch: Exception -> L51
        ArrayList r15 = new ArrayList(r14);     // Catch: Exception -> L51
        int r16 = 0;
    L21:
        if (r16 >= r14) goto L26;
        String r17 = r13.getString(r16);     // Catch: Exception -> L51
        if (TextUtils.isEmpty(r17) == true) goto L25;
        r15.add(Pattern.compile(r17));     // Catch: Exception -> L51
    L25:
        r16 = r16 + 1;
    L26:
        t2.b.O("api_allow_list", r12);
        JSONObject r18 = r12.optJSONObject("api_allow_list");     // Catch: Exception -> L52
        if (r18 != null) goto L30;
    L33:
        boolean r19 = true;
    L34:
        if (r19 == true) goto L43;
        ArrayList r20 = new ArrayList();     // Catch: Exception -> L52
        Iterator<String> r21 = r18.keys();     // Catch: Exception -> L52
    L37:
        if (r21.hasNext() == false) goto L43;
        String r22 = r21.next();     // Catch: Exception -> L52
        if (r18.optInt(r22) != 1) goto L37;
        r20.add(Pattern.compile(r22));     // Catch: Exception -> L52
        goto L37
    L30:
        if (r18.length() == 0) goto L33;
        r19 = false;
    L43:
        r12.optInt("enable_api_all_upload", 0);
        r12.optBoolean("enable_trace_log", true);
        r12.optInt("enable_api_error_upload", 1);
        r12.optInt("enable_cancel_error_report");
        t2.b.O("request_allow_header", r12);
        t2.b.O("response_allow_header", r12);
        r12.optDouble("enable_base_api_all", 0.0d);
    L45:
        if (TextUtils.isEmpty("image") == true) goto L48;
        r8 = r11.optJSONObject("image");
    L48:
        if (r8 == null) goto L66;
        this.f9428c = t2.b.O("image_allow_list", r8);
        return;
    L66:
        return;
    L13:
        r12 = r11.optJSONObject("network");
        goto L14
    L5:
        if (TextUtils.isEmpty("network_image_modules") == true) goto L8;
        r11 = r10.optJSONObject("network_image_modules");
        goto L9
    }

    @Override // m2.a
    public final boolean c(c r8) {
        o2.a r10 = (o2.a) r8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(r10.f9620d) == true) goto L7;
        return true;
    }

    @Override // m2.a
    public final void e(c r8) {
        String r10 = ((o2.a) r8).f9620d;
        ArrayList r11 = this.f9428c;
        if (l6.a.d0(r11) == false) goto L5;
    L13:
        boolean r12 = false;
    L14:
        if (r12 == true) goto L18;
        boolean r13 = k.f3297a;
        int r14 = f.f7630a;
        throw null;     // Catch: Exception -> L19
    L28:
        return;
    L18:
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L13;
        String r15 = Uri.parse(r10).getHost();     // Catch: Throwable -> L20
        Iterator r16 = r11.iterator();     // Catch: Throwable -> L20
    L9:
        if (r16.hasNext() == false) goto L13;
        if (r15.equalsIgnoreCase((String) r16.next()) == false) goto L9;
        r12 = true;
        goto L14
    }

    @Override // m2.a
    public final void g(c r8) {
        o2.a r10 = (o2.a) r8;
        int r11 = 1;
        if (ActivityLifeObserver.getInstance() != null) goto L6;
        boolean r12 = true;
    L7:
        if (r12 == false) goto L10;
        r11 = 0;
    L10:
        JSONObject r13 = r10.f9624h;     // Catch: JSONException -> L17
        if (r13.isNull("front") == false) goto L13;
        r13.put("front", r11);     // Catch: JSONException -> L17
    L13:
        JSONObject r14 = r10.f9624h;     // Catch: JSONException -> L17
        if (r14.isNull("net_consume_type") == false) goto L20;
        r14.put("net_consume_type", "ttnet");     // Catch: JSONException -> L17
        return;
    L20:
        return;
    L6:
        r12 = !ActivityLifeObserver.getInstance().isForeground();     // Catch: JSONException -> L17
    }
}
