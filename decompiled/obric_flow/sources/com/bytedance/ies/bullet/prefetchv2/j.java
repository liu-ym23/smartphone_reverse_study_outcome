package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f5864a = null;

    static {
        f5864a = new ConcurrentHashMap();
    }

    public static final r a(Uri r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "bid");
        ConcurrentHashMap r11 = f5864a;
        r r12 = (r) r11.get(r5);
        if (r12 == null) goto L5;
        return r12;
    L5:
        Lazy r13 = com.bytedance.ies.bullet.service.sdk.d.e;
        com.bytedance.ies.bullet.service.sdk.d r14 = av.i.e();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r5, "url");
        r r15 = b(r14.a(r10, r5, false));
        r11.put(r5, r15);
        return r15;
    }

    public static final r b(rd.b r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Boolean r10 = (Boolean) new vd.a(r5, "enable_prefetch", Boolean.FALSE).f22372b;
        if (r10 == null) goto L5;
        boolean r11 = r10.booleanValue();
    L6:
        LinkedHashMap r12 = ((com.bytedance.ies.bullet.service.sdk.b) r5).f6143o;
        r r13 = new r(r11, (String) r12.get("prefetch_business"), r5);
        Intrinsics.areEqual(r12.get("__dev"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        return r13;
    L5:
        r11 = false;
        goto L6
    }
}
