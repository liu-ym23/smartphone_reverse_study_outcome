package com.bytedance.android.live.browser.service;

import android.content.Context;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements z8.b {
    public h() {
    }

    public final List<Object> M(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        IMiddlewareHostAction r0 = jc1.k.f(IMiddlewareHostAction.class);
        if (r0 == null) goto L7;
        List<Object> r4 = r0.ecBehaviorAdd(r2, r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return CollectionsKt.emptyList();
    }

    public final List r1(Context r2, com.bytedance.android.annie.lynx.resource.h r3) {
        Intrinsics.checkNotNullParameter(r3, "xResourceLoader");
        IMiddlewareHostAction r0 = jc1.k.f(IMiddlewareHostAction.class);
        if (r0 == null) goto L15;
        List r4 = r0.createHostDefinedLynxBehavior(r2, r3);
        if (r4 == null) goto L15;
        List r5 = r4;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L18;
        Object r1 = r7.next();
        if (r1 == null) goto L13;
        r6.add((com.lynx.tasm.behavior.a) r1);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.behavior.Behavior");
    L18:
        return r6;
    L15:
        return CollectionsKt.emptyList();
    }
}
