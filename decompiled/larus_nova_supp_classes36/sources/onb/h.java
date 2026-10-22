package onb;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements Runnable {
    public final /* synthetic */ i a;

    public final void a() {
        i r0 = this.a;
        g r1 = r0.a.a;
        String r2 = r0.b.getType();
        String r3 = this.a.b.b();
        r1.getClass();
        if ("requestFromNative".equals(r2) == false) goto L9;
        pnb.b r4 = r1.a.b;
        if (pnb.c.a == false) goto L7;
        r4.getClass();
        rnb.c.a("bridge_send", "requestFromNative:  request=" + r3);
    L7:
        pnb.b.HandlerC0312b r5 = r4.a;
        int r6 = pnb.b.HandlerC0312b.b;
        r5.getClass();
        r5.sendMessage(Message.obtain(r5, 3, r3));
    L14:
        i r7 = this.a;
        if (r7.d == null) goto L21;
        Handler r8 = r7.e;
        long r9 = r7.b.b;
        if (r9 != (-1)) goto L20;
        r9 = r7.a.c;
    L20:
        r8.sendEmptyMessageDelayed(2, r9);
    L21:
        rnb.c.a("RNBridge->JSCall", "hashCode: " + hashCode() + "->sendJSMessage->requestId: " + this.a.b.a());
        return;
    L9:
        if ("requestFromDocs".equals(r2) == false) goto L14;
        pnb.b r10 = r1.a.b;
        if (pnb.c.a == false) goto L13;
        r10.getClass();
        rnb.c.a("bridge_send", "requestFromDocs:  request=" + r3);
    L13:
        pnb.b.HandlerC0312b r11 = r10.a;
        int r12 = pnb.b.HandlerC0312b.b;
        r11.getClass();
        r11.sendMessage(Message.obtain(r11, 5, r3));
        goto L14
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(i r1) {
        this.a = r1;
    }
}
