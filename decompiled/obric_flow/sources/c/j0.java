package c;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor$Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes.dex */
public abstract class j0 {
    public static Retrofit a(Context r5, String r10) {
        okhttp3.g r11 = new okhttp3.g(new File(r5.getCacheDir().getAbsolutePath()));
        zm.z r12 = new zm.z();
        r12.f23549a = new StringBuilder();
        mu.a r13 = new mu.a(r12);
        HttpLoggingInterceptor$Level r14 = HttpLoggingInterceptor$Level.NONE;
        Intrinsics.checkNotNullParameter(r14, "level");
        r13.f20183b = r14;
        okhttp3.l0 r15 = new okhttp3.l0();
        i0 r16 = new i0(r5);
        Intrinsics.checkNotNullParameter(r16, "interceptor");
        r15.f20678c.add(r16);
        Intrinsics.checkNotNullParameter(r13, "interceptor");
        r15.d.add(r13);
        TimeUnit r17 = TimeUnit.SECONDS;
        r15.a(30, r17);
        r15.c(30, r17);
        r15.d(30, r17);
        r15.f20682k = r11;
        OkHttpClient r18 = new OkHttpClient(r15);
        Gson r19 = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder().baseUrl(r10).addConverterFactory(GsonConverterFactory.create(r19)).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(r18).build();
    }

    public static void b(mt.n r5, mt.u r10) {
        mt.n r11 = r5.subscribeOn(ut.e.f22462b);
        nt.d r12 = nt.b.f20308a;
        if (r12 == null) goto L7;
        r11.observeOn(r12).subscribe(r10);
        return;
    L7:
        throw new NullPointerException("scheduler == null");
    }
}
