package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f2414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2415b = "e";
    private volatile int c;
    private List<a> d;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<String> f2416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final List<String> f2417b;
        List<String> c;
        List<String> d;
        List<Pattern> e;
        Set<Integer> f;
        int g;
        int h;
        String i;
        volatile int j;
        volatile long k;
        volatile boolean l;
        int m;
        boolean n;
        boolean o;
        String p;
        boolean q;
        int r;

        public a(List<String> r3, List<String> r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.q = false;
            this.r = 0;
            this.f2416a = r5;
            this.f2417b = r6;
            this.k = SystemClock.uptimeMillis();
            this.j = 0;
            this.h = Integer.MAX_VALUE;
            this.g = 0;
            this.l = false;
            this.i = UUID.randomUUID().toString();
            this.n = false;
            this.m = 4000;
            this.o = true;
            this.p = null;
        }

        public List<String> a() {
            return this.f2417b;
        }

        public String b() {
            return this.i;
        }
    }

    static {
    }

    private e() {
        this.c = 0;
        this.d = new CopyOnWriteArrayList();
    }

    public static e a() {
        if (f2414a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2414a != null) goto L9;
        f2414a = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f2414a;
    }

    private void a(a r5, boolean r6) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f2415b, "Forbidden: " + r5.l + " failed count: " + r5.j + " max count: " + r5.h);
    L5:
        int r4 = r5.j;
        if (r6 == false) goto L13;
        if (r4 == 0) goto L9;
    L11:
        r5.j = 0;
        r5.l = false;
        return;
    L9:
        if (r5.l == true) goto L11;
        return;
    L13:
        int r7 = r4 + 1;
        r5.j = r7;
        if (r7 >= r5.h) goto L17;
        return;
    L17:
        if (r5.l == true) goto L20;
        r5.l = true;
        r5.k = SystemClock.uptimeMillis();
    L20:
        if (Logger.debug() == false) goto L23;
        Logger.d(f2415b, "Forbidden: " + r5.l + " failed count: " + r5.j);
        return;
    }

    private void a(JSONObject r9) {
        ArrayList r0 = new ArrayList();
        a(r9, "host_group", r0);
        ArrayList r1 = new ArrayList();
        a(r9, "concurrent_hosts", r1);
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        if (r1.size() < 2) goto L57;
        a r2 = new a(r0, r1);
        ArrayList r3 = new ArrayList();
        if (a(r9, "equal_group", r3) == false) goto L10;
        r2.c = r3;
    L10:
        ArrayList r4 = new ArrayList();
        if (a(r9, "prefix_group", r4) == false) goto L13;
        r2.d = r4;
    L13:
        ArrayList r5 = new ArrayList();
        JSONArray r6 = r9.optJSONArray("pattern_group");
        int r7 = 0;
        if (r6 == null) goto L23;
        int r8 = 0;
    L17:
        if (r8 >= r6.length()) goto L22;
        String r10 = r6.optString(r8);
        if (TextUtils.isEmpty(r10) == true) goto L21;
        r5.add(Pattern.compile(r10, 2));     // Catch: Throwable -> L49
    L21:
        r8 = r8 + 1;
        goto L17
    L22:
        r2.e = r5;
    L23:
        r2.h = r9.optInt("fail_count", Integer.MAX_VALUE);
        r2.g = r9.optInt("forbid_seconds", 0);
        r2.m = r9.optInt("connect_interval_millis", 4000);
        boolean r11 = true;
        if (r9.optInt("bypass_rs_enabled", 1) <= 0) goto L26;
        boolean r12 = true;
    L27:
        r2.o = r12;
        r2.p = r9.optString("concurrent_route");
        if (TextUtils.isEmpty(r2.p) == false) goto L31;
        r2.p = r9.optString("rs_name", null);
    L31:
        if (r9.optInt("fin_fix_enabled", 0) <= 0) goto L33;
        boolean r13 = true;
    L34:
        r2.q = r13;
        r2.r = r9.optInt("max_wait_seconds", 0);
        if (r2.m > 0) goto L38;
        return;
    L38:
        if (r9.optInt("retry_for_not_2xx_code", 0) > 0) goto L41;
        r11 = false;
    L41:
        r2.n = r11;
        HashSet r14 = new HashSet();
        JSONArray r15 = r9.optJSONArray("block_code_list");
        if (r15 != null) goto L44;
    L47:
        this.d.add(r2);
        return;
    L44:
        if (r7 >= r15.length()) goto L46;
        r14.add(Integer.valueOf(r15.optInt(r7)));
        r7 = r7 + 1;
        goto L44
    L46:
        r2.f = r14;
        goto L47
    L33:
        r13 = false;
        goto L34
    L26:
        r12 = false;
        goto L27
    }

    private boolean a(Request r7, a r8) {
        if (r8.g > 0) goto L5;
    L7:
        String r6 = r7.getUrl();
        if (TextUtils.isEmpty(r6) == false) goto L10;
        return false;
    L10:
        Iterator<String> r1 = r8.f2416a.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        if (k.a(r7.getHost(), (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L12;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L19;
        String r9 = r7.getPath();
        if (TextUtils.isEmpty(r9) == false) goto L26;
        return false;
    L26:
        if (a(r8.c) == true) goto L34;
        Iterator<String> r10 = r8.c.iterator();
    L29:
        if (r10.hasNext() == false) goto L34;
        if (r9.equals((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L29;
        return true;
    L34:
        if (a(r8.d) == true) goto L42;
        Iterator<String> r11 = r8.d.iterator();
    L37:
        if (r11.hasNext() == false) goto L42;
        if (r9.startsWith((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L37;
        return true;
    L42:
        if (a(r8.e) == true) goto L51;
        Iterator<Pattern> r12 = r8.e.iterator();
    L45:
        if (r12.hasNext() == false) goto L51;
        Pattern r13 = (Pattern) ZeusTransformUtils.preCheckCast(r12.next(), Pattern.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L45;
        if (r13.matcher(r9).matches() == false) goto L45;
        return true;
    L51:
        return false;
    L19:
        if (Logger.debug() == false) goto L21;
        Logger.d(f2415b, "host not match: " + r6);
    L21:
        return false;
    L16:
        r2 = false;
        goto L17
    L5:
        if (r8.l == false) goto L7;
        return false;
    }

    private static boolean a(List<?> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return true;
    L5:
        if (r3.isEmpty() == true) goto L11;
        return false;
    L11:
        return true;
    }

    private static boolean a(JSONObject r2, String r3, List<String> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r2 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L19;
        if (r5 == null) goto L19;
        JSONArray r6 = r2.optJSONArray(r3);
        if (r6 != null) goto L12;
        return false;
    L12:
        if (r0 >= r6.length()) goto L17;
        String r7 = r6.optString(r0);
        if (TextUtils.isEmpty(r7) == true) goto L16;
        r5.add(r7);
    L16:
        r0 = r0 + 1;
        goto L12
    L17:
        return true;
    }

    private a b(String r4) {
        Iterator<a> r3 = this.d.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin");
        if (r0.b().equals(r4) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private void c() {
        Iterator<a> r6 = this.d.iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.memorydata.plugin");
        if (r0.l == false) goto L4;
        long r1 = SystemClock.uptimeMillis() - r0.k;
        if (r1 <= (r0.g * 1000)) goto L11;
        r0.l = false;
    L11:
        if (Logger.debug() == false) goto L4;
        Logger.d(f2415b, "Rule id: " + r0.i + " has forbidden duration: " + r1 + " fail count: " + r0.j + " forbidden duration: " + (r0.g * 1000));
        goto L4
    }

    public a a(Request r5) {
        c();
        Iterator<a> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin");
        if (a(r5, r1) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    public void a(String r5) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f2415b, "onNetConfigChanged config: " + r5);
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L17;
        return;
    L17:
        JSONObject r0 = new JSONObject(r5);     // Catch: Throwable -> L13
        int r1 = 0;
        this.c = r0.optInt("enabled_v2", 0);     // Catch: Throwable -> L13
        this.d.clear();     // Catch: Throwable -> L13
        JSONArray r6 = r0.getJSONArray("match_rules");     // Catch: Throwable -> L13
    L10:
        if (r1 >= r6.length()) goto L21;
        a((JSONObject) ZeusTransformUtils.preCheckCast(r6.get(r1), JSONObject.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
        r1 = r1 + 1;
        goto L10
    L21:
        return;
    L14:
        if (Logger.debug() == false) goto L20;
        Logger.d(f2415b, "parse json config error");
        return;
    }

    public void a(String r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        a r4 = b(r2);
        if (r4 != null) goto L8;
        return;
    L8:
        a(r4, r3);
    }

    public boolean a(int r3, String r4) {
        if (r3 != 0) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L14;
        a r2 = b(r4);
        if (r2 == null) goto L14;
        if (r2.f == null) goto L14;
        return r2.f.contains(Integer.valueOf(r3));
    }

    public boolean b() {
        if (this.c <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
