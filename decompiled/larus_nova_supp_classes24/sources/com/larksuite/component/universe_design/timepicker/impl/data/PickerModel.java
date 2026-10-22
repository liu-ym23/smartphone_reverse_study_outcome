package com.larksuite.component.universe_design.timepicker.impl.data;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerModel;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MONTHDAY_HOUR_MINUTE_12H", "MONTHDAY_HOUR_MINUTE_24H", "HOUR_MINUTE_12H", "HOUR_MINUTE_24H", "YEAR_MONTH_DAY", "MONTH_DAY", "Companion", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum PickerModel extends Enum<PickerModel> {
    public static final a Companion = null;
    public static final PickerModel HOUR_MINUTE_12H = null;
    public static final PickerModel HOUR_MINUTE_24H = null;
    public static final PickerModel MONTHDAY_HOUR_MINUTE_12H = null;
    public static final PickerModel MONTHDAY_HOUR_MINUTE_24H = null;
    public static final PickerModel MONTH_DAY = null;
    public static final PickerModel YEAR_MONTH_DAY = null;
    public static final /* synthetic */ PickerModel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<PickerModel> getEntries() {
        return b;
    }

    static {
        PickerModel r0 = new PickerModel("MONTHDAY_HOUR_MINUTE_12H", 0, 0);
        MONTHDAY_HOUR_MINUTE_12H = r0;
        PickerModel r1 = new PickerModel("MONTHDAY_HOUR_MINUTE_24H", 1, 1);
        MONTHDAY_HOUR_MINUTE_24H = r1;
        PickerModel r3 = new PickerModel("HOUR_MINUTE_12H", 2, 2);
        HOUR_MINUTE_12H = r3;
        PickerModel r5 = new PickerModel("HOUR_MINUTE_24H", 3, 3);
        HOUR_MINUTE_24H = r5;
        PickerModel r7 = new PickerModel("YEAR_MONTH_DAY", 4, 4);
        YEAR_MONTH_DAY = r7;
        PickerModel r9 = new PickerModel("MONTH_DAY", 5, 5);
        MONTH_DAY = r9;
        PickerModel[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static PickerModel[] values() {
        return (PickerModel[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PickerModel valueOf(String r1) {
        return (PickerModel) r27.a.a(PickerModel.class, r1);
    }

    public PickerModel(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
