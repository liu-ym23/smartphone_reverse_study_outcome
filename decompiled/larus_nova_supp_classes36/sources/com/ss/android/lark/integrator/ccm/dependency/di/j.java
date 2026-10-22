package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.lark.pb.space.doc.v1.UpdateDocMeReadResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements SdkSender.IParser<Boolean> {
    public j() {
    }

    public final Object parse(byte[] r2) throws IOException {
        UpdateDocMeReadResponse r3 = (UpdateDocMeReadResponse) UpdateDocMeReadResponse.ADAPTER.decode(r2);
        return Boolean.TRUE;
    }
}
