package androidx.core.view;

import ai.j0;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsCompat {

    @NonNull
    public static final WindowInsetsCompat CONSUMED = null;
    private static final String TAG = "WindowInsetsCompat";
    private final Impl mImpl;

    @RequiresApi(21)
    @SuppressLint({"SoonBlockedPrivateApi"})
    public static class Api21ReflectionHolder {
        private static Field sContentInsets;
        private static boolean sReflectionSucceeded;
        private static Field sStableInsets;
        private static Field sViewAttachInfoField;

        static {
            Field r5 = View.class.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L4
            sViewAttachInfoField = r5;     // Catch: ReflectiveOperationException -> L4
            r5.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Class<?> r10 = Class.forName("android.view.View$AttachInfo");     // Catch: ReflectiveOperationException -> L4
            Field r11 = r10.getDeclaredField("mStableInsets");     // Catch: ReflectiveOperationException -> L4
            sStableInsets = r11;     // Catch: ReflectiveOperationException -> L4
            r11.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Field r12 = r10.getDeclaredField("mContentInsets");     // Catch: ReflectiveOperationException -> L4
            sContentInsets = r12;     // Catch: ReflectiveOperationException -> L4
            r12.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            sReflectionSucceeded = true;     // Catch: ReflectiveOperationException -> L4
            return;
        L4:
            e = move-exception;
            Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }

        private Api21ReflectionHolder() {
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View r5) {
            if (sReflectionSucceeded == true) goto L5;
        L17:
            return null;
        L5:
            if (r5.isAttachedToWindow() == false) goto L17;
            Object r10 = sViewAttachInfoField.get(r5.getRootView());     // Catch: IllegalAccessException -> L15
            if (r10 == null) goto L17;
            Rect r11 = (Rect) sStableInsets.get(r10);     // Catch: IllegalAccessException -> L15
            Rect r12 = (Rect) sContentInsets.get(r10);     // Catch: IllegalAccessException -> L15
            if (r11 == null) goto L17;
            if (r12 == null) goto L17;
            WindowInsetsCompat r13 = new Builder().setStableInsets(Insets.of(r11)).setSystemWindowInsets(Insets.of(r12)).build();     // Catch: IllegalAccessException -> L15
            r13.setRootWindowInsets(r13);     // Catch: IllegalAccessException -> L15
            r13.copyRootViewBounds(r5.getRootView());     // Catch: IllegalAccessException -> L15
            return r13;
        L15:
            e = move-exception;
            Log.w(WindowInsetsCompat.TAG, "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            goto L17
        }
    }

    public static final class Builder {
        private final BuilderImpl mImpl;

        public Builder() {
            this.mImpl = new BuilderImpl30();
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.mImpl.build();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat r5) {
            this.mImpl.setDisplayCutout(r5);
            return this;
        }

        @NonNull
        public Builder setInsets(int r5, @NonNull Insets r10) {
            this.mImpl.setInsets(r5, r10);
            return this;
        }

        @NonNull
        public Builder setInsetsIgnoringVisibility(int r5, @NonNull Insets r10) {
            this.mImpl.setInsetsIgnoringVisibility(r5, r10);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setMandatorySystemGestureInsets(@NonNull Insets r5) {
            this.mImpl.setMandatorySystemGestureInsets(r5);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setStableInsets(@NonNull Insets r5) {
            this.mImpl.setStableInsets(r5);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemGestureInsets(@NonNull Insets r5) {
            this.mImpl.setSystemGestureInsets(r5);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemWindowInsets(@NonNull Insets r5) {
            this.mImpl.setSystemWindowInsets(r5);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTappableElementInsets(@NonNull Insets r5) {
            this.mImpl.setTappableElementInsets(r5);
            return this;
        }

        @NonNull
        public Builder setVisible(int r5, boolean r10) {
            this.mImpl.setVisible(r5, r10);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat r5) {
            this.mImpl = new BuilderImpl30(r5);
        }
    }

    public static class BuilderImpl {
        private final WindowInsetsCompat mInsets;
        Insets[] mInsetsTypeMask;

        public BuilderImpl() {
            this(new WindowInsetsCompat(null));
        }

        public final void applyInsetTypes() {
            Insets[] r5 = this.mInsetsTypeMask;
            if (r5 == null) goto L19;
            Insets r10 = r5[Type.indexOf(1)];
            Insets r11 = this.mInsetsTypeMask[Type.indexOf(2)];
            if (r11 != null) goto L7;
            r11 = this.mInsets.getInsets(2);
        L7:
            if (r10 != null) goto L9;
            r10 = this.mInsets.getInsets(1);
        L9:
            setSystemWindowInsets(Insets.max(r10, r11));
            Insets r12 = this.mInsetsTypeMask[Type.indexOf(16)];
            if (r12 == null) goto L12;
            setSystemGestureInsets(r12);
        L12:
            Insets r13 = this.mInsetsTypeMask[Type.indexOf(32)];
            if (r13 == null) goto L15;
            setMandatorySystemGestureInsets(r13);
        L15:
            Insets r14 = this.mInsetsTypeMask[Type.indexOf(64)];
            if (r14 == null) goto L20;
            setTappableElementInsets(r14);
            return;
        L20:
            return;
        }

        @NonNull
        public WindowInsetsCompat build() {
            applyInsetTypes();
            return this.mInsets;
        }

        public void setDisplayCutout(@Nullable DisplayCutoutCompat r5) {
        }

        public void setInsets(int r5, @NonNull Insets r10) {
            if (this.mInsetsTypeMask != null) goto L5;
            this.mInsetsTypeMask = new Insets[9];
        L5:
            int r11 = 1;
        L7:
            if (r11 > 256) goto L13;
            if ((r5 & r11) == 0) goto L12;
            this.mInsetsTypeMask[Type.indexOf(r11)] = r10;
        L12:
            r11 = r11 << 1;
            goto L7
        }

        public void setInsetsIgnoringVisibility(int r5, @NonNull Insets r10) {
            if (r5 == 8) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
        }

        public void setMandatorySystemGestureInsets(@NonNull Insets r5) {
        }

        public void setStableInsets(@NonNull Insets r5) {
        }

        public void setSystemGestureInsets(@NonNull Insets r5) {
        }

        public void setSystemWindowInsets(@NonNull Insets r5) {
        }

        public void setTappableElementInsets(@NonNull Insets r5) {
        }

        public void setVisible(int r5, boolean r10) {
        }

        public BuilderImpl(@NonNull WindowInsetsCompat r5) {
            this.mInsets = r5;
        }
    }

    @RequiresApi(api = 20)
    public static class BuilderImpl20 extends BuilderImpl {
        private static Constructor<WindowInsets> sConstructor = null;
        private static boolean sConstructorFetched = false;
        private static Field sConsumedField = null;
        private static boolean sConsumedFieldFetched = false;
        private WindowInsets mPlatformInsets;
        private Insets mStableInsets;

        public BuilderImpl20() {
            this.mPlatformInsets = createWindowInsetsInstance();
        }

        @Nullable
        private static WindowInsets createWindowInsetsInstance() {
            if (sConsumedFieldFetched == false) goto L33;
        L9:
            Field r5 = sConsumedField;
            if (r5 == null) goto L18;
            WindowInsets r10 = (WindowInsets) r5.get(null);     // Catch: ReflectiveOperationException -> L15
            if (r10 == null) goto L18;
            return new WindowInsets(r10);
        L15:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not get value from WindowInsets.CONSUMED field", e);
        L18:
            if (sConstructorFetched == false) goto L31;
        L24:
            Constructor<WindowInsets> r11 = sConstructor;
            if (r11 != null) goto L35;
        L30:
            return null;
        L35:
            return r11.newInstance(new Object[]{new Rect()});
        L28:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not invoke WindowInsets(Rect) constructor", e);
            goto L30
        L31:
            sConstructor = WindowInsets.class.getConstructor(new Class[]{Rect.class});     // Catch: ReflectiveOperationException -> L21
        L23:
            sConstructorFetched = true;
        L21:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets(Rect) constructor", e);
            goto L23
        L33:
            sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");     // Catch: ReflectiveOperationException -> L6
        L8:
            sConsumedFieldFetched = true;
        L6:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets.CONSUMED field", e);
            goto L8
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat r5 = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            r5.setOverriddenInsets(this.mInsetsTypeMask);
            r5.setStableInsets(this.mStableInsets);
            return r5;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(@Nullable Insets r5) {
            this.mStableInsets = r5;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(@NonNull Insets r5) {
            WindowInsets r10 = this.mPlatformInsets;
            if (r10 == null) goto L6;
            this.mPlatformInsets = r10.replaceSystemWindowInsets(r5.left, r5.top, r5.right, r5.bottom);
            return;
        }

        public BuilderImpl20(@NonNull WindowInsetsCompat r5) {
            super(r5);
            this.mPlatformInsets = r5.toWindowInsets();
        }
    }

    @RequiresApi(api = 29)
    public static class BuilderImpl29 extends BuilderImpl {
        final WindowInsets.Builder mPlatBuilder;

        public BuilderImpl29() {
            this.mPlatBuilder = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat r5 = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
            r5.setOverriddenInsets(this.mInsetsTypeMask);
            return r5;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setDisplayCutout(@Nullable DisplayCutoutCompat r5) {
            WindowInsets.Builder r10 = this.mPlatBuilder;
            if (r5 == null) goto L5;
            DisplayCutout r11 = r5.unwrap();
        L6:
            r10.setDisplayCutout(r11);
            return;
        L5:
            r11 = null;
            goto L6
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setMandatorySystemGestureInsets(@NonNull Insets r5) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(r5.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(@NonNull Insets r5) {
            this.mPlatBuilder.setStableInsets(r5.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemGestureInsets(@NonNull Insets r5) {
            this.mPlatBuilder.setSystemGestureInsets(r5.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(@NonNull Insets r5) {
            this.mPlatBuilder.setSystemWindowInsets(r5.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setTappableElementInsets(@NonNull Insets r5) {
            this.mPlatBuilder.setTappableElementInsets(r5.toPlatformInsets());
        }

        public BuilderImpl29(@NonNull WindowInsetsCompat r5) {
            super(r5);
            WindowInsets r10 = r5.toWindowInsets();
            if (r10 == null) goto L5;
            WindowInsets.Builder r11 = new WindowInsets.Builder(r10);
        L6:
            this.mPlatBuilder = r11;
            return;
        L5:
            r11 = new WindowInsets.Builder();
            goto L6
        }
    }

    @RequiresApi(30)
    public static class BuilderImpl30 extends BuilderImpl29 {
        public BuilderImpl30() {
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setInsets(int r5, @NonNull Insets r10) {
            this.mPlatBuilder.setInsets(TypeImpl30.toPlatformType(r5), r10.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setInsetsIgnoringVisibility(int r5, @NonNull Insets r10) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(TypeImpl30.toPlatformType(r5), r10.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setVisible(int r5, boolean r10) {
            this.mPlatBuilder.setVisible(TypeImpl30.toPlatformType(r5), r10);
        }

        public BuilderImpl30(@NonNull WindowInsetsCompat r5) {
            super(r5);
        }
    }

    public static class Impl {

        @NonNull
        static final WindowInsetsCompat CONSUMED = null;
        final WindowInsetsCompat mHost;

        static {
            CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        }

        public Impl(@NonNull WindowInsetsCompat r5) {
            this.mHost = r5;
        }

        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        public void copyRootViewBounds(@NonNull View r5) {
        }

        public void copyWindowDataInto(@NonNull WindowInsetsCompat r5) {
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Impl) == true) goto L8;
            return false;
        L8:
            Impl r10 = (Impl) r5;
            if (isRound() != r10.isRound()) goto L20;
            if (isConsumed() != r10.isConsumed()) goto L20;
            if (ObjectsCompat.equals(getSystemWindowInsets(), r10.getSystemWindowInsets()) == false) goto L20;
            if (ObjectsCompat.equals(getStableInsets(), r10.getStableInsets()) == false) goto L20;
            if (ObjectsCompat.equals(getDisplayCutout(), r10.getDisplayCutout()) == false) goto L20;
            return true;
        L20:
            return false;
        }

        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        @NonNull
        public Insets getInsets(int r5) {
            return Insets.NONE;
        }

        @NonNull
        public Insets getInsetsIgnoringVisibility(int r5) {
            if ((r5 & 8) != 0) goto L7;
            return Insets.NONE;
        L7:
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @NonNull
        public Insets getStableInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @NonNull
        public Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout()});
        }

        @NonNull
        public WindowInsetsCompat inset(int r5, int r10, int r11, int r12) {
            return CONSUMED;
        }

        public boolean isConsumed() {
            return false;
        }

        public boolean isRound() {
            return false;
        }

        public boolean isVisible(int r5) {
            return true;
        }

        public void setOverriddenInsets(Insets[] r5) {
        }

        public void setRootViewData(@NonNull Insets r5) {
        }

        public void setRootWindowInsets(@Nullable WindowInsetsCompat r5) {
        }

        public void setStableInsets(Insets r5) {
        }
    }

    @RequiresApi(20)
    public static class Impl20 extends Impl {
        private static Class<?> sAttachInfoClass = null;
        private static Field sAttachInfoField = null;
        private static Method sGetViewRootImplMethod = null;
        private static Field sVisibleInsetsField = null;
        private static boolean sVisibleRectReflectionFetched = false;
        private Insets[] mOverriddenInsets;

        @NonNull
        final WindowInsets mPlatformInsets;
        Insets mRootViewVisibleInsets;
        private WindowInsetsCompat mRootWindowInsets;
        private Insets mSystemWindowInsets;

        public Impl20(@NonNull WindowInsetsCompat r5, @NonNull WindowInsets r10) {
            super(r5);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = r10;
        }

        private Insets getRootStableInsets() {
            WindowInsetsCompat r5 = this.mRootWindowInsets;
            if (r5 == null) goto L7;
            return r5.getStableInsets();
        L7:
            return Insets.NONE;
        }

        @Nullable
        private Insets getVisibleInsets(@NonNull View r5) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void loadReflectionField() {
            sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", null);     // Catch: ReflectiveOperationException -> L5
            Class<?> r5 = Class.forName("android.view.View$AttachInfo");     // Catch: ReflectiveOperationException -> L5
            sAttachInfoClass = r5;     // Catch: ReflectiveOperationException -> L5
            sVisibleInsetsField = r5.getDeclaredField("mVisibleInsets");     // Catch: ReflectiveOperationException -> L5
            sAttachInfoField = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L5
            sVisibleInsetsField.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
            sAttachInfoField.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        L7:
            sVisibleRectReflectionFetched = true;
            return;
        L5:
            e = move-exception;
            Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            goto L7
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void copyRootViewBounds(@NonNull View r5) {
            Insets r10 = getVisibleInsets(r5);
            if (r10 != null) goto L5;
            r10 = Insets.NONE;
        L5:
            setRootViewData(r10);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void copyWindowDataInto(@NonNull WindowInsetsCompat r5) {
            r5.setRootWindowInsets(this.mRootWindowInsets);
            r5.setRootViewData(this.mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object r5) {
            if (super.equals(r5) == true) goto L7;
            return false;
        L7:
            return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) r5).mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsets(int r5) {
            return getInsets(r5, false);
        }

        @NonNull
        public Insets getInsetsForType(int r5, boolean r10) {
            if (r5 == 1) goto L63;
            Insets r11 = null;
            if (r5 != 2) goto L7;
            if (r10 == false) goto L55;
            Insets r12 = getRootStableInsets();
            Insets r13 = getStableInsets();
            return Insets.of(Math.max(r12.left, r13.left), 0, Math.max(r12.right, r13.right), Math.max(r12.bottom, r13.bottom));
        L55:
            Insets r14 = getSystemWindowInsets();
            WindowInsetsCompat r15 = this.mRootWindowInsets;
            if (r15 == null) goto L58;
            r11 = r15.getStableInsets();
        L58:
            int r16 = r14.bottom;
            if (r11 == null) goto L62;
            r16 = Math.min(r16, r11.bottom);
        L62:
            return Insets.of(r14.left, 0, r14.right, r16);
        L7:
            if (r5 != 8) goto L9;
            Insets[] r17 = this.mOverriddenInsets;
            if (r17 == null) goto L36;
            r11 = r17[Type.indexOf(8)];
        L36:
            if (r11 == null) goto L38;
            return r11;
        L38:
            Insets r18 = getSystemWindowInsets();
            Insets r19 = getRootStableInsets();
            int r20 = r18.bottom;
            if (r20 > r19.bottom) goto L41;
            Insets r21 = this.mRootViewVisibleInsets;
            if (r21 == null) goto L51;
            if (r21.equals(Insets.NONE) == true) goto L51;
            int r22 = this.mRootViewVisibleInsets.bottom;
            if (r22 <= r19.bottom) goto L51;
            return Insets.of(0, 0, 0, r22);
        L51:
            return Insets.NONE;
        L41:
            return Insets.of(0, 0, 0, r20);
        L9:
            if (r5 == 16) goto L32;
            if (r5 == 32) goto L30;
            if (r5 == 64) goto L28;
            if (r5 != 128) goto L17;
            WindowInsetsCompat r23 = this.mRootWindowInsets;
            if (r23 == null) goto L21;
            DisplayCutoutCompat r24 = r23.getDisplayCutout();
        L22:
            if (r24 == null) goto L26;
            return Insets.of(r24.getSafeInsetLeft(), r24.getSafeInsetTop(), r24.getSafeInsetRight(), r24.getSafeInsetBottom());
        L26:
            return Insets.NONE;
        L21:
            r24 = getDisplayCutout();
            goto L22
        L17:
            return Insets.NONE;
        L28:
            return getTappableElementInsets();
        L30:
            return getMandatorySystemGestureInsets();
        L32:
            return getSystemGestureInsets();
        L63:
            if (r10 == false) goto L67;
            return Insets.of(0, Math.max(getRootStableInsets().top, getSystemWindowInsets().top), 0, 0);
        L67:
            return Insets.of(0, getSystemWindowInsets().top, 0, 0);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsetsIgnoringVisibility(int r5) {
            return getInsets(r5, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets != null) goto L6;
            this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
        L6:
            return this.mSystemWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat inset(int r5, int r10, int r11, int r12) {
            Builder r13 = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            r13.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), r5, r10, r11, r12));
            r13.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), r5, r10, r11, r12));
            return r13.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        public boolean isTypeVisible(int r5) {
            if (r5 == 1) goto L15;
            if (r5 == 2) goto L15;
            if (r5 != 4) goto L9;
            return false;
        L9:
            if (r5 == 8) goto L15;
            if (r5 == 128) goto L15;
            return true;
        L15:
            return !getInsetsForType(r5, false).equals(Insets.NONE);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @SuppressLint({"WrongConstant"})
        public boolean isVisible(int r5) {
            int r10 = 1;
        L4:
            if (r10 > 256) goto L13;
            if ((r5 & r10) == 0) goto L12;
            if (isTypeVisible(r10) == true) goto L12;
            return false;
        L12:
            r10 = r10 << 1;
            goto L4
        L13:
            return true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setOverriddenInsets(Insets[] r5) {
            this.mOverriddenInsets = r5;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setRootViewData(@NonNull Insets r5) {
            this.mRootViewVisibleInsets = r5;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setRootWindowInsets(@Nullable WindowInsetsCompat r5) {
            this.mRootWindowInsets = r5;
        }

        @NonNull
        @SuppressLint({"WrongConstant"})
        private Insets getInsets(int r5, boolean r10) {
            Insets r11 = Insets.NONE;
            int r12 = 1;
        L4:
            if (r12 > 256) goto L10;
            if ((r5 & r12) == 0) goto L9;
            r11 = Insets.max(r11, getInsetsForType(r12, r10));
        L9:
            r12 = r12 << 1;
            goto L4
        L10:
            return r11;
        }

        public Impl20(@NonNull WindowInsetsCompat r5, @NonNull Impl20 r10) {
            this(r5, new WindowInsets(r10.mPlatformInsets));
        }
    }

    @RequiresApi(21)
    public static class Impl21 extends Impl20 {
        private Insets mStableInsets;

        public Impl21(@NonNull WindowInsetsCompat r5, @NonNull WindowInsets r10) {
            super(r5, r10);
            this.mStableInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public final Insets getStableInsets() {
            if (this.mStableInsets != null) goto L6;
            this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
        L6:
            return this.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(@Nullable Insets r5) {
            this.mStableInsets = r5;
        }

        public Impl21(@NonNull WindowInsetsCompat r5, @NonNull Impl21 r10) {
            super(r5, r10);
            this.mStableInsets = null;
            this.mStableInsets = r10.mStableInsets;
        }
    }

    @RequiresApi(28)
    public static class Impl28 extends Impl21 {
        public Impl28(@NonNull WindowInsetsCompat r5, @NonNull WindowInsets r10) {
            super(r5, r10);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Impl28) == true) goto L8;
            return false;
        L8:
            Impl28 r10 = (Impl28) r5;
            if (Objects.equals(this.mPlatformInsets, r10.mPlatformInsets) == false) goto L14;
            if (Objects.equals(this.mRootViewVisibleInsets, r10.mRootViewVisibleInsets) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }

        public Impl28(@NonNull WindowInsetsCompat r5, @NonNull Impl28 r10) {
            super(r5, r10);
        }
    }

    @RequiresApi(29)
    public static class Impl29 extends Impl28 {
        private Insets mMandatorySystemGestureInsets;
        private Insets mSystemGestureInsets;
        private Insets mTappableElementInsets;

        public Impl29(@NonNull WindowInsetsCompat r5, @NonNull WindowInsets r10) {
            super(r5, r10);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            if (this.mMandatorySystemGestureInsets != null) goto L6;
            this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
        L6:
            return this.mMandatorySystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getSystemGestureInsets() {
            if (this.mSystemGestureInsets != null) goto L6;
            this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
        L6:
            return this.mSystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getTappableElementInsets() {
            if (this.mTappableElementInsets != null) goto L6;
            this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
        L6:
            return this.mTappableElementInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat inset(int r5, int r10, int r11, int r12) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(r5, r10, r11, r12));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(@Nullable Insets r5) {
        }

        public Impl29(@NonNull WindowInsetsCompat r5, @NonNull Impl29 r10) {
            super(r5, r10);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }
    }

    @RequiresApi(30)
    public static class Impl30 extends Impl29 {

        @NonNull
        static final WindowInsetsCompat CONSUMED = null;

        static {
            CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);
        }

        public Impl30(@NonNull WindowInsetsCompat r5, @NonNull WindowInsets r10) {
            super(r5, r10);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public final void copyRootViewBounds(@NonNull View r5) {
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsets(int r5) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsets(TypeImpl30.toPlatformType(r5)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsetsIgnoringVisibility(int r5) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.toPlatformType(r5)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean isVisible(int r5) {
            return this.mPlatformInsets.isVisible(TypeImpl30.toPlatformType(r5));
        }

        public Impl30(@NonNull WindowInsetsCompat r5, @NonNull Impl30 r10) {
            super(r5, r10);
        }
    }

    public static final class Type {
        static final int CAPTION_BAR = 4;
        static final int DISPLAY_CUTOUT = 128;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 256;
        static final int MANDATORY_SYSTEM_GESTURES = 32;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 9;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int TAPPABLE_ELEMENT = 64;
        static final int WINDOW_DECOR = 256;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface InsetsType {
        }

        private Type() {
        }

        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static int all() {
            return -1;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        public static int indexOf(int r5) {
            if (r5 != 1) goto L5;
            return 0;
        L5:
            if (r5 != 2) goto L7;
            return 1;
        L7:
            if (r5 != 4) goto L9;
            return 2;
        L9:
            if (r5 != 8) goto L11;
            return 3;
        L11:
            if (r5 != 16) goto L13;
            return 4;
        L13:
            if (r5 != 32) goto L15;
            return 5;
        L15:
            if (r5 != 64) goto L17;
            return 6;
        L17:
            if (r5 != 128) goto L19;
            return 7;
        L19:
            if (r5 != 256) goto L22;
            return 8;
        L22:
            throw new IllegalArgumentException(j0.g(r5, "type needs to be >= FIRST and <= LAST, type="));
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    @RequiresApi(30)
    public static final class TypeImpl30 {
        private TypeImpl30() {
        }

        public static int toPlatformType(int r5) {
            int r10 = 0;
            int r11 = 1;
        L4:
            if (r11 > 256) goto L33;
            if ((r5 & r11) == 0) goto L32;
            if (r11 != 1) goto L9;
            int r12 = WindowInsets.Type.statusBars();
        L24:
            r10 = r10 | r12;
            goto L32
        L9:
            if (r11 != 2) goto L11;
            r12 = WindowInsets.Type.navigationBars();
            goto L24
        L11:
            if (r11 != 4) goto L13;
            r12 = WindowInsets.Type.captionBar();
            goto L24
        L13:
            if (r11 != 8) goto L15;
            r12 = WindowInsets.Type.ime();
            goto L24
        L15:
            if (r11 != 16) goto L17;
            r12 = WindowInsets.Type.systemGestures();
            goto L24
        L17:
            if (r11 != 32) goto L19;
            r12 = WindowInsets.Type.mandatorySystemGestures();
            goto L24
        L19:
            if (r11 != 64) goto L21;
            r12 = WindowInsets.Type.tappableElement();
            goto L24
        L21:
            if (r11 != 128) goto L32;
            r12 = WindowInsets.Type.displayCutout();
        L32:
            r11 = r11 << 1;
            goto L4
        L33:
            return r10;
        }
    }

    static {
        CONSUMED = Impl30.CONSUMED;
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets r5) {
        this.mImpl = new Impl30(this, r5);
    }

    public static Insets insetInsets(@NonNull Insets r5, int r10, int r11, int r12, int r13) {
        int r14 = Math.max(0, r5.left - r10);
        int r15 = Math.max(0, r5.top - r11);
        int r16 = Math.max(0, r5.right - r12);
        int r17 = Math.max(0, r5.bottom - r13);
        if (r14 != r10) goto L9;
        if (r15 != r11) goto L9;
        if (r16 != r12) goto L9;
        if (r17 != r13) goto L9;
        return r5;
    L9:
        return Insets.of(r14, r15, r16, r17);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets r5) {
        return toWindowInsetsCompat(r5, null);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    public void copyRootViewBounds(@NonNull View r5) {
        this.mImpl.copyRootViewBounds(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WindowInsetsCompat) == true) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) r5).mImpl);
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    @NonNull
    public Insets getInsets(int r5) {
        return this.mImpl.getInsets(r5);
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int r5) {
        return this.mImpl.getInsetsIgnoringVisibility(r5);
    }

    @NonNull
    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    @NonNull
    @Deprecated
    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @NonNull
    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    @NonNull
    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @NonNull
    @Deprecated
    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasInsets() {
        Insets r5 = getInsets(Type.all());
        Insets r10 = Insets.NONE;
        if (r5.equals(r10) == true) goto L5;
    L10:
        return true;
    L5:
        if (getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(r10) == false) goto L10;
        if (getDisplayCutout() != null) goto L10;
        return false;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.getStableInsets().equals(Insets.NONE);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.getSystemWindowInsets().equals(Insets.NONE);
    }

    public int hashCode() {
        Impl r5 = this.mImpl;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets r5) {
        return inset(r5.left, r5.top, r5.right, r5.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public boolean isVisible(int r5) {
        return this.mImpl.isVisible(r5);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int r5, int r10, int r11, int r12) {
        return new Builder(this).setSystemWindowInsets(Insets.of(r5, r10, r11, r12)).build();
    }

    public void setOverriddenInsets(Insets[] r5) {
        this.mImpl.setOverriddenInsets(r5);
    }

    public void setRootViewData(@NonNull Insets r5) {
        this.mImpl.setRootViewData(r5);
    }

    public void setRootWindowInsets(@Nullable WindowInsetsCompat r5) {
        this.mImpl.setRootWindowInsets(r5);
    }

    public void setStableInsets(@Nullable Insets r5) {
        this.mImpl.setStableInsets(r5);
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets toWindowInsets() {
        Impl r5 = this.mImpl;
        if ((r5 instanceof Impl20) == true) goto L7;
        return null;
    L7:
        return ((Impl20) r5).mPlatformInsets;
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets r5, @Nullable View r10) {
        WindowInsetsCompat r11 = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(r5));
        if (r10 != null) goto L5;
    L7:
        return r11;
    L5:
        if (r10.isAttachedToWindow() == false) goto L7;
        r11.setRootWindowInsets(ViewCompat.getRootWindowInsets(r10));
        r11.copyRootViewBounds(r10.getRootView());
        goto L7
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int r5, @IntRange(from = 0) int r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12) {
        return this.mImpl.inset(r5, r10, r11, r12);
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat r5) {
        if (r5 == null) goto L21;
        Impl r10 = r5.mImpl;
        if ((r10 instanceof Impl30) == false) goto L8;
        this.mImpl = new Impl30(this, (Impl30) r10);
    L20:
        r10.copyWindowDataInto(this);
        return;
    L8:
        if ((r10 instanceof Impl29) == false) goto L11;
        this.mImpl = new Impl29(this, (Impl29) r10);
        goto L20
    L11:
        if ((r10 instanceof Impl28) == false) goto L14;
        this.mImpl = new Impl28(this, (Impl28) r10);
        goto L20
    L14:
        if ((r10 instanceof Impl21) == false) goto L17;
        this.mImpl = new Impl21(this, (Impl21) r10);
        goto L20
    L17:
        if ((r10 instanceof Impl20) == false) goto L19;
        this.mImpl = new Impl20(this, (Impl20) r10);
        goto L20
    L19:
        this.mImpl = new Impl(this);
        goto L20
    L21:
        this.mImpl = new Impl(this);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect r5) {
        return new Builder(this).setSystemWindowInsets(Insets.of(r5)).build();
    }
}
