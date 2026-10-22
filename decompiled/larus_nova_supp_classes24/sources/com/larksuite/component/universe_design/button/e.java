package com.larksuite.component.universe_design.button;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public static final a a = null;

    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            a r0 = e.a;
            if (r3.getTag(2131370226) == null) goto L15;
            Object r4 = r3.getTag(2131370226);
            if ((r4 instanceof c) == false) goto L7;
            c r5 = (c) r4;
        L8:
            if (r5 == null) goto L16;
            Object r6 = r5.a;
            if (r6 != null) goto L12;
            return;
        L12:
            if ((r6 instanceof Animatable) == false) goto L18;
            ((Animatable) r6).start();
            return;
        L18:
            return;
        L16:
            return;
        L7:
            r5 = null;
            goto L8
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            a r0 = e.a;
            if (r3.getTag(2131370226) == null) goto L15;
            Object r4 = r3.getTag(2131370226);
            if ((r4 instanceof c) == false) goto L7;
            c r5 = (c) r4;
        L8:
            if (r5 == null) goto L16;
            Object r6 = r5.a;
            if (r6 != null) goto L12;
            return;
        L12:
            if ((r6 instanceof Animatable) == false) goto L18;
            ((Animatable) r6).stop();
            return;
        L18:
            return;
        L16:
            return;
        L7:
            r5 = null;
            goto L8
        }
    }

    static {
        a = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(UDButton r4) {
        if (r4.getTag(2131370226) == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L20;
        Object r2 = r4.getTag(2131370226);
        if ((r2 instanceof c) == false) goto L10;
        c r3 = (c) r2;
    L11:
        if (r3 == null) goto L18;
        Drawable r5 = r3.a;
        if (r5 == 0) goto L18;
        if ((r5 instanceof Animatable) == false) goto L17;
        ((Animatable) r5).stop();
    L17:
        r5.setCallback(null);
    L18:
        r4.setTag(2131370226, null);
        return;
    L10:
        r3 = null;
        goto L11
    L20:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static /* synthetic */ void i(UDButton r1) {
        h(r1, UDButtonExtensionsKt$showProgress$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(UDButton r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        a(r1);
        r1.setText(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(UDButton r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        b(r1, r1.getContext().getString(r2));
    }

    public static /* synthetic */ void f(UDButton r1, Drawable r2) {
        e(r1, r2, UDButtonExtensionsKt$showDrawable$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(UDButton r7, d r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "params");
        Resources r0 = r7.getContext().getResources();
        Integer r1 = r8.h;
        if (r1 == null) goto L5;
        int r2 = r0.getDimensionPixelSize(r1.intValue());
    L6:
        Integer r3 = r8.f;
        if (r3 == null) goto L9;
        int r4 = r0.getDimensionPixelSize(r3.intValue());
    L11:
        if (r8.k == null) goto L13;
        Context r5 = r7.getContext();
        Integer r6 = r8.k;
        Intrinsics.checkNotNull(r6);
        int[] r9 = {ContextCompat.getColor(r5, r6.intValue())};
    L17:
        CircularProgressDrawable r10 = new CircularProgressDrawable(r7.getContext());
        r10.setStyle(1);
        if (r9.length != 0) goto L20;
        boolean r11 = true;
    L22:
        if ((true ^ r11) == false) goto L25;
        r10.setColorSchemeColors(Arrays.copyOf(r9, r9.length));
    L25:
        if (r4 == (-1)) goto L27;
        r10.setCenterRadius(r4);
    L27:
        if (r2 == (-1)) goto L29;
        r10.setStrokeWidth(r2);
    L29:
        r10.setStrokeCap(Paint.Cap.ROUND);
        int r12 = ((int) (r10.getCenterRadius() + r10.getStrokeWidth())) * 2;
        r10.setBounds(0, 0, r12, r12);
        d(r7, r10, r8);
        return;
    L20:
        r11 = false;
        goto L22
    L13:
        Integer r13 = r8.j;
        if (r13 == null) goto L16;
        Intrinsics.checkNotNull(r13);
        r9 = new int[]{r13.intValue()};
        goto L17
    L16:
        r9 = new int[0];
        goto L17
    L9:
        r4 = r8.g;
        goto L11
    L5:
        r2 = r8.i;
        goto L6
    }

    public static final void h(UDButton r1, Function1<? super d, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "params");
        d r0 = new d();
        r2.invoke(r0);
        g(r1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(UDButton r9, Drawable r10, com.larksuite.component.universe_design.button.a r11) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "drawable");
        Intrinsics.checkNotNullParameter(r11, "paramValues");
        Resources r0 = r9.getContext().getResources();
        Integer r1 = r11.a;
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
        Object r3 = r9.getContext().getString(r2);
        if (r3 == null) goto L7;
    L8:
        Integer r4 = r11.d;
        if (r4 == null) goto L11;
        int r5 = r0.getDimensionPixelSize(r4.intValue());
    L12:
        int r12 = r11.c;
        if (r9.getTag(2131370226) == null) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L19;
        a(r9);
    L19:
        if (r5 != (-1)) goto L21;
        r5 = (int) h18.d.a(r9.getContext(), 4.0f);
    L21:
        b r7 = new b(r10);
        if (r12 == 0) goto L33;
        if (r12 != 1) goto L25;
        r7.a = r5;
        StringBuilder r8 = new StringBuilder();
        if (r3 != null) goto L32;
        r3 = "";
    L32:
        r8.append(r3);
        r8.append(' ');
        SpannableString r13 = new SpannableString(r8.toString());
        r13.setSpan(r7, r13.length() - 1, r13.length(), 33);
    L37:
        r9.setText(r13);
        r9.addOnAttachStateChangeListener(a);
        f r14 = new f(r9);
        r9.setTag(2131370226, new c(r10, r14));
        r10.setCallback(r14);
        boolean r15 = r10 instanceof Animatable;
        if (r15 == false) goto L40;
        ((Animatable) r10).start();
    L40:
        if (r15 == false) goto L43;
        ((Animatable) r10).start();
        return;
    L43:
        return;
    L25:
        if (r12 != 2) goto L28;
        r13 = new SpannableString(" ");
        r13.setSpan(r7, 0, 1, 33);
        goto L37
    L28:
        throw new IllegalArgumentException("Please set the correct gravity");
    L33:
        r7.b = r5;
        StringBuilder r16 = new StringBuilder(" ");
        if (r3 != null) goto L36;
        r3 = "";
    L36:
        r16.append(r3);
        r13 = new SpannableString(r16.toString());
        r13.setSpan(r7, 0, 1, 33);
        goto L37
    L15:
        r6 = false;
        goto L16
    L11:
        r5 = r11.e;
    L7:
        r3 = r11.b;
        goto L8
    }

    public static final void e(UDButton r1, Drawable r2, Function1<? super com.larksuite.component.universe_design.button.a, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "drawable");
        Intrinsics.checkNotNullParameter(r3, "params");
        com.larksuite.component.universe_design.button.a r0 = new com.larksuite.component.universe_design.button.a();
        r3.invoke(r0);
        d(r1, r2, r0);
    }
}
