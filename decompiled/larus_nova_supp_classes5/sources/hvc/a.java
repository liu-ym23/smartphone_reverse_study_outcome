package hvc;

import android.net.ssl.SSLSockets;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.Protocol;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a extends b {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class t() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.android.org.conscrypt.SSLParametersImpl");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.android.org.conscrypt.SSLParametersImpl");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.android.org.conscrypt.SSLParametersImpl");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.android.org.conscrypt.SSLParametersImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.android.org.conscrypt.SSLParametersImpl");
    }

    public a(Class<?> r7) {
        super(r7, null, null, null, null);
    }

    @Override // hvc.b, hvc.g
    @Nullable
    public final String j(SSLSocket r2) {
        String r3 = r2.getApplicationProtocol();
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isEmpty() == true) goto L10;
        return r3;
    L10:
        return null;
    }

    @Override // hvc.b, hvc.g
    public final void g(SSLSocket r2, String r3, List<Protocol> r4) throws IOException {
    L7:
        e = move-exception;
        throw new IOException("Android internal error", e);
    L3:
        if (SSLSockets.isSupportedSocket(r2) == false) goto L5;
        SSLSockets.setUseSessionTickets(r2, true);     // Catch: IllegalArgumentException -> L7
    L5:
        SSLParameters r5 = r2.getSSLParameters();     // Catch: IllegalArgumentException -> L7
        ArrayList r6 = (ArrayList) g.c(r4);     // Catch: IllegalArgumentException -> L7
        r5.setApplicationProtocols((String[]) r6.toArray(new String[0]));     // Catch: IllegalArgumentException -> L7
        r2.setSSLParameters(r5);     // Catch: IllegalArgumentException -> L7
    }
}
