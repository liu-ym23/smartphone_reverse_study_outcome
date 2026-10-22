package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.aivoice.core.data.NameKeys;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g4 {
    public static g4 h;
    public static long i;
    public final LinkedHashMap<String, Long> a;
    public final PolarisFileWrapper b;
    public final String c;
    public final Context d;
    public boolean e;
    public String f;
    public String g;

    public static synchronized g4 a(Context r2) {
        monitor-enter(g4.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (h != null) goto L7;
        h = new g4(r2);     // Catch: Throwable -> L10
    L7:
        g4 r3 = h;     // Catch: Throwable -> L10
        monitor-exit(g4.class);
        return r3;
    }

    public final synchronized void b() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.e == false) goto L6;
        f();     // Catch: Throwable -> L8
        this.e = false;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized void c(AMapLocation r7) {
        monitor-enter(this);
    L48:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L52
        return;
    L52:
        th = move-exception;
        throw th;
    L4:
        if (this.a.containsKey(this.f) == true) goto L8;
        if (this.a.size() < 8) goto L8;
    L11:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L48
        Iterator<Map.Entry<String, Long>> r1 = this.a.entrySet().iterator();     // Catch: Throwable -> L48
    L13:
        if (r1.hasNext() == false) goto L21;
        r0.add(r1.next().getKey());     // Catch: Throwable -> L19
    L17:
        if (r0.size() != (this.a.size() - 7)) goto L13;
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L48
    L21:
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L48
    L23:
        if (r2.hasNext() == false) goto L26;
        this.a.remove((String) r2.next());     // Catch: Throwable -> L48
    L26:
        if (r7.getErrorCode() == 0) goto L30;
        monitor-exit(this);
        return;
    L30:
        if (r7.getLocationType() != 6) goto L32;
    L46:
        monitor-exit(this);
        return;
    L32:
        if (r7.getLocationType() == 5) goto L46;
        if (this.a.containsKey(this.f) == false) goto L37;
        long r3 = this.a.get(this.f).longValue() + 1;     // Catch: Throwable -> L48
        i = r3;     // Catch: Throwable -> L48
        this.a.put(this.f, Long.valueOf(r3));     // Catch: Throwable -> L48
    L38:
        long r4 = i;     // Catch: Throwable -> L48
        if (r4 != 0) goto L41;
    L43:
        this.e = true;     // Catch: Throwable -> L48
        monitor-exit(this);
        return;
    L41:
        if ((r4 % 100) != 0) goto L43;
        b();     // Catch: Throwable -> L48
        goto L43
    L37:
        this.a.put(this.f, 1L);     // Catch: Throwable -> L48
        i = 1;     // Catch: Throwable -> L48
    L8:
        if (this.a.containsKey(this.f) == false) goto L26;
        if (this.a.size() < 9) goto L26;
        goto L11
    }

    public final synchronized void d() {
        monitor-enter(this);
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    L4:
        if (e(this.d) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<Map.Entry<String, Long>> r0 = this.a.entrySet().iterator();     // Catch: Throwable -> L21
    L8:
        if (r0.hasNext() == false) goto L19;
        Map.Entry<String, Long> r1 = r0.next();     // Catch: Throwable -> L21
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L8
    L12:
        if (this.f.equals(r1.getKey()) == true) goto L8;
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L16
        r2.put("param_long_first", r1.getKey());     // Catch: Throwable -> L16
        r2.put("param_long_second", r1.getValue());     // Catch: Throwable -> L16
        h4.i(this.d, "O023", r2);     // Catch: Throwable -> L16
    L19:
        monitor-exit(this);
    }

    public final void f() {
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L14
        Iterator<Map.Entry<String, Long>> r1 = this.a.entrySet().iterator();     // Catch: Throwable -> L14
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, Long> r2 = r1.next();     // Catch: Throwable -> L14
        r0.append(y4.d(t3.c((r2.getKey() + "," + r2.getValue()).getBytes("UTF-8"), this.c)) + "\n");     // Catch: UnsupportedEncodingException -> L8 Throwable -> L14
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L4
    L10:
        String r3 = r0.toString();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r3) == true) goto L25;
        j4.h(this.b, r3);     // Catch: Throwable -> L14
        return;
    L25:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
    }

    public g4(Context r7) {
        this.a = new LinkedHashMap();
        this.c = null;
        this.f = NameKeys.UnloadStrategy_No_Strategy;
        this.g = null;
        Context r8 = r7.getApplicationContext();
        this.d = r8;
        String r0 = r8.getFilesDir().getPath();
        this.c = j4.I(r8);
        this.b = new PolarisFileWrapper(r0, "reportRecorder");     // Catch: Throwable -> L32
    L4:
        monitor-enter(this);
        LinkedHashMap<String, Long> r9 = this.a;     // Catch: Throwable -> L29
        if (r9 != null) goto L8;
    L35:
        this.f = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));     // Catch: Throwable -> L25
        Iterator r10 = ((ArrayList) j4.g(this.b)).iterator();     // Catch: Throwable -> L25
    L11:
        if (r10.hasNext() == false) goto L27;
        String[] r1 = new String(t3.e(y4.e((String) r10.next()), this.c), "UTF-8").split(",");     // Catch: Throwable -> L20 UnsupportedEncodingException -> L22
        if (r1 == null) goto L11;
        if (r1.length <= 1) goto L11;
        this.a.put(r1[0], Long.valueOf(CastLongProtector.parseLong(r1[1])));     // Catch: Throwable -> L20 UnsupportedEncodingException -> L22
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
        if (r9.size() <= 0) goto L35;
    L29:
        th = move-exception;
        throw th;
    }

    public final boolean e(Context r5) {
        if (this.g != null) goto L6;
        this.g = i4.d(r5, "pref", "lastavedate", "0");
    L6:
        if (this.g.equals(this.f) == false) goto L8;
        return false;
    L8:
        SharedPreferences.Editor r6 = r5.getSharedPreferences("pref", 0).edit();
        i4.h(r6, "lastavedate", this.f);
        i4.e(r6);
        this.g = this.f;
        return true;
    }
}
