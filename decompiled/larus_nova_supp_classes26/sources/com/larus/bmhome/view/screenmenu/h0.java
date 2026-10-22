package com.larus.bmhome.view.screenmenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.larus.common_res.common_ui.databinding.LarusScreenMenuItemLayoutBinding;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h0 implements ot8.b {

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ LottieAdapterView b;
        public final /* synthetic */ ot8.a c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            this.a.removeOnAttachStateChangeListener(this);
            LottieAdapterView r3 = this.b;
            ((f0) this.c).getClass();
            r3.setAnimation(null);
            this.b.playAnimation();
        }

        public a(LottieAdapterView r1, LottieAdapterView r2, ot8.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ LottieAdapterView b;
        public final /* synthetic */ ot8.a c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            this.a.removeOnAttachStateChangeListener(this);
            LottieAdapterView r3 = this.b;
            ((f0) this.c).getClass();
            r3.setAnimation(null);
            this.b.playAnimation();
        }

        public b(LottieAdapterView r1, LottieAdapterView r2, ot8.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public h0() {
    }

    @Override // ot8.b
    public void update(ot8.a r6, View r7) {
        Intrinsics.checkNotNullParameter(r6, "item");
        if (r7 == null) goto L5;
        Context r1 = r7.getContext();
    L7:
        if ((r6 instanceof f0) == false) goto L28;
        if (r7 == null) goto L29;
        if (r1 == null) goto L32;
        View r2 = r7.findViewById(2131379929);
        if ((r2 instanceof TextView) == false) goto L14;
        TextView r3 = (TextView) r2;
    L16:
        if (r3 == null) goto L18;
        ((f0) r6).getClass();
        r3.setText(r1.getText(0));
    L18:
        LottieAdapterView r8 = r7.findViewById(2131379919);
        if ((r8 instanceof LottieAdapterView) == false) goto L21;
        LottieAdapterView r9 = r8;
    L22:
        if (r9 == null) goto L30;
        r9.cancelAnimation();
        ((f0) r6).getClass();
        r9.setImageAssetsFolder(null);
        r9.setRepeatMode(0);
        r9.setRepeatCount(0);
        if (r9.isAttachedToWindow() == false) goto L26;
        r9.setAnimation(null);
        r9.playAnimation();
        return;
    L26:
        r9.addOnAttachStateChangeListener(new b(r9, r9, r6));
        return;
    L30:
        return;
    L21:
        r9 = null;
        goto L22
    L14:
        r3 = null;
        goto L16
    L32:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ot8.b
    public final View a(CommonMenu r7, int r8, int r9, ot8.a r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r10, "item");
        if ((r10 instanceof f0) == true) goto L5;
        return null;
    L5:
        FrameLayout r0 = new FrameLayout(r7.getContext());
        r0.setLayoutParams(new LinearLayoutCompat.LayoutParams(i5.K(), i5.c0()));
        int r2 = i5.q();
        int r3 = i5.q();
        r0.setPadding(r2, r0.getPaddingTop(), r3, r0.getPaddingBottom());
        if (r9 != 1) goto L8;
        Drawable r11 = r0.getContext().getDrawable(v19.c.b(2130970624, r0.getContext(), 2131238869));
    L14:
        r0.setBackground(r11);
        LarusScreenMenuItemLayoutBinding r12 = LarusScreenMenuItemLayoutBinding.a(LayoutInflater.from(r7.getContext()), r0);
        f0 r4 = (f0) r10;
        r12.f.setText(r7.getContext().getText(0));
        com.larus.utils.e1.o(r12.c);
        LottieAdapterView r13 = r12.e;
        r13.setImageAssetsFolder(null);
        r13.setRepeatMode(0);
        r13.setRepeatCount(0);
        Intrinsics.checkNotNull(r13);
        if (r13.isAttachedToWindow() == false) goto L17;
        r13.setAnimation(null);
        r13.playAnimation();
    L18:
        return r0;
    L17:
        r13.addOnAttachStateChangeListener(new a(r13, r13, r10));
        goto L18
    L8:
        if (r8 != 0) goto L11;
        r11 = r0.getContext().getDrawable(v19.c.b(2130970615, r0.getContext(), 2131238839));
        goto L14
    L11:
        if (r8 != (r9 - 1)) goto L13;
        r11 = r0.getContext().getDrawable(v19.c.b(2130970618, r0.getContext(), 2131238849));
        goto L14
    L13:
        r11 = r0.getContext().getDrawable(v19.c.b(2130970621, r0.getContext(), 2131238859));
        goto L14
    }

    @Override // ot8.b
    public final void b(CommonMenu r2, final ot8.a r3, View r4, final Function1<? super ot8.a, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (r4 == null) goto L6;
        r4.setOnClickListener(new g0(r5, r3));
        return;
    }
}
