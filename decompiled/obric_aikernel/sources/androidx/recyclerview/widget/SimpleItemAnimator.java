package androidx.recyclerview.widget;

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

    public abstract boolean animateAdd(RecyclerView.ViewHolder r10);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateAppearance(@NonNull RecyclerView.ViewHolder r10, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo r11, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r12) {
        if (r11 == null) goto L10;
        int r13 = r11.left;
        int r14 = r12.left;
        if (r13 != r14) goto L8;
        if (r11.top == r12.top) goto L10;
    L8:
        return animateMove(r10, r13, r11.top, r14, r12.top);
    L10:
        return animateAdd(r10);
    }

    public abstract boolean animateChange(RecyclerView.ViewHolder r10, RecyclerView.ViewHolder r11, int r12, int r13, int r14, int r15);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateChange(@NonNull RecyclerView.ViewHolder r10, @NonNull RecyclerView.ViewHolder r11, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r12, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r13) {
        int r14 = r12.left;
        int r15 = r12.top;
        if (r11.shouldIgnore() == false) goto L5;
        int r16 = r12.left;
        int r17 = r12.top;
        int r18 = r16;
    L7:
        return animateChange(r10, r11, r14, r15, r18, r17);
    L5:
        int r19 = r13.left;
        r18 = r19;
        r17 = r13.top;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder r10, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r11, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo r12) {
        int r13 = r11.left;
        int r14 = r11.top;
        View r15 = r10.itemView;
        if (r12 != null) goto L5;
        int r16 = r15.getLeft();
    L6:
        int r17 = r16;
        if (r12 != null) goto L9;
        int r18 = r15.getTop();
    L10:
        int r19 = r18;
        if (r10.isRemoved() == true) goto L17;
        if (r13 != r17) goto L14;
        if (r14 == r19) goto L17;
    L14:
        r15.layout(r17, r19, r15.getWidth() + r17, r15.getHeight() + r19);
        return animateMove(r10, r13, r14, r17, r19);
    L17:
        return animateRemove(r10);
    L9:
        r18 = r12.top;
        goto L10
    L5:
        r16 = r12.left;
        goto L6
    }

    public abstract boolean animateMove(RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animatePersistence(@NonNull RecyclerView.ViewHolder r10, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r11, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r12) {
        int r13 = r11.left;
        int r14 = r12.left;
        if (r13 != r14) goto L10;
        if (r11.top != r12.top) goto L10;
        dispatchMoveFinished(r10);
        return false;
    L10:
        return animateMove(r10, r13, r11.top, r14, r12.top);
    }

    public abstract boolean animateRemove(RecyclerView.ViewHolder r10);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder r10) {
        if (this.mSupportsChangeAnimations == true) goto L5;
    L8:
        return true;
    L5:
        if (r10.isInvalid() == true) goto L8;
        return false;
    }

    public final void dispatchAddFinished(RecyclerView.ViewHolder r10) {
        onAddFinished(r10);
        dispatchAnimationFinished(r10);
    }

    public final void dispatchAddStarting(RecyclerView.ViewHolder r10) {
        onAddStarting(r10);
    }

    public final void dispatchChangeFinished(RecyclerView.ViewHolder r10, boolean r11) {
        onChangeFinished(r10, r11);
        dispatchAnimationFinished(r10);
    }

    public final void dispatchChangeStarting(RecyclerView.ViewHolder r10, boolean r11) {
        onChangeStarting(r10, r11);
    }

    public final void dispatchMoveFinished(RecyclerView.ViewHolder r10) {
        onMoveFinished(r10);
        dispatchAnimationFinished(r10);
    }

    public final void dispatchMoveStarting(RecyclerView.ViewHolder r10) {
        onMoveStarting(r10);
    }

    public final void dispatchRemoveFinished(RecyclerView.ViewHolder r10) {
        onRemoveFinished(r10);
        dispatchAnimationFinished(r10);
    }

    public final void dispatchRemoveStarting(RecyclerView.ViewHolder r10) {
        onRemoveStarting(r10);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    public void onAddFinished(RecyclerView.ViewHolder r10) {
    }

    public void onAddStarting(RecyclerView.ViewHolder r10) {
    }

    public void onChangeFinished(RecyclerView.ViewHolder r10, boolean r11) {
    }

    public void onChangeStarting(RecyclerView.ViewHolder r10, boolean r11) {
    }

    public void onMoveFinished(RecyclerView.ViewHolder r10) {
    }

    public void onMoveStarting(RecyclerView.ViewHolder r10) {
    }

    public void onRemoveFinished(RecyclerView.ViewHolder r10) {
    }

    public void onRemoveStarting(RecyclerView.ViewHolder r10) {
    }

    public void setSupportsChangeAnimations(boolean r10) {
        this.mSupportsChangeAnimations = r10;
    }
}
