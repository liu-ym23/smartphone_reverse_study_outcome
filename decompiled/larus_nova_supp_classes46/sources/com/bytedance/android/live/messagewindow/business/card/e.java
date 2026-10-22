package com.bytedance.android.live.messagewindow.business.card;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter;
import com.bytedance.android.live.messagewindow.business.presenter.JsEventType;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.q;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdk.message.model.j3;
import com.bytedance.android.livesdkapi.depend.model.live.DslTypeInt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelExtraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.n;
import yt1.o;
import yt1.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends v61.a implements AbsCommonCardPresenter.a {
    public final Lazy A;
    public i3 B;
    public final DataCenter C;
    public final Context D;
    public final CommonCardInitScene E;
    public final MsgWindowPosition m;
    public com.bytedance.android.live.messagewindow.business.presenter.e n;
    public IRoom o;
    public HybridCard p;
    public ViewGroup q;
    public long r;
    public long s;
    public long t;
    public o u;
    public k v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void CA() {
        HybridCard r0 = this.p;
        Integer r1 = null;
        if (r0 == null) goto L13;
        ViewParent r2 = r0.getParent();
        if ((r2 instanceof ViewGroup) == true) goto L7;
        r2 = null;
    L7:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L10;
        r3.removeView(r0);
    L10:
        ViewGroup r4 = this.q;
        if (r4 == null) goto L13;
        r4.addView(r0, new ViewGroup.LayoutParams(-1, -1));
    L13:
        i r5 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r5 == null) goto L17;
        CardAlogParamsBuilder r6 = new CardAlogParamsBuilder();
        r6.d("TopRightCommonCard");
        r6.c("onHybridCardLoadSuccess");
        Unit r7 = Unit.INSTANCE;
        r5.d(r6.b());
    L17:
        i r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r8 == null) goto L25;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r9 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_result");
        r9.b("position", Integer.valueOf(CommonCardConstant.Position.TOP_RIGHT.getValue()));
        i3 r10 = this.B;
        if (r10 == null) goto L23;
        Integer r11 = r10.type;
    L24:
        r9.b("type", r11);
        r9.b("result", Integer.valueOf(CommonCardConstant.Result.SUCCESS.getValue()));
        Unit r12 = Unit.INSTANCE;
        r8.b(r9.a());
        goto L25
    L23:
        r11 = null;
    L25:
        i r13 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r13 == null) goto L33;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r14 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_time_cost");
        r14.b("position", Integer.valueOf(CommonCardConstant.Position.TOP_RIGHT.getValue()));
        i3 r15 = this.B;
        if (r15 == null) goto L31;
        r1 = r15.type;
    L31:
        r14.b("type", r1);
        r14.b("cost_time", Long.valueOf(System.currentTimeMillis() - this.r));
        Unit r16 = Unit.INSTANCE;
        r13.b(r14.a());
        return;
    }

    public final void I() {
        i3 r0 = this.B;
        if (r0 == null) goto L30;
        j3 r1 = r0.cardDisplayInfo;
        if (r1 == null) goto L30;
        LiveDSLModel r2 = r1.dslDetail;
        if (r2 == null) goto L9;
        r2.getDslType();
    L10:
        Integer r3 = r1.width;
        Integer r4 = r1.height;
        final Integer r5 = r1.right;
        final Integer r6 = r1.top;
        int r7 = CardConstraint.h;
        Integer r8 = null;
        if (r3 == null) goto L18;
        Integer r9 = Integer.valueOf(UtilityKotlinExtentionsKt.i(r3.intValue()));
        if ((!mm0.b.a(Integer.valueOf(r9.intValue()))) == true) goto L16;
        r9 = null;
    L16:
        if (r9 == null) goto L18;
        int r10 = r9.intValue();
    L19:
        if (r4 == null) goto L25;
        Integer r11 = Integer.valueOf(UtilityKotlinExtentionsKt.i(r4.intValue()));
        if ((!mm0.b.a(Integer.valueOf(r11.intValue()))) == false) goto L23;
        r8 = r11;
    L23:
        if (r8 == null) goto L25;
        int r12 = r8.intValue();
    L26:
        CardConstraint r13 = new CardConstraint(r10, r12);
        r13.b(CardConstraint.Position.TopRight);
        r13.a(new TopRightCommonCard$commonCardConstraint$$inlined$apply$lambda$1(this, r5, r6));
        P(r13);
        i r14 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r14 == null) goto L30;
        CardAlogParamsBuilder r15 = new CardAlogParamsBuilder();
        r15.d("TopRightCommonCard");
        r15.c("setConstraint");
        r15.a("width", Integer.valueOf(((v61.a) this).b.f));
        r15.a("height", Integer.valueOf(((v61.a) this).b.g));
        r15.a("right", Integer.valueOf(((v61.a) this).b.d));
        r15.a("top", Integer.valueOf(((v61.a) this).b.c));
        Unit r16 = Unit.INSTANCE;
        r14.d(r15.b());
    L25:
        r12 = ((Number) this.y.getValue()).intValue();
    L18:
        r10 = ((Number) this.x.getValue()).intValue();
        goto L19
    L9:
        DslTypeInt.DslTypeSchema.getValue();
    L30:
        i r17 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r17 == null) goto L35;
        CardAlogParamsBuilder r18 = new CardAlogParamsBuilder();
        r18.d("TopRightCommonCard");
        r18.c("onCreate");
        Unit r19 = Unit.INSTANCE;
        r17.d(r18.b());
        return;
    }

    public final void K() {
        com.bytedance.android.live.messagewindow.business.presenter.e r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L5:
        r0.f0(this.p, false);
        this.t += System.currentTimeMillis() - this.s;
        i r1 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r1 == null) goto L10;
        CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
        r2.d("TopRightCommonCard");
        r2.c("onHide");
        Unit r3 = Unit.INSTANCE;
        r1.d(r2.b());
        return;
    }

    public final void L() {
        com.bytedance.android.live.messagewindow.business.presenter.e r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L5:
        r0.f0(this.p, true);
        this.s = System.currentTimeMillis();
        i r1 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r1 == null) goto L16;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r2 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_show");
        r2.b("position", Integer.valueOf(CommonCardConstant.Position.TOP_RIGHT.getValue()));
        i3 r3 = this.B;
        Integer r4 = null;
        if (r3 == null) goto L11;
        Integer r5 = r3.type;
    L12:
        r2.b("type", r5);
        i3 r6 = this.B;
        if (r6 == null) goto L15;
        r4 = r6.priority;
    L15:
        r2.b("priority", r4);
        Unit r7 = Unit.INSTANCE;
        r1.b(r2.a());
        goto L16
    L11:
        r5 = null;
    L16:
        i r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r8 == null) goto L21;
        CardAlogParamsBuilder r9 = new CardAlogParamsBuilder();
        r9.d("TopRightCommonCard");
        r9.c("onShow");
        Unit r10 = Unit.INSTANCE;
        r8.d(r9.b());
        return;
    }

    public final void M() {
        DataCenter r0 = this.C;
        IRoom r1 = null;
        if (r0 == null) goto L5;
        r1 = (IRoom) r0.get("data_room", null);
    L5:
        this.o = r1;
        i r2 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r2 == null) goto L10;
        CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();
        r3.d("TopRightCommonCard");
        r3.c("onStart");
        Unit r4 = Unit.INSTANCE;
        r2.d(r3.b());
        return;
    }

    public final x61.h<?, ?> content() {
        x61.h.a.getClass();
        return new x61.e();
    }

    public final void J() {
        super.J();
        Integer r1 = null;
        if (this.n == null) goto L29;
        int r0 = m71.e.a;
        if (((n71.a) m71.b.a.getValue()).g() == false) goto L22;
        com.bytedance.android.live.messagewindow.business.presenter.e r2 = this.n;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L9:
        o r3 = this.u;
        k r4 = this.v;
        r2.getClass();
        IRoomContextService r5 = jc1.k.f(IRoomContextService.class);
        if (r5 == null) goto L16;
        q r6 = IRoomContextService.a.b(r5, r2.d, 2);
        if (r6 == null) goto L16;
        j r7 = r6.E1();
        if (r7 == null) goto L16;
        n r8 = (n) r7.getValue();
    L17:
        if (r3 == null) goto L25;
        yt1.q r9 = r3.b;
        if (r9 == null) goto L25;
        if (r8 == null) goto L25;
        r8.a(r9, r4);
    L25:
        com.bytedance.android.live.messagewindow.business.presenter.e r10 = this.n;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L28:
        r10.detachView();
    L16:
        r8 = null;
        goto L17
    L22:
        k r11 = this.v;
        if (r11 == null) goto L25;
        r11.release();
    L29:
        ViewGroup r12 = this.q;
        if (r12 == null) goto L32;
        r12.removeAllViews();
    L32:
        this.p = null;
        i r13 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r13 == null) goto L36;
        CardAlogParamsBuilder r14 = new CardAlogParamsBuilder();
        r14.d("TopRightCommonCard");
        r14.c("onDestroy");
        Unit r15 = Unit.INSTANCE;
        r13.d(r14.b());
    L36:
        i r16 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r16 == null) goto L47;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r17 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_show_duration");
        r17.b("position", Integer.valueOf(CommonCardConstant.Position.TOP_RIGHT.getValue()));
        i3 r18 = this.B;
        if (r18 == null) goto L42;
        Integer r19 = r18.type;
    L43:
        r17.b("type", r19);
        i3 r20 = this.B;
        if (r20 == null) goto L46;
        r1 = r20.priority;
    L46:
        r17.b("priority", r1);
        r17.b("duration", Long.valueOf(this.t));
        Unit r21 = Unit.INSTANCE;
        r16.b(r17.a());
        goto L47
    L42:
        r19 = null;
    L47:
        this.t = 0;
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void yA() {
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L7;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d("TopRightCommonCard");
        r1.c("onHybridCardLoadStart");
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
        return;
    }

    public final Context getContext() {
        return this.D;
    }

    public final DataCenter getDataCenter() {
        return this.C;
    }

    public final MsgWindowPosition getPosition() {
        return this.m;
    }

    public final void N(View r18) {
        Intrinsics.checkNotNullParameter(r18, "container");
        Intrinsics.checkNotNullParameter(r18, "container");
        this.r = System.currentTimeMillis();
        View r1 = ((v61.a) this).d;
        k r2 = null;
        if (r1 == null) goto L5;
        ViewGroup r3 = (ViewGroup) r1.findViewById(2131389638);
    L7:
        if ((r3 instanceof ViewGroup) == true) goto L9;
        r3 = null;
    L9:
        this.q = r3;
        View r4 = ((v61.a) this).d;
        if (r4 == null) goto L18;
        i3 r5 = this.B;
        if (r5 == null) goto L16;
        j3 r6 = r5.cardDisplayInfo;
        if (r6 == null) goto L16;
        String r7 = r6.accessibleName;
    L17:
        r4.setContentDescription(r7);
    L16:
        r7 = null;
    L18:
        com.bytedance.android.live.messagewindow.business.presenter.e r8 = new com.bytedance.android.live.messagewindow.business.presenter.e(this.C);
        ((q46.b) r8).a = this;
        Unit r9 = Unit.INSTANCE;
        this.n = r8;
        i3 r10 = this.B;
        if (r10 == null) goto L21;
        Integer r11 = r10.type;
    L23:
        if (r11 != null) goto L26;
    L50:
        i3 r12 = this.B;
        if (r12 == null) goto L57;
        j3 r13 = r12.cardDisplayInfo;
        if (r13 == null) goto L57;
        LiveDSLModel r14 = r13.dslDetail;
        if (r14 == null) goto L57;
        Long r15 = Long.valueOf(r14.getDslType());
    L58:
        long r16 = DslTypeInt.DslTypeSlice.getValue();
        long r17 = 0;
        if (r15 != null) goto L62;
    L64:
        long r19 = DslTypeInt.DslTypeLynxAir.getValue();
        if (r15 != null) goto L68;
    L93:
        DslTypeInt r20 = DslTypeInt.DslTypeLynx;
        long r21 = r20.getValue();
        if (r15 != null) goto L97;
    L99:
        long r22 = DslTypeInt.DslTypeSchema.getValue();
        if (r15 != null) goto L103;
    L164:
        i r23 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r23 == null) goto L176;
        CardAlogParamsBuilder r24 = new CardAlogParamsBuilder();
        r24.d("TopRightCommonCard");
        r24.c("onViewCreate");
        i3 r25 = this.B;
        if (r25 == null) goto L174;
        j3 r26 = r25.cardDisplayInfo;
        if (r26 == null) goto L174;
        LiveDSLModel r27 = r26.dslDetail;
        if (r27 == null) goto L174;
        r17 = r27.getDslType();
    L174:
        r24.a("containerType", Long.valueOf(r17));
        r23.d(r24.b());
        return;
    L176:
        return;
    L103:
        if (r15.longValue() != r22) goto L164;
    L104:
        i3 r28 = this.B;
        if (r28 == null) goto L163;
        int r29 = mm0.c.a;
        Intrinsics.checkNotNullParameter(r28, "commonCardArea");
        j3 r30 = r28.cardDisplayInfo;
        if (r30 == null) goto L109;
        LiveDSLModel r31 = r30.dslDetail;
    L110:
        if (r31 == null) goto L123;
        String r32 = r31.getUrl();
        if (r32 == null) goto L123;
        long r33 = r31.getDslType();
        if (r33 != r20.getValue()) goto L121;
        Uri.Builder r34 = x6.a.d(r32).buildUpon();
        if (r34 == null) goto L123;
        Uri.Builder r35 = r34.appendQueryParameter("screen_size_adaptation", "1");
        if (r35 == null) goto L123;
        Uri r36 = r35.build();
    L124:
        if (r36 == null) goto L163;
        com.bytedance.android.live.messagewindow.business.presenter.e r37 = this.n;
        if (r37 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L128:
        Context r38 = this.D;
        i3 r39 = this.B;
        if (r39 == null) goto L140;
        j3 r40 = r39.cardDisplayInfo;
        if (r40 == null) goto L140;
        Integer r41 = r40.width;
        if (r41 == null) goto L140;
        Integer r42 = Integer.valueOf(UtilityKotlinExtentionsKt.i(r41.intValue()));
        if ((true ^ mm0.b.a(Integer.valueOf(r42.intValue()))) == true) goto L138;
        r42 = null;
    L138:
        if (r42 == null) goto L140;
        int r43 = r42.intValue();
    L141:
        r37.getClass();
        Intrinsics.checkNotNullParameter(r38, "context");
        Intrinsics.checkNotNullParameter(r36, "uri");
        k r44 = jc1.k.n(IBaseBrowserService.class).getHybridCard(r38, r36, r43, new com.bytedance.android.live.messagewindow.business.presenter.a(r37));
        if (r44 == null) goto L163;
        com.bytedance.android.live.messagewindow.business.presenter.e r45 = this.n;
        if (r45 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L146:
        r45.e0(r44);
        com.bytedance.android.live.messagewindow.business.presenter.e r46 = this.n;
        if (r46 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L149:
        Observable r47 = w();
        y61.a r48 = r46.c0();
        if (r48 == null) goto L152;
        r48.registerJsEvent(r44, r47);
    L152:
        com.bytedance.android.live.messagewindow.business.presenter.e r49 = this.n;
        if (r49 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L155:
        if (r49 == null) goto L161;
        i3 r50 = this.B;
        Intrinsics.checkNotNullParameter(this.E, "initScene");
        y61.a r51 = r49.c0();
        if (r51 == null) goto L160;
        Map r52 = r51.generateTopRightCardData(r50);
        if (r52 == null) goto L160;
    L162:
        r44.load(null, r52);
        r2 = r44;
    L160:
        r52 = new LinkedHashMap();
        goto L162
    L161:
        r52 = null;
    L140:
        r43 = ((Number) this.x.getValue()).intValue();
        goto L141
    L121:
        if (r33 != DslTypeInt.DslTypeSchema.getValue()) goto L123;
        r36 = UriProtector.parse(r32);
    L123:
        r36 = null;
        goto L124
    L109:
        r31 = null;
    L163:
        this.p = r2;
        goto L164
    L97:
        if (r15.longValue() != r21) goto L99;
    L68:
        if (r15.longValue() != r19) goto L93;
    L69:
        ViewGroup r110 = this.q;
        if (r110 == null) goto L164;
        i3 r53 = this.B;
        if (r53 == null) goto L76;
        j3 r54 = r53.cardDisplayInfo;
        if (r54 == null) goto L76;
        LiveDSLModel r55 = r54.dslDetail;
    L77:
        if (r55 != null) goto L79;
        dismiss();
        goto L164
    L79:
        o.e.getClass();
        this.u = o.a.b(r55);
        MiddlewareRoomContext r56 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.C, 0, 2);
        if (r56 == null) goto L84;
        j r57 = r56.getDslManager();
        if (r57 == null) goto L84;
        n r111 = (n) r57.getValue();
    L85:
        o r112 = this.u;
        if (r112 == null) goto L164;
        if (r111 == null) goto L92;
        String r58 = r55.getDslData();
        if (r58 != null) goto L91;
        r58 = "";
    L91:
        r r113 = new r();
        r113.b = true;
        r2 = r111.d(r112, r58, r110, r113, new g(r111, r110, this));
    L92:
        this.v = r2;
    L84:
        r111 = null;
    L76:
        r55 = null;
        goto L77
    L62:
        if (r15.longValue() != r16) goto L64;
    L57:
        r15 = null;
        goto L58
    L26:
        if (r11.intValue() != 30) goto L50;
        i3 r59 = this.B;
        if (r59 == null) goto L34;
        j3 r60 = r59.cardDisplayInfo;
        if (r60 == null) goto L34;
        LiveDSLModel r61 = r60.dslDetail;
        if (r61 == null) goto L34;
        String r62 = r61.getDslData();
    L35:
        HashMap r63 = (HashMap) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r62, new h().getType());
        if (r63 == null) goto L42;
        com.bytedance.android.livesdk.chatroom.o r65 = getRoomContext();
        if (r65 == null) goto L40;
        Boolean r66 = r65.isAnchor();
    L41:
        r63.put("is_folded", Boolean.valueOf(!Intrinsics.areEqual(r66, Boolean.TRUE)));
    L43:
        i3 r67 = this.B;
        if (r67 == null) goto L50;
        j3 r68 = r67.cardDisplayInfo;
        if (r68 == null) goto L50;
        LiveDSLModel r69 = r68.dslDetail;
        if (r69 == null) goto L50;
        r69.setDslData(GsonProtectorUtils.toJson(GsonHelper.getDefault(), r63));
        goto L50
    L40:
        r66 = null;
        goto L41
    L42:
        r63 = null;
    L34:
        r62 = null;
        goto L35
    L21:
        r11 = null;
        goto L23
    L5:
        r3 = null;
        goto L7
    }

    public final void Q(HybridCard r1) {
        this.p = r1;
    }

    public final void R(i3 r8) {
        j3 r0 = r8.cardDisplayInfo;
        if (r0 == null) goto L7;
        LiveDSLModel r1 = r0.dslDetail;
        if (r1 == null) goto L7;
        String r2 = r1.getDslData();
    L8:
        HashMap r3 = (HashMap) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r2, new h().getType());
        j3 r4 = r8.cardDisplayInfo;
        if (r4 == null) goto L18;
        List r5 = r4.initFields;
        if (r5 == null) goto L18;
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L18;
        String r7 = (String) r6.next();
        if (r3 == null) goto L14;
        r3.remove(r7);
    L18:
        o r9 = this.u;
        if (r9 == null) goto L29;
        yt1.q r10 = r9.b;
        if (r10 == null) goto L29;
        MiddlewareRoomContext r11 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.C, 0, 2);
        if (r11 == null) goto L29;
        j r12 = r11.getDslManager();
        if (r12 == null) goto L29;
        n r13 = (n) r12.getValue();
        if (r13 == null) goto L29;
        r13.e(r10, r3);
    L29:
        this.B = r8;
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void S(Map<String, ? extends Object> r7) {
        Object r1 = null;
        if (r7 == null) goto L5;
        Object r2 = r7.get("activeClose");
    L6:
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L27;
        IRoom r4 = this.o;
        if (r4 == null) goto L13;
        OfficialChannelExtraInfo r5 = r4.getOfficialChannelExtraInfo();
        if (r5 == null) goto L13;
        Long r6 = Long.valueOf(r5.getShowListId());
    L14:
        Boolean r8 = Boolean.valueOf(mm0.b.b(r6));
        IRoom r9 = this.o;
        if (r9 == null) goto L17;
        Long r10 = Long.valueOf(r9.getId());
    L18:
        IRoom r11 = this.o;
        if (r11 == null) goto L21;
        String r12 = r11.getOfficialChannelUidString();
    L22:
        String r13 = mm0.b.c(r8, r10, r12);
        i3 r14 = this.B;
        if (r14 == null) goto L25;
        Integer r15 = r14.type;
    L26:
        com.bytedance.android.live.messagewindow.business.util.c.a(r13, r15, true);
        goto L27
    L25:
        r15 = null;
        goto L26
    L21:
        r12 = null;
        goto L22
    L17:
        r10 = null;
    L13:
        r6 = null;
    L27:
        if (r7 == null) goto L30;
        r1 = r7.get("activeClose");
    L30:
        if (Intrinsics.areEqual(r1, r3) == false) goto L32;
        b71.a.a r16 = new b71.a.a();
    L33:
        ((v61.a) this).h = r16;
        return;
    L32:
        r16 = new b71.a.b();
        goto L33
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void bi(String r5) {
        dismiss();
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L6;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d("TopRightCommonCard");
        r1.c("onHybridCadLoadFail");
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
    L6:
        i r3 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r3 == null) goto L15;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r4 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_result");
        r4.b("position", Integer.valueOf(CommonCardConstant.Position.TOP_RIGHT.getValue()));
        i3 r6 = this.B;
        if (r6 == null) goto L12;
        Integer r7 = r6.type;
    L13:
        r4.b("type", r7);
        r4.b("result", Integer.valueOf(CommonCardConstant.Result.FAIL.getValue()));
        r4.b("error_msg", r5);
        Unit r8 = Unit.INSTANCE;
        r3.b(r4.a());
        return;
    L12:
        r7 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void IG(int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "errorMessage");
        i r1 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r1 == null) goto L6;
        CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
        r2.d("TopRightCommonCard");
        r2.c("onHybridCardLoadFallback");
        r2.a("errorCode", String.valueOf(r6));
        r2.a("errorMessage", r7);
        Unit r0 = Unit.INSTANCE;
        r1.d(r2.b());
    L6:
        i r3 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r3 == null) goto L15;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r4 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_fallback");
        r4.b("position", Integer.valueOf(CommonCardConstant.Position.TOP_RIGHT.getValue()));
        i3 r5 = this.B;
        if (r5 == null) goto L12;
        Integer r8 = r5.type;
    L13:
        r4.b("type", r8);
        r4.b("error_code", String.valueOf(r6));
        r4.b("error_msg", r7);
        Unit r9 = Unit.INSTANCE;
        r3.b(r4.a());
        return;
    L12:
        r8 = null;
        goto L13
    }

    public final void e(vh7.h r5, String r6) {
        String r1 = null;
        if ((r5 instanceof i3) == true) goto L5;
        r5 = null;
    L5:
        i3 r7 = (i3) r5;
        com.bytedance.android.live.messagewindow.business.presenter.e r0 = this.n;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L8:
        if (r0 == null) goto L17;
        HybridCard r2 = this.p;
        if (r7 == null) goto L16;
        j3 r3 = r7.cardDisplayInfo;
        if (r3 == null) goto L16;
        LiveDSLModel r4 = r3.dslDetail;
        if (r4 == null) goto L16;
        r1 = r4.getDslData();
    L16:
        r0.g0(r2, String.valueOf(r1), r6);
    L17:
        if (r7 == null) goto L20;
        this.B = r7;
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void gG(JsEventType r9, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r9, "eventType");
        i r1 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r1 == null) goto L6;
        CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();
        r3.d("TopRightCommonCard");
        r3.c("handleJsEvent");
        r3.a("eventType", r9);
        r3.a("params", String.valueOf(r10));
        Unit r0 = Unit.INSTANCE;
        r1.d(r3.b());
    L6:
        int r11 = f.a[r9.ordinal()];
        String r2 = "2";
        Object r5 = null;
        if (r11 != 1) goto L9;
        S(r10);
        i r12 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r12 == null) goto L51;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r4 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_destroy");
        r4.b("position", Integer.valueOf(CommonCardConstant.Position.TOP_RIGHT.getValue()));
        i3 r6 = this.B;
        if (r6 == null) goto L41;
        Integer r7 = r6.type;
    L42:
        r4.b("type", r7);
        if (r10 == null) goto L45;
        Object r8 = r10.get("activeClose");
    L47:
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L49;
        Object r13 = "2";
    L50:
        r4.b("reason", r13);
        Unit r14 = Unit.INSTANCE;
        r12.b(r4.a());
        goto L51
    L49:
        r13 = "1";
        goto L50
    L45:
        r8 = null;
        goto L47
    L41:
        r7 = null;
    L51:
        i r15 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r15 == null) goto L66;
        CardAlogParamsBuilder r16 = new CardAlogParamsBuilder();
        r16.d("TopRightCommonCard");
        StringBuilder r17 = new StringBuilder("handle js event: close card, card type: ");
        i3 r18 = this.B;
        if (r18 == null) goto L57;
        Integer r19 = r18.type;
    L58:
        r17.append(r19);
        r17.append(", reason: ");
        if (r10 == null) goto L62;
        r5 = r10.get("activeClose");
    L62:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == true) goto L65;
        r2 = "1";
    L65:
        r17.append(r2);
        r16.c(r17.toString());
        Unit r110 = Unit.INSTANCE;
        r15.d(r16.b());
        goto L66
    L57:
        r19 = null;
    L66:
        dismiss();
        return;
    L9:
        if (r11 != 2) goto L11;
        S(r10);
        hide();
        i r20 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r20 == null) goto L72;
        CardAlogParamsBuilder r21 = new CardAlogParamsBuilder();
        r21.d("TopRightCommonCard");
        StringBuilder r22 = new StringBuilder("handle js event: hide card, card type: ");
        i3 r23 = this.B;
        if (r23 == null) goto L26;
        Integer r24 = r23.type;
    L27:
        r22.append(r24);
        r22.append("reason: ");
        if (r10 == null) goto L31;
        r5 = r10.get("activeClose");
    L31:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == true) goto L34;
        r2 = "1";
    L34:
        r22.append(r2);
        r21.c(r22.toString());
        Unit r111 = Unit.INSTANCE;
        r20.d(r21.b());
        return;
    L26:
        r24 = null;
        goto L27
    L72:
        return;
    L11:
        if (r11 != 3) goto L70;
        show();
        i r25 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r25 == null) goto L71;
        CardAlogParamsBuilder r112 = new CardAlogParamsBuilder();
        r112.d("TopRightCommonCard");
        StringBuilder r26 = new StringBuilder("handle js event: show card, card type: ");
        i3 r27 = this.B;
        if (r27 == null) goto L19;
        r5 = r27.type;
    L19:
        r26.append(r5);
        r112.c(r26.toString());
        Unit r28 = Unit.INSTANCE;
        r25.d(r112.b());
        return;
    L71:
        return;
    }

    public e(i3 r2, DataCenter r3, int r4, int r5, Context r6, CommonCardInitScene r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "initScene");
        super(r3, Integer.valueOf(r4), r5);
        this.B = r2;
        this.C = r3;
        this.D = r6;
        this.E = r7;
        this.m = MsgWindowPosition.TOP_RIGHT;
        this.r = System.currentTimeMillis();
        this.s = -1;
        this.w = LazyKt.lazy(new TopRightCommonCard$templateKey$2(this));
        this.x = LazyKt.lazy(TopRightCommonCard$DEFAULT_CARD_CONTAINER_WIDTH$2.INSTANCE);
        this.y = LazyKt.lazy(TopRightCommonCard$DEFAULT_CARD_CONTAINER_HEIGHT$2.INSTANCE);
        this.z = LazyKt.lazy(TopRightCommonCard$DEFAULT_CARD_CONTAINER_RIGHT$2.INSTANCE);
        this.A = LazyKt.lazy(TopRightCommonCard$DEFAULT_CARD_CONTAINER_TOP$2.INSTANCE);
    }
}
