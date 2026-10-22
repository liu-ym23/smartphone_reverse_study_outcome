package com.obric.oui.orecyclerview.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import androidx.core.view.ViewCompat;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 {
    private boolean mHasStableIds;
    private final b0 mObservable;
    private RecyclerView$Adapter$StateRestorationPolicy mStateRestorationPolicy;

    public a0() {
        this.mObservable = new b0();
        this.mHasStableIds = false;
        this.mStateRestorationPolicy = RecyclerView$Adapter$StateRestorationPolicy.ALLOW;
    }

    public final void bindViewHolder(@NonNull x0 r5, int r10) {
        if (r5.mBindingAdapter != null) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L11;
        r5.mPosition = r10;
        if (hasStableIds() == false) goto L10;
        r5.mItemId = getItemId(r10);
    L10:
        r5.setFlags(1, 519);
        TraceCompat.beginSection("RV OnBindView");
    L11:
        r5.mBindingAdapter = this;
        if (RecyclerView.f13723x0 == true) goto L14;
    L27:
        onBindViewHolder(r5, r10, r5.getUnmodifiedPayloads());
        if (r11 == false) goto L34;
        r5.clearPayload();
        ViewGroup.LayoutParams r12 = r5.itemView.getLayoutParams();
        if ((r12 instanceof RecyclerView.LayoutParams) == false) goto L32;
        ((RecyclerView.LayoutParams) r12).f13770c = true;
    L32:
        TraceCompat.endSection();
        return;
    L34:
        return;
    L14:
        if (r5.itemView.getParent() != null) goto L21;
        if (ViewCompat.isAttachedToWindow(r5.itemView) == r5.isTmpDetached()) goto L21;
        throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + r5.isTmpDetached() + ", attached to window: " + ViewCompat.isAttachedToWindow(r5.itemView) + ", holder: " + r5);
    L21:
        if (r5.itemView.getParent() != null) goto L27;
        if (ViewCompat.isAttachedToWindow(r5.itemView) == false) goto L27;
        throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + r5);
    L5:
        r11 = false;
        goto L6
    }

    public boolean canRestoreState() {
        int r5 = z.f13930a[this.mStateRestorationPolicy.ordinal()];
        if (r5 != 1) goto L5;
        return false;
    L5:
        if (r5 == 2) goto L8;
        return true;
    L8:
        if (getItemCount() > 0) goto L10;
        return false;
    L10:
        return true;
    }

    @NonNull
    public final x0 createViewHolder(@NonNull ViewGroup r5, int r10) {
        TraceCompat.beginSection("RV CreateView");     // Catch: Throwable -> L7
        x0 r11 = onCreateViewHolder(r5, r10);     // Catch: Throwable -> L7
        if (r11.itemView.getParent() != null) goto L10;
        r11.mItemViewType = r10;     // Catch: Throwable -> L7
        TraceCompat.endSection();
        return r11;
    L10:
        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    public int findRelativeAdapterPositionIn(@NonNull a0 r5, @NonNull x0 r10, int r11) {
        if (r5 != this) goto L4;
        return r11;
    L4:
        return -1;
    }

    public abstract int getItemCount();

    public long getItemId(int r5) {
        return -1;
    }

    public int getItemViewType(int r5) {
        return 0;
    }

    @NonNull
    public final RecyclerView$Adapter$StateRestorationPolicy getStateRestorationPolicy() {
        return this.mStateRestorationPolicy;
    }

    public final boolean hasObservers() {
        return this.mObservable.a();
    }

    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public final void notifyDataSetChanged() {
        this.mObservable.b();
    }

    public final void notifyItemChanged(int r5) {
        this.mObservable.d(r5, 1, null);
    }

    public final void notifyItemInserted(int r5) {
        this.mObservable.e(r5, 1);
    }

    public final void notifyItemMoved(int r5, int r10) {
        this.mObservable.c(r5, r10);
    }

    public final void notifyItemRangeChanged(int r5, int r10) {
        this.mObservable.d(r5, r10, null);
    }

    public final void notifyItemRangeInserted(int r5, int r10) {
        this.mObservable.e(r5, r10);
    }

    public final void notifyItemRangeRemoved(int r5, int r10) {
        this.mObservable.f(r5, r10);
    }

    public final void notifyItemRemoved(int r5) {
        this.mObservable.f(r5, 1);
    }

    public void onAttachedToRecyclerView(@NonNull RecyclerView r5) {
    }

    public abstract void onBindViewHolder(x0 r5, int r10);

    public void onBindViewHolder(@NonNull x0 r5, int r10, @NonNull List<Object> r11) {
        onBindViewHolder(r5, r10);
    }

    public abstract x0 onCreateViewHolder(ViewGroup r5, int r10);

    public void onDetachedFromRecyclerView(@NonNull RecyclerView r5) {
    }

    public boolean onFailedToRecycleView(@NonNull x0 r5) {
        return false;
    }

    public void onViewAttachedToWindow(@NonNull x0 r5) {
    }

    public void onViewDetachedFromWindow(@NonNull x0 r5) {
    }

    public void onViewRecycled(@NonNull x0 r5) {
    }

    public void registerAdapterDataObserver(@NonNull c0 r5) {
        this.mObservable.registerObserver(r5);
    }

    public void setHasStableIds(boolean r5) {
        if (hasObservers() == true) goto L7;
        this.mHasStableIds = r5;
        return;
    L7:
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }

    public void setStateRestorationPolicy(@NonNull RecyclerView$Adapter$StateRestorationPolicy r5) {
        this.mStateRestorationPolicy = r5;
        this.mObservable.g();
    }

    public void unregisterAdapterDataObserver(@NonNull c0 r5) {
        this.mObservable.unregisterObserver(r5);
    }

    public final void notifyItemChanged(int r5, @Nullable Object r10) {
        this.mObservable.d(r5, 1, r10);
    }

    public final void notifyItemRangeChanged(int r5, int r10, @Nullable Object r11) {
        this.mObservable.d(r5, r10, r11);
    }
}
