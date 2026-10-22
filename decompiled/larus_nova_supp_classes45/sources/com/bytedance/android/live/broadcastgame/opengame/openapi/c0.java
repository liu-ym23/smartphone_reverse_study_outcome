package com.bytedance.android.live.broadcastgame.opengame.openapi;

import io.reactivex.functions.Function;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c0<T, R> implements Function {
    public final /* synthetic */ NetworkRequestMethod a;
    public final /* synthetic */ v0 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public c0(NetworkRequestMethod r1, v0 r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object apply(Object r14) {
        Intrinsics.checkNotNullParameter((v0) r14, "it");
        String r15 = this.b.c();
        Locale r0 = Locale.ROOT;
        if (r15 == null) goto L48;
        String r3 = r15.toUpperCase(r0);
        Object r1 = null;
        switch(r3.hashCode()) {
            case -531492226: goto L39;
            case 70454: goto L36;
            case 79599: goto L17;
            case 2213344: goto L14;
            case 2461856: goto L11;
            case 2012838315: goto L8;
            default: goto L44;
        };
    L44:
        this.a.n(OpenApiErrorInfo.NET_REQUEST_PRE_VERIFY_METHOD_UN_SUPPORT, null);
    L46:
        return Unit.INSTANCE;
    L8:
        if (r3.equals("DELETE") == false) goto L44;
    L40:
        Map<String, String> r6 = MapsKt.emptyMap();
        u10.b r2 = this.a.h;
        String r4 = this.c;
        String r5 = this.d;
        Map<String, String> r16 = this.b.b();
        if (r16 != null) goto L43;
        r16 = MapsKt.emptyMap();
    L43:
        r2.b(r4, r3, r5, r16, r6, this.b.d(), new NetworkRequestMethod$executeRequest$1$1(this), new NetworkRequestMethod$executeRequest$1$2(this), false);
        goto L46
    L11:
        if (r3.equals("POST") == false) goto L44;
    L18:
        Map<String, String> r17 = this.b.b();
        if (r17 == null) goto L22;
        String r18 = r17.get("Content-Type");
        if (r18 == null) goto L22;
    L23:
        String r7 = r18;
        NetworkRequestMethod r19 = this.a;
        Object r8 = this.b.a();
        r19.getClass();
        if ((r8 instanceof String) == false) goto L27;
        r1 = r8;
    L27:
        String r9 = (String) r1;
        if (r9 == null) goto L30;
        byte[] r110 = r9.getBytes(Charsets.UTF_8);
    L31:
        byte[] r11 = r110;
        u10.b r12 = this.a.h;
        String r13 = this.c;
        String r21 = this.d;
        Map<String, String> r111 = this.b.b();
        if (r111 != null) goto L34;
        r111 = MapsKt.emptyMap();
    L34:
        r12.a(r13, r3, r21, r111, r11, r7, this.b.d(), new NetworkRequestMethod$executeRequest$1$3(this), new NetworkRequestMethod$executeRequest$1$4(this), false);
        goto L46
    L30:
        r110 = "".getBytes(Charsets.UTF_8);
    L22:
        r18 = "application/json; charset=UTF-8";
        goto L23
    L14:
        if (r3.equals("HEAD") == false) goto L44;
    L17:
        if (r3.equals("PUT") == false) goto L44;
    L36:
        if (r3.equals("GET") == false) goto L44;
    L39:
        if (r3.equals("OPTIONS") == false) goto L44;
    L48:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
