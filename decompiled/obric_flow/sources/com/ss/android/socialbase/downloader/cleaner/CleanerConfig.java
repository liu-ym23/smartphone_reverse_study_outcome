package com.ss.android.socialbase.downloader.cleaner;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.nubia.neopush.commons.AppUtil;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import td.c;
import td.d;

/* JADX INFO: loaded from: classes3.dex */
public class CleanerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile HashMap f15225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile HashMap f15226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile HashMap f15227c;
    public volatile ArrayList d;
    public volatile int e;
    public volatile long f;
    public volatile HashSet g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile HashMap f15228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile HashMap f15229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile HashMap f15230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile HashSet f15231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f15232l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f15233m;

    public class CleanItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashSet f15235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f15236c;
        public final HashSet d;

        public CleanItem() {
            this.f15235b = new HashSet();
            this.f15236c = new ArrayList();
            this.d = new HashSet();
        }

        public final String toString() {
            return "CleanItem{finish=" + this.f15234a + ", scenes=" + this.f15235b + ", prefixUrls=" + this.f15236c + ", savePaths=" + this.d + '}';
        }
    }

    public CleanerConfig() {
        this.f15225a = new HashMap();
        this.f15226b = new HashMap();
        this.f15227c = new HashMap();
        this.d = new ArrayList();
        this.g = new HashSet();
        this.f15228h = new HashMap();
        this.f15229i = new HashMap();
        this.f15230j = new HashMap();
        this.f15231k = new HashSet();
        this.f15232l = false;
    }

    public final boolean a(int r5) {
        if (this.f15232l == false) goto L6;
        return false;
    L6:
        HashSet r10 = this.g;
        monitor-enter(r10);
        boolean r11 = this.g.contains(Integer.valueOf(r5));     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r11;
    L11:
        th = move-exception;
        throw th;
    }

    public final void b(int r5) {
        HashSet r10 = this.g;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.g.isEmpty() == false) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        this.g.remove(Integer.valueOf(r5));     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
    }

    public final boolean c() {
        int r5 = DownloadSetting.f.a("clean_interval_d", 0);
        if (r5 <= 0) goto L13;
        long r10 = a("key_clean_time");
        if (r10 > 0) goto L8;
    L12:
        a("key_clean_time", System.currentTimeMillis());
        goto L13
    L8:
        if ((System.currentTimeMillis() - r10) >= (((long) r5) * AppUtil.MILLIS_IN_DAYS)) goto L12;
        if (Logger.b() == false) goto L21;
        Logger.b("CleanerConfig", "start", "It has already been clean, lastCleanTime:" + r10);
    L21:
        return false;
    L13:
        HashSet r11 = this.g;
        monitor-enter(r11);
        boolean r12 = this.g.isEmpty();     // Catch: Throwable -> L24
        monitor-exit(r11);     // Catch: Throwable -> L24
        if (r12 == true) goto L19;
        return true;
    L19:
        if (DirectoryCleaner.e == false) goto L21;
        return true;
    L24:
        th = move-exception;
        throw th;
    }

    public final void a(int r5, DownloadInfo r10, boolean r11) {
        List r12 = (List) this.f15227c.get(Integer.valueOf(r5));
        if (r12 != null) goto L5;
        r12 = new ArrayList();
    L5:
        r12.add(Integer.valueOf(r10.l()));
        int r13 = r10.l();
        if (this.f15232l == true) goto L14;
        if (r13 == 0) goto L14;
        HashSet r14 = this.g;
        monitor-enter(r14);
        this.g.add(Integer.valueOf(r13));     // Catch: Throwable -> L24
        monitor-exit(r14);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L14:
        this.f15227c.put(Integer.valueOf(r5), r12);
        if (TextUtils.isEmpty(r10.e) == false) goto L17;
    L21:
        if (r11 == false) goto L29;
        this.f15231k.add(Integer.valueOf(r10.l()));
        return;
    L29:
        return;
    L17:
        if (TextUtils.isEmpty(r10.f15808b) == true) goto L21;
        this.f15228h.put(Integer.valueOf(r10.l()), r10.e);
        this.f15229i.put(Integer.valueOf(r10.l()), r10.f15808b);
        if (TextUtils.isEmpty(r10.q()) == true) goto L21;
        this.f15230j.put(Integer.valueOf(r10.l()), r10.q());
        goto L21
    }

    public final void b(JSONObject r10) {
        if (r10 == null) goto L40;
        this.e = r10.optInt("check_expired_time_d");
        if (this.e <= 0) goto L41;
        this.e = (int) (((long) this.e) * AppUtil.MILLIS_IN_DAYS);
        this.f = System.currentTimeMillis();
        int r5 = r10.optInt("check_expired_interval_d");
        if (r5 <= 0) goto L15;
        int r11 = (int) (((long) r5) + AppUtil.MILLIS_IN_DAYS);
        long r12 = a("key_download_cache_last_expired_clean_time");
        if (r12 > 0) goto L12;
    L14:
        a("key_download_cache_last_expired_clean_time", this.f);
        goto L15
    L12:
        if ((this.f - r12) > r11) goto L14;
        return;
    L15:
        JSONArray r13 = r10.optJSONArray("expired_save_path");
        if (r13 != null) goto L18;
        return;
    L18:
        if (r13.length() <= 0) goto L43;
        int r14 = 0;
    L22:
        if (r14 >= r13.length()) goto L44;
        String r15 = r13.optString(r14);
        File r16 = a(r15, this.f15233m);
        if (r16 != null) goto L26;
    L28:
        File r17 = b(r15, this.f15233m);
        if (r17 == null) goto L33;
        if (r17.isDirectory() == false) goto L33;
        this.d.add(r17.getAbsolutePath());
    L33:
        r14 = r14 + 1;
        goto L22
    L26:
        if (r16.isDirectory() == false) goto L28;
        this.d.add(r16.getAbsolutePath());
        goto L33
    L44:
        return;
    L43:
        return;
    L41:
        return;
    }

    public final void c(int r11) {
        if (Logger.b() == false) goto L6;
        Logger.b("CleanerConfig", "updateCleanSetting", "Run:" + r11);
    L6:
        if (this.f15225a.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.f15225a.get(Integer.valueOf(r11)) != null) goto L10;
        return;
    L10:
        if (((CleanItem) this.f15225a.get(Integer.valueOf(r11))).f15234a == true) goto L62;
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L21
        JSONArray r10 = new JSONArray();     // Catch: Throwable -> L21
        Iterator r12 = this.f15225a.entrySet().iterator();     // Catch: Throwable -> L21
    L14:
        if (r12.hasNext() == false) goto L40;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L21
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L21
        r14.put("clean_id", r13.getKey());     // Catch: Throwable -> L21
        CleanItem r15 = (CleanItem) r13.getValue();     // Catch: Throwable -> L21
        if (r15.f15234a == false) goto L18;
    L23:
        boolean r16 = true;
    L24:
        r15.f15234a = r16;     // Catch: Throwable -> L21
        r14.put("key_clean_finish", r16);     // Catch: Throwable -> L21
        if (r15.f15234a == true) goto L26;
        JSONArray r17 = new JSONArray();     // Catch: Throwable -> L21
        Iterator r18 = r15.f15235b.iterator();     // Catch: Throwable -> L21
    L29:
        if (r18.hasNext() == false) goto L31;
        r17.put((String) r18.next());     // Catch: Throwable -> L21
        goto L29
    L31:
        r14.put("monitor_scene_list", r17);     // Catch: Throwable -> L21
        JSONArray r19 = new JSONArray();     // Catch: Throwable -> L21
        Iterator r20 = r15.f15236c.iterator();     // Catch: Throwable -> L21
    L33:
        if (r20.hasNext() == false) goto L35;
        r19.put((String) r20.next());     // Catch: Throwable -> L21
        goto L33
    L35:
        r14.put("url_prefix_list", r19);     // Catch: Throwable -> L21
        JSONArray r21 = new JSONArray();     // Catch: Throwable -> L21
        Iterator r22 = r15.d.iterator();     // Catch: Throwable -> L21
    L37:
        if (r22.hasNext() == false) goto L39;
        r21.put((String) r22.next());     // Catch: Throwable -> L21
        goto L37
    L39:
        r14.put("save_path_list", r21);     // Catch: Throwable -> L21
        r10.put(r14);     // Catch: Throwable -> L21
        goto L14
    L26:
        r10.put(r14);     // Catch: Throwable -> L21
        goto L14
    L18:
        if (((Integer) r13.getKey()).intValue() == r11) goto L23;
        r16 = false;
        goto L24
    L40:
        r5.put("clean_group", r10);     // Catch: Throwable -> L21
        b().edit().putString("key_download_cache_clean_strategy", r5.toString()).apply();     // Catch: Throwable -> L43
    L63:
        return;
    L43:
        th = move-exception;
        Logger.c("CleanerConfig", "putString", "Error:" + th);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        Logger.c("CleanerConfig", "updateCleanSetting", "Error:" + th);
        return;
    }

    public static File b(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        int r11 = r10.length();
        if (r5.length() > r11) goto L9;
        return null;
    L9:
        monitor-enter(DownloadComponentManager.class);
        Context r12 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L22
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L22
        File r13 = DownloadDirUtils.c(r12, false);
        if (r13 != null) goto L15;
        return null;
    L15:
        String r14 = r13.getParent();
        if (r5.startsWith(r10) == true) goto L18;
    L21:
        return null;
    L18:
        if (TextUtils.isEmpty(r14) == true) goto L21;
        return new File(r14, r5.substring(r11));
    L22:
        th = move-exception;
        throw th;
    }

    public final void a(JSONObject r12) {
        if (Logger.b() == false) goto L5;
        Logger.b("CleanerConfig", "parseCleanSetting", "Run");
    L5:
        if (r12 == null) goto L82;
        JSONArray r13 = r12.optJSONArray("clean_group");
        if (r13 != null) goto L10;
        return;
    L10:
        if (r13.length() <= 0) goto L83;
        int r5 = 0;
    L14:
        if (r5 >= r13.length()) goto L63;
        JSONObject r10 = r13.getJSONObject(r5);
        int r11 = r10.optInt("clean_id");
        if (this.f15225a.containsKey(Integer.valueOf(r11)) == true) goto L61;
        CleanItem r14 = new CleanItem();
        boolean r15 = r10.optBoolean("key_clean_finish");
        r14.f15234a = r15;
        if (r15 == false) goto L21;
        this.f15225a.put(Integer.valueOf(r11), r14);
        this.f15227c.put(Integer.valueOf(r11), new ArrayList());
        goto L61
    L21:
        JSONArray r16 = r10.optJSONArray("monitor_scene_list");
        if (r16 != null) goto L24;
    L32:
        JSONArray r17 = r10.optJSONArray("url_prefix_list");
        if (r17 != null) goto L35;
    L43:
        JSONArray r18 = r10.optJSONArray("save_path_list");
        if (r18 == null) goto L55;
        if (r18.length() <= 0) goto L55;
        int r19 = 0;
    L49:
        if (r19 >= r18.length()) goto L55;
        String r20 = r18.optString(r19);
        if (TextUtils.isEmpty(r20) == true) goto L53;
        r14.d.add(r20);
    L53:
        r19 = r19 + 1;
    L55:
        if (r14.f15235b.isEmpty() == true) goto L57;
    L60:
        this.f15225a.put(Integer.valueOf(r11), r14);
        this.f15227c.put(Integer.valueOf(r11), new ArrayList());
        goto L61
    L57:
        if (r14.f15236c.isEmpty() == false) goto L60;
        if (r14.d.isEmpty() == true) goto L61;
    L35:
        if (r17.length() <= 0) goto L43;
        int r21 = 0;
    L38:
        if (r21 >= r17.length()) goto L43;
        String r22 = r17.optString(r21);
        if (TextUtils.isEmpty(r22) == true) goto L42;
        r14.f15236c.add(r22);
    L42:
        r21 = r21 + 1;
        goto L38
    L24:
        if (r16.length() <= 0) goto L32;
        int r23 = 0;
    L27:
        if (r23 >= r16.length()) goto L32;
        String r24 = r16.optString(r23);
        if (TextUtils.isEmpty(r24) == true) goto L31;
        r14.f15235b.add(r24);
    L31:
        r23 = r23 + 1;
    L61:
        r5 = r5 + 1;
        goto L14
    L63:
        if (Logger.b() == false) goto L81;
        Logger.b("CleanerConfig", "parseCleanSetting", "Result: " + this.f15225a);
        return;
    L81:
        return;
    L83:
        return;
    }

    public static SharedPreferences b() {
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L8
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L8
        return r5.getSharedPreferences("sp_download_cache", 0);
    L8:
        th = move-exception;
        throw th;
    }

    public static File a(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L27:
        return null;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L27;
        String r11 = d.b("Android/data/", r10);
        int r12 = r11.length();
        if (r5.length() > r12) goto L11;
        return null;
    L11:
        monitor-enter(DownloadComponentManager.class);
        Context r13 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L24
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L24
        File r14 = DownloadDirUtils.a(r13, false);
        if (r14 != null) goto L17;
        return null;
    L17:
        String r15 = r14.getParent();
        if (r5.startsWith(r11) == true) goto L20;
    L23:
        return null;
    L20:
        if (TextUtils.isEmpty(r15) == true) goto L23;
        return new File(r15, r5.substring(r12));
    L24:
        th = move-exception;
        throw th;
    }

    public static long a(String r5) {
        return b().getLong(r5, 0);
    L5:
        th = move-exception;
        c.e("Error:", th, "CleanerConfig", "getLong");
        return 0;
    }

    public static void a(String r5, long r10) {
        b().edit().putLong(r5, r10).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c.e("Error:", th, "CleanerConfig", "putLong");
    }

    public final void a() {
        this.f15232l = true;
        this.f15225a.clear();
        this.f15226b.clear();
        this.f15227c.clear();
        this.f15228h.clear();
        this.f15229i.clear();
        this.f15230j.clear();
        this.f15231k.clear();
        this.d.clear();
        HashSet r5 = this.g;
        monitor-enter(r5);
        this.g.clear();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
