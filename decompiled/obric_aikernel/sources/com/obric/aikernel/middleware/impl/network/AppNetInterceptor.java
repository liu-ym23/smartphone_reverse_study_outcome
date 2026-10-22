package com.obric.aikernel.middleware.impl.network;

import com.bytedance.retrofit2.a0;
import java.net.URL;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n4.c;
import okhttp3.s;
import q4.a;

/* JADX INFO: loaded from: classes2.dex */
public final class AppNetInterceptor implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AppNetInterceptor f4559c = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f4560g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<String> f4561h = null;

    static {
        f4559c = new AppNetInterceptor();
        f4560g = LazyKt.lazy(AppNetInterceptor$packageName$2.INSTANCE);
        f4561h = CollectionsKt.emptyList();
    }

    private AppNetInterceptor() {
    }

    private final String b() {
        return (String) f4560g.getValue();
    }

    private final boolean c(String r10) {
        return false;
    }

    private final c d(c r10) {
        s.b r11 = s.f12025k;
        String r12 = r10.G();
        Intrinsics.checkNotNullExpressionValue(r12, "request.url");
        s r13 = r11.f(r12);
        if (r13 == null) goto L18;
        s.a r14 = r13.j();
        if (r14 == null) goto L18;
        AppNetInterceptor r15 = f4559c;
        String r16 = r10.G();
        Intrinsics.checkNotNullExpressionValue(r16, "request.url");
        if (r15.c(r16) == true) goto L9;
        r14.a("package_name", r15.b());
    L9:
        s r17 = r14.b();
        if (r17 == null) goto L18;
        URL r18 = r17.u();
        if (r18 == null) goto L18;
        String r19 = r18.toString();
        if (r19 == null) goto L18;
        c r20 = r10.O().f(r19).a();
        Intrinsics.checkNotNullExpressionValue(r20, "request.newBuilder().url(newUrl).build()");
        return r20;
    L18:
        return r10;
    }

    @Override // q4.a
    public a0<?> a(a.InterfaceC0283a r10) {
        Intrinsics.checkNotNullParameter(r10, "chain");
        c r11 = r10.a();
        Intrinsics.checkNotNullExpressionValue(r11, "request");
        a0<?> r12 = r10.c(d(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "chain.proceed(transformRequest(request))");
        return r12;
    }
}
