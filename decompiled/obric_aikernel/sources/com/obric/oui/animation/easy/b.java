package com.obric.oui.animation.easy;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final <T extends View> ViewPropertySpringAnimator<T> a(T r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$spring");
        int r11 = i8.a.view_property_spring_animator_key;
        Object r12 = r10.getTag(r11);
        if ((r12 instanceof ViewPropertySpringAnimator) == true) goto L5;
        r12 = null;
    L5:
        ViewPropertySpringAnimator<T> r13 = (ViewPropertySpringAnimator) r12;
        if (r13 != null) goto L9;
        ViewPropertySpringAnimator<T> r14 = new ViewPropertySpringAnimator(r10);
        r10.setTag(r11, r14);
        return r14;
    L9:
        return r13;
    }
}
