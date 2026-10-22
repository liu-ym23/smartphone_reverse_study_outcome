package com.larus.account.saas.mfa.assist;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.larus.account.saas.mfa.assist.bean.MfaMessage;
import com.larus.account.saas.mfa.assist.bean.MfaPushCodeResponse;
import com.larus.account.saas.mfa.databinding.LarusAccountsdkDialogMfaBinding;
import com.larus.account.saas.runtime.internal.delegate.SaasSettings;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/mfa/assist/MfaDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "a", "account-saas-mfa_release"}, k = 1, mv = {1, 7, 1})
public final class MfaDialogFragment extends DialogFragment {
    public static final /* synthetic */ int i = 0;
    public MfaPushCodeResponse d;
    public LarusAccountsdkDialogMfaBinding e;
    public long f;
    public long g;
    public final d h;

    public static final class a {
    }

    static {
    }

    public final void U90() {
        LarusAccountsdkDialogMfaBinding r0 = this.e;
        if (r0 == null) goto L12;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L14;
        r1.removeCallbacks(this.h);
        long r2 = this.g - SystemClock.elapsedRealtime();
        if (r2 > 0) goto L10;
        S90(this);
        return;
    L10:
        r1.postDelayed(this.h, r2);
        return;
    L14:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.account.saas.mfa.assist.d] */
    public MfaDialogFragment() {
        this.h = new d(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        LarusAccountsdkDialogMfaBinding r0 = this.e;
        if (r0 == null) goto L7;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L7;
        r1.removeCallbacks(this.h);
    L7:
        this.e = null;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.addFlags(2);
        r1.setLayout(-1, -2);
        int r2 = getResources().getDimensionPixelSize(2131165281);
        int r3 = getResources().getDimensionPixelSize(2131165288);
        Resources r4 = getResources();
        int r5 = Math.min(WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).widthPixels - (r3 * 2), r2);
        WindowManager.LayoutParams r6 = r1.getAttributes();
        r6.width = r5;
        r1.setAttributes(r6);
    L7:
        U90();
    }

