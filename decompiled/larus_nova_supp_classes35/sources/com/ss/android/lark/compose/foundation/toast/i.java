package com.ss.android.lark.compose.foundation.toast;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.ss.android.lark.flow.ud.databinding.FlowUdToastLayoutBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i {
    public final Context a;
    public final FlowUdToastLayoutBinding b;
    public ViewPropertyAnimator c;

    public static final class a {
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ Animatable a;
        public final /* synthetic */ i b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.start();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.stop();
            this.b.b.a.removeOnAttachStateChangeListener(this);
        }

        public b(Animatable r1, i r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public int a;
        public final /* synthetic */ i b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this.a != this.b.b.a.getWidth()) goto L5;
            return;
        L5:
            this.a = this.b.b.a.getWidth();
            ViewGroup.LayoutParams r0 = this.b.b.d.getLayoutParams();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r0;
            if (this.b.b.e.getLineCount() != 1) goto L8;
            r1.gravity = 16;
        L9:
            this.b.b.d.setLayoutParams(r1);
            return;
        L8:
            r1.gravity = 48;
            goto L9
        }

        public c(i r1) {
            this.b = r1;
        }
    }

    static {
    }

    public final void b() {
        this.b.b.getText().length();
        ImageView r0 = this.b.d;
        r0.getDrawable();
        Object r1 = r0.getDrawable();
        if ((r1 instanceof Animatable) == false) goto L5;
        Animatable r2 = (Animatable) r1;
    L6:
        if (r2 == null) goto L8;
        this.b.a.addOnAttachStateChangeListener(new b(r2, this));
    L8:
        TextView r3 = this.b.e;
        r3.setGravity(8388611);
        int r4 = h18.d.d(this.a, 2131166517) - (h18.d.d(this.a, 2131166519) * 2);
        if (this.b.d.getVisibility() != 0) goto L12;
        r4 = (r4 - h18.d.d(this.a, 2131166516)) - h18.d.d(this.a, 2131166520);
    L12:
        if (this.b.b.getVisibility() != 0) goto L14;
        int r5 = (r4 - (h18.d.d(this.a, 2131166518) * 2)) - h18.d.d(this.a, 2131166515);
        int r6 = h18.d.d(this.a, 2131166514);
        r4 = r5 - Math.min((int) this.b.b.getPaint().measureText(this.b.b.getText().toString()), r6);
    L14:
        r3.setMaxWidth(r4);
        r3.getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public i(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this.a = r9;
        UDShadowLayout r10 = LayoutInflater.from(r9).inflate(2131561148, null, false);
        int r0 = 2131373043;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, 2131373043);
        if (r4 == null) goto L15;
        r0 = 2131373044;
        View r5 = ViewBindings.findChildViewById(r10, 2131373044);
        if (r5 == null) goto L15;
        r0 = 2131373045;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r10, 2131373045);
        if (r6 == null) goto L15;
        r0 = 2131373046;
        if (((LinearLayout) ViewBindings.findChildViewById(r10, 2131373046)) == null) goto L15;
        UDShadowLayout r3 = r10;
        r0 = 2131373048;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, 2131373048);
        if (r7 == null) goto L15;
        this.b = new FlowUdToastLayoutBinding(r3, r4, r5, r6, r7);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }

    public final void a(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.b.d.setImageDrawable(r2);
        this.b.d.setVisibility(0);
    }
}
