package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import android.text.TextUtils;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.bridge.y1;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j extends a {
    public final /* synthetic */ FeedPkMachinePresenter a;

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.d
    public final void onFailed() {
        FeedPkMachinePresenter r0 = this.a;
        r0.getClass();
        r0.i(new e.g(r0.f()));
        FeedPkMachinePresenter r1 = this.a;
        r1.f = true;
        r1.e();
    }

    public j(FeedPkMachinePresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.d
    public final void a(c3 r18, com.bytedance.android.livesdk.link.model.r.b r19) {
        Intrinsics.checkNotNullParameter(r18, "battleStats");
        c1 r3 = r18.getBattleSetting();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r19 == null) goto L9;
        y1 r4 = r19.getOpenGameInfo();
        if (r4 == null) goto L9;
        String r5 = r4.getAppId();
    L11:
        if (TextUtils.isEmpty(r5) == true) goto L13;
        FeedPkMachinePresenter r6 = this.a;
        r6.getClass();
        o r7 = new o(r18, r19);
        r6.i(new e.h(r6.f(), r7));
    L49:
        FeedPkMachinePresenter r1 = this.a;
        r1.f = true;
        r1.e();
        return;
    L13:
        this.a.getClass();
        PkBaseDataContext.Companion.getClass();
        if (PkBaseDataContext.b.a(r3) == true) goto L29;
        FeedPkMachinePresenter r2 = this.a;
        r2.getClass();
        c1 r14 = r18.getBattleSetting();
        if (r14 == null) goto L49;
        long r9 = r14.getBattleId();
        long r12 = r14.getStartTimeMs();
        long r8 = r14.getDuration();
        if (r12 <= 0) goto L49;
        if (r8 <= 0) goto L49;
        l r10 = r2.j.getState();
        if ((r10 instanceof l.c) == true) goto L26;
    L28:
        r2.i(new e.j(new u(new v(r9, r12, (int) r8, r14, r18.getSkinConfig(), r18.getSkinType()), r18)));
        goto L49
    L26:
        if (r12 >= ((l.c) r10).c.c) goto L28;
    L29:
        this.a.getClass();
        if (PkBaseDataContext.b.a(r3) == false) goto L35;
        if (af2.d.d(r3) == false) goto L35;
    L41:
        boolean r13 = true;
    L43:
        if (r13 == true) goto L48;
        FeedPkMachinePresenter r15 = this.a;
        r15.getClass();
        c1 r16 = r18.getBattleSetting();
        if (r16 == null) goto L49;
        r15.i(new e.i(new r(FeedPkMachinePresenter.b(r16, r18.getSkinConfig(), r18.getSkinType()), r18)));
        goto L49
    L48:
        FeedPkMachinePresenter r17 = this.a;
        r17.getClass();
        o r20 = new o(r18, r19);
        r17.i(new e.h(r17.f(), r20));
    L35:
        if (r3.getPunishStartTimeMs() == 0) goto L40;
        if ((com.bytedance.live.kmp.util.e.b() - r3.getPunishStartTimeMs()) > (r3.getPunishDuration() * ((long) WebcastRedirectException.UNKNOWN))) goto L41;
    L42:
        r13 = false;
        goto L43
    L40:
        if ((com.bytedance.live.kmp.util.e.b() - r3.getStartTimeMs()) <= ((r3.getDuration() + r3.getPunishDuration()) * ((long) WebcastRedirectException.UNKNOWN))) goto L42;
    L9:
        r5 = null;
        goto L11
    }
}
