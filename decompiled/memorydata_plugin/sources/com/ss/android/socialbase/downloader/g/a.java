package com.ss.android.socialbase.downloader.g;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.k;
import com.ss.android.socialbase.downloader.service.l;
import com.ss.android.socialbase.downloader.service.t;
import com.ss.android.socialbase.downloader.utils.LruCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LruCache<Integer, a> f15445a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f15446b = null;
    private static JSONObject c;
    private static JSONObject d;
    private static Boolean e;
    private static boolean f;
    private static a g;
    private final JSONObject h;
    private final JSONObject i;
    private final Boolean j;
    private int k;

    static {
        f15445a = new LruCache(16, 16);
        f15446b = new a(null);
        a();
    }

    private a(JSONObject r5) {
        this.h = r5;
        JSONObject r0 = null;
        Boolean r1 = null;
        r1 = null;
        r1 = null;
        if (r5 != null) goto L5;
    L17:
        Boolean r6 = null;
    L18:
        this.i = r0;
        this.j = r6;
        return;
    L5:
        if (g("bugfix") == true) goto L17;
        JSONObject r7 = r5.optJSONObject("bugfix");
        if (r7 != null) goto L9;
    L16:
        Boolean r3 = r1;
        r0 = r7;
        r6 = r3;
        goto L18
    L9:
        if (r7.has("default") == false) goto L16;
        if (g("default") == true) goto L16;
        boolean r2 = false;
        if (r7.optInt("default", 0) != 1) goto L15;
        r2 = true;
    L15:
        r1 = Boolean.valueOf(r2);
        goto L16
    }

    public static a a(int r1) {
        return a(r1, null);
    }

    private static a a(int r4, DownloadInfo r5) {
        a r0 = g;
        if (r0 != null) goto L5;
    L7:
        LruCache<Integer, a> r1 = f15445a;
        monitor-enter(r1);
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r4)), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        if (r2 != null) goto L23;
        if (r5 != null) goto L14;
        a r6 = c(r4);
    L15:
        r2 = r6;
        monitor-enter(r1);
        r1.put(Integer.valueOf(r4), r2);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L14:
        r6 = b(r5);
    L23:
        r2.k = r4;
        g = r2;
        return r2;
    L25:
        th = move-exception;
        throw th;
    L5:
        if (r0.k != r4) goto L7;
        return r0;
    }

    public static a a(DownloadInfo r1) {
        if (r1 != null) goto L6;
        return f15446b;
    L6:
        return a(r1.getId(), r1);
    }

    public static void a() {
        JSONObject r0 = ((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).b();
        boolean r2 = false;
        if (r0.optInt("disable_task_setting", 0) != 1) goto L5;
        boolean r1 = true;
    L6:
        f = r1;
        c = r0.optJSONObject("disabled_task_keys");
        JSONObject r3 = r0.optJSONObject("bugfix");
        Boolean r4 = null;
        if (r3 != null) goto L9;
    L14:
        d = r3;
        e = r4;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L22;
        StringBuilder r5 = new StringBuilder().append("SettingUpdate:");
        if (r0 == null) goto L19;
        String r6 = r0.toString();
    L20:
        com.ss.android.socialbase.downloader.e.a.a("DownloadSetting", CommonConsts.APM_INNER_EVENT_COST_INIT, r5.append(r6).toString());
        return;
    L19:
        r6 = "Empty";
        goto L20
    L22:
        return;
    L9:
        if (r3.has("default") == false) goto L14;
        if (r3.optInt("default", 0) != 1) goto L13;
        r2 = true;
    L13:
        r4 = Boolean.valueOf(r2);
        goto L14
    L5:
        r1 = false;
        goto L6
    }

    public static void a(int r6, JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7 != b()) goto L6;
        return;
    L6:
        if (f == true) goto L37;
        LruCache<Integer, a> r0 = f15445a;
        monitor-enter(r0);
        a r1 = g;     // Catch: Throwable -> L27
        if (r1 != null) goto L13;
    L15:
        r1 = null;
        Iterator<a> r2 = r0.values().iterator();     // Catch: Throwable -> L27
    L17:
        if (r2.hasNext() == false) goto L21;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r3.h != r7) goto L17;
        r3.k = r6;     // Catch: Throwable -> L27
        r1 = r3;
    L21:
        if (r1 != null) goto L23;
        r1 = new a(r7);     // Catch: Throwable -> L27
        r1.k = r6;     // Catch: Throwable -> L27
    L23:
        g = r1;     // Catch: Throwable -> L27
    L24:
        f15445a.put(Integer.valueOf(r6), r1);     // Catch: Throwable -> L27
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L13:
        if (r1.h != r7) goto L15;
        r1.k = r6;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private static a b(DownloadInfo r1) {
        if (f == true) goto L5;
        String r2 = r1.getDownloadSettingString();     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r2) == true) goto L13;
        return new a(new JSONObject(r2));
    L13:
        return f15446b;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L13
    L5:
        return f15446b;
    }

    public static JSONObject b() {
        return ((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).b();
    }

    public static void b(int r1) {
        a r0 = g;
        if (r0 != null) goto L5;
    L7:
        LruCache<Integer, a> r2 = f15445a;
        monitor-enter(r2);
        r2.remove(Integer.valueOf(r1));     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r0.k != r1) goto L7;
        g = null;
        goto L7
    }

    public static a c() {
        return f15446b;
    }

    private static a c(int r3) {
        if (f == false) goto L7;
        return f15446b;
    L7:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L13;
        DownloadInfo r4 = ((t) ZeusTransformUtils.preCheckCast(k.a(t.class), t.class, "com.obric.memorydata.plugin")).h(r3);
        if (r4 == null) goto L13;
        return b(r4);
    L13:
        return f15446b;
    }

    public static boolean g(String r2) {
        JSONObject r0 = c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.optInt(r2, 0) != 1) goto L7;
        return true;
    }

    public double a(String r2, double r3) {
        JSONObject r0 = this.h;
        if (r0 != null) goto L5;
    L11:
        JSONObject r1 = b();
    L10:
        return r1.optDouble(r2, r3);
    L5:
        if (r0.has(r2) == false) goto L11;
        if (g(r2) == true) goto L11;
        r1 = this.h;
        goto L10
    }

    public int a(String r2, int r3) {
        JSONObject r0 = this.h;
        if (r0 != null) goto L5;
    L11:
        JSONObject r1 = b();
    L10:
        return r1.optInt(r2, r3);
    L5:
        if (r0.has(r2) == false) goto L11;
        if (g(r2) == true) goto L11;
        r1 = this.h;
        goto L10
    }

    public long a(String r2, long r3) {
        JSONObject r0 = this.h;
        if (r0 != null) goto L5;
    L11:
        JSONObject r1 = b();
    L10:
        return r1.optLong(r2, r3);
    L5:
        if (r0.has(r2) == false) goto L11;
        if (g(r2) == true) goto L11;
        r1 = this.h;
        goto L10
    }

    public String a(String r2, String r3) {
        JSONObject r0 = this.h;
        if (r0 != null) goto L5;
    L11:
        JSONObject r1 = b();
    L10:
        return r1.optString(r2, r3);
    L5:
        if (r0.has(r2) == false) goto L11;
        if (g(r2) == true) goto L11;
        r1 = this.h;
        goto L10
    }

    public boolean a(String r2) {
        return a(r2, false);
    }

    public boolean a(String r4, boolean r5) {
        if (this.i != null) goto L5;
    L16:
        JSONObject r3 = d;
        if (r3 != null) goto L19;
    L28:
        return r5;
    L19:
        if (r3.has(r4) == true) goto L21;
        Boolean r6 = e;
        if (r6 == null) goto L28;
        return r6.booleanValue();
    L21:
        if (d.optInt(r4, r5 ? 1 : 0) == 1) goto L23;
        return false;
    L23:
        return true;
    L5:
        if (g(r4) == true) goto L16;
        if (this.i.has(r4) == true) goto L9;
        Boolean r7 = this.j;
        if (r7 == null) goto L16;
        return r7.booleanValue();
    L9:
        if (this.i.optInt(r4, r5 ? 1 : 0) == 1) goto L11;
        return false;
    L11:
        return true;
    }

    public int b(String r2) {
        return a(r2, 0);
    }

    public long c(String r3) {
        return a(r3, 0);
    }

    public String d(String r2) {
        return a(r2, "");
    }

    public JSONObject e(String r2) {
        JSONObject r0 = this.h;
        if (r0 != null) goto L5;
    L11:
        JSONObject r1 = b();
    L10:
        return r1.optJSONObject(r2);
    L5:
        if (r0.has(r2) == false) goto L11;
        if (g(r2) == true) goto L11;
        r1 = this.h;
        goto L10
    }

    public JSONArray f(String r2) {
        JSONObject r0 = this.h;
        if (r0 != null) goto L5;
    L11:
        JSONObject r1 = b();
    L10:
        return r1.optJSONArray(r2);
    L5:
        if (r0.has(r2) == false) goto L11;
        if (g(r2) == true) goto L11;
        r1 = this.h;
        goto L10
    }

    public String toString() {
        return "DownloadSetting{mTaskSetting=" + this.h + ", mBugFixSetting=" + this.i + ", mBugFixDefault=" + this.j + ", mDownloadId=" + this.k + ", globalSetting=" + b() + '}';
    }
}
