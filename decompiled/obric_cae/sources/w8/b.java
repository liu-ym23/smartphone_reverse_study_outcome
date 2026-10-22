package w8;

import a7.i;
import android.content.Context;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.TTNetInit;
import d7.p;
import java.net.MalformedURLException;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile InterfaceC0189b f13060a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f13061b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f13062c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f13063d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f13064e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f13065f;

    public static class a extends c {
        @Override // w8.b.c
        public final w6.c a() {
            i r8 = i.m(TTNetInit.getTTNetDepend().getContext());
            if (d.f13066c != null) goto L15;
            monitor-enter(d.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (d.f13066c != null) goto L9;
            d.f13066c = new d(r8);     // Catch: Throwable -> L11
        L9:
            monitor-exit(d.class);     // Catch: Throwable -> L11
        L15:
            return d.f13066c;
        }
    }

    /* JADX INFO: renamed from: w8.b$b, reason: collision with other inner class name */
    public interface InterfaceC0189b {
        boolean c();
    }

    public static class c {
        public w6.c a() {
            Context r8 = TTNetInit.getTTNetDepend().getContext();
            if (p.f6904a == null) goto L5;
        L14:
            p r10 = p.f6904a;
            if (l7.e.c(r8) == false) goto L17;
            d9.d r11 = d9.d.c();
            r10.getClass();
            p.f6916m = r11;
        L17:
            return r10;
        L5:
            monitor-enter(p.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (p.f6904a != null) goto L9;
            p.f6904a = new p(r8);     // Catch: Throwable -> L11
        L9:
            monitor-exit(p.class);     // Catch: Throwable -> L11
            goto L14
        }
    }

    public static class d implements w6.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static volatile d f13066c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f13067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile int f13068b;

        public d(i r8) {
            this.f13067a = r8;
        }

        @Override // com.bytedance.retrofit2.client.Client
        public final SsCall newSsCall(Request r8) {
            return this.f13067a.newSsCall(r8);
        L4:
            th = move-exception;
            if ((th instanceof MalformedURLException) == false) goto L9;
        L26:
            TTNetInit.notifyColdStartFinish();
            return b.f13061b.a().newSsCall(r8);
        L9:
            if (th.getMessage() != null) goto L11;
        L13:
            y6.b.a r10 = y6.b.b().f14010a;
            if (r10 != y6.b.a.f14037m) goto L16;
        L19:
            boolean r11 = true;
        L20:
            if (r11 == false) goto L26;
            int r12 = this.f13068b + 1;
            this.f13068b = r12;
            if (r12 <= 3) goto L26;
            b.f13063d = true;
            String r13 = defpackage.c.W(th);
            b.f13065f = r13;
            if (r13.length() <= 256) goto L26;
            b.f13065f = b.f13065f.substring(0, 256);
            goto L26
        L16:
            if (r10 == y6.b.a.f14038n) goto L19;
            r11 = false;
            goto L20
        L11:
            if (th.getMessage().contains("MalformedURLException") == false) goto L13;
            goto L13
        }
    }

    static {
        f13061b = new c();
        f13062c = new a();
    }

    public static w6.c a() {
        if (b() == false) goto L7;
        return f13062c.a();
    L7:
        return f13061b.a();
    }

    public static boolean b() {
        if (f13060a != null) goto L7;
        p.f6905b = 9;
        return false;
    L7:
        if (f13060a.c() == true) goto L10;
        return false;
    L10:
        if (TTNetInit.getTTNetDepend().isCronetPluginInstalled() == true) goto L14;
        p.f6905b = 6;
        return false;
    L14:
        if (f13063d == true) goto L16;
        return true;
    L16:
        if (f13064e == true) goto L21;
        p.f6905b = 7;
        p.f6906c = f13065f;
        return false;
    L21:
        return true;
    }
}
