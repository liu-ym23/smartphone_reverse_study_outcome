package com.bytedance.android.anniex.container.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.anniex.salamander.AbsPageAndPopup;
import com.bytedance.android.anniex.salamander.SLPopup;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.salamander.anniex.AnnieXBaseViewModel;
import com.bytedance.salamander.anniex.AnnieXCommonUIViewModel;
import com.bytedance.salamander.anniex.AnnieXPlatformviewKt;
import com.bytedance.salamander.anniex.AnnieXPopupViewKt;
import com.bytedance.salamander.anniex.AnnieXPopupViewModel;
import com.bytedance.salamander.anniex.a1;
import com.bytedance.salamander.anniex.c1;
import com.bytedance.salamander.anniex.g3;
import com.bytedance.salamander.anniex.r7;
import com.bytedance.salamander.anniex.t0;
import com.bytedance.salamander.anniex.w1;
import com.bytedance.salamander.anniex.z0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.relax.RelaxView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXSLDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/DialogInterface$OnShowListener;", "<init>", "()V", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXSLDialog extends DialogFragment implements DialogInterface.OnShowListener {
    public static final /* synthetic */ int h = 0;
    public AnnieXPopupViewModel d;
    public SLPopup e;
    public FrameLayout f;
    public final com.bytedance.android.anniex.salamander.a g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.anniex.container.ui.AnnieXSLDialog$onCreate$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass2(Object r10) {
            super(1, r10, AnnieXSLDialog.class, "updateBlockBackPress", "updateBlockBackPress(Z)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r10) {
            AnnieXSLDialog r0 = (AnnieXSLDialog) ((CallableReference) this).receiver;
            int r1 = AnnieXSLDialog.h;
            r0.S90(r10);
        }
    }

    static {
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r1) {
    }

    public AnnieXSLDialog() {
        int r0 = AbsPageAndPopup.t;
        this.g = new com.bytedance.android.anniex.salamander.a();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        SLPopup r0 = this.e;
        if (r0 == null) goto L5;
        r0.l();
    L5:
        this.e = null;
        List r1 = com.bytedance.ies.bullet.core.a.b;
        com.bytedance.android.anniex.salamander.a r10 = this.g;
        Intrinsics.checkNotNullParameter(r10, "appStateListener");
        List r11 = com.bytedance.ies.bullet.core.a.b;
        if (r11.contains(r10) == false) goto L9;
        r11.remove(r10);
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        AnnieXBaseViewModel r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPopupViewModel");
        r0 = null;
    L5:
        r0.a().a().e();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        AnnieXBaseViewModel r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPopupViewModel");
        r0 = null;
    L5:
        r0.a().a().d();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        SLPopup r0 = this.e;
        if (r0 == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        com.bytedance.android.anniex.salamander.c r1 = r0.w;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        r1.f = this;
        Dialog r10 = getDialog();
        if (r10 == null) goto L11;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L11;
        j r12 = new j(r11);
        r12.d();
        r1.e = r12;
    L11:
        AnnieXCommonUIViewModel r13 = this.d;
        AnnieXCommonUIViewModel r14 = null;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("slPopupViewModel");
        r13 = null;
    L14:
        w1 r15 = r13.m;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("_statusBarViewModel");
        r15 = null;
    L17:
        r15.update();
        AnnieXCommonUIViewModel r16 = this.d;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("slPopupViewModel");
    L21:
        S90(r14.e());
        Dialog r17 = getDialog();
        if (r17 == null) goto L25;
        r17.setOnKeyListener(new g(this));
        return;
    L25:
        return;
    L20:
        r14 = r16;
        goto L21
    }

    public final void onStop() {
        super.onStop();
    }

    public final void S90(boolean r10) {
        AnnieXCommonUIViewModel r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPopupViewModel");
        r0 = null;
    L5:
        r0.t(r10);
        setCancelable(!r10);
        Dialog r1 = getDialog();
        if (r1 == null) goto L9;
        r1.setCancelable(!r10);
        r1.setCanceledOnTouchOutside(!r10);
        return;
    }

    public final void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        if (getShowsDialog() == false) goto L8;
        Dialog r10 = getDialog();
        if (r10 == null) goto L9;
        r10.setOnShowListener(this);
        return;
    L9:
        return;
    }

    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r10);
        SLPopup r0 = this.e;
        if (r0 == null) goto L5;
        r0.j(r10);
    L5:
        AnnieXPopupViewModel r11 = this.d;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("slPopupViewModel");
        r11 = null;
    L8:
        r11.x();
    }

    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (this.e != null) goto L10;
        Bundle r0 = getArguments();
        if (r0 == null) goto L10;
        boolean r1 = r0.getBoolean("bundle_annie_x_flow", false);
        com.bytedance.android.anniex.base.builder.c r11 = new com.bytedance.android.anniex.base.builder.c();
        String r12 = r0.getString("bundle_annie_x_bid");
        if (r12 != null) goto L9;
        r12 = "default_bid";
    L9:
        r11.a(r12);
        r11.b(r0);
        r11.d(requireActivity());
        r11.i = r1;
        r11.c.putBoolean("bundle_annie_x_flow", r1);
        int r13 = SLPopup.y;
        SLPopup r14 = SLPopup.a.a(r11);
        this.e = r14;
        this.d = r14.n();
    L10:
        SLPopup r15 = this.e;
        if (r15 == null) goto L13;
        AnonymousClass2 r16 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r16, "blockBackPress");
        r15.o = r16;
    L13:
        SLPopup r17 = this.e;
        if (r17 == null) goto L16;
        r17.k(r10);
    L16:
        List r18 = com.bytedance.ies.bullet.core.a.b;
        com.bytedance.android.anniex.salamander.a r19 = this.g;
        Intrinsics.checkNotNullParameter(r19, "appStateListener");
        List r20 = com.bytedance.ies.bullet.core.a.b;
        if (r20.contains(r19) == true) goto L21;
        r20.add(r19);
        return;
    }

    public final Dialog onCreateDialog(Bundle r10) {
        SLPopup r0 = this.e;
        if (r0 == null) goto L13;
        ia.c r1 = r0.c();
        Dialog r11 = null;
        if ((r1 instanceof ua.d) == false) goto L7;
        ua.d r12 = (ua.d) r1;
    L8:
        if (r12 == null) goto L10;
        r11 = r12.h(r10);
    L10:
        r0.x = (AppCompatDialog) r11;
        if (r11 == null) goto L13;
        return r11;
    L7:
        r12 = null;
    L13:
        return super.onCreateDialog(r10);
    }

    public final void onDismiss(DialogInterface r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r10);     // Catch: Throwable -> L5
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

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        AnnieXBaseViewModel r0 = this.d;
        FrameLayout r12 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPopupViewModel");
        r0 = null;
    L5:
        r0.getClass();
        com.bytedance.salamander.anniex.l r13 = new com.bytedance.salamander.anniex.l(r0);
        g3 r1 = r0.a().a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("_engine");
        r1 = null;
    L8:
        r1.b(r13);
        int r14 = z0.a;
        AnnieXCommonUIViewModel r15 = this.d;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("slPopupViewModel");
        r15 = null;
    L11:
        FrameLayout r16 = this.f;
        if (r16 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L15:
        AnonymousClass1 r17 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r15, "viewModel");
        t0 r18 = r15.f().a();
        int r19 = c1.a;
        RelaxView r20 = c1.a.a(new r7(AnnieXPopupViewKt.a, new a1(r15), r18, r17));
        if (r12 == null) goto L19;
        if (r20 == null) goto L19;
        AnnieXPlatformviewKt.a.invoke(r12, r20);
    L19:
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type android.view.ViewGroup{ com.bytedance.salamander.anniex.AnnieXPlatformviewKt.AnnieXPlatformRootView }");
        SLPopup r21 = this.e;
        if (r21 == null) goto L23;
        r21.m(r10, r11);
        return;
    L23:
        return;
    L14:
        r12 = r16;
        goto L15
    }

    public final void show(FragmentManager r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        HybridLogger.m("AnnieXSLDialog", "===show()===", null, null, 12);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        if (r10.isDestroyed() == false) goto L6;
        return;
    L6:
        r10.beginTransaction().remove(this).commit();     // Catch: Throwable -> L13
        LandscapeRestrictionOperation r12 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L13
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r11, r12);     // Catch: Throwable -> L13
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, this, r12) == false) goto L22;
    L11:
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L24;
        HybridLogger r15 = HybridLogger.a;
        HybridLogger.i("AnnieXSLDialog", "===show error:" + r14.getMessage() + "===", null, 12);
        return;
    L24:
        return;
    L22:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19 Throwable -> L13
    L10:
        super.show(r10, r11);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        super/*androidx.fragment.app.Fragment*/.onCreateView(r10, r11, r12);
        View r13 = r10.inflate(2131558569, r11, false);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r14 = (FrameLayout) r13;
        this.f = r14;
        SLPopup r15 = this.e;
        if (r15 == null) goto L7;
        if (r14 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r14 = null;
    L6:
        Intrinsics.checkNotNullParameter(r14, "viewGroup");
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r15.j = r14;
    L7:
        FrameLayout r16 = this.f;
        if (r16 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    L11:
        return r16;
    }
}
