package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;
import com.bytedance.android.livesdk.widget.rangeseekbar.SeekBar;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a extends b {
    public TextView c;
    public RangeSeekBar d;
    public TextView e;

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final void e() {
    }

    public abstract ov2.a g();

    public abstract f h();

    public abstract String i();

    public abstract void j();

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final void d() {
        TextView r0 = this.c;
        if (r0 == null) goto L5;
        r0.setText(i());
    L5:
        j();
        RangeSeekBar r1 = this.d;
        if (r1 == null) goto L9;
        r1.setOnRangeChangedListener(g());
        return;
    }

    public final void k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        TextView r0 = this.e;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public a(o r2, SimpleZDanmakuSettingDialogFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuSetting");
        Intrinsics.checkNotNullParameter(r3, "panelCallback");
        super(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final void c(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        View r6 = r4.inflate(2131566781, r5, true);
        if (r6 == null) goto L55;
        this.c = (TextView) r6.findViewById(2131388772);
        RangeSeekBar r7 = r6.findViewById(2131385750);
        if (r7 == null) goto L52;
        f r0 = h();
        r7.setGravity(r0.a);
        r7.setSeekBarMode(r0.b);
        Context r1 = r7.getContext();
        if (r1 == null) goto L11;
        Resources r2 = r1.getResources();
        if (r2 == null) goto L11;
        r7.setProgressColor(r2.getColor(r0.c));
    L11:
        Context r3 = r7.getContext();
        if (r3 == null) goto L16;
        Resources r8 = r3.getResources();
        if (r8 == null) goto L16;
        r7.setProgressDefaultColor(r8.getColor(r0.d));
    L16:
        r7.setProgressHeight(UtilityKotlinExtentionsKt.i(r0.e));
        r7.setProgressRadius(UtilityKotlinExtentionsKt.h(r0.f));
        r7.setStepCircleStyle(r0.g);
        Context r9 = r7.getContext();
        if (r9 == null) goto L21;
        Resources r10 = r9.getResources();
        if (r10 == null) goto L21;
        r7.setStepsColor(r10.getColor(r0.h));
    L21:
        Context r11 = r7.getContext();
        if (r11 == null) goto L26;
        Resources r13 = r11.getResources();
        if (r13 == null) goto L26;
        r7.setStepsCircleBorderColor(r13.getColor(r0.i));
    L26:
        r7.setStepsHeight(UtilityKotlinExtentionsKt.h(r0.j));
        r7.setStepsWidth(UtilityKotlinExtentionsKt.h(r0.k));
        Context r14 = r7.getContext();
        if (r14 == null) goto L33;
        Resources r15 = r14.getResources();
        if (r15 == null) goto L33;
        int r16 = r15.getColor(r0.l);
        SeekBar r17 = r7.getLeftSeekBar();
        if (r17 == null) goto L33;
        r17.u = r16;
    L33:
        SeekBar r18 = r7.getLeftSeekBar();
        if (r18 == null) goto L36;
        r18.t = UtilityKotlinExtentionsKt.i(r0.m);
    L36:
        SeekBar r19 = r7.getLeftSeekBar();
        if (r19 == null) goto L39;
        r19.s = UtilityKotlinExtentionsKt.i(r0.n);
    L39:
        SeekBar r20 = r7.getRightSeekBar();
        if (r20 == null) goto L42;
        r20.t = UtilityKotlinExtentionsKt.i(r0.o);
    L42:
        SeekBar r21 = r7.getRightSeekBar();
        if (r21 == null) goto L45;
        r21.s = UtilityKotlinExtentionsKt.i(r0.p);
    L45:
        SeekBar r23 = r7.getLeftSeekBar();
        if (r23 == null) goto L48;
        r23.a = r0.q;
    L48:
        SeekBar r24 = r7.getRightSeekBar();
        if (r24 == null) goto L51;
        r24.a = r0.r;
    L51:
        r7.setStepCount(r0.s);
        Unit r25 = Unit.INSTANCE;
    L53:
        this.d = r7;
        this.e = (TextView) r6.findViewById(2131368819);
        return;
    L52:
        r7 = null;
        goto L53
    }
}
