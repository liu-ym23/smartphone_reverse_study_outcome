package com.bytedance.android.live.revlink.link.biz.component;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.e0;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.DoubleRematchType;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RoomStateDispatchAnchorComponent implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final CompositeDisposable a;
    public final String b;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a c;
    public final com.bytedance.android.live.revenuelink.rtc.i d;
    public final AnchorUILayoutManager e;
    public final h f;
    public final com.bytedance.android.livesdk.revenue.service.room.c g;
    public final PkBaseDataContext h;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.RoomStateDispatchAnchorComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lf31/f;", "p1", "", "invoke", "(Lf31/f;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<f31.f, Unit> {
        public AnonymousClass1(RoomStateDispatchAnchorComponent r8) {
            super(1, r8, RoomStateDispatchAnchorComponent.class, "onLayoutStatusChange", "onLayoutStatusChange(Lcom/bytedance/android/live/revlink/impl/multianchor/model/LayoutStatus;)V", 0);
        }

        public final void invoke(f31.f r25) {
            RoomStateDispatchAnchorComponent r2 = (RoomStateDispatchAnchorComponent) ((CallableReference) this).receiver;
            if (r25 != null) goto L6;
            r2.getClass();
            return;
        L6:
            if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(r2.getContext()) == false) goto L123;
            List<f31.k> r3 = r25.a;
            if (r3 == null) goto L10;
            int r4 = r3.size();
        L12:
            if (r4 < 2) goto L216;
            int r5 = ((int) r25.b.bottom) + com.bytedance.android.live.revenue.common.i.b(48);
            if (r2.d.isEngineOn() == false) goto L17;
            boolean r10 = r2.d.G();
        L18:
            boolean r13 = r10;
            Integer r12 = Integer.valueOf(r5);
            int r17 = ((int) r25.b.bottom) + com.bytedance.android.live.revenue.common.i.b(48);
            if (d51.c.A0.g() == false) goto L25;
            com.bytedance.android.live.revlink.link.biz.service.i.q(r2).getClass();
            qr2.b r6 = com.bytedance.android.live.revlink.impl.pk.utils.h.d();
            com.bytedance.android.live.revlink.link.core.service.g r9 = r25.f;
            if (r9 == null) goto L23;
            int r14 = r9.b;
        L24:
            r6.d = r14;
            Unit r15 = Unit.INSTANCE;
            qr2.b r20 = r6;
        L26:
            gt1.d r7 = gt1.e.a(0, r12, r13, false, false, true, r17, false, false, r20, 564);
            r2.getContext().getLinkDataSet().Y1().setValue(r7);
            r2.getContext().getRoomDataCenterService().S1(r7);
            RectF r16 = r25.b;
            List<f31.k> r18 = r25.a;
            if (r18 == null) goto L121;
            Iterator<T> r19 = r18.iterator();
        L30:
            if (r19.hasNext() == false) goto L34;
            Object r110 = r19.next();
            if (Intrinsics.areEqual(((f31.k) r110).b, r2.getContext().Ab()) == false) goto L30;
        L35:
            f31.k r111 = (f31.k) r110;
            if (r111 == null) goto L121;
            int r112 = r111.f;
            Iterator<T> r1 = r25.a.iterator();
        L39:
            if (r1.hasNext() == false) goto L43;
            Object r113 = r1.next();
            if (Intrinsics.areEqual(((f31.k) r113).b, com.bytedance.android.live.revlink.link.biz.service.i.T(r2).c()) == false) goto L39;
        L44:
            f31.k r114 = (f31.k) r113;
            if (r114 == null) goto L47;
            int r8 = r114.f;
        L48:
            Intrinsics.checkNotNullParameter(r2, "$this$windowDiffCheckUtil");
            e0 r115 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(r2).w6();
            int r22 = (int) (r16.width() / 2);
            int r116 = (int) r16.left;
            int r23 = (int) r16.top;
            com.bytedance.android.live.revlink.impl.global.c r117 = r115.a;
            if (r117 == null) goto L51;
            RevLinkWindowRegionContext r118 = r117.P8();
        L52:
            if (r118 == null) goto L121;
            com.bytedance.android.live.revlink.impl.region.d r119 = r118.getRevUiRegionUpdater();
            if (r119 == null) goto L121;
            com.bytedance.android.live.revlink.impl.global.c r120 = r119.f;
            if (r120 == null) goto L58;
            w31.c r121 = r120.getPkLinkUtils();
        L59:
            if (r121 == null) goto L61;
            String r122 = r121.c();
        L62:
            com.bytedance.android.livesdk.revenue.service.room.c r123 = r119.e;
            if (r123 == null) goto L71;
            com.bytedance.android.livesdk.revenue.room.a r124 = r123.getRoomContext();
            if (r124 == null) goto L71;
            IRoomBase r125 = r124.getCommonRoom();
            if (r125 == null) goto L71;
            IBaseUser r126 = r125.getOwnerKt();
            if (r126 == null) goto L71;
            String r127 = r126.getIdString();
        L72:
            if (r122 != null) goto L74;
        L77:
            boolean r128 = true;
        L78:
            if (r128 == false) goto L80;
            r122 = "right";
        L80:
            if (r127 != null) goto L82;
        L85:
            boolean r129 = true;
        L86:
            if (r129 == false) goto L88;
            r127 = "left";
        L88:
            RevLinkWindowRegionContext r24 = r119.a();
            if (r24 == null) goto L93;
            pc0.c r26 = r24.getRegion(r122);
            if (r26 == null) goto L93;
            boolean r27 = com.bytedance.android.live.revlink.impl.region.e.a(r26, r22, r8, r116 + r22, r23);
        L94:
            RevLinkWindowRegionContext r28 = r119.a();
            if (r28 == null) goto L99;
            pc0.c r29 = r28.getRegion(r127);
            if (r29 == null) goto L99;
            boolean r30 = com.bytedance.android.live.revlink.impl.region.e.a(r29, r22, r112, r116, r23);
        L100:
            if (r27 == true) goto L105;
            RevLinkWindowRegionContext r32 = r119.a();
            if (r32 == null) goto L105;
            r32.updateRegion(r122, new pc0.c(r122, r116 + r22, r23, r22, r8));
        L105:
            if (r30 == true) goto L109;
            RevLinkWindowRegionContext r0 = r119.a();
            if (r0 == null) goto L109;
            r0.updateRegion(r127, new pc0.c(r127, r116, r23, r22, r112));
        L109:
            if (r27 == false) goto L113;
            if (r30 == false) goto L113;
            boolean r33 = true;
            boolean r34 = false;
        L114:
            if (r34 != r33) goto L122;
            com.bytedance.android.live.revlink.impl.global.c r35 = r115.a;
            if (r35 == null) goto L118;
            RevLinkWindowRegionContext r36 = r35.P8();
        L119:
            if (r36 == null) goto L122;
            r36.notifyRegionUpdate();
            goto L122
        L118:
            r36 = null;
        L122:
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r2), "updateRoomState onClassicDoubleLayoutStatusChange with " + r7, null, 4);
            return;
        L113:
            r33 = true;
            r34 = true;
        L99:
            r30 = false;
        L93:
            r27 = false;
            goto L94
        L82:
            if (StringsKt.isBlank(r127) == true) goto L85;
            r129 = false;
            goto L86
        L74:
            if (StringsKt.isBlank(r122) == true) goto L77;
            r128 = false;
        L71:
            r127 = null;
            goto L72
        L61:
            r122 = null;
            goto L62
        L58:
            r121 = null;
            goto L59
        L51:
            r118 = null;
            goto L52
        L47:
            r8 = 0;
            goto L48
        L43:
            r113 = null;
            goto L44
        L34:
            r110 = null;
        L121:
            r2 = r2;
            r7 = r7;
            goto L122
        L23:
            r14 = 0;
            goto L24
        L25:
            r20 = null;
            goto L26
        L17:
            r10 = com.bytedance.android.live.revlink.impl.pk.utils.p.a(r2.g.getRoomContext().getCommonRoom());
            goto L18
        L216:
            return;
        L10:
            r4 = 0;
            goto L12
        L123:
            RectF r37 = r25.b;
            List<f31.k> r38 = r25.a;
            if (r38 == null) goto L126;
            int r39 = r38.size();
        L127:
            List<f31.k> r40 = r25.a;
            if (r40 == null) goto L139;
            Iterator<T> r42 = r40.iterator();
        L131:
            if (r42.hasNext() == false) goto L135;
            Object r43 = r42.next();
            if (Intrinsics.areEqual(((f31.k) r43).b, r2.getContext().Ab()) == false) goto L131;
        L136:
            f31.k r44 = (f31.k) r43;
            if (r44 == null) goto L139;
            Intrinsics.checkNotNullParameter(r44, "$this$rectF");
            int r45 = r44.c;
            int r46 = r44.d;
            RectF r47 = new RectF(r45, r46, r45 + r44.e, r46 + r44.f);
        L141:
            if (r2.d.G() == false) goto L143;
            RectF r48 = r37;
        L144:
            jy0.b.c("testSingle", "onClassicMultiLayoutStatusChange " + r48.width() + '-' + r48.height(), null, 4);
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r2), "updateRoomState use singleViewMode: " + r2.d.G() + " and engineOn: " + r2.d.isEngineOn(), null, 4);
            qr2.b r49 = new qr2.b((int) r48.width(), (int) r48.height(), (int) r48.left, (int) r48.top);
            qr2.d r50 = new qr2.d();
            r50.k = r39;
            r50.f = 1;
            if (d51.c.A0.g() == false) goto L151;
            com.bytedance.android.live.revlink.link.biz.service.i.q(r2).getClass();
            qr2.b r52 = com.bytedance.android.live.revlink.impl.pk.utils.h.d();
            com.bytedance.android.live.revlink.link.core.service.g r53 = r25.f;
            if (r53 == null) goto L149;
            int r54 = r53.b;
        L150:
            r52.d = r54;
            Unit r55 = Unit.INSTANCE;
        L152:
            r50.m = r52;
            r50.l = r49;
            r50.n = r47;
            float r56 = r37.top;
            r50.g = (int) r56;
            r50.h = (int) (r56 + r37.height());
            r50.p = r2.e.e.a.b;
            o51.f r57 = r25.e;
            if ((r57 instanceof o51.f.b) == false) goto L155;
        L157:
            String r58 = com.bytedance.android.live.revlink.link.biz.service.e.a.a(r2);
            StringBuilder r59 = new StringBuilder();
            o51.e r60 = (o51.e) r2.getContext().getUiLayout().getValue();
            if (r60 == null) goto L160;
            String r62 = o51.g.a(r60);
        L161:
            r59.append(r62);
            r59.append(", ");
            r59.append(r25.a);
            jy0.b.c(r58, r59.toString(), null, 4);
            List<f31.k> r63 = r25.a;
            if (r63 != null) goto L164;
        L196:
            int r64 = 0;
        L197:
            r50.q = r64;
            r50.o = true;
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r2), "updateRoomState onClassicMultiLayoutStatusChange with " + r50, null, 4);
            r2.getContext().getLinkDataSet().ho().setValue(r50);
            r2.getContext().getRoomDataCenterService().Xf(r50);
            r2.a(r25);
            return;
        L164:
            if (r63.isEmpty() == true) goto L196;
            ArrayList r65 = new ArrayList();
            Iterator<T> r66 = r63.iterator();
        L168:
            if (r66.hasNext() == false) goto L182;
            Object r67 = r66.next();
            f31.k r68 = (f31.k) r67;
            if ((!StringsKt.isBlank(r68.b)) == false) goto L178;
            String r69 = r68.b;
            o51.e r70 = (o51.e) r2.getContext().getUiLayout().getValue();
            if (r70 == null) goto L174;
            String r72 = o51.g.b(r70);
        L176:
            if ((!Intrinsics.areEqual(r69, r72)) == false) goto L178;
            boolean r73 = true;
        L179:
            if (r73 == false) goto L168;
            r65.add(r67);
            goto L168
        L174:
            r72 = null;
        L178:
            r73 = false;
            goto L179
        L182:
            if (r65.isEmpty() == true) goto L196;
            ArrayList r74 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r65, 10));
            Iterator r75 = r65.iterator();
        L186:
            if (r75.hasNext() == false) goto L189;
            r74.add(Integer.valueOf(((f31.k) r75.next()).c));
            goto L186
        L189:
            if (r65.size() <= 5) goto L194;
            Integer r76 = (Integer) CollectionsKt.maxOrNull(r74);
            if (r76 == null) goto L193;
            int r77 = r76.intValue();
        L195:
            b03.a r78 = b03.a.a;
            r64 = com.bytedance.android.live.revenue.common.i.b(24) + (s1.y() - r77);
            goto L197
        L193:
            r77 = 0;
            goto L195
        L194:
            r77 = ((Number) CollectionsKt.first(r74)).intValue();
            goto L195
        L160:
            r62 = null;
            goto L161
        L155:
            if (r57.a() == true) goto L157;
        L149:
            r54 = 0;
            goto L150
        L151:
            r52 = null;
            goto L152
        L143:
            r48 = r47;
            goto L144
        L135:
            r43 = null;
        L139:
            r47 = r37;
            goto L141
        L126:
            r39 = 0;
            goto L127
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((f31.f) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.RoomStateDispatchAnchorComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", "invoke", "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<List<? extends com.bytedance.android.livesdk.link.model.p>, Integer, Unit> {
        public AnonymousClass2(RoomStateDispatchAnchorComponent r8) {
            super(2, r8, RoomStateDispatchAnchorComponent.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
        }

        public final void invoke(List<? extends com.bytedance.android.livesdk.link.model.p> r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "p1");
            RoomStateDispatchAnchorComponent r3 = (RoomStateDispatchAnchorComponent) ((CallableReference) this).receiver;
            f31.f r4 = (f31.f) r3.getContext().hh().getValue();
            if (r4 == null) goto L7;
            r3.a(r4);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((List) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.RoomStateDispatchAnchorComponent$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass3(RoomStateDispatchAnchorComponent r8) {
            super(1, r8, RoomStateDispatchAnchorComponent.class, "onBizEnd", "onBizEnd(I)V", 0);
        }

        public final void invoke(int r14) {
            RoomStateDispatchAnchorComponent r0 = (RoomStateDispatchAnchorComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r14 != 1) goto L7;
            gt1.d r15 = gt1.e.a(3, null, false, false, true, false, 0, false, false, null, 1996);
            r0.getContext().getLinkDataSet().Y1().setValue(r15);
            r0.getContext().getRoomDataCenterService().S1(r15);
            r0.getContext().getLinkDataSet().ke().setValue(0);
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r0), "updateRoomState onBizEnd with " + r15, null, 4);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Number) r1).intValue());
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        int r1 = getContext().getScene();
        if (r1 != 1) goto L5;
        h r2 = this.f;
        u r5 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r5 == null) goto L11;
        int r6 = r5.A;
    L12:
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r7 = com.bytedance.android.live.revlink.link.biz.service.i.z(this);
        if (r7 == null) goto L32;
        com.bytedance.live.datacontext.m<Integer> r8 = r7.getMatchType();
        if (r8 == null) goto L32;
        if (((Number) r8.getValue()).intValue() != 1) goto L32;
        if (r6 <= 0) goto L32;
        long r9 = ((long) (r6 * WebcastRedirectException.UNKNOWN)) + this.h.getPkStartTimeMs();
        i97.a r10 = i97.a.a;
        if (r9 <= System.currentTimeMillis()) goto L22;
        boolean r12 = true;
    L23:
        h r13 = this.f;
        if (r13.f == true) goto L26;
        if (r12 == false) goto L32;
        if (((Number) l51.a.h0.getValue(null, l51.a.a[69])).intValue() == 1) goto L32;
        this.f.b = false;
        DoubleRematchType r14 = DoubleRematchType.Guest;
    L33:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r2.c = r14;
        View r15 = getContext().getCommonService().c(this.f.c);
        if (r15 != null) goto L43;
        IRoomSpecificSceneTypeInfo r3 = this.g.getRoomContext().getCommonRoom().getSceneTypeInfo();
        if (r3 != null) goto L38;
    L40:
        boolean r4 = false;
    L41:
        if (r4 == false) goto L44;
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).b(IRevBroadcastService.class);
        Intrinsics.checkNotNull(r17);
        ((com.bytedance.live.kmp.core.c) r17).Ng();
    L44:
        DoubleRematchType r18 = this.f.c;
        DoubleRematchType r19 = DoubleRematchType.None;
        if (r18 == r19) goto L47;
        boolean r20 = true;
    L48:
        gt1.d r22 = gt1.e.a(1, Boolean.valueOf(r20), false, false, false, false, 0, false, false, null, 2044);
        getContext().getLinkDataSet().Y1().setValue(r22);
        Intrinsics.checkNotNullParameter(this, "$this$roomDataCenter");
        getContext().getRoomDataCenterService().S1(r22);
        getContext().getLinkDataSet().Pc().setValue(Unit.INSTANCE);
        if (this.f.c == r19) goto L51;
        boolean r110 = true;
    L52:
        gt1.d r23 = gt1.e.a(3, r15, false, r110, false, false, 0, false, false, null, 1996);
        getContext().getLinkDataSet().Y1().setValue(r23);
        getContext().getRoomDataCenterService().S1(r23);
        getContext().getLinkDataSet().ke().setValue(0);
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "updateRoomState onPKLinkEnd with " + r23, null, 4);
    L53:
        this.a.clear();
        return;
    L51:
        r110 = false;
        goto L52
    L47:
        r20 = false;
        goto L48
    L38:
        if (r3.isLandscapeVerticalRoom() != 1) goto L40;
        r4 = true;
        goto L41
    L43:
        getContext().E4().c();
        goto L44
    L26:
        if (r13.b == false) goto L32;
        r14 = DoubleRematchType.Anchor;
        goto L33
    L22:
        r12 = false;
    L32:
        r14 = DoubleRematchType.None;
        goto L33
    L11:
        r6 = 0;
        goto L12
    L5:
        if (r1 != 7) goto L53;
        qr2.d r24 = new qr2.d();
        r24.f = 2;
        getContext().getRoomDataCenterService().Xf(r24);
        getContext().getLinkDataSet().ho().setValue(r24);
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "updateRoomState onMultiLinkEnd with " + r24, null, 4);
        goto L53
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().hh(), new AnonymousClass1(this)), this.a);
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revlink.link.biz.service.i.t(this).m(new AnonymousClass2(this)), this.a);
        PublishSubject<Integer> r0 = getContext().a9();
        final AnonymousClass3 r1 = new AnonymousClass3(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribe(new a(r1)), this.a);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.revlink.impl.utils.e0] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    public final void a(f31.f r5) {
        Intrinsics.checkNotNullParameter(this, "$this$windowDiffCheckUtil");
        ?? r0 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).w6();
        if (r5 == null) goto L10;
        List<f31.k> r6 = r5.a;
        if (r6 == null) goto L10;
        List<f31.k> r7 = r6;
        ?? r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L11;
        r1.add(new com.bytedance.android.live.revlink.link.biz.audiencecomponent.b((f31.k) r8.next()));
    L11:
        r0.a(r1);
        return;
    L10:
        r1 = CollectionsKt.emptyList();
        goto L11
    }

    public RoomStateDispatchAnchorComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, com.bytedance.android.live.revenuelink.rtc.i r3, AnchorUILayoutManager r4, h r5, com.bytedance.android.livesdk.revenue.service.room.c r6, PkBaseDataContext r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rtcManager");
        Intrinsics.checkNotNullParameter(r4, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r5, "bizDataContext");
        Intrinsics.checkNotNullParameter(r6, "roomService");
        Intrinsics.checkNotNullParameter(r7, "pkBaseDataContext");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.a = new CompositeDisposable();
        this.b = "RoomStateDispatchAnchorComponent";
    }
}
