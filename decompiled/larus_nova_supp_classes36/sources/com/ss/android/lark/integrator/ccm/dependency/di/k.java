package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.lark.pb.space.doc.v1.RemoveDocResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements SdkSender.IParser<Boolean> {
    public k() {
    }

    public final Object parse(byte[] r2) throws IOException {
        RemoveDocResponse r3 = (RemoveDocResponse) RemoveDocResponse.ADAPTER.decode(r2);
        return Boolean.TRUE;
    }
}
