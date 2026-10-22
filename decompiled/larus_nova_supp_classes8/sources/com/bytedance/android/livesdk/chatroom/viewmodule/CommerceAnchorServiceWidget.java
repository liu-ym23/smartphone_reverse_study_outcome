package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.q4;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdkapi.shopping.LiveShoppingMessageHelper;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/CommerceAnchorServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lvlc/l;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommerceAnchorServiceWidget extends RoomRecyclableWidget implements vlc.l {
    public vlc.d a;
    public js2.a b;

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        vlc.d r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public CommerceAnchorServiceWidget() {
    }

    public final void onLoad(Object[] r3) {
        this.b = new js2.a(((Widget) this).dataCenter);
        vlc.d r4 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        this.a = r4;
        if (r4 == null) goto L6;
        r4.addMessageListener(BubbleId.Share, this);
        return;
    }

    public final void onMessage(tlc.d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = r3.getIntType();
        if (1001 <= r0) goto L8;
        return;
    L8:
        if (2000 < r0) goto L18;
        Integer r4 = LiveShoppingMessageHelper.INSTANCE.getMessageType(r3);
        if (r4 == null) goto L19;
        int r5 = r4.intValue();
        js2.a r1 = this.b;
        if (r1 == null) goto L15;
        r1.a(r5);
    L15:
        if (r5 != 10) goto L20;
        com.bytedance.android.livesdk.business.douplus.h.g(true, ((Widget) this).dataCenter);
        int r6 = q4.e;
        q4.a.b(((Widget) this).dataCenter);
        return;
    L20:
        return;
    L19:
        return;
    }
}
