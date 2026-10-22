package com.larksuite.component.card.component.slider;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import com.google.gson.Gson;
import com.larksuite.component.card.component.g;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.UIUtils;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0014J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0010H\u0002J\u001c\u0010\u0011\u001a\u00020\u0012*\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015H\u0002J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0013H\u0002¨\u0006 "}, d2 = {"Lcom/larksuite/component/card/component/slider/UniversalCardLynxSliderUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/card/component/slider/CardSeekBar;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "createView", "Landroid/content/Context;", "initSeekBar", "", "seekBar", "setProps", "props", "Lcom/lynx/react/bridge/ReadableMap;", "applyProps", "Lcom/larksuite/component/card/component/slider/CardSliderProps;", "toColorOrDefault", "", "", "default", "Lkotlin/Function0;", "createProgressDrawable", "Landroid/graphics/drawable/Drawable;", "bgColor", "fillColor", "createThumbDrawable", "knobColor", "sendEvent", "value", "mode", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UniversalCardLynxSliderUI extends LynxUI<CardSeekBar> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public UniversalCardLynxSliderUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final View createView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        CardSeekBar r0 = new CardSeekBar(r4, 0);
        r0.setMax(100);
        r0.setBackground(null);
        r0.setSplitTrack(false);
        int r5 = UIUtils.dp2px(r4, 8.0f);
        r0.setPadding(r5, 0, r5, 0);
        N(r0, new com.larksuite.component.card.component.slider.a(0));
        r0.setOnSeekBarChangeListener(new c(this));
        return r0;
    }

    @LynxProp(name = "props")
    public final void setProps(ReadableMap r3) {
        CardSeekBar r0 = (CardSeekBar) getView();
        if (r0 != null) goto L6;
        Log.e("UniversalCardLynxSliderUI", "setProps fail, view is null");
        return;
    L6:
        if (r3 == null) goto L9;
        Gson r1 = g.a;
        com.larksuite.component.card.component.slider.a r4 = (com.larksuite.component.card.component.slider.a) g.c(r3, com.larksuite.component.card.component.slider.a.class);
        if (r4 == null) goto L9;
    L10:
        N(r0, r4);
        return;
    L9:
        r4 = new com.larksuite.component.card.component.slider.a(0);
        goto L10
    }

    public static int O(String r3, Function0 r4) {
        if (r3 == null) goto L4;
        return Color.parseColor(r3);
    L7:
        th = move-exception;
        Log.e("UniversalCardLynxSliderUI", "parse color " + r3 + " error", th);
        return ((Number) r4.invoke()).intValue();
    L4:
        return ((Number) r4.invoke()).intValue();
    }

    public final void N(CardSeekBar r10, com.larksuite.component.card.component.slider.a r11) {
        final Context r0 = getLynxContext().getContext();
        r10.setEnabled(!r11.b());
        Integer r1 = r11.e();
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        r10.setProgress(r2);
        int r3 = O(r11.a(), new UniversalCardLynxSliderUI$applyProps$bgColor$1(r0));
        int r4 = O(r11.c(), new UniversalCardLynxSliderUI$applyProps$fillColor$1(r0));
        int r12 = O(r11.d(), new UniversalCardLynxSliderUI$applyProps$knobColor$1(r0));
        Intrinsics.checkNotNull(r0);
        GradientDrawable r5 = new GradientDrawable();
        r5.setShape(0);
        r5.setCornerRadius(UIUtils.dp2px(r0, 1.0f));
        r5.setColor(r3);
        GradientDrawable r7 = new GradientDrawable();
        r7.setShape(0);
        r7.setCornerRadius(UIUtils.dp2px(r0, 1.0f));
        r7.setColor(r3);
        ClipDrawable r6 = new ClipDrawable(r7, 8388611, 1);
        GradientDrawable r8 = new GradientDrawable();
        r8.setShape(0);
        r8.setCornerRadius(UIUtils.dp2px(r0, 1.0f));
        r8.setColor(r4);
        LayerDrawable r9 = new LayerDrawable(new Drawable[]{r5, r6, new ClipDrawable(r8, 8388611, 1)});
        r9.setId(0, R.id.background);
        r9.setId(1, R.id.secondaryProgress);
        r9.setId(2, R.id.progress);
        r10.setProgressDrawable(r9);
        GradientDrawable r13 = new GradientDrawable();
        r13.setShape(1);
        int r14 = UIUtils.dp2px(r0, 16.0f);
        r13.setSize(r14, r14);
        r13.setColor(r12);
        r13.setStroke(UIUtils.dp2px(r0, 0.5f), UIUtils.getAlphaColor(r12, 0.15d));
        r10.setThumb(r13);
        r10.setThumbOffset(UIUtils.dp2px(r0, 8.0f));
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public static final void M(UniversalCardLynxSliderUI r2, int r3, String r4) {
        r2.getClass();
        HashMap r0 = new HashMap();
        r0.put("value", Integer.valueOf(r3));
        r0.put("mode", r4);
        r2.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(r2.getSign(), "valueChange", r0));
    }
}
