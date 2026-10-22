package com.larus.business.debug.base.adapter.viewHolder;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sv8.g;
import sv8.h;
import zv8.b;
import zv8.e;
import zv8.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/business/debug/base/adapter/viewHolder/EntranceTextViewHolder;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "content", "bind", "", "debugEntrance", "Lcom/larus/business/debug/base/register/DebugEntrance;", "copyToClipboard", "key", "", "unbind", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceTextViewHolder extends EntranceViewHolder {
    public static final /* synthetic */ int d = 0;
    public TextView b;
    public TextView c;

    public EntranceTextViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void T3(final e r3) {
        Intrinsics.checkNotNullParameter(r3, "debugEntrance");
        Intrinsics.checkNotNullParameter(r3, "debugEntrance");
        this.a = r3;
        this.b = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371714);
        this.c = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371712);
        ((RecyclerView.ViewHolder) this).itemView.setOnLongClickListener(new g(r3));
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setText(r3.c());
    L5:
        TextView r1 = this.c;
        if (r1 == null) goto L8;
        r1.setText("");
    L8:
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new h(r3, this));
        if ((r3 instanceof j) == false) goto L11;
        j r4 = (j) r3;
    L12:
        if (r4 == null) goto L17;
        Activity r2 = AppHost.a.a().getCurrentActivity();
        if (r2 == null) goto L18;
        r4.c = new b(r2, r4);
        return;
    L18:
        return;
    L17:
        return;
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void U3(e r2) {
        Intrinsics.checkNotNullParameter(r2, "debugEntrance");
        Intrinsics.checkNotNullParameter(r2, "debugEntrance");
    }
}
