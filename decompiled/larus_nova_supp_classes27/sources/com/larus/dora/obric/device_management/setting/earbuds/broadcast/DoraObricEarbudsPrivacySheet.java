package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.LinearLayout;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0014H\u0002J\f\u0010\u0015\u001a\u00020\u0014*\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsPrivacySheet;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "agreeButton", "Lcom/obric/oui/button/OButton;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "buildHeader", "", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "buildBody", "Landroid/view/View;", "buildContentText", "buildAgreeButton", "onDestroyView", "dp", "", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsPrivacySheet extends DialogFragment {
    public static final /* synthetic */ int d = 0;

    public static final class a {
    }

    static {
    }

    public DoraObricEarbudsPrivacySheet() {
    }

    public final void onDestroyView() {
        super.onDestroyView();
    }

    public static void S90(DoraObricEarbudsPrivacySheet r1) {
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

    public final int T90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.larus.common_ui.widget.UrlSpanTextView] */
    public final Dialog onCreateDialog(Bundle r11) {
        OSheet r12 = new OSheet(requireContext(), 0, false, 30);
        setCancelable(false);
        q2 r0 = t2.a(requireContext(), getString(2131902202), new h2(this), new i2());
        r0.b.setVisibility(8);
        OSheetBase.DefaultImpls.p(r12, r0.a);
        LinearLayout r1 = new LinearLayout(requireContext());
        r1.setOrientation(1);
        r1.setPadding(T90(24), T90(8), T90(24), T90(24));
        ?? r2 = new UrlSpanTextView(requireContext(), null, 6, 0);
        r2.setUrlSpannedText(getString(2131902203) + "\n\n" + getString(2131902204) + ' ');
        r2.setTextColor(v19.c.a(2130972082, r2.getContext(), 2131103146));
        r2.setTextSize(2, 14.0f);
        Resources r3 = getResources();
        TextViewCompat.setLineHeight(r2, (int) TypedValue.applyDimension(2, 20.0f, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        r2.setOnClickListener(new k2(r2));
        r1.addView(r2, new LinearLayout.LayoutParams(-1, -2));
        OButton r4 = new OButton(requireContext(), null, 0, 28);
        r4.setGravity(17);
        r4.setMinHeight(T90(56));
        r4.setMinimumHeight(T90(56));
        r4.setAllCaps(false);
        r4.setIncludeFontPadding(false);
        r4.setText(getString(2131902201));
        r4.setTextSize(2, 17.0f);
        Resources r6 = getResources();
        TextViewCompat.setLineHeight(r4, (int) TypedValue.applyDimension(2, 24.0f, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        r4.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        com.larus.utils.e1.d(r4, new j2(this));
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-1, T90(56));
        r5.topMargin = T90(40);
        Unit r7 = Unit.INSTANCE;
        r1.addView(r4, r5);
        OSheetBase.DefaultImpls.j(r12, r1);
        r12.setOnDismissListener(new g2(this));
        return r12;
    }
}
