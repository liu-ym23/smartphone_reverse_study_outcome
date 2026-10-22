package n4a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t4 {
    public static v3 g;
    public static w h;
    public static long i;
    public final Context a;
    public String b;
    public v3 c;
    public v3 d;
    public long e;
    public boolean f;

    public t4(Context r3) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = false;
        this.a = r3.getApplicationContext();
    }

    public final void b() {
        if (this.f == false) goto L16;
        return;
    L16:
    L12:
        th = move-exception;
        c4.g(th, "LastLocationManager", "<init>:DBOperation");
    L14:
        this.f = true;
        return;
    L6:
        if (this.b != null) goto L9;
        this.b = t3.a("MD5", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L12
    L9:
        if (h != null) goto L14;
        v r0 = w.d(w3.class);     // Catch: Throwable -> L12
        h = new w(this.a, r0);     // Catch: Throwable -> L12
        goto L14
    }

    public final void e() {
        if (g != null) goto L5;
    L6:
        v3 r1 = null;
        r1 = null;
        String r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        String r3 = null;
        if (this.a == null) goto L50;
        b();
        w r0 = h;     // Catch: Throwable -> L46
        if (r0 == null) goto L50;
        List r4 = r0.c(v3.class);     // Catch: Throwable -> L46
        if (((ArrayList) r4).size() <= 0) goto L37;
        v3 r5 = (v3) ListProtector.get(r4, 0);     // Catch: Throwable -> L46
        byte[] r6 = y4.e(r5.a);     // Catch: Throwable -> L44
        if (r6 != null) goto L20;
    L26:
        String r7 = null;
    L27:
        byte[] r8 = y4.e(r5.c);     // Catch: Throwable -> L44
        if (r8 != null) goto L30;
    L36:
        r5.c = r2;     // Catch: Throwable -> L44
        r3 = r7;
    L39:
        if (TextUtils.isEmpty(r3) == true) goto L49;
        AMapLocation r9 = new AMapLocation(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L44
        c4.e(r9, new JSONObject(r3));     // Catch: Throwable -> L44
        if (j4.w(r9) == false) goto L49;
        r5.d = r9;     // Catch: Throwable -> L44
    L49:
        r1 = r5;
        goto L50
    L30:
        if (r8.length <= 0) goto L36;
        byte[] r10 = t3.e(r8, this.b);     // Catch: Throwable -> L44
        if (r10 == null) goto L36;
        if (r10.length <= 0) goto L36;
        r2 = new String(r10, "UTF-8");     // Catch: Throwable -> L44
        goto L36
    L20:
        if (r6.length <= 0) goto L26;
        byte[] r11 = t3.e(r6, this.b);     // Catch: Throwable -> L44
        if (r11 == null) goto L26;
        if (r11.length <= 0) goto L26;
        r7 = new String(r11, "UTF-8");     // Catch: Throwable -> L44
    L44:
        Throwable th = th;
    L48:
        c4.g(th, "LastLocationManager", "readLastFix");
        goto L49
    L37:
        r5 = null;
    L46:
        th = move-exception;
        th = th;
        r5 = null;
    L50:
        i = SystemClock.elapsedRealtime();
        if (r1 != null) goto L53;
        return;
    L53:
        if (j4.l(r1.d) == false) goto L62;
        g = r1;
        return;
    L62:
        return;
    L5:
        if ((SystemClock.elapsedRealtime() - i) > 180000) goto L6;
    }

    public final void d() {
        b();     // Catch: Throwable -> L38
        v3 r0 = this.c;     // Catch: Throwable -> L38
        if (r0 != null) goto L5;
        return;
    L5:
        if (j4.l(r0.d) == true) goto L7;
        return;
    L7:
        if (h == null) goto L45;
        v3 r1 = this.c;     // Catch: Throwable -> L38
        if (r1 != this.d) goto L11;
        return;
    L11:
        if (r1.b != 0) goto L47;
        String r2 = r1.d.toStr();     // Catch: Throwable -> L38
        v3 r3 = this.c;     // Catch: Throwable -> L38
        String r4 = r3.c;     // Catch: Throwable -> L38
        this.d = r3;     // Catch: Throwable -> L38
        String r5 = null;
        if (TextUtils.isEmpty(r2) == true) goto L19;
        String r6 = y4.d(t3.c(r2.getBytes("UTF-8"), this.b));     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r4) == true) goto L18;
        r5 = y4.d(t3.c(r4.getBytes("UTF-8"), this.b));     // Catch: Throwable -> L38
    L18:
        String r7 = r5;
        r5 = r6;
        String r8 = r7;
    L21:
        if (TextUtils.isEmpty(r5) == true) goto L48;
        v3 r9 = new v3();     // Catch: Throwable -> L38
        r9.a = r5;     // Catch: Throwable -> L38
        r9.b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L38
        r9.c = r8;     // Catch: Throwable -> L38
        w r10 = h;     // Catch: Throwable -> L38
        v r11 = r10.c;     // Catch: Throwable -> L38
        monitor-enter(r11);     // Catch: Throwable -> L38
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L25:
        if (((ArrayList) r10.c(v3.class)).size() != 0) goto L29;
        r10.e(r9);     // Catch: Throwable -> L27
    L30:
        monitor-exit(r11);     // Catch: Throwable -> L27
        this.e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L38
        v3 r12 = g;     // Catch: Throwable -> L38
        if (r12 == null) goto L49;
        r12.b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L38
        return;
    L49:
        return;
    L29:
        r10.h(r9);     // Catch: Throwable -> L27
        goto L30
    L48:
        return;
    L19:
        r8 = null;
        goto L21
    L47:
        return;
    L45:
        return;
    L38:
        th = move-exception;
        c4.g(th, "LastLocationManager", "saveLastFix");
    }

    public final boolean c(AMapLocation r6, String r7) {
        if (this.a == null) goto L30;
        if (r6 == null) goto L30;
        if (j4.l(r6) == false) goto L30;
        if (r6.getLocationType() == 2) goto L30;
        if (r6.isMock() == true) goto L30;
        if (r6.isFixLastLocation() == true) goto L30;
        v3 r0 = new v3();
        r0.d = r6;
        if (r6.getLocationType() != 1) goto L18;
        r0.c = null;
    L31:
        g = r0;     // Catch: Throwable -> L28
        i = SystemClock.elapsedRealtime();     // Catch: Throwable -> L28
        this.c = r0;     // Catch: Throwable -> L28
        v3 r8 = this.d;     // Catch: Throwable -> L28
        if (r8 != null) goto L22;
    L24:
        if ((SystemClock.elapsedRealtime() - this.e) <= AutoEndConversationTime.AFTER_30_SECONDS) goto L30;
        return true;
    L22:
        if (j4.a(r8.d, r0.d) > 500.0f) goto L24;
        return false;
    L28:
        th = move-exception;
        c4.g(th, "LastLocationManager", "setLastFix");
        goto L30
    L18:
        r0.c = r7;
    L30:
        return false;
    }

    public final AMapLocation a(AMapLocation r8, String r9, long r10) {
        if (r8 != null) goto L5;
        return r8;
    L5:
        if (r8.getErrorCode() != 0) goto L7;
        return r8;
    L7:
        if (r8.getLocationType() != 1) goto L9;
        return r8;
    L9:
        if (r8.getErrorCode() == 7) goto L44;
        e();     // Catch: Throwable -> L33
        v3 r0 = g;     // Catch: Throwable -> L33
        if (r0 != null) goto L14;
    L32:
        return r8;
    L14:
        if (r0.d == null) goto L32;
        if (TextUtils.isEmpty(r9) == false) goto L25;
        long r2 = SystemClock.elapsedRealtime() - g.b;     // Catch: Throwable -> L33
        if (r2 >= 0) goto L21;
    L23:
        boolean r11 = false;
    L24:
        r8.setTrustedLevel(3);     // Catch: Throwable -> L33
    L26:
        if (r11 == false) goto L42;
        AMapLocation r12 = g.d;     // Catch: Throwable -> L33
        b4.a(r12);     // Catch: Throwable -> L30
        r12.setLocationType(9);     // Catch: Throwable -> L30
        r12.setFixLastLocation(true);     // Catch: Throwable -> L30
        r12.setLocationDetail(r8.getLocationDetail());     // Catch: Throwable -> L30
        return r12;
    L30:
        th = move-exception;
        th = th;
        r8 = r12;
    L34:
        c4.g(th, "LastLocationManager", "fixLastLocation");
        return r8;
    L42:
        return r8;
    L21:
        if (r2 > r10) goto L23;
        r11 = true;
        goto L24
    L25:
        r11 = j4.o(g.c, r9);     // Catch: Throwable -> L33
        r8.setTrustedLevel(2);     // Catch: Throwable -> L33
    L33:
        th = th;
        goto L34
    L44:
        return r8;
    }
}
