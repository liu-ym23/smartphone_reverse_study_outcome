package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class StateListDrawableCompat extends DrawableContainerCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawableCompat";
    private boolean mMutated;
    private StateListState mStateListState;

    public static class StateListState extends DrawableContainerCompat.DrawableContainerState {
        int[][] mStateSets;

        public StateListState(StateListState r5, StateListDrawableCompat r10, Resources r11) {
            super(r5, r10, r11);
            if (r5 == null) goto L5;
            this.mStateSets = r5.mStateSets;
            return;
        L5:
            this.mStateSets = new int[getCapacity()][];
        }

        public int addStateSet(int[] r5, Drawable r10) {
            int r11 = addChild(r10);
            this.mStateSets[r11] = r5;
            return r11;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        public void growArray(int r5, int r10) {
            super.growArray(r5, r10);
            int[][] r11 = new int[r10][];
            System.arraycopy(this.mStateSets, 0, r11, 0, r5);
            this.mStateSets = r11;
        }

        public int indexOfStateSet(int[] r5) {
            int[][] r10 = this.mStateSets;
            int r11 = getChildCount();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L8;
            if (StateSet.stateSetMatches(r10[r12], r5) == true) goto L6;
            r12 = r12 + 1;
            goto L3
        L6:
            return r12;
        L8:
            return -1;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        public void mutate() {
            int[][] r5 = this.mStateSets;
            int[][] r10 = new int[r5.length][];
            int r11 = r5.length - 1;
        L3:
            if (r11 < 0) goto L9;
            int[] r12 = this.mStateSets[r11];
            if (r12 == null) goto L7;
            int[] r13 = (int[]) r12.clone();
        L8:
            r10[r11] = r13;
            r11 = r11 - 1;
            goto L3
        L7:
            r13 = null;
            goto L8
        L9:
            this.mStateSets = r10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new StateListDrawableCompat(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources r5) {
            return new StateListDrawableCompat(this, r5);
        }
    }

    public StateListDrawableCompat() {
        this(null, null);
    }

    private void inflateChildElements(Context r10, Resources r11, XmlPullParser r12, AttributeSet r13, Resources.Theme r14) throws XmlPullParserException, IOException {
        StateListState r5 = this.mStateListState;
        int r15 = r12.getDepth() + 1;
    L3:
        int r16 = r12.next();
        if (r16 == 1) goto L30;
        int r17 = r12.getDepth();
        if (r17 >= r15) goto L10;
        if (r16 != 3) goto L10;
        return;
    L10:
        if (r16 != 2) goto L3;
        if (r17 > r15) goto L3;
        if (r12.getName().equals("item") == false) goto L3;
        TypedArray r18 = TypedArrayUtils.obtainAttributes(r11, r14, r13, R.styleable.StateListDrawableItem);
        int r19 = r18.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
        if (r19 <= 0) goto L19;
        Drawable r20 = ResourceManagerInternal.get().getDrawable(r10, r19);
    L20:
        r18.recycle();
        int[] r21 = extractStateSet(r13);
        if (r20 != null) goto L29;
    L22:
        int r22 = r12.next();
        if (r22 == 4) goto L22;
        if (r22 != 2) goto L28;
        r20 = Compatibility.Api21Impl.createFromXmlInner(r11, r12, r13, r14);
        goto L29
    L28:
        throw new XmlPullParserException(r12.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    L29:
        r5.addStateSet(r21, r20);
        goto L3
    L19:
        r20 = null;
        goto L20
    }

    private void updateStateFromTypedArray(TypedArray r5) {
        StateListState r10 = this.mStateListState;
        r10.mChangingConfigurations |= Compatibility.Api21Impl.getChangingConfigurations(r5);
        r10.mVariablePadding = r5.getBoolean(R.styleable.StateListDrawable_android_variablePadding, r10.mVariablePadding);
        r10.mConstantSize = r5.getBoolean(R.styleable.StateListDrawable_android_constantSize, r10.mConstantSize);
        r10.mEnterFadeDuration = r5.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, r10.mEnterFadeDuration);
        r10.mExitFadeDuration = r5.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, r10.mExitFadeDuration);
        r10.mDither = r5.getBoolean(R.styleable.StateListDrawable_android_dither, r10.mDither);
    }

    public void addState(int[] r5, Drawable r10) {
        if (r10 == null) goto L5;
        this.mStateListState.addStateSet(r5, r10);
        onStateChange(getState());
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme r5) {
        super.applyTheme(r5);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public /* bridge */ /* synthetic */ DrawableContainerCompat.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    public int[] extractStateSet(AttributeSet r10) {
        int r11 = r10.getAttributeCount();
        int[] r5 = new int[r11];
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L17;
        int r14 = r10.getAttributeNameResource(r12);
        if (r14 == 0) goto L15;
        if (r14 == 16842960) goto L15;
        if (r14 == 16843161) goto L15;
        int r15 = r13 + 1;
        if (r10.getAttributeBooleanValue(r12, false) == true) goto L14;
        r14 = -r14;
    L14:
        r5[r13] = r14;
        r13 = r15;
    L15:
        r12 = r12 + 1;
        goto L3
    L17:
        return StateSet.trimStateSet(r5, r13);
    }

    public int getStateCount() {
        return this.mStateListState.getChildCount();
    }

    public Drawable getStateDrawable(int r5) {
        return this.mStateListState.getChild(r5);
    }

    public int getStateDrawableIndex(int[] r5) {
        return this.mStateListState.indexOfStateSet(r5);
    }

    public StateListState getStateListState() {
        return this.mStateListState;
    }

    public int[] getStateSet(int r5) {
        return this.mStateListState.mStateSets[r5];
    }

    public void inflate(@NonNull Context r5, @NonNull Resources r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) throws XmlPullParserException, IOException {
        TypedArray r14 = TypedArrayUtils.obtainAttributes(r10, r13, r12, R.styleable.StateListDrawable);
        setVisible(r14.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        updateStateFromTypedArray(r14);
        updateDensity(r10);
        r14.recycle();
        inflateChildElements(r5, r10, r11, r12, r13);
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
    public boolean onStateChange(@NonNull int[] r5) {
        boolean r10 = super.onStateChange(r5);
        int r11 = this.mStateListState.indexOfStateSet(r5);
        if (r11 >= 0) goto L6;
        r11 = this.mStateListState.indexOfStateSet(StateSet.WILD_CARD);
    L6:
        if (selectDrawable(r11) == true) goto L10;
        if (r10 == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public void setConstantState(@NonNull DrawableContainerCompat.DrawableContainerState r5) {
        super.setConstantState(r5);
        if ((r5 instanceof StateListState) == false) goto L6;
        this.mStateListState = (StateListState) r5;
        return;
    }

    public StateListDrawableCompat(StateListState r5, Resources r10) {
        setConstantState(new StateListState(r5, this, r10));
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public StateListState cloneConstantState() {
        return new StateListState(this.mStateListState, this, null);
    }

    public StateListDrawableCompat(@Nullable StateListState r5) {
        if (r5 == null) goto L6;
        setConstantState(r5);
        return;
    }
}
