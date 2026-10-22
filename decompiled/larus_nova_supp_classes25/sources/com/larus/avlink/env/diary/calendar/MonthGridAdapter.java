package com.larus.avlink.env.diary.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB!\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000e\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0005J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/avlink/env/diary/calendar/MonthGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/avlink/env/diary/calendar/MonthGridAdapter$DayViewHolder;", "onDayClick", "Lkotlin/Function2;", "Lcom/larus/avlink/env/diary/calendar/CalendarItem$DayItem;", "", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "days", "", "viewHolders", "", "setData", "newDays", "", "updateItem", "position", "dayItem", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onViewRecycled", "getItemCount", "DayViewHolder", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MonthGridAdapter extends RecyclerView.Adapter<DayViewHolder> {
    public final Function2<a.C0005a, Integer, Unit> a;
    public final List<a.C0005a> b;
    public final Map<Integer, DayViewHolder> c;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u0013J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/avlink/env/diary/calendar/MonthGridAdapter$DayViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "emojiView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "emptyView", "dayText", "Landroid/widget/TextView;", "todayBgNormal", "todayBgSelected", "selectedBg", "bind", "", "item", "Lcom/larus/avlink/env/diary/calendar/CalendarItem$DayItem;", "onDayClick", "Lkotlin/Function2;", "", "updateSelectedState", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class DayViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int g = 0;
        public final SimpleDraweeView a;
        public final View b;
        public final TextView c;
        public final TextView d;
        public final TextView e;
        public final View f;

        public DayViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131369019);
            this.b = r2.findViewById(2131369020);
            this.c = (TextView) r2.findViewById(2131369018);
            this.d = (TextView) r2.findViewById(2131369022);
            this.e = (TextView) r2.findViewById(2131369023);
            this.f = r2.findViewById(2131369021);
        }

        public final void T3(a.C0005a r6) {
            Intrinsics.checkNotNullParameter(r6, "item");
            Context r0 = ((RecyclerView.ViewHolder) this).itemView.getContext();
            if (r6.h == true) goto L5;
            this.c.setTextColor(ContextCompat.getColor(r0, 2131103681));
            this.f.setVisibility(4);
            if (r6.f == false) goto L11;
            this.d.setVisibility(0);
            this.e.setVisibility(4);
            return;
        L11:
            this.d.setVisibility(4);
            this.e.setVisibility(4);
            return;
        L5:
            if (r6.f == false) goto L7;
            this.c.setTextColor(ContextCompat.getColor(r0, 2131101300));
            this.e.setVisibility(0);
            this.d.setVisibility(4);
            this.f.setVisibility(4);
            return;
        L7:
            this.c.setTextColor(ContextCompat.getColor(r0, 2131106521));
            this.f.setVisibility(0);
            this.e.setVisibility(4);
            this.d.setVisibility(4);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public MonthGridAdapter(m r2) {
        Intrinsics.checkNotNullParameter(r2, "onDayClick");
        this.a = r2;
        this.b = new ArrayList();
        this.c = new LinkedHashMap();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r3) {
        final DayViewHolder r4 = (DayViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewRecycled(r4);
        CollectionsKt.removeAll(((LinkedHashMap) this.c).values(), new o(r4));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        final DayViewHolder r7 = (DayViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Integer r0 = Integer.valueOf(r6);
        this.c.put(r0, r7);
        final a.C0005a r8 = (a.C0005a) ListProtector.get(this.b, r6);
        final Function2<a.C0005a, Integer, Unit> r1 = this.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r1, "onDayClick");
        int r2 = r8.c;
        if (r2 != 0) goto L5;
        r7.c.setText("");
        r7.a.setVisibility(4);
        r7.b.setVisibility(4);
        r7.d.setVisibility(4);
        r7.e.setVisibility(4);
        r7.f.setVisibility(4);
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(null);
        return;
    L5:
        r7.c.setText(String.valueOf(r2));
        r7.T3(r8);
        if (r8.f == false) goto L9;
        r7.a.setVisibility(4);
        r7.b.setVisibility(4);
    L12:
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new p(r1, r8, r7));
        return;
    L9:
        if (o0.d(r8.e) == false) goto L11;
        r7.a.setVisibility(0);
        r7.b.setVisibility(4);
        ImageLoaderKt.u(r7.a, r8.e, "dora_diary_emoji");
        goto L12
    L11:
        r7.a.setVisibility(4);
        r7.b.setVisibility(0);
        goto L12
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562537, r3, false);
        Intrinsics.checkNotNull(r5);
        return new DayViewHolder(r5);
    }
}
