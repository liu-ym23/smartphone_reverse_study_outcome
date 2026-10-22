package com.bytedance.applog.priority;

import android.text.TextUtils;
import com.bytedance.applog.log.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    int f1779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1780b;
    int c;
    Map<String, Integer> d;
    boolean e;
    private Map<Integer, b> f;
    private final Set<String> g;
    private JSONArray h;

    a() {
        this.f1779a = 0;
        this.f1780b = 5;
        this.c = -1;
        this.g = new HashSet();
        this.e = false;
    }

    private boolean a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        Map<String, Integer> r0 = this.d;
        if (r0 == null) goto L13;
        if (r0.containsKey(r2) == false) goto L13;
        return true;
    L13:
        return this.g.contains(r2);
    }

    public int a(String r11, String r12) {
        if (a(r11) == true) goto L5;
        return -1;
    L5:
        Map<String, Integer> r0 = this.d;
        if (r0 == null) goto L14;
        if (r0.containsKey(r11) == false) goto L14;
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(this.d.get(r11), Integer.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L12;
        return -1;
    L12:
        return r10.intValue();
    L14:
        if (TextUtils.isEmpty(r12) == true) goto L84;
        Map<Integer, b> r1 = this.f;
        if (r1 == null) goto L84;
        if (r1.isEmpty() == true) goto L84;
        JSONObject r3 = new JSONObject(r12);     // Catch: JSONException -> L82
        Iterator<Map.Entry<Integer, b>> r13 = this.f.entrySet().iterator();
    L24:
        if (r13.hasNext() == false) goto L81;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(r14.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if ((-1) == r4) goto L24;
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14.getValue(), b.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L24;
        if (r15.f == null) goto L52;
        if (r15.f.isEmpty() == true) goto L52;
        if (r15.f.containsKey(r11) == false) goto L52;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r15.f.get(r11), List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L52;
        if (r5.isEmpty() == true) goto L52;
        Iterator r6 = r5.iterator();
    L43:
        if (r6.hasNext() == false) goto L52;
        Set r7 = (Set) ZeusTransformUtils.preCheckCast(r6.next(), Set.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L43;
        if (r7.isEmpty() == true) goto L43;
        if (com.bytedance.applog.util.i.a(r3, r7) == false) goto L43;
        return r4;
    L52:
        if (r15.g == null) goto L24;
        if (r15.g.isEmpty() == true) goto L24;
        if (r15.g.containsKey(r11) == false) goto L24;
        List r16 = (List) ZeusTransformUtils.preCheckCast(r15.g.get(r11), List.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L24;
        if (r16.isEmpty() == true) goto L24;
        Iterator r17 = r16.iterator();
    L63:
        if (r17.hasNext() == false) goto L24;
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(r17.next(), Map.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L63;
        if (r8.isEmpty() == true) goto L63;
        if (com.bytedance.applog.util.i.a(r3, r8.keySet()) == false) goto L63;
        boolean r9 = true;
        Iterator r18 = r8.entrySet().iterator();
    L72:
        if (r18.hasNext() == false) goto L79;
        Map.Entry r19 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.getKey(), String.class, "com.obric.memorydata.plugin");
        Object r21 = r19.getValue();
        if (TextUtils.isEmpty(r20) == true) goto L78;
        if (r21 == null) goto L78;
        if (r21.equals(r3.opt(r20)) == true) goto L72;
    L78:
        r9 = false;
    L79:
        if (r9 == false) goto L63;
        return r4;
    L81:
        return -1;
    L82:
        e = move-exception;
        q.a().a("Cannot parse event params", e, new Object[0]);
    L84:
        return -1;
    }

    public b a(int r2) {
        Map<Integer, b> r1 = this.f;
        if (r1 != null) goto L5;
        return null;
    L5:
        return (b) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r2)), b.class, "com.obric.memorydata.plugin");
    }

    public JSONArray a() {
        return this.h;
    }

    public void a(Map<Integer, b> r5) {
        this.f = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.g.clear();
        Map<Integer, b> r6 = this.f;
        if (r6 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, b>> r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L24;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if ((-1) == ((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue()) goto L7;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.getValue(), b.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        if (r1.f == null) goto L20;
        if (r1.f.isEmpty() == true) goto L20;
        this.g.addAll(r1.f.keySet());
    L20:
        if (r1.g == null) goto L7;
        if (r1.g.isEmpty() == true) goto L7;
        this.g.addAll(r1.g.keySet());
        goto L7
    }

    public void a(JSONArray r1) {
        this.h = r1;
    }

    public boolean a(a r6) {
        if (r6 != null) goto L6;
        return true;
    L6:
        if (r6.f1780b == this.f1780b) goto L8;
        return true;
    L8:
        Map<Integer, b> r5 = e();
        Map<Integer, b> r7 = r6.e();
        if (r5 == null) goto L33;
        if (r7 == null) goto L33;
        if (r5.size() == r7.size()) goto L15;
        return true;
    L15:
        Iterator<Map.Entry<Integer, b>> r8 = r5.entrySet().iterator();
    L17:
        if (r8.hasNext() == false) goto L31;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.getKey(), Integer.class, "com.obric.memorydata.plugin");
        b r3 = (b) ZeusTransformUtils.preCheckCast(r1.getValue(), b.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L30;
        if (r3 == null) goto L30;
        if (r7.containsKey(r2) == false) goto L24;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r7.get(r2), b.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L27;
        if (r3.c() == r4.c()) goto L17;
    L27:
        return true;
    L24:
        return true;
    L30:
        return true;
    L31:
        return false;
    L33:
        return true;
    }

    public int b() {
        return this.f1779a;
    }

    public int c() {
        return this.f1780b;
    }

    public boolean d() {
        if (this.f1779a >= 0) goto L5;
        return false;
    L5:
        if (this.f1780b <= 0) goto L25;
        Map<Integer, b> r3 = this.f;
        if (r3 != null) goto L10;
        return false;
    L10:
        if (r3.isEmpty() == false) goto L13;
        return false;
    L13:
        if (r3.containsKey(-1) == true) goto L15;
        return false;
    L15:
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3.get(-1), b.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L18;
        return false;
    L18:
        if (r4.d <= 0) goto L24;
        return true;
    L24:
        return false;
    L25:
        return false;
    }

    public Map<Integer, b> e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }
}
