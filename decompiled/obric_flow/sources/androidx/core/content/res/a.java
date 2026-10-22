package androidx.core.content.res;

import android.view.View;
import com.bytedance.ai.ex.widget.WidgetSDK;
import com.bytedance.ai.ex.widget.WidgetView;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;
import com.obric.oui.calendar.CalendarDay;
import com.obric.oui.calendar.MaterialCalendarView;
import com.obric.oui.calendar.ODatePickerView;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.picker.reels.views.WheelView;
import com.obric.oui.slider.TickMarkSeekBar;
import com.obric.oui.slider.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f456c;

    public /* synthetic */ a(int r5, int r10, Object r11) {
        this.f454a = r10;
        this.f456c = r11;
        this.f455b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f455b;
        Object r10 = this.f456c;
        switch(this.f454a) {
            case 0: goto L32;
            case 1: goto L30;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L17;
            case 5: goto L10;
            default: goto L4;
        };
    L4:
        int r11 = TickMarkSeekBar.W;
        TickMarkSeekBar r12 = (TickMarkSeekBar) r10;
        Intrinsics.checkNotNullParameter(r12, "this$0");
        r12.getClass();
        b r13 = r12.V;
        if (r13 == null) goto L8;
        ((we.a) r13).i(r5);
    L8:
        r12.invalidate();
        return;
    L10:
        int r14 = WheelView.C;
        WheelView r15 = (WheelView) r10;
        Intrinsics.checkNotNullParameter(r15, "this$0");
        View r16 = r15.f14044c.o(r5);
        if (r16 == null) goto L15;
        int r17 = r16.getTop();
        int r18 = (r16.getBottom() + r17) / 2;
        RecyclerView r19 = r15.f14042a;
        int r20 = r19.getPaddingTop();
        int r21 = r18 - (((r19.getHeight() + r20) - r19.getPaddingBottom()) / 2);
        if (r21 == 0) goto L34;
        r19.scrollBy(0, r21);
        r15.s = true;
        return;
    L34:
        return;
    L15:
        r15.f14054q = r5;
        return;
    L17:
        int r22 = ODatePickerView.I;
        ODatePickerView r23 = (ODatePickerView) r10;
        Intrinsics.checkNotNullParameter(r23, "this$0");
        if (r23.f12214z == true) goto L37;
        int r24 = r23.f12199j + 1;
        MaterialCalendarView r25 = r23.f12203n;
        CalendarDay r26 = r25.getCurrentDate();
        if (r26.f12167a.getYear() == r5) goto L23;
    L24:
        r23.A = true;
        r25.setCurrentDate(new CalendarDay(r5, r24, 1));
        return;
    L23:
        if (r26.f12167a.getMonthValue() != r24) goto L24;
        return;
    L37:
        return;
    L26:
        SideSheetBehavior.b((SideSheetBehavior) r10, r5);
        return;
    L28:
        AndroidScrollView r27 = (AndroidScrollView) r10;
        Intrinsics.checkNotNullParameter(r27, "$scrollView");
        int r28 = r27.getScrollY();
        r27.d(0, r28 + (-r5), true);
        return;
    L30:
        WidgetSDK.a((WidgetView) r10, r5);
        return;
    L32:
        ResourcesCompat.FontCallback.b((ResourcesCompat.FontCallback) r10, r5);
    }
}
