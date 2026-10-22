package com.ss.android.lark.integrator.flow.chat;

import aqb.j;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import hza.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements b {
    public final /* synthetic */ FlowChatDependencyImpl$feedDependency$1 a;

    public a(FlowChatDependencyImpl$feedDependency$1 r1) {
        this.a = r1;
    }

    public final void a(pza.a r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        Iterator r0 = ((ArrayList) this.a.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        j r1 = (j) r0.next();
        qtb.b r2 = (qtb.b) LarkContext.spiByDwarf(qtb.b.class);     // Catch: Throwable -> L8
    L10:
        if (r2 == null) goto L14;
        boolean r3 = true;
        if (r2.P0() != true) goto L14;
    L15:
        if (r3 == false) goto L17;
        int r4 = r6.c;
    L18:
        r1.onBadgeChange(r4);
        goto L4
    L17:
        r4 = r6.b;
    L14:
        r3 = false;
    L8:
        th = move-exception;
        Log.e("FlowChatDependencyImpl", "spiByDwarf(IOfficeSDKFeedApi) failed", th);
        r2 = null;
        goto L10
    }
}
