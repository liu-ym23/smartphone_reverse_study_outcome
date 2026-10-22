package com.bytedance.android.live.liveinteract.videotalk;

import android.content.Context;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.model.e1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ String d;

    public m(long r1, MultiLinkVideoTalkRoomAnchorWidget r3, Ref.ObjectRef r4, String r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final void accept(Object r9) {
        com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
        Intrinsics.checkNotNullParameter(r10, "response");
        int r0 = nd0.g.a;
        nd0.g.d(this.a, r10);
        Ref.ObjectRef r1 = this.c;
        r1.element = ((e1) r10.data).getInteractItems();
        MultiLinkVideoTalkRoomAnchorWidget r11 = this.b;
        DataCenter r2 = ((Widget) r11).dataCenter;
        IRoom r3 = r11.getMRoom();
        if (r3 == null) goto L5;
        Long r4 = Long.valueOf(r3.getRoomId());
    L6:
        long r5 = r4.longValue();
        Intrinsics.checkNotNullParameter(r11, "$this$multiLinkContext");
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        com.bytedance.android.livesdk.chatroom.u r12 = jc1.k.n(IRoomContextService.class).getRoomMultiLinkService(r2, r5);
        if (r12 == null) goto L11;
        com.bytedance.live.datacontext.n r13 = r12.l();
        if (r13 == null) goto L11;
        r13.setValue((List) this.c.element);
    L11:
        ILinkPanelService r6 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r6 == null) goto L15;
        Context r7 = this.b.getContext();
        MultiLinkVideoTalkRoomAnchorWidget r14 = this.b;
        r6.uO(r7, ((Widget) r14).dataCenter, r14.getMRoom(), (List) this.c.element, this.d, this.b);
        return;
    L15:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
