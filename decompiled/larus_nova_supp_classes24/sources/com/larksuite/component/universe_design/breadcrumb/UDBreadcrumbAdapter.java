package com.larksuite.component.universe_design.breadcrumb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import h18.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rJ\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0010\u0010\u0018\u001a\u00020\u000f2\b\b\u0001\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\rJ\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\"\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumbAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumbAdapter$BreadcrumbViewHolder;", "context", "Landroid/content/Context;", "onClickListener", "Lcom/larksuite/component/universe_design/breadcrumb/OnBreadcrumbItemClickListener;", "<init>", "(Landroid/content/Context;Lcom/larksuite/component/universe_design/breadcrumb/OnBreadcrumbItemClickListener;)V", "items", "", "", "itemMaxWidth", "", "setItems", "", "itemList", "", "addItem", "item", "removeItems", "index", "count", "updateItem", "setItemMaxWidth", "maxWidth", "getItemMaxWidth", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "isLastItem", "", "createItemView", "Landroid/view/View;", "BreadcrumbViewHolder", "universe-ui-breadcrumb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDBreadcrumbAdapter extends RecyclerView.Adapter<BreadcrumbViewHolder> {
    public final Context a;
    public final a b;
    public final List<String> c;
    public int d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumbAdapter$BreadcrumbViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "labelTv", "Landroid/widget/TextView;", "getLabelTv", "()Landroid/widget/TextView;", "universe-ui-breadcrumb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class BreadcrumbViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public BreadcrumbViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131364564);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public UDBreadcrumbAdapter(Context r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onClickListener");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
        this.d = LKUIToast.DURATION_MAX;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        BreadcrumbViewHolder r7 = (BreadcrumbViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        String r0 = (String) ListProtector.get(this.c, r6);
        r7.a.setText(r0);
        View r1 = ((RecyclerView.ViewHolder) r7).itemView;
        boolean r2 = true;
        if (r6 == (getItemCount() - 1)) goto L5;
        boolean r3 = true;
    L6:
        r1.setEnabled(r3);
        TextView r4 = r7.a;
        if (r6 != (getItemCount() - 1)) goto L10;
        r2 = false;
    L10:
        r4.setEnabled(r2);
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new b(this, r6));
        int r8 = r7.a.getMaxWidth();
        int r9 = this.d;
        if (r8 == r9) goto L14;
        r7.a.setMaxWidth(r9);
        return;
    L14:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        TextView r9 = new TextView(this.a, null, 0, 2131953824);
        r9.setId(2131364564);
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -2);
        r0.gravity = 17;
        r9.setLayoutParams(r0);
        r9.setMaxWidth(this.d);
        LinearLayout r1 = new LinearLayout(this.a, null, 0, 2131953823);
        r1.setLayoutParams(new LinearLayout.LayoutParams(-2, d.d(r1.getContext(), 2131169364)));
        r1.setOrientation(0);
        r1.addView(r9);
        return new BreadcrumbViewHolder(r1);
    }
}
