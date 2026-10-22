package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.pb.graph.PullClosestChattersResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f<T> implements SdkSender.IParser {
    public static final f<T> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object parse(byte[] r2) {
        return (PullClosestChattersResponse) PullClosestChattersResponse.ADAPTER.decode(r2);
    }
}
