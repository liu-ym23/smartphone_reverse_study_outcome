package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = null;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION = null;
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators;
    private ArrayList<Animator> mAnimators;
    boolean mCanRemoveViews;
    ArrayList<Animator> mCurrentAnimators;
    long mDuration;
    private TransitionValuesMaps mEndValues;
    private ArrayList<TransitionValues> mEndValuesList;
    private boolean mEnded;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator;
    private ArrayList<TransitionListener> mListeners;
    private int[] mMatchOrder;
    private String mName;
    private ArrayMap<String, String> mNameOverrides;
    private int mNumInstances;
    TransitionSet mParent;
    private PathMotion mPathMotion;
    private boolean mPaused;
    TransitionPropagation mPropagation;
    private ViewGroup mSceneRoot;
    private long mStartDelay;
    private TransitionValuesMaps mStartValues;
    private ArrayList<TransitionValues> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes;
    private ArrayList<View> mTargetExcludes;
    private ArrayList<Integer> mTargetIdChildExcludes;
    private ArrayList<Integer> mTargetIdExcludes;
    ArrayList<Integer> mTargetIds;
    private ArrayList<String> mTargetNameExcludes;
    private ArrayList<String> mTargetNames;
    private ArrayList<Class<?>> mTargetTypeChildExcludes;
    private ArrayList<Class<?>> mTargetTypeExcludes;
    private ArrayList<Class<?>> mTargetTypes;
    ArrayList<View> mTargets;

    private static class AnimationInfo {
        String mName;
        Transition mTransition;
        TransitionValues mValues;
        View mView;
        WindowIdImpl mWindowId;

        AnimationInfo(View r3, String r4, Transition r5, WindowIdImpl r6, TransitionValues r7) {
            WindowIdImpl r8 = (WindowIdImpl) ZeusTransformUtils.wrapperContextForParams(r6, WindowIdImpl.class, "com.obric.memorydata.plugin");
            this.mView = r3;
            this.mName = r4;
            this.mValues = r7;
            this.mWindowId = r8;
            this.mTransition = r5;
        }
    }

    private static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> add(ArrayList<T> r1, T r2) {
            if (r1 != null) goto L5;
            r1 = new ArrayList();
        L5:
            if (r1.contains(r2) == true) goto L7;
            r1.add(r2);
        L7:
            return r1;
        }

        static <T> ArrayList<T> remove(ArrayList<T> r0, T r1) {
            if (r0 == null) goto L7;
            r0.remove(r1);
            if (r0.isEmpty() == false) goto L8;
            return null;
        L8:
            return r0;
        L7:
            return r0;
        }
    }

    public static abstract class EpicenterCallback {
        public EpicenterCallback() {
        }

        public abstract Rect onGetEpicenter(Transition r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchOrder {
    }

    public interface TransitionListener {
        void onTransitionCancel(Transition r1);

        void onTransitionEnd(Transition r1);

        void onTransitionPause(Transition r1);

        void onTransitionResume(Transition r1);

        void onTransitionStart(Transition r1);
    }

    static {
        DEFAULT_MATCH_ORDER = new int[]{2, 1, 3, 4};
        STRAIGHT_PATH_MOTION = new AnonymousClass1();
        sRunningAnimators = new ThreadLocal();
    }

    public Transition() {
        this.mName = getClass().getName();
        this.mStartDelay = -1;
        this.mDuration = -1;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList();
        this.mTargets = new ArrayList();
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mSceneRoot = null;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
    }

    public Transition(Context r10, AttributeSet r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        this.mName = getClass().getName();
        this.mStartDelay = -1;
        this.mDuration = -1;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList();
        this.mTargets = new ArrayList();
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mSceneRoot = null;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        TypedArray r0 = r12.obtainStyledAttributes(r13, Styleable.TRANSITION);
        XmlResourceParser r14 = (XmlResourceParser) ZeusTransformUtils.preCheckCast(r13, XmlResourceParser.class, "com.obric.memorydata.plugin");
        long r5 = TypedArrayUtils.getNamedInt(r0, r14, "duration", 1, -1);
        if (r5 < 0) goto L5;
        setDuration(r5);
    L5:
        long r3 = TypedArrayUtils.getNamedInt(r0, r14, "startDelay", 2, -1);
        if (r3 <= 0) goto L8;
        setStartDelay(r3);
    L8:
        int r1 = TypedArrayUtils.getNamedResourceId(r0, r14, "interpolator", 0, 0);
        if (r1 <= 0) goto L11;
        setInterpolator(AnimationUtils.loadInterpolator(r12, r1));
    L11:
        String r15 = TypedArrayUtils.getNamedString(r0, r14, "matchOrder", 3);
        if (r15 == null) goto L14;
        setMatchOrder(parseMatchOrder(r15));
    L14:
        r0.recycle();
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> r7, ArrayMap<View, TransitionValues> r8) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= r7.size()) goto L10;
        TransitionValues r2 = (TransitionValues) ZeusTransformUtils.preCheckCast(r7.valueAt(r1), TransitionValues.class, "com.obric.memorydata.plugin");
        if (isValidTarget(r2.view) == false) goto L8;
        this.mStartValuesList.add(r2);
        this.mEndValuesList.add(null);
    L8:
        r1 = r1 + 1;
    L10:
        if (r0 >= r8.size()) goto L15;
        TransitionValues r9 = (TransitionValues) ZeusTransformUtils.preCheckCast(r8.valueAt(r0), TransitionValues.class, "com.obric.memorydata.plugin");
        if (isValidTarget(r9.view) == false) goto L14;
        this.mEndValuesList.add(r9);
        this.mStartValuesList.add(null);
    L14:
        r0 = r0 + 1;
        goto L10
    }

    private static void addViewValues(TransitionValuesMaps r5, View r6, TransitionValues r7) {
        r5.mViewValues.put(r6, r7);
        int r8 = r6.getId();
        if (r8 >= 0) goto L5;
    L8:
        String r9 = ViewCompat.getTransitionName(r6);
        if (r9 == null) goto L15;
        if (r5.mNameValues.containsKey(r9) == false) goto L13;
        r5.mNameValues.put(r9, null);
        goto L15
    L13:
        r5.mNameValues.put(r9, r6);
    L15:
        if (ZeusTransformUtils.instanceOf(r6.getParent(), ListView.class) == false) goto L25;
        ListView r10 = (ListView) ZeusTransformUtils.preCheckCast(r6.getParent(), ListView.class, "com.obric.memorydata.plugin");
        if (r10.getAdapter().hasStableIds() == false) goto L26;
        long r3 = r10.getItemIdAtPosition(r10.getPositionForView(r6));
        if (r5.mItemIdValues.indexOfKey(r3) < 0) goto L23;
        View r11 = (View) ZeusTransformUtils.preCheckCast(r5.mItemIdValues.get(r3), View.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L27;
        ViewCompat.setHasTransientState(r11, false);
        r5.mItemIdValues.put(r3, null);
        return;
    L27:
        return;
    L23:
        ViewCompat.setHasTransientState(r6, true);
        r5.mItemIdValues.put(r3, r6);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (r5.mIdValues.indexOfKey(r8) < 0) goto L7;
        r5.mIdValues.put(r8, null);
        goto L8
    L7:
        r5.mIdValues.put(r8, r6);
        goto L8
    }

    private static boolean alreadyContains(int[] r4, int r5) {
        int r0 = r4[r5];
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L9;
        if (r4[r2] == r0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void captureHierarchy(View r8, boolean r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        int r0 = r8.getId();
        ArrayList<Integer> r1 = this.mTargetIdExcludes;
        if (r1 != null) goto L7;
    L9:
        ArrayList<View> r2 = this.mTargetExcludes;
        if (r2 != null) goto L12;
    L14:
        ArrayList<Class<?>> r3 = this.mTargetTypeExcludes;
        int r4 = 0;
        if (r3 == null) goto L23;
        int r5 = r3.size();
        int r6 = 0;
    L17:
        if (r6 >= r5) goto L23;
        if (ZeusTransformUtils.instanceOf((Class) ZeusTransformUtils.preCheckCast(this.mTargetTypeExcludes.get(r6), Class.class, "com.obric.memorydata.plugin"), r8) == true) goto L20;
        r6 = r6 + 1;
        goto L17
    L20:
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r8.getParent(), ViewGroup.class) == false) goto L34;
        TransitionValues r7 = new TransitionValues(r8);
        if (r9 == false) goto L27;
        captureStartValues(r7);
    L28:
        r7.mTargetedTransitions.add(this);
        capturePropagationValues(r7);
        if (r9 == false) goto L31;
        TransitionValuesMaps r10 = this.mStartValues;
    L32:
        addViewValues(r10, r8, r7);
        goto L34
    L31:
        r10 = this.mEndValues;
        goto L32
    L27:
        captureEndValues(r7);
    L34:
        if (ZeusTransformUtils.instanceOf(r8, ViewGroup.class) == false) goto L57;
        ArrayList<Integer> r11 = this.mTargetIdChildExcludes;
        if (r11 != null) goto L38;
    L40:
        ArrayList<View> r12 = this.mTargetChildExcludes;
        if (r12 != null) goto L43;
    L45:
        ArrayList<Class<?>> r13 = this.mTargetTypeChildExcludes;
        if (r13 == null) goto L53;
        int r14 = r13.size();
        int r15 = 0;
    L48:
        if (r15 >= r14) goto L53;
        if (ZeusTransformUtils.instanceOf((Class) ZeusTransformUtils.preCheckCast(this.mTargetTypeChildExcludes.get(r15), Class.class, "com.obric.memorydata.plugin"), r8) == true) goto L51;
        r15 = r15 + 1;
        goto L48
    L51:
        return;
    L53:
        ViewGroup r16 = (ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.memorydata.plugin");
    L55:
        if (r4 >= r16.getChildCount()) goto L63;
        captureHierarchy(r16.getChildAt(r4), r9);
        r4 = r4 + 1;
        goto L55
    L63:
        return;
    L43:
        if (r12.contains(r8) == false) goto L45;
        return;
    L38:
        if (r11.contains(Integer.valueOf(r0)) == false) goto L40;
        return;
    L57:
        return;
    L12:
        if (r2.contains(r8) == false) goto L14;
        return;
    L7:
        if (r1.contains(Integer.valueOf(r0)) == false) goto L9;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> r1, int r2, boolean r3) {
        if (r2 <= 0) goto L8;
        Integer r0 = Integer.valueOf(r2);
        if (r3 == false) goto L7;
        return ArrayListManager.add(r1, r0);
    L7:
        return ArrayListManager.remove(r1, r0);
    L8:
        return r1;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> r0, T r1, boolean r2) {
        if (r1 == null) goto L7;
        if (r2 == false) goto L6;
        return ArrayListManager.add(r0, r1);
    L6:
        return ArrayListManager.remove(r0, r1);
    L7:
        return r0;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> r1, Class<?> r2, boolean r3) {
        if (r2 == null) goto L7;
        if (r3 == false) goto L6;
        return ArrayListManager.add(r1, r2);
    L6:
        return ArrayListManager.remove(r1, r2);
    L7:
        return r1;
    }

    private ArrayList<View> excludeView(ArrayList<View> r1, View r2, boolean r3) {
        if (r2 == null) goto L7;
        if (r3 == false) goto L6;
        return ArrayListManager.add(r1, r2);
    L6:
        return ArrayListManager.remove(r1, r2);
    L7:
        return r1;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> r0 = (ArrayMap) ZeusTransformUtils.preCheckCast(sRunningAnimators.get(), ArrayMap.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ArrayMap<Animator, AnimationInfo> r1 = new ArrayMap();
        sRunningAnimators.set(r1);
        return r1;
    L6:
        return r0;
    }

    private static boolean isValidMatch(int r2) {
        if (r2 >= 1) goto L5;
    L7:
        return false;
    L5:
        if (r2 > 4) goto L7;
        return true;
    }

    private static boolean isValueChanged(TransitionValues r0, TransitionValues r1, String r2) {
        Object r3 = r0.values.get(r2);
        Object r4 = r1.values.get(r2);
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r3 == null) goto L12;
        if (r4 != null) goto L10;
        return true;
    L10:
        return true ^ r3.equals(r4);
    L12:
        return true;
    }

    private void matchIds(ArrayMap<View, TransitionValues> r9, ArrayMap<View, TransitionValues> r10, SparseArray<View> r11, SparseArray<View> r12) {
        int r0 = r11.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r11.valueAt(r1), View.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L16;
        if (isValidTarget(r2) == false) goto L16;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r12.get(r11.keyAt(r1)), View.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L16;
        if (isValidTarget(r3) == false) goto L16;
        TransitionValues r5 = (TransitionValues) ZeusTransformUtils.preCheckCast(r9.get(r2), TransitionValues.class, "com.obric.memorydata.plugin");
        TransitionValues r4 = (TransitionValues) ZeusTransformUtils.preCheckCast(r10.get(r3), TransitionValues.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L16;
        if (r4 == null) goto L16;
        this.mStartValuesList.add(r5);
        this.mEndValuesList.add(r4);
        r9.remove(r2);
        r10.remove(r3);
    L16:
        r1 = r1 + 1;
        goto L3
    }

    private void matchInstances(ArrayMap<View, TransitionValues> r6, ArrayMap<View, TransitionValues> r7) {
        int r0 = r6.size() - 1;
    L3:
        if (r0 < 0) goto L14;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r6.keyAt(r0), View.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L13;
        if (isValidTarget(r1) == false) goto L13;
        TransitionValues r2 = (TransitionValues) ZeusTransformUtils.preCheckCast(r7.remove(r1), TransitionValues.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
        if (isValidTarget(r2.view) == false) goto L13;
        this.mStartValuesList.add((TransitionValues) ZeusTransformUtils.preCheckCast(r6.removeAt(r0), TransitionValues.class, "com.obric.memorydata.plugin"));
        this.mEndValuesList.add(r2);
    L13:
        r0 = r0 - 1;
        goto L3
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> r9, ArrayMap<View, TransitionValues> r10, LongSparseArray<View> r11, LongSparseArray<View> r12) {
        int r0 = r11.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r11.valueAt(r1), View.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L16;
        if (isValidTarget(r2) == false) goto L16;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r12.get(r11.keyAt(r1)), View.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L16;
        if (isValidTarget(r3) == false) goto L16;
        TransitionValues r5 = (TransitionValues) ZeusTransformUtils.preCheckCast(r9.get(r2), TransitionValues.class, "com.obric.memorydata.plugin");
        TransitionValues r4 = (TransitionValues) ZeusTransformUtils.preCheckCast(r10.get(r3), TransitionValues.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L16;
        if (r4 == null) goto L16;
        this.mStartValuesList.add(r5);
        this.mEndValuesList.add(r4);
        r9.remove(r2);
        r10.remove(r3);
    L16:
        r1 = r1 + 1;
        goto L3
    }

    private void matchNames(ArrayMap<View, TransitionValues> r9, ArrayMap<View, TransitionValues> r10, ArrayMap<String, View> r11, ArrayMap<String, View> r12) {
        int r0 = r11.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r11.valueAt(r1), View.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L16;
        if (isValidTarget(r2) == false) goto L16;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r12.get(r11.keyAt(r1)), View.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L16;
        if (isValidTarget(r3) == false) goto L16;
        TransitionValues r5 = (TransitionValues) ZeusTransformUtils.preCheckCast(r9.get(r2), TransitionValues.class, "com.obric.memorydata.plugin");
        TransitionValues r4 = (TransitionValues) ZeusTransformUtils.preCheckCast(r10.get(r3), TransitionValues.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L16;
        if (r4 == null) goto L16;
        this.mStartValuesList.add(r5);
        this.mEndValuesList.add(r4);
        r9.remove(r2);
        r10.remove(r3);
    L16:
        r1 = r1 + 1;
        goto L3
    }

    private void matchStartAndEnd(TransitionValuesMaps r6, TransitionValuesMaps r7) {
        ArrayMap<View, TransitionValues> r0 = new ArrayMap(r6.mViewValues);
        ArrayMap<View, TransitionValues> r1 = new ArrayMap(r7.mViewValues);
        int r2 = 0;
    L3:
        int[] r3 = this.mMatchOrder;
        if (r2 >= r3.length) goto L19;
        int r4 = r3[r2];
        if (r4 != 1) goto L8;
        matchInstances(r0, r1);
    L18:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r4 != 2) goto L10;
        matchNames(r0, r1, r6.mNameValues, r7.mNameValues);
        goto L18
    L10:
        if (r4 != 3) goto L12;
        matchIds(r0, r1, r6.mIdValues, r7.mIdValues);
        goto L18
    L12:
        if (r4 != 4) goto L18;
        matchItemIds(r0, r1, r6.mItemIdValues, r7.mItemIdValues);
        goto L18
    L19:
        addUnmatched(r0, r1);
    }

    private static int[] parseMatchOrder(String r6) {
        StringTokenizer r0 = new StringTokenizer(r6, ",");
        int[] r7 = new int[r0.countTokens()];
        int r2 = 0;
    L4:
        if (r0.hasMoreTokens() == false) goto L23;
        String r3 = r0.nextToken().trim();
        if ("id".equalsIgnoreCase(r3) == false) goto L9;
        r7[r2] = 3;
    L20:
        r2 = r2 + 1;
        goto L4
    L9:
        if (MATCH_INSTANCE_STR.equalsIgnoreCase(r3) == false) goto L12;
        r7[r2] = 1;
        goto L20
    L12:
        if ("name".equalsIgnoreCase(r3) == false) goto L15;
        r7[r2] = 2;
        goto L20
    L15:
        if (MATCH_ITEM_ID_STR.equalsIgnoreCase(r3) == false) goto L18;
        r7[r2] = 4;
        goto L20
    L18:
        if (r3.isEmpty() == false) goto L22;
        int[] r4 = new int[r7.length - 1];
        System.arraycopy(r7, 0, r4, 0, r2);
        r2 = r2 - 1;
        r7 = r4;
        goto L20
    L22:
        throw new InflateException("Unknown match type in matchOrder: '" + r3 + "'");
    L23:
        return r7;
    }

    private void runAnimator(Animator r2, final ArrayMap<Animator, AnimationInfo> r3) {
        if (r2 == null) goto L5;
        r2.addListener(new AnonymousClass2(this, r3));
        animate(r2);
        return;
    }

    public Transition addListener(TransitionListener r3) {
        TransitionListener r4 = (TransitionListener) ZeusTransformUtils.wrapperContextForParams(r3, TransitionListener.class, "com.obric.memorydata.plugin");
        if (this.mListeners != null) goto L5;
        this.mListeners = new ArrayList();
    L5:
        this.mListeners.add(r4);
        return this;
    }

    public Transition addTarget(int r2) {
        if (r2 == 0) goto L4;
        this.mTargetIds.add(Integer.valueOf(r2));
    L4:
        return this;
    }

    public Transition addTarget(View r2) {
        this.mTargets.add(r2);
        return this;
    }

    public Transition addTarget(Class<?> r2) {
        if (this.mTargetTypes != null) goto L5;
        this.mTargetTypes = new ArrayList();
    L5:
        this.mTargetTypes.add(r2);
        return this;
    }

    public Transition addTarget(String r2) {
        if (this.mTargetNames != null) goto L5;
        this.mTargetNames = new ArrayList();
    L5:
        this.mTargetNames.add(r2);
        return this;
    }

    public void animate(Animator r5) {
        if (r5 != null) goto L5;
        end();
        return;
    L5:
        if (getDuration() < 0) goto L8;
        r5.setDuration(getDuration());
    L8:
        if (getStartDelay() < 0) goto L11;
        r5.setStartDelay(getStartDelay() + r5.getStartDelay());
    L11:
        if (getInterpolator() == null) goto L13;
        r5.setInterpolator(getInterpolator());
    L13:
        r5.addListener(new AnonymousClass3(this));
        r5.start();
    }

    public void cancel() {
        int r0 = this.mCurrentAnimators.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L6;
        ((Animator) ZeusTransformUtils.preCheckCast(this.mCurrentAnimators.get(r0), Animator.class, "com.obric.memorydata.plugin")).cancel();
        goto L3
    L6:
        ArrayList<TransitionListener> r1 = this.mListeners;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.size() <= 0) goto L16;
        ArrayList r2 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mListeners.clone(), ArrayList.class, "com.obric.memorydata.plugin");
        int r3 = r2.size();
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L17;
        ((TransitionListener) ZeusTransformUtils.preCheckCast(r2.get(r4), TransitionListener.class, "com.obric.memorydata.plugin")).onTransitionCancel(this);
        r4 = r4 + 1;
        goto L11
    L17:
        return;
    }

    public abstract void captureEndValues(TransitionValues r1);

    void capturePropagationValues(TransitionValues r6) {
        if (this.mPropagation != null) goto L5;
        return;
    L5:
        if (r6.values.isEmpty() == true) goto L23;
        String[] r0 = this.mPropagation.getPropagationProperties();
        if (r0 != null) goto L9;
        return;
    L9:
        boolean r1 = false;
        int r2 = 0;
    L11:
        if (r2 >= r0.length) goto L16;
        if (r6.values.containsKey(r0[r2]) == false) goto L17;
        r2 = r2 + 1;
    L17:
        if (r1 == true) goto L24;
        this.mPropagation.captureValues(r6);
        return;
    L24:
        return;
    L16:
        r1 = true;
        goto L17
    }

    public abstract void captureStartValues(TransitionValues r1);

    void captureValues(ViewGroup r7, boolean r8) {
        clearValues(r8);
        int r1 = 0;
        if (this.mTargetIds.size() <= 0) goto L5;
    L6:
        ArrayList<String> r0 = this.mTargetNames;
        if (r0 != null) goto L9;
    L10:
        ArrayList<Class<?>> r2 = this.mTargetTypes;
        if (r2 != null) goto L13;
    L16:
        int r3 = 0;
    L18:
        if (r3 >= this.mTargetIds.size()) goto L31;
        View r4 = r7.findViewById(((Integer) ZeusTransformUtils.preCheckCast(this.mTargetIds.get(r3), Integer.class, "com.obric.memorydata.plugin")).intValue());
        if (r4 == null) goto L30;
        TransitionValues r5 = new TransitionValues(r4);
        if (r8 == false) goto L24;
        captureStartValues(r5);
    L25:
        r5.mTargetedTransitions.add(this);
        capturePropagationValues(r5);
        if (r8 == false) goto L28;
        TransitionValuesMaps r6 = this.mStartValues;
    L29:
        addViewValues(r6, r4, r5);
        goto L30
    L28:
        r6 = this.mEndValues;
        goto L29
    L24:
        captureEndValues(r5);
    L30:
        r3 = r3 + 1;
        goto L18
    L31:
        int r9 = 0;
    L33:
        if (r9 >= this.mTargets.size()) goto L43;
        View r10 = (View) ZeusTransformUtils.preCheckCast(this.mTargets.get(r9), View.class, "com.obric.memorydata.plugin");
        TransitionValues r11 = new TransitionValues(r10);
        if (r8 == false) goto L37;
        captureStartValues(r11);
    L38:
        r11.mTargetedTransitions.add(this);
        capturePropagationValues(r11);
        if (r8 == false) goto L41;
        TransitionValuesMaps r12 = this.mStartValues;
    L42:
        addViewValues(r12, r10, r11);
        r9 = r9 + 1;
        goto L33
    L41:
        r12 = this.mEndValues;
        goto L42
    L37:
        captureEndValues(r11);
    L43:
        if (r8 == true) goto L54;
        ArrayMap<String, String> r13 = this.mNameOverrides;
        if (r13 == null) goto L65;
        int r14 = r13.size();
        ArrayList r15 = new ArrayList(r14);
        int r16 = 0;
    L47:
        if (r16 >= r14) goto L49;
        r15.add(this.mStartValues.mNameValues.remove((String) ZeusTransformUtils.preCheckCast(this.mNameOverrides.keyAt(r16), String.class, "com.obric.memorydata.plugin")));
        r16 = r16 + 1;
    L49:
        if (r1 >= r14) goto L66;
        View r17 = (View) ZeusTransformUtils.preCheckCast(r15.get(r1), View.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L53;
        this.mStartValues.mNameValues.put((String) ZeusTransformUtils.preCheckCast(this.mNameOverrides.valueAt(r1), String.class, "com.obric.memorydata.plugin"), r17);
    L53:
        r1 = r1 + 1;
        goto L49
    L66:
        return;
    L65:
        return;
    L54:
        return;
    L13:
        if (r2.isEmpty() == true) goto L16;
    L15:
        captureHierarchy(r7, r8);
        goto L43
    L9:
        if (r0.isEmpty() == false) goto L15;
    L5:
        if (this.mTargets.size() <= 0) goto L15;
        goto L6
    }

    void clearValues(boolean r1) {
        if (r1 == false) goto L4;
        this.mStartValues.mViewValues.clear();
        this.mStartValues.mIdValues.clear();
        TransitionValuesMaps r0 = this.mStartValues;
    L5:
        r0.mItemIdValues.clear();
        return;
    L4:
        this.mEndValues.mViewValues.clear();
        this.mEndValues.mIdValues.clear();
        r0 = this.mEndValues;
        goto L5
    }

    public Transition clone() {
        Transition r3 = (Transition) ZeusTransformUtils.preCheckCast(super.clone(), Transition.class, "com.obric.memorydata.plugin");     // Catch: CloneNotSupportedException -> L5
        r3.mAnimators = new ArrayList();     // Catch: CloneNotSupportedException -> L5
        r3.mStartValues = new TransitionValuesMaps();     // Catch: CloneNotSupportedException -> L5
        r3.mEndValues = new TransitionValuesMaps();     // Catch: CloneNotSupportedException -> L5
        r3.mStartValuesList = null;     // Catch: CloneNotSupportedException -> L5
        r3.mEndValuesList = null;     // Catch: CloneNotSupportedException -> L5
        return r3;
    L5:
        return null;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo66clone() {
        return clone();
    }

    public Animator createAnimator(ViewGroup r1, TransitionValues r2, TransitionValues r3) {
        return null;
    }

    public void createAnimators(ViewGroup r22, TransitionValuesMaps r23, TransitionValuesMaps r24, ArrayList<TransitionValues> r25, ArrayList<TransitionValues> r26) {
        ArrayMap<Animator, AnimationInfo> r8 = getRunningAnimators();
        SparseIntArray r9 = new SparseIntArray();
        int r10 = r25.size();
        long r0 = Long.MAX_VALUE;
        int r12 = 0;
    L4:
        if (r12 >= r10) goto L65;
        TransitionValues r3 = (TransitionValues) ZeusTransformUtils.preCheckCast(r25.get(r12), TransitionValues.class, "com.obric.memorydata.plugin");
        TransitionValues r4 = (TransitionValues) ZeusTransformUtils.preCheckCast(r26.get(r12), TransitionValues.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
    L10:
        if (r4 != null) goto L12;
    L14:
        if (r3 != null) goto L17;
        if (r4 != null) goto L17;
    L16:
        int r16 = r10;
        int r18 = r12;
        long r11 = r0;
    L64:
        r0 = r11;
        r12 = r18 + 1;
        r10 = r16;
    L17:
        if (r3 == null) goto L23;
        if (r4 == null) goto L23;
        if (isTransitionRequired(r3, r4) == true) goto L23;
        boolean r15 = false;
    L24:
        if (r15 == false) goto L16;
        Animator r17 = createAnimator(r22, r3, r4);
        if (r17 == null) goto L16;
        if (r4 == null) goto L56;
        View r5 = r4.view;
        String[] r13 = getTransitionProperties();
        if (r13 == null) goto L53;
        r16 = r10;
        if (r13.length <= 0) goto L54;
        TransitionValues r14 = new TransitionValues(r5);
        TransitionValues r19 = (TransitionValues) ZeusTransformUtils.preCheckCast(r24.mViewValues.get(r5), TransitionValues.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L39;
        int r110 = 0;
    L36:
        if (r110 >= r13.length) goto L38;
        int r111 = r12;
        long r112 = r0;
        r14.values.put(r13[r110], r19.values.get(r13[r110]));
        r110 = r110 + 1;
        r12 = r111;
        r0 = r112;
        goto L36
    L38:
        r0 = r0;
        r18 = r12;
    L40:
        int r1 = r8.size();
        int r2 = 0;
    L41:
        if (r2 >= r1) goto L55;
        AnimationInfo r113 = (AnimationInfo) ZeusTransformUtils.preCheckCast(r8.get((Animator) ZeusTransformUtils.preCheckCast(r8.keyAt(r2), Animator.class, "com.obric.memorydata.plugin")), AnimationInfo.class, "com.obric.memorydata.plugin");
        if (r113.mValues == null) goto L51;
        if (r113.mView != r5) goto L51;
        if (r113.mName.equals(getName()) == false) goto L51;
        if (r113.mValues.equals(r14) == false) goto L51;
        r17 = null;
    L51:
        r2 = r2 + 1;
    L55:
        View r6 = r5;
        TransitionValues r7 = r14;
        r17 = r17;
    L57:
        if (r17 == null) goto L63;
        TransitionPropagation r20 = this.mPropagation;
        if (r20 == null) goto L61;
        long r21 = r20.getStartDelay(r22, this, r3, r4);
        r9.put(this.mAnimators.size(), (int) r21);
        r11 = Math.min(r21, r0);
    L62:
        r8.put(r17, new AnimationInfo(r6, getName(), this, ViewUtils.getWindowId(r22), r7));
        this.mAnimators.add(r17);
        goto L64
    L61:
        r11 = r0;
        goto L62
    L63:
        r11 = r0;
        goto L64
    L39:
        r0 = r0;
        r18 = r12;
    L54:
        r18 = r12;
        r17 = r17;
        r14 = null;
        goto L55
    L53:
        r16 = r10;
        goto L54
    L56:
        r0 = r0;
        r16 = r10;
        r18 = r12;
        r6 = r3.view;
        r7 = null;
    L23:
        r15 = true;
        goto L24
    L12:
        if (r4.mTargetedTransitions.contains(this) == true) goto L14;
        r4 = null;
        goto L14
    L8:
        if (r3.mTargetedTransitions.contains(this) == true) goto L10;
        r3 = null;
        goto L10
    L65:
        long r114 = r0;
        if (r9.size() == 0) goto L71;
        int r27 = 0;
    L69:
        if (r27 >= r9.size()) goto L84;
        int r28 = r9.keyAt(r27);
        Animator r29 = (Animator) ZeusTransformUtils.preCheckCast(this.mAnimators.get(r28), Animator.class, "com.obric.memorydata.plugin");
        r29.setStartDelay((((long) r9.valueAt(r27)) - r114) + r29.getStartDelay());
        r27 = r27 + 1;
        goto L69
    L84:
        return;
    }

    public void end() {
        int r0 = this.mNumInstances - 1;
        this.mNumInstances = r0;
        if (r0 != 0) goto L34;
        ArrayList<TransitionListener> r1 = this.mListeners;
        if (r1 != null) goto L7;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= this.mStartValues.mItemIdValues.size()) goto L18;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.mStartValues.mItemIdValues.valueAt(r2), View.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L17;
        ViewCompat.setHasTransientState(r4, false);
    L17:
        r2 = r2 + 1;
        goto L13
    L18:
        int r3 = 0;
    L20:
        if (r3 >= this.mEndValues.mItemIdValues.size()) goto L25;
        View r5 = (View) ZeusTransformUtils.preCheckCast(this.mEndValues.mItemIdValues.valueAt(r3), View.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L24;
        ViewCompat.setHasTransientState(r5, false);
    L24:
        r3 = r3 + 1;
        goto L20
    L25:
        this.mEnded = true;
        return;
    L7:
        if (r1.size() <= 0) goto L11;
        ArrayList r6 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mListeners.clone(), ArrayList.class, "com.obric.memorydata.plugin");
        int r7 = r6.size();
        int r8 = 0;
    L9:
        if (r8 >= r7) goto L11;
        ((TransitionListener) ZeusTransformUtils.preCheckCast(r6.get(r8), TransitionListener.class, "com.obric.memorydata.plugin")).onTransitionEnd(this);
        r8 = r8 + 1;
        goto L9
    }

    public Transition excludeChildren(int r2, boolean r3) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, r2, r3);
        return this;
    }

    public Transition excludeChildren(View r2, boolean r3) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, r2, r3);
        return this;
    }

    public Transition excludeChildren(Class<?> r2, boolean r3) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, r2, r3);
        return this;
    }

    public Transition excludeTarget(int r2, boolean r3) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, r2, r3);
        return this;
    }

    public Transition excludeTarget(View r2, boolean r3) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, r2, r3);
        return this;
    }

    public Transition excludeTarget(Class<?> r2, boolean r3) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, r2, r3);
        return this;
    }

    public Transition excludeTarget(String r2, boolean r3) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, r2, r3);
        return this;
    }

    void forceToEnd(ViewGroup r5) {
        ArrayMap<Animator, AnimationInfo> r4 = getRunningAnimators();
        int r0 = r4.size();
        if (r5 == null) goto L15;
        if (r0 == 0) goto L21;
        WindowIdImpl r6 = ViewUtils.getWindowId(r5);
        ArrayMap r1 = new ArrayMap(r4);
        r4.clear();
        int r2 = r0 - 1;
    L7:
        if (r2 < 0) goto L22;
        AnimationInfo r7 = (AnimationInfo) ZeusTransformUtils.preCheckCast(r1.valueAt(r2), AnimationInfo.class, "com.obric.memorydata.plugin");
        if (r7.mView == null) goto L14;
        if (r6 == null) goto L14;
        if (r6.equals(r7.mWindowId) == false) goto L14;
        ((Animator) ZeusTransformUtils.preCheckCast(r1.keyAt(r2), Animator.class, "com.obric.memorydata.plugin")).end();
    L14:
        r2 = r2 - 1;
        goto L7
    L22:
        return;
    L21:
        return;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        EpicenterCallback r0 = this.mEpicenterCallback;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.onGetEpicenter(this);
    }

    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    TransitionValues getMatchedTransitionValues(View r9, boolean r10) {
        TransitionSet r0 = this.mParent;
        if (r0 != null) goto L5;
        if (r10 == false) goto L8;
        ArrayList<TransitionValues> r1 = this.mStartValuesList;
    L10:
        if (r1 != null) goto L12;
        return null;
    L12:
        int r2 = r1.size();
        int r3 = -1;
        int r4 = 0;
    L14:
        if (r4 >= r2) goto L22;
        TransitionValues r6 = (TransitionValues) ZeusTransformUtils.preCheckCast(r1.get(r4), TransitionValues.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L17;
        if (r6.view == r9) goto L20;
        r4 = r4 + 1;
        goto L14
    L20:
        r3 = r4;
        goto L22
    L17:
        return null;
    L22:
        if (r3 < 0) goto L31;
        if (r10 == false) goto L25;
        ArrayList<TransitionValues> r8 = this.mEndValuesList;
    L27:
        return (TransitionValues) ZeusTransformUtils.preCheckCast(r8.get(r3), TransitionValues.class, "com.obric.memorydata.plugin");
    L25:
        r8 = this.mStartValuesList;
        goto L27
    L31:
        return null;
    L8:
        r1 = this.mEndValuesList;
        goto L10
    L5:
        return r0.getMatchedTransitionValues(r9, r10);
    }

    public String getName() {
        return this.mName;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public TransitionValues getTransitionValues(View r2, boolean r3) {
        TransitionSet r0 = this.mParent;
        if (r0 != null) goto L5;
        if (r3 == false) goto L8;
        TransitionValuesMaps r1 = this.mStartValues;
    L10:
        return (TransitionValues) ZeusTransformUtils.preCheckCast(r1.mViewValues.get(r2), TransitionValues.class, "com.obric.memorydata.plugin");
    L8:
        r1 = this.mEndValues;
        goto L10
    L5:
        return r0.getTransitionValues(r2, r3);
    }

    public boolean isTransitionRequired(TransitionValues r6, TransitionValues r7) {
        if (r6 == null) goto L25;
        if (r7 == null) goto L26;
        String[] r5 = getTransitionProperties();
        if (r5 == null) goto L13;
        int r2 = r5.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L27;
        if (isValueChanged(r6, r7, r5[r3]) == true) goto L19;
        r3 = r3 + 1;
    L19:
        return true;
    L27:
        return false;
    L13:
        Iterator<String> r8 = r6.values.keySet().iterator();
    L15:
        if (r8.hasNext() == false) goto L28;
        if (isValueChanged(r6, r7, (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L15;
    L28:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    boolean isValidTarget(View r8) {
        int r0 = r8.getId();
        ArrayList<Integer> r1 = this.mTargetIdExcludes;
        if (r1 != null) goto L5;
    L7:
        ArrayList<View> r2 = this.mTargetExcludes;
        if (r2 != null) goto L10;
    L12:
        ArrayList<Class<?>> r3 = this.mTargetTypeExcludes;
        if (r3 == null) goto L21;
        int r4 = r3.size();
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L21;
        if (ZeusTransformUtils.instanceOf((Class) ZeusTransformUtils.preCheckCast(this.mTargetTypeExcludes.get(r5), Class.class, "com.obric.memorydata.plugin"), r8) == true) goto L18;
        r5 = r5 + 1;
        goto L15
    L18:
        return false;
    L21:
        if (this.mTargetNameExcludes == null) goto L28;
        if (ViewCompat.getTransitionName(r8) == null) goto L28;
        if (this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(r8)) == false) goto L28;
        return false;
    L28:
        if (this.mTargetIds.size() != 0) goto L41;
        if (this.mTargets.size() != 0) goto L41;
        ArrayList<Class<?>> r6 = this.mTargetTypes;
        if (r6 != null) goto L34;
    L35:
        ArrayList<String> r7 = this.mTargetNames;
        if (r7 != null) goto L38;
    L39:
        return true;
    L38:
        if (r7.isEmpty() == false) goto L41;
    L34:
        if (r6.isEmpty() == true) goto L35;
    L41:
        if (this.mTargetIds.contains(Integer.valueOf(r0)) == false) goto L43;
    L60:
        return true;
    L43:
        if (this.mTargets.contains(r8) == true) goto L60;
        ArrayList<String> r9 = this.mTargetNames;
        if (r9 == null) goto L51;
        if (r9.contains(ViewCompat.getTransitionName(r8)) == false) goto L51;
        return true;
    L51:
        if (this.mTargetTypes == null) goto L59;
        int r10 = 0;
    L54:
        if (r10 >= this.mTargetTypes.size()) goto L59;
        if (ZeusTransformUtils.instanceOf((Class) ZeusTransformUtils.preCheckCast(this.mTargetTypes.get(r10), Class.class, "com.obric.memorydata.plugin"), r8) == true) goto L57;
        r10 = r10 + 1;
        goto L54
    L57:
        return true;
    L59:
        return false;
    L10:
        if (r2.contains(r8) == false) goto L12;
        return false;
    L5:
        if (r1.contains(Integer.valueOf(r0)) == false) goto L7;
        return false;
    }

    public void pause(View r7) {
        if (this.mEnded == true) goto L27;
        ArrayMap<Animator, AnimationInfo> r0 = getRunningAnimators();
        int r1 = r0.size();
        WindowIdImpl r8 = ViewUtils.getWindowId(r7);
        int r2 = r1 - 1;
    L6:
        if (r2 < 0) goto L13;
        AnimationInfo r4 = (AnimationInfo) ZeusTransformUtils.preCheckCast(r0.valueAt(r2), AnimationInfo.class, "com.obric.memorydata.plugin");
        if (r4.mView == null) goto L12;
        if (r8.equals(r4.mWindowId) == false) goto L12;
        AnimatorUtils.pause((Animator) ZeusTransformUtils.preCheckCast(r0.keyAt(r2), Animator.class, "com.obric.memorydata.plugin"));
    L12:
        r2 = r2 - 1;
        goto L6
    L13:
        ArrayList<TransitionListener> r9 = this.mListeners;
        if (r9 != null) goto L16;
    L20:
        this.mPaused = true;
        return;
    L16:
        if (r9.size() <= 0) goto L20;
        ArrayList r10 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mListeners.clone(), ArrayList.class, "com.obric.memorydata.plugin");
        int r3 = r10.size();
        int r5 = 0;
    L18:
        if (r5 >= r3) goto L20;
        ((TransitionListener) ZeusTransformUtils.preCheckCast(r10.get(r5), TransitionListener.class, "com.obric.memorydata.plugin")).onTransitionPause(this);
        r5 = r5 + 1;
        goto L18
    }

    void playTransition(ViewGroup r12) {
        this.mStartValuesList = new ArrayList();
        this.mEndValuesList = new ArrayList();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> r0 = getRunningAnimators();
        int r1 = r0.size();
        WindowIdImpl r2 = ViewUtils.getWindowId(r12);
        int r3 = r1 - 1;
    L3:
        if (r3 < 0) goto L31;
        Animator r4 = (Animator) ZeusTransformUtils.preCheckCast(r0.keyAt(r3), Animator.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L30;
        AnimationInfo r5 = (AnimationInfo) ZeusTransformUtils.preCheckCast(r0.get(r4), AnimationInfo.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L30;
        if (r5.mView == null) goto L30;
        if (r2.equals(r5.mWindowId) == false) goto L30;
        TransitionValues r7 = r5.mValues;
        View r8 = r5.mView;
        TransitionValues r9 = getTransitionValues(r8, true);
        TransitionValues r10 = getMatchedTransitionValues(r8, true);
        if (r9 != null) goto L16;
        if (r10 != null) goto L16;
        r10 = (TransitionValues) ZeusTransformUtils.preCheckCast(this.mEndValues.mViewValues.get(r8), TransitionValues.class, "com.obric.memorydata.plugin");
    L16:
        if (r9 != null) goto L19;
        if (r10 != null) goto L19;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == false) goto L30;
        if (r4.isRunning() == false) goto L26;
    L29:
        r4.cancel();
        goto L30
    L26:
        if (r4.isStarted() == true) goto L29;
        r0.remove(r4);
    L19:
        if (r5.mTransition.isTransitionRequired(r7, r10) == false) goto L21;
        r6 = true;
    L30:
        r3 = r3 - 1;
        goto L3
    L31:
        createAnimators(r12, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public Transition removeListener(TransitionListener r3) {
        TransitionListener r4 = (TransitionListener) ZeusTransformUtils.wrapperContextForParams(r3, TransitionListener.class, "com.obric.memorydata.plugin");
        ArrayList<TransitionListener> r0 = this.mListeners;
        if (r0 != null) goto L5;
        return this;
    L5:
        r0.remove(r4);
        if (this.mListeners.size() != 0) goto L8;
        this.mListeners = null;
    L8:
        return this;
    }

    public Transition removeTarget(int r2) {
        if (r2 == 0) goto L4;
        this.mTargetIds.remove(Integer.valueOf(r2));
    L4:
        return this;
    }

    public Transition removeTarget(View r2) {
        this.mTargets.remove(r2);
        return this;
    }

    public Transition removeTarget(Class<?> r2) {
        ArrayList<Class<?>> r0 = this.mTargetTypes;
        if (r0 == null) goto L5;
        r0.remove(r2);
    L5:
        return this;
    }

    public Transition removeTarget(String r2) {
        ArrayList<String> r0 = this.mTargetNames;
        if (r0 == null) goto L5;
        r0.remove(r2);
    L5:
        return this;
    }

    public void resume(View r7) {
        if (this.mPaused == true) goto L5;
        return;
    L5:
        if (this.mEnded == true) goto L22;
        ArrayMap<Animator, AnimationInfo> r0 = getRunningAnimators();
        int r2 = r0.size();
        WindowIdImpl r8 = ViewUtils.getWindowId(r7);
    L7:
        r2 = r2 - 1;
        if (r2 < 0) goto L15;
        AnimationInfo r4 = (AnimationInfo) ZeusTransformUtils.preCheckCast(r0.valueAt(r2), AnimationInfo.class, "com.obric.memorydata.plugin");
        if (r4.mView == null) goto L7;
        if (r8.equals(r4.mWindowId) == false) goto L7;
        AnimatorUtils.resume((Animator) ZeusTransformUtils.preCheckCast(r0.keyAt(r2), Animator.class, "com.obric.memorydata.plugin"));
        goto L7
    L15:
        ArrayList<TransitionListener> r9 = this.mListeners;
        if (r9 == null) goto L22;
        if (r9.size() <= 0) goto L22;
        ArrayList r10 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mListeners.clone(), ArrayList.class, "com.obric.memorydata.plugin");
        int r1 = r10.size();
        int r3 = 0;
    L20:
        if (r3 >= r1) goto L22;
        ((TransitionListener) ZeusTransformUtils.preCheckCast(r10.get(r3), TransitionListener.class, "com.obric.memorydata.plugin")).onTransitionResume(this);
        r3 = r3 + 1;
    L22:
        this.mPaused = false;
    }

    public void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> r0 = getRunningAnimators();
        Iterator<Animator> r1 = this.mAnimators.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Animator r2 = (Animator) ZeusTransformUtils.preCheckCast(r1.next(), Animator.class, "com.obric.memorydata.plugin");
        if (r0.containsKey(r2) == false) goto L4;
        start();
        runAnimator(r2, r0);
        goto L4
    L8:
        this.mAnimators.clear();
        end();
    }

    void setCanRemoveViews(boolean r1) {
        this.mCanRemoveViews = r1;
    }

    public Transition setDuration(long r1) {
        this.mDuration = r1;
        return this;
    }

    public void setEpicenterCallback(EpicenterCallback r1) {
        this.mEpicenterCallback = r1;
    }

    public Transition setInterpolator(TimeInterpolator r3) {
        this.mInterpolator = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r3, TimeInterpolator.class, "com.obric.memorydata.plugin");
        return this;
    }

    public void setMatchOrder(int... r3) {
        if (r3 != null) goto L4;
    L19:
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        return;
    L4:
        if (r3.length == 0) goto L19;
        int r0 = 0;
    L8:
        if (r0 >= r3.length) goto L18;
        if (isValidMatch(r3[r0]) == false) goto L17;
        if (alreadyContains(r3, r0) == true) goto L15;
        r0 = r0 + 1;
        goto L8
    L15:
        throw new IllegalArgumentException("matches contains a duplicate value");
    L17:
        throw new IllegalArgumentException("matches contains invalid value");
    L18:
        this.mMatchOrder = (int[]) ZeusTransformUtils.preCheckCast(r3.clone(), int[].class, "com.obric.memorydata.plugin");
    }

    public void setPathMotion(PathMotion r1) {
        if (r1 != null) goto L4;
        r1 = STRAIGHT_PATH_MOTION;
    L4:
        this.mPathMotion = r1;
    }

    public void setPropagation(TransitionPropagation r1) {
        this.mPropagation = r1;
    }

    Transition setSceneRoot(ViewGroup r1) {
        this.mSceneRoot = r1;
        return this;
    }

    public Transition setStartDelay(long r1) {
        this.mStartDelay = r1;
        return this;
    }

    public void start() {
        if (this.mNumInstances != 0) goto L12;
        ArrayList<TransitionListener> r0 = this.mListeners;
        if (r0 != null) goto L7;
    L11:
        this.mEnded = false;
        goto L12
    L7:
        if (r0.size() <= 0) goto L11;
        ArrayList r1 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mListeners.clone(), ArrayList.class, "com.obric.memorydata.plugin");
        int r2 = r1.size();
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L11;
        ((TransitionListener) ZeusTransformUtils.preCheckCast(r1.get(r4), TransitionListener.class, "com.obric.memorydata.plugin")).onTransitionStart(this);
        r4 = r4 + 1;
    L12:
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    String toString(String r7) {
        String r8 = r7 + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration == (-1)) goto L6;
        r8 = r8 + "dur(" + this.mDuration + ") ";
    L6:
        if (this.mStartDelay == (-1)) goto L9;
        r8 = r8 + "dly(" + this.mStartDelay + ") ";
    L9:
        if (this.mInterpolator == null) goto L12;
        r8 = r8 + "interp(" + this.mInterpolator + ") ";
    L12:
        if (this.mTargetIds.size() <= 0) goto L14;
    L15:
        String r9 = r8 + "tgts(";
        int r2 = 0;
        if (this.mTargetIds.size() <= 0) goto L24;
        int r0 = 0;
    L19:
        if (r0 >= this.mTargetIds.size()) goto L24;
        if (r0 <= 0) goto L22;
        r9 = r9 + ", ";
    L22:
        r9 = r9 + this.mTargetIds.get(r0);
        r0 = r0 + 1;
    L24:
        if (this.mTargets.size() <= 0) goto L31;
    L26:
        if (r2 >= this.mTargets.size()) goto L31;
        if (r2 <= 0) goto L29;
        r9 = r9 + ", ";
    L29:
        r9 = r9 + this.mTargets.get(r2);
        r2 = r2 + 1;
    L31:
        return r9 + ")";
    L14:
        if (this.mTargets.size() > 0) goto L15;
        return r8;
    }
}
