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
        HashMap<Pair<Integer, Integer>, String> r5 = new HashMap();
        allAttributes = r5;
        HashMap<String, String> r10 = new HashMap();
        allMargins = r10;
        r5.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        r5.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        r5.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        r5.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        r5.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        r5.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        r5.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        r5.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        r5.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        r5.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        r5.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        r5.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        r5.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        r10.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        r10.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        r10.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        r10.put("layout_constraintTop_toTopOf", "layout_marginTop");
        r10.put("layout_constraintStart_toStartOf", "layout_marginStart");
        r10.put("layout_constraintStart_toEndOf", "layout_marginStart");
        r10.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        r10.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        r10.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        r10.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        r10.put("layout_constraintRight_toRightOf", "layout_marginRight");
        r10.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout r5) {
        this.mLastStartState = null;
        this.mLastEndState = null;
        this.mLastStartStateId = -1;
        this.mLastEndStateId = -1;
        this.mMotionLayout = r5;
    }

    private static void Connect(int r10, ConstraintSet r11, View r12, HashMap<String, String> r13, int r14, int r15) {
        String r5 = allAttributes.get(Pair.create(Integer.valueOf(r14), Integer.valueOf(r15)));
        String r16 = r13.get(r5);
        if (r16 == null) goto L11;
        String r17 = allMargins.get(r5);
        if (r17 == null) goto L8;
        int r18 = GetPxFromDp(r10, r13.get(r17));
    L7:
        int r19 = r18;
        int r20 = Integer.parseInt(r16);
        r11.connect(r12.getId(), r14, r20, r15, r19);
        return;
    L8:
        r18 = 0;
        goto L7
    }

    private static int GetPxFromDp(int r5, String r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = r10.indexOf(100);
        if (r11 != (-1)) goto L9;
        return 0;
    L9:
        return (int) ((Integer.valueOf(r10.substring(0, r11)).intValue() * r5) / 160.0f);
    }

    private static void SetAbsolutePositions(int r5, ConstraintSet r10, View r11, HashMap<String, String> r12) {
        String r13 = r12.get("layout_editor_absoluteX");
        if (r13 == null) goto L5;
        r10.setEditorAbsoluteX(r11.getId(), GetPxFromDp(r5, r13));
    L5:
        String r14 = r12.get("layout_editor_absoluteY");
        if (r14 == null) goto L9;
        r10.setEditorAbsoluteY(r11.getId(), GetPxFromDp(r5, r14));
        return;
    }

    private static void SetBias(ConstraintSet r5, View r10, HashMap<String, String> r11, int r12) {
        if (r12 != 1) goto L5;
        String r13 = "layout_constraintVertical_bias";
    L6:
        String r14 = r11.get(r13);
        if (r14 == null) goto L13;
        if (r12 != 0) goto L10;
        r5.setHorizontalBias(r10.getId(), Float.parseFloat(r14));
        return;
    L10:
        if (r12 != 1) goto L15;
        r5.setVerticalBias(r10.getId(), Float.parseFloat(r14));
        return;
    L15:
        return;
    L13:
        return;
    L5:
        r13 = "layout_constraintHorizontal_bias";
        goto L6
    }

    private static void SetDimensions(int r5, ConstraintSet r10, View r11, HashMap<String, String> r12, int r13) {
        if (r13 != 1) goto L5;
        String r14 = "layout_height";
    L6:
        String r15 = r12.get(r14);
        if (r15 != null) goto L9;
        return;
    L9:
        if (r15.equalsIgnoreCase("wrap_content") == true) goto L11;
        int r16 = GetPxFromDp(r5, r15);
    L12:
        if (r13 != 0) goto L14;
        r10.constrainWidth(r11.getId(), r16);
        return;
    L14:
        r10.constrainHeight(r11.getId(), r16);
        return;
    L11:
        r16 = -2;
        goto L12
    L5:
        r14 = "layout_width";
        goto L6
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int r5, String r10, Object r11, float[] r12, int r13, float[] r14, int r15) {
        View r16 = (View) r11;
        if (r5 == 0) goto L11;
        MotionLayout r17 = this.mMotionLayout;
        if (r17.mScene != null) goto L7;
        return -1;
    L7:
        if (r16 == null) goto L10;
        MotionController r18 = r17.mFrameArrayList.get(r16);
        if (r18 == null) goto L10;
    L13:
        if (r5 == 0) goto L26;
        if (r5 != 1) goto L16;
        int r19 = this.mMotionLayout.mScene.getDuration() / 16;
        r18.buildPath(r14, r19);
        return r19;
    L16:
        if (r5 != 2) goto L18;
        int r20 = this.mMotionLayout.mScene.getDuration() / 16;
        r18.buildKeyFrames(r14, null);
        return r20;
    L18:
        if (r5 == 3) goto L20;
        return -1;
    L20:
        this.mMotionLayout.mScene.getDuration();
        return r18.getAttributeValues(r10, r14, r15);
    L26:
        return 1;
    L10:
        return -1;
    L11:
        r18 = null;
        goto L13
    }

    public void disableAutoTransition(boolean r5) {
        this.mMotionLayout.disableAutoTransition(r5);
    }

    public void dumpConstraintSet(String r5) {
        MotionLayout r10 = this.mMotionLayout;
        if (r10.mScene != null) goto L5;
        r10.mScene = this.mSceneCache;
    L5:
        int r11 = r10.lookUpConstraintId(r5);
        System.out.println(" dumping  " + r5 + " (" + r11 + ")");
        this.mMotionLayout.mScene.getConstraintSet(r11).dump(this.mMotionLayout.mScene, new int[0]);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public int getAnimationKeyFrames(Object r5, float[] r10) {
        MotionScene r11 = this.mMotionLayout.mScene;
        if (r11 != null) goto L6;
        return -1;
    L6:
        int r12 = r11.getDuration() / 16;
        MotionController r13 = this.mMotionLayout.mFrameArrayList.get(r5);
        if (r13 != null) goto L10;
        return 0;
    L10:
        r13.buildKeyFrames(r10, null);
        return r12;
    }

    public int getAnimationPath(Object r5, float[] r10, int r11) {
        MotionLayout r12 = this.mMotionLayout;
        if (r12.mScene != null) goto L6;
        return -1;
    L6:
        MotionController r13 = r12.mFrameArrayList.get(r5);
        if (r13 != null) goto L10;
        return 0;
    L10:
        r13.buildPath(r10, r11);
        return r11;
    }

    public void getAnimationRectangles(Object r5, float[] r10) {
        MotionScene r11 = this.mMotionLayout.mScene;
        if (r11 != null) goto L5;
        return;
    L5:
        int r12 = r11.getDuration() / 16;
        MotionController r13 = this.mMotionLayout.mFrameArrayList.get(r5);
        if (r13 != null) goto L8;
        return;
    L8:
        r13.buildRectangles(r10, r12);
    }

    public String getEndState() {
        int r5 = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == r5) goto L5;
        String r10 = this.mMotionLayout.getConstraintSetNames(r5);
        if (r10 == null) goto L9;
        this.mLastEndState = r10;
        this.mLastEndStateId = r5;
    L9:
        return r10;
    L5:
        return this.mLastEndState;
    }

    public int getKeyFrameInfo(Object r5, int r10, int[] r11) {
        MotionController r12 = this.mMotionLayout.mFrameArrayList.get((View) r5);
        if (r12 != null) goto L7;
        return 0;
    L7:
        return r12.getKeyFrameInfo(r10, r11);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(Object r5, int r10, float r11, float r12) {
        return this.mMotionLayout.mFrameArrayList.get((View) r5).getKeyFrameParameter(r10, r11, r12);
    }

    public int getKeyFramePositions(Object r5, int[] r10, float[] r11) {
        MotionController r12 = this.mMotionLayout.mFrameArrayList.get((View) r5);
        if (r12 != null) goto L7;
        return 0;
    L7:
        return r12.getkeyFramePositions(r10, r11);
    }

    public Object getKeyframe(int r5, int r10, int r11) {
        MotionLayout r12 = this.mMotionLayout;
        MotionScene r13 = r12.mScene;
        if (r13 != null) goto L7;
        return null;
    L7:
        return r13.getKeyFrame(r12.getContext(), r5, r10, r11);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Object getKeyframeAtLocation(Object r5, float r10, float r11) {
        View r12 = (View) r5;
        MotionLayout r13 = this.mMotionLayout;
        if (r13.mScene != null) goto L7;
        return -1;
    L7:
        if (r12 == null) goto L13;
        MotionController r14 = r13.mFrameArrayList.get(r12);
        if (r14 != null) goto L11;
        return null;
    L11:
        ViewGroup r15 = (ViewGroup) r12.getParent();
        return r14.getPositionKeyframe(r15.getWidth(), r15.getHeight(), r10, r11);
    L13:
        return null;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Boolean getPositionKeyframe(Object r10, Object r11, float r12, float r13, String[] r14, float[] r15) {
        if ((r10 instanceof KeyPositionBase) == false) goto L7;
        KeyPositionBase r5 = (KeyPositionBase) r10;
        View r16 = (View) r11;
        this.mMotionLayout.mFrameArrayList.get(r16).positionKeyframe(r16, r5, r12, r13, r14, r15);
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
        int r5 = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == r5) goto L5;
        String r10 = this.mMotionLayout.getConstraintSetNames(r5);
        if (r10 == null) goto L10;
        this.mLastStartState = r10;
        this.mLastStartStateId = r5;
    L10:
        return this.mMotionLayout.getConstraintSetNames(r5);
    L5:
        return this.mLastStartState;
    }

    public String getState() {
        if (this.mLastStartState == null) goto L15;
        if (this.mLastEndState == null) goto L15;
        float r5 = getProgress();
        if (r5 > 0.01f) goto L11;
        return this.mLastStartState;
    L11:
        if (r5 < 0.99f) goto L15;
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
    public void setKeyFrame(Object r5, int r10, String r11, Object r12) {
        MotionScene r13 = this.mMotionLayout.mScene;
        if (r13 == null) goto L6;
        r13.setKeyframe((View) r5, r10, r11, r12);
        MotionLayout r14 = this.mMotionLayout;
        r14.mTransitionGoalPosition = r10 / 100.0f;
        r14.mTransitionLastPosition = 0.0f;
        r14.rebuildScene();
        this.mMotionLayout.evaluate(true);
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(Object r5, int r10, int r11, float r12, float r13) {
        MotionLayout r14 = this.mMotionLayout;
        if (r14.mScene == null) goto L10;
        MotionController r15 = r14.mFrameArrayList.get(r5);
        MotionLayout r16 = this.mMotionLayout;
        int r17 = (int) (r16.mTransitionPosition * 100.0f);
        if (r15 == null) goto L12;
        View r18 = (View) r5;
        if (r16.mScene.hasKeyFramePosition(r18, r17) == false) goto L13;
        float r19 = r15.getKeyFrameParameter(2, r12, r13);
        float r20 = r15.getKeyFrameParameter(5, r12, r13);
        this.mMotionLayout.mScene.setKeyframe(r18, r17, "motion:percentX", Float.valueOf(r19));
        this.mMotionLayout.mScene.setKeyframe(r18, r17, "motion:percentY", Float.valueOf(r20));
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.invalidate();
        return true;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    public void setKeyframe(Object r5, String r10, Object r11) {
        if ((r5 instanceof Key) == false) goto L6;
        ((Key) r5).setValue(r10, r11);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return;
    }

    public void setState(String r5) {
        if (r5 != null) goto L5;
        r5 = "motion_base";
    L5:
        if (this.mLastStartState != r5) goto L7;
        return;
    L7:
        this.mLastStartState = r5;
        this.mLastEndState = null;
        MotionLayout r10 = this.mMotionLayout;
        if (r10.mScene != null) goto L10;
        r10.mScene = this.mSceneCache;
    L10:
        int r11 = r10.lookUpConstraintId(r5);
        this.mLastStartStateId = r11;
        if (r11 != 0) goto L13;
    L19:
        this.mMotionLayout.requestLayout();
        return;
    L13:
        if (r11 != this.mMotionLayout.getStartState()) goto L16;
        this.mMotionLayout.setProgress(0.0f);
        goto L19
    L16:
        if (r11 != this.mMotionLayout.getEndState()) goto L18;
        this.mMotionLayout.setProgress(1.0f);
        goto L19
    L18:
        this.mMotionLayout.transitionToState(r11);
        this.mMotionLayout.setProgress(1.0f);
        goto L19
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float r5) {
        MotionLayout r10 = this.mMotionLayout;
        if (r10.mScene != null) goto L5;
        r10.mScene = this.mSceneCache;
    L5:
        r10.setProgress(r5);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setTransition(String r5, String r10) {
        MotionLayout r11 = this.mMotionLayout;
        if (r11.mScene != null) goto L5;
        r11.mScene = this.mSceneCache;
    L5:
        int r12 = r11.lookUpConstraintId(r5);
        int r13 = this.mMotionLayout.lookUpConstraintId(r10);
        this.mMotionLayout.setTransition(r12, r13);
        this.mLastStartStateId = r12;
        this.mLastEndStateId = r13;
        this.mLastStartState = r5;
        this.mLastEndState = r10;
    }

    public void setViewDebug(Object r5, int r10) {
        MotionController r11 = this.mMotionLayout.mFrameArrayList.get(r5);
        if (r11 == null) goto L6;
        r11.setDrawPath(r10);
        this.mMotionLayout.invalidate();
        return;
    }

    public Object getKeyframe(Object r5, int r10, int r11) {
        if (this.mMotionLayout.mScene != null) goto L6;
        return null;
    L6:
        int r12 = ((View) r5).getId();
        MotionLayout r13 = this.mMotionLayout;
        return r13.mScene.getKeyFrame(r13.getContext(), r10, r12, r11);
    }
}
