package com.larksuite.component.universe_design.timepicker.impl.action;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larksuite.component.universe_design.util.CalendarDate;
import java.util.Calendar;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDTimePickerBuilder extends UDBaseDialogBuilder<UDTimePickerBuilder> {
    public PickerModel a;
    public String b;
    public Integer c;
    public a d;
    public String e;
    public a f;
    public String g;
    public final int h;
    public Calendar i;
    public CalendarDate j;
    public CalendarDate k;

    @Deprecated(message = "please use TimePickerActionListener instead.", replaceWith = @ReplaceWith(expression = "TimePickerActionListener", imports = {}))
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/action/UDTimePickerBuilder$TimePickerActonListener;", "", "onClickRightAction", "", "dialog", "Lcom/larksuite/component/universe_design/dialog/UDDialog;", "year", "", "monthOfYear", "dayOfMonth", "hourOfDay", "minute", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public interface TimePickerActonListener {
        void onClickRightAction(UDDialog r1, int r2, int r3, int r4, int r5, int r6);
    }

    public interface a {
        void a(UDDialog r1, int r2, int r3, int r4);
    }

    public UDTimePickerBuilder(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8);
        this.a = PickerModel.MONTHDAY_HOUR_MINUTE_24H;
        this.h = 1;
        rootLayout(new UDTimePickerActionView(r8, null, 0, 6, null));
        controller(new com.larksuite.component.universe_design.timepicker.impl.action.a(r8));
        width(1.0f);
        gravity(80);
        marginInDp(0);
    }
}
