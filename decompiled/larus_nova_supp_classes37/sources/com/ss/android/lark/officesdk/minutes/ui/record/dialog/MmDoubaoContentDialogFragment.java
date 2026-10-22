package com.ss.android.lark.officesdk.minutes.ui.record.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentManager;
import bwb.b;
import com.bytedance.crash.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmPanelHeightConfig;
import com.ss.android.lark.officesdk.minutes.ui.foundation.dialog.MmPanelFragmentArgs;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rub.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010!\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\"\u001a\u0004\u0018\u00010\u00112\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010+\u001a\u00020\u0014H\u0016J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0005H\u0002J\b\u00101\u001a\u00020\u0014H\u0002J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/dialog/MmDoubaoContentDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "registryTag", "", "heightConfig", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;", "drawBehindNavigationBar", "", "backgroundConfig", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelBackgroundConfig;", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "contentViewProvider", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroid/view/View;", "onDismissCallback", "Lkotlin/Function0;", "", "onShowCallback", "isInvalidRestore", "hasCalledOnDismiss", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "configureNavigationBar", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "bottomSheet", "Landroid/widget/FrameLayout;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "dismissAllowingStateLoss", "onDismiss", "Landroid/content/DialogInterface;", "restoreFromRegistry", "dismissInvalidPanel", "reason", "notifyDismiss", "resolveDialogBackground", "Landroid/graphics/drawable/Drawable;", "context", "officesdk-minutes-doubao-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmDoubaoContentDialogFragment extends BottomSheetDialogFragment {
    public String d;
    public MmPanelHeightConfig e;
    public boolean f;
    public c g;
    public MmRecordingUILaunchMode h;
    public Function1<? super Context, ? extends View> i;
    public Function0<Unit> j;
    public Function0<Unit> k;
    public boolean l;
    public boolean m;

    public static final class a implements DialogInterface.OnShowListener {
        public final /* synthetic */ MmDoubaoContentDialogFragment a;
        public final /* synthetic */ BottomSheetDialog b;

        public a(MmDoubaoContentDialogFragment r1, BottomSheetDialog r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r13) {
            if (this.a.l == false) goto L5;
            return;
        L5:
            FrameLayout r14 = (FrameLayout) this.b.findViewById(2131368870);
            if (r14 != null) goto L8;
        L51:
            Function0<Unit> r15 = this.a.k;
            if (r15 == null) goto L55;
            r15.invoke();
            return;
        L55:
            return;
        L8:
            if (this.a.f == false) goto L22;
            BottomSheetDialog r0 = this.b;
            Window r2 = r0.getWindow();
            if (r2 == null) goto L22;
            View r3 = r0.findViewById(2131367728);
            if (r3 == null) goto L22;
            WindowCompat.setDecorFitsSystemWindows(r2, false);
            r2.setNavigationBarColor(0);
            if (Build.VERSION.SDK_INT < 29) goto L18;
            r2.setNavigationBarContrastEnforced(false);
        L18:
            r3.setFitsSystemWindows(false);
            View r1 = r0.findViewById(2131367947);
            if (r1 == null) goto L21;
            r1.setFitsSystemWindows(false);
        L21:
            r14.setFitsSystemWindows(false);
            ViewCompat.setOnApplyWindowInsetsListener(r3, new cwb.a(r14));
            ViewCompat.requestApplyInsets(r3);
        L22:
            r14.setBackground(null);
            MmDoubaoContentDialogFragment r4 = this.a;
            Context r5 = com.ss.android.lark.officesdk.minutes.ui.style.c.c(r4.requireContext(), this.a.h);
            c r6 = r4.g;
            if ((r6 instanceof c.a) == false) goto L26;
            Drawable r7 = (Drawable) ((c.a) r6).a.invoke(r5);
        L31:
            r14.setBackground(r7);
            BottomSheetBehavior r8 = BottomSheetBehavior.from(r14);
            r8.setHideable(false);
            MmDoubaoContentDialogFragment r9 = this.a;
            MmPanelHeightConfig r10 = r9.e;
            if ((r10 instanceof MmPanelHeightConfig.ScreenTopMargin) == false) goto L39;
            int r11 = UIUtils.getScreenHeight(r9.getContext());
            MmPanelHeightConfig.ScreenTopMargin r12 = (MmPanelHeightConfig.ScreenTopMargin) r10;
            int r16 = r11 - r12.getMarginPx();
            r8.setPeekHeight(r16);
            if (r12.isExpanded() == false) goto L36;
            ViewGroup.LayoutParams r17 = r14.getLayoutParams();
            r17.height = r16;
            r14.setLayoutParams(r17);
            r8.setState(3);
        L37:
            int r18 = b.a;
            b.g(MmUiLogScene.OVERLAY, "onCreateDialog", "screenHeight=" + r11 + ", targetHeight=" + r16 + ", isExpanded=" + r12.isExpanded(), null, 8);
            goto L51
        L36:
            r8.setState(4);
            goto L37
        L39:
            if ((r10 instanceof MmPanelHeightConfig.Fixed) == false) goto L45;
            MmPanelHeightConfig.Fixed r19 = (MmPanelHeightConfig.Fixed) r10;
            int r20 = r19.getHeightPx();
            r8.setPeekHeight(r20);
            if (r19.isExpanded() == false) goto L43;
            ViewGroup.LayoutParams r21 = r14.getLayoutParams();
            r21.height = r20;
            r14.setLayoutParams(r21);
            r8.setState(3);
        L44:
            int r110 = b.a;
            b.g(MmUiLogScene.OVERLAY, "onCreateDialog", "config.heightPx=" + r19.getHeightPx() + ", isExpanded=" + r19.isExpanded(), null, 8);
            goto L51
        L43:
            r8.setState(4);
            goto L44
        L45:
            if (r10 != null) goto L48;
            r8.setState(3);
            r8.setSkipCollapsed(true);
            goto L51
        L48:
            throw new NoWhenBranchMatchedException();
        L26:
            if (Intrinsics.areEqual(r6, c.b.a) == false) goto L29;
            int r22 = jwb.a.a;
            Intrinsics.checkNotNullParameter(r5, "context");
            int r23 = jwb.a.a(r5);
            int r24 = zvb.a.b;
            r7 = zvb.a.C0209a.d(r5, 2131102029, Integer.valueOf(r23), Integer.valueOf(r23), null, null, 240);
            goto L31
        L29:
            if (Intrinsics.areEqual(r6, c.C0185c.a) == false) goto L50;
            r7 = null;
            goto L31
        L50:
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void dismissAllowingStateLoss() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        super/*androidx.fragment.app.DialogFragment*/.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L11
    L9:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public MmDoubaoContentDialogFragment() {
        this.g = c.b.a;
        this.h = MmRecordingUILaunchMode.UNKNOWN;
    }

    public final void S90(String r5) {
        this.l = true;
        int r1 = b.a;
        b.d(MmUiLogScene.OVERLAY, "onCreate", "dismiss invalid panel: " + r5, null);
        if (this.m == true) goto L18;
        this.m = true;
        Function0<Unit> r6 = this.j;
        if (r6 == null) goto L8;
        r6.invoke();
    L8:
        String r7 = this.d;
        if (r7 == null) goto L18;
        ConcurrentHashMap<String, vvb.a.C0201a> r0 = vvb.a.a;
        Intrinsics.checkNotNullParameter(r7, "tag");
        vvb.a.a.remove(r7);
    L18:
        dismissAllowingStateLoss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L20;
        d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        MmPanelFragmentArgs.a r4 = MmPanelFragmentArgs.Companion;
        Bundle r0 = getArguments();
        r4.getClass();
        MmPanelFragmentArgs r5 = null;
        if (r0 == null) goto L5;
        Serializable r1 = r0.getSerializable("key_mm_panel_fragment_args");
    L7:
        if ((r1 instanceof MmPanelFragmentArgs) == false) goto L9;
        r5 = (MmPanelFragmentArgs) r1;
    L9:
        if (r5 != null) goto L12;
        S90("missing panel args");
        return;
    L12:
        this.d = r5.getRegistryTag();
        this.e = r5.getHeightConfig();
        this.f = r5.getDrawBehindNavigationBar();
        MmRecordingUILaunchMode r6 = r5.getUiLaunchMode();
        if (r6 != null) goto L15;
        r6 = MmRecordingUILaunchMode.UNKNOWN;
    L15:
        this.h = r6;
        if (r6.shouldHandleUI() == true) goto L19;
        S90("invalid uiLaunchMode=" + this.h);
        return;
    L19:
        e r7 = e.a;
        MmRecordingUILaunchMode r2 = this.h;
        r7.getClass();
        if (e.c(r2) != null) goto L23;
        S90("missing provider, uiLaunchMode=" + this.h);
        return;
    L23:
        String r8 = this.d;
        if (r8 == null) goto L30;
        ConcurrentHashMap<String, vvb.a.C0201a> r9 = vvb.a.a;
        Intrinsics.checkNotNullParameter(r8, "tag");
        vvb.a.C0201a r10 = vvb.a.a.get(r8);
        if (r10 == null) goto L30;
        this.i = r10.a;
        this.j = r10.b;
        this.k = r10.c;
        this.g = r10.d;
    L30:
        if (this.i != null) goto L33;
        S90("missing content provider, registryTag=" + this.d);
        return;
    L33:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final Dialog onCreateDialog(Bundle r2) {
        BottomSheetDialog r3 = super.onCreateDialog(r2);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetDialog r4 = r3;
        r4.setOnShowListener(new a(this, r4));
        return r4;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L13
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L13
        if (this.m == true) goto L11;
        this.m = true;     // Catch: Throwable -> L13
        Function0<Unit> r3 = this.j;     // Catch: Throwable -> L13
        if (r3 == null) goto L8;
        r3.invoke();     // Catch: Throwable -> L13
    L8:
        String r4 = this.d;     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        ConcurrentHashMap<String, vvb.a.C0201a> r0 = vvb.a.a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r4, "tag");     // Catch: Throwable -> L13
        vvb.a.a.remove(r4);     // Catch: Throwable -> L13
    L11:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L13:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void show(FragmentManager r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "manager");
        if (r4.isStateSaved() == true) goto L9;
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r5, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, this, r0) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L8:
        super/*androidx.fragment.app.DialogFragment*/.show(r4, r5);
        return;
    L15:
        return;
    L9:
        int r6 = b.a;
        b.g(MmUiLogScene.OVERLAY, "show", "show " + r5 + ", fragment state saved, skip show", null, 8);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        if (this.l == true) goto L5;
        Function1<? super Context, ? extends View> r4 = this.i;
        if (r4 != null) goto L11;
        return null;
    L11:
        return (View) r4.invoke(com.ss.android.lark.officesdk.minutes.ui.style.c.c(requireContext(), this.h));
    L5:
        return new View(r1.getContext());
    }
}
