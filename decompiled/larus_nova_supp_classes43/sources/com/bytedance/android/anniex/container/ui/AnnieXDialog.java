package com.bytedance.android.anniex.container.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.reflect.Field;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/DialogInterface$OnShowListener;", "<init>", "()V", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXDialog extends DialogFragment implements DialogInterface.OnShowListener {
    public ia.f d;
    public View e;
    public final c f;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AnnieXDialog a;

        public b(AnnieXDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.a.isAdded() == true) goto L5;
            return;
        L5:
            if (this.a.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
            this.a.getParentFragmentManager().beginTransaction().remove(this.a).commitNowAllowingStateLoss();     // Catch: Throwable -> L8
            return;
        }
    }

    public static final class c extends ia.f.a {
        public final /* synthetic */ AnnieXDialog a;

        @Override // ia.j
        public final void a() {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // ia.j
        public final View b() {
            ia.f r0 = this.a.d;
            if (r0 != null) goto L7;
            return null;
        L7:
            return com.bytedance.android.anniex.container.util.e.a(r0);
        }

        @Override // ia.j
        public final View c() {
            ia.f r0 = this.a.d;
            if (r0 != null) goto L7;
            return null;
        L7:
            return com.bytedance.android.anniex.container.util.e.b(r0);
        }

        public c(AnnieXDialog r1) {
            this.a = r1;
        }

        @Override // ia.f.a
        public final Dialog g(Bundle r10) {
            return AnnieXDialog.T90(this.a, r10);
        }
    }

    static {
    }

    public AnnieXDialog() {
        this.f = new c(this);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ia.f r0 = this.d;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.d = null;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        ia.f r0 = this.d;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public final void onStop() {
        super.onStop();
        ia.f r0 = this.d;
        if (r0 == null) goto L6;
        r0.onStop();
        return;
    }

    public final void U90(DialogInterface r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        super.onDismiss(r10);
        ia.f r0 = this.d;
        if (r0 == null) goto L5;
        r0.onDismiss(r10);
    L5:
        Map r11 = x26.a.a;
        w26.g r12 = (w26.g) x26.a.a(w26.g.class);
        if (r12 == null) goto L12;
        w26.e r13 = (w26.e) r12.n0(w26.e.class);
        if (r13 == null) goto L12;
        Boolean r14 = r13.U0();
        if (r14 == null) goto L12;
        boolean r15 = r14.booleanValue();
    L13:
        if (r15 == false) goto L18;
        View r16 = getView();
        if (r16 == null) goto L19;
        r16.post(new b(this));
        return;
    L19:
        return;
    L18:
        return;
    L12:
        r15 = true;
        goto L13
    }

    public final void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        ia.f r0 = this.d;
        if (r0 == null) goto L6;
        r0.onActivityCreated(r10);
    L6:
        if (getShowsDialog() == false) goto L11;
        Dialog r11 = getDialog();
        if (r11 == null) goto L12;
        r11.setOnShowListener(this);
        return;
    L12:
        return;
    }

    public final void onAttach(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super.onAttach(r10);
        ia.f r11 = this.d;
        if (r11 == null) goto L6;
        r11.d(this.f);
        r11.o(this);
        return;
    }

    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r10);
        ia.f r0 = this.d;
        if (r0 == null) goto L6;
        r0.onConfigurationChanged(r10);
        return;
    }

    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (this.d != null) goto L33;
        Bundle r0 = getArguments();
        ia.f r1 = null;
        if (r0 == null) goto L30;
        boolean r11 = BulletSdk.a;
        BulletSdk.c(requireContext());
        boolean r12 = false;
        boolean r13 = r0.getBoolean("bundle_annie_x_flow", false);
        com.bytedance.android.anniex.base.builder.c r14 = new com.bytedance.android.anniex.base.builder.c();
        String r15 = r0.getString("bundle_annie_x_bid");
        if (r15 != null) goto L9;
        r15 = "default_bid";
    L9:
        r14.a(r15);
        r14.b(r0);
        r14.d(requireActivity());
        r14.i = r13;
        r14.c.putBoolean("bundle_annie_x_flow", r13);
        if (r13 == false) goto L12;
        r1 = new AnnieXFlowPopupContainer(r14);
        goto L30
    L12:
        com.bytedance.android.anniex.container.d r16 = new com.bytedance.android.anniex.container.d(r14);
        if (r10 != null) goto L15;
    L17:
        boolean r17 = false;
    L18:
        if (r17 == false) goto L29;
        Map r18 = x26.a.a;
        w26.g r19 = (w26.g) x26.a.a(w26.g.class);
        if (r19 == null) goto L25;
        w26.e r20 = (w26.e) r19.n0(w26.e.class);
        if (r20 == null) goto L25;
        r12 = Intrinsics.areEqual(r20.U1(), Boolean.FALSE);
    L25:
        if ((!r12) == false) goto L29;
        String r21 = r0.getString("__x_inner_schema");
        if (r21 == null) goto L29;
        r16.loadSchema(r21, null);
    L29:
        r1 = r16;
        goto L30
    L15:
        if (r10.getBoolean("on_recreate") != true) goto L17;
        r17 = true;
    L30:
        this.d = r1;
        if (r1 == null) goto L33;
        r1.d(this.f);
        r1.o(this);
    L33:
        ia.f r22 = this.d;
        if (r22 == null) goto L37;
        r22.onCreate(r10);
        return;
    }

    public final Dialog onCreateDialog(Bundle r10) {
        ia.f r0 = this.d;
        if (r0 == null) goto L7;
        Dialog r1 = r0.h(r10);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return super.onCreateDialog(r10);
    }

    public final void onDismiss(DialogInterface r10) {
        U90(r10);     // Catch: Throwable -> L5
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

    public final void onSaveInstanceState(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "outState");
        super.onSaveInstanceState(r10);
        r10.putBoolean("on_recreate", true);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r10) {
        ia.f r0 = this.d;
        if (r0 == null) goto L6;
        r0.onShow(r10);
        return;
    }

    public final void setUserVisibleHint(boolean r10) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r10);
        ia.f r0 = this.d;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r10);
        return;
    }

    public static final Dialog T90(AnnieXDialog r0, Bundle r1) {
        return super.onCreateDialog(r1);
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        ia.f r0 = this.d;
        if (r0 == null) goto L5;
        r0.b(r10, r11);
    L5:
        Bundle r12 = getArguments();
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.getBoolean("bundle_annie_x_flow", false) == false) goto L16;
        String r13 = r12.getString("__x_inner_schema");
        if (r13 == null) goto L17;
        ia.f r14 = this.d;
        if (r14 == null) goto L18;
        r14.loadSchema(r13, null);
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void show(FragmentManager r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        HybridLogger.m("AnnieXDialog", "===show()===", null, null, 12);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L22
        if (r10.isDestroyed() == false) goto L7;
        return;
    L7:
        if (com.bytedance.ies.bullet.service.base.h.v() == true) goto L10;
        r10.beginTransaction().remove(this).commit();     // Catch: Throwable -> L22
        S90(this, r10, r11);     // Catch: Throwable -> L22
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L22
    L24:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L30;
        HybridLogger r15 = HybridLogger.a;
        HybridLogger.i("AnnieXDialog", "===show error:" + r14.getMessage() + "===", null, 12);
        return;
    L30:
        return;
    L10:
        if (isAdded() == false) goto L13;
        r10.beginTransaction().remove(this).commit();     // Catch: Throwable -> L22
    L13:
        if (r10.isStateSaved() == true) goto L15;
        S90(this, r10, r11);     // Catch: Throwable -> L22
        r12 = Unit.INSTANCE;     // Catch: Throwable -> L22
        goto L20
    L15:
        Field r16 = DialogFragment.class.getDeclaredField("mDismissed");     // Catch: Throwable -> L22
        r16.setAccessible(true);     // Catch: Throwable -> L22
        r16.set(this, Boolean.FALSE);     // Catch: Throwable -> L22
        Field r17 = DialogFragment.class.getDeclaredField("mShownByMe");     // Catch: Throwable -> L22
        r17.setAccessible(true);     // Catch: Throwable -> L22
        r17.set(this, Boolean.TRUE);     // Catch: Throwable -> L22
        FragmentTransaction r18 = r10.beginTransaction();     // Catch: Throwable -> L22
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r18, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r11, 0) == true) goto L19;
        r18 = r18.add(this, r11);     // Catch: Throwable -> L22
    L19:
        r12 = Integer.valueOf(r18.commitAllowingStateLoss());     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }

    public static void S90(DialogFragment r10, FragmentManager r11, String r12) {
        if ((r10 instanceof Fragment) == false) goto L5;
        DialogFragment r0 = r10;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r12, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        super.show(r11, r12);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        super/*androidx.fragment.app.Fragment*/.onCreateView(r10, r11, r12);
        View r13 = r10.inflate(2131558562, r11, false);
        this.e = r13;
        ia.f r14 = this.d;
        if (r14 == null) goto L5;
        r14.a(r13);
    L5:
        Dialog r15 = getDialog();
        if (r15 == null) goto L9;
        r15.setOnKeyListener(new com.bytedance.android.anniex.container.ui.a(this));
    L9:
        return this.e;
    }
}
