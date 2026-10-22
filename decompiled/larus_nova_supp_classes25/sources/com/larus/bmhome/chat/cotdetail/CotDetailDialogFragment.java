package com.larus.bmhome.chat.cotdetail;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.crash.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.bmhome.block.presentation.BlockToolDetailFragment;
import com.larus.bmhome.chat.block.base.config.BlockDetailRequest;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.FloatingThinkDetailFragment;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.g;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.u;
import com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kc8.c;
import kc8.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000±\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0007\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001KB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0016\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'J\"\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.J\u001a\u0010/\u001a\u00020!2\u0006\u00100\u001a\u0002012\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00102\u001a\u00020!2\u0006\u00100\u001a\u000201H\u0016J\u0018\u00103\u001a\u00020!2\u0006\u00104\u001a\u0002052\u0006\u0010&\u001a\u00020'H\u0002J\b\u00106\u001a\u00020!H\u0016J\n\u00107\u001a\u0004\u0018\u00010,H\u0016J\b\u00108\u001a\u00020\u001eH\u0016J\u001e\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u00182\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00180<H\u0014J$\u0010=\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010:\u001a\u0004\u0018\u00010\u00182\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020BH\u0002J\u001a\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020\u001eH\u0016R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006L"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/CotDetailDialogFragment;", "Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "Lcom/larus/bmhome/chat/block/base/config/BlockDetailNavigationHost;", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkDetailNavigationHost;", "<init>", "()V", "childPageBackCallback", "com/larus/bmhome/chat/cotdetail/CotDetailDialogFragment$childPageBackCallback$1", "Lcom/larus/bmhome/chat/cotdetail/CotDetailDialogFragment$childPageBackCallback$1;", "childPageBackStackListener", "Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;", "roundedBottomSheetThemeRes", "", "getRoundedBottomSheetThemeRes", "()I", "roundedBottomSheetBackgroundRes", "getRoundedBottomSheetBackgroundRes", "roundedBottomSheetTopCornerRadius", "getRoundedBottomSheetTopCornerRadius", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "pushBlockDetail", "", "request", "Lcom/larus/bmhome/chat/block/base/config/BlockDetailRequest;", "pushCotDetail", "arguments", "tag", "", "pushClarificationAnswerDetail", "interactionAskBlock", "Lcom/larus/im/bean/message/block/InteractionAskBlock;", "globalConfig", "Lcom/larus/bmhome/chat/block/base/config/GlobalConfig;", "message", "Lcom/larus/im/bean/message/Message;", "pushFloatingThinkDetail", "blockModel", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkBlockBizModel;", "updateFloatingThinkDetail", "pushChildPage", "fragment", "Landroidx/fragment/app/Fragment;", "popBlockDetail", "provideBlockDetailGlobalConfig", "onStart", "onRoundedBottomSheetReady", "bottomSheet", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "setupOutsideTouchDismiss", "bottomSheetDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "setupTransparentNavigationBar", "window", "Landroid/view/Window;", "isTouchInsideView", "event", "Landroid/view/MotionEvent;", "targetView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CotDetailDialogFragment extends RoundedBottomSheetDialogFragment implements c, u {
    public static final /* synthetic */ int f = 0;
    public final CotDetailDialogFragment$childPageBackCallback$1 d;
    public final ee8.c e;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ CotDetailDialogFragment a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(CotDetailDialogFragment r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 == 5) goto L12;
            return;
        L12:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L15;
            d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public final int S90() {
        return 2131240187;
    }

    public final int T90() {
        return 2131952451;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.bmhome.chat.cotdetail.CotDetailDialogFragment$childPageBackCallback$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [ee8.c] */
    public CotDetailDialogFragment() {
        this.d = new CotDetailDialogFragment$childPageBackCallback$1(this);
        this.e = new ee8.c(this);
    }

    public final int U90() {
        return getResources().getDimensionPixelSize(2131166989);
    }

    @Override // kc8.c
    public final y XK() {
        List r0 = CollectionsKt.asReversedMutable(getChildFragmentManager().getFragments());
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof CotDetailFragment) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        CotDetailFragment r4 = (CotDetailFragment) CollectionsKt.firstOrNull(r1);
        if (r4 != null) goto L18;
        return null;
    L18:
        return r4.g;
    }

    public final void onDestroyView() {
        getChildFragmentManager().removeOnBackStackChangedListener(this.e);
        setEnabled(false);
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        View r1 = r0.getCurrentFocus();
        if (r1 == null) goto L7;
        r1.clearFocus();
    L7:
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L12;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L12;
        r3.setSoftInputMode(3);
    L12:
        super.onStart();
        BottomSheetDialog r4 = getDialog();
        if ((r4 instanceof BottomSheetDialog) == false) goto L15;
        final BottomSheetDialog r5 = r4;
    L16:
        if (r5 == null) goto L35;
        r5.setCanceledOnTouchOutside(true);
        Window r6 = r5.getWindow();
        if (r6 == null) goto L27;
        WindowCompat.setDecorFitsSystemWindows(r6, false);
        r6.clearFlags(134217728);
        r6.addFlags(Integer.MIN_VALUE);
        r6.setNavigationBarColor(0);
        int r7 = Build.VERSION.SDK_INT;
        if (r7 < 28) goto L24;
        r6.setNavigationBarDividerColor(0);
    L24:
        if (r7 < 29) goto L26;
        r6.setNavigationBarContrastEnforced(false);
    L26:
        W90(r6).setSystemUiVisibility((W90(r6).getSystemUiVisibility() | 512) | 256);
    L27:
        final View r8 = r5.findViewById(2131368870);
        View r9 = r5.findViewById(2131367728);
        if (r9 == null) goto L30;
        ViewCompat.setOnApplyWindowInsetsListener(r9, new ee8.b());
        ViewCompat.requestApplyInsets(r9);
    L30:
        final Ref.BooleanRef r10 = new Ref.BooleanRef();
        if (r9 == null) goto L34;
        r9.setOnTouchListener(new ee8.d(r10, this, r8, r5));
        return;
    L34:
        return;
    L35:
        return;
    L15:
        r5 = null;
        goto L16
    }

    @Override // kc8.c
    public final boolean rx() {
        if (isAdded() == true) goto L5;
        return false;
    L5:
        if (getChildFragmentManager().getBackStackEntryCount() <= 0) goto L11;
        getChildFragmentManager().popBackStack();
        return true;
    L11:
        return false;
    }

    public static View W90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // kc8.c
    public final boolean FV(BlockDetailRequest r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        int r1 = BlockToolDetailFragment.j;
        Intrinsics.checkNotNullParameter(r3, "request");
        BlockToolDetailFragment r0 = new BlockToolDetailFragment();
        r0.d = r3;
        return X90(r0, "BlockDetailFragment");
    }

    public final boolean cf(g r9) {
        Intrinsics.checkNotNullParameter(r9, "blockModel");
        List r1 = CollectionsKt.asReversedMutable(getChildFragmentManager().getFragments());
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if ((r4 instanceof FloatingThinkDetailFragment) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        Iterator r5 = r2.iterator();
    L10:
        if (r5.hasNext() == false) goto L22;
        Object r6 = r5.next();
        FloatingThinkDetailFragment r7 = (FloatingThinkDetailFragment) r6;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r9, "other");
        g r8 = r7.d;
        if (r8 != null) goto L15;
    L19:
        boolean r10 = false;
    L20:
        if (r10 == false) goto L10;
    L23:
        FloatingThinkDetailFragment r11 = (FloatingThinkDetailFragment) r6;
        if (r11 != null) goto L26;
        return false;
    L26:
        Intrinsics.checkNotNullParameter(r9, "blockModel");
        r11.d = r9;
        r11.T90();
        return true;
    L15:
        if (Intrinsics.areEqual(r8.j().getMessageId(), r9.j().getMessageId()) == false) goto L19;
        if (Intrinsics.areEqual(r8.a.getBlockId(), r9.a.getBlockId()) == false) goto L19;
        r10 = true;
        goto L20
    L22:
        r6 = null;
        goto L23
    }

    public final Dialog onCreateDialog(Bundle r2) {
        final Context r3 = requireContext();
        return new AnonymousClass1(this, r3);
    }

    public final void onDismiss(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L15
        View r0 = getView();     // Catch: Throwable -> L15
        if (r0 == null) goto L7;
        View r1 = r0.findFocus();     // Catch: Throwable -> L15
        if (r1 == null) goto L7;
        r1.clearFocus();     // Catch: Throwable -> L15
    L7:
        FragmentActivity r2 = getActivity();     // Catch: Throwable -> L15
        if (r2 == null) goto L12;
        Window r4 = r2.getWindow();     // Catch: Throwable -> L15
        if (r4 == null) goto L12;
        r4.setSoftInputMode(3);     // Catch: Throwable -> L15
    L12:
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r3);     // Catch: Throwable -> L15
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L15:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final boolean FT(g r4, y r5) {
        Intrinsics.checkNotNullParameter(r4, "blockModel");
        int r1 = FloatingThinkDetailFragment.n;
        Intrinsics.checkNotNullParameter(r4, "blockModel");
        String r2 = "FloatingThinkDetail_" + r4.j().getMessageId() + '_' + r4.a.getBlockId();
        if (getChildFragmentManager().findFragmentByTag(r2) == null) goto L6;
        return true;
    L6:
        Intrinsics.checkNotNullParameter(r4, "blockModel");
        FloatingThinkDetailFragment r0 = new FloatingThinkDetailFragment();
        r0.d = r4;
        r0.e = r5;
        return X90(r0, r2);
    }

    public final void V90(View r4, BottomSheetBehavior<View> r5) {
        Intrinsics.checkNotNullParameter(r4, "bottomSheet");
        Intrinsics.checkNotNullParameter(r5, "behavior");
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        ViewGroup.MarginLayoutParams r1 = null;
        if (r0 == null) goto L5;
        r0.height = -1;
    L6:
        r4.setLayoutParams(r0);
        Object r6 = r4.getParent();
        if ((r6 instanceof View) == false) goto L9;
        View r7 = (View) r6;
    L10:
        if (r7 == null) goto L17;
        ViewGroup.LayoutParams r2 = r7.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        r1 = (ViewGroup.MarginLayoutParams) r2;
    L14:
        if (r1 == null) goto L16;
        r1.topMargin = getResources().getDimensionPixelSize(2131166696);
    L16:
        r7.setLayoutParams(r1);
    L17:
        r5.setState(3);
        r5.setSkipCollapsed(true);
        r5.setHideable(true);
        r5.setBottomSheetCallback(new b(this));
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    public final boolean X90(Fragment r9, String r10) {
        if (isAdded() == true) goto L5;
        return false;
    L5:
        if (getChildFragmentManager().isStateSaved() == false) goto L7;
        return false;
    L7:
        if (getChildFragmentManager().isDestroyed() == true) goto L21;
        Fragment r0 = getChildFragmentManager().findFragmentById(2131367980);
        FragmentTransaction r2 = getChildFragmentManager().beginTransaction();
        r2.setReorderingAllowed(true);
        r2.setCustomAnimations(2130772410, 2130772411, 2130772409, 2130772412);
        if (r0 == null) goto L13;
        r2.hide(r0);
        r2.setMaxLifecycle(r0, Lifecycle.State.STARTED);
    L13:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r10, 2131367980) == true) goto L16;
        r2.add(2131367980, r9, r10);
    L16:
        r2.addToBackStack(null);
        r2.commit();
        setEnabled(true);
        return true;
    L21:
        return false;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), this.d);
        getChildFragmentManager().addOnBackStackChangedListener(this.e);
        if (getChildFragmentManager().findFragmentById(2131367980) != null) goto L10;
        Bundle r6 = new Bundle(requireArguments());
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction();
        CotDetailFragment r1 = new CotDetailFragment();
        r1.setArguments(r6);
        Unit r7 = Unit.INSTANCE;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "task_cot_detail", 2131367980) == true) goto L8;
        r0.replace(2131367980, r1, "task_cot_detail");
    L8:
        r0.commit();
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562052, r3, false);
    }
}
