package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations;

    public SimpleItemAnimator() {
        this.mSupportsChangeAnimations = true;
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateAdd(RecyclerView.ViewHolder r5);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateAppearance(@NonNull RecyclerView.ViewHolder r10, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo r11, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r12) {
        if (r11 == null) goto L10;
        int r5 = r11.left;
        int r13 = r12.left;
        if (r5 != r13) goto L8;
        if (r11.top == r12.top) goto L10;
    L8:
        return animateMove(r10, r5, r11.top, r13, r12.top);
    L10:
        return animateAdd(r10);
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateChange(RecyclerView.ViewHolder r5, RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateChange(@NonNull RecyclerView.ViewHolder r10, @NonNull RecyclerView.ViewHolder r11, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r12, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r13) {
        int r5 = r12.left;
        int r14 = r12.top;
        if (r11.shouldIgnore() == false) goto L5;
        int r15 = r12.left;
        int r16 = r12.top;
        int r17 = r15;
    L7:
        return animateChange(r10, r11, r5, r14, r17, r16);
    L5:
        int r18 = r13.left;
        r17 = r18;
        r16 = r13.top;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder r10, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r11, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo r12) {
        int r5 = r11.left;
        int r13 = r11.top;
        View r14 = r10.itemView;
        if (r12 != null) goto L6;
        int r15 = r14.getLeft();
    L5:
        int r16 = r15;
        if (r12 != null) goto L10;
        int r17 = r14.getTop();
    L9:
        int r18 = r17;
        if (r10.isRemoved() == true) goto L18;
        if (r5 != r16) goto L15;
        if (r13 == r18) goto L18;
    L15:
        r14.layout(r16, r18, r14.getWidth() + r16, r14.getHeight() + r18);
        return animateMove(r10, r5, r13, r16, r18);
    L18:
        return animateRemove(r10);
    L10:
        r17 = r12.top;
        goto L9
    L6:
        r15 = r12.left;
        goto L5
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateMove(RecyclerView.ViewHolder r5, int r10, int r11, int r12, int r13);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animatePersistence(@NonNull RecyclerView.ViewHolder r10, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r11, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r12) {
        int r5 = r11.left;
        int r13 = r12.left;
        if (r5 != r13) goto L10;
        if (r11.top != r12.top) goto L10;
        dispatchMoveFinished(r10);
        return false;
    L10:
        return animateMove(r10, r5, r11.top, r13, r12.top);
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateRemove(RecyclerView.ViewHolder r5);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder r5) {
        if (this.mSupportsChangeAnimations == true) goto L5;
    L8:
        return true;
    L5:
        if (r5.isInvalid() == true) goto L8;
        return false;
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchAddFinished(RecyclerView.ViewHolder r5) {
        onAddFinished(r5);
        dispatchAnimationFinished(r5);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchAddStarting(RecyclerView.ViewHolder r5) {
        onAddStarting(r5);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchChangeFinished(RecyclerView.ViewHolder r5, boolean r10) {
        onChangeFinished(r5, r10);
        dispatchAnimationFinished(r5);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchChangeStarting(RecyclerView.ViewHolder r5, boolean r10) {
        onChangeStarting(r5, r10);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchMoveFinished(RecyclerView.ViewHolder r5) {
        onMoveFinished(r5);
        dispatchAnimationFinished(r5);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchMoveStarting(RecyclerView.ViewHolder r5) {
        onMoveStarting(r5);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchRemoveFinished(RecyclerView.ViewHolder r5) {
        onRemoveFinished(r5);
        dispatchAnimationFinished(r5);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchRemoveStarting(RecyclerView.ViewHolder r5) {
        onRemoveStarting(r5);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    @SuppressLint({"UnknownNullness"})
    public void onAddFinished(RecyclerView.ViewHolder r5) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onAddStarting(RecyclerView.ViewHolder r5) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onChangeFinished(RecyclerView.ViewHolder r5, boolean r10) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onChangeStarting(RecyclerView.ViewHolder r5, boolean r10) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onMoveFinished(RecyclerView.ViewHolder r5) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onMoveStarting(RecyclerView.ViewHolder r5) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onRemoveFinished(RecyclerView.ViewHolder r5) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onRemoveStarting(RecyclerView.ViewHolder r5) {
    }

    public void setSupportsChangeAnimations(boolean r5) {
        this.mSupportsChangeAnimations = r5;
    }
}
