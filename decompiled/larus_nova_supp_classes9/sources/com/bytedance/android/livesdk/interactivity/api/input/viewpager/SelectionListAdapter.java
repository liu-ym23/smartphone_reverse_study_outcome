package com.bytedance.android.livesdk.interactivity.api.input.viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/SelectionListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/SelectionListAdapter$PageSelectionViewHolder;", "PageSelectionViewHolder", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class SelectionListAdapter extends RecyclerView.Adapter<PageSelectionViewHolder> {
    public Function2<? super Integer, ? super c, Unit> a;
    public int b;
    public final LinkedHashSet<Integer> c;
    public final int d;
    public final int e;
    public final RecyclerView f;
    public final List<c> g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0096\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/SelectionListAdapter$PageSelectionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public class PageSelectionViewHolder extends RecyclerView.ViewHolder {
        public c a;
        public final /* synthetic */ SelectionListAdapter b;

        public void T3(boolean r2) {
            if (r2 == false) goto L5;
            ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131385726)).setTextColor(this.b.d);
            return;
        L5:
            ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131385726)).setTextColor(this.b.e);
        }

        public PageSelectionViewHolder(SelectionListAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.b = r2;
            super(r3);
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SelectionListAdapter a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PageSelectionViewHolder c;
        public final /* synthetic */ c d;

        public a(SelectionListAdapter r1, int r2, PageSelectionViewHolder r3, c r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            SelectionListAdapter r4 = this.a;
            int r0 = r4.b;
            if (r0 != this.b) goto L5;
            return;
        L5:
            r4.c.remove(Integer.valueOf(r0));
            SelectionListAdapter r5 = this.a;
            RecyclerView.ViewHolder r6 = r5.f.findViewHolderForLayoutPosition(r5.b);
            if ((r6 instanceof PageSelectionViewHolder) == true) goto L8;
            r6 = null;
        L8:
            PageSelectionViewHolder r7 = (PageSelectionViewHolder) r6;
            if (r7 == null) goto L11;
            r7.T3(false);
        L12:
            SelectionListAdapter r8 = this.a;
            int r1 = this.b;
            int r2 = r8.g.size();
            if (r1 < 0) goto L17;
            if (r2 <= r1) goto L17;
            ((c) ListProtector.get(r8.g, r1)).c();
        L17:
            this.c.T3(true);
            SelectionListAdapter r9 = this.a;
            r9.b = this.c.getAdapterPosition();
            SelectionListAdapter r10 = this.a;
            r10.c.add(Integer.valueOf(r10.b));
            Function2<? super Integer, ? super c, Unit> r11 = this.a.a;
            if (r11 == null) goto L20;
            Unit r13 = (Unit) r11.invoke(Integer.valueOf(this.c.getAdapterPosition()), this.d);
        L20:
            SelectionListAdapter r14 = this.a;
            int r15 = this.b;
            int r16 = r14.g.size();
            if (r15 < 0) goto L27;
            if (r16 <= r15) goto L26;
            ((c) ListProtector.get(r14.g, r15)).b();
            return;
        L26:
            return;
        L27:
            return;
        L11:
            SelectionListAdapter r17 = this.a;
            int r18 = r17.b;
            r17.notifyItemChanged(r18, ListProtector.get(r17.g, r18));
            goto L12
        }
    }

    public final int getItemCount() {
        return this.g.size();
    }

    public PageSelectionViewHolder z2(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new PageSelectionViewHolder(this, LayoutInflater.from(r4.getContext()).inflate(2131567049, r4, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectionListAdapter(RecyclerView r2, List<? extends c> r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.f = r2;
        this.g = r3;
        this.c = new LinkedHashSet();
        this.d = ColorProtector.parseColor("#161823");
        this.e = ColorProtector.parseColor("#99161823");
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((PageSelectionViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return z2(r1);
    }

    public final void y2(PageSelectionViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        c r0 = (c) ListProtector.get(this.g, r5);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "selection");
        r4.a = r0;
        r4.T3(r4.b.c.contains(Integer.valueOf(r4.getAdapterPosition())));
        TextView r1 = (TextView) ((RecyclerView.ViewHolder) r4).itemView.findViewById(2131385726);
        c r2 = r4.a;
        if (r2 == null) goto L5;
        CharSequence r3 = r2.a();
    L6:
        r1.setText(r3);
        ((RecyclerView.ViewHolder) r4).itemView.setOnClickListener(new a(this, r5, r4, r0));
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        PageSelectionViewHolder r5 = (PageSelectionViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (r4.isEmpty() == false) goto L5;
        y2(r5, r3);
        return;
    L5:
        r5.T3(this.c.contains(Integer.valueOf(r3)));
    }
}
