package com.bytedance.android.live.recharge;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.utils.e4;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/recharge/RechargeSecurityConfirmDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeSecurityConfirmDialogFragment extends LiveDialogFragment {
    public static final /* synthetic */ int p = 0;
    public View d;
    public ToggleButton e;
    public ToggleButton f;
    public ToggleButton g;
    public LinearLayoutCompat h;
    public LinearLayoutCompat i;
    public LinearLayoutCompat j;
    public TextView k;
    public TextView l;
    public HSImageView m;
    public boolean n;
    public com.bytedance.android.live.recharge.panel.context.c o;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnDismissListener {
        public final /* synthetic */ RechargeSecurityConfirmDialogFragment a;

        public b(RechargeSecurityConfirmDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            if (this.a.n == false) goto L5;
            int r3 = ToastUtil.a;
            ToastUtil.b(s1.B(2131915660), 0);
        L5:
            com.bytedance.android.live.recharge.panel.context.c r4 = this.a.o;
            if (r4 == null) goto L9;
            com.bytedance.android.live.recharge.panel.context.d.a(r4, false);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ RechargeSecurityConfirmDialogFragment a;

        public c(RechargeSecurityConfirmDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            RechargeSecurityConfirmDialogFragment r3 = this.a;
            RechargeSecurityConfirmDialogFragment.S90(r3, r3.e);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ RechargeSecurityConfirmDialogFragment a;

        public d(RechargeSecurityConfirmDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            RechargeSecurityConfirmDialogFragment r3 = this.a;
            RechargeSecurityConfirmDialogFragment.S90(r3, r3.f);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ RechargeSecurityConfirmDialogFragment a;

        public e(RechargeSecurityConfirmDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            RechargeSecurityConfirmDialogFragment r3 = this.a;
            RechargeSecurityConfirmDialogFragment.S90(r3, r3.g);
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ RechargeSecurityConfirmDialogFragment a;

        public f(RechargeSecurityConfirmDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_recharge_safe_confirm_cancel_click", false, 0);
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L12;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ RechargeSecurityConfirmDialogFragment a;

        public g(RechargeSecurityConfirmDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_recharge_safe_confirm_cancel_click", false, 0);
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L12;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ RechargeSecurityConfirmDialogFragment a;

        public h(RechargeSecurityConfirmDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            RechargeSecurityConfirmDialogFragment r5 = this.a;
            int r0 = RechargeSecurityConfirmDialogFragment.p;
            if (r5.T90() == false) goto L17;
            com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_recharge_safe_confirm_continue_click", false, 0);
            com.bytedance.android.live.recharge.panel.context.c r6 = this.a.o;
            if (r6 == null) goto L7;
            com.bytedance.android.live.recharge.util.j.a(r6);
        L7:
            RechargeSecurityConfirmDialogFragment r7 = this.a;
            r7.n = false;
            r7.dismiss();     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r8 = DialogFragmentLancet.sLastShowStack;
            if (r8 == null) goto L18;
            com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L18:
            return;
        }
    }

    static {
    }

    public final boolean T90() {
        ToggleButton r0 = this.e;
        if (r0 != null) goto L5;
    L15:
        return false;
    L5:
        if (r0.isChecked() != true) goto L15;
        ToggleButton r1 = this.f;
        if (r1 == null) goto L15;
        if (r1.isChecked() != true) goto L15;
        ToggleButton r2 = this.g;
        if (r2 == null) goto L15;
        if (r2.isChecked() != true) goto L15;
        return true;
    }

    public RechargeSecurityConfirmDialogFragment() {
        this.n = true;
    }

    public final void dismiss() {
        super.dismiss();     // Catch: Exception -> L4
    L9:
        if (this.n == false) goto L16;
        com.bytedance.android.live.recharge.panel.context.c r0 = this.o;
        if (r0 == null) goto L17;
        r0.h();
        return;
    L17:
        return;
    L16:
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L9;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (isVertical() == false) goto L5;
        int r3 = 2131954578;
    L6:
        setStyle(1, r3);
        return;
    L5:
        r3 = 2131954584;
        goto L6
    }

    public static final void S90(RechargeSecurityConfirmDialogFragment r2, ToggleButton r3) {
        r2.getClass();
        if (r3 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r3 == null) goto L11;
        r3.setChecked(true ^ r1);
    L11:
        if (r2.T90() == false) goto L15;
        TextView r4 = r2.l;
        if (r4 == null) goto L19;
        r4.setAlpha(1.0f);
        return;
    L19:
        return;
    L15:
        TextView r5 = r2.l;
        if (r5 == null) goto L21;
        r5.setAlpha(0.3f);
        return;
    L21:
        return;
    L5:
        if (r3.isChecked() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_recharge_safe_confirm_panel_show", false, 0);
        View r5 = this.d;
        if (r5 == null) goto L7;
        this.e = (ToggleButton) r5.findViewById(2131384897);
        this.f = (ToggleButton) r5.findViewById(2131384899);
        this.g = (ToggleButton) r5.findViewById(2131384901);
        this.h = r5.findViewById(2131384898);
        this.i = r5.findViewById(2131384900);
        this.j = r5.findViewById(2131384902);
        this.k = (TextView) r5.findViewById(2131365123);
        this.l = (TextView) r5.findViewById(2131381427);
        this.m = r5.findViewById(2131366984);
        TextView r6 = (TextView) r5.findViewById(2131384894);
        if (r6 == null) goto L7;
        r6.setText(s1.C(2131915656, new Object[]{e4.a()}));
    L7:
        setOnDismissListener(new b(this));
        LinearLayoutCompat r7 = this.h;
        if (r7 == null) goto L10;
        r7.setOnClickListener(new c(this));
    L10:
        LinearLayoutCompat r8 = this.i;
        if (r8 == null) goto L13;
        r8.setOnClickListener(new d(this));
    L13:
        LinearLayoutCompat r9 = this.j;
        if (r9 == null) goto L16;
        r9.setOnClickListener(new e(this));
    L16:
        HSImageView r10 = this.m;
        if (r10 == null) goto L19;
        r10.setOnClickListener(new f(this));
    L19:
        ToggleButton r12 = this.e;
        if (r12 == null) goto L22;
        r12.setClickable(false);
    L22:
        ToggleButton r13 = this.f;
        if (r13 == null) goto L25;
        r13.setClickable(false);
    L25:
        ToggleButton r14 = this.g;
        if (r14 == null) goto L28;
        r14.setClickable(false);
    L28:
        TextView r15 = this.k;
        if (r15 == null) goto L31;
        r15.setOnClickListener(new g(this));
    L31:
        TextView r16 = this.l;
        if (r16 == null) goto L35;
        r16.setOnClickListener(new h(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565719, r3, false);
        this.d = r5;
        return r5;
    }
}
