package com.bytedance.android.live.revlink.link.biz.service;

import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.pk.scope.service.MultiPkScopeProviderService;
import com.bytedance.android.live.revlink.impl.pk.service.PkServiceContext;
import com.bytedance.android.live.revlink.link.biz.audiencecomponent.AiAssistantAudienceComponent;
import com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceLifeControlComponent;
import com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceOtherComponent;
import com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudiencePreloadComponent;
import com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceSeiComponent;
import com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceWindowBizComponent;
import com.bytedance.android.live.revlink.link.biz.audiencecomponent.RoomStateDispatchAudienceComponent;
import com.bytedance.android.live.revlink.link.biz.audiencecomponent.SwitchSceneAudienceCompactComponent;
import com.bytedance.android.live.revlink.link.biz.component.BackgroundComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiLastResultComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiLinkContextComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKContextHolder;
import com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudienceJoinComponent;
import com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoublePKAudienceDataContextHolder;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAudienceService;
import com.bytedance.android.livesdk.link.model.bridge.f0;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements o, n21.a, com.bytedance.android.live.revlink.impl.pk.service.h {
    public final MultiLinkContextComponent a;
    public final com.bytedance.android.live.revlink.link.biz.component.e b;
    public final MultiAudienceWindowBizComponent c;
    public final MultiAudienceLifeControlComponent d;
    public RectF e;
    public final CompositeDisposable f;
    public final List<e> g;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h h;
    public final com.bytedance.android.livesdk.revenue.service.room.c i;
    public final yz0.f j;
    public final com.bytedance.android.livesdk.revenue.service.message.d k;

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public final void finish(String r2) {
        Intrinsics.checkNotNullParameter(r2, "req");
    }

    @Override // n21.a
    public final void handleMuteAiDynamicData(f31.h r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public final void handlePkRoomClose(boolean r1) {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public final void receiveChorusMessage(f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public final void sendGuestKickOut(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "openId");
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public final LiveData<Boolean> getGuestMuteState() {
        return new MutableLiveData();
    }

    @Override // n21.a
    public final NextLiveData<Long> linkRecordTime() {
        return this.b.a.c;
    }

    public final void onStart() {
        MultiLinkContextComponent r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "service");
        r0.b.getCommonService().d(this);
        Pair r1 = com.bytedance.live.datacontext.d.a(RevLinkBizAudienceMultiService$checkShareDoubleCompactService$1.INSTANCE);
        PkServiceContext r2 = (PkServiceContext) r1.component1();
        Disposable r3 = (Disposable) r1.component2();
        r2.getService().d(this);
        this.h.T6("IPkService", r2);
        com.bytedance.revenue.platform.api.core.rx.f.a(r3, this.f);
        Iterator<T> r4 = this.g.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((e) r4.next()).attach();
        goto L4
    }

    public final void onStop() {
        Iterator r0 = CollectionsKt.reversed(this.g).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).detach();
        goto L4
    L6:
        this.f.clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public final oq2.d getPkLayoutData(boolean r7) {
        f31.f r0 = (f31.f) this.h.d.h.getValue();
        if (r0 == null) goto L17;
        List<f31.k> r3 = r0.a;
        boolean r4 = false;
        if (r3 == null) goto L7;
        int r5 = r3.size();
    L8:
        if (r5 >= 2) goto L10;
    L12:
        if (r4 == true) goto L15;
        r0 = null;
    L15:
        if (r0 == null) goto L17;
        this.e = r0.b;
        goto L17
    L10:
        if (r0.b.height() <= 0) goto L12;
        r4 = true;
        goto L12
    L7:
        r5 = 0;
    L17:
        if (r7 == false) goto L19;
        RectF r8 = this.e;
    L23:
        if (r8 != null) goto L26;
        return null;
    L26:
        return new oq2.d((int) r8.top, ((int) r8.width()) / 2, (int) r8.height());
    L19:
        f31.f r9 = (f31.f) this.h.d.h.getValue();
        if (r9 == null) goto L22;
        Intrinsics.checkNotNullParameter(r9, "$this$layout");
        Matrix r1 = r9.d;
        RectF r6 = r9.b;
        int r10 = r9.e.b;
        Intrinsics.checkNotNullParameter(r1, "gridMatrix");
        Intrinsics.checkNotNullParameter(r6, "visibleArea");
        Intrinsics.checkNotNullParameter("", "seiRaw");
        r8 = r6;
        goto L23
    L22:
        r8 = null;
        goto L23
    }

    @Override // n21.a
    public final void handleMultiDynamicData(f31.h r5) {
        Intrinsics.checkNotNullParameter(r5, Constants.Keys.DATA);
        MultiAudienceWindowBizComponent r1 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, Constants.Keys.DATA);
        if ((r5 instanceof f31.d) == false) goto L15;
        Iterator<T> r0 = r1.c.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        Object r2 = r0.next();
        if (Intrinsics.areEqual(((com.bytedance.android.live.revlink.link.biz.audiencecomponent.a) r2).d, ((f31.d) r5).d()) == false) goto L6;
    L11:
        com.bytedance.android.live.revlink.link.biz.audiencecomponent.a r3 = (com.bytedance.android.live.revlink.link.biz.audiencecomponent.a) r2;
        if (r3 == null) goto L21;
        r3.a();
        return;
    L21:
        return;
    L10:
        r2 = null;
        goto L11
    L15:
        if ((r5 instanceof f31.c) == false) goto L23;
        r1.getContext().getCommonService().h().b();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public final void onLynxMicInteractionEvent(int r5) {
        MultiAudienceWindowBizComponent r0 = this.c;
        if (r5 != 1) goto L15;
        Iterator<T> r6 = r0.c.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Object r1 = r6.next();
        if (Intrinsics.areEqual(((com.bytedance.android.live.revlink.link.biz.audiencecomponent.a) r1).d, i.v(r0)) == false) goto L6;
    L11:
        com.bytedance.android.live.revlink.link.biz.audiencecomponent.a r2 = (com.bytedance.android.live.revlink.link.biz.audiencecomponent.a) r1;
        if (r2 == null) goto L22;
        r2.a();
        return;
    L22:
        return;
    L10:
        r1 = null;
        goto L11
    L15:
        if (r5 != 2) goto L17;
        r0.getContext().getCommonService().h().b();
        return;
    L17:
        r0.getClass();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public final void finishInteract(String r4, Integer r5) {
        MultiAudienceLifeControlComponent r6 = this.d;
        r6.getClass();
        jy0.b.c(e.a.a(r6), "unload pkWidget source=" + r4, null, 4);
        r6.f.b.a();
        com.bytedance.android.live.revlink.impl.service.internal.a r7 = i.p(r6);
        if (r7 == null) goto L6;
        com.bytedance.android.live.revlink.impl.service.internal.b.a.a(r7, 4, false, 6);
        return;
    }

    public m(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r22, com.bytedance.android.livesdk.revenue.service.room.c r23, yz0.f r24, com.bytedance.android.livesdk.revenue.service.message.d r25, com.bytedance.android.live.revlink.impl.pk.scope.service.a r26, MultiPkScopeProviderService r27, RevLinkDomainAudienceService r28) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "roomService");
        Intrinsics.checkNotNullParameter(r24, "messageService");
        Intrinsics.checkNotNullParameter(r25, "messageManagerService");
        Intrinsics.checkNotNullParameter(r26, "pkProfitReportService");
        Intrinsics.checkNotNullParameter(r27, "multiPkScopeService");
        Intrinsics.checkNotNullParameter(r28, "domainService");
        this.h = r22;
        this.i = r23;
        this.j = r24;
        this.k = r25;
        com.bytedance.android.live.revlink.link.biz.audiencecomponent.c r15 = new com.bytedance.android.live.revlink.link.biz.audiencecomponent.c(r22);
        this.f = new CompositeDisposable();
        MultiPKContextHolder r6 = new MultiPKContextHolder(r22, r23, r24, r25, null);
        Unit r1 = Unit.INSTANCE;
        DoublePKAudienceDataContextHolder r7 = new DoublePKAudienceDataContextHolder(r22, r23, r24, r25);
        BackgroundComponent r8 = new BackgroundComponent(r22);
        MultiLinkContextComponent r9 = new MultiLinkContextComponent(r22, r23);
        this.a = r9;
        MultiAudienceLifeControlComponent r2 = new MultiAudienceLifeControlComponent(r22, r24, r9.b, r15);
        this.d = r2;
        com.bytedance.android.live.revlink.link.biz.component.e r3 = new com.bytedance.android.live.revlink.link.biz.component.e(r22);
        this.b = r3;
        MultiAudienceWindowBizComponent r4 = new MultiAudienceWindowBizComponent(r22, r6);
        this.c = r4;
        this.g = CollectionsKt.listOf(new e[]{r6, r7, r8, new SwitchSceneAudienceCompactComponent(r22, r23, r8, r6.c.getBasePKContext(), r15, r6, r7), new RoomStateDispatchAudienceComponent(r22), r9, r2, new MultiAudienceOtherComponent(r22, r24, r9.b, r22.d.y, r26, r27, r15, r6), r3, r4, new MultiAudiencePreloadComponent(r22, r6), new MultiLastResultComponent(r22, r6), new MultiAudienceSeiComponent(r22, r9.b, r15), new DoubleAudienceJoinComponent(r22, r28, r8), new AiAssistantAudienceComponent(r22, r23, r24)});
    }
}
