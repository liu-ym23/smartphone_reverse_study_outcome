package h4;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.news.common.settings.internal.c;
import f4.f;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile a f9161f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f9162g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f9163h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile long f9164i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile long f9165j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static ConcurrentHashMap f9166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static ConcurrentHashMap f9167l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static c f9168m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile f4.a f9169n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f9170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f9171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f9172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SharedPreferences f9173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SharedPreferences.Editor f9174e;

    static {
        f9166k = new ConcurrentHashMap();
        f9167l = new ConcurrentHashMap();
    }

    private a(Context r10) {
        this.f9171b = r10.getSharedPreferences("__ab_vid_info.sp", 0);
        this.f9173d = r10.getSharedPreferences("__ab_exposed_info.sp", 0);
        SharedPreferences r11 = r10.getSharedPreferences("__ab_local_exposed_info.sp", 0);
        this.f9172c = r11;
        r11.edit();
        this.f9174e = this.f9173d.edit();
        String r12 = this.f9171b.getString("key_vid_info", "");
        if (TextUtils.isEmpty(r12) == true) goto L11;
        this.f9170a = new JSONObject(r12);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static a a(Context r10) {
        if (f9161f != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9161f != null) goto L9;
        f9161f = new a(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f9161f;
    }

    public static long b() {
        if (f9164i >= 0) goto L5;
        f9164i = System.currentTimeMillis();
    L5:
        f9165j = System.currentTimeMillis() - f9164i;
        return f9165j;
    }

    public static boolean c() {
        return f9162g;
    }

    public static boolean e(String r10) {
        if (f9163h == true) goto L5;
        return false;
    L5:
        if (f9166k.containsKey(r10) == true) goto L10;
        f9166k.put(r10, "");
        return true;
    L10:
        return false;
    }

    public static void f(f4.a r10) {
        if (f9169n != null) goto L6;
        f9169n = r10;
        return;
    }

    public static void g(c r10) {
        f9168m = r10;
    }

    public static void h(long r10) {
        f9164i = r10;
    }

    public static void i(boolean r10) {
        f9163h = r10;
    }

    public static void j(boolean r10) {
        f9162g = r10;
    }

    public void d(String r10) {
        long r11 = System.currentTimeMillis();
        f9167l.put(r10, Long.valueOf(r11));
        if (f9169n == null) goto L12;
        if (f9169n.isDebug().booleanValue() == false) goto L12;
        c r12 = f9168m;
        if (r12 == null) goto L12;
        f r13 = r12.a();
        if (r13 == null) goto L12;
        r13.i("settings_auto_test", r10);
    L12:
        if (this.f9170a == null) goto L33;
        monitor-enter(this);
        JSONObject r14 = this.f9170a;     // Catch: Throwable -> L30
        if (r14 == null) goto L28;
        long r15 = r14.optLong(r10);     // Catch: Throwable -> L30
        if (r15 <= 0) goto L28;
        if (this.f9173d.contains(r10) == true) goto L36;
        this.f9174e.putString(r10, String.valueOf(r15)).apply();     // Catch: Throwable -> L30
        goto L28
    L36:
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L30
        goto L28
    L23:
        if (r15 == Long.parseLong(this.f9173d.getString(r10, NetConst.NOT_ENCRYPT_VERISON_CODE))) goto L28;
        this.f9174e.putString(r10, String.valueOf(r15)).apply();     // Catch: Exception -> L26 Throwable -> L30
    L28:
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    }

    public synchronized void k(@NonNull JSONObject r10) {
        monitor-enter(this);
        this.f9170a = r10;     // Catch: Throwable -> L19
        this.f9171b.edit().putString("key_vid_info", r10.toString()).apply();     // Catch: Throwable -> L19
        Iterator<String> r11 = this.f9173d.getAll().keySet().iterator();     // Catch: Throwable -> L19
    L5:
        if (r11.hasNext() == false) goto L16;
        String r12 = r11.next();     // Catch: Throwable -> L19
        if (this.f9170a.has(r12) == false) goto L8;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        goto L5
    L11:
        if (this.f9170a.optLong(r12) == Long.parseLong(this.f9173d.getString(r12, NetConst.NOT_ENCRYPT_VERISON_CODE))) goto L5;
        this.f9174e.remove(r12);     // Catch: Exception -> L14 Throwable -> L19
    L8:
        this.f9174e.remove(r12);     // Catch: Throwable -> L19
        goto L5
    L16:
        this.f9174e.apply();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
