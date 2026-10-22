package com.bytedance.android.live.ktv.common.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public static final String a = null;
    public static final String b = null;

    static {
        String r0 = s1.B(2131918617);
        if (r0 != null) goto L5;
        r0 = "演唱得分";
    L5:
        a = r0;
        String r1 = s1.B(2131918618);
        if (r1 != null) goto L8;
        r1 = "演唱时间";
    L8:
        b = r1;
    }

    public static final View a(Context r2, kb0.c r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "tabTextView");
        View r0 = new View(r2);
        r0.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r4 = new ConstraintLayout.LayoutParams(-2, -2);
        r4.topToTop = r3.getId();
        r4.startToEnd = r3.getId();
        ((ViewGroup.MarginLayoutParams) r4).width = (int) UtilityKotlinExtentionsKt.h(6.0f);
        ((ViewGroup.MarginLayoutParams) r4).height = (int) UtilityKotlinExtentionsKt.h(6.0f);
        Unit r5 = Unit.INSTANCE;
        r0.setLayoutParams(r4);
        r0.setBackgroundResource(2131252121);
        UtilityKotlinExtentionsKt.t(r0);
        return r0;
    }
}
