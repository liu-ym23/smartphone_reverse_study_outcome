package c1;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HashSet<String> f608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final HashMap<String, HashSet<String>> f609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.bytedance.applog.c f610c;

    protected a(com.bytedance.applog.c r10, HashSet<String> r11, HashMap<String, HashSet<String>> r12) {
        this.f610c = r10;
        this.f608a = r11;
        this.f609b = r12;
    }

    public static a e(com.bytedance.applog.c r11, String r12) {
        SharedPreferences r13 = r11.w().getSharedPreferences(r12, 0);     // Catch: Throwable -> L47
        HashSet r10 = new HashSet();     // Catch: Throwable -> L47
        HashMap r14 = new HashMap();     // Catch: Throwable -> L47
        Map<String, ?> r15 = r13.getAll();     // Catch: Throwable -> L6
    L7:
        if (r15 != null) goto L9;
        return null;
    L9:
        if (r15.size() <= 0) goto L75;
        Iterator<Map.Entry<String, ?>> r16 = r15.entrySet().iterator();     // Catch: Throwable -> L47
        int r17 = 0;
    L13:
        if (r16.hasNext() == false) goto L42;
        Map.Entry<String, ?> r18 = r16.next();     // Catch: Throwable -> L47
        if (r18 == null) goto L13;
        String r19 = r18.getKey();     // Catch: Throwable -> L47
        if ("is_block".equals(r19) == true) goto L19;
        if ("events".equals(r19) == false) goto L30;
        Set r20 = (Set) r18.getValue();     // Catch: Throwable -> L24
    L25:
        if (r20 == null) goto L13;
        if (r20.size() <= 0) goto L13;
        r10.addAll(r20);     // Catch: Throwable -> L47
    L24:
        r20 = null;
        goto L25
    L30:
        if (TextUtils.isEmpty(r19) == true) goto L13;
        HashSet r21 = new HashSet();     // Catch: Throwable -> L47
        Set r22 = (Set) r18.getValue();     // Catch: Throwable -> L34
    L35:
        if (r22 == null) goto L40;
        if (r22.size() <= 0) goto L40;
        r21.addAll(r22);     // Catch: Throwable -> L47
    L40:
        if (r21.size() <= 0) goto L13;
        r14.put(r19, r21);     // Catch: Throwable -> L47
    L34:
        r22 = null;
        goto L35
    L19:
        r17 = r13.getInt("is_block", 0);     // Catch: Throwable -> L47
        goto L13
    L42:
        if (r17 <= 0) goto L44;
        a r110 = new c(r11, r10, r14);     // Catch: Throwable -> L47
    L46:
        return r110;
    L44:
        r110 = new b(r11, r10, r14);     // Catch: Throwable -> L47
        goto L46
    L75:
        return null;
    L6:
        r15 = null;
        goto L7
    L76:
        return null;
    }

    public static a f(com.bytedance.applog.c r12, String r13, JSONObject r14) {
        SharedPreferences.Editor r15 = r12.w().getSharedPreferences(r13, 0).edit();     // Catch: Throwable -> L59
        r15.clear().commit();     // Catch: Throwable -> L59
        if (r14 != null) goto L6;
        return null;
    L6:
        if (r14.has("event_list") == false) goto L77;
        JSONObject r16 = r14.optJSONObject("event_list");     // Catch: Throwable -> L59
        if (r16 != null) goto L11;
        return null;
    L11:
        int r10 = r16.optInt("is_block", 0);     // Catch: Throwable -> L59
        r15.putInt("is_block", r10);     // Catch: Throwable -> L59
        HashSet r11 = new HashSet();     // Catch: Throwable -> L59
        JSONArray r17 = r16.optJSONArray("events");     // Catch: Throwable -> L59
        if (r17 == null) goto L23;
        if (r17.length() <= 0) goto L23;
        int r18 = 0;
    L17:
        if (r18 >= r17.length()) goto L23;
        String r19 = r17.optString(r18);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r19) == true) goto L21;
        r11.add(r19);     // Catch: Throwable -> L59
    L21:
        r18 = r18 + 1;     // Catch: Throwable -> L59
    L23:
        if (r11.size() <= 0) goto L25;
        r15.putStringSet("events", r11);     // Catch: Throwable -> L59
    L25:
        HashMap r20 = new HashMap();     // Catch: Throwable -> L59
        JSONObject r110 = r16.optJSONObject("params");     // Catch: Throwable -> L59
        if (r110 == null) goto L48;
        Iterator<String> r21 = r110.keys();     // Catch: Throwable -> L59
    L29:
        if (r21.hasNext() == false) goto L48;
        String r22 = r21.next();     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r22) == true) goto L29;
        HashSet r23 = new HashSet();     // Catch: Throwable -> L59
        JSONArray r24 = r110.optJSONArray(r22);     // Catch: Throwable -> L59
        if (r24 == null) goto L45;
        if (r24.length() <= 0) goto L45;
        int r25 = 0;
    L39:
        if (r25 >= r24.length()) goto L45;
        String r111 = r24.optString(r25);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r111) == true) goto L43;
        r23.add(r111);     // Catch: Throwable -> L59
    L43:
        r25 = r25 + 1;     // Catch: Throwable -> L59
    L45:
        if (r23.size() <= 0) goto L29;
        r20.put(r22, r23);     // Catch: Throwable -> L59
    L48:
        if (r20.size() <= 0) goto L53;
        Iterator r112 = r20.entrySet().iterator();     // Catch: Throwable -> L59
    L51:
        if (r112.hasNext() == false) goto L53;
        Map.Entry r26 = (Map.Entry) r112.next();     // Catch: Throwable -> L59
        r15.putStringSet((String) r26.getKey(), (Set) r26.getValue());     // Catch: Throwable -> L59
    L53:
        r15.commit();     // Catch: Throwable -> L59
        if (r10 <= 0) goto L56;
        a r113 = new c(r12, r11, r20);     // Catch: Throwable -> L59
    L58:
        return r113;
    L56:
        r113 = new b(r12, r11, r20);     // Catch: Throwable -> L59
        goto L58
    L77:
        return null;
    L78:
        return null;
    }

    @Override // c1.d
    public boolean a(MonitorKey r10, String r11, String r12) {
        if (MonitorKey.event_v3.equals(r10) == true) goto L6;
        return false;
    L6:
        boolean r13 = !b(r11, r12);
        if (r13 == false) goto L9;
        this.f610c.R().h(r10, MonitorState.f_filter);
        this.f610c.R().m(MonitorKey.filtered_event, r11);
    L9:
        return r13;
    }

    boolean b(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        HashSet<String> r12 = this.f608a;
        if (r12 != null) goto L8;
    L39:
        return true;
    L8:
        if (r12.size() <= 0) goto L39;
        if (c(r10) == false) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty(r11) == false) goto L16;
        return true;
    L16:
        JSONObject r13 = null;
        r13 = new JSONObject(r11);     // Catch: JSONException -> L40
    L19:
        if (r13 == null) goto L39;
        HashMap<String, HashSet<String>> r14 = this.f609b;
        if (r14 == null) goto L39;
        if (r14.size() <= 0) goto L39;
        if (this.f609b.containsKey(r10) == false) goto L39;
        HashSet<String> r15 = this.f609b.get(r10);
        if (r15 == null) goto L39;
        if (r15.size() <= 0) goto L39;
        Iterator<String> r16 = r13.keys();
    L34:
        if (r16.hasNext() == false) goto L39;
        if (d(r15, r16.next()) == false) goto L34;
        r16.remove();     // Catch: Throwable -> L41
        goto L34
    }

    protected abstract boolean c(String r10);

    protected abstract boolean d(HashSet<String> r10, String r11);
}
