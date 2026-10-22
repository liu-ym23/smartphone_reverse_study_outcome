package w6;

import android.webkit.CookieManager;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ttnet.TTNetInit;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f13020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f13021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f13022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static f f13023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile AtomicBoolean f13024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f13025f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static CountDownLatch f13026g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static b f13027h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static InterfaceC0187e f13028i;

    public interface a<T extends w6.a> {
        String addCommonParams(String r8, boolean r10);

        String addRequestVertifyParams(String r8, boolean r10, Object... r11);

        void onTryInit();
    }

    public interface b<T extends w6.b> {
    }

    public interface c {
    }

    public interface d {
    }

    /* JADX INFO: renamed from: w6.e$e, reason: collision with other inner class name */
    public interface InterfaceC0187e {
        List<String> a(CookieManager r8, c7.a r10, URI r11);

        List<String> b(String r8);
    }

    public interface f<T extends w6.a> {
        void monitorApiError(long r8, long r10, String r11, String r12, T r13, Throwable r14);

        void monitorApiOk(long r8, long r10, String r11, String r12, T r13);
    }

    static {
        f13024e = new AtomicBoolean(false);
        f13025f = new Object();
        f13026g = new CountDownLatch(1);
    }

    public e() {
    }

    public static void a(String r8) {
        if (r5.f.b(r8) == false) goto L5;
        return;
    L5:
        b r10 = f13027h;
        if (r10 == null) goto L22;
        x8.c r11 = (x8.c) r10;
        if (r5.f.b(r8) == true) goto L23;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L11:
        if (r11.f13678a == false) goto L13;
        r11.r();     // Catch: Throwable -> L15
    L18:
        return;
    L13:
        r11.q();     // Catch: Throwable -> L15
        goto L18
    L23:
        return;
    }

    public static void b(long r10, long r11, String r13, String r14, w6.a r15, Throwable r16) {
        if (r5.f.b(r13) == true) goto L13;
        if (r16 == null) goto L15;
        f r8 = f13023d;
        if (r8 != null) goto L9;
        return;
    L9:
        if (r15.f13014y == false) goto L11;
        r15.C.set(true);
    L11:
        r8.monitorApiError(r10, r11, r13, r14, r15, r16);
        return;
    L15:
        return;
    }

    public static void c(String r8, String r10, boolean r11) {
        if (r5.f.b(r8) == false) goto L5;
        return;
    L5:
        if (r5.f.b(r10) == true) goto L37;
        b r12 = f13027h;
        if (r12 == null) goto L35;
        CopyOnWriteArrayList r13 = ((x8.c) r12).D;
        if (r13.isEmpty() == true) goto L38;
        Iterator r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L40;
        String r15 = (String) r14.next();
        if (r5.f.b(r15) == true) goto L14;
        if (r8.endsWith(r15) == false) goto L14;
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L27
        r16.put(WsConstants.KEY_CONNECTION_URL, r8 + r10);     // Catch: Throwable -> L27
        r16.put("replace", r11);     // Catch: Throwable -> L27
        TTNetInit.monitorLogSend("api_http", r16);     // Catch: Throwable -> L27
    L21:
        if (TTNetInit.apiHttpInterceptEnabled() == false) goto L36;
        if (r11 == false) goto L25;
        return;
    L25:
        throw new b7.d();
    L36:
        return;
    L40:
        return;
    L38:
        return;
    L35:
        return;
    }

    public static void d(long r8, long r10, String r12, String r13, w6.a r14) {
        f r11 = f13023d;
        if (r5.f.b(r12) == false) goto L5;
        return;
    L5:
        if (r8 <= 0) goto L17;
        if (r11 != null) goto L8;
        return;
    L8:
        if (r14.f13014y == false) goto L12;
        if (r14.C.get() == false) goto L12;
        return;
    L12:
        if (r14.f13014y == false) goto L14;
        r14.C.set(true);
    L14:
        r11.monitorApiOk(r8, r10, r12, r13, r14);
        return;
    }

    public static void e() {
        if (f13024e.get() != true) goto L5;
        return;
    L5:
        f13024e.getAndSet(true);
        CountDownLatch r8 = f13026g;
        if (r8 != null) goto L8;
        return;
    L8:
        if (r8.getCount() <= 0) goto L12;
        f13026g.countDown();
        return;
    }

    public static CookieManager f() {
        Object r8 = f13025f;
        monitor-enter(r8);
    L21:
        th = move-exception;
        throw th;
    L6:
        if (f13024e.get() == false) goto L26;
    L13:
        monitor-exit(r8);     // Catch: Throwable -> L21
        CookieManager r10 = CookieManager.getInstance();     // Catch: Throwable -> L19
        if (r10.acceptCookie() == true) goto L34;
        r10.setAcceptCookie(true);     // Catch: Throwable -> L24
        return r10;
    L34:
        return r10;
    L36:
        return r10;
    L19:
        return null;
    L26:
        CountDownLatch r11 = f13026g;     // Catch: Exception -> L25 Throwable -> L21
        if (r11 == null) goto L12;
        r11.await(5000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L25 Throwable -> L21
        if (f13026g.getCount() != 1) goto L12;
        f13026g.countDown();     // Catch: Exception -> L25 Throwable -> L21
    L12:
        f13024e.getAndSet(true);     // Catch: Throwable -> L21
        goto L13
    }
}
