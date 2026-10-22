package com.ss.android.lark.lynxkit.host;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tqb.d;
import tqb.e;
import tqb.f;
import tqb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020\u0012H\u0002J \u0010&\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020\u0012H\u0002J\b\u0010,\u001a\u00020\u0012H\u0002J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostController;", "<init>", "()V", "hostId", "", "entry", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostEntry;", "container", "Lcom/ss/android/lark/lynxkit/container/ILarkLynxContainer;", "rootView", "Landroid/widget/FrameLayout;", "loadingView", "Landroid/view/View;", "closeNotified", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onStop", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onDestroyView", "onDestroy", "applyWindowAttributes", "attachContainer", "lynxContainer", "params", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostParams;", "showLoading", "hideLoading", "handleBackPressed", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "source", "Lcom/ss/android/lark/lynxkit/host/LarkLynxCloseSource;", "notifyClose", "shouldRenderOnCreate", "hostEntry", "Companion", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxDialogFragment extends DialogFragment implements tqb.c {
    public static final /* synthetic */ int j = 0;
    public String d;
    public d e;
    public ILarkLynxContainer f;
    public FrameLayout g;
    public View h;
    public boolean i;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public final /* synthetic */ LarkLynxDialogFragment a;

        public b(LarkLynxDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r3, int r4, KeyEvent r5) {
            boolean r0 = false;
            if (r4 == 4) goto L5;
            return false;
        L5:
            if (r5.getAction() != 1) goto L23;
            LarkLynxDialogFragment r6 = this.a;
            ILarkLynxContainer r7 = r6.f;
            if (r7 == null) goto L20;
            d r1 = r6.e;
            if (r1 == null) goto L17;
            LarkLynxHostOptions r2 = r1.b;
            if (r2 == null) goto L17;
            LarkLynxBackPressedHandler r8 = r2.getBackPressedHandler();
            if (r8 == null) goto L17;
            if (r8.onBackPressed(r7) != true) goto L17;
            boolean r9 = true;
        L18:
            if (r9 == false) goto L20;
            r0 = true;
        L17:
            r9 = false;
        L20:
            if (r0 == true) goto L23;
            r6.T90(LarkLynxCloseSource.BACK);
            LarkLynxDialogFragment.S90(r6);
        L23:
            return true;
        }
    }

    public static final class c implements e {
        public final /* synthetic */ LarkLynxDialogFragment a;
        public final /* synthetic */ FrameLayout b;
        public final /* synthetic */ d c;

        @Override // tqb.e
        public final void a() {
            LarkLynxDialogFragment r0 = this.a;
            View r1 = r0.h;
            if (r1 == null) goto L10;
            ViewParent r3 = r1.getParent();
            if ((r3 instanceof ViewGroup) == false) goto L7;
            ViewGroup r4 = (ViewGroup) r3;
        L8:
            if (r4 == null) goto L10;
            r4.removeView(r1);
            goto L10
        L7:
            r4 = null;
        L10:
            r0.h = null;
        }

        @Override // tqb.e
        public final void onLoadStart() {
            LarkLynxDialogFragment r0 = this.a;
            FrameLayout r1 = this.b;
            LarkLynxHostParams r2 = this.c.a;
            int r3 = LarkLynxDialogFragment.j;
            r0.U90(r1, r2);
        }

        public c(LarkLynxDialogFragment r1, FrameLayout r2, d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final void onDestroy() {
        d r0 = this.e;
        if (r0 == null) goto L7;
        g r1 = r0.d;
        if (r1 == null) goto L7;
        r1.b(this);
    L7:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void onDestroyView() {
        ILarkLynxContainer r0 = this.f;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.isChangingConfigurations() != true) goto L7;
    L8:
        if (r2 == false) goto L10;
    L12:
        if (r0 == null) goto L26;
        d r3 = this.e;
        if (r3 == null) goto L18;
        g r4 = r3.d;
        if (r4 == null) goto L18;
        r4.a(r0);
    L18:
        d r5 = this.e;
        if (r5 == null) goto L25;
        LarkLynxHostOptions r6 = r5.b;
        if (r6 == null) goto L25;
        LarkLynxHostLifecycleCallback r7 = r6.getLifecycleCallback();
        if (r7 == null) goto L25;
        r7.onDestroy(r0);
    L25:
        r0.destroy();
    L26:
        this.f = null;
        this.g = null;
        this.h = null;
        if (r2 == true) goto L33;
        ConcurrentHashMap<String, d> r8 = f.a;
        f.c(this.d);
        d r9 = this.e;
        if (r9 == null) goto L33;
        g r10 = r9.d;
        if (r10 == null) goto L33;
        r10.d();
    L33:
        super.onDestroyView();
        return;
    L10:
        if (this.i == true) goto L12;
        T90(LarkLynxCloseSource.PROGRAMMATIC);
    L7:
        r2 = false;
        goto L8
    }

    public final void onStop() {
        ILarkLynxContainer r0 = this.f;
        if (r0 == null) goto L11;
        r0.hide();
        d r1 = this.e;
        if (r1 == null) goto L11;
        LarkLynxHostOptions r2 = r1.b;
        if (r2 == null) goto L11;
        LarkLynxHostLifecycleCallback r3 = r2.getLifecycleCallback();
        if (r3 == null) goto L11;
        r3.onHide(r0);
    L11:
        super.onStop();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        d r0 = this.e;
        if (r0 == null) goto L14;
        Dialog r1 = getDialog();
        if (r1 == null) goto L14;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L14;
        r2.setSoftInputMode(r0.b.getSoftInputMode());
        r2.setWindowAnimations(2131952431);
        WindowManager.LayoutParams r3 = r2.getAttributes();
        if (r3 != null) goto L13;
        r3 = new WindowManager.LayoutParams();
    L13:
        r3.width = r0.b.getDialogWidth();
        r3.height = r0.b.getDialogHeight();
        r3.gravity = r0.b.getDialogGravity();
        r3.dimAmount = r0.b.getDialogDimAmount();
        r2.setAttributes(r3);
        r2.addFlags(2);
    L14:
        ILarkLynxContainer r4 = this.f;
        if (r4 == null) goto L24;
        r4.show();
        d r5 = this.e;
        if (r5 == null) goto L25;
        LarkLynxHostOptions r6 = r5.b;
        if (r6 == null) goto L26;
        LarkLynxHostLifecycleCallback r7 = r6.getLifecycleCallback();
        if (r7 == null) goto L27;
        r7.onShow(r4);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }

    public LarkLynxDialogFragment() {
    }

    public static void S90(LarkLynxDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // tqb.c
    public final void K40(LarkLynxCloseSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        T90(r2);
        S90(this);
    }

    public final void T90(LarkLynxCloseSource r4) {
        if (this.i == true) goto L19;
        FragmentActivity r0 = getActivity();
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == true) goto L23;
        this.i = true;
        d r2 = this.e;
        if (r2 == null) goto L20;
        LarkLynxHostOptions r3 = r2.b;
        if (r3 == null) goto L21;
        LarkLynxHostCloseCallback r5 = r3.getCloseCallback();
        if (r5 == null) goto L22;
        r5.onClose(r4);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L23:
        return;
    L7:
        if (r0.isChangingConfigurations() != true) goto L9;
        r1 = true;
        goto L9
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        T90(LarkLynxCloseSource.CANCEL);
        super.onCancel(r2);
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        boolean r4 = true;
        setStyle(1, 2131952432);
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("extra_lynx_host_id");
    L6:
        this.d = r1;
        ConcurrentHashMap<String, d> r2 = f.a;
        d r5 = f.a(r1);
        this.e = r5;
        if (r5 == null) goto L11;
        LarkLynxHostOptions r6 = r5.b;
        if (r6 == null) goto L11;
        r4 = r6.getDialogCancelable();
    L11:
        setCancelable(r4);
        d r7 = this.e;
        if (r7 == null) goto L17;
        g r8 = r7.d;
        if (r8 == null) goto L18;
        r8.c(this);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = new Dialog(requireContext(), getTheme());
        d r0 = this.e;
        if (r0 == null) goto L7;
        LarkLynxHostOptions r1 = r0.b;
        if (r1 == null) goto L7;
        boolean r2 = r1.getDialogCanceledOnTouchOutside();
    L8:
        r4.setCanceledOnTouchOutside(r2);
        r4.setOnKeyListener(new b(this));
        return r4;
    L7:
        r2 = true;
        goto L8
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        T90(LarkLynxCloseSource.DISMISS);     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void U90(FrameLayout r4, LarkLynxHostParams r5) {
        if (r5.getShowLoading() == true) goto L5;
        return;
    L5:
        if (this.h != null) goto L10;
        ProgressBar r6 = new ProgressBar(requireContext());
        r4.addView(r6, new FrameLayout.LayoutParams(-2, -2, 17));
        this.h = r6;
        return;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        d r8 = this.e;
        if (r8 != null) goto L5;
        return;
    L5:
        FrameLayout r9 = this.g;
        if (r9 != null) goto L8;
        return;
    L8:
        c r0 = new c(this, r9, r8);
        int r1 = tqb.b.a;     // Catch: Throwable -> L32
        ILarkLynxContainer r2 = tqb.b.a(requireContext(), r8.a, r8.b, r0);     // Catch: Throwable -> L32
        this.f = r2;     // Catch: Throwable -> L32
        g r3 = r8.d;     // Catch: Throwable -> L32
        if (r3 == null) goto L12;
        r3.e(r2);     // Catch: Throwable -> L32
    L12:
        LarkLynxHostParams r4 = r8.a;     // Catch: Throwable -> L32
        View r5 = r2.getLynxView();     // Catch: Throwable -> L32
        ViewParent r10 = r5.getParent();     // Catch: Throwable -> L32
        if ((r10 instanceof ViewGroup) == false) goto L15;
        ViewGroup r11 = (ViewGroup) r10;     // Catch: Throwable -> L32
    L16:
        if (r11 == null) goto L18;
        r11.removeView(r5);     // Catch: Throwable -> L32
    L18:
        ViewGroup.LayoutParams r12 = r4.getLayoutParams();     // Catch: Throwable -> L32
        if (r12 != null) goto L21;
        r12 = new FrameLayout.LayoutParams(-1, -1);     // Catch: Throwable -> L32
    L21:
        r9.addView(r5, r12);     // Catch: Throwable -> L32
        g r13 = r8.d;     // Catch: Throwable -> L32
        if (r13 == null) goto L24;
        boolean r14 = r13.f();     // Catch: Throwable -> L32
    L26:
        if (r8.a.getShowLoading() == false) goto L29;
        if (r14 == false) goto L29;
        U90(r9, r8.a);     // Catch: Throwable -> L32
    L29:
        if (r14 == false) goto L37;
        tqb.b.c(r2, r8.a);     // Catch: Throwable -> L32
        return;
    L37:
        return;
    L24:
        r14 = r8.c;     // Catch: Throwable -> L32
        goto L26
    L15:
        r11 = null;
    L32:
        th = move-exception;
        Log.e("LynxDialogFragment", "create lynx dialog host failed", th);
        S90(this);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        d r4 = this.e;
        if (r4 != null) goto L6;
        Log.e("LynxDialogFragment", "onCreateView failed, host entry not found");
        S90(this);
        return new FrameLayout(requireContext());
    L6:
        FrameLayout r5 = new FrameLayout(requireContext());
        Integer r6 = r4.a.getContainerBackgroundColor();
        if (r6 == null) goto L9;
        int r7 = r6.intValue();
    L10:
        r5.setBackgroundColor(r7);
        this.g = r5;
        return r5;
    L9:
        r7 = 0;
        goto L10
    }
}
