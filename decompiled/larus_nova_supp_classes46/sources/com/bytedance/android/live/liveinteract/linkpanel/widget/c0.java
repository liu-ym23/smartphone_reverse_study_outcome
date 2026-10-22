package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.content.DialogInterface;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 implements DialogInterface.OnClickListener {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        r1.dismiss();
        gd0.m r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r3 == null) goto L6;
        ((LinkPanelTransitService) r3).e();
        return;
    }
}
