package com.larus.chat.job.impl.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.chat.job.impl.page.edit.h;
import fz8.b;
import fz8.c;
import fz8.d;
import fz8.e;
import gz8.g;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0000\u0018\u0000 >2\u00020\u0001:\u0001>B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0017J\u0010\u0010\u001d\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0007H\u0002J4\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110$H\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u001e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110$H\u0002J\b\u0010,\u001a\u00020\"H\u0002J,\u0010-\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110.H\u0002JK\u0010/\u001a\u00020\"2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020*2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110.H\u0002¢\u0006\u0002\u00104J \u00105\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0018\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=H\u0002Ra\u0010\n\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/chat/job/impl/ui/ChatJobDatePickerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDateSelected", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "year", "month", "dayOfMonth", "", "getOnDateSelected", "()Lkotlin/jvm/functions/Function3;", "setOnDateSelected", "(Lkotlin/jvm/functions/Function3;)V", "selectedDate", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditDate;", "minDate", "visibleYear", "visibleMonth", "bindDate", "date", "bindMinDate", "renderCalendar", "updateVisibleMonth", "offset", "createCalendarHeader", "Landroid/view/View;", "onPreviousMonth", "Lkotlin/Function0;", "onNextMonth", "formatCalendarTitle", "", "createCalendarArrow", "isPrevious", "", "onClick", "createCalendarWeekHeader", "createCalendarMonthGrid", "Lkotlin/Function1;", "createCalendarDayCell", "isSelected", "isEnabled", "isLastColumn", "isLastRow", "(Ljava/lang/Integer;ZZZZLkotlin/jvm/functions/Function1;)Landroid/view/View;", "isBeforeMinDate", "createFontWeight", "Landroid/graphics/Typeface;", "weight", "createRoundedDrawable", "Landroid/graphics/drawable/GradientDrawable;", "color", "radius", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobDatePickerView extends LinearLayout {
    public static final int f = 0;
    public Function3<? super Integer, ? super Integer, ? super Integer, Unit> a;
    public h b;
    public h c;
    public int d;
    public int e;

    public static final class a {
        public a() {
        }
    }

    public ChatJobDatePickerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChatJobDatePickerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        new a();
        f = ((Number) i5.F1.getValue()).intValue();
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [fz8.c] */
    public final void c() {
        removeAllViews();
        int r1 = this.d;
        int r2 = this.e;
        Function0 r3 = new fz8.a(this);
        Function0 r4 = new b(this);
        LinearLayout r5 = new LinearLayout(getContext());
        int r6 = 0;
        r5.setOrientation(0);
        r5.setGravity(16);
        int r9 = -1;
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, i5.Q()));
        TextView r7 = new TextView(r5.getContext());
        Locale r8 = Locale.getDefault();
        Calendar r10 = Calendar.getInstance(r8);
        r10.clear();
        r10.set(r1, r2 - 1, 1);
        r7.setText(new SimpleDateFormat(DateFormat.getBestDateTimePattern(r8, "yMMMM"), r8).format(r10.getTime()));
        r7.setIncludeFontPadding(false);
        r7.setTypeface(b(590));
        int r11 = g.a;
        r7.setTextColor(g.b(r7.getContext()));
        r7.setTextSize(0, i5.t());
        int r12 = -2;
        r7.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        r5.addView(r7);
        r5.addView(a(true, r3));
        r5.addView(a(false, r4));
        addView(r5);
        LinearLayout r13 = new LinearLayout(getContext());
        r13.setOrientation(0);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-1, -2);
        r14.topMargin = i5.v0();
        r14.bottomMargin = i5.N();
        r13.setLayoutParams(r14);
        int r15 = 7;
        Iterator r16 = CollectionsKt.take(ArraysKt.drop(DateFormatSymbols.getInstance(Locale.getDefault()).getShortWeekdays(), 1), 7).iterator();
        int r17 = 0;
    L4:
        if (r16.hasNext() == false) goto L12;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TextView r110 = new TextView(r13.getContext());
        r110.setText((String) r18);
        r110.setGravity(17);
        r110.setIncludeFontPadding(false);
        r110.setTypeface(b(500));
        int r20 = g.a;
        r110.setTextColor(g.c(r110.getContext()));
        r110.setTextSize(0, i5.k());
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(i5.X(), -2);
        if (r17 == CollectionsKt.getLastIndex(CollectionsKt.take(ArraysKt.drop(DateFormatSymbols.getInstance(Locale.getDefault()).getShortWeekdays(), 1), 7))) goto L11;
        r21.setMarginEnd(i5.e0());
    L11:
        r110.setLayoutParams(r21);
        r13.addView(r110);
        r17 = r19;
        goto L4
    L12:
        addView(r13);
        int r22 = this.d;
        int r23 = this.e;
        final ?? r24 = new c(this);
        Calendar r25 = Calendar.getInstance(Locale.getDefault());
        r25.set(r22, r23 - 1, 1);
        int r111 = r25.get(7) - 1;
        int r26 = r25.getActualMaximum(5);
        int r112 = (((r111 + r26) + 7) - 1) / 7;
        h r113 = this.b;
        LinearLayout r114 = new LinearLayout(getContext());
        r114.setOrientation(1);
        r114.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int r115 = 0;
    L13:
        if (r115 >= r112) goto L87;
        LinearLayout r27 = new LinearLayout(r114.getContext());
        r27.setOrientation(r6);
        r27.setLayoutParams(new LinearLayout.LayoutParams(r9, r12));
        int r116 = 0;
    L15:
        if (r116 >= r15) goto L86;
        int r28 = (((r115 * 7) + r116) - r111) + 1;
        Integer r117 = Integer.valueOf(r28);
        int r29 = r117.intValue();
        if (1 > r29) goto L20;
        if (r29 > r26) goto L20;
        boolean r30 = true;
    L21:
        if (r30 == true) goto L24;
        r117 = null;
    L24:
        final Integer r31 = r117;
        if (r113 != null) goto L27;
    L33:
        boolean r32 = false;
    L34:
        if (r31 == null) goto L53;
        int r33 = r31.intValue();
        h r34 = this.c;
        if (r34 != null) goto L38;
        int r118 = r26;
    L49:
        boolean r35 = false;
    L50:
        if (r35 == false) goto L54;
        boolean r36 = false;
    L56:
        if (r116 != 6) goto L58;
        boolean r37 = true;
    L59:
        int r119 = r22;
        if (r115 != (r112 - 1)) goto L62;
        boolean r38 = true;
    L63:
        int r120 = r23;
        FrameLayout r39 = new FrameLayout(getContext());
        int r210 = r111;
        int r211 = r112;
        LinearLayout.LayoutParams r40 = new LinearLayout.LayoutParams(i5.X(), i5.X());
        if (r37 == true) goto L66;
        r40.setMarginEnd(i5.e0());
    L66:
        if (r38 == true) goto L68;
        r40.bottomMargin = i5.n0();
    L68:
        r39.setLayoutParams(r40);
        if (r31 == null) goto L85;
        r39.setClickable(r36);
        r39.setFocusable(r36);
        if (r36 == false) goto L74;
        r39.setOnClickListener(new e(r24, r31));
    L74:
        TextView r41 = new TextView(r39.getContext());
        r41.setText(r31.toString());
        r41.setGravity(17);
        r41.setIncludeFontPadding(false);
        if (r32 == false) goto L77;
        int r42 = g.a;
        Context r43 = r41.getContext();
        Intrinsics.checkNotNullParameter(r43, "context");
        int r44 = v19.c.a(2130972312, r43, 2131103298);
    L80:
        r41.setTextColor(r44);
        r41.setTextSize(0, i5.A());
        if (r32 == false) goto L84;
        Context r45 = r41.getContext();
        Intrinsics.checkNotNullParameter(r45, "context");
        int r46 = v19.c.a(2130972123, r45, 2131103203);
        float r47 = i5.X() / 2.0f;
        GradientDrawable r48 = new GradientDrawable();
        r48.setShape(0);
        r48.setColor(r46);
        r48.setCornerRadius(r47);
        r41.setBackground(r48);
    L84:
        r41.setLayoutParams(new FrameLayout.LayoutParams(i5.X(), i5.X(), 17));
        r39.addView(r41);
        goto L85
    L77:
        if (r36 == false) goto L79;
        int r49 = g.a;
        r44 = g.b(r41.getContext());
        goto L80
    L79:
        int r50 = g.a;
        Context r51 = r41.getContext();
        Intrinsics.checkNotNullParameter(r51, "context");
        r44 = v19.c.a(2130972080, r51, 2131103140);
    L85:
        r27.addView(r39);
        r116 = r116 + 1;
        r26 = r118;
        r22 = r119;
        r23 = r120;
        r111 = r210;
        r112 = r211;
        r15 = 7;
        goto L15
    L62:
        r38 = false;
        goto L63
    L58:
        r37 = false;
    L54:
        r36 = true;
        goto L56
    L38:
        r118 = r26;
        int r52 = r34.a;
        if (r22 == r52) goto L42;
        if (r22 >= r52) goto L49;
    L48:
        r35 = true;
        goto L50
    L42:
        int r53 = r34.b;
        if (r23 == r53) goto L47;
        if (r23 >= r53) goto L49;
    L47:
        if (r33 >= r34.c) goto L49;
    L53:
        r118 = r26;
        goto L54
    L27:
        if (r113.a != r22) goto L33;
        if (r113.b != r23) goto L33;
        if (r113.c != r28) goto L33;
        r32 = true;
    L20:
        r30 = false;
        goto L21
    L86:
        r114.addView(r27);
        r115 = r115 + 1;
        r26 = r26;
        r12 = -2;
        r15 = 7;
        r6 = 0;
        r9 = -1;
        goto L13
    L87:
        addView(r114);
    }

    public final Function3<Integer, Integer, Integer, Unit> getOnDateSelected() {
        return this.a;
    }

    public static Typeface b(int r2) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Typeface r3 = Typeface.create(Typeface.DEFAULT, r2, false);
        Intrinsics.checkNotNull(r3);
        return r3;
    L6:
        if (r2 < 500) goto L8;
        Typeface r4 = Typeface.create(Typeface.DEFAULT, 1);
        Intrinsics.checkNotNull(r4);
        return r4;
    L8:
        Typeface r5 = Typeface.DEFAULT;
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public final void d(int r5) {
        Calendar r0 = Calendar.getInstance(Locale.getDefault());
        r0.set(this.d, this.e - 1, 1);
        r0.add(2, r5);
        this.d = r0.get(1);
        this.e = r0.get(2) + 1;
    }

    public final void setOnDateSelected(Function3<? super Integer, ? super Integer, ? super Integer, Unit> r1) {
        this.a = r1;
    }

    public final AppCompatImageView a(boolean r3, final Function0 r4) {
        AppCompatImageView r0 = new AppCompatImageView(getContext());
        r0.setImageResource(2131240023);
        int r1 = g.a;
        r0.setColorFilter(g.b(r0.getContext()));
        r0.setScaleType(ImageView.ScaleType.CENTER);
        if (r3 == false) goto L5;
        float r5 = 180.0f;
    L6:
        r0.setRotation(r5);
        r0.setClickable(true);
        r0.setFocusable(true);
        r0.setOnClickListener(new d(r4));
        r0.setLayoutParams(new LinearLayout.LayoutParams(i5.Q(), i5.Q()));
        return r0;
    L5:
        r5 = 0.0f;
        goto L6
    }

    public ChatJobDatePickerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setOrientation(1);
        setBackground(g.a(r2));
        setPadding(i5.q(), i5.h(), i5.q(), i5.q());
    }

    public /* synthetic */ ChatJobDatePickerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
