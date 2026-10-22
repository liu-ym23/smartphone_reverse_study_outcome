package com.larus.bmhome.view.screenmenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.larus.common_res.common_ui.databinding.LarusScreenMenuItemLayoutBinding;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q0 implements ot8.b {

    public static final class a extends BasePostprocessor {
        public a() {
        }

        public final void process(Bitmap r5) {
            super.process(r5);
            if (r5 != null) goto L5;
            return;
        L5:
            Canvas r0 = new Canvas(r5);
            ColorMatrix r1 = new ColorMatrix();
            r1.setScale(0.0f, 0.0f, 0.0f, 1.0f);
            ColorMatrixColorFilter r2 = new ColorMatrixColorFilter(r1);
            Paint r3 = new Paint();
            r3.setColorFilter(r2);
            r0.drawBitmap(r5, 0.0f, 0.0f, r3);
        }
    }

    public q0() {
    }

    @Override // ot8.b
    public void update(ot8.a r7, View r8) {
        Intrinsics.checkNotNullParameter(r7, "item");
        ViewGroup.LayoutParams r0 = null;
        if (r8 == null) goto L5;
        Context r1 = r8.getContext();
    L7:
        if ((r7 instanceof l0) == false) goto L81;
        if (r8 == null) goto L82;
        if (r1 == null) goto L83;
        View r2 = r8.findViewById(2131379929);
        if ((r2 instanceof TextView) == false) goto L14;
        TextView r3 = (TextView) r2;
    L15:
        l0 r9 = (l0) r7;
        String r4 = r9.c;
        if (r4 != null) goto L18;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == true) goto L24;
        CharSequence r6 = r9.c;
    L28:
        if (r6 == null) goto L31;
        if (r3 == null) goto L31;
        r3.setText(r6);
    L31:
        Integer r10 = r9.f;
        if (r10 == null) goto L36;
        int r11 = r10.intValue();
        if (r3 == null) goto L36;
        r3.setTextColor(ContextCompat.getColor(r1, r11));
    L36:
        View r12 = r8.findViewById(2131379912);
        if ((r12 instanceof ImageView) == false) goto L39;
        ImageView r13 = (ImageView) r12;
    L40:
        Integer r14 = r9.K;
        if (r14 == null) goto L45;
        int r15 = r14.intValue();
        ImageView r16 = (ImageView) r8.findViewById(2131388455);
        if (r16 == null) goto L45;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        r17.width = r15;
        r17.height = r15;
        r16.setLayoutParams(r17);
    L45:
        Integer r18 = r9.L;
        if (r18 == null) goto L54;
        int r19 = r18.intValue();
        if (r13 == null) goto L54;
        ViewGroup.LayoutParams r20 = r13.getLayoutParams();
        if (r20 == null) goto L52;
        r20.width = r19;
        r20.height = r19;
        r0 = r20;
    L52:
        r13.setLayoutParams(r0);
    L54:
        if (r9.j == false) goto L57;
        if (r13 == null) goto L62;
        r13.clearColorFilter();
    L62:
        Integer r21 = r9.h;
        if (r21 == null) goto L67;
        int r22 = r21.intValue();
        if (r13 == null) goto L67;
        r13.setImageResource(r22);
    L67:
        Integer r23 = r9.s;
        if (r23 == null) goto L72;
        int r24 = r23.intValue();
        if (r13 == null) goto L72;
        r13.setColorFilter(r24);
    L72:
        r8.setSelected(r9.j);
        Float r25 = r9.y;
        if (r25 == null) goto L76;
        float r26 = r25.floatValue();
    L79:
        r8.setAlpha(r26);
        r8.setEnabled(r9.p);
        return;
    L76:
        if (r9.q == false) goto L78;
        r26 = 0.5f;
        goto L79
    L78:
        r26 = 1.0f;
        goto L79
    L57:
        Integer r27 = r9.f;
        if (r27 == null) goto L62;
        int r28 = r27.intValue();
        if (r13 == null) goto L62;
        r13.setColorFilter(ContextCompat.getColor(r1, r28));
        goto L62
    L39:
        r13 = null;
        goto L40
    L24:
        int r29 = r9.b;
        if (r29 == 0) goto L27;
        r6 = r1.getText(r29);
        goto L28
    L27:
        r6 = null;
        goto L28
    L18:
        if (r4.length() == 0) goto L21;
        r5 = false;
        goto L22
    L14:
        r3 = null;
        goto L15
    L83:
        return;
    L82:
        return;
    L81:
        return;
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ot8.b
    public final View a(CommonMenu r6, int r7, int r8, ot8.a r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r9, "item");
        if ((r9 instanceof l0) == true) goto L6;
        return null;
    L6:
        FrameLayout r0 = new FrameLayout(r6.getContext());
        r0.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, i5.d0()));
        l0 r10 = (l0) r9;
        int r1 = r10.o;
        int r2 = i5.A();
        r0.setPadding(r1, r0.getPaddingTop(), r2, r0.getPaddingBottom());
        if (r8 != 1) goto L9;
        Drawable r11 = r0.getContext().getDrawable(v19.c.b(2130970624, r0.getContext(), 2131238869));
    L15:
        r0.setBackground(r11);
        final LarusScreenMenuItemLayoutBinding r12 = LarusScreenMenuItemLayoutBinding.a(LayoutInflater.from(r6.getContext()), r0);
        Integer r13 = r10.K;
        if (r13 == null) goto L18;
        int r14 = r13.intValue();
        SimpleDraweeView r3 = r12.h;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        r4.width = r14;
        r4.height = r14;
        r3.setLayoutParams(r4);
    L18:
        Integer r15 = r10.L;
        if (r15 == null) goto L21;
        int r16 = r15.intValue();
        AppCompatImageView r5 = r12.c;
        ViewGroup.LayoutParams r17 = r5.getLayoutParams();
        r17.width = r16;
        r17.height = r16;
        r5.setLayoutParams(r17);
    L21:
        AppCompatTextView r18 = r12.f;
        String r19 = r10.c;
        int r20 = 0;
        if (r19 != null) goto L24;
    L27:
        boolean r21 = true;
    L28:
        if (r21 == true) goto L31;
        CharSequence r22 = r10.c;
    L34:
        r18.setText(r22);
        r12.f.post(new n0(r12));
        if (r10.f == null) goto L37;
        r12.f.setTextColor(ContextCompat.getColor(r6.getContext(), r10.f.intValue()));
    L37:
        com.larus.utils.e1.o(r12.e);
        AppCompatImageView r23 = r12.c;
        if (r10.h == null) goto L40;
        boolean r24 = true;
    L42:
        if (r24 == false) goto L44;
        int r25 = 0;
    L45:
        r23.setVisibility(r25);
        SimpleDraweeView r26 = r12.g;
        String r27 = r10.i;
        if (r27 != null) goto L48;
    L51:
        boolean r28 = true;
    L53:
        if ((true ^ r28) == true) goto L56;
        r20 = 8;
    L56:
        r26.setVisibility(r20);
        Integer r29 = r10.h;
        if (r29 == null) goto L59;
        int r30 = r29.intValue();
        r12.c.setImageResource(r30);
    L59:
        Integer r31 = r10.f;
        if (r31 == null) goto L67;
        int r32 = r31.intValue();
        r12.f.setTextColor(ContextCompat.getColor(r6.getContext(), r32));
        if (r10.j == true) goto L65;
        r12.c.setColorFilter(ContextCompat.getColor(r6.getContext(), r32));
        goto L67
    L65:
        if (r10.g == null) goto L67;
        r12.f.setTextColor(ContextCompat.getColor(r6.getContext(), r10.g.intValue()));
    L67:
        Integer r33 = r10.s;
        if (r33 == null) goto L70;
        int r34 = r33.intValue();
        r12.c.setColorFilter(r34);
    L70:
        String r35 = r10.i;
        if (r35 == null) goto L74;
        ImageLoaderKt.y(r12.g, r35, "default_menu", new o0(), 4);
    L74:
        if (com.larus.utils.o0.d(r10.n) == false) goto L80;
        com.larus.utils.e1.x(r12.h);
        if (r10.m == null) goto L78;
        r12.h.getHierarchy().setPlaceholderImage(r10.m.intValue());
    L78:
        ImageLoaderKt.u(r12.h, r10.n, "default_menu_text");
    L82:
        Integer r36 = r10.r;
        if (r36 == null) goto L85;
        r12.h.setColorFilter(r36.intValue());
    L85:
        View r37 = r12.a;
        Float r38 = r10.y;
        if (r38 == null) goto L89;
        float r39 = r38.floatValue();
    L92:
        r37.setAlpha(r39);
        r12.a.setSelected(r10.j);
        return r0;
    L89:
        if (r10.q == false) goto L91;
        r39 = 0.5f;
        goto L92
    L91:
        r39 = 1.0f;
        goto L92
    L80:
        if (r10.m == null) goto L82;
        com.larus.utils.e1.x(r12.h);
        r12.h.setImageResource(r10.m.intValue());
        goto L82
    L48:
        if (r27.length() == 0) goto L51;
        r28 = false;
        goto L53
    L44:
        r25 = 8;
        goto L45
    L40:
        r24 = false;
        goto L42
    L31:
        if (r10.b == 0) goto L33;
        r22 = r6.getContext().getText(r10.b);
        goto L34
    L33:
        r22 = "";
        goto L34
    L24:
        if (r19.length() == 0) goto L27;
        r21 = false;
        goto L28
    L9:
        if (r7 != 0) goto L12;
        r11 = r0.getContext().getDrawable(v19.c.b(2130970615, r0.getContext(), 2131238839));
        goto L15
    L12:
        if (r7 != (r8 - 1)) goto L14;
        r11 = r0.getContext().getDrawable(v19.c.b(2130970618, r0.getContext(), 2131238849));
        goto L15
    L14:
        r11 = r0.getContext().getDrawable(v19.c.b(2130970621, r0.getContext(), 2131238859));
        goto L15
    }

    @Override // ot8.b
    public final void b(CommonMenu r2, final ot8.a r3, View r4, final Function1<? super ot8.a, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (r4 == null) goto L6;
        r4.setOnClickListener(new p0(r5, r3));
        return;
    }
}
