package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ConstraintLayoutInfoKt {
    public static final View a(ConstraintLayout r5, FeedCardComponent<?, ?>[] r6, final a r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "components");
        Intrinsics.checkNotNullParameter(r7, "layoutInfo");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        if (r6.length <= 1) goto L5;
        LinearLayout r1 = new LinearLayout(r5.getContext());
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(0, -2);
        r2.startToEnd = r7.a;
        r2.topToBottom = r7.b;
        r2.endToStart = r7.c;
        r2.bottomToTop = r7.d;
        ((ViewGroup.MarginLayoutParams) r2).topMargin = r7.f;
        ((ViewGroup.MarginLayoutParams) r2).leftMargin = r7.e;
        ((ViewGroup.MarginLayoutParams) r2).rightMargin = r7.g;
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = r7.h;
        r5.addView(r1, r2);
        b(r1, r6, ConstraintLayoutInfoKt$addComponents$1.INSTANCE);
        r0.element = r1;
    L7:
        return (View) r0.element;
    L5:
        b(r5, r6, new ConstraintLayoutInfoKt$addComponents$2(r0, r7));
        goto L7
    }

    public static final void b(ViewGroup r4, FeedCardComponent<?, ?>[] r5, Function1<? super FeedCardComponent<?, ?>, ? extends ViewGroup.LayoutParams> r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "components");
        Intrinsics.checkNotNullParameter(r6, "getLayoutParams");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        FeedCardComponent<?, ?> r2 = r5[r1];
        r4.addView(r2.c(), (ViewGroup.LayoutParams) r6.invoke(r2));
        r1 = r1 + 1;
        goto L3
    }
}
