package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o {
    public final Map<String, h> a;
    public final ih0.b b;
    public final Context c;
    public final ViewGroup d;
    public final String e;

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        ALogger.i("MultiLinkFeedDynamicWidget", "onDestroy, mBizId: " + this.e);
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        Map.Entry r1 = (Map.Entry) r0.next();
        ih0.c r2 = ((h) r1.getValue()).a;
        if (r2 == null) goto L16;
        View r3 = r2.S0();
        if (r3 == null) goto L16;
        ViewGroup r4 = UtilityKotlinExtentionsKt.p(r3);
        if (r4 == null) goto L16;
        ih0.c r6 = ((h) r1.getValue()).a;
        if (r6 == null) goto L14;
        View r7 = r6.S0();
    L15:
        r4.removeView(r7);
        goto L16
    L14:
        r7 = null;
    L16:
        ((h) r1.getValue()).b();
        goto L4
    L17:
        ((LinkedHashMap) this.a).clear();
        int r8 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.c(this.e, r5);
    }

    public final void b(String r3) {
        h r4 = this.a.remove(r3);
        if (r4 == null) goto L16;
        this.b.Tl(r4.a);
        r4.b();
        ih0.c r0 = r4.a;
        if (r0 == null) goto L17;
        View r1 = r0.S0();
        if (r1 == null) goto L18;
        ViewGroup r2 = UtilityKotlinExtentionsKt.p(r1);
        if (r2 == null) goto L19;
        ih0.c r5 = r4.a;
        if (r5 == null) goto L13;
        View r6 = r5.S0();
    L14:
        r2.removeView(r6);
        return;
    L13:
        r6 = null;
        goto L14
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public o(ih0.b r2, Context r3, ViewGroup r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "service");
        Intrinsics.checkNotNullParameter(r3, "mContext");
        Intrinsics.checkNotNullParameter(r4, "mLinkRootView");
        Intrinsics.checkNotNullParameter(r5, "mBizId");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.a = new LinkedHashMap();
    }
}
