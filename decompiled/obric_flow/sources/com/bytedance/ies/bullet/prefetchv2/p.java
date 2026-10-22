package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends tc.a {
    public static List d(Uri r10, String r11, com.bytedance.ies.bullet.core.e r12) {
        Intrinsics.checkNotNullParameter(r10, "scheme");
        Intrinsics.checkNotNullParameter(r12, "bulletContext");
        rd.b r5 = r12.e;
        List r13 = null;
        if (r5 == null) goto L7;
        LinkedHashMap r14 = ((com.bytedance.ies.bullet.service.sdk.b) r5).f6143o;
        if (r14 == null) goto L7;
        String r15 = (String) r14.get("enable_prefetch");
    L9:
        if (Intrinsics.areEqual(r15, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L11;
        ExecutorService r16 = o.f5870a;
        rd.b r17 = r12.g.f21723a;
        String r18 = r12.f;
        if (r18 != null) goto L15;
        r18 = "default_bid";
    L15:
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r17, "schemaData");
        Intrinsics.checkNotNullParameter(r18, "bid");
        r r19 = j.b(r17);
        if (r19.f5873a == true) goto L18;
        r13 = CollectionsKt.emptyList();
    L35:
        ArrayList r20 = new ArrayList();
        if (r13 != null) goto L38;
    L45:
        return r20;
    L38:
        if (r13.isEmpty() == true) goto L45;
        Iterator r21 = r13.iterator();
        if (r21.hasNext() == false) goto L45;
        throw androidx.constraintlayout.motion.widget.a.g(r21);
    L18:
        if (r11 == null) goto L22;
        a r22 = a.f5833a;
        Intrinsics.checkNotNullParameter(r11, "identifier");
        f r23 = (f) a.f5835c.get(r11);
        c.h("Get config cache by identifier: " + r11 + ", config: " + r23);
        if (r23 != null) goto L23;
        r23 = r22.a(r10);
    L23:
        if (r23 != null) goto L25;
    L34:
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPrefetch", "未获取到prefetch配置，无法进行globalprops注入", null, 12);
        goto L35
    L25:
        if (r23.f5847c.isEmpty() == true) goto L34;
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r23.d = r18;
        r13 = new ArrayList();
        Iterator r24 = r23.f5847c.iterator();
    L29:
        if (r24.hasNext() == false) goto L35;
        i r25 = (i) r24.next();
        if (c.c(r25, r19, r23) != null) goto L29;
        c.l("PrefetchRequest创建失败: " + r25.f5855a);
        goto L29
    L22:
        r23 = null;
        goto L23
    L11:
        return CollectionsKt.emptyList();
    L7:
        r15 = null;
        goto L9
    }
}
