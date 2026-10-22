package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
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
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
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

        AnimationInfo(View r10, String r11, Transition r12, WindowIdImpl r13, TransitionValues r14) {
            this.mView = r10;
            this.mName = r11;
            this.mValues = r14;
            this.mWindowId = r13;
            this.mTransition = r12;
        }
    }

    private static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> add(ArrayList<T> r10, T r11) {
            if (r10 != null) goto L5;
            r10 = new ArrayList();
        L5:
            if (r10.contains(r11) == true) goto L7;
            r10.add(r11);
        L7:
            return r10;
        }

        static <T> ArrayList<T> remove(ArrayList<T> r10, T r11) {
            if (r10 == null) goto L7;
            r10.remove(r11);
            if (r10.isEmpty() == false) goto L8;
            return null;
        L8:
            return r10;
        L7:
            return r10;
        }
    }

    public static abstract class EpicenterCallback {
        public EpicenterCallback() {
        }

        public abstract Rect onGetEpicenter(@NonNull Transition r10);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface MatchOrder {
    }

    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition r10);

        void onTransitionEnd(@NonNull Transition r10);

        void onTransitionPause(@NonNull Transition r10);

        void onTransitionResume(@NonNull Transition r10);

        void onTransitionStart(@NonNull Transition r10);
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

    @SuppressLint({"RestrictedApi"})
    public Transition(Context r10, AttributeSet r11) {
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
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.TRANSITION);
        XmlResourceParser r13 = (XmlResourceParser) r11;
        long r14 = TypedArrayUtils.getNamedInt(r12, r13, "duration", 1, -1);
        if (r14 < 0) goto L5;
        setDuration(r14);
    L5:
        long r15 = TypedArrayUtils.getNamedInt(r12, r13, "startDelay", 2, -1);
        if (r15 <= 0) goto L8;
        setStartDelay(r15);
    L8:
        int r16 = TypedArrayUtils.getNamedResourceId(r12, r13, "interpolator", 0, 0);
        if (r16 <= 0) goto L11;
        setInterpolator(AnimationUtils.loadInterpolator(r10, r16));
    L11:
        String r17 = TypedArrayUtils.getNamedString(r12, r13, "matchOrder", 3);
        if (r17 == null) goto L14;
        setMatchOrder(parseMatchOrder(r17));
    L14:
        r12.recycle();
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> r10, ArrayMap<View, TransitionValues> r11) {
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r10.size()) goto L10;
        TransitionValues r14 = r10.valueAt(r13);
        if (isValidTarget(r14.view) == false) goto L8;
        this.mStartValuesList.add(r14);
        this.mEndValuesList.add(null);
    L8:
        r13 = r13 + 1;
    L10:
        if (r12 >= r11.size()) goto L15;
        TransitionValues r15 = r11.valueAt(r12);
        if (isValidTarget(r15.view) == false) goto L14;
        this.mEndValuesList.add(r15);
        this.mStartValuesList.add(null);
    L14:
        r12 = r12 + 1;
        goto L10
    }

    private static void addViewValues(TransitionValuesMaps r10, View r11, TransitionValues r12) {
        r10.mViewValues.put(r11, r12);
        int r13 = r11.getId();
        if (r13 >= 0) goto L5;
    L8:
        String r14 = ViewCompat.getTransitionName(r11);
        if (r14 == null) goto L15;
        if (r10.mNameValues.containsKey(r14) == false) goto L13;
        r10.mNameValues.put(r14, null);
        goto L15
    L13:
        r10.mNameValues.put(r14, r11);
    L15:
        if ((r11.getParent() instanceof ListView) == false) goto L25;
        ListView r15 = (ListView) r11.getParent();
        if (r15.getAdapter().hasStableIds() == false) goto L26;
        long r16 = r15.getItemIdAtPosition(r15.getPositionForView(r11));
        if (r10.mItemIdValues.indexOfKey(r16) < 0) goto L23;
        View r17 = r10.mItemIdValues.get(r16);
        if (r17 == null) goto L27;
        ViewCompat.setHasTransientState(r17, false);
        r10.mItemIdValues.put(r16, null);
        return;
    L27:
        return;
    L23:
        ViewCompat.setHasTransientState(r11, true);
        r10.mItemIdValues.put(r16, r11);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (r10.mIdValues.indexOfKey(r13) < 0) goto L7;
        r10.mIdValues.put(r13, null);
        goto L8
    L7:
        r10.mIdValues.put(r13, r11);
        goto L8
    }

    private static boolean alreadyContains(int[] r10, int r11) {
        int r12 = r10[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L9;
        if (r10[r13] == r12) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void captureHierarchy(View r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r12 = r10.getId();
        ArrayList<Integer> r13 = this.mTargetIdExcludes;
        if (r13 != null) goto L7;
    L9:
        ArrayList<View> r14 = this.mTargetExcludes;
        if (r14 != null) goto L12;
    L14:
        ArrayList<Class<?>> r15 = this.mTargetTypeExcludes;
        int r16 = 0;
        if (r15 == null) goto L23;
        int r17 = r15.size();
        int r18 = 0;
    L17:
        if (r18 >= r17) goto L23;
        if (this.mTargetTypeExcludes.get(r18).isInstance(r10) == true) goto L20;
        r18 = r18 + 1;
        goto L17
    L20:
        return;
    L23:
        if ((r10.getParent() instanceof ViewGroup) == false) goto L34;
        TransitionValues r19 = new TransitionValues(r10);
        if (r11 == false) goto L27;
        captureStartValues(r19);
    L28:
        r19.mTargetedTransitions.add(this);
        capturePropagationValues(r19);
        if (r11 == false) goto L31;
        TransitionValuesMaps r20 = this.mStartValues;
    L32:
        addViewValues(r20, r10, r19);
        goto L34
    L31:
        r20 = this.mEndValues;
        goto L32
    L27:
        captureEndValues(r19);
    L34:
        if ((r10 instanceof ViewGroup) == false) goto L57;
        ArrayList<Integer> r21 = this.mTargetIdChildExcludes;
        if (r21 != null) goto L38;
    L40:
        ArrayList<View> r22 = this.mTargetChildExcludes;
        if (r22 != null) goto L43;
    L45:
        ArrayList<Class<?>> r23 = this.mTargetTypeChildExcludes;
        if (r23 == null) goto L53;
        int r24 = r23.size();
        int r25 = 0;
    L48:
        if (r25 >= r24) goto L53;
        if (this.mTargetTypeChildExcludes.get(r25).isInstance(r10) == true) goto L51;
        r25 = r25 + 1;
        goto L48
    L51:
        return;
    L53:
        ViewGroup r26 = (ViewGroup) r10;
    L55:
        if (r16 >= r26.getChildCount()) goto L63;
        captureHierarchy(r26.getChildAt(r16), r11);
        r16 = r16 + 1;
        goto L55
    L63:
        return;
    L43:
        if (r22.contains(r10) == false) goto L45;
        return;
    L38:
        if (r21.contains(Integer.valueOf(r12)) == false) goto L40;
        return;
    L57:
        return;
    L12:
        if (r14.contains(r10) == false) goto L14;
        return;
    L7:
        if (r13.contains(Integer.valueOf(r12)) == false) goto L9;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> r10, int r11, boolean r12) {
        if (r11 <= 0) goto L8;
        Integer r13 = Integer.valueOf(r11);
        if (r12 == false) goto L7;
        return ArrayListManager.add(r10, r13);
    L7:
        return ArrayListManager.remove(r10, r13);
    L8:
        return r10;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> r10, T r11, boolean r12) {
        if (r11 == null) goto L7;
        if (r12 == false) goto L6;
        return ArrayListManager.add(r10, r11);
    L6:
        return ArrayListManager.remove(r10, r11);
    L7:
        return r10;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> r10, Class<?> r11, boolean r12) {
        if (r11 == null) goto L7;
        if (r12 == false) goto L6;
        return ArrayListManager.add(r10, r11);
    L6:
        return ArrayListManager.remove(r10, r11);
    L7:
        return r10;
    }

    private ArrayList<View> excludeView(ArrayList<View> r10, View r11, boolean r12) {
        if (r11 == null) goto L7;
        if (r12 == false) goto L6;
        return ArrayListManager.add(r10, r11);
    L6:
        return ArrayListManager.remove(r10, r11);
    L7:
        return r10;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> r10 = sRunningAnimators.get();
        if (r10 != null) goto L6;
        ArrayMap<Animator, AnimationInfo> r11 = new ArrayMap();
        sRunningAnimators.set(r11);
        return r11;
    L6:
        return r10;
    }

    private static boolean isValidMatch(int r10) {
        if (r10 >= 1) goto L5;
    L7:
        return false;
    L5:
        if (r10 > 4) goto L7;
        return true;
    }

    private static boolean isValueChanged(TransitionValues r10, TransitionValues r11, String r12) {
        Object r13 = r10.values.get(r12);
        Object r14 = r11.values.get(r12);
        if (r13 != null) goto L6;
        if (r14 != null) goto L6;
        return false;
    L6:
        if (r13 == null) goto L12;
        if (r14 != null) goto L10;
        return true;
    L10:
        return true ^ r13.equals(r14);
    L12:
        return true;
    }

    private void matchIds(ArrayMap<View, TransitionValues> r10, ArrayMap<View, TransitionValues> r11, SparseArray<View> r12, SparseArray<View> r13) {
        int r14 = r12.size();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L17;
        View r16 = r12.valueAt(r15);
        if (r16 == null) goto L16;
        if (isValidTarget(r16) == false) goto L16;
        View r17 = r13.get(r12.keyAt(r15));
        if (r17 == null) goto L16;
        if (isValidTarget(r17) == false) goto L16;
        TransitionValues r18 = r10.get(r16);
        TransitionValues r19 = r11.get(r17);
        if (r18 == null) goto L16;
        if (r19 == null) goto L16;
        this.mStartValuesList.add(r18);
        this.mEndValuesList.add(r19);
        r10.remove(r16);
        r11.remove(r17);
    L16:
        r15 = r15 + 1;
        goto L3
    }

    private void matchInstances(ArrayMap<View, TransitionValues> r10, ArrayMap<View, TransitionValues> r11) {
        int r12 = r10.size() - 1;
    L3:
        if (r12 < 0) goto L14;
        View r13 = r10.keyAt(r12);
        if (r13 == null) goto L13;
        if (isValidTarget(r13) == false) goto L13;
        TransitionValues r14 = r11.remove(r13);
        if (r14 == null) goto L13;
        if (isValidTarget(r14.view) == false) goto L13;
        this.mStartValuesList.add(r10.removeAt(r12));
        this.mEndValuesList.add(r14);
    L13:
        r12 = r12 - 1;
        goto L3
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> r10, ArrayMap<View, TransitionValues> r11, LongSparseArray<View> r12, LongSparseArray<View> r13) {
        int r14 = r12.size();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L17;
        View r16 = r12.valueAt(r15);
        if (r16 == null) goto L16;
        if (isValidTarget(r16) == false) goto L16;
        View r17 = r13.get(r12.keyAt(r15));
        if (r17 == null) goto L16;
        if (isValidTarget(r17) == false) goto L16;
        TransitionValues r18 = r10.get(r16);
        TransitionValues r19 = r11.get(r17);
        if (r18 == null) goto L16;
        if (r19 == null) goto L16;
        this.mStartValuesList.add(r18);
        this.mEndValuesList.add(r19);
        r10.remove(r16);
        r11.remove(r17);
    L16:
        r15 = r15 + 1;
        goto L3
    }

    private void matchNames(ArrayMap<View, TransitionValues> r10, ArrayMap<View, TransitionValues> r11, ArrayMap<String, View> r12, ArrayMap<String, View> r13) {
        int r14 = r12.size();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L17;
        View r16 = r12.valueAt(r15);
        if (r16 == null) goto L16;
        if (isValidTarget(r16) == false) goto L16;
        View r17 = r13.get(r12.keyAt(r15));
        if (r17 == null) goto L16;
        if (isValidTarget(r17) == false) goto L16;
        TransitionValues r18 = r10.get(r16);
        TransitionValues r19 = r11.get(r17);
        if (r18 == null) goto L16;
        if (r19 == null) goto L16;
        this.mStartValuesList.add(r18);
        this.mEndValuesList.add(r19);
        r10.remove(r16);
        r11.remove(r17);
    L16:
        r15 = r15 + 1;
        goto L3
    }

    private void matchStartAndEnd(TransitionValuesMaps r10, TransitionValuesMaps r11) {
        ArrayMap<View, TransitionValues> r12 = new ArrayMap(r10.mViewValues);
        ArrayMap<View, TransitionValues> r13 = new ArrayMap(r11.mViewValues);
        int r14 = 0;
    L3:
        int[] r15 = this.mMatchOrder;
        if (r14 >= r15.length) goto L19;
        int r16 = r15[r14];
        if (r16 != 1) goto L8;
        matchInstances(r12, r13);
    L18:
        r14 = r14 + 1;
        goto L3
    L8:
        if (r16 != 2) goto L10;
        matchNames(r12, r13, r10.mNameValues, r11.mNameValues);
        goto L18
    L10:
        if (r16 != 3) goto L12;
        matchIds(r12, r13, r10.mIdValues, r11.mIdValues);
        goto L18
    L12:
        if (r16 != 4) goto L18;
        matchItemIds(r12, r13, r10.mItemIdValues, r11.mItemIdValues);
        goto L18
    L19:
        addUnmatched(r12, r13);
    }

    private static int[] parseMatchOrder(String r10) {
        StringTokenizer r11 = new StringTokenizer(r10, ",");
        int[] r12 = new int[r11.countTokens()];
        int r13 = 0;
    L4:
        if (r11.hasMoreTokens() == false) goto L23;
        String r14 = r11.nextToken().trim();
        if ("id".equalsIgnoreCase(r14) == false) goto L9;
        r12[r13] = 3;
    L20:
        r13 = r13 + 1;
        goto L4
    L9:
        if (MATCH_INSTANCE_STR.equalsIgnoreCase(r14) == false) goto L12;
        r12[r13] = 1;
        goto L20
    L12:
        if ("name".equalsIgnoreCase(r14) == false) goto L15;
        r12[r13] = 2;
        goto L20
    L15:
        if (MATCH_ITEM_ID_STR.equalsIgnoreCase(r14) == false) goto L18;
        r12[r13] = 4;
        goto L20
    L18:
        if (r14.isEmpty() == false) goto L22;
        int[] r15 = new int[r12.length - 1];
        System.arraycopy(r12, 0, r15, 0, r13);
        r13 = r13 - 1;
        r12 = r15;
        goto L20
    L22:
        throw new InflateException("Unknown match type in matchOrder: '" + r14 + "'");
    L23:
        return r12;
    }

    private void runAnimator(Animator r10, final ArrayMap<Animator, AnimationInfo> r11) {
        if (r10 == null) goto L5;
        r10.addListener(new AnonymousClass2(this, r11));
        animate(r10);
        return;
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener r10) {
        if (this.mListeners != null) goto L5;
        this.mListeners = new ArrayList();
    L5:
        this.mListeners.add(r10);
        return this;
    }

    @NonNull
    public Transition addTarget(@IdRes int r10) {
        if (r10 == 0) goto L4;
        this.mTargetIds.add(Integer.valueOf(r10));
    L4:
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull View r10) {
        this.mTargets.add(r10);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull Class<?> r10) {
        if (this.mTargetTypes != null) goto L5;
        this.mTargetTypes = new ArrayList();
    L5:
        this.mTargetTypes.add(r10);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull String r10) {
        if (this.mTargetNames != null) goto L5;
        this.mTargetNames = new ArrayList();
    L5:
        this.mTargetNames.add(r10);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void animate(Animator r10) {
        if (r10 != null) goto L5;
        end();
        return;
    L5:
        if (getDuration() < 0) goto L8;
        r10.setDuration(getDuration());
    L8:
        if (getStartDelay() < 0) goto L11;
        r10.setStartDelay(getStartDelay() + r10.getStartDelay());
    L11:
        if (getInterpolator() == null) goto L13;
        r10.setInterpolator(getInterpolator());
    L13:
        r10.addListener(new AnonymousClass3(this));
        r10.start();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void cancel() {
        int r10 = this.mCurrentAnimators.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        this.mCurrentAnimators.get(r10).cancel();
        r10 = r10 - 1;
        goto L3
    L5:
        ArrayList<TransitionListener> r11 = this.mListeners;
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.size() <= 0) goto L15;
        ArrayList r12 = (ArrayList) this.mListeners.clone();
        int r13 = r12.size();
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L16;
        ((TransitionListener) r12.get(r14)).onTransitionCancel(this);
        r14 = r14 + 1;
        goto L10
    L16:
        return;
    }

    public abstract void captureEndValues(@NonNull TransitionValues r10);

    void capturePropagationValues(TransitionValues r10) {
        if (this.mPropagation != null) goto L5;
        return;
    L5:
        if (r10.values.isEmpty() == true) goto L23;
        String[] r11 = this.mPropagation.getPropagationProperties();
        if (r11 != null) goto L9;
        return;
    L9:
        boolean r12 = false;
        int r13 = 0;
    L11:
        if (r13 >= r11.length) goto L16;
        if (r10.values.containsKey(r11[r13]) == false) goto L17;
        r13 = r13 + 1;
    L17:
        if (r12 == true) goto L24;
        this.mPropagation.captureValues(r10);
        return;
    L24:
        return;
    L16:
        r12 = true;
        goto L17
    }

    public abstract void captureStartValues(@NonNull TransitionValues r10);

    void captureValues(ViewGroup r10, boolean r11) {
        clearValues(r11);
        int r12 = 0;
        if (this.mTargetIds.size() <= 0) goto L5;
    L6:
        ArrayList<String> r13 = this.mTargetNames;
        if (r13 != null) goto L9;
    L10:
        ArrayList<Class<?>> r14 = this.mTargetTypes;
        if (r14 != null) goto L13;
    L16:
        int r15 = 0;
    L18:
        if (r15 >= this.mTargetIds.size()) goto L31;
        View r16 = r10.findViewById(this.mTargetIds.get(r15).intValue());
        if (r16 == null) goto L30;
        TransitionValues r17 = new TransitionValues(r16);
        if (r11 == false) goto L24;
        captureStartValues(r17);
    L25:
        r17.mTargetedTransitions.add(this);
        capturePropagationValues(r17);
        if (r11 == false) goto L28;
        TransitionValuesMaps r18 = this.mStartValues;
    L29:
        addViewValues(r18, r16, r17);
        goto L30
    L28:
        r18 = this.mEndValues;
        goto L29
    L24:
        captureEndValues(r17);
    L30:
        r15 = r15 + 1;
        goto L18
    L31:
        int r19 = 0;
    L33:
        if (r19 >= this.mTargets.size()) goto L43;
        View r20 = this.mTargets.get(r19);
        TransitionValues r21 = new TransitionValues(r20);
        if (r11 == false) goto L37;
        captureStartValues(r21);
    L38:
        r21.mTargetedTransitions.add(this);
        capturePropagationValues(r21);
        if (r11 == false) goto L41;
        TransitionValuesMaps r22 = this.mStartValues;
    L42:
        addViewValues(r22, r20, r21);
        r19 = r19 + 1;
        goto L33
    L41:
        r22 = this.mEndValues;
        goto L42
    L37:
        captureEndValues(r21);
    L43:
        if (r11 == true) goto L54;
        ArrayMap<String, String> r23 = this.mNameOverrides;
        if (r23 == null) goto L65;
        int r24 = r23.size();
        ArrayList r25 = new ArrayList(r24);
        int r26 = 0;
    L47:
        if (r26 >= r24) goto L49;
        r25.add(this.mStartValues.mNameValues.remove(this.mNameOverrides.keyAt(r26)));
        r26 = r26 + 1;
    L49:
        if (r12 >= r24) goto L66;
        View r27 = (View) r25.get(r12);
        if (r27 == null) goto L53;
        this.mStartValues.mNameValues.put(this.mNameOverrides.valueAt(r12), r27);
    L53:
        r12 = r12 + 1;
        goto L49
    L66:
        return;
    L65:
        return;
    L54:
        return;
    L13:
        if (r14.isEmpty() == true) goto L16;
    L15:
        captureHierarchy(r10, r11);
        goto L43
    L9:
        if (r13.isEmpty() == false) goto L15;
    L5:
        if (this.mTargets.size() <= 0) goto L15;
        goto L6
    }

    void clearValues(boolean r10) {
        if (r10 == false) goto L4;
        this.mStartValues.mViewValues.clear();
        this.mStartValues.mIdValues.clear();
        TransitionValuesMaps r11 = this.mStartValues;
    L5:
        r11.mItemIdValues.clear();
        return;
    L4:
        this.mEndValues.mViewValues.clear();
        this.mEndValues.mIdValues.clear();
        r11 = this.mEndValues;
        goto L5
    }

    public Transition clone() {
        Transition r10 = (Transition) super.clone();     // Catch: CloneNotSupportedException -> L5
        r10.mAnimators = new ArrayList();     // Catch: CloneNotSupportedException -> L5
        r10.mStartValues = new TransitionValuesMaps();     // Catch: CloneNotSupportedException -> L5
        r10.mEndValues = new TransitionValuesMaps();     // Catch: CloneNotSupportedException -> L5
        r10.mStartValuesList = null;     // Catch: CloneNotSupportedException -> L5
        r10.mEndValuesList = null;     // Catch: CloneNotSupportedException -> L5
        return r10;
    L5:
        return null;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo9clone() {
        return clone();
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r10, @Nullable TransitionValues r11, @Nullable TransitionValues r12) {
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void createAnimators(ViewGroup r21, TransitionValuesMaps r22, TransitionValuesMaps r23, ArrayList<TransitionValues> r24, ArrayList<TransitionValues> r25) {
        ArrayMap<Animator, AnimationInfo> r10 = getRunningAnimators();
        SparseIntArray r11 = new SparseIntArray();
        int r12 = r24.size();
        long r13 = Long.MAX_VALUE;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L60;
        TransitionValues r15 = r24.get(r14);
        TransitionValues r16 = r25.get(r14);
        if (r15 != null) goto L7;
    L9:
        if (r16 != null) goto L11;
    L13:
        if (r15 != null) goto L16;
        if (r16 != null) goto L16;
    L15:
        int r17 = r12;
        int r18 = r14;
    L58:
        r14 = r18 + 1;
        r12 = r17;
    L16:
        if (r15 == null) goto L22;
        if (r16 == null) goto L22;
        if (isTransitionRequired(r15, r16) == true) goto L22;
        boolean r19 = false;
    L23:
        if (r19 == false) goto L15;
        Animator r20 = createAnimator(r21, r15, r16);
        if (r20 == null) goto L15;
        if (r16 == null) goto L52;
        View r110 = r16.view;
        String[] r26 = getTransitionProperties();
        if (r26 != null) goto L30;
    L50:
        r17 = r12;
        r18 = r14;
        Animator r27 = r20;
        TransitionValues r111 = null;
    L51:
        Animator r112 = r27;
        TransitionValues r28 = r111;
    L53:
        if (r112 == null) goto L58;
        TransitionPropagation r29 = this.mPropagation;
        if (r29 == null) goto L57;
        long r30 = r29.getStartDelay(r21, this, r15, r16);
        r11.put(this.mAnimators.size(), (int) r30);
        r13 = Math.min(r30, r13);
    L57:
        long r113 = r13;
        View r31 = r110;
        r10.put(r112, new AnimationInfo(r31, getName(), this, ViewUtils.getWindowId(r21), r28));
        this.mAnimators.add(r112);
        r13 = r113;
        goto L58
    L30:
        if (r26.length <= 0) goto L50;
        r111 = new TransitionValues(r110);
        r17 = r12;
        TransitionValues r32 = r23.mViewValues.get(r110);
        if (r32 == null) goto L37;
        int r114 = 0;
    L35:
        if (r114 >= r26.length) goto L37;
        int r115 = r14;
        TransitionValues r116 = r32;
        r111.values.put(r26[r114], r32.values.get(r26[r114]));
        r114 = r114 + 1;
        r14 = r115;
        r32 = r116;
    L37:
        r18 = r14;
        int r33 = r10.size();
        int r34 = 0;
    L38:
        if (r34 >= r33) goto L49;
        AnimationInfo r117 = r10.get(r10.keyAt(r34));
        if (r117.mValues == null) goto L48;
        if (r117.mView != r110) goto L48;
        if (r117.mName.equals(getName()) == false) goto L48;
        if (r117.mValues.equals(r111) == false) goto L48;
        r27 = null;
    L48:
        r34 = r34 + 1;
        goto L38
    L49:
        r27 = r20;
        goto L51
    L52:
        r17 = r12;
        r18 = r14;
        r110 = r15.view;
        r112 = r20;
        r28 = null;
    L22:
        r19 = true;
        goto L23
    L11:
        if (r16.mTargetedTransitions.contains(this) == true) goto L13;
        r16 = null;
        goto L13
    L7:
        if (r15.mTargetedTransitions.contains(this) == true) goto L9;
        r15 = null;
        goto L9
    L60:
        if (r11.size() == 0) goto L65;
        int r118 = 0;
    L63:
        if (r118 >= r11.size()) goto L78;
        int r35 = r11.keyAt(r118);
        Animator r36 = this.mAnimators.get(r35);
        r36.setStartDelay((((long) r11.valueAt(r118)) - r13) + r36.getStartDelay());
        r118 = r118 + 1;
        goto L63
    L78:
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void end() {
        int r10 = this.mNumInstances - 1;
        this.mNumInstances = r10;
        if (r10 != 0) goto L34;
        ArrayList<TransitionListener> r11 = this.mListeners;
        if (r11 != null) goto L7;
    L11:
        int r12 = 0;
    L13:
        if (r12 >= this.mStartValues.mItemIdValues.size()) goto L18;
        View r13 = this.mStartValues.mItemIdValues.valueAt(r12);
        if (r13 == null) goto L17;
        ViewCompat.setHasTransientState(r13, false);
    L17:
        r12 = r12 + 1;
        goto L13
    L18:
        int r14 = 0;
    L20:
        if (r14 >= this.mEndValues.mItemIdValues.size()) goto L25;
        View r15 = this.mEndValues.mItemIdValues.valueAt(r14);
        if (r15 == null) goto L24;
        ViewCompat.setHasTransientState(r15, false);
    L24:
        r14 = r14 + 1;
        goto L20
    L25:
        this.mEnded = true;
        return;
    L7:
        if (r11.size() <= 0) goto L11;
        ArrayList r16 = (ArrayList) this.mListeners.clone();
        int r17 = r16.size();
        int r18 = 0;
    L9:
        if (r18 >= r17) goto L11;
        ((TransitionListener) r16.get(r18)).onTransitionEnd(this);
        r18 = r18 + 1;
        goto L9
    }

    @NonNull
    public Transition excludeChildren(@IdRes int r10, boolean r11) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, r10, r11);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull View r10, boolean r11) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, r10, r11);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class<?> r10, boolean r11) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, r10, r11);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int r10, boolean r11) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, r10, r11);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull View r10, boolean r11) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, r10, r11);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> r10, boolean r11) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, r10, r11);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull String r10, boolean r11) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, r10, r11);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void forceToEnd(ViewGroup r10) {
        ArrayMap<Animator, AnimationInfo> r11 = getRunningAnimators();
        int r12 = r11.size();
        if (r10 == null) goto L15;
        if (r12 == 0) goto L21;
        WindowIdImpl r13 = ViewUtils.getWindowId(r10);
        ArrayMap r14 = new ArrayMap(r11);
        r11.clear();
        int r15 = r12 - 1;
    L7:
        if (r15 < 0) goto L22;
        AnimationInfo r16 = (AnimationInfo) r14.valueAt(r15);
        if (r16.mView == null) goto L14;
        if (r13 == null) goto L14;
        if (r13.equals(r16.mWindowId) == false) goto L14;
        ((Animator) r14.keyAt(r15)).end();
    L14:
        r15 = r15 - 1;
        goto L7
    L22:
        return;
    L21:
        return;
    }

    public long getDuration() {
        return this.mDuration;
    }

    @Nullable
    public Rect getEpicenter() {
        EpicenterCallback r10 = this.mEpicenterCallback;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.onGetEpicenter(this);
    }

    @Nullable
    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    TransitionValues getMatchedTransitionValues(View r10, boolean r11) {
        TransitionSet r12 = this.mParent;
        if (r12 != null) goto L5;
        if (r11 == false) goto L8;
        ArrayList<TransitionValues> r13 = this.mStartValuesList;
    L10:
        if (r13 != null) goto L12;
        return null;
    L12:
        int r14 = r13.size();
        int r15 = -1;
        int r16 = 0;
    L13:
        if (r16 >= r14) goto L21;
        TransitionValues r17 = r13.get(r16);
        if (r17 == null) goto L16;
        if (r17.view == r10) goto L19;
        r16 = r16 + 1;
        goto L13
    L19:
        r15 = r16;
        goto L21
    L16:
        return null;
    L21:
        if (r15 < 0) goto L30;
        if (r11 == false) goto L24;
        ArrayList<TransitionValues> r18 = this.mEndValuesList;
    L26:
        return r18.get(r15);
    L24:
        r18 = this.mStartValuesList;
        goto L26
    L30:
        return null;
    L8:
        r13 = this.mEndValuesList;
        goto L10
    L5:
        return r12.getMatchedTransitionValues(r10, r11);
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    @NonNull
    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    @Nullable
    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    @NonNull
    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    @Nullable
    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    @Nullable
    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    @NonNull
    public List<View> getTargets() {
        return this.mTargets;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return null;
    }

    @Nullable
    public TransitionValues getTransitionValues(@NonNull View r10, boolean r11) {
        TransitionSet r12 = this.mParent;
        if (r12 != null) goto L5;
        if (r11 == false) goto L8;
        TransitionValuesMaps r13 = this.mStartValues;
    L10:
        return r13.mViewValues.get(r10);
    L8:
        r13 = this.mEndValues;
        goto L10
    L5:
        return r12.getTransitionValues(r10, r11);
    }

    public boolean isTransitionRequired(@Nullable TransitionValues r10, @Nullable TransitionValues r11) {
        if (r10 == null) goto L25;
        if (r11 == null) goto L26;
        String[] r12 = getTransitionProperties();
        if (r12 == null) goto L13;
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L27;
        if (isValueChanged(r10, r11, r12[r14]) == true) goto L19;
        r14 = r14 + 1;
    L19:
        return true;
    L27:
        return false;
    L13:
        Iterator<String> r15 = r10.values.keySet().iterator();
    L15:
        if (r15.hasNext() == false) goto L28;
        if (isValueChanged(r10, r11, r15.next()) == false) goto L15;
    L28:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    boolean isValidTarget(View r10) {
        int r11 = r10.getId();
        ArrayList<Integer> r12 = this.mTargetIdExcludes;
        if (r12 != null) goto L5;
    L7:
        ArrayList<View> r13 = this.mTargetExcludes;
        if (r13 != null) goto L10;
    L12:
        ArrayList<Class<?>> r14 = this.mTargetTypeExcludes;
        if (r14 == null) goto L21;
        int r15 = r14.size();
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L21;
        if (this.mTargetTypeExcludes.get(r16).isInstance(r10) == true) goto L18;
        r16 = r16 + 1;
        goto L15
    L18:
        return false;
    L21:
        if (this.mTargetNameExcludes == null) goto L28;
        if (ViewCompat.getTransitionName(r10) == null) goto L28;
        if (this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(r10)) == false) goto L28;
        return false;
    L28:
        if (this.mTargetIds.size() != 0) goto L41;
        if (this.mTargets.size() != 0) goto L41;
        ArrayList<Class<?>> r17 = this.mTargetTypes;
        if (r17 != null) goto L34;
    L35:
        ArrayList<String> r18 = this.mTargetNames;
        if (r18 != null) goto L38;
    L39:
        return true;
    L38:
        if (r18.isEmpty() == false) goto L41;
    L34:
        if (r17.isEmpty() == true) goto L35;
    L41:
        if (this.mTargetIds.contains(Integer.valueOf(r11)) == false) goto L43;
    L60:
        return true;
    L43:
        if (this.mTargets.contains(r10) == true) goto L60;
        ArrayList<String> r19 = this.mTargetNames;
        if (r19 == null) goto L51;
        if (r19.contains(ViewCompat.getTransitionName(r10)) == false) goto L51;
        return true;
    L51:
        if (this.mTargetTypes == null) goto L59;
        int r20 = 0;
    L54:
        if (r20 >= this.mTargetTypes.size()) goto L59;
        if (this.mTargetTypes.get(r20).isInstance(r10) == true) goto L57;
        r20 = r20 + 1;
        goto L54
    L57:
        return true;
    L59:
        return false;
    L10:
        if (r13.contains(r10) == false) goto L12;
        return false;
    L5:
        if (r12.contains(Integer.valueOf(r11)) == false) goto L7;
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View r10) {
        if (this.mEnded == true) goto L26;
        ArrayMap<Animator, AnimationInfo> r11 = getRunningAnimators();
        int r12 = r11.size();
        WindowIdImpl r13 = ViewUtils.getWindowId(r10);
        int r14 = r12 - 1;
    L5:
        if (r14 < 0) goto L12;
        AnimationInfo r15 = r11.valueAt(r14);
        if (r15.mView == null) goto L11;
        if (r13.equals(r15.mWindowId) == false) goto L11;
        AnimatorUtils.pause(r11.keyAt(r14));
    L11:
        r14 = r14 - 1;
        goto L5
    L12:
        ArrayList<TransitionListener> r16 = this.mListeners;
        if (r16 != null) goto L15;
    L19:
        this.mPaused = true;
        return;
    L15:
        if (r16.size() <= 0) goto L19;
        ArrayList r17 = (ArrayList) this.mListeners.clone();
        int r18 = r17.size();
        int r19 = 0;
    L17:
        if (r19 >= r18) goto L19;
        ((TransitionListener) r17.get(r19)).onTransitionPause(this);
        r19 = r19 + 1;
        goto L17
    }

    void playTransition(ViewGroup r11) {
        this.mStartValuesList = new ArrayList();
        this.mEndValuesList = new ArrayList();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> r10 = getRunningAnimators();
        int r12 = r10.size();
        WindowIdImpl r13 = ViewUtils.getWindowId(r11);
        int r14 = r12 - 1;
    L3:
        if (r14 < 0) goto L31;
        Animator r15 = r10.keyAt(r14);
        if (r15 == null) goto L30;
        AnimationInfo r16 = r10.get(r15);
        if (r16 == null) goto L30;
        if (r16.mView == null) goto L30;
        if (r13.equals(r16.mWindowId) == false) goto L30;
        TransitionValues r17 = r16.mValues;
        View r18 = r16.mView;
        TransitionValues r19 = getTransitionValues(r18, true);
        TransitionValues r20 = getMatchedTransitionValues(r18, true);
        if (r19 != null) goto L16;
        if (r20 != null) goto L16;
        r20 = this.mEndValues.mViewValues.get(r18);
    L16:
        if (r19 != null) goto L19;
        if (r20 != null) goto L19;
    L21:
        boolean r21 = false;
    L22:
        if (r21 == false) goto L30;
        if (r15.isRunning() == false) goto L26;
    L29:
        r15.cancel();
        goto L30
    L26:
        if (r15.isStarted() == true) goto L29;
        r10.remove(r15);
    L19:
        if (r16.mTransition.isTransitionRequired(r17, r20) == false) goto L21;
        r21 = true;
    L30:
        r14 = r14 - 1;
        goto L3
    L31:
        createAnimators(r11, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener r10) {
        ArrayList<TransitionListener> r11 = this.mListeners;
        if (r11 != null) goto L5;
        return this;
    L5:
        r11.remove(r10);
        if (this.mListeners.size() != 0) goto L8;
        this.mListeners = null;
    L8:
        return this;
    }

    @NonNull
    public Transition removeTarget(@IdRes int r10) {
        if (r10 == 0) goto L4;
        this.mTargetIds.remove(Integer.valueOf(r10));
    L4:
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull View r10) {
        this.mTargets.remove(r10);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull Class<?> r10) {
        ArrayList<Class<?>> r11 = this.mTargetTypes;
        if (r11 == null) goto L5;
        r11.remove(r10);
    L5:
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull String r10) {
        ArrayList<String> r11 = this.mTargetNames;
        if (r11 == null) goto L5;
        r11.remove(r10);
    L5:
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View r10) {
        if (this.mPaused == true) goto L5;
        return;
    L5:
        if (this.mEnded == true) goto L21;
        ArrayMap<Animator, AnimationInfo> r11 = getRunningAnimators();
        int r12 = r11.size();
        WindowIdImpl r13 = ViewUtils.getWindowId(r10);
        int r14 = r12 - 1;
    L7:
        if (r14 < 0) goto L14;
        AnimationInfo r15 = r11.valueAt(r14);
        if (r15.mView == null) goto L13;
        if (r13.equals(r15.mWindowId) == false) goto L13;
        AnimatorUtils.resume(r11.keyAt(r14));
    L13:
        r14 = r14 - 1;
        goto L7
    L14:
        ArrayList<TransitionListener> r16 = this.mListeners;
        if (r16 == null) goto L21;
        if (r16.size() <= 0) goto L21;
        ArrayList r17 = (ArrayList) this.mListeners.clone();
        int r18 = r17.size();
        int r19 = 0;
    L19:
        if (r19 >= r18) goto L21;
        ((TransitionListener) r17.get(r19)).onTransitionResume(this);
        r19 = r19 + 1;
    L21:
        this.mPaused = false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> r10 = getRunningAnimators();
        Iterator<Animator> r11 = this.mAnimators.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Animator r12 = r11.next();
        if (r10.containsKey(r12) == false) goto L4;
        start();
        runAnimator(r12, r10);
        goto L4
    L8:
        this.mAnimators.clear();
        end();
    }

    void setCanRemoveViews(boolean r10) {
        this.mCanRemoveViews = r10;
    }

    @NonNull
    public Transition setDuration(long r10) {
        this.mDuration = r10;
        return this;
    }

    public void setEpicenterCallback(@Nullable EpicenterCallback r10) {
        this.mEpicenterCallback = r10;
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator r10) {
        this.mInterpolator = r10;
        return this;
    }

    public void setMatchOrder(int... r10) {
        if (r10 != null) goto L4;
    L19:
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        return;
    L4:
        if (r10.length == 0) goto L19;
        int r11 = 0;
    L8:
        if (r11 >= r10.length) goto L18;
        if (isValidMatch(r10[r11]) == false) goto L17;
        if (alreadyContains(r10, r11) == true) goto L15;
        r11 = r11 + 1;
        goto L8
    L15:
        throw new IllegalArgumentException("matches contains a duplicate value");
    L17:
        throw new IllegalArgumentException("matches contains invalid value");
    L18:
        this.mMatchOrder = (int[]) r10.clone();
    }

    public void setPathMotion(@Nullable PathMotion r10) {
        if (r10 != null) goto L4;
        r10 = STRAIGHT_PATH_MOTION;
    L4:
        this.mPathMotion = r10;
    }

    public void setPropagation(@Nullable TransitionPropagation r10) {
        this.mPropagation = r10;
    }

    Transition setSceneRoot(ViewGroup r10) {
        this.mSceneRoot = r10;
        return this;
    }

    @NonNull
    public Transition setStartDelay(long r10) {
        this.mStartDelay = r10;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void start() {
        if (this.mNumInstances != 0) goto L12;
        ArrayList<TransitionListener> r10 = this.mListeners;
        if (r10 != null) goto L7;
    L11:
        this.mEnded = false;
        goto L12
    L7:
        if (r10.size() <= 0) goto L11;
        ArrayList r11 = (ArrayList) this.mListeners.clone();
        int r12 = r11.size();
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L11;
        ((TransitionListener) r11.get(r13)).onTransitionStart(this);
        r13 = r13 + 1;
    L12:
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    String toString(String r10) {
        String r11 = r10 + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration == (-1)) goto L6;
        r11 = r11 + "dur(" + this.mDuration + ") ";
    L6:
        if (this.mStartDelay == (-1)) goto L9;
        r11 = r11 + "dly(" + this.mStartDelay + ") ";
    L9:
        if (this.mInterpolator == null) goto L12;
        r11 = r11 + "interp(" + this.mInterpolator + ") ";
    L12:
        if (this.mTargetIds.size() <= 0) goto L14;
    L15:
        String r12 = r11 + "tgts(";
        int r13 = 0;
        if (this.mTargetIds.size() <= 0) goto L24;
        int r14 = 0;
    L19:
        if (r14 >= this.mTargetIds.size()) goto L24;
        if (r14 <= 0) goto L22;
        r12 = r12 + ", ";
    L22:
        r12 = r12 + this.mTargetIds.get(r14);
        r14 = r14 + 1;
    L24:
        if (this.mTargets.size() <= 0) goto L31;
    L26:
        if (r13 >= this.mTargets.size()) goto L31;
        if (r13 <= 0) goto L29;
        r12 = r12 + ", ";
    L29:
        r12 = r12 + this.mTargets.get(r13);
        r13 = r13 + 1;
    L31:
        return r12 + ")";
    L14:
        if (this.mTargets.size() > 0) goto L15;
        return r11;
    }
}
