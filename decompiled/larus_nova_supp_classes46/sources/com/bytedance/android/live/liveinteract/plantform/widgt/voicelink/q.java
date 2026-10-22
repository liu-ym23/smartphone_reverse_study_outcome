package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceGuestContainerWidget a;

    public q(MultiLinkVoiceGuestContainerWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        com.bytedance.android.livesdk.chatroom.viewmodel.i r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r5;
        Intrinsics.checkNotNullParameter(r6, "switchSceneEvent");
        MultiLinkVoiceGuestContainerWidget r0 = this.a;
        int r1 = r0.c;
        int r2 = r6.a;
        if (r1 == r2) goto L5;
    L7:
        r0.c = r2;
        r0.d = r6.b;
        Lazy r3 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) r0).dataCenter, "voiceGuestContainerWidget", "call onVoiceChatRoomSubSceneChange, scene = " + r6.a + ", uiLayout = " + r6.b);
        r0.zq(r6.a, r6.b, MultiLinkOpenSource.DEFAULT);
        return;
    L5:
        if (r0.d != r6.b) goto L7;
    }
}
