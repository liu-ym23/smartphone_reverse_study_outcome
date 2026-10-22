package com.larus.bmhome.view.screenmenu;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t0 implements ot8.b {
    public t0() {
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
    public final View a(CommonMenu r4, int r5, int r6, ot8.a r7) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r7, "item");
        if ((r7 instanceof s0) == true) goto L6;
        return null;
    L6:
        TextView r8 = new TextView(r4.getContext());
        LinearLayoutCompat.LayoutParams r9 = new LinearLayoutCompat.LayoutParams(-1, -2);
        r9.setMargins(i5.q(), i5.h(), i5.q(), 0);
        r8.setLayoutParams(r9);
        r8.setIncludeFontPadding(false);
        r8.setText(((s0) r7).b);
        r8.setTextColor(ContextCompat.getColor(r8.getContext(), v19.c.b(2130972081, r8.getContext(), 2131103143)));
        r8.setTextSize(0, r8.getContext().getResources().getDimension(v19.c.b(2130972270, r8.getContext(), 2131167610)));
        TextViewCompat.setLineHeight(r8, i5.v());
        return r8;
    }
}
