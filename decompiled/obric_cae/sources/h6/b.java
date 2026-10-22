package h6;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import f6.c;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import we.a0;
import z5.f;

/* JADX INFO: loaded from: classes.dex */
public final class b extends f6.a<h6.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f7910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f7911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f7912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f7913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RunnableC0085b f7914f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f7915a;

        public a(b r8) {
            this.f7915a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r8 = this.f7915a;
            if (r8.f7912d.getAndSet(false) == false) goto L8;
            r8.f7911c.removeCallbacks(r8.f7913e);
            r8.f7911c.removeCallbacks(r8.f7914f);
            r8.f7912d.set(false);
            if (r8.f7910b == null) goto L9;
            Logger.d("WsChannelSdk_ok", "心跳超时，准备断开重连");
            z5.b.n(((z5.b.a) r8.f7910b).f14239a);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: h6.b$b, reason: collision with other inner class name */
    public class RunnableC0085b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f7916a;

        public RunnableC0085b(b r8) {
            this.f7916a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r8 = this.f7916a;
            if (r8.f7910b == null) goto L6;
            r8.f();
            z5.b r10 = ((z5.b.a) r8.f7910b).f14239a;
            r10.f14232s.post(new f(r10));
            return;
        }
    }

    public b(h6.a.C0084a r8) {
        super(r8);
        this.f7912d = new AtomicBoolean(false);
        this.f7913e = new a(this);
        this.f7914f = new RunnableC0085b(this);
    }

    @Override // f6.a
    public final void a(z5.b.a r8, WeakHandler r10) {
        this.f7910b = r8;
        this.f7911c = r10;
    }

    public final void b(a0 r14) {
        Logger.d("WsChannelSdk_ok", "连接成功，开始计时发送ping");
        h6.a r8 = (h6.a) this.f7329a;
        if (r8.f7908a == (-1)) goto L6;
    L26:
        f();
        return;
    L6:
        if (r14 == null) goto L24;
        String r15 = r14.n("Handshake-Options");
        if (r15 == null) goto L21;
        String[] r16 = r15.split(";");
        int r10 = r16.length;
        long r11 = -1;
        int r12 = 0;
    L11:
        if (r12 >= r10) goto L23;
        String r13 = r16[r12];
        if (TextUtils.isEmpty(r13) == true) goto L20;
        String[] r17 = r13.split("=");
        if ("ping-interval".equals(r17[0]) == false) goto L20;
        r11 = Long.parseLong(r17[1]) * 1000;
    L19:
        r11 = 270000;
    L20:
        r12 = r12 + 1;
    L23:
        if (r11 == (-1)) goto L24;
        r8.f7908a = r11;
        goto L26
    L21:
        r11 = -1;
    L24:
        r8.f7908a = 270000;
        goto L26
    }

    public final void c() {
        Logger.d("WsChannelSdk_ok", "断开连接，停止计时发送ping");
        this.f7911c.removeCallbacks(this.f7913e);
        this.f7911c.removeCallbacks(this.f7914f);
        this.f7912d.set(false);
    }

    public final void d() {
        Logger.d("WsChannelSdk_ok", "ping已发送，开始等待pong");
        this.f7912d.set(true);
        Handler r8 = this.f7911c;
        a r10 = this.f7913e;
        r8.removeCallbacks(r10);
        this.f7911c.postDelayed(r10, ((h6.a) this.f7329a).f7909b);
    }

    public final void e() {
        Logger.d("WsChannelSdk_ok", "收到pong");
        this.f7912d.set(false);
        this.f7911c.removeCallbacks(this.f7913e);
    }

    public final void f() {
        long r8 = ((h6.a) this.f7329a).f7908a;
        StringBuilder r10 = new StringBuilder("interval :");
        r10.append(r8);
        r10.append(" ms,下次心跳时间为: ");
        long r11 = System.currentTimeMillis() + r8;
        r10.append(DateFormat.getDateTimeInstance().format(new Date(r11)));
        Logger.d("WsChannelSdk_ok", r10.toString());
        Handler r12 = this.f7911c;
        RunnableC0085b r13 = this.f7914f;
        r12.removeCallbacks(r13);
        this.f7911c.postDelayed(r13, r8);
    }
}
