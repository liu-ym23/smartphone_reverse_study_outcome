package com.ss.android.lark.integrator.ccm.spacekit;

import com.bytedance.lark.pb.space.doc.v1.CreateDocFeedResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p implements SdkSender.IParser<ibb.a> {
    public p() {
    }

    public final Object parse(byte[] r2) throws IOException {
        return yb5.d.b(((CreateDocFeedResponse) CreateDocFeedResponse.ADAPTER.decode(r2)).entity);
    }
}
