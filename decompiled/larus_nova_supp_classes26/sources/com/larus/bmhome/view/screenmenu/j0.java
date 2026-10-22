package com.larus.bmhome.view.screenmenu;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j0 implements ot8.b {
    public j0() {
    }

    @Override // ot8.b
    public final void b(CommonMenu r1, ot8.a r2, View r3, Function1<? super ot8.a, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r4, "listener");
    }

    @Override // ot8.b
    public void update(ot8.a r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "item");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ot8.b
    public final View a(CommonMenu r3, int r4, int r5, ot8.a r6) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r6, "item");
        if ((r6 instanceof i0) == true) goto L5;
        return null;
    L5:
        if (r4 > 0) goto L7;
    L25:
        return null;
    L7:
        if ((r5 - 1) == r4) goto L25;
        i0 r7 = (i0) r6;
        if (r7.f > 0) goto L12;
        return null;
    L12:
        FrameLayout r8 = new FrameLayout(r3.getContext());
        r8.setLayoutParams(new LinearLayoutCompat.LayoutParams(r7.g, r7.f));
        r8.setPadding(i5.q(), r8.getPaddingTop(), i5.q(), r8.getPaddingBottom());
        int r9 = r7.c;
        if (r9 == 0) goto L16;
        r8.setBackgroundColor(r9);
    L24:
        return r8;
    L16:
        if (r7.b == 0) goto L19;
        r8.setBackgroundColor(ContextCompat.getColor(r8.getContext(), r7.b));
        goto L24
    L19:
        if (r7.d == 0) goto L21;
        r8.setBackground(ContextCompat.getDrawable(r8.getContext(), r7.d));
        goto L24
    L21:
        Drawable r10 = r7.e;
        if (r10 == null) goto L24;
        r8.setBackground(r10);
        goto L24
    }
}
