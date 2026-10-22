package com.larksuite.framework.http.v2.internal.main;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.http.v2.internal.rust.g;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarkHttpImpl implements com.larksuite.framework.http.v2.b {
    public final com.larksuite.framework.http.v2.internal.rust.d a;
    public final com.larksuite.framework.http.v2.a b;
    public final e28.c c;
    public final Lazy d;
    public final List<WeakReference<com.larksuite.framework.http.v2.c>> e;

    @Override // com.larksuite.framework.http.v2.b
    public final b a(Function1 r6) {
        Intrinsics.checkNotNullParameter(r6, "configureSpec");
        com.larksuite.framework.http.v2.c.b r0 = new com.larksuite.framework.http.v2.c.b(new OkHttpClient.Builder());
        r6.invoke(r0);
        Intrinsics.checkNotNullParameter(r0, "spec");
        OkHttpClient.Builder r7 = r0.a.build().newBuilder();
        if (Intrinsics.areEqual(r0.b, com.larksuite.framework.http.v2.d.c.a) == false) goto L6;
        r7.cookieJar(this.b.a());
    L6:
        if (r0.c == false) goto L9;
        CollectionsKt.removeAll(r7.interceptors(), LarkHttpImpl$doCreateClient$1.INSTANCE);
        r7.addInterceptor(new e28.b(this.c));
    L9:
        if (r0.d == false) goto L12;
        CollectionsKt.removeAll(r7.interceptors(), LarkHttpImpl$doCreateClient$2.INSTANCE);
        r7.addInterceptor(new f());
    L12:
        if (r0.e == false) goto L14;
        CollectionsKt.removeAll(r7.interceptors(), LarkHttpImpl$doCreateClient$3.INSTANCE);
        ListProtector.add(r7.interceptors(), 0, new e());
    L14:
        CollectionsKt.removeAll(r7.interceptors(), LarkHttpImpl$doCreateClient$4.INSTANCE);
        CollectionsKt.removeAll(r7.interceptors(), LarkHttpImpl$doCreateClient$5.INSTANCE);
        CollectionsKt.removeAll(r7.interceptors(), LarkHttpImpl$doCreateClient$6.INSTANCE);
        r7.addInterceptor(new g(r7.build().cookieJar()));
        Iterator r1 = r7.networkInterceptors().iterator();
    L16:
        if (r1.hasNext() == false) goto L18;
        r7.addInterceptor((Interceptor) r1.next());
        goto L16
    L18:
        com.larksuite.framework.http.v2.d r2 = r0.b;
        r7.addInterceptor(new com.larksuite.framework.http.v2.internal.rust.stream.a(0));
        r7.addInterceptor(new com.larksuite.framework.http.v2.internal.rust.a(this.a.a(r2), com.larksuite.framework.http.v2.e.a.contains(Reflection.getOrCreateKotlinClass(r2.getClass()))));
        b r3 = new b(r7.build(), r0, this);
        List<WeakReference<com.larksuite.framework.http.v2.c>> r8 = this.e;
        CopyOnWriteArrayList r9 = (CopyOnWriteArrayList) r8;
        r9.add(new WeakReference(r3));
        return r3;
    }

    public LarkHttpImpl(com.larksuite.framework.http.v2.internal.rust.d r2, com.larksuite.framework.http.v2.a r3, e28.c r4) {
        Intrinsics.checkNotNullParameter(r2, "clientProvider");
        Intrinsics.checkNotNullParameter(r3, "larkCookies");
        Intrinsics.checkNotNullParameter(r4, "uaSupporter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(new LarkHttpImpl$defaultClient$2(this));
        this.e = new CopyOnWriteArrayList();
    }
}
