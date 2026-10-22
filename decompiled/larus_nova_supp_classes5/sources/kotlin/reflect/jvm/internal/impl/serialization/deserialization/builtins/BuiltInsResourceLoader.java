package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.a;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class BuiltInsResourceLoader {
    public BuiltInsResourceLoader() {
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_kotlin_reflect_jvm_internal_impl_serialization_deserialization_builtins_BuiltInsResourceLoader_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r7) throws IOException {
        String r3 = r7.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r4 = r7.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (a.c(r3, r4) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r3 + " path=" + r4);     // Catch: Throwable -> L8 IOException -> L12
        a.b(a.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r7);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r7.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public final InputStream loadResource(String r2) {
        Intrinsics.checkNotNullParameter(r2, DownloadConstants.PATH_KEY);
        ClassLoader r0 = BuiltInsResourceLoader.class.getClassLoader();
        if (r0 == null) goto L5;
        URL r3 = r0.getResource(r2);
        if (r3 != null) goto L10;
        return null;
    L10:
        URLConnection r4 = INVOKEVIRTUAL_kotlin_reflect_jvm_internal_impl_serialization_deserialization_builtins_BuiltInsResourceLoader_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r3);
        r4.setUseCaches(false);
        return r4.getInputStream();
    L5:
        return ClassLoader.getSystemResourceAsStream(r2);
    }
}
