package com.obric.clockwidgets.ui;

import android.view.View;
import com.obric.clockwidgets.data.WidgetClockCity;
import com.obric.oui.calendar.OWeekPickerView;
import com.obric.oui.calendar.PickerSelectionMode;
import com.obric.oui.calendar.w;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11299c;
    public final /* synthetic */ Object d;

    public /* synthetic */ b(Object r5, int r10, Object r11, int r12) {
        this.f11297a = r12;
        this.f11299c = r5;
        this.f11298b = r10;
        this.d = r11;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        int r10 = this.f11298b;
        Object r11 = this.d;
        Object r12 = this.f11299c;
        switch(this.f11297a) {
            case 0: goto L16;
            default: goto L4;
        };
    L4:
        int r13 = OWeekPickerView.f12228m;
        OWeekPickerView r14 = (OWeekPickerView) r12;
        Intrinsics.checkNotNullParameter(r14, "this$0");
        w r15 = (w) r11;
        Intrinsics.checkNotNullParameter(r15, "$this_apply");
        if (((Boolean) r14.f12236l.get(r10)).booleanValue() == true) goto L8;
        return;
    L8:
        if (r14.f12229a != PickerSelectionMode.SINGLE) goto L13;
        Iterator r16 = r14.f12235k.iterator();
    L11:
        if (r16.hasNext() == false) goto L14;
        w r17 = (w) r16.next();
        r17.setChecked(Intrinsics.areEqual(r17, r15));
    L14:
        r14.b();
        return;
    L13:
        r15.toggle();
        goto L14
    L16:
        WidgetClockCityAdapter r18 = (WidgetClockCityAdapter) r12;
        Intrinsics.checkNotNullParameter(r18, "this$0");
        WidgetClockCity r19 = (WidgetClockCity) r11;
        Intrinsics.checkNotNullParameter(r19, "$item");
        r18.f11292c.mo2invoke(Integer.valueOf(r10), r19);
    }
}
