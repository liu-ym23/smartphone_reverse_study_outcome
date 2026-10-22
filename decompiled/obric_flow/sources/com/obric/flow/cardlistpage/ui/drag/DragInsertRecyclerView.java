package com.obric.flow.cardlistpage.ui.drag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import gu.f;
import gu.g;
import gu.j;
import java.util.IdentityHashMap;
import ju.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kq.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/obric/flow/cardlistpage/ui/drag/DragInsertRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lgu/g;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lgu/j;", "listener", "", "setTouchCompleteListener", "(Lgu/j;)V", "", "getBottomFadingEdgeStrength", "()F", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "a", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "getOnItemTouchListener", "()Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "setOnItemTouchListener", "(Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;)V", "onItemTouchListener", "Landroid/view/View;", "b", "Landroid/view/View;", "getDragSelectedView", "()Landroid/view/View;", "setDragSelectedView", "(Landroid/view/View;)V", "dragSelectedView", "kq/a", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DragInsertRecyclerView extends RecyclerView implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView.OnItemTouchListener f11769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f11770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f11771c;
    public final IdentityHashMap d;

    public DragInsertRecyclerView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.d = new IdentityHashMap();
        setEnableOverFling(true);
        allowClickDuringOverScroll(true);
    }

    public static boolean b(Object r5) {
        String r10 = ItemTouchHelper.class.getName();
        String r11 = r5.getClass().getName();
        if (Intrinsics.areEqual(r11, r10) == true) goto L8;
        Intrinsics.checkNotNull(r11);
        if (StringsKt.P(r11, r10.concat("$")) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public final void a(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        int r10 = r5.getAction();
        RecyclerView.OnItemTouchListener r11 = this.f11769a;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.onInterceptTouchEvent(this, r5) == true) goto L7;
        return;
    L7:
        if (r10 == 3) goto L12;
        r11.onTouchEvent(this, r5);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void addOnChildAttachStateChangeListener(RecyclerView.OnChildAttachStateChangeListener r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (b(r5) == false) goto L6;
        a r10 = new a(this, r5);
        this.d.put(r5, r10);
        super.addOnChildAttachStateChangeListener(r10);
        return;
    L6:
        super.addOnChildAttachStateChangeListener(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void addOnItemTouchListener(RecyclerView.OnItemTouchListener r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        if (b(r10) == false) goto L9;
        String r5 = "addOnItemTouchListener: " + r10;
        Intrinsics.checkNotNullParameter("DragInsertRecyclerView", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        org.koin.core.a r11 = su.a.f22013b;
        if (r11 == null) goto L8;
        ((b) r11.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).i("DragInsertRecyclerView", r5);
        this.f11769a = r10;
        goto L9
    L8:
        throw new IllegalStateException("KoinApplication has not been started");
    L9:
        super.addOnItemTouchListener(r10);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    public final View getDragSelectedView() {
        return this.f11770b;
    }

    public final RecyclerView.OnItemTouchListener getOnItemTouchListener() {
        return this.f11769a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        int r10 = r5.getAction();
        if (r10 != 1) goto L5;
    L7:
        j r11 = this.f11771c;
        if (r11 == null) goto L12;
        hu.a r12 = ((f) r11).g;
        if (r12.d == true) goto L12;
        r12.a();
    L12:
        this.f11771c = null;
    L14:
        return super.onInterceptTouchEvent(r5);
    L5:
        if (r10 == 3) goto L7;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void removeOnChildAttachStateChangeListener(RecyclerView.OnChildAttachStateChangeListener r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (b(r5) == false) goto L8;
        a r10 = (a) this.d.remove(r5);
        if (r10 == null) goto L10;
        super.removeOnChildAttachStateChangeListener(r10);
        return;
    L10:
        return;
    L8:
        super.removeOnChildAttachStateChangeListener(r5);
    }

    public final void setDragSelectedView(View r5) {
        this.f11770b = r5;
    }

    public final void setOnItemTouchListener(RecyclerView.OnItemTouchListener r5) {
        this.f11769a = r5;
    }

    @Override // gu.g
    public void setTouchCompleteListener(j r5) {
        this.f11771c = r5;
    }

    public DragInsertRecyclerView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "attrs");
        super(r5, r10);
        this.d = new IdentityHashMap();
        setEnableOverFling(true);
        allowClickDuringOverScroll(true);
    }

    public DragInsertRecyclerView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "attrs");
        super(r5, r10, r11);
        this.d = new IdentityHashMap();
        setEnableOverFling(true);
        allowClickDuringOverScroll(true);
    }
}
