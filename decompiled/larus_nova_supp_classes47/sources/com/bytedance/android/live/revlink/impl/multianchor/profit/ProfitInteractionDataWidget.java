package com.bytedance.android.live.revlink.impl.multianchor.profit;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revlink.impl.kmpwidget.KmpStatelessLiveWidget;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.b8;
import com.bytedance.android.livesdk.link.model.bridge.f2;
import com.bytedance.android.livesdk.link.model.c8;
import com.bytedance.android.livesdk.link.model.d8;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/profit/ProfitInteractionDataWidget;", "Lcom/bytedance/android/live/revlink/impl/kmpwidget/KmpStatelessLiveWidget;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ProfitInteractionDataWidget extends KmpStatelessLiveWidget {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public boolean b;
    public final CompositeDisposable c;
    public ProfitInteractionDataContext d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ProfitInteractionDataWidget a;

        public b(ProfitInteractionDataWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            sh6.b r5 = (sh6.b) r4;
            zg1.d r0 = (zg1.d) sh6.c.b(r5);
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.b == false) goto L8;
        L10:
            boolean r1 = false;
        L11:
            if (r1 == false) goto L20;
            ProfitInteractionDataWidget r2 = this.a;
            if (r2.b == false) goto L21;
            jy0.b.f(r2.a, "anchorLinkMicFinish, clear link score data " + r5, null, 4);
            ProfitInteractionDataContext r6 = this.a.d;
            if (r6 == null) goto L22;
            n<c8> r7 = r6.getCurrentMessage();
            if (r7 == null) goto L23;
            r7.setValue(null);
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        L20:
            return;
        L8:
            if (r0.c == true) goto L10;
            r1 = true;
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataWidget$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(ProfitInteractionDataWidget r8) {
            super(1, r8, ProfitInteractionDataWidget.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r20) {
            Intrinsics.checkNotNullParameter(r20, "p1");
            ProfitInteractionDataWidget r2 = (ProfitInteractionDataWidget) ((CallableReference) this).receiver;
            int r3 = ProfitInteractionDataWidget.e;
            r2.getClass();
            if ((r20 instanceof f2) == false) goto L135;
            c8 r0 = ((vh7.c) r20).castTo(c8.class);
            ProfitInteractionDataContext r4 = r2.d;
            Map r5 = null;
            if (r4 != null) goto L8;
        L21:
            jy0.b.d(r2.a, "update data " + r0);
            ProfitInteractionDataContext r6 = r2.d;
            if (r6 == null) goto L26;
            n<c8> r7 = r6.getCurrentMessage();
            if (r7 == null) goto L26;
            r7.setValue(r0);
        L26:
            ProfitInteractionDataContext r8 = r2.d;
            if (r8 == null) goto L134;
            com.bytedance.android.live.revlink.impl.global.c r9 = (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class);
            if (r9 == null) goto L31;
            com.bytedance.android.live.revlink.impl.multianchor.profit.a r10 = r9.Qj();
        L32:
            String r12 = "";
            if (r10 == null) goto L59;
            Intrinsics.checkNotNullParameter(r0, "message");
            Intrinsics.checkNotNullParameter(r8, "dataContext");
            if (r10.k() == false) goto L59;
            JSONObject r13 = new JSONObject();
            int r14 = y50.b.a;
            y50.b.a.c(r13, "link_start_time", r0.getLinkStartTime());
            y50.b.a.b(r13, "score_status", r0.getInteractionScoreStatus());
            y50.b.a.b(r13, "score_update_type", r0.getScoreUpdateType());
            String r15 = r0.getExtraJson();
            if (r15 != null) goto L40;
        L43:
            boolean r16 = true;
        L44:
            if (r16 == true) goto L49;
            String r17 = r0.getExtraJson();
            if (r17 != null) goto L48;
            r17 = "";
        L48:
            y50.b.a.d(r13, "extra", r17);
        L49:
            Map r18 = r0.getAnchorInfoMap();
            if (r18 == null) goto L54;
            Map r19 = MapsKt.toMap(r18);
            if (r19 == null) goto L54;
            String r22 = ef2.a.b(r19);
        L55:
            y50.b.a.d(r13, "info_map", r22);
            y50.b.a.c(r13, "msg_channel_id", r0.getChannelId());
            y50.b.a.d(r13, "msg_id", String.valueOf(qj.a(r0)));
            y50.b.a.d(r13, "data_context", r8.getLogString());
            if (r8.currentScoreShowStatus() == r0.getInteractionScoreStatus()) goto L59;
            y50.b.a.d(r13, "score_status_update", r8.currentScoreShowStatus() + "->" + r0.getInteractionScoreStatus());
            y50.b.a.d(r13, "link_timestamp_update", r8.currentLinkTimestamp() + "->" + r0.getLinkStartTime());
            r10.o("anchor_link_score_status_update", r13);
        L54:
            r22 = null;
            goto L55
        L40:
            if (r15.length() == 0) goto L43;
            r16 = false;
        L59:
            if (r8.currentLinkTimestamp() == r0.getLinkStartTime()) goto L71;
            long r23 = r0.getLinkStartTime() - r8.currentLinkTimestamp();
            long r110 = r23 / ((long) WebcastRedirectException.UNKNOWN);
            jy0.b.c(r2.a, "linkStartTimeStamp update, elapseSeconds=" + r110 + "s " + r23 + "ms", null, 4);
            if (r23 < 0) goto L63;
            r8.getLinkStartTimeStamp().setValue(Long.valueOf(r0.getLinkStartTime()));
            goto L71
        L63:
            com.bytedance.android.live.revlink.impl.global.c r24 = (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class);
            if (r24 == null) goto L66;
            com.bytedance.android.live.revlink.impl.multianchor.profit.a r25 = r24.Qj();
        L67:
            if (r25 == null) goto L71;
            String r26 = ef2.a.c(r0);
            Intrinsics.checkNotNullParameter(r26, "messageStr");
            JSONObject r27 = new JSONObject();
            int r28 = y50.b.a;
            y50.b.a.c(r27, "elapse_seconds", r110);
            y50.b.a.d(r27, "message", r26);
            int r29 = v.a;
            v.b("ttlive_anchor_link_profit_monitor", "link_start_time_rollback params=" + r27, null);
            if (r25.k() == false) goto L71;
            r25.o("link_start_time_rollback", r27);
            goto L71
        L66:
            r25 = null;
        L71:
            int r30 = r8.currentScoreShowStatus();
            if (r30 == r0.getInteractionScoreStatus()) goto L117;
            jy0.b.d(r2.a, "scoreShowStatus update " + r30 + "->" + r0.getInteractionScoreStatus());
            r8.getScoreShowStatus().setValue(Integer.valueOf(r0.getInteractionScoreStatus()));
            if (r2.b == false) goto L117;
            com.bytedance.android.live.revlink.impl.global.c r32 = (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class);
            if (r32 == null) goto L78;
            f r33 = r32.getLinkPlayHelper();
        L79:
            if (r33 == null) goto L83;
            int r34 = 1;
            if (r33.c() == true) goto L117;
        L85:
            if (r0.getScoreUpdateType() != r34) goto L117;
            String r35 = d8.a(r0).a;
            if (r35 != null) goto L89;
        L92:
            String r36 = d8.a(r0).b;
            com.bytedance.android.livesdk.revenue.service.room.c r37 = KmpStatelessLiveWidget.yq(com.bytedance.android.livesdk.revenue.service.room.c.class);
            if (r37 == null) goto L97;
            com.bytedance.android.livesdk.revenue.room.a r38 = r37.getRoomContext();
            if (r38 == null) goto L97;
            IRoomBase r39 = r38.getCommonRoom();
        L98:
            IRoom r40 = (IRoom) r39;
            if (r40 == null) goto L103;
            IBaseUser r42 = r40.getOwnerKt();
            if (r42 == null) goto L103;
            String r43 = r42.getIdString();
        L104:
            boolean r44 = !Intrinsics.areEqual(r36, r43);
            if (r44 == true) goto L107;
        L111:
            if (r44 == false) goto L117;
            if (com.bytedance.android.live.revlink.impl.multianchor.profit.c.a(r30) == true) goto L117;
            if (com.bytedance.android.live.revlink.impl.multianchor.profit.c.a(r0.getInteractionScoreStatus()) == false) goto L117;
            int r45 = ToastUtil.a;
            com.bytedance.live.kmp.util.c r46 = com.bytedance.live.kmp.util.c.a;
            int r47 = w11.a.a;
            ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131914784, new Object[]{r12}), 0);
            goto L117
        L107:
            if (com.bytedance.android.live.revlink.impl.multianchor.profit.c.a(r30) == false) goto L111;
            if (com.bytedance.android.live.revlink.impl.multianchor.profit.c.a(r0.getInteractionScoreStatus()) == true) goto L111;
            int r48 = ToastUtil.a;
            com.bytedance.live.kmp.util.c r49 = com.bytedance.live.kmp.util.c.a;
            int r50 = w11.a.a;
            ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131914783, new Object[]{r12}), 0);
        L103:
            r43 = null;
        L97:
            r39 = null;
            goto L98
        L89:
            if (r35.length() > 6) goto L91;
            r12 = r35;
            goto L92
        L91:
            r12 = r35.subSequence(0, 5).toString() + "...";
            goto L92
        L83:
            r34 = 1;
            goto L85
        L78:
            r33 = null;
        L117:
            String r52 = r2.a;
            StringBuilder r53 = new StringBuilder("multiAnchorData update: ");
            Map r54 = r0.getAnchorInfoMap();
            if (r54 == null) goto L125;
            Map r55 = MapsKt.toMap(r54);
            if (r55 == null) goto L125;
            LinkedHashMap r56 = new LinkedHashMap(MapsKt.mapCapacity(r55.size()));
            Iterator r57 = r55.entrySet().iterator();
        L123:
            if (r57.hasNext() == false) goto L126;
            Map.Entry r58 = (Map.Entry) r57.next();
            r56.put(((String) r58.getKey()) + ": " + ((b8) r58.getValue()).getScoreStr(), r58.getValue());
        L126:
            r53.append(r56);
            jy0.b.d(r52, r53.toString());
            n<Map<String, b8>> r59 = r8.getMultiAnchorData();
            Map r1 = r0.getAnchorInfoMap();
            if (r1 == null) goto L129;
            r5 = MapsKt.toMap(r1);
        L129:
            r59.setValue(r5);
            m<String> r60 = r8.getLinkRecordTime();
            i97.a r62 = i97.a.a;
            r60.setValue(String.valueOf((System.currentTimeMillis() - ((Number) r8.getLinkStartTimeStamp().getValue()).longValue()) / ((long) WebcastRedirectException.UNKNOWN)));
            return;
        L125:
            r56 = null;
            goto L126
        L31:
            r10 = null;
            goto L32
        L134:
            return;
        L8:
            if (r4.hasDataInitialized() == true) goto L21;
            jy0.b.f(r2.a, "init interactionDataContext " + r0, null, 4);
            ProfitInteractionDataContext r63 = r2.d;
            if (r63 == null) goto L12;
            r63.initData(r0);
        L12:
            String r64 = r2.a;
            StringBuilder r65 = new StringBuilder("multiAnchorData init: ");
            Map r66 = r0.getAnchorInfoMap();
            if (r66 == null) goto L20;
            Map r67 = MapsKt.toMap(r66);
            if (r67 == null) goto L20;
            r5 = new LinkedHashMap(MapsKt.mapCapacity(r67.size()));
            Iterator r68 = r67.entrySet().iterator();
        L18:
            if (r68.hasNext() == false) goto L20;
            Map.Entry r69 = (Map.Entry) r68.next();
            r5.put(((String) r69.getKey()) + ": " + ((b8) r69.getValue()).getScoreStr(), r69.getValue());
        L20:
            r65.append(r5);
            jy0.b.d(r64, r65.toString());
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void onCreate() {
        v41.b r0 = v41.b.f;
        r0.getClass();
        if (((Boolean) v41.b.d.getValue(r0, v41.b.a[2])).booleanValue() == false) goto L31;
        com.bytedance.android.livesdk.revenue.service.room.c r1 = KmpStatelessLiveWidget.yq(com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r2 = r1.getRoomContext();
    L8:
        if (r2 == null) goto L10;
        Pair r3 = r2.getCommonProfitInteractionDataContext();
    L11:
        if (r3 != null) goto L18;
        Pair r4 = com.bytedance.live.datacontext.d.a(ProfitInteractionDataWidget$onCreate$pair$1.INSTANCE);
        com.bytedance.android.live.revlink.impl.global.d.a((ProfitInteractionDataContext) r4.getFirst(), Reflection.getOrCreateKotlinClass(ProfitInteractionDataContext.class), (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class));
        com.bytedance.android.livesdk.revenue.service.room.c r5 = KmpStatelessLiveWidget.yq(com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r5 == null) goto L15;
        com.bytedance.android.livesdk.revenue.room.a r6 = r5.getRoomContext();
    L16:
        if (r6 == null) goto L18;
        r6.setCommonProfitInteractionDataContext(r4);
        goto L18
    L15:
        r6 = null;
    L18:
        com.bytedance.android.livesdk.revenue.service.room.c r7 = KmpStatelessLiveWidget.yq(com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r7 == null) goto L21;
        com.bytedance.android.livesdk.revenue.room.a r8 = r7.getRoomContext();
    L22:
        if (r8 == null) goto L26;
        Pair r9 = r8.getCommonProfitInteractionDataContext();
        if (r9 == null) goto L26;
        DataContext r10 = (DataContext) r9.getFirst();
    L28:
        if ((r10 instanceof ProfitInteractionDataContext) == true) goto L30;
        r10 = null;
    L30:
        this.d = (ProfitInteractionDataContext) r10;
    L32:
        String r12 = this.a;
        StringBuilder r13 = new StringBuilder("onLoad ");
        ProfitInteractionDataContext r14 = this.d;
        if (r14 == null) goto L35;
        String r15 = r14.getLogString();
    L36:
        r13.append(r15);
        jy0.b.f(r12, r13.toString(), null, 4);
        com.bytedance.android.livesdk.revenue.service.room.c r16 = KmpStatelessLiveWidget.yq(com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r16 == null) goto L41;
        com.bytedance.android.livesdk.revenue.room.a r17 = r16.getRoomContext();
        if (r17 == null) goto L41;
        boolean r18 = r17.getCommonIsAnchor();
    L42:
        this.b = r18;
        yz0.f r19 = (yz0.f) KmpStatelessLiveWidget.zq(yz0.f.class);
        if (r19 == null) goto L49;
        com.bytedance.android.live.revenue.common.message.a r20 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r22 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r20, "$this$PROFIT_INTERACTION_SCORE");
        Observable r23 = h.a.a(r19, (yh6.b) CommonMessageTypeKt.t.getValue(), true, 4);
        if (r23 == null) goto L49;
        final AnonymousClass1 r24 = new AnonymousClass1(this);
        Disposable r25 = r23.subscribe(new c(r24));
        if (r25 == null) goto L49;
        com.bytedance.revenue.platform.api.core.rx.f.a(r25, this.c);
    L49:
        ld.a r26 = ld.d.a();
        if (r26 == null) goto L59;
        NextLiveData r27 = r26.so();
        if (r27 == null) goto L60;
        Observable r28 = ld.c.a(r27);
        if (r28 == null) goto L61;
        Disposable r29 = r28.subscribe(new b(this));
        if (r29 == null) goto L62;
        this.c.add(r29);
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L41:
        r18 = false;
        goto L42
    L35:
        r15 = null;
    L26:
        r10 = null;
        goto L28
    L21:
        r8 = null;
        goto L22
    L10:
        r3 = null;
        goto L11
    L7:
        r2 = null;
        goto L8
    L31:
        Pair r30 = com.bytedance.live.datacontext.d.a(ProfitInteractionDataWidget$onCreate$pair$2.INSTANCE);
        ProfitInteractionDataContext r32 = (ProfitInteractionDataContext) r30.getFirst();
        com.bytedance.android.live.revlink.impl.global.d.a(r32, Reflection.getOrCreateKotlinClass(ProfitInteractionDataContext.class), (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class));
        this.d = r32;
        this.c.add((Disposable) r30.getSecond());
        goto L32
    }

    @Override // com.bytedance.android.live.revlink.scopeui.KmpWidget
    public final void onDestroy() {
        String r0 = this.a;
        StringBuilder r1 = new StringBuilder("onUnload ");
        ProfitInteractionDataContext r2 = this.d;
        if (r2 == null) goto L5;
        String r3 = r2.getLogString();
    L6:
        r1.append(r3);
        jy0.b.f(r0, r1.toString(), null, 4);
        this.c.dispose();
        return;
    L5:
        r3 = null;
        goto L6
    }

    public ProfitInteractionDataWidget() {
        this.a = "ttlive_anchor_profit_interact_data";
        this.c = new CompositeDisposable();
    }
}
