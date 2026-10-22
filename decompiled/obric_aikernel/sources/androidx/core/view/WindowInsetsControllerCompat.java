package androidx.core.view;

import android.R;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_DEFAULT = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    private static class Impl {
        Impl() {
        }

        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r10) {
        }

        void controlWindowInsetsAnimation(int r10, long r11, Interpolator r12, CancellationSignal r13, WindowInsetsAnimationControlListenerCompat r14) {
        }

        int getSystemBarsBehavior() {
            return 0;
        }

        void hide(int r10) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r10) {
        }

        public void setAppearanceLightNavigationBars(boolean r10) {
        }

        public void setAppearanceLightStatusBars(boolean r10) {
        }

        void setSystemBarsBehavior(int r10) {
        }

        void show(int r10) {
        }
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {

        @NonNull
        private final View mView;

        @NonNull
        protected final Window mWindow;

        Impl20(@NonNull Window r10, @NonNull View r11) {
            this.mWindow = r10;
            this.mView = r11;
        }

        public static /* synthetic */ void a(View r10) {
            lambda$showForType$0(r10);
        }

        private void hideForType(int r10) {
            if (r10 != 1) goto L5;
            setSystemUiFlag(4);
            return;
        L5:
            if (r10 != 2) goto L7;
            setSystemUiFlag(2);
            return;
        L7:
            if (r10 != 8) goto L15;
            ((InputMethodManager) this.mWindow.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mWindow.getDecorView().getWindowToken(), 0);
            return;
        }

        private static /* synthetic */ void lambda$showForType$0(View r10) {
            ((InputMethodManager) r10.getContext().getSystemService("input_method")).showSoftInput(r10, 0);
        }

        private void showForType(int r10) {
            if (r10 != 1) goto L5;
            unsetSystemUiFlag(4);
            unsetWindowFlag(1024);
            return;
        L5:
            if (r10 != 2) goto L7;
            unsetSystemUiFlag(2);
            return;
        L7:
            if (r10 != 8) goto L29;
            final View r11 = this.mView;
            if (r11.isInEditMode() == false) goto L12;
        L15:
            r11.requestFocus();
        L16:
            if (r11 != null) goto L18;
            r11 = this.mWindow.findViewById(R.id.content);
        L18:
            if (r11 != null) goto L20;
            return;
        L20:
            if (r11.hasWindowFocus() == false) goto L28;
            r11.post(new j(r11));
            return;
        L28:
            return;
        L12:
            if (r11.onCheckIsTextEditor() == true) goto L15;
            r11 = this.mWindow.getCurrentFocus();
            goto L16
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r10) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int r10, long r11, Interpolator r12, CancellationSignal r13, WindowInsetsAnimationControlListenerCompat r14) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            return 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int r10) {
            int r11 = 1;
        L4:
            if (r11 > 256) goto L10;
            if ((r10 & r11) == 0) goto L9;
            hideForType(r11);
        L9:
            r11 = r11 << 1;
            goto L4
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r10) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int r10) {
            if (r10 != 0) goto L4;
            unsetSystemUiFlag(6144);
            return;
        L4:
            if (r10 != 1) goto L6;
            unsetSystemUiFlag(4096);
            setSystemUiFlag(2048);
            return;
        L6:
            if (r10 != 2) goto L14;
            unsetSystemUiFlag(2048);
            setSystemUiFlag(4096);
            return;
        }

        protected void setSystemUiFlag(int r10) {
            View r11 = this.mWindow.getDecorView();
            r11.setSystemUiVisibility(r10 | r11.getSystemUiVisibility());
        }

        protected void setWindowFlag(int r10) {
            this.mWindow.addFlags(r10);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int r10) {
            int r11 = 1;
        L4:
            if (r11 > 256) goto L10;
            if ((r10 & r11) == 0) goto L9;
            showForType(r11);
        L9:
            r11 = r11 << 1;
            goto L4
        }

        protected void unsetSystemUiFlag(int r10) {
            View r11 = this.mWindow.getDecorView();
            int r12 = r11.getSystemUiVisibility();
            r11.setSystemUiVisibility((~r10) & r12);
        }

        protected void unsetWindowFlag(int r10) {
            this.mWindow.clearFlags(r10);
        }
    }

    @RequiresApi(23)
    private static class Impl23 extends Impl20 {
        Impl23(@NonNull Window r10, @Nullable View r11) {
            super(r10, r11);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean r10) {
            if (r10 == false) goto L5;
            unsetWindowFlag(67108864);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(8192);
            return;
        L5:
            unsetSystemUiFlag(8192);
        }
    }

    @RequiresApi(26)
    private static class Impl26 extends Impl23 {
        Impl26(@NonNull Window r10, @Nullable View r11) {
            super(r10, r11);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean r10) {
            if (r10 == false) goto L5;
            unsetWindowFlag(134217728);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(16);
            return;
        L5:
            unsetSystemUiFlag(16);
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;
        protected Window mWindow;

        Impl30(@NonNull Window r10, @NonNull WindowInsetsControllerCompat r11) {
            this(r10.getInsetsController(), r11);
            this.mWindow = r10;
        }

        Impl30(@NonNull WindowInsetsController r10, @NonNull WindowInsetsControllerCompat r11) {
            this.mListeners = new SimpleArrayMap();
            this.mInsetsController = r10;
            this.mCompatController = r11;
        }

        public static /* synthetic */ void a(Impl30 r10, OnControllableInsetsChangedListener r11, WindowInsetsController r12, int r13) {
            r10.lambda$addOnControllableInsetsChangedListener$0(r11, r12, r13);
        }

        private /* synthetic */ void lambda$addOnControllableInsetsChangedListener$0(OnControllableInsetsChangedListener r10, WindowInsetsController r11, int r12) {
            if (this.mInsetsController != r11) goto L6;
            r10.onControllableInsetsChanged(this.mCompatController, r12);
            return;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(@NonNull final OnControllableInsetsChangedListener r10) {
            if (this.mListeners.containsKey(r10) == false) goto L5;
            return;
        L5:
            WindowInsetsController.OnControllableInsetsChangedListener r11 = new k(this, r10);
            this.mListeners.put(r10, r11);
            this.mInsetsController.addOnControllableInsetsChangedListener(r11);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int r10, long r11, @Nullable Interpolator r12, @Nullable CancellationSignal r13, @NonNull final WindowInsetsAnimationControlListenerCompat r14) {
            WindowInsetsAnimationControlListener r15 = new AnonymousClass1(this, r14);
            this.mInsetsController.controlWindowInsetsAnimation(r10, r11, r12, r13, r15);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        @SuppressLint({"WrongConstant"})
        int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int r10) {
            this.mInsetsController.hide(r10);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            if ((this.mInsetsController.getSystemBarsAppearance() & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            if ((this.mInsetsController.getSystemBarsAppearance() & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r10) {
            WindowInsetsController.OnControllableInsetsChangedListener r11 = this.mListeners.remove(r10);
            if (r11 == null) goto L6;
            this.mInsetsController.removeOnControllableInsetsChangedListener(r11);
            return;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean r10) {
            if (r10 == false) goto L9;
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
        public void setAppearanceLightStatusBars(boolean r10) {
            if (r10 == false) goto L9;
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
        void setSystemBarsBehavior(int r10) {
            this.mInsetsController.setSystemBarsBehavior(r10);
        }

        protected void setSystemUiFlag(int r10) {
            View r11 = this.mWindow.getDecorView();
            r11.setSystemUiVisibility(r10 | r11.getSystemUiVisibility());
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int r10) {
            Window r11 = this.mWindow;
            if (r11 != null) goto L5;
        L9:
            this.mInsetsController.show(r10);
            return;
        L5:
            if ((r10 & 8) == 0) goto L9;
            if (Build.VERSION.SDK_INT >= 33) goto L9;
            ((InputMethodManager) r11.getContext().getSystemService("input_method")).isActive();
            goto L9
        }

        protected void unsetSystemUiFlag(int r10) {
            View r11 = this.mWindow.getDecorView();
            int r12 = r11.getSystemUiVisibility();
            r11.setSystemUiVisibility((~r10) & r12);
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@NonNull WindowInsetsControllerCompat r10, int r11);
    }

    public WindowInsetsControllerCompat(@NonNull Window r10, @NonNull View r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 30) goto L6;
        this.mImpl = new Impl30(r10, this);
        return;
    L6:
        if (r12 < 26) goto L10;
        Impl r13 = new Impl26(r10, r11);
    L8:
        this.mImpl = r13;
        return;
    L10:
        if (r12 < 23) goto L13;
        r13 = new Impl23(r10, r11);
        goto L8
    L13:
        if (r12 < 20) goto L15;
        r13 = new Impl20(r10, r11);
        goto L8
    L15:
        this.mImpl = new Impl();
    }

    @RequiresApi(30)
    @Deprecated
    private WindowInsetsControllerCompat(@NonNull WindowInsetsController r10) {
        this.mImpl = new Impl30(r10, this);
    }

    @NonNull
    @RequiresApi(30)
    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(@NonNull WindowInsetsController r10) {
        return new WindowInsetsControllerCompat(r10);
    }

    public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r10) {
        this.mImpl.addOnControllableInsetsChangedListener(r10);
    }

    public void controlWindowInsetsAnimation(int r10, long r11, @Nullable Interpolator r12, @Nullable CancellationSignal r13, @NonNull WindowInsetsAnimationControlListenerCompat r14) {
        this.mImpl.controlWindowInsetsAnimation(r10, r11, r12, r13, r14);
    }

    @SuppressLint({"WrongConstant"})
    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int r10) {
        this.mImpl.hide(r10);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r10) {
        this.mImpl.removeOnControllableInsetsChangedListener(r10);
    }

    public void setAppearanceLightNavigationBars(boolean r10) {
        this.mImpl.setAppearanceLightNavigationBars(r10);
    }

    public void setAppearanceLightStatusBars(boolean r10) {
        this.mImpl.setAppearanceLightStatusBars(r10);
    }

    public void setSystemBarsBehavior(int r10) {
        this.mImpl.setSystemBarsBehavior(r10);
    }

    public void show(int r10) {
        this.mImpl.show(r10);
    }
}
