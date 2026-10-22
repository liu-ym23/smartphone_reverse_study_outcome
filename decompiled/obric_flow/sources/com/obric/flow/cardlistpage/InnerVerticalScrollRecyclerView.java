package com.obric.flow.cardlistpage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/obric/flow/cardlistpage/InnerVerticalScrollRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "c", "Lkotlin/Lazy;", "getLinearLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "d", "getParentScrollOrientation", "()I", "parentScrollOrientation", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InnerVerticalScrollRecyclerView extends RecyclerView {
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f11433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f11435c;
    public final Lazy d;

    @JvmOverloads
    public InnerVerticalScrollRecyclerView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final LinearLayoutManager getLinearLayoutManager() {
        return (LinearLayoutManager) this.f11435c.getValue();
    }

    private final int getParentScrollOrientation() {
        return ((Number) this.d.getValue()).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        char r5 = 0;
        if (getLinearLayoutManager().findFirstCompletelyVisibleItemPosition() != 0) goto L11;
        int r11 = getLinearLayoutManager().findLastCompletelyVisibleItemPosition();
        RecyclerView.Adapter r12 = getAdapter();
        if (r12 == null) goto L8;
        int r13 = r12.getItemCount();
    L10:
        if (r11 != (r13 - 1)) goto L11;
        return super.onInterceptTouchEvent(r10);
    L8:
        r13 = 0;
    L11:
        if (r10 == null) goto L13;
        Integer r14 = Integer.valueOf(r10.getActionMasked());
    L15:
        if (r14 != null) goto L18;
    L20:
        if (r14 != null) goto L23;
    L44:
        return super.onInterceptTouchEvent(r10);
    L23:
        if (r14.intValue() != 2) goto L44;
        if (getParentScrollOrientation() != 1) goto L41;
        float r15 = this.f11433a;
        double r16 = 360;
        double r17 = ((Math.toDegrees((float) Math.atan2(this.f11434b - (r10.getRawY() + 0.5f), r15 - (r10.getRawX() + 0.5f))) - 0.0d) + r16) % r16;
        if (r17 <= 45.0d) goto L32;
        if (r17 >= 135.0d) goto L32;
        r5 = 1;
    L36:
        if (r5 != 1) goto L38;
        getParent().requestDisallowInterceptTouchEvent(true);
    L38:
        if (r5 != 2) goto L44;
        getParent().requestDisallowInterceptTouchEvent(true);
    L32:
        if (r17 <= 225.0d) goto L36;
        if (r17 >= 315.0d) goto L36;
        r5 = 2;
        goto L36
    L41:
        if (getParentScrollOrientation() != 2) goto L44;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L44
    L18:
        if (r14.intValue() != 0) goto L20;
        this.f11433a = r10.getRawX() + 0.5f;
        this.f11434b = r10.getRawY() + 0.5f;
        goto L44
    L13:
        r14 = null;
        goto L15
    }

    @JvmOverloads
    public InnerVerticalScrollRecyclerView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ InnerVerticalScrollRecyclerView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public InnerVerticalScrollRecyclerView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f11435c = LazyKt.lazy(new InnerVerticalScrollRecyclerView$linearLayoutManager$2(this));
        this.d = LazyKt.lazy(new InnerVerticalScrollRecyclerView$parentScrollOrientation$2(this));
    }
}
