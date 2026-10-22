package com.bytedance.android.anniex.lite;

import android.net.Uri;
import android.util.LruCache;
import av.i;
import com.bytedance.ies.bullet.forest.n;
import com.bytedance.ies.bullet.service.sdk.d;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import rd.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache f3223a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache f3224b = null;

    static {
        f3223a = new LruCache(10);
        f3224b = new LruCache(10);
    }

    public static e a(Uri r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r10, "schema");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        LruCache r5 = f3224b;
        e r13 = (e) r5.get(r12);
        if (r13 == null) goto L5;
        return r13;
    L5:
        Lazy r14 = d.e;
        d r15 = i.e();
        com.bytedance.ies.bullet.service.sdk.a r16 = new com.bytedance.ies.bullet.service.sdk.a();
        o4.a r17 = new o4.a(r11);
        Intrinsics.checkNotNullParameter(r17, "interceptor");
        ArrayList r18 = r16.f6132a;
        r18.add(r17);
        n r19 = new n(1);
        Intrinsics.checkNotNullParameter(r19, "interceptor");
        r18.add(r19);
        Unit r20 = Unit.INSTANCE;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r16, "schemaConfig");
        if (Intrinsics.areEqual(r10, Uri.EMPTY) == true) goto L12;
        LinkedHashMap r21 = r15.f6146c;
        com.bytedance.ies.bullet.service.sdk.a r22 = (com.bytedance.ies.bullet.service.sdk.a) r21.get(r10);
        if (r22 == null) goto L11;
        Intrinsics.checkNotNullParameter(r18, "interceptors");
        r22.f6132a.addAll(r18);
        goto L12
    L11:
        r21.put(r10, r16);
    L12:
        com.bytedance.ies.bullet.service.sdk.b r23 = i.e().a(r11, r10, true);
        e r24 = new e(r23);
        r5.put(r12, r24);
        LinkedHashMap r25 = com.bytedance.android.anniex.monitor.c.f3335a;
        String r26 = (String) r23.f6143o.get("url");
        if (r26 != null) goto L15;
        r26 = r10.toString();
    L15:
        com.bytedance.android.anniex.monitor.c.e(Uri.parse(r26), r12);
        return r24;
    }
}
