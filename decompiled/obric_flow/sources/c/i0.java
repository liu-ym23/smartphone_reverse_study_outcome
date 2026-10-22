package c;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;

/* JADX INFO: loaded from: classes.dex */
public final class i0 implements okhttp3.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1057a;

    public i0(Context r5) {
        this.f1057a = r5;
    }

    @Override // okhttp3.g0
    public final okhttp3.s0 intercept(okhttp3.f0 r10) {
        Request r5 = r10.request();
        boolean r11 = v.b(this.f1057a);
        if (r11 == true) goto L10;
        m.i("NetWorks", "getInterceptor intercept isNetConnected= " + r11);
        okhttp3.n0 r12 = r5.newBuilder();
        okhttp3.h r13 = okhttp3.h.f20647n;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "cacheControl");
        String r14 = r13.toString();
        if (r14.length() != 0) goto L7;
        r12.e("Cache-Control");
    L8:
        r5 = r12.b();
        goto L10
    L7:
        r12.c("Cache-Control", r14);
    L10:
        if (r11 == false) goto L13;
        okhttp3.r0 r15 = r10.proceed(r5).f();
        Intrinsics.checkNotNullParameter("Pragma", "name");
        r15.f.f("Pragma");
        Intrinsics.checkNotNullParameter("Cache-Control", "name");
        Intrinsics.checkNotNullParameter("public, max-age=3600", "value");
        okhttp3.b0 r16 = r15.f;
        r16.getClass();
        Intrinsics.checkNotNullParameter("Cache-Control", "name");
        Intrinsics.checkNotNullParameter("public, max-age=3600", "value");
        okhttp3.z.b("Cache-Control");
        okhttp3.z.c("public, max-age=3600", "Cache-Control");
        r16.f("Cache-Control");
        r16.c("Cache-Control", "public, max-age=3600");
        return r15.a();
    L13:
        okhttp3.r0 r17 = r10.proceed(r5).f();
        Intrinsics.checkNotNullParameter("Pragma", "name");
        r17.f.f("Pragma");
        Intrinsics.checkNotNullParameter("Cache-Control", "name");
        Intrinsics.checkNotNullParameter("public, only-if-cached, max-stale=86400", "value");
        okhttp3.b0 r18 = r17.f;
        r18.getClass();
        Intrinsics.checkNotNullParameter("Cache-Control", "name");
        Intrinsics.checkNotNullParameter("public, only-if-cached, max-stale=86400", "value");
        okhttp3.z.b("Cache-Control");
        okhttp3.z.c("public, only-if-cached, max-stale=86400", "Cache-Control");
        r18.f("Cache-Control");
        r18.c("Cache-Control", "public, only-if-cached, max-stale=86400");
        return r17.a();
    }
}
