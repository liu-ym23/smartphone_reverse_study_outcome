package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
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
    static class Api21ReflectionHolder {
        private static Field sContentInsets;
        private static boolean sReflectionSucceeded;
        private static Field sStableInsets;
        private static Field sViewAttachInfoField;

        static {
            Field r10 = View.class.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L4
            sViewAttachInfoField = r10;     // Catch: ReflectiveOperationException -> L4
            r10.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Class<?> r11 = Class.forName("android.view.View$AttachInfo");     // Catch: ReflectiveOperationException -> L4
            Field r12 = r11.getDeclaredField("mStableInsets");     // Catch: ReflectiveOperationException -> L4
            sStableInsets = r12;     // Catch: ReflectiveOperationException -> L4
            r12.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Field r13 = r11.getDeclaredField("mContentInsets");     // Catch: ReflectiveOperationException -> L4
            sContentInsets = r13;     // Catch: ReflectiveOperationException -> L4
            r13.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            sReflectionSucceeded = true;     // Catch: ReflectiveOperationException -> L4
            return;
        L4:
            e = move-exception;
            Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }

        private Api21ReflectionHolder() {
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View r10) {
            if (sReflectionSucceeded == true) goto L5;
        L17:
            return null;
        L5:
            if (r10.isAttachedToWindow() == false) goto L17;
            Object r11 = sViewAttachInfoField.get(r10.getRootView());     // Catch: IllegalAccessException -> L15
            if (r11 == null) goto L17;
            Rect r12 = (Rect) sStableInsets.get(r11);     // Catch: IllegalAccessException -> L15
            Rect r13 = (Rect) sContentInsets.get(r11);     // Catch: IllegalAccessException -> L15
            if (r12 == null) goto L17;
            if (r13 == null) goto L17;
            WindowInsetsCompat r14 = new Builder().setStableInsets(Insets.of(r12)).setSystemWindowInsets(Insets.of(r13)).build();     // Catch: IllegalAccessException -> L15
            r14.setRootWindowInsets(r14);     // Catch: IllegalAccessException -> L15
            r14.copyRootViewBounds(r10.getRootView());     // Catch: IllegalAccessException -> L15
            return r14;
        L15:
            e = move-exception;
            Log.w(WindowInsetsCompat.TAG, "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            goto L17
        }
    }

    public static final class Builder {
        private final BuilderImpl mImpl;

        public Builder() {
            int r10 = Build.VERSION.SDK_INT;
            if (r10 < 30) goto L7;
            BuilderImpl r11 = new BuilderImpl30();
        L5:
            this.mImpl = r11;
            return;
        L7:
            if (r10 < 29) goto L10;
            r11 = new BuilderImpl29();
            goto L5
        L10:
            if (r10 < 20) goto L12;
            r11 = new BuilderImpl20();
            goto L5
        L12:
            r11 = new BuilderImpl();
            goto L5
        }

        public Builder(@NonNull WindowInsetsCompat r10) {
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 30) goto L7;
            BuilderImpl r12 = new BuilderImpl30(r10);
        L5:
            this.mImpl = r12;
            return;
        L7:
            if (r11 < 29) goto L10;
            r12 = new BuilderImpl29(r10);
            goto L5
        L10:
            if (r11 < 20) goto L12;
            r12 = new BuilderImpl20(r10);
            goto L5
        L12:
            r12 = new BuilderImpl(r10);
            goto L5
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.mImpl.build();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat r10) {
            this.mImpl.setDisplayCutout(r10);
            return this;
        }

        @NonNull
        public Builder setInsets(int r10, @NonNull Insets r11) {
            this.mImpl.setInsets(r10, r11);
            return this;
        }

        @NonNull
        public Builder setInsetsIgnoringVisibility(int r10, @NonNull Insets r11) {
            this.mImpl.setInsetsIgnoringVisibility(r10, r11);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setMandatorySystemGestureInsets(@NonNull Insets r10) {
            this.mImpl.setMandatorySystemGestureInsets(r10);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setStableInsets(@NonNull Insets r10) {
            this.mImpl.setStableInsets(r10);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemGestureInsets(@NonNull Insets r10) {
            this.mImpl.setSystemGestureInsets(r10);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemWindowInsets(@NonNull Insets r10) {
            this.mImpl.setSystemWindowInsets(r10);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTappableElementInsets(@NonNull Insets r10) {
            this.mImpl.setTappableElementInsets(r10);
            return this;
        }

        @NonNull
        public Builder setVisible(int r10, boolean r11) {
            this.mImpl.setVisible(r10, r11);
            return this;
        }
    }

    private static class BuilderImpl {
        private final WindowInsetsCompat mInsets;
        Insets[] mInsetsTypeMask;

        BuilderImpl() {
            this(new WindowInsetsCompat(null));
        }

        BuilderImpl(@NonNull WindowInsetsCompat r10) {
            this.mInsets = r10;
        }

        protected final void applyInsetTypes() {
            Insets[] r10 = this.mInsetsTypeMask;
            if (r10 == null) goto L19;
            Insets r11 = r10[Type.indexOf(1)];
            Insets r12 = this.mInsetsTypeMask[Type.indexOf(2)];
            if (r12 != null) goto L7;
            r12 = this.mInsets.getInsets(2);
        L7:
            if (r11 != null) goto L9;
            r11 = this.mInsets.getInsets(1);
        L9:
            setSystemWindowInsets(Insets.max(r11, r12));
            Insets r13 = this.mInsetsTypeMask[Type.indexOf(16)];
            if (r13 == null) goto L12;
            setSystemGestureInsets(r13);
        L12:
            Insets r14 = this.mInsetsTypeMask[Type.indexOf(32)];
            if (r14 == null) goto L15;
            setMandatorySystemGestureInsets(r14);
        L15:
            Insets r15 = this.mInsetsTypeMask[Type.indexOf(64)];
            if (r15 == null) goto L20;
            setTappableElementInsets(r15);
            return;
        L20:
            return;
        }

        @NonNull
        WindowInsetsCompat build() {
            applyInsetTypes();
            return this.mInsets;
        }

        void setDisplayCutout(@Nullable DisplayCutoutCompat r10) {
        }

        void setInsets(int r10, @NonNull Insets r11) {
            if (this.mInsetsTypeMask != null) goto L5;
            this.mInsetsTypeMask = new Insets[9];
        L5:
            int r12 = 1;
        L7:
            if (r12 > 256) goto L13;
            if ((r10 & r12) == 0) goto L12;
            this.mInsetsTypeMask[Type.indexOf(r12)] = r11;
        L12:
            r12 = r12 << 1;
            goto L7
        }

        void setInsetsIgnoringVisibility(int r10, @NonNull Insets r11) {
            if (r10 == 8) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
        }

        void setMandatorySystemGestureInsets(@NonNull Insets r10) {
        }

        void setStableInsets(@NonNull Insets r10) {
        }

        void setSystemGestureInsets(@NonNull Insets r10) {
        }

        void setSystemWindowInsets(@NonNull Insets r10) {
        }

        void setTappableElementInsets(@NonNull Insets r10) {
        }

        void setVisible(int r10, boolean r11) {
        }
    }

    @RequiresApi(api = 20)
    private static class BuilderImpl20 extends BuilderImpl {
        private static Constructor<WindowInsets> sConstructor = null;
        private static boolean sConstructorFetched = false;
        private static Field sConsumedField = null;
        private static boolean sConsumedFieldFetched = false;
        private WindowInsets mPlatformInsets;
        private Insets mStableInsets;

        static {
        }

        BuilderImpl20() {
            this.mPlatformInsets = createWindowInsetsInstance();
        }

        BuilderImpl20(@NonNull WindowInsetsCompat r10) {
            super(r10);
            this.mPlatformInsets = r10.toWindowInsets();
        }

        @Nullable
        private static WindowInsets createWindowInsetsInstance() {
            if (sConsumedFieldFetched == false) goto L33;
        L9:
            Field r10 = sConsumedField;
            if (r10 == null) goto L18;
            WindowInsets r11 = (WindowInsets) r10.get(null);     // Catch: ReflectiveOperationException -> L15
            if (r11 == null) goto L18;
            return new WindowInsets(r11);
        L15:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not get value from WindowInsets.CONSUMED field", e);
        L18:
            if (sConstructorFetched == false) goto L37;
        L24:
            Constructor<WindowInsets> r12 = sConstructor;
            if (r12 != null) goto L31;
        L30:
            return null;
        L31:
            return r12.newInstance(new Object[]{new Rect()});
        L28:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not invoke WindowInsets(Rect) constructor", e);
            goto L30
        L37:
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
        WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat r10 = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            r10.setOverriddenInsets(this.mInsetsTypeMask);
            r10.setStableInsets(this.mStableInsets);
            return r10;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setStableInsets(@Nullable Insets r10) {
            this.mStableInsets = r10;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setSystemWindowInsets(@NonNull Insets r10) {
            WindowInsets r11 = this.mPlatformInsets;
            if (r11 == null) goto L6;
            this.mPlatformInsets = r11.replaceSystemWindowInsets(r10.left, r10.top, r10.right, r10.bottom);
            return;
        }
    }

    @RequiresApi(api = 29)
    private static class BuilderImpl29 extends BuilderImpl {
        final WindowInsets.Builder mPlatBuilder;

        BuilderImpl29() {
            this.mPlatBuilder = new WindowInsets.Builder();
        }

        BuilderImpl29(@NonNull WindowInsetsCompat r10) {
            super(r10);
            WindowInsets r11 = r10.toWindowInsets();
            if (r11 == null) goto L5;
            WindowInsets.Builder r12 = new WindowInsets.Builder(r11);
        L6:
            this.mPlatBuilder = r12;
            return;
        L5:
            r12 = new WindowInsets.Builder();
            goto L6
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat r10 = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
            r10.setOverriddenInsets(this.mInsetsTypeMask);
            return r10;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setDisplayCutout(@Nullable DisplayCutoutCompat r10) {
            WindowInsets.Builder r11 = this.mPlatBuilder;
            if (r10 == null) goto L5;
            DisplayCutout r12 = r10.unwrap();
        L6:
            r11.setDisplayCutout(r12);
            return;
        L5:
            r12 = null;
            goto L6
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setMandatorySystemGestureInsets(@NonNull Insets r10) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(r10.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setStableInsets(@NonNull Insets r10) {
            this.mPlatBuilder.setStableInsets(r10.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setSystemGestureInsets(@NonNull Insets r10) {
            this.mPlatBuilder.setSystemGestureInsets(r10.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setSystemWindowInsets(@NonNull Insets r10) {
            this.mPlatBuilder.setSystemWindowInsets(r10.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setTappableElementInsets(@NonNull Insets r10) {
            this.mPlatBuilder.setTappableElementInsets(r10.toPlatformInsets());
        }
    }

    @RequiresApi(30)
    private static class BuilderImpl30 extends BuilderImpl29 {
        BuilderImpl30() {
        }

        BuilderImpl30(@NonNull WindowInsetsCompat r10) {
            super(r10);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setInsets(int r10, @NonNull Insets r11) {
            this.mPlatBuilder.setInsets(TypeImpl30.toPlatformType(r10), r11.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setInsetsIgnoringVisibility(int r10, @NonNull Insets r11) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(TypeImpl30.toPlatformType(r10), r11.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setVisible(int r10, boolean r11) {
            this.mPlatBuilder.setVisible(TypeImpl30.toPlatformType(r10), r11);
        }
    }

    private static class Impl {

        @NonNull
        static final WindowInsetsCompat CONSUMED = null;
        final WindowInsetsCompat mHost;

        static {
            CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        }

        Impl(@NonNull WindowInsetsCompat r10) {
            this.mHost = r10;
        }

        @NonNull
        WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        @NonNull
        WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        @NonNull
        WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        void copyRootViewBounds(@NonNull View r10) {
        }

        void copyWindowDataInto(@NonNull WindowInsetsCompat r10) {
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Impl) == true) goto L8;
            return false;
        L8:
            Impl r11 = (Impl) r10;
            if (isRound() != r11.isRound()) goto L20;
            if (isConsumed() != r11.isConsumed()) goto L20;
            if (ObjectsCompat.equals(getSystemWindowInsets(), r11.getSystemWindowInsets()) == false) goto L20;
            if (ObjectsCompat.equals(getStableInsets(), r11.getStableInsets()) == false) goto L20;
            if (ObjectsCompat.equals(getDisplayCutout(), r11.getDisplayCutout()) == false) goto L20;
            return true;
        L20:
            return false;
        }

        @Nullable
        DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        @NonNull
        Insets getInsets(int r10) {
            return Insets.NONE;
        }

        @NonNull
        Insets getInsetsIgnoringVisibility(int r10) {
            if ((r10 & 8) != 0) goto L7;
            return Insets.NONE;
        L7:
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        @NonNull
        Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @NonNull
        Insets getStableInsets() {
            return Insets.NONE;
        }

        @NonNull
        Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @NonNull
        Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        @NonNull
        Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout()});
        }

        @NonNull
        WindowInsetsCompat inset(int r10, int r11, int r12, int r13) {
            return CONSUMED;
        }

        boolean isConsumed() {
            return false;
        }

        boolean isRound() {
            return false;
        }

        boolean isVisible(int r10) {
            return true;
        }

        public void setOverriddenInsets(Insets[] r10) {
        }

        void setRootViewData(@NonNull Insets r10) {
        }

        void setRootWindowInsets(@Nullable WindowInsetsCompat r10) {
        }

        public void setStableInsets(Insets r10) {
        }
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {
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

        static {
        }

        Impl20(@NonNull WindowInsetsCompat r10, @NonNull WindowInsets r11) {
            super(r10);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = r11;
        }

        Impl20(@NonNull WindowInsetsCompat r10, @NonNull Impl20 r11) {
            this(r10, new WindowInsets(r11.mPlatformInsets));
        }

        @NonNull
        @SuppressLint({"WrongConstant"})
        private Insets getInsets(int r10, boolean r11) {
            Insets r12 = Insets.NONE;
            int r13 = 1;
        L4:
            if (r13 > 256) goto L10;
            if ((r10 & r13) == 0) goto L9;
            r12 = Insets.max(r12, getInsetsForType(r13, r11));
        L9:
            r13 = r13 << 1;
            goto L4
        L10:
            return r12;
        }

        private Insets getRootStableInsets() {
            WindowInsetsCompat r10 = this.mRootWindowInsets;
            if (r10 == null) goto L7;
            return r10.getStableInsets();
        L7:
            return Insets.NONE;
        }

        @Nullable
        private Insets getVisibleInsets(@NonNull View r10) {
            if (Build.VERSION.SDK_INT >= 30) goto L27;
            if (sVisibleRectReflectionFetched == true) goto L7;
            loadReflectionField();
        L7:
            Method r11 = sGetViewRootImplMethod;
            if (r11 != null) goto L10;
        L25:
            return null;
        L10:
            if (sAttachInfoClass == null) goto L25;
            if (sVisibleInsetsField == null) goto L25;
            Object r12 = r11.invoke(r10, new Object[0]);     // Catch: ReflectiveOperationException -> L23
            if (r12 != null) goto L19;
            Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());     // Catch: ReflectiveOperationException -> L23
            return null;
        L19:
            Rect r13 = (Rect) sVisibleInsetsField.get(sAttachInfoField.get(r12));     // Catch: ReflectiveOperationException -> L23
            if (r13 != null) goto L22;
            return null;
        L22:
            return Insets.of(r13);
        L23:
            e = move-exception;
            Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            goto L25
        L27:
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void loadReflectionField() {
            sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: ReflectiveOperationException -> L5
            Class<?> r10 = Class.forName("android.view.View$AttachInfo");     // Catch: ReflectiveOperationException -> L5
            sAttachInfoClass = r10;     // Catch: ReflectiveOperationException -> L5
            sVisibleInsetsField = r10.getDeclaredField("mVisibleInsets");     // Catch: ReflectiveOperationException -> L5
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
        void copyRootViewBounds(@NonNull View r10) {
            Insets r11 = getVisibleInsets(r10);
            if (r11 != null) goto L5;
            r11 = Insets.NONE;
        L5:
            setRootViewData(r11);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void copyWindowDataInto(@NonNull WindowInsetsCompat r10) {
            r10.setRootWindowInsets(this.mRootWindowInsets);
            r10.setRootViewData(this.mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object r10) {
            if (super.equals(r10) == true) goto L7;
            return false;
        L7:
            return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) r10).mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsets(int r10) {
            return getInsets(r10, false);
        }

        @NonNull
        protected Insets getInsetsForType(int r10, boolean r11) {
            if (r10 == 1) goto L63;
            Insets r12 = null;
            if (r10 != 2) goto L7;
            if (r11 == false) goto L55;
            Insets r13 = getRootStableInsets();
            Insets r14 = getStableInsets();
            return Insets.of(Math.max(r13.left, r14.left), 0, Math.max(r13.right, r14.right), Math.max(r13.bottom, r14.bottom));
        L55:
            Insets r15 = getSystemWindowInsets();
            WindowInsetsCompat r16 = this.mRootWindowInsets;
            if (r16 == null) goto L58;
            r12 = r16.getStableInsets();
        L58:
            int r17 = r15.bottom;
            if (r12 == null) goto L62;
            r17 = Math.min(r17, r12.bottom);
        L62:
            return Insets.of(r15.left, 0, r15.right, r17);
        L7:
            if (r10 != 8) goto L9;
            Insets[] r18 = this.mOverriddenInsets;
            if (r18 == null) goto L36;
            r12 = r18[Type.indexOf(8)];
        L36:
            if (r12 == null) goto L38;
            return r12;
        L38:
            Insets r19 = getSystemWindowInsets();
            Insets r20 = getRootStableInsets();
            int r21 = r19.bottom;
            if (r21 > r20.bottom) goto L41;
            Insets r22 = this.mRootViewVisibleInsets;
            if (r22 == null) goto L51;
            if (r22.equals(Insets.NONE) == true) goto L51;
            int r23 = this.mRootViewVisibleInsets.bottom;
            if (r23 <= r20.bottom) goto L51;
            return Insets.of(0, 0, 0, r23);
        L51:
            return Insets.NONE;
        L41:
            return Insets.of(0, 0, 0, r21);
        L9:
            if (r10 == 16) goto L32;
            if (r10 == 32) goto L30;
            if (r10 == 64) goto L28;
            if (r10 != 128) goto L17;
            WindowInsetsCompat r24 = this.mRootWindowInsets;
            if (r24 == null) goto L21;
            DisplayCutoutCompat r25 = r24.getDisplayCutout();
        L22:
            if (r25 == null) goto L26;
            return Insets.of(r25.getSafeInsetLeft(), r25.getSafeInsetTop(), r25.getSafeInsetRight(), r25.getSafeInsetBottom());
        L26:
            return Insets.NONE;
        L21:
            r25 = getDisplayCutout();
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
            if (r11 == false) goto L67;
            return Insets.of(0, Math.max(getRootStableInsets().top, getSystemWindowInsets().top), 0, 0);
        L67:
            return Insets.of(0, getSystemWindowInsets().top, 0, 0);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsetsIgnoringVisibility(int r10) {
            return getInsets(r10, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets != null) goto L6;
            this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
        L6:
            return this.mSystemWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat inset(int r10, int r11, int r12, int r13) {
            Builder r14 = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            r14.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), r10, r11, r12, r13));
            r14.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), r10, r11, r12, r13));
            return r14.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        protected boolean isTypeVisible(int r10) {
            if (r10 == 1) goto L15;
            if (r10 == 2) goto L15;
            if (r10 != 4) goto L9;
            return false;
        L9:
            if (r10 == 8) goto L15;
            if (r10 == 128) goto L15;
            return true;
        L15:
            return !getInsetsForType(r10, false).equals(Insets.NONE);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @SuppressLint({"WrongConstant"})
        boolean isVisible(int r10) {
            int r11 = 1;
        L4:
            if (r11 > 256) goto L13;
            if ((r10 & r11) == 0) goto L12;
            if (isTypeVisible(r11) == true) goto L12;
            return false;
        L12:
            r11 = r11 << 1;
            goto L4
        L13:
            return true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setOverriddenInsets(Insets[] r10) {
            this.mOverriddenInsets = r10;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void setRootViewData(@NonNull Insets r10) {
            this.mRootViewVisibleInsets = r10;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void setRootWindowInsets(@Nullable WindowInsetsCompat r10) {
            this.mRootWindowInsets = r10;
        }
    }

    @RequiresApi(21)
    private static class Impl21 extends Impl20 {
        private Insets mStableInsets;

        Impl21(@NonNull WindowInsetsCompat r10, @NonNull WindowInsets r11) {
            super(r10, r11);
            this.mStableInsets = null;
        }

        Impl21(@NonNull WindowInsetsCompat r10, @NonNull Impl21 r11) {
            super(r10, r11);
            this.mStableInsets = null;
            this.mStableInsets = r11.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        final Insets getStableInsets() {
            if (this.mStableInsets != null) goto L6;
            this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
        L6:
            return this.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(@Nullable Insets r10) {
            this.mStableInsets = r10;
        }
    }

    @RequiresApi(28)
    private static class Impl28 extends Impl21 {
        Impl28(@NonNull WindowInsetsCompat r10, @NonNull WindowInsets r11) {
            super(r10, r11);
        }

        Impl28(@NonNull WindowInsetsCompat r10, @NonNull Impl28 r11) {
            super(r10, r11);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Impl28) == true) goto L8;
            return false;
        L8:
            Impl28 r11 = (Impl28) r10;
            if (Objects.equals(this.mPlatformInsets, r11.mPlatformInsets) == false) goto L14;
            if (Objects.equals(this.mRootViewVisibleInsets, r11.mRootViewVisibleInsets) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @Nullable
        DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }
    }

    @RequiresApi(29)
    private static class Impl29 extends Impl28 {
        private Insets mMandatorySystemGestureInsets;
        private Insets mSystemGestureInsets;
        private Insets mTappableElementInsets;

        Impl29(@NonNull WindowInsetsCompat r10, @NonNull WindowInsets r11) {
            super(r10, r11);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        Impl29(@NonNull WindowInsetsCompat r10, @NonNull Impl29 r11) {
            super(r10, r11);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        Insets getMandatorySystemGestureInsets() {
            if (this.mMandatorySystemGestureInsets != null) goto L6;
            this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
        L6:
            return this.mMandatorySystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        Insets getSystemGestureInsets() {
            if (this.mSystemGestureInsets != null) goto L6;
            this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
        L6:
            return this.mSystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        Insets getTappableElementInsets() {
            if (this.mTappableElementInsets != null) goto L6;
            this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
        L6:
            return this.mTappableElementInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat inset(int r10, int r11, int r12, int r13) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(r10, r11, r12, r13));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(@Nullable Insets r10) {
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl29 {

        @NonNull
        static final WindowInsetsCompat CONSUMED = null;

        static {
            CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);
        }

        Impl30(@NonNull WindowInsetsCompat r10, @NonNull WindowInsets r11) {
            super(r10, r11);
        }

        Impl30(@NonNull WindowInsetsCompat r10, @NonNull Impl30 r11) {
            super(r10, r11);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        final void copyRootViewBounds(@NonNull View r10) {
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsets(int r10) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsets(TypeImpl30.toPlatformType(r10)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsetsIgnoringVisibility(int r10) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.toPlatformType(r10)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean isVisible(int r10) {
            return this.mPlatformInsets.isVisible(TypeImpl30.toPlatformType(r10));
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
        static int all() {
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

        static int indexOf(int r10) {
            if (r10 != 1) goto L5;
            return 0;
        L5:
            if (r10 != 2) goto L7;
            return 1;
        L7:
            if (r10 != 4) goto L9;
            return 2;
        L9:
            if (r10 != 8) goto L11;
            return 3;
        L11:
            if (r10 != 16) goto L13;
            return 4;
        L13:
            if (r10 != 32) goto L15;
            return 5;
        L15:
            if (r10 != 64) goto L17;
            return 6;
        L17:
            if (r10 != 128) goto L19;
            return 7;
        L19:
            if (r10 != 256) goto L22;
            return 8;
        L22:
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + r10);
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
    private static final class TypeImpl30 {
        private TypeImpl30() {
        }

        static int toPlatformType(int r10) {
            int r11 = 0;
            int r12 = 1;
        L4:
            if (r12 > 256) goto L33;
            if ((r10 & r12) == 0) goto L32;
            if (r12 != 1) goto L9;
            int r13 = WindowInsets.Type.statusBars();
        L31:
            r11 = r11 | r13;
            goto L32
        L9:
            if (r12 != 2) goto L11;
            r13 = WindowInsets.Type.navigationBars();
            goto L31
        L11:
            if (r12 != 4) goto L13;
            r13 = WindowInsets.Type.captionBar();
            goto L31
        L13:
            if (r12 != 8) goto L15;
            r13 = WindowInsets.Type.ime();
            goto L31
        L15:
            if (r12 != 16) goto L17;
            r13 = WindowInsets.Type.systemGestures();
            goto L31
        L17:
            if (r12 != 32) goto L19;
            r13 = WindowInsets.Type.mandatorySystemGestures();
            goto L31
        L19:
            if (r12 != 64) goto L21;
            r13 = WindowInsets.Type.tappableElement();
            goto L31
        L21:
            if (r12 != 128) goto L32;
            r13 = WindowInsets.Type.displayCutout();
        L32:
            r12 = r12 << 1;
            goto L4
        L33:
            return r11;
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        WindowInsetsCompat r10 = Impl30.CONSUMED;
    L6:
        CONSUMED = r10;
        return;
    L5:
        r10 = Impl.CONSUMED;
        goto L6
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 30) goto L7;
        Impl r12 = new Impl30(this, r10);
    L5:
        this.mImpl = r12;
        return;
    L7:
        if (r11 < 29) goto L10;
        r12 = new Impl29(this, r10);
        goto L5
    L10:
        if (r11 < 28) goto L13;
        r12 = new Impl28(this, r10);
        goto L5
    L13:
        if (r11 < 21) goto L16;
        r12 = new Impl21(this, r10);
        goto L5
    L16:
        if (r11 < 20) goto L18;
        r12 = new Impl20(this, r10);
        goto L5
    L18:
        this.mImpl = new Impl(this);
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat r10) {
        if (r10 == null) goto L32;
        Impl r11 = r10.mImpl;
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 30) goto L11;
        if ((r11 instanceof Impl30) == false) goto L11;
        Impl r13 = new Impl30(this, (Impl30) r11);
    L9:
        this.mImpl = r13;
        r11.copyWindowDataInto(this);
        return;
    L11:
        if (r12 < 29) goto L16;
        if ((r11 instanceof Impl29) == false) goto L16;
        r13 = new Impl29(this, (Impl29) r11);
    L16:
        if (r12 < 28) goto L21;
        if ((r11 instanceof Impl28) == false) goto L21;
        r13 = new Impl28(this, (Impl28) r11);
    L21:
        if (r12 < 21) goto L26;
        if ((r11 instanceof Impl21) == false) goto L26;
        r13 = new Impl21(this, (Impl21) r11);
    L26:
        if (r12 >= 20) goto L28;
    L30:
        r13 = new Impl(this);
        goto L9
    L28:
        if ((r11 instanceof Impl20) == false) goto L30;
        r13 = new Impl20(this, (Impl20) r11);
        goto L9
    L32:
        this.mImpl = new Impl(this);
    }

    static Insets insetInsets(@NonNull Insets r10, int r11, int r12, int r13, int r14) {
        int r15 = Math.max(0, r10.left - r11);
        int r16 = Math.max(0, r10.top - r12);
        int r17 = Math.max(0, r10.right - r13);
        int r18 = Math.max(0, r10.bottom - r14);
        if (r15 != r11) goto L9;
        if (r16 != r12) goto L9;
        if (r17 != r13) goto L9;
        if (r18 != r14) goto L9;
        return r10;
    L9:
        return Insets.of(r15, r16, r17, r18);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets r10) {
        return toWindowInsetsCompat(r10, null);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets r10, @Nullable View r11) {
        WindowInsetsCompat r12 = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(r10));
        if (r11 != null) goto L5;
    L7:
        return r12;
    L5:
        if (ViewCompat.isAttachedToWindow(r11) == false) goto L7;
        r12.setRootWindowInsets(ViewCompat.getRootWindowInsets(r11));
        r12.copyRootViewBounds(r11.getRootView());
        goto L7
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

    void copyRootViewBounds(@NonNull View r10) {
        this.mImpl.copyRootViewBounds(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WindowInsetsCompat) == true) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) r10).mImpl);
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    @NonNull
    public Insets getInsets(int r10) {
        return this.mImpl.getInsets(r10);
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int r10) {
        return this.mImpl.getInsetsIgnoringVisibility(r10);
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
        Insets r10 = getInsets(Type.all());
        Insets r11 = Insets.NONE;
        if (r10.equals(r11) == true) goto L5;
    L10:
        return true;
    L5:
        if (getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(r11) == false) goto L10;
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
        Impl r10 = this.mImpl;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13) {
        return this.mImpl.inset(r10, r11, r12, r13);
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets r10) {
        return inset(r10.left, r10.top, r10.right, r10.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public boolean isVisible(int r10) {
        return this.mImpl.isVisible(r10);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int r10, int r11, int r12, int r13) {
        return new Builder(this).setSystemWindowInsets(Insets.of(r10, r11, r12, r13)).build();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect r10) {
        return new Builder(this).setSystemWindowInsets(Insets.of(r10)).build();
    }

    void setOverriddenInsets(Insets[] r10) {
        this.mImpl.setOverriddenInsets(r10);
    }

    void setRootViewData(@NonNull Insets r10) {
        this.mImpl.setRootViewData(r10);
    }

    void setRootWindowInsets(@Nullable WindowInsetsCompat r10) {
        this.mImpl.setRootWindowInsets(r10);
    }

    void setStableInsets(@Nullable Insets r10) {
        this.mImpl.setStableInsets(r10);
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets toWindowInsets() {
        Impl r10 = this.mImpl;
        if ((r10 instanceof Impl20) == true) goto L7;
        return null;
    L7:
        return ((Impl20) r10).mPlatformInsets;
    }
}
