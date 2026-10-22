package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.block.presentation.BlockToolDetailFragment;
import com.larus.bmhome.chat.block.base.config.BlockDetailRequest;
import com.larus.utils.i0;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.m7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000e\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010'\u001a\u00020\u0014H\u0016J\u000e\u0010(\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010)\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\fH\u0016J\n\u00100\u001a\u0004\u0018\u00010\nH\u0016J\b\u00101\u001a\u00020\u0014H\u0002J\b\u00102\u001a\u00020\u0014H\u0002J\u0006\u00103\u001a\u00020\fJ\b\u00104\u001a\u00020\fH\u0002J\u0006\u00105\u001a\u00020\u0014J\b\u00106\u001a\u0004\u0018\u00010\bJ\n\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u00109\u001a\u00020\u0014H\u0002J\u0010\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020 H\u0002J\u0010\u0010<\u001a\u00020\u00142\u0006\u0010;\u001a\u00020 H\u0002J\u0010\u0010=\u001a\u00020\u00142\u0006\u0010&\u001a\u00020 H\u0002J\b\u0010>\u001a\u00020\u0014H\u0016J\u0010\u0010?\u001a\u00020\u00142\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020\u0014H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006D"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkDetailRootFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/larus/bmhome/chat/block/base/config/BlockDetailNavigationHost;", "<init>", "()V", "blockModel", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkBlockBizModel;", "titleText", "", "globalConfig", "Lcom/larus/bmhome/chat/block/base/config/GlobalConfig;", "hasReachedExpandedState", "", "childPageBackCallback", "com/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkDetailRootFragment$childPageBackCallback$1", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkDetailRootFragment$childPageBackCallback$1;", "childPageBackStackListener", "Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;", "onDismissCallback", "Lkotlin/Function0;", "", "getOnDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "getTheme", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "updateData", "showClarificationAnswerDetail", "interactionAskBlock", "Lcom/larus/im/bean/message/block/InteractionAskBlock;", "pushBlockDetail", "request", "Lcom/larus/bmhome/chat/block/base/config/BlockDetailRequest;", "popBlockDetail", "provideBlockDetailGlobalConfig", "setupBackStack", "showCotDetailPage", "popChildPage", "canPopChildPage", "dismissFromChild", "getCotTitle", "findCotDetailFragment", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkDetailFragment;", "setupBottomSheet", "dispatchBottomSheetChanged", "bottomSheet", "clearBottomSheetBackground", "setClipViewTopCornerRadius", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatingThinkDetailRootFragment extends BottomSheetDialogFragment implements kc8.c {
    public static final /* synthetic */ int j = 0;
    public g d;
    public kc8.y e;
    public boolean f;
    public final FloatingThinkDetailRootFragment$childPageBackCallback$1 g;
    public final v h;
    public Function0<Unit> i;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final kc8.y XK() {
        kc8.y r0 = this.e;
        if (r0 == null) goto L5;
        kc8.y.a r1 = r0.b();
        r1.C = this;
        return r1.a();
    L5:
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.FloatingThinkDetailRootFragment$childPageBackCallback$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.v] */
    public FloatingThinkDetailRootFragment() {
        this.g = new FloatingThinkDetailRootFragment$childPageBackCallback$1(this);
        this.h = new v(this);
    }

    public final boolean T90() {
        if (isAdded() == true) goto L6;
    L8:
        boolean r0 = false;
    L9:
        if (r0 == true) goto L11;
        return false;
    L11:
        getChildFragmentManager().popBackStack();
        return true;
    L6:
        if (getChildFragmentManager().getBackStackEntryCount() <= 0) goto L8;
        r0 = true;
        goto L9
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.d = null;
        this.e = null;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.f = false;
        getChildFragmentManager().removeOnBackStackChangedListener(this.h);
        setEnabled(false);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        BottomSheetDialog r0 = getDialog();
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r1 = r0;
    L6:
        if (r1 == null) goto L25;
        final View r2 = r1.findViewById(2131368870);
        if (r2 == null) goto L25;
        View r3 = r1.findViewById(2131367947);
        int r4 = m0.a;
        int r5 = m0.a(getContext());
        i0.a.getClass();
        int r6 = ((r5 - i0.g()) * 5) / 10;
        ViewGroup.LayoutParams r7 = r2.getLayoutParams();
        if (r7 == null) goto L14;
        r7.height = -1;
    L14:
        r2.setLayoutParams(r2.getLayoutParams());
        if (r3 == null) goto L24;
        ViewGroup.LayoutParams r8 = r3.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
    L20:
        int r10 = getResources().getDimensionPixelSize(v19.c.b(2130971163, null, 2131166696));
        if (r9 == null) goto L23;
        r9.topMargin = r10;
    L23:
        r3.setLayoutParams(r9);
        goto L24
    L19:
        r9 = null;
    L24:
        r2.setBackground(null);
        r2.setBackgroundColor(0);
        r1.setOnShowListener(new w(this, r2));
        BottomSheetBehavior r11 = BottomSheetBehavior.from(r2);
        r11.setPeekHeight(r6);
        r11.setState(4);
        r11.setSkipCollapsed(false);
        r2.setBackgroundResource(2131239081);
        r2.setOutlineProvider(new y(c7.b(16)));
        r2.setClipToOutline(true);
        r11.setBottomSheetCallback(new z(this, r11));
        r2.post(new x(this, r2));
    L25:
        Dialog r12 = getDialog();
        if (r12 == null) goto L31;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L32;
        m7.a(r13);
        return;
    L32:
        return;
    L31:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean rx() {
        return T90();
    }

    public final boolean FV(BlockDetailRequest r7) {
        Intrinsics.checkNotNullParameter(r7, "request");
        if (isAdded() == true) goto L5;
        return false;
    L5:
        if (getChildFragmentManager().isStateSaved() == false) goto L7;
        return false;
    L7:
        if (getChildFragmentManager().isDestroyed() == true) goto L18;
        FragmentTransaction r1 = getChildFragmentManager().beginTransaction();
        r1.setCustomAnimations(2130772410, 2130772411, 2130772409, 2130772412);
        int r2 = BlockToolDetailFragment.j;
        Intrinsics.checkNotNullParameter(r7, "request");
        BlockToolDetailFragment r0 = new BlockToolDetailFragment();
        r0.d = r7;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "BlockDetailFragment", 2131368894) == true) goto L13;
        r1.replace(2131368894, r0, "BlockDetailFragment");
    L13:
        r1.addToBackStack("floating_think_child_page");
        r1.commitAllowingStateLoss();
        setEnabled(true);
        return true;
    L18:
        return false;
    }

    public final void S90(View r3) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        m r0 = getChildFragmentManager().findFragmentById(2131368894);
        if ((r0 instanceof m) == false) goto L8;
        m r1 = r0;
    L9:
        if (r1 == null) goto L12;
        r1.BG(r3);
        return;
    L12:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void U90(g r5) {
        Intrinsics.checkNotNullParameter(r5, "blockModel");
        g r1 = this.d;
        if (r1 != null) goto L5;
    L11:
        this.d = r5;
        if (isAdded() == false) goto L17;
        Fragment r2 = getChildFragmentManager().findFragmentByTag("FloatingThinkCotDetailFragment");
        if ((r2 instanceof FloatingThinkDetailFragment) == false) goto L17;
        FloatingThinkDetailFragment r3 = (FloatingThinkDetailFragment) r2;
    L18:
        if (r3 == null) goto L23;
        Intrinsics.checkNotNullParameter(r5, "blockModel");
        r3.d = r5;
        r3.T90();
        return;
    L23:
        return;
    L17:
        r3 = null;
        goto L18
    L5:
        if (Intrinsics.areEqual(r1.j().getMessageId(), r5.j().getMessageId()) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r1.j().getConversationId(), r5.j().getConversationId()) == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(((jc8.a) r1).a.getBlockId(), ((jc8.a) r5).a.getBlockId()) == true) goto L11;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        final Context r3 = requireContext();
        return new AnonymousClass1(this, r3);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L8
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L8
        Function0<Unit> r3 = this.i;     // Catch: Throwable -> L8
        if (r3 == null) goto L5;
        r3.invoke();     // Catch: Throwable -> L8
    L5:
        this.i = null;     // Catch: Throwable -> L8
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        r4.setOutlineProvider(new y(c7.b(16)));
        r4.setClipToOutline(true);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), this.g);
        getChildFragmentManager().addOnBackStackChangedListener(this.h);
        if (r5 != null) goto L13;
        g r6 = this.d;
        if (r6 == null) goto L14;
        FragmentTransaction r7 = getChildFragmentManager().beginTransaction();
        int r0 = FloatingThinkDetailFragment.n;
        kc8.y r1 = this.e;
        Intrinsics.checkNotNullParameter(r6, "blockModel");
        FloatingThinkDetailFragment r2 = new FloatingThinkDetailFragment();
        r2.d = r6;
        r2.e = r1;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "FloatingThinkCotDetailFragment", 2131368894) == true) goto L11;
        r7.replace(2131368894, r2, "FloatingThinkCotDetailFragment");
    L11:
        r7.commitAllowingStateLoss();
        return;
    L14:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562367, r3, false);
    }
}
