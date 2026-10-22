package com.larus.dora.obric.device_management.device_home;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005H\u0002J\n\u0010&\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010'\u001a\u00020\u000fH\u0002J\b\u0010(\u001a\u00020\u000fH\u0002J\f\u0010)\u001a\u00020\u000f*\u00020\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricGOtaCompletionSheet;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "version", "", "getVersion", "()Ljava/lang/String;", "descText", "getDescText", "descDetail", "getDescDetail", "deviceSn", "getDeviceSn", "deviceProductId", "", "getDeviceProductId", "()I", "isFor", "", "deviceKey", "Lcom/larus/dora/impl/ota/g2/DeviceKey;", "isFor$impl_mainlandRelease", "markdownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "getMarkdownInfo", "()Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "markdownInfo$delegate", "Lkotlin/Lazy;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "buildBody", "Landroid/view/View;", "buildInfoText", "Landroid/widget/TextView;", "text", "buildNotesView", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "dp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGOtaCompletionSheet extends DialogFragment {
    public static final /* synthetic */ int e = 0;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    public DoraObricGOtaCompletionSheet() {
        this.d = LazyKt.lazy(new m2(this));
    }

    public final String T90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("arg_desc_detail");
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public static void S90(DoraObricGOtaCompletionSheet r1) {
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

    public final Dialog onCreateDialog(Bundle r14) {
        OSheet r15 = new OSheet(requireContext(), 0, false, 30);
        OSheetBase.DefaultImpls.q(r15, OSheet.HeightMode.WRAP_HEIGHT);
        OSheet.Header r1 = OSheet.Header.MODAL;
        String r3 = getString(2131903628);
        Object[] r0 = new Object[1];
        Bundle r4 = getArguments();
        String r11 = null;
        MarkdownTextView r12 = null;
        if (r4 == null) goto L5;
        String r5 = r4.getString("arg_version");
    L6:
        String r13 = "";
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        r0[0] = r5;
        OSheetBase.DefaultImpls.o(r15, r1, null, r3, getString(2131903814, r0), false, null, new n2(this), 16134);
        Context r2 = requireContext();
        String r6 = getString(2131898390);
        TextView r7 = new TextView(requireContext());
        r7.setIncludeFontPadding(false);
        r7.setGravity(8388611);
        r7.setText(r6);
        r7.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r7.setTextSize(2, 16.0f);
        if (T90().length() != 0) goto L12;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L27;
        Bundle r9 = getArguments();
        if (r9 == null) goto L18;
        String r10 = r9.getString("arg_desc_text");
    L19:
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        if (r10.length() != 0) goto L24;
        boolean r16 = true;
    L25:
        if (r16 == false) goto L27;
    L52:
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r7, "notesTitleView");
        LinearLayout r17 = new LinearLayout(r2);
        r17.setOrientation(1);
        r17.setPadding(q2.a(16, r2), q2.a(16, r2), q2.a(16, r2), q2.a(24, r2));
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-1, -2);
        r18.topMargin = q2.a(0, r2);
        r17.addView(r7, r18);
        if (r12 == null) goto L55;
        LinearLayout.LayoutParams r20 = new LinearLayout.LayoutParams(-1, -2);
        r20.topMargin = q2.a(12, r2);
        r17.addView(r12, r20);
    L55:
        NestedScrollView r21 = new NestedScrollView(r2);
        r21.setOverScrollMode(2);
        r21.setFillViewport(true);
        r21.addView(r17, new ViewGroup.LayoutParams(-1, -2));
        OSheetBase.DefaultImpls.j(r15, r21);
        OSheetBase.DefaultImpls.l(r15, getString(2131903627), new o2(this));
        r15.setOnDismissListener(new p2(this));
        return r15;
    L24:
        r16 = false;
        goto L25
    L18:
        r10 = null;
    L27:
        MarkdownTextView r22 = new MarkdownTextView(requireContext(), null, 6, 0);
        r22.setIncludeFontPadding(false);
        r22.setTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        r22.setTextSize(2, 14.0f);
        r22.setLineSpacing(0.0f, 1.4285715f);
        if (T90().length() <= 0) goto L30;
        boolean r23 = true;
    L31:
        if (r23 == false) goto L35;
        gw8.c.a.getClass();
        gw8.c r24 = gw8.c.a.b();
        if (r24 == null) goto L35;
        lw8.l r25 = gw8.c.b.b(r24, r22, T90(), false, (lw8.d) this.d.getValue());
    L36:
        if (r25 == null) goto L38;
        r22.setMarkdown(r25);
    L51:
        r12 = r22;
        goto L52
    L38:
        Bundle r26 = getArguments();
        if (r26 == null) goto L41;
        r11 = r26.getString("arg_desc_text");
    L41:
        if (r11 == null) goto L45;
        r13 = r11;
    L45:
        if (r13.length() != 0) goto L47;
        boolean r27 = true;
    L48:
        if (r27 == false) goto L50;
        r13 = T90();
    L50:
        r22.setText(r13);
        goto L51
    L47:
        r27 = false;
    L35:
        r25 = null;
        goto L36
    L30:
        r23 = false;
        goto L31
    L12:
        r8 = false;
        goto L14
    L5:
        r5 = null;
        goto L6
    }
}