    public static void S90(MfaDialogFragment r1) {
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

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Bundle r6 = getArguments();
        if (r6 == null) goto L5;
        MfaMessage r7 = (MfaMessage) r6.getParcelable("mfa_message");
    L5:
        Bundle r8 = getArguments();
        Integer r0 = null;
        if (r8 == null) goto L8;
        MfaPushCodeResponse r9 = (MfaPushCodeResponse) r8.getParcelable("mfa_code_resp");
    L9:
        this.d = r9;
        Integer r10 = Integer.valueOf(SaasSettings.a.a("mfa_config", new JSONObject()).optInt("mfa_dialog_auto_dismiss_sec"));
        if (r10.intValue() <= 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
        r0 = r10;
    L15:
        if (r0 == null) goto L17;
        int r11 = r0.intValue();
    L18:
        this.f = ((long) r11) * 1000;
        this.g = SystemClock.elapsedRealtime() + this.f;
        return;
    L17:
        r11 = 300;
        goto L18
    L12:
        r1 = false;
        goto L13
    L8:
        r9 = null;
        goto L9
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.requestWindowFeature(1);
        r3.setCanceledOnTouchOutside(false);
        return r3;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        LarusAccountsdkDialogMfaBinding r5 = this.e;
        TextView r6 = null;
        if (r5 == null) goto L5;
        TextView r7 = r5.i;
    L6:
        if (r7 == null) goto L20;
        MfaPushCodeResponse r0 = this.d;
        if (r0 == null) goto L18;
        String r1 = r0.f;
        if (r1 == null) goto L18;
        if ((!StringsKt.isBlank(r1)) == true) goto L16;
        r1 = null;
    L16:
        if (r1 == null) goto L18;
    L19:
        r7.setText(r1);
    L18:
        r1 = getString(2131899099);
    L20:
        LarusAccountsdkDialogMfaBinding r8 = this.e;
        if (r8 == null) goto L23;
        TextView r9 = r8.h;
    L24:
        String r2 = "";
        if (r9 == null) goto L34;
        MfaPushCodeResponse r10 = this.d;
        if (r10 == null) goto L30;
        String r11 = r10.g;
    L31:
        if (r11 != null) goto L33;
        r11 = "";
    L33:
        r9.setText(r11);
        goto L34
    L30:
        r11 = null;
    L34:
        LarusAccountsdkDialogMfaBinding r12 = this.e;
        if (r12 == null) goto L39;
        TextView r13 = r12.c;
        if (r13 == null) goto L39;
        r13.setOnClickListener(new e(this));
    L39:
        LarusAccountsdkDialogMfaBinding r14 = this.e;
        if (r14 == null) goto L44;
        TextView r15 = r14.b;
        if (r15 == null) goto L44;
        r15.setOnClickListener(new f(this));
    L44:
        LarusAccountsdkDialogMfaBinding r16 = this.e;
        if (r16 == null) goto L49;
        TextView r17 = r16.d;
        if (r17 == null) goto L49;
        r17.setOnClickListener(new g(this));
    L49:
        LarusAccountsdkDialogMfaBinding r19 = this.e;
        if (r19 == null) goto L52;
        TextView r20 = r19.l;
    L53:
        if (r20 == null) goto L62;
        MfaPushCodeResponse r21 = this.d;
        if (r21 == null) goto L58;
        String r22 = r21.c;
    L59:
        if (r22 != null) goto L61;
        r22 = "";
    L61:
        r20.setText(r22);
        goto L62
    L58:
        r22 = null;
    L62:
        LarusAccountsdkDialogMfaBinding r23 = this.e;
        if (r23 == null) goto L65;
        TextView r24 = r23.g;
    L66:
        if (r24 == null) goto L76;
        MfaPushCodeResponse r25 = this.d;
        if (r25 == null) goto L71;
        String r26 = r25.d;
    L72:
        if (r26 == null) goto L75;
        r2 = r26;
    L75:
        r24.setText(r2);
        goto L76
    L71:
        r26 = null;
    L76:
        LarusAccountsdkDialogMfaBinding r27 = this.e;
        if (r27 == null) goto L79;
        LinearLayout r29 = r27.k;
    L81:
        if (r29 == null) goto L84;
        r29.setVisibility(0);
    L84:
        LarusAccountsdkDialogMfaBinding r30 = this.e;
        if (r30 == null) goto L87;
        FrameLayout r31 = r30.j;
    L89:
        if (r31 == null) goto L92;
        r31.setVisibility(8);
    L92:
        LarusAccountsdkDialogMfaBinding r32 = this.e;
        if (r32 == null) goto L95;
        LinearLayout r33 = r32.e;
    L96:
        if (r33 == null) goto L99;
        r33.setVisibility(0);
    L99:
        LarusAccountsdkDialogMfaBinding r34 = this.e;
        if (r34 == null) goto L102;
        r6 = r34.d;
    L102:
        if (r6 == null) goto L105;
        r6.setVisibility(8);
    L105:
        T90("enter", "enter_step", "confirm_login_popup");
        return;
    L95:
        r33 = null;
        goto L96
    L87:
        r31 = null;
        goto L89
    L79:
        r29 = null;
        goto L81
    L65:
        r24 = null;
        goto L66
    L52:
        r20 = null;
        goto L53
    L23:
        r9 = null;
        goto L24
    L5:
        r7 = null;
        goto L6
    }

    public static void T90(String r4, String r5, String r6) {
        SaasTracking r0 = SaasTracking.a;
        JSONObject r1 = new JSONObject();
        r1.put("mfa_method", "trusted_device");
        r1.put("step_type", r4);
        r1.put(r5, r6);
        Unit r7 = Unit.INSTANCE;
        r0.reportEvent("account_mfa_approval_interaction", r1);
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r19, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Dialog r1 = getDialog();
        if (r1 == null) goto L7;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L7;
        r2.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        View r0 = r17.inflate(2131561778, r19, false);
        int r3 = 2131380031;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r0, 2131380031);
        if (r5 == null) goto L36;
        r3 = 2131380032;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r0, 2131380032);
        if (r6 == null) goto L36;
        r3 = 2131380033;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r0, 2131380033);
        if (r7 == null) goto L36;
        r3 = 2131380034;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131380034);
        if (r8 == null) goto L36;
        r3 = 2131380035;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r0, 2131380035);
        if (r9 == null) goto L36;
        r3 = 2131380036;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r0, 2131380036);
        if (r10 == null) goto L36;
        r3 = 2131380037;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131380037)) == null) goto L36;
        r3 = 2131380038;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r0, 2131380038);
        if (r11 == null) goto L36;
        r3 = 2131380039;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131380039)) == null) goto L36;
        r3 = 2131380040;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r0, 2131380040);
        if (r12 == null) goto L36;
        r3 = 2131380041;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131380041);
        if (r13 == null) goto L36;
        r3 = 2131380042;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131380042);
        if (r14 == null) goto L36;
        r3 = 2131380043;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131380043);
        if (r15 == null) goto L36;
        LinearLayout r4 = (LinearLayout) r0;
        this.e = new LarusAccountsdkDialogMfaBinding(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        return r4;
    L36:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r3)));
    }
}
