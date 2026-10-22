package com.larus.dora.impl.nl.notification_rule.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.api.entity.NotificationRule;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\u001a\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\u001e\u001a\u00020\rJ\u001c\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0#J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/NotificationRuleBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusDoraBottomSheetNotificationRuleBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraBottomSheetNotificationRuleBinding;", "rule", "Lcom/larus/dora/api/entity/NotificationRule;", "onFinishEdit", "Lkotlin/Function0;", "", "getOnFinishEdit", "()Lkotlin/jvm/functions/Function0;", "setOnFinishEdit", "(Lkotlin/jvm/functions/Function0;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "showInputFragment", "showClarificationFragment", "userInput", "", "clarifiedDesc", "", "getTheme", "", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationRuleBottomSheet extends BottomSheetDialogFragment {
    public static final /* synthetic */ int f = 0;
    public NotificationRule d;
    public Function0<Unit> e;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131954325;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L15;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L16;
        r1.setSoftInputMode(16);
        BottomSheetDialog r2 = getDialog();
        View r3 = null;
        if ((r2 instanceof BottomSheetDialog) == false) goto L9;
        BottomSheetDialog r4 = r2;
    L10:
        if (r4 == null) goto L12;
        r3 = r4.findViewById(2131368870);
    L12:
        if (r3 == null) goto L17;
        BottomSheetBehavior r5 = BottomSheetBehavior.from(r3);
        r5.setState(3);
        r5.setSkipCollapsed(true);
        return;
    L17:
        return;
    L9:
        r4 = null;
        goto L10
    L16:
        return;
    }

    public NotificationRuleBottomSheet() {
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        Bundle r4 = getArguments();
        NotificationRule r0 = null;
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable("arg_rule");
    L7:
        if ((r5 instanceof NotificationRule) == false) goto L9;
        r0 = (NotificationRule) r5;
    L9:
        this.d = r0;
        return;
    L5:
        r5 = null;
        goto L7
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        if (r5 != null) goto L10;
        FragmentTransaction r6 = getChildFragmentManager().beginTransaction();
        int r7 = AddRuleInputFragment.h;
        NotificationRule r8 = this.d;
        AddRuleInputFragment r0 = new AddRuleInputFragment();
        Bundle r1 = new Bundle();
        r1.putSerializable("arg_rule", r8);
        r0.setArguments(r1);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131367728) == true) goto L8;
        r6 = r6.replace(2131367728, r0);
    L8:
        r6.commit();
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562144, r3, false);
        if (r5 == null) goto L7;
        return (FrameLayout) r5;
    L7:
        throw new NullPointerException("rootView");
    }
}
