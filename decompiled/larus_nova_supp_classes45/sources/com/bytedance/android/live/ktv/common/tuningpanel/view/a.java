package com.bytedance.android.live.ktv.common.tuningpanel.view;

import ac0.b;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListView;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view.TuningEffectListView;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.TuningVolumeContentArea;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends LinearLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    private final FrameLayout getAdjustContentArea() {
        return (FrameLayout) this.c.getValue();
    }

    private final FrameLayout getBottomEntranceArea() {
        return (FrameLayout) this.e.getValue();
    }

    private final FrameLayout getCustomEntranceArea() {
        return (FrameLayout) this.b.getValue();
    }

    private final FrameLayout getSoundEffectArea() {
        return (FrameLayout) this.d.getValue();
    }

    private final FrameLayout getTopSwitchArea() {
        return (FrameLayout) this.a.getValue();
    }

    public a(b r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 0);
        this.a = LazyKt.lazy(new TuningContentContainer$topSwitchArea$2(this));
        this.b = LazyKt.lazy(new TuningContentContainer$customEntranceArea$2(this));
        this.c = LazyKt.lazy(new TuningContentContainer$adjustContentArea$2(this));
        this.d = LazyKt.lazy(new TuningContentContainer$soundEffectArea$2(this));
        this.e = LazyKt.lazy(new TuningContentContainer$bottomEntranceArea$2(this));
        LayoutInflater.from(r5).inflate(2131566538, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        if (r4.b == false) goto L9;
        FrameLayout r6 = getTopSwitchArea();
        if (r6 == null) goto L7;
        r6.removeAllViews();
    L7:
        if (r6 == null) goto L9;
        r6.addView(new TuningButtonListView(r4, getContext()));
    L9:
        FrameLayout r7 = getCustomEntranceArea();
        if (r7 == null) goto L19;
        r7.removeAllViews();
        Function1<ViewGroup, View> r0 = r4.i;
        if (r0 == null) goto L19;
        View r1 = (View) r0.invoke(r7);
        if (r1 == null) goto L19;
        r7.addView(r1);
    L19:
        if (r4.d == false) goto L26;
        FrameLayout r8 = getAdjustContentArea();
        if (r8 == null) goto L23;
        r8.removeAllViews();
    L23:
        if (r8 == null) goto L26;
        r8.addView(new TuningVolumeContentArea(r4, getContext()));
    L26:
        if (r4.c == false) goto L32;
        FrameLayout r9 = getSoundEffectArea();
        if (r9 == null) goto L30;
        r9.removeAllViews();
    L30:
        if (r9 == null) goto L32;
        r9.addView(new TuningEffectListView(r4, getContext()));
    L32:
        FrameLayout r11 = getBottomEntranceArea();
        if (r11 == null) goto L43;
        r11.removeAllViews();
        Function1<ViewGroup, View> r12 = r4.j;
        if (r12 == null) goto L42;
        View r13 = (View) r12.invoke(r11);
        if (r13 == null) goto L44;
        r11.addView(r13);
        return;
    L44:
        return;
    L42:
        return;
    }
}
