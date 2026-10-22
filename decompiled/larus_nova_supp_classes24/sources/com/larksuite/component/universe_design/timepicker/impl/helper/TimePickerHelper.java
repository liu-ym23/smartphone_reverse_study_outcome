package com.larksuite.component.universe_design.timepicker.impl.helper;

import android.content.Context;
import android.widget.LinearLayout;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PanelStyleData;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController;
import com.larksuite.component.universe_design.timepicker.impl.panel.c;
import com.larksuite.component.universe_design.timepicker.impl.panel.d;
import com.larksuite.component.universe_design.timepicker.impl.panel.f;
import com.larksuite.component.universe_design.util.CalendarDate;
import h18.b;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a¨\u0006\u001c"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/helper/TimePickerHelper;", "", "<init>", "()V", "getPanelController", "Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController;", "context", "Landroid/content/Context;", "pickerModel", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerModel;", "pickerPanelDependency", "Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController$PickerPanelDependency;", "panelStyleData", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PanelStyleData;", "createWheelView", "Lcom/larksuite/component/universe_design/timepicker/impl/base/WheelView;", "builder", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerBuilder;", "generalDefaultLayoutParam", "Landroid/widget/LinearLayout$LayoutParams;", "createWheelViewLayoutParam", "builderLayoutParams", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerBuilder$LayoutParams;", "isLanguageAMPMAtFront", "", "getValidWheelItemNum", "", "itemNum", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TimePickerHelper {
    public static final TimePickerHelper INSTANCE = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PickerModel.values().length];
            r0[PickerModel.HOUR_MINUTE_24H.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[PickerModel.HOUR_MINUTE_12H.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[PickerModel.YEAR_MONTH_DAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[PickerModel.MONTH_DAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[PickerModel.MONTHDAY_HOUR_MINUTE_24H.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[PickerModel.MONTHDAY_HOUR_MINUTE_12H.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
        INSTANCE = new TimePickerHelper();
    }

    private TimePickerHelper() {
    }

    public final LinearLayout.LayoutParams generalDefaultLayoutParam() {
        return new LinearLayout.LayoutParams(0, -2, 1.0f);
    }

    public final boolean isLanguageAMPMAtFront() {
        Locale r0 = Locale.getDefault();
        Intrinsics.checkNotNull(r0);
        int r1 = b.a;
        Intrinsics.checkNotNullParameter(r0, "locale");
        String r2 = r0.getLanguage();
        Locale r3 = Locale.ROOT;
        if (Intrinsics.areEqual("zh", r2.toLowerCase(r3)) == true) goto L10;
        Intrinsics.checkNotNullParameter(r0, "locale");
        if (Intrinsics.areEqual("ja", r0.getLanguage().toLowerCase(r3)) == true) goto L10;
        Intrinsics.checkNotNullParameter(r0, "locale");
        if (Intrinsics.areEqual("ko", r0.getLanguage().toLowerCase(r3)) == true) goto L10;
        return false;
    L10:
        return true;
    }

    private final LinearLayout.LayoutParams createWheelViewLayoutParam(PickerBuilder.a r4) {
        r4.getClass();
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(0, -2);
        r0.weight = r4.a;
        r0.rightMargin = 0;
        r0.leftMargin = 0;
        return r0;
    }

    public final int getValidWheelItemNum(int r2) {
        return RangesKt.coerceAtLeast(1, r2 - ((r2 + 1) % 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WheelView createWheelView(Context r4, PickerBuilder r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "builder");
        WheelView r0 = new WheelView(r4, null, 2, null);
        r0.setTextColorCenter(r5.getTextColorCenter());
        r0.setTextSize(r5.getTextSize());
        r0.setTextSizeOuter(r5.getOuterTextSize());
        r0.setShowTwoFigure(r5.getShowTwoFigure());
        r0.setItemVisible(r5.getVisibleItemNum() + 2);
        r0.setCyclic(r5.isLoop());
        r0.setAdapter(r5.getAdapter());
        r0.setLayoutParams(INSTANCE.createWheelViewLayoutParam(r5.getLayoutParams()));
        return r0;
    }

    public final BaseTimePickerController getPanelController(Context r19, PickerModel r110, BaseTimePickerController.PickerPanelDependency r20, PanelStyleData r21) {
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r110, "pickerModel");
        Intrinsics.checkNotNullParameter(r20, "pickerPanelDependency");
        Intrinsics.checkNotNullParameter(r21, "panelStyleData");
        switch(a.a[r110.ordinal()]) {
            case 1: goto L12;
            case 2: goto L17;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L5;
        };
    L8:
        int r2 = d.e;
        return d.a.a(r19, r20);
    L9:
        int r3 = f.j;
        return f.a.a(r19, r20, new CalendarDate(1900, 1, 1, 0, 0, 0), new CalendarDate(2100, 12, 31, 0, 0, 0));
    L5:
        throw new NoWhenBranchMatchedException();
    L13:
        return new c(r19, r20, false);
    L14:
        return new c(r19, r20, true);
    L17:
        return new com.larksuite.component.universe_design.timepicker.impl.panel.a(r19, r20, false, r21.getMinuteInterval());
    L12:
        return new com.larksuite.component.universe_design.timepicker.impl.panel.a(r19, r20, true, r21.getMinuteInterval());
    }
}
