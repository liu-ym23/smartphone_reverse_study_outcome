package com.bytedance.android.live.browser.utils;

import android.view.View;
import com.bytedance.android.live.core.setting.q0;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(CallContext r2) {
        if (((Number) q0.a.getValue()).intValue() < 1) goto L9;
        if (r2 == null) goto L10;
        View r3 = r2.d;
        if (r3 == null) goto L11;
        r3.setTag(2131378195, null);
        return;
    L11:
        return;
    L10:
        return;
    }

    public static void c(View r3) {
        if (((Number) q0.a.getValue()).intValue() < 1) goto L16;
        Object r0 = r3.getTag(2131378195);
        if ((r0 instanceof LinkedHashSet) == true) goto L7;
        r0 = null;
    L7:
        LinkedHashSet r1 = (LinkedHashSet) r0;
        if (r1 == null) goto L13;
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        ((com.bytedance.android.live.browser.jsbridge.e) r2.next()).onClean();
    L13:
        r3.setTag(2131378193, null);
        return;
    }

    public static void b(CallContext r3, com.bytedance.android.live.browser.jsbridge.e r4) {
        Intrinsics.checkNotNullParameter(r4, "jsbMethod");
        if (((Number) q0.a.getValue()).intValue() < 1) goto L15;
        if (r3 == null) goto L16;
        View r5 = r3.d;
        if (r5 == null) goto L17;
        Object r1 = r5.getTag(2131378195);
        if ((r1 instanceof LinkedHashSet) == true) goto L10;
        r1 = null;
    L10:
        LinkedHashSet r2 = (LinkedHashSet) r1;
        if (r2 != null) goto L13;
        r2 = new LinkedHashSet();
        r5.setTag(2131378195, r2);
    L13:
        r2.add(r4);
        return;
    L17:
        return;
    L16:
        return;
    }
}
