package okhttp3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0 f20713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f20715c;
    public q0 d;
    public Map e;

    public n0() {
        this.e = new LinkedHashMap();
        this.f20714b = "GET";
        this.f20715c = new b0();
    }

    public final void a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "value");
        this.f20715c.a(r5, r10);
    }

    public final Request b() {
        e0 r5 = this.f20713a;
        if (r5 == null) goto L7;
        return new Request(r5, this.f20714b, this.f20715c.d(), this.d, Util.toImmutableMap(this.e));
    L7:
        throw new IllegalStateException("url == null");
    }

    public final void c(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "value");
        b0 r11 = this.f20715c;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "value");
        z.b(r5);
        z.c(r10, r5);
        r11.f(r5);
        r11.c(r5, r10);
    }

    public final void d(String r5, q0 r10) {
        Intrinsics.checkNotNullParameter(r5, "method");
        if (r5.length() <= 0) goto L18;
        if (r10 != null) goto L12;
        if (HttpMethod.requiresRequestBody(r5) == true) goto L10;
    L13:
        this.f20714b = r5;
        this.d = r10;
        return;
    L10:
        throw new IllegalArgumentException(ai.j0.k("method ", r5, " must have a request body.").toString());
    L12:
        if (HttpMethod.permitsRequestBody(r5) == true) goto L13;
        throw new IllegalArgumentException(ai.j0.k("method ", r5, " must not have a request body.").toString());
    L18:
        throw new IllegalArgumentException("method.isEmpty() == true");
    }

    public final void e(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.f20715c.f(r5);
    }

    public final void f(Class r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (r10 != null) goto L6;
        this.e.remove(r5);
        return;
    L6:
        if (this.e.isEmpty() == false) goto L8;
        this.e = new LinkedHashMap();
    L8:
        Map r11 = this.e;
        Object r12 = r5.cast(r10);
        Intrinsics.checkNotNull(r12);
        r11.put(r5, r12);
    }

    public final void g(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        if (StringsKt.M(r5, "ws:") == false) goto L6;
        r5 = "http:" + r5.substring(3);
    L8:
        Intrinsics.checkNotNullParameter(r5, "$this$toHttpUrl");
        d0 r10 = new d0();
        r10.d(null, r5);
        e0 r11 = r10.a();
        Intrinsics.checkNotNullParameter(r11, "url");
        this.f20713a = r11;
        return;
    L6:
        if (StringsKt.M(r5, "wss:") == false) goto L8;
        r5 = "https:" + r5.substring(4);
        goto L8
    }
}
