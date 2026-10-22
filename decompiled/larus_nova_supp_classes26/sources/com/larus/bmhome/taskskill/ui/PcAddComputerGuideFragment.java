package com.larus.bmhome.taskskill.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.bmhome.taskskill.k2;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment;
import com.larus.flowskill.impl.databinding.LarusFragmentPcAddComputerGuideBinding;
import com.larus.platform.service.o2;
import com.larus.platform.service.p1;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.m7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020\rH\u0016J\u001e\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130*H\u0014J\b\u0010+\u001a\u00020\rH\u0002J\u0010\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020\rH\u0002J\b\u00100\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u001b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u00062"}, d2 = {"Lcom/larus/bmhome/taskskill/ui/PcAddComputerGuideFragment;", "Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/flowskill/impl/databinding/LarusFragmentPcAddComputerGuideBinding;", "shouldPublishCompletedOnDismiss", "", "onDismissCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "completed", "", "getOnDismissCallback", "()Lkotlin/jvm/functions/Function1;", "setOnDismissCallback", "(Lkotlin/jvm/functions/Function1;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "roundedBottomSheetBackgroundRes", "", "getRoundedBottomSheetBackgroundRes", "()I", "onViewCreated", "view", "buildDownloadUrlText", "", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "onStart", "onRoundedBottomSheetReady", "bottomSheet", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "reportGuideShow", "reportGuideClick", "clickFrom", "", "publishCompleted", "copyDesktopDownloadUrl", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcAddComputerGuideFragment extends RoundedBottomSheetDialogFragment {
    public static final /* synthetic */ int f = 0;
    public LarusFragmentPcAddComputerGuideBinding d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public final int S90() {
        return 2131239798;
    }

    public final void onDestroyView() {
        this.d = null;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.clearFlags(2);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.dimAmount = 0.0f;
        r1.setAttributes(r2);
        m7.a(r1);
        return;
    L9:
        return;
    }

    public PcAddComputerGuideFragment() {
    }

    public static void X90(String r4) {
        int r0 = k2.a;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter(r4, "clickFrom");
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;
        JSONObject r2 = new JSONObject();
        r2.put("current_page", "chat");
        r2.put("click_from", r4);
        Unit r5 = Unit.INSTANCE;
        r1.reportEvent("local_computer_connect_guide_board_click", r2);
    }

    public final void W90(DialogInterface r6) {
        Intrinsics.checkNotNullParameter(r6, "dialog");
        if (this.e == false) goto L14;
        this.e = false;
        Bundle r0 = getArguments();
        if (r0 == null) goto L7;
        String r1 = r0.getString("arg_request_key");
    L8:
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        if (StringsKt.isBlank(r1) == true) goto L14;
        FragmentManager r2 = getParentFragmentManager();
        Bundle r3 = new Bundle();
        r3.putString("key_event", "completed");
        Unit r4 = Unit.INSTANCE;
        r2.setFragmentResult(r1, r3);
        goto L14
    L7:
        r1 = null;
    L14:
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r6);
    }

    public final void onDismiss(DialogInterface r2) {
        W90(r2);     // Catch: Throwable -> L5
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

    public final void V90(View r3, BottomSheetBehavior<View> r4) {
        Intrinsics.checkNotNullParameter(r3, "bottomSheet");
        Intrinsics.checkNotNullParameter(r4, "behavior");
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 == null) goto L5;
        r0.height = -1;
    L5:
        r3.setLayoutParams(r0);
        r4.setSkipCollapsed(true);
        r4.setState(3);
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        int r11 = k2.a;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        com.larus.platform.service.o r12 = com.larus.platform.service.o.a;
        JSONObject r0 = new JSONObject();
        r0.put("current_page", "chat");
        Unit r13 = Unit.INSTANCE;
        r12.reportEvent("local_computer_connect_guide_board_show", r0);
        LarusFragmentPcAddComputerGuideBinding r14 = this.d;
        if (r14 == null) goto L19;
        TextView r15 = r14.e;
        o2 r1 = o2.a;
        r15.setText(r1.b(2131901710));
        r14.h.setText(r1.b(2131901718));
        TextView r16 = r14.f;
        String r2 = p1.a.f();
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        r2 = AppHost.a.d() + "/download/desktop";
    L13:
        Drawable r4 = AppCompatResources.getDrawable(requireContext(), 2131241701);
        CharSequence r5 = r2;
        if (r4 == null) goto L17;
        int r6 = getResources().getDimensionPixelSize(v19.c.b(2130971186, null, 2131166742));
        r4.setBounds(0, 0, r6, r6);
        SpannableStringBuilder r7 = new SpannableStringBuilder(r2);
        r7.append("  ");
        r7.setSpan(new ImageSpan(r4, 2), r7.length() - 1, r7.length(), 33);
        r5 = r7;
    L17:
        r16.setText(r5);
        r14.b.setOnClickListener(new com.larus.bmhome.taskskill.ui.a(this));
        r14.d.setOnClickListener(new b(this));
        r14.c.setOnClickListener(new c(this));
        return;
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
        goto L11
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131562420, r11, false);
        int r14 = 2131382060;
        if (((LinearLayout) ViewBindings.findChildViewById(r13, 2131382060)) == null) goto L47;
        r14 = 2131382061;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r13, 2131382061);
        if (r2 == null) goto L47;
        r14 = 2131382062;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r13, 2131382062);
        if (r3 == null) goto L47;
        r14 = 2131382063;
        if (((LinearLayout) ViewBindings.findChildViewById(r13, 2131382063)) == null) goto L47;
        r14 = 2131382064;
        if (ViewBindings.findChildViewById(r13, 2131382064) == null) goto L47;
        r14 = 2131382065;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131382065)) == null) goto L47;
        r14 = 2131382066;
        if (((LinearLayout) ViewBindings.findChildViewById(r13, 2131382066)) == null) goto L47;
        r14 = 2131382067;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r13, 2131382067);
        if (r4 == null) goto L47;
        r14 = 2131382068;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r13, 2131382068);
        if (r5 == null) goto L47;
        r14 = 2131382069;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r13, 2131382069);
        if (r6 == null) goto L47;
        r14 = 2131382070;
        View r7 = ViewBindings.findChildViewById(r13, 2131382070);
        if (r7 == null) goto L47;
        r14 = 2131382071;
        if (ViewBindings.findChildViewById(r13, 2131382071) == null) goto L47;
        r14 = 2131382072;
        if (ViewBindings.findChildViewById(r13, 2131382072) == null) goto L47;
        r14 = 2131382073;
        if (((LinearLayout) ViewBindings.findChildViewById(r13, 2131382073)) == null) goto L47;
        r14 = 2131382074;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, 2131382074);
        if (r8 == null) goto L47;
        r14 = 2131382075;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131382075)) == null) goto L47;
        r14 = 2131382076;
        if (ViewBindings.findChildViewById(r13, 2131382076) == null) goto L47;
        r14 = 2131382077;
        if (ViewBindings.findChildViewById(r13, 2131382077) == null) goto L47;
        r14 = 2131382078;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131382078)) == null) goto L47;
        r14 = 2131382079;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131382079)) == null) goto L47;
        r14 = 2131382080;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131382080)) == null) goto L47;
        ConstraintLayout r15 = r13;
        this.d = new LarusFragmentPcAddComputerGuideBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L47:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
