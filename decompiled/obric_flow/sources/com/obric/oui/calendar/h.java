package com.obric.oui.calendar;

import android.util.Log;
import androidx.viewpager.widget.ViewPager;
import com.obric.oui.picker.reels.views.OReelPickerMulti;
import com.obric.oui.picker.reels.views.WheelView;
import java.util.Calendar;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarView f12281a;

    public h(MaterialCalendarView r5) {
        this.f12281a = r5;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r5) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r5, float r10, int r11) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r10) {
        MaterialCalendarView r11 = this.f12281a;
        r11.f12170a.f12265i = r11.g;
        r11.g = r11.f.f12244k.getItem(r10);
        r11.e();
        CalendarDay r12 = r11.g;
        a0 r5 = r11.f12180o;
        if (r5 == null) goto L34;
        q r13 = (q) r5;
        ODatePickerView r14 = r13.f12292b;
        Intrinsics.checkNotNullParameter(r14, "this$0");
        String r15 = "setOnMonthChangedListener widget:" + r11 + ",date:" + r12;
        Intrinsics.checkNotNullParameter("DatePickerView", "tag");
        Intrinsics.checkNotNullParameter(r15, "msg");
        Log.i("DatePickerView", r15);
        int r16 = r12.f12167a.getYear();
        LocalDate r17 = r12.f12167a;
        int r18 = r17.getMonthValue() - 1;
        Calendar r19 = r13.f12291a;
        r19.set(r16, r18, 1);
        long r20 = r19.getTimeInMillis();
        r14.f12204o.setText(ODatePickerView.n(r20, r14.D));
        r14.f12198i = r17.getYear();
        r14.f12199j = r17.getMonthValue();
        if (r14.f12197h == false) goto L8;
        r14.f12203n.setSelectedDate(new CalendarDay(r17.getYear(), r17.getMonthValue(), 1));
    L8:
        if (r14.A == false) goto L10;
        r14.A = false;
    L29:
        Function1 r21 = r14.E;
        if (r21 == null) goto L35;
        r21.invoke(Long.valueOf(r20));
        return;
    L35:
        return;
    L10:
        OReelPickerMulti r22 = r14.s;
        if (r22 != null) goto L14;
        r22 = null;
    L14:
        if (r22 == null) goto L29;
        int r23 = RangesKt.coerceAtLeast(r17.getYear() - 1900, 0);
        int r24 = RangesKt.coerceIn(r17.getMonthValue() - 1, 0, 11);
        r14.f12214z = true;
        WheelView r25 = r22.a(0);
        if (r25 != null) goto L20;
    L22:
        WheelView r26 = r22.a(1);
        if (r26 != null) goto L26;
    L28:
        r14.f12214z = false;
        goto L29
    L26:
        if (r26.getCurrentIndex() == r24) goto L28;
        r26.i(r24);
        goto L28
    L20:
        if (r25.getCurrentIndex() == r23) goto L22;
        r25.i(r23);
        goto L22
    }
}
