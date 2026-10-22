package com.ss.android.lark.integrator.ccm.config.viewbinder;

import com.bytedance.lark.pb.space.doc.v1.UpdateDocPermissionResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements SdkSender.IParser<List<String>> {
    public h() {
    }

    public final Object parse(byte[] r2) throws IOException {
        return ((UpdateDocPermissionResponse) UpdateDocPermissionResponse.ADAPTER.decode(r2)).success_message_ids;
    }
}
