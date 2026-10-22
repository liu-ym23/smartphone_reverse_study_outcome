package com.larus.business.debug.base.adapter.viewHolder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.larus.business.debug.base.adapter.EntranceGroupAdapter;
import com.larus.business.debug.base.adapter.EntranceGroupDiffCallback;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntrancePage;
import com.larus.business.debug.base.view.DebugEntranceRecyclerLinearLayoutManager;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zv8.e;
import zv8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0006\u0010\u0015\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/business/debug/base/adapter/viewHolder/EntranceGroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "entranceListRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "entranceGroupTitleView", "Landroid/widget/TextView;", "entranceGroupAdapter", "Lcom/larus/business/debug/base/adapter/EntranceGroupAdapter;", "entranceGroup", "Lcom/larus/business/debug/base/register/EntranceGroup;", "entranceList", "Ljava/util/LinkedList;", "Lcom/larus/business/debug/base/register/DebugEntrance;", "bind", "", "page", "Lcom/larus/business/debug/base/register/EntrancePage;", "unbind", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceGroupViewHolder extends RecyclerView.ViewHolder {
    public final View a;
    public RecyclerView b;
    public TextView c;
    public EntranceGroupAdapter d;
    public final LinkedList<e> e;

    public EntranceGroupViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2;
        this.e = new LinkedList();
    }

    public final void T3(EntranceGroup r6, EntrancePage r7) {
        Intrinsics.checkNotNullParameter(r6, "entranceGroup");
        Intrinsics.checkNotNullParameter(r7, "page");
        this.b = this.a.findViewById(2131368585);
        this.c = (TextView) this.a.findViewById(2131368586);
        RecyclerView r0 = this.b;
        if (r0 == null) goto L7;
        RecyclerView.ItemAnimator r1 = r0.getItemAnimator();
        if (r1 == null) goto L7;
        r1.setChangeDuration(0);
    L7:
        RecyclerView r2 = this.b;
        SimpleItemAnimator r3 = null;
        if (r2 == null) goto L10;
        RecyclerView.ItemAnimator r4 = r2.getItemAnimator();
    L12:
        if ((r4 instanceof SimpleItemAnimator) == false) goto L15;
        r3 = (SimpleItemAnimator) r4;
    L15:
        if (r3 == null) goto L17;
        r3.setSupportsChangeAnimations(false);
    L17:
        TextView r5 = this.c;
        if (r5 == null) goto L20;
        r5.setText(r6.getDes());
    L20:
        k.a.getClass();
        List r8 = k.d(r7, r6, false);
        if (this.d != null) goto L28;
        EntranceGroupAdapter r9 = new EntranceGroupAdapter(this.e);
        this.d = r9;
        RecyclerView r10 = this.b;
        if (r10 == null) goto L25;
        r10.setAdapter(r9);
    L25:
        RecyclerView r11 = this.b;
        if (r11 == null) goto L28;
        r11.setLayoutManager(new DebugEntranceRecyclerLinearLayoutManager(this.a.getContext()));
    L28:
        EntranceGroupAdapter r12 = this.d;
        if (r12 == null) goto L31;
        DiffUtil.calculateDiff(new EntranceGroupDiffCallback(this.e, r8)).dispatchUpdatesTo(r12);
    L31:
        this.e.clear();
        this.e.addAll(k.d(r7, r6, false));
        return;
    L10:
        r4 = null;
        goto L12
    }
}
