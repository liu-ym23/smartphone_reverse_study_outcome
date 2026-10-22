package com.bytedance.android.live.openplatform.impl.base.view;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.livesdk.e;
import com.bytedance.android.livesdk.f;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/view/OpenPlatformBottomDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OpenPlatformBottomDialog extends DialogFragment {
    public final void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4
    L8:
        e.b().d();
        f.d().f();
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L8;
        d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    public OpenPlatformBottomDialog() {
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setGravity(80);
        r5.setLayout(-1, -2);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.getAttributes().windowAnimations = 2131954752;
        return;
    L9:
        return;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.requestWindowFeature(1);
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void show(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        if (isAdded() == false) goto L5;
        return;
    L5:
        e.b().a();
        f.d().a();
        FragmentTransaction r5 = r3.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == true) goto L9;
        r5.add(this, r4);
    L9:
        r5.commitAllowingStateLoss();
    }
}
