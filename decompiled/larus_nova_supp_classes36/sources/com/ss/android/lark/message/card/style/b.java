package com.ss.android.lark.message.card.style;

import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements SdkSender.IParser<UserSendHttpResponse> {
    public b() {
    }

    public final Object parse(byte[] r2) throws IOException {
        return (UserSendHttpResponse) UserSendHttpResponse.ADAPTER.decode(r2);
    }
}
