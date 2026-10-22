package com.bytedance.android.live.revlink.impl.multianchor.network;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.livesdk.link.model.e7;
import com.bytedance.android.livesdk.link.model.f7;
import com.bytedance.android.livesdk.link.model.r3;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ j a;
    public final /* synthetic */ long b;

    public h(j r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        ExtraResponse r12 = (ExtraResponse) r10;
        LiveFullLinkPKMonitor r0 = com.bytedance.android.live.revlink.impl.global.b.q();
        if (r0 == null) goto L5;
        LiveFullLinkPKMonitor.s(r0, "linkmic/change_multi_pk_team", System.currentTimeMillis() - this.b, 0, 0, null, 28);
    L5:
        z r1 = com.bytedance.android.live.revlink.impl.global.b.J();
        e7 r2 = null;
        if (r1 == null) goto L12;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r3 = com.bytedance.android.live.revlink.impl.global.b.u();
        if (r3 == null) goto L10;
        long r4 = r3.a();
    L11:
        int r5 = z.f;
        r1.n(r4, null);
        goto L12
    L10:
        r4 = 0;
    L12:
        if (r12 == null) goto L16;
        r3 r13 = (r3) r12.data;
        if (r13 == null) goto L16;
        r2 = r13.getMultiPKModeInfo();
    L16:
        if (r2 == null) goto L34;
        MultiAnchorPkLaunchContext r6 = com.bytedance.android.live.revlink.impl.global.b.x();
        if (r6 == null) goto L20;
        MultiAnchorPkLaunchContext.updateMultiPkModeInfo$default(r6, r2, null, "oldChangeTeam", null, 8, null);
    L20:
        j r14 = this.a;
        if (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.f.a(r14.a, f7.a(r2)) == true) goto L24;
        return;
    L24:
        if (r2.getModeTab() != 1) goto L28;
        c r7 = r14.c;
        if (r7 == null) goto L28;
        r7.a(r2.getVersion());
    L28:
        Intrinsics.checkNotNullParameter(r2, "$this$userIdToTeamId");
        Map<String, Long> r8 = r2.getRevUserIdToTeamId();
        if (r2.getModeTab() != 2) goto L38;
        if (r8 == null) goto L39;
        c r15 = r14.c;
        if (r15 == null) goto L40;
        r15.c(r2.getVersion(), r8);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L34:
        c r16 = this.a.c;
        if (r16 == null) goto L42;
        r16.onRequestChangeMultiTeamFailed();
        return;
    }
}
