package com.larus.bmhome.chat.standarduikit.browsercontrol.utils;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import ej8.b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\tH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/browsercontrol/utils/BrowserControlTipDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "requestKey", "", "getRequestKey", "()Ljava/lang/String;", "resultReported", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "buildTrackParams", "Lcom/larus/bmhome/chat/standarduikit/browsercontrol/utils/BrowserControlTipDialogTracker$TrackParams;", "reportResultIfNeeded", "confirmed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BrowserControlTipDialog extends DialogFragment {
    public static final /* synthetic */ int e = 0;
    public boolean d;

    public static final class a {
        public a() {
        }

        public static BrowserControlTipDialog a(String r3, Integer r4, String r5, String r6, String r7) {
            BrowserControlTipDialog r0 = new BrowserControlTipDialog();
            Bundle r1 = new Bundle();
            r1.putString("arg_block_id", r3);
            if (r4 == null) goto L5;
            r1.putInt("arg_interaction_type", r4.intValue());
        L5:
            if (r5 == null) goto L7;
            r1.putString("pc_guide_request_key", r5);
        L7:
            if (r6 == null) goto L9;
            r1.putString("arg_display_type", r6);
        L9:
            if (r7 == null) goto L11;
            r1.putString("arg_agent_type", r7);
        L11:
            r0.setArguments(r1);
            return r0;
        }
    }

    static {
        new a();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[onStart] hasResultChannel=");
        Bundle r2 = getArguments();
        if (r2 == null) goto L5;
        String r3 = r2.getString("pc_guide_request_key");
    L6:
        if (r3 == null) goto L8;
        boolean r4 = true;
    L9:
        r1.append(r4);
        r0.i("BrowserControlTipDialog", r1.toString());
        Dialog r5 = getDialog();
        if (r5 == null) goto L15;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L16;
        WindowManager.LayoutParams r7 = r6.getAttributes();
        r7.width = -1;
        r7.height = -2;
        r7.gravity = 80;
        r6.setAttributes(r7);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r4 = false;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public BrowserControlTipDialog() {
    }

    public final void S90(boolean r7) {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("pc_guide_request_key");
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (this.d == false) goto L12;
        FLogger.a.d("BrowserControlTipDialog", "[result] duplicate ignored");
        return;
    L12:
        this.d = true;
        FLogger.a.i("BrowserControlTipDialog", "[result] confirmed=" + r7);
        o5.a(this, r1, BundleKt.bundleOf(new Pair[]{TuplesKt.to("confirmed", Boolean.valueOf(r7))}));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        Window r0 = r4.getWindow();
        if (r0 == null) goto L5;
        r0.setBackgroundDrawableResource(R.color.transparent);
    L5:
        r4.setCancelable(true);
        r4.setCanceledOnTouchOutside(true);
        return r4;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        Bundle r10 = getArguments();
        String r0 = null;
        if (r10 == null) goto L5;
        String r11 = r10.getString("arg_block_id");
    L6:
        Bundle r1 = getArguments();
        if (r1 != null) goto L9;
    L14:
        Integer r2 = null;
    L16:
        if (r11 != null) goto L18;
    L21:
        boolean r3 = true;
    L22:
        if (r3 == false) goto L24;
        final com.larus.bmhome.chat.standarduikit.browsercontrol.utils.a.C0005a r4 = null;
    L33:
        int r12 = com.larus.bmhome.chat.standarduikit.browsercontrol.utils.a.a;
        if (r4 == null) goto L48;
        o r13 = o.a;
        JSONObject r5 = new JSONObject();
        r5.put("popup_type", "interaction_mobile_fallback");
        r5.put("block_id", r4.a);
        r5.put("interaction_type", r4.b);
        String r6 = r4.c;
        if (r6 != null) goto L39;
    L41:
        r6 = null;
    L42:
        r5.putOpt("display_type", r6);
        String r7 = r4.d;
        if (r7 != null) goto L45;
    L47:
        r5.putOpt("agent_type", r0);
        Unit r14 = Unit.INSTANCE;
        r13.reportEvent("popup_show", r5);
        goto L48
    L45:
        if ((!StringsKt.isBlank(r7)) == false) goto L47;
        r0 = r7;
        goto L47
    L39:
        if ((!StringsKt.isBlank(r6)) == false) goto L41;
    L48:
        r8.findViewById(2131364691).setOnClickListener(new ej8.a(r4, this));
        Dialog r15 = getDialog();
        if (r15 == null) goto L51;
        r15.setCancelable(true);
    L51:
        Dialog r16 = getDialog();
        if (r16 == null) goto L55;
        r16.setOnCancelListener(new b(this));
        return;
    L55:
        return;
    L24:
        Bundle r17 = getArguments();
        if (r17 == null) goto L27;
        String r18 = r17.getString("arg_display_type");
    L28:
        Bundle r19 = getArguments();
        if (r19 == null) goto L31;
        String r20 = r19.getString("arg_agent_type");
    L32:
        r4 = new com.larus.bmhome.chat.standarduikit.browsercontrol.utils.a.C0005a(r11, r2, r18, r20);
        goto L33
    L31:
        r20 = null;
        goto L32
    L27:
        r18 = null;
        goto L28
    L18:
        if (StringsKt.isBlank(r11) == true) goto L21;
        r3 = false;
        goto L22
    L9:
        if (r1.containsKey("arg_interaction_type") == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L14;
        r2 = Integer.valueOf(r1.getInt("arg_interaction_type"));
        goto L16
    L5:
        r11 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562763, r3, false);
    }
}
