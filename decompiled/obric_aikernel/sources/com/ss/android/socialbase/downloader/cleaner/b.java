package com.ss.android.socialbase.downloader.cleaner;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Map<Integer, C0141b> f7867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Map<Integer, C0141b> f7868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Map<Integer, List<Integer>> f7869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Set<Integer> f7870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Map<Integer, String> f7871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Map<Integer, String> f7872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile Map<Integer, String> f7873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f7874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f7875i;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.cleaner.b$b, reason: collision with other inner class name */
    private class C0141b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f7876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Set<String> f7877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<String> f7878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Set<String> f7879d;

        private C0141b(b r10) {
            this.f7877b = new HashSet();
            this.f7878c = new ArrayList();
            this.f7879d = new HashSet();
        }

        /* synthetic */ C0141b(b r10, a r11) {
            this(r10);
        }

        public String toString() {
            return "CleanItem{finish=" + this.f7876a + ", scenes=" + this.f7877b + ", prefixUrls=" + this.f7878c + ", savePaths=" + this.f7879d + '}';
        }
    }

    public b() {
        this.f7867a = new HashMap();
        this.f7868b = new HashMap();
        this.f7869c = new HashMap();
        this.f7870d = new HashSet();
        this.f7871e = new HashMap();
        this.f7872f = new HashMap();
        this.f7873g = new HashMap();
        this.f7874h = false;
    }

    private void a(int r10) {
        if (this.f7874h == false) goto L5;
        return;
    L5:
        if (r10 != 0) goto L7;
        return;
    L7:
        Set<Integer> r11 = this.f7870d;
        monitor-enter(r11);
        this.f7870d.add(Integer.valueOf(r10));     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private SharedPreferences d() {
        return com.ss.android.socialbase.downloader.downloader.a.h().getSharedPreferences("sp_download_cache", 0);
    }

    private String g(String r10) {
        return d().getString(r10, "");
    }

    private boolean l(C0141b r10, DownloadInfo r11) {
        if (r10 == null) goto L45;
        if (r11 == null) goto L45;
        if (TextUtils.isEmpty(r11.getSavePath()) == true) goto L12;
        if (com.ss.android.socialbase.downloader.utils.a.p(r11.getSavePath()) == true) goto L12;
        return false;
    L12:
        if (r10.f7877b.isEmpty() == true) goto L19;
        if (TextUtils.isEmpty(r11.getMonitorScene()) == true) goto L19;
        if (r10.f7877b.contains(r11.getMonitorScene()) == false) goto L19;
        return true;
    L19:
        if (r10.f7878c.isEmpty() == true) goto L30;
        String r12 = r11.getUrl();
        if (TextUtils.isEmpty(r12) == false) goto L23;
        return false;
    L23:
        Iterator<String> r13 = r10.f7878c.iterator();
    L25:
        if (r13.hasNext() == false) goto L30;
        if (r12.startsWith(r13.next()) == false) goto L25;
        return true;
    L30:
        if (r10.f7879d.isEmpty() == true) goto L45;
        if (TextUtils.isEmpty(this.f7875i) == true) goto L45;
        String r14 = r11.getSavePath();
        if (TextUtils.isEmpty(r14) == false) goto L37;
        return false;
    L37:
        if (r14.indexOf(this.f7875i) > 0) goto L40;
        return false;
    L40:
        if (r14.endsWith("/") == false) goto L43;
        r14 = r14.substring(0, r14.length() - 1);
    L43:
        if (r10.f7879d.contains(r14) == false) goto L45;
        return true;
    L45:
        return false;
    }

    private void m(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        n(new JSONObject(r10));
    }

    private void n(JSONObject r12) {
        if (lb.a.a() == false) goto L5;
        lb.a.b("CleanerConfig", "parseCleanSetting", "Run");
    L5:
        if (r12 != null) goto L7;
        return;
    L7:
        JSONArray r13 = r12.optJSONArray("clean_group");
        if (r13 != null) goto L10;
        return;
    L10:
        if (r13.length() <= 0) goto L82;
        int r10 = 0;
    L14:
        if (r10 >= r13.length()) goto L64;
        JSONObject r11 = r13.getJSONObject(r10);
        int r14 = r11.optInt("clean_id");
        if (this.f7867a.containsKey(Integer.valueOf(r14)) == true) goto L62;
        C0141b r15 = new C0141b(this, null);
        boolean r16 = r11.optBoolean("key_clean_finish");
        r15.f7876a = r16;
        if (r16 == false) goto L22;
        this.f7867a.put(Integer.valueOf(r14), r15);
        Map<Integer, List<Integer>> r17 = this.f7869c;
        Integer r18 = Integer.valueOf(r14);
        ArrayList r19 = new ArrayList();
    L21:
        r17.put(r18, r19);
        goto L62
    L22:
        JSONArray r20 = r11.optJSONArray("monitor_scene_list");
        if (r20 != null) goto L25;
    L33:
        JSONArray r21 = r11.optJSONArray("url_prefix_list");
        if (r21 != null) goto L36;
    L44:
        JSONArray r22 = r11.optJSONArray("save_path_list");
        if (r22 == null) goto L56;
        if (r22.length() <= 0) goto L56;
        int r23 = 0;
    L50:
        if (r23 >= r22.length()) goto L56;
        String r24 = r22.optString(r23);
        if (TextUtils.isEmpty(r24) == true) goto L54;
        r15.f7879d.add(r24);
    L54:
        r23 = r23 + 1;
    L56:
        if (r15.f7877b.isEmpty() == true) goto L58;
    L61:
        this.f7867a.put(Integer.valueOf(r14), r15);
        r17 = this.f7869c;
        r18 = Integer.valueOf(r14);
        r19 = new ArrayList();
        goto L21
    L58:
        if (r15.f7878c.isEmpty() == false) goto L61;
        if (r15.f7879d.isEmpty() == true) goto L62;
    L36:
        if (r21.length() <= 0) goto L44;
        int r25 = 0;
    L39:
        if (r25 >= r21.length()) goto L44;
        String r26 = r21.optString(r25);
        if (TextUtils.isEmpty(r26) == true) goto L43;
        r15.f7878c.add(r26);
    L43:
        r25 = r25 + 1;
        goto L39
    L25:
        if (r20.length() <= 0) goto L33;
        int r27 = 0;
    L28:
        if (r27 >= r20.length()) goto L33;
        String r28 = r20.optString(r27);
        if (TextUtils.isEmpty(r28) == true) goto L32;
        r15.f7877b.add(r28);
    L32:
        r27 = r27 + 1;
    L62:
        r10 = r10 + 1;
        goto L14
    L64:
        if (lb.a.a() == false) goto L81;
        lb.a.b("CleanerConfig", "parseCleanSetting", "Result: " + this.f7867a);
        return;
    L81:
        return;
    }

    private void o(String r10, String r11) {
        d().edit().putString(r10, r11).apply();
    }

    private void q(DownloadInfo r10) {
        if (TextUtils.isEmpty(r10.getSavePath()) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10.getName()) == true) goto L11;
        this.f7871e.put(Integer.valueOf(r10.getId()), r10.getSavePath());
        this.f7872f.put(Integer.valueOf(r10.getId()), r10.getName());
        if (TextUtils.isEmpty(r10.getTempPath()) == true) goto L12;
        this.f7873g.put(Integer.valueOf(r10.getId()), r10.getTempPath());
        return;
    L12:
        return;
    }

    public void b() {
        this.f7874h = true;
        this.f7867a.clear();
        this.f7868b.clear();
        this.f7869c.clear();
        this.f7871e.clear();
        this.f7872f.clear();
        this.f7873g.clear();
        Set<Integer> r10 = this.f7870d;
        monitor-enter(r10);
        this.f7870d.clear();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<Integer, List<Integer>> c() {
        return this.f7869c;
    }

    public String e(int r10) {
        return this.f7872f.get(Integer.valueOf(r10));
    }

    public String f(int r10) {
        return this.f7871e.get(Integer.valueOf(r10));
    }

    public String h(int r10) {
        return this.f7873g.get(Integer.valueOf(r10));
    }

    public void i() {
        m(g("key_download_cache_clean_strategy"));     // Catch: Throwable -> L14
        n(rb.a.d());     // Catch: Throwable -> L14
        if (this.f7867a.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, C0141b>> r10 = this.f7867a.entrySet().iterator();     // Catch: Throwable -> L14
    L7:
        if (r10.hasNext() == false) goto L12;
        Map.Entry<Integer, C0141b> r11 = r10.next();     // Catch: Throwable -> L14
        C0141b r12 = r11.getValue();     // Catch: Throwable -> L14
        if (r12.f7876a == true) goto L7;
        this.f7868b.put(r11.getKey(), r12);     // Catch: Throwable -> L14
        goto L7
    L12:
        this.f7875i = com.ss.android.socialbase.downloader.downloader.a.h().getPackageName();     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
    }

    public boolean j(int r10) {
        if (this.f7874h == false) goto L6;
        return false;
    L6:
        Set<Integer> r11 = this.f7870d;
        monitor-enter(r11);
        boolean r12 = this.f7870d.contains(Integer.valueOf(r10));     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean k() {
        Set<Integer> r10 = this.f7870d;
        monitor-enter(r10);
        boolean r11 = this.f7870d.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public void p(int r10) {
        Set<Integer> r11 = this.f7870d;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f7870d.isEmpty() == false) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        this.f7870d.remove(Integer.valueOf(r10));     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
    }

    public boolean r(DownloadInfo r10) {
        if (this.f7868b.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<Integer, C0141b>> r11 = this.f7868b.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L15;
        Map.Entry<Integer, C0141b> r12 = r11.next();
        if (l(r12.getValue(), r10) == false) goto L7;
        int r13 = r12.getKey().intValue();
        List<Integer> r14 = this.f7869c.get(Integer.valueOf(r13));
        if (r14 != null) goto L13;
        r14 = new ArrayList();
    L13:
        r14.add(Integer.valueOf(r10.getId()));
        a(r10.getId());
        this.f7869c.put(Integer.valueOf(r13), r14);
        q(r10);
        return true;
    L15:
        return false;
    }

    public void s(int r11) {
        if (lb.a.a() == false) goto L6;
        lb.a.b("CleanerConfig", "updateCleanSetting", "Run:" + r11);
    L6:
        if (this.f7867a.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.f7867a.get(Integer.valueOf(r11)).f7876a == true) goto L50;
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L38
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L38
        Iterator<Map.Entry<Integer, C0141b>> r13 = this.f7867a.entrySet().iterator();     // Catch: Throwable -> L38
    L12:
        if (r13.hasNext() == false) goto L36;
        Map.Entry<Integer, C0141b> r14 = r13.next();     // Catch: Throwable -> L38
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L38
        r15.put("clean_id", r14.getKey());     // Catch: Throwable -> L38
        C0141b r16 = r14.getValue();     // Catch: Throwable -> L38
        if (r16.f7876a == false) goto L16;
    L19:
        boolean r17 = true;
    L20:
        r16.f7876a = r17;     // Catch: Throwable -> L38
        r15.put("key_clean_finish", r17);     // Catch: Throwable -> L38
        if (r16.f7876a == true) goto L22;
        JSONArray r18 = new JSONArray();     // Catch: Throwable -> L38
        Iterator<String> r19 = r16.f7877b.iterator();     // Catch: Throwable -> L38
    L25:
        if (r19.hasNext() == false) goto L27;
        r18.put(r19.next());     // Catch: Throwable -> L38
        goto L25
    L27:
        r15.put("monitor_scene_list", r18);     // Catch: Throwable -> L38
        JSONArray r20 = new JSONArray();     // Catch: Throwable -> L38
        Iterator<String> r21 = r16.f7878c.iterator();     // Catch: Throwable -> L38
    L29:
        if (r21.hasNext() == false) goto L31;
        r20.put(r21.next());     // Catch: Throwable -> L38
        goto L29
    L31:
        r15.put("url_prefix_list", r20);     // Catch: Throwable -> L38
        JSONArray r22 = new JSONArray();     // Catch: Throwable -> L38
        Iterator<String> r23 = r16.f7879d.iterator();     // Catch: Throwable -> L38
    L33:
        if (r23.hasNext() == false) goto L35;
        r22.put(r23.next());     // Catch: Throwable -> L38
        goto L33
    L35:
        r15.put("save_path_list", r22);     // Catch: Throwable -> L38
    L22:
        r12.put(r15);     // Catch: Throwable -> L38
        goto L12
    L16:
        if (r14.getKey().intValue() == r11) goto L19;
        r17 = false;
        goto L20
    L36:
        r10.put("clean_group", r12);     // Catch: Throwable -> L38
        o("key_download_cache_clean_strategy", r10.toString());     // Catch: Throwable -> L38
        return;
    L38:
        th = move-exception;
        th.printStackTrace();
        lb.a.c("CleanerConfig", "updateCleanSetting", "Error:" + th);
        return;
    }
}
