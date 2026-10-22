package qa;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class v3 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static v3 f11163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f11164i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, Long> f11165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f11166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f11168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f11170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11171g;

    public v3(Context r8) {
        this.f11165a = new LinkedHashMap();
        this.f11167c = null;
        this.f11170f = "";
        this.f11171g = null;
        Context r10 = r8.getApplicationContext();
        this.f11168d = r10;
        String r11 = r10.getFilesDir().getPath();
        this.f11167c = y3.E(r10);
        this.f11166b = new File(r11, "reportRecorder");     // Catch: Throwable -> L32
    L4:
        monitor-enter(this);
        LinkedHashMap<String, Long> r12 = this.f11165a;     // Catch: Throwable -> L29
        if (r12 != null) goto L8;
    L35:
        this.f11170f = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));     // Catch: Throwable -> L25
        Iterator r13 = y3.f(this.f11166b).iterator();     // Catch: Throwable -> L25
    L11:
        if (r13.hasNext() == false) goto L27;
        byte[] r14 = l4.e((String) r13.next());     // Catch: Throwable -> L20 UnsupportedEncodingException -> L22
        String[] r15 = new String(h3.e(this.f11167c, r14), "UTF-8").split(",");     // Catch: Throwable -> L20 UnsupportedEncodingException -> L22
        if (r15 == null) goto L11;
        if (r15.length <= 1) goto L11;
        this.f11165a.put(r15[0], Long.valueOf(Long.parseLong(r15[1])));     // Catch: Throwable -> L20 UnsupportedEncodingException -> L22
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L25
    L27:
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L29
        goto L27
    L8:
        if (r12.size() <= 0) goto L35;
    L29:
        th = move-exception;
        throw th;
    }

    public static synchronized v3 a(Context r8) {
        monitor-enter(v3.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f11163h != null) goto L7;
        f11163h = new v3(r8);     // Catch: Throwable -> L10
    L7:
        v3 r10 = f11163h;     // Catch: Throwable -> L10
        monitor-exit(v3.class);
        return r10;
    }

    public final synchronized void b(AMapLocation r8) {
        monitor-enter(this);
    L48:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L61
        return;
    L61:
        th = move-exception;
        throw th;
    L4:
        if (this.f11165a.containsKey(this.f11170f) == true) goto L8;
        if (this.f11165a.size() < 8) goto L8;
    L11:
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L48
        Iterator<Map.Entry<String, Long>> r11 = this.f11165a.entrySet().iterator();     // Catch: Throwable -> L48
    L13:
        if (r11.hasNext() == false) goto L21;
        r10.add(r11.next().getKey());     // Catch: Throwable -> L19
    L17:
        if (r10.size() != (this.f11165a.size() - 7)) goto L13;
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L48
    L21:
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L48
    L23:
        if (r12.hasNext() == false) goto L26;
        this.f11165a.remove((String) r12.next());     // Catch: Throwable -> L48
    L26:
        if (r8.f3646w == 0) goto L29;
        monitor-exit(this);
        return;
    L29:
        int r13 = r8.f3649z;     // Catch: Throwable -> L48
        if (r13 != 6) goto L32;
    L56:
        monitor-exit(this);
        return;
    L32:
        if (r13 == 5) goto L56;
        if (this.f11165a.containsKey(this.f11170f) == false) goto L37;
        long r14 = this.f11165a.get(this.f11170f).longValue() + 1;     // Catch: Throwable -> L48
        f11164i = r14;     // Catch: Throwable -> L48
        this.f11165a.put(this.f11170f, Long.valueOf(r14));     // Catch: Throwable -> L48
    L38:
        long r15 = f11164i;     // Catch: Throwable -> L48
        if (r15 != 0) goto L41;
    L53:
        this.f11169e = true;     // Catch: Throwable -> L48
        monitor-exit(this);
        return;
    L41:
        if ((r15 % 100) != 0) goto L53;
        monitor-enter(this);     // Catch: Throwable -> L48
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L44:
        if (this.f11169e == false) goto L46;
        e();     // Catch: Throwable -> L50
        this.f11169e = false;     // Catch: Throwable -> L50
    L46:
        monitor-exit(this);     // Catch: Throwable -> L48
        goto L53
    L37:
        this.f11165a.put(this.f11170f, 1L);     // Catch: Throwable -> L48
        f11164i = 1;     // Catch: Throwable -> L48
    L8:
        if (this.f11165a.containsKey(this.f11170f) == false) goto L26;
        if (this.f11165a.size() < 9) goto L26;
        goto L11
    }

    public final synchronized void c() {
        monitor-enter(this);
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    L4:
        if (d(this.f11168d) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<Map.Entry<String, Long>> r8 = this.f11165a.entrySet().iterator();     // Catch: Throwable -> L21
    L8:
        if (r8.hasNext() == false) goto L19;
        Map.Entry<String, Long> r10 = r8.next();     // Catch: Throwable -> L21
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L8
    L12:
        if (this.f11170f.equals(r10.getKey()) == true) goto L8;
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L16
        r11.put("param_long_first", r10.getKey());     // Catch: Throwable -> L16
        r11.put("param_long_second", r10.getValue());     // Catch: Throwable -> L16
        w3.j(this.f11168d, "O023", r11);     // Catch: Throwable -> L16
    L19:
        monitor-exit(this);
    }

    public final boolean d(Context r8) {
        if (this.f11171g != null) goto L6;
        this.f11171g = x3.d(r8, "pref", "lastavedate", "0");
    L6:
        if (this.f11171g.equals(this.f11170f) == false) goto L8;
        return false;
    L8:
        SharedPreferences.Editor r10 = r8.getSharedPreferences("pref", 0).edit();
        x3.h(r10, "lastavedate", this.f11170f);
        x3.e(r10);
        this.f11171g = this.f11170f;
        return true;
    }

    public final void e() {
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L14
        Iterator<Map.Entry<String, Long>> r10 = this.f11165a.entrySet().iterator();     // Catch: Throwable -> L14
    L4:
        if (r10.hasNext() == false) goto L10;
        Map.Entry<String, Long> r11 = r10.next();     // Catch: Throwable -> L14
        String r12 = r11.getKey() + "," + r11.getValue();     // Catch: UnsupportedEncodingException -> L8 Throwable -> L14
        StringBuilder r13 = new StringBuilder();     // Catch: UnsupportedEncodingException -> L8 Throwable -> L14
        r13.append(l4.d(h3.b(this.f11167c, r12.getBytes("UTF-8"))));     // Catch: UnsupportedEncodingException -> L8 Throwable -> L14
        r13.append("\n");     // Catch: UnsupportedEncodingException -> L8 Throwable -> L14
        r8.append(r13.toString());     // Catch: UnsupportedEncodingException -> L8 Throwable -> L14
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L4
    L10:
        String r14 = r8.toString();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r14) == true) goto L25;
        y3.g(this.f11166b, r14);     // Catch: Throwable -> L14
        return;
    L25:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
    }
}
