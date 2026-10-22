package com.bytedance.android.accessibilityLib_Core.engine;

import com.bytedance.android.accessibilityLib_Core.base.AccessiblityScope;
import com.bytedance.android.accessibilityLib_Core.base.largertoucharea.LargeTouchAreaScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[LargeTouchAreaScope.values().length];
        a = r0;
        r0[LargeTouchAreaScope.ALL.ordinal()] = 1;
        int[] r1 = new int[AccessiblityScope.values().length];
        b = r1;
        r1[AccessiblityScope.View.ordinal()] = 1;
    }
}
