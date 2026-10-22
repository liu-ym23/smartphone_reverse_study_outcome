package nc;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NewApi"})
@SourceDebugExtension({"SMAP\nAndroid10SocketAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Android10SocketAdapter.kt\nokhttp3/internal/platform/android/Android10SocketAdapter\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,77:1\n37#2,2:78\n*S KotlinDebug\n*F\n+ 1 Android10SocketAdapter.kt\nokhttp3/internal/platform/android/Android10SocketAdapter\n*L\n60#1:78,2\n*E\n"})
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0252a f11338a = null;

    /* JADX INFO: renamed from: nc.a$a, reason: collision with other inner class name */
    public static final class C0252a {
        private C0252a() {
        }

        public /* synthetic */ C0252a(DefaultConstructorMarker r10) {
            this();
        }

        public final k a() {
            if (b() == true) goto L7;
            return null;
        L7:
            return new a();
        }

        public final boolean b() {
            if (okhttp3.internal.platform.h.f11979a.h() == true) goto L5;
        L7:
            return false;
        L5:
            if (Build.VERSION.SDK_INT < 29) goto L7;
            return true;
        }
    }

    static {
        f11338a = new C0252a(null);
    }

    public a() {
    }

    @Override // nc.k
    public boolean a(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        return SSLSockets.isSupportedSocket(r10);
    }

    @Override // nc.k
    @SuppressLint({"NewApi"})
    public String b(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        String r11 = r10.getApplicationProtocol();
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        return r11;
    L5:
        r12 = Intrinsics.areEqual(r11, "");
        goto L6
    }

    @Override // nc.k
    public X509TrustManager c(SSLSocketFactory r10) {
        return k.a.b(this, r10);
    }

    @Override // nc.k
    public boolean d(SSLSocketFactory r10) {
        return k.a.a(this, r10);
    }

    @Override // nc.k
    @SuppressLint({"NewApi"})
    public void e(SSLSocket r10, String r11, List<? extends Protocol> r12) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        Intrinsics.checkNotNullParameter(r12, "protocols");
        SSLSockets.setUseSessionTickets(r10, true);     // Catch: IllegalArgumentException -> L5
        SSLParameters r13 = r10.getSSLParameters();     // Catch: IllegalArgumentException -> L5
        r13.setApplicationProtocols((String[]) okhttp3.internal.platform.h.f11979a.b(r12).toArray(new String[0]));     // Catch: IllegalArgumentException -> L5
        r10.setSSLParameters(r13);     // Catch: IllegalArgumentException -> L5
        return;
    L5:
        e = move-exception;
        throw new IOException("Android internal error", e);
    }

    @Override // nc.k
    public boolean isSupported() {
        return f11338a.b();
    }
}
