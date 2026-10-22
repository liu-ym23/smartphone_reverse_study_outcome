package com.bytedance.android.live.messagewindow.business.tetris;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer;
import com.bytedance.android.live.messagewindow.framework.context.CardContext;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.ICardInnerService;
import com.bytedance.android.live.room.api.panel.PanelCoverListener;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.live.room.api.panel.e;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import d90.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t70.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/messagewindow/business/tetris/MsgWindowCardTetris;", "Lcom/bytedance/android/live/messagewindow/framework/container/AbsMsgWindowContainer;", "Ld90/d;", "Lcom/bytedance/android/livesdkapi/depend/handler/WeakHandler$IHandler;", "Lo70/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MsgWindowCardTetris extends AbsMsgWindowContainer<d> implements WeakHandler.IHandler, o70.a {
    public static final /* synthetic */ int y = 0;
    public final String r;
    public final MsgWindowPosition s;
    public ConstraintLayout t;
    public final WeakHandler u;
    public h71.d v;
    public final com.bytedance.android.live.messagewindow.business.util.a w;
    public final c x;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.messagewindow.business.util.a.InterfaceC0127a {
        public final /* synthetic */ MsgWindowCardTetris a;

        public b(MsgWindowCardTetris r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.messagewindow.business.util.a.InterfaceC0127a
        public final WidgetElement a(Class<? extends Widget> r8, ViewGroup r9, boolean r10, Object[] r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r8, "widgetClass");
            Intrinsics.checkNotNullParameter(r9, "elementView");
            return this.a.P(r8, r9, r10, r11, r12);
        }
    }

    public static final class c extends PanelCoverListener {
        public final /* synthetic */ MsgWindowCardTetris c;

        public final String getName() {
            return "MsgWindowCardTetris";
        }

        public final View d() {
            MsgWindowCardTetris r0 = this.c;
            int r1 = MsgWindowCardTetris.y;
            return r0.q;
        }

        public c(MsgWindowCardTetris r1) {
            this.c = r1;
        }

        public final boolean e(e r2) {
            Intrinsics.checkNotNullParameter(r2, "panelInfo");
            if (r2.a == PanelName.RightCard) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
    }

    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(z61.b.class);
    }

    public MsgWindowCardTetris() {
        this.r = "MsgWindowCardTetris";
        this.s = MsgWindowPosition.BOTTOM_RIGHT;
        this.u = new WeakHandler(Looper.getMainLooper(), this);
        this.w = new com.bytedance.android.live.messagewindow.business.util.a(new b(this));
        this.x = new c(this);
    }

    public final void O() {
        DataCenter r0 = K().h;
        if (r0 == null) goto L11;
        IRoom r1 = lu2.c.f(r0);
        if (r1 == null) goto L11;
        long r2 = r1.getId();
        r r3 = z51.a.e(K().h);
        if (r3 == null) goto L11;
        n r4 = r3.M();
        if (r4 == null) goto L11;
        r4.setValue(new Pair(Long.valueOf(r2), this));
    L11:
        CardContext r5 = V();
        if (r5 == null) goto L14;
        r5.provideWindowContainer(this.s, this);
    L14:
        CardContext r6 = V();
        Integer r7 = null;
        if (r6 == null) goto L44;
        d71.d<v61.a, d71.b> r8 = r6.recordManager(MsgWindowPosition.BOTTOM_RIGHT);
        if (r8 == null) goto L44;
        Collection r9 = r8.o();
        if (r9 == null) goto L44;
        Iterator r10 = r9.iterator();
    L22:
        if (r10.hasNext() == false) goto L44;
        d71.b r11 = (d71.b) r10.next();
        CardContext r12 = V();
        if (r12 == null) goto L34;
        i r13 = r12.getMonitor();
        if (r13 == null) goto L34;
        CardAlogParamsBuilder r14 = new CardAlogParamsBuilder();
        r14.d(this.r);
        StringBuilder r15 = new StringBuilder("temporary card show, ");
        if (r11 == null) goto L32;
        v61.a r16 = ((d71.e) r11).b;
        if (r16 == null) goto L32;
        Object r17 = r16.j;
    L33:
        r15.append(r17);
        r14.c(r15.toString());
        Unit r18 = Unit.INSTANCE;
        r13.d(r14.b());
    L32:
        r17 = null;
    L34:
        CardContext r19 = V();
        if (r19 == null) goto L39;
        e71.a r20 = r19.getMsgManager();
        if (r20 == null) goto L39;
        r20.show(((d71.e) r11).b);
    L39:
        CardContext r21 = V();
        if (r21 == null) goto L22;
        d71.d<v61.a, d71.b> r22 = r21.recordManager(MsgWindowPosition.BOTTOM_RIGHT);
        if (r22 == null) goto L22;
        r22.e(((d71.e) r11).b);
    L44:
        i r23 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r23 == null) goto L47;
        o r24 = z51.a.h(K().h, 2);
        DataCenter r25 = K().h;
        r23.a(r24);
    L47:
        xs2.b r26 = xs2.b.a();
        o r27 = z51.a.h(K().h, 2);
        if (r27 == null) goto L52;
        m r28 = r27.v2();
        if (r28 == null) goto L52;
        r7 = (Integer) r28.getValue();
    L52:
        r26.post(new z61.c(r7));
        List<Class<? extends o70.b>> r29 = Mg();
        if (r29 == null) goto L58;
        Iterator<T> r30 = r29.iterator();
    L56:
        if (r30.hasNext() == false) goto L67;
        T((Class) r30.next(), new MsgWindowCardTetris$onViewCreated$3$1(this));
        goto L56
    L67:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer
    public final DataCenter Z() {
        return K().h;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer
    public final void b0() {
        super.b0();
        CardContext r0 = V();
        if (r0 == null) goto L7;
        d71.d<v61.a, d71.b> r1 = r0.recordManager(MsgWindowPosition.BOTTOM_RIGHT);
        if (r1 == null) goto L7;
        r1.b();
    L7:
        this.u.removeMessages(1001);
        this.u.removeMessages(1002);
        this.u.removeMessages(1003);
        this.u.removeMessages(1004);
        h71.d r2 = this.v;
        if (r2 == null) goto L14;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L11:
        if (r2 == null) goto L15;
        r2.unload();
        return;
    L15:
        return;
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onDestroy();
        b0();
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L5;
        r0.c();
    L5:
        int r1 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r2 = com.bytedance.android.live.room.api.panel.d.c(K().h, 2);
        if (r2 == null) goto L9;
        r2.unregisterPanelListener(this.x);
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer
    public final com.bytedance.android.live.messagewindow.business.util.a W() {
        return this.w;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer
    public final String a0() {
        return this.r;
    }

    public final View G(k r6) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        o r0 = z51.a.h(K().h, 2);
        if (r0 == null) goto L7;
        Map r1 = r0.F2();
        if (r1 == null) goto L7;
        String r2 = (String) r1.put("onCreate", "1");
    L7:
        DataCenter r3 = K().h;
        if (r3 == null) goto L16;
        IRoom r4 = a0.n(r3);
        if (r4 == null) goto L16;
        long r5 = r4.getId();
        r r7 = z51.a.e(K().h);
        if (r7 == null) goto L16;
        n r8 = r7.M();
        if (r8 == null) goto L16;
        r8.setValue(new Pair(Long.valueOf(r5), this));
    L16:
        ConstraintLayout r9 = r6.b(2131567781);
        if (r9 == null) goto L32;
        ConstraintLayout r10 = r9;
        this.t = r10;
        ViewGroup r11 = (ViewGroup) r10.findViewById(2131365163);
        if (r11 == null) goto L21;
        h71.d r12 = jc1.k.n(ICardInnerService.class).createMsgWindowPositionAdjuster(r11);
        r12.load();
        Unit r13 = Unit.INSTANCE;
        this.v = r12;
    L22:
        this.q = r11;
        if (d90.e.h(K()) == false) goto L27;
        int r14 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r15 = com.bytedance.android.live.room.api.panel.d.c(K().h, 2);
        if (r15 == null) goto L27;
        r15.registerPanelListener(this.x);
    L27:
        ConstraintLayout r16 = this.t;
        if (r16 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L30:
        return r16;
    L21:
        r11 = null;
        goto L22
    L32:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    public final void handleMsg(Message r4) {
        if (r4 == null) goto L4;
        Integer r5 = Integer.valueOf(r4.what);
    L6:
        if (r5 != null) goto L9;
    L14:
        if (r5 != null) goto L17;
    L22:
        if (r5 != null) goto L25;
    L30:
        if (r5 != null) goto L33;
    L38:
        if (r5 != null) goto L41;
        return;
    L41:
        if (r5.intValue() != 1005) goto L51;
        h71.d r6 = this.v;
        if (r6 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L45:
        r6.d();
        return;
    L51:
        return;
    L33:
        if (r5.intValue() != 1004) goto L38;
        h71.d r7 = this.v;
        if (r7 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L37:
        r7.e();
        return;
    L25:
        if (r5.intValue() != 1003) goto L30;
        h71.d r8 = this.v;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L29:
        r8.b();
        return;
    L17:
        if (r5.intValue() != 1001) goto L22;
        h71.d r9 = this.v;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L21:
        r9.c();
        return;
    L9:
        if (r5.intValue() != 1002) goto L14;
        h71.d r10 = this.v;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L13:
        r10.a();
        return;
    L4:
        r5 = null;
        goto L6
    }

    public void onEvent(o70.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof z61.b) == false) goto L31;
        z61.b r4 = (z61.b) r3;
        if (r4.e.a == true) goto L11;
        if (this.u.hasMessages(1005) == true) goto L11;
        this.u.sendEmptyMessage(1005);
        return;
    L11:
        if (r4.b == false) goto L16;
        if (this.u.hasMessages(1002) == true) goto L16;
        this.u.sendEmptyMessage(1002);
    L16:
        if (r4.a == false) goto L21;
        if (this.u.hasMessages(1001) == true) goto L21;
        this.u.sendEmptyMessage(1001);
    L21:
        if (r4.c == false) goto L26;
        if (this.u.hasMessages(1003) == true) goto L26;
        this.u.sendEmptyMessage(1003);
    L26:
        if (r4.d == true) goto L28;
        return;
    L28:
        if (this.u.hasMessages(1004) == true) goto L33;
        this.u.sendEmptyMessage(1004);
        return;
    L33:
        return;
    }
}
