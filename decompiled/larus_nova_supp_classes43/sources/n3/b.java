package n3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static OkHttpClient a(final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "userName");
        Intrinsics.checkNotNullParameter(r11, "password");
        OkHttpClient.Builder r0 = new OkHttpClient.Builder();
        TimeUnit r1 = TimeUnit.SECONDS;
        return r0.connectTimeout(10, r1).readTimeout(10, r1).writeTimeout(10, r1).callTimeout(30, r1).addInterceptor(new a(r10, r11)).followRedirects(false).build();
    }
}
