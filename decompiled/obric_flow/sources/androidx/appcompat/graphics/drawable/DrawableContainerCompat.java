package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: loaded from: classes.dex */
public class DrawableContainerCompat extends Drawable implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainerCompat";
    private int mAlpha;
    private Runnable mAnimationRunnable;
    private BlockInvalidateCallback mBlockInvalidateCallback;
    private int mCurIndex;
    private Drawable mCurrDrawable;
    private DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private Rect mHotspotBounds;
    private Drawable mLastDrawable;
    private boolean mMutated;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean canApplyTheme(Drawable.ConstantState r5) {
            return r5.canApplyTheme();
        }

        public static void getOutline(Drawable r5, Outline r10) {
            r5.getOutline(r10);
        }

        public static Resources getResources(Resources.Theme r5) {
            return r5.getResources();
        }
    }

    public static class BlockInvalidateCallback implements Drawable.Callback {
        private Drawable.Callback mCallback;

        public BlockInvalidateCallback() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable r5) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable r5, @NonNull Runnable r10, long r11) {
            Drawable.Callback r12 = this.mCallback;
            if (r12 == null) goto L6;
            r12.scheduleDrawable(r5, r10, r11);
            return;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable r5, @NonNull Runnable r10) {
            Drawable.Callback r11 = this.mCallback;
            if (r11 == null) goto L6;
            r11.unscheduleDrawable(r5, r10);
            return;
        }

        public Drawable.Callback unwrap() {
            Drawable.Callback r5 = this.mCallback;
            this.mCallback = null;
            return r5;
        }

        public BlockInvalidateCallback wrap(Drawable.Callback r5) {
            this.mCallback = r5;
            return this;
        }
    }

    public static abstract class DrawableContainerState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCanConstantState;
        int mChangingConfigurations;
        boolean mCheckedConstantSize;
        boolean mCheckedConstantState;
        boolean mCheckedOpacity;
        boolean mCheckedPadding;
        boolean mCheckedStateful;
        int mChildrenChangingConfigurations;
        ColorFilter mColorFilter;
        int mConstantHeight;
        int mConstantMinimumHeight;
        int mConstantMinimumWidth;
        Rect mConstantPadding;
        boolean mConstantSize;
        int mConstantWidth;
        int mDensity;
        boolean mDither;
        SparseArray<Drawable.ConstantState> mDrawableFutures;
        Drawable[] mDrawables;
        int mEnterFadeDuration;
        int mExitFadeDuration;
        boolean mHasColorFilter;
        boolean mHasTintList;
        boolean mHasTintMode;
        int mLayoutDirection;
        boolean mMutated;
        int mNumChildren;
        int mOpacity;
        final DrawableContainerCompat mOwner;
        Resources mSourceRes;
        boolean mStateful;
        ColorStateList mTintList;
        PorterDuff.Mode mTintMode;
        boolean mVariablePadding;

        public DrawableContainerState(DrawableContainerState r5, DrawableContainerCompat r10, Resources r11) {
            int r12 = 0;
            this.mVariablePadding = false;
            this.mConstantSize = false;
            this.mDither = DrawableContainerCompat.DEFAULT_DITHER;
            this.mEnterFadeDuration = 0;
            this.mExitFadeDuration = 0;
            this.mOwner = r10;
            Rect r13 = null;
            if (r11 == null) goto L5;
            Resources r14 = r11;
        L8:
            this.mSourceRes = r14;
            if (r5 == null) goto L11;
            int r15 = r5.mDensity;
        L12:
            int r16 = DrawableContainerCompat.resolveDensity(r11, r15);
            this.mDensity = r16;
            if (r5 == null) goto L44;
            this.mChangingConfigurations = r5.mChangingConfigurations;
            this.mChildrenChangingConfigurations = r5.mChildrenChangingConfigurations;
            this.mCheckedConstantState = DrawableContainerCompat.DEFAULT_DITHER;
            this.mCanConstantState = DrawableContainerCompat.DEFAULT_DITHER;
            this.mVariablePadding = r5.mVariablePadding;
            this.mConstantSize = r5.mConstantSize;
            this.mDither = r5.mDither;
            this.mMutated = r5.mMutated;
            this.mLayoutDirection = r5.mLayoutDirection;
            this.mEnterFadeDuration = r5.mEnterFadeDuration;
            this.mExitFadeDuration = r5.mExitFadeDuration;
            this.mAutoMirrored = r5.mAutoMirrored;
            this.mColorFilter = r5.mColorFilter;
            this.mHasColorFilter = r5.mHasColorFilter;
            this.mTintList = r5.mTintList;
            this.mTintMode = r5.mTintMode;
            this.mHasTintList = r5.mHasTintList;
            this.mHasTintMode = r5.mHasTintMode;
            if (r5.mDensity != r16) goto L26;
            if (r5.mCheckedPadding == false) goto L23;
            if (r5.mConstantPadding == null) goto L21;
            r13 = new Rect(r5.mConstantPadding);
        L21:
            this.mConstantPadding = r13;
            this.mCheckedPadding = DrawableContainerCompat.DEFAULT_DITHER;
        L23:
            if (r5.mCheckedConstantSize == false) goto L26;
            this.mConstantWidth = r5.mConstantWidth;
            this.mConstantHeight = r5.mConstantHeight;
            this.mConstantMinimumWidth = r5.mConstantMinimumWidth;
            this.mConstantMinimumHeight = r5.mConstantMinimumHeight;
            this.mCheckedConstantSize = DrawableContainerCompat.DEFAULT_DITHER;
        L26:
            if (r5.mCheckedOpacity == false) goto L29;
            this.mOpacity = r5.mOpacity;
            this.mCheckedOpacity = DrawableContainerCompat.DEFAULT_DITHER;
        L29:
            if (r5.mCheckedStateful == false) goto L31;
            this.mStateful = r5.mStateful;
            this.mCheckedStateful = DrawableContainerCompat.DEFAULT_DITHER;
        L31:
            Drawable[] r17 = r5.mDrawables;
            this.mDrawables = new Drawable[r17.length];
            this.mNumChildren = r5.mNumChildren;
            SparseArray<Drawable.ConstantState> r18 = r5.mDrawableFutures;
            if (r18 == null) goto L34;
            this.mDrawableFutures = r18.clone();
        L35:
            int r19 = this.mNumChildren;
        L36:
            if (r12 >= r19) goto L50;
            Drawable r20 = r17[r12];
            if (r20 == null) goto L43;
            Drawable.ConstantState r21 = r20.getConstantState();
            if (r21 == null) goto L42;
            this.mDrawableFutures.put(r12, r21);
            goto L43
        L42:
            this.mDrawables[r12] = r17[r12];
        L43:
            r12 = r12 + 1;
            goto L36
        L50:
            return;
        L34:
            this.mDrawableFutures = new SparseArray(this.mNumChildren);
            goto L35
        L44:
            this.mDrawables = new Drawable[10];
            this.mNumChildren = 0;
            return;
        L11:
            r15 = 0;
            goto L12
        L5:
            if (r5 == null) goto L7;
            r14 = r5.mSourceRes;
            goto L8
        L7:
            r14 = null;
            goto L8
        }

        private void createAllFutures() {
            SparseArray<Drawable.ConstantState> r5 = this.mDrawableFutures;
            if (r5 == null) goto L10;
            int r10 = r5.size();
            int r11 = 0;
        L5:
            if (r11 >= r10) goto L7;
            int r12 = this.mDrawableFutures.keyAt(r11);
            Drawable.ConstantState r13 = this.mDrawableFutures.valueAt(r11);
            this.mDrawables[r12] = prepareDrawable(r13.newDrawable(this.mSourceRes));
            r11 = r11 + 1;
            goto L5
        L7:
            this.mDrawableFutures = null;
            return;
        }

        private Drawable prepareDrawable(Drawable r5) {
            DrawableCompat.setLayoutDirection(r5, this.mLayoutDirection);
            Drawable r10 = r5.mutate();
            r10.setCallback(this.mOwner);
            return r10;
        }

        public final int addChild(Drawable r5) {
            int r10 = this.mNumChildren;
            if (r10 < this.mDrawables.length) goto L5;
            growArray(r10, r10 + 10);
        L5:
            r5.mutate();
            r5.setVisible(false, DrawableContainerCompat.DEFAULT_DITHER);
            r5.setCallback(this.mOwner);
            this.mDrawables[r10] = r5;
            this.mNumChildren++;
            this.mChildrenChangingConfigurations = r5.getChangingConfigurations() | this.mChildrenChangingConfigurations;
            invalidateCache();
            this.mConstantPadding = null;
            this.mCheckedPadding = false;
            this.mCheckedConstantSize = false;
            this.mCheckedConstantState = false;
            return r10;
        }

        @RequiresApi(21)
        public final void applyTheme(Resources.Theme r10) {
            if (r10 == null) goto L17;
            createAllFutures();
            int r5 = this.mNumChildren;
            Drawable[] r11 = this.mDrawables;
            int r12 = 0;
        L4:
            if (r12 >= r5) goto L11;
            Drawable r13 = r11[r12];
            if (r13 == null) goto L10;
            if (DrawableCompat.canApplyTheme(r13) == false) goto L10;
            DrawableCompat.applyTheme(r11[r12], r10);
            this.mChildrenChangingConfigurations |= r11[r12].getChangingConfigurations();
        L10:
            r12 = r12 + 1;
            goto L4
        L11:
            updateDensity(Api21Impl.getResources(r10));
            return;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @RequiresApi(21)
        public boolean canApplyTheme() {
            int r5 = this.mNumChildren;
            Drawable[] r10 = this.mDrawables;
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L15;
            Drawable r12 = r10[r11];
            if (r12 != null) goto L7;
            Drawable.ConstantState r13 = this.mDrawableFutures.get(r11);
            if (r13 == null) goto L14;
            if (Api21Impl.canApplyTheme(r13) == false) goto L14;
            return DrawableContainerCompat.DEFAULT_DITHER;
        L14:
            r11 = r11 + 1;
            goto L3
        L7:
            if (DrawableCompat.canApplyTheme(r12) == false) goto L14;
            return DrawableContainerCompat.DEFAULT_DITHER;
        L15:
            return false;
        }

        public boolean canConstantState() {
            if (this.mCheckedConstantState == true) goto L5;
            createAllFutures();
            this.mCheckedConstantState = DrawableContainerCompat.DEFAULT_DITHER;
            int r5 = this.mNumChildren;
            Drawable[] r10 = this.mDrawables;
            int r11 = 0;
        L7:
            if (r11 >= r5) goto L13;
            if (r10[r11].getConstantState() == null) goto L10;
            r11 = r11 + 1;
            goto L7
        L10:
            this.mCanConstantState = false;
            return false;
        L13:
            this.mCanConstantState = DrawableContainerCompat.DEFAULT_DITHER;
            return DrawableContainerCompat.DEFAULT_DITHER;
        L5:
            return this.mCanConstantState;
        }

        public final void clearMutated() {
            this.mMutated = false;
        }

        public void computeConstantSize() {
            this.mCheckedConstantSize = DrawableContainerCompat.DEFAULT_DITHER;
            createAllFutures();
            int r5 = this.mNumChildren;
            Drawable[] r10 = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            int r11 = 0;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
        L3:
            if (r11 >= r5) goto L17;
            Drawable r12 = r10[r11];
            int r13 = r12.getIntrinsicWidth();
            if (r13 <= this.mConstantWidth) goto L7;
            this.mConstantWidth = r13;
        L7:
            int r14 = r12.getIntrinsicHeight();
            if (r14 <= this.mConstantHeight) goto L10;
            this.mConstantHeight = r14;
        L10:
            int r15 = r12.getMinimumWidth();
            if (r15 <= this.mConstantMinimumWidth) goto L13;
            this.mConstantMinimumWidth = r15;
        L13:
            int r16 = r12.getMinimumHeight();
            if (r16 <= this.mConstantMinimumHeight) goto L16;
            this.mConstantMinimumHeight = r16;
        L16:
            r11 = r11 + 1;
            goto L3
        }

        public final int getCapacity() {
            return this.mDrawables.length;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            int r5 = this.mChangingConfigurations;
            return this.mChildrenChangingConfigurations | r5;
        }

        public final Drawable getChild(int r5) {
            Drawable r10 = this.mDrawables[r5];
            if (r10 == null) goto L5;
            return r10;
        L5:
            SparseArray<Drawable.ConstantState> r11 = this.mDrawableFutures;
            if (r11 == null) goto L13;
            int r12 = r11.indexOfKey(r5);
            if (r12 < 0) goto L13;
            Drawable r13 = prepareDrawable(this.mDrawableFutures.valueAt(r12).newDrawable(this.mSourceRes));
            this.mDrawables[r5] = r13;
            this.mDrawableFutures.removeAt(r12);
            if (this.mDrawableFutures.size() != 0) goto L12;
            this.mDrawableFutures = null;
        L12:
            return r13;
        L13:
            return null;
        }

        public final int getChildCount() {
            return this.mNumChildren;
        }

        public final int getConstantHeight() {
            if (this.mCheckedConstantSize == true) goto L6;
            computeConstantSize();
        L6:
            return this.mConstantHeight;
        }

        public final int getConstantMinimumHeight() {
            if (this.mCheckedConstantSize == true) goto L6;
            computeConstantSize();
        L6:
            return this.mConstantMinimumHeight;
        }

        public final int getConstantMinimumWidth() {
            if (this.mCheckedConstantSize == true) goto L6;
            computeConstantSize();
        L6:
            return this.mConstantMinimumWidth;
        }

        public final Rect getConstantPadding() {
            Rect r5 = null;
            if (this.mVariablePadding == false) goto L5;
            return null;
        L5:
            Rect r10 = this.mConstantPadding;
            if (r10 == null) goto L8;
        L31:
            return r10;
        L8:
            if (this.mCheckedPadding == true) goto L31;
            createAllFutures();
            Rect r11 = new Rect();
            int r12 = this.mNumChildren;
            Drawable[] r13 = this.mDrawables;
            int r14 = 0;
        L11:
            if (r14 >= r12) goto L29;
            if (r13[r14].getPadding(r11) == false) goto L28;
            if (r5 != null) goto L16;
            r5 = new Rect(0, 0, 0, 0);
        L16:
            int r15 = r11.left;
            if (r15 <= r5.left) goto L19;
            r5.left = r15;
        L19:
            int r16 = r11.top;
            if (r16 <= r5.top) goto L22;
            r5.top = r16;
        L22:
            int r17 = r11.right;
            if (r17 <= r5.right) goto L25;
            r5.right = r17;
        L25:
            int r18 = r11.bottom;
            if (r18 <= r5.bottom) goto L28;
            r5.bottom = r18;
        L28:
            r14 = r14 + 1;
            goto L11
        L29:
            this.mCheckedPadding = DrawableContainerCompat.DEFAULT_DITHER;
            this.mConstantPadding = r5;
            return r5;
        }

        public final int getConstantWidth() {
            if (this.mCheckedConstantSize == true) goto L6;
            computeConstantSize();
        L6:
            return this.mConstantWidth;
        }

        public final int getEnterFadeDuration() {
            return this.mEnterFadeDuration;
        }

        public final int getExitFadeDuration() {
            return this.mExitFadeDuration;
        }

        public final int getOpacity() {
            if (this.mCheckedOpacity == true) goto L5;
            createAllFutures();
            int r5 = this.mNumChildren;
            Drawable[] r10 = this.mDrawables;
            if (r5 <= 0) goto L9;
            int r11 = r10[0].getOpacity();
        L10:
            int r12 = 1;
        L11:
            if (r12 >= r5) goto L13;
            r11 = Drawable.resolveOpacity(r11, r10[r12].getOpacity());
            r12 = r12 + 1;
            goto L11
        L13:
            this.mOpacity = r11;
            this.mCheckedOpacity = DrawableContainerCompat.DEFAULT_DITHER;
            return r11;
        L9:
            r11 = -2;
            goto L10
        L5:
            return this.mOpacity;
        }

        public void growArray(int r5, int r10) {
            Drawable[] r11 = new Drawable[r10];
            Drawable[] r12 = this.mDrawables;
            if (r12 == null) goto L5;
            System.arraycopy(r12, 0, r11, 0, r5);
        L5:
            this.mDrawables = r11;
        }

        public void invalidateCache() {
            this.mCheckedOpacity = false;
            this.mCheckedStateful = false;
        }

        public final boolean isConstantSize() {
            return this.mConstantSize;
        }

        public final boolean isStateful() {
            if (this.mCheckedStateful == true) goto L5;
            createAllFutures();
            int r5 = this.mNumChildren;
            Drawable[] r10 = this.mDrawables;
            boolean r11 = false;
            int r12 = 0;
        L8:
            if (r12 >= r5) goto L13;
            if (r10[r12].isStateful() == true) goto L11;
            r12 = r12 + 1;
            goto L8
        L11:
            r11 = true;
        L13:
            this.mStateful = r11;
            this.mCheckedStateful = DrawableContainerCompat.DEFAULT_DITHER;
            return r11;
        L5:
            return this.mStateful;
        }

        public void mutate() {
            int r5 = this.mNumChildren;
            Drawable[] r10 = this.mDrawables;
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L8;
            Drawable r12 = r10[r11];
            if (r12 == null) goto L7;
            r12.mutate();
        L7:
            r11 = r11 + 1;
            goto L3
        L8:
            this.mMutated = DrawableContainerCompat.DEFAULT_DITHER;
        }

        public final void setConstantSize(boolean r5) {
            this.mConstantSize = r5;
        }

        public final void setEnterFadeDuration(int r5) {
            this.mEnterFadeDuration = r5;
        }

        public final void setExitFadeDuration(int r5) {
            this.mExitFadeDuration = r5;
        }

        public final boolean setLayoutDirection(int r10, int r11) {
            int r5 = this.mNumChildren;
            Drawable[] r12 = this.mDrawables;
            int r13 = 0;
            boolean r14 = false;
        L3:
            if (r13 >= r5) goto L10;
            Drawable r15 = r12[r13];
            if (r15 == null) goto L9;
            boolean r16 = DrawableCompat.setLayoutDirection(r15, r10);
            if (r13 != r11) goto L9;
            r14 = r16;
        L9:
            r13 = r13 + 1;
            goto L3
        L10:
            this.mLayoutDirection = r10;
            return r14;
        }

        public final void setVariablePadding(boolean r5) {
            this.mVariablePadding = r5;
        }

        public final void updateDensity(Resources r5) {
            if (r5 == null) goto L7;
            this.mSourceRes = r5;
            int r10 = DrawableContainerCompat.resolveDensity(r5, this.mDensity);
            int r11 = this.mDensity;
            this.mDensity = r10;
            if (r11 == r10) goto L8;
            this.mCheckedConstantSize = false;
            this.mCheckedPadding = false;
            return;
        L8:
            return;
        }
    }

    public DrawableContainerCompat() {
        this.mAlpha = 255;
        this.mCurIndex = -1;
    }

    private void initializeDrawableForDisplay(Drawable r5) {
        if (this.mBlockInvalidateCallback != null) goto L5;
        this.mBlockInvalidateCallback = new BlockInvalidateCallback();
    L5:
        r5.setCallback(this.mBlockInvalidateCallback.wrap(r5.getCallback()));
    L11:
        th = move-exception;
        r5.setCallback(this.mBlockInvalidateCallback.unwrap());
        throw th;
    L7:
        if (this.mDrawableContainerState.mEnterFadeDuration <= 0) goto L9;
    L13:
        DrawableContainerState r10 = this.mDrawableContainerState;     // Catch: Throwable -> L11
        if (r10.mHasColorFilter == false) goto L17;
        r5.setColorFilter(r10.mColorFilter);     // Catch: Throwable -> L11
    L22:
        r5.setVisible(isVisible(), DEFAULT_DITHER);     // Catch: Throwable -> L11
        r5.setDither(this.mDrawableContainerState.mDither);     // Catch: Throwable -> L11
        r5.setState(getState());     // Catch: Throwable -> L11
        r5.setLevel(getLevel());     // Catch: Throwable -> L11
        r5.setBounds(getBounds());     // Catch: Throwable -> L11
        DrawableCompat.setLayoutDirection(r5, DrawableCompat.getLayoutDirection(this));     // Catch: Throwable -> L11
        DrawableCompat.setAutoMirrored(r5, this.mDrawableContainerState.mAutoMirrored);     // Catch: Throwable -> L11
        Rect r11 = this.mHotspotBounds;     // Catch: Throwable -> L11
        if (r11 == null) goto L25;
        DrawableCompat.setHotspotBounds(r5, r11.left, r11.top, r11.right, r11.bottom);     // Catch: Throwable -> L11
    L25:
        r5.setCallback(this.mBlockInvalidateCallback.unwrap());
        return;
    L17:
        if (r10.mHasTintList == false) goto L19;
        DrawableCompat.setTintList(r5, r10.mTintList);     // Catch: Throwable -> L11
    L19:
        DrawableContainerState r12 = this.mDrawableContainerState;     // Catch: Throwable -> L11
        if (r12.mHasTintMode == false) goto L22;
        DrawableCompat.setTintMode(r5, r12.mTintMode);     // Catch: Throwable -> L11
        goto L22
    L9:
        if (this.mHasAlpha == false) goto L13;
        r5.setAlpha(this.mAlpha);     // Catch: Throwable -> L11
        goto L13
    }

    private boolean needsMirroring() {
        if (isAutoMirrored() == true) goto L5;
    L7:
        return false;
    L5:
        if (DrawableCompat.getLayoutDirection(this) != 1) goto L7;
        return DEFAULT_DITHER;
    }

    public static int resolveDensity(@Nullable Resources r5, int r10) {
        if (r5 == null) goto L5;
        r10 = r5.getDisplayMetrics().densityDpi;
    L5:
        if (r10 != 0) goto L8;
        return 160;
    L8:
        return r10;
    }

    public void animate(boolean r14) {
        boolean r5 = DEFAULT_DITHER;
        this.mHasAlpha = DEFAULT_DITHER;
        long r10 = SystemClock.uptimeMillis();
        Drawable r11 = this.mCurrDrawable;
        if (r11 == null) goto L10;
        long r12 = this.mEnterAnimationEnd;
        if (r12 != 0) goto L7;
    L11:
        boolean r13 = false;
    L12:
        Drawable r15 = this.mLastDrawable;
        if (r15 == null) goto L20;
        long r16 = this.mExitAnimationEnd;
        if (r16 != 0) goto L17;
    L21:
        r5 = r13;
    L22:
        if (r14 == false) goto L26;
        if (r5 == false) goto L27;
        scheduleSelf(this.mAnimationRunnable, r10 + 16);
        return;
    L27:
        return;
    L26:
        return;
    L17:
        if (r16 > r10) goto L19;
        r15.setVisible(false, false);
        this.mLastDrawable = null;
        this.mExitAnimationEnd = 0;
        goto L21
    L19:
        r15.setAlpha(((((int) ((r16 - r10) * 255)) / this.mDrawableContainerState.mExitFadeDuration) * this.mAlpha) / 255);
        goto L22
    L20:
        this.mExitAnimationEnd = 0;
        goto L21
    L7:
        if (r12 > r10) goto L9;
        r11.setAlpha(this.mAlpha);
        this.mEnterAnimationEnd = 0;
        goto L11
    L9:
        r11.setAlpha(((255 - (((int) ((r12 - r10) * 255)) / this.mDrawableContainerState.mEnterFadeDuration)) * this.mAlpha) / 255);
        r13 = true;
        goto L12
    L10:
        this.mEnterAnimationEnd = 0;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme r5) {
        this.mDrawableContainerState.applyTheme(r5);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    public void clearMutated() {
        this.mDrawableContainerState.clearMutated();
        this.mMutated = false;
    }

    public DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r5) {
        Drawable r10 = this.mCurrDrawable;
        if (r10 == null) goto L5;
        r10.draw(r5);
    L5:
        Drawable r11 = this.mLastDrawable;
        if (r11 == null) goto L9;
        r11.draw(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int r5 = super.getChangingConfigurations();
        return this.mDrawableContainerState.getChangingConfigurations() | r5;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.mDrawableContainerState.canConstantState() == false) goto L6;
        DrawableContainerState r5 = this.mDrawableContainerState;
        r5.mChangingConfigurations = getChangingConfigurations();
        return this.mDrawableContainerState;
    L6:
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    public int getCurrentIndex() {
        return this.mCurIndex;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect r5) {
        Rect r10 = this.mHotspotBounds;
        if (r10 == null) goto L5;
        r5.set(r10);
        return;
    L5:
        super.getHotspotBounds(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r5 = this.mCurrDrawable;
        if (r5 != null) goto L11;
        return -1;
    L11:
        return r5.getIntrinsicHeight();
    L5:
        return this.mDrawableContainerState.getConstantHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r5 = this.mCurrDrawable;
        if (r5 != null) goto L11;
        return -1;
    L11:
        return r5.getIntrinsicWidth();
    L5:
        return this.mDrawableContainerState.getConstantWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r5 = this.mCurrDrawable;
        if (r5 != null) goto L11;
        return 0;
    L11:
        return r5.getMinimumHeight();
    L5:
        return this.mDrawableContainerState.getConstantMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r5 = this.mCurrDrawable;
        if (r5 != null) goto L11;
        return 0;
    L11:
        return r5.getMinimumWidth();
    L5:
        return this.mDrawableContainerState.getConstantMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable r5 = this.mCurrDrawable;
        if (r5 != null) goto L5;
    L8:
        return -2;
    L5:
        if (r5.isVisible() == false) goto L8;
        return this.mDrawableContainerState.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void getOutline(@NonNull Outline r5) {
        Drawable r10 = this.mCurrDrawable;
        if (r10 == null) goto L6;
        Api21Impl.getOutline(r10, r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect r5) {
        Rect r10 = this.mDrawableContainerState.getConstantPadding();
        if (r10 == null) goto L8;
        r5.set(r10);
        int r11 = (r10.left | r10.top) | r10.bottom;
        if ((r10.right | r11) == 0) goto L7;
        boolean r12 = DEFAULT_DITHER;
    L13:
        if (needsMirroring() == false) goto L15;
        int r13 = r5.left;
        r5.left = r5.right;
        r5.right = r13;
    L15:
        return r12;
    L7:
        r12 = false;
        goto L13
    L8:
        Drawable r14 = this.mCurrDrawable;
        if (r14 == null) goto L11;
        r12 = r14.getPadding(r5);
        goto L13
    L11:
        r12 = super.getPadding(r5);
        goto L13
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable r5) {
        DrawableContainerState r10 = this.mDrawableContainerState;
        if (r10 == null) goto L6;
        r10.invalidateCache();
    L6:
        if (r5 == this.mCurrDrawable) goto L8;
        return;
    L8:
        if (getCallback() == null) goto L12;
        getCallback().invalidateDrawable(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable r5 = this.mLastDrawable;
        boolean r10 = DEFAULT_DITHER;
        if (r5 == null) goto L5;
        r5.jumpToCurrentState();
        this.mLastDrawable = null;
        boolean r11 = true;
    L6:
        Drawable r12 = this.mCurrDrawable;
        if (r12 == null) goto L12;
        r12.jumpToCurrentState();
        if (this.mHasAlpha == false) goto L12;
        this.mCurrDrawable.setAlpha(this.mAlpha);
    L12:
        if (this.mExitAnimationEnd == 0) goto L15;
        this.mExitAnimationEnd = 0;
        r11 = true;
    L15:
        if (this.mEnterAnimationEnd == 0) goto L17;
        this.mEnterAnimationEnd = 0;
    L18:
        if (r10 == false) goto L21;
        invalidateSelf();
        return;
    L21:
        return;
    L17:
        r10 = r11;
        goto L18
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        DrawableContainerState r5 = cloneConstantState();
        r5.mutate();
        setConstantState(r5);
        this.mMutated = DEFAULT_DITHER;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        Drawable r10 = this.mLastDrawable;
        if (r10 == null) goto L5;
        r10.setBounds(r5);
    L5:
        Drawable r11 = this.mCurrDrawable;
        if (r11 == null) goto L9;
        r11.setBounds(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int r5) {
        return this.mDrawableContainerState.setLayoutDirection(r5, getCurrentIndex());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r5) {
        Drawable r10 = this.mLastDrawable;
        if (r10 != null) goto L5;
        Drawable r11 = this.mCurrDrawable;
        if (r11 != null) goto L9;
        return false;
    L9:
        return r11.setLevel(r5);
    L5:
        return r10.setLevel(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] r5) {
        Drawable r10 = this.mLastDrawable;
        if (r10 != null) goto L5;
        Drawable r11 = this.mCurrDrawable;
        if (r11 != null) goto L9;
        return false;
    L9:
        return r11.setState(r5);
    L5:
        return r10.setState(r5);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable r5, @NonNull Runnable r10, long r11) {
        if (r5 == this.mCurrDrawable) goto L5;
        return;
    L5:
        if (getCallback() == null) goto L9;
        getCallback().scheduleDrawable(this, r10, r11);
        return;
    }

    public boolean selectDrawable(int r10) {
        if (r10 != this.mCurIndex) goto L5;
        return false;
    L5:
        long r5 = SystemClock.uptimeMillis();
        if (this.mDrawableContainerState.mExitFadeDuration <= 0) goto L14;
        Drawable r11 = this.mLastDrawable;
        if (r11 == null) goto L10;
        r11.setVisible(false, false);
    L10:
        Drawable r12 = this.mCurrDrawable;
        if (r12 == null) goto L13;
        this.mLastDrawable = r12;
        this.mExitAnimationEnd = ((long) this.mDrawableContainerState.mExitFadeDuration) + r5;
    L17:
        if (r10 < 0) goto L26;
        DrawableContainerState r13 = this.mDrawableContainerState;
        if (r10 >= r13.mNumChildren) goto L26;
        Drawable r14 = r13.getChild(r10);
        this.mCurrDrawable = r14;
        this.mCurIndex = r10;
        if (r14 == null) goto L28;
        int r15 = this.mDrawableContainerState.mEnterFadeDuration;
        if (r15 <= 0) goto L25;
        this.mEnterAnimationEnd = r5 + ((long) r15);
    L25:
        initializeDrawableForDisplay(r14);
    L28:
        if (this.mEnterAnimationEnd == 0) goto L30;
    L31:
        Runnable r16 = this.mAnimationRunnable;
        if (r16 != null) goto L34;
        this.mAnimationRunnable = new AnonymousClass1(this);
    L35:
        animate(DEFAULT_DITHER);
    L36:
        invalidateSelf();
        return DEFAULT_DITHER;
    L34:
        unscheduleSelf(r16);
        goto L35
    L30:
        if (this.mExitAnimationEnd == 0) goto L36;
    L26:
        this.mCurrDrawable = null;
        this.mCurIndex = -1;
        goto L28
    L13:
        this.mLastDrawable = null;
        this.mExitAnimationEnd = 0;
        goto L17
    L14:
        Drawable r17 = this.mCurrDrawable;
        if (r17 == null) goto L17;
        r17.setVisible(false, false);
        goto L17
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        if (this.mHasAlpha == true) goto L5;
    L6:
        this.mHasAlpha = DEFAULT_DITHER;
        this.mAlpha = r10;
        Drawable r5 = this.mCurrDrawable;
        if (r5 != null) goto L9;
        return;
    L9:
        if (this.mEnterAnimationEnd != 0) goto L11;
        r5.setAlpha(r10);
        return;
    L11:
        animate(false);
        return;
    L5:
        if (this.mAlpha != r10) goto L6;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r5) {
        DrawableContainerState r10 = this.mDrawableContainerState;
        if (r10.mAutoMirrored == r5) goto L8;
        r10.mAutoMirrored = r5;
        Drawable r11 = this.mCurrDrawable;
        if (r11 == null) goto L9;
        DrawableCompat.setAutoMirrored(r11, r5);
        return;
    L9:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r5) {
        DrawableContainerState r10 = this.mDrawableContainerState;
        r10.mHasColorFilter = DEFAULT_DITHER;
        if (r10.mColorFilter == r5) goto L8;
        r10.mColorFilter = r5;
        Drawable r11 = this.mCurrDrawable;
        if (r11 == null) goto L9;
        r11.setColorFilter(r5);
        return;
    L9:
        return;
    }

    public void setConstantState(DrawableContainerState r5) {
        this.mDrawableContainerState = r5;
        int r10 = this.mCurIndex;
        if (r10 < 0) goto L7;
        Drawable r11 = r5.getChild(r10);
        this.mCurrDrawable = r11;
        if (r11 == null) goto L7;
        initializeDrawableForDisplay(r11);
    L7:
        this.mLastDrawable = null;
    }

    public void setCurrentIndex(int r5) {
        selectDrawable(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r5) {
        DrawableContainerState r10 = this.mDrawableContainerState;
        if (r10.mDither == r5) goto L8;
        r10.mDither = r5;
        Drawable r11 = this.mCurrDrawable;
        if (r11 == null) goto L9;
        r11.setDither(r5);
        return;
    L9:
        return;
    }

    public void setEnterFadeDuration(int r5) {
        this.mDrawableContainerState.mEnterFadeDuration = r5;
    }

    public void setExitFadeDuration(int r5) {
        this.mDrawableContainerState.mExitFadeDuration = r5;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r5, float r10) {
        Drawable r11 = this.mCurrDrawable;
        if (r11 == null) goto L6;
        DrawableCompat.setHotspot(r11, r5, r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r5, int r10, int r11, int r12) {
        Rect r13 = this.mHotspotBounds;
        if (r13 != null) goto L5;
        this.mHotspotBounds = new Rect(r5, r10, r11, r12);
    L6:
        Drawable r14 = this.mCurrDrawable;
        if (r14 == null) goto L10;
        DrawableCompat.setHotspotBounds(r14, r5, r10, r11, r12);
        return;
    L10:
        return;
    L5:
        r13.set(r5, r10, r11, r12);
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(@ColorInt int r5) {
        setTintList(ColorStateList.valueOf(r5));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r5) {
        DrawableContainerState r10 = this.mDrawableContainerState;
        r10.mHasTintList = DEFAULT_DITHER;
        if (r10.mTintList == r5) goto L6;
        r10.mTintList = r5;
        DrawableCompat.setTintList(this.mCurrDrawable, r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode r5) {
        DrawableContainerState r10 = this.mDrawableContainerState;
        r10.mHasTintMode = DEFAULT_DITHER;
        if (r10.mTintMode == r5) goto L6;
        r10.mTintMode = r5;
        DrawableCompat.setTintMode(this.mCurrDrawable, r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r5, boolean r10) {
        boolean r11 = super.setVisible(r5, r10);
        Drawable r12 = this.mLastDrawable;
        if (r12 == null) goto L5;
        r12.setVisible(r5, r10);
    L5:
        Drawable r13 = this.mCurrDrawable;
        if (r13 == null) goto L8;
        r13.setVisible(r5, r10);
    L8:
        return r11;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable r5, @NonNull Runnable r10) {
        if (r5 == this.mCurrDrawable) goto L5;
        return;
    L5:
        if (getCallback() == null) goto L9;
        getCallback().unscheduleDrawable(this, r10);
        return;
    }

    public final void updateDensity(Resources r5) {
        this.mDrawableContainerState.updateDensity(r5);
    }
}
