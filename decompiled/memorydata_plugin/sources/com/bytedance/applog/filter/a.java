package com.bytedance.applog.filter;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.keva.Keva;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements e {
    private static com.bytedance.applog.log.b<Keva> d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HashSet<String> f1590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final HashMap<String, HashSet<String>> f1591b;
    protected final com.bytedance.applog.b c;

    static {
        d = new AnonymousClass1();
    }

    public a(com.bytedance.applog.b r1, HashSet<String> r2, HashMap<String, HashSet<String>> r3) {
        this.c = r1;
        this.f1590a = r2;
        this.f1591b = r3;
    }

    public static a a(com.bytedance.applog.b r13, String r14) {
        boolean r3 = r13.bb();     // Catch: Throwable -> L57
        if (r3 == true) goto L7;
        SharedPreferences r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r14, 0);     // Catch: Throwable -> L57
    L8:
        HashSet r5 = new HashSet();     // Catch: Throwable -> L57
        HashMap r6 = new HashMap();     // Catch: Throwable -> L57
        if (r3 == false) goto L11;
        Map<String, ?> r7 = new HashMap();     // Catch: Throwable -> L13
        ((Keva) ZeusTransformUtils.preCheckCast(d.c(new Object[0]), Keva.class, "com.obric.memorydata.plugin")).buildNewMap(r7);     // Catch: Throwable -> L13
    L65:
    L15:
        if (r7 != null) goto L17;
    L56:
        return null;
    L17:
        if (r7.size() <= 0) goto L56;
        Iterator<Map.Entry<String, ?>> r8 = r7.entrySet().iterator();     // Catch: Throwable -> L57
        int r9 = 0;
    L21:
        if (r8.hasNext() == false) goto L52;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        if (r10 == null) goto L21;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        if ("is_block".equals(r11) == true) goto L27;
        if ("events".equals(r11) == false) goto L40;
        Set r12 = (Set) ZeusTransformUtils.preCheckCast(r10.getValue(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
    L35:
        if (r12 == null) goto L21;
        if (r12.size() <= 0) goto L21;
        r5.addAll(r12);     // Catch: Throwable -> L57
    L34:
        r12 = null;
        goto L35
    L40:
        if (TextUtils.isEmpty(r11) == true) goto L21;
        HashSet r16 = new HashSet();     // Catch: Throwable -> L57
        Set r17 = (Set) ZeusTransformUtils.preCheckCast(r10.getValue(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
    L45:
        if (r17 == null) goto L50;
        if (r17.size() <= 0) goto L50;
        r16.addAll(r17);     // Catch: Throwable -> L57
    L50:
        if (r16.size() <= 0) goto L21;
        r6.put(r11, r16);     // Catch: Throwable -> L57
    L44:
        r17 = null;
        goto L45
    L27:
        if (r3 == true) goto L28;
        r9 = r15.getInt("is_block", 0);     // Catch: Throwable -> L57
        goto L21
    L28:
        r9 = ((Keva) ZeusTransformUtils.preCheckCast(d.c(new Object[0]), Keva.class, "com.obric.memorydata.plugin")).getInt("is_block", 0);     // Catch: Throwable -> L57
        goto L21
    L52:
        if (r9 <= 0) goto L54;
        a r18 = new c(r13, r5, r6);     // Catch: Throwable -> L57
    L90:
        return r18;
    L54:
        r18 = new b(r13, r5, r6);     // Catch: Throwable -> L57
        goto L90
    L11:
        r7 = r15.getAll();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r13.aA().a("parseFilterFromLocal getAll error: ", th, new Object[0]);     // Catch: Throwable -> L57
        r7 = null;
        goto L15
    L7:
        r15 = null;
    L57:
        th = move-exception;
        r13.aA().a("parseFilterFromLocal error: ", th, new Object[0]);
        return null;
    }

    public static a a(com.bytedance.applog.b r17, String r18, JSONObject r19) {
        boolean r7 = r17.bb();     // Catch: Throwable -> L73
        if (r7 == false) goto L7;
        ((Keva) ZeusTransformUtils.preCheckCast(d.c(new Object[0]), Keva.class, "com.obric.memorydata.plugin")).clear();     // Catch: Throwable -> L73
        SharedPreferences.Editor r9 = null;
    L8:
        if (r19 != null) goto L10;
    L72:
        return null;
    L10:
        if (r19.has("event_list") == false) goto L72;
        JSONObject r0 = r19.optJSONObject("event_list");     // Catch: Throwable -> L73
        if (r0 != null) goto L15;
        return null;
    L15:
        int r2 = r0.optInt("is_block", 0);     // Catch: Throwable -> L73
        if (r7 == false) goto L18;
        ((Keva) ZeusTransformUtils.preCheckCast(d.c(new Object[0]), Keva.class, "com.obric.memorydata.plugin")).storeInt("is_block", r2);     // Catch: Throwable -> L73
    L19:
        HashSet r4 = new HashSet();     // Catch: Throwable -> L73
        JSONArray r10 = r0.optJSONArray("events");     // Catch: Throwable -> L73
        if (r10 == null) goto L31;
        if (r10.length() <= 0) goto L31;
        int r11 = 0;
    L25:
        if (r11 >= r10.length()) goto L31;
        String r12 = r10.optString(r11);     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r12) == true) goto L29;
        r4.add(r12);     // Catch: Throwable -> L73
    L29:
        r11 = r11 + 1;     // Catch: Throwable -> L73
    L31:
        if (r4.size() <= 0) goto L35;
        if (r7 == false) goto L34;
        ((Keva) ZeusTransformUtils.preCheckCast(d.c(new Object[0]), Keva.class, "com.obric.memorydata.plugin")).storeStringSetJustDisk("events", r4);     // Catch: Throwable -> L73
        goto L35
    L34:
        r9.putStringSet("events", r4);     // Catch: Throwable -> L73
    L35:
        HashMap r3 = new HashMap();     // Catch: Throwable -> L73
        JSONObject r1 = r0.optJSONObject(TrackerImpl.PARAMS);     // Catch: Throwable -> L73
        if (r1 == null) goto L58;
        Iterator<String> r13 = r1.keys();     // Catch: Throwable -> L73
    L39:
        if (r13.hasNext() == false) goto L58;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r14) == true) goto L39;
        HashSet r15 = new HashSet();     // Catch: Throwable -> L73
        JSONArray r16 = r1.optJSONArray(r14);     // Catch: Throwable -> L73
        if (r16 == null) goto L55;
        if (r16.length() <= 0) goto L55;
        int r110 = 0;
    L49:
        if (r110 >= r16.length()) goto L55;
        String r111 = r16.optString(r110);     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r111) == true) goto L53;
        r15.add(r111);     // Catch: Throwable -> L73
    L53:
        r110 = r110 + 1;     // Catch: Throwable -> L73
    L55:
        if (r15.size() <= 0) goto L39;
        r3.put(r14, r15);     // Catch: Throwable -> L73
    L58:
        if (r3.size() <= 0) goto L66;
        Iterator r5 = r3.entrySet().iterator();     // Catch: Throwable -> L73
    L61:
        if (r5.hasNext() == false) goto L66;
        Map.Entry r112 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L73
        if (r7 == true) goto L64;
        r9.putStringSet((String) ZeusTransformUtils.preCheckCast(r112.getKey(), String.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r112.getValue(), Set.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L73
        goto L61
    L64:
        ((Keva) ZeusTransformUtils.preCheckCast(d.c(new Object[0]), Keva.class, "com.obric.memorydata.plugin")).storeStringSetJustDisk((String) ZeusTransformUtils.preCheckCast(r112.getKey(), String.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r112.getValue(), Set.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L73
    L66:
        if (r9 == null) goto L68;
        r9.apply();     // Catch: Throwable -> L73
    L68:
        if (r2 <= 0) goto L70;
        a r6 = new c(r17, r4, r3);     // Catch: Throwable -> L73
    L97:
        return r6;
    L70:
        r6 = new b(r17, r4, r3);     // Catch: Throwable -> L73
        goto L97
    L18:
        r9.putInt("is_block", r2);     // Catch: Throwable -> L73
        goto L19
    L7:
        r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r18, 0).edit();     // Catch: Throwable -> L73
        r9.clear().apply();     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        r17.aA().a("parseFilterFromServer error: ", th, new Object[0]);
        return null;
    }

    public static a a(com.bytedance.applog.b r5, List<String> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
    L19:
        return null;
    L5:
        if (r8.isEmpty() == true) goto L19;
        HashSet r2 = new HashSet();
        Iterator r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L13;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r2.add(r3);
        goto L8
    L13:
        if (r2.isEmpty() == true) goto L19;
        if (r7 == false) goto L18;
        return new c(r5, r2, null);
    L18:
        return new b(r5, r2, null);
    }

    public static f a(com.bytedance.applog.b r3, JSONObject r4) {
        if (r4 != null) goto L5;
    L12:
        return null;
    L5:
        if (r4.has("event_list") == false) goto L12;
        JSONObject r5 = r4.optJSONObject("event_list");
        if (r5 != null) goto L11;
        return null;
    L11:
        return new f(r3, r5, null, null);
    }

    public static void a(com.bytedance.applog.b r2) {
        new f(r2, null, null, null).c();
    }

    public static f b(com.bytedance.applog.b r2) {
        return new f(r2, null, null, null);
    }

    @Override // com.bytedance.applog.filter.e
    public boolean a(MonitorKey r2, String r3, String r4) {
        if (MonitorKey.event_v3.equals(r2) == true) goto L7;
        return false;
    L7:
        return !a(r3, r4);
    }

    public abstract boolean a(String r1);

    boolean a(String r5, String r6) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        HashSet<String> r0 = this.f1590a;
        if (r0 != null) goto L8;
    L40:
        return true;
    L8:
        if (r0.isEmpty() == true) goto L40;
        if (a(r5) == false) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty(r6) == false) goto L16;
        return true;
    L16:
        HashMap<String, HashSet<String>> r1 = this.f1591b;
        if (r1 == null) goto L40;
        if (r1.isEmpty() == true) goto L40;
        if (this.f1591b.containsKey(r5) == false) goto L40;
        HashSet<String> r7 = (HashSet) ZeusTransformUtils.preCheckCast(this.f1591b.get(r5), HashSet.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L40;
        if (r7.isEmpty() == true) goto L40;
        JSONObject r2 = null;
        r2 = new JSONObject(r6);     // Catch: Throwable -> L41
    L31:
        if (r2 != null) goto L33;
        return true;
    L33:
        Iterator<String> r8 = r2.keys();
    L35:
        if (r8.hasNext() == false) goto L40;
        if (a(r7, (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L35;
        r8.remove();     // Catch: Throwable -> L42
        goto L35
    }

    public abstract boolean a(HashSet<String> r1, String r2);
}
