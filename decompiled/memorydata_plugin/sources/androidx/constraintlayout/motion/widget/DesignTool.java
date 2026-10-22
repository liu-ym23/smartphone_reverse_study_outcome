package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        HashMap<Pair<Integer, Integer>, String> r0 = new HashMap();
        allAttributes = r0;
        HashMap<String, String> r1 = new HashMap();
        allMargins = r1;
        r0.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        r0.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        r0.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        r0.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        r0.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        r0.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        r0.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        r0.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        r0.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        r0.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        r0.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        r0.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        r0.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        r1.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        r1.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        r1.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        r1.put("layout_constraintTop_toTopOf", "layout_marginTop");
        r1.put("layout_constraintStart_toStartOf", "layout_marginStart");
        r1.put("layout_constraintStart_toEndOf", "layout_marginStart");
        r1.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        r1.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        r1.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        r1.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        r1.put("layout_constraintRight_toRightOf", "layout_marginRight");
        r1.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout r2) {
        this.mLastStartState = null;
        this.mLastEndState = null;
        this.mLastStartStateId = -1;
        this.mLastEndStateId = -1;
        this.mMotionLayout = r2;
    }

    private static void Connect(int r10, ConstraintSet r11, View r12, HashMap<String, String> r13, int r14, int r15) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(allAttributes.get(Pair.create(Integer.valueOf(r14), Integer.valueOf(r15))), String.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r13.get(r0), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        int r3 = 0;
        String r2 = (String) ZeusTransformUtils.preCheckCast(allMargins.get(r0), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        r3 = GetPxFromDp(r10, (String) ZeusTransformUtils.preCheckCast(r13.get(r2), String.class, "com.obric.memorydata.plugin"));
    L7:
        int r7 = Integer.parseInt(r1);
        int r5 = r12.getId();
        r11.connect(r5, r14, r7, r15, r3);
        return;
    }

    private static int GetPxFromDp(int r3, String r4) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        int r1 = r4.indexOf(100);
        if (r1 != (-1)) goto L9;
        return 0;
    L9:
        return (int) ((Integer.valueOf(r4.substring(0, r1)).intValue() * r3) / 160.0f);
    }

    private static void SetAbsolutePositions(int r3, ConstraintSet r4, View r5, HashMap<String, String> r6) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.get("layout_editor_absoluteX"), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r4.setEditorAbsoluteX(r5.getId(), GetPxFromDp(r3, r0));
    L5:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.get("layout_editor_absoluteY"), String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L9;
        r4.setEditorAbsoluteY(r5.getId(), GetPxFromDp(r3, r7));
        return;
    }

    private static void SetBias(ConstraintSet r3, View r4, HashMap<String, String> r5, int r6) {
        if (r6 != 1) goto L5;
        String r1 = "layout_constraintVertical_bias";
    L6:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.get(r1), String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        if (r6 != 0) goto L10;
        r3.setHorizontalBias(r4.getId(), Float.parseFloat(r7));
        return;
    L10:
        if (r6 != 1) goto L15;
        r3.setVerticalBias(r4.getId(), Float.parseFloat(r7));
        return;
    L15:
        return;
    L13:
        return;
    L5:
        r1 = "layout_constraintHorizontal_bias";
        goto L6
    }

    private static void SetDimensions(int r2, ConstraintSet r3, View r4, HashMap<String, String> r5, int r6) {
        if (r6 != 1) goto L5;
        String r0 = "layout_height";
    L6:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.get(r0), String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L16;
        int r1 = -2;
        if (r7.equalsIgnoreCase("wrap_content") == true) goto L11;
        r1 = GetPxFromDp(r2, r7);
    L11:
        int r8 = r4.getId();
        if (r6 != 0) goto L14;
        r3.constrainWidth(r8, r1);
        return;
    L14:
        r3.constrainHeight(r8, r1);
        return;
    L16:
        return;
    L5:
        r0 = "layout_width";
        goto L6
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int r3, String r4, Object r5, float[] r6, int r7, float[] r8, int r9) {
        View r10 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin");
        if (r3 != 0) goto L5;
        MotionController r11 = null;
    L13:
        if (r3 == 0) goto L26;
        if (r3 != 1) goto L16;
        int r2 = this.mMotionLayout.mScene.getDuration() / 16;
        r11.buildPath(r8, r2);
        return r2;
    L16:
        if (r3 != 2) goto L18;
        int r12 = this.mMotionLayout.mScene.getDuration() / 16;
        r11.buildKeyFrames(r8, null);
        return r12;
    L18:
        if (r3 == 3) goto L20;
        return -1;
    L20:
        int r13 = this.mMotionLayout.mScene.getDuration() / 16;
        return r11.getAttributeValues(r4, r8, r9);
    L26:
        return 1;
    L5:
        if (this.mMotionLayout.mScene != null) goto L7;
        return -1;
    L7:
        if (r10 == null) goto L10;
        r11 = (MotionController) ZeusTransformUtils.preCheckCast(this.mMotionLayout.mFrameArrayList.get(r10), MotionController.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L13;
    L10:
        return -1;
    }

    public void disableAutoTransition(boolean r1) {
        this.mMotionLayout.disableAutoTransition(r1);
    }

    public void dumpConstraintSet(String r5) {
        if (this.mMotionLayout.mScene != null) goto L5;
        this.mMotionLayout.mScene = this.mSceneCache;
    L5:
        int r0 = this.mMotionLayout.lookUpConstraintId(r5);
        System.out.println(" dumping  " + r5 + " (" + r0 + ")");
        this.mMotionLayout.mScene.getConstraintSet(r0).dump(this.mMotionLayout.mScene, new int[0]);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public int getAnimationKeyFrames(Object r3, float[] r4) {
        if (this.mMotionLayout.mScene != null) goto L6;
        return -1;
    L6:
        int r0 = this.mMotionLayout.mScene.getDuration() / 16;
        MotionController r2 = (MotionController) ZeusTransformUtils.preCheckCast(this.mMotionLayout.mFrameArrayList.get(r3), MotionController.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L10;
        return 0;
    L10:
        r2.buildKeyFrames(r4, null);
        return r0;
    }

    public int getAnimationPath(Object r2, float[] r3, int r4) {
        if (this.mMotionLayout.mScene != null) goto L6;
        return -1;
    L6:
        MotionController r1 = (MotionController) ZeusTransformUtils.preCheckCast(this.mMotionLayout.mFrameArrayList.get(r2), MotionController.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L10;
        return 0;
    L10:
        r1.buildPath(r3, r4);
        return r4;
    }

    public void getAnimationRectangles(Object r3, float[] r4) {
        if (this.mMotionLayout.mScene != null) goto L5;
        return;
    L5:
        int r0 = this.mMotionLayout.mScene.getDuration() / 16;
        MotionController r2 = (MotionController) ZeusTransformUtils.preCheckCast(this.mMotionLayout.mFrameArrayList.get(r3), MotionController.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L8;
        return;
    L8:
        r2.buildRectangles(r4, r0);
    }

    public String getEndState() {
        int r0 = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == r0) goto L5;
        String r1 = this.mMotionLayout.getConstraintSetNames(r0);
        if (r1 == null) goto L9;
        this.mLastEndState = r1;
        this.mLastEndStateId = r0;
    L9:
        return r1;
    L5:
        return this.mLastEndState;
    }

    public int getKeyFrameInfo(Object r3, int r4, int[] r5) {
        MotionController r2 = (MotionController) ZeusTransformUtils.preCheckCast(this.mMotionLayout.mFrameArrayList.get((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")), MotionController.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getKeyFrameInfo(r4, r5);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(Object r4, int r5, float r6, float r7) {
        if (ZeusTransformUtils.instanceOf(r4, View.class) == true) goto L5;
        return 0.0f;
    L5:
        MotionController r3 = (MotionController) ZeusTransformUtils.preCheckCast(this.mMotionLayout.mFrameArrayList.get((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin")), MotionController.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
        return 0.0f;
    L9:
        return r3.getKeyFrameParameter(r5, r6, r7);
    }

    public int getKeyFramePositions(Object r3, int[] r4, float[] r5) {
        MotionController r2 = (MotionController) ZeusTransformUtils.preCheckCast(this.mMotionLayout.mFrameArrayList.get((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")), MotionController.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getKeyFramePositions(r4, r5);
    }

    public Object getKeyframe(int r4, int r5, int r6) {
        if (this.mMotionLayout.mScene != null) goto L7;
        return null;
    L7:
        return this.mMotionLayout.mScene.getKeyFrame((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mMotionLayout.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    public Object getKeyframe(Object r4, int r5, int r6) {
        if (this.mMotionLayout.mScene != null) goto L6;
        return null;
    L6:
        int r7 = ((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin")).getId();
        return this.mMotionLayout.mScene.getKeyFrame((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mMotionLayout.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, r7, r6);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Object getKeyframeAtLocation(Object r4, float r5, float r6) {
        View r7 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
        if (this.mMotionLayout.mScene != null) goto L7;
        return -1;
    L7:
        if (r7 == null) goto L13;
        MotionController r3 = (MotionController) ZeusTransformUtils.preCheckCast(this.mMotionLayout.mFrameArrayList.get(r7), MotionController.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L11;
        return null;
    L11:
        ViewGroup r8 = (ViewGroup) ZeusTransformUtils.preCheckCast(r7.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
        return r3.getPositionKeyframe(r8.getWidth(), r8.getHeight(), r5, r6);
    L13:
        return null;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Boolean getPositionKeyframe(Object r10, Object r11, float r12, float r13, String[] r14, float[] r15) {
        if (ZeusTransformUtils.instanceOf(r10, KeyPositionBase.class) == false) goto L7;
        KeyPositionBase r4 = (KeyPositionBase) ZeusTransformUtils.preCheckCast(r10, KeyPositionBase.class, "com.obric.memorydata.plugin");
        ((MotionController) ZeusTransformUtils.preCheckCast(this.mMotionLayout.mFrameArrayList.get((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin")), MotionController.class, "com.obric.memorydata.plugin")).positionKeyframe((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), r4, r12, r13, r14, r15);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return true;
    L7:
        return false;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getStartState() {
        int r0 = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == r0) goto L5;
        String r1 = this.mMotionLayout.getConstraintSetNames(r0);
        if (r1 == null) goto L10;
        this.mLastStartState = r1;
        this.mLastStartStateId = r0;
    L10:
        return this.mMotionLayout.getConstraintSetNames(r0);
    L5:
        return this.mLastStartState;
    }

    public String getState() {
        if (this.mLastStartState == null) goto L15;
        if (this.mLastEndState == null) goto L15;
        float r0 = getProgress();
        if (r0 > 0.01f) goto L11;
        return this.mLastStartState;
    L11:
        if (r0 < 0.99f) goto L15;
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
        View r14 = (View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin");
        HashMap r15 = (HashMap) ZeusTransformUtils.preCheckCast(r13, HashMap.class, "com.obric.memorydata.plugin");
        int r16 = this.mMotionLayout.lookUpConstraintId(r11);
        ConstraintSet r0 = this.mMotionLayout.mScene.getConstraintSet(r16);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.clear(r14.getId());
        SetDimensions(r10, r0, r14, r15, 0);
        SetDimensions(r10, r0, r14, r15, 1);
        Connect(r10, r0, r14, r15, 6, 6);
        Connect(r10, r0, r14, r15, 6, 7);
        Connect(r10, r0, r14, r15, 7, 7);
        Connect(r10, r0, r14, r15, 7, 6);
        Connect(r10, r0, r14, r15, 1, 1);
        Connect(r10, r0, r14, r15, 1, 2);
        Connect(r10, r0, r14, r15, 2, 2);
        Connect(r10, r0, r14, r15, 2, 1);
        Connect(r10, r0, r14, r15, 3, 3);
        Connect(r10, r0, r14, r15, 3, 4);
        Connect(r10, r0, r14, r15, 4, 3);
        Connect(r10, r0, r14, r15, 4, 4);
        Connect(r10, r0, r14, r15, 5, 5);
        SetBias(r0, r14, r15, 0);
        SetBias(r0, r14, r15, 1);
        SetAbsolutePositions(r10, r0, r14, r15);
        this.mMotionLayout.updateState(r16, r0);
        this.mMotionLayout.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setKeyFrame(Object r4, int r5, String r6, Object r7) {
        if (this.mMotionLayout.mScene == null) goto L6;
        this.mMotionLayout.mScene.setKeyframe((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), r5, r6, r7);
        this.mMotionLayout.mTransitionGoalPosition = r5 / 100.0f;
        this.mMotionLayout.mTransitionLastPosition = 0.0f;
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(Object r5, int r6, int r7, float r8, float r9) {
        if (ZeusTransformUtils.instanceOf(r5, View.class) == true) goto L6;
        return false;
    L6:
        if (this.mMotionLayout.mScene == null) goto L13;
        MotionController r10 = (MotionController) ZeusTransformUtils.preCheckCast(this.mMotionLayout.mFrameArrayList.get(r5), MotionController.class, "com.obric.memorydata.plugin");
        int r0 = (int) (this.mMotionLayout.mTransitionPosition * 100.0f);
        if (r10 == null) goto L13;
        if (this.mMotionLayout.mScene.hasKeyFramePosition((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), r0) == false) goto L13;
        float r11 = r10.getKeyFrameParameter(2, r8, r9);
        float r12 = r10.getKeyFrameParameter(5, r8, r9);
        this.mMotionLayout.mScene.setKeyframe((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), r0, "motion:percentX", Float.valueOf(r11));
        this.mMotionLayout.mScene.setKeyframe((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), r0, "motion:percentY", Float.valueOf(r12));
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.invalidate();
        return true;
    L13:
        return false;
    }

    public void setKeyframe(Object r3, String r4, Object r5) {
        if (ZeusTransformUtils.instanceOf(r3, Key.class) == false) goto L6;
        ((Key) ZeusTransformUtils.preCheckCast(r3, Key.class, "com.obric.memorydata.plugin")).setValue(r4, r5);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return;
    }

    public void setState(String r3) {
        if (r3 != null) goto L5;
        r3 = "motion_base";
    L5:
        if (this.mLastStartState != r3) goto L7;
        return;
    L7:
        this.mLastStartState = r3;
        this.mLastEndState = null;
        if (this.mMotionLayout.mScene != null) goto L10;
        MotionLayout r0 = this.mMotionLayout;
        r0.mScene = this.mSceneCache;
    L10:
        int r4 = this.mMotionLayout.lookUpConstraintId(r3);
        this.mLastStartStateId = r4;
        if (r4 != 0) goto L13;
    L20:
        this.mMotionLayout.requestLayout();
        return;
    L13:
        if (r4 != this.mMotionLayout.getStartState()) goto L16;
        this.mMotionLayout.setProgress(0.0f);
        goto L20
    L16:
        if (r4 == this.mMotionLayout.getEndState()) goto L19;
        this.mMotionLayout.transitionToState(r4);
    L19:
        this.mMotionLayout.setProgress(1.0f);
        goto L20
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float r3) {
        if (this.mMotionLayout.mScene != null) goto L5;
        MotionLayout r0 = this.mMotionLayout;
        r0.mScene = this.mSceneCache;
    L5:
        this.mMotionLayout.setProgress(r3);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setTransition(String r4, String r5) {
        if (this.mMotionLayout.mScene != null) goto L5;
        MotionLayout r0 = this.mMotionLayout;
        r0.mScene = this.mSceneCache;
    L5:
        int r1 = this.mMotionLayout.lookUpConstraintId(r4);
        int r2 = this.mMotionLayout.lookUpConstraintId(r5);
        this.mMotionLayout.setTransition(r1, r2);
        this.mLastStartStateId = r1;
        this.mLastEndStateId = r2;
        this.mLastStartState = r4;
        this.mLastEndState = r5;
    }

    public void setViewDebug(Object r3, int r4) {
        if (ZeusTransformUtils.instanceOf(r3, View.class) == true) goto L5;
        return;
    L5:
        MotionController r5 = (MotionController) ZeusTransformUtils.preCheckCast(this.mMotionLayout.mFrameArrayList.get(r3), MotionController.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        r5.setDrawPath(r4);
        this.mMotionLayout.invalidate();
        return;
    }
}
