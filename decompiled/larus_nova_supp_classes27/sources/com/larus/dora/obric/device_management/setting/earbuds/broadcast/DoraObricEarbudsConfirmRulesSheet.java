package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OButton;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J.\u0010\u001f\u001a\u00020\u001a2\u001e\b\u0004\u0010 \u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\"\u0012\u0006\u0012\u0004\u0018\u00010#0!H\u0082\b¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000eH\u0002J\f\u0010)\u001a\u00020\u001a*\u00020*H\u0002J\u001a\u0010+\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u001aH\u0016J\f\u0010/\u001a\u000200*\u000200H\u0002J\f\u00101\u001a\u000200*\u000202H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00064"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsConfirmRulesSheet;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "getViewModel", "()Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "confirmButton", "Lcom/obric/oui/button/OButton;", "reDescribeButton", "originalDesc", "", "getOriginalDesc", "()Ljava/lang/String;", "generatedRules", "", "getGeneratedRules", "()Ljava/util/List;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "buildHeader", "", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "buildFooter", "observeViewModel", "launchAndRepeatWithLifecycle", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "buildBody", "Landroid/view/View;", "buildSectionLabel", "text", "applySectionLabelTextStyle", "Landroid/widget/TextView;", "buildCard", "isGeneratedRule", "", "onDestroyView", "dp", "", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsConfirmRulesSheet extends DialogFragment {
    public static final /* synthetic */ int g = 0;
    public final Lazy d;
    public OButton e;
    public OButton f;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        this.e = null;
        this.f = null;
        super.onDestroyView();
    }

    public DoraObricEarbudsConfirmRulesSheet() {
        this.d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CustomBroadcastRulesViewModel.class), new DoraObricEarbudsConfirmRulesSheet$special$$inlined$activityViewModels$default$1(this), new DoraObricEarbudsConfirmRulesSheet$special$$inlined$activityViewModels$default$2(this));
    }

    public final List<String> V90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L9;
        ArrayList<String> r1 = r0.getStringArrayList("arg_generated_rules");
        if (r1 == null) goto L9;
        List<String> r2 = CollectionsKt.toList(r1);
        if (r2 == null) goto L9;
        return r2;
    L9:
        return CollectionsKt.emptyList();
    }

    public final OSectionTitleBar T90(String r7) {
        OSectionTitleBar r0 = new OSectionTitleBar(requireContext(), null, 6, 0);
        r0.setTitleText(r7);
        r0.b(false);
        r0.a(false);
        LinearLayout r8 = (LinearLayout) r0.findViewById(2131367728);
        if (r8 == null) goto L5;
        r8.setPadding(U90(20), U90(8), U90(12), U90(8));
    L5:
        TextView r9 = (TextView) r0.findViewById(2131388792);
        if (r9 == null) goto L8;
        r9.setTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        r9.setTextSize(2, 12.0f);
        r9.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
    L8:
        r0.setLayoutParams(new LinearLayout.LayoutParams(U90(336), U90(32)));
        return r0;
    }

    public final int U90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final int W90(float r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public final Dialog onCreateDialog(Bundle r24) {
        OSheet r10 = new OSheet(requireContext(), 0, false, 30);
        OSheetBase.DefaultImpls.o(r10, OSheet.Header.ONLY_TITLE, null, getString(2131902235), getString(2131902232), false, null, null, 16166);
        TextView r1 = (TextView) r10.findViewById(2131372630);
        if (r1 == null) goto L10;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof LinearLayout.LayoutParams) == false) goto L7;
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2;
    L8:
        if (r3 == null) goto L10;
        r3.topMargin = U90(4);
        r1.setLayoutParams(r3);
        goto L10
    L7:
        r3 = null;
    L10:
        Context r4 = requireContext();
        LinearLayout r5 = new LinearLayout(r4);
        r5.setOrientation(1);
        r5.setPadding(0, 0, 0, U90(24));
        LinearLayout r6 = new LinearLayout(r4);
        r6.setOrientation(1);
        r6.setGravity(1);
        OSectionTitleBar r7 = T90(getString(2131902234));
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof LinearLayout.LayoutParams) == false) goto L13;
        LinearLayout.LayoutParams r9 = (LinearLayout.LayoutParams) r8;
    L14:
        if (r9 == null) goto L16;
        r9.topMargin = U90(8);
    L16:
        r6.addView(r7);
        Bundle r11 = getArguments();
        if (r11 == null) goto L19;
        String r12 = r11.getString("arg_original_desc");
    L20:
        if (r12 != null) goto L22;
        r12 = "";
    L22:
        r6.addView(S90(r12, false));
        OSectionTitleBar r13 = T90(getString(2131902233, new Object[]{String.valueOf(V90().size())}));
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof LinearLayout.LayoutParams) == false) goto L25;
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) r14;
    L27:
        if (r15 == null) goto L29;
        r15.topMargin = U90(16);
    L29:
        r6.addView(r13);
        Iterator<T> r16 = V90().iterator();
        int r17 = 0;
    L31:
        if (r16.hasNext() == false) goto L45;
        Object r18 = r16.next();
        int r110 = r17 + 1;
        if (r17 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        View r20 = S90((String) r18, true);
        ViewGroup.LayoutParams r111 = r20.getLayoutParams();
        if ((r111 instanceof LinearLayout.LayoutParams) == false) goto L38;
        LinearLayout.LayoutParams r112 = (LinearLayout.LayoutParams) r111;
    L39:
        if (r112 == null) goto L44;
        if (r17 != 0) goto L42;
        int r21 = 0;
    L43:
        r112.topMargin = r21;
        goto L44
    L42:
        r21 = U90(16);
    L44:
        r6.addView(r20);
        r17 = r110;
        goto L31
    L38:
        r112 = null;
        goto L39
    L45:
        NestedScrollView r22 = new NestedScrollView(r4);
        r22.setOverScrollMode(2);
        r22.addView(r6, new ViewGroup.LayoutParams(-1, -2));
        r5.addView(r22, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        OSheetBase.DefaultImpls.j(r10, r5);
        OSheetBase.DefaultImpls.k(r10, getString(2131902231), false, new j1(this), getString(2131902230), true, new k1(this));
        this.f = r10.findViewById(2131364771);
        OButton r23 = r10.findViewById(2131364794);
        this.e = r23;
        if (r23 == null) goto L48;
        r23.setSelected(true);
    L48:
        r10.setOnDismissListener(new i1(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsConfirmRulesSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$1(this, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsConfirmRulesSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2(this, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsConfirmRulesSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$3(this, null, this), 3, null);
        return r10;
    L25:
        r15 = null;
        goto L27
    L19:
        r12 = null;
        goto L20
    L13:
        r9 = null;
        goto L14
    }

    public final View S90(String r8, boolean r9) {
        Context r0 = requireContext();
        LinearLayout r1 = new LinearLayout(r0);
        r1.setOrientation(1);
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(0);
        r2.setCornerRadius(U90(20));
        r2.setColor(v19.c.a(2130970529, r0, 2131102529));
        r1.setBackground(r2);
        r1.setPadding(U90(8), U90(8), U90(8), U90(8));
        TextView r3 = new TextView(r0);
        r3.setText(r8);
        r3.setTextColor(v19.c.a(2130972079, r0, 2131103136));
        if (r9 == false) goto L5;
        float r10 = 15.0f;
    L6:
        r3.setTextSize(2, r10);
        if (r9 == false) goto L9;
        float r11 = 22.5f;
    L10:
        TextViewCompat.setLineHeight(r3, W90(r11));
        Typeface r12 = Typeface.create("sans-serif", 0);
        if (r9 == false) goto L13;
        int r13 = 500;
    L14:
        r3.setTypeface(Typeface.create(r12, r13, false));
        r3.setPadding(U90(12), U90(13), U90(12), U90(13));
        r1.addView(r3, new LinearLayout.LayoutParams(-1, -2));
        r1.setLayoutParams(new LinearLayout.LayoutParams(U90(328), -2));
        return r1;
    L13:
        r13 = 400;
        goto L14
    L9:
        r11 = 22.0f;
        goto L10
    L5:
        r10 = 16.0f;
        goto L6
    }
}
