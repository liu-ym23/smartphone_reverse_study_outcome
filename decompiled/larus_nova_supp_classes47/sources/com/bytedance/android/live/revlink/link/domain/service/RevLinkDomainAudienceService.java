package com.bytedance.android.live.revlink.link.domain.service;

import android.graphics.RectF;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.impl.dynamiclayout.RevenueDynamicLayout;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiDynamicManager;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.MultiDynamicContextImpl;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.e0;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.k0;
import com.bytedance.android.live.revlink.impl.multianchor.model.WindowType;
import com.bytedance.android.live.revlink.link.biz.component.AudioPunishComponent;
import com.bytedance.android.live.revlink.link.biz.service.j;
import com.bytedance.android.live.revlink.link.core.service.s;
import com.bytedance.android.live.revlink.link.domain.dependencyimpl.DynamicContextDependencyImpl;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.m0;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.m;
import f31.i;
import f31.k;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import o51.e;
import yz0.f;
import z41.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevLinkDomainAudienceService implements o, j {
    public final CompositeDisposable a;
    public final q51.a b;
    public final PkBaseDataContext c;
    public final DynamicContextDependencyImpl d;
    public final com.bytedance.android.live.revlink.link.domain.dependencyimpl.a e;
    public final DomainManualLayout f;
    public AudioPunishComponent g;
    public final MultiDynamicContextImpl h;
    public final MultiDynamicManager i;
    public final h j;
    public final com.bytedance.android.livesdk.revenue.service.room.c k;
    public final f l;
    public final com.bytedance.android.livesdk.revenue.service.message.d m;
    public final RevLinkBizScopeAudienceLaunchService n;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAudienceService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/revenue/common/player/vendor/link/RevSeiFrame;", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<RevSeiFrame, Unit> {
        public AnonymousClass1(RevLinkDomainAudienceService r8) {
            super(1, r8, RevLinkDomainAudienceService.class, "onSeiFrameChange", "onSeiFrameChange(Lcom/bytedance/android/live/revenue/common/player/vendor/link/RevSeiFrame;)V", 0);
        }

        public final void invoke(RevSeiFrame r9) {
            RevLinkDomainAudienceService r0 = (RevLinkDomainAudienceService) ((CallableReference) this).receiver;
            if (r9 != null) goto L5;
            r0.getClass();
            return;
        L5:
            MultiDynamicContextImpl r1 = r0.h;
            String r10 = r9.C;
            r1.getClass();
            if (r10 != null) goto L8;
            return;
        L8:
            if (StringsKt.contains$default(r10, "app_data", false, 2, null) != true) goto L21;
            k0 r5 = r1.g;
            r5.getClass();
            if (StringsKt.contains$default(r10, "app_data", false, 2, null) != true) goto L14;
            r5.r = r10;
        L14:
            e0 r2 = r1.h;
            r2.getClass();
            if (StringsKt.contains$default(r10, "app_data", false, 2, null) != true) goto L22;
            r2.e = r10;
            return;
        L22:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((RevSeiFrame) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAudienceService$onStart$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lg90/a;", "p1", "", "invoke", "(Lg90/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<g90.a, Unit> {
        public AnonymousClass2(RevLinkDomainAudienceService r8) {
            super(1, r8, RevLinkDomainAudienceService.class, "onInteractStatusUpdate", "onInteractStatusUpdate(Lcom/bytedance/android/live/datacenter/InteractStatus;)V", 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void invoke(g90.a r39) {
            RevLinkDomainAudienceService r2 = (RevLinkDomainAudienceService) ((CallableReference) this).receiver;
            if (r39 != null) goto L6;
            r2.getClass();
            return;
        L6:
            if (r2.f.a == true) goto L211;
            RevSeiFrame r12 = RevSeiFrame.a.a(RevSeiFrame.G, r39.c, false, 6);
            p0 r3 = r12.b();
            if (r3 == null) goto L212;
            String r7 = "";
            if (r12.p() == false) goto L24;
            RectF r1 = r39.b;
            p r4 = r2.getContext().d.d.getGuestInfo(r2.getContext().d.n, null);
            if (r4 == null) goto L19;
            String r5 = r4.getInteractId();
            if (r5 == null) goto L19;
            String r13 = r5;
        L20:
            float r6 = r1.right;
            float r8 = r1.left;
            int r9 = (int) (r6 - r8);
            int r10 = (int) r8;
            if (r2.c.getCloudCollaboratePanelType() != IBattleConfigSetting.BattleCloudCollaboratePanelType.BattleCloudCollaboratePanelType_ThroneFight.ordinal()) goto L23;
            r9 = RangesKt.coerceAtMost((int) (((double) r1.height()) * 0.5625d), r2.getContext().getContainerWidth());
            r10 = (r2.getContext().getContainerWidth() - r9) / 2;
        L23:
            List r14 = CollectionsKt.listOf(new k(r13, r2.getContext().d.n, 0, 0, (int) r1.width(), (int) r1.height(), true, true, 0, DefaultConfig.MAX_CACHE_ENTRIES, 0));
            String r15 = r12.C;
            float r16 = r1.bottom;
            float r17 = r1.top;
            r2.d.getWindowStatus().setValue(new i(r14, r15, new com.bytedance.android.live.revlink.impl.multianchor.dynamic.i(r9, (int) (r16 - r17), r10, (int) r17), r12, r12.d(), null, null, 96));
            return;
        L19:
            r13 = "";
            goto L20
        L24:
            xx0.a r18 = new xx0.a(r39);
            RectF r19 = r39.b;
            q51.a r20 = r2.b;
            r20.getClass();
            Intrinsics.checkNotNullParameter(r3, "appData");
            Intrinsics.checkNotNullParameter(r12, "seiFrame");
            Intrinsics.checkNotNullParameter(r39, "interactStatus");
            Intrinsics.checkNotNullParameter(r18, "interactDraw");
            if (g.o.b() == true) goto L27;
        L29:
            List r110 = r3.e();
        L30:
            List r111 = r110;
            ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
            Iterator r113 = r111.iterator();
            int r114 = 0;
        L32:
            if (r113.hasNext() == false) goto L51;
            Object r115 = r113.next();
            int r116 = r114 + 1;
            if (r114 >= 0) goto L36;
            CollectionsKt.throwIndexOverflow();
        L36:
            RevSeiRegion r117 = (RevSeiRegion) r115;
            String r118 = r7;
            r19 = r19;
            RevLinkDomainAudienceService r25 = r2;
            RectF r22 = new RectF((float) r117.getX(), (float) r117.getY(), (float) (r117.getX() + r117.getWidth()), (float) (r117.getY() + r117.getHeight()));
            n0 r0 = r12.g();
            Intrinsics.checkNotNullParameter(r22, "seiGrid");
            RectF r23 = new RectF(com.bytedance.android.live.revenue.common.player.utils.b.a(r22, r0));
            r18.a.a.mapRect(r23);
            RectF r24 = new RectF(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r23.left, 0.0f), r20.getContext().getContainerWidth()), RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r23.top, 0.0f), r20.getContext().l()), RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r23.right, 0.0f), r20.getContext().getContainerWidth()), RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r23.bottom, 0.0f), r20.getContext().l()));
            String r27 = r117.getInteractId();
            p r26 = com.bytedance.android.live.revlink.link.biz.service.i.t(r20).getGuestInfo(null, r117.getInteractId());
            if (r26 == null) goto L44;
            IBaseUser r28 = r26.getUser();
            if (r28 == null) goto L44;
            String r29 = iz.a.a(r28);
            if (r29 == null) goto L44;
            String r210 = r29;
        L45:
            int r30 = (int) r24.left;
            int r32 = (int) r24.top;
            int r33 = (int) r24.width();
            int r34 = (int) r24.height();
            boolean r35 = r117.isLocal();
            if (r3.getVersion() != 2) goto L49;
            if (r114 <= 0) goto L49;
            int r36 = WindowType.Guest.ordinal();
        L50:
            r112.add(new k(r27, r210, r30, r32, r33, r34, r35, true, r36, 512, 0));
            r114 = r116;
            r7 = r118;
            r2 = r25;
        L49:
            r36 = r117.getWindowType();
        L44:
            r210 = r118;
            goto L45
        L51:
            RevLinkDomainAudienceService r211 = r2;
            String r119 = r7;
            Integer r37 = r12.n();
            if (r37 != null) goto L55;
        L53:
            Throwable r38 = null;
        L71:
            ArrayList r212 = r112;
        L73:
            boolean r40 = true;
            if (IRoomKtKt.getStreamType(r211.getContext().getRoom()) != LiveMode.SCREEN_RECORD) goto L76;
            boolean r42 = true;
        L77:
            o51.f r43 = r12.t(r42, ((Boolean) r211.d.getChangeScreenEvent().getValue()).booleanValue());
            if (Intrinsics.areEqual(r43, o51.f.j.e) == false) goto L80;
        L195:
            Object r44 = e.f.e;
        L196:
            RectF r45 = o51.a.e(r212);
            com.bytedance.android.live.revlink.impl.multianchor.dynamic.i r120 = new com.bytedance.android.live.revlink.impl.multianchor.dynamic.i(RangesKt.coerceAtMost((int) r45.width(), r211.getContext().getContainerWidth()), RangesKt.coerceAtMost((int) r45.height(), r211.getContext().l()), (int) r45.left, RangesKt.coerceAtLeast((int) r45.top, 0));
            RectF r46 = new RectF(RangesKt.coerceAtLeast(r19.left, 0.0f), RangesKt.coerceAtLeast(r19.top, 0.0f), RangesKt.coerceAtMost(r19.right, r211.getContext().getContainerWidth()), RangesKt.coerceAtMost(r19.bottom, r211.getContext().l()));
            com.bytedance.android.live.revlink.link.domain.dependencyimpl.a r47 = r211.e;
            m0 r48 = r3.f();
            if (r48 == null) goto L199;
            String r49 = r48.b();
        L200:
            r47.a = r49;
            com.bytedance.android.live.revlink.link.domain.dependencyimpl.a r50 = r211.e;
            m0 r52 = r3.f();
            if (r52 == null) goto L203;
            Integer r53 = Integer.valueOf(r52.c());
        L204:
            r50.b = r53;
            r211.d.getWindowStatus().setValue(new i(r212, r12.C, r120, r12, r12.d(), null, null, 96));
            r211.getContext().d.i.setValue(r44);
            r211.getContext().d.h.setValue(new f31.f(r212, r46, r45, r39.a, r43));
            jy0.b.c("DomainManualLayout", "domain layoutStatus " + ((f31.f) r211.getContext().d.h.getValue()), r38, 4);
            return;
        L203:
            r53 = r38;
            goto L204
        L199:
            r49 = r38;
            goto L200
        L80:
            if (Intrinsics.areEqual(r43, o51.f.C0284f.e) == true) goto L195;
            if (Intrinsics.areEqual(r43, o51.f.g.e) == true) goto L195;
            if (Intrinsics.areEqual(r43, o51.f.b.e) == false) goto L102;
            m0 r54 = r3.f();
            if (r54 == null) goto L92;
            String r55 = r54.b();
            if (r55 == null) goto L92;
            Intrinsics.checkNotNullParameter(r55, "$this$uid");
            String r56 = j.a.b(r211, r55);
            if (r56 == null) goto L92;
        L93:
            m0 r57 = r3.f();
            if (r57 == null) goto L99;
            String r58 = r57.b();
            if (r58 == null) goto L99;
            String r59 = r58;
        L100:
            r44 = new e.c(r56, r59, IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
        L99:
            r59 = r119;
        L92:
            r56 = r119;
            goto L93
        L102:
            if (Intrinsics.areEqual(r43, o51.f.c.e) == false) goto L119;
            m0 r60 = r3.f();
            if (r60 == null) goto L109;
            String r62 = r60.b();
            if (r62 == null) goto L109;
            Intrinsics.checkNotNullParameter(r62, "$this$uid");
            String r63 = j.a.b(r211, r62);
            if (r63 == null) goto L109;
        L110:
            m0 r64 = r3.f();
            if (r64 == null) goto L116;
            String r65 = r64.b();
            if (r65 == null) goto L116;
            String r66 = r65;
        L117:
            r44 = new e.d(r63, r66, IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
        L116:
            r66 = r119;
        L109:
            r63 = r119;
            goto L110
        L119:
            if (Intrinsics.areEqual(r43, o51.f.d.e) == false) goto L134;
            m0 r67 = r3.f();
            if (r67 == null) goto L126;
            String r68 = r67.b();
            if (r68 == null) goto L126;
            Intrinsics.checkNotNullParameter(r68, "$this$uid");
            String r69 = j.a.b(r211, r68);
            if (r69 == null) goto L126;
        L127:
            m0 r70 = r3.f();
            if (r70 == null) goto L131;
            String r72 = r70.b();
            if (r72 == null) goto L131;
        L132:
            r44 = new e.C0283e(true, r69, r72);
        L131:
            r72 = r119;
        L126:
            r69 = r119;
            goto L127
        L134:
            if (Intrinsics.areEqual(r43, o51.f.e.e) == false) goto L151;
            m0 r73 = r3.f();
            if (r73 == null) goto L141;
            String r74 = r73.b();
            if (r74 == null) goto L141;
            Intrinsics.checkNotNullParameter(r74, "$this$uid");
            String r75 = j.a.b(r211, r74);
            if (r75 == null) goto L141;
        L142:
            m0 r76 = r3.f();
            if (r76 == null) goto L148;
            String r77 = r76.b();
            if (r77 == null) goto L148;
            String r78 = r77;
        L149:
            r44 = new e.C0283e(false, r75, r78);
        L148:
            r78 = r119;
        L141:
            r75 = r119;
            goto L142
        L151:
            if (Intrinsics.areEqual(r43, o51.f.k.e) == false) goto L154;
            r44 = e.g.e;
            goto L196
        L154:
            if (Intrinsics.areEqual(r43, o51.f.n.e) == false) goto L161;
            String r79 = r211.getContext().d.n;
            String r80 = com.bytedance.android.live.revlink.link.biz.service.i.T(r211).c();
            if (r80 != null) goto L158;
            String r82 = r119;
        L159:
            r44 = new e.i(false, false, r79, r82);
            goto L196
        L158:
            r82 = r80;
            goto L159
        L161:
            if (Intrinsics.areEqual(r43, o51.f.l.e) == true) goto L191;
            if (Intrinsics.areEqual(r43, o51.f.m.e) == true) goto L191;
            if (Intrinsics.areEqual(r43, o51.f.i.e) == false) goto L169;
            r44 = e.f.e;
            goto L196
        L169:
            if (Intrinsics.areEqual(r43, o51.f.h.e) == false) goto L186;
            m0 r83 = r3.f();
            if (r83 == null) goto L176;
            String r84 = r83.b();
            if (r84 == null) goto L176;
            Intrinsics.checkNotNullParameter(r84, "$this$uid");
            String r85 = j.a.b(r211, r84);
            if (r85 == null) goto L176;
        L177:
            m0 r86 = r3.f();
            if (r86 == null) goto L183;
            String r87 = r86.b();
            if (r87 == null) goto L183;
            String r88 = r87;
        L184:
            r44 = new e.c(r85, r88, IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
        L183:
            r88 = r119;
        L176:
            r85 = r119;
            goto L177
        L186:
            if ((r43 instanceof o51.f.a) == false) goto L189;
            r44 = new e.a(r43);
            goto L196
        L189:
            throw new NoWhenBranchMatchedException();
        L191:
            if (((Number) r12.t.getValue()).intValue() != 0) goto L194;
            r40 = false;
        L194:
            r44 = new e.h(r40);
            goto L196
        L76:
            r42 = false;
            goto L77
        L55:
            if (r37.intValue() != 2) goto L53;
            r38 = null;
            p r89 = r211.getContext().d.d.getGuestInfo(r211.getContext().d.n, null);
            if (r89 == null) goto L63;
            String r90 = r89.getInteractId();
            if (r90 == null) goto L63;
            String r213 = r90;
        L65:
            if (g.o.b() == true) goto L67;
        L69:
            k r92 = (k) CollectionsKt.firstOrNull(r112);
            if (r92 == null) goto L71;
            k r93 = new k(r213, r211.getContext().d.n, RangesKt.coerceAtLeast(0, (int) r19.left), r92.d, r92.e, r92.f, true, true, 0, DefaultConfig.MAX_CACHE_ENTRIES, 0);
            ArrayList r94 = new ArrayList();
            r94.add(r93);
            r94.addAll(r112);
            r212 = r94;
            goto L73
        L67:
            if (r12.h() == false) goto L69;
        L63:
            r213 = r119;
            goto L65
        L27:
            if (r12.h() == false) goto L29;
            r110 = r3.h();
            goto L30
        L212:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((g90.a) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAudienceService$onStart$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass3(RevLinkDomainAudienceService r8) {
            super(0, r8, RevLinkDomainAudienceService.class, "onSwitchScene", "onSwitchScene()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m942invoke() {
            ((RevLinkDomainAudienceService) ((CallableReference) this).receiver).getClass();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m942invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAudienceService$onStart$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lb03/b;", "p1", "", "invoke", "(Lb03/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<b03.b, Unit> {
        public AnonymousClass4(RevLinkDomainAudienceService r8) {
            super(1, r8, RevLinkDomainAudienceService.class, "onPlatformConfigChange", "onPlatformConfigChange(Lcom/bytedance/android/platform/PlatformConfig;)V", 0);
        }

        public final void invoke(b03.b r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ((RevLinkDomainAudienceService) ((CallableReference) this).receiver).d.getChangeScreenEvent().setValue(Boolean.valueOf(r2.a));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((b03.b) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAudienceService$onStart$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass5(PkBaseDataContext r8) {
            super(0, r8, PkBaseDataContext.class, "onResume", "onResume()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m943invoke() {
            ((PkBaseDataContext) ((CallableReference) this).receiver).onResume();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m943invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAudienceService$onStart$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass6(PkBaseDataContext r8) {
            super(0, r8, PkBaseDataContext.class, "onPause", "onPause()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m944invoke() {
            ((PkBaseDataContext) ((CallableReference) this).receiver).onPause();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m944invoke();
            return Unit.INSTANCE;
        }
    }

    public final void onStart() {
        MultiDynamicManager r0 = this.i;
        r0.l = getContext().wo();
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.d(getContext().a, new AnonymousClass1(this)), this.a);
        this.h.n();
        this.i.o();
        g r1 = g.o;
        r1.getClass();
        if (((Boolean) g.e.getValue(r1, g.a[3])).booleanValue() == true) goto L5;
        getContext().d.d.b(4, "multi_anchor_link_widget_create");
    L5:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().d.y.s9(), new AnonymousClass2(this)), this.a);
        this.d.getChannelId().setValue(Long.valueOf(getContext().d.p));
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.g(getContext().d.e, new AnonymousClass3(this)), this.a);
        AudioPunishComponent r2 = new AudioPunishComponent(getContext(), this.k, this.c, null);
        this.g = r2;
        r2.attach();
        final RevLinkBizScopeAudienceLaunchService r3 = this.n;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.g(r3.c.d.e, new RevLinkBizScopeAudienceLaunchService$startBizScope$1(r3)), r3.a);
        r3.a("startBizScope");
        com.bytedance.revenue.platform.api.core.rx.f.a(getContext().Pi(new AnonymousClass4(this)), this.a);
        m<Boolean> r4 = this.d.getChangeScreenEvent();
        b03.a r5 = b03.a.a;
        r4.setValue(Boolean.valueOf(b03.a.c()));
        com.bytedance.revenue.platform.api.core.rx.f.a(getContext().x7(new AnonymousClass5(this.c), new AnonymousClass6(this.c)), this.a);
    }

    public final void onStop() {
        this.a.clear();
        this.h.o();
        this.i.q();
        AudioPunishComponent r0 = this.g;
        if (r0 == null) goto L5;
        r0.detach();
    L5:
        getContext().d.y.Y8().setValue(Boolean.TRUE);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public h getContext() {
        return this.j;
    }

    public RevLinkDomainAudienceService(h r18, com.bytedance.android.livesdk.revenue.service.room.c r19, f r20, com.bytedance.android.livesdk.revenue.service.message.d r22, RevLinkBizScopeAudienceLaunchService r23) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "revRoomService");
        Intrinsics.checkNotNullParameter(r20, "messageService");
        Intrinsics.checkNotNullParameter(r22, "messageManagerService");
        Intrinsics.checkNotNullParameter(r23, "bizLauncherService");
        this.j = r18;
        this.k = r19;
        this.l = r20;
        this.m = r22;
        this.n = r23;
        CompositeDisposable r12 = new CompositeDisposable();
        this.a = r12;
        this.b = new q51.a(getContext());
        final PkBaseDataContext r13 = new PkBaseDataContext(new RevLinkDomainAudienceService$pkContext$1(this), false, getContext().d.y, getContext().d.v, r19, getContext(), r20, getContext().d.z, getContext());
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) com.bytedance.live.datacontext.d.a(new RevLinkDomainAudienceService$pkContext$2$1(r13)).getSecond(), r12);
        r13.getContext().T6(PkBaseDataContext.TAG, r13);
        Unit r1 = Unit.INSTANCE;
        this.c = r13;
        DynamicContextDependencyImpl r9 = new DynamicContextDependencyImpl();
        this.d = r9;
        com.bytedance.android.live.revlink.link.domain.dependencyimpl.a r10 = new com.bytedance.android.live.revlink.link.domain.dependencyimpl.a();
        this.e = r10;
        this.f = new DomainManualLayout(r10, r9, getContext(), (s) RevenueDynamicLayout.a.getValue());
        MultiDynamicContextImpl r15 = new MultiDynamicContextImpl(new RevLinkDomainAudienceService$dynamicContext$1(this), getContext().d.y, r19, getContext(), r13, r9, getContext().d.d, r9, r10, null, null, 3584);
        this.h = r15;
        RevLinkDomainAudienceService$dynamicManager$1 r2 = RevLinkDomainAudienceService$dynamicManager$1.INSTANCE;
        x51.a r3 = getContext().d.u;
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.g() == false) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r4 = r15.h;
    L6:
        MultiDynamicManager r7 = new MultiDynamicManager(r2, r3, r19, r4, com.bytedance.android.live.revlink.impl.multianchor.dynamic.h.b.b);
        r15.c = r7;
        this.i = r7;
        return;
    L5:
        r4 = r15.g;
        goto L6
    }
}
