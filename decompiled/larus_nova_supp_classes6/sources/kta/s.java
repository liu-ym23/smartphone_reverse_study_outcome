package kta;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import ita.k;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import pta.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class s {
    public static volatile s h;
    public final o a;
    public final q b;
    public final boolean c;
    public final Context d;
    public final AtomicBoolean e;
    public Future<p> f;
    public p g;

    public class a implements Callable<p> {
        public final /* synthetic */ s a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public p call2() {
            s r2 = this.a;
            String r0 = r2.b.a.getString("oaid", "");
            int r10 = -1;
            if (TextUtils.isEmpty(r0) == false) goto L56;
        L29:
            p r1 = null;
        L30:
            Objects.toString(r1);
            if (r1 == null) goto L33;
            r2.g = r1;
        L33:
            Context r3 = r2.d;
            long r5 = SystemClock.elapsedRealtime();
            o r7 = r2.a;
            if (r7 == null) goto L49;
            o.a r4 = r7.getOaid(r3);
            if (r4 == null) goto L49;
            int r8 = 1;
            if (r1 == null) goto L40;
            String r11 = r1.b;
            r10 = r1.f.intValue() + 1;
        L42:
            if (TextUtils.isEmpty(r11) == false) goto L44;
            r11 = UUID.randomUUID().toString();
        L44:
            String r14 = r11;
            if (r10 <= 0) goto L48;
            r8 = r10;
        L48:
            p r12 = new p(r4.a, r14, Boolean.valueOf(r4.b), Long.valueOf(SystemClock.elapsedRealtime() - r5), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r8), Long.valueOf(r4.c));
        L50:
            if (r12 == null) goto L52;
            r2.b.a.edit().putString("oaid", r12.a().toString()).apply();
        L52:
            if (r12 == null) goto L54;
            r2.g = r12;
        L54:
            Objects.toString(r12);
            return r12;
        L40:
            r11 = null;
        L49:
            r12 = null;
            goto L50
        L56:
            JSONObject r9 = new JSONObject(r0);     // Catch: JSONException -> L27
            String r13 = r9.optString("id", null);     // Catch: JSONException -> L27
            String r15 = r9.optString("req_id", null);     // Catch: JSONException -> L27
            if (r9.has("is_track_limited") == false) goto L8;
            Boolean r16 = Boolean.valueOf(r9.optBoolean("is_track_limited"));     // Catch: JSONException -> L27
        L10:
            if (r9.has("take_ms") == false) goto L12;
            Long r17 = Long.valueOf(r9.optLong("take_ms", -1));     // Catch: JSONException -> L27
        L14:
            if (r9.has("time") == false) goto L16;
            Long r18 = Long.valueOf(r9.optLong("time", -1));     // Catch: JSONException -> L27
        L18:
            if (r9.has("query_times") == false) goto L20;
            Integer r19 = Integer.valueOf(r9.optInt("query_times", -1));     // Catch: JSONException -> L27
        L22:
            if (r9.has("hw_id_version_code") == false) goto L24;
            Long r110 = Long.valueOf(r9.optLong("hw_id_version_code", -1));     // Catch: JSONException -> L27
        L25:
            r1 = new p(r13, r15, r16, r17, r18, r19, r110);     // Catch: JSONException -> L27
            goto L30
        L24:
            r110 = null;
            goto L25
        L20:
            r19 = null;
            goto L22
        L16:
            r18 = null;
            goto L18
        L12:
            r17 = null;
            goto L14
        L8:
            r16 = null;
        L27:
            e = move-exception;
            e.printStackTrace();
            goto L29
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ p call() throws Exception {
            return call2();
        }

        public a(s r1) {
            this.a = r1;
        }
    }

    public final void a() {
        if (this.e.compareAndSet(false, true) == false) goto L6;
        this.f = TTExecutors.getIOThreadPool().submit(new a(this));
        return;
    }

    public s(Context r9) {
        this.e = new AtomicBoolean(false);
        Context r0 = r9.getApplicationContext();
        this.d = r0;
        if (d.g() == false) goto L5;
        t r2 = new t(new x());
    L85:
        this.a = r2;
        if (r2 == null) goto L88;
        this.c = r2.a(r9);
    L89:
        this.b = new q(r0);
        return;
    L88:
        this.c = false;
        goto L89
    L5:
        boolean r3 = true;
        if (x.b != null) goto L8;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L16;
        r2 = new x();
        goto L85
    L16:
        if (r.a.b(new Object[0]).booleanValue() == false) goto L19;
        r2 = new r();
        goto L85
    L19:
        if (d.i() == false) goto L24;
        if (d.f() == false) goto L24;
        r2 = new g();
    L24:
        if (d.i() == false) goto L29;
        if (d.f() == true) goto L29;
        r2 = new i();
    L29:
        if (d.j() == false) goto L31;
        r2 = new g();
        goto L85
    L31:
        String r5 = Build.MANUFACTURER;
        if ("OnePlus".equalsIgnoreCase(r5) == false) goto L34;
        r2 = new t(null);
        goto L85
    L34:
        String r6 = Build.BRAND;
        if (r6 != null) goto L37;
        boolean r7 = false;
    L38:
        if (r7 == false) goto L41;
        r2 = new l();
        goto L85
    L41:
        if (Build.VERSION.SDK_INT <= 28) goto L80;
        if ("samsung".equalsIgnoreCase(r6) == false) goto L45;
    L48:
        boolean r8 = true;
    L49:
        if (r8 == false) goto L51;
        r2 = new v();
        goto L85
    L51:
        String r10 = "";
        if (r5 != null) goto L54;
        String r11 = "";
    L56:
        if (r11.toUpperCase().contains("NUBIA") == false) goto L58;
        r2 = new m();
        goto L85
    L58:
        String r12 = Build.FINGERPRINT;
        if (TextUtils.isEmpty(r12) == true) goto L61;
        r3 = r12.contains("VIBEUI_V2");
    L67:
        if (r3 == false) goto L69;
        r2 = new k();
        goto L85
    L69:
        if (r5 == null) goto L73;
        r10 = r5.trim();
    L73:
        if (r10.toUpperCase().contains("ASUS") == false) goto L75;
        r2 = new kta.a();
        goto L85
    L75:
        r2 = new e(r9);
        if (r2.a(r9) == true) goto L85;
        r2 = new d();
        goto L85
    L61:
        String r13 = d.e("ro.build.version.incremental");
        if (TextUtils.isEmpty(r13) == false) goto L64;
    L66:
        r3 = false;
        goto L67
    L64:
        if (r13.contains("VIBEUI_V2") == false) goto L66;
    L54:
        r11 = r5.trim();
        goto L56
    L45:
        if ("samsung".equalsIgnoreCase(r5) == true) goto L48;
        r8 = false;
        goto L49
    L80:
        if (k.j() == false) goto L82;
    L84:
        r2 = null;
        goto L85
    L82:
        if (((Boolean) g.a.b(new Object[]{r9})).booleanValue() == false) goto L84;
        r2 = new g();
        goto L85
    L37:
        r7 = r6.toLowerCase(Locale.ENGLISH).contains("meizu");
        goto L38
    L8:
        if (x.a == null) goto L12;
        if (x.c == null) goto L12;
        r4 = true;
        goto L13
    }

    public static s b(Context r2) {
        if (h != null) goto L15;
        monitor-enter(s.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (h != null) goto L9;
        h = new s(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(s.class);     // Catch: Throwable -> L11
    L15:
        return h;
    }

    public static void c(JSONObject r1, String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (r3 == null) goto L13;
        r1.put(r2, r3);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        return;
    }

    public static <K, V> void d(Map<K, V> r0, K r1, V r2) {
        if (r2 == null) goto L5;
        ((HashMap) r0).put(r1, r2);
        return;
    }
}
