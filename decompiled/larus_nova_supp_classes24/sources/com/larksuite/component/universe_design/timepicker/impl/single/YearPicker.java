package com.larksuite.component.universe_design.timepicker.impl.single;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import d18.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/single/YearPicker;", "", "<init>", "()V", "getPickerBuilder", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerBuilder;", "startYear", "", "endYear", "isLoop", "", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class YearPicker {
    public static final YearPicker INSTANCE = null;

    static {
        INSTANCE = new YearPicker();
    }

    private YearPicker() {
    }

    public final PickerBuilder getPickerBuilder(int r3, int r4, boolean r5) {
        if (r3 < 0) goto L8;
        if (r4 < 0) goto L10;
        if (r3 > r4) goto L11;
        PickerBuilder r0 = new PickerBuilder(new b(r3, r4));
        r0.setLoop(r5);
        return r0;
    L11:
        return null;
    L10:
        return null;
    L8:
        return null;
    }
}
