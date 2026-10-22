package com.bytedance.android.live.revlink.link.biz.component;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.android.live.revlink.impl.multianchor.ui.q {
    public final /* synthetic */ AiAssistantAnchorComponent a;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.q
    public final void a() {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.q
    public final void b(boolean r1, boolean r2) {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.q
    public final void c(String r1, String r2, boolean r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "interactID");
    }

    public a(AiAssistantAnchorComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.q
    public final void d(String r4, boolean r5, com.bytedance.android.live.revlink.impl.multianchor.ui.r.b r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        Iterator r7 = ((ArrayList) this.a.g).iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        Object r0 = r7.next();
        m11.a r1 = (m11.a) r0;
        if (r4 != this.a.j.getRoomContext().getCommonUser().getIdString()) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L4;
    L14:
        m11.a r3 = (m11.a) r0;
        if (r3 != null) goto L17;
        return;
    L17:
        this.a.k(r3, r5);
        return;
    L8:
        if (Intrinsics.areEqual(r1.a.getBelongUserId(), r4) == false) goto L10;
        r2 = true;
        goto L11
    L13:
        r0 = null;
        goto L14
    }
}
