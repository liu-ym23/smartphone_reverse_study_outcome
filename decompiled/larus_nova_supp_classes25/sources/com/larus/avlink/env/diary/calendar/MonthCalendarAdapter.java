package com.larus.avlink.env.diary.calendar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B'\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000f\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ/\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\u0010\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\u0006R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/avlink/env/diary/calendar/MonthCalendarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/avlink/env/diary/calendar/MonthCalendarAdapter$MonthViewHolder;", "onDayClick", "Lkotlin/Function3;", "Lcom/larus/avlink/env/diary/calendar/CalendarItem$DayItem;", "", "", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "months", "", "Lcom/larus/avlink/env/diary/calendar/MonthCalendarData;", "viewHolders", "", "submitList", "newMonths", "", "getData", "updateSelectedDay", "lastMonthPos", "lastDayPos", "newMonthPos", "newDayPos", "(Ljava/lang/Integer;Ljava/lang/Integer;II)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "onViewRecycled", "getItemCount", "getMonthData", "MonthViewHolder", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MonthCalendarAdapter extends RecyclerView.Adapter<MonthViewHolder> {
    public final Function3<a.C0005a, Integer, Integer, Unit> a;
    public final List<n> b;
    public final Map<Integer, MonthViewHolder> c;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0006R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/avlink/env/diary/calendar/MonthCalendarAdapter$MonthViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onDayClick", "Lkotlin/Function3;", "Lcom/larus/avlink/env/diary/calendar/CalendarItem$DayItem;", "", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function3;)V", "monthTitle", "Landroid/widget/TextView;", "monthGrid", "Landroidx/recyclerview/widget/RecyclerView;", "gridAdapter", "Lcom/larus/avlink/env/diary/calendar/MonthGridAdapter;", "bind", "monthData", "Lcom/larus/avlink/env/diary/calendar/MonthCalendarData;", "monthPosition", "updateDay", "dayPosition", "dayItem", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class MonthViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int d = 0;
        public final Function3<a.C0005a, Integer, Integer, Unit> a;
        public final TextView b;
        public final MonthGridAdapter c;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.avlink.env.diary.calendar.m] */
        public MonthViewHolder(View r4, Function3<? super a.C0005a, ? super Integer, ? super Integer, Unit> r5) {
            Intrinsics.checkNotNullParameter(r4, "itemView");
            Intrinsics.checkNotNullParameter(r5, "onDayClick");
            super(r4);
            this.a = r5;
            this.b = (TextView) r4.findViewById(2131369026);
            RecyclerView r6 = r4.findViewById(2131369024);
            MonthGridAdapter r0 = new MonthGridAdapter(new m(this));
            this.c = r0;
            r6.setLayoutManager(new GridLayoutManager(r4.getContext(), 7));
            r6.setAdapter(r0);
            r6.addItemDecoration(new GridRowSpacingDecoration());
            r6.setNestedScrollingEnabled(false);
            r6.setHasFixedSize(true);
        }

        public final void T3(int r3, a.C0005a r4) {
            Intrinsics.checkNotNullParameter(r4, "dayItem");
            MonthGridAdapter r1 = this.c;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "dayItem");
            if (r3 >= 0) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r0 == false) goto L13;
            ListProtector.set(r1.b, r3, r4);
            Map<Integer, MonthGridAdapter.DayViewHolder> r2 = r1.c;
            LinkedHashMap r5 = (LinkedHashMap) r2;
            MonthGridAdapter.DayViewHolder r6 = (MonthGridAdapter.DayViewHolder) r5.get(Integer.valueOf(r3));
            if (r6 == null) goto L14;
            r6.T3(r4);
            return;
        L14:
            return;
        L13:
            return;
        L5:
            if (r3 >= ((ArrayList) r1.b).size()) goto L7;
            r0 = true;
            goto L8
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public MonthCalendarAdapter(d r2) {
        Intrinsics.checkNotNullParameter(r2, "onDayClick");
        this.a = r2;
        this.b = new ArrayList();
        this.c = new LinkedHashMap();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r3) {
        final MonthViewHolder r4 = (MonthViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewRecycled(r4);
        CollectionsKt.removeAll(((LinkedHashMap) this.c).values(), new l(r4));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        MonthViewHolder r6 = (MonthViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Integer r0 = Integer.valueOf(r5);
        this.c.put(r0, r6);
        n r7 = (n) ListProtector.get(this.b, r5);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "monthData");
        TextView r1 = r6.b;
        StringBuilder r2 = new StringBuilder();
        r2.append(r7.b);
        r2.append(26376);
        r1.setText(r2.toString());
        MonthGridAdapter r8 = r6.c;
        List<a.C0005a> r9 = r7.c;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "newDays");
        ((ArrayList) r8.b).clear();
        ArrayList r3 = (ArrayList) r8.b;
        r3.addAll(r9);
        r8.notifyDataSetChanged();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562538, r3, false);
        Intrinsics.checkNotNull(r5);
        return new MonthViewHolder(r5, this.a);
    }

    public final void y2(Integer r6, Integer r7, int r8, int r9) {
        boolean r0 = false;
        if (r6 == null) goto L13;
        if (r7 == null) goto L13;
        if (CollectionsKt.getIndices(this.b).contains(r6.intValue()) == false) goto L13;
        n r1 = (n) ListProtector.get(this.b, r6.intValue());
        if (CollectionsKt.getIndices(r1.c).contains(r7.intValue()) == false) goto L13;
        List r2 = CollectionsKt.toMutableList(r1.c);
        ListProtector.set(r2, r7.intValue(), a.C0005a.a((a.C0005a) ListProtector.get(r2, r7.intValue()), false));
        ListProtector.set(this.b, r6.intValue(), n.a(r1, r2));
        MonthViewHolder r10 = (MonthViewHolder) ((LinkedHashMap) this.c).get(r6);
        if (r10 == null) goto L13;
        r10.T3(r7.intValue(), (a.C0005a) ListProtector.get(r2, r7.intValue()));
    L13:
        if (r8 >= 0) goto L15;
    L17:
        boolean r11 = false;
    L18:
        if (r11 == false) goto L29;
        n r12 = (n) ListProtector.get(this.b, r8);
        if (r9 >= 0) goto L22;
    L24:
        if (r0 == false) goto L30;
        List r3 = CollectionsKt.toMutableList(r12.c);
        ListProtector.set(r3, r9, a.C0005a.a((a.C0005a) ListProtector.get(r3, r9), true));
        ListProtector.set(this.b, r8, n.a(r12, r3));
        Map<Integer, MonthViewHolder> r13 = this.c;
        LinkedHashMap r14 = (LinkedHashMap) r13;
        MonthViewHolder r15 = (MonthViewHolder) r14.get(Integer.valueOf(r8));
        if (r15 == null) goto L31;
        r15.T3(r9, (a.C0005a) ListProtector.get(r3, r9));
        return;
    L31:
        return;
    L30:
        return;
    L22:
        if (r9 >= r12.c.size()) goto L24;
        r0 = true;
        goto L24
    L29:
        return;
    L15:
        if (r8 >= ((ArrayList) this.b).size()) goto L17;
        r11 = true;
        goto L18
    }
}
