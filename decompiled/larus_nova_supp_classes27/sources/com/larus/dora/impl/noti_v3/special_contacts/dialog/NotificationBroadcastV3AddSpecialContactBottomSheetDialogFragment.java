package com.larus.dora.impl.noti_v3.special_contacts.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.utils.x1;
import com.larus.dora.impl.databinding.LarusDoraDialogNotiV3AddSpecialContactBinding;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import x59.b;
import x59.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0002J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0019J\u000f\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0019J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/dora/impl/noti_v3/special_contacts/dialog/NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDialogNotiV3AddSpecialContactBinding;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "contactId", "", "getTheme", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupInitialValues", "()Lkotlin/Unit;", "onDestroyView", "setupBottomSheetBehavior", "setupInputValidation", "validateInputs", "setupClicks", "handleConfirm", "appName", "chatName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int g = 0;
    public LarusDoraDialogNotiV3AddSpecialContactBinding d;
    public x1 e;
    public String f;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131954327;
    }

    public final Unit S90() {
        LarusDoraDialogNotiV3AddSpecialContactBinding r0 = this.d;
        String r1 = null;
        if (r0 == null) goto L35;
        Editable r2 = r0.d.getText();
        if (r2 == null) goto L9;
        String r3 = r2.toString();
        if (r3 == null) goto L9;
        String r4 = StringsKt.trim(r3).toString();
    L10:
        String r5 = "";
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        Editable r6 = r0.e.getText();
        if (r6 == null) goto L18;
        String r7 = r6.toString();
        if (r7 == null) goto L18;
        r1 = StringsKt.trim(r7).toString();
    L18:
        if (r1 == null) goto L21;
        r5 = r1;
    L21:
        AppCompatButton r8 = r0.c;
        int r9 = r4.length();
        boolean r10 = true;
        if (r9 <= 0) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == true) goto L27;
    L32:
        r10 = false;
    L33:
        r8.setEnabled(r10);
        return Unit.INSTANCE;
    L27:
        if (r5.length() <= 0) goto L29;
        boolean r12 = true;
    L30:
        if (r12 == false) goto L32;
    L29:
        r12 = false;
        goto L30
    L24:
        r11 = false;
    L9:
        r4 = null;
        goto L10
    L35:
        return null;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        x1 r0 = this.e;
        if (r0 == null) goto L5;
        r0.a(true);
    L5:
        this.d = null;
    }

    public NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment() {
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        String r4 = r3.getString("key_contact_id");
    L6:
        this.f = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L7;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L7;
        r5.setSoftInputMode(16);
    L7:
        LarusDoraDialogNotiV3AddSpecialContactBinding r6 = this.d;
        if (r6 == null) goto L12;
        AppCompatEditText r7 = r6.d;
        if (r7 == null) goto L12;
        this.e = new x1(r7);
    L12:
        LarusDoraDialogNotiV3AddSpecialContactBinding r8 = this.d;
        if (r8 == null) goto L28;
        Bundle r9 = getArguments();
        if (r9 == null) goto L19;
        String r10 = r9.getString("key_app_name");
        if (r10 == null) goto L19;
        r8.d.setText(r10);
    L19:
        Bundle r11 = getArguments();
        if (r11 == null) goto L25;
        String r12 = r11.getString("key_chat_name");
        if (r12 == null) goto L25;
        r8.e.setText(r12);
    L25:
        if (this.f == null) goto L27;
        r8.f.setText(getString(2131902306));
    L27:
        Unit r13 = Unit.INSTANCE;
    L28:
        BottomSheetDialog r14 = getDialog();
        View r0 = null;
        if ((r14 instanceof BottomSheetDialog) == false) goto L31;
        BottomSheetDialog r15 = r14;
    L32:
        if (r15 == null) goto L34;
        r0 = r15.findViewById(2131368870);
    L34:
        if (r0 == null) goto L36;
        BottomSheetBehavior r16 = BottomSheetBehavior.from(r0);
        r16.setState(3);
        r16.setSkipCollapsed(true);
    L36:
        LarusDoraDialogNotiV3AddSpecialContactBinding r17 = this.d;
        if (r17 == null) goto L39;
        c r18 = new c(this);
        r17.d.addTextChangedListener(r18);
        r17.e.addTextChangedListener(r18);
        S90();
    L39:
        final LarusDoraDialogNotiV3AddSpecialContactBinding r20 = this.d;
        if (r20 == null) goto L43;
        e1.d(r20.b, new x59.a(this));
        e1.d(r20.c, new b(r20, this));
        Unit r21 = Unit.INSTANCE;
        return;
    L43:
        return;
    L31:
        r15 = null;
        goto L32
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        NestedScrollView r11 = r8.inflate(2131562165, r9, false);
        int r12 = 2131364673;
        AppCompatButton r2 = ViewBindings.findChildViewById(r11, 2131364673);
        if (r2 == null) goto L19;
        r12 = 2131364689;
        AppCompatButton r3 = ViewBindings.findChildViewById(r11, 2131364689);
        if (r3 == null) goto L19;
        r12 = 2131371792;
        AppCompatEditText r4 = ViewBindings.findChildViewById(r11, 2131371792);
        if (r4 == null) goto L19;
        r12 = 2131371794;
        AppCompatEditText r5 = ViewBindings.findChildViewById(r11, 2131371794);
        if (r5 == null) goto L19;
        r12 = 2131390155;
        if (((DoraTextView) ViewBindings.findChildViewById(r11, 2131390155)) == null) goto L19;
        r12 = 2131390388;
        if (((DoraTextView) ViewBindings.findChildViewById(r11, 2131390388)) == null) goto L19;
        r12 = 2131391606;
        DoraTextView r6 = (DoraTextView) ViewBindings.findChildViewById(r11, 2131391606);
        if (r6 == null) goto L19;
        NestedScrollView r13 = r11;
        this.d = new LarusDoraDialogNotiV3AddSpecialContactBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
