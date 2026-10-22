package com.ss.android.lark.discretescrollview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.discretescrollview.transform.DiscreteScrollItemTransformer;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DiscreteScrollView extends RecyclerView {
    private static final int DEFAULT_ORIENTATION = 0;
    private static final String LOG_TAG = "DiscreteScrollView";
    public static final int NO_POSITION = -1;
    private boolean isOverScrollEnabled;
    private DiscreteScrollLayoutManager layoutManager;
    private Runnable notifyItemChangedRunnable;
    private List<OnItemChangedListener> onItemChangedListeners;
    private List<c> scrollStateChangeListeners;

    public interface OnItemChangedListener<T extends RecyclerView.ViewHolder> {
        void onCurrentItemChanged(T r1, int r2);
    }

    public class a implements Runnable {
        public final /* synthetic */ DiscreteScrollView a;

        @Override // java.lang.Runnable
        public final void run() {
            DiscreteScrollView.access$000(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(DiscreteScrollView r1) {
            this.a = r1;
        }
    }

    public interface b<T extends RecyclerView.ViewHolder> {
    }

    public interface c<T extends RecyclerView.ViewHolder> {
        void a();

        void b();

        void c();
    }

    public class d implements DiscreteScrollLayoutManager.c {
        public final /* synthetic */ DiscreteScrollView a;

        public d(DiscreteScrollView r1) {
            this.a = r1;
        }
    }

    static {
        DEFAULT_ORIENTATION = DSVOrientation.HORIZONTAL.ordinal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void notifyCurrentItemChanged() {
        removeCallbacks(this.notifyItemChangedRunnable);
        if (this.onItemChangedListeners.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = this.layoutManager.k;
        RecyclerView.ViewHolder r1 = getViewHolder(r0);
        if (r1 != null) goto L8;
        post(this.notifyItemChangedRunnable);
        return;
    L8:
        notifyCurrentItemChanged(r1, r0);
    }

    public int getCurrentItem() {
        return this.layoutManager.k;
    }

    public DiscreteScrollView(Context r1) {
        super(r1);
        this.notifyItemChangedRunnable = new a(this);
        init(null);
    }

    public static /* synthetic */ void access$000(DiscreteScrollView r0) {
        r0.notifyCurrentItemChanged();
    }

    public static /* synthetic */ boolean access$200(DiscreteScrollView r0) {
        return r0.isOverScrollEnabled;
    }

    public static /* synthetic */ Runnable access$300(DiscreteScrollView r0) {
        return r0.notifyItemChangedRunnable;
    }

    public static /* synthetic */ List access$400(DiscreteScrollView r0) {
        return r0.scrollStateChangeListeners;
    }

    public static /* synthetic */ DiscreteScrollLayoutManager access$500(DiscreteScrollView r0) {
        return r0.layoutManager;
    }

    public static /* synthetic */ List access$700(DiscreteScrollView r0) {
        return r0.onItemChangedListeners;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(AttributeSet r7) {
        this.scrollStateChangeListeners = new ArrayList();
        this.onItemChangedListeners = new ArrayList();
        int r0 = DEFAULT_ORIENTATION;
        boolean r1 = true;
        if (r7 == null) goto L6;
        TypedArray r8 = getContext().obtainStyledAttributes(r7, new int[]{2130969845});
        r0 = r8.getInt(0, r0);
        r8.recycle();
    L6:
        if (getOverScrollMode() != 2) goto L9;
        r1 = false;
    L9:
        this.isOverScrollEnabled = r1;
        DiscreteScrollLayoutManager r9 = new DiscreteScrollLayoutManager(getContext(), new d(this), DSVOrientation.values()[r0]);
        this.layoutManager = r9;
        setLayoutManager(r9);
    }

    public void addOnItemChangedListener(OnItemChangedListener<?> r2) {
        this.onItemChangedListeners.add(r2);
    }

    public void addScrollListener(b<?> r1) {
        addScrollStateChangeListener(new bbb.a());
    }

    public void addScrollStateChangeListener(c<?> r2) {
        this.scrollStateChangeListeners.add(r2);
    }

    public RecyclerView.ViewHolder getViewHolder(int r2) {
        View r3 = this.layoutManager.findViewByPosition(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return getChildViewHolder(r3);
    }

    public void removeItemChangedListener(OnItemChangedListener<?> r2) {
        this.onItemChangedListeners.remove(r2);
    }

    public void removeScrollListener(b<?> r1) {
        removeScrollStateChangeListener(new bbb.a());
    }

    public void removeScrollStateChangeListener(c<?> r2) {
        this.scrollStateChangeListeners.remove(r2);
    }

    public void scrollToPosition(int r2) {
        int r0 = this.layoutManager.k;
        super.scrollToPosition(r2);
        if (r0 == r2) goto L6;
        notifyCurrentItemChanged();
        return;
    }

    public void setClampTransformProgressAfter(int r3) {
        if (r3 > 1) goto L5;
        Log.e(LOG_TAG, "must be >= 1");
    L5:
        DiscreteScrollLayoutManager r0 = this.layoutManager;
        r0.s = r3;
        r0.p();
    }

    public void setItemTransformer(DiscreteScrollItemTransformer r2) {
        this.layoutManager.A = r2;
    }

    public void setItemTransitionTimeMillis(int r2) {
        this.layoutManager.q = r2;
    }

    public void setLayoutManager(RecyclerView.LayoutManager r2) {
        if ((r2 instanceof DiscreteScrollLayoutManager) == false) goto L5;
        super.setLayoutManager(r2);
        return;
    L5:
        Log.e(LOG_TAG, "layout manager of wrong type");
    }

    public void setOffscreenItems(int r3) {
        DiscreteScrollLayoutManager r0 = this.layoutManager;
        r0.r = r3;
        r0.f = r0.g * r3;
        r0.B.a.requestLayout();
    }

    public void setOrientation(DSVOrientation r2) {
        DiscreteScrollLayoutManager r0 = this.layoutManager;
        r0.getClass();
        r0.n = r2.createHelper();
        r0.B.a.removeAllViews();
        r0.B.a.requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOverScrollEnabled(boolean r1) {
        this.isOverScrollEnabled = r1;
        setOverScrollMode(2);
    }

    public void setScrollConfig(DSVScrollConfig r2) {
        this.layoutManager.y = r2;
    }

    public void setSlideOnFling(boolean r2) {
        this.layoutManager.v = r2;
    }

    public void setSlideOnFlingThreshold(int r2) {
        this.layoutManager.u = r2;
    }

    public DiscreteScrollView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.notifyItemChangedRunnable = new a(this);
        init(r2);
    }

    private void notifyCurrentItemChanged(RecyclerView.ViewHolder r3, int r4) {
        Iterator<OnItemChangedListener> r0 = this.onItemChangedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCurrentItemChanged(r3, r4);
        goto L4
    }

    private void notifyScrollEnd(RecyclerView.ViewHolder r1, int r2) {
        Iterator<c> r3 = this.scrollStateChangeListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().c();
        goto L4
    }

    private void notifyScrollStart(RecyclerView.ViewHolder r1, int r2) {
        Iterator<c> r3 = this.scrollStateChangeListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().a();
        goto L4
    }

    public boolean fling(int r8, int r9) {
        DiscreteScrollLayoutManager r0 = this.layoutManager;
        boolean r1 = false;
        if (r0.y.isScrollBlocked(Direction.fromDelta(r0.n.h(r8, r9))) == false) goto L5;
        return false;
    L5:
        boolean r2 = super.fling(r8, r9);
        if (r2 == false) goto L36;
        DiscreteScrollLayoutManager r3 = this.layoutManager;
        int r10 = r3.n.h(r8, r9);
        if (r3.v == false) goto L10;
        int r11 = Math.abs(r10 / r3.u);
    L11:
        int r4 = r3.k + Direction.fromDelta(r10).applyTo(r11);
        int r12 = r3.B.b();
        int r5 = r3.k;
        if (r5 == 0) goto L15;
        if (r4 >= 0) goto L15;
        r4 = 0;
    L20:
        if ((r10 * r3.i) < 0) goto L22;
        boolean r13 = true;
    L23:
        if (r13 == false) goto L31;
        if (r4 >= 0) goto L26;
    L28:
        boolean r14 = false;
    L29:
        if (r14 == false) goto L31;
        r1 = true;
        goto L31
    L26:
        if (r4 >= r3.B.b()) goto L28;
        r14 = true;
    L31:
        if (r1 == false) goto L33;
        r3.v(r4);
    L39:
        return r2;
    L33:
        int r15 = -r3.i;
        r3.j = r15;
        if (r15 == 0) goto L39;
        r3.u();
        goto L39
    L22:
        r13 = false;
    L15:
        int r6 = r12 - 1;
        if (r5 == r6) goto L20;
        if (r4 < r12) goto L20;
        r4 = r6;
        goto L20
    L10:
        r11 = 1;
        goto L11
    L36:
        DiscreteScrollLayoutManager r16 = this.layoutManager;
        int r17 = -r16.i;
        r16.j = r17;
        if (r17 == 0) goto L39;
        r16.u();
        goto L39
    }

    public DiscreteScrollView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.notifyItemChangedRunnable = new a(this);
        init(r2);
    }

    public static /* synthetic */ void access$600(DiscreteScrollView r0, RecyclerView.ViewHolder r1, int r2) {
        r0.notifyScrollStart(r1, r2);
    }

    public static /* synthetic */ void access$800(DiscreteScrollView r0, RecyclerView.ViewHolder r1, int r2) {
        r0.notifyScrollEnd(r1, r2);
    }

    public static /* synthetic */ void access$900(DiscreteScrollView r0, RecyclerView.ViewHolder r1, int r2) {
        r0.notifyCurrentItemChanged(r1, r2);
    }

    private void notifyScroll(float r1, int r2, int r3, RecyclerView.ViewHolder r4, RecyclerView.ViewHolder r5) {
        Iterator<c> r6 = this.scrollStateChangeListeners.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r6.next().b();
        goto L4
    }

    public static /* synthetic */ void access$1000(DiscreteScrollView r0, float r1, int r2, int r3, RecyclerView.ViewHolder r4, RecyclerView.ViewHolder r5) {
        r0.notifyScroll(r1, r2, r3, r4, r5);
    }
}
