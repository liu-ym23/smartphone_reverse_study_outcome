package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.model.interact.x;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ VideoTalkRoomApplyCancelDialog a;

    public j(VideoTalkRoomApplyCancelDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
        Intrinsics.checkNotNullParameter(r5, "response");
        VideoTalkRoomApplyCancelDialog r0 = this.a;
        x r6 = (x) r5.data;
        int r1 = VideoTalkRoomApplyCancelDialog.e;
        ((FrameLayout) r0.findViewById(2131377420)).setVisibility(0);
        ((TextView) r0.findViewById(2131391713)).setText(r6.getPrompt());
    }
}
