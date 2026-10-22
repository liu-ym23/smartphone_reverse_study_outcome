package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class DesignTool implements ProxyInterface {
    private static final boolean DEBUG = false;
    private static final String TAG = "DesignTool";
    static final HashMap<Pair<Integer, Integer>, String> allAttributes = null;
    static final HashMap<String, String> allMargins = null;
    private String mLastEndState;
    private int mLastEndStateId;
    private String mLastStartState;
    private int mLastStartStateId;
    private final MotionLayout mMotionLayout;
    private MotionScene mSceneCache;

    static {
        HashMap<Pair<Integer, Integer>, String> r10 = new HashMap();
        allAttributes = r10;
        HashMap<String, String> r11 = new HashMap();
        allMargins = r11;
        r10.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        r10.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        r10.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        r10.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        r10.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        r10.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        r10.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        r10.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        r10.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        r10.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        r10.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        r10.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        r10.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        r11.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        r11.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        r11.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        r11.put("layout_constraintTop_toTopOf", "layout_marginTop");
        r11.put("layout_constraintStart_toStartOf", "layout_marginStart");
        r11.put("layout_constraintStart_toEndOf", "layout_marginStart");
        r11.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        r11.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        r11.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        r11.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        r11.put("layout_constraintRight_toRightOf", "layout_marginRight");
        r11.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout r10) {
        this.mLastStartState = null;
        this.mLastEndState = null;
        this.mLastStartStateId = -1;
        this.mLastEndStateId = -1;
        this.mMotionLayout = r10;
    }

    private static void Connect(int r10, ConstraintSet r11, View r12, HashMap<String, String> r13, int r14, int r15) {
        String r16 = allAttributes.get(Pair.create(Integer.valueOf(r14), Integer.valueOf(r15)));
        String r17 = r13.get(r16);
        if (r17 == null) goto L9;
        int r18 = 0;
        String r19 = allMargins.get(r16);
        if (r19 == null) goto L7;
        r18 = GetPxFromDp(r10, r13.get(r19));
    L7:
        int r20 = Integer.parseInt(r17);
        int r21 = r12.getId();
        r11.connect(r21, r14, r20, r15, r18);
        return;
    }

    private static int GetPxFromDp(int r10, String r11) {
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r12 = r11.indexOf(100);
        if (r12 != (-1)) goto L9;
        return 0;
    L9:
        return (int) ((Integer.valueOf(r11.substring(0, r12)).intValue() * r10) / 160.0f);
    }

    private static void SetAbsolutePositions(int r10, ConstraintSet r11, View r12, HashMap<String, String> r13) {
        String r14 = r13.get("layout_editor_absoluteX");
        if (r14 == null) goto L5;
        r11.setEditorAbsoluteX(r12.getId(), GetPxFromDp(r10, r14));
    L5:
        String r15 = r13.get("layout_editor_absoluteY");
        if (r15 == null) goto L9;
        r11.setEditorAbsoluteY(r12.getId(), GetPxFromDp(r10, r15));
        return;
    }

    private static void SetBias(ConstraintSet r10, View r11, HashMap<String, String> r12, int r13) {
        if (r13 != 1) goto L5;
        String r14 = "layout_constraintVertical_bias";
    L6:
        String r15 = r12.get(r14);
        if (r15 == null) goto L13;
        if (r13 != 0) goto L10;
        r10.setHorizontalBias(r11.getId(), Float.parseFloat(r15));
        return;
    L10:
        if (r13 != 1) goto L15;
        r10.setVerticalBias(r11.getId(), Float.parseFloat(r15));
        return;
    L15:
        return;
    L13:
        return;
    L5:
        r14 = "layout_constraintHorizontal_bias";
        goto L6
    }

    private static void SetDimensions(int r10, ConstraintSet r11, View r12, HashMap<String, String> r13, int r14) {
        if (r14 != 1) goto L5;
        String r15 = "layout_height";
    L6:
        String r16 = r13.get(r15);
        if (r16 == null) goto L16;
        int r17 = -2;
        if (r16.equalsIgnoreCase("wrap_content") == true) goto L11;
        r17 = GetPxFromDp(r10, r16);
    L11:
        int r18 = r12.getId();
        if (r14 != 0) goto L14;
        r11.constrainWidth(r18, r17);
        return;
    L14:
        r11.constrainHeight(r18, r17);
        return;
    L16:
        return;
    L5:
        r15 = "layout_width";
        goto L6
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int r10, String r11, Object r12, float[] r13, int r14, float[] r15, int r16) {
        View r17 = (View) r12;
        if (r10 == 0) goto L11;
        MotionLayout r18 = this.mMotionLayout;
        if (r18.mScene != null) goto L7;
        return -1;
    L7:
        if (r17 == null) goto L10;
        MotionController r19 = r18.mFrameArrayList.get(r17);
        if (r19 == null) goto L10;
    L13:
        if (r10 == 0) goto L26;
        if (r10 != 1) goto L16;
        int r20 = this.mMotionLayout.mScene.getDuration() / 16;
        r19.buildPath(r15, r20);
        return r20;
    L16:
        if (r10 != 2) goto L18;
        int r21 = this.mMotionLayout.mScene.getDuration() / 16;
        r19.buildKeyFrames(r15, null);
        return r21;
    L18:
        if (r10 == 3) goto L20;
        return -1;
    L20:
        int r22 = this.mMotionLayout.mScene.getDuration() / 16;
        return r19.getAttributeValues(r11, r15, r16);
    L26:
        return 1;
    L10:
        return -1;
    L11:
        r19 = null;
        goto L13
    }

    public void disableAutoTransition(boolean r10) {
        this.mMotionLayout.disableAutoTransition(r10);
    }

    public void dumpConstraintSet(String r10) {
        MotionLayout r11 = this.mMotionLayout;
        if (r11.mScene != null) goto L5;
        r11.mScene = this.mSceneCache;
    L5:
        int r12 = r11.lookUpConstraintId(r10);
        System.out.println(" dumping  " + r10 + " (" + r12 + ")");
        this.mMotionLayout.mScene.getConstraintSet(r12).dump(this.mMotionLayout.mScene, new int[0]);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public int getAnimationKeyFrames(Object r10, float[] r11) {
        MotionScene r12 = this.mMotionLayout.mScene;
        if (r12 != null) goto L6;
        return -1;
    L6:
        int r13 = r12.getDuration() / 16;
        MotionController r14 = this.mMotionLayout.mFrameArrayList.get(r10);
        if (r14 != null) goto L10;
        return 0;
    L10:
        r14.buildKeyFrames(r11, null);
        return r13;
    }

    public int getAnimationPath(Object r10, float[] r11, int r12) {
        MotionLayout r13 = this.mMotionLayout;
        if (r13.mScene != null) goto L6;
        return -1;
    L6:
        MotionController r14 = r13.mFrameArrayList.get(r10);
        if (r14 != null) goto L10;
        return 0;
    L10:
        r14.buildPath(r11, r12);
        return r12;
    }

    public void getAnimationRectangles(Object r10, float[] r11) {
        MotionScene r12 = this.mMotionLayout.mScene;
        if (r12 != null) goto L5;
        return;
    L5:
        int r13 = r12.getDuration() / 16;
        MotionController r14 = this.mMotionLayout.mFrameArrayList.get(r10);
        if (r14 != null) goto L8;
        return;
    L8:
        r14.buildRectangles(r11, r13);
    }

    public String getEndState() {
        int r10 = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == r10) goto L5;
        String r11 = this.mMotionLayout.getConstraintSetNames(r10);
        if (r11 == null) goto L9;
        this.mLastEndState = r11;
        this.mLastEndStateId = r10;
    L9:
        return r11;
    L5:
        return this.mLastEndState;
    }

    public int getKeyFrameInfo(Object r10, int r11, int[] r12) {
        MotionController r13 = this.mMotionLayout.mFrameArrayList.get((View) r10);
        if (r13 != null) goto L7;
        return 0;
    L7:
        return r13.getKeyFrameInfo(r11, r12);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(Object r10, int r11, float r12, float r13) {
        if ((r10 instanceof View) == true) goto L5;
        return 0.0f;
    L5:
        MotionController r14 = this.mMotionLayout.mFrameArrayList.get((View) r10);
        if (r14 != null) goto L9;
        return 0.0f;
    L9:
        return r14.getKeyFrameParameter(r11, r12, r13);
    }

    public int getKeyFramePositions(Object r10, int[] r11, float[] r12) {
        MotionController r13 = this.mMotionLayout.mFrameArrayList.get((View) r10);
        if (r13 != null) goto L7;
        return 0;
    L7:
        return r13.getKeyFramePositions(r11, r12);
    }

    public Object getKeyframe(int r10, int r11, int r12) {
        MotionLayout r13 = this.mMotionLayout;
        MotionScene r14 = r13.mScene;
        if (r14 != null) goto L7;
        return null;
    L7:
        return r14.getKeyFrame(r13.getContext(), r10, r11, r12);
    }

    public Object getKeyframe(Object r10, int r11, int r12) {
        if (this.mMotionLayout.mScene != null) goto L6;
        return null;
    L6:
        int r13 = ((View) r10).getId();
        MotionLayout r14 = this.mMotionLayout;
        return r14.mScene.getKeyFrame(r14.getContext(), r11, r13, r12);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Object getKeyframeAtLocation(Object r10, float r11, float r12) {
        View r13 = (View) r10;
        MotionLayout r14 = this.mMotionLayout;
        if (r14.mScene != null) goto L7;
        return -1;
    L7:
        if (r13 == null) goto L13;
        MotionController r15 = r14.mFrameArrayList.get(r13);
        if (r15 != null) goto L11;
        return null;
    L11:
        ViewGroup r16 = (ViewGroup) r13.getParent();
        return r15.getPositionKeyframe(r16.getWidth(), r16.getHeight(), r11, r12);
    L13:
        return null;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Boolean getPositionKeyframe(Object r10, Object r11, float r12, float r13, String[] r14, float[] r15) {
        if ((r10 instanceof KeyPositionBase) == false) goto L7;
        KeyPositionBase r16 = (KeyPositionBase) r10;
        View r17 = (View) r11;
        this.mMotionLayout.mFrameArrayList.get(r17).positionKeyframe(r17, r16, r12, r13, r14, r15);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return Boolean.TRUE;
    L7:
        return Boolean.FALSE;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getStartState() {
        int r10 = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == r10) goto L5;
        String r11 = this.mMotionLayout.getConstraintSetNames(r10);
        if (r11 == null) goto L10;
        this.mLastStartState = r11;
        this.mLastStartStateId = r10;
    L10:
        return this.mMotionLayout.getConstraintSetNames(r10);
    L5:
        return this.mLastStartState;
    }

    public String getState() {
        if (this.mLastStartState == null) goto L15;
        if (this.mLastEndState == null) goto L15;
        float r10 = getProgress();
        if (r10 > 0.01f) goto L11;
        return this.mLastStartState;
    L11:
        if (r10 < 0.99f) goto L15;
        return this.mLastEndState;
    L15:
        return this.mLastStartState;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        if (this.mLastStartState != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLastEndState == null) goto L7;
        return true;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setAttributes(int r10, String r11, Object r12, Object r13) {
        View r14 = (View) r12;
        HashMap r15 = (HashMap) r13;
        int r16 = this.mMotionLayout.lookUpConstraintId(r11);
        ConstraintSet r17 = this.mMotionLayout.mScene.getConstraintSet(r16);
        if (r17 != null) goto L5;
        return;
    L5:
        r17.clear(r14.getId());
        SetDimensions(r10, r17, r14, r15, 0);
        SetDimensions(r10, r17, r14, r15, 1);
        Connect(r10, r17, r14, r15, 6, 6);
        Connect(r10, r17, r14, r15, 6, 7);
        Connect(r10, r17, r14, r15, 7, 7);
        Connect(r10, r17, r14, r15, 7, 6);
        Connect(r10, r17, r14, r15, 1, 1);
        Connect(r10, r17, r14, r15, 1, 2);
        Connect(r10, r17, r14, r15, 2, 2);
        Connect(r10, r17, r14, r15, 2, 1);
        Connect(r10, r17, r14, r15, 3, 3);
        Connect(r10, r17, r14, r15, 3, 4);
        Connect(r10, r17, r14, r15, 4, 3);
        Connect(r10, r17, r14, r15, 4, 4);
        Connect(r10, r17, r14, r15, 5, 5);
        SetBias(r17, r14, r15, 0);
        SetBias(r17, r14, r15, 1);
        SetAbsolutePositions(r10, r17, r14, r15);
        this.mMotionLayout.updateState(r16, r17);
        this.mMotionLayout.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setKeyFrame(Object r10, int r11, String r12, Object r13) {
        MotionScene r14 = this.mMotionLayout.mScene;
        if (r14 == null) goto L6;
        r14.setKeyframe((View) r10, r11, r12, r13);
        MotionLayout r15 = this.mMotionLayout;
        r15.mTransitionGoalPosition = r11 / 100.0f;
        r15.mTransitionLastPosition = 0.0f;
        r15.rebuildScene();
        this.mMotionLayout.evaluate(true);
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(Object r10, int r11, int r12, float r13, float r14) {
        if ((r10 instanceof View) == true) goto L5;
        return false;
    L5:
        MotionLayout r15 = this.mMotionLayout;
        if (r15.mScene == null) goto L13;
        MotionController r16 = r15.mFrameArrayList.get(r10);
        MotionLayout r17 = this.mMotionLayout;
        int r18 = (int) (r17.mTransitionPosition * 100.0f);
        if (r16 == null) goto L13;
        View r19 = (View) r10;
        if (r17.mScene.hasKeyFramePosition(r19, r18) == false) goto L13;
        float r20 = r16.getKeyFrameParameter(2, r13, r14);
        float r21 = r16.getKeyFrameParameter(5, r13, r14);
        this.mMotionLayout.mScene.setKeyframe(r19, r18, "motion:percentX", Float.valueOf(r20));
        this.mMotionLayout.mScene.setKeyframe(r19, r18, "motion:percentY", Float.valueOf(r21));
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.invalidate();
        return true;
    L13:
        return false;
    }

    public void setKeyframe(Object r10, String r11, Object r12) {
        if ((r10 instanceof Key) == false) goto L6;
        ((Key) r10).setValue(r11, r12);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return;
    }

    public void setState(String r10) {
        if (r10 != null) goto L5;
        r10 = "motion_base";
    L5:
        if (this.mLastStartState != r10) goto L7;
        return;
    L7:
        this.mLastStartState = r10;
        this.mLastEndState = null;
        MotionLayout r11 = this.mMotionLayout;
        if (r11.mScene != null) goto L10;
        r11.mScene = this.mSceneCache;
    L10:
        int r12 = r11.lookUpConstraintId(r10);
        this.mLastStartStateId = r12;
        if (r12 != 0) goto L13;
    L20:
        this.mMotionLayout.requestLayout();
        return;
    L13:
        if (r12 != this.mMotionLayout.getStartState()) goto L16;
        this.mMotionLayout.setProgress(0.0f);
        goto L20
    L16:
        if (r12 == this.mMotionLayout.getEndState()) goto L19;
        this.mMotionLayout.transitionToState(r12);
    L19:
        this.mMotionLayout.setProgress(1.0f);
        goto L20
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float r10) {
        MotionLayout r11 = this.mMotionLayout;
        if (r11.mScene != null) goto L5;
        r11.mScene = this.mSceneCache;
    L5:
        r11.setProgress(r10);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setTransition(String r10, String r11) {
        MotionLayout r12 = this.mMotionLayout;
        if (r12.mScene != null) goto L5;
        r12.mScene = this.mSceneCache;
    L5:
        int r13 = r12.lookUpConstraintId(r10);
        int r14 = this.mMotionLayout.lookUpConstraintId(r11);
        this.mMotionLayout.setTransition(r13, r14);
        this.mLastStartStateId = r13;
        this.mLastEndStateId = r14;
        this.mLastStartState = r10;
        this.mLastEndState = r11;
    }

    public void setViewDebug(Object r10, int r11) {
        if ((r10 instanceof View) == true) goto L5;
        return;
    L5:
        MotionController r12 = this.mMotionLayout.mFrameArrayList.get(r10);
        if (r12 == null) goto L9;
        r12.setDrawPath(r11);
        this.mMotionLayout.invalidate();
        return;
    }
}
