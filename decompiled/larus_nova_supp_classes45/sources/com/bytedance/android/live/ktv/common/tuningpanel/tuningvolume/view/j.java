package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j extends LinearLayout {
    public final Lazy a;
    public final Lazy b;

    public final SeekBarWithProgress getVolumeSeekBar() {
        return (SeekBarWithProgress) this.b.getValue();
    }

    public final TextView getVolumeTitle() {
        return (TextView) this.a.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SeekBarWithProgress r0 = getVolumeSeekBar();
        if (r0 == null) goto L6;
        r0.c = null;
        return;
    }

    public j(gc0.c r4, Context r5, boolean r6, int r7) {
        if ((r7 & 16) == 0) goto L5;
        r6 = false;
    L5:
        Intrinsics.checkNotNullParameter(r4, "tuningVolumeItemViewCallback");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 0);
        this.a = LazyKt.lazy(new TuningVolumeItemView$volumeTitle$2(this));
        this.b = LazyKt.lazy(new TuningVolumeItemView$volumeSeekBar$2(this));
        LayoutInflater.from(r5).inflate(2131566542, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(0);
        setGravity(17);
        setPadding(s1.f(16.0f), s1.f(18.0f), s1.f(16.0f), s1.f(0.0f));
        TextView r8 = getVolumeTitle();
        if (r8 == null) goto L8;
        r8.setText(r4.a());
    L8:
        if (r6 == false) goto L12;
        TextView r9 = getVolumeTitle();
        if (r9 == null) goto L12;
        r9.setTextSize(13.0f);
    L12:
        SeekBarWithProgress r11 = getVolumeSeekBar();
        if (r11 == null) goto L15;
        r11.setSeekBarProgressTvColor(ColorProtector.parseColor("#000000"));
    L15:
        SeekBarWithProgress r12 = getVolumeSeekBar();
        if (r12 == null) goto L18;
        r12.setThumbColor(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.s));
    L18:
        SeekBarWithProgress r13 = getVolumeSeekBar();
        if (r13 == null) goto L21;
        r13.setProgressBarDrawable(s1.m(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.v)));
    L21:
        SeekBarWithProgress r14 = getVolumeSeekBar();
        if (r14 == null) goto L24;
        int r15 = r4.c();
        r14.e = r15;
        r14.f = true;
        ((SeekBar) r14.a(2131385758)).setMax(r15);
    L24:
        SeekBarWithProgress r16 = getVolumeSeekBar();
        if (r16 == null) goto L27;
        r16.setInterceptCallBack(r4.b());
    L27:
        SeekBarWithProgress r17 = getVolumeSeekBar();
        if (r17 == null) goto L30;
        r17.c(r4.d());
    L30:
        SeekBarWithProgress r18 = getVolumeSeekBar();
        if (r18 == null) goto L34;
        r18.setOnSeekBarChangeListener(new i(r4));
        return;
    }
}
