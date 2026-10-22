package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {
    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String LOGTAG = null;
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private boolean mMutated;
    private AnimatedStateListState mState;
    private Transition mTransition;
    private int mTransitionFromIndex;
    private int mTransitionToIndex;

    /* JADX INFO: renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AnimatableTransition extends Transition {
        private final Animatable mA;

        AnimatableTransition(Animatable r10) {
            super(null);
            this.mA = r10;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mA.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mA.stop();
        }
    }

    static class AnimatedStateListState extends StateListDrawableCompat.StateListState {
        private static final long REVERSED_BIT = 4294967296L;
        private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
        SparseArrayCompat<Integer> mStateIds;
        LongSparseArray<Long> mTransitions;

        AnimatedStateListState(@Nullable AnimatedStateListState r10, @NonNull AnimatedStateListDrawableCompat r11, @Nullable Resources r12) {
            super(r10, r11, r12);
            if (r10 == null) goto L5;
            this.mTransitions = r10.mTransitions;
            SparseArrayCompat<Integer> r13 = r10.mStateIds;
        L6:
            this.mStateIds = r13;
            return;
        L5:
            this.mTransitions = new LongSparseArray();
            r13 = new SparseArrayCompat();
            goto L6
        }

        private static long generateTransitionKey(int r10, int r11) {
            long r12 = ((long) r10) << 32;
            return ((long) r11) | r12;
        }

        int addStateSet(@NonNull int[] r10, @NonNull Drawable r11, int r12) {
            int r13 = super.addStateSet(r10, r11);
            this.mStateIds.put(r13, Integer.valueOf(r12));
            return r13;
        }

        int addTransition(int r10, int r11, @NonNull Drawable r12, boolean r13) {
            int r14 = super.addChild(r12);
            long r15 = generateTransitionKey(r10, r11);
            if (r13 == false) goto L5;
            long r16 = REVERSIBLE_FLAG_BIT;
        L6:
            long r17 = r14;
            this.mTransitions.append(r15, Long.valueOf(r17 | r16));
            if (r13 == false) goto L9;
            this.mTransitions.append(generateTransitionKey(r11, r10), Long.valueOf((REVERSED_BIT | r17) | r16));
        L9:
            return r14;
        L5:
            r16 = 0;
            goto L6
        }

        int getKeyframeIdAt(int r10) {
            if (r10 >= 0) goto L6;
            return 0;
        L6:
            return this.mStateIds.get(r10, 0).intValue();
        }

        int indexOfKeyframe(@NonNull int[] r10) {
            int r11 = super.indexOfStateSet(r10);
            if (r11 < 0) goto L6;
            return r11;
        L6:
            return super.indexOfStateSet(StateSet.WILD_CARD);
        }

        int indexOfTransition(int r10, int r11) {
            long r12 = generateTransitionKey(r10, r11);
            return (int) this.mTransitions.get(r12, -1L).longValue();
        }

        boolean isTransitionReversed(int r10, int r11) {
            long r12 = generateTransitionKey(r10, r11);
            if ((this.mTransitions.get(r12, -1L).longValue() & REVERSED_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        void mutate() {
            this.mTransitions = this.mTransitions.clone();
            this.mStateIds = this.mStateIds.clone();
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources r10) {
            return new AnimatedStateListDrawableCompat(this, r10);
        }

        boolean transitionHasReversibleFlag(int r10, int r11) {
            long r12 = generateTransitionKey(r10, r11);
            if ((this.mTransitions.get(r12, -1L).longValue() & REVERSIBLE_FLAG_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static class AnimatedVectorDrawableTransition extends Transition {
        private final AnimatedVectorDrawableCompat mAvd;

        AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat r10) {
            super(null);
            this.mAvd = r10;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mAvd.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mAvd.stop();
        }
    }

    private static class AnimationDrawableTransition extends Transition {
        private final ObjectAnimator mAnim;
        private final boolean mHasReversibleFlag;

        AnimationDrawableTransition(AnimationDrawable r10, boolean r11, boolean r12) {
            super(null);
            int r13 = r10.getNumberOfFrames();
            if (r11 == false) goto L5;
            int r14 = r13 - 1;
        L7:
            if (r11 == false) goto L9;
            int r15 = 0;
        L10:
            FrameInterpolator r16 = new FrameInterpolator(r10, r11);
            ObjectAnimator r17 = ObjectAnimator.ofInt(r10, "currentIndex", new int[]{r14, r15});
            if (Build.VERSION.SDK_INT < 18) goto L13;
            Compatibility.Api18Impl.setAutoCancel(r17, true);
        L13:
            r17.setDuration(r16.getTotalDuration());
            r17.setInterpolator(r16);
            this.mHasReversibleFlag = r12;
            this.mAnim = r17;
            return;
        L9:
            r15 = r13 - 1;
            goto L10
        L5:
            r14 = 0;
            goto L7
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void reverse() {
            this.mAnim.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mAnim.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mAnim.cancel();
        }
    }

    private static class FrameInterpolator implements TimeInterpolator {
        private int[] mFrameTimes;
        private int mFrames;
        private int mTotalDuration;

        FrameInterpolator(AnimationDrawable r10, boolean r11) {
            updateFrames(r10, r11);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            int r11 = (int) ((r10 * this.mTotalDuration) + 0.5f);
            int r12 = this.mFrames;
            int[] r13 = this.mFrameTimes;
            int r14 = 0;
        L3:
            if (r14 >= r12) goto L7;
            if (r11 < r13[r14]) goto L7;
            r11 = r11 - r13[r14];
            r14 = r14 + 1;
        L7:
            if (r14 >= r12) goto L9;
            float r15 = r11 / this.mTotalDuration;
        L11:
            return (r14 / r12) + r15;
        L9:
            r15 = 0.0f;
            goto L11
        }

        int getTotalDuration() {
            return this.mTotalDuration;
        }

        int updateFrames(AnimationDrawable r10, boolean r11) {
            int r12 = r10.getNumberOfFrames();
            this.mFrames = r12;
            int[] r13 = this.mFrameTimes;
            if (r13 != null) goto L5;
        L6:
            this.mFrameTimes = new int[r12];
        L7:
            int[] r14 = this.mFrameTimes;
            int r15 = 0;
            int r16 = 0;
        L8:
            if (r15 >= r12) goto L13;
            if (r11 == false) goto L11;
            int r17 = (r12 - r15) - 1;
        L12:
            int r18 = r10.getDuration(r17);
            r14[r15] = r18;
            r16 = r16 + r18;
            r15 = r15 + 1;
            goto L8
        L11:
            r17 = r15;
            goto L12
        L13:
            this.mTotalDuration = r16;
            return r16;
        L5:
            if (r13.length >= r12) goto L7;
            goto L6
        }
    }

    private static abstract class Transition {
        private Transition() {
        }

        /* synthetic */ Transition(AnonymousClass1 r10) {
            this();
        }

        public boolean canReverse() {
            return false;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();
    }

    static {
        LOGTAG = AnimatedStateListDrawableCompat.class.getSimpleName();
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    AnimatedStateListDrawableCompat(@Nullable AnimatedStateListState r10, @Nullable Resources r11) {
        super(null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        setConstantState(new AnimatedStateListState(r10, this, r11));
        onStateChange(getState());
        jumpToCurrentState();
    }

    @Nullable
    public static AnimatedStateListDrawableCompat create(@NonNull Context r10, @DrawableRes int r11, @Nullable Resources.Theme r12) {
        Resources r13 = r10.getResources();     // Catch: Throwable -> L14
        XmlResourceParser r14 = r13.getXml(r11);     // Catch: Throwable -> L14
        AttributeSet r15 = Xml.asAttributeSet(r14);     // Catch: Throwable -> L14
    L4:
        int r16 = r14.next();     // Catch: Throwable -> L14
        if (r16 == 2) goto L9;
        if (r16 != 1) goto L4;
    L9:
        if (r16 != 2) goto L13;
        return createFromXmlInner(r10, r13, r14, r15, r12);
    L13:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L14
    L14:
        e = move-exception;
        Log.e(LOGTAG, "parser error", e);
        return null;
    }

    @NonNull
    public static AnimatedStateListDrawableCompat createFromXmlInner(@NonNull Context r10, @NonNull Resources r11, @NonNull XmlPullParser r12, @NonNull AttributeSet r13, @Nullable Resources.Theme r14) {
        String r15 = r12.getName();
        if (r15.equals("animated-selector") == false) goto L7;
        AnimatedStateListDrawableCompat r16 = new AnimatedStateListDrawableCompat();
        r16.inflate(r10, r11, r12, r13, r14);
        return r16;
    L7:
        throw new XmlPullParserException(r12.getPositionDescription() + ": invalid animated-selector tag " + r15);
    }

    private void inflateChildElements(@NonNull Context r10, @NonNull Resources r11, @NonNull XmlPullParser r12, @NonNull AttributeSet r13, @Nullable Resources.Theme r14) {
        int r15 = r12.getDepth() + 1;
    L3:
        int r16 = r12.next();
        if (r16 == 1) goto L20;
        int r17 = r12.getDepth();
        if (r17 >= r15) goto L10;
        if (r16 != 3) goto L10;
        return;
    L10:
        if (r16 != 2) goto L3;
        if (r17 > r15) goto L3;
        if (r12.getName().equals(ELEMENT_ITEM) == true) goto L16;
        if (r12.getName().equals(ELEMENT_TRANSITION) == false) goto L3;
        parseTransition(r10, r11, r12, r13, r14);
        goto L3
    L16:
        parseItem(r10, r11, r12, r13, r14);
        goto L3
    }

    private void init() {
        onStateChange(getState());
    }

    private int parseItem(@NonNull Context r10, @NonNull Resources r11, @NonNull XmlPullParser r12, @NonNull AttributeSet r13, @Nullable Resources.Theme r14) {
        TypedArray r15 = TypedArrayUtils.obtainAttributes(r11, r14, r13, R.styleable.AnimatedStateListDrawableItem);
        int r16 = r15.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int r17 = r15.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        if (r17 <= 0) goto L5;
        Drawable r18 = ResourceManagerInternal.get().getDrawable(r10, r17);
    L6:
        r15.recycle();
        int[] r19 = extractStateSet(r13);
        if (r18 != null) goto L22;
    L8:
        int r20 = r12.next();
        if (r20 == 4) goto L8;
        if (r20 != 2) goto L21;
        if (r12.getName().equals("vector") == false) goto L17;
        r18 = VectorDrawableCompat.createFromXmlInner(r11, r12, r13, r14);
        goto L22
    L17:
        if (Build.VERSION.SDK_INT < 21) goto L19;
        r18 = Compatibility.Api21Impl.createFromXmlInner(r11, r12, r13, r14);
        goto L22
    L19:
        r18 = Drawable.createFromXmlInner(r11, r12, r13);
        goto L22
    L21:
        throw new XmlPullParserException(r12.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    L22:
        if (r18 == null) goto L26;
        return this.mState.addStateSet(r19, r18, r16);
    L26:
        throw new XmlPullParserException(r12.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    L5:
        r18 = null;
        goto L6
    }

    private int parseTransition(@NonNull Context r10, @NonNull Resources r11, @NonNull XmlPullParser r12, @NonNull AttributeSet r13, @Nullable Resources.Theme r14) {
        TypedArray r15 = TypedArrayUtils.obtainAttributes(r11, r14, r13, R.styleable.AnimatedStateListDrawableTransition);
        int r16 = r15.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int r17 = r15.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int r18 = r15.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        if (r18 <= 0) goto L5;
        Drawable r19 = ResourceManagerInternal.get().getDrawable(r10, r18);
    L6:
        boolean r20 = r15.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        r15.recycle();
        if (r19 != null) goto L22;
    L8:
        int r21 = r12.next();
        if (r21 == 4) goto L8;
        if (r21 != 2) goto L21;
        if (r12.getName().equals("animated-vector") == false) goto L17;
        r19 = AnimatedVectorDrawableCompat.createFromXmlInner(r10, r11, r12, r13, r14);
        goto L22
    L17:
        if (Build.VERSION.SDK_INT < 21) goto L19;
        r19 = Compatibility.Api21Impl.createFromXmlInner(r11, r12, r13, r14);
        goto L22
    L19:
        r19 = Drawable.createFromXmlInner(r11, r12, r13);
        goto L22
    L21:
        throw new XmlPullParserException(r12.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
    L22:
        if (r19 == null) goto L30;
        if (r16 == (-1)) goto L28;
        if (r17 == (-1)) goto L28;
        return this.mState.addTransition(r16, r17, r19, r20);
    L28:
        throw new XmlPullParserException(r12.getPositionDescription() + TRANSITION_MISSING_FROM_TO_ID);
    L30:
        throw new XmlPullParserException(r12.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
    L5:
        r19 = null;
        goto L6
    }

    private boolean selectTransition(int r10) {
        Transition r11 = this.mTransition;
        if (r11 != null) goto L5;
        int r12 = getCurrentIndex();
    L15:
        this.mTransition = null;
        this.mTransitionFromIndex = -1;
        this.mTransitionToIndex = -1;
        AnimatedStateListState r13 = this.mState;
        int r14 = r13.getKeyframeIdAt(r12);
        int r15 = r13.getKeyframeIdAt(r10);
        if (r15 == 0) goto L33;
        if (r14 == 0) goto L33;
        int r16 = r13.indexOfTransition(r14, r15);
        if (r16 >= 0) goto L22;
        return false;
    L22:
        boolean r17 = r13.transitionHasReversibleFlag(r14, r15);
        selectDrawable(r16);
        Object r18 = getCurrent();
        if ((r18 instanceof AnimationDrawable) == false) goto L26;
        AnimationDrawable r19 = (AnimationDrawable) r18;
        Transition r20 = new AnimationDrawableTransition(r19, r13.isTransitionReversed(r14, r15), r17);
    L31:
        r20.start();
        this.mTransition = r20;
        this.mTransitionFromIndex = r12;
        this.mTransitionToIndex = r10;
        return true;
    L26:
        if ((r18 instanceof AnimatedVectorDrawableCompat) == false) goto L29;
        r20 = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) r18);
        goto L31
    L29:
        if ((r18 instanceof Animatable) == false) goto L33;
        r20 = new AnimatableTransition((Animatable) r18);
    L33:
        return false;
    L5:
        if (r10 != this.mTransitionToIndex) goto L8;
        return true;
    L8:
        if (r10 == this.mTransitionFromIndex) goto L10;
    L13:
        r12 = this.mTransitionToIndex;
        r11.stop();
        goto L15
    L10:
        if (r11.canReverse() == false) goto L13;
        r11.reverse();
        this.mTransitionToIndex = this.mTransitionFromIndex;
        this.mTransitionFromIndex = r10;
        return true;
    }

    private void updateStateFromTypedArray(TypedArray r10) {
        AnimatedStateListState r11 = this.mState;
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r11.mChangingConfigurations |= Compatibility.Api21Impl.getChangingConfigurations(r10);
    L5:
        r11.setVariablePadding(r10.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, r11.mVariablePadding));
        r11.setConstantSize(r10.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, r11.mConstantSize));
        r11.setEnterFadeDuration(r10.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, r11.mEnterFadeDuration));
        r11.setExitFadeDuration(r10.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, r11.mExitFadeDuration));
        setDither(r10.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, r11.mDither));
    }

    public void addState(@NonNull int[] r10, @NonNull Drawable r11, int r12) {
        ObjectsCompat.requireNonNull(r11);
        this.mState.addStateSet(r10, r11, r12);
        onStateChange(getState());
    }

    public <T extends Drawable & Animatable> void addTransition(int r10, int r11, @NonNull T r12, boolean r13) {
        ObjectsCompat.requireNonNull(r12);
        this.mState.addTransition(r10, r11, r12, r13);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    AnimatedStateListState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* bridge */ /* synthetic */ DrawableContainerCompat.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* bridge */ /* synthetic */ StateListDrawableCompat.StateListState cloneConstantState() {
        return cloneConstantState();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat
    public void inflate(@NonNull Context r10, @NonNull Resources r11, @NonNull XmlPullParser r12, @NonNull AttributeSet r13, @Nullable Resources.Theme r14) {
        TypedArray r15 = TypedArrayUtils.obtainAttributes(r11, r14, r13, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(r15.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        updateStateFromTypedArray(r15);
        updateDensity(r11);
        r15.recycle();
        inflateChildElements(r10, r11, r12, r13, r14);
        init();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition r10 = this.mTransition;
        if (r10 == null) goto L6;
        r10.stop();
        this.mTransition = null;
        selectDrawable(this.mTransitionToIndex);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        this.mState.mutate();
        this.mMutated = true;
        goto L7
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] r10) {
        int r11 = this.mState.indexOfKeyframe(r10);
        if (r11 != getCurrentIndex()) goto L5;
    L9:
        boolean r12 = false;
    L10:
        Drawable r13 = getCurrent();
        if (r13 != null) goto L13;
        return r12;
    L13:
        return r12 | r13.setState(r10);
    L5:
        if (selectTransition(r11) == false) goto L7;
    L8:
        r12 = true;
        goto L10
    L7:
        if (selectDrawable(r11) == false) goto L9;
        goto L8
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void setConstantState(@NonNull DrawableContainerCompat.DrawableContainerState r10) {
        super.setConstantState(r10);
        if ((r10 instanceof AnimatedStateListState) == false) goto L6;
        this.mState = (AnimatedStateListState) r10;
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean setVisible(boolean r10, boolean r11) {
        boolean r12 = super.setVisible(r10, r11);
        Transition r13 = this.mTransition;
        if (r13 == null) goto L9;
        if (r12 == true) goto L6;
        if (r11 == false) goto L9;
    L6:
        if (r10 == false) goto L8;
        r13.start();
        goto L9
    L8:
        jumpToCurrentState();
    L9:
        return r12;
    }
}
