package com.bytedance.frameworks.baselib.network.http.impl;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.d;
import com.bytedance.frameworks.baselib.network.http.cookie.e;
import com.bytedance.frameworks.baselib.network.http.cookie.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f2445b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.frameworks.baselib.network.http.cookie.c f2446a;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.impl.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f2447a = null;

        static {
            f2447a = new b(null);
        }

        static /* synthetic */ b a() {
            return f2447a;
        }
    }

    static {
    }

    private b() {
        long r0 = System.nanoTime();
        if (com.bytedance.frameworks.baselib.network.a.b.l() == false) goto L5;
        f r2 = null;
    L6:
        this.f2446a = r2;
        f2445b = (System.nanoTime() - r0) / 1000;
        return;
    L5:
        r2 = new f();
        goto L6
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    public static b a() {
        return a.a();
    }

    public static long c() {
        return f2445b;
    }

    public String a(URI r3) {
        com.bytedance.frameworks.baselib.network.http.cookie.c r2 = this.f2446a;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.a(r3);
    L7:
        th = move-exception;
        Logger.e("CookieManagerWrap", "getCookie error", th);
        return null;
    }

    void a(URI r8, List<String> r9, ValueCallback<Boolean> r10, boolean r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        ValueCallback r13 = (ValueCallback) ZeusTransformUtils.wrapperContextForParams(r10, ValueCallback.class, "com.obric.memorydata.plugin");
        if (this.f2446a == null) goto L23;
        if (r8 == null) goto L23;
        if (d.a(r12) == true) goto L23;
        boolean r1 = true;
        Iterator r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L20;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r4) == true) goto L13;
    L18:
        th = move-exception;
        Logger.d("CookieManagerWrap", "setCookies error: " + r4, th);
        goto L13
    L15:
        if (this.f2446a.a(r8, r4, r11) == true) goto L10;
        Logger.d("CookieManagerWrap", "setCookies failed: " + r4);     // Catch: Throwable -> L18
    L13:
        r1 = false;
        goto L10
    L20:
        if (r13 == null) goto L34;
        r13.onReceiveValue(Boolean.valueOf(r1));
        return;
    L34:
        return;
    L23:
        if (r13 == null) goto L35;
        r13.onReceiveValue(false);
        return;
    }

    public boolean a(e r1) {
        com.bytedance.frameworks.baselib.network.http.cookie.c r0 = this.f2446a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r1);
    }

    Pair<String, Map<String, Set<e>>> b(URI r3) {
        com.bytedance.frameworks.baselib.network.http.cookie.c r2 = this.f2446a;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.b(r3);
    L7:
        th = move-exception;
        Logger.e("CookieManagerWrap", "getCookieForRelTest error", th);
        return null;
    }

    boolean b() {
        com.bytedance.frameworks.baselib.network.http.cookie.c r0 = this.f2446a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }
}
