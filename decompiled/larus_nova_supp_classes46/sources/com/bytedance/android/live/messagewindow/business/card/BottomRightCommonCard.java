package com.bytedance.android.live.messagewindow.business.card;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter;
import com.bytedance.android.live.messagewindow.business.presenter.JsEventType;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.strategy.showintercept.ConditionId;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.android.livesdk.message.model.t1;
import com.bytedance.android.livesdk.message.model.u;
import com.bytedance.android.livesdk.message.model.u1;
import com.bytedance.android.livesdk.message.model.vd;
import com.bytedance.android.livesdk.message.model.w1;
import com.bytedance.android.livesdk.message.model.x1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelExtraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zg1.f1;
import zg1.i1;
import zl0.l;
import zl0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class BottomRightCommonCard extends v61.a implements AbsCommonCardPresenter.a {
    public static final /* synthetic */ int I = 0;
    public long A;
    public long B;
    public long C;
    public m1 D;
    public final DataCenter E;
    public final Context F;
    public HybridCard G;
    public final CommonCardInitScene H;
    public final int m;
    public final int n;
    public ViewGroup o;
    public HybridCard p;
    public boolean q;
    public t61.c r;
    public Animator s;
    public Animator t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public com.bytedance.android.live.messagewindow.business.presenter.b x;
    public IRoom y;
    public Disposable z;

    public static final class a {
    }

    public static final class b implements t61.a {
        public final /* synthetic */ BottomRightCommonCard a;

        public static final class a extends AnimatorListenerAdapter {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                t61.c r3 = this.a.a.r;
                if (r3 == null) goto L8;
                Function0 r4 = r3.b;
                if (r4 == null) goto L9;
                Unit r5 = (Unit) r4.invoke();
                return;
            L9:
                return;
            }
        }

        public b(BottomRightCommonCard r1) {
            this.a = r1;
        }

        public final Animator a(View r3) {
            int r0 = yl0.a.a;
            m1 r1 = this.a.D;
            if (r1 == null) goto L7;
            u r2 = r1.animConfig;
            if (r2 == null) goto L7;
            Integer r4 = r2.enterAnimType;
        L9:
            return yl0.a.a(r4, true, r3);
        L7:
            r4 = null;
            goto L9
        }

        public final Animator c(View r3) {
            int r0 = yl0.a.a;
            m1 r1 = this.a.D;
            if (r1 == null) goto L7;
            u r2 = r1.animConfig;
            if (r2 == null) goto L7;
            Integer r4 = r2.exitAnimType;
        L9:
            return yl0.a.a(r4, false, r3);
        L7:
            r4 = null;
            goto L9
        }

        public final boolean b(View r3, boolean r4, t61.c r5) {
            Intrinsics.checkNotNullParameter(r3, "animView");
            Intrinsics.checkNotNullParameter(r5, "listener");
            BottomRightCommonCard r6 = this.a;
            if (r6.G != null) goto L23;
            r6.r = r5;
            if (r4 == true) goto L24;
            Animator r7 = r6.t;
            if (r7 == null) goto L9;
            r7.cancel();
        L9:
            BottomRightCommonCard r8 = this.a;
            int r9 = yl0.a.a;
            m1 r10 = r8.D;
            Animator r11 = null;
            if (r10 == null) goto L14;
            u r12 = r10.animConfig;
            if (r12 == null) goto L14;
            Integer r13 = r12.exitAnimType;
        L15:
            Animator r14 = yl0.a.a(r13, false, r8.o);
            if (r14 == null) goto L18;
            r14.addListener(new a(this));
            Unit r15 = Unit.INSTANCE;
            r11 = r14;
        L18:
            r8.t = r11;
            Animator r16 = this.a.t;
            if (r16 == null) goto L25;
            r16.start();
            return true;
        L25:
            return true;
        L14:
            r13 = null;
            goto L15
        L24:
            return true;
        L23:
            return false;
        }
    }

    public static final class c implements View.OnTouchListener {
        public final /* synthetic */ BottomRightCommonCard a;

        public c(BottomRightCommonCard r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r5, MotionEvent r6) {
            if (r6 != null) goto L4;
            return false;
        L4:
            if (r6.getAction() != 0) goto L22;
            i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r0 == null) goto L23;
            com.bytedance.android.live.room.api.messagewindow.monitor.c r1 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_click");
            r1.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
            m1 r2 = this.a.D;
            if (r2 == null) goto L11;
            Integer r3 = r2.type;
        L12:
            r1.b("type", r3);
            if ((r5.getBottom() - r6.getY()) != 0.0f) goto L15;
        L17:
            String r7 = "picture";
        L18:
            r1.b("click_area", r7);
            Unit r8 = Unit.INSTANCE;
            r0.b(r1.a());
            return false;
        L15:
            if (((r5.getBottom() - r5.getTop()) / (r5.getBottom() - r6.getY())) <= 4) goto L17;
            r7 = "action";
            goto L18
        L11:
            r3 = null;
            goto L12
        L23:
            return false;
        L22:
            return false;
        }
    }

    static {
    }

    public final void I() {
        m1 r1 = this.D;
        Boolean r2 = null;
        if (r1 == null) goto L7;
        u1 r3 = r1.cardDisplayInfo;
        if (r3 == null) goto L7;
        w1 r4 = r3.preDefeatStrategy;
    L8:
        if (r1 == null) goto L12;
        u1 r5 = r1.cardDisplayInfo;
        if (r5 == null) goto L12;
        x1 r6 = r5.showDefeatStrategy;
    L13:
        t(new am0.b(r4, r6));
        int r0 = m71.e.a;
        if (((n71.a) m71.b.a.getValue()).j() == false) goto L71;
        m1 r7 = this.D;
        if (r7 == null) goto L46;
        u1 r8 = r7.cardDisplayInfo;
        if (r8 == null) goto L46;
        List r9 = r8.conditionList;
        if (r9 == null) goto L46;
        Iterator r10 = r9.iterator();
    L23:
        if (r10.hasNext() == false) goto L46;
        t1 r11 = (t1) r10.next();
        DataCenter r12 = this.E;
        int r13 = r11.type;
        Long r14 = r11.value;
        m1 r15 = this.D;
        if (r15 == null) goto L27;
        Integer r16 = r15.type;
    L28:
        int r17 = mm0.d.a;
        if (r13 != ConditionId.ANCHOR_EXIT_MIC_NOT_DISPLAY.getValue()) goto L32;
        t71.a r18 = new zl0.b(r12, r14);
    L44:
        if (r18 == null) goto L23;
        i(r18);
        goto L23
    L32:
        if (r13 != ConditionId.SAME_ANCHOR_NOT_DISPLAY.getValue()) goto L35;
        r18 = new l(r12, r14, r16, this);
        goto L44
    L35:
        if (r13 != ConditionId.ALREADY_FOLLOWED_NOT_DISPLAY.getValue()) goto L38;
        r18 = new zl0.a(r12, r14, r16, this);
        goto L44
    L38:
        if (r13 != ConditionId.EXIT_CARD_TIMES_LIMIT.getValue()) goto L41;
        r18 = new zl0.h(r12, r14, r16, this);
        goto L44
    L41:
        if (r13 != ConditionId.CARD_SHOW_INTERVAL_TIME_LIMIT.getValue()) goto L43;
        r18 = new zl0.g(r12, r14, r16, this);
        goto L44
    L43:
        r18 = null;
        goto L44
    L27:
        r16 = null;
    L46:
        DataCenter r19 = this.E;
        m1 r20 = this.D;
        if (r20 == null) goto L49;
        Integer r21 = r20.type;
    L50:
        if (r20 == null) goto L56;
        u1 r22 = r20.cardDisplayInfo;
        if (r22 == null) goto L56;
        vd r23 = r22.landScapeConfig;
        if (r23 == null) goto L56;
        Boolean r110 = r23.isLandscapeSupported;
    L57:
        int r24 = mm0.d.a;
        ArrayList r25 = new ArrayList();
        r25.add(new m(r19, 0L, r21, this, r110));
        r25.add(new zl0.i(r19, 0L, r21, this));
        if (r21 != null) goto L61;
    L63:
        Iterator r26 = r25.iterator();
    L65:
        if (r26.hasNext() == false) goto L67;
        i((t71.a) r26.next());
        goto L65
    L67:
        i r27 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r27 == null) goto L71;
        CardAlogParamsBuilder r28 = new CardAlogParamsBuilder();
        r28.d("PortraitBottomRightCommonCard");
        r28.c("addCardCondition");
        r28.a("conditions", u().toString());
        Unit r29 = Unit.INSTANCE;
        r27.d(r28.b());
        goto L71
    L61:
        if (r21.intValue() != 1) goto L63;
        r25.add(new l(r19, 0L, r21, this));
        r25.add(new zl0.b(r19, 0L));
        r25.add(new zl0.a(r19, 0L, r21, this));
    L56:
        r110 = null;
        goto L57
    L49:
        r21 = null;
    L71:
        int r30 = m71.e.a;
        if (((n71.a) m71.b.a.getValue()).a() == true) goto L74;
        a0();
    L74:
        m1 r31 = this.D;
        if (r31 == null) goto L85;
        u r32 = r31.animConfig;
        if (r32 == null) goto L85;
        Boolean r33 = r32.isAnimSupported;
        if (r33 == null) goto L85;
        if (r33.booleanValue() == false) goto L83;
        r2 = r33;
    L83:
        if (r2 == null) goto L85;
        r2.booleanValue();
        c(new b(this));
    L85:
        i r34 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r34 == null) goto L96;
        CardAlogParamsBuilder r35 = new CardAlogParamsBuilder();
        r35.d("PortraitBottomRightCommonCard");
        r35.c("onCreate");
        Unit r36 = Unit.INSTANCE;
        r34.d(r35.b());
        return;
    L96:
        return;
    L12:
        r6 = null;
    L7:
        r4 = null;
        goto L8
    }

    public final void K() {
        com.bytedance.android.live.messagewindow.business.presenter.b r0 = this.x;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L5:
        r0.f0(this.p, false);
        if (this.B <= 0) goto L9;
        this.C += System.currentTimeMillis() - this.B;
        this.B = -1;
    L9:
        DataCenter r1 = this.E;
        if (r1 == null) goto L12;
        r1.put("data_live_bottom_right_card_show", new f1(false, 0));
    L12:
        i r2 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r2 == null) goto L17;
        CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();
        r3.d("PortraitBottomRightCommonCard");
        r3.c("onHide");
        Unit r4 = Unit.INSTANCE;
        r2.d(r3.b());
        return;
    }

    public final void L() {
        com.bytedance.android.live.messagewindow.business.presenter.b r0 = this.x;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L5:
        r0.f0(this.p, true);
        this.B = System.currentTimeMillis();
        DataCenter r1 = this.E;
        if (r1 == null) goto L17;
        m1 r3 = this.D;
        if (r3 == null) goto L14;
        u1 r4 = r3.cardDisplayInfo;
        if (r4 == null) goto L14;
        Integer r5 = r4.width;
        if (r5 == null) goto L14;
        int r6 = UtilityKotlinExtentionsKt.i(r5.intValue());
    L15:
        r1.put("data_live_bottom_right_card_show", new f1(true, r6));
    L14:
        r6 = ((Number) this.u.getValue()).intValue();
    L17:
        if (this.q == false) goto L19;
        S();
    L19:
        i r2 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        Integer r7 = null;
        if (r2 == null) goto L54;
        CardAlogParamsBuilder r8 = new CardAlogParamsBuilder();
        r8.d("PortraitBottomRightCommonCard");
        r8.c("onShow");
        if (((v61.a) this).f == false) goto L53;
        StringBuilder r9 = new StringBuilder("卡片的页面类型为：");
        m1 r10 = this.D;
        if (r10 == null) goto L29;
        u1 r11 = r10.cardDisplayInfo;
        if (r11 == null) goto L29;
        Integer r12 = Integer.valueOf(r11.containerType);
    L30:
        if (r12 != null) goto L33;
    L35:
        if (r12 != null) goto L38;
    L40:
        if (r12 != null) goto L43;
    L45:
        String r13 = "Unknown";
    L46:
        r9.append(r13);
        r9.append("，地址为：");
        m1 r14 = this.D;
        if (r14 == null) goto L51;
        u1 r15 = r14.cardDisplayInfo;
        if (r15 == null) goto L51;
        String r16 = r15.url;
    L52:
        r9.append(r16);
        r8.c(r9.toString());
    L51:
        r16 = null;
        goto L52
    L43:
        if (r12.intValue() != 3) goto L45;
        r13 = "Schema";
        goto L46
    L38:
        if (r12.intValue() != 2) goto L40;
        r13 = "WebView";
        goto L46
    L33:
        if (r12.intValue() != 1) goto L35;
        r13 = "Lynx";
    L29:
        r12 = null;
    L53:
        Unit r17 = Unit.INSTANCE;
        r2.d(r8.b());
    L54:
        i r18 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r18 == null) goto L66;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r19 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_show");
        r19.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        m1 r20 = this.D;
        if (r20 == null) goto L60;
        Integer r21 = r20.type;
    L61:
        r19.b("type", r21);
        m1 r22 = this.D;
        if (r22 == null) goto L64;
        r7 = r22.priority;
    L64:
        r19.b("priority", r7);
        Unit r23 = Unit.INSTANCE;
        r18.b(r19.a());
        return;
    L60:
        r21 = null;
        goto L61
    }

    public final void M() {
        HybridCard r0 = this.G;
        if (r0 == null) goto L5;
        this.p = r0;
        this.q = true;
    L5:
        int r1 = m71.e.a;
        if (((n71.a) m71.b.a.getValue()).a() == false) goto L8;
        a0();
    L8:
        DataCenter r2 = this.E;
        IRoom r3 = null;
        if (r2 == null) goto L11;
        r3 = (IRoom) r2.get("data_room", null);
    L11:
        this.y = r3;
        T();
        i r4 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r4 == null) goto L16;
        CardAlogParamsBuilder r5 = new CardAlogParamsBuilder();
        r5.d("PortraitBottomRightCommonCard");
        r5.c("onStart");
        Unit r6 = Unit.INSTANCE;
        r4.d(r5.b());
        return;
    }

    public final void S() {
        HybridCard r0 = this.p;
        if (r0 == null) goto L14;
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == true) goto L7;
        r1 = null;
    L7:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L10;
        r2.removeView(r0);
    L10:
        ViewGroup r3 = this.o;
        if (r3 == null) goto L15;
        r3.addView(r0, new ViewGroup.LayoutParams(-1, -1));
        return;
    L15:
        return;
    }

    public final void a0() {
        m1 r0 = this.D;
        if (r0 == null) goto L27;
        u1 r1 = r0.cardDisplayInfo;
        if (r1 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(b0(), Boolean.TRUE) == false) goto L9;
        CardConstraint r2 = V(r1.width, r1.height, r1.right, r1.bottom);
    L22:
        P(r2);
        i r3 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r3 == null) goto L29;
        CardAlogParamsBuilder r4 = new CardAlogParamsBuilder();
        r4.d("PortraitBottomRightCommonCard");
        r4.c("setConstraint");
        r4.a("width", Integer.valueOf(((v61.a) this).b.f));
        r4.a("height", Integer.valueOf(((v61.a) this).b.g));
        r4.a("right", Integer.valueOf(((v61.a) this).b.d));
        r4.a("bottom", Integer.valueOf(((v61.a) this).b.e));
        Unit r5 = Unit.INSTANCE;
        r3.d(r4.b());
        return;
    L29:
        return;
    L9:
        vd r6 = r1.landScapeConfig;
        Integer r7 = null;
        if (r6 == null) goto L12;
        Integer r8 = r6.width;
    L13:
        if (r6 == null) goto L15;
        Integer r9 = r6.height;
    L16:
        if (r6 == null) goto L18;
        Integer r10 = r6.right;
    L19:
        if (r6 == null) goto L21;
        r7 = r6.bottom;
    L21:
        r2 = V(r8, r9, r10, r7);
        goto L22
    L18:
        r10 = null;
        goto L19
    L15:
        r9 = null;
        goto L16
    L12:
        r8 = null;
        goto L13
    }

    public final Boolean b0() {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        boolean r1 = true;
        if (r0 == null) goto L12;
        o r2 = IRoomContextService.a.a(r0, this.E, 0, 2);
        if (r2 == null) goto L12;
        com.bytedance.live.datacontext.m r3 = r2.v2();
        if (r3 == null) goto L12;
        Integer r4 = (Integer) r3.getValue();
        if (r4 == null) goto L12;
        r1 = r4.equals(1);
    L12:
        return Boolean.valueOf(r1);
    }

    public final x61.h<?, ?> content() {
        x61.h.a.getClass();
        return new x61.e();
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void CA() {
        S();
        m1 r0 = this.D;
        Integer r1 = null;
        if (r0 == null) goto L34;
        u r2 = r0.animConfig;
        if (r2 == null) goto L34;
        Boolean r3 = r2.isAnimSupported;
        if (r3 == null) goto L34;
        if (r3.booleanValue() == true) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L34;
        r3.booleanValue();
        Animator r5 = this.s;
        if (r5 == null) goto L21;
        r5.cancel();
    L21:
        int r6 = yl0.a.a;
        m1 r7 = this.D;
        if (r7 == null) goto L26;
        u r8 = r7.animConfig;
        if (r8 == null) goto L26;
        Integer r9 = r8.enterAnimType;
    L27:
        Animator r10 = yl0.a.a(r9, true, this.o);
        if (r10 == null) goto L30;
        r10.addListener(new com.bytedance.android.live.messagewindow.business.card.b(this));
        Unit r11 = Unit.INSTANCE;
    L31:
        this.s = r10;
        if (r10 == null) goto L34;
        r10.start();
        goto L34
    L30:
        r10 = null;
    L26:
        r9 = null;
        goto L27
    L11:
        if (this.G != null) goto L13;
        r4 = true;
    L34:
        i r12 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r12 == null) goto L38;
        CardAlogParamsBuilder r13 = new CardAlogParamsBuilder();
        r13.d("PortraitBottomRightCommonCard");
        r13.c("onHybridCardLoadSuccess");
        Unit r14 = Unit.INSTANCE;
        r12.d(r13.b());
    L38:
        i r15 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r15 == null) goto L46;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r16 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_result");
        r16.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        m1 r17 = this.D;
        if (r17 == null) goto L44;
        Integer r18 = r17.type;
    L45:
        r16.b("type", r18);
        r16.b("result", Integer.valueOf(CommonCardConstant.Result.SUCCESS.getValue()));
        Unit r19 = Unit.INSTANCE;
        r15.b(r16.a());
        goto L46
    L44:
        r18 = null;
    L46:
        i r20 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r20 == null) goto L54;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r21 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_time_cost");
        r21.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        m1 r22 = this.D;
        if (r22 == null) goto L52;
        r1 = r22.type;
    L52:
        r21.b("type", r1);
        r21.b("cost_time", Long.valueOf(System.currentTimeMillis() - this.A));
        Unit r23 = Unit.INSTANCE;
        r20.b(r21.a());
        return;
    }

    public final void J() {
        super.J();
        com.bytedance.android.live.messagewindow.business.presenter.b r0 = this.x;
        if (r0 == null) goto L5;
        r0.detachView();
    L5:
        HybridCard r1 = this.p;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        ViewGroup r2 = this.o;
        if (r2 == null) goto L11;
        r2.removeAllViews();
    L11:
        this.p = null;
        this.q = false;
        Disposable r3 = this.z;
        if (r3 == null) goto L14;
        r3.dispose();
    L14:
        i r4 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r4 == null) goto L19;
        CardAlogParamsBuilder r5 = new CardAlogParamsBuilder();
        r5.d("PortraitBottomRightCommonCard");
        r5.c("onDestroy");
        Unit r6 = Unit.INSTANCE;
        r4.d(r5.b());
    L19:
        if (this.B <= 0) goto L22;
        this.C += System.currentTimeMillis() - this.B;
        this.B = -1;
    L22:
        i r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r7 == null) goto L34;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r8 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_show_duration");
        r8.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        m1 r9 = this.D;
        if (r9 == null) goto L28;
        Integer r10 = r9.type;
    L29:
        r8.b("type", r10);
        m1 r11 = this.D;
        if (r11 == null) goto L32;
        Integer r12 = r11.priority;
    L33:
        r8.b("priority", r12);
        r8.b("duration", Long.valueOf(this.C));
        Unit r13 = Unit.INSTANCE;
        r7.b(r8.a());
        goto L34
    L32:
        r12 = null;
        goto L33
    L28:
        r10 = null;
    L34:
        this.C = 0;
        Animator r14 = this.s;
        if (r14 == null) goto L37;
        r14.removeAllListeners();
    L37:
        Animator r15 = this.t;
        if (r15 == null) goto L40;
        r15.removeAllListeners();
    L40:
        Animator r16 = this.s;
        if (r16 == null) goto L43;
        r16.cancel();
    L43:
        Animator r17 = this.t;
        if (r17 == null) goto L46;
        r17.cancel();
    L46:
        this.s = null;
        this.t = null;
        this.r = null;
    }

    public final void T() {
        Boolean r0 = b0();
        if (r0 == null) goto L20;
        Disposable r2 = null;
        if (r0.booleanValue() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L21;
        r0.booleanValue();
        Disposable r1 = this.z;
        if (r1 == null) goto L12;
        r1.dispose();
    L12:
        com.bytedance.android.live.messagewindow.business.presenter.b r3 = this.x;
        if (r3 == null) goto L22;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L16:
        if (r3 == null) goto L18;
        r2 = xs2.b.a().b(i1.class).subscribe(new com.bytedance.android.live.messagewindow.business.presenter.c(r3, ((v61.a) this).d, this.y));
    L18:
        this.z = r2;
        return;
    L22:
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void yA() {
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L7;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d("PortraitBottomRightCommonCard");
        r1.c("onHybridCardLoadStart");
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
        return;
    }

    public final Context getContext() {
        return this.F;
    }

    public final DataCenter getDataCenter() {
        return this.E;
    }

    public final void N(View r8) {
        Intrinsics.checkNotNullParameter(r8, "container");
        Intrinsics.checkNotNullParameter(r8, "container");
        View r9 = ((v61.a) this).d;
        HybridCard r0 = null;
        if (r9 == null) goto L5;
        ViewGroup r10 = (ViewGroup) r9.findViewById(2131389638);
    L7:
        if ((r10 instanceof ViewGroup) == true) goto L9;
        r10 = null;
    L9:
        this.o = r10;
        View r11 = ((v61.a) this).d;
        if (r11 == null) goto L18;
        m1 r1 = this.D;
        if (r1 == null) goto L16;
        u1 r2 = r1.cardDisplayInfo;
        if (r2 == null) goto L16;
        String r3 = r2.accessibleName;
    L17:
        r11.setContentDescription(r3);
    L16:
        r3 = null;
    L18:
        com.bytedance.android.live.messagewindow.business.presenter.b r12 = this.x;
        if (r12 == null) goto L21;
        ((q46.b) r12).a = this;
    L22:
        this.A = System.currentTimeMillis();
        HybridCard r13 = this.p;
        if (r13 != null) goto L69;
        m1 r14 = this.D;
        if (r14 == null) goto L67;
        Uri r15 = mm0.c.c(r14);
        if (r15 == null) goto L67;
        com.bytedance.android.live.messagewindow.business.presenter.b r4 = this.x;
        if (r4 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L31:
        Context r5 = this.F;
        m1 r6 = this.D;
        if (r6 == null) goto L38;
        u1 r7 = r6.cardDisplayInfo;
        if (r7 == null) goto L38;
        Integer r16 = r7.width;
        if (r16 == null) goto L38;
        int r17 = UtilityKotlinExtentionsKt.i(r16.intValue());
    L39:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r15, "uri");
        HybridCard r18 = k.n(IBaseBrowserService.class).getHybridCard(r5, r15, r17, new com.bytedance.android.live.messagewindow.business.presenter.a(r4));
        if (r18 == null) goto L67;
        com.bytedance.android.live.messagewindow.business.presenter.b r19 = this.x;
        if (r19 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L44:
        r19.h0();
        com.bytedance.android.live.messagewindow.business.presenter.b r20 = this.x;
        if (r20 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L47:
        r20.i0();
        com.bytedance.android.live.messagewindow.business.presenter.b r21 = this.x;
        if (r21 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L50:
        r21.e0(r18);
        com.bytedance.android.live.messagewindow.business.presenter.b r22 = this.x;
        if (r22 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L53:
        Observable r23 = w();
        y61.a r24 = r22.c0();
        if (r24 == null) goto L56;
        r24.registerJsEvent(r18, r23);
    L56:
        com.bytedance.android.live.messagewindow.business.presenter.b r25 = this.x;
        if (r25 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L59:
        if (r25 == null) goto L65;
        m1 r26 = this.D;
        CommonCardInitScene r27 = this.H;
        Intrinsics.checkNotNullParameter(r27, "initScene");
        y61.a r28 = r25.c0();
        if (r28 == null) goto L64;
        Map r29 = r28.generateCardData(r26, r27);
        if (r29 == null) goto L64;
    L66:
        r18.load(null, r29);
        r0 = r18;
    L64:
        r29 = new LinkedHashMap();
        goto L66
    L65:
        r29 = null;
    L38:
        r17 = ((Number) this.u.getValue()).intValue();
    L67:
        this.p = r0;
    L80:
        c r30 = new c(this);
        HybridCard r31 = this.p;
        if (r31 == null) goto L83;
        r31.setOnTouchListener(r30);
    L83:
        T();
        i r32 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r32 == null) goto L88;
        CardAlogParamsBuilder r33 = new CardAlogParamsBuilder();
        r33.d("PortraitBottomRightCommonCard");
        r33.c("onViewCreate");
        Unit r34 = Unit.INSTANCE;
        r32.d(r33.b());
        return;
    L88:
        return;
    L69:
        if (this.G == null) goto L80;
        com.bytedance.android.live.messagewindow.business.presenter.b r35 = this.x;
        if (r35 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L73:
        r35.h0();
        com.bytedance.android.live.messagewindow.business.presenter.b r36 = this.x;
        if (r36 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L76:
        r36.i0();
        com.bytedance.android.live.messagewindow.business.presenter.b r37 = this.x;
        if (r37 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L79:
        r37.e0(r13);
        goto L80
    L21:
        com.bytedance.android.live.messagewindow.business.presenter.b r38 = new com.bytedance.android.live.messagewindow.business.presenter.b(this.E);
        ((q46.b) r38).a = this;
        Unit r39 = Unit.INSTANCE;
        this.x = r38;
        goto L22
    L5:
        r10 = null;
        goto L7
    }

    public final void Q(HybridCard r1) {
        this.G = r1;
    }

    public final void W(Map<String, ? extends Object> r7) {
        Object r1 = null;
        if (r7 == null) goto L5;
        Object r2 = r7.get("activeClose");
    L6:
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L27;
        IRoom r4 = this.y;
        if (r4 == null) goto L13;
        OfficialChannelExtraInfo r5 = r4.getOfficialChannelExtraInfo();
        if (r5 == null) goto L13;
        Long r6 = Long.valueOf(r5.getShowListId());
    L14:
        Boolean r8 = Boolean.valueOf(mm0.b.b(r6));
        IRoom r9 = this.y;
        if (r9 == null) goto L17;
        Long r10 = Long.valueOf(r9.getId());
    L18:
        IRoom r11 = this.y;
        if (r11 == null) goto L21;
        String r12 = r11.getOfficialChannelUidString();
    L22:
        String r13 = mm0.b.c(r8, r10, r12);
        m1 r14 = this.D;
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
        r1.d("PortraitBottomRightCommonCard");
        r1.c("onHybridCadLoadFail");
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
    L6:
        i r3 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r3 == null) goto L15;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r4 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_result");
        r4.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        m1 r6 = this.D;
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
        r2.d("PortraitBottomRightCommonCard");
        r2.c("onHybridCardLoadFallback");
        r2.a("errorCode", String.valueOf(r6));
        r2.a("errorMessage", r7);
        Unit r0 = Unit.INSTANCE;
        r1.d(r2.b());
    L6:
        i r3 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r3 == null) goto L15;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r4 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_fallback");
        r4.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        m1 r5 = this.D;
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
        if ((r5 instanceof m1) == true) goto L5;
        r5 = null;
    L5:
        m1 r7 = (m1) r5;
        if (this.x != null) goto L8;
        this.x = new com.bytedance.android.live.messagewindow.business.presenter.b(this.E);
    L8:
        com.bytedance.android.live.messagewindow.business.presenter.b r0 = this.x;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L11:
        if (r0 == null) goto L20;
        HybridCard r2 = this.p;
        if (r2 != null) goto L15;
        r2 = this.G;
    L15:
        if (r7 == null) goto L19;
        u1 r3 = r7.cardDisplayInfo;
        if (r3 == null) goto L19;
        r1 = r3.containerPayload;
    L19:
        r0.g0(r2, r1, r6);
    L20:
        if (r7 == null) goto L23;
        this.D = r7;
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void gG(JsEventType r9, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r9, "eventType");
        i r1 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r1 == null) goto L6;
        CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();
        r3.d("PortraitBottomRightCommonCard");
        r3.c("handleJsEvent");
        r3.a("eventType", r9);
        r3.a("params", String.valueOf(r10));
        Unit r0 = Unit.INSTANCE;
        r1.d(r3.b());
    L6:
        int r11 = com.bytedance.android.live.messagewindow.business.card.a.a[r9.ordinal()];
        String r2 = "2";
        Object r5 = null;
        if (r11 != 1) goto L9;
        W(r10);
        i r12 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r12 == null) goto L51;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r4 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_destroy");
        r4.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        m1 r6 = this.D;
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
        r16.d("PortraitBottomRightCommonCard");
        StringBuilder r17 = new StringBuilder("handle js event: close card, card type: ");
        m1 r18 = this.D;
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
        W(r10);
        hide();
        i r20 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r20 == null) goto L72;
        CardAlogParamsBuilder r21 = new CardAlogParamsBuilder();
        r21.d("PortraitBottomRightCommonCard");
        StringBuilder r22 = new StringBuilder("handle js event: hide card, card type: ");
        m1 r23 = this.D;
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
        r112.d("PortraitBottomRightCommonCard");
        StringBuilder r26 = new StringBuilder("handle js event: show card, card type: ");
        m1 r27 = this.D;
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

    public final CardConstraint V(Integer r2, Integer r3, final Integer r4, final Integer r5) {
        if (mm0.b.a(r2) == false) goto L5;
    L15:
        int r6 = CardConstraint.h;
        CardConstraint r7 = new CardConstraint(new CardConstraint(((Number) this.u.getValue()).intValue(), ((Number) this.v.getValue()).intValue()));
    L16:
        r7.b(CardConstraint.Position.BottomRight);
        r7.a(new BottomRightCommonCard$commonCardConstraint$$inlined$apply$lambda$1(this, r4, r5));
        return r7;
    L5:
        if (mm0.b.a(r3) == true) goto L15;
        int r0 = CardConstraint.h;
        if (r2 == null) goto L10;
        int r8 = UtilityKotlinExtentionsKt.i(r2.intValue());
    L11:
        if (r3 == null) goto L13;
        int r9 = UtilityKotlinExtentionsKt.i(r3.intValue());
    L14:
        r7 = new CardConstraint(new CardConstraint(r8, r9));
        goto L16
    L13:
        r9 = ((Number) this.v.getValue()).intValue();
        goto L14
    L10:
        r8 = ((Number) this.u.getValue()).intValue();
        goto L11
    }

    public BottomRightCommonCard(m1 r2, DataCenter r3, int r4, int r5, Context r6, CommonCardInitScene r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "initScene");
        super(r3, Integer.valueOf(r4), r5);
        this.D = r2;
        this.E = r3;
        this.F = r6;
        this.G = null;
        this.H = r7;
        int r8 = s1.j(com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.a.a(Boolean.valueOf(a0.d(r3, false))));
        this.m = r8;
        this.n = r8 + s1.f(8.0f);
        this.u = LazyKt.lazy(BottomRightCommonCard$DEFAULT_CARD_CONTAINER_WIDTH$2.INSTANCE);
        this.v = LazyKt.lazy(BottomRightCommonCard$DEFAULT_CARD_CONTAINER_HEIGHT$2.INSTANCE);
        this.w = LazyKt.lazy(BottomRightCommonCard$DEFAULT_CARD_CONTAINER_RIGHT$2.INSTANCE);
        this.A = System.currentTimeMillis();
        this.B = -1;
    }
}
