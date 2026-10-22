package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    ArrayList<RecyclerView.ViewHolder> mAddAnimations;
    ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList;
    ArrayList<RecyclerView.ViewHolder> mChangeAnimations;
    ArrayList<ArrayList<ChangeInfo>> mChangesList;
    ArrayList<RecyclerView.ViewHolder> mMoveAnimations;
    ArrayList<ArrayList<MoveInfo>> mMovesList;
    private ArrayList<RecyclerView.ViewHolder> mPendingAdditions;
    private ArrayList<ChangeInfo> mPendingChanges;
    private ArrayList<MoveInfo> mPendingMoves;
    private ArrayList<RecyclerView.ViewHolder> mPendingRemovals;
    ArrayList<RecyclerView.ViewHolder> mRemoveAnimations;

    private static class ChangeInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public int toX;
        public int toY;

        private ChangeInfo(RecyclerView.ViewHolder r10, RecyclerView.ViewHolder r11) {
            this.oldHolder = r10;
            this.newHolder = r11;
        }

        ChangeInfo(RecyclerView.ViewHolder r10, RecyclerView.ViewHolder r11, int r12, int r13, int r14, int r15) {
            this(r10, r11);
            this.fromX = r12;
            this.fromY = r13;
            this.toX = r14;
            this.toY = r15;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
        }
    }

    private static class MoveInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int toX;
        public int toY;

        MoveInfo(RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14) {
            this.holder = r10;
            this.fromX = r11;
            this.fromY = r12;
            this.toX = r13;
            this.toY = r14;
        }
    }

    public DefaultItemAnimator() {
        this.mPendingRemovals = new ArrayList();
        this.mPendingAdditions = new ArrayList();
        this.mPendingMoves = new ArrayList();
        this.mPendingChanges = new ArrayList();
        this.mAdditionsList = new ArrayList();
        this.mMovesList = new ArrayList();
        this.mChangesList = new ArrayList();
        this.mAddAnimations = new ArrayList();
        this.mMoveAnimations = new ArrayList();
        this.mRemoveAnimations = new ArrayList();
        this.mChangeAnimations = new ArrayList();
    }

    private void animateRemoveImpl(final RecyclerView.ViewHolder r10) {
        final View r11 = r10.itemView;
        final ViewPropertyAnimator r12 = r11.animate();
        this.mRemoveAnimations.add(r10);
        r12.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new AnonymousClass4(this, r10, r12, r11)).start();
    }

    private void endChangeAnimation(List<ChangeInfo> r10, RecyclerView.ViewHolder r11) {
        int r12 = r10.size() - 1;
    L3:
        if (r12 < 0) goto L12;
        ChangeInfo r13 = r10.get(r12);
        if (endChangeAnimationIfNecessary(r13, r11) == false) goto L11;
        if (r13.oldHolder != null) goto L11;
        if (r13.newHolder != null) goto L11;
        r10.remove(r13);
    L11:
        r12 = r12 - 1;
        goto L3
    }

    private void endChangeAnimationIfNecessary(ChangeInfo r10) {
        RecyclerView.ViewHolder r11 = r10.oldHolder;
        if (r11 == null) goto L5;
        endChangeAnimationIfNecessary(r10, r11);
    L5:
        RecyclerView.ViewHolder r12 = r10.newHolder;
        if (r12 == null) goto L9;
        endChangeAnimationIfNecessary(r10, r12);
        return;
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo r10, RecyclerView.ViewHolder r11) {
        boolean r12 = false;
        if (r10.newHolder != r11) goto L6;
        r10.newHolder = null;
    L8:
        r11.itemView.setAlpha(1.0f);
        r11.itemView.setTranslationX(0.0f);
        r11.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(r11, r12);
        return true;
    L6:
        if (r10.oldHolder != r11) goto L10;
        r10.oldHolder = null;
        r12 = true;
        goto L8
    L10:
        return false;
    }

    private void resetAnimation(RecyclerView.ViewHolder r10) {
        if (sDefaultInterpolator != null) goto L5;
        sDefaultInterpolator = new ValueAnimator().getInterpolator();
    L5:
        r10.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(r10);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder r10) {
        resetAnimation(r10);
        r10.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(r10);
        return true;
    }

    void animateAddImpl(final RecyclerView.ViewHolder r10) {
        final View r11 = r10.itemView;
        final ViewPropertyAnimator r12 = r11.animate();
        this.mAddAnimations.add(r10);
        r12.alpha(1.0f).setDuration(getAddDuration()).setListener(new AnonymousClass5(this, r10, r11, r12)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder r10, RecyclerView.ViewHolder r11, int r12, int r13, int r14, int r15) {
        if (r10 == r11) goto L4;
        float r16 = r10.itemView.getTranslationX();
        float r17 = r10.itemView.getTranslationY();
        float r18 = r10.itemView.getAlpha();
        resetAnimation(r10);
        int r19 = (int) ((r14 - r12) - r16);
        int r20 = (int) ((r15 - r13) - r17);
        r10.itemView.setTranslationX(r16);
        r10.itemView.setTranslationY(r17);
        r10.itemView.setAlpha(r18);
        if (r11 == null) goto L8;
        resetAnimation(r11);
        r11.itemView.setTranslationX(-r19);
        r11.itemView.setTranslationY(-r20);
        r11.itemView.setAlpha(0.0f);
    L8:
        this.mPendingChanges.add(new ChangeInfo(r10, r11, r12, r13, r14, r15));
        return true;
    L4:
        return animateMove(r10, r12, r13, r14, r15);
    }

    void animateChangeImpl(final ChangeInfo r10) {
        RecyclerView.ViewHolder r11 = r10.oldHolder;
        final View r12 = null;
        if (r11 != null) goto L5;
        final View r13 = null;
    L6:
        RecyclerView.ViewHolder r14 = r10.newHolder;
        if (r14 == null) goto L10;
        r12 = r14.itemView;
    L10:
        if (r13 == null) goto L12;
        final ViewPropertyAnimator r15 = r13.animate().setDuration(getChangeDuration());
        this.mChangeAnimations.add(r10.oldHolder);
        r15.translationX(r10.toX - r10.fromX);
        r15.translationY(r10.toY - r10.fromY);
        r15.alpha(0.0f).setListener(new AnonymousClass7(this, r10, r15, r13)).start();
    L12:
        if (r12 == null) goto L15;
        final ViewPropertyAnimator r16 = r12.animate();
        this.mChangeAnimations.add(r10.newHolder);
        r16.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnonymousClass8(this, r10, r16, r12)).start();
        return;
    L15:
        return;
    L5:
        r13 = r11.itemView;
        goto L6
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14) {
        View r15 = r10.itemView;
        int r16 = r11 + ((int) r15.getTranslationX());
        int r17 = r12 + ((int) r10.itemView.getTranslationY());
        resetAnimation(r10);
        int r18 = r13 - r16;
        int r19 = r14 - r17;
        if (r18 != 0) goto L7;
        if (r19 != 0) goto L7;
        dispatchMoveFinished(r10);
        return false;
    L7:
        if (r18 == 0) goto L9;
        r15.setTranslationX(-r18);
    L9:
        if (r19 == 0) goto L11;
        r15.setTranslationY(-r19);
    L11:
        this.mPendingMoves.add(new MoveInfo(r10, r16, r17, r13, r14));
        return true;
    }

    void animateMoveImpl(final RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14) {
        final View r15 = r10.itemView;
        final int r16 = r13 - r11;
        final int r17 = r14 - r12;
        if (r16 == 0) goto L5;
        r15.animate().translationX(0.0f);
    L5:
        if (r17 == 0) goto L7;
        r15.animate().translationY(0.0f);
    L7:
        final ViewPropertyAnimator r18 = r15.animate();
        this.mMoveAnimations.add(r10);
        r18.setDuration(getMoveDuration()).setListener(new AnonymousClass6(this, r10, r16, r15, r17, r18)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder r10) {
        resetAnimation(r10);
        this.mPendingRemovals.add(r10);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder r10, @NonNull List<Object> r11) {
        if (r11.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (super.canReuseUpdatedViewHolder(r10, r11) == true) goto L8;
        return false;
    }

    void cancelAll(List<RecyclerView.ViewHolder> r10) {
        int r11 = r10.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        r10.get(r11).itemView.animate().cancel();
        r11 = r11 - 1;
        goto L3
    }

    void dispatchFinishedWhenDone() {
        if (isRunning() == true) goto L6;
        dispatchAnimationsFinished();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder r10) {
        View r11 = r10.itemView;
        r11.animate().cancel();
        int r12 = this.mPendingMoves.size();
    L3:
        r12 = r12 - 1;
        if (r12 < 0) goto L9;
        if (this.mPendingMoves.get(r12).holder != r10) goto L3;
        r11.setTranslationY(0.0f);
        r11.setTranslationX(0.0f);
        dispatchMoveFinished(r10);
        this.mPendingMoves.remove(r12);
        goto L3
    L9:
        endChangeAnimation(this.mPendingChanges, r10);
        if (this.mPendingRemovals.remove(r10) == false) goto L13;
        r11.setAlpha(1.0f);
        dispatchRemoveFinished(r10);
    L13:
        if (this.mPendingAdditions.remove(r10) == false) goto L15;
        r11.setAlpha(1.0f);
        dispatchAddFinished(r10);
    L15:
        int r13 = this.mChangesList.size() - 1;
    L16:
        if (r13 < 0) goto L21;
        ArrayList<ChangeInfo> r14 = this.mChangesList.get(r13);
        endChangeAnimation(r14, r10);
        if (r14.isEmpty() == false) goto L20;
        this.mChangesList.remove(r13);
    L20:
        r13 = r13 - 1;
        goto L16
    L21:
        int r15 = this.mMovesList.size() - 1;
    L22:
        if (r15 < 0) goto L32;
        ArrayList<MoveInfo> r16 = this.mMovesList.get(r15);
        int r17 = r16.size() - 1;
    L24:
        if (r17 < 0) goto L31;
        if (r16.get(r17).holder == r10) goto L27;
        r17 = r17 - 1;
        goto L24
    L27:
        r11.setTranslationY(0.0f);
        r11.setTranslationX(0.0f);
        dispatchMoveFinished(r10);
        r16.remove(r17);
        if (r16.isEmpty() == false) goto L31;
        this.mMovesList.remove(r15);
    L31:
        r15 = r15 - 1;
        goto L22
    L32:
        int r18 = this.mAdditionsList.size() - 1;
    L33:
        if (r18 < 0) goto L40;
        ArrayList<RecyclerView.ViewHolder> r19 = this.mAdditionsList.get(r18);
        if (r19.remove(r10) == false) goto L39;
        r11.setAlpha(1.0f);
        dispatchAddFinished(r10);
        if (r19.isEmpty() == false) goto L39;
        this.mAdditionsList.remove(r18);
    L39:
        r18 = r18 - 1;
        goto L33
    L40:
        this.mRemoveAnimations.remove(r10);
        this.mAddAnimations.remove(r10);
        this.mChangeAnimations.remove(r10);
        this.mMoveAnimations.remove(r10);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int r10 = this.mPendingMoves.size();
    L3:
        r10 = r10 - 1;
        if (r10 < 0) goto L6;
        MoveInfo r11 = this.mPendingMoves.get(r10);
        View r12 = r11.holder.itemView;
        r12.setTranslationY(0.0f);
        r12.setTranslationX(0.0f);
        dispatchMoveFinished(r11.holder);
        this.mPendingMoves.remove(r10);
        goto L3
    L6:
        int r13 = this.mPendingRemovals.size() - 1;
    L7:
        if (r13 < 0) goto L9;
        dispatchRemoveFinished(this.mPendingRemovals.get(r13));
        this.mPendingRemovals.remove(r13);
        r13 = r13 - 1;
        goto L7
    L9:
        int r14 = this.mPendingAdditions.size();
    L10:
        r14 = r14 - 1;
        if (r14 < 0) goto L13;
        RecyclerView.ViewHolder r15 = this.mPendingAdditions.get(r14);
        r15.itemView.setAlpha(1.0f);
        dispatchAddFinished(r15);
        this.mPendingAdditions.remove(r14);
        goto L10
    L13:
        int r16 = this.mPendingChanges.size() - 1;
    L14:
        if (r16 < 0) goto L16;
        endChangeAnimationIfNecessary(this.mPendingChanges.get(r16));
        r16 = r16 - 1;
        goto L14
    L16:
        this.mPendingChanges.clear();
        if (isRunning() == true) goto L19;
        return;
    L19:
        int r17 = this.mMovesList.size() - 1;
    L20:
        if (r17 < 0) goto L28;
        ArrayList<MoveInfo> r18 = this.mMovesList.get(r17);
        int r19 = r18.size() - 1;
    L22:
        if (r19 < 0) goto L27;
        MoveInfo r20 = r18.get(r19);
        View r21 = r20.holder.itemView;
        r21.setTranslationY(0.0f);
        r21.setTranslationX(0.0f);
        dispatchMoveFinished(r20.holder);
        r18.remove(r19);
        if (r18.isEmpty() == false) goto L26;
        this.mMovesList.remove(r18);
    L26:
        r19 = r19 - 1;
        goto L22
    L27:
        r17 = r17 - 1;
        goto L20
    L28:
        int r22 = this.mAdditionsList.size() - 1;
    L29:
        if (r22 < 0) goto L37;
        ArrayList<RecyclerView.ViewHolder> r23 = this.mAdditionsList.get(r22);
        int r24 = r23.size() - 1;
    L31:
        if (r24 < 0) goto L36;
        RecyclerView.ViewHolder r25 = r23.get(r24);
        r25.itemView.setAlpha(1.0f);
        dispatchAddFinished(r25);
        r23.remove(r24);
        if (r23.isEmpty() == false) goto L35;
        this.mAdditionsList.remove(r23);
    L35:
        r24 = r24 - 1;
        goto L31
    L36:
        r22 = r22 - 1;
        goto L29
    L37:
        int r26 = this.mChangesList.size() - 1;
    L38:
        if (r26 < 0) goto L46;
        ArrayList<ChangeInfo> r27 = this.mChangesList.get(r26);
        int r28 = r27.size() - 1;
    L40:
        if (r28 < 0) goto L45;
        endChangeAnimationIfNecessary(r27.get(r28));
        if (r27.isEmpty() == false) goto L44;
        this.mChangesList.remove(r27);
    L44:
        r28 = r28 - 1;
        goto L40
    L45:
        r26 = r26 - 1;
        goto L38
    L46:
        cancelAll(this.mRemoveAnimations);
        cancelAll(this.mMoveAnimations);
        cancelAll(this.mAddAnimations);
        cancelAll(this.mChangeAnimations);
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if (this.mPendingAdditions.isEmpty() == true) goto L5;
    L26:
        return true;
    L5:
        if (this.mPendingChanges.isEmpty() == false) goto L26;
        if (this.mPendingMoves.isEmpty() == false) goto L26;
        if (this.mPendingRemovals.isEmpty() == false) goto L26;
        if (this.mMoveAnimations.isEmpty() == false) goto L26;
        if (this.mRemoveAnimations.isEmpty() == false) goto L26;
        if (this.mAddAnimations.isEmpty() == false) goto L26;
        if (this.mChangeAnimations.isEmpty() == false) goto L26;
        if (this.mMovesList.isEmpty() == false) goto L26;
        if (this.mAdditionsList.isEmpty() == false) goto L26;
        if (this.mChangesList.isEmpty() == false) goto L26;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean r10 = !this.mPendingRemovals.isEmpty();
        boolean r11 = !this.mPendingMoves.isEmpty();
        boolean r12 = !this.mPendingChanges.isEmpty();
        boolean r13 = !this.mPendingAdditions.isEmpty();
        if (r10 == true) goto L8;
        if (r11 == true) goto L8;
        if (r13 == true) goto L8;
        if (r12 == true) goto L8;
        return;
    L8:
        Iterator<RecyclerView.ViewHolder> r14 = this.mPendingRemovals.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        animateRemoveImpl(r14.next());
        goto L10
    L12:
        this.mPendingRemovals.clear();
        if (r11 == false) goto L18;
        final ArrayList<MoveInfo> r15 = new ArrayList();
        r15.addAll(this.mPendingMoves);
        this.mMovesList.add(r15);
        this.mPendingMoves.clear();
        Runnable r16 = new AnonymousClass1(this, r15);
        if (r10 == false) goto L17;
        ViewCompat.postOnAnimationDelayed(r15.get(0).holder.itemView, r16, getRemoveDuration());
        goto L18
    L17:
        r16.run();
    L18:
        if (r12 == false) goto L23;
        final ArrayList<ChangeInfo> r17 = new ArrayList();
        r17.addAll(this.mPendingChanges);
        this.mChangesList.add(r17);
        this.mPendingChanges.clear();
        Runnable r18 = new AnonymousClass2(this, r17);
        if (r10 == false) goto L22;
        ViewCompat.postOnAnimationDelayed(r17.get(0).oldHolder.itemView, r18, getRemoveDuration());
        goto L23
    L22:
        r18.run();
    L23:
        if (r13 == false) goto L42;
        final ArrayList<RecyclerView.ViewHolder> r19 = new ArrayList();
        r19.addAll(this.mPendingAdditions);
        this.mAdditionsList.add(r19);
        this.mPendingAdditions.clear();
        Runnable r20 = new AnonymousClass3(this, r19);
        if (r10 == true) goto L30;
        if (r11 == true) goto L30;
        if (r12 == true) goto L30;
        r20.run();
        return;
    L30:
        long r21 = 0;
        if (r10 == false) goto L33;
        long r22 = getRemoveDuration();
    L34:
        if (r11 == false) goto L36;
        long r23 = getMoveDuration();
    L37:
        if (r12 == false) goto L39;
        r21 = getChangeDuration();
    L39:
        ViewCompat.postOnAnimationDelayed(r19.get(0).itemView, r20, r22 + Math.max(r23, r21));
        return;
    L36:
        r23 = 0;
        goto L37
    L33:
        r22 = 0;
        goto L34
    }
}
