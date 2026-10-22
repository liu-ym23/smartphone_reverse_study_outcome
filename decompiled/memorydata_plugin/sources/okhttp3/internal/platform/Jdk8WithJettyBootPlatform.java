package okhttp3.internal.platform;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform;", "Lokhttp3/internal/platform/Platform;", "putMethod", "Ljava/lang/reflect/Method;", "getMethod", "removeMethod", "clientProviderClass", "Ljava/lang/Class;", "serverProviderClass", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "socket", "AlpnProvider", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = null;
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J0\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0096\u0002¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$AlpnProvider;", "Ljava/lang/reflect/InvocationHandler;", "protocols", "", "", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "getSelected$okhttp", "()Ljava/lang/String;", "setSelected$okhttp", "(Ljava/lang/String;)V", "unsupported", "", "getUnsupported$okhttp", "()Z", "setUnsupported$okhttp", "(Z)V", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 1, 15})
    private static final class AlpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public AlpnProvider(List<String> r3) {
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "protocols");
            this.protocols = r4;
        }

        public final String getSelected$okhttp() {
            return this.selected;
        }

        public final boolean getUnsupported$okhttp() {
            return this.unsupported;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r8, Method r9, Object[] r10) {
            Intrinsics.checkParameterIsNotNull(r8, "proxy");
            Intrinsics.checkParameterIsNotNull(r9, "method");
            if (r10 != null) goto L6;
            r10 = new Object[0];
        L6:
            String r0 = r9.getName();
            Class<?> r1 = r9.getReturnType();
            if (Intrinsics.areEqual(r0, "supports") == false) goto L13;
            if (Intrinsics.areEqual(Boolean.TYPE, r1) == false) goto L13;
            return true;
        L13:
            if (Intrinsics.areEqual(r0, "unsupported") == false) goto L19;
            if (Intrinsics.areEqual(Void.TYPE, r1) == false) goto L19;
            this.unsupported = true;
            return null;
        L19:
            if (Intrinsics.areEqual(r0, "protocols") == false) goto L28;
            if (r10.length != 0) goto L23;
            boolean r2 = true;
        L24:
            if (r2 == false) goto L28;
            return this.protocols;
        L23:
            r2 = false;
        L28:
            if (Intrinsics.areEqual(r0, "selectProtocol") == true) goto L32;
            if (Intrinsics.areEqual(r0, "select") == true) goto L32;
        L57:
            if (Intrinsics.areEqual(r0, "protocolSelected") == true) goto L61;
            if (Intrinsics.areEqual(r0, BuildConfig.FLAVOR) == true) goto L61;
        L69:
            return r9.invoke(this, Arrays.copyOf(r10, r10.length));
        L61:
            if (r10.length != 1) goto L69;
            Object r11 = r10[0];
            if (r11 == null) goto L67;
            this.selected = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin");
            return null;
        L67:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        L32:
            if (Intrinsics.areEqual(String.class, r1) == false) goto L57;
            if (r10.length != 1) goto L57;
            if (ZeusTransformUtils.instanceOf(r10[0], List.class) == false) goto L57;
            Object r12 = r10[0];
            if (r12 == null) goto L55;
            List r13 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
            int r14 = r13.size();
            if (r14 < 0) goto L52;
            int r3 = 0;
        L42:
            Object r4 = r13.get(r3);
            if (r4 == null) goto L51;
            String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
            if (this.protocols.contains(r5) == true) goto L46;
            if (r3 == r14) goto L52;
            r3 = r3 + 1;
            goto L42
        L46:
            this.selected = r5;
            return r5;
        L51:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        L52:
            String r15 = (String) ZeusTransformUtils.preCheckCast(this.protocols.get(0), String.class, "com.obric.memorydata.plugin");
            this.selected = r15;
            return r15;
        L55:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<*>");
        }

        public final void setSelected$okhttp(String r1) {
            this.selected = r1;
        }

        public final void setUnsupported$okhttp(boolean r1) {
            this.unsupported = r1;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Platform buildIfSupported() {
            String r11 = System.getProperty("java.specification.version", "unknown");
            Intrinsics.checkExpressionValueIsNotNull(r11, "jvmVersion");     // Catch: NumberFormatException -> L10
            if (Integer.parseInt(r11) < 9) goto L13;
            return null;
        L13:
            Class<?> r2 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);     // Catch: Throwable -> L9
            Class<?> r3 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);     // Catch: Throwable -> L9
            Class<?> r9 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);     // Catch: Throwable -> L9
            Class<?> r10 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);     // Catch: Throwable -> L9
            Method r12 = r2.getMethod("put", new Class[]{SSLSocket.class, r3});     // Catch: Throwable -> L9
            Method r7 = r2.getMethod("get", new Class[]{SSLSocket.class});     // Catch: Throwable -> L9
            Method r8 = r2.getMethod("remove", new Class[]{SSLSocket.class});     // Catch: Throwable -> L9
            Intrinsics.checkExpressionValueIsNotNull(r12, "putMethod");     // Catch: Throwable -> L9
            Intrinsics.checkExpressionValueIsNotNull(r7, "getMethod");     // Catch: Throwable -> L9
            Intrinsics.checkExpressionValueIsNotNull(r8, "removeMethod");     // Catch: Throwable -> L9
            Intrinsics.checkExpressionValueIsNotNull(r9, "clientProviderClass");     // Catch: Throwable -> L9
            Intrinsics.checkExpressionValueIsNotNull(r10, "serverProviderClass");     // Catch: Throwable -> L9
            return (Platform) ZeusTransformUtils.preCheckCast(new Jdk8WithJettyBootPlatform(r12, r7, r8, r9, r10), Platform.class, "com.obric.memorydata.plugin");
        L9:
            return null;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Jdk8WithJettyBootPlatform(Method r2, Method r3, Method r4, Class<?> r5, Class<?> r6) {
        Intrinsics.checkParameterIsNotNull(r2, "putMethod");
        Intrinsics.checkParameterIsNotNull(r3, "getMethod");
        Intrinsics.checkParameterIsNotNull(r4, "removeMethod");
        Intrinsics.checkParameterIsNotNull(r5, "clientProviderClass");
        Intrinsics.checkParameterIsNotNull(r6, "serverProviderClass");
        this.putMethod = r2;
        this.getMethod = r3;
        this.removeMethod = r4;
        this.clientProviderClass = r5;
        this.serverProviderClass = r6;
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(SSLSocket r6) {
        Intrinsics.checkParameterIsNotNull(r6, "sslSocket");
        this.removeMethod.invoke(null, new Object[]{r6});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
        return;
    L8:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("failed to remove ALPN", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("failed to remove ALPN", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r8, String r9, List<? extends Protocol> r10) {
        List<? extends Protocol> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r8, "sslSocket");
        Intrinsics.checkParameterIsNotNull(r11, "protocols");
        List<String> r12 = Platform.Companion.alpnProtocolNames(r11);
        Object r13 = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, (InvocationHandler) ZeusTransformUtils.preCheckCast(new AlpnProvider(r12), InvocationHandler.class, "com.obric.memorydata.plugin"));     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L8
        this.putMethod.invoke(null, new Object[]{r8, r13});     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L8
        return;
    L5:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("failed to set ALPN", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L8:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("failed to set ALPN", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket r5) {
        Intrinsics.checkParameterIsNotNull(r5, "socket");
        InvocationHandler r4 = Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[]{r5}));     // Catch: IllegalAccessException -> L18 InvocationTargetException -> L21
        if (r4 == null) goto L17;
        AlpnProvider r6 = (AlpnProvider) ZeusTransformUtils.preCheckCast(r4, AlpnProvider.class, "com.obric.memorydata.plugin");     // Catch: IllegalAccessException -> L18 InvocationTargetException -> L21
        if (r6.getUnsupported$okhttp() == true) goto L12;
        if (r6.getSelected$okhttp() != null) goto L12;
        Platform.Companion.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);     // Catch: IllegalAccessException -> L18 InvocationTargetException -> L21
        return null;
    L12:
        if (r6.getUnsupported$okhttp() == false) goto L15;
        return null;
    L15:
        return r6.getSelected$okhttp();
    L17:
        throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");     // Catch: IllegalAccessException -> L18 InvocationTargetException -> L21
    L18:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("failed to get ALPN selected protocol", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L21:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("failed to get ALPN selected protocol", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
