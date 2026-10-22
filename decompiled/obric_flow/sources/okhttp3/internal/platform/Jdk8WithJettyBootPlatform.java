package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\rH\u0016R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform;", "Lokhttp3/internal/platform/Platform;", "putMethod", "Ljava/lang/reflect/Method;", "getMethod", "removeMethod", "clientProviderClass", "Ljava/lang/Class;", "serverProviderClass", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "AlpnProvider", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = null;
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J0\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0096\u0002¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$AlpnProvider;", "Ljava/lang/reflect/InvocationHandler;", "protocols", "", "", "(Ljava/util/List;)V", "selected", "getSelected", "()Ljava/lang/String;", "setSelected", "(Ljava/lang/String;)V", "unsupported", "", "getUnsupported", "()Z", "setUnsupported", "(Z)V", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class AlpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public AlpnProvider(List<String> r5) {
            Intrinsics.checkNotNullParameter(r5, "protocols");
            this.protocols = r5;
        }

        public final String getSelected() {
            return this.selected;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r10, Method r11, Object[] r12) throws Throwable {
            Intrinsics.checkNotNullParameter(r10, "proxy");
            Intrinsics.checkNotNullParameter(r11, "method");
            if (r12 != null) goto L6;
            r12 = new Object[0];
        L6:
            String r5 = r11.getName();
            Class<?> r13 = r11.getReturnType();
            if (Intrinsics.areEqual(r5, "supports") == false) goto L13;
            if (Intrinsics.areEqual(Boolean.TYPE, r13) == false) goto L13;
            return Boolean.TRUE;
        L13:
            if (Intrinsics.areEqual(r5, "unsupported") == false) goto L19;
            if (Intrinsics.areEqual(Void.TYPE, r13) == false) goto L19;
            this.unsupported = true;
            return null;
        L19:
            if (Intrinsics.areEqual(r5, "protocols") == false) goto L25;
            if (r12.length != 0) goto L25;
            return this.protocols;
        L25:
            if (Intrinsics.areEqual(r5, "selectProtocol") == true) goto L29;
            if (Intrinsics.areEqual(r5, "select") == true) goto L29;
        L53:
            if (Intrinsics.areEqual(r5, "protocolSelected") == true) goto L57;
            if (Intrinsics.areEqual(r5, "selected") == true) goto L57;
        L65:
            return r11.invoke(this, Arrays.copyOf(r12, r12.length));
        L57:
            if (r12.length != 1) goto L65;
            Object r14 = r12[0];
            if (r14 == null) goto L63;
            this.selected = (String) r14;
            return null;
        L63:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L29:
            if (Intrinsics.areEqual(String.class, r13) == false) goto L53;
            if (r12.length != 1) goto L53;
            Object r15 = r12[0];
            if ((r15 instanceof List) == false) goto L53;
            if (r15 == null) goto L51;
            List r16 = (List) r15;
            int r17 = r16.size();
            if (r17 < 0) goto L48;
            int r18 = 0;
        L38:
            Object r19 = r16.get(r18);
            if (r19 == null) goto L47;
            String r20 = (String) r19;
            if (this.protocols.contains(r20) == true) goto L42;
            if (r18 == r17) goto L48;
            r18 = r18 + 1;
            goto L38
        L42:
            this.selected = r20;
            return r20;
        L47:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L48:
            String r21 = this.protocols.get(0);
            this.selected = r21;
            return r21;
        L51:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
        }

        public final void setSelected(String r5) {
            this.selected = r5;
        }

        public final void setUnsupported(boolean r5) {
            this.unsupported = r5;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final Platform buildIfSupported() {
            if (Integer.parseInt(System.getProperty("java.specification.version", "unknown")) < 9) goto L14;
            return null;
        L14:
            Class<?> r5 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);     // Catch: Throwable -> L10
            Class<?> r10 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);     // Catch: Throwable -> L10
            Class<?> r11 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);     // Catch: Throwable -> L10
            Class<?> r12 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);     // Catch: Throwable -> L10
            return new Jdk8WithJettyBootPlatform(r5.getMethod("put", new Class[]{SSLSocket.class, r10}), r5.getMethod("get", new Class[]{SSLSocket.class}), r5.getMethod("remove", new Class[]{SSLSocket.class}), r11, r12);
        L10:
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Jdk8WithJettyBootPlatform(Method r5, Method r10, Method r11, Class<?> r12, Class<?> r13) {
        Intrinsics.checkNotNullParameter(r5, "putMethod");
        Intrinsics.checkNotNullParameter(r10, "getMethod");
        Intrinsics.checkNotNullParameter(r11, "removeMethod");
        Intrinsics.checkNotNullParameter(r12, "clientProviderClass");
        Intrinsics.checkNotNullParameter(r13, "serverProviderClass");
        this.putMethod = r5;
        this.getMethod = r10;
        this.removeMethod = r11;
        this.clientProviderClass = r12;
        this.serverProviderClass = r13;
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(SSLSocket r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        this.removeMethod.invoke(null, new Object[]{r5});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7
        return;
    L7:
        e = move-exception;
        throw new AssertionError("failed to remove ALPN", e);
    L5:
        e = move-exception;
        throw new AssertionError("failed to remove ALPN", e);
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r5, String r10, List<? extends Protocol> r11) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        Intrinsics.checkNotNullParameter(r11, "protocols");
        List<String> r12 = Platform.Companion.alpnProtocolNames(r11);
        Object r13 = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(r12));     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7
        this.putMethod.invoke(null, new Object[]{r5, r13});     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7
        return;
    L5:
        e = move-exception;
        throw new AssertionError("failed to set ALPN", e);
    L7:
        e = move-exception;
        throw new AssertionError("failed to set ALPN", e);
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        InvocationHandler r11 = Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[]{r10}));     // Catch: IllegalAccessException -> L11 InvocationTargetException -> L13
        if (r11 == null) goto L21;
        AlpnProvider r12 = (AlpnProvider) r11;     // Catch: IllegalAccessException -> L11 InvocationTargetException -> L13
        if (r12.getUnsupported() == true) goto L16;
        if (r12.getSelected() != null) goto L16;
        Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);     // Catch: IllegalAccessException -> L11 InvocationTargetException -> L13
        return null;
    L16:
        if (r12.getUnsupported() == false) goto L19;
        return null;
    L19:
        return r12.getSelected();
    L21:
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");     // Catch: IllegalAccessException -> L11 InvocationTargetException -> L13
    L11:
        e = move-exception;
        throw new AssertionError("failed to get ALPN selected protocol", e);
    L13:
        e = move-exception;
        throw new AssertionError("failed to get ALPN selected protocol", e);
    }
}
