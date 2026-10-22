package androidx.transition;

import ai.j0;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = null;
    private static final Animator[] EMPTY_ANIMATOR_ARRAY = null;
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
    private Animator[] mAnimatorCache;
    ArrayList<Animator> mAnimators;
    boolean mCanRemoveViews;
    private Transition mCloneParent;
    ArrayList<Animator> mCurrentAnimators;
    long mDuration;
    private TransitionValuesMaps mEndValues;
    private ArrayList<TransitionValues> mEndValuesList;
    boolean mEnded;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator;
    private ArrayList<TransitionListener> mListeners;
    private TransitionListener[] mListenersCache;
    private int[] mMatchOrder;
    private String mName;
    private ArrayMap<String, String> mNameOverrides;
    int mNumInstances;
    TransitionSet mParent;
    private PathMotion mPathMotion;
    private boolean mPaused;
    TransitionPropagation mPropagation;
    SeekController mSeekController;
    long mSeekOffsetInParent;
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
    long mTotalDuration;

    public static class AnimationInfo {
        Animator mAnimator;
        String mName;
        Transition mTransition;
        TransitionValues mValues;
        View mView;
        WindowId mWindowId;

        public AnimationInfo(View r5, String r10, Transition r11, WindowId r12, TransitionValues r13, Animator r14) {
            this.mView = r5;
            this.mName = r10;
            this.mValues = r13;
            this.mWindowId = r12;
            this.mTransition = r11;
            this.mAnimator = r14;
        }
    }

    public static class ArrayListManager {
        private ArrayListManager() {
        }

        public static <T> ArrayList<T> add(ArrayList<T> r5, T r10) {
            if (r5 != null) goto L5;
            r5 = new ArrayList();
        L5:
            if (r5.contains(r10) == true) goto L7;
            r5.add(r10);
        L7:
            return r5;
        }

        public static <T> ArrayList<T> remove(ArrayList<T> r5, T r10) {
            if (r5 == null) goto L7;
            r5.remove(r10);
            if (r5.isEmpty() == false) goto L8;
            return null;
        L8:
            return r5;
        L7:
            return r5;
        }
    }

    public static abstract class EpicenterCallback {
        public EpicenterCallback() {
        }

        @Nullable
        public abstract Rect onGetEpicenter(@NonNull Transition r5);
    }

    @RequiresApi(26)
    public static class Impl26 {
        private Impl26() {
        }

        @DoNotInline
        public static long getTotalDuration(Animator r5) {
            return r5.getTotalDuration();
        }

        @DoNotInline
        public static void setCurrentPlayTime(Animator r5, long r10) {
            ((AnimatorSet) r5).setCurrentPlayTime(r10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface MatchOrder {
    }

    @RequiresApi(34)
    public class SeekController extends TransitionListenerAdapter implements TransitionSeekController, DynamicAnimation.OnAnimationUpdateListener {
        private long mCurrentPlayTime;
        private boolean mIsCanceled;
        private boolean mIsReady;
        private Consumer<TransitionSeekController>[] mListenerCache;
        private ArrayList<Consumer<TransitionSeekController>> mOnProgressListeners;
        private ArrayList<Consumer<TransitionSeekController>> mOnReadyListeners;
        private Runnable mResetToStartState;
        private SpringAnimation mSpringAnimation;
        private final VelocityTracker1D mVelocityTracker;
        final /* synthetic */ Transition this$0;

        public SeekController(Transition r5) {
            this.this$0 = r5;
            this.mCurrentPlayTime = -1;
            this.mOnReadyListeners = null;
            this.mOnProgressListeners = null;
            this.mListenerCache = null;
            this.mVelocityTracker = new VelocityTracker1D();
        }

        public static /* synthetic */ void a(SeekController r5, DynamicAnimation r10, boolean r11, float r12, float r13) {
            r5.lambda$ensureAnimation$0(r10, r11, r12, r13);
        }

        private void callProgressListeners() {
            ArrayList<Consumer<TransitionSeekController>> r5 = this.mOnProgressListeners;
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.isEmpty() == true) goto L17;
            int r10 = this.mOnProgressListeners.size();
            if (this.mListenerCache != null) goto L10;
            this.mListenerCache = new Consumer[r10];
        L10:
            Consumer<TransitionSeekController>[] r11 = (Consumer[]) this.mOnProgressListeners.toArray(this.mListenerCache);
            this.mListenerCache = null;
            int r12 = 0;
        L11:
            if (r12 >= r10) goto L13;
            r11[r12].accept(this);
            r11[r12] = null;
            r12 = r12 + 1;
            goto L11
        L13:
            this.mListenerCache = r11;
            return;
        }

        private void ensureAnimation() {
            if (this.mSpringAnimation == null) goto L5;
            return;
        L5:
            this.mVelocityTracker.addDataPoint(AnimationUtils.currentAnimationTimeMillis(), this.mCurrentPlayTime);
            this.mSpringAnimation = new SpringAnimation(new FloatValueHolder());
            SpringForce r5 = new SpringForce();
            r5.setDampingRatio(1.0f);
            r5.setStiffness(200.0f);
            this.mSpringAnimation.setSpring(r5);
            this.mSpringAnimation.setStartValue(this.mCurrentPlayTime);
            this.mSpringAnimation.addUpdateListener(this);
            this.mSpringAnimation.setStartVelocity(this.mVelocityTracker.calculateVelocity());
            this.mSpringAnimation.setMaxValue(getDurationMillis() + 1);
            this.mSpringAnimation.setMinValue(-1.0f);
            this.mSpringAnimation.setMinimumVisibleChange(4.0f);
            this.mSpringAnimation.addEndListener(new b(this));
        }

        private /* synthetic */ void lambda$ensureAnimation$0(DynamicAnimation r5, boolean r10, float r11, float r12) {
            if (r10 == false) goto L4;
            return;
        L4:
            if (r11 >= 1.0f) goto L11;
            long r13 = getDurationMillis();
            Transition r14 = ((TransitionSet) this.this$0).getTransitionAt(0);
            Transition r15 = Transition.access$000(r14);
            Transition.access$002(r14, null);
            this.this$0.setCurrentPlayTimeMillis(-1, this.mCurrentPlayTime);
            this.this$0.setCurrentPlayTimeMillis(r13, -1);
            this.mCurrentPlayTime = r13;
            Runnable r16 = this.mResetToStartState;
            if (r16 == null) goto L8;
            r16.run();
        L8:
            this.this$0.mAnimators.clear();
            if (r15 == null) goto L14;
            r15.notifyListeners(TransitionNotification.ON_END, true);
            return;
        L14:
            return;
        L11:
            this.this$0.notifyListeners(TransitionNotification.ON_END, false);
        }

        @Override // androidx.transition.TransitionSeekController
        public void addOnProgressChangedListener(@NonNull Consumer<TransitionSeekController> r5) {
            if (this.mOnProgressListeners != null) goto L5;
            this.mOnProgressListeners = new ArrayList();
        L5:
            this.mOnProgressListeners.add(r5);
        }

        @Override // androidx.transition.TransitionSeekController
        public void addOnReadyListener(@NonNull Consumer<TransitionSeekController> r5) {
            if (isReady() == false) goto L7;
            r5.accept(this);
            return;
        L7:
            if (this.mOnReadyListeners != null) goto L9;
            this.mOnReadyListeners = new ArrayList();
        L9:
            this.mOnReadyListeners.add(r5);
        }

        @Override // androidx.transition.TransitionSeekController
        public void animateToEnd() {
            ensureAnimation();
            this.mSpringAnimation.animateToFinalPosition(getDurationMillis() + 1);
        }

        @Override // androidx.transition.TransitionSeekController
        public void animateToStart(@NonNull Runnable r5) {
            this.mResetToStartState = r5;
            ensureAnimation();
            this.mSpringAnimation.animateToFinalPosition(0.0f);
        }

        @Override // androidx.transition.TransitionSeekController
        public float getCurrentFraction() {
            return getCurrentPlayTimeMillis() / getDurationMillis();
        }

        @Override // androidx.transition.TransitionSeekController
        public long getCurrentPlayTimeMillis() {
            return Math.min(getDurationMillis(), Math.max(0, this.mCurrentPlayTime));
        }

        @Override // androidx.transition.TransitionSeekController
        public long getDurationMillis() {
            return this.this$0.getTotalDurationMillis();
        }

        public void initPlayTime() {
            long r5 = 0;
            if (getDurationMillis() != 0) goto L5;
            r5 = 1;
        L5:
            this.this$0.setCurrentPlayTimeMillis(r5, this.mCurrentPlayTime);
            this.mCurrentPlayTime = r5;
        }

        @Override // androidx.transition.TransitionSeekController
        public boolean isReady() {
            return this.mIsReady;
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public void onAnimationUpdate(DynamicAnimation r5, float r10, float r11) {
            long r12 = Math.max(-1, Math.min(getDurationMillis() + 1, Math.round(r10)));
            this.this$0.setCurrentPlayTimeMillis(r12, this.mCurrentPlayTime);
            this.mCurrentPlayTime = r12;
            callProgressListeners();
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r5) {
            this.mIsCanceled = true;
        }

        public void ready() {
            this.mIsReady = true;
            ArrayList<Consumer<TransitionSeekController>> r5 = this.mOnReadyListeners;
            if (r5 == null) goto L8;
            this.mOnReadyListeners = null;
            int r10 = 0;
        L6:
            if (r10 >= r5.size()) goto L8;
            r5.get(r10).accept(this);
            r10 = r10 + 1;
        L8:
            callProgressListeners();
        }

        @Override // androidx.transition.TransitionSeekController
        public void removeOnProgressChangedListener(@NonNull Consumer<TransitionSeekController> r5) {
            ArrayList<Consumer<TransitionSeekController>> r10 = this.mOnProgressListeners;
            if (r10 == null) goto L6;
            r10.remove(r5);
            return;
        }

        @Override // androidx.transition.TransitionSeekController
        public void removeOnReadyListener(@NonNull Consumer<TransitionSeekController> r5) {
            ArrayList<Consumer<TransitionSeekController>> r10 = this.mOnReadyListeners;
            if (r10 == null) goto L8;
            r10.remove(r5);
            if (this.mOnReadyListeners.isEmpty() == false) goto L9;
            this.mOnReadyListeners = null;
            return;
        L9:
            return;
        }

        @Override // androidx.transition.TransitionSeekController
        public void setCurrentFraction(float r5) {
            if (this.mSpringAnimation != null) goto L7;
            setCurrentPlayTimeMillis((long) (r5 * getDurationMillis()));
            return;
        L7:
            throw new IllegalStateException("setCurrentFraction() called after animation has been started");
        }

        @Override // androidx.transition.TransitionSeekController
        public void setCurrentPlayTimeMillis(long r5) {
            if (this.mSpringAnimation != null) goto L27;
            if (r5 != this.mCurrentPlayTime) goto L7;
            return;
        L7:
            if (isReady() == true) goto L10;
            return;
        L10:
            if (this.mIsCanceled == false) goto L12;
        L24:
            callProgressListeners();
            this.mVelocityTracker.addDataPoint(AnimationUtils.currentAnimationTimeMillis(), r5);
            return;
        L12:
            if (r5 == 0) goto L14;
        L16:
            long r10 = getDurationMillis();
            if (r5 == r10) goto L19;
        L21:
            long r11 = this.mCurrentPlayTime;
            if (r5 == r11) goto L24;
            this.this$0.setCurrentPlayTimeMillis(r5, r11);
            this.mCurrentPlayTime = r5;
            goto L24
        L19:
            if (this.mCurrentPlayTime >= r10) goto L21;
            r5 = 1 + r10;
            goto L21
        L14:
            if (this.mCurrentPlayTime <= 0) goto L16;
            r5 = -1;
            goto L21
        L27:
            throw new IllegalStateException("setCurrentPlayTimeMillis() called after animation has been started");
        }
    }

    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition r5);

        void onTransitionEnd(@NonNull Transition r5);

        default void onTransitionEnd(@NonNull Transition r5, boolean r10) {
            onTransitionEnd(r5);
        }

        void onTransitionPause(@NonNull Transition r5);

        void onTransitionResume(@NonNull Transition r5);

        void onTransitionStart(@NonNull Transition r5);

        default void onTransitionStart(@NonNull Transition r5, boolean r10) {
            onTransitionStart(r5);
        }
    }

    public interface TransitionNotification {
        public static final TransitionNotification ON_CANCEL = null;
        public static final TransitionNotification ON_END = null;
        public static final TransitionNotification ON_PAUSE = null;
        public static final TransitionNotification ON_RESUME = null;
        public static final TransitionNotification ON_START = null;

        static {
            final int r5 = 0;
            ON_START = new c(r5);
            final int r10 = 1;
            ON_END = new c(r10);
            final int r11 = 2;
            ON_CANCEL = new c(r11);
            final int r12 = 3;
            ON_PAUSE = new c(r12);
            final int r13 = 4;
            ON_RESUME = new c(r13);
        }

        static /* synthetic */ void a(TransitionListener r5, Transition r10, boolean r11) {
            lambda$static$2(r5, r10, r11);
        }

        static /* synthetic */ void b(TransitionListener r5, Transition r10, boolean r11) {
            lambda$static$0(r5, r10, r11);
        }

        static /* synthetic */ void c(TransitionListener r5, Transition r10, boolean r11) {
            lambda$static$1(r5, r10, r11);
        }

        private static /* synthetic */ void lambda$static$0(TransitionListener r5, Transition r10, boolean r11) {
            r5.onTransitionCancel(r10);
        }

        private static /* synthetic */ void lambda$static$1(TransitionListener r5, Transition r10, boolean r11) {
            r5.onTransitionPause(r10);
        }

        private static /* synthetic */ void lambda$static$2(TransitionListener r5, Transition r10, boolean r11) {
            r5.onTransitionResume(r10);
        }

        void notifyListener(@NonNull TransitionListener r5, @NonNull Transition r10, boolean r11);
    }

    static {
        EMPTY_ANIMATOR_ARRAY = new Animator[0];
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
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList();
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mCloneParent = null;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
    }

    public static /* synthetic */ Transition access$000(Transition r5) {
        return r5.mCloneParent;
    }

    public static /* synthetic */ Transition access$002(Transition r5, Transition r10) {
        r5.mCloneParent = r10;
        return r10;
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> r10, ArrayMap<View, TransitionValues> r11) {
        int r5 = 0;
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L10;
        TransitionValues r13 = r10.valueAt(r12);
        if (isValidTarget(r13.view) == false) goto L8;
        this.mStartValuesList.add(r13);
        this.mEndValuesList.add(null);
    L8:
        r12 = r12 + 1;
    L10:
        if (r5 >= r11.size()) goto L15;
        TransitionValues r14 = r11.valueAt(r5);
        if (isValidTarget(r14.view) == false) goto L14;
        this.mEndValuesList.add(r14);
        this.mStartValuesList.add(null);
    L14:
        r5 = r5 + 1;
        goto L10
    }

    private static void addViewValues(TransitionValuesMaps r5, View r10, TransitionValues r11) {
        r5.mViewValues.put(r10, r11);
        int r12 = r10.getId();
        if (r12 >= 0) goto L5;
    L8:
        String r13 = ViewCompat.getTransitionName(r10);
        if (r13 == null) goto L15;
        if (r5.mNameValues.containsKey(r13) == false) goto L13;
        r5.mNameValues.put(r13, null);
        goto L15
    L13:
        r5.mNameValues.put(r13, r10);
    L15:
        if ((r10.getParent() instanceof ListView) == false) goto L25;
        ListView r14 = (ListView) r10.getParent();
        if (r14.getAdapter().hasStableIds() == false) goto L26;
        long r15 = r14.getItemIdAtPosition(r14.getPositionForView(r10));
        if (r5.mItemIdValues.indexOfKey(r15) < 0) goto L23;
        View r16 = r5.mItemIdValues.get(r15);
        if (r16 == null) goto L27;
        r16.setHasTransientState(false);
        r5.mItemIdValues.put(r15, null);
        return;
    L27:
        return;
    L23:
        r10.setHasTransientState(true);
        r5.mItemIdValues.put(r15, r10);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (r5.mIdValues.indexOfKey(r12) < 0) goto L7;
        r5.mIdValues.put(r12, null);
        goto L8
    L7:
        r5.mIdValues.put(r12, r10);
        goto L8
    }

    private static boolean alreadyContains(int[] r5, int r10) {
        int r11 = r5[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L9;
        if (r5[r12] == r11) goto L6;
        r12 = r12 + 1;
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
        int r5 = r10.getId();
        ArrayList<Integer> r12 = this.mTargetIdExcludes;
        if (r12 != null) goto L7;
    L9:
        ArrayList<View> r13 = this.mTargetExcludes;
        if (r13 != null) goto L12;
    L14:
        ArrayList<Class<?>> r14 = this.mTargetTypeExcludes;
        int r15 = 0;
        if (r14 == null) goto L23;
        int r16 = r14.size();
        int r17 = 0;
    L17:
        if (r17 >= r16) goto L23;
        if (this.mTargetTypeExcludes.get(r17).isInstance(r10) == true) goto L20;
        r17 = r17 + 1;
        goto L17
    L20:
        return;
    L23:
        if ((r10.getParent() instanceof ViewGroup) == false) goto L33;
        TransitionValues r18 = new TransitionValues(r10);
        if (r11 == false) goto L27;
        captureStartValues(r18);
    L28:
        r18.mTargetedTransitions.add(this);
        capturePropagationValues(r18);
        if (r11 == false) goto L31;
        addViewValues(this.mStartValues, r10, r18);
        goto L33
    L31:
        addViewValues(this.mEndValues, r10, r18);
        goto L33
    L27:
        captureEndValues(r18);
    L33:
        if ((r10 instanceof ViewGroup) == false) goto L56;
        ArrayList<Integer> r19 = this.mTargetIdChildExcludes;
        if (r19 != null) goto L37;
    L39:
        ArrayList<View> r20 = this.mTargetChildExcludes;
        if (r20 != null) goto L42;
    L44:
        ArrayList<Class<?>> r21 = this.mTargetTypeChildExcludes;
        if (r21 == null) goto L52;
        int r22 = r21.size();
        int r23 = 0;
    L47:
        if (r23 >= r22) goto L52;
        if (this.mTargetTypeChildExcludes.get(r23).isInstance(r10) == true) goto L50;
        r23 = r23 + 1;
        goto L47
    L50:
        return;
    L52:
        ViewGroup r24 = (ViewGroup) r10;
    L54:
        if (r15 >= r24.getChildCount()) goto L62;
        captureHierarchy(r24.getChildAt(r15), r11);
        r15 = r15 + 1;
        goto L54
    L62:
        return;
    L42:
        if (r20.contains(r10) == false) goto L44;
        return;
    L37:
        if (r19.contains(Integer.valueOf(r5)) == false) goto L39;
        return;
    L56:
        return;
    L12:
        if (r13.contains(r10) == false) goto L14;
        return;
    L7:
        if (r12.contains(Integer.valueOf(r5)) == false) goto L9;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> r5, int r10, boolean r11) {
        if (r10 <= 0) goto L7;
        if (r11 == false) goto L6;
        return ArrayListManager.add(r5, Integer.valueOf(r10));
    L6:
        return ArrayListManager.remove(r5, Integer.valueOf(r10));
    L7:
        return r5;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> r5, T r10, boolean r11) {
        if (r10 == null) goto L7;
        if (r11 == false) goto L6;
        return ArrayListManager.add(r5, r10);
    L6:
        return ArrayListManager.remove(r5, r10);
    L7:
        return r5;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> r5, Class<?> r10, boolean r11) {
        if (r10 == null) goto L7;
        if (r11 == false) goto L6;
        return ArrayListManager.add(r5, r10);
    L6:
        return ArrayListManager.remove(r5, r10);
    L7:
        return r5;
    }

    private ArrayList<View> excludeView(ArrayList<View> r5, View r10, boolean r11) {
        if (r10 == null) goto L7;
        if (r11 == false) goto L6;
        return ArrayListManager.add(r5, r10);
    L6:
        return ArrayListManager.remove(r5, r10);
    L7:
        return r5;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> r5 = sRunningAnimators.get();
        if (r5 != null) goto L6;
        ArrayMap<Animator, AnimationInfo> r10 = new ArrayMap();
        sRunningAnimators.set(r10);
        return r10;
    L6:
        return r5;
    }

    private static boolean isValidMatch(int r5) {
        if (r5 >= 1) goto L5;
    L7:
        return false;
    L5:
        if (r5 > 4) goto L7;
        return true;
    }

    private static boolean isValueChanged(TransitionValues r5, TransitionValues r10, String r11) {
        Object r12 = r5.values.get(r11);
        Object r13 = r10.values.get(r11);
        if (r12 != null) goto L7;
        if (r13 != null) goto L7;
        return false;
    L7:
        if (r12 == null) goto L12;
        if (r13 == null) goto L12;
        return !r12.equals(r13);
    L12:
        return true;
    }

    private void matchIds(ArrayMap<View, TransitionValues> r10, ArrayMap<View, TransitionValues> r11, SparseArray<View> r12, SparseArray<View> r13) {
        int r5 = r12.size();
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L17;
        View r15 = r12.valueAt(r14);
        if (r15 == null) goto L16;
        if (isValidTarget(r15) == false) goto L16;
        View r16 = r13.get(r12.keyAt(r14));
        if (r16 == null) goto L16;
        if (isValidTarget(r16) == false) goto L16;
        TransitionValues r17 = r10.get(r15);
        TransitionValues r18 = r11.get(r16);
        if (r17 == null) goto L16;
        if (r18 == null) goto L16;
        this.mStartValuesList.add(r17);
        this.mEndValuesList.add(r18);
        r10.remove(r15);
        r11.remove(r16);
    L16:
        r14 = r14 + 1;
        goto L3
    }

    private void matchInstances(ArrayMap<View, TransitionValues> r5, ArrayMap<View, TransitionValues> r10) {
        int r11 = r5.size() - 1;
    L3:
        if (r11 < 0) goto L14;
        View r12 = r5.keyAt(r11);
        if (r12 == null) goto L13;
        if (isValidTarget(r12) == false) goto L13;
        TransitionValues r13 = r10.remove(r12);
        if (r13 == null) goto L13;
        if (isValidTarget(r13.view) == false) goto L13;
        this.mStartValuesList.add(r5.removeAt(r11));
        this.mEndValuesList.add(r13);
    L13:
        r11 = r11 - 1;
        goto L3
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> r10, ArrayMap<View, TransitionValues> r11, LongSparseArray<View> r12, LongSparseArray<View> r13) {
        int r5 = r12.size();
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L17;
        View r15 = r12.valueAt(r14);
        if (r15 == null) goto L16;
        if (isValidTarget(r15) == false) goto L16;
        View r16 = r13.get(r12.keyAt(r14));
        if (r16 == null) goto L16;
        if (isValidTarget(r16) == false) goto L16;
        TransitionValues r17 = r10.get(r15);
        TransitionValues r18 = r11.get(r16);
        if (r17 == null) goto L16;
        if (r18 == null) goto L16;
        this.mStartValuesList.add(r17);
        this.mEndValuesList.add(r18);
        r10.remove(r15);
        r11.remove(r16);
    L16:
        r14 = r14 + 1;
        goto L3
    }

    private void matchNames(ArrayMap<View, TransitionValues> r10, ArrayMap<View, TransitionValues> r11, ArrayMap<String, View> r12, ArrayMap<String, View> r13) {
        int r5 = r12.size();
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L17;
        View r15 = r12.valueAt(r14);
        if (r15 == null) goto L16;
        if (isValidTarget(r15) == false) goto L16;
        View r16 = r13.get(r12.keyAt(r14));
        if (r16 == null) goto L16;
        if (isValidTarget(r16) == false) goto L16;
        TransitionValues r17 = r10.get(r15);
        TransitionValues r18 = r11.get(r16);
        if (r17 == null) goto L16;
        if (r18 == null) goto L16;
        this.mStartValuesList.add(r17);
        this.mEndValuesList.add(r18);
        r10.remove(r15);
        r11.remove(r16);
    L16:
        r14 = r14 + 1;
        goto L3
    }

    private void matchStartAndEnd(TransitionValuesMaps r10, TransitionValuesMaps r11) {
        ArrayMap<View, TransitionValues> r5 = new ArrayMap(r10.mViewValues);
        ArrayMap<View, TransitionValues> r12 = new ArrayMap(r11.mViewValues);
        int r13 = 0;
    L3:
        int[] r14 = this.mMatchOrder;
        if (r13 >= r14.length) goto L19;
        int r15 = r14[r13];
        if (r15 != 1) goto L8;
        matchInstances(r5, r12);
    L18:
        r13 = r13 + 1;
        goto L3
    L8:
        if (r15 != 2) goto L10;
        matchNames(r5, r12, r10.mNameValues, r11.mNameValues);
        goto L18
    L10:
        if (r15 != 3) goto L12;
        matchIds(r5, r12, r10.mIdValues, r11.mIdValues);
        goto L18
    L12:
        if (r15 != 4) goto L18;
        matchItemIds(r5, r12, r10.mItemIdValues, r11.mItemIdValues);
        goto L18
    L19:
        addUnmatched(r5, r12);
    }

    private void notifyFromTransition(Transition r10, TransitionNotification r11, boolean r12) {
        Transition r5 = this.mCloneParent;
        if (r5 == null) goto L5;
        r5.notifyFromTransition(r10, r11, r12);
    L5:
        ArrayList<TransitionListener> r13 = this.mListeners;
        if (r13 != null) goto L8;
        return;
    L8:
        if (r13.isEmpty() == true) goto L19;
        int r14 = this.mListeners.size();
        TransitionListener[] r15 = this.mListenersCache;
        if (r15 != null) goto L12;
        r15 = new TransitionListener[r14];
    L12:
        this.mListenersCache = null;
        TransitionListener[] r16 = (TransitionListener[]) this.mListeners.toArray(r15);
        int r17 = 0;
    L13:
        if (r17 >= r14) goto L15;
        r11.notifyListener(r16[r17], r10, r12);
        r16[r17] = null;
        r17 = r17 + 1;
        goto L13
    L15:
        this.mListenersCache = r16;
        return;
    }

    private static int[] parseMatchOrder(String r10) {
        StringTokenizer r5 = new StringTokenizer(r10, ",");
        int[] r11 = new int[r5.countTokens()];
        int r12 = 0;
    L4:
        if (r5.hasMoreTokens() == false) goto L23;
        String r13 = r5.nextToken().trim();
        if (MATCH_ID_STR.equalsIgnoreCase(r13) == false) goto L9;
        r11[r12] = 3;
    L20:
        r12 = r12 + 1;
        goto L4
    L9:
        if (MATCH_INSTANCE_STR.equalsIgnoreCase(r13) == false) goto L12;
        r11[r12] = 1;
        goto L20
    L12:
        if (MATCH_NAME_STR.equalsIgnoreCase(r13) == false) goto L15;
        r11[r12] = 2;
        goto L20
    L15:
        if (MATCH_ITEM_ID_STR.equalsIgnoreCase(r13) == false) goto L18;
        r11[r12] = 4;
        goto L20
    L18:
        if (r13.isEmpty() == false) goto L22;
        int[] r14 = new int[r11.length - 1];
        System.arraycopy(r11, 0, r14, 0, r12);
        r12 = r12 - 1;
        r11 = r14;
        goto L20
    L22:
        throw new InflateException(j0.k("Unknown match type in matchOrder: '", r13, "'"));
    L23:
        return r11;
    }

    private void runAnimator(Animator r5, final ArrayMap<Animator, AnimationInfo> r10) {
        if (r5 == null) goto L5;
        r5.addListener(new AnonymousClass2(this, r10));
        animate(r5);
        return;
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener r5) {
        if (this.mListeners != null) goto L5;
        this.mListeners = new ArrayList();
    L5:
        this.mListeners.add(r5);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull View r5) {
        this.mTargets.add(r5);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void animate(@Nullable Animator r5) {
        if (r5 != null) goto L5;
        end();
        return;
    L5:
        if (getDuration() < 0) goto L8;
        r5.setDuration(getDuration());
    L8:
        if (getStartDelay() < 0) goto L11;
        long r10 = getStartDelay();
        r5.setStartDelay(r5.getStartDelay() + r10);
    L11:
        if (getInterpolator() == null) goto L13;
        r5.setInterpolator(getInterpolator());
    L13:
        r5.addListener(new AnonymousClass3(this));
        r5.start();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        int r5 = this.mCurrentAnimators.size();
        Animator[] r10 = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        int r11 = r5 - 1;
    L3:
        if (r11 < 0) goto L5;
        Animator r12 = r10[r11];
        r10[r11] = null;
        r12.cancel();
        r11 = r11 - 1;
        goto L3
    L5:
        this.mAnimatorCache = r10;
        notifyListeners(TransitionNotification.ON_CANCEL, false);
    }

    public abstract void captureEndValues(@NonNull TransitionValues r5);

    public void capturePropagationValues(TransitionValues r5) {
        if (this.mPropagation != null) goto L5;
        return;
    L5:
        if (r5.values.isEmpty() == true) goto L19;
        String[] r10 = this.mPropagation.getPropagationProperties();
        if (r10 != null) goto L9;
        return;
    L9:
        int r11 = 0;
    L11:
        if (r11 >= r10.length) goto L21;
        if (r5.values.containsKey(r10[r11]) == false) goto L14;
        r11 = r11 + 1;
        goto L11
    L14:
        this.mPropagation.captureValues(r5);
        return;
    L21:
        return;
    }

    public abstract void captureStartValues(@NonNull TransitionValues r5);

    public void captureValues(@NonNull ViewGroup r10, boolean r11) {
        clearValues(r11);
        int r5 = 0;
        if (this.mTargetIds.size() <= 0) goto L5;
    L6:
        ArrayList<String> r12 = this.mTargetNames;
        if (r12 != null) goto L9;
    L10:
        ArrayList<Class<?>> r13 = this.mTargetTypes;
        if (r13 != null) goto L13;
    L16:
        int r14 = 0;
    L18:
        if (r14 >= this.mTargetIds.size()) goto L30;
        View r15 = r10.findViewById(this.mTargetIds.get(r14).intValue());
        if (r15 == null) goto L29;
        TransitionValues r16 = new TransitionValues(r15);
        if (r11 == false) goto L24;
        captureStartValues(r16);
    L25:
        r16.mTargetedTransitions.add(this);
        capturePropagationValues(r16);
        if (r11 == false) goto L28;
        addViewValues(this.mStartValues, r15, r16);
        goto L29
    L28:
        addViewValues(this.mEndValues, r15, r16);
        goto L29
    L24:
        captureEndValues(r16);
    L29:
        r14 = r14 + 1;
        goto L18
    L30:
        int r17 = 0;
    L32:
        if (r17 >= this.mTargets.size()) goto L42;
        View r18 = this.mTargets.get(r17);
        TransitionValues r19 = new TransitionValues(r18);
        if (r11 == false) goto L36;
        captureStartValues(r19);
    L37:
        r19.mTargetedTransitions.add(this);
        capturePropagationValues(r19);
        if (r11 == false) goto L40;
        addViewValues(this.mStartValues, r18, r19);
    L41:
        r17 = r17 + 1;
        goto L32
    L40:
        addViewValues(this.mEndValues, r18, r19);
        goto L41
    L36:
        captureEndValues(r19);
    L42:
        if (r11 == true) goto L53;
        ArrayMap<String, String> r20 = this.mNameOverrides;
        if (r20 == null) goto L65;
        int r21 = r20.size();
        ArrayList r22 = new ArrayList(r21);
        int r23 = 0;
    L46:
        if (r23 >= r21) goto L48;
        r22.add(this.mStartValues.mNameValues.remove(this.mNameOverrides.keyAt(r23)));
        r23 = r23 + 1;
    L48:
        if (r5 >= r21) goto L66;
        View r24 = (View) r22.get(r5);
        if (r24 == null) goto L52;
        this.mStartValues.mNameValues.put(this.mNameOverrides.valueAt(r5), r24);
    L52:
        r5 = r5 + 1;
        goto L48
    L66:
        return;
    L65:
        return;
    L53:
        return;
    L13:
        if (r13.isEmpty() == true) goto L16;
    L15:
        captureHierarchy(r10, r11);
        goto L42
    L9:
        if (r12.isEmpty() == false) goto L15;
    L5:
        if (this.mTargets.size() <= 0) goto L15;
        goto L6
    }

    public void clearValues(boolean r5) {
        if (r5 == false) goto L4;
        this.mStartValues.mViewValues.clear();
        this.mStartValues.mIdValues.clear();
        this.mStartValues.mItemIdValues.clear();
        return;
    L4:
        this.mEndValues.mViewValues.clear();
        this.mEndValues.mIdValues.clear();
        this.mEndValues.mItemIdValues.clear();
    }

    @NonNull
    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo82clone() throws CloneNotSupportedException {
        return clone();
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r5, @Nullable TransitionValues r10, @Nullable TransitionValues r11) {
        return null;
    }

    public void createAnimators(@NonNull ViewGroup r21, @NonNull TransitionValuesMaps r22, @NonNull TransitionValuesMaps r23, @NonNull ArrayList<TransitionValues> r24, @NonNull ArrayList<TransitionValues> r25) {
        ArrayMap<Animator, AnimationInfo> r10 = getRunningAnimators();
        SparseIntArray r11 = new SparseIntArray();
        int r12 = r24.size();
        if (getRootTransition().mSeekController == null) goto L5;
        boolean r13 = true;
    L6:
        long r5 = Long.MAX_VALUE;
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L62;
        TransitionValues r15 = r24.get(r14);
        TransitionValues r16 = r25.get(r14);
        if (r15 != null) goto L11;
    L13:
        if (r16 != null) goto L15;
    L17:
        if (r15 != null) goto L20;
        if (r16 != null) goto L20;
    L19:
        int r17 = r12;
        int r18 = r14;
    L60:
        r14 = r18 + 1;
        r12 = r17;
    L20:
        if (r15 == null) goto L24;
        if (r16 == null) goto L24;
        if (isTransitionRequired(r15, r16) == false) goto L19;
    L24:
        Animator r19 = createAnimator(r21, r15, r16);
        if (r19 == null) goto L19;
        if (r16 == null) goto L51;
        View r20 = r16.view;
        String[] r110 = getTransitionProperties();
        Animator r111 = r19;
        if (r110 != null) goto L30;
    L49:
        r17 = r12;
        r18 = r14;
        TransitionValues r26 = null;
    L50:
        Animator r112 = r111;
    L52:
        if (r112 == null) goto L60;
        TransitionPropagation r27 = this.mPropagation;
        if (r27 == null) goto L56;
        long r28 = r27.getStartDelay(r21, this, r15, r16);
        r11.put(this.mAnimators.size(), (int) r28);
        r5 = Math.min(r28, r5);
    L56:
        long r113 = r5;
        AnimationInfo r114 = new AnimationInfo(r20, getName(), this, r21.getWindowId(), r26, r112);
        Animator r115 = r112;
        if (r13 == false) goto L59;
        AnimatorSet r29 = new AnimatorSet();
        r29.play(r112);
        r115 = r29;
    L59:
        r10.put(r115, r114);
        this.mAnimators.add(r115);
        r5 = r113;
        goto L60
    L30:
        if (r110.length <= 0) goto L49;
        r26 = new TransitionValues(r20);
        r17 = r12;
        TransitionValues r30 = r23.mViewValues.get(r20);
        if (r30 == null) goto L37;
        int r116 = 0;
    L35:
        if (r116 >= r110.length) goto L37;
        Map<String, Object> r117 = r26.values;
        int r118 = r14;
        String r119 = r110[r116];
        r117.put(r119, r30.values.get(r119));
        r116 = r116 + 1;
        r14 = r118;
        r110 = r110;
    L37:
        r18 = r14;
        int r31 = r10.size();
        int r120 = 0;
    L38:
        if (r120 >= r31) goto L50;
        AnimationInfo r121 = r10.get(r10.keyAt(r120));
        if (r121.mValues == null) goto L48;
        if (r121.mView != r20) goto L48;
        if (r121.mName.equals(getName()) == false) goto L48;
        if (r121.mValues.equals(r26) == false) goto L48;
        r111 = null;
    L48:
        r120 = r120 + 1;
        goto L38
    L51:
        r17 = r12;
        r18 = r14;
        r20 = r15.view;
        r112 = r19;
        r26 = null;
        goto L52
    L15:
        if (r16.mTargetedTransitions.contains(this) == true) goto L17;
        r16 = null;
        goto L17
    L11:
        if (r15.mTargetedTransitions.contains(this) == true) goto L13;
        r15 = null;
        goto L13
    L62:
        if (r11.size() == 0) goto L67;
        int r122 = 0;
    L65:
        if (r122 >= r11.size()) goto L80;
        AnimationInfo r32 = r10.get(this.mAnimators.get(r11.keyAt(r122)));
        r32.mAnimator.setStartDelay(r32.mAnimator.getStartDelay() + (((long) r11.valueAt(r122)) - r5));
        r122 = r122 + 1;
        goto L65
    L80:
        return;
    L67:
        return;
    L5:
        r13 = false;
        goto L6
    }

    @NonNull
    @RequiresApi(34)
    public TransitionSeekController createSeekController() {
        SeekController r5 = new SeekController(this);
        this.mSeekController = r5;
        addListener(r5);
        return this.mSeekController;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void end() {
        int r5 = this.mNumInstances - 1;
        this.mNumInstances = r5;
        if (r5 != 0) goto L26;
        notifyListeners(TransitionNotification.ON_END, false);
        int r10 = 0;
    L6:
        if (r10 >= this.mStartValues.mItemIdValues.size()) goto L11;
        View r11 = this.mStartValues.mItemIdValues.valueAt(r10);
        if (r11 == null) goto L10;
        r11.setHasTransientState(false);
    L10:
        r10 = r10 + 1;
        goto L6
    L11:
        int r12 = 0;
    L13:
        if (r12 >= this.mEndValues.mItemIdValues.size()) goto L18;
        View r13 = this.mEndValues.mItemIdValues.valueAt(r12);
        if (r13 == null) goto L17;
        r13.setHasTransientState(false);
    L17:
        r12 = r12 + 1;
        goto L13
    L18:
        this.mEnded = true;
        return;
    }

    @NonNull
    public Transition excludeChildren(@NonNull View r5, boolean r10) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, r5, r10);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull View r5, boolean r10) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, r5, r10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(@Nullable ViewGroup r5) {
        ArrayMap<Animator, AnimationInfo> r10 = getRunningAnimators();
        int r11 = r10.size();
        if (r5 == null) goto L14;
        if (r11 == 0) goto L19;
        WindowId r12 = r5.getWindowId();
        ArrayMap r13 = new ArrayMap(r10);
        r10.clear();
        int r14 = r11 - 1;
    L7:
        if (r14 < 0) goto L20;
        AnimationInfo r15 = (AnimationInfo) r13.valueAt(r14);
        if (r15.mView == null) goto L13;
        if (r12.equals(r15.mWindowId) == false) goto L13;
        ((Animator) r13.keyAt(r14)).end();
    L13:
        r14 = r14 - 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    public long getDuration() {
        return this.mDuration;
    }

    @Nullable
    public Rect getEpicenter() {
        EpicenterCallback r5 = this.mEpicenterCallback;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.onGetEpicenter(this);
    }

    @Nullable
    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public TransitionValues getMatchedTransitionValues(View r10, boolean r11) {
        TransitionSet r5 = this.mParent;
        if (r5 != null) goto L5;
        if (r11 == false) goto L8;
        ArrayList<TransitionValues> r12 = this.mStartValuesList;
    L10:
        if (r12 != null) goto L12;
        return null;
    L12:
        int r13 = r12.size();
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L21;
        TransitionValues r15 = r12.get(r14);
        if (r15 == null) goto L16;
        if (r15.view == r10) goto L22;
        r14 = r14 + 1;
    L22:
        if (r14 < 0) goto L31;
        if (r11 == false) goto L25;
        ArrayList<TransitionValues> r16 = this.mEndValuesList;
    L27:
        return r16.get(r14);
    L25:
        r16 = this.mStartValuesList;
        goto L27
    L31:
        return null;
    L16:
        return null;
    L21:
        r14 = -1;
        goto L22
    L8:
        r12 = this.mEndValuesList;
        goto L10
    L5:
        return r5.getMatchedTransitionValues(r10, r11);
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

    @NonNull
    public final Transition getRootTransition() {
        TransitionSet r5 = this.mParent;
        if (r5 != null) goto L5;
        return this;
    L5:
        return r5.getRootTransition();
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

    public final long getTotalDurationMillis() {
        return this.mTotalDuration;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return null;
    }

    @Nullable
    public TransitionValues getTransitionValues(@NonNull View r5, boolean r10) {
        TransitionSet r11 = this.mParent;
        if (r11 != null) goto L5;
        if (r10 == false) goto L8;
        TransitionValuesMaps r12 = this.mStartValues;
    L10:
        return r12.mViewValues.get(r5);
    L8:
        r12 = this.mEndValues;
        goto L10
    L5:
        return r11.getTransitionValues(r5, r10);
    }

    public boolean hasAnimators() {
        return !this.mCurrentAnimators.isEmpty();
    }

    public boolean isSeekingSupported() {
        return false;
    }

    public boolean isTransitionRequired(@Nullable TransitionValues r10, @Nullable TransitionValues r11) {
        if (r10 == null) goto L25;
        if (r11 == null) goto L26;
        String[] r5 = getTransitionProperties();
        if (r5 == null) goto L13;
        int r12 = r5.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L27;
        if (isValueChanged(r10, r11, r5[r13]) == true) goto L19;
        r13 = r13 + 1;
    L19:
        return true;
    L27:
        return false;
    L13:
        Iterator<String> r14 = r10.values.keySet().iterator();
    L15:
        if (r14.hasNext() == false) goto L28;
        if (isValueChanged(r10, r11, r14.next()) == false) goto L15;
    L28:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    public boolean isValidTarget(View r10) {
        int r5 = r10.getId();
        ArrayList<Integer> r11 = this.mTargetIdExcludes;
        if (r11 != null) goto L5;
    L7:
        ArrayList<View> r12 = this.mTargetExcludes;
        if (r12 != null) goto L10;
    L12:
        ArrayList<Class<?>> r13 = this.mTargetTypeExcludes;
        if (r13 == null) goto L21;
        int r14 = r13.size();
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L21;
        if (this.mTargetTypeExcludes.get(r15).isInstance(r10) == true) goto L18;
        r15 = r15 + 1;
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
        ArrayList<Class<?>> r16 = this.mTargetTypes;
        if (r16 != null) goto L34;
    L35:
        ArrayList<String> r17 = this.mTargetNames;
        if (r17 != null) goto L38;
    L39:
        return true;
    L38:
        if (r17.isEmpty() == false) goto L41;
    L34:
        if (r16.isEmpty() == true) goto L35;
    L41:
        if (this.mTargetIds.contains(Integer.valueOf(r5)) == false) goto L43;
    L60:
        return true;
    L43:
        if (this.mTargets.contains(r10) == true) goto L60;
        ArrayList<String> r18 = this.mTargetNames;
        if (r18 == null) goto L51;
        if (r18.contains(ViewCompat.getTransitionName(r10)) == false) goto L51;
        return true;
    L51:
        if (this.mTargetTypes == null) goto L59;
        int r19 = 0;
    L54:
        if (r19 >= this.mTargetTypes.size()) goto L59;
        if (this.mTargetTypes.get(r19).isInstance(r10) == true) goto L57;
        r19 = r19 + 1;
        goto L54
    L57:
        return true;
    L59:
        return false;
    L10:
        if (r12.contains(r10) == false) goto L12;
        return false;
    L5:
        if (r11.contains(Integer.valueOf(r5)) == false) goto L7;
        return false;
    }

    public void notifyListeners(TransitionNotification r5, boolean r10) {
        notifyFromTransition(this, r5, r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(@Nullable View r5) {
        if (this.mEnded == true) goto L10;
        int r10 = this.mCurrentAnimators.size();
        Animator[] r11 = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        int r12 = r10 - 1;
    L5:
        if (r12 < 0) goto L7;
        Animator r13 = r11[r12];
        r11[r12] = null;
        r13.pause();
        r12 = r12 - 1;
        goto L5
    L7:
        this.mAnimatorCache = r11;
        notifyListeners(TransitionNotification.ON_PAUSE, false);
        this.mPaused = true;
        return;
    }

    public void playTransition(@NonNull ViewGroup r11) {
        this.mStartValuesList = new ArrayList();
        this.mEndValuesList = new ArrayList();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> r5 = getRunningAnimators();
        int r10 = r5.size();
        WindowId r12 = r11.getWindowId();
        int r13 = r10 - 1;
    L3:
        if (r13 < 0) goto L35;
        Animator r14 = r5.keyAt(r13);
        if (r14 == null) goto L34;
        AnimationInfo r15 = r5.get(r14);
        if (r15 == null) goto L34;
        if (r15.mView == null) goto L34;
        if (r12.equals(r15.mWindowId) == false) goto L34;
        TransitionValues r16 = r15.mValues;
        View r17 = r15.mView;
        TransitionValues r18 = getTransitionValues(r17, true);
        TransitionValues r19 = getMatchedTransitionValues(r17, true);
        if (r18 != null) goto L16;
        if (r19 != null) goto L16;
        r19 = this.mEndValues.mViewValues.get(r17);
    L16:
        if (r18 != null) goto L19;
        if (r19 == null) goto L34;
    L19:
        if (r15.mTransition.isTransitionRequired(r16, r19) == false) goto L34;
        Transition r20 = r15.mTransition;
        if (r20.getRootTransition().mSeekController == null) goto L28;
        r14.cancel();
        r20.mCurrentAnimators.remove(r14);
        r5.remove(r14);
        if (r20.mCurrentAnimators.size() != 0) goto L34;
        r20.notifyListeners(TransitionNotification.ON_CANCEL, false);
        if (r20.mEnded == true) goto L34;
        r20.mEnded = true;
        r20.notifyListeners(TransitionNotification.ON_END, false);
        goto L34
    L28:
        if (r14.isRunning() == false) goto L30;
    L33:
        r14.cancel();
        goto L34
    L30:
        if (r14.isStarted() == true) goto L33;
        r5.remove(r14);
    L34:
        r13 = r13 - 1;
        goto L3
    L35:
        createAnimators(r11, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        if (this.mSeekController != null) goto L39;
        runAnimators();
        return;
    L39:
        if (Build.VERSION.SDK_INT < 34) goto L55;
        prepareAnimatorsForSeeking();
        this.mSeekController.initPlayTime();
        this.mSeekController.ready();
        return;
    }

    @RequiresApi(34)
    public void prepareAnimatorsForSeeking() {
        ArrayMap<Animator, AnimationInfo> r5 = getRunningAnimators();
        this.mTotalDuration = 0;
        int r10 = 0;
    L4:
        if (r10 >= this.mAnimators.size()) goto L19;
        Animator r11 = this.mAnimators.get(r10);
        AnimationInfo r12 = r5.get(r11);
        if (r11 == null) goto L18;
        if (r12 == null) goto L18;
        if (getDuration() < 0) goto L12;
        r12.mAnimator.setDuration(getDuration());
    L12:
        if (getStartDelay() < 0) goto L15;
        Animator r13 = r12.mAnimator;
        long r14 = getStartDelay();
        r13.setStartDelay(r12.mAnimator.getStartDelay() + r14);
    L15:
        if (getInterpolator() == null) goto L17;
        r12.mAnimator.setInterpolator(getInterpolator());
    L17:
        this.mCurrentAnimators.add(r11);
        this.mTotalDuration = Math.max(this.mTotalDuration, Impl26.getTotalDuration(r11));
    L18:
        r10 = r10 + 1;
        goto L4
    L19:
        this.mAnimators.clear();
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener r5) {
        ArrayList<TransitionListener> r10 = this.mListeners;
        if (r10 != null) goto L6;
        return this;
    L6:
        if (r10.remove(r5) == true) goto L11;
        Transition r11 = this.mCloneParent;
        if (r11 == null) goto L11;
        r11.removeListener(r5);
    L11:
        if (this.mListeners.size() != 0) goto L13;
        this.mListeners = null;
    L13:
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull View r5) {
        this.mTargets.remove(r5);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(@Nullable View r5) {
        if (this.mPaused == true) goto L5;
        return;
    L5:
        if (this.mEnded == true) goto L10;
        int r10 = this.mCurrentAnimators.size();
        Animator[] r11 = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        int r12 = r10 - 1;
    L7:
        if (r12 < 0) goto L9;
        Animator r13 = r11[r12];
        r11[r12] = null;
        r13.resume();
        r12 = r12 - 1;
        goto L7
    L9:
        this.mAnimatorCache = r11;
        notifyListeners(TransitionNotification.ON_RESUME, false);
    L10:
        this.mPaused = false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> r5 = getRunningAnimators();
        Iterator<Animator> r10 = this.mAnimators.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Animator r11 = r10.next();
        if (r5.containsKey(r11) == false) goto L4;
        start();
        runAnimator(r11, r5);
        goto L4
    L8:
        this.mAnimators.clear();
        end();
    }

    public void setCanRemoveViews(boolean r5) {
        this.mCanRemoveViews = r5;
    }

    @RequiresApi(34)
    public void setCurrentPlayTimeMillis(long r19, long r21) {
        long r5 = getTotalDurationMillis();
        int r10 = 0;
        if (r19 >= r21) goto L5;
        boolean r11 = true;
    L6:
        int r12 = (r21 > 0 ? 1 : (r21 == 0 ? 0 : -1));
        if (r12 >= 0) goto L11;
        if (r19 < 0) goto L11;
    L14:
        this.mEnded = false;
        notifyListeners(TransitionNotification.ON_START, r11);
    L15:
        int r13 = this.mCurrentAnimators.size();
        Animator[] r14 = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
    L16:
        if (r10 >= r13) goto L18;
        Animator r15 = r14[r10];
        r14[r10] = null;
        Impl26.setCurrentPlayTime(r15, Math.min(Math.max(0, r19), Impl26.getTotalDuration(r15)));
        r10 = r10 + 1;
        r12 = r12;
        r13 = r13;
        goto L16
    L18:
        int r16 = r12;
        this.mAnimatorCache = r14;
        if (r19 <= r5) goto L23;
        if (r21 > r5) goto L23;
    L25:
        if (r19 <= r5) goto L27;
        this.mEnded = true;
    L27:
        notifyListeners(TransitionNotification.ON_END, r11);
        return;
    L23:
        if (r19 >= 0) goto L30;
        if (r16 >= 0) goto L25;
        return;
    L30:
        return;
    L11:
        if (r21 <= r5) goto L15;
        if (r19 > r5) goto L15;
    L5:
        r11 = false;
        goto L6
    }

    @NonNull
    public Transition setDuration(long r5) {
        this.mDuration = r5;
        return this;
    }

    public void setEpicenterCallback(@Nullable EpicenterCallback r5) {
        this.mEpicenterCallback = r5;
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator r5) {
        this.mInterpolator = r5;
        return this;
    }

    public void setMatchOrder(@Nullable int... r5) {
        if (r5 != null) goto L4;
    L19:
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        return;
    L4:
        if (r5.length == 0) goto L19;
        int r10 = 0;
    L8:
        if (r10 >= r5.length) goto L18;
        if (isValidMatch(r5[r10]) == false) goto L17;
        if (alreadyContains(r5, r10) == true) goto L15;
        r10 = r10 + 1;
        goto L8
    L15:
        throw new IllegalArgumentException("matches contains a duplicate value");
    L17:
        throw new IllegalArgumentException("matches contains invalid value");
    L18:
        this.mMatchOrder = (int[]) r5.clone();
    }

    public void setPathMotion(@Nullable PathMotion r5) {
        if (r5 != null) goto L4;
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        return;
    L4:
        this.mPathMotion = r5;
    }

    public void setPropagation(@Nullable TransitionPropagation r5) {
        this.mPropagation = r5;
    }

    @NonNull
    public Transition setStartDelay(long r5) {
        this.mStartDelay = r5;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void start() {
        if (this.mNumInstances != 0) goto L5;
        notifyListeners(TransitionNotification.ON_START, false);
        this.mEnded = false;
    L5:
        this.mNumInstances++;
    }

    @NonNull
    public String toString() {
        return toString("");
    }

    @NonNull
    public Transition addTarget(@IdRes int r5) {
        if (r5 == 0) goto L4;
        this.mTargetIds.add(Integer.valueOf(r5));
    L4:
        return this;
    }

    @NonNull
    public Transition clone() {
        Transition r5 = (Transition) super.clone();     // Catch: CloneNotSupportedException -> L4
        r5.mAnimators = new ArrayList();     // Catch: CloneNotSupportedException -> L4
        r5.mStartValues = new TransitionValuesMaps();     // Catch: CloneNotSupportedException -> L4
        r5.mEndValues = new TransitionValuesMaps();     // Catch: CloneNotSupportedException -> L4
        r5.mStartValuesList = null;     // Catch: CloneNotSupportedException -> L4
        r5.mEndValuesList = null;     // Catch: CloneNotSupportedException -> L4
        r5.mSeekController = null;     // Catch: CloneNotSupportedException -> L4
        r5.mCloneParent = this;     // Catch: CloneNotSupportedException -> L4
        r5.mListeners = null;     // Catch: CloneNotSupportedException -> L4
        return r5;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @NonNull
    public Transition excludeChildren(@IdRes int r5, boolean r10) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, r5, r10);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int r5, boolean r10) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, r5, r10);
        return this;
    }

    @NonNull
    public Transition removeTarget(@IdRes int r5) {
        if (r5 == 0) goto L4;
        this.mTargetIds.remove(Integer.valueOf(r5));
    L4:
        return this;
    }

    public String toString(String r10) {
        StringBuilder r5 = new StringBuilder(r10);
        r5.append(getClass().getSimpleName());
        r5.append("@");
        r5.append(Integer.toHexString(hashCode()));
        r5.append(": ");
        if (this.mDuration == (-1)) goto L6;
        r5.append("dur(");
        r5.append(this.mDuration);
        r5.append(") ");
    L6:
        if (this.mStartDelay == (-1)) goto L9;
        r5.append("dly(");
        r5.append(this.mStartDelay);
        r5.append(") ");
    L9:
        if (this.mInterpolator == null) goto L12;
        r5.append("interp(");
        r5.append(this.mInterpolator);
        r5.append(") ");
    L12:
        if (this.mTargetIds.size() <= 0) goto L14;
    L15:
        r5.append("tgts(");
        int r11 = 0;
        if (this.mTargetIds.size() <= 0) goto L24;
        int r12 = 0;
    L19:
        if (r12 >= this.mTargetIds.size()) goto L24;
        if (r12 <= 0) goto L22;
        r5.append(", ");
    L22:
        r5.append(this.mTargetIds.get(r12));
        r12 = r12 + 1;
    L24:
        if (this.mTargets.size() > 0) goto L26;
    L30:
        r5.append(")");
    L32:
        return r5.toString();
    L26:
        if (r11 >= this.mTargets.size()) goto L30;
        if (r11 <= 0) goto L29;
        r5.append(", ");
    L29:
        r5.append(this.mTargets.get(r11));
        r11 = r11 + 1;
        goto L26
    L14:
        if (this.mTargets.size() <= 0) goto L32;
        goto L15
    }

    @NonNull
    public Transition addTarget(@NonNull String r5) {
        if (this.mTargetNames != null) goto L5;
        this.mTargetNames = new ArrayList();
    L5:
        this.mTargetNames.add(r5);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class<?> r5, boolean r10) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, r5, r10);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull String r5, boolean r10) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, r5, r10);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull String r5) {
        ArrayList<String> r10 = this.mTargetNames;
        if (r10 == null) goto L5;
        r10.remove(r5);
    L5:
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> r5, boolean r10) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, r5, r10);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull Class<?> r5) {
        ArrayList<Class<?>> r10 = this.mTargetTypes;
        if (r10 == null) goto L5;
        r10.remove(r5);
    L5:
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull Class<?> r5) {
        if (this.mTargetTypes != null) goto L5;
        this.mTargetTypes = new ArrayList();
    L5:
        this.mTargetTypes.add(r5);
        return this;
    }

    public Transition(@NonNull Context r10, @NonNull AttributeSet r11) {
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
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList();
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mCloneParent = null;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        TypedArray r5 = r10.obtainStyledAttributes(r11, Styleable.TRANSITION);
        XmlResourceParser r12 = (XmlResourceParser) r11;
        long r13 = TypedArrayUtils.getNamedInt(r5, r12, "duration", 1, -1);
        if (r13 < 0) goto L5;
        setDuration(r13);
    L5:
        long r14 = TypedArrayUtils.getNamedInt(r5, r12, "startDelay", 2, -1);
        if (r14 <= 0) goto L8;
        setStartDelay(r14);
    L8:
        int r15 = TypedArrayUtils.getNamedResourceId(r5, r12, "interpolator", 0, 0);
        if (r15 <= 0) goto L11;
        setInterpolator(AnimationUtils.loadInterpolator(r10, r15));
    L11:
        String r16 = TypedArrayUtils.getNamedString(r5, r12, "matchOrder", 3);
        if (r16 == null) goto L14;
        setMatchOrder(parseMatchOrder(r16));
    L14:
        r5.recycle();
    }
}
