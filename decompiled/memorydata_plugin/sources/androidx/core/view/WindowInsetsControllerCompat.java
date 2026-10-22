package androidx.core.view;

import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r2) {
            OnControllableInsetsChangedListener r1 = (OnControllableInsetsChangedListener) ZeusTransformUtils.wrapperContextForParams(r2, OnControllableInsetsChangedListener.class, "com.obric.memorydata.plugin");
        }

        void controlWindowInsetsAnimation(int r1, long r2, Interpolator r4, CancellationSignal r5, WindowInsetsAnimationControlListenerCompat r6) {
            Interpolator r0 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r4, Interpolator.class, "com.obric.memorydata.plugin");
            WindowInsetsAnimationControlListenerCompat r3 = (WindowInsetsAnimationControlListenerCompat) ZeusTransformUtils.wrapperContextForParams(r6, WindowInsetsAnimationControlListenerCompat.class, "com.obric.memorydata.plugin");
        }

        int getSystemBarsBehavior() {
            return 0;
        }

        void hide(int r1) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r2) {
            OnControllableInsetsChangedListener r1 = (OnControllableInsetsChangedListener) ZeusTransformUtils.wrapperContextForParams(r2, OnControllableInsetsChangedListener.class, "com.obric.memorydata.plugin");
        }

        public void setAppearanceLightNavigationBars(boolean r1) {
        }

        public void setAppearanceLightStatusBars(boolean r1) {
        }

        void setSystemBarsBehavior(int r1) {
        }

        void show(int r1) {
        }
    }

    private static class Impl20 extends Impl {
        private final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected final Window mWindow;

        Impl20(Window r1, SoftwareKeyboardControllerCompat r2) {
            this.mWindow = r1;
            this.mSoftwareKeyboardControllerCompat = r2;
        }

        private void hideForType(int r2) {
            if (r2 != 1) goto L5;
            setSystemUiFlag(4);
            return;
        L5:
            if (r2 != 2) goto L7;
            setSystemUiFlag(2);
            return;
        L7:
            if (r2 != 8) goto L15;
            this.mSoftwareKeyboardControllerCompat.hide();
            return;
        }

        private void showForType(int r2) {
            if (r2 != 1) goto L5;
            unsetSystemUiFlag(4);
            unsetWindowFlag(1024);
            return;
        L5:
            if (r2 != 2) goto L7;
            unsetSystemUiFlag(2);
            return;
        L7:
            if (r2 != 8) goto L15;
            this.mSoftwareKeyboardControllerCompat.show();
            return;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r2) {
            OnControllableInsetsChangedListener r1 = (OnControllableInsetsChangedListener) ZeusTransformUtils.wrapperContextForParams(r2, OnControllableInsetsChangedListener.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int r1, long r2, Interpolator r4, CancellationSignal r5, WindowInsetsAnimationControlListenerCompat r6) {
            Interpolator r0 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r4, Interpolator.class, "com.obric.memorydata.plugin");
            WindowInsetsAnimationControlListenerCompat r3 = (WindowInsetsAnimationControlListenerCompat) ZeusTransformUtils.wrapperContextForParams(r6, WindowInsetsAnimationControlListenerCompat.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            return 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int r3) {
            int r0 = 1;
        L4:
            if (r0 > 256) goto L10;
            if ((r3 & r0) == 0) goto L9;
            hideForType(r0);
        L9:
            r0 = r0 << 1;
            goto L4
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r2) {
            OnControllableInsetsChangedListener r1 = (OnControllableInsetsChangedListener) ZeusTransformUtils.wrapperContextForParams(r2, OnControllableInsetsChangedListener.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int r4) {
            if (r4 != 0) goto L4;
            unsetSystemUiFlag(6144);
            return;
        L4:
            if (r4 != 1) goto L6;
            unsetSystemUiFlag(4096);
            setSystemUiFlag(2048);
            return;
        L6:
            if (r4 != 2) goto L14;
            unsetSystemUiFlag(2048);
            setSystemUiFlag(4096);
            return;
        }

        public void setSystemUiFlag(int r2) {
            View r1 = this.mWindow.getDecorView();
            r1.setSystemUiVisibility(r2 | r1.getSystemUiVisibility());
        }

        public void setWindowFlag(int r1) {
            this.mWindow.addFlags(r1);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int r3) {
            int r0 = 1;
        L4:
            if (r0 > 256) goto L10;
            if ((r3 & r0) == 0) goto L9;
            showForType(r0);
        L9:
            r0 = r0 << 1;
            goto L4
        }

        public void unsetSystemUiFlag(int r2) {
            View r1 = this.mWindow.getDecorView();
            int r0 = r1.getSystemUiVisibility();
            r1.setSystemUiVisibility((~r2) & r0);
        }

        public void unsetWindowFlag(int r1) {
            this.mWindow.clearFlags(r1);
        }
    }

    private static class Impl23 extends Impl20 {
        Impl23(Window r1, SoftwareKeyboardControllerCompat r2) {
            super(r1, r2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean r2) {
            if (r2 == false) goto L5;
            unsetWindowFlag(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(8192);
            return;
        L5:
            unsetSystemUiFlag(8192);
        }
    }

    private static class Impl26 extends Impl23 {
        Impl26(Window r1, SoftwareKeyboardControllerCompat r2) {
            super(r1, r2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean r2) {
            if (r2 == false) goto L5;
            unsetWindowFlag(134217728);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(16);
            return;
        L5:
            unsetSystemUiFlag(16);
        }
    }

    private static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;
        final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected Window mWindow;

        Impl30(Window r2, WindowInsetsControllerCompat r3, SoftwareKeyboardControllerCompat r4) {
            this(r2.getInsetsController(), r3, r4);
            this.mWindow = r2;
        }

        Impl30(WindowInsetsController r3, WindowInsetsControllerCompat r4, SoftwareKeyboardControllerCompat r5) {
            WindowInsetsController r6 = (WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsController.class, "com.obric.memorydata.plugin");
            this.mListeners = new SimpleArrayMap();
            this.mInsetsController = r6;
            this.mCompatController = r4;
            this.mSoftwareKeyboardControllerCompat = r5;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r3) {
            final OnControllableInsetsChangedListener r4 = (OnControllableInsetsChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, OnControllableInsetsChangedListener.class, "com.obric.memorydata.plugin");
            if (this.mListeners.containsKey(r4) == false) goto L5;
            return;
        L5:
            WindowInsetsController.OnControllableInsetsChangedListener r0 = new $$Lambda$WindowInsetsControllerCompat$Impl30$cdZqTFRvo8KSnFk5DhCaM1suM5Y(this, r4);
            this.mListeners.put(r4, r0);
            this.mInsetsController.addOnControllableInsetsChangedListener(r0);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int r10, long r11, Interpolator r13, CancellationSignal r14, WindowInsetsAnimationControlListenerCompat r15) {
            Interpolator r6 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r13, Interpolator.class, "com.obric.memorydata.plugin");
            final WindowInsetsAnimationControlListenerCompat r16 = (WindowInsetsAnimationControlListenerCompat) ZeusTransformUtils.wrapperContextForParams(r15, WindowInsetsAnimationControlListenerCompat.class, "com.obric.memorydata.plugin");
            WindowInsetsAnimationControlListener r8 = new AnonymousClass1(this, r16);
            this.mInsetsController.controlWindowInsetsAnimation(r10, r11, r6, r14, r8);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int r2) {
            if ((r2 & 8) == 0) goto L5;
            this.mSoftwareKeyboardControllerCompat.hide();
        L5:
            this.mInsetsController.hide(r2 & (-9));
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

        public /* synthetic */ void lambda$addOnControllableInsetsChangedListener$0$WindowInsetsControllerCompat$Impl30(OnControllableInsetsChangedListener r3, WindowInsetsController r4, int r5) {
            OnControllableInsetsChangedListener r6 = (OnControllableInsetsChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, OnControllableInsetsChangedListener.class, "com.obric.memorydata.plugin");
            WindowInsetsController r7 = (WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r4, WindowInsetsController.class, "com.obric.memorydata.plugin");
            if (this.mInsetsController != r7) goto L6;
            r6.onControllableInsetsChanged(this.mCompatController, r5);
            return;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r3) {
            OnControllableInsetsChangedListener r4 = (OnControllableInsetsChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, OnControllableInsetsChangedListener.class, "com.obric.memorydata.plugin");
            WindowInsetsController.OnControllableInsetsChangedListener r5 = (WindowInsetsController.OnControllableInsetsChangedListener) ZeusTransformUtils.preCheckCast(this.mListeners.remove(r4), WindowInsetsController.OnControllableInsetsChangedListener.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L6;
            this.mInsetsController.removeOnControllableInsetsChangedListener(r5);
            return;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean r2) {
            if (r2 == false) goto L9;
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
        public void setAppearanceLightStatusBars(boolean r3) {
            if (r3 == false) goto L9;
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
        void setSystemBarsBehavior(int r1) {
            this.mInsetsController.setSystemBarsBehavior(r1);
        }

        public void setSystemUiFlag(int r2) {
            View r1 = this.mWindow.getDecorView();
            r1.setSystemUiVisibility(r2 | r1.getSystemUiVisibility());
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int r2) {
            if ((r2 & 8) == 0) goto L5;
            this.mSoftwareKeyboardControllerCompat.show();
        L5:
            this.mInsetsController.show(r2 & (-9));
        }

        public void unsetSystemUiFlag(int r2) {
            View r1 = this.mWindow.getDecorView();
            int r0 = r1.getSystemUiVisibility();
            r1.setSystemUiVisibility((~r2) & r0);
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(WindowInsetsControllerCompat r1, int r2);
    }

    public WindowInsetsControllerCompat(Window r3, View r4) {
        SoftwareKeyboardControllerCompat r0 = new SoftwareKeyboardControllerCompat(r4);
        if (Build.VERSION.SDK_INT < 30) goto L7;
        Impl r5 = new Impl30(r3, this, r0);
    L5:
        this.mImpl = r5;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        r5 = new Impl26(r3, r0);
        goto L5
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L13;
        r5 = new Impl23(r3, r0);
        goto L5
    L13:
        if (Build.VERSION.SDK_INT < 20) goto L15;
        r5 = new Impl20(r3, r0);
        goto L5
    L15:
        this.mImpl = new Impl();
    }

    @Deprecated
    private WindowInsetsControllerCompat(WindowInsetsController r3) {
        WindowInsetsController r4 = (WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsController.class, "com.obric.memorydata.plugin");
        this.mImpl = new Impl30(r4, this, new SoftwareKeyboardControllerCompat(r4));
    }

    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(WindowInsetsController r2) {
        return new WindowInsetsControllerCompat((WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r2, WindowInsetsController.class, "com.obric.memorydata.plugin"));
    }

    public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r3) {
        OnControllableInsetsChangedListener r4 = (OnControllableInsetsChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, OnControllableInsetsChangedListener.class, "com.obric.memorydata.plugin");
        this.mImpl.addOnControllableInsetsChangedListener(r4);
    }

    public void controlWindowInsetsAnimation(int r10, long r11, Interpolator r13, CancellationSignal r14, WindowInsetsAnimationControlListenerCompat r15) {
        Interpolator r6 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r13, Interpolator.class, "com.obric.memorydata.plugin");
        WindowInsetsAnimationControlListenerCompat r8 = (WindowInsetsAnimationControlListenerCompat) ZeusTransformUtils.wrapperContextForParams(r15, WindowInsetsAnimationControlListenerCompat.class, "com.obric.memorydata.plugin");
        this.mImpl.controlWindowInsetsAnimation(r10, r11, r6, r14, r8);
    }

    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int r1) {
        this.mImpl.hide(r1);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r3) {
        OnControllableInsetsChangedListener r4 = (OnControllableInsetsChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, OnControllableInsetsChangedListener.class, "com.obric.memorydata.plugin");
        this.mImpl.removeOnControllableInsetsChangedListener(r4);
    }

    public void setAppearanceLightNavigationBars(boolean r1) {
        this.mImpl.setAppearanceLightNavigationBars(r1);
    }

    public void setAppearanceLightStatusBars(boolean r1) {
        this.mImpl.setAppearanceLightStatusBars(r1);
    }

    public void setSystemBarsBehavior(int r1) {
        this.mImpl.setSystemBarsBehavior(r1);
    }

    public void show(int r1) {
        this.mImpl.show(r1);
    }
}
