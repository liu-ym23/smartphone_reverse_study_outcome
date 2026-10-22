package com.ss.ugc.live.sdk.msg.utils;

import com.ss.ugc.live.sdk.msg.data.SdkUplinkPacket;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String a(tlc.f r4) {
        if (r4 == null) goto L20;
        List<com.ss.ugc.live.sdk.msg.network.d> r5 = r4.f;
        if (r5 == null) goto L21;
        Iterator<T> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        Object r1 = r6.next();
        if (Intrinsics.areEqual(((com.ss.ugc.live.sdk.msg.network.d) r1).a, "compress_type") == false) goto L8;
    L13:
        com.ss.ugc.live.sdk.msg.network.d r2 = (com.ss.ugc.live.sdk.msg.network.d) r1;
        if (r2 != null) goto L16;
        return null;
    L16:
        return r2.b;
    L12:
        r1 = null;
        goto L13
    L21:
        return null;
    L20:
        return null;
    }

    @JvmStatic
    public static final String b(SdkUplinkPacket r6) {
        if (r6 == null) goto L21;
        Map<String, String> r0 = r6.headers;
        if (r0 == null) goto L21;
        Set<String> r1 = r0.keySet();
        if (r1 == null) goto L21;
        Iterator<T> r2 = r1.iterator();
    L8:
        String r3 = null;
        if (r2.hasNext() == false) goto L13;
        Object r4 = r2.next();
        if (StringsKt.equals("x-tt-logid", (String) r4, true) == false) goto L8;
    L14:
        String r5 = (String) r4;
        if (r5 == null) goto L21;
        Map<String, String> r7 = r6.headers;
        if (r7 == null) goto L19;
        r3 = r7.get(r5);
    L19:
        if (r3 == null) goto L21;
        return r3;
    L13:
        r4 = null;
    L21:
        return "";
    }
}
