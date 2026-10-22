package o9;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.n;
import com.bytedance.ies.argus.bean.b;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import l9.o;
import l9.u;
import org.json.JSONArray;
import z8.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {
    public static a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f20417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f20418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f20419c;

    public /* synthetic */ a(Handler r5, long r10) {
        this.f20419c = 0;
        this(r5, r10, (byte) 0);
    }

    public static void a() {
        u r5 = o.e();
        if (d != null) goto L5;
        Handler r10 = o.e().d;
        Context r11 = n.f4057a;
        d = new a(r10, 30000);
    L5:
        r5.c(d, 1000);
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f20419c) {
            case 0: goto L27;
            default: goto L4;
        };
    L4:
        r6.a r5 = n.g();
        if (TextUtils.isEmpty((String) r5.f21695a) == false) goto L7;
    L9:
        i4.a r10 = n.d();
        r10.getClass();
        String r11 = ((ICommonParams) r10.f17503c).getDeviceId();     // Catch: Throwable -> L12
    L14:
        if (TextUtils.isEmpty(r11) == false) goto L16;
    L21:
        long r12 = this.f20418b;
        Handler r13 = this.f20417a;
        if (r12 <= 0) goto L24;
        r13.postDelayed(this, r12);
    L25:
        io.reactivex.exceptions.a.i("[DeviceIdTask] did is null, continue check.");
        return;
    L24:
        r13.post(this);
        goto L25
    L16:
        if ("0".equals(r11) == true) goto L21;
        n.g().f21695a = r11;
        b r14 = b.a();
        r14.getClass();
        cl.a.u(r11, (File) r14.d, false);     // Catch: Throwable -> L48
    L20:
        io.reactivex.exceptions.a.i("[DeviceIdTask] did is " + r11);
        return;
    L12:
        r11 = "";
        goto L14
    L7:
        if ("0".equals((String) r5.f21695a) == true) goto L9;
        return;
    L27:
        o.e().d.removeCallbacks(this);
        Map r15 = n.d().v();     // Catch: Throwable -> L30
    L31:
        if (r15 != null) goto L54;
    L46:
        b r16 = b.a();     // Catch: Throwable -> L49
        ConcurrentLinkedQueue r17 = d.f23418a;     // Catch: Throwable -> L49
        r16.f(r15, new JSONArray());     // Catch: Throwable -> L49
        return;
    L54:
        if (r15.isEmpty() == false) goto L35;
    L42:
        long r18 = this.f20418b;     // Catch: Throwable -> L49
        if (r18 <= 0) goto L45;
        this.f20417a.postDelayed(this, r18);     // Catch: Throwable -> L49
        return;
    L45:
        this.f20417a.post(this);     // Catch: Throwable -> L49
        return;
    L35:
        if (r15.containsKey("app_version") == true) goto L39;
        if (r15.containsKey("version_name") == false) goto L42;
    L39:
        if (r15.containsKey("version_code") == false) goto L42;
        if (r15.containsKey("update_version_code") == true) goto L46;
    L61:
        return;
    L30:
        r15 = null;
        goto L31
    }

    public a(Handler r5) {
        this.f20419c = 1;
        this(r5, 5000, (byte) 0);
    }

    public a(Handler r5, long r10, byte r11) {
        this.f20417a = r5;
        this.f20418b = r10;
    }
}
