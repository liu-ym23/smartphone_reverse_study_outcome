package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IAudienceRecommendRoomResponse;
import com.bytedance.android.livesdk.chatroom.model.LinkmicAudienceRecommendItem;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ LinkResultDialogFragmentV2 a;

    public r(LinkResultDialogFragmentV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        LinkResultDialogFragmentV2 r0 = this.a;
        if (r3 == null) goto L7;
        IAudienceRecommendRoomResponse r4 = (IAudienceRecommendRoomResponse) r3.data;
        if (r4 == null) goto L7;
        LinkmicAudienceRecommendItem r5 = r4.getLinkmicAudienceRecommendItem();
    L8:
        LinkResultDialogFragmentV2.U90(r0, r5);
        return;
    L7:
        r5 = null;
        goto L8
    }
}
