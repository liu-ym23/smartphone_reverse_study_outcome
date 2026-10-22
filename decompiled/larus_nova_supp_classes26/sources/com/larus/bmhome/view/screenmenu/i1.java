package com.larus.bmhome.view.screenmenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.larus.common_res.common_ui.databinding.LarusScreenWidgetSwitchMenuItemLayoutBinding;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i1 implements ot8.b {
    public boolean a;

    public static final class a extends BasePostprocessor {
        public a() {
        }

        public final void process(Bitmap r4) {
            super.process(r4);
            if (r4 != null) goto L5;
            return;
        L5:
            new Canvas(r4).drawBitmap(r4, 0.0f, 0.0f, new Paint());
        }
    }

    public i1() {
    }

    @Override // ot8.b
    public void update(ot8.a r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if (r4 == null) goto L5;
        Context r0 = r4.getContext();
    L7:
        if ((r3 instanceof f1) == false) goto L13;
        if (r4 == null) goto L14;
        if (r0 == null) goto L15;
        f1 r5 = (f1) r3;
        r4.setSelected(r5.g);
        c(r0, LarusScreenWidgetSwitchMenuItemLayoutBinding.a(r4), r5);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r0 = null;
        goto L7
    }

    public final void c(Context r5, LarusScreenWidgetSwitchMenuItemLayoutBinding r6, f1 r7) {
        boolean r0 = r7.i;
        SwitchCompat r1 = r6.b;
        boolean r2 = true;
        this.a = true;
        r1.setChecked(r0);
        int r3 = 0;
        this.a = false;
        r6.c.setText(r7.c);
        SimpleDraweeView r4 = r6.d;
        String r8 = r7.d;
        if (r8 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == true) goto L11;
    L14:
        if (r2 == true) goto L17;
        r3 = 8;
    L17:
        r4.setVisibility(r3);
        Integer r10 = r7.f;
        if (r10 == null) goto L20;
        int r11 = r10.intValue();
        r6.c.setTextColor(r11);
    L21:
        Integer r12 = r7.e;
        if (r12 == null) goto L24;
        int r13 = r12.intValue();
        r6.d.setImageResource(r13);
    L24:
        String r14 = r7.d;
        if (r14 == null) goto L27;
        ImageLoaderKt.y(r6.d, r14, "default_menu", new g1(), 4);
    L27:
        r6.a.setSelected(r7.g);
        return;
    L20:
        r6.c.setTextColor(ContextCompat.getColor(r5, v19.c.b(2130972079, r5, 2131103136)));
        goto L21
    L11:
        if (r7.e != null) goto L14;
        r2 = false;
        goto L14
    L5:
        if (r8.length() == 0) goto L8;
        r9 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ot8.b
    public final View a(CommonMenu r6, int r7, int r8, ot8.a r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r9, "item");
        if ((r9 instanceof f1) == true) goto L6;
        return null;
    L6:
        FrameLayout r0 = new FrameLayout(r6.getContext());
        r0.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, i5.d0()));
        int r1 = i5.q();
        int r2 = i5.A();
        r0.setPadding(r1, r0.getPaddingTop(), r2, r0.getPaddingBottom());
        if (r8 != 1) goto L9;
        Drawable r10 = r0.getContext().getDrawable(v19.c.b(2130970624, r0.getContext(), 2131238869));
    L15:
        r0.setBackground(r10);
        r0.setEnabled(false);
        View r11 = LayoutInflater.from(r6.getContext()).inflate(2131563109, r0, false);
        r0.addView(r11);
        LarusScreenWidgetSwitchMenuItemLayoutBinding r12 = LarusScreenWidgetSwitchMenuItemLayoutBinding.a(r11);
        c(r6.getContext(), r12, (f1) r9);
        return r0;
    L9:
        if (r7 != 0) goto L12;
        r10 = r0.getContext().getDrawable(v19.c.b(2130970615, r0.getContext(), 2131238839));
        goto L15
    L12:
        if (r7 != (r8 - 1)) goto L14;
        r10 = r0.getContext().getDrawable(v19.c.b(2130970618, r0.getContext(), 2131238849));
        goto L15
    L14:
        r10 = r0.getContext().getDrawable(v19.c.b(2130970621, r0.getContext(), 2131238859));
        goto L15
    }

    @Override // ot8.b
    public final void b(CommonMenu r2, final ot8.a r3, View r4, final Function1<? super ot8.a, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if ((r3 instanceof f1) == false) goto L5;
        f1 r6 = (f1) r3;
    L6:
        if (r6 == null) goto L14;
        if (r4 == null) goto L9;
        r4.setOnClickListener(new dg5.d());
    L9:
        if (r4 == null) goto L15;
        SwitchCompat r7 = r4.findViewById(2131379928);
        if (r7 == null) goto L16;
        r7.setOnCheckedChangeListener(new h1(r3, this, r5));
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
