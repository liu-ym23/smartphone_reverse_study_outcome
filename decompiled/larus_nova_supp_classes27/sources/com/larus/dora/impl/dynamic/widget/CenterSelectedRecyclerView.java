package com.larus.dora.impl.dynamic.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0010J\u0016\u0010 \u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"H\u0016R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/CenterSelectedRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "selectedIndex", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "", "isAutoCenterEnabled", "()Z", "setAutoCenterEnabled", "(Z)V", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLinearLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "centerSnapHelper", "Landroidx/recyclerview/widget/LinearSnapHelper;", "maxDeviation", "isCorrecting", "scrollToSelectedItem", "", "smoothScroll", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CenterSelectedRecyclerView extends RecyclerView {
    public int a;

    public CenterSelectedRecyclerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CenterSelectedRecyclerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final LinearLayoutManager getLinearLayoutManager() {
        LinearLayoutManager r0 = getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final int getSelectedIndex() {
        return this.a;
    }

    public void setAdapter(RecyclerView.Adapter<?> r4) {
        super.setAdapter(r4);
        int r0 = 0;
        if (r4 == null) goto L5;
        int r1 = r4.getItemCount();
    L6:
        int r2 = -1;
        if (r1 != 0) goto L9;
        setSelectedIndex(-1);
        return;
    L9:
        int r3 = this.a;
        if (r4 == null) goto L12;
        r0 = r4.getItemCount();
    L12:
        if (r3 < r0) goto L18;
        if (r4 == null) goto L15;
        r2 = r4.getItemCount() - 1;
    L15:
        setSelectedIndex(r2);
        return;
    L18:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void setAutoCenterEnabled(boolean r2) {
        if (r2 == false) goto L11;
        int r3 = this.a;
        if (r3 == (-1)) goto L12;
        if (r3 != (-1)) goto L7;
        return;
    L7:
        if (getAdapter() == null) goto L14;
        scrollToPosition(this.a);
        return;
    L14:
        return;
    L12:
        return;
    }

    public final void setSelectedIndex(int r2) {
        if (this.a == r2) goto L17;
        if (r2 < 0) goto L18;
        RecyclerView.Adapter r0 = getAdapter();
        if (r0 == null) goto L8;
        int r1 = r0.getItemCount();
    L9:
        if (r2 >= r1) goto L19;
        this.a = r2;
        if (r2 != (-1)) goto L13;
        return;
    L13:
        if (getAdapter() == null) goto L21;
        smoothScrollToPosition(this.a);
        return;
    L21:
        return;
    L19:
        return;
    L8:
        r1 = 0;
        goto L9
    L18:
        return;
    }

    public CenterSelectedRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = -1;
        LinearSnapHelper r5 = new LinearSnapHelper();
        c7.b(10);
        r5.attachToRecyclerView(this);
    }

    public /* synthetic */ CenterSelectedRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
