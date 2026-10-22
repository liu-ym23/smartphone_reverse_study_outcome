package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.adjust.view.ToneProcessView;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends LinearLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public final TextView getAdjustToneTitle() {
        return (TextView) this.a.getValue();
    }

    public final View getIcDecrease() {
        return (View) this.b.getValue();
    }

    public final View getIcIncrease() {
        return (View) this.d.getValue();
    }

    public final ToneProcessView getToneProcess() {
        return (ToneProcessView) this.c.getValue();
    }

    public c(gc0.a r4, Context r5, boolean r6, int r7) {
        if ((r7 & 16) == 0) goto L5;
        r6 = false;
    L5:
        Intrinsics.checkNotNullParameter(r4, "tuningToneItemViewCallback");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 0);
        this.a = LazyKt.lazy(new TuningToneItemView$adjustToneTitle$2(this));
        this.b = LazyKt.lazy(new TuningToneItemView$icDecrease$2(this));
        this.c = LazyKt.lazy(new TuningToneItemView$toneProcess$2(this));
        this.d = LazyKt.lazy(new TuningToneItemView$icIncrease$2(this));
        LayoutInflater.from(r5).inflate(2131566541, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(0);
        setGravity(17);
        setPadding(s1.f(16.0f), s1.f(18.0f), s1.f(16.0f), s1.f(0.0f));
        TextView r8 = getAdjustToneTitle();
        if (r8 == null) goto L8;
        r8.setText(s1.B(2131918190));
    L8:
        if (r6 == false) goto L12;
        TextView r9 = getAdjustToneTitle();
        if (r9 == null) goto L12;
        r9.setTextSize(13.0f);
    L12:
        ToneProcessView r11 = getToneProcess();
        if (r11 == null) goto L15;
        r11.setHighLightColor(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.w));
    L15:
        ToneProcessView r12 = getToneProcess();
        if (r12 == null) goto L22;
        int r13 = r4.a();
        int r14 = r12.f;
        int r0 = ((r14 / 2) + 1) + r13;
        if (1 > r0) goto L22;
        if (r14 < r0) goto L22;
        r12.j = r0;
        r12.invalidate();
    L22:
        View r15 = getIcDecrease();
        if (r15 == null) goto L25;
        r15.setOnClickListener(new a(this, r4));
    L25:
        View r16 = getIcIncrease();
        if (r16 == null) goto L29;
        r16.setOnClickListener(new b(this, r4));
        return;
    }
}
