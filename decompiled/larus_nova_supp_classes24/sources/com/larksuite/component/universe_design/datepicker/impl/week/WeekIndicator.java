package com.larksuite.component.universe_design.datepicker.impl.week;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.util.CalendarDate;
import h18.b;
import h18.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"J\u0016\u0010#\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0012J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u000eR\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/week/WeekIndicator;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mWeeks", "", "", "[Ljava/lang/String;", "mShowTexts", "mBlueColor", "", "mBlackColor", "mCurrentWeekDayIndex", "mChangeTextColorBlue", "", "mWeekDateTextPaint", "Landroid/text/TextPaint;", "weekTextSizePx", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateWeekColorAndText", "currentWeekDayIndex", "changeTextColorBlue", "weekStartDay", "Lcom/larksuite/component/universe_design/util/CalendarDate$DayOfWeek;", "updateWeekColor", "setWeekTextSizePx", "textSize", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class WeekIndicator extends View {
    public final String[] a;
    public final String[] b;
    public final int c;
    public final int d;
    public int e;
    public boolean f;
    public final TextPaint g;
    public float h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CalendarDate.DayOfWeek.values().length];
            r0[CalendarDate.DayOfWeek.MONDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CalendarDate.DayOfWeek.SATURDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        float r0 = getWidth() / 7;
        int r3 = 0;
    L3:
        if (r3 >= 7) goto L21;
        String r4 = this.b[r3];
        if (r4 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L20;
        if (this.f == true) goto L16;
    L18:
        this.g.setColor(this.d);
    L19:
        int r6 = (int) r0;
        Rect r7 = new Rect(r6 * r3, 0, r6 * (r3 + 1), getHeight());
        Paint.FontMetrics r8 = this.g.getFontMetrics();
        float r9 = r7.centerY();
        float r10 = r8.bottom;
        r11.drawText(r4, r7.centerX(), (r9 + ((r10 - r8.top) / 2)) - r10, this.g);
        goto L20
    L16:
        if (r3 != this.e) goto L18;
        this.g.setColor(this.c);
    L20:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r4.length() == 0) goto L10;
        r5 = false;
        goto L11
    }

    public final void setWeekTextSizePx(int r2) {
        float r3 = d.a(getContext(), r2);
        this.h = r3;
        this.g.setTextSize(r3);
        requestLayout();
        invalidate();
    }

    public WeekIndicator(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        TextPaint r6 = new TextPaint();
        this.g = r6;
        float r1 = d.a(getContext(), 12.0f);
        this.h = r1;
        r6.setTextSize(r1);
        r6.setTextAlign(Paint.Align.CENTER);
        r6.setAntiAlias(true);
        Context r7 = getContext();
        int r2 = b.a;
        Intrinsics.checkNotNullParameter(r7, "context");
        this.a = r7.getResources().getStringArray(2130903128);
        this.b = new String[7];
        this.c = r4.getResources().getColor(2131105548);
        this.d = r4.getResources().getColor(2131106622);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), r1), (int) this.h);
    }
}
