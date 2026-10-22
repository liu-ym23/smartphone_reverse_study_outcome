package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 extends d {
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d
    public final void d0(r1 r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        f2.b(2131919297, 0);
        if (this.g == false) goto L10;
        rj0.k.m2.getClass();
        rj0.k r1 = rj0.k.a.a();
        if (r1 == null) goto L17;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r0 = r9.getLinkedUsers();
        if (r0 != null) goto L9;
        r0 = new ArrayList();
    L9:
        r1.a2(true, r0, r9.getClientUiInfo(), r9.getVersion(), r9.getLinkerContentMap());
        return;
    L17:
        return;
    L10:
        rj0.l.n2.getClass();
        rj0.l r2 = rj0.l.a.a();
        if (r2 == null) goto L19;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r3 = r9.getLinkedUsers();
        if (r3 != null) goto L15;
        r3 = new ArrayList();
    L15:
        r2.a2(true, r3, r9.getClientUiInfo(), r9.getVersion(), r9.getLinkerContentMap());
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d
    public final void e0(c2 r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        f2.c(s1.B(2131923173), 0);
        if (this.g == false) goto L10;
        rj0.k.m2.getClass();
        rj0.k r1 = rj0.k.a.a();
        if (r1 == null) goto L17;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r0 = r9.getLinkedUsers();
        if (r0 != null) goto L9;
        r0 = new ArrayList();
    L9:
        r1.a2(false, r0, r9.getClientUiInfo(), r9.getVersion(), r9.getLinkerContentMap());
        return;
    L17:
        return;
    L10:
        rj0.l.n2.getClass();
        rj0.l r2 = rj0.l.a.a();
        if (r2 == null) goto L19;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r3 = r9.getLinkedUsers();
        if (r3 != null) goto L15;
        r3 = new ArrayList();
    L15:
        r2.a2(false, r3, r9.getClientUiInfo(), r9.getVersion(), r9.getLinkerContentMap());
        return;
    }

    public d0(boolean r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3);
    }
}
