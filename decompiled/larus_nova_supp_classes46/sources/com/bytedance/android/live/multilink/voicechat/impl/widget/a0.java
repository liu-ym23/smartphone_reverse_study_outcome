package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import zg1.p2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

    public a0(MultiLinkVoiceChatRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        jy0.b.d("[VoiceTalk]BaseLiveBackground", "widget, observeWindowDraw, put recover");
        ((Widget) this.a).dataCenter.put("cmd_voice_chat_room_show_background", new p2("recover"));
    }
}
