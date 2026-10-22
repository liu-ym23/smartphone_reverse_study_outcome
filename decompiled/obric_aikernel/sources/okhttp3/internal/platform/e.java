package okhttp3.internal.platform;

import com.bytedance.crash.event.EnsureReportData;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f11965i = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f11966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f11967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Method f11968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Class<?> f11969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Class<?> f11970h;

    private static final class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f11971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f11972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f11973c;

        public a(List<String> r10) {
            Intrinsics.checkNotNullParameter(r10, "protocols");
            this.f11971a = r10;
        }

        public final String a() {
            return this.f11973c;
        }

        public final boolean b() {
            return this.f11972b;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r10, Method r11, Object[] r12) {
            Intrinsics.checkNotNullParameter(r10, "proxy");
            Intrinsics.checkNotNullParameter(r11, EnsureReportData.METHOD);
            if (r12 != null) goto L5;
            r12 = new Object[0];
        L5:
            String r13 = r11.getName();
            Class<?> r14 = r11.getReturnType();
            if (Intrinsics.areEqual(r13, "supports") == false) goto L12;
            if (Intrinsics.areEqual(Boolean.TYPE, r14) == false) goto L12;
            return Boolean.TRUE;
        L12:
            if (Intrinsics.areEqual(r13, "unsupported") == false) goto L18;
            if (Intrinsics.areEqual(Void.TYPE, r14) == false) goto L18;
            this.f11972b = true;
            return null;
        L18:
            if (Intrinsics.areEqual(r13, "protocols") == false) goto L27;
            if (r12.length != 0) goto L22;
            boolean r15 = true;
        L23:
            if (r15 == false) goto L27;
            return this.f11971a;
        L22:
            r15 = false;
        L27:
            if (Intrinsics.areEqual(r13, "selectProtocol") == true) goto L31;
            if (Intrinsics.areEqual(r13, "select") == true) goto L31;
        L48:
            if (Intrinsics.areEqual(r13, "protocolSelected") == true) goto L52;
            if (Intrinsics.areEqual(r13, "selected") == true) goto L52;
        L56:
            return r11.invoke(this, Arrays.copyOf(r12, r12.length));
        L52:
            if (r12.length != 1) goto L56;
            Object r16 = r12[0];
            Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.String");
            this.f11973c = (String) r16;
            return null;
        L31:
            if (Intrinsics.areEqual(String.class, r14) == false) goto L48;
            if (r12.length != 1) goto L48;
            if ((r12[0] instanceof List) == false) goto L48;
            Object r17 = r12[0];
            Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List r18 = (List) r17;
            int r19 = r18.size();
            if (r19 < 0) goto L45;
            int r20 = 0;
        L39:
            Object r21 = r18.get(r20);
            Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.String");
            String r22 = (String) r21;
            if (this.f11971a.contains(r22) == true) goto L41;
            if (r20 == r19) goto L45;
            r20 = r20 + 1;
            goto L39
        L41:
            this.f11973c = r22;
            return r22;
        L45:
            String r23 = this.f11971a.get(0);
            this.f11973c = r23;
            return r23;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final h a() {
            String r11 = System.getProperty("java.specification.version", "unknown");
            Intrinsics.checkNotNullExpressionValue(r11, "jvmVersion");     // Catch: NumberFormatException -> L12
            if (Integer.parseInt(r11) < 9) goto L15;
            return null;
        L15:
            Class<?> r10 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);     // Catch: Throwable -> L11 Throwable -> L11
            Class<?> r12 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);     // Catch: Throwable -> L11 Throwable -> L11
            Class<?> r13 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);     // Catch: Throwable -> L11 Throwable -> L11
            Class<?> r14 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);     // Catch: Throwable -> L11 Throwable -> L11
            Method r15 = r10.getMethod("put", new Class[]{SSLSocket.class, r12});     // Catch: Throwable -> L11 Throwable -> L11
            Method r16 = r10.getMethod("get", new Class[]{SSLSocket.class});     // Catch: Throwable -> L11 Throwable -> L11
            Method r17 = r10.getMethod("remove", new Class[]{SSLSocket.class});     // Catch: Throwable -> L11 Throwable -> L11
            Intrinsics.checkNotNullExpressionValue(r15, "putMethod");     // Catch: Throwable -> L11 Throwable -> L11
            Intrinsics.checkNotNullExpressionValue(r16, "getMethod");     // Catch: Throwable -> L11 Throwable -> L11
            Intrinsics.checkNotNullExpressionValue(r17, "removeMethod");     // Catch: Throwable -> L11 Throwable -> L11
            Intrinsics.checkNotNullExpressionValue(r13, "clientProviderClass");     // Catch: Throwable -> L11 Throwable -> L11
            Intrinsics.checkNotNullExpressionValue(r14, "serverProviderClass");     // Catch: Throwable -> L11 Throwable -> L11
            return new e(r15, r16, r17, r13, r14);
        L11:
            return null;
        }
    }

    static {
        f11965i = new b(null);
    }

    public e(Method r10, Method r11, Method r12, Class<?> r13, Class<?> r14) {
        Intrinsics.checkNotNullParameter(r10, "putMethod");
        Intrinsics.checkNotNullParameter(r11, "getMethod");
        Intrinsics.checkNotNullParameter(r12, "removeMethod");
        Intrinsics.checkNotNullParameter(r13, "clientProviderClass");
        Intrinsics.checkNotNullParameter(r14, "serverProviderClass");
        this.f11966d = r10;
        this.f11967e = r11;
        this.f11968f = r12;
        this.f11969g = r13;
        this.f11970h = r14;
    }

    @Override // okhttp3.internal.platform.h
    public void b(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        this.f11968f.invoke(null, new Object[]{r10});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
        return;
    L8:
        e = move-exception;
        throw new AssertionError("failed to remove ALPN", e);
    L5:
        e = move-exception;
        throw new AssertionError("failed to remove ALPN", e);
    }

    @Override // okhttp3.internal.platform.h
    public void e(SSLSocket r10, String r11, List<? extends Protocol> r12) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        Intrinsics.checkNotNullParameter(r12, "protocols");
        List<String> r13 = h.f11979a.b(r12);
        Object r14 = Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f11969g, this.f11970h}, new a(r13));     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L8
        this.f11966d.invoke(null, new Object[]{r10, r14});     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L8
        return;
    L5:
        e = move-exception;
        throw new AssertionError("failed to set ALPN", e);
    L8:
        e = move-exception;
        throw new AssertionError("failed to set ALPN", e);
    }

    @Override // okhttp3.internal.platform.h
    public String g(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        InvocationHandler r11 = Proxy.getInvocationHandler(this.f11967e.invoke(null, new Object[]{r10}));     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
        a r12 = (a) r11;     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
        if (r12.b() == true) goto L10;
        if (r12.a() != null) goto L10;
        h.k(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
        return null;
    L10:
        if (r12.b() == false) goto L13;
        return null;
    L13:
        return r12.a();
    L14:
        e = move-exception;
        throw new AssertionError("failed to get ALPN selected protocol", e);
    L17:
        e = move-exception;
        throw new AssertionError("failed to get ALPN selected protocol", e);
    }
}
