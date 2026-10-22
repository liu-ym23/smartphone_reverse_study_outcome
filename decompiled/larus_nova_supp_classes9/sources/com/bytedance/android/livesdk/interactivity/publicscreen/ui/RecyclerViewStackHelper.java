package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/RecyclerViewStackHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewStackHelper extends RecyclerView.OnScrollListener {
    public RecyclerView a;
    public boolean b;

    public final void j() {
        RecyclerView r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
        View r3 = null;
        if ((r1 instanceof LinearLayoutManager) == true) goto L8;
        r1 = null;
    L8:
        LinearLayoutManager r2 = (LinearLayoutManager) r1;
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.getStackFromEnd() == true) goto L14;
        return;
    L14:
        boolean r4 = !this.b;
        if (r4 == false) goto L30;
        int r5 = r2.findFirstCompletelyVisibleItemPosition();
        int r6 = r2.findLastCompletelyVisibleItemPosition();
        if (r5 == (-1)) goto L28;
        if (r6 == (-1)) goto L28;
        if (r5 > r6) goto L28;
    L21:
        View r7 = r2.findViewByPosition(r5);
        if (r7 != null) goto L24;
    L26:
        if (r5 == r6) goto L28;
        r5 = r5 + 1;
        goto L21
    L24:
        if (r7.isFocusableInTouchMode() == false) goto L26;
        r3 = r7;
    L28:
        if (r3 == null) goto L30;
        r3.requestFocus();
    L30:
        if (r4 == false) goto L32;
        return;
    L32:
        if (r0.getFocusedChild() == null) goto L38;
        r0.clearFocus();
        return;
    }

    public RecyclerViewStackHelper() {
        this.b = true;
    }

    public final void onScrollStateChanged(RecyclerView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        j();
    }
}
