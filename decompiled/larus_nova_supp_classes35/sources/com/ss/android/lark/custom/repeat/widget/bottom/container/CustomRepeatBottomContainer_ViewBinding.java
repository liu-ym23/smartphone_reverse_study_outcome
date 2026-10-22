package com.ss.android.lark.custom.repeat.widget.bottom.container;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.custom.repeat.widget.childview.ControlChildViewClickableLayout;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CustomRepeatBottomContainer_ViewBinding implements Unbinder {
    public CustomRepeatBottomContainer a;

    public final void unbind() {
        CustomRepeatBottomContainer r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mCustomRepeatWeekly = null;
        r0.mCustomRepeatMonthly = null;
        r0.mSwitchDate = null;
        r0.mSwitchWeek = null;
        r0.mMonthlyTabContainer = null;
        r0.mRepeatWeekNoWheelView = null;
        r0.mRepeatWeeksWheelView = null;
        r0.mChooseRepeatWeeksViewGroup = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public CustomRepeatBottomContainer_ViewBinding(CustomRepeatBottomContainer r4, View r5) {
        this.a = r4;
        r4.mCustomRepeatWeekly = (GridView) Utils.findRequiredViewAsType(r5, 2131368429, "field 'mCustomRepeatWeekly'", GridView.class);
        r4.mCustomRepeatMonthly = (GridView) Utils.findRequiredViewAsType(r5, 2131368427, "field 'mCustomRepeatMonthly'", GridView.class);
        r4.mSwitchDate = (TextView) Utils.findRequiredViewAsType(r5, 2131387896, "field 'mSwitchDate'", TextView.class);
        r4.mSwitchWeek = (TextView) Utils.findRequiredViewAsType(r5, 2131387949, "field 'mSwitchWeek'", TextView.class);
        r4.mMonthlyTabContainer = Utils.findRequiredView(r5, 2131380285, "field 'mMonthlyTabContainer'");
        r4.mRepeatWeekNoWheelView = (WheelView) Utils.findRequiredViewAsType(r5, 2131393170, "field 'mRepeatWeekNoWheelView'", WheelView.class);
        r4.mRepeatWeeksWheelView = (WheelView) Utils.findRequiredViewAsType(r5, 2131393171, "field 'mRepeatWeeksWheelView'", WheelView.class);
        r4.mChooseRepeatWeeksViewGroup = (ControlChildViewClickableLayout) Utils.findRequiredViewAsType(r5, 2131365678, "field 'mChooseRepeatWeeksViewGroup'", ControlChildViewClickableLayout.class);
    }
}
