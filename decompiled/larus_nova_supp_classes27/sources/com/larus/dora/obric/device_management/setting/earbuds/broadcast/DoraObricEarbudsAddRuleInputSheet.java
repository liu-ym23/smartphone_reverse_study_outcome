package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OEditText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J.\u0010\u001f\u001a\u00020\u00192\u001e\b\u0004\u0010 \u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\"\u0012\u0006\u0012\u0004\u0018\u00010#0!H\u0082\b¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0002J\f\u0010*\u001a\u00020\u0019*\u00020\rH\u0002J\u0010\u0010+\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020\u0019H\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020&H\u0002J\b\u00100\u001a\u00020\u0019H\u0002J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u0011H\u0002J\b\u00106\u001a\u00020\u0019H\u0016J\f\u00107\u001a\u000203*\u000203H\u0002J\f\u00108\u001a\u000203*\u000209H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006;"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAddRuleInputSheet;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "getViewModel", "()Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "ruleInput", "Landroid/widget/EditText;", "charCount", "Landroid/widget/TextView;", "generateButton", "Lcom/obric/oui/button/OButton;", "isLoading", "", "editingRule", "Lcom/larus/dora/api/entity/NotificationRule;", "getEditingRule", "()Lcom/larus/dora/api/entity/NotificationRule;", "isEditMode", "()Z", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "observeViewModel", "launchAndRepeatWithLifecycle", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "buildContent", "Landroid/view/View;", "buildInputLabel", "context", "Landroid/content/Context;", "applyLabelTextStyle", "buildInputCard", "buildInputField", "focusRuleInput", "showKeyboard", "input", "handleAction", "updateCharCount", "length", "", "updateGenerateEnabled", "enabled", "onDestroy", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsAddRuleInputSheet extends DialogFragment {
    public static final /* synthetic */ int i = 0;
    public final Lazy d;
    public OEditText e;
    public TextView f;
    public OButton g;
    public boolean h;

    public static final class a {
    }

    static {
    }

    public final void onDestroy() {
        this.e = null;
        this.f = null;
        this.g = null;
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void T90() {
        final OEditText r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.requestFocus();
        Editable r1 = r0.getText();
        if (r1 == null) goto L8;
        int r2 = r1.length();
    L9:
        r0.setSelection(r2);
        r0.post(new g(this, r0));
        return;
    L8:
        r2 = 0;
        goto L9
    }

    public final CustomBroadcastRulesViewModel V90() {
        return (CustomBroadcastRulesViewModel) this.d.getValue();
    }

    public DoraObricEarbudsAddRuleInputSheet() {
        this.d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CustomBroadcastRulesViewModel.class), new DoraObricEarbudsAddRuleInputSheet$special$$inlined$activityViewModels$default$1(this), new DoraObricEarbudsAddRuleInputSheet$special$$inlined$activityViewModels$default$2(this));
    }

    public final NotificationRule U90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        Serializable r1 = r0.getSerializable("arg_rule");
    L7:
        if ((r1 instanceof NotificationRule) == true) goto L9;
        return null;
    L9:
        return (NotificationRule) r1;
    L5:
        r1 = null;
        goto L7
    }

    public final int S90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void W90(boolean r2) {
        if (r2 == true) goto L4;
    L6:
        boolean r3 = false;
    L7:
        OButton r0 = this.g;
        if (r0 == null) goto L10;
        r0.setEnabled(r3);
    L10:
        OButton r1 = this.g;
        if (r1 == null) goto L17;
        if (r3 == false) goto L14;
        float r4 = 1.0f;
    L15:
        r1.setAlpha(r4);
        return;
    L14:
        r4 = 0.3f;
        goto L15
    L17:
        return;
    L4:
        if (this.h == true) goto L6;
        r3 = true;
        goto L7
    }

    public final void onCreate(Bundle r25) {
        super.onCreate(r25);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$1(this, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2(this, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$3(this, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$4(this, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$5(this, null, this), 3, null);
    }

    public final Dialog onCreateDialog(Bundle r17) {
        boolean r11 = false;
        OSheet r10 = new OSheet(requireContext(), 0, false, 30);
        OSheetBase.DefaultImpls.q(r10, OSheet.HeightMode.FULL_HEIGHT);
        OSheet.Header r2 = OSheet.Header.PAGE;
        if (U90() == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        int r3 = 2131902252;
    L9:
        OSheetBase.DefaultImpls.o(r10, r2, null, getString(r3), null, false, new com.larus.dora.obric.device_management.setting.earbuds.broadcast.a(this), null, 16182);
        Context r4 = requireContext();
        LinearLayout r5 = new LinearLayout(r4);
        r5.setOrientation(1);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        OSectionTitleBar r6 = new OSectionTitleBar(r4, null, 6, 0);
        r6.setTitleText(getString(2131902714));
        r6.b(false);
        r6.a(false);
        LinearLayout r7 = (LinearLayout) r6.findViewById(2131367728);
        if (r7 == null) goto L12;
        r7.setPadding(S90(20), S90(8), S90(12), S90(8));
    L12:
        TextView r8 = (TextView) r6.findViewById(2131388792);
        if (r8 == null) goto L15;
        r8.setTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        r8.setTextSize(2, 12.0f);
        r8.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
    L15:
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-1, S90(32));
        r9.topMargin = S90(8);
        Unit r12 = Unit.INSTANCE;
        r5.addView(r6, r9);
        LinearLayout r13 = new LinearLayout(r4);
        r13.setOrientation(1);
        GradientDrawable r14 = new GradientDrawable();
        r14.setShape(0);
        r14.setCornerRadius(S90(20));
        r14.setColor(v19.c.a(2130970529, r4, 2131102529));
        r13.setBackground(r14);
        r13.setPadding(S90(8), S90(8), S90(8), S90(8));
        LinearLayout r15 = new LinearLayout(r4);
        r15.setOrientation(1);
        r15.setPadding(S90(12), S90(8), S90(12), S90(8));
        final OEditText r16 = new OEditText(r4, null, 6, 0);
        r16.setHint(getString(2131902228));
        r16.setBackground(null);
        r16.setGravity(8388659);
        r16.setIncludeFontPadding(false);
        r16.setFocusable(true);
        r16.setFocusableInTouchMode(true);
        r16.setSingleLine(false);
        r16.setInputType(147457);
        r16.setHintTextColor(v19.c.a(2130972080, r4, 2131103140));
        r16.setTextColor(v19.c.a(2130972079, r4, 2131103136));
        r16.setTextSize(2, 16.0f);
        Resources r18 = getResources();
        TextViewCompat.setLineHeight(r16, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r18, r18.getDisplayMetrics())));
        r16.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(300)});
        r16.setOnClickListener(new e(this));
        r16.setOnFocusChangeListener(new f(r16, this));
        r16.addTextChangedListener(new i(this));
        NotificationRule r20 = U90();
        if (r20 == null) goto L18;
        String r21 = r20.getRuleDesc();
    L19:
        if (r21 != null) goto L22;
        r21 = "";
    L22:
        if (r21.length() <= 0) goto L24;
        boolean r110 = true;
    L25:
        if (r110 == true) goto L28;
        r21 = null;
    L28:
        if (r21 == null) goto L33;
        r16.setText(r21);
        r16.setSelection(r21.length());
        int r22 = r21.length();
        TextView r111 = this.f;
        if (r111 == null) goto L32;
        r111.setText(r22 + "/300");
    L32:
        W90(true);
    L33:
        this.e = r16;
        r15.addView(r16, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        TextView r23 = new TextView(r4);
        r23.setText("0/300");
        r23.setGravity(8388613);
        r23.setIncludeFontPadding(false);
        r23.setTextColor(v19.c.a(2130972081, r4, 2131103143));
        r23.setTextSize(2, 10.0f);
        this.f = r23;
        LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(-1, -2);
        r24.topMargin = S90(6);
        r15.addView(r23, r24);
        r13.addView(r15, new LinearLayout.LayoutParams(-1, S90(146)));
        r13.setOnClickListener(new c(this));
        r15.setOnClickListener(new d(this));
        LinearLayout.LayoutParams r25 = new LinearLayout.LayoutParams(-1, S90(162));
        r25.setMarginStart(S90(12));
        r25.setMarginEnd(S90(12));
        r5.addView(r13, r25);
        OSheetBase.DefaultImpls.j(r10, r5);
        if (U90() == null) goto L36;
        boolean r26 = true;
    L37:
        if (r26 == false) goto L39;
        int r27 = 2131902220;
    L40:
        OSheetBase.DefaultImpls.l(r10, getString(r27), new b(this));
        Intrinsics.checkNotNullParameter(r10, "this");
        OButton r28 = r10.getFooterContainer().findViewById(2131364794);
        if ((r28 instanceof OButton) == false) goto L43;
        OButton r30 = r28;
    L44:
        this.g = r30;
        OEditText r31 = this.e;
        if (r31 == null) goto L54;
        Editable r32 = r31.getText();
        if (r32 == null) goto L54;
        if (r32.length() <= 0) goto L51;
        boolean r33 = true;
    L52:
        if (r33 != true) goto L54;
        r11 = true;
        goto L54
    L51:
        r33 = false;
    L54:
        W90(r11);
        Window r34 = r10.getWindow();
        if (r34 == null) goto L57;
        r34.setSoftInputMode(16);
    L57:
        return r10;
    L43:
        r30 = null;
        goto L44
    L39:
        r27 = 2131902226;
        goto L40
    L36:
        r26 = false;
        goto L37
    L24:
        r110 = false;
        goto L25
    L18:
        r21 = null;
        goto L19
    L8:
        r3 = 2131902212;
        goto L9
    L5:
        r1 = false;
        goto L6
    }
}
