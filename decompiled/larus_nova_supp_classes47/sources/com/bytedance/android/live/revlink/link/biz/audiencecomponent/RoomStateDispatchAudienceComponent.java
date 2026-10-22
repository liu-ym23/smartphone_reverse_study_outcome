package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import android.graphics.RectF;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.impl.multianchor.service.RevLinkLayoutPreloadContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import f31.k;
import f31.l;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RoomStateDispatchAudienceComponent implements com.bytedance.android.live.revlink.link.biz.service.d {
    public final CompositeDisposable a;
    public final String b;
    public f31.f c;
    public boolean d;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b e;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.RoomStateDispatchAudienceComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lf31/f;", "p1", "", "invoke", "(Lf31/f;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<f31.f, Unit> {
        public AnonymousClass1(RoomStateDispatchAudienceComponent r8) {
            super(1, r8, RoomStateDispatchAudienceComponent.class, "onLayoutStatusChange", "onLayoutStatusChange(Lcom/bytedance/android/live/revlink/impl/multianchor/model/LayoutStatus;)V", 0);
        }

        public final void invoke(f31.f r19) {
            final RoomStateDispatchAudienceComponent r2 = (RoomStateDispatchAudienceComponent) ((CallableReference) this).receiver;
            if (r19 != null) goto L5;
            r2.getClass();
            return;
        L5:
            p0 r4 = null;
            if (j.a(r2.getContext()) == true) goto L8;
            f31.f r3 = r2.c;
            if (r3 == null) goto L75;
            Intrinsics.checkNotNullParameter(r3, "$this$isSameVisible");
            RectF r5 = r3.b;
            RectF r6 = r19.b;
            if (r5.left == r6.left) goto L66;
        L72:
            boolean r7 = false;
        L73:
            if (r7 != true) goto L75;
            return;
        L66:
            if (r5.top != r6.top) goto L72;
            if (r5.right != r6.right) goto L72;
            if (r5.bottom != r6.bottom) goto L72;
            r7 = true;
        L75:
            MultiEnterRoomTracer r8 = i.F(r2);
            r8.getClass();
            z41.e.d.getClass();
            a51.d r9 = z41.e.c;
            if (r9.e9() == false) goto L86;
            com.bytedance.android.live.revlink.impl.multianchor.service.f.a.getClass();
            RevLinkLayoutPreloadContext r10 = RevLinkLayoutPreloadContext.Companion.getContext(null);
            if (r10 == null) goto L82;
            com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.f> r12 = r10.getService();
            if (r12 == null) goto L82;
            com.bytedance.android.live.revlink.impl.multianchor.service.f r13 = (com.bytedance.android.live.revlink.impl.multianchor.service.f) r12.getValue();
        L83:
            if (r13 == null) goto L85;
            Integer r14 = Integer.valueOf(r13.a());
        L87:
            boolean r15 = r9.G3();
            i97.a r16 = i97.a.a;
            r8.n = System.currentTimeMillis();
            jy0.b.f("MultiEnterRoomTracer", "windowManagerStart source=" + r8.a + " cacheWindowCnt=" + r14 + " simplify=" + r15, null, 4);
            r8.l = 0;
            r8.m = 0;
            if (r14 == null) goto L90;
            int r17 = r14.intValue();
        L91:
            if (r17 > 0) goto L93;
        L96:
            r2.c = r19;
            RectF r18 = r19.b;
            List<k> r20 = r19.a;
            if (r20 == null) goto L99;
            int r22 = r20.size();
        L100:
            final qr2.d r23 = new qr2.d();
            r23.k = r22;
            r23.f = 1;
            r23.b = true;
            r23.c = com.bytedance.android.live.revenue.common.i.b(16);
            r23.d = true;
            r23.e = com.bytedance.android.live.revenue.common.i.b(16);
            r23.g = ((int) r18.top) + com.bytedance.android.live.revenue.common.i.b(16);
            int r110 = (int) (r18.top + r18.height());
            if (l.b(r19) == false) goto L103;
            int r24 = 0;
        L104:
            r23.h = r110 + r24;
            r23.i = (int) r18.left;
            o51.f r25 = r19.e;
            r23.p = r25.b;
            if ((r25 instanceof o51.f.b) == false) goto L107;
        L109:
            String r26 = com.bytedance.android.live.revlink.link.biz.service.e.a.a(r2);
            StringBuilder r27 = new StringBuilder();
            o51.e r111 = (o51.e) r2.getContext().getUiLayout().getValue();
            if (r111 == null) goto L112;
            String r112 = o51.g.a(r111);
        L113:
            r27.append(r112);
            r27.append(", ");
            r27.append(r19.a);
            jy0.b.c(r26, r27.toString(), null, 4);
            List<k> r28 = r19.a;
            if (r28 != null) goto L116;
        L154:
            int r29 = 0;
        L155:
            r23.q = r29;
            r23.r = l.b(r19);
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r2), "updateRoomState with " + r23, null, 4);
            com.bytedance.android.live.revenue.common.p0.a(0, false, true, new RoomStateDispatchAudienceComponent$onClassicMultiLayoutStatusChange$1(r2, r23), 3);
            MultiEnterRoomTracer r30 = i.F(r2);
            List<k> r1 = r19.a;
            if (r1 == null) goto L158;
            int r32 = r1.size();
        L159:
            r30.getClass();
            i97.a r33 = i97.a.a;
            r30.o = System.currentTimeMillis();
            jy0.b.f("MultiEnterRoomTracer", "windowManagerDone cost " + (r30.o - r30.n) + "ms window=" + r32 + " viewCache=" + r30.A, null, 4);
            r30.g();
            return;
        L158:
            r32 = 0;
            goto L159
        L116:
            if (r28.isEmpty() == true) goto L154;
            ArrayList r34 = new ArrayList();
            Iterator<T> r35 = r28.iterator();
        L120:
            if (r35.hasNext() == false) goto L140;
            Object r113 = r35.next();
            k r114 = (k) r113;
            String r115 = r114.a;
            if (r115 != null) goto L124;
        L127:
            boolean r116 = true;
        L128:
            if (r116 == true) goto L136;
            String r117 = r114.a;
            o51.e r118 = (o51.e) r2.getContext().getUiLayout().getValue();
            if (r118 == null) goto L132;
            String r119 = o51.g.a(r118);
        L134:
            if ((!Intrinsics.areEqual(r117, r119)) == false) goto L136;
            boolean r120 = true;
        L137:
            if (r120 == false) goto L120;
            r34.add(r113);
            goto L120
        L132:
            r119 = null;
        L136:
            r120 = false;
            goto L137
        L124:
            if (StringsKt.isBlank(r115) == true) goto L127;
            r116 = false;
            goto L128
        L140:
            if (r34.isEmpty() == true) goto L154;
            ArrayList r36 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10));
            Iterator r37 = r34.iterator();
        L144:
            if (r37.hasNext() == false) goto L147;
            r36.add(Integer.valueOf(((k) r37.next()).c));
            goto L144
        L147:
            if (r34.size() <= 5) goto L152;
            Integer r38 = (Integer) CollectionsKt.maxOrNull(r36);
            if (r38 == null) goto L151;
            int r39 = r38.intValue();
        L153:
            b03.a r40 = b03.a.a;
            r29 = (s1.y() - r39) + com.bytedance.android.live.revenue.common.i.b(24);
            goto L155
        L151:
            r39 = 0;
            goto L153
        L152:
            r39 = ((Number) CollectionsKt.first(r36)).intValue();
            goto L153
        L112:
            r112 = null;
            goto L113
        L107:
            if (r25.a() == true) goto L109;
        L103:
            r24 = com.bytedance.android.live.revenue.common.i.b(16);
            goto L104
        L99:
            r22 = 0;
            goto L100
        L93:
            if (r8.a != MultiEnterRoomTracer.MultiLoadSource.RoomEnter) goto L96;
            r8.A = Boolean.TRUE;
            goto L96
        L90:
            r17 = 0;
            goto L91
        L85:
            r14 = null;
        L82:
            r13 = null;
            goto L83
        L86:
            r14 = -1;
            goto L87
        L8:
            if (Intrinsics.areEqual((Boolean) r2.getContext().getLinkDataSet().cn().getValue(), Boolean.TRUE) == false) goto L12;
            com.bytedance.android.live.revlink.impl.settings.live.c r42 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
            r42.getClass();
            if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.B.getValue(r42, com.bytedance.android.live.revlink.impl.settings.live.c.a[26])).booleanValue() == false) goto L12;
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r2), "block sei update for audience self join", null, 4);
            return;
        L12:
            RevSeiFrame r43 = (RevSeiFrame) r2.getContext().lb().getValue();
            if (r43 == null) goto L15;
            r4 = r43.b();
        L15:
            b03.a r44 = b03.a.a;
            if (PadConfigUtils.a() == true) goto L22;
            if (l.b(r19) == true) goto L22;
            int r45 = (int) (r19.b.bottom + com.bytedance.android.live.revenue.common.i.b(48));
        L37:
            Integer r46 = Integer.valueOf(r45);
            Integer r47 = Integer.valueOf(r45);
            if (r47 == null) goto L40;
            int r121 = r47.intValue();
        L41:
            if (r4 == null) goto L43;
            int r48 = r4.getGameType();
        L44:
            if (r48 == 0) goto L46;
            boolean r122 = true;
        L48:
            if (l.b(r19) == false) goto L52;
            d51.c r49 = d51.c.A0;
            r49.getClass();
            if (((Boolean) d51.c.n0.getValue(r49, d51.c.a[64])).booleanValue() == false) goto L52;
            boolean r123 = true;
        L53:
            final gt1.d r50 = gt1.e.a(0, r46, false, false, false, false, r121, r122, r123, null, 1148);
            if (r2.d == true) goto L56;
        L60:
            com.bytedance.android.live.revenue.common.p0.a(0, false, true, new RoomStateDispatchAudienceComponent$onClassicDoubleLayoutStatusChange$1(r2, r50), 3);
            r2.getContext().getRoomDataCenterService().Mm();
            return;
        L56:
            if (l.b(r19) == false) goto L60;
            d51.c r52 = d51.c.A0;
            r52.getClass();
            if (((Boolean) d51.c.n0.getValue(r52, d51.c.a[64])).booleanValue() == false) goto L60;
            return;
        L52:
            r123 = false;
            goto L53
        L46:
            r122 = false;
            goto L48
        L43:
            r48 = 0;
            goto L44
        L40:
            r121 = 0;
        L22:
            if (PadConfigUtils.a() == false) goto L30;
            if (r4 == null) goto L25;
            int r53 = r4.getGameType();
        L26:
            if (r53 == 0) goto L30;
            if (b03.a.c() == false) goto L30;
            r45 = Math.max(s1.y(), s1.w()) - com.bytedance.android.live.revenue.common.i.b(190);
            goto L37
        L25:
            r53 = 0;
        L30:
            if (r4 == null) goto L32;
            int r54 = r4.d();
        L34:
            if (r54 == 0) goto L36;
            r45 = (s1.w() * 2) / 3;
            goto L37
        L36:
            r45 = ((int) r19.b.bottom) + com.bytedance.android.live.revenue.common.i.b(2);
            goto L37
        L32:
            r54 = 0;
            goto L34
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((f31.f) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.d = true;
        gt1.d r0 = gt1.e.a(1, null, false, false, false, false, 0, false, false, null, 2046);
        getContext().getLinkDataSet().Y1().setValue(r0);
        getContext().getRoomDataCenterService().S1(r0);
        qr2.d r1 = new qr2.d();
        r1.f = 2;
        getContext().getRoomDataCenterService().Xf(r1);
        getContext().getLinkDataSet().ho().setValue(r1);
        this.a.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().hh(), new AnonymousClass1(this)), this.a);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
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

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b getContext() {
        return this.e;
    }

    public RoomStateDispatchAudienceComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.e = r2;
        this.a = new CompositeDisposable();
        this.b = "MultiRoomStateDispatchAudienceComponent";
    }
}
