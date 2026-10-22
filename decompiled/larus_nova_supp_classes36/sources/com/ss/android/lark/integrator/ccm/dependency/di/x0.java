package com.ss.android.lark.integrator.ccm.dependency.di;

import com.ss.android.lark.dto.chat.ChatLinkTokenResponse;
import com.ss.android.lark.pb.chats.PullChatLinkTokenResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x0<T> implements SdkSender.IParser {
    public static final x0<T> a = null;

    static {
        a = new x0();
    }

    public x0() {
    }

    public final Object parse(byte[] r9) {
        PullChatLinkTokenResponse r10 = (PullChatLinkTokenResponse) PullChatLinkTokenResponse.ADAPTER.decode(r9);
        return new ChatLinkTokenResponse(r10.mtoken, r10.mshared_url, r10.mkouLing, r10.mexpire_time.longValue(), r10.mis_unlimited.booleanValue());
    }
}
