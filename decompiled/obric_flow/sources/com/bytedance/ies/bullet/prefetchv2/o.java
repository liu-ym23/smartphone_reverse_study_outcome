package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f5870a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f5871b = null;

    static {
        f5870a = Executors.newCachedThreadPool(new d("PrefetchV2", 0));
        f5871b = Executors.newFixedThreadPool(4, new d("PrefetchV2Worker", 0));
    }

    public static List a(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        ConcurrentHashMap r5 = j.f5864a;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r r11 = (r) j.f5864a.get(r10);
        if (r11 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (r11.f5873a == false) goto L9;
        f r12 = a.f5833a.a(r10);
        if (r12 == null) goto L23;
        ArrayList r13 = r12.f5847c;
        if (r13.isEmpty() == true) goto L23;
        ArrayList r14 = new ArrayList();
        Iterator r15 = r13.iterator();
    L17:
        if (r15.hasNext() == false) goto L22;
        i r16 = (i) r15.next();
        if (c.c(r16, r11, r12) != null) goto L17;
        c.l("PrefetchRequest创建失败: " + r16.f5855a);
        goto L17
    L22:
        return r14;
    L23:
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPrefetch", "未获取到prefetch配置，无法进行globalProps注入", null, 12);
        return null;
    L9:
        return CollectionsKt.emptyList();
    }

    public static void b(Uri r10, String r11, rd.b r12, ad.a r13, String r14, int r15) {
        if ((r15 & 16) == 0) goto L5;
        ad.a r16 = null;
    L7:
        if ((r15 & 32) == 0) goto L9;
        String r17 = null;
    L10:
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "bid");
        f5870a.execute(new n(r10, r12, r11, r16, r17));
        return;
    L9:
        r17 = r14;
        goto L10
    L5:
        r16 = r13;
        goto L7
    }
}
