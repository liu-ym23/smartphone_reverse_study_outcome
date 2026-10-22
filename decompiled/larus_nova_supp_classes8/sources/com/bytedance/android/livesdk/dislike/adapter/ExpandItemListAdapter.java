package com.bytedance.android.livesdk.dislike.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.bytedance.android.livesdk.dislike.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nt1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/adapter/ExpandItemListAdapter;", "Lcom/bytedance/android/livesdk/dislike/adapter/AbsExpandListItemAdapter;", "Lcom/bytedance/android/livesdk/dislike/adapter/ExpandItemListAdapter$ExpandItemViewHolder;", "ExpandItemViewHolder", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExpandItemListAdapter extends AbsExpandListItemAdapter<ExpandItemViewHolder> {
    public final List<j> a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/adapter/ExpandItemListAdapter$ExpandItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ExpandItemViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final TextView b;

        public ExpandItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131374718);
            this.b = (TextView) r2.findViewById(2131368819);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public ExpandItemListAdapter(List<j> r2) {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        r0.addAll(r2);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        ExpandItemViewHolder r9 = (ExpandItemViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "viewHolder");
        j r0 = (j) ListProtector.get(this.a, r8);
        int r1 = ((ArrayList) this.a).size();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        ImageView r2 = r9.a;
        if (r2 == null) goto L5;
        r2.setImageResource(r0.c.a);
    L5:
        TextView r3 = r9.b;
        if (r3 != null) goto L41;
    L12:
        c r4 = r0.c;
        if (r4 == null) goto L24;
        String r5 = r4.c;
        if (r5 == null) goto L24;
        if (r5.length() <= 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 != true) goto L24;
        TextView r10 = r9.b;
        if (r10 == null) goto L24;
        r10.setText(r0.c.c);
        goto L24
    L19:
        r6 = false;
    L24:
        View r11 = ((RecyclerView.ViewHolder) r9).itemView;
        if (r11 == null) goto L27;
        r11.setOnClickListener(new a(r0));
    L27:
        OptionAction.e(r0.b);
        if (r8 != 0) goto L33;
        View r12 = ((RecyclerView.ViewHolder) r9).itemView;
        if (r12 == null) goto L43;
        r12.setBackgroundResource(2131249492);
        return;
    L43:
        return;
    L33:
        if (r8 != (r1 - 1)) goto L37;
        View r13 = ((RecyclerView.ViewHolder) r9).itemView;
        if (r13 == null) goto L45;
        r13.setBackgroundResource(2131249493);
        return;
    L45:
        return;
    L37:
        View r14 = ((RecyclerView.ViewHolder) r9).itemView;
        if (r14 == null) goto L47;
        r14.setBackgroundColor(-1);
        return;
    L47:
        return;
    L41:
        String r15 = s1.B(r0.c.b);     // Catch: Exception -> L9
    L11:
        r3.setText(r15);
    L9:
        e = move-exception;
        SafetyGuard.a(null, e, "get desc text wrong!");
        r15 = "";
        goto L11
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        return new ExpandItemViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131565625, r3, false));
    }
}
