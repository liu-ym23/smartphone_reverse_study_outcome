package com.obric.aikernel.middleware.impl.ttnet;

import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s7.e;

/* JADX INFO: loaded from: classes2.dex */
public final class StandbyWhitelist {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StandbyWhitelist f4612a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, ? extends Set<String>> f4614c;

    static {
        f4612a = new StandbyWhitelist();
        f4614c = MapsKt.emptyMap();
        e.a("ttnet_whitelist_standby", AnonymousClass1.INSTANCE);
    }

    private StandbyWhitelist() {
    }

    public static final /* synthetic */ boolean a() {
        return f4613b;
    }

    public static final /* synthetic */ Map b() {
        return f4614c;
    }

    public static final /* synthetic */ void c(boolean r10) {
        f4613b = r10;
    }

    public static final /* synthetic */ void d(Map r10) {
        f4614c = r10;
    }

    public final Boolean e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "host");
        Intrinsics.checkNotNullParameter(r11, "path");
        if (f4613b == true) goto L6;
        return null;
    L6:
        Set<String> r12 = f4614c.get(r10);
        boolean r13 = true;
        if (r12 != null) goto L9;
    L17:
        r13 = false;
    L19:
        return Boolean.valueOf(r13);
    L9:
        if (r12.isEmpty() == false) goto L11;
    L14:
        boolean r14 = true;
    L15:
        if (r14 != true) goto L17;
    L11:
        if (r12.contains(r11) == true) goto L14;
        r14 = false;
        goto L15
    }
}
