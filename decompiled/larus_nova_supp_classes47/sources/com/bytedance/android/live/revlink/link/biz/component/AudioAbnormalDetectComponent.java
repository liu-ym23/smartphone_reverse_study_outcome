package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.kmp.core.KmpEnv;
import fr2.g0;
import fr2.i0;
import fr2.r0;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AudioAbnormalDetectComponent implements com.bytedance.android.live.revlink.link.biz.service.e {
    public final String a;
    public final CompositeDisposable b;
    public final IRoom c;
    public fr2.a d;
    public boolean e;
    public fr2.p f;
    public final w41.e g;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d h;
    public final com.bytedance.android.livesdk.revenue.service.room.c i;
    public final com.bytedance.android.live.revenuelink.rtc.i j;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.AudioAbnormalDetectComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(AudioAbnormalDetectComponent r8) {
            super(0, r8, AudioAbnormalDetectComponent.class, "startAudioDiagnosis", "startAudioDiagnosis()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m879invoke() {
            AudioAbnormalDetectComponent r0 = (AudioAbnormalDetectComponent) ((CallableReference) this).receiver;
            if (r0.e == true) goto L22;
            fr2.a r1 = r0.d;
            if (r1 == null) goto L9;
            r1.k2(r0.b);
        L9:
            if (r0.d == null) goto L20;
            fr2.p r2 = r0.f;
            if (r2 == null) goto L13;
            r2.V2();
        L13:
            r0.e = true;
            com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r3 = r0.getContext();
            if (r3 == null) goto L16;
            LiveFullLinkPKMonitor r4 = r3.getLiveFullLinkPKMonitor();
        L17:
            if (r4 == null) goto L21;
            LiveFullLinkPKMonitor.m(r4, "live_revlink_active_audio_diagnosis");
            return;
        L21:
            return;
        L16:
            r4 = null;
            goto L17
        L20:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m879invoke();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        LiveFullLinkPKMonitor r2 = null;
        xh6.b r0 = vh6.c.b(g0.class).o6().b(Reflection.getOrCreateKotlinClass(fr2.a.class), null);
        if ((r0 instanceof fr2.a) == true) goto L5;
        r0 = null;
    L5:
        KmpEnv r1 = KmpEnv.a;
        com.bytedance.live.kmp.core.b.a();
        this.d = (fr2.a) r0;
        vc0.a r3 = this.j.getLiveCore();
        if (r3 == null) goto L8;
        fr2.p r4 = i0.a(r3);
    L9:
        this.f = r4;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.h(getContext().getLinkDataSet().tb(), new AnonymousClass1(this)), this.b);
        fr2.a r5 = this.d;
        if (r5 == null) goto L12;
        r5.H2(this.g.E5());
    L12:
        fr2.a r6 = this.d;
        if (r6 == null) goto L15;
        r6.J3(this.g.N6());
    L15:
        fr2.a r7 = this.d;
        if (r7 == null) goto L19;
        r7.k2(r0.a);
    L19:
        if (this.d == null) goto L31;
        fr2.p r8 = this.f;
        if (r8 == null) goto L23;
        r8.V2();
    L23:
        String r9 = this.a;
        StringBuilder r10 = new StringBuilder("startAudioKitDiagnosis adm = ");
        fr2.p r12 = this.f;
        if (r12 == null) goto L26;
        r12.V2();
    L26:
        r10.append(null);
        jy0.b.c(r9, r10.toString(), null, 4);
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r13 = getContext();
        if (r13 == null) goto L29;
        r2 = r13.getLiveFullLinkPKMonitor();
    L29:
        if (r2 == null) goto L31;
        LiveFullLinkPKMonitor.m(r2, "live_revlink_start_audiokit_diagnosis");
    L31:
        fr2.p r14 = this.f;
        if (r14 == null) goto L35;
        r14.V2();
        return;
    L35:
        return;
    L8:
        r4 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        fr2.p r0 = this.f;
        if (r0 == null) goto L5;
        r0.V2();
    L5:
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.h;
    }

    public AudioAbnormalDetectComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, com.bytedance.android.livesdk.revenue.service.room.c r3, PkBaseDataContext r4, com.bytedance.android.live.revenuelink.rtc.i r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "baseDataContext");
        Intrinsics.checkNotNullParameter(r5, "anchorRtcManager");
        this.h = r2;
        this.i = r3;
        this.j = r5;
        this.a = "AudioAbnormalDetectComponent";
        this.b = new CompositeDisposable();
        IRoom r6 = r3.getRoomContext().getCommonRoom();
        if (r6 == null) goto L7;
        this.c = r6;
        this.g = com.bytedance.android.live.revlink.impl.settings.live.b.p.d();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoomKt /* = com.bytedance.android.livesdkapi.depend.model.live.IRoom */");
    }
}
