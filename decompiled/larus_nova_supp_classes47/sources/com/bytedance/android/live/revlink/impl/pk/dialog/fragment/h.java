package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.view.View;
import com.bytedance.android.live.liveinteract.widget.WheelPicker;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.AnchorInteractSettingContract$View;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ InteractPKTimeDialogFragment a;

    public h(InteractPKTimeDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        WheelPicker r6 = this.a.d;
        Intrinsics.checkNotNull(r6);
        int r7 = r6.getCurrentItemPosition();
        if (r7 < 0) goto L45;
        InteractPKTimeDialogFragment r0 = this.a;
        int[] r1 = r0.e;
        if (r7 < r1.length) goto L8;
        return;
    L8:
        if (r0.k == false) goto L13;
        com.bytedance.android.live.revlink.impl.pk.utils.o.c(r1[r7], r7, false);
        x31.k r2 = this.a.l;
        if (r2 == null) goto L19;
        Intrinsics.checkNotNull(r2);
        r2.onConfirm();
    L19:
        InteractPKTimeDialogFragment r3 = this.a;
        InteractPKTimeDialogFragment.b r4 = r3.m;
        if (r4 == null) goto L23;
        r4.cS(r3.e[r7], r7);
    L23:
        if (this.a.k == false) goto L25;
    L26:
        String r8 = String.valueOf(Calendar.getInstance().get(6));
        KProperty[] r9 = l51.a.a;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        l51.a.q0.setValue(null, l51.a.a[78], r8);
    L43:
        this.a.dismiss();     // Catch: Exception -> L30
    L34:
        HashMap r10 = new HashMap();
        InteractPKTimeDialogFragment r12 = this.a;
        if (r12.k == false) goto L38;
        String r13 = "hint_bar";
    L41:
        r10.put("request_page", r13);
        r10.put("pk_time", String.valueOf(this.a.e[r7] / 60));
        mz0.n r14 = new mz0.n();
        Map<String, String> r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r10, "map");
        r15.putAll(r10);
        mz0.m r16 = new mz0.m();
        r16.b(LogCommon.ROOM);
        List<Object> r17 = r14.b;
        ArrayList r18 = (ArrayList) r17;
        r18.addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r20);
        ((mz0.i) ((f80.a) r20)).w3("livesdk_pk_time_setting_panel_click", r14.a, r14.b);
        return;
    L38:
        if (r12.n == false) goto L40;
        r13 = "playmode_panel_setting";
        goto L41
    L40:
        r13 = "set_panel";
    L30:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r22 = DialogFragmentLancet.sLastShowStack;
        if (r22 == null) goto L34;
        com.bytedance.crash.d.d(r22, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L34
    L25:
        if (com.bytedance.android.live.revlink.impl.pk.utils.o.a(System.currentTimeMillis()) == false) goto L43;
    L13:
        if (r0.j == false) goto L18;
        AnchorInteractSettingContract$View r23 = r0.i;
        if (r23 == null) goto L17;
        r23.ba0(r1[r7], r7);
    L17:
        com.bytedance.android.live.revlink.impl.pk.utils.o.b();
        goto L19
    L18:
        com.bytedance.android.live.revlink.impl.pk.utils.o.b();
        goto L19
    }
}
