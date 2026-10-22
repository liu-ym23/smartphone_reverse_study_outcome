package com.bytedance.android.live.ktv.common.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.KtvRoomFeedbackGuideDialog;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseKtvDialogFragment extends LiveDialogFragment {
    public BaseKtvDialogFragment d;
    public boolean e;
    public View f;

    public static final class a implements LiveBottomSheetDialog.m {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public abstract String S90();

    public View getContentView() {
        return null;
    }

    public abstract int getLayoutId();

    public void V90() {
        BaseKtvDialogFragment r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    L10:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        r0 = null;
    L15:
        if (r0 == null) goto L19;
        r0.e = true;
        r0.U90(getContext());
        this.d = null;
        return;
    L19:
        return;
    L7:
        if (this.e == false) goto L10;
        r1 = false;
        goto L12
    }

    public BaseKtvDialogFragment() {
        this.e = true;
        setNoTitleAndCancelOutside(true);
    }

    public final void T90() {
        Dialog r0 = getDialog();
        Context r1 = getContext();
        if (r0 == null) goto L19;
        if (r1 == null) goto L22;
        Dialog r2 = getDialog();
        if (r2 == null) goto L21;
        View r3 = r2.getCurrentFocus();
        if (r3 == null) goto L23;
        Object r4 = r1.getSystemService("input_method");
        if (r4 == null) goto L18;
        InputMethodManager r5 = (InputMethodManager) r4;
        if (r5.isActive() == false) goto L20;
        r5.hideSoftInputFromWindow(r3.getWindowToken(), 0);
        return;
    L20:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L23:
        return;
    L21:
        return;
    L22:
        return;
    }

    public final boolean onBackPressed() {
        Activity r0 = ContextUtil.contextToActivity(getContext());
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getSystemService("input_method");
    L7:
        if ((r2 instanceof InputMethodManager) == false) goto L10;
        r1 = r2;
    L10:
        InputMethodManager r3 = (InputMethodManager) r1;
        if (r3 != null) goto L13;
    L22:
        dismissAllowingStateLoss();     // Catch: Exception -> L17
        return true;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L25;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return true;
    L25:
        return true;
    L13:
        if (r3.isActive() != true) goto L22;
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void U90(Context r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
        r3 = null;
    L5:
        FragmentActivity r4 = (FragmentActivity) r3;
        if (r4 == null) goto L18;
        FragmentManager r5 = r4.getSupportFragmentManager();
        if (r5 == null) goto L19;
        String r0 = S90();
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r0, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, this, r1) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        show(r5, r0);
        return;
    L20:
        return;
    L19:
        return;
    }

    public void onActivityCreated(Bundle r4) {
        super.onActivityCreated(r4);
        Dialog r5 = getDialog();
        if (r5 == null) goto L7;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L7;
        r6.setLayout(-1, -1);
        WindowManager.LayoutParams r0 = r6.getAttributes();
        r0.height = s1.w() - s1.A();
        r6.setAttributes(r0);
        r6.setGravity(80);
        r6.clearFlags(RomUtils.SZ);
        r6.setAttributes(r6.getAttributes());
    L7:
        setBottomSheetSlideProcessor(a.a);
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        T90();
        this.d = null;
        super.onCancel(r2);
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954699);
    }

    public void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        T90();     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        V90();     // Catch: Throwable -> L5
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

    public final void W90(Context r2, KtvRoomFeedbackGuideDialog r3, boolean r4) {
        if (r3 == null) goto L4;
        r3.e = false;
    L4:
        if (r4 == false) goto L12;
        if (r3 == null) goto L12;
        r3.dismiss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L12;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L12:
        this.d = r3;
        U90(r2);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = getContentView();
        if (r5 != null) goto L5;
        r5 = r2.inflate(getLayoutId(), r3, false);
    L5:
        this.f = r5;
        return r5;
    }
}
