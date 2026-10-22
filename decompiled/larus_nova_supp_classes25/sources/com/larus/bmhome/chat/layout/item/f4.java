package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.databinding.LarusLayoutFileCardBinding;
import com.larus.bmhome.view.FileNameView;
import com.larus.common_ui.widget.CircleProgressBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f4 extends xc8.h {
    public static final /* synthetic */ int s = 0;
    public final FrameLayout p;
    public final CircleProgressBarView q;
    public final LarusLayoutFileCardBinding r;

    public f4(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12);
        FrameLayout r0 = new FrameLayout(r12);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r0.setBackgroundColor(ContextCompat.getColor(r12, 2131103293));
        this.p = r0;
        int r1 = r12.getResources().getDimensionPixelSize(v19.c.b(2130971255, r12, 2131166880));
        View r2 = new CircleProgressBarView(r12, null, 6, 0);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(r1, r1);
        r3.gravity = 17;
        r2.setLayoutParams(r3);
        r2.a(10.0f, 2.5f);
        this.q = r2;
        View r13 = LayoutInflater.from(r12).inflate(2131562814, this, false);
        addView(r13);
        int r4 = 2131372415;
        FileNameView r6 = ViewBindings.findChildViewById(r13, 2131372415);
        if (r6 == null) goto L15;
        r4 = 2131374968;
        CardView r5 = ViewBindings.findChildViewById(r13, 2131374968);
        if (r5 == null) goto L15;
        r4 = 2131375091;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r13, 2131375091);
        if (r8 == null) goto L15;
        r4 = 2131378924;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r13, 2131378924);
        if (r9 == null) goto L15;
        RelativeLayout r7 = (RelativeLayout) r13;
        r4 = 2131390083;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r13, 2131390083);
        if (r10 == null) goto L15;
        this.r = new LarusLayoutFileCardBinding(r7, r6, r5, r8, r9, r10);
        r5.addView(r0);
        r5.addView(r2);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r4)));
    }

    public final void setProcess(long r2) {
        this.q.setProgress(r2);
    }

    public final void n(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errMsg");
        if (r2 == false) goto L24;
        LarusLayoutFileCardBinding r4 = this.r;
        if (r4 == null) goto L9;
        CardView r5 = r4.c;
        if (r5 == null) goto L9;
        com.larus.utils.e1.o(r5);
    L9:
        LarusLayoutFileCardBinding r6 = this.r;
        if (r6 == null) goto L14;
        FileNameView r7 = r6.b;
        if (r7 == null) goto L14;
        com.larus.utils.e1.o(r7);
    L14:
        LarusLayoutFileCardBinding r8 = this.r;
        if (r8 == null) goto L19;
        LinearLayout r9 = r8.e;
        if (r9 == null) goto L19;
        com.larus.utils.e1.x(r9);
    L19:
        LarusLayoutFileCardBinding r10 = this.r;
        if (r10 == null) goto L40;
        TextView r11 = r10.f;
        if (r11 == null) goto L41;
        r11.setText(r3);
        return;
    L41:
        return;
    L40:
        return;
    L24:
        LarusLayoutFileCardBinding r12 = this.r;
        if (r12 == null) goto L29;
        CardView r13 = r12.c;
        if (r13 == null) goto L29;
        com.larus.utils.e1.x(r13);
    L29:
        LarusLayoutFileCardBinding r14 = this.r;
        if (r14 == null) goto L34;
        FileNameView r15 = r14.b;
        if (r15 == null) goto L34;
        com.larus.utils.e1.x(r15);
    L34:
        LarusLayoutFileCardBinding r16 = this.r;
        if (r16 == null) goto L43;
        LinearLayout r17 = r16.e;
        if (r17 == null) goto L44;
        com.larus.utils.e1.o(r17);
        return;
    L44:
        return;
    }
}
