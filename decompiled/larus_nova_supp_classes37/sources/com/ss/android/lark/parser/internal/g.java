package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.Channel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public static Channel a(com.bytedance.lark.pb.basic.v1.Channel r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new Channel(r2.type.getValue(), r2.id);
    }

    public static com.bytedance.lark.pb.basic.v1.Channel b(Channel r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new com.bytedance.lark.pb.basic.v1.Channel.Builder().id(r2.getId()).type(com.bytedance.lark.pb.basic.v1.Channel.Type.fromValue(r2.getType().getNumber())).build();
    }
}
