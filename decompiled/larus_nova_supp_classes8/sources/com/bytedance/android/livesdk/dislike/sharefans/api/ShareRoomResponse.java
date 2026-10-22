package com.bytedance.android.livesdk.dislike.sharefans.api;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@ProtoMessage("webcast.api.distribution.ShareRoomResponse")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/sharefans/api/ShareRoomResponse;", "", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareRoomResponse implements h {
    public ShareRoomResponse() {
    }

    public ShareRoomResponse(g r5) {
        long r0 = r5.c();
    L4:
        if (r5.f() == (-1)) goto L6;
        am3.h.e(r5);
        goto L4
    L6:
        r5.d(r0);
    }
}
