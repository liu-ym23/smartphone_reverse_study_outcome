package com.ss.android.socialbase.downloader.cleaner;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.a;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CacheStatistics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f15213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15214b;

    public class CacheSize implements Comparable<CacheSize> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f15217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f15218c;
        public long d;
        public int e;

        public CacheSize() {
        }

        @Override // java.lang.Comparable
        public final int compareTo(CacheSize r5) {
            CacheSize r10 = r5;
            long r11 = this.f15217b + this.f15218c;
            long r12 = r10.f15217b + r10.f15218c;
            if (r11 != r12) goto L6;
            return 0;
        L6:
            if (r11 <= r12) goto L9;
            return -1;
        L9:
            return 1;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L5;
            return true;
        L5:
            if (r5 != null) goto L7;
            return false;
        L7:
            if (getClass() == r5.getClass()) goto L10;
            return false;
        L10:
            return Objects.equals(this.f15216a, ((CacheSize) r5).f15216a);
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{this.f15216a});
        }
    }

    public class DownloadDiskInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CacheSize f15219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TreeSet f15220b;

        public DownloadDiskInfo(CacheStatistics r5) {
            this.f15219a = new CacheSize();
            this.f15220b = new TreeSet();
        }
    }

    public CacheStatistics() {
        this.f15213a = new HashMap();
    }

    public static void a(CacheStatistics r16, CleanerConfig r17) {
        DownloadSetting r5 = DownloadSetting.f;
        int r10 = 0;
        r16.f15214b = r5.a("monitor_cache_top_count", 0);
        if (Logger.b() == false) goto L6;
        Logger.b("CleanerStatistics", "run", "TopCacheCount:" + r16.f15214b);
    L6:
        if (r16.f15214b > 0) goto L9;
        return;
    L9:
        monitor-enter(DownloadComponentManager.class);
        Context r11 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L60
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r11.getPackageName()) == true) goto L35;
        JSONArray r12 = r5.c("monitor_cache_path_list");
        if (r12 == null) goto L35;
        if (r12.length() <= 0) goto L35;
        int r13 = 0;
    L22:
        if (r13 >= r12.length()) goto L35;
        String r14 = r12.optString(r13);
        File r15 = CleanerConfig.a(r14, r17.f15233m);
        if (r15 != null) goto L26;
    L28:
        File r18 = CleanerConfig.b(r14, r17.f15233m);
        if (r18 == null) goto L33;
        if (r18.isDirectory() == false) goto L33;
        r16.a(r18);
    L33:
        r13 = r13 + 1;
        goto L22
    L26:
        if (r15.isDirectory() == false) goto L28;
        r16.a(r15);
    L35:
        if (r16.f15213a.isEmpty() == true) goto L79;
        JSONObject r19 = new JSONObject();
        Iterator r20 = r16.f15213a.entrySet().iterator();
    L39:
        if (r20.hasNext() == false) goto L56;
        Map.Entry r21 = (Map.Entry) r20.next();
        String r22 = (String) r21.getKey();
        Map r23 = (Map) r21.getValue();
        if (r23.isEmpty() == true) goto L39;
        JSONObject r24 = new JSONObject();
        Iterator r25 = r23.entrySet().iterator();
    L45:
        if (r25.hasNext() == false) goto L54;
        Map.Entry r26 = (Map.Entry) r25.next();
        String r27 = (String) r26.getKey();
        DownloadDiskInfo r28 = (DownloadDiskInfo) r26.getValue();
        JSONObject r29 = new JSONObject();
        JSONObject r110 = new JSONObject();
        r110.put("size", r28.f15219a.f15217b);
        r110.put("tpSize", r28.f15219a.f15218c);
        r110.put("duration", r28.f15219a.d);
        r110.put("count", r28.f15219a.e);
        r29.put("totalCache", r110);
        JSONArray r111 = new JSONArray();
        Iterator r30 = r28.f15220b.iterator();
        int r112 = r10;
    L48:
        if (r30.hasNext() == false) goto L53;
        CacheSize r113 = (CacheSize) r30.next();
        r112 = r112 + 1;
        if (r112 > r16.f15214b) goto L53;
        JSONObject r114 = new JSONObject();
        r114.put("size", r113.f15217b);
        r114.put("tpSize", r113.f15218c);
        r114.put("name", r113.f15216a);
        r114.put("duration", r113.d);
        r111.put(r114);
    L53:
        r29.put("topCache", r111);
        r24.put(r27, r29);
        r10 = 0;
        goto L45
    L54:
        r19.put(r22, r24);
        r10 = 0;
        goto L39
    L56:
        if (r19.length() > 0) goto L58;
        return;
    L58:
        Context r31 = DownloadComponentManager.f15515a;
        return;
    L79:
        return;
    L60:
        th = move-exception;
        throw th;
    }

    public final void a(File r10) {
        Map r5 = (Map) this.f15213a.get(r10.getAbsolutePath());
        if (r5 != null) goto L6;
        r5 = new HashMap();
        this.f15213a.put(r10.getAbsolutePath(), r5);
    L6:
        monitor-enter(DownloadComponentManager.class);
        Context r11 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L19
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L19
        List r12 = Downloader.b(r11).a(r10.getAbsolutePath() + "%");
        HashMap r13 = new HashMap();
        if (r12 != null) goto L12;
    L17:
        a(r10, r5, r13);
        return;
    L12:
        if (r12.isEmpty() == true) goto L17;
        Iterator r14 = r12.iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        DownloadInfo r15 = (DownloadInfo) r14.next();
        r13.put(new DownloadFile(r15.e, r15.f15808b, true).e(), r15);
    L19:
        th = move-exception;
        throw th;
    }

    public final void a(File r10, Map r11, HashMap r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.exists() == false) goto L46;
        int r5 = 0;
        if (r10.isFile() == false) goto L33;
        String r13 = r10.getAbsolutePath();
        if (TextUtils.isEmpty(r13) == false) goto L12;
        return;
    L12:
        if (r13.endsWith(".tp") == true) goto L14;
    L16:
        r5 = 1;
    L17:
        DownloadInfo r14 = (DownloadInfo) r12.get(r13);
        if (r14 != null) goto L20;
        String r15 = "NoMatchDB";
    L23:
        DownloadDiskInfo r16 = (DownloadDiskInfo) r11.get(r15);
        if (r16 != null) goto L26;
        r16 = new DownloadDiskInfo(this);
    L26:
        CacheSize r17 = new CacheSize();
        if (r5 == 0) goto L29;
        r17.f15217b = r10.length();
    L30:
        r17.d = System.currentTimeMillis() - r10.lastModified();
        r17.f15216a = r10.getName();
        r16.f15220b.add(r17);
        CacheSize r18 = r16.f15219a;
        r18.f15217b += r17.f15217b;
        r18.f15218c += r17.f15218c;
        r18.d += r17.d;
        r18.e++;
        r11.put(r15, r16);
        return;
    L29:
        r17.f15218c = r10.length();
        goto L30
    L20:
        r15 = r14.P;
        if (TextUtils.isEmpty(r15) == false) goto L23;
        r15 = "UNKNOWN";
        goto L23
    L14:
        if (r13.length() <= 3) goto L16;
        r13 = a.n(r13, 3, 0);
        goto L17
    L33:
        if (r10.isDirectory() == false) goto L48;
        File[] r19 = r10.listFiles();
        if (r19 != null) goto L38;
        return;
    L38:
        if (r19.length > 0) goto L41;
        return;
    L41:
        if (r5 >= r19.length) goto L50;
        a(r19[r5], r11, r12);
        r5 = r5 + 1;
        goto L41
    L50:
        return;
    L48:
        return;
    }
}
