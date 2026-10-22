package com.bytedance.android.live.revlink.link.domain.service;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.link.biz.component.AudioAbnormalDetectComponent;
import com.bytedance.android.live.revlink.link.biz.component.AudioPunishComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiMuteManager;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.core.service.i;
import com.bytedance.android.live.revlink.link.core.service.p;
import com.bytedance.android.live.revlink.link.core.service.q;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.CoreContext;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.DomainLaunchTask;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.RenderControl;
import com.bytedance.android.live.revlink.link.domain.streammix.NormalStreamMixStrategy;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g;
import com.bytedance.android.live.revlink.link.streaminteract.biz.PushModeManagerService;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.revenue.platform.api.core.rx.l;
import f31.k;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import o51.e;
import org.json.JSONObject;
import uf2.d0;
import yz0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevLinkDomainAnchorService implements o, b {
    public final CompositeDisposable a;
    public final NormalStreamMixStrategy b;
    public final CompositeDisposable c;
    public final NextLiveData<List<s51.b>> d;
    public final NextLiveData<List<s51.c>> e;
    public final MultiMuteManager f;
    public final a g;
    public final CoreContext h;
    public final RenderControl i;
    public final DomainLaunchTask j;
    public AudioPunishComponent k;
    public AudioAbnormalDetectComponent l;
    public final i m;
    public final g n;
    public final com.bytedance.android.live.revenuelink.rtc.i o;
    public final n p;
    public final PushModeManagerService q;
    public final com.bytedance.android.livesdk.revenue.service.room.c r;
    public final com.bytedance.android.live.revlink.link.streaminteract.biz.c s;
    public final f t;
    public final com.bytedance.android.livesdk.revenue.service.message.d u;
    public final RevLinkBizScopeAnchorLaunchService v;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/link/core/service/p;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/link/core/service/p;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<p, Unit> {
        public AnonymousClass1(RevLinkDomainAnchorService r8) {
            super(1, r8, RevLinkDomainAnchorService.class, "onLayoutFrameChange", "onLayoutFrameChange(Lcom/bytedance/android/live/revlink/link/core/service/LayoutFrame;)V", 0);
        }

        public final void invoke(p r27) {
            RevLinkDomainAnchorService r2 = (RevLinkDomainAnchorService) ((CallableReference) this).receiver;
            r2.getClass();
            if (r27 != null) goto L6;
            return;
        L6:
            if (r27.a.size() < 2) goto L187;
            Map<String, com.bytedance.android.live.revlink.link.core.service.n> r3 = r27.a;
            ArrayList r4 = new ArrayList(r3.size());
            Iterator<Map.Entry<String, com.bytedance.android.live.revlink.link.core.service.n>> r5 = r3.entrySet().iterator();
        L10:
            if (r5.hasNext() == false) goto L12;
            r4.add(r5.next().getValue().a);
            goto L10
        L12:
            LinkedHashMap r6 = new LinkedHashMap();
            LinkedHashMap r7 = new LinkedHashMap();
            List r8 = (List) r2.e.getValue();
            if (r8 == null) goto L18;
            Iterator r9 = r8.iterator();
        L16:
            if (r9.hasNext() == false) goto L18;
            s51.c r10 = (s51.c) r9.next();
            r6.put(r10.d, MicStage.Idle);
            r7.put(r10.d, r10);
        L18:
            ArrayList r12 = new ArrayList();
            Iterator r13 = r4.iterator();
        L19:
            String r14 = "";
            if (r13.hasNext() == false) goto L42;
            q r15 = (q) r13.next();
            if (r6.containsKey(r2.a(r15.a)) == true) goto L23;
            r6.put(r2.a(r15.a), MicStage.NewCreated);
            String r16 = r2.a(r15.a);
            String r17 = r15.a;
            com.bytedance.android.livesdk.link.model.p r18 = r2.n.d.d.getGuestInfo(r16, null);
            g r19 = r2.n;
            if (r18 == null) goto L36;
            IBaseUser r20 = r18.getUser();
            if (r20 == null) goto L36;
            Intrinsics.checkNotNullParameter(r20, "$this$secUidExt");
            String r22 = r20.getCastSecUid();
            if (r22 == null) goto L36;
            String r110 = r22;
        L37:
            s51.c r23 = new s51.c(r15, r19, r16, r110, r17, r2.n.d.d, r2.o, r2.p);
            Iterator<T> r24 = r23.b.iterator();
        L39:
            if (r24.hasNext() == false) goto L41;
            ((s51.a) r24.next()).attach();
            goto L39
        L41:
            r12.add(r23);
        L36:
            r110 = "";
            goto L37
        L23:
            r6.put(r2.a(r15.a), MicStage.Reuse);
            s51.c r25 = (s51.c) r7.get(r2.a(r15.a));
            if (r25 == null) goto L26;
            Intrinsics.checkNotNullParameter(r15, "newLayoutState");
            Intrinsics.checkNotNullParameter(r15, "<set-?>");
            r25.a = r15;
        L26:
            if (r25 == null) goto L19;
            r12.add(r25);
            goto L19
        L42:
            LinkedHashMap r26 = new LinkedHashMap();
            Iterator r28 = r6.entrySet().iterator();
        L44:
            if (r28.hasNext() == false) goto L51;
            Map.Entry r29 = (Map.Entry) r28.next();
            if (((MicStage) r29.getValue()) != MicStage.Idle) goto L48;
            boolean r111 = true;
        L49:
            if (r111 == false) goto L44;
            r26.put(r29.getKey(), r29.getValue());
            goto L44
        L48:
            r111 = false;
            goto L49
        L51:
            Iterator r30 = r26.entrySet().iterator();
        L53:
            if (r30.hasNext() == false) goto L60;
            s51.c r32 = (s51.c) r7.get((String) ((Map.Entry) r30.next()).getKey());
            if (r32 == null) goto L53;
            Iterator<T> r33 = r32.b.iterator();
        L58:
            if (r33.hasNext() == false) goto L53;
            ((s51.a) r33.next()).detach();
            goto L58
        L60:
            r2.i.a(r12, r27);
            CoreContext r34 = r2.h;
            r34.getClass();
            Intrinsics.checkNotNullParameter(r12, "mics");
            Intrinsics.checkNotNullParameter(r27, "layoutFrame");
            ArrayList r35 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
            Iterator r112 = r12.iterator();
        L62:
            if (r112.hasNext() == false) goto L64;
            s51.c r113 = (s51.c) r112.next();
            String r114 = r113.f();
            String r115 = r113.d;
            q r116 = r113.a;
            r35.add(new k(r114, r115, r116.b, r116.c, r116.d, r116.e, true, r116.j, 0, 768, 0));
            r14 = r14;
            goto L62
        L64:
            String r210 = r14;
            com.bytedance.android.live.revlink.link.domain.dependencyimpl.a r0 = r34.d;
            com.bytedance.android.livesdk.link.model.p r36 = r34.g.d.d.getGuestInfo(o51.g.b(r34.k.e), null);
            if (r36 == null) goto L67;
            String r37 = r36.getInteractId();
        L68:
            r0.a = r37;
            r34.d.b = Integer.valueOf(r34.k.e.a.b);
            r34.d.c = Integer.valueOf(r34.k.e.c.ordinal());
            ArrayList r1 = new ArrayList();
            Map<String, com.bytedance.android.live.revlink.link.core.service.n> r38 = r27.a;
            ArrayList r39 = new ArrayList(r38.size());
            Iterator<Map.Entry<String, com.bytedance.android.live.revlink.link.core.service.n>> r40 = r38.entrySet().iterator();
        L70:
            if (r40.hasNext() == false) goto L72;
            r39.add(r40.next().getValue());
            goto L70
        L72:
            r1.addAll(r39);
            r1.addAll(r27.b);
            ArrayList r42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator r43 = r1.iterator();
        L74:
            if (r43.hasNext() == false) goto L76;
            r42.add(((com.bytedance.android.live.revlink.link.core.service.n) r43.next()).a);
            goto L74
        L76:
            RectF r44 = o51.a.b(r42);
            com.bytedance.android.live.revlink.impl.multianchor.service.g r45 = r34.b();
            if (r45 == null) goto L81;
            NextLiveData<Boolean> r46 = r45.getBattleStatus();
            if (r46 == null) goto L81;
            Boolean r47 = (Boolean) r46.getValue();
        L83:
            if (Intrinsics.areEqual(r47, Boolean.TRUE) == false) goto L91;
            int r48 = r34.g.getContainerWidth();
            com.bytedance.android.live.revlink.impl.multianchor.service.g r49 = r34.b();
            if (r49 != null) goto L87;
        L89:
            int r50 = r34.g.l();
        L90:
            com.bytedance.android.live.revlink.impl.multianchor.dynamic.i r52 = new com.bytedance.android.live.revlink.impl.multianchor.dynamic.i(r48, r50, 0, 0);
        L92:
            com.bytedance.android.live.revlink.impl.multianchor.dynamic.i r117 = r52;
            ArrayList r53 = new ArrayList();
            Map<String, com.bytedance.android.live.revlink.link.core.service.n> r54 = r27.a;
            ArrayList r55 = new ArrayList(r54.size());
            Iterator<Map.Entry<String, com.bytedance.android.live.revlink.link.core.service.n>> r56 = r54.entrySet().iterator();
        L94:
            if (r56.hasNext() == false) goto L96;
            r55.add(r56.next().getValue());
            goto L94
        L96:
            r53.addAll(r55);
            r53.addAll(r27.b);
            com.bytedance.android.live.revlink.link.core.service.n r57 = r27.c;
            if (r57 == null) goto L99;
            r53.add(r57);
        L99:
            ArrayList r58 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r53, 10));
            Iterator r59 = r53.iterator();
        L101:
            if (r59.hasNext() == false) goto L103;
            r58.add(((com.bytedance.android.live.revlink.link.core.service.n) r59.next()).a);
            goto L101
        L103:
            RectF r60 = o51.a.b(r58);
            r34.c.getWindowStatus().setValue(new f31.i(r35, null, r117, null, null, r27.i, r27.j, 16));
            jy0.b.c("CoreContext", "updateMic with: anchorFrames" + r27.a + ", audienceFrames: " + r27.b + ",  gameFrame: " + r27.c, null, 4);
            r34.g.d.i.setValue(r34.k.e);
            r34.g.d.h.setValue(new f31.f(r35, r60, r44, r27.g, r34.k.e.a, r27.h));
            r2.e.setValue(r12);
            r2.d.setValue(r12);
            if (r2.r.getRoomContext().getCommonRoom().isLiveTypeAudio() == false) goto L136;
            g r62 = r2.n;
            if (r62 == null) goto L111;
            com.bytedance.android.live.revlink.impl.multianchor.service.a r63 = r62.u5();
            if (r63 == null) goto L111;
            Pair<Integer, Integer> r64 = r63.getPreviewSize();
            if (r64 == null) goto L111;
        L112:
            JSONObject r65 = new JSONObject();
            r65.put("render_size", r64);
            int r66 = com.bytedance.revenue.platform.api.core.b.a;
            ArrayList r67 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
            Iterator r68 = r12.iterator();
        L114:
            if (r68.hasNext() == false) goto L116;
            r67.add(((s51.b) r68.next()).d().toString());
            goto L114
        L116:
            r65.put("mic_state", JSONObject.wrap(r67));
            com.bytedance.android.live.revenuelink.rtc.f r69 = com.bytedance.android.live.revlink.impl.global.b.d();
            if (r69 == null) goto L134;
            com.bytedance.android.live.revenuelink.rtc.i r70 = r69.getRtcManager();
            if (r70 == null) goto L134;
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r72 = ILiveWrappedLivePusher.a.b();
            if (r72 == null) goto L128;
            vc0.a r73 = r70.getLiveCore();
            if (r73 == null) goto L126;
            Object r74 = r73.a;
        L127:
            d0 r75 = r72.buildLiveCore(r74);
        L129:
            if (r75 == null) goto L133;
            View r76 = r75.Y();
            if (r76 == null) goto L133;
            String r77 = "width:" + r76.getWidth() + ", height:" + r76.getHeight();
        L135:
            r65.put("surfaceview_info", r77);
            LiveFullLinkPKMonitor.t(r2.n.getLiveFullLinkPKMonitor(), "audio_pk_render_size_info", r65, null, 4);
        L133:
            r77 = r210;
            goto L135
        L126:
            r74 = null;
            goto L127
        L128:
            r75 = null;
        L134:
            r77 = null;
        L111:
            r64 = new Pair(-1, -1);
        L136:
            Map<String, com.bytedance.android.live.revlink.link.core.service.n> r78 = r27.a;
            e r79 = r27.f;
            com.bytedance.android.live.revlink.link.core.service.n r80 = r78.get(r2.n.Zl());
            if (r80 == null) goto L157;
            t51.e r82 = r80.b;
            if (r82 == null) goto L157;
            Integer r83 = r82.p().get(Integer.valueOf(r79.c.ordinal()));
            if (r83 != null) goto L144;
            r83 = r82.p().get(Integer.valueOf(IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom.ordinal()));
        L144:
            Integer r84 = r82.q().get(Integer.valueOf(r79.c.ordinal()));
            if (r84 != null) goto L147;
            r84 = r82.q().get(Integer.valueOf(IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom.ordinal()));
        L147:
            PushModeManagerService r85 = r2.q;
            int r86 = r85.f;
            if (r83 != null) goto L151;
        L153:
            if (r83 == null) goto L157;
            r83.intValue();
            if (r84 == null) goto L157;
            r84.intValue();
            r85.f = r83.intValue();
            r85.g = r84.intValue();
            r85.h = -1;
            r85.c();
            goto L157
        L151:
            if (r83.intValue() != r86) goto L153;
        L157:
            NormalStreamMixStrategy r87 = r2.b;
            r87.getClass();
            Intrinsics.checkNotNullParameter(r27, "layoutFrame");
            r87.b = r27;
            r2.s.f.f();
            r2.c.clear();
            l r88 = l.a;
            long r89 = WebcastRedirectException.UNKNOWN;
            int r90 = com.bytedance.revenue.platform.api.core.rx.p.a;
            com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(Observable.interval(0, r89, TimeUnit.MILLISECONDS, Schedulers.computation()).take(3)).subscribe(new c(r2)), r2.c);
            return;
        L87:
            if (r49.getCloudCollaboratePanelType() != IBattleConfigSetting.BattleCloudCollaboratePanelType.BattleCloudCollaboratePanelType_ThroneFight.ordinal()) goto L89;
            r50 = (int) (((double) r44.width()) * 1.7777777777777777d);
            goto L90
        L91:
            r52 = new com.bytedance.android.live.revlink.impl.multianchor.dynamic.i(RangesKt.coerceAtMost((int) r44.width(), r34.g.getContainerWidth()), RangesKt.coerceAtMost((int) r44.height(), r34.g.l()), RangesKt.coerceAtLeast((int) r44.left, 0), RangesKt.coerceAtLeast((int) r44.top, 0));
        L81:
            r47 = null;
            goto L83
        L67:
            r37 = null;
            goto L68
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((p) r1);
            return Unit.INSTANCE;
        }
    }

    public final void onStart() {
        jy0.b.c("xuzr_log", "RevLinkDomainAnchorService onStart", null, 4);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(this.m.getLayoutFrame(), new AnonymousClass1(this)), this.a);
        com.bytedance.android.live.revlink.link.streaminteract.biz.c r0 = this.s;
        NormalStreamMixStrategy r1 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "strategy");
        r0.b = r1;
        this.h.a();
        this.j.attach();
        final RevLinkBizScopeAnchorLaunchService r2 = this.v;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.g(r2.c.d.e, new RevLinkBizScopeAnchorLaunchService$startBizScope$1(r2)), r2.a);
        r2.c("startBizScope");
        this.b.attach();
        this.f.attach();
        AudioPunishComponent r3 = new AudioPunishComponent(this.n, this.r, this.h.b, this.f);
        this.k = r3;
        r3.attach();
        if (com.bytedance.android.live.revlink.impl.settings.live.b.p.d().getEnable() == false) goto L6;
        AudioAbnormalDetectComponent r4 = new AudioAbnormalDetectComponent(this.n, this.r, this.h.b, this.o);
        this.l = r4;
        r4.attach();
        return;
    }

    public final void onStop() {
        jy0.b.c("xuzr_log", "RevLinkDomainAnchorService onStop", null, 4);
        this.v.a();     // Catch: Throwable -> L5
    L7:
        this.f.detach();
        this.a.clear();
        CoreContext r0 = this.h;
        r0.a.clear();
        r0.e.o();
        r0.f.q();
        this.j.detach();
        this.c.clear();
        RenderControl r1 = this.i;
        if (r1.getContext().getScene() == 1) goto L11;
        r1.b.a(CollectionsKt.listOf((com.bytedance.android.live.revlink.link.domain.anchorimpl.p) r1.a.getValue()), false);
    L11:
        this.b.c.clear();
        AudioPunishComponent r2 = this.k;
        if (r2 == null) goto L14;
        r2.detach();
    L14:
        AudioAbnormalDetectComponent r3 = this.l;
        if (r3 == null) goto L20;
        r3.detach();
        return;
    L20:
        return;
    L5:
        th = move-exception;
        jy0.b.c("xuzr_log", "RevLinkDomainAnchorService stop with crash " + th, null, 4);
        goto L7
    }

    public final String a(String r2) {
        com.bytedance.android.livesdk.link.model.p r3 = this.n.d.d.v(r2);
        if (r3 == null) goto L8;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L8;
        String r5 = iz.a.a(r4);
        if (r5 == null) goto L8;
        return r5;
    L8:
        return "";
    }

    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        return this.h.b.isInAudioPunish(r2);
    }

    public final s51.c d(String r5, String r6) {
        com.bytedance.android.livesdk.link.model.p r7 = this.n.d.d.getGuestInfo(r5, r6);
        Object r8 = null;
        if (r7 != null) goto L5;
        return null;
    L5:
        List r0 = (List) this.e.getValue();
        if (r0 == null) goto L22;
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        Object r2 = r1.next();
        String r3 = ((s51.c) r2).d;
        IBaseUser r4 = r7.getUser();
        if (r4 == null) goto L13;
        String r9 = iz.a.a(r4);
    L15:
        if (Intrinsics.areEqual(r3, r9) == false) goto L9;
        r8 = r2;
        goto L18
    L13:
        r9 = null;
    L18:
        return (s51.c) r8;
    L22:
        return null;
    }

    public static /* synthetic */ s51.c f(RevLinkDomainAnchorService r2, String r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = null;
    L9:
        return r2.d(r3, r4);
    }

    public RevLinkDomainAnchorService(i r16, g r17, com.bytedance.android.live.revenuelink.rtc.i r18, n r19, AnchorUILayoutManager r20, PushModeManagerService r22, com.bytedance.android.livesdk.revenue.service.room.c r23, com.bytedance.android.live.revlink.link.streaminteract.biz.c r24, f r25, com.bytedance.android.livesdk.revenue.service.message.d r26, RevLinkBizScopeAnchorLaunchService r27) {
        Intrinsics.checkNotNullParameter(r16, "layoutContext");
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "rtcManager");
        Intrinsics.checkNotNullParameter(r19, "linkOutManager");
        Intrinsics.checkNotNullParameter(r20, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r22, "pushManager");
        Intrinsics.checkNotNullParameter(r23, "roomService");
        Intrinsics.checkNotNullParameter(r24, "streamMixManager");
        Intrinsics.checkNotNullParameter(r25, "messageService");
        Intrinsics.checkNotNullParameter(r26, "messageManagerService");
        Intrinsics.checkNotNullParameter(r27, "bizLaunchService");
        this.m = r16;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r22;
        this.r = r23;
        this.s = r24;
        this.t = r25;
        this.u = r26;
        this.v = r27;
        this.a = new CompositeDisposable();
        this.b = new NormalStreamMixStrategy(r20, this, r17, r23);
        this.c = new CompositeDisposable();
        this.d = new NextLiveData();
        this.e = new NextLiveData();
        MultiMuteManager r7 = new MultiMuteManager(r17, this, r18);
        this.f = r7;
        this.g = new a(r7);
        this.h = new CoreContext(r17, r23, r25, r26, r20, r7);
        this.i = new RenderControl(r17.l, r17);
        com.bytedance.android.live.revenuelink.connect.f r1 = r17.Z0();
        if (r1 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.l r2 = r1.linkInManager();
    L6:
        com.bytedance.android.live.revenuelink.connect.l r3 = r2;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.l.a(r3);
        this.j = new DomainLaunchTask(r18, r3, r17, r22, r20, r23, r24);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
