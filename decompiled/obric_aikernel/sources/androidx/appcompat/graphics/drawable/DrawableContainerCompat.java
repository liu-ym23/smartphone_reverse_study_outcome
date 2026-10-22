package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
    private static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean canApplyTheme(Drawable.ConstantState r10) {
            return r10.canApplyTheme();
        }

        public static void getOutline(Drawable r10, Outline r11) {
            r10.getOutline(r11);
        }

        public static Resources getResources(Resources.Theme r10) {
            return r10.getResources();
        }
    }

    static class BlockInvalidateCallback implements Drawable.Callback {
        private Drawable.Callback mCallback;

        BlockInvalidateCallback() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable r10) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable r10, @NonNull Runnable r11, long r12) {
            Drawable.Callback r13 = this.mCallback;
            if (r13 == null) goto L6;
            r13.scheduleDrawable(r10, r11, r12);
            return;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable r10, @NonNull Runnable r11) {
            Drawable.Callback r12 = this.mCallback;
            if (r12 == null) goto L6;
            r12.unscheduleDrawable(r10, r11);
            return;
        }

        public Drawable.Callback unwrap() {
            Drawable.Callback r10 = this.mCallback;
            this.mCallback = null;
            return r10;
        }

        public BlockInvalidateCallback wrap(Drawable.Callback r10) {
            this.mCallback = r10;
            return this;
        }
    }

    static abstract class DrawableContainerState extends Drawable.ConstantState {
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

        DrawableContainerState(DrawableContainerState r10, DrawableContainerCompat r11, Resources r12) {
            int r13 = 0;
            this.mVariablePadding = false;
            this.mConstantSize = false;
            this.mDither = true;
            this.mEnterFadeDuration = 0;
            this.mExitFadeDuration = 0;
            this.mOwner = r11;
            Rect r14 = null;
            if (r12 == null) goto L5;
            Resources r15 = r12;
        L8:
            this.mSourceRes = r15;
            if (r10 == null) goto L11;
            int r16 = r10.mDensity;
        L12:
            int r17 = DrawableContainerCompat.resolveDensity(r12, r16);
            this.mDensity = r17;
            if (r10 == null) goto L44;
            this.mChangingConfigurations = r10.mChangingConfigurations;
            this.mChildrenChangingConfigurations = r10.mChildrenChangingConfigurations;
            this.mCheckedConstantState = true;
            this.mCanConstantState = true;
            this.mVariablePadding = r10.mVariablePadding;
            this.mConstantSize = r10.mConstantSize;
            this.mDither = r10.mDither;
            this.mMutated = r10.mMutated;
            this.mLayoutDirection = r10.mLayoutDirection;
            this.mEnterFadeDuration = r10.mEnterFadeDuration;
            this.mExitFadeDuration = r10.mExitFadeDuration;
            this.mAutoMirrored = r10.mAutoMirrored;
            this.mColorFilter = r10.mColorFilter;
            this.mHasColorFilter = r10.mHasColorFilter;
            this.mTintList = r10.mTintList;
            this.mTintMode = r10.mTintMode;
            this.mHasTintList = r10.mHasTintList;
            this.mHasTintMode = r10.mHasTintMode;
            if (r10.mDensity != r17) goto L26;
            if (r10.mCheckedPadding == false) goto L23;
            if (r10.mConstantPadding == null) goto L21;
            r14 = new Rect(r10.mConstantPadding);
        L21:
            this.mConstantPadding = r14;
            this.mCheckedPadding = true;
        L23:
            if (r10.mCheckedConstantSize == false) goto L26;
            this.mConstantWidth = r10.mConstantWidth;
            this.mConstantHeight = r10.mConstantHeight;
            this.mConstantMinimumWidth = r10.mConstantMinimumWidth;
            this.mConstantMinimumHeight = r10.mConstantMinimumHeight;
            this.mCheckedConstantSize = true;
        L26:
            if (r10.mCheckedOpacity == false) goto L29;
            this.mOpacity = r10.mOpacity;
            this.mCheckedOpacity = true;
        L29:
            if (r10.mCheckedStateful == false) goto L31;
            this.mStateful = r10.mStateful;
            this.mCheckedStateful = true;
        L31:
            Drawable[] r18 = r10.mDrawables;
            this.mDrawables = new Drawable[r18.length];
            this.mNumChildren = r10.mNumChildren;
            SparseArray<Drawable.ConstantState> r19 = r10.mDrawableFutures;
            if (r19 == null) goto L34;
            SparseArray<Drawable.ConstantState> r20 = r19.clone();
        L35:
            this.mDrawableFutures = r20;
            int r21 = this.mNumChildren;
        L36:
            if (r13 >= r21) goto L50;
            if (r18[r13] == null) goto L43;
            Drawable.ConstantState r22 = r18[r13].getConstantState();
            if (r22 == null) goto L42;
            this.mDrawableFutures.put(r13, r22);
            goto L43
        L42:
            this.mDrawables[r13] = r18[r13];
        L43:
            r13 = r13 + 1;
            goto L36
        L50:
            return;
        L34:
            r20 = new SparseArray(this.mNumChildren);
            goto L35
        L44:
            this.mDrawables = new Drawable[10];
            this.mNumChildren = 0;
            return;
        L11:
            r16 = 0;
            goto L12
        L5:
            if (r10 == null) goto L7;
            r15 = r10.mSourceRes;
            goto L8
        L7:
            r15 = null;
            goto L8
        }

        private void createAllFutures() {
            SparseArray<Drawable.ConstantState> r10 = this.mDrawableFutures;
            if (r10 == null) goto L10;
            int r11 = r10.size();
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L7;
            int r13 = this.mDrawableFutures.keyAt(r12);
            Drawable.ConstantState r14 = this.mDrawableFutures.valueAt(r12);
            this.mDrawables[r13] = prepareDrawable(r14.newDrawable(this.mSourceRes));
            r12 = r12 + 1;
            goto L5
        L7:
            this.mDrawableFutures = null;
            return;
        }

        private Drawable prepareDrawable(Drawable r10) {
            if (Build.VERSION.SDK_INT < 23) goto L5;
            DrawableCompat.setLayoutDirection(r10, this.mLayoutDirection);
        L5:
            Drawable r11 = r10.mutate();
            r11.setCallback(this.mOwner);
            return r11;
        }

        public final int addChild(Drawable r10) {
            int r11 = this.mNumChildren;
            if (r11 < this.mDrawables.length) goto L5;
            growArray(r11, r11 + 10);
        L5:
            r10.mutate();
            r10.setVisible(false, true);
            r10.setCallback(this.mOwner);
            this.mDrawables[r11] = r10;
            this.mNumChildren++;
            this.mChildrenChangingConfigurations = r10.getChangingConfigurations() | this.mChildrenChangingConfigurations;
            invalidateCache();
            this.mConstantPadding = null;
            this.mCheckedPadding = false;
            this.mCheckedConstantSize = false;
            this.mCheckedConstantState = false;
            return r11;
        }

        @RequiresApi(21)
        final void applyTheme(Resources.Theme r10) {
            if (r10 == null) goto L17;
            createAllFutures();
            int r11 = this.mNumChildren;
            Drawable[] r12 = this.mDrawables;
            int r13 = 0;
        L4:
            if (r13 >= r11) goto L11;
            if (r12[r13] == null) goto L10;
            if (DrawableCompat.canApplyTheme(r12[r13]) == false) goto L10;
            DrawableCompat.applyTheme(r12[r13], r10);
            this.mChildrenChangingConfigurations |= r12[r13].getChangingConfigurations();
        L10:
            r13 = r13 + 1;
            goto L4
        L11:
            updateDensity(Api21Impl.getResources(r10));
            return;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @RequiresApi(21)
        public boolean canApplyTheme() {
            int r10 = this.mNumChildren;
            Drawable[] r11 = this.mDrawables;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L15;
            Drawable r13 = r11[r12];
            if (r13 != null) goto L7;
            Drawable.ConstantState r14 = this.mDrawableFutures.get(r12);
            if (r14 == null) goto L14;
            if (Api21Impl.canApplyTheme(r14) == false) goto L14;
            return true;
        L14:
            r12 = r12 + 1;
            goto L3
        L7:
            if (DrawableCompat.canApplyTheme(r13) == false) goto L14;
            return true;
        L15:
            return false;
        }

        public boolean canConstantState() {
            if (this.mCheckedConstantState == true) goto L5;
            createAllFutures();
            this.mCheckedConstantState = true;
            int r10 = this.mNumChildren;
            Drawable[] r11 = this.mDrawables;
            int r12 = 0;
        L7:
            if (r12 >= r10) goto L13;
            if (r11[r12].getConstantState() == null) goto L10;
            r12 = r12 + 1;
            goto L7
        L10:
            this.mCanConstantState = false;
            return false;
        L13:
            this.mCanConstantState = true;
            return true;
        L5:
            return this.mCanConstantState;
        }

        final void clearMutated() {
            this.mMutated = false;
        }

        protected void computeConstantSize() {
            this.mCheckedConstantSize = true;
            createAllFutures();
            int r10 = this.mNumChildren;
            Drawable[] r11 = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            int r12 = 0;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
        L3:
            if (r12 >= r10) goto L17;
            Drawable r13 = r11[r12];
            int r14 = r13.getIntrinsicWidth();
            if (r14 <= this.mConstantWidth) goto L7;
            this.mConstantWidth = r14;
        L7:
            int r15 = r13.getIntrinsicHeight();
            if (r15 <= this.mConstantHeight) goto L10;
            this.mConstantHeight = r15;
        L10:
            int r16 = r13.getMinimumWidth();
            if (r16 <= this.mConstantMinimumWidth) goto L13;
            this.mConstantMinimumWidth = r16;
        L13:
            int r17 = r13.getMinimumHeight();
            if (r17 <= this.mConstantMinimumHeight) goto L16;
            this.mConstantMinimumHeight = r17;
        L16:
            r12 = r12 + 1;
            goto L3
        }

        final int getCapacity() {
            return this.mDrawables.length;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            int r10 = this.mChangingConfigurations;
            return this.mChildrenChangingConfigurations | r10;
        }

        public final Drawable getChild(int r10) {
            Drawable r11 = this.mDrawables[r10];
            if (r11 == null) goto L5;
            return r11;
        L5:
            SparseArray<Drawable.ConstantState> r12 = this.mDrawableFutures;
            if (r12 == null) goto L13;
            int r13 = r12.indexOfKey(r10);
            if (r13 < 0) goto L13;
            Drawable r14 = prepareDrawable(this.mDrawableFutures.valueAt(r13).newDrawable(this.mSourceRes));
            this.mDrawables[r10] = r14;
            this.mDrawableFutures.removeAt(r13);
            if (this.mDrawableFutures.size() != 0) goto L12;
            this.mDrawableFutures = null;
        L12:
            return r14;
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
            Rect r10 = null;
            if (this.mVariablePadding == false) goto L5;
            return null;
        L5:
            Rect r11 = this.mConstantPadding;
            if (r11 == null) goto L8;
        L31:
            return r11;
        L8:
            if (this.mCheckedPadding == true) goto L31;
            createAllFutures();
            Rect r12 = new Rect();
            int r13 = this.mNumChildren;
            Drawable[] r14 = this.mDrawables;
            int r15 = 0;
        L11:
            if (r15 >= r13) goto L29;
            if (r14[r15].getPadding(r12) == false) goto L28;
            if (r10 != null) goto L16;
            r10 = new Rect(0, 0, 0, 0);
        L16:
            int r16 = r12.left;
            if (r16 <= r10.left) goto L19;
            r10.left = r16;
        L19:
            int r17 = r12.top;
            if (r17 <= r10.top) goto L22;
            r10.top = r17;
        L22:
            int r18 = r12.right;
            if (r18 <= r10.right) goto L25;
            r10.right = r18;
        L25:
            int r19 = r12.bottom;
            if (r19 <= r10.bottom) goto L28;
            r10.bottom = r19;
        L28:
            r15 = r15 + 1;
            goto L11
        L29:
            this.mCheckedPadding = true;
            this.mConstantPadding = r10;
            return r10;
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
            int r10 = this.mNumChildren;
            Drawable[] r11 = this.mDrawables;
            if (r10 <= 0) goto L9;
            int r12 = r11[0].getOpacity();
        L10:
            int r13 = 1;
        L11:
            if (r13 >= r10) goto L13;
            r12 = Drawable.resolveOpacity(r12, r11[r13].getOpacity());
            r13 = r13 + 1;
            goto L11
        L13:
            this.mOpacity = r12;
            this.mCheckedOpacity = true;
            return r12;
        L9:
            r12 = -2;
            goto L10
        L5:
            return this.mOpacity;
        }

        public void growArray(int r10, int r11) {
            Drawable[] r12 = new Drawable[r11];
            Drawable[] r13 = this.mDrawables;
            if (r13 == null) goto L5;
            System.arraycopy(r13, 0, r12, 0, r10);
        L5:
            this.mDrawables = r12;
        }

        void invalidateCache() {
            this.mCheckedOpacity = false;
            this.mCheckedStateful = false;
        }

        public final boolean isConstantSize() {
            return this.mConstantSize;
        }

        public final boolean isStateful() {
            if (this.mCheckedStateful == true) goto L5;
            createAllFutures();
            int r10 = this.mNumChildren;
            Drawable[] r11 = this.mDrawables;
            boolean r12 = false;
            int r13 = 0;
        L8:
            if (r13 >= r10) goto L13;
            if (r11[r13].isStateful() == true) goto L11;
            r13 = r13 + 1;
            goto L8
        L11:
            r12 = true;
        L13:
            this.mStateful = r12;
            this.mCheckedStateful = true;
            return r12;
        L5:
            return this.mStateful;
        }

        void mutate() {
            int r10 = this.mNumChildren;
            Drawable[] r11 = this.mDrawables;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L8;
            if (r11[r12] == null) goto L7;
            r11[r12].mutate();
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            this.mMutated = true;
        }

        public final void setConstantSize(boolean r10) {
            this.mConstantSize = r10;
        }

        public final void setEnterFadeDuration(int r10) {
            this.mEnterFadeDuration = r10;
        }

        public final void setExitFadeDuration(int r10) {
            this.mExitFadeDuration = r10;
        }

        final boolean setLayoutDirection(int r10, int r11) {
            int r12 = this.mNumChildren;
            Drawable[] r13 = this.mDrawables;
            int r14 = 0;
            boolean r15 = false;
        L3:
            if (r14 >= r12) goto L13;
            if (r13[r14] == null) goto L12;
            if (Build.VERSION.SDK_INT < 23) goto L9;
            boolean r16 = DrawableCompat.setLayoutDirection(r13[r14], r10);
        L10:
            if (r14 != r11) goto L12;
            r15 = r16;
            goto L12
        L9:
            r16 = false;
        L12:
            r14 = r14 + 1;
            goto L3
        L13:
            this.mLayoutDirection = r10;
            return r15;
        }

        public final void setVariablePadding(boolean r10) {
            this.mVariablePadding = r10;
        }

        final void updateDensity(Resources r10) {
            if (r10 == null) goto L7;
            this.mSourceRes = r10;
            int r11 = DrawableContainerCompat.resolveDensity(r10, this.mDensity);
            int r12 = this.mDensity;
            this.mDensity = r11;
            if (r12 == r11) goto L8;
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

    private void initializeDrawableForDisplay(Drawable r10) {
        if (this.mBlockInvalidateCallback != null) goto L5;
        this.mBlockInvalidateCallback = new BlockInvalidateCallback();
    L5:
        r10.setCallback(this.mBlockInvalidateCallback.wrap(r10.getCallback()));
    L32:
        th = move-exception;
        r10.setCallback(this.mBlockInvalidateCallback.unwrap());
        throw th;
    L7:
        if (this.mDrawableContainerState.mEnterFadeDuration <= 0) goto L9;
    L11:
        DrawableContainerState r11 = this.mDrawableContainerState;     // Catch: Throwable -> L32
        if (r11.mHasColorFilter == false) goto L15;
        r10.setColorFilter(r11.mColorFilter);     // Catch: Throwable -> L32
    L20:
        r10.setVisible(isVisible(), true);     // Catch: Throwable -> L32
        r10.setDither(this.mDrawableContainerState.mDither);     // Catch: Throwable -> L32
        r10.setState(getState());     // Catch: Throwable -> L32
        r10.setLevel(getLevel());     // Catch: Throwable -> L32
        r10.setBounds(getBounds());     // Catch: Throwable -> L32
        int r12 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L32
        if (r12 < 23) goto L24;
        DrawableCompat.setLayoutDirection(r10, DrawableCompat.getLayoutDirection(this));     // Catch: Throwable -> L32
    L24:
        if (r12 < 19) goto L26;
        DrawableCompat.setAutoMirrored(r10, this.mDrawableContainerState.mAutoMirrored);     // Catch: Throwable -> L32
    L26:
        Rect r13 = this.mHotspotBounds;     // Catch: Throwable -> L32
        if (r12 < 21) goto L30;
        if (r13 == null) goto L30;
        DrawableCompat.setHotspotBounds(r10, r13.left, r13.top, r13.right, r13.bottom);     // Catch: Throwable -> L32
    L30:
        r10.setCallback(this.mBlockInvalidateCallback.unwrap());
        return;
    L15:
        if (r11.mHasTintList == false) goto L17;
        DrawableCompat.setTintList(r10, r11.mTintList);     // Catch: Throwable -> L32
    L17:
        DrawableContainerState r14 = this.mDrawableContainerState;     // Catch: Throwable -> L32
        if (r14.mHasTintMode == false) goto L20;
        DrawableCompat.setTintMode(r10, r14.mTintMode);     // Catch: Throwable -> L32
        goto L20
    L9:
        if (this.mHasAlpha == false) goto L11;
        r10.setAlpha(this.mAlpha);     // Catch: Throwable -> L32
        goto L11
    }

    private boolean needsMirroring() {
        if (isAutoMirrored() == true) goto L5;
    L7:
        return false;
    L5:
        if (DrawableCompat.getLayoutDirection(this) != 1) goto L7;
        return true;
    }

    static int resolveDensity(@Nullable Resources r10, int r11) {
        if (r10 == null) goto L5;
        r11 = r10.getDisplayMetrics().densityDpi;
    L5:
        if (r11 != 0) goto L8;
        return 160;
    L8:
        return r11;
    }

    void animate(boolean r14) {
        boolean r10 = true;
        this.mHasAlpha = true;
        long r11 = SystemClock.uptimeMillis();
        Drawable r12 = this.mCurrDrawable;
        if (r12 == null) goto L10;
        long r13 = this.mEnterAnimationEnd;
        if (r13 != 0) goto L7;
    L11:
        boolean r15 = false;
    L12:
        Drawable r16 = this.mLastDrawable;
        if (r16 == null) goto L20;
        long r17 = this.mExitAnimationEnd;
        if (r17 != 0) goto L17;
    L21:
        r10 = r15;
    L22:
        if (r14 == false) goto L26;
        if (r10 == false) goto L27;
        scheduleSelf(this.mAnimationRunnable, r11 + 16);
        return;
    L27:
        return;
    L26:
        return;
    L17:
        if (r17 > r11) goto L19;
        r16.setVisible(false, false);
        this.mLastDrawable = null;
        goto L20
    L19:
        r16.setAlpha(((((int) ((r17 - r11) * 255)) / this.mDrawableContainerState.mExitFadeDuration) * this.mAlpha) / 255);
    L20:
        this.mExitAnimationEnd = 0;
        goto L21
    L7:
        if (r13 > r11) goto L9;
        r12.setAlpha(this.mAlpha);
        goto L10
    L9:
        r12.setAlpha(((255 - (((int) ((r13 - r11) * 255)) / this.mDrawableContainerState.mEnterFadeDuration)) * this.mAlpha) / 255);
        r15 = true;
    L10:
        this.mEnterAnimationEnd = 0;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme r10) {
        this.mDrawableContainerState.applyTheme(r10);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    void clearMutated() {
        this.mDrawableContainerState.clearMutated();
        this.mMutated = false;
    }

    DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        Drawable r11 = this.mCurrDrawable;
        if (r11 == null) goto L5;
        r11.draw(r10);
    L5:
        Drawable r12 = this.mLastDrawable;
        if (r12 == null) goto L9;
        r12.draw(r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int r10 = super.getChangingConfigurations();
        return this.mDrawableContainerState.getChangingConfigurations() | r10;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.mDrawableContainerState.canConstantState() == false) goto L6;
        DrawableContainerState r10 = this.mDrawableContainerState;
        r10.mChangingConfigurations = getChangingConfigurations();
        return this.mDrawableContainerState;
    L6:
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    int getCurrentIndex() {
        return this.mCurIndex;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect r10) {
        Rect r11 = this.mHotspotBounds;
        if (r11 == null) goto L5;
        r10.set(r11);
        return;
    L5:
        super.getHotspotBounds(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r10 = this.mCurrDrawable;
        if (r10 != null) goto L11;
        return -1;
    L11:
        return r10.getIntrinsicHeight();
    L5:
        return this.mDrawableContainerState.getConstantHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r10 = this.mCurrDrawable;
        if (r10 != null) goto L11;
        return -1;
    L11:
        return r10.getIntrinsicWidth();
    L5:
        return this.mDrawableContainerState.getConstantWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r10 = this.mCurrDrawable;
        if (r10 != null) goto L11;
        return 0;
    L11:
        return r10.getMinimumHeight();
    L5:
        return this.mDrawableContainerState.getConstantMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r10 = this.mCurrDrawable;
        if (r10 != null) goto L11;
        return 0;
    L11:
        return r10.getMinimumWidth();
    L5:
        return this.mDrawableContainerState.getConstantMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable r10 = this.mCurrDrawable;
        if (r10 != null) goto L5;
    L8:
        return -2;
    L5:
        if (r10.isVisible() == false) goto L8;
        return this.mDrawableContainerState.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void getOutline(@NonNull Outline r10) {
        Drawable r11 = this.mCurrDrawable;
        if (r11 == null) goto L6;
        Api21Impl.getOutline(r11, r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect r10) {
        Rect r11 = this.mDrawableContainerState.getConstantPadding();
        if (r11 == null) goto L8;
        r10.set(r11);
        int r12 = (r11.left | r11.top) | r11.bottom;
        if ((r11.right | r12) == 0) goto L7;
        boolean r13 = true;
    L13:
        if (needsMirroring() == false) goto L15;
        int r14 = r10.left;
        r10.left = r10.right;
        r10.right = r14;
    L15:
        return r13;
    L7:
        r13 = false;
        goto L13
    L8:
        Drawable r15 = this.mCurrDrawable;
        if (r15 == null) goto L11;
        r13 = r15.getPadding(r10);
        goto L13
    L11:
        r13 = super.getPadding(r10);
        goto L13
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable r10) {
        DrawableContainerState r11 = this.mDrawableContainerState;
        if (r11 == null) goto L6;
        r11.invalidateCache();
    L6:
        if (r10 == this.mCurrDrawable) goto L8;
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
        Drawable r10 = this.mLastDrawable;
        boolean r11 = true;
        if (r10 == null) goto L5;
        r10.jumpToCurrentState();
        this.mLastDrawable = null;
        boolean r12 = true;
    L6:
        Drawable r13 = this.mCurrDrawable;
        if (r13 == null) goto L12;
        r13.jumpToCurrentState();
        if (this.mHasAlpha == false) goto L12;
        this.mCurrDrawable.setAlpha(this.mAlpha);
    L12:
        if (this.mExitAnimationEnd == 0) goto L15;
        this.mExitAnimationEnd = 0;
        r12 = true;
    L15:
        if (this.mEnterAnimationEnd == 0) goto L17;
        this.mEnterAnimationEnd = 0;
    L18:
        if (r11 == false) goto L21;
        invalidateSelf();
        return;
    L21:
        return;
    L17:
        r11 = r12;
        goto L18
    L5:
        r12 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        DrawableContainerState r10 = cloneConstantState();
        r10.mutate();
        setConstantState(r10);
        this.mMutated = true;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r10) {
        Drawable r11 = this.mLastDrawable;
        if (r11 == null) goto L5;
        r11.setBounds(r10);
    L5:
        Drawable r12 = this.mCurrDrawable;
        if (r12 == null) goto L9;
        r12.setBounds(r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int r10) {
        return this.mDrawableContainerState.setLayoutDirection(r10, getCurrentIndex());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r10) {
        Drawable r11 = this.mLastDrawable;
        if (r11 != null) goto L5;
        Drawable r12 = this.mCurrDrawable;
        if (r12 != null) goto L9;
        return false;
    L9:
        return r12.setLevel(r10);
    L5:
        return r11.setLevel(r10);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] r10) {
        Drawable r11 = this.mLastDrawable;
        if (r11 != null) goto L5;
        Drawable r12 = this.mCurrDrawable;
        if (r12 != null) goto L9;
        return false;
    L9:
        return r12.setState(r10);
    L5:
        return r11.setState(r10);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable r10, @NonNull Runnable r11, long r12) {
        if (r10 == this.mCurrDrawable) goto L5;
        return;
    L5:
        if (getCallback() == null) goto L9;
        getCallback().scheduleDrawable(this, r11, r12);
        return;
    }

    boolean selectDrawable(int r10) {
        if (r10 != this.mCurIndex) goto L5;
        return false;
    L5:
        long r11 = SystemClock.uptimeMillis();
        if (this.mDrawableContainerState.mExitFadeDuration <= 0) goto L14;
        Drawable r12 = this.mLastDrawable;
        if (r12 == null) goto L10;
        r12.setVisible(false, false);
    L10:
        Drawable r13 = this.mCurrDrawable;
        if (r13 == null) goto L13;
        this.mLastDrawable = r13;
        this.mExitAnimationEnd = ((long) this.mDrawableContainerState.mExitFadeDuration) + r11;
    L17:
        if (r10 < 0) goto L26;
        DrawableContainerState r14 = this.mDrawableContainerState;
        if (r10 >= r14.mNumChildren) goto L26;
        Drawable r15 = r14.getChild(r10);
        this.mCurrDrawable = r15;
        this.mCurIndex = r10;
        if (r15 == null) goto L28;
        int r16 = this.mDrawableContainerState.mEnterFadeDuration;
        if (r16 <= 0) goto L25;
        this.mEnterAnimationEnd = r11 + ((long) r16);
    L25:
        initializeDrawableForDisplay(r15);
    L28:
        if (this.mEnterAnimationEnd == 0) goto L30;
    L31:
        Runnable r17 = this.mAnimationRunnable;
        if (r17 != null) goto L34;
        this.mAnimationRunnable = new AnonymousClass1(this);
    L35:
        animate(true);
    L36:
        invalidateSelf();
        return true;
    L34:
        unscheduleSelf(r17);
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
        Drawable r18 = this.mCurrDrawable;
        if (r18 == null) goto L17;
        r18.setVisible(false, false);
        goto L17
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        if (this.mHasAlpha == true) goto L5;
    L6:
        this.mHasAlpha = true;
        this.mAlpha = r10;
        Drawable r11 = this.mCurrDrawable;
        if (r11 != null) goto L9;
        return;
    L9:
        if (this.mEnterAnimationEnd != 0) goto L11;
        r11.setAlpha(r10);
        return;
    L11:
        animate(false);
        return;
    L5:
        if (this.mAlpha != r10) goto L6;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r10) {
        DrawableContainerState r11 = this.mDrawableContainerState;
        if (r11.mAutoMirrored == r10) goto L8;
        r11.mAutoMirrored = r10;
        Drawable r12 = this.mCurrDrawable;
        if (r12 == null) goto L9;
        DrawableCompat.setAutoMirrored(r12, r10);
        return;
    L9:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        DrawableContainerState r11 = this.mDrawableContainerState;
        r11.mHasColorFilter = true;
        if (r11.mColorFilter == r10) goto L8;
        r11.mColorFilter = r10;
        Drawable r12 = this.mCurrDrawable;
        if (r12 == null) goto L9;
        r12.setColorFilter(r10);
        return;
    L9:
        return;
    }

    void setConstantState(DrawableContainerState r10) {
        this.mDrawableContainerState = r10;
        int r11 = this.mCurIndex;
        if (r11 < 0) goto L7;
        Drawable r12 = r10.getChild(r11);
        this.mCurrDrawable = r12;
        if (r12 == null) goto L7;
        initializeDrawableForDisplay(r12);
    L7:
        this.mLastDrawable = null;
    }

    void setCurrentIndex(int r10) {
        selectDrawable(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r10) {
        DrawableContainerState r11 = this.mDrawableContainerState;
        if (r11.mDither == r10) goto L8;
        r11.mDither = r10;
        Drawable r12 = this.mCurrDrawable;
        if (r12 == null) goto L9;
        r12.setDither(r10);
        return;
    L9:
        return;
    }

    public void setEnterFadeDuration(int r10) {
        this.mDrawableContainerState.mEnterFadeDuration = r10;
    }

    public void setExitFadeDuration(int r10) {
        this.mDrawableContainerState.mExitFadeDuration = r10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r10, float r11) {
        Drawable r12 = this.mCurrDrawable;
        if (r12 == null) goto L6;
        DrawableCompat.setHotspot(r12, r10, r11);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r10, int r11, int r12, int r13) {
        Rect r14 = this.mHotspotBounds;
        if (r14 != null) goto L5;
        this.mHotspotBounds = new Rect(r10, r11, r12, r13);
    L6:
        Drawable r15 = this.mCurrDrawable;
        if (r15 == null) goto L10;
        DrawableCompat.setHotspotBounds(r15, r10, r11, r12, r13);
        return;
    L10:
        return;
    L5:
        r14.set(r10, r11, r12, r13);
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(@ColorInt int r10) {
        setTintList(ColorStateList.valueOf(r10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r10) {
        DrawableContainerState r11 = this.mDrawableContainerState;
        r11.mHasTintList = true;
        if (r11.mTintList == r10) goto L6;
        r11.mTintList = r10;
        DrawableCompat.setTintList(this.mCurrDrawable, r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode r10) {
        DrawableContainerState r11 = this.mDrawableContainerState;
        r11.mHasTintMode = true;
        if (r11.mTintMode == r10) goto L6;
        r11.mTintMode = r10;
        DrawableCompat.setTintMode(this.mCurrDrawable, r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r10, boolean r11) {
        boolean r12 = super.setVisible(r10, r11);
        Drawable r13 = this.mLastDrawable;
        if (r13 == null) goto L5;
        r13.setVisible(r10, r11);
    L5:
        Drawable r14 = this.mCurrDrawable;
        if (r14 == null) goto L8;
        r14.setVisible(r10, r11);
    L8:
        return r12;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable r10, @NonNull Runnable r11) {
        if (r10 == this.mCurrDrawable) goto L5;
        return;
    L5:
        if (getCallback() == null) goto L9;
        getCallback().unscheduleDrawable(this, r11);
        return;
    }

    final void updateDensity(Resources r10) {
        this.mDrawableContainerState.updateDensity(r10);
    }
}
