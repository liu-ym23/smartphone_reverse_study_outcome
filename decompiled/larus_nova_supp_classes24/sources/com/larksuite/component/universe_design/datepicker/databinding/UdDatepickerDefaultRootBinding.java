package com.larksuite.component.universe_design.datepicker.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.larksuite.component.universe_design.datepicker.impl.MonthViewPager;
import com.larksuite.component.universe_design.datepicker.impl.header.MonthPickerDefaultHead;
import com.larksuite.component.universe_design.datepicker.impl.week.WeekIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UdDatepickerDefaultRootBinding implements ViewBinding {
    public final View a;
    public final MonthPickerDefaultHead b;
    public final WeekIndicator c;
    public final MonthViewPager d;

    public final View getRoot() {
        return this.a;
    }

    public UdDatepickerDefaultRootBinding(View r1, MonthPickerDefaultHead r2, WeekIndicator r3, MonthViewPager r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
