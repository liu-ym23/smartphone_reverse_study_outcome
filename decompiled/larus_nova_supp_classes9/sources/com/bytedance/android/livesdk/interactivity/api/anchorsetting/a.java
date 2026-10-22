package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.model.b b;

    public a(String r1, com.bytedance.android.livesdk.chatroom.model.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Response r5 = (Response) r4;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("update switch status success. " + this.a);
        com.bytedance.android.livesdk.chatroom.model.b r6 = this.b;
        if (r6 != null) goto L5;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = com.bytedance.android.livesdk.interactivity.api.asr.utils.e.a;
        com.bytedance.android.livesdk.chatroom.model.b r1 = new com.bytedance.android.livesdk.chatroom.model.b();
    L6:
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.chatroom.model.b> r2 = com.bytedance.android.livesdk.interactivity.api.asr.utils.e.b;
        if ((!Intrinsics.areEqual((com.bytedance.android.livesdk.chatroom.model.b) r2.getValue(), r1)) == false) goto L10;
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r6);
        xs2.b.a().post(com.bytedance.android.livesdk.interactivity.api.asr.utils.e.a());
        return;
    L10:
        return;
    L5:
        r1 = r6;
        goto L6
    }
}
