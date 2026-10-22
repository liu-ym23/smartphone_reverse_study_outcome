package com.larus.business.debug.base.adapter.viewHolder;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common.apphost.AppHost;
import com.larus.utils.t0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sv8.a;
import sv8.b;
import sv8.c;
import zv8.e;
import zv8.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/business/debug/base/adapter/viewHolder/EntranceButtonViewHolder;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "button", "Landroid/widget/TextView;", "bind", "", "debugEntrance", "Lcom/larus/business/debug/base/register/DebugEntrance;", "unbind", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceButtonViewHolder extends EntranceViewHolder {
    public static final /* synthetic */ int c = 0;
    public TextView b;

    public EntranceButtonViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void T3(final e r3) {
        Intrinsics.checkNotNullParameter(r3, "debugEntrance");
        Intrinsics.checkNotNullParameter(r3, "debugEntrance");
        this.a = r3;
        this.b = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371701);
        ((RecyclerView.ViewHolder) this).itemView.setOnLongClickListener(new a(r3));
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setText(r3.c());
    L5:
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new b(r3));
        t0.c(new c(r3, this));
        if ((r3 instanceof j) == false) goto L8;
        j r4 = (j) r3;
    L9:
        if (r4 == null) goto L14;
        Activity r1 = AppHost.a.a().getCurrentActivity();
        if (r1 == null) goto L15;
        r4.c = new zv8.b(r1, r4);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r4 = null;
        goto L9
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void U3(e r4) {
        Intrinsics.checkNotNullParameter(r4, "debugEntrance");
        Intrinsics.checkNotNullParameter(r4, "debugEntrance");
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        TextView r1 = this.b;
        if (r1 == null) goto L8;
        r1.setText("");
    L8:
        TextView r2 = this.b;
        if (r2 == null) goto L11;
        r2.setOnClickListener(null);
    L11:
        r4.a();
        ((RecyclerView.ViewHolder) this).itemView.setPadding(0, 0, 0, 0);
    }
}
