package com.ss.android.socialbase.downloader.cleaner;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Map<Integer, a> f15343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Map<Integer, a> f15344b;
    private volatile Map<Integer, List<Integer>> c;
    private volatile Set<Integer> d;
    private volatile Map<Integer, String> e;
    private volatile Map<Integer, String> f;
    private volatile Map<Integer, String> g;
    private volatile Set<Integer> h;
    private volatile boolean i;
    private String j;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.cleaner.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f15345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Set<String> f15346b;
        List<String> c;
        Set<String> d;
        final /* synthetic */ b e;

        private a(b r1) {
            this.e = r1;
            this.f15346b = new HashSet();
            this.c = new ArrayList();
            this.d = new HashSet();
        }

        /* synthetic */ a(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        public String toString() {
            return "CleanItem{finish=" + this.f15345a + ", scenes=" + this.f15346b + ", prefixUrls=" + this.c + ", savePaths=" + this.d + '}';
        }
    }

    public b() {
        this.f15343a = new HashMap();
        this.f15344b = new HashMap();
        this.c = new HashMap();
        this.d = new HashSet();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new HashSet();
        this.i = false;
    }

    private void a(int r4, DownloadInfo r5, boolean r6) {
        List<Integer> r0 = (List) ZeusTransformUtils.preCheckCast(this.c.get(Integer.valueOf(r4)), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        r0.add(Integer.valueOf(r5.getId()));
        h(r5.getId());
        this.c.put(Integer.valueOf(r4), r0);
        b(r5);
        if (r6 == false) goto L9;
        this.h.add(Integer.valueOf(r5.getId()));
        return;
    }

    private void a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        a(new JSONObject(r2));
    }

    private void a(String r1, String r2) {
        e().edit().putString(r1, r2).apply();
    }

    private void a(JSONObject r12) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("CleanerConfig", "parseCleanSetting", "Run");
    L5:
        if (r12 != null) goto L7;
        return;
    L7:
        JSONArray r13 = r12.optJSONArray("clean_group");
        if (r13 != null) goto L10;
        return;
    L10:
        if (r13.length() <= 0) goto L82;
        int r3 = 0;
    L14:
        if (r3 >= r13.length()) goto L64;
        JSONObject r4 = r13.getJSONObject(r3);
        int r5 = r4.optInt("clean_id");
        if (this.f15343a.containsKey(Integer.valueOf(r5)) == true) goto L62;
        a r6 = new a(this, null);
        r6.f15345a = r4.optBoolean("key_clean_finish");
        if (r6.f15345a == false) goto L22;
        this.f15343a.put(Integer.valueOf(r5), r6);
        Map<Integer, List<Integer>> r7 = this.c;
        Integer r8 = Integer.valueOf(r5);
        ArrayList r9 = new ArrayList();
    L21:
        r7.put(r8, r9);
        goto L62
    L22:
        JSONArray r10 = r4.optJSONArray("monitor_scene_list");
        if (r10 != null) goto L25;
    L33:
        JSONArray r11 = r4.optJSONArray("url_prefix_list");
        if (r11 != null) goto L36;
    L44:
        JSONArray r14 = r4.optJSONArray("save_path_list");
        if (r14 == null) goto L56;
        if (r14.length() <= 0) goto L56;
        int r15 = 0;
    L50:
        if (r15 >= r14.length()) goto L56;
        String r16 = r14.optString(r15);
        if (TextUtils.isEmpty(r16) == true) goto L54;
        r6.d.add(r16);
    L54:
        r15 = r15 + 1;
    L56:
        if (r6.f15346b.isEmpty() == true) goto L58;
    L61:
        this.f15343a.put(Integer.valueOf(r5), r6);
        r7 = this.c;
        r8 = Integer.valueOf(r5);
        r9 = new ArrayList();
        goto L21
    L58:
        if (r6.c.isEmpty() == false) goto L61;
        if (r6.d.isEmpty() == true) goto L62;
    L36:
        if (r11.length() <= 0) goto L44;
        int r17 = 0;
    L39:
        if (r17 >= r11.length()) goto L44;
        String r18 = r11.optString(r17);
        if (TextUtils.isEmpty(r18) == true) goto L43;
        r6.c.add(r18);
    L43:
        r17 = r17 + 1;
        goto L39
    L25:
        if (r10.length() <= 0) goto L33;
        int r19 = 0;
    L28:
        if (r19 >= r10.length()) goto L33;
        String r20 = r10.optString(r19);
        if (TextUtils.isEmpty(r20) == true) goto L32;
        r6.f15346b.add(r20);
    L32:
        r19 = r19 + 1;
    L62:
        r3 = r3 + 1;
        goto L14
    L64:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L81;
        com.ss.android.socialbase.downloader.e.a.a("CleanerConfig", "parseCleanSetting", "Result: " + this.f15343a);
        return;
    L81:
        return;
    }

    private boolean a(a r8, DownloadInfo r9) {
        if (r8 == null) goto L43;
        if (r9 == null) goto L43;
        if (TextUtils.isEmpty(r9.getSavePath()) == true) goto L10;
        return false;
    L10:
        if (r8.f15346b.isEmpty() == true) goto L17;
        if (TextUtils.isEmpty(r9.getMonitorScene()) == true) goto L17;
        if (r8.f15346b.contains(r9.getMonitorScene()) == false) goto L17;
        return true;
    L17:
        if (r8.c.isEmpty() == true) goto L28;
        String r1 = r9.getUrl();
        if (TextUtils.isEmpty(r1) == false) goto L21;
        return false;
    L21:
        Iterator<String> r3 = r8.c.iterator();
    L23:
        if (r3.hasNext() == false) goto L28;
        if (r1.startsWith((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L23;
        return true;
    L28:
        if (r8.d.isEmpty() == true) goto L43;
        if (TextUtils.isEmpty(this.j) == true) goto L43;
        String r10 = r9.getSavePath();
        if (TextUtils.isEmpty(r10) == false) goto L35;
        return false;
    L35:
        if (r10.indexOf(this.j) > 0) goto L38;
        return false;
    L38:
        if (r10.endsWith("/") == false) goto L41;
        r10 = r10.substring(0, r10.length() - 1);
    L41:
        if (r8.d.contains(r10) == false) goto L43;
        return true;
    L43:
        return false;
    }

    private String b(String r2) {
        return e().getString(r2, "");
    }

    private void b(DownloadInfo r4) {
        if (TextUtils.isEmpty(r4.getSavePath()) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4.getName()) == true) goto L11;
        this.e.put(Integer.valueOf(r4.getId()), r4.getSavePath());
        this.f.put(Integer.valueOf(r4.getId()), r4.getName());
        if (TextUtils.isEmpty(r4.getTempPath()) == true) goto L12;
        this.g.put(Integer.valueOf(r4.getId()), r4.getTempPath());
        return;
    L12:
        return;
    }

    private SharedPreferences e() {
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("sp_download_cache", 0);
    }

    private void h(int r2) {
        if (this.i == false) goto L5;
        return;
    L5:
        if (r2 != 0) goto L7;
        return;
    L7:
        Set<Integer> r0 = this.d;
        monitor-enter(r0);
        this.d.add(Integer.valueOf(r2));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void a() {
        a(b("key_download_cache_clean_strategy"));     // Catch: Throwable -> L15
        a(com.ss.android.socialbase.downloader.g.a.b());     // Catch: Throwable -> L15
        if (this.f15343a.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, a>> r0 = this.f15343a.entrySet().iterator();     // Catch: Throwable -> L15
    L8:
        if (r0.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.getValue(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r2.f15345a == true) goto L8;
        this.f15344b.put((Integer) r1.getKey(), r2);     // Catch: Throwable -> L15
        goto L8
    L13:
        this.j = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
    }

    public void a(int r3) {
        Set<Integer> r0 = this.d;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.d.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.d.remove(Integer.valueOf(r3));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public boolean a(DownloadInfo r7) {
        if (this.f15344b.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<Integer, a>> r0 = this.f15344b.entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (a((a) ZeusTransformUtils.preCheckCast(r2.getValue(), a.class, "com.obric.memorydata.plugin"), r7) == false) goto L7;
        a(((Integer) ZeusTransformUtils.preCheckCast(r2.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), r7, false);
        return true;
    L12:
        return false;
    }

    public boolean a(DownloadInfo r2, boolean r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        a(-1, r2, r3);
        return true;
    }

    public boolean b() {
        Set<Integer> r0 = this.d;
        monitor-enter(r0);
        boolean r1 = this.d.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean b(int r2) {
        if (this.i == false) goto L6;
        return false;
    L6:
        Set<Integer> r0 = this.d;
        monitor-enter(r0);
        boolean r1 = this.d.contains(Integer.valueOf(r2));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public String c(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(this.e.get(Integer.valueOf(r2)), String.class, "com.obric.memorydata.plugin");
    }

    public Map<Integer, List<Integer>> c() {
        return this.c;
    }

    public String d(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(this.f.get(Integer.valueOf(r2)), String.class, "com.obric.memorydata.plugin");
    }

    public void d() {
        this.i = true;
        this.f15343a.clear();
        this.f15344b.clear();
        this.c.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h.clear();
        Set<Integer> r0 = this.d;
        monitor-enter(r0);
        this.d.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String e(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(this.g.get(Integer.valueOf(r2)), String.class, "com.obric.memorydata.plugin");
    }

    public boolean f(int r1) {
        return this.h.contains(Integer.valueOf(r1));
    }

    public void g(int r13) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("CleanerConfig", "updateCleanSetting", "Run:" + r13);
    L6:
        if (this.f15343a.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.f15343a.get(Integer.valueOf(r13)) != null) goto L10;
        return;
    L10:
        if (((a) ZeusTransformUtils.preCheckCast(this.f15343a.get(Integer.valueOf(r13)), a.class, "com.obric.memorydata.plugin")).f15345a == true) goto L53;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L40
        JSONArray r3 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<Map.Entry<Integer, a>> r5 = this.f15343a.entrySet().iterator();     // Catch: Throwable -> L40
    L14:
        if (r5.hasNext() == false) goto L38;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L40
        r7.put("clean_id", r6.getKey());     // Catch: Throwable -> L40
        a r8 = (a) ZeusTransformUtils.preCheckCast(r6.getValue(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        if (r8.f15345a == false) goto L18;
    L21:
        boolean r9 = true;
    L22:
        r8.f15345a = r9;     // Catch: Throwable -> L40
        r7.put("key_clean_finish", r8.f15345a);     // Catch: Throwable -> L40
        if (r8.f15345a == true) goto L24;
        JSONArray r10 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<String> r11 = r8.f15346b.iterator();     // Catch: Throwable -> L40
    L27:
        if (r11.hasNext() == false) goto L29;
        r10.put((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L40
        goto L27
    L29:
        r7.put("monitor_scene_list", r10);     // Catch: Throwable -> L40
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<String> r14 = r8.c.iterator();     // Catch: Throwable -> L40
    L31:
        if (r14.hasNext() == false) goto L33;
        r12.put((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L40
        goto L31
    L33:
        r7.put("url_prefix_list", r12);     // Catch: Throwable -> L40
        JSONArray r15 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<String> r16 = r8.d.iterator();     // Catch: Throwable -> L40
    L35:
        if (r16.hasNext() == false) goto L37;
        r15.put((String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L40
        goto L35
    L37:
        r7.put("save_path_list", r15);     // Catch: Throwable -> L40
    L24:
        r3.put(r7);     // Catch: Throwable -> L40
        goto L14
    L18:
        if (((Integer) ZeusTransformUtils.preCheckCast(r6.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() == r13) goto L21;
        r9 = false;
        goto L22
    L38:
        r0.put("clean_group", r3);     // Catch: Throwable -> L40
        a("key_download_cache_clean_strategy", r0.toString());     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("CleanerConfig", "updateCleanSetting", "Error:" + th);
        return;
    }
}
