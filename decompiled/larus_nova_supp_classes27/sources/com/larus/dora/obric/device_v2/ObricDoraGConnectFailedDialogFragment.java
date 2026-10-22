package com.larus.dora.obric.device_v2;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/dora/obric/device_v2/ObricDoraGConnectFailedDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "device", "Lcom/bytedance/dora/device/DoraDevice;", "getDevice", "()Lcom/bytedance/dora/device/DoraDevice;", "setDevice", "(Lcom/bytedance/dora/device/DoraDevice;)V", "onReconnectClick", "Lkotlin/Function0;", "", "getOnReconnectClick", "()Lkotlin/jvm/functions/Function0;", "setOnReconnectClick", "(Lkotlin/jvm/functions/Function0;)V", "enterPageTraced", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "createBodyView", "Landroid/widget/FrameLayout;", "getConnectFailedMessage", "", "dpToPx", "", "dp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDoraGConnectFailedDialogFragment extends DialogFragment {
    public static final /* synthetic */ int g = 0;
    public DoraDevice d;
    public Function0<Unit> e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.f == true) goto L6;
        j49.b.d();
        this.f = true;
        return;
    }

    public ObricDoraGConnectFailedDialogFragment() {
    }

    public static void S90(ObricDoraGConnectFailedDialogFragment r1) {
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

    public final int T90(float r3) {
        Resources r0 = getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public final Dialog onCreateDialog(Bundle r22) {
        OSheet r10 = new OSheet(requireContext(), 0, false, 14);
        OSheetBase.DefaultImpls.q(r10, OSheet.HeightMode.WRAP_HEIGHT);
        OSheetBase.DefaultImpls.r(r10, Color.argb(255, 255, 255, 255));
        OSheetBase.DefaultImpls.o(r10, OSheet.Header.MODAL, null, getString(2131902387), null, false, null, new e(this), 16166);
        FrameLayout r1 = new FrameLayout(requireContext());
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, T90(164.0f)));
        TextView r2 = new TextView(r1.getContext());
        DoraDevice r3 = this.d;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L9:
        if (r4 == false) goto L11;
        String r5 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Integer[]{2131903539, 2131903540, 2131903541, 2131903542}), "\n", null, null, 0, null, new h(), 30, null);
    L12:
        r2.setText(r5);
        r2.setGravity(8388659);
        r2.setTextSize(2, 16.0f);
        r2.setTypeface(Typeface.create("sans-serif", 0));
        Resources r6 = r2.getResources();
        TextViewCompat.setLineHeight(r2, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        r2.setTextColor(r2.getContext().getColor(2131104350));
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-1, -1);
        r7.setMargins(T90(20.0f), T90(16.0f), T90(20.0f), T90(16.0f));
        Unit r8 = Unit.INSTANCE;
        r1.addView(r2, r7);
        OSheetBase.DefaultImpls.j(r10, r1);
        OSheetBase.DefaultImpls.l(r10, getString(2131902344), new f(this));
        r10.setOnDismissListener(new g(this));
        return r10;
    L11:
        int r9 = j0.a;
        r5 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{j0.d(2131902893), j0.d(2131902890), j0.d(2131902891), j0.d(2131902892)}), "\n", null, null, 0, null, null, 62, null);
        goto L12
    L5:
        if (r3.productId != ProductNameType.DORA_G2.id) goto L7;
        r4 = true;
        goto L9
    }
}
