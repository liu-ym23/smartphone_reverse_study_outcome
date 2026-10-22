package com.bytedance.android.live.recharge;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RechargeDialogFactoryImpl {

    public static final class a implements j {
        public final k.a a;

        @Override // com.bytedance.android.live.recharge.j
        public final void a() {
            k.a r0 = this.a;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        public a(k.a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.recharge.j
        public final void b(int r2, int r3, long r4) {
            k.a r0 = this.a;
            if (r0 == null) goto L6;
            r0.b(r2, r3, r4);
            return;
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {
        public final /* synthetic */ k.a a;

        public b(k.a r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            k.a r2 = this.a;
            if (r2 == null) goto L6;
            r2.a();
            return;
        }
    }

    static {
    }

    public static DialogFragment a(Context r7, com.bytedance.android.live.recharge.model.d r8, k.a r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "entranceParams");
        if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L7;
        RxUtilKt.r(((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).z4(r7, RechargeDialogFactoryImpl$provide$1.INSTANCE), "RechargeDialogFactoryImpl");
        return null;
    L7:
        if (com.bytedance.android.live.core.utils.v.b() == false) goto L18;
        String r2 = r8.b;
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L18;
        f2.g();
        goto L18
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
    L18:
        if (com.bytedance.android.live.recharge.model.g.a(com.bytedance.android.live.recharge.model.g.a) == false) goto L23;
        com.bytedance.android.live.recharge.core.d r0 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r0, "$this$dynamicRechargePanelProvider");
        zy0.d r10 = ((com.bytedance.android.live.recharge.panel.dynamic.d) r0.f(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.recharge.panel.dynamic.d.class))).d(r7, r8, new a(r9));
        if (r10 != null) goto L22;
        return null;
    L22:
        return r10.p1();
    L23:
        com.bytedance.android.live.recharge.trace.session.a r4 = new com.bytedance.android.live.recharge.trace.session.a();
        r4.d.put("panel_type", "native");
        int r5 = RechargeDialogFragmentV2.n;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "entranceParams");
        Intrinsics.checkNotNullParameter(r4, "session");
        RechargeDialogFragmentV2 r1 = new RechargeDialogFragmentV2();
        r1.d = r7;
        r1.f = r9;
        r1.g = r8;
        r1.h = r4;
        r1.setOnDismissListener(new b(r9));
        r4.c(com.bytedance.android.live.recharge.trace.session.d.a);
        FragmentActivity r12 = (FragmentActivity) r7;
        if (r12.getSupportFragmentManager().findFragmentByTag("RechargeDialogFragment") != null) goto L31;
        FragmentManager r13 = r12.getSupportFragmentManager();
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "RechargeDialogFragment", r14);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r1, r14) == false) goto L33;
    L30:
        return r1;
    L33:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L29:
        r1.show(r13, "RechargeDialogFragment");
        goto L30
    L31:
        return null;
    }
}
