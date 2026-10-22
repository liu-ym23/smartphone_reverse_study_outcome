package com.bytedance.android.live.messagewindow.preview.widget;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.messagewindow.framework.context.CardContext;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.ICardInnerService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomEx;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import d71.b;
import d71.e;
import h71.d;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import z61.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/messagewindow/preview/widget/PreviewMsgWinTopLeftWidget;", "Lcom/bytedance/android/live/messagewindow/preview/widget/PreviewMsgWinCommonWidget;", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewMsgWinTopLeftWidget extends PreviewMsgWinCommonWidget {
    public final String d;
    public final MsgWindowPosition e;
    public ConstraintLayout f;
    public d g;
    public final com.bytedance.android.live.messagewindow.business.util.a h;

    public static final class a implements com.bytedance.android.live.messagewindow.business.util.a.InterfaceC0127a {
        public a() {
        }

        @Override // com.bytedance.android.live.messagewindow.business.util.a.InterfaceC0127a
        public final WidgetElement a(Class<? extends Widget> r1, ViewGroup r2, boolean r3, Object[] r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r1, "widgetClass");
            Intrinsics.checkNotNullParameter(r2, "elementView");
            return null;
        }
    }

    public final int getLayoutId() {
        return 2131567781;
    }

    public PreviewMsgWinTopLeftWidget() {
        this.d = "PreviewMsgWinTopLeftWidget";
        this.e = MsgWindowPosition.TOP_LEFT;
        this.h = new com.bytedance.android.live.messagewindow.business.util.a(new a());
        new CompositeDisposable();
    }

    public final void onUnload() {
        zq();
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.preview.widget.PreviewMsgWinCommonWidget
    public final com.bytedance.android.live.messagewindow.business.util.a xq() {
        return this.h;
    }

    @Override // com.bytedance.android.live.messagewindow.preview.widget.PreviewMsgWinCommonWidget
    public final String yq() {
        return this.d;
    }

    public final void onInit(Object[] r2) {
        ConstraintLayout r3 = ((Widget) this).contentView;
        if (r3 == null) goto L7;
        this.f = r3;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    public final void onLoad(Object[] r8) {
        MiddlewareRoomContext r9 = getMiddlewareRoomContext();
        if (r9 == null) goto L9;
        Intrinsics.checkNotNullParameter(r9, "$this$getRoomDataCtxExt");
        o r10 = z51.a.g(r9);
        if (r10 == null) goto L9;
        Map r11 = r10.F2();
        if (r11 == null) goto L9;
        String r12 = (String) r11.put("onCreate", "1");
    L9:
        DataCenter r13 = ((Widget) this).dataCenter;
        Integer r0 = null;
        if (r13 == null) goto L26;
        IRoomEx r1 = a0.a;
        Object r14 = r13.get("data_room", null);
        if ((r14 instanceof IRoom) == true) goto L14;
        r14 = null;
    L14:
        IRoomEx r15 = (IRoom) r14;
        if (r15 == null) goto L18;
        r1 = r15;
    L18:
        if (r1 == null) goto L26;
        long r2 = r1.getId();
        MiddlewareRoomContext r16 = getMiddlewareRoomContext();
        if (r16 == null) goto L26;
        Intrinsics.checkNotNullParameter(r16, "$this$getExpRoomServiceExt");
        r r17 = z51.a.d(r16);
        if (r17 == null) goto L26;
        n r18 = r17.M();
        if (r18 == null) goto L26;
        r18.setValue(new Pair(Long.valueOf(r2), this));
    L26:
        ConstraintLayout r19 = this.f;
        if (r19 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L29:
        ViewGroup r20 = (ViewGroup) r19.findViewById(2131365163);
        if (r20 == null) goto L32;
        d r3 = k.n(ICardInnerService.class).createMsgWindowPositionAdjuster(r20);
        r3.load();
        Unit r4 = Unit.INSTANCE;
        this.g = r3;
    L33:
        this.c = r20;
        CardContext r21 = wq();
        if (r21 == null) goto L36;
        r21.provideWindowContainer(this.e, this);
    L36:
        CardContext r22 = wq();
        if (r22 == null) goto L66;
        d71.d<v61.a, b> r23 = r22.recordManager(MsgWindowPosition.TOP_LEFT);
        if (r23 == null) goto L66;
        Collection r24 = r23.o();
        if (r24 == null) goto L66;
        Iterator r25 = r24.iterator();
    L44:
        if (r25.hasNext() == false) goto L66;
        b r5 = (b) r25.next();
        CardContext r6 = wq();
        if (r6 == null) goto L56;
        i r7 = r6.getMonitor();
        if (r7 == null) goto L56;
        CardAlogParamsBuilder r26 = new CardAlogParamsBuilder();
        r26.d(this.d);
        StringBuilder r27 = new StringBuilder("temporary card show, ");
        if (r5 == null) goto L54;
        v61.a r28 = ((e) r5).b;
        if (r28 == null) goto L54;
        Object r29 = r28.j;
    L55:
        r27.append(r29);
        r26.c(r27.toString());
        Unit r30 = Unit.INSTANCE;
        r7.d(r26.b());
    L54:
        r29 = null;
    L56:
        CardContext r31 = wq();
        if (r31 == null) goto L61;
        e71.a r32 = r31.getMsgManager();
        if (r32 == null) goto L61;
        r32.show(((e) r5).b);
    L61:
        CardContext r33 = wq();
        if (r33 == null) goto L44;
        d71.d<v61.a, b> r34 = r33.recordManager(MsgWindowPosition.TOP_LEFT);
        if (r34 == null) goto L44;
        r34.e(((e) r5).b);
    L66:
        i r35 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r35 != null) goto L69;
    L73:
        xs2.b r36 = xs2.b.a();
        MiddlewareRoomContext r37 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r37 == null) goto L78;
        m r38 = r37.getReportScreenOrientation();
        if (r38 == null) goto L78;
        r0 = (Integer) r38.getValue();
    L78:
        r36.post(new c(r0));
        return;
    L69:
        if (((MiddlewareRoomRecyclableWidget) this).dataContext == null) goto L71;
        o r39 = IRoomContextService.a.a(k.n(IRoomContextService.class), ((Widget) this).dataCenter, 0, 2);
    L72:
        r35.a(r39);
        goto L73
    L71:
        r39 = null;
        goto L72
    L32:
        r20 = null;
        goto L33
    }
}
