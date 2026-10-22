package com.larus.share.impl.view;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.share.impl.databinding.LarusDialogFragmentSlidesShareBinding;
import com.larus.share.impl.panel.SharePanelAdapter;
import com.larus.share.impl.panel.SharePanelItemDecoration;
import com.larus.share.service.ShareDocType;
import com.larus.share.service.ShareOfficeDocDelegate;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 72\u00020\u0001:\u00017B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0002J\u001a\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u0010H\u0002J\b\u0010/\u001a\u00020\u0010H\u0002J\b\u00100\u001a\u00020\u0010H\u0002J\b\u00101\u001a\u00020\u0010H\u0002J\u0010\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020-H\u0002J\b\u00104\u001a\u00020\u0010H\u0002J\b\u00105\u001a\u00020\u0010H\u0002J\b\u00106\u001a\u00020\u0010H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u00068"}, d2 = {"Lcom/larus/share/impl/view/SheetShareDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "shareContext", "Lcom/larus/share/bean/SheetShareContext;", "<init>", "(Lcom/larus/share/bean/SheetShareContext;)V", "()V", "binding", "Lcom/larus/share/impl/databinding/LarusDialogFragmentSlidesShareBinding;", "currentPrivacyStatus", "", "isEnterpriseMode", "()Z", "isEnterpriseMode$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "getTheme", "", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setupLandscape", "applyWindowHorizontalPadding", "preSyncSystemBarsWithHost", "window", "Landroid/view/Window;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "setupPrivacy", "refreshPrivacy", "observePrivacy", "setupTitleBar", "getPermission", "token", "setupSharePanel", "showOpenPermissionGuide", "toSheetPermissionPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetShareDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int h = 0;
    public final kw9.f d;
    public LarusDialogFragmentSlidesShareBinding e;
    public boolean f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public SheetShareDialogFragment() {
        this(null);
        T90(this);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e("SheetShareDialogFragment", "no argument constructor, dismiss failed", e);
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void V90() {
        kw9.f r0 = this.d;
        if (r0 == null) goto L8;
        kw9.g r1 = r0.d;
        if (r1 == null) goto L8;
        String r2 = r1.a;
        if (r2 == null) goto L8;
    L9:
        boolean r3 = ShareOfficeDocDelegate.b.a(ShareDocType.SHEET, r2);
        this.f = r3;
        if (r3 == false) goto L21;
        LarusDialogFragmentSlidesShareBinding r4 = this.e;
        if (r4 == null) goto L16;
        ImageView r5 = r4.c;
        if (r5 == null) goto L16;
        r5.setImageResource(2131243405);
    L16:
        LarusDialogFragmentSlidesShareBinding r6 = this.e;
        if (r6 == null) goto L32;
        TextView r7 = r6.d;
        if (r7 == null) goto L33;
        r7.setText(getResources().getString(2131909876));
        return;
    L33:
        return;
    L32:
        return;
    L21:
        LarusDialogFragmentSlidesShareBinding r8 = this.e;
        if (r8 == null) goto L26;
        ImageView r9 = r8.c;
        if (r9 == null) goto L26;
        r9.setImageResource(2131243400);
    L26:
        LarusDialogFragmentSlidesShareBinding r10 = this.e;
        if (r10 == null) goto L35;
        TextView r11 = r10.d;
        if (r11 == null) goto L36;
        r11.setText(getResources().getString(2131909875));
        return;
    L36:
        return;
    L35:
        return;
    L8:
        r2 = "";
        goto L9
    }

    public final void W90() {
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L29;
        FragmentActivity r3 = getActivity();
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L29;
        Context r5 = getContext();
        if (r5 == null) goto L25;
        Resources r6 = r5.getResources();
        if (r6 == null) goto L25;
        Configuration r7 = r6.getConfiguration();
        if (r7 == null) goto L25;
        if (r7.orientation != 2) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == true) goto L29;
        boolean r9 = false;
    L30:
        ShareOfficeDocDelegate r10 = ShareOfficeDocDelegate.b;
        Context r11 = getContext();
        ShareDocType r12 = ShareDocType.SHEET;
        kw9.f r13 = this.d;
        if (r13 == null) goto L36;
        kw9.g r14 = r13.d;
        if (r14 == null) goto L36;
        String r15 = r14.a;
        if (r15 == null) goto L36;
    L37:
        boolean r16 = this.f;
        if (r13 == null) goto L44;
        kw9.g r17 = r13.d;
        if (r17 == null) goto L44;
        com.larus.bmhome.share.panel.h r18 = r17.c;
        if (r18 == null) goto L44;
        String r19 = r18.Z;
    L46:
        if (r13 == null) goto L52;
        kw9.g r110 = r13.d;
        if (r110 == null) goto L52;
        com.larus.bmhome.share.panel.h r111 = r110.c;
        if (r111 == null) goto L52;
        String r112 = r111.b0;
    L53:
        if (r13 == null) goto L59;
        kw9.g r113 = r13.d;
        if (r113 == null) goto L59;
        com.larus.bmhome.share.panel.h r114 = r113.c;
        if (r114 == null) goto L59;
        String r115 = r114.c0;
    L60:
        if (r13 == null) goto L66;
        kw9.g r116 = r13.d;
        if (r116 == null) goto L66;
        com.larus.bmhome.share.panel.h r117 = r116.c;
        if (r117 == null) goto L66;
        Integer r118 = r117.d0;
    L67:
        if (r13 == null) goto L73;
        kw9.g r119 = r13.d;
        if (r119 == null) goto L73;
        com.larus.bmhome.share.panel.h r120 = r119.c;
        if (r120 == null) goto L73;
        String r121 = r120.L;
    L74:
        if (r13 == null) goto L80;
        kw9.g r20 = r13.d;
        if (r20 == null) goto L80;
        com.larus.bmhome.share.panel.h r21 = r20.c;
        if (r21 == null) goto L80;
        Integer r122 = r21.M;
    L81:
        r10.c(r11, r12, new com.larus.share.service.i(r15, r16, r9, r19, null, r112, r115, r118, r121, r122, null, 1040));
        return;
    L80:
        r122 = null;
    L73:
        r121 = null;
    L66:
        r118 = null;
    L59:
        r115 = null;
    L52:
        r112 = null;
    L44:
        r19 = null;
    L36:
        r15 = "";
    L25:
        r8 = false;
        goto L26
    L12:
        if (r3.getRequestedOrientation() != 8) goto L14;
        r4 = true;
    L29:
        r9 = true;
        goto L30
    L5:
        if (r1.getRequestedOrientation() != 0) goto L7;
        r2 = true;
        goto L8
    }

    public final void U90() {
        int r2 = 0;
        if (requireContext().getResources().getConfiguration().orientation != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r2 = getResources().getDimensionPixelSize(v19.c.b(2130971166, null, 2131166701));
    L8:
        Dialog r1 = getDialog();
        if (r1 == null) goto L17;
        Window r3 = r1.getWindow();
        if (r3 == null) goto L18;
        View r4 = S90(r3);
        if (r4 == null) goto L19;
        r4.setPadding(r2, r4.getPaddingTop(), r2, r4.getPaddingBottom());
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        V90();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.setLayout(-1, -1);
        r1.setWindowAnimations(2131954385);
    L7:
        U90();
    }

    public SheetShareDialogFragment(kw9.f r1) {
        this.d = r1;
        this.g = LazyKt.lazy(new n0());
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void T90(SheetShareDialogFragment r1) {
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

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        U90();
    }

    public final void onCreate(Bundle r4) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r4);
        if (r4 == null) goto L12;
        FLogger.a.i("SheetShareDialogFragment", "UI mode changed during recreation, dismissing dialog");
        T90(this);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.a.e("SheetShareDialogFragment", "no argument constructor, dismiss failed", e);
        return;
    }

    public final Dialog onCreateDialog(Bundle r8) {
        Dialog r9 = super.onCreateDialog(r8);
        Window r0 = r9.getWindow();
        if (r0 == null) goto L14;
        r0.addFlags(8);
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L14;
        Window r2 = r1.getWindow();
        View r3 = S90(r2);
        View r4 = S90(r0);
        WindowCompat.setDecorFitsSystemWindows(r0, false);
        r0.addFlags(Integer.MIN_VALUE);
        r0.clearFlags(134217728);
        int r5 = Build.VERSION.SDK_INT;
        if (r5 < 29) goto L11;
        r0.setNavigationBarContrastEnforced(false);
    L11:
        if (r5 < 28) goto L13;
        WindowManager.LayoutParams r6 = r0.getAttributes();
        r6.layoutInDisplayCutoutMode = 1;
        r0.setAttributes(r6);
    L13:
        r4.setSystemUiVisibility(((r3.getSystemUiVisibility() | 1024) | 512) | 256);
        r0.setStatusBarColor(r2.getStatusBarColor());
        r0.setNavigationBarColor(0);
    L14:
        return r9;
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        BottomSheetDialog r15 = getDialog();
        List r0 = null;
        if ((r15 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r16 = r15;
    L6:
        if (r16 == null) goto L8;
        final View r17 = r16.findViewById(2131368870);
    L9:
        Dialog r18 = getDialog();
        if (r18 == null) goto L12;
        r18.setOnShowListener(new l0(r17, this));
    L12:
        LarusDialogFragmentSlidesShareBinding r19 = this.e;
        if (r19 == null) goto L17;
        ImageView r110 = r19.b;
        if (r110 == null) goto L17;
        e1.d(r110, new p0(this));
    L17:
        LarusDialogFragmentSlidesShareBinding r111 = this.e;
        if (r111 == null) goto L28;
        TextView r112 = r111.g;
        if (r112 == null) goto L28;
        kw9.f r113 = this.d;
        if (r113 == null) goto L26;
        com.larus.bmhome.share.panel.b r114 = r113.c;
        if (r114 == null) goto L26;
        String r115 = r114.h;
    L27:
        r112.setText(r115);
    L26:
        r115 = null;
    L28:
        V90();
        LarusDialogFragmentSlidesShareBinding r116 = this.e;
        if (r116 == null) goto L33;
        ConstraintLayout r117 = r116.f;
        if (r117 == null) goto L33;
        e1.d(r117, new o0(this));
    L33:
        LarusDialogFragmentSlidesShareBinding r118 = this.e;
        if (r118 == null) goto L58;
        RecyclerView r119 = r118.e;
        if (r119 == null) goto L58;
        kw9.f r120 = this.d;
        if (r120 == null) goto L58;
        List<jr9.a> r1 = r120.b;
        if (r1 != null) goto L42;
    L45:
        boolean r2 = true;
    L46:
        if (r2 == false) goto L53;
        com.larus.share.impl.util.e r4 = com.larus.share.impl.util.e.a;
        int r3 = com.larus.share.impl.sdk.a.a;
        jr9.c r5 = com.larus.share.impl.sdk.a.a(r120.d.b);
        if (r5 == null) goto L52;
        List<jr9.a> r6 = r5.c();
        if (r6 == null) goto L52;
        r0 = CollectionsKt.filterNotNull(r6);
    L52:
        List<jr9.a> r7 = com.larus.share.impl.util.e.d(r4, r0, false, null, false, 7);
    L55:
        if ((!r7.isEmpty()) == false) goto L57;
        SharePanelAdapter r8 = new SharePanelAdapter(r120.a, this, new r0(r120, this), r120.c, null, false, 96);
        r8.setData(r7);
        r119.setAdapter(r8);
        r119.setLayoutManager(new LinearLayoutManager(r120.a, 0, false));
        r119.addItemDecoration(new SharePanelItemDecoration(r120.a, false));
        r119.setVisibility(0);
        goto L58
    L57:
        FLogger.a.i("SheetShareDialogFragment", "setupSharePanel: shareItems is empty");
        r119.setVisibility(8);
        goto L58
    L53:
        r7 = com.larus.share.impl.util.e.d(com.larus.share.impl.util.e.a, r120.b, false, null, false, 7);
        goto L55
    L42:
        if (r1.isEmpty() == true) goto L45;
        r2 = false;
    L58:
        kw9.f r121 = this.d;
        if (r121 == null) goto L67;
        kw9.g r122 = r121.d;
        if (r122 == null) goto L68;
        String r123 = r122.a;
        if (r123 == null) goto L69;
        ShareOfficeDocDelegate.b.b(ShareDocType.SHEET, r123, getViewLifecycleOwner(), new m0(this));
        return;
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L8:
        r17 = null;
        goto L9
    L5:
        r16 = null;
        goto L6
    }

    public final void show(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == false) goto L12;
    L7:
        kw9.f r5 = this.d;
        if (r5 == null) goto L14;
        com.larus.share.impl.e r6 = com.larus.share.impl.a.a;
        kw9.g r7 = r5.d;
        com.larus.share.impl.a.r(r7.b, r7.c, r7.d);
        kw9.g r8 = r5.d;
        com.larus.share.impl.a.q(r8.b, "permission_setting", r8.c, r8.d);
        return;
    L14:
        return;
    L12:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        super/*androidx.fragment.app.DialogFragment*/.show(r3, r4);
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        this.e = LarusDialogFragmentSlidesShareBinding.a(r2, r3);
        Dialog r5 = getDialog();
        if (r5 == null) goto L7;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L7;
        r6.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.transparent)));
    L7:
        LarusDialogFragmentSlidesShareBinding r7 = this.e;
        if (r7 != null) goto L12;
        return null;
    L12:
        return r7.a;
    }
}
