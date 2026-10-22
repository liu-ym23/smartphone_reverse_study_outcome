package h1;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f9132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f9133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<Integer, b> f9134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f9135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Map<String, Integer> f9136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONArray f9137f;

    a() {
        this.f9132a = 0;
        this.f9133b = 5;
        this.f9135d = -1;
    }

    public b a(int r10) {
        Map<Integer, b> r11 = this.f9134c;
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.get(Integer.valueOf(r10));
    }

    public Map<Integer, b> b() {
        return this.f9134c;
    }

    public JSONArray c() {
        return this.f9137f;
    }

    public int d(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return -1;
    L5:
        Map<String, Integer> r12 = this.f9136e;
        if (r12 != null) goto L8;
    L11:
        JSONObject r13 = null;
        if (TextUtils.isEmpty(r11) == true) goto L16;
        r13 = new JSONObject(r11);     // Catch: JSONException -> L86
    L16:
        if (r13 == null) goto L85;
        Map<Integer, b> r14 = this.f9134c;
        if (r14 == null) goto L85;
        if (r14.isEmpty() == true) goto L85;
        HashSet r15 = new HashSet();
        Iterator<String> r16 = r13.keys();
    L24:
        if (r16.hasNext() == false) goto L26;
        r15.add(r16.next());
        goto L24
    L26:
        Iterator<Map.Entry<Integer, b>> r17 = this.f9134c.entrySet().iterator();
    L28:
        if (r17.hasNext() == false) goto L85;
        Map.Entry<Integer, b> r18 = r17.next();
        int r19 = r18.getKey().intValue();
        if ((-1) == r19) goto L28;
        b r20 = r18.getValue();
        if (r20 == null) goto L28;
        Map<String, List<Set<String>>> r21 = r20.f9143f;
        if (r21 != null) goto L38;
    L55:
        Map<String, List<Map<String, Object>>> r22 = r20.f9144g;
        if (r22 == null) goto L28;
        if (r22.isEmpty() == true) goto L28;
        if (r20.f9144g.containsKey(r10) == false) goto L28;
        List<Map<String, Object>> r23 = r20.f9144g.get(r10);
        if (r23 == null) goto L28;
        if (r23.isEmpty() == true) goto L28;
        Iterator<Map<String, Object>> r24 = r23.iterator();
    L67:
        if (r24.hasNext() == false) goto L28;
        Map<String, Object> r25 = r24.next();
        if (r25 == null) goto L67;
        if (r25.isEmpty() == true) goto L67;
        if (r15.containsAll(r25.keySet()) == false) goto L67;
        boolean r26 = true;
        Iterator<Map.Entry<String, Object>> r27 = r25.entrySet().iterator();
    L76:
        if (r27.hasNext() == false) goto L83;
        Map.Entry<String, Object> r28 = r27.next();
        String r29 = r28.getKey();
        Object r30 = r28.getValue();
        if (TextUtils.isEmpty(r29) == true) goto L82;
        if (r30 == null) goto L82;
        if (r30.equals(r13.opt(r29)) == true) goto L76;
    L82:
        r26 = false;
    L83:
        if (r26 == false) goto L67;
        return r19;
    L38:
        if (r21.isEmpty() == true) goto L55;
        if (r20.f9143f.containsKey(r10) == false) goto L55;
        List<Set<String>> r31 = r20.f9143f.get(r10);
        if (r31 == null) goto L55;
        if (r31.isEmpty() == true) goto L55;
        Iterator<Set<String>> r32 = r31.iterator();
    L47:
        if (r32.hasNext() == false) goto L55;
        Set<String> r33 = r32.next();
        if (r33 == null) goto L47;
        if (r33.isEmpty() == true) goto L47;
        if (r15.containsAll(r33) == false) goto L47;
        return r19;
    L85:
        return -1;
    L8:
        if (r12.containsKey(r10) == false) goto L11;
        return this.f9136e.get(r10).intValue();
    }

    public boolean e() {
        if (this.f9132a >= 0) goto L5;
    L22:
        return false;
    L5:
        if (this.f9133b <= 0) goto L22;
        Map<Integer, b> r10 = this.f9134c;
        if (r10 == null) goto L22;
        if (r10.isEmpty() == true) goto L22;
        if (r10.containsKey(-1) == true) goto L15;
        return false;
    L15:
        b r11 = r10.get(-1);
        if (r11 == null) goto L22;
        if (r11.f9141d <= 0) goto L22;
        return true;
    }

    public void f(JSONArray r10) {
        this.f9137f = r10;
    }
}
