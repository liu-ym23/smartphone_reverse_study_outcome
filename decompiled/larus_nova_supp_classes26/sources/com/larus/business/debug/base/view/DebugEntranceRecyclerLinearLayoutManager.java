package com.larus.business.debug.base.view;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0018\u00010\tR\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/business/debug/base/view/DebugEntranceRecyclerLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DebugEntranceRecyclerLinearLayoutManager extends LinearLayoutManager {
    public DebugEntranceRecyclerLinearLayoutManager(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, 1, false);
    }

    public final void onLayoutChildren(RecyclerView.Recycler r2, RecyclerView.State r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        super.onLayoutChildren(r2, r3);     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
