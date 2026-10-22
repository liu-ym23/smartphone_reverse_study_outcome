package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class StateListDrawableCompat extends DrawableContainerCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawableCompat";
    private boolean mMutated;
    private StateListState mStateListState;

    static class StateListState extends DrawableContainerCompat.DrawableContainerState {
        int[][] mStateSets;

        StateListState(StateListState r10, StateListDrawableCompat r11, Resources r12) {
            super(r10, r11, r12);
            if (r10 == null) goto L5;
            this.mStateSets = r10.mStateSets;
            return;
        L5:
            this.mStateSets = new int[getCapacity()][];
        }

        int addStateSet(int[] r10, Drawable r11) {
            int r12 = addChild(r11);
            this.mStateSets[r12] = r10;
            return r12;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        public void growArray(int r10, int r11) {
            super.growArray(r10, r11);
            int[][] r12 = new int[r11][];
            System.arraycopy(this.mStateSets, 0, r12, 0, r10);
            this.mStateSets = r12;
        }

        int indexOfStateSet(int[] r10) {
            int[][] r11 = this.mStateSets;
            int r12 = getChildCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L8;
            if (StateSet.stateSetMatches(r11[r13], r10) == true) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return r13;
        L8:
            return -1;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        void mutate() {
            int[][] r10 = this.mStateSets;
            int[][] r11 = new int[r10.length][];
            int r12 = r10.length - 1;
        L3:
            if (r12 < 0) goto L9;
            int[][] r13 = this.mStateSets;
            if (r13[r12] == null) goto L7;
            int[] r14 = (int[]) r13[r12].clone();
        L8:
            r11[r12] = r14;
            r12 = r12 - 1;
            goto L3
        L7:
            r14 = null;
            goto L8
        L9:
            this.mStateSets = r11;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new StateListDrawableCompat(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources r10) {
            return new StateListDrawableCompat(this, r10);
        }
    }

    public StateListDrawableCompat() {
        this(null, null);
    }

    StateListDrawableCompat(@Nullable StateListState r10) {
        if (r10 == null) goto L6;
        setConstantState(r10);
        return;
    }

    StateListDrawableCompat(StateListState r10, Resources r11) {
        setConstantState(new StateListState(r10, this, r11));
        onStateChange(getState());
    }

    private void inflateChildElements(Context r10, Resources r11, XmlPullParser r12, AttributeSet r13, Resources.Theme r14) {
        StateListState r15 = this.mStateListState;
        int r16 = r12.getDepth() + 1;
    L3:
        int r17 = r12.next();
        if (r17 == 1) goto L32;
        int r18 = r12.getDepth();
        if (r18 >= r16) goto L10;
        if (r17 != 3) goto L10;
        return;
    L10:
        if (r17 != 2) goto L3;
        if (r18 > r16) goto L3;
        if (r12.getName().equals("item") == false) goto L3;
        TypedArray r19 = TypedArrayUtils.obtainAttributes(r11, r14, r13, R.styleable.StateListDrawableItem);
        Drawable r20 = null;
        int r21 = r19.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
        if (r21 <= 0) goto L19;
        r20 = ResourceManagerInternal.get().getDrawable(r10, r21);
    L19:
        r19.recycle();
        int[] r22 = extractStateSet(r13);
        if (r20 != null) goto L31;
    L21:
        int r23 = r12.next();
        if (r23 == 4) goto L21;
        if (r23 != 2) goto L30;
        if (Build.VERSION.SDK_INT < 21) goto L28;
        r20 = Compatibility.Api21Impl.createFromXmlInner(r11, r12, r13, r14);
        goto L31
    L28:
        r20 = Drawable.createFromXmlInner(r11, r12, r13);
        goto L31
    L30:
        throw new XmlPullParserException(r12.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    L31:
        r15.addStateSet(r22, r20);
        goto L3
    }

    private void updateStateFromTypedArray(TypedArray r10) {
        StateListState r11 = this.mStateListState;
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r11.mChangingConfigurations |= Compatibility.Api21Impl.getChangingConfigurations(r10);
    L5:
        r11.mVariablePadding = r10.getBoolean(R.styleable.StateListDrawable_android_variablePadding, r11.mVariablePadding);
        r11.mConstantSize = r10.getBoolean(R.styleable.StateListDrawable_android_constantSize, r11.mConstantSize);
        r11.mEnterFadeDuration = r10.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, r11.mEnterFadeDuration);
        r11.mExitFadeDuration = r10.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, r11.mExitFadeDuration);
        r11.mDither = r10.getBoolean(R.styleable.StateListDrawable_android_dither, r11.mDither);
    }

    public void addState(int[] r10, Drawable r11) {
        if (r11 == null) goto L5;
        this.mStateListState.addStateSet(r10, r11);
        onStateChange(getState());
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme r10) {
        super.applyTheme(r10);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* bridge */ /* synthetic */ DrawableContainerCompat.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    StateListState cloneConstantState() {
        return new StateListState(this.mStateListState, this, null);
    }

    int[] extractStateSet(AttributeSet r10) {
        int r11 = r10.getAttributeCount();
        int[] r12 = new int[r11];
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r11) goto L17;
        int r15 = r10.getAttributeNameResource(r13);
        if (r15 == 0) goto L15;
        if (r15 == 16842960) goto L15;
        if (r15 == 16843161) goto L15;
        int r16 = r14 + 1;
        if (r10.getAttributeBooleanValue(r13, false) == true) goto L14;
        r15 = -r15;
    L14:
        r12[r14] = r15;
        r14 = r16;
    L15:
        r13 = r13 + 1;
        goto L3
    L17:
        return StateSet.trimStateSet(r12, r14);
    }

    int getStateCount() {
        return this.mStateListState.getChildCount();
    }

    Drawable getStateDrawable(int r10) {
        return this.mStateListState.getChild(r10);
    }

    int getStateDrawableIndex(int[] r10) {
        return this.mStateListState.indexOfStateSet(r10);
    }

    StateListState getStateListState() {
        return this.mStateListState;
    }

    int[] getStateSet(int r10) {
        return this.mStateListState.mStateSets[r10];
    }

    public void inflate(@NonNull Context r10, @NonNull Resources r11, @NonNull XmlPullParser r12, @NonNull AttributeSet r13, @Nullable Resources.Theme r14) {
        TypedArray r15 = TypedArrayUtils.obtainAttributes(r11, r14, r13, R.styleable.StateListDrawable);
        setVisible(r15.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        updateStateFromTypedArray(r15);
        updateDensity(r11);
        r15.recycle();
        inflateChildElements(r10, r11, r12, r13, r14);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        this.mStateListState.mutate();
        this.mMutated = true;
        goto L7
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] r10) {
        boolean r11 = super.onStateChange(r10);
        int r12 = this.mStateListState.indexOfStateSet(r10);
        if (r12 >= 0) goto L6;
        r12 = this.mStateListState.indexOfStateSet(StateSet.WILD_CARD);
    L6:
        if (selectDrawable(r12) == true) goto L10;
        if (r11 == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void setConstantState(@NonNull DrawableContainerCompat.DrawableContainerState r10) {
        super.setConstantState(r10);
        if ((r10 instanceof StateListState) == false) goto L6;
        this.mStateListState = (StateListState) r10;
        return;
    }
}
