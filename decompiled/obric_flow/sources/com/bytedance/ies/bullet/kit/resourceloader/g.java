package com.bytedance.ies.bullet.kit.resourceloader;

import android.app.Application;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f5451a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f5452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f5453c;
    public static final f d = null;
    public static com.bytedance.ies.bullet.preloadv2.a e;

    static {
        f5451a = new ConcurrentHashMap();
        d = new f();
    }

    public static h a(String r5) {
        Intrinsics.checkNotNullParameter("default_bid", "fallback");
        ConcurrentHashMap r10 = f5451a;
        h r11 = (h) r10.get(r5);
        if (r11 != null) goto L8;
        h r12 = (h) r10.get("default_bid");
        if (r12 == null) goto L7;
        return r12;
    L7:
        return d;
    L8:
        return r11;
    }
}
