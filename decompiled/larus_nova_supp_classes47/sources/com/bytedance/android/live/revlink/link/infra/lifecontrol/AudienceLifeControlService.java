package com.bytedance.android.live.revlink.link.infra.lifecontrol;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.w;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revlink.impl.control.launchcontext.RevLinkSwitchExtraContext;
import com.bytedance.android.live.revlink.impl.control.q;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.service.d;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkAudienceOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkControlContext;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.biz.service.k;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.bridge.f1;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.DataContext;
import cy0.e;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import mz0.m;
import mz0.n;
import org.json.JSONObject;
import yz0.f;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AudienceLifeControlService implements o, k, d {
    public static final /* synthetic */ int j = 0;
    public final CompositeDisposable a;
    public final PKLongBizHandler b;
    public boolean c;
    public final c d;
    public final f e;
    public final com.bytedance.android.livesdk.revenue.service.message.d f;
    public final ld.a g;
    public final com.bytedance.android.live.revlink.impl.global.c h;
    public final com.bytedance.android.livesdk.revenue.service.gift.a i;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.infra.lifecontrol.AudienceLifeControlService$onStart$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/i6;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/i6;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<i6, Unit> {
        public AnonymousClass2(AudienceLifeControlService r8) {
            super(1, r8, AudienceLifeControlService.class, "onLinkerMessage", "onLinkerMessage(Lcom/bytedance/android/livesdk/link/model/ILinkerMessage;)V", 0);
        }

        public final void invoke(i6 r12) {
            Intrinsics.checkNotNullParameter(r12, "p1");
            AudienceLifeControlService r0 = (AudienceLifeControlService) ((CallableReference) this).receiver;
            int r1 = AudienceLifeControlService.j;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r12, "$this$sceneExt");
            if (((int) r12.getScene()) != 7) goto L24;
            Intrinsics.checkNotNullParameter(r12, "$this$typeExt");
            if (((int) r12.getType2()) != 6) goto L25;
            Integer r3 = null;
            if (i.I(r0).d() == true) goto L12;
            jy0.b.f("ttlive_anchor_link", "audience loadMultiAnchorLinkWidget by enter message", null, 4);
        L12:
            if (i.I(r0).d() == true) goto L14;
            i.F(r0).d(MultiEnterRoomTracer.MultiLoadSource.LinkerEnter);
        L14:
            StringBuilder r2 = new StringBuilder("loadRevLinkAudienceWidget from onLinkerMessage, channelId=");
            Intrinsics.checkNotNullParameter(r12, "$this$linkerIdExt");
            r2.append(r12.getLinkerId());
            jy0.b.d("AudienceLifeControlManager", r2.toString());
            com.bytedance.android.live.revlink.impl.service.internal.a r4 = i.p(r0);
            if (r4 == null) goto L17;
            int r5 = RevLinkSwitchExtraContext.g;
            Intrinsics.checkNotNullParameter(r12, "$this$linkerIdExt");
            r4.Gp(64, RevLinkSwitchExtraContext.Companion.b(7, r12.getLinkerId(), com.bytedance.android.live.revlink.impl.audience.c.a.b, "", j6.b(r12)));
        L17:
            f1 r13 = r12.getEnter();
            if (r13 == null) goto L22;
            List r14 = r13.getLinkUsers();
            if (r14 == null) goto L22;
            r3 = Integer.valueOf(r14.size());
        L22:
            LinkedHashMap r15 = new LinkedHashMap();
            r15.put("connection_type", "anchor");
            r15.put("anchor_connect_status", String.valueOf(r3));
            n r6 = new n();
            Map<String, String> r7 = r6.a;
            Intrinsics.checkNotNullParameter(r7, "map");
            Intrinsics.checkNotNullParameter(r15, "map");
            r7.putAll(r15);
            m r16 = new m();
            i.m(r0).m(r16);
            r16.b(LogCommon.ROOM);
            List<Object> r8 = r6.b;
            ArrayList r9 = (ArrayList) r8;
            r9.addAll(r16.a);
            e.a.getClass();
            j r17 = e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r18);
            ((mz0.i) ((f80.a) r18)).w3("livesdk_connection_transform", r6.a, r6.b);
            return;
        L25:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((i6) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.infra.lifecontrol.AudienceLifeControlService$onStart$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/r0;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/bridge/r0;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<r0, Unit> {
        public AnonymousClass3(AudienceLifeControlService r8) {
            super(1, r8, AudienceLifeControlService.class, "onBattleMessage", "onBattleMessage(Lcom/bytedance/android/livesdk/link/model/bridge/ILinkMicBattleMessageBridge;)V", 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void invoke(r0 r29) {
            Intrinsics.checkNotNullParameter(r29, "p1");
            AudienceLifeControlService r2 = (AudienceLifeControlService) ((CallableReference) this).receiver;
            int r3 = AudienceLifeControlService.j;
            r2.getClass();
            c5 r0 = r29.castTo(c5.class);
            com.bytedance.android.live.revlink.impl.service.internal.a r4 = i.p(r2);
            if (r4 == null) goto L5;
            int r5 = r4.getCurrentMode();
        L6:
            boolean r6 = com.bytedance.android.live.utils.c.a(r5, 4);
            boolean r7 = com.bytedance.android.live.utils.c.a(r5, 64);
            LiveFullLinkPKMonitor r14 = i.s(r2);
            r14.getClass();
            Intrinsics.checkNotNullParameter(r0, Constants.OperatorKey.MSG);
            d51.c r15 = d51.c.A0;
            r15.getClass();
            ReadOnlyProperty r8 = d51.c.Q;
            KProperty[] r16 = d51.c.a;
            if (((Boolean) r8.getValue(r15, r16[41])).booleanValue() == false) goto L21;
            u1 r9 = r0.getBattleSetting();
            if (r9 != null) goto L12;
        L15:
            String r10 = "";
            int r12 = 0;
        L16:
            u1 r13 = r0.getBattleSetting();
            if (r13 != null) goto L19;
        L25:
            String r20 = r10;
            int r19 = r12;
        L26:
            JSONObject r17 = new JSONObject();
            int r18 = y50.b.a;
            y50.b.a.d(r17, "business_api_name", "live_pk_battle_message_illegal");
            u1 r22 = r0.getBattleSetting();
            if (r22 == null) goto L29;
            String r23 = af2.d.e(r22);
        L30:
            y50.b.a.d(r17, "battle_setting", r23);
            y50.b.a.d(r17, "msg_id", String.valueOf(qj.a(r0)));
            y50.b.a.d(r17, "isInPkMode", String.valueOf(r6));
            y50.b.a.d(r17, "isInMultiMode", String.valueOf(r7));
            Throwable r24 = null;
            boolean r27 = true;
            LiveFullLinkPKMonitor.u(r14, "live_pk_battle_message_illegal", r17, r19, r20, null, 16);
            com.bytedance.android.live.revlink.impl.global.c r25 = r14.o;
            if (r25 == null) goto L33;
            d31.f r110 = r25.y2();
        L34:
            if (r110 == null) goto L36;
            d31.f.f(r110, "live_pk_battle_message_illegal", r19, r20, 0, 0, null, null, null, 248);
        L36:
            if (r6 == true) goto L61;
            if (r7 == false) goto L40;
            return;
        L40:
            if (((Boolean) d51.c.S.getValue(r15, r16[43])).booleanValue() == false) goto L53;
            u1 r26 = r0.getBattleSetting();
            if (r26 == null) goto L53;
            Intrinsics.checkNotNullParameter(r26, "$this$isBattleTypeDoublePk");
            if (r26.getBattleType() == 0) goto L47;
            r27 = false;
        L47:
            if (r27 == true) goto L53;
            StringBuilder r28 = new StringBuilder("receive multi pk battle in live ");
            u1 r1 = r0.getBattleSetting();
            if (r1 == null) goto L51;
            String r111 = af2.d.e(r1);
        L52:
            r28.append(r111);
            jy0.b.c("AudienceLifeControlManager", r28.toString(), r24, 4);
            return;
        L51:
            r111 = r24;
        L53:
            u1 r30 = r0.getBattleSetting();
            if (r30 == null) goto L56;
            long r32 = r30.getChannelId();
        L57:
            long r33 = r32;
            jy0.b.d("AudienceLifeControlManager", "loadRevLinkAudienceWidget from battleMsg, channelId=" + r33);
            com.bytedance.android.live.revlink.impl.service.internal.a r34 = i.p(r2);
            if (r34 == null) goto L63;
            int r35 = RevLinkSwitchExtraContext.g;
            r34.Gp(4, RevLinkSwitchExtraContext.Companion.b(1, r33, com.bytedance.android.live.revlink.impl.audience.c.a.b, null, null));
            return;
        L63:
            return;
        L56:
            r32 = 0;
            goto L57
        L61:
            return;
        L33:
            r110 = null;
            goto L34
        L29:
            r23 = null;
            goto L30
        L19:
            if (r13.getBattleType() != 1) goto L25;
            if (r7 == true) goto L21;
            if (r6 == false) goto L24;
            r20 = "receive_multi_pk_in_double_pk";
            r19 = 2;
            goto L26
        L24:
            r20 = "receive_multi_pk_in_live";
            r19 = 3;
            goto L26
        L12:
            if (r9.getBattleType() != 0) goto L15;
            if (r7 == false) goto L21;
            r10 = "receive_double_pk_in_multi_link";
            r12 = 1;
        L21:
            r24 = null;
            r27 = true;
            goto L36
        L5:
            r5 = 0;
            goto L6
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((r0) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.d, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void finishMultiAnchor(int r1, Function0<Unit> r2, boolean r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter("ceiling_view_leave", "reqSrc");
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.d
    public final i11.b getLinkUserCenter() {
        i11.b r0 = this.h.c8();
        if (r0 != null) goto L6;
        int r1 = AnchorLinkUserCenterV2.u;
        jy0.b.c("ttlive_anchor_link_users_v2", "create empty AnchorLinkUserCenter", null, 4);
        return new AnchorLinkUserCenterV2(null, null, null, null);
    L6:
        return r0;
    }

    public final void onStart() {
        IRoomBase r0 = (IRoom) this.d.getRoomContext().getCommonRoom();
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.e(this.g.Sh(), false, new AnonymousClass1(this)), this.a);
        a(r0, false);
        f r1 = this.e;
        com.bytedance.android.live.revenue.common.message.a r2 = com.bytedance.android.live.revenue.common.message.a.g;
        Observable r3 = h.a.a(r1, CommonMessageTypeKt.a(r2), false, 6);
        final AnonymousClass2 r4 = new AnonymousClass2(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r3.subscribe(new b(r4)), this.a);
        Observable r5 = h.a.a(this.e, CommonMessageTypeKt.b(r2), false, 6);
        final AnonymousClass3 r6 = new AnonymousClass3(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r5.subscribe(new b(r6)), this.a);
        this.i.syncMultiAnchorList();
        this.b.a();
        Pair r7 = com.bytedance.live.datacontext.d.a(new AudienceLifeControlService$shareMultiAudienceService$1(this));
        ((MultiLinkControlContext) r7.getFirst()).getService().d(this);
        DataContext r8 = (DataContext) r7.getFirst();
        Intrinsics.checkNotNullParameter(MultiLinkControlContext.Companion, "$this$TAG");
        com.bytedance.android.live.revlink.impl.global.d.a(r8, "MultiLinkControlContext", this.h);
        MultiLinkControlContext r9 = (MultiLinkControlContext) r7.getFirst();
        if (r0 == null) goto L5;
        long r10 = IRoomKtKt.getId(r0);
    L6:
        r9.sharedWithRoomId(r10);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r7.getSecond(), this.a);
        return;
    L5:
        r10 = 0;
        goto L6
    }

    public final void onStop() {
        this.a.clear();
        PKLongBizHandler r0 = this.b;
        if (r0 == null) goto L6;
        r0.a.clear();
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.h;
    }

    public final void a(IRoom r17, boolean r18) {
        StringBuilder r1 = new StringBuilder("syncRoomState with linkerMap: ");
        if (r17 == null) goto L7;
        Map r3 = IRoomKt_androidKt.getLinkMapKt(r17);
        if (r3 == null) goto L7;
        Map r4 = MapsKt.toMap(r3);
    L8:
        r1.append(r4);
        jy0.b.c("AudienceLifeControlManager", r1.toString(), null, 4);
        if (r17 == null) goto L66;
        Intrinsics.checkNotNullParameter(r17, "$this$getMergeInfo");
        Long r2 = (Long) IRoomKt_androidKt.getLinkMapKt(r17).get(String.valueOf(7));
        if (r2 != null) goto L13;
        r2 = (Long) IRoomKt_androidKt.getLinkMapKt(r17).get(String.valueOf(1));
    L13:
        if (r2 == null) goto L19;
        long r8 = r2.longValue();
        if (IRoomKt_androidKt.getLinkMapKt(r17).containsKey(String.valueOf(7)) == false) goto L17;
        int r0 = 7;
    L18:
        q r9 = new q(r8, r0);
    L20:
        if (r9 == null) goto L68;
        final long r5 = r9.a;
        com.bytedance.android.live.revlink.impl.service.internal.a r10 = i.p(this);
        boolean r15 = false;
        if (r10 == null) goto L25;
        int r12 = r10.getCurrentMode();
    L27:
        if (r18 == true) goto L29;
    L32:
        i.F(this).d(MultiEnterRoomTracer.MultiLoadSource.RoomEnter);
    L33:
        int r13 = r9.b;
        if (r13 == 1) goto L39;
        if (r13 == 7) goto L38;
        jy0.b.c("AudienceLifeControlManager", "oooooooops expect scene", null, 4);
        return;
    L38:
        final int r6 = 64;
    L40:
        jy0.b.d("AudienceLifeControlManager", "loadRevLinkAudienceWidget, channelId=" + r5 + ", scene=" + r9.b);
        if (this.c == true) goto L54;
        Intrinsics.checkNotNullParameter(this, "$this$anchorLinkAudienceOptUtils");
        AnchorLinkAudienceOptUtils r7 = i.getContext(this).a3();
        if (((Boolean) r7.a.getValue()).booleanValue() == true) goto L45;
    L47:
        boolean r14 = false;
    L48:
        if (r14 != true) goto L54;
        if (r5 <= 0) goto L54;
        this.c = true;
        Intrinsics.checkNotNullParameter(this, "$this$mLinkUserCenter");
        i11.b r16 = i.getContext(this).c8();
        if (r16 == null) goto L54;
        r16.k(7, 4, "enter_room_preload", r5);
        goto L54
    L45:
        if (((r11.a) r7.b.getValue()).q5() == false) goto L47;
        r14 = true;
    L54:
        Intrinsics.checkNotNullParameter(this, "$this$anchorLinkAudienceOptUtils");
        if (((r11.a) i.getContext(this).a3().b.getValue()).v4() == false) goto L59;
        int r19 = w.a;
        if (v.a() == false) goto L59;
        r15 = true;
    L59:
        if (r15 != true) goto L62;
        final q r20 = r9;
        p0.a(400, false, false, new AudienceLifeControlService$syncRoomState$1(this, r6, r20, r5), 6);
        return;
    L62:
        com.bytedance.android.live.revlink.impl.service.internal.a r22 = i.p(this);
        if (r22 == null) goto L67;
        int r23 = RevLinkSwitchExtraContext.g;
        r22.Gp(r6, RevLinkSwitchExtraContext.Companion.b(r9.b, r5, com.bytedance.android.live.revlink.impl.audience.c.b.b, null, null));
        return;
    L67:
        return;
    L39:
        r6 = 4;
        goto L40
    L29:
        if (com.bytedance.android.live.utils.c.a(r12, 64) == true) goto L33;
        if (com.bytedance.android.live.utils.c.a(r12, 4) == true) goto L33;
    L25:
        r12 = 0;
        goto L27
    L68:
        return;
    L17:
        r0 = 1;
        goto L18
    L19:
        r9 = null;
        goto L20
    L66:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public AudienceLifeControlService(c r2, f r3, com.bytedance.android.livesdk.revenue.service.message.d r4, ld.a r5, com.bytedance.android.live.revlink.impl.global.c r6, com.bytedance.android.livesdk.revenue.service.gift.a r7) {
        Intrinsics.checkNotNullParameter(r2, "revRoomService");
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r4, "messageManagerService");
        Intrinsics.checkNotNullParameter(r5, "linkDataSet");
        Intrinsics.checkNotNullParameter(r6, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r7, "giftCompactService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.a = new CompositeDisposable();
        this.b = new PKLongBizHandler(false, r3, r4, r2);
    }
}
