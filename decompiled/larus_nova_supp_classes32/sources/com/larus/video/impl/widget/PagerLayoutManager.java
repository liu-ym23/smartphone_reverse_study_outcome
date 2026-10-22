package com.larus.video.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00018B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000fJ\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0017H\u0017J\b\u0010)\u001a\u00020\tH\u0016J \u0010*\u001a\u00020'2\f\u0010+\u001a\b\u0018\u00010,R\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020'2\u0006\u0010-\u001a\u00020\u0007H\u0016J\b\u00100\u001a\u00020\tH\u0002J\b\u00101\u001a\u0004\u0018\u000102J,\u00103\u001a\u00020\t2\u0010\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\u0010\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H\u0002J\u001c\u00106\u001a\u0004\u0018\u0001022\u0010\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H\u0002R\u0018\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/video/impl/widget/PagerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "orientation", NameKeys.UnloadStrategy_No_Strategy, "reverseLayout", NameKeys.UnloadStrategy_No_Strategy, "(Landroid/content/Context;IZ)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastSelectedView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "currentSelectedView", "pagerSnapHelper", "Landroidx/recyclerview/widget/PagerSnapHelper;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isFirstLayout", "pointerCount", "enableScroll", "getEnableScroll", "()Z", "setEnableScroll", "(Z)V", "scrollCallBack", "Lcom/larus/video/impl/widget/PagerLayoutManager$ScrollCallBack;", "getScrollCallBack", "()Lcom/larus/video/impl/widget/PagerLayoutManager$ScrollCallBack;", "setScrollCallBack", "(Lcom/larus/video/impl/widget/PagerLayoutManager$ScrollCallBack;)V", "lastPosition", "onAttachedToWindow", NameKeys.UnloadStrategy_No_Strategy, "view", "canScrollVertically", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onScrollStateChanged", "tryNotifyItemSelectionChanged", "getCurrentViewHolder", "Lcom/larus/video/impl/widget/VideoViewHolder;", "equals", "r1", "r2", "getViewHolder", "viewRef", "ScrollCallBack", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PagerLayoutManager extends LinearLayoutManager {
    public WeakReference<View> a;
    public WeakReference<View> b;
    public final PagerSnapHelper c;
    public RecyclerView d;
    public boolean e;
    public int f;
    public boolean g;
    public a h;
    public int i;

    public interface a {
        void a(int r1, int r2);

        void b(int r1, int r2);
    }

    public final boolean canScrollVertically() {
        if (this.g == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically() == false) goto L7;
        return true;
    }

    public final boolean q() {
        this.a = this.b;
        if (this.g == false) goto L5;
        View r0 = this.c.findSnapView(this);
    L6:
        WeakReference<View> r1 = new WeakReference(r0);
        this.b = r1;
        WeakReference<View> r2 = this.a;
        if (Intrinsics.areEqual(r2, r1) == true) goto L15;
        if (r2 == null) goto L10;
        View r3 = r2.get();
    L12:
        if (Intrinsics.areEqual(r3, r1.get()) == true) goto L15;
        boolean r4 = false;
    L16:
        if (r4 == true) goto L19;
        postOnAnimation(new com.larus.video.impl.widget.a(this));
        return true;
    L19:
        return false;
    L10:
        r3 = null;
    L15:
        r4 = true;
        goto L16
    L5:
        r0 = findViewByPosition(findFirstVisibleItemPosition());
        goto L6
    }

    public PagerLayoutManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = new PagerSnapHelper();
        this.e = true;
        this.g = true;
        this.i = -1;
    }

    public final void onAttachedToWindow(RecyclerView r3) {
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onAttachedToWindow(r3);
        this.c.attachToRecyclerView(r3);
        this.d = r3;
        View r0 = null;
        if (r3 == null) goto L5;
        ViewParent r4 = r3.getParent();
    L7:
        if ((r4 instanceof View) == false) goto L9;
        r0 = (View) r4;
    L9:
        if (r0 == null) goto L12;
        r0.setOnTouchListener(new b(this));
        return;
    L12:
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void onScrollStateChanged(int r3) {
        if (r3 == 0) goto L4;
    L6:
        if (r3 != 0) goto L20;
        View r4 = this.c.findSnapView(this);
        if (r4 == null) goto L21;
        int r5 = getPosition(r4);
        int r0 = this.i;
        if (r5 <= r0) goto L14;
        a r1 = this.h;
        if (r1 == null) goto L18;
        r1.a(r0, r5);
    L18:
        this.i = r5;
        return;
    L14:
        if (r5 >= r0) goto L18;
        a r2 = this.h;
        if (r2 == null) goto L18;
        r2.b(r0, r5);
        goto L18
    L21:
        return;
    L20:
        return;
    L4:
        if (this.f != 0) goto L6;
        q();
        goto L6
    }

    public final VideoViewHolder p(WeakReference<View> r3) {
        if (r3 == null) goto L14;
        View r4 = r3.get();
        if (r4 == null) goto L15;
        RecyclerView r1 = this.d;
        if (r1 == null) goto L9;
        RecyclerView.ViewHolder r5 = r1.getChildViewHolder(r4);
    L11:
        if ((r5 instanceof VideoViewHolder) == true) goto L13;
        return null;
    L13:
        return (VideoViewHolder) r5;
    L9:
        r5 = null;
        goto L11
    L15:
        return null;
    L14:
        return null;
    }

    public final void onLayoutChildren(RecyclerView.Recycler r4, RecyclerView.State r5) {
        super.onLayoutChildren(r4, r5);     // Catch: IndexOutOfBoundsException -> L10
        if (this.e == true) goto L5;
        return;
    L5:
        if (q() == true) goto L7;
        boolean r6 = true;
    L8:
        this.e = r6;     // Catch: IndexOutOfBoundsException -> L10
        return;
    L7:
        r6 = false;
    L10:
        e = move-exception;
        FLogger.a.e(PagerLayoutManager.class.getName(), "perform notifyDataSetChanged still crash >>>" + e);
    }

    public PagerLayoutManager(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.c = new PagerSnapHelper();
        this.e = true;
        this.g = true;
        this.i = -1;
    }
}
