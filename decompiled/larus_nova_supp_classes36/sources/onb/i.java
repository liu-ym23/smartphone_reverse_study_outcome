package onb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements g.c, Handler.Callback {
    public final k a;
    public final a b;
    public b c;
    public j d;
    public final Handler e;

    @Override // onb.g.c
    public final void a() {
        rnb.c.c("RNBridge->JSCall", "hashCode: " + hashCode() + "->connected");
        this.a.d.submit(new h(this));
    }

    public final void c() {
        this.e.removeMessages(2);
        this.e.removeMessages(1);
        this.e.removeMessages(4);
        this.e.removeMessages(3);
        this.a.a.f(this);
    }

    @Override // onb.g.c
    public final void disconnect() {
        rnb.c.c("RNBridge->JSCall", "hashCode: " + hashCode() + "->disconnect");
        c();
        j r0 = this.d;
        if (r0 == null) goto L6;
        r0.onError("NB202", (String) ((HashMap) m.a).get("NB202"));
        return;
    }

    @Override // onb.g.c
    public final void b(b r3) {
        if (TextUtils.equals(this.b.a(), r3.a()) == false) goto L6;
        this.c = r3;
        this.e.sendEmptyMessage(4);
        return;
    }

    public final void d(j r2) {
        this.d = r2;
        rnb.c.c("RNBridge->JSCall", "hashCode: " + hashCode() + "->startCall");
        this.e.sendEmptyMessage(3);
        this.a.a.c(this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r9) {
        int r0 = r9.what;
        boolean r3 = true;
        if (r0 == 1) goto L29;
        if (r0 != 2) goto L7;
        c();
        j r10 = this.d;
        if (r10 == null) goto L36;
        r10.onError("NB201", (String) ((HashMap) m.a).get("NB201"));
    L36:
        return false;
    L7:
        if (r0 == 3) goto L15;
        if (r0 == 4) goto L11;
        rnb.c.a("RNBridge->JSCall", "error type:" + r9.what);
        goto L36
    L11:
        c();
        if (this.d == null) goto L36;
        rnb.c.a("RNBridge->JSCall", "hashCode: " + hashCode() + "->received bridge data");
        this.d.a(this.c);
        goto L36
    L15:
        if (this.a.a.b.get() != 3) goto L17;
        boolean r11 = true;
    L18:
        if (r11 == false) goto L20;
        this.a.d.submit(new h(this));
        goto L36
    L20:
        rnb.c.a("RNBridge->JSCall", "hashCode: " + hashCode() + "->waitting connected");
        Handler r12 = this.e;
        long r4 = this.b.a;
        if (r4 != (-1)) goto L24;
        r4 = this.a.b;
    L24:
        r12.sendEmptyMessageDelayed(1, r4);
        goto L36
    L17:
        r11 = false;
        goto L18
    L29:
        if (this.a.a.b.get() == 3) goto L32;
        r3 = false;
    L32:
        if (r3 == true) goto L36;
        c();
        j r13 = this.d;
        if (r13 == null) goto L36;
        r13.onError("NB200", (String) ((HashMap) m.a).get("NB200"));
        goto L36
    }

    public i(k r3, vl5.h r4) {
        this.e = new Handler(Looper.getMainLooper(), this);
        this.a = r3;
        this.b = r4;
        boolean r0 = true;
        if (r3.a.b.get() == 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L12;
        final g r5 = r3.a;
        r5.getClass();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L10;
        r5.d();
        return;
    L10:
        r5.e.post(new e(r5));
        return;
    }
}
