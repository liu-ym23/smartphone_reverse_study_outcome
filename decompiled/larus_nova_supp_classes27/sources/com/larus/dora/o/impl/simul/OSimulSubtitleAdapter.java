package com.larus.dora.o.impl.simul;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/o/impl/simul/OSimulSubtitleAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/avlink/api/DoraSimulSubtitleItem;", "Lcom/larus/dora/o/impl/simul/OSimulSubtitleAdapter$SubtitleViewHolder;", "isBottomPanel", "", "<init>", "(Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "Companion", "SubtitleViewHolder", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OSimulSubtitleAdapter extends ListAdapter<w88.l, SubtitleViewHolder> {
    public static final OSimulSubtitleAdapter$Companion$DIFF$1 b = null;
    public final boolean a;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/o/impl/simul/OSimulSubtitleAdapter$SubtitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "isBottomPanel", "", "<init>", "(Landroid/view/View;Z)V", "originalView", "Landroid/widget/TextView;", "translationView", "bind", "", "item", "Lcom/larus/avlink/api/DoraSimulSubtitleItem;", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SubtitleViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;

        public SubtitleViewHolder(View r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "itemView");
            super(r5);
            TextView r0 = (TextView) r5.findViewById(2131387659);
            this.a = r0;
            TextView r1 = (TextView) r5.findViewById(2131387672);
            this.b = r1;
            r0.setTextSize(2, 12.0f);
            r1.setTextSize(2, 16.0f);
            r1.setTypeface(null, 0);
            Context r7 = r5.getContext();
            if (r6 == false) goto L5;
            int r8 = 2131101368;
        L6:
            r1.setTextColor(ContextCompat.getColor(r7, r8));
            return;
        L5:
            r8 = 2131101354;
            goto L6
        }
    }

    public static final class a {
    }

    public OSimulSubtitleAdapter() {
        this(false);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.dora.o.impl.simul.OSimulSubtitleAdapter$Companion$DIFF$1] */
    static {
        b = new OSimulSubtitleAdapter$Companion$DIFF$1();
    }

    public OSimulSubtitleAdapter(boolean r2) {
        super(b);
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        SubtitleViewHolder r8 = (SubtitleViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        w88.l r9 = (w88.l) getItem(r7);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "item");
        boolean r1 = true;
        if (r9.b.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        r8.a.setVisibility(8);
    L11:
        if (r9.c.length() == 0) goto L14;
        r1 = false;
    L14:
        if (r1 == false) goto L16;
        r8.b.setVisibility(8);
        return;
    L16:
        r8.b.setVisibility(0);
        r8.b.setText(r9.c);
        return;
    L9:
        r8.a.setVisibility(0);
        r8.a.setText(r9.b);
        goto L11
    L5:
        r0 = false;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131560159, r3, false);
        Intrinsics.checkNotNull(r5);
        return new SubtitleViewHolder(r5, this.a);
    }
}
