package com.larksuite.component.universe_design.timepicker.impl.panel;

import android.content.Context;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PanelStyleData;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013H&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001dH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController;", "", "context", "Landroid/content/Context;", "pickerPanelDependency", "Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController$PickerPanelDependency;", "<init>", "(Landroid/content/Context;Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController$PickerPanelDependency;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getPickerPanelDependency", "()Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController$PickerPanelDependency;", "setPickerPanelDependency", "(Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController$PickerPanelDependency;)V", "create", "", "builderList", "", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerBuilder;", "getPickerViewList", "Lcom/larksuite/component/universe_design/timepicker/impl/base/WheelView;", "getPickerBuilderList", "setCurrentDate", "selectedDate", "Ljava/util/Calendar;", "setItemVisibleNum", "visibleItemNum", "", "setItemDividerVisibility", "isShow", "", "setMinuteWheelInterval", "minuteInterval", "PickerPanelDependency", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public abstract class BaseTimePickerController {
    private Context context;
    private PickerPanelDependency pickerPanelDependency;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController$PickerPanelDependency;", "", "onSelected", "", "selectedDate", "Ljava/util/Calendar;", "getSelectedDate", "getPanelStyleData", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PanelStyleData;", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public interface PickerPanelDependency {
        PanelStyleData getPanelStyleData();

        Calendar getSelectedDate();

        void onSelected(Calendar r1);
    }

    public abstract void create(Context r1, List<PickerBuilder> r2);

    public abstract List<PickerBuilder> getPickerBuilderList();

    public abstract List<WheelView> getPickerViewList();

    public abstract void setCurrentDate(Calendar r1);

    public abstract void setItemDividerVisibility(boolean r1);

    public abstract void setItemVisibleNum(int r1);

    public void setMinuteWheelInterval(int r1) {
    }

    public final Context getContext() {
        return this.context;
    }

    public final PickerPanelDependency getPickerPanelDependency() {
        return this.pickerPanelDependency;
    }

    public final void setContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.context = r2;
    }

    public final void setPickerPanelDependency(PickerPanelDependency r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pickerPanelDependency = r2;
    }

    public BaseTimePickerController(Context r2, PickerPanelDependency r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pickerPanelDependency");
        this.context = r2;
        this.pickerPanelDependency = r3;
    }
}
