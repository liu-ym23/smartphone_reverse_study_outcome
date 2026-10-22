package com.bytedance.android.live.messagewindow.business.widget;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.messagewindow.business.presenter.CommonCardServiceWidgetPresenter;
import com.bytedance.android.live.messagewindow.framework.context.CommonCardContext;
import com.bytedance.android.live.messagewindow.framework.handler.BottomRightCommonCardHandler;
import com.bytedance.android.live.messagewindow.framework.handler.TopRightCommonCardHandler;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.c;
import com.bytedance.android.live.room.api.messagewindow.monitor.d;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.state.CardAction;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.config.ny0;
import com.bytedance.android.livesdk.message.model.b7;
import com.bytedance.android.livesdk.message.model.e3;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import g71.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m71.e;
import r71.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/messagewindow/business/widget/CommonCardServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/live/messagewindow/business/presenter/CommonCardServiceWidgetPresenter$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lz61/a;", "commonCardEvent", "", "onEvent", "<init>", "()V", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonCardServiceWidget extends MiddlewareRoomRecyclableWidget implements CommonCardServiceWidgetPresenter.b, Observer<KVData> {
    public Map<Integer, m1> a;
    public Map<Integer, i3> b;
    public Map<Integer, Pair<v61.a, b>> c;
    public TopRightCommonCardHandler d;
    public BottomRightCommonCardHandler e;
    public CommonCardServiceWidgetPresenter f;
    public Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> g;

    public static final class a {
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        CommonCardServiceWidgetPresenter r0 = this.f;
        if (r0 == null) goto L5;
        r0.detachView();
    L5:
        i r1 = d.a();
        if (r1 == null) goto L9;
        CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
        r2.d("PortraitCommonCardServiceWidget");
        r2.c("onUnload");
        Unit r3 = Unit.INSTANCE;
        r1.d(r2.b());
    L9:
        Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r4 = this.g;
        if (r4 == null) goto L16;
        Iterator<Map.Entry<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b>> r5 = r4.entrySet().iterator();
    L13:
        if (r5.hasNext() == false) goto L16;
        this.g.put(r5.next().getKey(), null);
    L16:
        if (((Boolean) ny0.a.getValue()).booleanValue() == false) goto L31;
        Map<Integer, m1> r6 = this.a;
        if (r6 == null) goto L31;
        Iterator<Map.Entry<Integer, m1>> r7 = r6.entrySet().iterator();
    L21:
        if (r7.hasNext() == false) goto L31;
        Map.Entry<Integer, m1> r8 = r7.next();
        q71.a r9 = xq();
        if (r9 == null) goto L21;
        m1 r10 = r8.getValue();
        if (r10 == null) goto L27;
        e3 r11 = r10.combineType;
    L28:
        q71.d r12 = q71.a.a.a(r9, r11);
        if (r12 == null) goto L21;
        r12.b(null);
        goto L21
    L27:
        r11 = null;
    L31:
        ((Widget) this).dataCenter.removeObserver(this);
        TopRightCommonCardHandler r13 = this.d;
        if (r13 == null) goto L34;
        r13.g();
    L34:
        BottomRightCommonCardHandler r14 = this.e;
        if (r14 == null) goto L46;
        r14.g();
        return;
    }

    public final q71.a xq() {
        return k.n(IMsgWindowService.class).cardStateDispatcher(((Widget) this).dataCenter);
    }

    public final y61.a yq() {
        CommonCardContext.b r0 = CommonCardContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        return CommonCardContext.b.b(r1);
    }

    public CommonCardServiceWidget() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.g = new LinkedHashMap();
    }

    public static boolean wq(Integer r4) {
        int r0 = e.a;
        if (r4 == null) goto L5;
        int r1 = r4.intValue();
    L6:
        boolean r2 = e.c(r1);
        i r3 = d.a();
        if (r3 == null) goto L18;
        c r5 = new c("livesdk_common_card_setting_result");
        if (r4 == null) goto L12;
        int r6 = r4.intValue();
    L13:
        r5.b("type", Integer.valueOf(r6));
        if (r2 == false) goto L16;
        String r7 = "0";
    L17:
        r5.b("result", r7);
        Unit r8 = Unit.INSTANCE;
        r3.b(r5.a());
        goto L18
    L16:
        r7 = "1";
        goto L17
    L12:
        r6 = -1;
    L18:
        return r2;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.CommonCardServiceWidgetPresenter.b
    public final void Up(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        i r0 = d.a();
        if (r0 == null) goto L7;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d("PortraitCommonCardServiceWidget");
        r1.c("getCommonCardDataInfoFailure");
        r1.a("msg", String.valueOf(r4.getMessage()));
        Unit r5 = Unit.INSTANCE;
        r0.d(r1.b());
        return;
    }

    public final void onChanged(Object r8) {
        KVData r9 = (KVData) r8;
        if (r9 == null) goto L5;
        String r0 = r9.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == (-392573918)) goto L12;
        return;
    L12:
        if (r0.equals("common_card_status_changed") == false) goto L27;
        Long r2 = (Long) r9.getData(0L);
        if (r2 != null) goto L17;
    L18:
        Long r10 = (Long) r9.getData(0L);
        if (r10 != null) goto L22;
        return;
    L22:
        if (r10.longValue() != 0) goto L28;
    L23:
        CommonCardServiceWidgetPresenter r11 = this.f;
        if (r11 == null) goto L29;
        r11.e0();
        return;
    L29:
        return;
    L28:
        return;
    L17:
        if (r2.longValue() == 1) goto L23;
    L27:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.CommonCardServiceWidgetPresenter.b
    public void onEvent(z61.a r5) {
        Intrinsics.checkNotNullParameter(r5, "commonCardEvent");
        CardAction r0 = r5.a;
        int r1 = com.bytedance.android.live.messagewindow.business.widget.a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        TopRightCommonCardHandler r2 = this.d;
        if (r2 == null) goto L44;
        r2.a(r5);
    L44:
        BottomRightCommonCardHandler r3 = this.e;
        if (r3 == null) goto L57;
        r3.a(r5);
        return;
    L57:
        return;
    L5:
        if (r1 != 2) goto L7;
        Map<Integer, m1> r4 = this.a;
        if (r4 == null) goto L53;
        m1 r6 = r4.get(Integer.valueOf(r5.b.getType()));
        if (r6 == null) goto L54;
        BottomRightCommonCardHandler r7 = this.e;
        if (r7 == null) goto L55;
        r7.l(r6);
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L7:
        if (r1 != 3) goto L9;
        Map<Integer, m1> r8 = this.a;
        if (r8 == null) goto L27;
        m1 r9 = r8.get(Integer.valueOf(r5.b.getType()));
        if (r9 == null) goto L27;
        BottomRightCommonCardHandler r10 = this.e;
        if (r10 == null) goto L27;
        r10.b(r9);
    L27:
        Map<Integer, i3> r11 = this.b;
        if (r11 == null) goto L49;
        i3 r12 = r11.get(Integer.valueOf(r5.b.getType()));
        if (r12 == null) goto L50;
        TopRightCommonCardHandler r13 = this.d;
        if (r13 == null) goto L51;
        r13.b(r12);
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L9:
        if (r1 != 4) goto L58;
        Integer r14 = Integer.valueOf(r5.b.getType());
        Pair<v61.a, b> r15 = this.c.get(r14);
        if (r15 == null) goto L16;
        v61.a r16 = (v61.a) r15.getFirst();
        if (r16 == null) goto L16;
        r16.dismiss();
    L16:
        i r17 = d.a();
        if (r17 == null) goto L59;
        c r18 = new c("livesdk_common_card_destroy");
        r18.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        r18.b("type", r14);
        r18.b("reason", "4");
        Unit r19 = Unit.INSTANCE;
        r17.b(r18.a());
        return;
    L59:
        return;
    }

    public final void onLoad(Object[] r23) {
        long r1 = System.currentTimeMillis();
        DataCenter r4 = ((Widget) this).dataCenter;
        CommonCardServiceWidgetPresenter r3 = new CommonCardServiceWidgetPresenter(r4, z51.a.h(r4, 2));
        ((q46.b) r3).a = this;
        Unit r5 = Unit.INSTANCE;
        this.f = r3;
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L5;
        r6.put("live_enter_room_complete_time", Long.valueOf(r1));
    L5:
        o r2 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r2 == null) goto L14;
        m r7 = r2.getRoom();
        if (r7 == null) goto L14;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L14;
        IRoomAuthStatus r9 = r8.getRoomAuthStatus();
        if (r9 == null) goto L14;
        long r10 = r9.getCommonCard();
    L15:
        i r11 = d.a();
        boolean r12 = false;
        if (r11 == null) goto L25;
        CardAlogParamsBuilder r13 = new CardAlogParamsBuilder();
        r13.d("PortraitCommonCardServiceWidget");
        r13.c("onLoad");
        r13.a("showCommonCard", Long.valueOf(r10));
        y61.a r14 = yq();
        if (r14 != null) goto L21;
    L23:
        boolean r15 = false;
    L24:
        r13.a("commonCardContext init status", Boolean.valueOf(r15));
        r11.d(r13.b());
        goto L25
    L21:
        if (r14.getHasInitialized() != true) goto L23;
        r15 = true;
    L25:
        i r16 = d.a();
        if (r16 == null) goto L32;
        c r17 = new c("livesdk_common_card_status");
        if (r10 == 2) goto L31;
        r12 = true;
    L31:
        r17.b("status", Boolean.valueOf(r12));
        r16.b(r17.a());
    L32:
        ((Widget) this).dataCenter.observe("common_card_status_changed", this);
        if (e.d() == false) goto L39;
        TopRightCommonCardHandler r18 = new TopRightCommonCardHandler(new WeakReference(((Widget) this).context), ((Widget) this).dataCenter, xq(), yq(), this.g);
        r18.h();
        this.d = r18;
        BottomRightCommonCardHandler r19 = new BottomRightCommonCardHandler(new WeakReference(((Widget) this).context), ((Widget) this).dataCenter, xq(), this.f, yq(), this.g);
        r19.h();
        this.e = r19;
        i r20 = d.a();
        if (r20 == null) goto L39;
        CardAlogParamsBuilder r21 = new CardAlogParamsBuilder();
        r21.d("PortraitCommonCardServiceWidget");
        r21.c("initCommonCardHandler");
        r20.d(r21.b());
    L39:
        y61.a r22 = yq();
        if (r22 != null) goto L42;
    L62:
        y61.a r24 = yq();
        if (r24 == null) goto L65;
        r24.setHasInitialized(true);
    L65:
        y61.a r25 = yq();
        if (r25 == null) goto L68;
        r25.setBottomRightCardData(this.a);
    L68:
        y61.a r26 = yq();
        if (r26 == null) goto L71;
        r26.setTopRightCardData(this.b);
    L71:
        y61.a r27 = yq();
        if (r27 == null) goto L74;
        r27.setCardMap(this.c);
    L74:
        y61.a r28 = yq();
        if (r28 == null) goto L78;
        r28.setCardLifecycleMap(this.g);
    L78:
        if (r10 == 2) goto L80;
    L82:
        CommonCardServiceWidgetPresenter r29 = this.f;
        if (r29 == null) goto L85;
        r29.d0();
    L85:
        Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r30 = this.g;
        if (r30 == null) goto L110;
        Iterator<Map.Entry<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b>> r31 = r30.entrySet().iterator();
    L89:
        if (r31.hasNext() == false) goto L110;
        Map.Entry<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r32 = r31.next();
        Map<Integer, m1> r33 = this.a;
        if (r33 == null) goto L89;
        Iterator<Map.Entry<Integer, m1>> r34 = r33.entrySet().iterator();
    L94:
        if (r34.hasNext() == false) goto L89;
        Map.Entry<Integer, m1> r35 = r34.next();
        Object r36 = r32.getKey().j;
        if (r36 == null) goto L94;
        String r37 = r36.toString();
        if (r37 == null) goto L94;
        if (CastIntegerProtector.parseInt(r37) != r35.getKey().intValue()) goto L94;
        q71.a r38 = xq();
        if (r38 == null) goto L94;
        m1 r39 = r35.getValue();
        if (r39 == null) goto L106;
        e3 r40 = r39.combineType;
    L107:
        q71.d r41 = q71.a.a.a(r38, r40);
        if (r41 == null) goto L94;
        int r42 = f.d;
        r41.b(f.a.a(r35.getKey().intValue(), CardDataState.INIT, CommonCardInitScene.RELOAD));
        goto L94
    L106:
        r40 = null;
    L110:
        CommonCardServiceWidgetPresenter r43 = this.f;
        if (r43 == null) goto L131;
        r43.e0();
        return;
    L131:
        return;
    L80:
        if (((n71.a) m71.b.a.getValue()).k() == false) goto L82;
        return;
    L42:
        if (r22.getHasInitialized() != true) goto L62;
        y61.a r44 = yq();
        if (r44 == null) goto L46;
        Map<Integer, m1> r45 = r44.getBottomRightCardData();
    L47:
        this.a = r45;
        y61.a r46 = yq();
        if (r46 == null) goto L50;
        Map<Integer, i3> r47 = r46.getTopRightCardData();
    L51:
        this.b = r47;
        y61.a r48 = yq();
        if (r48 == null) goto L55;
        Map<Integer, Pair<v61.a, b>> r49 = r48.getCardMap();
        if (r49 == null) goto L55;
    L56:
        this.c = r49;
        y61.a r50 = yq();
        if (r50 == null) goto L60;
        Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r51 = r50.getCardLifecycleMap();
        if (r51 == null) goto L60;
    L61:
        this.g = r51;
    L60:
        r51 = new LinkedHashMap();
    L55:
        r49 = new LinkedHashMap();
        goto L56
    L50:
        r47 = null;
        goto L51
    L46:
        r45 = null;
    L14:
        r10 = 0;
        goto L15
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.CommonCardServiceWidgetPresenter.b
    public final void r80(f71.c.a r9) {
        if (r9 == null) goto L41;
        List r2 = r9.bottomRightCardArea;
        if (r2 == null) goto L41;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L28;
        Object r5 = r4.next();
        m1 r6 = (m1) r5;
        boolean r7 = true;
        if (v.a() == true) goto L19;
        Integer r8 = r6.mockType;
        if (r8 != null) goto L15;
    L17:
        boolean r10 = false;
    L18:
        if (r10 == false) goto L19;
    L25:
        r7 = false;
    L26:
        if (r7 == false) goto L8;
        r3.add(r5);
        goto L8
    L15:
        if (r8.intValue() != 1) goto L17;
        r10 = true;
    L19:
        if (r6 == null) goto L21;
        Integer r11 = r6.type;
    L23:
        if (wq(r11) == false) goto L25;
    L21:
        r11 = null;
        goto L23
    L28:
        Iterator r12 = r3.iterator();
    L30:
        if (r12.hasNext() == false) goto L41;
        m1 r13 = (m1) r12.next();
        Map<Integer, m1> r14 = this.a;
        if (r14 == null) goto L38;
        Integer r15 = r13.type;
        if (r15 == null) goto L36;
        int r16 = r15.intValue();
    L37:
        m1 r17 = r14.put(Integer.valueOf(r16), r13);
        goto L38
    L36:
        r16 = 0;
    L38:
        BottomRightCommonCardHandler r18 = this.e;
        if (r18 == null) goto L30;
        r18.e(r13, CommonCardInitScene.ROOM_ENTER);
    L41:
        if (r9 == null) goto L69;
        List r19 = r9.commonCardArea;
        if (r19 == null) goto L69;
        Iterator r20 = r19.iterator();
    L46:
        if (r20.hasNext() == false) goto L69;
        i3 r21 = (i3) r20.next();
        if (r21 == null) goto L50;
        Integer r22 = r21.type;
    L52:
        if (wq(r22) == false) goto L53;
        Integer r23 = r21.domain;
        if (r23 == null) goto L46;
        if (r23.intValue() != 3) goto L46;
        Map<Integer, i3> r24 = this.b;
        if (r24 == null) goto L66;
        Integer r25 = r21.type;
        if (r25 == null) goto L64;
        int r26 = r25.intValue();
    L65:
        i3 r27 = r24.put(Integer.valueOf(r26), r21);
        goto L66
    L64:
        r26 = 0;
    L66:
        TopRightCommonCardHandler r28 = this.d;
        if (r28 == null) goto L46;
        r28.e(r21, CommonCardInitScene.ROOM_ENTER);
        goto L46
    L53:
        return;
    L50:
        r22 = null;
    L69:
        i r29 = d.a();
        if (r29 == null) goto L94;
        CardAlogParamsBuilder r0 = new CardAlogParamsBuilder();
        r0.d("PortraitCommonCardServiceWidget");
        r0.c("getCommonCardDataInfoSuccess");
        r0.a("bottomRightCardData", String.valueOf(this.a));
        r0.a("topRightCardData", String.valueOf(this.b));
        Unit r1 = Unit.INSTANCE;
        r29.d(r0.b());
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.CommonCardServiceWidgetPresenter.b
    public final void rj(f71.a r5) {
        Intrinsics.checkNotNullParameter(r5, "cardChangeParams");
        i r0 = d.a();
        if (r0 == null) goto L6;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d("PortraitCommonCardServiceWidget");
        r1.c("notifyCardDataChange");
        r1.a("actionType", String.valueOf(r5.a));
        r1.a("bottomRightCardData", String.valueOf(r5.b.getBottomRightCardData()));
        r1.a("commonCardData", String.valueOf(r5.b.getCommonCard()));
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
    L6:
        m1 r3 = r5.b.getBottomRightCardData();
        if (r3 == null) goto L10;
        Integer r4 = r3.type;
        if (r4 == null) goto L10;
    L15:
        if (wq(r4) == true) goto L17;
        return;
    L17:
        int r6 = r5.a;
        if (r6 != 1) goto L20;
        b7 r7 = r5.b;
        int r8 = 0;
        if (r7 == null) goto L80;
        i3 r9 = r7.getCommonCard();
        if (r9 == null) goto L80;
        Integer r10 = r9.domain;
        if (r10 == null) goto L80;
        if (r10.intValue() != 3) goto L80;
        Map<Integer, i3> r11 = this.b;
        if (r11 == null) goto L77;
        Integer r12 = r9.type;
        if (r12 == null) goto L75;
        int r13 = r12.intValue();
    L76:
        i3 r14 = r11.put(Integer.valueOf(r13), r9);
        goto L77
    L75:
        r13 = 0;
    L77:
        TopRightCommonCardHandler r15 = this.d;
        if (r15 == null) goto L80;
        r15.e(r9, CommonCardInitScene.ROOM_MSG);
    L80:
        b7 r16 = r5.b;
        if (r16 == null) goto L102;
        m1 r17 = r16.getBottomRightCardData();
        if (r17 == null) goto L103;
        Map<Integer, m1> r18 = this.a;
        if (r18 == null) goto L90;
        Integer r19 = r17.type;
        if (r19 == null) goto L89;
        r8 = r19.intValue();
    L89:
        m1 r20 = r18.put(Integer.valueOf(r8), r17);
    L90:
        BottomRightCommonCardHandler r21 = this.e;
        if (r21 == null) goto L104;
        r21.e(r17, CommonCardInitScene.ROOM_MSG);
        return;
    L104:
        return;
    L103:
        return;
    L102:
        return;
    L20:
        if (r6 == 2) goto L42;
        if (r6 != 3) goto L105;
        b7 r22 = r5.b;
        if (r22 == null) goto L35;
        h r23 = r22.getCommonCard();
        if (r23 == null) goto L35;
        Integer r24 = ((i3) r23).domain;
        if (r24 == null) goto L35;
        if (r24.intValue() != 3) goto L35;
        TopRightCommonCardHandler r25 = this.d;
        if (r25 == null) goto L35;
        r25.i(r23);
    L35:
        b7 r26 = r5.b;
        if (r26 == null) goto L94;
        h r27 = r26.getBottomRightCardData();
        if (r27 == null) goto L95;
        BottomRightCommonCardHandler r28 = this.e;
        if (r28 == null) goto L96;
        r28.i(r27);
        return;
    L96:
        return;
    L95:
        return;
    L94:
        return;
    L105:
        return;
    L42:
        b7 r29 = r5.b;
        if (r29 == null) goto L54;
        i3 r30 = r29.getCommonCard();
        if (r30 == null) goto L54;
        Integer r31 = r30.domain;
        if (r31 == null) goto L54;
        if (r31.intValue() != 3) goto L54;
        TopRightCommonCardHandler r32 = this.d;
        if (r32 == null) goto L54;
        r32.b(r30);
    L54:
        b7 r33 = r5.b;
        if (r33 == null) goto L98;
        m1 r34 = r33.getBottomRightCardData();
        if (r34 == null) goto L99;
        BottomRightCommonCardHandler r35 = this.e;
        if (r35 == null) goto L100;
        r35.b(r34);
        return;
    L100:
        return;
    L99:
        return;
    L98:
        return;
    L10:
        i3 r36 = r5.b.getCommonCard();
        if (r36 == null) goto L13;
        r4 = r36.type;
        goto L15
    L13:
        r4 = null;
        goto L15
    }
}
