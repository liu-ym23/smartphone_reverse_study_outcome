package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ InteractivityContext a;
    public final /* synthetic */ RoomContext b;

    public f(InteractivityContext r1, RoomContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.model.b r4 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.model.b) ((BaseResponse) ((Response) r3)).data;
        if (r4 == null) goto L6;
        int r0 = h.a;
        h.b(r4, this.a, this.b);
        return;
    }
}
