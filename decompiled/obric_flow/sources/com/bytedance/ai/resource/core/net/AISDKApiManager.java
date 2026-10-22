package com.bytedance.ai.resource.core.net;

import a3.f;
import ai.g0;
import bi.b;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import r9.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/net/AISDKApiManager;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AISDKApiManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f2670a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f2671b = null;

    static {
        f2670a = LazyKt.lazy(new f(17));
        f2671b = LazyKt.lazy(new f(18));
    }

    public static final AIPackageNetApi a() {
        g0 r5 = new g0(0);
        u0.a r10 = s0.a.f21800c;
        if (r10 != null) goto L5;
    L7:
        String r11 = "https://api-normal.doubao.com/";
    L8:
        r5.g(r11);
        r5.f210b = new a(0);
        r5.d(new HttpEnvInterceptor());
        gi.a r12 = new gi.a();
        ((ArrayList) r5.f).add(r12);
        r5.c(aa.a.f());
        r5.g = new h.a(3);
        if (r5.e().b(AIPackageNetApi.class) != null) goto L13;
        return null;
    L13:
        throw new ClassCastException();
    L5:
        if (r10.f22203n != true) goto L7;
        r11 = "https://aiverse-boe.byted.org/";
        goto L8
    }

    public static final b b() {
        return new c(17);
    }

    public static final OpenPlatformNetApi c() {
        g0 r5 = new g0(0);
        u0.a r10 = s0.a.f21800c;
        if (r10 != null) goto L5;
    L7:
        String r11 = "https://hello.doubao-dev.com";
    L8:
        r5.g(r11);
        r5.f210b = new a(1);
        r5.d(new HttpEnvInterceptor());
        gi.a r12 = new gi.a();
        ((ArrayList) r5.f).add(r12);
        r5.c(aa.a.f());
        r5.g = new h.a(3);
        if (r5.e().b(OpenPlatformNetApi.class) != null) goto L13;
        return null;
    L13:
        throw new ClassCastException();
    L5:
        if (r10.f22203n != true) goto L7;
        r11 = "https://doubao-developer-open-boe.byted.org";
        goto L8
    }

    public static final b d() {
        return new c(17);
    }
}
