package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.ShareReportResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements sy.a {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final void invoke(Object r6) {
        Response r7 = (Response) r6;
        if (r7 == null) goto L5;
        ShareReportResult r0 = (ShareReportResult) ((BaseResponse) r7).data;
    L6:
        if (r0 == null) goto L15;
        ShareReportResult r1 = (ShareReportResult) ((BaseResponse) r7).data;
        if (r1 == null) goto L10;
        long r3 = r1.getDeltaIntimacy();
    L12:
        if (r3 <= 0) goto L16;
        xs2.b.a().post(new b30.e((ShareReportResult) ((BaseResponse) r7).data));
        return;
    L16:
        return;
    L10:
        r3 = 0;
        goto L12
    L15:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
