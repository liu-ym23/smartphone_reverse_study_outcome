package com.larus.share.impl.view;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.platform.service.IOfficePlatformService;
import com.larus.share.impl.databinding.LarusDialogFragmentDriveShareBinding;
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
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\b\u0010&\u001a\u00020\u0010H\u0002J\b\u0010'\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u0010H\u0002J\b\u0010)\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002J\b\u0010+\u001a\u00020\u0010H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006-"}, d2 = {"Lcom/larus/share/impl/view/DriveShareDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "shareContext", "Lcom/larus/share/bean/DriveShareContext;", "<init>", "(Lcom/larus/share/bean/DriveShareContext;)V", "()V", "binding", "Lcom/larus/share/impl/databinding/LarusDialogFragmentDriveShareBinding;", "currentPrivacyStatus", "", "isEnterpriseMode", "()Z", "isEnterpriseMode$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "setupLandscape", "setupTitleBar", "setupPrivacy", "observePrivacy", "refreshPrivacy", "setupSharePanel", "toDrivePermissionPage", "showOpenPermissionGuide", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DriveShareDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int h = 0;
    public final kw9.b d;
    public LarusDialogFragmentDriveShareBinding e;
    public boolean f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public DriveShareDialogFragment() {
        this(null);
        S90(this);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e("DriveShareDialogFragment", "no argument constructor, dismiss failed", e);
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void T90() {
        ShareOfficeDocDelegate r0 = ShareOfficeDocDelegate.b;
        ShareDocType r1 = ShareDocType.DRIVE;
        kw9.b r2 = this.d;
        if (r2 == null) goto L8;
        kw9.d r3 = r2.b;
        if (r3 == null) goto L8;
        String r4 = r3.a;
        if (r4 == null) goto L8;
    L9:
        boolean r5 = r0.a(r1, r4);
        this.f = r5;
        if (r5 == false) goto L21;
        LarusDialogFragmentDriveShareBinding r6 = this.e;
        if (r6 == null) goto L16;
        ImageView r7 = r6.c;
        if (r7 == null) goto L16;
        r7.setImageResource(2131243405);
    L16:
        LarusDialogFragmentDriveShareBinding r8 = this.e;
        if (r8 == null) goto L32;
        TextView r9 = r8.d;
        if (r9 == null) goto L33;
        r9.setText(getResources().getString(2131909876));
        return;
    L33:
        return;
    L32:
        return;
    L21:
        LarusDialogFragmentDriveShareBinding r10 = this.e;
        if (r10 == null) goto L26;
        ImageView r11 = r10.c;
        if (r11 == null) goto L26;
        r11.setImageResource(2131243400);
    L26:
        LarusDialogFragmentDriveShareBinding r12 = this.e;
        if (r12 == null) goto L35;
        TextView r13 = r12.d;
        if (r13 == null) goto L36;
        r13.setText(getResources().getString(2131909875));
        return;
    L36:
        return;
    L35:
        return;
    L8:
        r4 = "";
        goto L9
    }

    public final void U90() {
        ShareOfficeDocDelegate r1 = ShareOfficeDocDelegate.b;
        Context r2 = getContext();
        ShareDocType r3 = ShareDocType.DRIVE;
        kw9.b r4 = this.d;
        if (r4 == null) goto L8;
        kw9.d r5 = r4.b;
        if (r5 == null) goto L8;
        String r6 = r5.a;
        if (r6 == null) goto L8;
    L9:
        boolean r7 = this.f;
        if (r4 == null) goto L14;
        kw9.d r8 = r4.b;
        if (r8 == null) goto L14;
        int r9 = r8.b;
    L15:
        r1.c(r2, r3, new com.larus.share.service.i(r6, r7, false, null, null, null, null, null, null, null, Integer.valueOf(r9), 1016));
        return;
    L14:
        r9 = 12;
    L8:
        r6 = "";
        goto L9
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.e = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setLayout(-1, -1);
        r1.setWindowAnimations(2131954385);
        return;
    L9:
        return;
    }

    public DriveShareDialogFragment(kw9.b r1) {
        this.d = r1;
        this.g = LazyKt.lazy(new c());
    }

    public static void S90(DriveShareDialogFragment r1) {
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

    public final void onCreate(Bundle r4) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r4);
        if (r4 == null) goto L12;
        FLogger.a.i("DriveShareDialogFragment", "UI mode changed during recreation, dismissing dialog");
        S90(this);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.a.e("DriveShareDialogFragment", "dismiss failed during recreation", e);
        return;
    }

    public final void onViewCreated(View r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r19, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r19, r20);
        BottomSheetDialog r0 = getDialog();
        List r2 = null;
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r1 = r0;
    L6:
        if (r1 == null) goto L8;
        final View r3 = r1.findViewById(2131368870);
    L9:
        Dialog r4 = getDialog();
        if (r4 == null) goto L12;
        r4.setOnShowListener(new com.larus.share.impl.view.a(r3));
    L12:
        LarusDialogFragmentDriveShareBinding r5 = this.e;
        if (r5 == null) goto L17;
        ImageView r6 = r5.b;
        if (r6 == null) goto L17;
        e1.d(r6, new b(this));
    L17:
        LarusDialogFragmentDriveShareBinding r7 = this.e;
        if (r7 == null) goto L28;
        TextView r8 = r7.g;
        if (r8 == null) goto L28;
        kw9.b r9 = this.d;
        if (r9 == null) goto L26;
        com.larus.bmhome.share.panel.b r10 = r9.d;
        if (r10 == null) goto L26;
        String r11 = r10.h;
    L27:
        r8.setText(r11);
    L26:
        r11 = null;
    L28:
        T90();
        LarusDialogFragmentDriveShareBinding r12 = this.e;
        if (r12 == null) goto L33;
        ConstraintLayout r13 = r12.f;
        if (r13 == null) goto L33;
        e1.d(r13, new d(this));
    L33:
        LarusDialogFragmentDriveShareBinding r14 = this.e;
        if (r14 == null) goto L70;
        RecyclerView r15 = r14.e;
        if (r15 == null) goto L70;
        kw9.b r16 = this.d;
        if (r16 == null) goto L70;
        List<jr9.a> r17 = r16.c;
        if (r17 != null) goto L42;
    L45:
        boolean r18 = true;
    L46:
        if (r18 == false) goto L53;
        com.larus.share.impl.util.e r110 = com.larus.share.impl.util.e.a;
        int r21 = com.larus.share.impl.sdk.a.a;
        jr9.c r22 = com.larus.share.impl.sdk.a.a(r16.b.c);
        if (r22 == null) goto L52;
        List<jr9.a> r23 = r22.c();
        if (r23 == null) goto L52;
        r2 = CollectionsKt.filterNotNull(r23);
    L52:
        List<jr9.a> r24 = com.larus.share.impl.util.e.d(r110, r2, false, null, false, 7);
    L54:
        IOfficePlatformService r25 = (IOfficePlatformService) ServiceManager.get().getService(IOfficePlatformService.class);
        FLogger.a.i("DriveShareDialogFragment", "feishuService: " + r25 + "， fileType: " + r16.b.b);
        if (r25 != null) goto L57;
    L65:
        List<jr9.a> r111 = r24;
    L67:
        if ((!r111.isEmpty()) == false) goto L69;
        SharePanelAdapter r112 = new SharePanelAdapter(r16.a, this, new g(r16, this), r16.d, null, false, 96);
        r112.setData(r111);
        r15.setAdapter(r112);
        r15.setLayoutManager(new LinearLayoutManager(r16.a, 0, false));
        r15.addItemDecoration(new SharePanelItemDecoration(r16.a, false));
        r15.setVisibility(0);
        goto L70
    L69:
        FLogger.a.i("DriveShareDialogFragment", "setupSharePanel: shareItems is empty");
        r15.setVisibility(8);
        goto L70
    L57:
        if (r25.c(Integer.valueOf(r16.b.b)) == true) goto L65;
        ArrayList r26 = new ArrayList();
        Iterator r27 = r24.iterator();
    L60:
        if (r27.hasNext() == false) goto L64;
        Object r28 = r27.next();
        if ((!Intrinsics.areEqual(((jr9.a) r28).b(), "copy_feishu_link")) == false) goto L60;
        r26.add(r28);
        goto L60
    L64:
        r111 = r26;
        goto L67
    L53:
        r24 = com.larus.share.impl.util.e.d(com.larus.share.impl.util.e.a, r16.c, false, null, false, 7);
        goto L54
    L42:
        if (r17.isEmpty() == true) goto L45;
        r18 = false;
    L70:
        kw9.b r29 = this.d;
        if (r29 == null) goto L84;
        kw9.d r30 = r29.b;
        if (r30 == null) goto L85;
        String r31 = r30.a;
        if (r31 == null) goto L86;
        ShareOfficeDocDelegate.b.b(ShareDocType.DRIVE, r31, getViewLifecycleOwner(), new e(this));
        return;
    L86:
        return;
    L85:
        return;
    L84:
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final void show(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == false) goto L12;
    L7:
        kw9.b r5 = this.d;
        if (r5 == null) goto L14;
        com.larus.share.impl.e r6 = com.larus.share.impl.a.a;
        kw9.d r7 = r5.b;
        com.larus.share.impl.a.r(r7.c, r7.d, r7.e);
        kw9.d r8 = r5.b;
        com.larus.share.impl.a.q(r8.c, "permission_setting", r8.d, r8.e);
        return;
    L14:
        return;
    L12:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        super/*androidx.fragment.app.DialogFragment*/.show(r3, r4);
        goto L7
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562073, r10, false);
        int r13 = 2131367000;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r12, 2131367000);
        if (r2 == null) goto L31;
        r13 = 2131369197;
        if (((ImageView) ViewBindings.findChildViewById(r12, 2131369197)) == null) goto L31;
        r13 = 2131383036;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r12, 2131383036);
        if (r3 == null) goto L31;
        r13 = 2131383047;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r12, 2131383047);
        if (r4 == null) goto L31;
        r13 = 2131383064;
        if (((ImageView) ViewBindings.findChildViewById(r12, 2131383064)) == null) goto L31;
        r13 = 2131386112;
        RecyclerView r5 = ViewBindings.findChildViewById(r12, 2131386112);
        if (r5 == null) goto L31;
        r13 = 2131386140;
        ConstraintLayout r6 = ViewBindings.findChildViewById(r12, 2131386140);
        if (r6 == null) goto L31;
        r13 = 2131386144;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, 2131386144);
        if (r7 == null) goto L31;
        r13 = 2131386146;
        if (ViewBindings.findChildViewById(r12, 2131386146) == null) goto L31;
        this.e = new LarusDialogFragmentDriveShareBinding((FrameLayout) r12, r2, r3, r4, r5, r6, r7);
        Dialog r14 = getDialog();
        if (r14 == null) goto L25;
        Window r15 = r14.getWindow();
        if (r15 == null) goto L25;
        r15.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.transparent)));
    L25:
        LarusDialogFragmentDriveShareBinding r16 = this.e;
        if (r16 != null) goto L32;
        return null;
    L32:
        return r16.a;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
