package com.larus.camera.impl.widget;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001!B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000e\u001a\u00020\r2\n\u0010\u000f\u001a\u00060\u0010R\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010\u000f\u001a\u00060\u0010R\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J(\u0010\u001a\u001a\u00020\r2\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r0\u001cH\u0002J\u001c\u0010\u001e\u001a\u00020\r2\u0014\u0010\u001f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000bJ\b\u0010 \u001a\u0004\u0018\u00010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/camera/impl/widget/PickerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "reverseLayout", "", "itemUpdater", "Lcom/larus/camera/impl/widget/PickerLayoutManager$ItemUpdater;", "<init>", "(Landroid/content/Context;ZLcom/larus/camera/impl/widget/PickerLayoutManager$ItemUpdater;)V", "itemSelectedListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "", "dx", "onScrollStateChanged", "scaleDownView", "getSelectedPosition", "normalizeOffsetAndLoopChild", "callback", "Lkotlin/Function3;", "", "setOnItemSelectedListener", "listener", "getSelectedItem", "ItemUpdater", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerLayoutManager extends LinearLayoutManager {
    public final a a;
    public Function1<? super View, Unit> b;

    public interface a {
        void a(View r1, float r2);
    }

    public final View p() {
        final Ref.IntRef r0 = new Ref.IntRef();
        final Ref.FloatRef r1 = new Ref.FloatRef();
        r1.element = 1.0f;
        q(new s(r1, r0));
        return getChildAt(r0.element);
    }

    public final void onScrollStateChanged(int r2) {
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onScrollStateChanged(r2);
        if (r2 != 0) goto L6;
        this.b.invoke(p());
        return;
    }

    public final void q(Function3<? super View, ? super Integer, ? super Float, Unit> r8) {
        float r0 = getWidth() / 2.0f;
        int r3 = 0;
        if (r0 != 0.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        int r4 = getChildCount();
    L9:
        if (r3 >= r4) goto L15;
        View r5 = getChildAt(r3);
        if (r5 == null) goto L14;
        r8.invoke(r5, Integer.valueOf(r3), Float.valueOf(Math.abs(((getDecoratedLeft(r5) + getDecoratedRight(r5)) / 2.0f) - r0) / r0));
    L14:
        r3 = r3 + 1;
        goto L9
    L15:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public PickerLayoutManager(Context r2, a r3) {
        Intrinsics.checkNotNullParameter(r3, "itemUpdater");
        super(r2, 0, false);
        this.a = r3;
        this.b = new t();
    }

    public final void onLayoutChildren(RecyclerView.Recycler r2, RecyclerView.State r3) {
        Intrinsics.checkNotNullParameter(r2, "recycler");
        Intrinsics.checkNotNullParameter(r3, "state");
        super.onLayoutChildren(r2, r3);
        q(new r(this));
    }

    public final int scrollHorizontallyBy(int r2, RecyclerView.Recycler r3, RecyclerView.State r4) {
        Intrinsics.checkNotNullParameter(r3, "recycler");
        Intrinsics.checkNotNullParameter(r4, "state");
        int r5 = super.scrollHorizontallyBy(r2, r3, r4);
        q(new r(this));
        return r5;
    }
}
