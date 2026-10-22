package com.bytedance.android.live.liveinteract.service;

import android.content.DialogInterface;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Ref.IntRef b;

    public o(int r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        r4.dismiss();
        ILinkPanelService r6 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r6 == null) goto L6;
        r6.close();
    L6:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.b.a() == false) goto L10;
        rj0.k.m2.getClass();
        rj0.k r7 = rj0.k.a.a();
        if (r7 == null) goto L11;
        rj0.k.b.e(r7, this.a, Integer.valueOf(this.b.element), null, 4);
    L11:
        com.bytedance.android.live.liveinteract.linkpanel.util.o.E(null, "confirm");
        return;
    L10:
        f2.b(2131917584, 0);
        goto L11
    }
}
