package com.larksuite.component.card.component.checkbox;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.google.gson.Gson;
import com.larksuite.component.card.component.g;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.LynxEventDetail;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\rH\u0014J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0012H\u0002J!\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0007R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larksuite/component/card/component/checkbox/UniversalCardLynxCheckBoxUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "squareShape", "", "Ljava/lang/Boolean;", "styles", "Lcom/larksuite/component/card/component/checkbox/CheckBoxStyles;", "createView", "Landroid/content/Context;", "dispatchEvent", "event", "Lcom/lynx/tasm/event/LynxEventDetail;", "setContent", "", "props", "Lcom/lynx/react/bridge/ReadableMap;", "resectView", "setCheckBoxEnable", "isEnabled", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "applyStyles", "setCheckBoxState", "state", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UniversalCardLynxCheckBoxUI extends LynxUI<UniversalCardCheckBox> {
    public static final /* synthetic */ int c = 0;
    public Boolean a;
    public CheckBoxStyles b;

    public static final class a {
    }

    static {
    }

    public final void M() {
        CheckBoxStyles r0 = this.b;
        if (r0 != null) goto L15;
        return;
    L15:
        String r1 = r0.getBackgroundColor();     // Catch: Exception -> L12
        if (r1 == null) goto L8;
        ((UniversalCardCheckBox) getView()).setUncheckedBackgroundColor(Color.parseColor(r1));     // Catch: Exception -> L12
    L8:
        String r2 = r0.getBorderColor();     // Catch: Exception -> L12
        if (r2 == null) goto L17;
        ((UniversalCardCheckBox) getView()).setUncheckedBorderColor(Color.parseColor(r2));     // Catch: Exception -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        Log.e("UniversalCardLynxCheckBoxUI", "applyStyles error", e);
    }

    public UniversalCardLynxCheckBoxUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = Boolean.FALSE;
    }

    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        UniversalCardCheckBox r0 = new UniversalCardCheckBox(r2);
        r0.setEnabled(true);
        r0.setPadding(0, 0, 0, 0);
        return r0;
    }

    public final boolean dispatchEvent(LynxEventDetail r1) {
        return super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.dispatchEvent(r1);
    }

    @LynxProp(name = "checkBoxState")
    public final void setCheckBoxState(ReadableMap r4) {
        if (r4 != null) goto L18;
        Log.i("UniversalCardLynxCheckBoxUI", "state null");
        return;
    L18:
        Gson r1 = g.a;     // Catch: Exception -> L8
        CheckBoxState r5 = (CheckBoxState) g.c(r4, CheckBoxState.class);     // Catch: Exception -> L8
    L10:
        if (r5 != null) goto L13;
        Log.e("UniversalCardLynxCheckBoxUI", "setCheckBoxState fail, content is empty");
        return;
    L13:
        UniversalCardCheckBox r0 = (UniversalCardCheckBox) getView();
        Boolean r2 = r5.isSelected();
        Boolean r3 = Boolean.TRUE;
        r0.setChecked(Intrinsics.areEqual(r2, r3));
        N(r5.isEnabled(), this.a);
        M();
        if (Intrinsics.areEqual(r5.getShowRequired(), r3) == false) goto L16;
        ((UniversalCardCheckBox) getView()).setColor(UDColorUtils.getColor(((UniversalCardCheckBox) getView()).getContext(), 2131102089));
        return;
    L16:
        ((UniversalCardCheckBox) getView()).setColor(0);
        return;
    L8:
        e = move-exception;
        Log.e("UniversalCardLynxCheckBoxUI", "state from lynx transform failed", e);
        r5 = null;
        goto L10
    }

    @LynxProp(name = "props")
    public final void setContent(ReadableMap r4) {
        TraceEvent.beginSection("UniversalCardLynxCheckBoxUI.setContent");
        this.a = Boolean.FALSE;
        if (r4 != null) goto L22;
        Log.i("UniversalCardLynxCheckBoxUI", "props null");
        return;
    L22:
        Gson r2 = g.a;     // Catch: Exception -> L8
        CheckBoxProps r5 = (CheckBoxProps) g.c(r4, CheckBoxProps.class);     // Catch: Exception -> L8
    L10:
        if (r5 != null) goto L13;
        Log.e("UniversalCardLynxCheckBoxUI", "setContent fail, content is empty");
        return;
    L13:
        Boolean r1 = r5.getSquareShape();
        this.a = r1;
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r3) == false) goto L17;
        ((UniversalCardCheckBox) getView()).setType(UniversalCardCheckBox.CheckBoxType.CHECK_BOX_SQUARE);
    L20:
        N(r5.getActionEnable(), this.a);
        this.b = r5.getStyles();
        M();
        TraceEvent.endSection("UniversalCardLynxCheckBoxUI.setContent");
        return;
    L17:
        if (Intrinsics.areEqual(r5.getMultiSelect(), r3) == false) goto L19;
        ((UniversalCardCheckBox) getView()).setType(UniversalCardCheckBox.CheckBoxType.CHECK_BOX);
        goto L20
    L19:
        ((UniversalCardCheckBox) getView()).setType(UniversalCardCheckBox.CheckBoxType.RADIO);
    L8:
        e = move-exception;
        Log.e("UniversalCardLynxCheckBoxUI", "props from lynx transform failed", e);
        r5 = null;
        goto L10
    }

    public final void N(Boolean r4, Boolean r5) {
        Boolean r0 = Boolean.TRUE;
        if (Intrinsics.areEqual(r5, r0) == false) goto L9;
        if (Intrinsics.areEqual(r4, r0) == false) goto L7;
        ((UniversalCardCheckBox) getView()).setEnabled(true);
        ((UniversalCardCheckBox) getView()).setUncheckedBackgroundColor(UDColorUtils.getColor(((UniversalCardCheckBox) getView()).getContext(), 2131109044));
        ((UniversalCardCheckBox) getView()).setUncheckedBorderColor(UDColorUtils.getColor(((UniversalCardCheckBox) getView()).getContext(), 2131108723));
        return;
    L7:
        ((UniversalCardCheckBox) getView()).setEnabled(false);
        ((UniversalCardCheckBox) getView()).setUncheckedBackgroundColor(UDColorUtils.getColor(((UniversalCardCheckBox) getView()).getContext(), 2131108939));
        ((UniversalCardCheckBox) getView()).setUncheckedBorderColor(UDColorUtils.getColor(((UniversalCardCheckBox) getView()).getContext(), 2131108941));
        return;
    L9:
        if (Intrinsics.areEqual(r4, r0) == false) goto L11;
        ((UniversalCardCheckBox) getView()).setEnabled(true);
        ((UniversalCardCheckBox) getView()).setUncheckedBackgroundColor(UDColorUtils.getColor(((UniversalCardCheckBox) getView()).getContext(), 2131106503));
        ((UniversalCardCheckBox) getView()).setUncheckedBorderColor(UDColorUtils.getColor(((UniversalCardCheckBox) getView()).getContext(), 2131106521));
        return;
    L11:
        ((UniversalCardCheckBox) getView()).setEnabled(false);
        ((UniversalCardCheckBox) getView()).setUncheckedBackgroundColor(UDColorUtils.getColor(((UniversalCardCheckBox) getView()).getContext(), 2131106498));
        ((UniversalCardCheckBox) getView()).setUncheckedBorderColor(UDColorUtils.getColor(((UniversalCardCheckBox) getView()).getContext(), 2131106499));
    }
}
