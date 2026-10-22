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
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {
    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String LOGTAG = "AnimatedStateListDrawableCompat";
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private boolean mMutated;
    private AnimatedStateListState mState;
    private Transition mTransition;
    private int mTransitionFromIndex;
    private int mTransitionToIndex;

    /* JADX INFO: renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AnimatableTransition extends Transition {
        private final Animatable mA;

        public AnimatableTransition(Animatable r5) {
            super(null);
            this.mA = r5;
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

    public static class AnimatedStateListState extends StateListDrawableCompat.StateListState {
        private static final long REVERSED_BIT = 4294967296L;
        private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
        SparseArrayCompat<Integer> mStateIds;
        LongSparseArray<Long> mTransitions;

        public AnimatedStateListState(@Nullable AnimatedStateListState r5, @NonNull AnimatedStateListDrawableCompat r10, @Nullable Resources r11) {
            super(r5, r10, r11);
            if (r5 == null) goto L5;
            this.mTransitions = r5.mTransitions;
            this.mStateIds = r5.mStateIds;
            return;
        L5:
            this.mTransitions = new LongSparseArray();
            this.mStateIds = new SparseArrayCompat();
        }

        private static long generateTransitionKey(int r5, int r10) {
            long r11 = ((long) r5) << 32;
            return ((long) r10) | r11;
        }

        public int addStateSet(@NonNull int[] r5, @NonNull Drawable r10, int r11) {
            int r12 = super.addStateSet(r5, r10);
            this.mStateIds.put(r12, Integer.valueOf(r11));
            return r12;
        }

        public int addTransition(int r10, int r11, @NonNull Drawable r12, boolean r13) {
            int r14 = addChild(r12);
            long r5 = generateTransitionKey(r10, r11);
            if (r13 == false) goto L5;
            long r15 = REVERSIBLE_FLAG_BIT;
        L6:
            long r16 = r14;
            this.mTransitions.append(r5, Long.valueOf(r16 | r15));
            if (r13 == false) goto L9;
            this.mTransitions.append(generateTransitionKey(r11, r10), Long.valueOf((REVERSED_BIT | r16) | r15));
        L9:
            return r14;
        L5:
            r15 = 0;
            goto L6
        }

        public int getKeyframeIdAt(int r5) {
            if (r5 >= 0) goto L6;
            return 0;
        L6:
            return this.mStateIds.get(r5, 0).intValue();
        }

        public int indexOfKeyframe(@NonNull int[] r5) {
            int r10 = super.indexOfStateSet(r5);
            if (r10 < 0) goto L6;
            return r10;
        L6:
            return super.indexOfStateSet(StateSet.WILD_CARD);
        }

        public int indexOfTransition(int r5, int r10) {
            long r11 = generateTransitionKey(r5, r10);
            return (int) this.mTransitions.get(r11, -1L).longValue();
        }

        public boolean isTransitionReversed(int r5, int r10) {
            long r11 = generateTransitionKey(r5, r10);
            if ((this.mTransitions.get(r11, -1L).longValue() & REVERSED_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        public void mutate() {
            this.mTransitions = this.mTransitions.clone();
            this.mStateIds = this.mStateIds.clone();
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        public boolean transitionHasReversibleFlag(int r5, int r10) {
            long r11 = generateTransitionKey(r5, r10);
            if ((this.mTransitions.get(r11, -1L).longValue() & REVERSIBLE_FLAG_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources r5) {
            return new AnimatedStateListDrawableCompat(this, r5);
        }
    }

    public static class AnimatedVectorDrawableTransition extends Transition {
        private final AnimatedVectorDrawableCompat mAvd;

        public AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat r5) {
            super(null);
            this.mAvd = r5;
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

    public static class AnimationDrawableTransition extends Transition {
        private final ObjectAnimator mAnim;
        private final boolean mHasReversibleFlag;

        public AnimationDrawableTransition(AnimationDrawable r5, boolean r10, boolean r11) {
            super(null);
            int r12 = r5.getNumberOfFrames();
            int r13 = 0;
            if (r10 == false) goto L5;
            int r14 = r12 - 1;
        L7:
            if (r10 == true) goto L10;
            r13 = r12 - 1;
        L10:
            FrameInterpolator r15 = new FrameInterpolator(r5, r10);
            ObjectAnimator r16 = ObjectAnimator.ofInt(r5, "currentIndex", new int[]{r14, r13});
            Compatibility.Api18Impl.setAutoCancel(r16, true);
            r16.setDuration(r15.getTotalDuration());
            r16.setInterpolator(r15);
            this.mHasReversibleFlag = r11;
            this.mAnim = r16;
            return;
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

    public static class FrameInterpolator implements TimeInterpolator {
        private int[] mFrameTimes;
        private int mFrames;
        private int mTotalDuration;

        public FrameInterpolator(AnimationDrawable r5, boolean r10) {
            updateFrames(r5, r10);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r5) {
            int r10 = (int) ((r5 * this.mTotalDuration) + 0.5f);
            int r11 = this.mFrames;
            int[] r12 = this.mFrameTimes;
            int r13 = 0;
        L3:
            if (r13 >= r11) goto L7;
            int r14 = r12[r13];
            if (r10 < r14) goto L7;
            r10 = r10 - r14;
            r13 = r13 + 1;
        L7:
            if (r13 >= r11) goto L9;
            float r15 = r10 / this.mTotalDuration;
        L11:
            return (r13 / r11) + r15;
        L9:
            r15 = 0.0f;
            goto L11
        }

        public int getTotalDuration() {
            return this.mTotalDuration;
        }

        public int updateFrames(AnimationDrawable r10, boolean r11) {
            int r5 = r10.getNumberOfFrames();
            this.mFrames = r5;
            int[] r12 = this.mFrameTimes;
            if (r12 != null) goto L5;
        L6:
            this.mFrameTimes = new int[r5];
        L7:
            int[] r13 = this.mFrameTimes;
            int r14 = 0;
            int r15 = 0;
        L8:
            if (r14 >= r5) goto L13;
            if (r11 == false) goto L11;
            int r16 = (r5 - r14) - 1;
        L12:
            int r17 = r10.getDuration(r16);
            r13[r14] = r17;
            r15 = r15 + r17;
            r14 = r14 + 1;
            goto L8
        L11:
            r16 = r14;
            goto L12
        L13:
            this.mTotalDuration = r15;
            return r15;
        L5:
            if (r12.length >= r5) goto L7;
            goto L6
        }
    }

    public static abstract class Transition {
        private Transition() {
        }

        public boolean canReverse() {
            return false;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();

        public /* synthetic */ Transition(AnonymousClass1 r5) {
            this();
        }
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    @Nullable
    public static AnimatedStateListDrawableCompat create(@NonNull Context r10, @DrawableRes int r11, @Nullable Resources.Theme r12) {
        Resources r5 = r10.getResources();     // Catch: IOException -> L12 XmlPullParserException -> L14
        XmlResourceParser r13 = r5.getXml(r11);     // Catch: IOException -> L12 XmlPullParserException -> L14
        AttributeSet r14 = Xml.asAttributeSet(r13);     // Catch: IOException -> L12 XmlPullParserException -> L14
    L4:
        int r15 = r13.next();     // Catch: IOException -> L12 XmlPullParserException -> L14
        if (r15 == 2) goto L9;
        if (r15 != 1) goto L4;
    L9:
        if (r15 != 2) goto L17;
        return createFromXmlInner(r10, r5, r13, r14, r12);
    L17:
        throw new XmlPullParserException("No start tag found");     // Catch: IOException -> L12 XmlPullParserException -> L14
    L12:
        e = move-exception;
        Log.e(LOGTAG, "parser error", e);
        return null;
    L14:
        e = move-exception;
        Log.e(LOGTAG, "parser error", e);
        return null;
    }

    @NonNull
    public static AnimatedStateListDrawableCompat createFromXmlInner(@NonNull Context r10, @NonNull Resources r11, @NonNull XmlPullParser r12, @NonNull AttributeSet r13, @Nullable Resources.Theme r14) throws IOException, XmlPullParserException {
        String r5 = r12.getName();
        if (r5.equals("animated-selector") == false) goto L7;
        AnimatedStateListDrawableCompat r15 = new AnimatedStateListDrawableCompat();
        r15.inflate(r10, r11, r12, r13, r14);
        return r15;
    L7:
        throw new XmlPullParserException(r12.getPositionDescription() + ": invalid animated-selector tag " + r5);
    }

    private void inflateChildElements(@NonNull Context r10, @NonNull Resources r11, @NonNull XmlPullParser r12, @NonNull AttributeSet r13, @Nullable Resources.Theme r14) throws XmlPullParserException, IOException {
        int r5 = r12.getDepth() + 1;
    L3:
        int r15 = r12.next();
        if (r15 == 1) goto L20;
        int r16 = r12.getDepth();
        if (r16 >= r5) goto L10;
        if (r15 != 3) goto L10;
        return;
    L10:
        if (r15 != 2) goto L3;
        if (r16 > r5) goto L3;
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

    private int parseItem(@NonNull Context r5, @NonNull Resources r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) throws XmlPullParserException, IOException {
        TypedArray r14 = TypedArrayUtils.obtainAttributes(r10, r13, r12, R.styleable.AnimatedStateListDrawableItem);
        int r15 = r14.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int r16 = r14.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        if (r16 <= 0) goto L5;
        Drawable r17 = ResourceManagerInternal.get().getDrawable(r5, r16);
    L6:
        r14.recycle();
        int[] r18 = extractStateSet(r12);
        if (r17 != null) goto L19;
    L8:
        int r19 = r11.next();
        if (r19 == 4) goto L8;
        if (r19 != 2) goto L18;
        if (r11.getName().equals("vector") == false) goto L16;
        r17 = VectorDrawableCompat.createFromXmlInner(r10, r11, r12, r13);
        goto L19
    L16:
        r17 = Compatibility.Api21Impl.createFromXmlInner(r10, r11, r12, r13);
        goto L19
    L18:
        throw new XmlPullParserException(r11.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    L19:
        if (r17 == null) goto L23;
        return this.mState.addStateSet(r18, r17, r15);
    L23:
        throw new XmlPullParserException(r11.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    L5:
        r17 = null;
        goto L6
    }

    private int parseTransition(@NonNull Context r10, @NonNull Resources r11, @NonNull XmlPullParser r12, @NonNull AttributeSet r13, @Nullable Resources.Theme r14) throws XmlPullParserException, IOException {
        TypedArray r5 = TypedArrayUtils.obtainAttributes(r11, r14, r13, R.styleable.AnimatedStateListDrawableTransition);
        int r15 = r5.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int r16 = r5.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int r17 = r5.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        if (r17 <= 0) goto L5;
        Drawable r18 = ResourceManagerInternal.get().getDrawable(r10, r17);
    L6:
        boolean r19 = r5.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        r5.recycle();
        if (r18 != null) goto L19;
    L8:
        int r20 = r12.next();
        if (r20 == 4) goto L8;
        if (r20 != 2) goto L18;
        if (r12.getName().equals("animated-vector") == false) goto L16;
        r18 = AnimatedVectorDrawableCompat.createFromXmlInner(r10, r11, r12, r13, r14);
        goto L19
    L16:
        r18 = Compatibility.Api21Impl.createFromXmlInner(r11, r12, r13, r14);
        goto L19
    L18:
        throw new XmlPullParserException(r12.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
    L19:
        if (r18 == null) goto L27;
        if (r15 == (-1)) goto L25;
        if (r16 == (-1)) goto L25;
        return this.mState.addTransition(r15, r16, r18, r19);
    L25:
        throw new XmlPullParserException(r12.getPositionDescription() + TRANSITION_MISSING_FROM_TO_ID);
    L27:
        throw new XmlPullParserException(r12.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
    L5:
        r18 = null;
        goto L6
    }

    private boolean selectTransition(int r10) {
        Transition r5 = this.mTransition;
        if (r5 != null) goto L5;
        int r11 = getCurrentIndex();
    L15:
        this.mTransition = null;
        this.mTransitionFromIndex = -1;
        this.mTransitionToIndex = -1;
        AnimatedStateListState r12 = this.mState;
        int r13 = r12.getKeyframeIdAt(r11);
        int r14 = r12.getKeyframeIdAt(r10);
        if (r14 == 0) goto L33;
        if (r13 == 0) goto L33;
        int r15 = r12.indexOfTransition(r13, r14);
        if (r15 >= 0) goto L22;
        return false;
    L22:
        boolean r16 = r12.transitionHasReversibleFlag(r13, r14);
        selectDrawable(r15);
        Object r17 = getCurrent();
        if ((r17 instanceof AnimationDrawable) == false) goto L26;
        AnimationDrawable r18 = (AnimationDrawable) r17;
        Transition r19 = new AnimationDrawableTransition(r18, r12.isTransitionReversed(r13, r14), r16);
    L31:
        r19.start();
        this.mTransition = r19;
        this.mTransitionFromIndex = r11;
        this.mTransitionToIndex = r10;
        return true;
    L26:
        if ((r17 instanceof AnimatedVectorDrawableCompat) == false) goto L29;
        r19 = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) r17);
        goto L31
    L29:
        if ((r17 instanceof Animatable) == false) goto L33;
        r19 = new AnimatableTransition((Animatable) r17);
    L33:
        return false;
    L5:
        if (r10 != this.mTransitionToIndex) goto L8;
        return true;
    L8:
        if (r10 == this.mTransitionFromIndex) goto L10;
    L13:
        r11 = this.mTransitionToIndex;
        r5.stop();
        goto L15
    L10:
        if (r5.canReverse() == false) goto L13;
        r5.reverse();
        this.mTransitionToIndex = this.mTransitionFromIndex;
        this.mTransitionFromIndex = r10;
        return true;
    }

    private void updateStateFromTypedArray(TypedArray r5) {
        AnimatedStateListState r10 = this.mState;
        r10.mChangingConfigurations |= Compatibility.Api21Impl.getChangingConfigurations(r5);
        r10.setVariablePadding(r5.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, r10.mVariablePadding));
        r10.setConstantSize(r5.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, r10.mConstantSize));
        r10.setEnterFadeDuration(r5.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, r10.mEnterFadeDuration));
        r10.setExitFadeDuration(r5.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, r10.mExitFadeDuration));
        setDither(r5.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, r10.mDither));
    }

    public void addState(@NonNull int[] r5, @NonNull Drawable r10, int r11) {
        ObjectsCompat.requireNonNull(r10);
        this.mState.addStateSet(r5, r10, r11);
        onStateChange(getState());
    }

    public <T extends Drawable & Animatable> void addTransition(int r5, int r10, @NonNull T r11, boolean r12) {
        ObjectsCompat.requireNonNull(r11);
        this.mState.addTransition(r5, r10, r11, r12);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public /* bridge */ /* synthetic */ DrawableContainerCompat.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat
    public void inflate(@NonNull Context r5, @NonNull Resources r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) throws XmlPullParserException, IOException {
        TypedArray r14 = TypedArrayUtils.obtainAttributes(r10, r13, r12, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(r14.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        updateStateFromTypedArray(r14);
        updateDensity(r10);
        r14.recycle();
        inflateChildElements(r5, r10, r11, r12, r13);
        init();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition r5 = this.mTransition;
        if (r5 == null) goto L6;
        r5.stop();
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
    public boolean onStateChange(@NonNull int[] r5) {
        int r10 = this.mState.indexOfKeyframe(r5);
        if (r10 != getCurrentIndex()) goto L5;
    L9:
        boolean r11 = false;
    L10:
        Drawable r12 = getCurrent();
        if (r12 != null) goto L13;
        return r11;
    L13:
        return r11 | r12.setState(r5);
    L5:
        if (selectTransition(r10) == false) goto L7;
    L8:
        r11 = true;
        goto L10
    L7:
        if (selectDrawable(r10) == false) goto L9;
        goto L8
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public void setConstantState(@NonNull DrawableContainerCompat.DrawableContainerState r5) {
        super.setConstantState(r5);
        if ((r5 instanceof AnimatedStateListState) == false) goto L6;
        this.mState = (AnimatedStateListState) r5;
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean setVisible(boolean r5, boolean r10) {
        boolean r11 = super.setVisible(r5, r10);
        Transition r12 = this.mTransition;
        if (r12 == null) goto L9;
        if (r11 == true) goto L6;
        if (r10 == false) goto L9;
    L6:
        if (r5 == false) goto L8;
        r12.start();
        goto L9
    L8:
        jumpToCurrentState();
    L9:
        return r11;
    }

    public AnimatedStateListDrawableCompat(@Nullable AnimatedStateListState r5, @Nullable Resources r10) {
        super(null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        setConstantState(new AnimatedStateListState(r5, this, r10));
        onStateChange(getState());
        jumpToCurrentState();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public /* bridge */ /* synthetic */ StateListDrawableCompat.StateListState cloneConstantState() {
        return cloneConstantState();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public AnimatedStateListState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }
}
