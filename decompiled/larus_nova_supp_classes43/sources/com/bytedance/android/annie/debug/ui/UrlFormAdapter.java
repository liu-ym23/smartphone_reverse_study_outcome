package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/UrlFormAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/annie/debug/ui/UrlFormViewHolder;", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class UrlFormAdapter extends RecyclerView.Adapter<UrlFormViewHolder> {
    public final List<g> a;
    public final Context b;

    public final int getItemCount() {
        return this.a.size();
    }

    public UrlFormAdapter(List<g> r10, Context r11) {
        Intrinsics.checkNotNullParameter(r10, "paraList");
        Intrinsics.checkNotNullParameter(r11, "context");
        this.a = r10;
        this.b = r11;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        UrlFormViewHolder r12 = (UrlFormViewHolder) r10;
        Intrinsics.checkNotNullParameter(r12, "holder");
        g r13 = (g) ListProtector.get(this.a, r11);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "data");
        TextView r0 = (TextView) r12.b.getValue();
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        TextView r1 = (TextView) r12.b.getValue();
        if (r1 == null) goto L10;
        r1.setText(r13.c);
    L10:
        TextView r14 = (TextView) r12.c.getValue();
        if (r14 == null) goto L14;
        r14.setVisibility(0);
    L14:
        TextView r15 = (TextView) r12.c.getValue();
        if (r15 == null) goto L19;
        r15.setText(r13.d);
    L19:
        if (r13.getType() != 1) goto L28;
        TextView r16 = (TextView) r12.d.getValue();
        if (r16 == null) goto L24;
        r16.setVisibility(0);
    L24:
        TextView r17 = (TextView) r12.d.getValue();
        if (r17 == null) goto L34;
        r17.setText("子字段(" + r13.c + ")解析");
        return;
    L34:
        return;
    L28:
        TextView r18 = (TextView) r12.d.getValue();
        if (r18 == null) goto L35;
        r18.setVisibility(8);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        UrlFormViewHolder r12 = new UrlFormViewHolder(LayoutInflater.from(r10.getContext()).inflate(2131558545, r10, false));
        r12.a.setOnClickListener(new e(this, r12));
        TextView r13 = (TextView) r12.d.getValue();
        if (r13 == null) goto L5;
        r13.setOnClickListener(new f(this, r12));
    L5:
        return r12;
    }
}
