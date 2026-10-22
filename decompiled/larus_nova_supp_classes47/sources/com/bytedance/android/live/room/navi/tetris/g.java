package com.bytedance.android.live.room.navi.tetris;

import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.IMiddlewareMicRoomService;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import l81.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ AudienceRoomNavigatorTetris a;

    public g(AudienceRoomNavigatorTetris r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        Object r10 = sh6.c.b((sh6.b) r9);
        if (r10 == null) goto L22;
        IRoom r12 = (IRoom) r10;
        AudienceRoomNavigatorTetris r0 = this.a;
        WidgetElement r1 = r0.v;
        if (r1 == null) goto L7;
        r0.S(r1);
    L7:
        IMiddlewareMicRoomService r2 = (IMiddlewareMicRoomService) jc1.k.f(IMiddlewareMicRoomService.class);
        ViewGroup r4 = this.a.o;
        if (r4 == null) goto L23;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.isMicRoom(r12) == false) goto L25;
        AudienceRoomNavigatorTetris r13 = this.a;
        INavigationProxyService r3 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r3 == null) goto L19;
        o r5 = r3.getMicRoomService();
        if (r5 == null) goto L19;
        Class<? extends LiveRecyclableWidget> r6 = r5.getMicRoomOfficialInfoWidget();
        if (r6 == null) goto L19;
        WidgetElement r7 = LiveTetris.Q(this.a, r6, r4, false, null, 24);
    L20:
        r13.v = r7;
        return;
    L19:
        r7 = null;
        goto L20
    L25:
        return;
    L23:
        return;
    }
}
