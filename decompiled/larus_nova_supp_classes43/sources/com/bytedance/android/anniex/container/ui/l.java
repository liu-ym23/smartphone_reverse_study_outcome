package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import bolts.Task;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import y36.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l extends com.bytedance.android.anniex.base.service.d.b {
    public boolean a;
    public FrameLayout b;
    public AppCompatImageView c;
    public TextView d;
    public LinearLayout e;

    public static final class a {
    }

    static {
    }

    public l() {
        this.a = true;
    }

    @Override // com.bytedance.android.anniex.base.service.d.b
    public final void b(int r10) {
        FrameLayout r0 = this.b;
        if (r0 == null) goto L6;
        r0.setBackgroundColor(r10);
        return;
    }

    @Override // com.bytedance.android.anniex.base.service.d.b
    public final void c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        TextView r0 = this.d;
        if (r0 == null) goto L7;
        SpannableString r1 = new SpannableString(r10);
        r1.setSpan(new StyleSpan(1), 0, r1.length(), 33);
        r0.setText(r1);
        return;
    }

    @Override // com.bytedance.android.anniex.base.service.d.b
    public final void d(int r10) {
        TextView r0 = this.d;
        if (r0 == null) goto L6;
        r0.setTextColor(r10);
        return;
    }

    @Override // com.bytedance.android.anniex.base.service.d.b
    public final void e(boolean r10) {
        FrameLayout r0 = this.b;
        if (r0 == null) goto L10;
        if (r10 == false) goto L7;
        int r11 = 0;
    L8:
        r0.setVisibility(r11);
        return;
    L7:
        r11 = 8;
        goto L8
    }

    @Override // com.bytedance.android.anniex.base.service.d.b
    public final void f(boolean r10) {
        AppCompatImageView r0 = this.c;
        if (r0 == null) goto L10;
        if (r10 == false) goto L7;
        int r11 = 0;
    L8:
        r0.setVisibility(r11);
        return;
    L7:
        r11 = 4;
        goto L8
    }

    public final int h(ia.c r10) {
        if (this.a == true) goto L12;
        t36.d r11 = r10.getSchemaData();
        if (r11 == null) goto L11;
        Integer r12 = (Integer) ((y36.i) new r(r11, "title_color")).b;
        if (r12 == null) goto L11;
        return r12.intValue();
    L11:
        return ((Number) AnnieXRuntime.a().c.getValue()).intValue();
    L12:
        return ((Number) AnnieXRuntime.a().c.getValue()).intValue();
    }

    @Override // com.bytedance.android.anniex.base.service.d.b
    public final View a(Context r11, ia.c r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "container");
        LinearLayout r10 = new LinearLayout(r11);
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "container");
        String r13 = r12.getContainerId();
        AppCompatImageView r14 = g(r11, h(r12), 2131248403);
        r14.setOnClickListener(new m(r12, this, r13));
        r10.addView(r14);
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "container");
        String r15 = r12.getContainerId();
        AppCompatImageView r16 = g(r11, h(r12), 2131248404);
        r16.setOnClickListener(new n(r12, this, r15));
        r16.setVisibility(4);
        this.c = r16;
        r10.addView(r16);
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-2, -2, 8388611);
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "container");
        TextView r18 = new TextView(r11);
        r18.setTextSize(2, 17.0f);
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(-2, -2);
        r19.gravity = 17;
        r18.setLayoutParams(r19);
        r18.setGravity(17);
        r18.setMaxEms(9);
        r18.setMaxLines(1);
        r18.setEllipsize(TextUtils.TruncateAt.END);
        r18.setTextColor(h(r12));
        this.d = r18;
        FrameLayout.LayoutParams r20 = new FrameLayout.LayoutParams(-2, -2, 17);
        LinearLayout r21 = new LinearLayout(r11);
        if (this.a == false) goto L5;
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "container");
        String r22 = r12.getContainerId();
        AppCompatImageView r23 = g(r11, h(r12), 2131248406);
        r23.setOnClickListener(new p(r12, this, r22));
        r21.addView(r23);
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "container");
        String r0 = r12.getContainerId();
        AppCompatImageView r1 = g(r11, h(r12), 2131248405);
        r1.setOnClickListener(new o(r12, r0, this));
        r21.addView(r1);
    L5:
        this.e = r21;
        FrameLayout.LayoutParams r24 = new FrameLayout.LayoutParams(-2, -2, 8388613);
        if (this.a == false) goto L11;
        MonitorCenter r25 = MonitorCenter.c;
        String r110 = r12.getContainerId();
        List r26 = CollectionsKt.listOf(new String[]{"back", com.bytedance.android.ec.core.event.a.VALUE_CLOSE, "search_amplifier", com.bytedance.android.ec.core.event.a.VALUE_MORE});
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "buttons");
        if (r110 == null) goto L11;
        Task.callInBackground(new com.bytedance.android.anniex.base.monitor.e(r25, r110, r26));
    L11:
        FrameLayout r111 = new FrameLayout(r11);
        r111.addView(r10, r17);
        TextView r112 = this.d;
        if (r112 == null) goto L14;
        r111.addView(r112, r20);
    L14:
        r111.addView(this.e, r24);
        this.b = r111;
        return r111;
    }

    public static AppCompatImageView g(Context r10, int r11, int r12) {
        int r0 = i16.c.f(8, r10);
        AppCompatImageView r1 = new AppCompatImageView(r10);
        r1.setPadding(r0, r0, r0, r0);
        VectorDrawableCompat r13 = VectorDrawableCompat.create(r10.getResources(), r12, r10.getTheme());
        if (r13 == null) goto L5;
        r13.setTint(r11);
    L5:
        r1.setImageDrawable(r13);
        return r1;
    }
}
