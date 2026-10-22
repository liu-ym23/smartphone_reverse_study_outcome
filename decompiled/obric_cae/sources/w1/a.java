package w1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.amap.api.location.AMapLocationClientOption;
import org.json.JSONObject;
import qa.h4;
import qa.l1;
import qa.o4;
import qa.p4;
import qa.q4;
import qa.s4;
import qa.t3;
import qa.x1;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x1 f12952a;

    public a(Context r15) {
        s4 r8 = t3.j();
        p4.c r10 = p4.f10903a;
        monitor-enter(p4.class);
        if (r15 == null) goto L58;
        if (r8 == null) goto L58;
        if (p4.f10914l == true) goto L10;
        p4.g(r15);     // Catch: Throwable -> L72
        p4.f10914l = true;     // Catch: Throwable -> L72
    L10:
        q4 r11 = null;
        if (p4.f10904b != p4.e.f10943n) goto L13;
        boolean r12 = true;
    L21:
        if (r12 == true) goto L23;
    L32:
        if (r12 != true) goto L43;
        if (p4.f10908f == p4.b.f10922n) goto L43;
        if (p4.f10908f != p4.b.f10920b) goto L39;
        r11 = new q4(p4.d.f10935q, r8);     // Catch: Throwable -> L72
    L41:
        r12 = false;
        goto L43
    L39:
        if (p4.f10908f != p4.b.f10921m) goto L41;
        r11 = new q4(p4.d.f10936r, r8);     // Catch: Throwable -> L72
    L43:
        if (p4.f10913k == p4.f10912j) goto L48;
        long r13 = p4.f10912j;     // Catch: Throwable -> L72
        p4.f10913k = p4.f10912j;     // Catch: Throwable -> L72
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L75
        r14.put("privacyInfo", p4.f10903a.f10929a);     // Catch: Throwable -> L75
        r14.put("privacyShow", p4.f10904b.f10945a);     // Catch: Throwable -> L75
        r14.put("showTime", p4.f10907e);     // Catch: Throwable -> L75
        r14.put("show2SDK", p4.f10905c);     // Catch: Throwable -> L75
        r14.put("show2SDKVer", p4.f10906d);     // Catch: Throwable -> L75
        r14.put("privacyAgree", p4.f10908f.f10924a);     // Catch: Throwable -> L75
        r14.put("agreeTime", p4.f10909g);     // Catch: Throwable -> L75
        r14.put("agree2SDK", p4.f10910h);     // Catch: Throwable -> L75
        r14.put("agree2SDKVer", p4.f10911i);     // Catch: Throwable -> L75
        l1.f10784d.a(new p4.a(p4.f10915m, r15, r13, r14));     // Catch: Throwable -> L72
    L50:
        p4.f10915m = false;     // Catch: Throwable -> L72
        String r16 = h4.g(r15);     // Catch: Throwable -> L72
        if (r16 != null) goto L53;
    L54:
        r11 = new q4(p4.d.f10937s, r8);     // Catch: Throwable -> L72
        Log.e(r8.a(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", new Object[]{10001, r11.f10955b}));     // Catch: Throwable -> L72
    L55:
        if (r12 == false) goto L57;
        r11 = new q4(p4.d.f10930b, r8);     // Catch: Throwable -> L72
    L59:
        monitor-exit(p4.class);
        if (r11.f10954a == p4.d.f10930b) goto L79;
        Log.e("AMapLocationClient", r11.f10955b);
        throw new Exception(r11.f10955b);
    L79:
        if (r15 == null) goto L66;
        r15.getApplicationContext();     // Catch: Throwable -> L67
        this.f12952a = new x1(r15);     // Catch: Throwable -> L67
        return;
    L66:
        throw new IllegalArgumentException("Context参数不能为null");     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        t3.g("AMClt", "ne1", th);
        return;
    L57:
        Log.e(r8.a(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", new Object[]{Integer.valueOf(r11.f10954a.f10940a), r11.f10955b}));     // Catch: Throwable -> L72
        goto L59
    L53:
        if (r16.length() > 0) goto L55;
    L48:
        if (p4.f10915m == false) goto L50;
        l1.f10784d.a(new o4(r15));     // Catch: Throwable -> L72
        goto L50
    L23:
        if (p4.f10903a == p4.c.f10927n) goto L32;
        if (p4.f10903a != p4.c.f10925b) goto L29;
        q4 r17 = new q4(p4.d.f10933o, r8);     // Catch: Throwable -> L72
    L27:
        r11 = r17;
    L31:
        r12 = false;
        goto L32
    L29:
        if (p4.f10903a != p4.c.f10926m) goto L31;
        r17 = new q4(p4.d.f10934p, r8);     // Catch: Throwable -> L72
        goto L27
    L13:
        if (p4.f10904b != p4.e.f10941b) goto L17;
        q4 r18 = new q4(p4.d.f10931m, r8);     // Catch: Throwable -> L72
    L15:
        r11 = r18;
    L19:
        r12 = false;
        goto L21
    L17:
        if (p4.f10904b != p4.e.f10942m) goto L19;
        r18 = new q4(p4.d.f10932n, r8);     // Catch: Throwable -> L72
    L58:
        r11 = new q4(p4.d.f10938t, r8);     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        throw th;
    }

    public final void a() {
        x1 r8 = this.f12952a;     // Catch: Throwable -> L9
        if (r8 == null) goto L15;
        Bundle r10 = new Bundle();     // Catch: Throwable -> L6
        r10.putBoolean("j", true);     // Catch: Throwable -> L6
        r8.c(1024, r10, 0);     // Catch: Throwable -> L6
    L16:
        return;
    L6:
        th = move-exception;
        t3.g("ALManager", "disableBackgroundLocation", th);     // Catch: Throwable -> L9
        return;
    L15:
        return;
    L9:
        th = move-exception;
        t3.g("AMClt", "dBackL", th);
    }

    public final void b() {
        x1 r8 = this.f12952a;     // Catch: Throwable -> L11
        if (r8 == null) goto L18;
        r8.getClass();     // Catch: Throwable -> L11
        r8.c(1011, null, 0);     // Catch: Throwable -> L8
        r8.f11212s = true;     // Catch: Throwable -> L8
    L19:
        return;
    L8:
        th = move-exception;
        t3.g("ALManager", "onDestroy", th);     // Catch: Throwable -> L11
        return;
    L18:
        return;
    L11:
        th = move-exception;
        t3.g("AMClt", "onDy", th);
    }

    public final void c(b r8) {
        if (r8 == null) goto L15;
        x1 r10 = this.f12952a;     // Catch: Throwable -> L12
        if (r10 == null) goto L21;
        r10.getClass();     // Catch: Throwable -> L12
        r10.c(1002, r8, 0);     // Catch: Throwable -> L9
    L22:
        return;
    L9:
        th = move-exception;
        t3.g("ALManager", "setLocationListener", th);     // Catch: Throwable -> L12
        return;
    L21:
        return;
    L15:
        throw new IllegalArgumentException("listener参数不能为null");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        t3.g("AMClt", "sLocL", th);
    }

    public final void d(AMapLocationClientOption r8) {
        if (r8 == null) goto L11;
        x1 r10 = this.f12952a;     // Catch: Throwable -> L12
        if (r10 == null) goto L18;
        r10.f11218y = r8.t();     // Catch: Throwable -> L7
        r10.c(1018, r8.t(), 0);     // Catch: Throwable -> L7
    L19:
        return;
    L7:
        th = move-exception;
        t3.g("ALManager", "setLocationOption", th);     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L11:
        throw new IllegalArgumentException("LocationManagerOption参数不能为null");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        t3.g("AMClt", "sLocnO", th);
    }

    public final void e() {
        x1 r8 = this.f12952a;     // Catch: Throwable -> L16
        if (r8 == null) goto L26;
        r8.getClass();     // Catch: Throwable -> L16
        AMapLocationClientOption r10 = r8.f11218y;     // Catch: Throwable -> L19
        if (r10.C == false) goto L20;
        x1.e r11 = r8.f11197d;     // Catch: Throwable -> L19
        if (r11 == null) goto L20;
        r11.sendEmptyMessageDelayed(13, r10.D);     // Catch: Throwable -> L19
    L20:
        r8.c(1003, null, 0);     // Catch: Throwable -> L13
    L27:
        return;
    L13:
        th = move-exception;
        t3.g("ALManager", "startLocation", th);     // Catch: Throwable -> L16
        return;
    L26:
        return;
    L16:
        th = move-exception;
        t3.g("AMClt", "stl", th);
    }

    public final void f() {
        x1 r8 = this.f12952a;     // Catch: Throwable -> L11
        if (r8 == null) goto L18;
        r8.getClass();     // Catch: Throwable -> L11
        r8.c(1004, null, 0);     // Catch: Throwable -> L8
    L19:
        return;
    L8:
        th = move-exception;
        t3.g("ALManager", "stopLocation", th);     // Catch: Throwable -> L11
        return;
    L18:
        return;
    L11:
        th = move-exception;
        t3.g("AMClt", "stl", th);
    }

    public final void g(b r8) {
        x1 r10 = this.f12952a;     // Catch: Throwable -> L11
        if (r10 == null) goto L17;
        r10.getClass();     // Catch: Throwable -> L11
        r10.c(1005, r8, 0);     // Catch: Throwable -> L8
    L18:
        return;
    L8:
        th = move-exception;
        t3.g("ALManager", "unRegisterLocationListener", th);     // Catch: Throwable -> L11
        return;
    L17:
        return;
    L11:
        th = move-exception;
        t3.g("AMClt", "unRL", th);
    }
}
