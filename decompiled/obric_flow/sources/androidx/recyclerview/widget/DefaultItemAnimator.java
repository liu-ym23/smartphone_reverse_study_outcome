package androidx.recyclerview.widget;

import ai.j0;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.base.SmoothInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    private static TimeInterpolator sVisibilityInterpolator;
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

    public static class ChangeInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public int toX;
        public int toY;

        private ChangeInfo(RecyclerView.ViewHolder r5, RecyclerView.ViewHolder r10) {
            this.oldHolder = r5;
            this.newHolder = r10;
        }

        @SuppressLint({"UnknownNullness"})
        public String toString() {
            StringBuilder r5 = new StringBuilder("ChangeInfo{oldHolder=");
            r5.append(this.oldHolder);
            r5.append(", newHolder=");
            r5.append(this.newHolder);
            r5.append(", fromX=");
            r5.append(this.fromX);
            r5.append(", fromY=");
            r5.append(this.fromY);
            r5.append(", toX=");
            r5.append(this.toX);
            r5.append(", toY=");
            return j0.n(r5, this.toY, '}');
        }

        public ChangeInfo(RecyclerView.ViewHolder r5, RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14) {
            this(r5, r10);
            this.fromX = r11;
            this.fromY = r12;
            this.toX = r13;
            this.toY = r14;
        }
    }

    public static class MoveInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int toX;
        public int toY;

        public MoveInfo(RecyclerView.ViewHolder r5, int r10, int r11, int r12, int r13) {
            this.holder = r5;
            this.fromX = r10;
            this.fromY = r11;
            this.toX = r12;
            this.toY = r13;
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

    public static /* synthetic */ TimeInterpolator access$000() {
        return sDefaultInterpolator;
    }

    private void animateRemoveImpl(final RecyclerView.ViewHolder r5) {
        final View r10 = r5.itemView;
        final ViewPropertyAnimator r11 = r10.animate();
        this.mRemoveAnimations.add(r5);
        r11.setDuration(getRemoveDuration()).alpha(0.0f).setInterpolator(sVisibilityInterpolator).setListener(new AnonymousClass4(this, r5, r10, r11)).start();
    }

    private void endChangeAnimation(List<ChangeInfo> r5, RecyclerView.ViewHolder r10) {
        int r11 = r5.size() - 1;
    L3:
        if (r11 < 0) goto L12;
        ChangeInfo r12 = r5.get(r11);
        if (endChangeAnimationIfNecessary(r12, r10) == false) goto L11;
        if (r12.oldHolder != null) goto L11;
        if (r12.newHolder != null) goto L11;
        r5.remove(r12);
    L11:
        r11 = r11 - 1;
        goto L3
    }

    private void endChangeAnimationIfNecessary(ChangeInfo r5) {
        RecyclerView.ViewHolder r10 = r5.oldHolder;
        if (r10 == null) goto L5;
        endChangeAnimationIfNecessary(r5, r10);
    L5:
        RecyclerView.ViewHolder r11 = r5.newHolder;
        if (r11 == null) goto L9;
        endChangeAnimationIfNecessary(r5, r11);
        return;
    }

    private void resetAnimation(RecyclerView.ViewHolder r5) {
        if (sDefaultInterpolator != null) goto L6;
        sDefaultInterpolator = new SmoothInterpolator();
    L6:
        if (sVisibilityInterpolator != null) goto L8;
        sVisibilityInterpolator = new LinearInterpolator();
    L8:
        r5.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(r5);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    @SuppressLint({"UnknownNullness"})
    public boolean animateAdd(RecyclerView.ViewHolder r5) {
        resetAnimation(r5);
        r5.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(r5);
        return true;
    }

    public void animateAddImpl(final RecyclerView.ViewHolder r10) {
        final View r5 = r10.itemView;
        final ViewPropertyAnimator r11 = r5.animate();
        this.mAddAnimations.add(r10);
        r11.alpha(1.0f).setDuration(getAddDuration()).setInterpolator(sVisibilityInterpolator).setListener(new AnonymousClass5(this, r10, r5, r11)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    @SuppressLint({"UnknownNullness"})
    public boolean animateChange(RecyclerView.ViewHolder r10, RecyclerView.ViewHolder r11, int r12, int r13, int r14, int r15) {
        if (r10 == r11) goto L4;
        float r5 = r10.itemView.getTranslationX();
        float r16 = r10.itemView.getTranslationY();
        float r17 = r10.itemView.getAlpha();
        resetAnimation(r10);
        int r18 = (int) ((r14 - r12) - r5);
        int r19 = (int) ((r15 - r13) - r16);
        r10.itemView.setTranslationX(r5);
        r10.itemView.setTranslationY(r16);
        r10.itemView.setAlpha(r17);
        if (r11 == null) goto L8;
        resetAnimation(r11);
        r11.itemView.setTranslationX(-r18);
        r11.itemView.setTranslationY(-r19);
        r11.itemView.setAlpha(0.0f);
    L8:
        this.mPendingChanges.add(new ChangeInfo(r10, r11, r12, r13, r14, r15));
        return true;
    L4:
        return animateMove(r10, r12, r13, r14, r15);
    }

    public void animateChangeImpl(final ChangeInfo r10) {
        RecyclerView.ViewHolder r5 = r10.oldHolder;
        final View r11 = null;
        if (r5 != null) goto L5;
        final View r12 = null;
    L6:
        RecyclerView.ViewHolder r13 = r10.newHolder;
        if (r13 == null) goto L10;
        r11 = r13.itemView;
    L10:
        if (r12 == null) goto L12;
        final ViewPropertyAnimator r14 = r12.animate().setDuration(getChangeDuration());
        this.mChangeAnimations.add(r10.oldHolder);
        r14.translationX(r10.toX - r10.fromX);
        r14.translationY(r10.toY - r10.fromY);
        r14.alpha(0.0f).setListener(new AnonymousClass7(this, r10, r14, r12)).start();
    L12:
        if (r11 == null) goto L15;
        final ViewPropertyAnimator r15 = r11.animate();
        this.mChangeAnimations.add(r10.newHolder);
        r15.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnonymousClass8(this, r10, r15, r11)).start();
        return;
    L15:
        return;
    L5:
        r12 = r5.itemView;
        goto L6
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    @SuppressLint({"UnknownNullness"})
    public boolean animateMove(RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14) {
        View r5 = r10.itemView;
        int r15 = r11 + ((int) r5.getTranslationX());
        int r16 = r12 + ((int) r10.itemView.getTranslationY());
        resetAnimation(r10);
        int r17 = r13 - r15;
        int r18 = r14 - r16;
        if (r17 != 0) goto L7;
        if (r18 != 0) goto L7;
        dispatchMoveFinished(r10);
        return false;
    L7:
        if (r17 == 0) goto L9;
        r5.setTranslationX(-r17);
    L9:
        if (r18 == 0) goto L11;
        r5.setTranslationY(-r18);
    L11:
        this.mPendingMoves.add(new MoveInfo(r10, r15, r16, r13, r14));
        return true;
    }

    public void animateMoveImpl(final RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14) {
        final View r5 = r10.itemView;
        final int r15 = r13 - r11;
        final int r16 = r14 - r12;
        if (r15 == 0) goto L5;
        r5.animate().translationX(0.0f);
    L5:
        if (r16 == 0) goto L7;
        r5.animate().translationY(0.0f);
    L7:
        final ViewPropertyAnimator r17 = r5.animate();
        this.mMoveAnimations.add(r10);
        r17.setDuration(getMoveDuration()).setListener(new AnonymousClass6(this, r10, r15, r5, r16, r17)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    @SuppressLint({"UnknownNullness"})
    public boolean animateRemove(RecyclerView.ViewHolder r5) {
        resetAnimation(r5);
        this.mPendingRemovals.add(r5);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder r5, @NonNull List<Object> r10) {
        if (r10.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (super.canReuseUpdatedViewHolder(r5, r10) == true) goto L8;
        return false;
    }

    public void cancelAll(List<RecyclerView.ViewHolder> r5) {
        int r10 = r5.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        r5.get(r10).itemView.animate().cancel();
        r10 = r10 - 1;
        goto L3
    }

    public void dispatchFinishedWhenDone() {
        if (isRunning() == true) goto L6;
        dispatchAnimationsFinished();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    @SuppressLint({"UnknownNullness"})
    public void endAnimation(RecyclerView.ViewHolder r10) {
        View r5 = r10.itemView;
        r5.animate().cancel();
        int r11 = this.mPendingMoves.size();
    L3:
        r11 = r11 - 1;
        if (r11 < 0) goto L9;
        if (this.mPendingMoves.get(r11).holder != r10) goto L3;
        r5.setTranslationY(0.0f);
        r5.setTranslationX(0.0f);
        dispatchMoveFinished(r10);
        this.mPendingMoves.remove(r11);
        goto L3
    L9:
        endChangeAnimation(this.mPendingChanges, r10);
        if (this.mPendingRemovals.remove(r10) == false) goto L13;
        r5.setAlpha(1.0f);
        dispatchRemoveFinished(r10);
    L13:
        if (this.mPendingAdditions.remove(r10) == false) goto L15;
        r5.setAlpha(1.0f);
        dispatchAddFinished(r10);
    L15:
        int r12 = this.mChangesList.size() - 1;
    L16:
        if (r12 < 0) goto L21;
        ArrayList<ChangeInfo> r13 = this.mChangesList.get(r12);
        endChangeAnimation(r13, r10);
        if (r13.isEmpty() == false) goto L20;
        this.mChangesList.remove(r12);
    L20:
        r12 = r12 - 1;
        goto L16
    L21:
        int r14 = this.mMovesList.size() - 1;
    L22:
        if (r14 < 0) goto L32;
        ArrayList<MoveInfo> r15 = this.mMovesList.get(r14);
        int r16 = r15.size() - 1;
    L24:
        if (r16 < 0) goto L31;
        if (r15.get(r16).holder == r10) goto L27;
        r16 = r16 - 1;
        goto L24
    L27:
        r5.setTranslationY(0.0f);
        r5.setTranslationX(0.0f);
        dispatchMoveFinished(r10);
        r15.remove(r16);
        if (r15.isEmpty() == false) goto L31;
        this.mMovesList.remove(r14);
    L31:
        r14 = r14 - 1;
        goto L22
    L32:
        int r17 = this.mAdditionsList.size() - 1;
    L33:
        if (r17 < 0) goto L40;
        ArrayList<RecyclerView.ViewHolder> r18 = this.mAdditionsList.get(r17);
        if (r18.remove(r10) == false) goto L39;
        r5.setAlpha(1.0f);
        dispatchAddFinished(r10);
        if (r18.isEmpty() == false) goto L39;
        this.mAdditionsList.remove(r17);
    L39:
        r17 = r17 - 1;
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
        int r5 = this.mPendingMoves.size();
    L3:
        r5 = r5 - 1;
        if (r5 < 0) goto L6;
        MoveInfo r10 = this.mPendingMoves.get(r5);
        View r11 = r10.holder.itemView;
        r11.setTranslationY(0.0f);
        r11.setTranslationX(0.0f);
        dispatchMoveFinished(r10.holder);
        this.mPendingMoves.remove(r5);
        goto L3
    L6:
        int r12 = this.mPendingRemovals.size() - 1;
    L7:
        if (r12 < 0) goto L9;
        dispatchRemoveFinished(this.mPendingRemovals.get(r12));
        this.mPendingRemovals.remove(r12);
        r12 = r12 - 1;
        goto L7
    L9:
        int r13 = this.mPendingAdditions.size();
    L10:
        r13 = r13 - 1;
        if (r13 < 0) goto L13;
        RecyclerView.ViewHolder r14 = this.mPendingAdditions.get(r13);
        r14.itemView.setAlpha(1.0f);
        dispatchAddFinished(r14);
        this.mPendingAdditions.remove(r13);
        goto L10
    L13:
        int r15 = this.mPendingChanges.size() - 1;
    L14:
        if (r15 < 0) goto L16;
        endChangeAnimationIfNecessary(this.mPendingChanges.get(r15));
        r15 = r15 - 1;
        goto L14
    L16:
        this.mPendingChanges.clear();
        if (isRunning() == true) goto L19;
        return;
    L19:
        int r16 = this.mMovesList.size() - 1;
    L20:
        if (r16 < 0) goto L28;
        ArrayList<MoveInfo> r17 = this.mMovesList.get(r16);
        int r18 = r17.size() - 1;
    L22:
        if (r18 < 0) goto L27;
        MoveInfo r19 = r17.get(r18);
        View r20 = r19.holder.itemView;
        r20.setTranslationY(0.0f);
        r20.setTranslationX(0.0f);
        dispatchMoveFinished(r19.holder);
        r17.remove(r18);
        if (r17.isEmpty() == false) goto L26;
        this.mMovesList.remove(r17);
    L26:
        r18 = r18 - 1;
        goto L22
    L27:
        r16 = r16 - 1;
        goto L20
    L28:
        int r21 = this.mAdditionsList.size() - 1;
    L29:
        if (r21 < 0) goto L37;
        ArrayList<RecyclerView.ViewHolder> r22 = this.mAdditionsList.get(r21);
        int r23 = r22.size() - 1;
    L31:
        if (r23 < 0) goto L36;
        RecyclerView.ViewHolder r24 = r22.get(r23);
        r24.itemView.setAlpha(1.0f);
        dispatchAddFinished(r24);
        r22.remove(r23);
        if (r22.isEmpty() == false) goto L35;
        this.mAdditionsList.remove(r22);
    L35:
        r23 = r23 - 1;
        goto L31
    L36:
        r21 = r21 - 1;
        goto L29
    L37:
        int r25 = this.mChangesList.size() - 1;
    L38:
        if (r25 < 0) goto L46;
        ArrayList<ChangeInfo> r26 = this.mChangesList.get(r25);
        int r27 = r26.size() - 1;
    L40:
        if (r27 < 0) goto L45;
        endChangeAnimationIfNecessary(r26.get(r27));
        if (r26.isEmpty() == false) goto L44;
        this.mChangesList.remove(r26);
    L44:
        r27 = r27 - 1;
        goto L40
    L45:
        r25 = r25 - 1;
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
        boolean r5 = this.mPendingRemovals.isEmpty();
        boolean r10 = this.mPendingMoves.isEmpty();
        boolean r11 = this.mPendingChanges.isEmpty();
        boolean r12 = this.mPendingAdditions.isEmpty();
        if (r5 == false) goto L8;
        if (r10 == false) goto L8;
        if (r12 == false) goto L8;
        if (r11 == false) goto L8;
        return;
    L8:
        Iterator<RecyclerView.ViewHolder> r13 = this.mPendingRemovals.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        animateRemoveImpl(r13.next());
        goto L10
    L12:
        this.mPendingRemovals.clear();
        if (r10 == true) goto L18;
        final ArrayList<MoveInfo> r14 = new ArrayList();
        r14.addAll(this.mPendingMoves);
        this.mMovesList.add(r14);
        this.mPendingMoves.clear();
        Runnable r15 = new AnonymousClass1(this, r14);
        if (r5 == true) goto L17;
        ViewCompat.postOnAnimationDelayed(r14.get(0).holder.itemView, r15, getRemoveDuration());
        goto L18
    L17:
        r15.run();
    L18:
        if (r11 == true) goto L23;
        final ArrayList<ChangeInfo> r16 = new ArrayList();
        r16.addAll(this.mPendingChanges);
        this.mChangesList.add(r16);
        this.mPendingChanges.clear();
        Runnable r17 = new AnonymousClass2(this, r16);
        if (r5 == true) goto L22;
        ViewCompat.postOnAnimationDelayed(r16.get(0).oldHolder.itemView, r17, getRemoveDuration());
        goto L23
    L22:
        r17.run();
    L23:
        if (r12 == true) goto L42;
        final ArrayList<RecyclerView.ViewHolder> r18 = new ArrayList();
        r18.addAll(this.mPendingAdditions);
        this.mAdditionsList.add(r18);
        this.mPendingAdditions.clear();
        Runnable r19 = new AnonymousClass3(this, r18);
        if (r5 == false) goto L30;
        if (r10 == false) goto L30;
        if (r11 == false) goto L30;
        r19.run();
        return;
    L30:
        long r20 = 0;
        if (r5 == true) goto L33;
        long r21 = getRemoveDuration();
    L34:
        if (r10 == true) goto L36;
        long r22 = getMoveDuration();
    L37:
        if (r11 == true) goto L39;
        r20 = getChangeDuration();
    L39:
        ViewCompat.postOnAnimationDelayed(r18.get(0).itemView, r19, Math.max(r22, r20) + r21);
        return;
    L36:
        r22 = 0;
        goto L37
    L33:
        r21 = 0;
        goto L34
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo r5, RecyclerView.ViewHolder r10) {
        boolean r11 = false;
        if (r5.newHolder != r10) goto L6;
        r5.newHolder = null;
    L8:
        r10.itemView.setAlpha(1.0f);
        r10.itemView.setTranslationX(0.0f);
        r10.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(r10, r11);
        return true;
    L6:
        if (r5.oldHolder != r10) goto L10;
        r5.oldHolder = null;
        r11 = true;
        goto L8
    L10:
        return false;
    }
}
