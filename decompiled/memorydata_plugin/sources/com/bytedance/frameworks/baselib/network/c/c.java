package com.bytedance.frameworks.baselib.network.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    private static final String d = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f2298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2299b;
    private int c;
    private Set<String> e;
    private Set<String> f;
    private Set<String> g;
    private Set<Pattern> h;

    static {
    }

    public c(int r2) {
        this.f2298a = false;
        this.e = new HashSet();
        this.f = new HashSet();
        this.g = new HashSet();
        this.h = new HashSet();
        this.f2299b = r2;
        this.c = r2;
    }

    public static c a(String r1, int r2, int r3, JSONObject r4) {
        if (r1.equals("rm") == false) goto L6;
        c r5 = new f(r2);
    L8:
        r5.a(r4);
        r5.a(r3);
        return r5;
    L6:
        if (r1.equals(LBSLightLocationTraceLogger.ENCRYPT) == false) goto L10;
        r5 = new b(r2);
        goto L8
    L10:
        return null;
    }

    private void a(int r1) {
        this.c = r1;
    }

    private static void a(JSONArray r3, Set<Pattern> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L14;
        if (r5 == null) goto L24;
        int r0 = 0;
    L19:
        if (r0 >= r3.length()) goto L26;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(r1) == true) goto L13;
        r5.add(Pattern.compile(r1, 2));     // Catch: Throwable -> L15
    L13:
        r0 = r0 + 1;
        goto L19
    L26:
        return;
    L25:
        return;
    L24:
        return;
    }

    private boolean a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        Iterator<String> r4 = this.e.iterator();
    L7:
        if (r4.hasNext() == false) goto L15;
        if (k.a(r5, (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return true;
    L15:
        return false;
    }

    private static boolean a(Set<?> r2) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return true;
    L5:
        if (r3.isEmpty() == true) goto L11;
        return false;
    L11:
        return true;
    }

    private void b(JSONArray r3, Set<String> r4) {
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L13;
        if (r2 == null) goto L20;
        int r5 = 0;
    L15:
        if (r5 >= r3.length()) goto L22;
        String r0 = r3.getString(r5);     // Catch: JSONException -> L14
        if (TextUtils.isEmpty(r0) == true) goto L12;
        r2.add(r0);     // Catch: JSONException -> L14
    L12:
        r5 = r5 + 1;
        goto L15
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    private boolean b(Request r1) {
        if (r1.getQueryFilterPriority() <= this.f2299b) goto L6;
        return false;
    L6:
        return true;
    }

    private boolean b(Request r3, Map<String, List<String>> r4) {
        Map<String, List<String>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (b(r3) == true) goto L7;
        return false;
    L7:
        return a(r3, r5);
    }

    public int a() {
        return this.f2299b;
    }

    public abstract void a(JSONObject r1);

    public boolean a(Request r7) {
        if (this.f2298a == false) goto L8;
        if (e.e().f2305a.get() == true) goto L8;
        return false;
    L8:
        if (a(this.e) == false) goto L10;
    L12:
        String r8 = r7.getPath();
        if (TextUtils.isEmpty(r8) == true) goto L15;
        int r0 = r8.length();
        if (r0 <= 1) goto L24;
        int r1 = r0 - 1;
        if (r8.substring(r1).equals("/") == false) goto L24;
        r8 = r8.substring(0, r1);
    L24:
        if (a(this.f) == true) goto L29;
        if (this.f.contains(r8) == false) goto L29;
        return true;
    L29:
        if (a(this.g) == true) goto L37;
        Iterator<String> r2 = this.g.iterator();
    L32:
        if (r2.hasNext() == false) goto L37;
        if (r8.startsWith((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L32;
        return true;
    L37:
        if (a(this.h) == true) goto L46;
        Iterator<Pattern> r6 = this.h.iterator();
    L40:
        if (r6.hasNext() == false) goto L46;
        Pattern r3 = (Pattern) ZeusTransformUtils.preCheckCast(r6.next(), Pattern.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L40;
        if (r3.matcher(r8).matches() == false) goto L40;
        return true;
    L46:
        return false;
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d(d, "Path is empty: " + r8);
    L17:
        return false;
    L10:
        if (a(r7.getHost()) == true) goto L12;
        return false;
    }

    public abstract boolean a(Request r1, Map<String, List<String>> r2);

    public boolean a(Request r4, Map<String, List<String>> r5, List<a> r6) {
        Map<String, List<String>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        a r0 = new a();
        r0.a(SystemClock.uptimeMillis());
        boolean r9 = b(r4, r7);
        if (r9 == false) goto L5;
        r4.setQueryFilterPriority(this.c);
    L5:
        r0.a(r9);
        r0.a(this.f2299b);
        r0.b(SystemClock.uptimeMillis());
        r8.add(r0);
        return r9;
    }

    public void b(JSONObject r3) {
        b(r3.optJSONArray("host_group"), this.e);
        b(r3.optJSONArray("equal_group"), this.f);
        b(r3.optJSONArray("prefix_group"), this.g);
        a(r3.optJSONArray("pattern_group"), this.h);
    }
}
