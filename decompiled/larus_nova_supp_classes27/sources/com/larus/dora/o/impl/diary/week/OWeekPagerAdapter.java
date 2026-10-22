package com.larus.dora.o.impl.diary.week;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.o.impl.diary.c0;
import com.larus.dora.o.impl.diary.calendar.a;
import com.larus.dora.o.impl.diary.i;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w69.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000e\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/o/impl/diary/week/OWeekPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/o/impl/diary/week/OWeekPagerAdapter$WeekViewHolder;", "onDayClick", "Lkotlin/Function1;", "Lcom/larus/dora/o/impl/diary/calendar/OCalendarDataBuilder$DayCell;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "weeks", "", "Lcom/larus/dora/o/impl/diary/calendar/OCalendarDataBuilder$WeekData;", "selectedDate", "", "submit", "updateSelected", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "WeekViewHolder", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OWeekPagerAdapter extends RecyclerView.Adapter<WeekViewHolder> {
    public final Function1<a.C0094a, Unit> a;
    public List<a.c> b;
    public String c;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/o/impl/diary/week/OWeekPagerAdapter$WeekViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "row", "Landroid/widget/LinearLayout;", "<init>", "(Landroid/widget/LinearLayout;)V", "bind", "", "week", "Lcom/larus/dora/o/impl/diary/calendar/OCalendarDataBuilder$WeekData;", "selectedDate", "", "onDayClick", "Lkotlin/Function1;", "Lcom/larus/dora/o/impl/diary/calendar/OCalendarDataBuilder$DayCell;", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WeekViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int b = 0;
        public final LinearLayout a;

        public static final class a {
        }

        static {
        }

        public WeekViewHolder(LinearLayout r2) {
            Intrinsics.checkNotNullParameter(r2, "row");
            super(r2);
            this.a = r2;
        }
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public OWeekPagerAdapter(w69.a r2) {
        Intrinsics.checkNotNullParameter(r2, "onDayClick");
        this.a = r2;
        this.b = CollectionsKt.emptyList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r18, int r110) {
        WeekViewHolder r1 = (WeekViewHolder) r18;
        Intrinsics.checkNotNullParameter(r1, "holder");
        a.c r2 = (a.c) ListProtector.get(this.b, r110);
        String r3 = this.c;
        final Function1<a.C0094a, Unit> r4 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "week");
        Intrinsics.checkNotNullParameter(r4, "onDayClick");
        Iterator<T> r5 = r2.a.iterator();
        int r7 = 0;
    L4:
        if (r5.hasNext() == false) goto L49;
        Object r8 = r5.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final a.C0094a r10 = (a.C0094a) r8;
        View r11 = r1.a.getChildAt(r7);
        if (r11 == null) goto L48;
        boolean r12 = Intrinsics.areEqual(r3, r10.a);
        Intrinsics.checkNotNullParameter(r11, "dayView");
        Intrinsics.checkNotNullParameter(r4, "onDayClick");
        View r13 = r11.findViewById(2131393148);
        TextView r14 = (TextView) r11.findViewById(2131368563);
        SimpleDraweeView r15 = r11.findViewById(2131368557);
        Context r16 = r11.getContext();
        r14.setText(String.valueOf(r10.b));
        i r17 = r10.e;
        if (r17 != null) goto L14;
    L21:
        String r111 = null;
    L22:
        if (r111 != null) goto L24;
    L27:
        boolean r112 = true;
    L28:
        if (r112 == true) goto L30;
        r15.setVisibility(0);
        ImageLoaderKt.u(r15, r111, "dora_o_diary_emoji");
    L31:
        if (r12 == false) goto L34;
        int r6 = 2131233945;
    L37:
        r13.setBackgroundResource(r6);
        if (r12 == false) goto L41;
        int r20 = 2131101355;
    L44:
        r14.setTextColor(ContextCompat.getColor(r16, r20));
        if (r10.d == false) goto L47;
        r11.setOnClickListener(null);
        r11.setClickable(false);
        goto L48
    L47:
        r11.setOnClickListener(new b(r4, r10));
        goto L48
    L41:
        if (r10.d == false) goto L43;
        r20 = 2131101369;
        goto L44
    L43:
        r20 = 2131101368;
        goto L44
    L34:
        if (r10.c == false) goto L36;
        r6 = 2131233946;
        goto L37
    L36:
        r6 = 0;
        goto L37
    L30:
        r15.setVisibility(8);
        goto L31
    L24:
        if (r111.length() == 0) goto L27;
        r112 = false;
        goto L28
    L14:
        if (r17.e() == true) goto L17;
        r17 = null;
    L17:
        if (r17 == null) goto L21;
        c0 r113 = r17.d();
        if (r113 == null) goto L21;
        r111 = r113.a();
    L48:
        r7 = r9;
        goto L4
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        LinearLayout r12 = new LinearLayout(r10.getContext());
        r12.setOrientation(0);
        r12.setClipChildren(false);
        Integer r1 = Integer.valueOf(r10.getMeasuredWidth());
        if (r1.intValue() <= 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        int r3 = r1.intValue();
    L13:
        r12.setLayoutParams(new RecyclerView.LayoutParams(r3, -2));
        LayoutInflater r4 = LayoutInflater.from(r10.getContext());
        int r5 = 0;
    L15:
        if (r5 >= 7) goto L26;
        View r6 = r4.inflate(2131560160, r12, false);
        if (r5 <= 0) goto L24;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
    L22:
        if (r8 == null) goto L24;
        Resources r9 = r10.getResources();
        r8.setMarginStart((int) ((WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()).density * 1) + 0.5f));
        goto L24
    L21:
        r8 = null;
    L24:
        r12.addView(r6);
        r5 = r5 + 1;
        goto L15
    L26:
        return new WeekViewHolder(r12);
    L12:
        r3 = -1;
        goto L13
    L5:
        r2 = false;
        goto L7
    }
}
