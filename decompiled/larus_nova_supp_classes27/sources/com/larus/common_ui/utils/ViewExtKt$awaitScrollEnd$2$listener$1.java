package com.larus.common_ui.utils;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/common_ui/utils/ViewExtKt$awaitScrollEnd$2$listener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewExtKt$awaitScrollEnd$2$listener$1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ i<Unit> b;

    public ViewExtKt$awaitScrollEnd$2$listener$1(RecyclerView r1, j r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onScrollStateChanged(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        if (r3 != 0) goto L6;
        this.a.removeOnScrollListener(this);
        i<Unit> r4 = this.b;
        Result.Companion r5 = Result.Companion;
        r4.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        return;
    }
}
