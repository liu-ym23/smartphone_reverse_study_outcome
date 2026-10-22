package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.lark.pb.space.doc.v1.UpdateDocMessageBadgeResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements SdkSender.IParser<Boolean> {
    public l() {
    }

    public final Object parse(byte[] r2) throws IOException {
        UpdateDocMessageBadgeResponse r3 = (UpdateDocMessageBadgeResponse) UpdateDocMessageBadgeResponse.ADAPTER.decode(r2);
        return Boolean.TRUE;
    }
}
