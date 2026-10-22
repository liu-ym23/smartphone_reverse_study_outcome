package com.larus.bmhome.block.presentation;

import android.app.Dialog;
import android.content.Context;
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
import com.larus.bmhome.chat.block.base.config.BlockDetailRequest;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.ClarificationAnswerDetailFragment;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.m;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.InteractionAskBlock;
import com.larus.utils.i0;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import kc8.c;
import kc8.y;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rb8.d;
import rb8.e;
import v19.c7;
import v19.m7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b*\u0001\f\u0018\u0000 32\u00020\u00012\u00020\u0002:\u000234B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\nH\u0016J\n\u0010$\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u001c\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(2\u0006\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0019H\u0002J\u0010\u00100\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0019H\u0002J\u0010\u00101\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u00102\u001a\u00020\u0017H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/bmhome/block/presentation/BlockDetailDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/larus/bmhome/chat/block/base/config/BlockDetailNavigationHost;", "<init>", "()V", "pendingRequest", "Lcom/larus/bmhome/chat/block/base/config/BlockDetailRequest;", "pendingGlobalConfig", "Lcom/larus/bmhome/chat/block/base/config/GlobalConfig;", "hasReachedExpandedState", "", "childPageBackCallback", "com/larus/bmhome/block/presentation/BlockDetailDialogFragment$childPageBackCallback$1", "Lcom/larus/bmhome/block/presentation/BlockDetailDialogFragment$childPageBackCallback$1;", "childPageBackStackListener", "Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;", "getTheme", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "pushBlockDetail", "request", "popBlockDetail", "provideBlockDetailGlobalConfig", "setupBackStack", "showBlockDetailPage", "createDetailFragment", "Lkotlin/Pair;", "Landroidx/fragment/app/Fragment;", "", "popChildPage", "canPopChildPage", "setupBottomSheet", "dispatchBottomSheetChanged", "bottomSheet", "clearBottomSheetBackground", "setClipViewTopCornerRadius", "onDestroyView", "Companion", "Holder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BlockDetailDialogFragment extends BottomSheetDialogFragment implements c {
    public static final /* synthetic */ int i = 0;
    public BlockDetailRequest d;
    public y e;
    public boolean f;
    public final BlockDetailDialogFragment$childPageBackCallback$1 g;
    public final rb8.a h;

    public static final class a {
    }

    public static final class b {
        public static y a;

        static {
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    @Override // kc8.c
    public final y XK() {
        y r0 = this.e;
        if (r0 == null) goto L5;
        y.a r1 = r0.b();
        r1.C = this;
        return r1.a();
    L5:
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.bmhome.block.presentation.BlockDetailDialogFragment$childPageBackCallback$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [rb8.a] */
    public BlockDetailDialogFragment() {
        this.g = new BlockDetailDialogFragment$childPageBackCallback$1(this);
        this.h = new rb8.a(this);
    }

    public final boolean S90() {
        if (isAdded() == true) goto L5;
    L7:
        return false;
    L5:
        if (getChildFragmentManager().getBackStackEntryCount() <= 0) goto L7;
        return true;
    }

    public final boolean U90() {
        if (S90() == true) goto L6;
        return false;
    L6:
        getChildFragmentManager().popBackStack();
        return true;
    }

    public final void onDestroyView() {
        getChildFragmentManager().removeOnBackStackChangedListener(this.h);
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
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
        r1.setOnShowListener(new rb8.b(this, r2));
        BottomSheetBehavior r11 = BottomSheetBehavior.from(r2);
        r11.setPeekHeight(r6);
        r11.setState(4);
        r11.setSkipCollapsed(false);
        r2.setBackgroundResource(2131239081);
        r2.setOutlineProvider(new d(c7.b(16)));
        r2.setClipToOutline(true);
        r11.setBottomSheetCallback(new e(this, r11));
        r2.post(new rb8.c(this, r2));
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

    @Override // kc8.c
    public final boolean rx() {
        return U90();
    }

    @Override // kc8.c
    public final boolean FV(BlockDetailRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        if (isAdded() == true) goto L6;
        return false;
    L6:
        V90(r2);
        return true;
    }

    public final void T90(View r3) {
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

    public final void V90(BlockDetailRequest r11) {
        if (getChildFragmentManager().isStateSaved() == false) goto L5;
        return;
    L5:
        if (getChildFragmentManager().isDestroyed() == true) goto L44;
        boolean r2 = false;
        if (getChildFragmentManager().findFragmentById(2131368894) == null) goto L10;
        boolean r0 = true;
    L11:
        Block r4 = (Block) CollectionsKt.lastOrNull(r11.getBlock());
        InteractionAskBlock r5 = null;
        if (r4 != null) goto L14;
    L24:
        if (r5 == null) goto L26;
        InteractionAskBlock r6 = ClarificationAnswerDetailFragment.j;
        Pair r12 = TuplesKt.to(ClarificationAnswerDetailFragment.c.a(r5, XK(), r11.getMessage()), "ClarificationAnswerDetailFragment");
    L27:
        Fragment r7 = (Fragment) r12.component1();
        String r13 = (String) r12.component2();
        FragmentTransaction r8 = getChildFragmentManager().beginTransaction();
        if (r0 == false) goto L31;
        r8.setCustomAnimations(2130772410, 2130772411, 2130772409, 2130772412);
    L31:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r13, 2131368894) == true) goto L34;
        r8.replace(2131368894, r7, r13);
    L34:
        if (r0 == false) goto L36;
        r8.addToBackStack("block_detail_child_page");
    L36:
        r8.commitAllowingStateLoss();
        BlockDetailDialogFragment$childPageBackCallback$1 r14 = this.g;
        if (r0 == false) goto L39;
    L40:
        r2 = true;
    L41:
        r14.setEnabled(r2);
        return;
    L39:
        if (S90() == false) goto L41;
    L26:
        int r9 = BlockToolDetailFragment.j;
        Intrinsics.checkNotNullParameter(r11, "request");
        BlockToolDetailFragment r10 = new BlockToolDetailFragment();
        r10.d = r11;
        r12 = TuplesKt.to(r10, "BlockDetailFragment");
        goto L27
    L14:
        if (r4.getBlockType() != j.q0) goto L16;
        boolean r15 = true;
    L17:
        if (r15 == true) goto L20;
        r4 = null;
    L20:
        if (r4 == null) goto L24;
        BlockContent r16 = r4.getContent();
        if (r16 == null) goto L24;
        r5 = r16.getInteractionAskBlock();
        goto L24
    L16:
        r15 = false;
        goto L17
    L10:
        r0 = false;
        goto L11
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable("arg_block_detail_request");
    L7:
        if ((r5 instanceof BlockDetailRequest) == false) goto L9;
        BlockDetailRequest r6 = (BlockDetailRequest) r5;
    L10:
        this.d = r6;
        y r7 = b.a;
        this.e = b.a;
        b.a = null;
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L7
    }

    public final Dialog onCreateDialog(Bundle r2) {
        final Context r3 = requireContext();
        return new AnonymousClass1(this, r3);
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        r3.setOutlineProvider(new d(c7.b(16)));
        r3.setClipToOutline(true);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), this.g);
        getChildFragmentManager().addOnBackStackChangedListener(this.h);
        if (r4 != null) goto L8;
        BlockDetailRequest r5 = this.d;
        if (r5 == null) goto L9;
        V90(r5);
        return;
    L9:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562367, r3, false);
    }
}
