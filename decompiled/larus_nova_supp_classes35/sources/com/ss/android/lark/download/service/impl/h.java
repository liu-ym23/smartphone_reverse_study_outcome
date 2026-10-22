package com.ss.android.lark.download.service.impl;

import com.bytedance.lark.pb.media.v1.GetFileStateResponse;
import com.ss.android.lark.download.service.FileState;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements SdkSender.IParser<FileState> {
    public h() {
    }

    public final Object parse(byte[] r2) throws IOException {
        return FileState.forNumber(((GetFileStateResponse) GetFileStateResponse.ADAPTER.decode(r2)).state.getValue());
    }
}
