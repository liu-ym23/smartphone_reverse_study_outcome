package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public ViewTransitionController(MotionLayout r2) {
        this.viewTransitions = new ArrayList();
        this.TAG = "ViewTransitionController";
        this.removeList = new ArrayList();
        this.mMotionLayout = r2;
    }

    static /* synthetic */ MotionLayout access$000(ViewTransitionController r0) {
        return r0.mMotionLayout;
    }

    private void listenForSharedVariable(final ViewTransition r10, final boolean r11) {
        final int r3 = r10.getSharedValueID();
        final int r5 = r10.getSharedValue();
        ConstraintLayout.getSharedValues().addListener(r10.getSharedValueID(), new AnonymousClass1(this, r10, r3, r11, r5));
    }

    private void viewTransition(ViewTransition r8, View... r9) {
        int r4 = this.mMotionLayout.getCurrentState();
        if (r8.mViewTransitionMode != 2) goto L5;
        r8.applyTransition(this, this.mMotionLayout, r4, null, r9);
        return;
    L5:
        if (r4 != (-1)) goto L8;
        Log.w(this.TAG, "No support for ViewTransition within transition yet. Currently: " + this.mMotionLayout.toString());
        return;
    L8:
        ConstraintSet r5 = this.mMotionLayout.getConstraintSet(r4);
        if (r5 != null) goto L11;
        return;
    L11:
        r8.applyTransition(this, this.mMotionLayout, r4, r5, r9);
    }

    public void add(ViewTransition r3) {
        this.viewTransitions.add(r3);
        this.mRelatedViews = null;
        if (r3.getStateTransition() != 4) goto L7;
        boolean r0 = true;
    L5:
        listenForSharedVariable(r3, r0);
        return;
    L7:
        if (r3.getStateTransition() != 5) goto L10;
        r0 = false;
        goto L5
    }

    void addAnimation(ViewTransition.Animate r2) {
        if (this.animations != null) goto L5;
        this.animations = new ArrayList();
    L5:
        this.animations.add(r2);
    }

    void animate() {
        ArrayList<ViewTransition.Animate> r0 = this.animations;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<ViewTransition.Animate> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((ViewTransition.Animate) ZeusTransformUtils.preCheckCast(r1.next(), ViewTransition.Animate.class, "com.obric.memorydata.plugin")).mutate();
        goto L7
    L9:
        this.animations.removeAll(this.removeList);
        this.removeList.clear();
        if (this.animations.isEmpty() == false) goto L14;
        this.animations = null;
        return;
    }

    boolean applyViewTransition(int r4, MotionController r5) {
        Iterator<ViewTransition> r3 = this.viewTransitions.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        ViewTransition r0 = (ViewTransition) ZeusTransformUtils.preCheckCast(r3.next(), ViewTransition.class, "com.obric.memorydata.plugin");
        if (r0.getId() != r4) goto L4;
        r0.mKeyFrames.addAllFrames(r5);
        return true;
    L9:
        return false;
    }

    void enableViewTransition(int r4, boolean r5) {
        Iterator<ViewTransition> r3 = this.viewTransitions.iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        ViewTransition r0 = (ViewTransition) ZeusTransformUtils.preCheckCast(r3.next(), ViewTransition.class, "com.obric.memorydata.plugin");
        if (r0.getId() != r4) goto L4;
        r0.setEnabled(r5);
        return;
    }

    void invalidate() {
        this.mMotionLayout.invalidate();
    }

    boolean isViewTransitionEnabled(int r4) {
        Iterator<ViewTransition> r3 = this.viewTransitions.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        ViewTransition r0 = (ViewTransition) ZeusTransformUtils.preCheckCast(r3.next(), ViewTransition.class, "com.obric.memorydata.plugin");
        if (r0.getId() != r4) goto L4;
        return r0.isEnabled();
    L9:
        return false;
    }

    void remove(int r6) {
        Iterator<ViewTransition> r0 = this.viewTransitions.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ViewTransition r1 = (ViewTransition) ZeusTransformUtils.preCheckCast(r0.next(), ViewTransition.class, "com.obric.memorydata.plugin");
        if (r1.getId() != r6) goto L4;
    L9:
        if (r1 == null) goto L15;
        this.mRelatedViews = null;
        this.viewTransitions.remove(r1);
        return;
    L15:
        return;
    L8:
        r1 = null;
        goto L9
    }

    void removeAnimation(ViewTransition.Animate r1) {
        this.removeList.add(r1);
    }

    void touchEvent(MotionEvent r21) {
        int r7 = this.mMotionLayout.getCurrentState();
        if (r7 != (-1)) goto L6;
        return;
    L6:
        if (this.mRelatedViews != null) goto L16;
        this.mRelatedViews = new HashSet();
        Iterator<ViewTransition> r0 = this.viewTransitions.iterator();
    L9:
        if (r0.hasNext() == false) goto L16;
        ViewTransition r1 = (ViewTransition) ZeusTransformUtils.preCheckCast(r0.next(), ViewTransition.class, "com.obric.memorydata.plugin");
        int r2 = this.mMotionLayout.getChildCount();
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L9;
        View r4 = this.mMotionLayout.getChildAt(r3);
        if (r1.matchesView(r4) == false) goto L15;
        r4.getId();
        this.mRelatedViews.add(r4);
    L15:
        r3 = r3 + 1;
    L16:
        float r10 = r21.getX();
        float r11 = r21.getY();
        Rect r12 = new Rect();
        int r13 = r21.getAction();
        ArrayList<ViewTransition.Animate> r5 = this.animations;
        if (r5 == null) goto L25;
        if (r5.isEmpty() == true) goto L25;
        Iterator<ViewTransition.Animate> r6 = this.animations.iterator();
    L22:
        if (r6.hasNext() == false) goto L25;
        ((ViewTransition.Animate) ZeusTransformUtils.preCheckCast(r6.next(), ViewTransition.Animate.class, "com.obric.memorydata.plugin")).reactTo(r13, r10, r11);
    L25:
        if (r13 == 0) goto L28;
        if (r13 == 1) goto L28;
        return;
    L28:
        ConstraintSet r15 = this.mMotionLayout.getConstraintSet(r7);
        Iterator<ViewTransition> r16 = this.viewTransitions.iterator();
    L30:
        if (r16.hasNext() == false) goto L59;
        ViewTransition r8 = (ViewTransition) ZeusTransformUtils.preCheckCast(r16.next(), ViewTransition.class, "com.obric.memorydata.plugin");
        if (r8.supports(r13) == false) goto L30;
        Iterator<View> r17 = this.mRelatedViews.iterator();
    L35:
        if (r17.hasNext() == false) goto L30;
        View r9 = (View) ZeusTransformUtils.preCheckCast(r17.next(), View.class, "com.obric.memorydata.plugin");
        if (r8.matchesView(r9) == false) goto L35;
        r9.getHitRect(r12);
        if (r12.contains((int) r10, (int) r11) == false) goto L43;
        r8.applyTransition(this, this.mMotionLayout, r7, r15, new View[]{r9});
    L43:
        r8 = r8;
        goto L35
    }

    void viewTransition(int r10, View... r11) {
        ArrayList r0 = new ArrayList();
        Iterator<ViewTransition> r1 = this.viewTransitions.iterator();
        ViewTransition r2 = null;
    L4:
        if (r1.hasNext() == false) goto L17;
        ViewTransition r3 = (ViewTransition) ZeusTransformUtils.preCheckCast(r1.next(), ViewTransition.class, "com.obric.memorydata.plugin");
        if (r3.getId() != r10) goto L4;
        int r4 = r11.length;
        int r6 = 0;
    L8:
        if (r6 >= r4) goto L14;
        View r7 = r11[r6];
        if (r3.checkTags(r7) == false) goto L12;
        r0.add(r7);
    L12:
        r6 = r6 + 1;
        goto L8
    L14:
        if (r0.isEmpty() == true) goto L16;
        viewTransition(r3, (View[]) ZeusTransformUtils.preCheckCast(r0.toArray(new View[0]), View[].class, "com.obric.memorydata.plugin"));
        r0.clear();
    L16:
        r2 = r3;
        goto L4
    L17:
        if (r2 != null) goto L28;
        Log.e(this.TAG, " Could not find ViewTransition");
        return;
    }
}
