package com.ss.android.socialbase.downloader.setting;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import td.c;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadSetting {
    public static final LruCache e = null;
    public static final DownloadSetting f = null;
    public static final JSONObject g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final JSONObject f16103h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final JSONObject f16104i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Boolean f16105j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f16106k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static DownloadSetting f16107l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f16108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f16109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f16110c;
    public int d;

    static {
        e = new LruCache(16, 16);
        Boolean r5 = null;
        f = new DownloadSetting(null);
        JSONObject r10 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c();
        boolean r11 = false;
        if (r10.optInt("disable_task_setting", 0) != 1) goto L5;
        boolean r12 = true;
    L6:
        f16106k = r12;
        f16103h = r10.optJSONObject("disabled_task_keys");
        g = r10.optJSONObject("global_task_setting");
        JSONObject r13 = r10.optJSONObject("bugfix");
        if (r13 != null) goto L9;
    L14:
        f16104i = r13;
        f16105j = r5;
        if (Logger.b() == false) goto L18;
        Logger.b("DownloadSetting", "init", "SettingUpdate:" + r10.toString());
        return;
    L18:
        return;
    L9:
        if (r13.has("default") == false) goto L14;
        if (r13.optInt("default", 0) != 1) goto L13;
        r11 = true;
    L13:
        r5 = Boolean.valueOf(r11);
        goto L14
    L5:
        r12 = false;
        goto L6
    }

    public DownloadSetting(JSONObject r5) {
        this.f16108a = r5;
        JSONObject r10 = null;
        Boolean r11 = null;
        r11 = null;
        r11 = null;
        if (r5 != null) goto L5;
    L17:
        Boolean r12 = null;
    L18:
        this.f16109b = r10;
        this.f16110c = r12;
        return;
    L5:
        if (a("bugfix") == true) goto L17;
        JSONObject r13 = r5.optJSONObject("bugfix");
        if (r13 != null) goto L9;
    L16:
        Boolean r14 = r11;
        r10 = r13;
        r12 = r14;
        goto L18
    L9:
        if (r13.has("default") == false) goto L16;
        if (a("default") == true) goto L16;
        boolean r15 = false;
        if (r13.optInt("default", 0) != 1) goto L15;
        r15 = true;
    L15:
        r11 = Boolean.valueOf(r15);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static DownloadSetting a(int r5, DownloadInfo r10) {
        DownloadSetting r11 = f16107l;
        if (r11 != null) goto L5;
    L7:
        LruCache r12 = e;
        monitor-enter(r12);
        DownloadSetting r13 = (DownloadSetting) r12.get(Integer.valueOf(r5));     // Catch: Throwable -> L33
        monitor-exit(r12);     // Catch: Throwable -> L33
        if (r13 != null) goto L31;
        if (r10 == null) goto L14;
        DownloadSetting r14 = a(r10);
    L22:
        r13 = r14;
        monitor-enter(r12);
        r12.put(Integer.valueOf(r5), r13);     // Catch: Throwable -> L28
        monitor-exit(r12);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L14:
        if (f16106k == false) goto L17;
        r14 = f;
        goto L22
    L17:
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e() == null) goto L21;
        DownloadInfo r15 = ((IDownloadProcessDispatcherService) DownloadServiceManager.a(IDownloadProcessDispatcherService.class)).a(r5);
        if (r15 == null) goto L21;
        r14 = a(r15);
    L21:
        r14 = f;
    L31:
        r13.d = r5;
        f16107l = r13;
        return r13;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (r11.d != r5) goto L7;
        return r11;
    }

    public final boolean b(String r5) {
        if (this.f16109b != null) goto L5;
    L16:
        JSONObject r10 = f16104i;
        if (r10 != null) goto L19;
    L28:
        return false;
    L19:
        if (r10.has(r5) == true) goto L21;
        Boolean r11 = f16105j;
        if (r11 == null) goto L28;
        return r11.booleanValue();
    L21:
        if (r10.optInt(r5, 0) != 1) goto L23;
        return true;
    L23:
        return false;
    L5:
        if (a(r5) == true) goto L16;
        if (this.f16109b.has(r5) == true) goto L9;
        Boolean r12 = this.f16110c;
        if (r12 == null) goto L16;
        return r12.booleanValue();
    L9:
        if (this.f16109b.optInt(r5, 0) != 1) goto L11;
        return true;
    L11:
        return false;
    }

    public final JSONArray c(String r5) {
        JSONObject r10 = this.f16108a;
        if (r10 == null) goto L11;
        if (r10.has(r5) == false) goto L11;
        if (a(r5) == true) goto L11;
        return this.f16108a.optJSONArray(r5);
    L11:
        return ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optJSONArray(r5);
    }

    public final JSONObject d(String r5) {
        JSONObject r10 = this.f16108a;
        if (r10 == null) goto L11;
        if (r10.has(r5) == false) goto L11;
        if (a(r5) == true) goto L11;
        return this.f16108a.optJSONObject(r5);
    L11:
        return ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optJSONObject(r5);
    }

    public final String toString() {
        return "DownloadSetting{mTaskSetting=" + this.f16108a + ", mBugFixSetting=" + this.f16109b + ", mBugFixDefault=" + this.f16110c + ", mDownloadId=" + this.d + ", globalSetting=" + ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c() + '}';
    L5:
        th = move-exception;
        c.e("Error:", th, "DownloadSetting", "toString");
        return "DownloadSetting Error";
    }

    public final int a(String r5, int r10) {
        JSONObject r11 = this.f16108a;
        if (r11 == null) goto L11;
        if (r11.has(r5) == false) goto L11;
        if (a(r5) == true) goto L11;
        return this.f16108a.optInt(r5, r10);
    L11:
        return ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt(r5, r10);
    }

    public final long a(String r5, long r10) {
        JSONObject r11 = this.f16108a;
        if (r11 == null) goto L11;
        if (r11.has(r5) == false) goto L11;
        if (a(r5) == true) goto L11;
        return this.f16108a.optLong(r5, r10);
    L11:
        return ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optLong(r5, r10);
    }

    public final String a() {
        JSONObject r5 = this.f16108a;
        if (r5 == null) goto L11;
        if (r5.has("setting_tag") == false) goto L11;
        if (a("setting_tag") == true) goto L11;
        return this.f16108a.optString("setting_tag", "");
    L11:
        return ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optString("setting_tag", "");
    }

    public static boolean a(String r5) {
        JSONObject r10 = f16103h;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.optInt(r5, 0) != 1) goto L7;
        return true;
    }

    public static void a(int r5) {
        DownloadSetting r10 = f16107l;
        if (r10 != null) goto L5;
    L7:
        LruCache r11 = e;
        monitor-enter(r11);
        r11.remove(Integer.valueOf(r5));     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r10.d != r5) goto L7;
        f16107l = null;
        goto L7
    }

    public static DownloadSetting a(DownloadInfo r5) {
        if (f16106k == true) goto L5;
        r5.d();     // Catch: Throwable -> L9
        String r10 = r5.T0.optString("download_setting");     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r10) == true) goto L11;
        JSONObject r11 = new JSONObject(r10);     // Catch: Throwable -> L9
    L12:
        JSONObject r12 = a(r11, r5.P);     // Catch: Throwable -> L9
        if (r12 == null) goto L18;
        return new DownloadSetting(r12);
    L18:
        return f;
    L11:
        r11 = null;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L18
    L5:
        return f;
    }

    public static JSONObject a(JSONObject r5, String r10) {
        JSONObject r11 = g;     // Catch: Throwable -> L10
        if (r11 != null) goto L6;
    L12:
        JSONObject r12 = null;
    L13:
        if (r5 == null) goto L20;
        if (r12 == null) goto L20;
        Iterator<String> r13 = r12.keys();     // Catch: Throwable -> L10
    L16:
        if (r13.hasNext() == false) goto L20;
        String r14 = r13.next();     // Catch: Throwable -> L10
        r5.put(r14, r12.get(r14));     // Catch: Throwable -> L10
    L20:
        if (r5 == null) goto L22;
        return r5;
    L22:
        if (r12 == null) goto L25;
        return r12;
    L25:
        return null;
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L12;
        if (r11.has(r10) == false) goto L12;
        r12 = r11.optJSONObject(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.c("DownloadSetting", "mergeGlobalTaskSetting", "Error:" + th + " " + r10);
        goto L25
    }
}
