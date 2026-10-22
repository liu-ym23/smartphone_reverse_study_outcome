package com.larus.community.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewbinding.ViewBindings;
import com.larus.community.impl.databinding.LarusCommunityCreationLoadingAndRetryLayoutBinding;
import com.larus.community.impl.loading.CreationTemplateLoadingAdapter;
import com.larus.utils.e1;
import com.larus.utils.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r29.k;
import t29.a;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0012\u001a\u00020\f2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u000bJ\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/community/impl/widget/CreationLoadingAndRetryView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationLoadingAndRetryLayoutBinding;", "onRetryClickListener", "Lkotlin/Function0;", "", "emptyViewCreator", "Landroid/view/View;", "emptyView", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setOnRetryClickListener", "bindItemDecoration", "updateSpanCount", "spanCount", "", "trySetEmptyView", "view", "setEmptyCreator", "updateStatus", "state", "Lcom/larus/community/impl/view/PageState;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationLoadingAndRetryView extends ConstraintLayout {
    public static final /* synthetic */ int f = 0;
    public final LarusCommunityCreationLoadingAndRetryLayoutBinding a;
    public Function0<Unit> b;
    public Function0<? extends View> c;
    public View d;
    public RecyclerView.ItemDecoration e;

    public CreationLoadingAndRetryView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(k r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        if (Intrinsics.areEqual(r4, k.d.a) == false) goto L8;
        e1.x(this.a.b);
        e1.o(this.a.c);
        View r5 = this.d;
        if (r5 == null) goto L40;
        e1.o(r5);
        return;
    L40:
        return;
    L8:
        if (Intrinsics.areEqual(r4, k.b.a) == false) goto L13;
        e1.o(this.a.b);
        e1.x(this.a.c);
        View r6 = this.d;
        if (r6 == null) goto L42;
        e1.o(r6);
        return;
    L42:
        return;
    L13:
        if (Intrinsics.areEqual(r4, k.e.a) == false) goto L16;
        e1.o(this.a.b);
        e1.o(this.a.c);
        return;
    L16:
        if (Intrinsics.areEqual(r4, k.a.a) == false) goto L35;
        e1.o(this.a.b);
        e1.o(this.a.c);
        if (this.d != null) goto L32;
        Function0<? extends View> r7 = this.c;
        if (r7 == null) goto L32;
        View r8 = (View) r7.invoke();
        if (r8 == null) goto L32;
        if (this.d != null) goto L32;
        ViewParent r0 = r8.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L28;
        ViewGroup r1 = (ViewGroup) r0;
    L29:
        if (r1 == null) goto L31;
        r1.removeView(r8);
    L31:
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(-1, -2);
        r2.startToStart = 0;
        r2.endToEnd = 0;
        r2.topToTop = 0;
        Unit r3 = Unit.INSTANCE;
        addView(r8, r2);
        this.d = r8;
        e1.o(r8);
        goto L32
    L28:
        r1 = null;
    L32:
        View r9 = this.d;
        if (r9 == null) goto L45;
        e1.x(r9);
        return;
    L45:
        return;
    L35:
        View r10 = this.d;
        if (r10 == null) goto L38;
        e1.o(r10);
    L38:
        e1.o(this.a.b);
        e1.o(this.a.c);
    }

    public final void setEmptyCreator(Function0<? extends View> r1) {
        this.c = r1;
    }

    public final void setOnRetryClickListener(Function0<Unit> r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationLoadingAndRetryView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        LayoutInflater.from(r4).inflate(2131561960, this);
        int r6 = 2131379091;
        UnresponsiveRecyclerView r0 = (UnresponsiveRecyclerView) ViewBindings.findChildViewById(this, 2131379091);
        if (r0 == null) goto L15;
        r6 = 2131384145;
        if (((TextView) ViewBindings.findChildViewById(this, 2131384145)) == null) goto L15;
        r6 = 2131384472;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(this, 2131384472);
        if (r1 == null) goto L15;
        this.a = new LarusCommunityCreationLoadingAndRetryLayoutBinding(this, r0, r1);
        if (c7.d(Integer.valueOf(i.d(r4))) <= 500.0f) goto L11;
        int r7 = 3;
    L12:
        r0.setLayoutManager(new StaggeredGridLayoutManager(r7, 1));
        r0.setAdapter(new CreationTemplateLoadingAdapter());
        e1.d(r1, new a(this));
        return;
    L11:
        r7 = 2;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r6)));
    }
}
