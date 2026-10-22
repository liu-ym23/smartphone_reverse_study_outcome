package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/DialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/annie/debug/ui/DialogAdapter$ViewHolder;", "ViewHolder", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class DialogAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final List<DialogItem> a;
    public final Context b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/DialogAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final ViewGroup a;
        public final TextView b;
        public final TextView c;
        public final TextView d;
        public final Switch e;

        public ViewHolder(View r10) {
            Intrinsics.checkNotNullParameter(r10, "itemView");
            super(r10);
            this.a = (ViewGroup) r10.findViewById(2131375288);
            this.b = (TextView) r10.findViewById(2131392192);
            this.c = (TextView) r10.findViewById(2131377093);
            this.d = (TextView) r10.findViewById(2131388772);
            this.e = (Switch) r10.findViewById(2131387876);
        }
    }

    public final long getItemId(int r10) {
        return r10;
    }

    public final int getItemViewType(int r1) {
        return r1;
    }

    public final int getItemCount() {
        List<DialogItem> r0 = this.a;
        Intrinsics.checkNotNull(r0);
        return r0.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DialogAdapter(List<? extends DialogItem> r1, Context r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        ViewHolder r12 = (ViewHolder) r10;
        Intrinsics.checkNotNullParameter(r12, "viewHolder");
        List<DialogItem> r0 = this.a;
        Intrinsics.checkNotNull(r0);
        DialogItem r13 = (DialogItem) ListProtector.get(r0, r11);
        if (r13.getType() != DialogItem.ItemType.DUMMY_TITLE) goto L6;
        TextView r14 = r12.d;
        r14.setText(r13.a);
        r14.setVisibility(0);
        return;
    L6:
        if (r13.d == null) goto L8;
    L10:
        r12.a.setVisibility(0);
        String r1 = r13.a;
        if (r1 == null) goto L13;
        r12.c.setText(r1);
        r12.c.setVisibility(0);
    L13:
        String r15 = r13.b;
        if (r15 == null) goto L16;
        r12.b.setText(r15);
        r12.b.setVisibility(0);
    L16:
        View.OnClickListener r16 = r13.d;
        if (r16 == null) goto L19;
        r12.a.setOnClickListener(r16);
    L19:
        CompoundButton.OnCheckedChangeListener r17 = r13.e;
        if (r17 == null) goto L22;
        r12.e.setVisibility(0);
        r12.e.setChecked(r13.c);
        r12.e.setOnCheckedChangeListener(r17);
    L22:
        r12.a.setOnLongClickListener(new c(r13, this));
        return;
    L8:
        if (r13.getType() == DialogItem.ItemType.SWITCH) goto L10;
        r13.d = new b(r13, this);
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        return new ViewHolder(LayoutInflater.from(r10.getContext()).inflate(2131558543, r10, false));
    }
}
