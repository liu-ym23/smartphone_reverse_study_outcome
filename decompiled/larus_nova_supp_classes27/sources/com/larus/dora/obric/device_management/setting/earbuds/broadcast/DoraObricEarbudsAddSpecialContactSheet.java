package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.forms.OInputView;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\f\u0010\u001d\u001a\u00020\u0019*\u00020\u0019H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAddSpecialContactSheet;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "appNameInput", "Lcom/obric/oui/forms/OInputView;", "contactNameInput", "confirmBtn", "Lcom/obric/oui/button/OIconButtonFloating;", "contactId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "buildBody", "Landroid/view/View;", "buildInput", "label", "hint", "inputParams", "Landroid/widget/LinearLayout$LayoutParams;", "topMarginDp", "", "validateInputs", "handleConfirm", "resolveSheetBackgroundColor", "dp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsAddSpecialContactSheet extends DialogFragment {
    public static final /* synthetic */ int h = 0;
    public OInputView d;
    public OInputView e;
    public OIconButtonFloating f;
    public String g;

    public static final class a {
    }

    static {
    }

    public final void U90() {
        OInputView r0 = this.d;
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getText();
        if (r2 == null) goto L7;
        String r3 = StringsKt.trim(r2).toString();
    L8:
        String r4 = "";
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        OInputView r5 = this.e;
        if (r5 == null) goto L16;
        String r6 = r5.getText();
        if (r6 == null) goto L16;
        r1 = StringsKt.trim(r6).toString();
    L16:
        if (r1 == null) goto L19;
        r4 = r1;
    L19:
        boolean r7 = true;
        if (r3.length() <= 0) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L25;
    L30:
        r7 = false;
    L31:
        OIconButtonFloating r9 = this.f;
        if (r9 == null) goto L34;
        r9.setEnabled(r7);
    L34:
        OIconButtonFloating r10 = this.f;
        if (r10 == null) goto L41;
        if (r7 == false) goto L38;
        float r11 = 1.0f;
    L39:
        r10.setAlpha(r11);
        return;
    L38:
        r11 = 0.3f;
        goto L39
    L41:
        return;
    L25:
        if (r4.length() <= 0) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == false) goto L30;
    L27:
        r12 = false;
        goto L28
    L22:
        r8 = false;
    L7:
        r3 = null;
        goto L8
    }

    public DoraObricEarbudsAddSpecialContactSheet() {
    }

    public final int T90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        String r4 = r3.getString("key_contact_id");
    L6:
        this.g = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r10) {
        OSheet r11 = new OSheet(requireContext(), 0, false, 30);
        OSheetBase.DefaultImpls.r(r11, ContextCompat.getColor(requireContext(), 2131102535));
        Window r0 = r11.getWindow();
        if (r0 == null) goto L5;
        r0.setSoftInputMode(21);
    L5:
        Context r1 = requireContext();
        if (this.g == null) goto L8;
        String r3 = getString(2131902306);
    L9:
        Intrinsics.checkNotNull(r3);
        q2 r2 = t2.a(r1, r3, new o(this), new p(this));
        OIconButtonFloating r4 = r2.b;
        r4.setAlpha(0.3f);
        r4.setEnabled(false);
        this.f = r4;
        OSheetBase.DefaultImpls.p(r11, r2.a);
        LinearLayout r5 = new LinearLayout(requireContext());
        r5.setOrientation(1);
        r5.setPadding(T90(12), T90(12), T90(12), T90(16));
        r5.setBackgroundColor(ContextCompat.getColor(requireContext(), 2131102535));
        r5.setFocusableInTouchMode(true);
        r5.setFocusable(true);
        View r6 = S90(getString(2131902302), getString(2131902301));
        this.d = r6;
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-1, -2);
        r7.topMargin = T90(0);
        r5.addView(r6, r7);
        View r8 = S90(getString(2131902307), getString(2131902313));
        this.e = r8;
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-1, -2);
        r9.topMargin = T90(16);
        r5.addView(r8, r9);
        Bundle r12 = getArguments();
        if (r12 == null) goto L16;
        String r13 = r12.getString("key_app_name");
        if (r13 == null) goto L16;
        OInputView r14 = this.d;
        if (r14 == null) goto L16;
        r14.setText(r13);
    L16:
        Bundle r15 = getArguments();
        if (r15 == null) goto L23;
        String r16 = r15.getString("key_chat_name");
        if (r16 == null) goto L23;
        OInputView r17 = this.e;
        if (r17 == null) goto L23;
        r17.setText(r16);
    L23:
        s r18 = new s(this);
        OInputView r20 = this.d;
        if (r20 == null) goto L26;
        r20.E.addTextChangedListener(r18);
    L26:
        OInputView r21 = this.e;
        if (r21 == null) goto L29;
        r21.E.addTextChangedListener(r18);
    L29:
        U90();
        OSheetBase.DefaultImpls.j(r11, r5);
        r11.setOnShowListener(new q(this));
        return r11;
    L8:
        r3 = getString(2131902309);
        goto L9
    }

    public final OInputView S90(String r6, String r7) {
        OInputView r0 = new OInputView(requireContext(), null, 6, 0);
        r0.setLabel(r6);
        r0.setHint(r7);
        r0.setShowLabel(true);
        r0.setShowLabelIcon(false);
        r0.setSingleLine(true);
        r0.setInputType(1);
        r0.setRadius(T90(20));
        r0.f = true;
        r0.b6(true);
        r0.setBgResId(2131244226);
        TextView r8 = (TextView) r0.findViewById(2131381130);
        if (r8 == null) goto L5;
        r8.setTextColor(ContextCompat.getColor(requireContext(), 2131103136));
    L5:
        return r0;
    }
}
