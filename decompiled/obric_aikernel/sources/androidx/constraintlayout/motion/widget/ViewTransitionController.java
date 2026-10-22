package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ViewTransitionController {
    private String TAG;
    ArrayList<ViewTransition.Animate> animations;
    private final MotionLayout mMotionLayout;
    private HashSet<View> mRelatedViews;
    ArrayList<ViewTransition.Animate> removeList;
    private ArrayList<ViewTransition> viewTransitions;

    public ViewTransitionController(MotionLayout r10) {
        this.viewTransitions = new ArrayList();
        this.TAG = "ViewTransitionController";
        this.removeList = new ArrayList();
        this.mMotionLayout = r10;
    }

    static /* synthetic */ MotionLayout access$000(ViewTransitionController r10) {
        return r10.mMotionLayout;
    }

    private void listenForSharedVariable(final ViewTransition r10, final boolean r11) {
        final int r12 = r10.getSharedValueID();
        final int r13 = r10.getSharedValue();
        ConstraintLayout.getSharedValues().addListener(r10.getSharedValueID(), new AnonymousClass1(this, r10, r12, r11, r13));
    }

    private void viewTransition(ViewTransition r10, View... r11) {
        int r12 = this.mMotionLayout.getCurrentState();
        if (r10.mViewTransitionMode != 2) goto L5;
        r10.applyTransition(this, this.mMotionLayout, r12, null, r11);
        return;
    L5:
        if (r12 != (-1)) goto L8;
        Log.w(this.TAG, "No support for ViewTransition within transition yet. Currently: " + this.mMotionLayout.toString());
        return;
    L8:
        ConstraintSet r13 = this.mMotionLayout.getConstraintSet(r12);
        if (r13 != null) goto L11;
        return;
    L11:
        r10.applyTransition(this, this.mMotionLayout, r12, r13, r11);
    }

    public void add(ViewTransition r10) {
        this.viewTransitions.add(r10);
        this.mRelatedViews = null;
        if (r10.getStateTransition() != 4) goto L7;
        boolean r11 = true;
    L5:
        listenForSharedVariable(r10, r11);
        return;
    L7:
        if (r10.getStateTransition() != 5) goto L10;
        r11 = false;
        goto L5
    }

    void addAnimation(ViewTransition.Animate r10) {
        if (this.animations != null) goto L5;
        this.animations = new ArrayList();
    L5:
        this.animations.add(r10);
    }

    void animate() {
        ArrayList<ViewTransition.Animate> r10 = this.animations;
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator<ViewTransition.Animate> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r11.next().mutate();
        goto L7
    L9:
        this.animations.removeAll(this.removeList);
        this.removeList.clear();
        if (this.animations.isEmpty() == false) goto L14;
        this.animations = null;
        return;
    }

    boolean applyViewTransition(int r10, MotionController r11) {
        Iterator<ViewTransition> r12 = this.viewTransitions.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        ViewTransition r13 = r12.next();
        if (r13.getId() != r10) goto L4;
        r13.mKeyFrames.addAllFrames(r11);
        return true;
    L9:
        return false;
    }

    void enableViewTransition(int r10, boolean r11) {
        Iterator<ViewTransition> r12 = this.viewTransitions.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        ViewTransition r13 = r12.next();
        if (r13.getId() != r10) goto L4;
        r13.setEnabled(r11);
        return;
    }

    void invalidate() {
        this.mMotionLayout.invalidate();
    }

    boolean isViewTransitionEnabled(int r10) {
        Iterator<ViewTransition> r11 = this.viewTransitions.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        ViewTransition r12 = r11.next();
        if (r12.getId() != r10) goto L4;
        return r12.isEnabled();
    L9:
        return false;
    }

    void remove(int r10) {
        Iterator<ViewTransition> r11 = this.viewTransitions.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ViewTransition r12 = r11.next();
        if (r12.getId() != r10) goto L4;
    L9:
        if (r12 == null) goto L15;
        this.mRelatedViews = null;
        this.viewTransitions.remove(r12);
        return;
    L15:
        return;
    L8:
        r12 = null;
        goto L9
    }

    void removeAnimation(ViewTransition.Animate r10) {
        this.removeList.add(r10);
    }

    void touchEvent(MotionEvent r20) {
        int r10 = this.mMotionLayout.getCurrentState();
        if (r10 != (-1)) goto L6;
        return;
    L6:
        if (this.mRelatedViews != null) goto L16;
        this.mRelatedViews = new HashSet();
        Iterator<ViewTransition> r11 = this.viewTransitions.iterator();
    L9:
        if (r11.hasNext() == false) goto L16;
        ViewTransition r12 = r11.next();
        int r13 = this.mMotionLayout.getChildCount();
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L9;
        View r15 = this.mMotionLayout.getChildAt(r14);
        if (r12.matchesView(r15) == false) goto L15;
        r15.getId();
        this.mRelatedViews.add(r15);
    L15:
        r14 = r14 + 1;
    L16:
        float r16 = r20.getX();
        float r17 = r20.getY();
        Rect r18 = new Rect();
        int r19 = r20.getAction();
        ArrayList<ViewTransition.Animate> r21 = this.animations;
        if (r21 == null) goto L25;
        if (r21.isEmpty() == true) goto L25;
        Iterator<ViewTransition.Animate> r22 = this.animations.iterator();
    L22:
        if (r22.hasNext() == false) goto L25;
        r22.next().reactTo(r19, r16, r17);
    L25:
        if (r19 == 0) goto L28;
        if (r19 == 1) goto L28;
        return;
    L28:
        ConstraintSet r110 = this.mMotionLayout.getConstraintSet(r10);
        Iterator<ViewTransition> r111 = this.viewTransitions.iterator();
    L30:
        if (r111.hasNext() == false) goto L59;
        ViewTransition r23 = r111.next();
        if (r23.supports(r19) == false) goto L30;
        Iterator<View> r112 = this.mRelatedViews.iterator();
    L35:
        if (r112.hasNext() == false) goto L30;
        View r24 = r112.next();
        if (r23.matchesView(r24) == false) goto L35;
        r24.getHitRect(r18);
        if (r18.contains((int) r16, (int) r17) == false) goto L43;
        r23.applyTransition(this, this.mMotionLayout, r10, r110, new View[]{r24});
    L43:
        r23 = r23;
        goto L35
    }

    void viewTransition(int r10, View... r11) {
        ArrayList r12 = new ArrayList();
        Iterator<ViewTransition> r13 = this.viewTransitions.iterator();
        ViewTransition r14 = null;
    L4:
        if (r13.hasNext() == false) goto L17;
        ViewTransition r15 = r13.next();
        if (r15.getId() != r10) goto L4;
        int r16 = r11.length;
        int r17 = 0;
    L8:
        if (r17 >= r16) goto L14;
        View r18 = r11[r17];
        if (r15.checkTags(r18) == false) goto L12;
        r12.add(r18);
    L12:
        r17 = r17 + 1;
        goto L8
    L14:
        if (r12.isEmpty() == true) goto L16;
        viewTransition(r15, (View[]) r12.toArray(new View[0]));
        r12.clear();
    L16:
        r14 = r15;
        goto L4
    L17:
        if (r14 != null) goto L28;
        Log.e(this.TAG, " Could not find ViewTransition");
        return;
    }
}
