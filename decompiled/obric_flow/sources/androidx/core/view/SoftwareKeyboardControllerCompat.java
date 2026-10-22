package androidx.core.view;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class SoftwareKeyboardControllerCompat {
    private final Impl mImpl;

    public static class Impl {
        public Impl() {
        }

        public void hide() {
        }

        public void show() {
        }
    }

    @RequiresApi(20)
    public static class Impl20 extends Impl {

        @Nullable
        private final View mView;

        public Impl20(@Nullable View r5) {
            this.mView = r5;
        }

        public static /* synthetic */ void a(View r5) {
            lambda$show$0(r5);
        }

        private static /* synthetic */ void lambda$show$0(View r5) {
            ((InputMethodManager) r5.getContext().getSystemService("input_method")).showSoftInput(r5, 0);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        public void hide() {
            View r5 = this.mView;
            if (r5 == null) goto L6;
            ((InputMethodManager) r5.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
            return;
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        public void show() {
            View r5 = this.mView;
            if (r5 != null) goto L6;
            return;
        L6:
            if (r5.isInEditMode() == false) goto L8;
        L11:
            r5.requestFocus();
        L12:
            if (r5 != null) goto L14;
            r5 = this.mView.getRootView().findViewById(R.id.content);
        L14:
            if (r5 != null) goto L16;
            return;
        L16:
            if (r5.hasWindowFocus() == false) goto L20;
            r5.post(new g(r5, 0));
            return;
        L20:
            return;
        L8:
            if (r5.onCheckIsTextEditor() == true) goto L11;
            r5 = r5.getRootView().findFocus();
            goto L12
        }
    }

    @RequiresApi(30)
    public static class Impl30 extends Impl20 {

        @Nullable
        private View mView;

        @Nullable
        private WindowInsetsController mWindowInsetsController;

        public Impl30(@NonNull View r5) {
            super(r5);
            this.mView = r5;
        }

        public static /* synthetic */ void b(AtomicBoolean r5, WindowInsetsController r10, int r11) {
            lambda$hide$0(r5, r10, r11);
        }

        private static /* synthetic */ void lambda$hide$0(AtomicBoolean r5, WindowInsetsController r10, int r11) {
            if ((r11 & 8) == 0) goto L5;
            boolean r12 = true;
        L6:
            r5.set(r12);
            return;
        L5:
            r12 = false;
            goto L6
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        public void hide() {
            WindowInsetsController r5 = this.mWindowInsetsController;
            if (r5 != null) goto L9;
            View r10 = this.mView;
            if (r10 == null) goto L8;
            r5 = r10.getWindowInsetsController();
            goto L9
        L8:
            r5 = null;
        L9:
            if (r5 == null) goto L16;
            final AtomicBoolean r11 = new AtomicBoolean(false);
            WindowInsetsController.OnControllableInsetsChangedListener r12 = new h(r11);
            r5.addOnControllableInsetsChangedListener(r12);
            if (r11.get() == true) goto L15;
            View r13 = this.mView;
            if (r13 == null) goto L15;
            ((InputMethodManager) r13.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
        L15:
            r5.removeOnControllableInsetsChangedListener(r12);
            r5.hide(WindowInsets.Type.ime());
            return;
        L16:
            super.hide();
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        public void show() {
            View r5 = this.mView;
            if (r5 != null) goto L5;
        L7:
            WindowInsetsController r10 = this.mWindowInsetsController;
            if (r10 != null) goto L14;
            View r11 = this.mView;
            if (r11 == null) goto L13;
            r10 = r11.getWindowInsetsController();
            goto L14
        L13:
            r10 = null;
        L14:
            if (r10 == null) goto L16;
            r10.show(WindowInsets.Type.ime());
            return;
        L16:
            super.show();
            return;
        L5:
            if (Build.VERSION.SDK_INT >= 33) goto L7;
            ((InputMethodManager) r5.getContext().getSystemService("input_method")).isActive();
            goto L7
        }

        public Impl30(@Nullable WindowInsetsController r5) {
            super(null);
            this.mWindowInsetsController = r5;
        }
    }

    public SoftwareKeyboardControllerCompat(@NonNull View r5) {
        this.mImpl = new Impl30(r5);
    }

    public void hide() {
        this.mImpl.hide();
    }

    public void show() {
        this.mImpl.show();
    }

    @RequiresApi(30)
    @Deprecated
    public SoftwareKeyboardControllerCompat(@NonNull WindowInsetsController r5) {
        this.mImpl = new Impl30(r5);
    }
}
