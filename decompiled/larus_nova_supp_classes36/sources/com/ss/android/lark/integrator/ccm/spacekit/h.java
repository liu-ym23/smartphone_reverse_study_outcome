package com.ss.android.lark.integrator.ccm.spacekit;

import com.bytedance.lark.pb.space.doc.v1.MGetDocFeedsResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements SdkSender.IParser<ibb.a> {
    public h() {
    }

    public final Object parse(byte[] r2) throws IOException {
        return yb5.d.b(((MGetDocFeedsResponse) MGetDocFeedsResponse.ADAPTER.decode(r2)).entity);
    }
}
