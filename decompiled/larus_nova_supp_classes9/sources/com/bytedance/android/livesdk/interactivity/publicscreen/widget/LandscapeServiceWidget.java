package com.bytedance.android.livesdk.interactivity.publicscreen.widget;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.publicscreen.framework.PublicScreenBaseWidget;
import com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/widget/LandscapeServiceWidget;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/framework/PublicScreenBaseWidget;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeServiceWidget extends PublicScreenBaseWidget {
    public s42.a f;

    public final void onInit(Object[] r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.framework.PublicScreenBaseWidget
    public final void onUnload() {
        super.onUnload();
        s42.a r0 = this.f;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    public LandscapeServiceWidget() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.framework.PublicScreenBaseWidget
    public final void onLoad(Object[] r7) {
        super.onLoad(r7);
        DataCenter r8 = ((Widget) this).dataCenter;
        Object r0 = null;
        if (r8 == null) goto L14;
        Object r2 = r8.get("data_room_text_message_presenter", null);
        if ((r2 instanceof s42.a) == true) goto L7;
        r2 = null;
    L7:
        s42.a r3 = (s42.a) r2;
        if (r3 != null) goto L10;
        TransTextMessagePresenter r4 = wq();
        this.f = r4;
        r8.put("data_room_text_message_presenter", r4);
    L11:
        s42.a r1 = this.f;
        if (r1 == null) goto L14;
        r1.W(r8);
        goto L14
    L10:
        this.f = r3;
    L14:
        boolean r9 = TextMessageTracer.a;
        TextMessageTracer.A("LandscapeServiceWidget create config, config is " + xq());
        if (com.bytedance.android.livesdk.utils.landscape.f.a() == true) goto L23;
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L19;
        Boolean r11 = (Boolean) r10.get("data_longer_video_within_live_type", Boolean.FALSE);
    L21:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == true) goto L23;
    L49:
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L52;
        Boolean r14 = (Boolean) r13.get("data_longer_video_within_live_type", Boolean.FALSE);
    L54:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == true) goto L56;
    L60:
        q92.a r15 = xq();
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L69;
        Object r6 = r5.get("data_is_anchor", null);
        if ((r6 instanceof Boolean) == false) goto L66;
        r0 = r6;
    L66:
        Boolean r16 = (Boolean) r0;
        if (r16 == null) goto L69;
        boolean r17 = r16.booleanValue();
    L70:
        r15.m = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q.a(r15, false, r17);
        return;
    L69:
        r17 = false;
        goto L70
    L56:
        if (dm2.b.a.c() == false) goto L60;
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 == null) goto L60;
        r18.put("cmd_landscape_text_message_widget_loaded", new Object());
        goto L60
    L52:
        r14 = null;
        goto L54
    L19:
        r11 = null;
    L23:
        if (getRoomContext() == null) goto L49;
        com.bytedance.android.livesdk.interactivity.api.h r19 = com.bytedance.android.livesdk.interactivity.api.i.a(getRoomContext(), ((Widget) this).dataCenter);
        if (r19 == null) goto L29;
        com.bytedance.live.datacontext.j<r42.h> r20 = r19.getHistoryDataManager();
        if (r20 == null) goto L29;
        r42.h r21 = (r42.h) r20.getValue();
    L30:
        if (r21 != null) goto L49;
        IRoomContextService r23 = jc1.k.f(IRoomContextService.class);
        if (r23 == null) goto L39;
        com.bytedance.android.livesdk.chatroom.o r24 = IRoomContextService.a.a(r23, ((Widget) this).dataCenter, 0, 2);
        if (r24 == null) goto L39;
        com.bytedance.live.datacontext.m r25 = r24.getRoom();
        if (r25 == null) goto L39;
        IRoom r26 = (IRoom) r25.getValue();
    L41:
        if (r42.g.c() == false) goto L43;
        r42.i r27 = new r42.m(r26);
    L44:
        r42.h r28 = new r42.h(r27);
        com.bytedance.android.livesdk.interactivity.api.h r29 = com.bytedance.android.livesdk.interactivity.api.i.a(getRoomContext(), ((Widget) this).dataCenter);
        if (r29 == null) goto L49;
        com.bytedance.live.datacontext.j<r42.h> r30 = r29.getHistoryDataManager();
        if (r30 == null) goto L49;
        r30.d(r28);
        goto L49
    L43:
        r27 = new r42.k(r26);
    L39:
        r26 = null;
    L29:
        r21 = null;
        goto L30
    }
}
