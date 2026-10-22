package kq;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.ui.drag.DragInsertRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements RecyclerView.OnChildAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.OnChildAttachStateChangeListener f19458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DragInsertRecyclerView f19459b;

    public a(DragInsertRecyclerView r5, RecyclerView.OnChildAttachStateChangeListener r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.f19459b = r5;
        this.f19458a = r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void onChildViewAttachedToWindow(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.f19458a.onChildViewAttachedToWindow(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void onChildViewDetachedFromWindow(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if (r5 != this.f19459b.getDragSelectedView()) goto L5;
        return;
    L5:
        this.f19458a.onChildViewDetachedFromWindow(r5);
    }
}
