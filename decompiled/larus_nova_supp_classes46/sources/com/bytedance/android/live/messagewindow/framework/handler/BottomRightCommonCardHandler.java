package com.bytedance.android.live.messagewindow.framework.handler;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.messagewindow.business.card.BottomRightCommonCard;
import com.bytedance.android.live.messagewindow.business.presenter.CommonCardServiceWidgetPresenter;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import com.bytedance.android.livesdk.config.ny0;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.android.livesdk.message.model.u1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import m71.e;
import org.json.JSONObject;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class BottomRightCommonCardHandler extends com.bytedance.android.live.messagewindow.framework.handler.a<m1> {
    public final String b;
    public Map<Integer, m1> c;
    public Disposable d;
    public final WeakReference<Context> e;
    public final DataCenter f;
    public final q71.a g;
    public final CommonCardServiceWidgetPresenter h;
    public final y61.a i;
    public final Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> j;

    public static final class a implements g71.a {
        public final /* synthetic */ BottomRightCommonCardHandler a;

        public a(BottomRightCommonCardHandler r1) {
            this.a = r1;
        }

        public final void a(Integer r2) {
            this.a.f(r2);
        }
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void g() {
        super.g();
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void h() {
        super.h();
        y61.a r0 = this.i;
        if (r0 == null) goto L9;
        Map<Integer, m1> r1 = r0.getBottomRightCardData();
        if (r1 == null) goto L9;
        if ((!r1.isEmpty()) == false) goto L9;
        this.c = r1;
    L9:
        y61.a r2 = this.i;
        if (r2 == null) goto L12;
        r2.setBottomRightCardData(this.c);
    L12:
        int r3 = e.a;
        if (((n71.a) m71.b.a.getValue()).d() == true) goto L26;
        y61.a r4 = this.i;
        if (r4 == null) goto L21;
        Map r5 = r4.getCardMapV2();
        if (r5 == null) goto L21;
        Map<Integer, Pair<v61.a, g71.b>> r6 = (Map) r5.get(MsgWindowPosition.BOTTOM_RIGHT);
        if (r6 == null) goto L21;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.a = r6;
    L21:
        y61.a r7 = this.i;
        if (r7 == null) goto L50;
        Map r8 = r7.getCardMapV2();
        if (r8 == null) goto L51;
        Map r9 = (Map) r8.put(MsgWindowPosition.BOTTOM_RIGHT, this.a);
        return;
    L51:
        return;
    L50:
        return;
    L26:
        y61.a r10 = this.i;
        String r11 = null;
        if (r10 == null) goto L39;
        Map r12 = r10.getCardMapV3();
        if (r12 == null) goto L39;
        DataCenter r13 = this.f;
        if (r13 == null) goto L35;
        IRoom r14 = a0.n(r13);
        if (r14 == null) goto L35;
        String r15 = r14.getIdStr();
    L36:
        Map<Integer, Pair<v61.a, g71.b>> r16 = (Map) r12.get(new w61.b(r15, MsgWindowPosition.BOTTOM_RIGHT));
        if (r16 == null) goto L39;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        this.a = r16;
    L35:
        r15 = null;
    L39:
        y61.a r17 = this.i;
        if (r17 == null) goto L53;
        Map r18 = r17.getCardMapV3();
        if (r18 == null) goto L54;
        DataCenter r19 = this.f;
        if (r19 == null) goto L48;
        IRoom r20 = a0.n(r19);
        if (r20 == null) goto L48;
        r11 = r20.getIdStr();
    L48:
        Map r21 = (Map) r18.put(new w61.b(r11, MsgWindowPosition.BOTTOM_RIGHT), this.a);
        return;
    L54:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final String c() {
        return this.b;
    }

    public final y61.a getCommonCardContext() {
        return this.i;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public WeakReference<Context> getContext() {
        return this.e;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void a(final z61.a r5) {
        Intrinsics.checkNotNullParameter(r5, "commonCardEvent");
        super.a(r5);
        Map<Integer, m1> r0 = this.c;
        if (r0 == null) goto L5;
        m1 r1 = r0.get(Integer.valueOf(r5.b.getType()));
    L6:
        if (r1 == null) goto L20;
        Pair<v61.a, g71.b> r2 = this.a.get(Integer.valueOf(r5.b.getType()));
        if (r2 == null) goto L20;
        v61.a r3 = (v61.a) r2.getFirst();
        if (r3 == null) goto L20;
        if (this.j.get(r3) != null) goto L20;
        this.j.put(r3, r5.b);
        y61.a r4 = this.i;
        if (r4 == null) goto L20;
        final CompositeDisposable r6 = r4.registerCardCallback(r3, r5.b.getType(), r5);
        if (r6 == null) goto L20;
        if (((Boolean) ny0.a.getValue()).booleanValue() == false) goto L20;
        r5.b.a = new BottomRightCommonCardHandler$combineTypeCardRefresh$$inlined$let$lambda$1(r6, this, r5);
    L20:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r7 = r5.b;
        if (r7 != null) goto L23;
    L33:
        f(Integer.valueOf(r5.b.getType()));
        return;
    L23:
        if (r7.g == null) goto L33;
        Pair<v61.a, g71.b> r8 = this.a.get(Integer.valueOf(r7.getType()));
        if (r8 == null) goto L33;
        v61.a r9 = (v61.a) r8.getFirst();
        if (r9 == null) goto L33;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r10 = r5.b;
        if (r10 == null) goto L31;
        String r11 = r10.g;
    L32:
        r9.e(null, r11);
        goto L33
    L31:
        r11 = null;
        goto L32
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void b(m1 r3) {
        m1 r4 = r3;
        super.b(r4);
        Integer r5 = r4.type;
        if (r5 == null) goto L25;
        int r6 = r5.intValue();
        Pair<v61.a, g71.b> r0 = this.a.get(Integer.valueOf(r6));
        if (r0 == null) goto L9;
        g71.b r1 = (g71.b) r0.getSecond();
        if (r1 == null) goto L9;
        r1.reset();
    L9:
        Pair<v61.a, g71.b> r2 = this.a.get(Integer.valueOf(r6));
        if (r2 == null) goto L14;
        v61.a r7 = (v61.a) r2.getFirst();
        if (r7 == null) goto L14;
        r7.dismiss();
    L14:
        this.a.remove(Integer.valueOf(r6));
        this.c.remove(Integer.valueOf(r6));
        Pair<v61.a, g71.b> r8 = this.a.get(Integer.valueOf(r6));
        if (r8 == null) goto L26;
        v61.a r9 = (v61.a) r8.getFirst();
        if (r9 != null) goto L19;
        return;
    L19:
        if (e.b() == false) goto L23;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r10 = this.j.get(r9);
        if (r10 == null) goto L23;
        r10.a();
    L23:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r11 = this.j.remove(r9);
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void i(h r6) {
        m1 r7 = (m1) r6;
        super.i(r7);
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L6;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d(this.b);
        r1.c("recreateCard");
        r1.a("cardData", r7.toString());
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
    L6:
        Pair<v61.a, g71.b> r3 = this.a.get(r7.type);
        if (r3 == null) goto L11;
        v61.a r4 = (v61.a) r3.getFirst();
        if (r4 == null) goto L11;
        r4.dismiss();
    L11:
        if (r3 == null) goto L15;
        g71.b r5 = (g71.b) r3.getSecond();
        if (r5 == null) goto L15;
        r5.reset();
    L15:
        Disposable r8 = null;
        if (r3 == null) goto L36;
        v61.a r9 = (v61.a) r3.getFirst();
        if (r9 == null) goto L36;
        ICardLifecycle.State r10 = r9.A();
        if (r10 == null) goto L36;
        if (r10.isAtMost(ICardLifecycle.State.Showed) != true) goto L36;
        i r11 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r11 == null) goto L27;
        CardAlogParamsBuilder r12 = new CardAlogParamsBuilder();
        r12.d(this.b);
        r12.c("cardDelayedToDisplay");
        Unit r13 = Unit.INSTANCE;
        r11.d(r12.b());
    L27:
        Disposable r14 = this.d;
        if (r14 == null) goto L30;
        r14.dispose();
    L30:
        v61.a r15 = (v61.a) r3.getFirst();
        if (r15 == null) goto L35;
        Observable r16 = r15.v();
        if (r16 == null) goto L35;
        r8 = r16.subscribe(new b(this, r7, r3), new c(this));
    L35:
        this.d = r8;
        return;
    L36:
        if (r3 == null) goto L38;
        r8 = (v61.a) r3.getFirst();
    L38:
        k(r7, r8);
    }

    public final void l(m1 r4) {
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L6;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d(this.b);
        r1.c("hideCard");
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
    L6:
        Integer r5 = r4.type;
        if (r5 == null) goto L14;
        int r6 = r5.intValue();
        Pair<v61.a, g71.b> r7 = this.a.get(Integer.valueOf(r6));
        if (r7 == null) goto L15;
        v61.a r8 = (v61.a) r7.getFirst();
        if (r8 == null) goto L16;
        r8.hide();
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void e(m1 r5, CommonCardInitScene r6) {
        m1 r7 = r5;
        Intrinsics.checkNotNullParameter(r6, "initScene");
        super.e(r7, r6);
        if (r7 == null) goto L50;
        Map<Integer, m1> r0 = this.c;
        if (r0 == null) goto L12;
        Integer r1 = r7.type;
        if (r1 == null) goto L10;
        int r2 = r1.intValue();
    L11:
        m1 r3 = r0.put(Integer.valueOf(r2), r7);
        goto L12
    L10:
        r2 = 0;
    L12:
        Pair<v61.a, g71.b> r4 = this.a.get(r7.type);
        if (r4 == null) goto L38;
        v61.a r8 = (v61.a) r4.getFirst();
        if (r8 == null) goto L38;
        ICardLifecycle.State r9 = r8.A();
        if (r9 == null) goto L38;
        if (r9.isShowOrHide() != true) goto L38;
        if (this.h != null) goto L45;
    L33:
        Pair<v61.a, g71.b> r10 = this.a.get(r7.type);
        if (r10 == null) goto L47;
        v61.a r11 = (v61.a) r10.getFirst();
        if (r11 == null) goto L48;
        r11.e(r7, null);
        return;
    L48:
        return;
    L47:
        return;
    L45:
        l71.c r12 = k.n(IMsgWindowProxyService.class).getExternalBrowserService();     // Catch: Exception -> L31
        if (r12 == null) goto L33;
        u1 r13 = r7.cardDisplayInfo;     // Catch: Exception -> L31
        if (r13 == null) goto L28;
        String r14 = r13.containerPayload;     // Catch: Exception -> L31
        if (r14 == null) goto L28;
    L29:
        r12.enqueueEvent("update_bottom_right_card", new JSONObject(r14));     // Catch: Exception -> L31
    L28:
        r14 = "";
    L31:
        e = move-exception;
        SafetyGuard.a(null, null, e.getMessage());
    L38:
        Pair<v61.a, g71.b> r15 = this.a.get(r7.type);
        if (r15 == null) goto L43;
        g71.b r16 = (g71.b) r15.getSecond();
        if (r16 == null) goto L43;
        r16.reset();
    L43:
        m(r7, r6);
        return;
    }

    public final void k(m1 r2, v61.a r3) {
        if (e.b() == true) goto L6;
        if (r3 == null) goto L6;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r4 = this.j.remove(r3);
    L6:
        if (r2 == null) goto L16;
        Map<Integer, m1> r5 = this.c;
        if (r5 == null) goto L14;
        Integer r0 = r2.type;
        if (r0 == null) goto L12;
        int r1 = r0.intValue();
    L13:
        m1 r6 = r5.put(Integer.valueOf(r1), r2);
        goto L14
    L12:
        r1 = 0;
    L14:
        m(r2, CommonCardInitScene.ROOM_MSG);
        return;
    }

    public final void m(final m1 r17, final CommonCardInitScene r18) {
        Intrinsics.checkNotNullParameter(r18, "initScene");
        d(r17, r18);
        if (r17 != null) goto L5;
        return;
    L5:
        Integer r0 = r17.type;
        if (r0 == null) goto L48;
        int r12 = r0.intValue();
        gm0.b r13 = new gm0.b(r17, this.f);
        a r1 = new a(this);
        Intrinsics.checkNotNullParameter(r1, "showCardCallback");
        r13.b = r1;
        Context r5 = getContext().get();
        if (r5 == null) goto L46;
        Map<Integer, Pair<v61.a, g71.b>> r14 = this.a;
        Integer r15 = Integer.valueOf(r12);
        DataCenter r2 = this.f;
        Integer r3 = r17.priority;
        if (r3 == null) goto L12;
        int r4 = r3.intValue();
    L13:
        BottomRightCommonCard r6 = new BottomRightCommonCard(r17, r2, r12, r4, r5, r18);
        Integer r7 = r17.mockType;
        boolean r8 = true;
        if (r7 != null) goto L17;
    L19:
        boolean r9 = false;
    L20:
        if (r9 == true) goto L23;
        r8 = false;
    L23:
        ((v61.a) r6).f = r8;
        v61.d r10 = ((v61.a) r6).g;
        if (r10 == null) goto L30;
        Boolean r11 = r17.isPreloadingNeeded;
        if (r11 == null) goto L28;
        boolean r16 = r11.booleanValue();
    L29:
        r10.a = r16;
        goto L30
    L28:
        r16 = false;
    L30:
        Unit r19 = Unit.INSTANCE;
        r14.put(r15, TuplesKt.to(r6, r13));
        if (e.b() == false) goto L46;
        Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r20 = this.j;
        if (r20 == null) goto L46;
        Pair<v61.a, g71.b> r21 = this.a.get(Integer.valueOf(r12));
        if (r21 == null) goto L37;
        v61.a r22 = (v61.a) r21.getFirst();
    L38:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r23 = r20.get(r22);
        if (r23 == null) goto L41;
        r23.a();
    L41:
        Pair<v61.a, g71.b> r24 = this.a.get(Integer.valueOf(r12));
        if (r24 == null) goto L44;
        v61.a r25 = (v61.a) r24.getFirst();
    L45:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r26 = (com.bytedance.android.live.room.api.messagewindow.builder.card.b) TypeIntrinsics.asMutableMap(r20).remove(r25);
        goto L46
    L44:
        r25 = null;
        goto L45
    L37:
        r22 = null;
        goto L38
    L17:
        if (r7.intValue() != 1) goto L19;
        r9 = true;
        goto L20
    L12:
        r4 = 0;
    L46:
        r13.c();
    L48:
        if (Intrinsics.areEqual(r17.isPreloadingNeeded, Boolean.TRUE) == false) goto L95;
        final Integer r110 = r17.type;
        final BottomRightCommonCardHandler$cardPreLoading$1 r111 = BottomRightCommonCardHandler$cardPreLoading$1.INSTANCE;
        Uri r27 = mm0.c.c(r17);
        if (r27 == null) goto L105;
        WeakReference<Context> r28 = getContext();
        if (r28 == null) goto L64;
        Context r29 = r28.get();
        if (r29 == null) goto L64;
        if (this.h == null) goto L64;
        Integer r30 = r17.type;
        u1 r31 = r17.cardDisplayInfo;
        if (r31 == null) goto L62;
        Integer r32 = r31.width;
        if (r32 == null) goto L62;
        int r33 = r32.intValue();
    L63:
        int r34 = UtilityKotlinExtentionsKt.i(r33);
        Intrinsics.checkNotNullParameter(r29, "context");
        Intrinsics.checkNotNullParameter(r27, "uri");
        Intrinsics.checkNotNullParameter(r111, "failCallBack");
        HybridCard r112 = k.n(IBaseBrowserService.class).getHybridCard(r29, r27, r34, new com.bytedance.android.live.messagewindow.business.presenter.d(r30, System.currentTimeMillis(), r111));
    L65:
        if (r112 == null) goto L106;
        y61.a r113 = this.i;
        if (r113 == null) goto L71;
        final HybridCard r35 = r112;
        Pair r36 = r113.providePreLoadedJsMethod(new BottomRightCommonCardHandler$cardPreLoading$$inlined$let$lambda$1(r35, this, r17, r111, r110, r18));
        if (r36 == null) goto L71;
        r112.registerMethod((String) r36.getFirst(), (g) r36.getSecond());
    L71:
        y61.a r37 = this.i;
        if (r37 == null) goto L76;
        Pair r38 = r37.provideShowJsMethod(new BottomRightCommonCardHandler$cardPreLoading$$inlined$let$lambda$2(this, r17, r111, r110, r18));
        if (r38 == null) goto L76;
        r112.registerMethod((String) r38.getFirst(), (g) r38.getSecond());
    L76:
        y61.a r39 = this.i;
        if (r39 == null) goto L81;
        Pair r40 = r39.provideWRDSJsMethod();
        if (r40 == null) goto L81;
        r112.registerMethod((String) r40.getFirst(), (f.b) r40.getSecond());
    L81:
        y61.a r41 = this.i;
        if (r41 == null) goto L90;
        Pair<v61.a, g71.b> r42 = this.a.get(r110);
        if (r42 == null) goto L88;
        v61.a r43 = (v61.a) r42.getFirst();
        if (r43 == null) goto L88;
        Observable r44 = r43.w();
    L89:
        r41.registerJsEvent(r112, r44);
    L88:
        r44 = null;
    L90:
        y61.a r45 = this.i;
        if (r45 == null) goto L93;
        Map r46 = r45.generateCardData(r17, r18);
    L94:
        r112.load(null, r46);
        return;
    L93:
        r46 = null;
        goto L94
    L106:
        return;
    L62:
        r33 = 112;
    L64:
        r112 = null;
        goto L65
    L105:
        return;
    L95:
        q71.a r47 = this.g;
        if (r47 == null) goto L108;
        q71.d r48 = q71.a.a.a(r47, r17.combineType);
        if (r48 == null) goto L109;
        int r49 = r71.f.d;
        Integer r50 = r17.type;
        if (r50 == null) goto L102;
        int r114 = r50.intValue();
    L103:
        r48.b(r71.f.a.a(r114, CardDataState.SHOW, r18));
        return;
    L102:
        r114 = 0;
        goto L103
    L109:
        return;
    }

    public BottomRightCommonCardHandler(WeakReference<Context> r2, DataCenter r3, q71.a r4, CommonCardServiceWidgetPresenter r5, y61.a r6, Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r7, "cardLifecycleMap");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.b = "BottomRightCommonCardHandler";
        this.c = new LinkedHashMap();
    }
}
