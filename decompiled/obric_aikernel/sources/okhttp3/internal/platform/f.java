package okhttp3.internal.platform;

import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJdk9Platform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Jdk9Platform.kt\nokhttp3/internal/platform/Jdk9Platform\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,89:1\n37#2,2:90\n*S KotlinDebug\n*F\n+ 1 Jdk9Platform.kt\nokhttp3/internal/platform/Jdk9Platform\n*L\n36#1:90,2\n*E\n"})
public class f extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11974d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f11975e = false;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final f a() {
            if (b() == true) goto L7;
            return null;
        L7:
            return new f();
        }

        public final boolean b() {
            return f.q();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Integer r10 = null;
        f11974d = new a(0 == true ? 1 : 0);
        String r11 = System.getProperty("java.specification.version");
        if (r11 == null) goto L5;
        r10 = StringsKt.toIntOrNull(r11);
    L5:
        boolean r12 = true;
        if (r10 != null) goto L8;
        SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);     // Catch: NoSuchMethodException -> L14
    L12:
        f11975e = r12;
        return;
    L10:
        r12 = false;
        goto L12
    L8:
        if (r10.intValue() < 9) goto L10;
        goto L10
    }

    public f() {
    }

    public static final /* synthetic */ boolean q() {
        return f11975e;
    }

    @Override // okhttp3.internal.platform.h
    public void e(SSLSocket r10, String r11, List<Protocol> r12) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        Intrinsics.checkNotNullParameter(r12, "protocols");
        SSLParameters r13 = r10.getSSLParameters();
        r13.setApplicationProtocols((String[]) h.f11979a.b(r12).toArray(new String[0]));
        r10.setSSLParameters(r13);
    }

    @Override // okhttp3.internal.platform.h
    public String g(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        String r11 = r10.getApplicationProtocol();     // Catch: UnsupportedOperationException -> L11
        if (r11 != null) goto L6;
        boolean r12 = true;
    L7:
        if (r12 == false) goto L10;
        return null;
    L10:
        return r11;
    L6:
        r12 = Intrinsics.areEqual(r11, "");     // Catch: UnsupportedOperationException -> L11
    L15:
        return null;
    }

    @Override // okhttp3.internal.platform.h
    public X509TrustManager p(SSLSocketFactory r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
