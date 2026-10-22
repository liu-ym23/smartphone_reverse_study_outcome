package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPKTimeDialogFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.RevLinkAnchorListFragment;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ PkTopTipView a;
    public final /* synthetic */ x31.k b;
    public final /* synthetic */ boolean c;

    public w(PkTopTipView r1, RevLinkAnchorListFragment r2) {
        this.a = r1;
        this.b = r2;
        this.c = true;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r5 = InteractPKTimeDialogFragment.o;
        int r6 = com.bytedance.android.live.revlink.impl.pk.utils.o.a;
        int r7 = l51.a.l();
        x31.k r0 = this.b;
        InteractPKTimeDialogFragment r1 = new InteractPKTimeDialogFragment();
        r1.f = r7;
        r1.k = true;
        r1.l = r0;
        Context r8 = this.a.getContext();
        if (r8 == null) goto L16;
        FragmentManager r9 = ((FragmentActivity) r8).getSupportFragmentManager();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "InteractPKTimeDialogFragment", r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r1, r2) == false) goto L18;
    L9:
        HashMap r10 = new HashMap();
        r10.put("hint_type", DataType.TRUE);
        if (this.c == false) goto L12;
        String r3 = "pk_tab";
    L13:
        r10.put("located_tab", r3);
        r10.put("button_type", "set_time");
        mz0.n r12 = new mz0.n();
        Map<String, String> r13 = r12.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r10, "map");
        r13.putAll(r10);
        mz0.m r14 = new mz0.m();
        r14.b(LogCommon.ROOM);
        List<Object> r15 = r12.b;
        ArrayList r16 = (ArrayList) r15;
        r16.addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_hint_bar_click", r12.a, r12.b);
        return;
    L12:
        r3 = "connection_tab";
        goto L13
    L18:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L8:
        r1.show(r9, "InteractPKTimeDialogFragment");
        goto L9
    L16:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }
}
