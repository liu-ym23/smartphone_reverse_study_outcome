package com.larus.app.settings.impl;

import android.content.Context;
import android.widget.LinearLayout;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.utils.e1;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ItemClickMode.values().length];
            r0[ItemClickMode.DIRECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ItemClickMode.DEBOUNCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ItemClickMode.STICKY_DEBOUNCE_1S.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final int b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return c(r2, 2130971163, 2131166696);
    }

    public static final int c(Context r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getResources().getDimensionPixelSize(v19.c.b(r2, r1, r3));
    }

    public static final ItemTextArrow a(ItemGroup r4, String r5, ItemClickMode r6, final Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "text");
        Intrinsics.checkNotNullParameter(r6, "clickMode");
        Intrinsics.checkNotNullParameter(r7, "onClick");
        ItemTextArrow r0 = new ItemTextArrow(r4.getContext());
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r0.setText(r5);
        r0.setTextFontWeight(500);
        int r8 = a.a[r6.ordinal()];
        if (r8 != 1) goto L5;
        r0.setOnClickListener(new h(r7));
    L13:
        r4.addView(r0);
        return r0;
    L5:
        if (r8 != 2) goto L7;
        e1.d(r0, new i(r7));
        goto L13
    L7:
        if (r8 != 3) goto L10;
        e1.a(r0, 1000, new j(r7));
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
