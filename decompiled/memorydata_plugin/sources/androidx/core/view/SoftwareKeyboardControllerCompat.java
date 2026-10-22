package androidx.core.view;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class SoftwareKeyboardControllerCompat {
    private final Impl mImpl;

    private static class Impl {
        Impl() {
        }

        void hide() {
        }

        void show() {
        }
    }

    private static class Impl20 extends Impl {
        private final View mView;

        Impl20(View r1) {
            this.mView = r1;
        }

        static /* synthetic */ void lambda$show$0(View r3) {
            ((InputMethodManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method"), InputMethodManager.class, "com.obric.memorydata.plugin")).showSoftInput(r3, 0);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void hide() {
            View r0 = this.mView;
            if (r0 == null) goto L6;
            ((InputMethodManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method"), InputMethodManager.class, "com.obric.memorydata.plugin")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
            return;
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void show() {
            final View r0 = this.mView;
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.isInEditMode() == false) goto L8;
        L11:
            r0.requestFocus();
        L12:
            if (r0 != null) goto L14;
            r0 = this.mView.getRootView().findViewById(R.id.content);
        L14:
            if (r0 != null) goto L16;
            return;
        L16:
            if (r0.hasWindowFocus() == false) goto L20;
            r0.post(new $$Lambda$SoftwareKeyboardControllerCompat$Impl20$u4uIvAozI847qj1kh1RMVuhvBhg(r0));
            return;
        L20:
            return;
        L8:
            if (r0.onCheckIsTextEditor() == true) goto L11;
            r0 = r0.getRootView().findFocus();
            goto L12
        }
    }

    private static class Impl30 extends Impl20 {
        private View mView;
        private WindowInsetsController mWindowInsetsController;

        Impl30(View r1) {
            super(r1);
            this.mView = r1;
        }

        Impl30(WindowInsetsController r3) {
            WindowInsetsController r4 = (WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsController.class, "com.obric.memorydata.plugin");
            super(null);
            this.mWindowInsetsController = r4;
        }

        static /* synthetic */ void lambda$hide$0(AtomicBoolean r2, WindowInsetsController r3, int r4) {
            WindowInsetsController r5 = (WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsController.class, "com.obric.memorydata.plugin");
            if ((r4 & 8) == 0) goto L5;
            boolean r6 = true;
        L6:
            r2.set(r6);
            return;
        L5:
            r6 = false;
            goto L6
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void hide() {
            WindowInsetsController r0 = this.mWindowInsetsController;
            if (r0 != null) goto L9;
            View r1 = this.mView;
            if (r1 == null) goto L8;
            r0 = r1.getWindowInsetsController();
            goto L9
        L8:
            r0 = null;
        L9:
            if (r0 == null) goto L16;
            final AtomicBoolean r2 = new AtomicBoolean(false);
            WindowInsetsController.OnControllableInsetsChangedListener r3 = new $$Lambda$SoftwareKeyboardControllerCompat$Impl30$NOpnYWodE79aXmVFvQxDV4OedpM(r2);
            r0.addOnControllableInsetsChangedListener(r3);
            if (r2.get() == true) goto L15;
            View r4 = this.mView;
            if (r4 == null) goto L15;
            ((InputMethodManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method"), InputMethodManager.class, "com.obric.memorydata.plugin")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
        L15:
            r0.removeOnControllableInsetsChangedListener(r3);
            r0.hide(WindowInsets.Type.ime());
            return;
        L16:
            super.hide();
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void show() {
            if (this.mView != null) goto L5;
        L7:
            WindowInsetsController r0 = null;
            WindowInsetsController r1 = this.mWindowInsetsController;
            if (r1 == null) goto L10;
            r0 = r1;
        L13:
            if (r0 == null) goto L15;
            r0.show(WindowInsets.Type.ime());
            return;
        L15:
            super.show();
            return;
        L10:
            View r2 = this.mView;
            if (r2 == null) goto L13;
            r0 = r2.getWindowInsetsController();
            goto L13
        L5:
            if (Build.VERSION.SDK_INT >= 33) goto L7;
            ((InputMethodManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method"), InputMethodManager.class, "com.obric.memorydata.plugin")).isActive();
            goto L7
        }
    }

    public SoftwareKeyboardControllerCompat(View r3) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        Impl r0 = new Impl30(r3);
    L5:
        this.mImpl = r0;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 20) goto L9;
        r0 = new Impl20(r3);
        goto L5
    L9:
        this.mImpl = new Impl();
    }

    @Deprecated
    SoftwareKeyboardControllerCompat(WindowInsetsController r3) {
        this.mImpl = new Impl30((WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsController.class, "com.obric.memorydata.plugin"));
    }

    public void hide() {
        this.mImpl.hide();
    }

    public void show() {
        this.mImpl.show();
    }
}
