package com.larus.bmhome.double_post.side_bar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.model.repo.SettingRepoDelegate;
import com.larus.bmhome.databinding.LarusLayoutAwemeFeedSideBarBinding;
import com.larus.bmhome.double_post.fragment.AwemeDoublePostFragment;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.z;
import com.larus.common.apphost.AppHost;
import com.larus.utils.f;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import jp8.a;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/double_post/side_bar/AwemeSideBarFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/bmhome/ISideBarChildFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusLayoutAwemeFeedSideBarBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onNewIntent", "bundle", "initView", "addFragment", "onEnterTab", "previousPage", "", "onLeaveTab", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwemeSideBarFragment extends Fragment implements z {
    public static final /* synthetic */ int e = 0;
    public LarusLayoutAwemeFeedSideBarBinding d;

    public final void a2(Bundle r1) {
    }

    public final void pp(String r1) {
    }

    public final void t1() {
    }

    public final void y2(String r1) {
    }

    public AwemeSideBarFragment() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View, android.view.ViewGroup, com.larus.bmhome.view.NovaTitleBarEx] */
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        AwemeDoublePostFragment r12 = new AwemeDoublePostFragment();
        r12.setArguments(f.c(new Pair[]{TuplesKt.to("bundle_key_disable_outer_input", Boolean.TRUE), TuplesKt.to("bundle_key_loading_space_height", 0)}));
        r12.g = true;
        FragmentTransaction r13 = getChildFragmentManager().beginTransaction();
        FragmentActivity r1 = null;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131377467) == true) goto L6;
        r13 = r13.replace(2131377467, r12);
    L6:
        r13.commitAllowingStateLoss();
        LarusLayoutAwemeFeedSideBarBinding r14 = this.d;
        if (r14 == null) goto L19;
        ?? r2 = r14.c;
        if (r2 == 0) goto L19;
        ViewGroup.LayoutParams r15 = r2.getLayoutParams();
        if (r15 == null) goto L18;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        i0.a.getClass();
        r16.topMargin = i0.g();
        r2.setLayoutParams(r16);
        if (SettingRepoDelegate.b.R0() == false) goto L15;
        String r17 = AppHost.a.getApplication().getString(2131901386);
    L16:
        Intrinsics.checkNotNull(r17);
        NovaTitleBarEx.Y5(r2, r17, null, null, 6);
        NovaTitleBarEx.b6(r2, c.b(2130971852, r2.getContext(), 2131242079), false, null, null, new a(this), 14);
        goto L19
    L15:
        r17 = AppHost.a.getApplication().getString(2131901387);
        goto L16
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        LarusLayoutAwemeFeedSideBarBinding r18 = this.d;
        if (r18 == null) goto L28;
        ConstraintLayout r19 = r18.a;
        if (r19 == null) goto L29;
        Context r110 = getContext();
        if ((r110 instanceof FragmentActivity) == false) goto L26;
        r1 = (FragmentActivity) r110;
    L26:
        int r111 = u.b(r1);
        int r0 = r19.getPaddingStart();
        int r3 = r19.getPaddingTop();
        int r4 = r19.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r19.getClass().getSimpleName() + ",source:,start:" + r0 + ",top:" + r3 + ",end:" + r4 + ",bottom:" + r111);
        r19.setPaddingRelative(r0, r3, r4, r111);
        return;
    L29:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562744, r3, false);
        int r6 = 2131377467;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r5, 2131377467);
        if (r7 == null) goto L9;
        r6 = 2131388807;
        NovaTitleBarEx r0 = (NovaTitleBarEx) ViewBindings.findChildViewById(r5, 2131388807);
        if (r0 == null) goto L9;
        ConstraintLayout r8 = r5;
        this.d = new LarusLayoutAwemeFeedSideBarBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
