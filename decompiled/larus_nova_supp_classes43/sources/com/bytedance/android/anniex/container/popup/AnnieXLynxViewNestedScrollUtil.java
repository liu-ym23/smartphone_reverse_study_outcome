package com.bytedance.android.anniex.container.popup;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLynxViewNestedScrollUtil {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(LynxView r10) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        final ViewPager r11 = a(r10, AnnieXLynxViewNestedScrollUtil$handleNestedScrollWithVp$vp$1.INSTANCE);
        boolean r0 = r11 instanceof ViewPager;
        if (r0 == false) goto L11;
        final ArrayList r1 = new ArrayList();
        if (r0 == false) goto L7;
        ViewPager r12 = r11;
    L8:
        if (r12 == null) goto L12;
        r12.addOnPageChangeListener(new AnnieXLynxViewNestedScrollUtil$handleNestedScrollWithVp$1(r1, r11));
        return;
    L12:
        return;
    L7:
        r12 = null;
        goto L8
    }

    public static View a(View r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "v");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        if (((Boolean) r11.invoke(r10)).booleanValue() == false) goto L6;
        return r10;
    L6:
        if ((r10 instanceof ViewGroup) == true) goto L8;
        return null;
    L8:
        ViewGroup r12 = (ViewGroup) r10;
        int r0 = r12.getChildCount();
        int r13 = 0;
    L9:
        if (r13 >= r0) goto L14;
        View r14 = a(r12.getChildAt(r13), r11);
        if (r14 != null) goto L12;
        r13 = r13 + 1;
        goto L9
    L12:
        return r14;
    L14:
        return null;
    }
}
