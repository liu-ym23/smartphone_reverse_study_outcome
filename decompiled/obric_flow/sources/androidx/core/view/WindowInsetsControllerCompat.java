package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_DEFAULT = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    public static class Impl {
        public Impl() {
        }

        public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r5) {
        }

        public void controlWindowInsetsAnimation(int r5, long r10, Interpolator r11, CancellationSignal r12, WindowInsetsAnimationControlListenerCompat r13) {
        }

        public int getSystemBarsBehavior() {
            return 0;
        }

        public void hide(int r5) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r5) {
        }

        public void setAppearanceLightNavigationBars(boolean r5) {
        }

        public void setAppearanceLightStatusBars(boolean r5) {
        }

        public void setSystemBarsBehavior(int r5) {
        }

        public void show(int r5) {
        }
    }

    @RequiresApi(20)
    public static class Impl20 extends Impl {

        @NonNull
        private final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;

        @NonNull
        protected final Window mWindow;

        public Impl20(@NonNull Window r5, @NonNull SoftwareKeyboardControllerCompat r10) {
            this.mWindow = r5;
            this.mSoftwareKeyboardControllerCompat = r10;
        }

        private void hideForType(int r5) {
            if (r5 != 1) goto L5;
            setSystemUiFlag(4);
            return;
        L5:
            if (r5 != 2) goto L7;
            setSystemUiFlag(2);
            return;
        L7:
            if (r5 != 8) goto L15;
            this.mSoftwareKeyboardControllerCompat.hide();
            return;
        }

        private void showForType(int r5) {
            if (r5 != 1) goto L5;
            unsetSystemUiFlag(4);
            unsetWindowFlag(1024);
            return;
        L5:
            if (r5 != 2) goto L7;
            unsetSystemUiFlag(2);
            return;
        L7:
            if (r5 != 8) goto L15;
            this.mSoftwareKeyboardControllerCompat.show();
            return;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r5) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void controlWindowInsetsAnimation(int r5, long r10, Interpolator r11, CancellationSignal r12, WindowInsetsAnimationControlListenerCompat r13) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public int getSystemBarsBehavior() {
            return 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void hide(int r5) {
            int r10 = 1;
        L4:
            if (r10 > 256) goto L10;
            if ((r5 & r10) == 0) goto L9;
            hideForType(r10);
        L9:
            r10 = r10 << 1;
            goto L4
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r5) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setSystemBarsBehavior(int r5) {
            if (r5 != 0) goto L4;
            unsetSystemUiFlag(6144);
            return;
        L4:
            if (r5 != 1) goto L6;
            unsetSystemUiFlag(4096);
            setSystemUiFlag(2048);
            return;
        L6:
            if (r5 != 2) goto L14;
            unsetSystemUiFlag(2048);
            setSystemUiFlag(4096);
            return;
        }

        public void setSystemUiFlag(int r5) {
            View r10 = this.mWindow.getDecorView();
            r10.setSystemUiVisibility(r5 | r10.getSystemUiVisibility());
        }

        public void setWindowFlag(int r5) {
            this.mWindow.addFlags(r5);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void show(int r5) {
            int r10 = 1;
        L4:
            if (r10 > 256) goto L10;
            if ((r5 & r10) == 0) goto L9;
            showForType(r10);
        L9:
            r10 = r10 << 1;
            goto L4
        }

        public void unsetSystemUiFlag(int r5) {
            View r10 = this.mWindow.getDecorView();
            int r11 = r10.getSystemUiVisibility();
            r10.setSystemUiVisibility((~r5) & r11);
        }

        public void unsetWindowFlag(int r5) {
            this.mWindow.clearFlags(r5);
        }
    }

    @RequiresApi(23)
    public static class Impl23 extends Impl20 {
        public Impl23(@NonNull Window r5, @NonNull SoftwareKeyboardControllerCompat r10) {
            super(r5, r10);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean r5) {
            if (r5 == false) goto L5;
            unsetWindowFlag(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(8192);
            return;
        L5:
            unsetSystemUiFlag(8192);
        }
    }

    @RequiresApi(26)
    public static class Impl26 extends Impl23 {
        public Impl26(@NonNull Window r5, @NonNull SoftwareKeyboardControllerCompat r10) {
            super(r5, r10);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean r5) {
            if (r5 == false) goto L5;
            unsetWindowFlag(134217728);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(16);
            return;
        L5:
            unsetSystemUiFlag(16);
        }
    }

    @RequiresApi(30)
    public static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;
        final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected Window mWindow;

        public Impl30(@NonNull Window r5, @NonNull WindowInsetsControllerCompat r10, @NonNull SoftwareKeyboardControllerCompat r11) {
            this(r5.getInsetsController(), r10, r11);
            this.mWindow = r5;
        }

        public static /* synthetic */ void a(Impl30 r5, OnControllableInsetsChangedListener r10, WindowInsetsController r11, int r12) {
            r5.lambda$addOnControllableInsetsChangedListener$0(r10, r11, r12);
        }

        private /* synthetic */ void lambda$addOnControllableInsetsChangedListener$0(OnControllableInsetsChangedListener r5, WindowInsetsController r10, int r11) {
            if (this.mInsetsController != r10) goto L6;
            r5.onControllableInsetsChanged(this.mCompatController, r11);
            return;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void addOnControllableInsetsChangedListener(@NonNull final OnControllableInsetsChangedListener r5) {
            if (this.mListeners.containsKey(r5) == false) goto L5;
            return;
        L5:
            WindowInsetsController.OnControllableInsetsChangedListener r10 = new m(this, r5);
            this.mListeners.put(r5, r10);
            this.mInsetsController.addOnControllableInsetsChangedListener(r10);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void controlWindowInsetsAnimation(int r10, long r11, @Nullable Interpolator r12, @Nullable CancellationSignal r13, @NonNull final WindowInsetsAnimationControlListenerCompat r14) {
            WindowInsetsAnimationControlListener r15 = new AnonymousClass1(this, r14);
            this.mInsetsController.controlWindowInsetsAnimation(r10, r11, r12, r13, r15);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        @SuppressLint({"WrongConstant"})
        public int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void hide(int r5) {
            if ((r5 & 8) == 0) goto L5;
            this.mSoftwareKeyboardControllerCompat.hide();
        L5:
            this.mInsetsController.hide(r5 & (-9));
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            this.mInsetsController.setSystemBarsAppearance(0, 0);
            if ((this.mInsetsController.getSystemBarsAppearance() & 16) == 0) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            this.mInsetsController.setSystemBarsAppearance(0, 0);
            if ((this.mInsetsController.getSystemBarsAppearance() & 8) == 0) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r5) {
            WindowInsetsController.OnControllableInsetsChangedListener r10 = this.mListeners.remove(r5);
            if (r10 == null) goto L6;
            this.mInsetsController.removeOnControllableInsetsChangedListener(r10);
            return;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean r5) {
            if (r5 == false) goto L9;
            if (this.mWindow == null) goto L7;
            setSystemUiFlag(16);
        L7:
            this.mInsetsController.setSystemBarsAppearance(16, 16);
            return;
        L9:
            if (this.mWindow == null) goto L11;
            unsetSystemUiFlag(16);
        L11:
            this.mInsetsController.setSystemBarsAppearance(0, 16);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean r5) {
            if (r5 == false) goto L9;
            if (this.mWindow == null) goto L7;
            setSystemUiFlag(8192);
        L7:
            this.mInsetsController.setSystemBarsAppearance(8, 8);
            return;
        L9:
            if (this.mWindow == null) goto L11;
            unsetSystemUiFlag(8192);
        L11:
            this.mInsetsController.setSystemBarsAppearance(0, 8);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setSystemBarsBehavior(int r5) {
            this.mInsetsController.setSystemBarsBehavior(r5);
        }

        public void setSystemUiFlag(int r5) {
            View r10 = this.mWindow.getDecorView();
            r10.setSystemUiVisibility(r5 | r10.getSystemUiVisibility());
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void show(int r5) {
            if ((r5 & 8) == 0) goto L5;
            this.mSoftwareKeyboardControllerCompat.show();
        L5:
            this.mInsetsController.show(r5 & (-9));
        }

        public void unsetSystemUiFlag(int r5) {
            View r10 = this.mWindow.getDecorView();
            int r11 = r10.getSystemUiVisibility();
            r10.setSystemUiVisibility((~r5) & r11);
        }

        public Impl30(@NonNull WindowInsetsController r5, @NonNull WindowInsetsControllerCompat r10, @NonNull SoftwareKeyboardControllerCompat r11) {
            this.mListeners = new SimpleArrayMap();
            this.mInsetsController = r5;
            this.mCompatController = r10;
            this.mSoftwareKeyboardControllerCompat = r11;
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@NonNull WindowInsetsControllerCompat r5, int r10);
    }

    @RequiresApi(30)
    @Deprecated
    private WindowInsetsControllerCompat(@NonNull WindowInsetsController r5) {
        this.mImpl = new Impl30(r5, this, new SoftwareKeyboardControllerCompat(r5));
    }

    @NonNull
    @RequiresApi(30)
    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(@NonNull WindowInsetsController r5) {
        return new WindowInsetsControllerCompat(r5);
    }

    public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r5) {
        this.mImpl.addOnControllableInsetsChangedListener(r5);
    }

    public void controlWindowInsetsAnimation(int r10, long r11, @Nullable Interpolator r12, @Nullable CancellationSignal r13, @NonNull WindowInsetsAnimationControlListenerCompat r14) {
        this.mImpl.controlWindowInsetsAnimation(r10, r11, r12, r13, r14);
    }

    @SuppressLint({"WrongConstant"})
    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int r5) {
        this.mImpl.hide(r5);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r5) {
        this.mImpl.removeOnControllableInsetsChangedListener(r5);
    }

    public void setAppearanceLightNavigationBars(boolean r5) {
        this.mImpl.setAppearanceLightNavigationBars(r5);
    }

    public void setAppearanceLightStatusBars(boolean r5) {
        this.mImpl.setAppearanceLightStatusBars(r5);
    }

    public void setSystemBarsBehavior(int r5) {
        this.mImpl.setSystemBarsBehavior(r5);
    }

    public void show(int r5) {
        this.mImpl.show(r5);
    }

    public WindowInsetsControllerCompat(@NonNull Window r5, @NonNull View r10) {
        this.mImpl = new Impl30(r5, this, new SoftwareKeyboardControllerCompat(r10));
    }
}
