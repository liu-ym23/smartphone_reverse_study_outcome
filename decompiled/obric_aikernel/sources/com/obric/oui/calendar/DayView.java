package com.obric.oui.calendar;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class DayView extends AppCompatCheckedTextView {
    private final Rect circleDrawableRect;
    private m9.e contentDescriptionFormatter;
    private Drawable customBackground;
    private CalendarDay date;
    private final int fadeTime;
    private m9.e formatter;
    private boolean isDecoratedDisabled;
    private boolean isInMonth;
    private boolean isInRange;
    private Drawable mCircleDrawable;
    private int selectionColor;
    private Drawable selectionDrawable;
    private int showOtherDates;
    private final Rect tempRect;

    public DayView(Context r10, CalendarDay r11) {
        super(r10);
        this.selectionColor = -7829368;
        this.fadeTime = 50;
        this.customBackground = null;
        m9.e r12 = m9.e.f11059a;
        this.formatter = r12;
        this.contentDescriptionFormatter = r12;
        this.isInRange = true;
        this.isInMonth = true;
        this.isDecoratedDisabled = false;
        this.showOtherDates = 4;
        this.tempRect = new Rect();
        this.circleDrawableRect = new Rect();
        setSelectionColor(this.selectionColor);
        setGravity(17);
        setTextAlignment(4);
        setDay(r11);
    }

    private void calculateBounds(int r10, int r11) {
        int r12 = Math.min(r11, r10);
        int r13 = Math.abs(r11 - r10) / 2;
        if (r10 < r11) goto L5;
        int r14 = r12 + r13;
        this.tempRect.set(r13, 0, r14, r11);
        this.circleDrawableRect.set(r13, 0, r14, r11);
        return;
    L5:
        int r15 = r12 + r13;
        this.tempRect.set(0, r13, r10, r15);
        this.circleDrawableRect.set(0, r13, r10, r15);
    }

    private static Drawable generateBackground(int r10, int r11, Rect r12) {
        StateListDrawable r13 = new StateListDrawable();
        r13.setExitFadeDuration(r11);
        r13.addState(new int[]{R.attr.state_checked}, generateCircleDrawable(r10));
        int[] r14 = new int[1];
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r14[0] = 16842919;
        r13.addState(r14, generateRippleDrawable(r10, r12));
    L6:
        r13.addState(new int[0], generateCircleDrawable(0));
        return r13;
    L5:
        r14[0] = 16842919;
        r13.addState(r14, generateCircleDrawable(r10));
        goto L6
    }

    private static Drawable generateCircleDrawable(int r10) {
        ShapeDrawable r11 = new ShapeDrawable(new OvalShape());
        r11.getPaint().setColor(r10);
        return r11;
    }

    private static Drawable generateRippleDrawable(int r10, Rect r11) {
        return new RippleDrawable(ColorStateList.valueOf(r10), null, generateCircleDrawable(-1));
    }

    private void regenerateBackground() {
        Drawable r10 = this.selectionDrawable;
        if (r10 != null) goto L6;
        r10 = generateBackground(this.selectionColor, 50, this.circleDrawableRect);
        this.mCircleDrawable = r10;
    L6:
        setBackgroundDrawable(r10);
    }

    private void setEnabled() {
        int r10 = 0;
        if (this.isInMonth == true) goto L5;
    L9:
        boolean r11 = false;
    L11:
        if (this.isInRange == true) goto L13;
    L15:
        boolean r12 = false;
    L16:
        super.setEnabled(r12);
        boolean r13 = MaterialCalendarView.K(this.showOtherDates);
        if (MaterialCalendarView.L(this.showOtherDates) == true) goto L21;
        if (r13 == true) goto L21;
        boolean r14 = false;
    L22:
        boolean r15 = MaterialCalendarView.J(this.showOtherDates);
        boolean r16 = this.isInMonth;
        if (r16 == true) goto L26;
        if (r13 == false) goto L26;
        r11 = true;
    L26:
        boolean r17 = this.isInRange;
        if (r17 == true) goto L31;
        if (r14 == false) goto L31;
        r11 = r11 | r16;
    L31:
        if (this.isDecoratedDisabled == false) goto L38;
        if (r15 == false) goto L38;
        if (r16 == false) goto L36;
        if (r17 == false) goto L36;
        boolean r18 = true;
    L37:
        r11 = r11 | r18;
    L36:
        r18 = false;
    L38:
        if (r16 == true) goto L41;
        if (r11 == false) goto L41;
        setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
    L41:
        if (r11 == true) goto L44;
        r10 = 4;
    L44:
        setVisibility(r10);
        return;
    L21:
        r14 = true;
        goto L22
    L13:
        if (this.isDecoratedDisabled == true) goto L15;
        r12 = true;
        goto L16
    L5:
        if (this.isInRange == false) goto L9;
        if (this.isDecoratedDisabled == true) goto L9;
        r11 = true;
        goto L11
    }

    void applyFacade(e r10) {
        this.isDecoratedDisabled = r10.b();
        setEnabled();
        setCustomBackground(r10.c());
        setSelectionDrawable(r10.d());
        List<e.a> r11 = r10.e();
        if (r11.isEmpty() == true) goto L9;
        String r12 = getLabel();
        SpannableString r13 = new SpannableString(getLabel());
        Iterator<e.a> r14 = r11.iterator();
    L6:
        if (r14.hasNext() == false) goto L8;
        r13.setSpan(r14.next().f6351a, 0, r12.length(), 33);
        goto L6
    L8:
        setText(r13);
        return;
    L9:
        setText(getLabel());
    }

    @NonNull
    public String getContentDescriptionLabel() {
        m9.e r10 = this.contentDescriptionFormatter;
        if (r10 != null) goto L6;
        r10 = this.formatter;
    L6:
        return r10.a(this.date);
    }

    public CalendarDay getDate() {
        return this.date;
    }

    @NonNull
    public String getLabel() {
        return this.formatter.a(this.date);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void onDraw(@NonNull Canvas r10) {
        Drawable r11 = this.customBackground;
        if (r11 == null) goto L5;
        r11.setBounds(this.tempRect);
        this.customBackground.setState(getDrawableState());
        this.customBackground.draw(r10);
    L5:
        this.mCircleDrawable.setBounds(this.circleDrawableRect);
        super.onDraw(r10);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        calculateBounds(r13 - r11, r14 - r12);
        regenerateBackground();
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean r10 = super.performClick();
        q9.a.b(getContext(), 1);
        return r10;
    }

    public void setCustomBackground(Drawable r10) {
        if (r10 != null) goto L4;
        Drawable r11 = null;
    L5:
        this.customBackground = r11;
        invalidate();
        return;
    L4:
        r11 = r10.getConstantState().newDrawable(getResources());
        goto L5
    }

    public void setDay(CalendarDay r10) {
        this.date = r10;
        setText(getLabel());
    }

    public void setDayFormatter(m9.e r10) {
        m9.e r11 = this.contentDescriptionFormatter;
        if (r11 != this.formatter) goto L5;
        r11 = r10;
    L5:
        this.contentDescriptionFormatter = r11;
        if (r10 != null) goto L8;
        r10 = m9.e.f11059a;
    L8:
        this.formatter = r10;
        CharSequence r12 = getText();
        Object[] r13 = null;
        if ((r12 instanceof Spanned) == false) goto L11;
        r13 = ((Spanned) r12).getSpans(0, r12.length(), Object.class);
    L11:
        SpannableString r14 = new SpannableString(getLabel());
        if (r13 == null) goto L16;
        int r15 = r13.length;
        int r16 = 0;
    L14:
        if (r16 >= r15) goto L16;
        r14.setSpan(r13[r16], 0, r14.length(), 33);
        r16 = r16 + 1;
    L16:
        setText(r14);
    }

    public void setDayFormatterContentDescription(m9.e r10) {
        if (r10 != null) goto L4;
        r10 = this.formatter;
    L4:
        this.contentDescriptionFormatter = r10;
        setContentDescription(getContentDescriptionLabel());
    }

    public void setSelectionColor(int r10) {
        this.selectionColor = r10;
        regenerateBackground();
    }

    public void setSelectionDrawable(Drawable r10) {
        if (r10 != null) goto L4;
        Drawable r11 = null;
    L5:
        this.selectionDrawable = r11;
        regenerateBackground();
        return;
    L4:
        r11 = r10.getConstantState().newDrawable(getResources());
        goto L5
    }

    protected void setupSelection(int r10, boolean r11, boolean r12) {
        this.showOtherDates = r10;
        this.isInMonth = r12;
        this.isInRange = r11;
        setEnabled();
    }
}
