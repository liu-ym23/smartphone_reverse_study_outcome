package x18;

import android.content.Context;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.larksuite.framework.utils.Reflect;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.g;
import okhttp3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements b {
    public b28.a b;
    public final OkHttpClient c;

    public final b28.a d() {
        if (this.b != null) goto L21;
        Dispatcher r0 = this.c.dispatcher();
        b28.a r1 = new b28.a(r0.executorService());
        int r2 = r0.getMaxRequests();
        if (r2 < 1) goto L19;
        monitor-enter(r1);
        r1.a = r2;     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        r1.f();
        r1.i(r0.getMaxRequestsPerHost());
        r1.h((Runnable) new Reflect(r0).e("idleCallback", new Class[]{Runnable.class}).a);     // Catch: Reflect.ReflectException -> L12
        this.b = r1;
    L12:
        e = move-exception;
        Log.e("DispatcherAdapter", e);
        throw e;
    L15:
        th = move-exception;
        throw th;
    L19:
        throw new IllegalArgumentException("max < 1: " + r2);
    L21:
        return this.b;
    }

    public d(b.a r8) {
        OkHttpClient.Builder r0 = new OkHttpClient.Builder();
        if (r8.c == false) goto L5;
        Context r1 = r8.a;
        r0.cookieJar(new d28.c(r1, new SetCookieCache(), new d28.d(r1, d28.a.b(r1, "CookiePersistence_" + z.b(r1)), d28.a.b(r1, "CookiePersistence"))));
    L5:
        List<y18.b> r2 = r8.b;
        ArrayList r3 = new ArrayList();
        Iterator r4 = ((ArrayList) r2).iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        y18.b r5 = (y18.b) r4.next();
        if ((r5 instanceof y18.a) == false) goto L7;
        r3.add(new c((y18.a) r5));
        goto L7
    L12:
        if (r3.size() <= 0) goto L17;
        Iterator r6 = r3.iterator();
    L15:
        if (r6.hasNext() == false) goto L17;
        r0.addInterceptor((Interceptor) r6.next());
    L17:
        r0.connectTimeout(r8.d, r8.e).readTimeout(r8.f, r8.g).writeTimeout(r8.h, r8.i);
        this.c = r0.build();
    }

    @Override // x18.b
    public final List<a28.a> a(String r6) {
        List r7 = this.c.cookieJar().a(HttpUrl.parse(r6));
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L18;
        g r1 = (g) r8.next();
        a28.a.C0001a r2 = new a28.a.C0001a();
        r2.c(r1.a);
        r2.e(r1.b);
        r2.b(r1.c);
        r2.a(r1.d);
        r2.d(r1.e);
        if (r1.f == false) goto L9;
        r2.f = true;
    L9:
        if (r1.g == false) goto L12;
        r2.g = true;
    L12:
        if (r1.i == false) goto L15;
        r2.g = true;
    L15:
        if (r1.h == false) goto L17;
        r2.g = true;
    L17:
        r0.add(new a28.a(r2));
        goto L4
    L18:
        return r0;
    }

    @Override // x18.b
    public final com.larksuite.framework.http.call.b c(z18.a r2) {
        return new com.larksuite.framework.http.call.b(this, r2);
    }

    @Override // x18.b
    public final b28.b newCall(Request r2) {
        return b28.b.c(this, r2, false);
    }

    @Override // x18.b
    public final void b(String r7, List<a28.a> r8) {
        HttpUrl r9 = HttpUrl.parse(r7);
        if (r9 != null) goto L5;
        Log.w("OkHttpClientImpl", "saveCookie: failed to get http url");
    L5:
        h r0 = this.c.cookieJar();
        ArrayList r1 = new ArrayList();
        Iterator<a28.a> r10 = r8.iterator();
    L7:
        if (r10.hasNext() == false) goto L18;
        a28.a r2 = r10.next();
        g.a r3 = new g.a();
        r3.c(r2.a);
        r3.e(r2.b);
        r3.b(r2.c);
        r3.a(r2.d, false);
        r3.d(r2.e);
        if (r2.f == false) goto L12;
        r3.f = true;
    L12:
        if (r2.g == false) goto L15;
        r3.g = true;
    L15:
        if (r2.h == false) goto L17;
        r3.g = true;
    L17:
        r1.add(new g(r3));
        goto L7
    L18:
        r0.b(r9, r1);
    }
}
