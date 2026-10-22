package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.livesdk.utils.r2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements MediaOperation.a {
    public k() {
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation.a
    public final void onSuccess() {
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation.a
    public final void onError(Throwable r3) {
        if ((r3 instanceof ApiServerException) == false) goto L10;
        ApiServerException r4 = (ApiServerException) r3;
        if (r2.a(r4.getPrompt()) == true) goto L7;
        return;
    L7:
        if (r4.getErrorCode() != 4004468) goto L12;
        f2.c(r4.getPrompt(), 0);
        return;
    L12:
        return;
    }
}
