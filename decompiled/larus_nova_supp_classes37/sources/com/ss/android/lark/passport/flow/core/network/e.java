package com.ss.android.lark.passport.flow.core.network;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final /* synthetic */ int i = 0;
    public final String a;
    public final PassportHttpMethod b;
    public final String c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final Map<String, String> g;
    public final byte[] h;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("PassportHttpRequest(method=");
        r0.append(this.b);
        r0.append(", requestId=");
        r0.append(this.c);
        r0.append(", headerNames=");
        r0.append(((LinkedHashMap) this.g).keySet());
        r0.append(", bodyBytes=");
        byte[] r1 = this.h;
        if (r1 == null) goto L5;
        int r2 = r1.length;
    L6:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = 0;
        goto L6
    }

    public e(String r2, PassportHttpMethod r3, Map r4, byte[] r5, String r6, int r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter(r4, "headers");
        Intrinsics.checkNotNullParameter(r6, "requestId");
        this.a = r2;
        this.b = r3;
        this.c = r6;
        this.d = r7;
        this.e = false;
        this.f = r8;
        this.g = new LinkedHashMap(r4);
        if (r5 == null) goto L5;
        byte[] r9 = Arrays.copyOf(r5, r5.length);
    L6:
        this.h = r9;
        return;
    L5:
        r9 = null;
        goto L6
    }
}
