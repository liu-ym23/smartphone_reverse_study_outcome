package com.bytedance.android.live.revlink.link.biz.component;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements com.bytedance.android.live.revlink.link.biz.service.e {
    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.b a;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d b;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return "LinkTimeRecorder";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.android.live.revlink.impl.multianchor.dialog.b r0 = this.a;
        NextLiveData<Long> r1 = r0.c;
        com.bytedance.android.live.revlink.impl.global.c r2 = r0.h;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r3 = null;
        if (r2 == null) goto L5;
        ProfitInteractionDataContext r4 = r2.vj();
    L7:
        if (r4 != null) goto L9;
    L13:
        long r6 = -1;
    L14:
        r1.setValue(Long.valueOf(r6));
        StringBuilder r5 = new StringBuilder("scene=");
        r5.append(r0.j);
        r5.append(" attach time=");
        r5.append((Long) r0.c.getValue());
        r5.append(' ');
        com.bytedance.android.live.revlink.impl.global.c r7 = r0.h;
        if (r7 == null) goto L17;
        ProfitInteractionDataContext r8 = r7.vj();
    L18:
        if (r8 == null) goto L20;
        String r9 = r8.getLogString();
    L21:
        r5.append(r9);
        jy0.b.f("ttlive_anchor_link_timer", r5.toString(), null, 4);
        com.bytedance.android.live.revlink.impl.global.c r10 = r0.h;
        if (r10 == null) goto L24;
        ProfitInteractionDataContext r12 = r10.vj();
    L25:
        if (r12 == null) goto L34;
        com.bytedance.live.datacontext.m<Long> r13 = r12.getLinkStartTimeStamp();
        if (r13 == null) goto L34;
        Observable r14 = r13.a();
        if (r14 == null) goto L34;
        Disposable r15 = r14.subscribe(new com.bytedance.android.live.revlink.impl.multianchor.dialog.c(r0));
        if (r15 == null) goto L34;
        r0.b.add(r15);
    L34:
        if (r0.j != 1) goto L43;
        x11.a r16 = r0.i;
        if (r16 == null) goto L41;
        y11.d r17 = r16.getPkService();
        if (r17 == null) goto L41;
        r17.f(r0.f);
    L41:
        if (Intrinsics.areEqual(r0.e, q11.b.C0295b.b) == false) goto L56;
        r0.a("attach_pkFinished");
        return;
    L56:
        return;
    L43:
        com.bytedance.android.live.revlink.impl.global.c r18 = r0.h;
        if (r18 == null) goto L46;
        r3 = r18.Ig();
    L46:
        if (r3 == null) goto L50;
        LiveData<PkBaseStateMachine.c> r19 = r3.getPkBaseState();
        if (r19 == null) goto L50;
        r19.observeForever(r0.g);
    L50:
        PkBaseStateMachine.c r20 = r0.d;
        if (r20 != null) goto L53;
        return;
    L53:
        if (r20.b() != true) goto L59;
        r0.a("attach_multiPkDisabled");
        return;
    L59:
        return;
    L24:
        r12 = null;
        goto L25
    L20:
        r9 = null;
        goto L21
    L17:
        r8 = null;
        goto L18
    L9:
        if (r4.hasDataInitialized() == false) goto L13;
        r6 = (com.bytedance.live.kmp.util.e.b() - r4.currentLinkTimestamp()) / ((long) WebcastRedirectException.UNKNOWN);
        if (r6 >= 0) goto L14;
        jy0.b.c("ttlive_anchor_link_timer", "init recordTime=" + r6 + " linkStartTime=" + r4.currentLinkTimestamp(), null, 4);
        r6 = 0;
        goto L14
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        com.bytedance.android.live.revlink.impl.multianchor.dialog.b r0 = this.a;
        if (r0.j != 1) goto L9;
        x11.a r1 = r0.i;
        if (r1 == null) goto L17;
        y11.d r2 = r1.getPkService();
        if (r2 == null) goto L17;
        r2.g(r0.f);
    L17:
        Disposable r3 = r0.a;
        if (r3 == null) goto L20;
        r3.dispose();
    L20:
        r0.b.dispose();
        return;
    L9:
        com.bytedance.android.live.revlink.impl.global.c r4 = r0.h;
        if (r4 == null) goto L12;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r5 = r4.Ig();
    L13:
        if (r5 == null) goto L17;
        LiveData<PkBaseStateMachine.c> r6 = r5.getPkBaseState();
        if (r6 == null) goto L17;
        r6.removeObserver(r0.g);
        goto L17
    L12:
        r5 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.b;
    }

    public e(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.b = r4;
        this.a = new com.bytedance.android.live.revlink.impl.multianchor.dialog.b(getContext(), getContext().getInternalLinkService(), getContext().getScene());
    }
}
