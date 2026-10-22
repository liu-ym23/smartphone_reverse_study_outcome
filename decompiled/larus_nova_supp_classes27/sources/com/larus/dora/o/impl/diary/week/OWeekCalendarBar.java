package com.larus.dora.o.impl.diary.week;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.dora.o.impl.diary.calendar.a;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J \u0010#\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u0012\u0010&\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u0010\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010%J\u0010\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/dora/o/impl/diary/week/OWeekCalendarBar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onDayClick", "Lkotlin/Function1;", "Lcom/larus/dora/o/impl/diary/calendar/OCalendarDataBuilder$DayCell;", "", "getOnDayClick", "()Lkotlin/jvm/functions/Function1;", "setOnDayClick", "(Lkotlin/jvm/functions/Function1;)V", "onReachHistoryEdge", "Lkotlin/Function0;", "getOnReachHistoryEdge", "()Lkotlin/jvm/functions/Function0;", "setOnReachHistoryEdge", "(Lkotlin/jvm/functions/Function0;)V", "weekPagerView", "Landroidx/recyclerview/widget/RecyclerView;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "adapter", "Lcom/larus/dora/o/impl/diary/week/OWeekPagerAdapter;", "weeks", "", "Lcom/larus/dora/o/impl/diary/calendar/OCalendarDataBuilder$WeekData;", "dpF", "", "value", "", "setWeeks", "selectedDate", "", "updateSelected", "scrollToDate", "date", "dp", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OWeekCalendarBar extends LinearLayout {
    public static final /* synthetic */ int g = 0;
    public Function1<? super a.C0094a, Unit> a;
    public Function0<Unit> b;
    public final RecyclerView c;
    public final LinearLayoutManager d;
    public final OWeekPagerAdapter e;
    public List<a.c> f;

    public final Function1<a.C0094a, Unit> getOnDayClick() {
        return this.a;
    }

    public final Function0<Unit> getOnReachHistoryEdge() {
        return this.b;
    }

    public OWeekCalendarBar(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final int a(int r3) {
        Resources r0 = getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3) + 0.5f);
    }

    public final void setOnDayClick(Function1<? super a.C0094a, Unit> r1) {
        this.a = r1;
    }

    public final void setOnReachHistoryEdge(Function0<Unit> r1) {
        this.b = r1;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [w69.a] */
    public OWeekCalendarBar(Context r11, AttributeSet r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12);
        this.c = new RecyclerView(r11);
        this.d = new LinearLayoutManager(r11, 0, false);
        this.e = new OWeekPagerAdapter(new w69.a(this));
        this.f = CollectionsKt.emptyList();
        setOrientation(1);
        int r1 = a(9);
        setPadding(r1, getPaddingTop(), r1, getPaddingBottom());
        LinearLayout r2 = new LinearLayout(r11);
        r2.setOrientation(0);
        Iterator<T> r3 = a.a.iterator();
        int r4 = 0;
    L4:
        if (r3.hasNext() == false) goto L12;
        Object r5 = r3.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TextView r8 = new TextView(r11);
        r8.setText((String) r5);
        r8.setGravity(17);
        r8.setTextSize(2, 10.0f);
        r8.setTypeface(Typeface.create("sans-serif-medium", 0));
        r8.setTextColor(ContextCompat.getColor(r11, 2131101369));
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        if (r4 <= 0) goto L11;
        r6.setMarginStart(a(1));
    L11:
        Unit r9 = Unit.INSTANCE;
        r2.addView(r8, r6);
        r4 = r7;
        goto L4
    L12:
        addView(r2, new LinearLayout.LayoutParams(-1, -2));
        this.c.setLayoutManager(this.d);
        this.c.setAdapter(this.e);
        this.c.setClipChildren(false);
        this.c.setClipToPadding(false);
        setClipChildren(false);
        setClipToPadding(false);
        new PagerSnapHelper().attachToRecyclerView(this.c);
        this.c.addOnScrollListener(new AnonymousClass1(this));
        View r0 = this.c;
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-1, -2);
        r10.topMargin = a(4);
        Unit r13 = Unit.INSTANCE;
        addView(r0, r10);
        View r14 = new View(r11);
        r14.setBackgroundColor(ContextCompat.getColor(r11, 2131101357));
        Resources r15 = getResources();
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-1, RangesKt.coerceAtLeast((int) ((WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics()).density * 0.5f) + 0.5f), 1));
        r16.topMargin = a(8);
        int r17 = -r1;
        r16.leftMargin = r17;
        r16.rightMargin = r17;
        addView(r14, r16);
    }
}
