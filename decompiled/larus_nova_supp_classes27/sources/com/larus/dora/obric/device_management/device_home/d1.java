package com.larus.dora.obric.device_management.device_home;

import android.content.Context;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.obric.device_v2.ObricDoraGConnectFailedDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d1<T> implements FlowCollector {
    public final /* synthetic */ DoraObricDeviceHomeFragment a;

    public d1(DoraObricDeviceHomeFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r10, Continuation r11) {
        a r12 = (a) r10;
        OButton r3 = null;
        if ((r12 instanceof a.C0100a) == false) goto L41;
        DoraObricDeviceHomeFragment r13 = this.a;
        int r5 = DoraObricDeviceHomeFragment.R;
        r13.Y90();
        final DoraObricDeviceHomeFragment r14 = this.a;
        final DoraDevice r15 = ((a.C0100a) r12).a;
        if (r14.o == null) goto L7;
        g49.d.d("DoraObricDeviceHomeFragment", "handleUnbind ignored, unbind dialog is already visible");
    L90:
        return Unit.INSTANCE;
    L7:
        boolean r6 = o59.a.m(Integer.valueOf(r15.productId));
        if (r15.productId != ProductNameType.DORA_G.id) goto L10;
    L13:
        boolean r7 = true;
    L14:
        g49.d.d("DoraObricDeviceHomeFragment", "handleUnbind productId=" + r15.productId + ", type=" + r15.type + ", isSupportFactory=" + o59.a.v(r15) + ", isFactory=" + r15.isFactory());
        if (r6 == true) goto L17;
        if (r7 == true) goto L25;
    L33:
        Context r0 = r14.getContext();
        if (r0 == null) goto L90;
        AbstractDialog r4 = r14.o;
        if (r4 == null) goto L39;
        r4.dismiss();
    L39:
        r14.o = null;
        com.obric.oui.dialog.v2.alert.g r8 = new com.obric.oui.dialog.v2.alert.g(r0);
        r8.w = false;
        int r1 = com.larus.utils.j0.a;
        String r2 = com.larus.utils.j0.d(2131902447);
        r8.j = false;
        r8.h = r2;
        r8.i = com.larus.utils.j0.d(2131902446);
        com.obric.oui.dialog.v2.alert.g.c(r8);
        r8.e(com.larus.utils.j0.d(2131902465), new m0(r14, r15));
        r8.h(com.larus.utils.j0.d(2131902418), new n0(r14, r15));
        com.obric.oui.dialog.v2.alert.c r16 = r8.a();
        r14.o = r16;
        DoraObricDeviceHomeFragment.W90(r16);
        goto L90
    L25:
        if (o59.a.v(r15) == false) goto L33;
        if (r15.isFactory() == false) goto L29;
        r14.ia0().replaceBind(r15);
        goto L90
    L29:
        AbstractDialog r9 = r14.o;
        if (r9 == null) goto L32;
        r9.dismiss();
    L32:
        r14.o = null;
        int r17 = a79.c.a;
        r14.o = a79.c.a(r14.getContext(), false, new w0(r14, r15), new x0(r14, r15));
        goto L90
    L17:
        if (r15.isFactory() == false) goto L19;
        r14.ia0().replaceBind(r15);
        goto L90
    L19:
        AbstractDialog r18 = r14.o;
        if (r18 == null) goto L22;
        r18.dismiss();
    L22:
        r14.o = null;
        int r20 = a79.c.a;
        r14.o = a79.c.a(r14.getContext(), true, new w0(r14, r15), new x0(r14, r15));
        goto L90
    L10:
        if (r15.type == 16) goto L13;
        r7 = false;
        goto L14
    L41:
        if ((r12 instanceof a.b) == false) goto L57;
        DoraObricDeviceHomeFragment r110 = this.a;
        int r21 = DoraObricDeviceHomeFragment.R;
        r110.Y90();
        final DoraObricDeviceHomeFragment r111 = this.a;
        final DoraDevice r112 = ((a.b) r12).a;
        ObricDoraGConnectFailedDialogFragment r22 = r111.m;
        if (r22 != null) goto L96;
    L50:
        r111.m = null;
        ObricDoraGConnectFailedDialogFragment r23 = new ObricDoraGConnectFailedDialogFragment();
        r23.d = r112;
        r23.e = new r0(r111, r112);
        FragmentManager r113 = r111.getChildFragmentManager();
        LandscapeRestrictionOperation r24 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r23, "ObricDeviceHomeConnectFailedDialog", r24);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r113, r23, r24) == false) goto L94;
    L55:
        r111.m = r23;
        goto L90
    L94:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L93
    L54:
        r23.show(r113, "ObricDeviceHomeConnectFailedDialog");
        goto L55
    L96:
        r22.dismiss();     // Catch: Exception -> L46
    L46:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r25 = DialogFragmentLancet.sLastShowStack;
        if (r25 == null) goto L50;
        com.bytedance.crash.d.d(r25, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L50
    L57:
        if ((r12 instanceof a.c) == false) goto L92;
        final DoraObricDeviceHomeFragment r114 = this.a;
        a.c r115 = (a.c) r12;
        final DoraDevice r26 = r115.a;
        String r116 = r115.b;
        int r27 = DoraObricDeviceHomeFragment.R;
        Context r28 = r114.getContext();
        if (r28 == null) goto L90;
        StringBuilder r30 = new StringBuilder("showQuickActionReconnectDialog mac=");
        if (r26 == null) goto L64;
        String r31 = r26.mac;
    L65:
        r30.append(r31);
        r30.append(" featureName=");
        r30.append(r116);
        g49.d.d("DoraObricDeviceHomeFragment", r30.toString());
        com.obric.oui.dialog.v2.alert.c r32 = r114.n;
        if (r32 == null) goto L68;
        r32.dismiss();
    L68:
        r114.n = null;
        com.obric.oui.dialog.v2.alert.g r33 = new com.obric.oui.dialog.v2.alert.g(r28);
        ((com.obric.oui.dialog.base.i) r33).c = true;
        r33.w = false;
        String r34 = r28.getString(2131903449);
        r33.j = false;
        r33.h = r34;
        r33.i = r28.getString(2131903451, new Object[]{r116});
        r33.m = 0;
        r33.t = true;
        int r117 = com.larus.utils.j0.a;
        r33.e(com.larus.utils.j0.d(2131902465), new h0(r114));
        if (r26 != null) goto L71;
        int r118 = 2131903445;
    L72:
        r33.h(com.larus.utils.j0.d(r118), new i0(r114, r26));
        com.obric.oui.dialog.v2.alert.c r119 = r33.a();
        int r35 = vma.c.a;
        ButtonStyleController r36 = r119.M;
        if (r36 != null) goto L76;
    L78:
        r36 = null;
    L79:
        ButtonStyleController r37 = r36;
        if (r37 != null) goto L82;
        OButton r38 = null;
    L84:
        if ((r38 instanceof TextView) == false) goto L86;
        r3 = r38;
    L86:
        if (r3 == null) goto L88;
        r3.setTextColor(ContextCompat.getColor(r28, 2131103203));
    L88:
        r114.n = r119;
        DoraObricDeviceHomeFragment.W90(r119);
        goto L90
    L82:
        r38 = r37.f();
        goto L84
    L76:
        if ((r36 instanceof ButtonStyleController) == false) goto L78;
    L71:
        r118 = 2131902419;
        goto L72
    L64:
        r31 = null;
        goto L65
    L92:
        throw new NoWhenBranchMatchedException();
    }
}
