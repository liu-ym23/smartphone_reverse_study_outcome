package com.ss.android.lark.download.service.impl;

import com.bytedance.lark.pb.media.v1.DownloadFileResponse;
import com.ss.android.lark.sdk.SdkSender;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements SdkSender.IParser<wbb.d.b> {
    public g() {
    }

    public final Object parse(byte[] r3) throws IOException {
        DownloadFileResponse r4 = (DownloadFileResponse) DownloadFileResponse.ADAPTER.decode(r3);
        if (r4 != null) goto L5;
        String r5 = BuildConfig.FLAVOR;
    L7:
        return new wbb.d.b(r5, false);
    L5:
        r5 = r4.path;
        goto L7
    }
}
