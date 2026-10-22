package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.MergeForwardContent;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements com.larksuite.framework.utils.y.a<MergeForwardContent.ChatterInfo, ChatterInfo> {
    public k() {
    }

    public final Object get(Object r3) {
        MergeForwardContent.ChatterInfo r4 = (MergeForwardContent.ChatterInfo) r3;
        ChatterInfo r0 = new ChatterInfo();
        r0.setId(r4.id);
        r0.setName(r4.name);
        r0.setAvatarKey(r4.avatar_key);
        r0.setAnonymous(r4.is_anonymous.booleanValue());
        Chatter.Type r5 = r4.type;
        if (r5 != Chatter.Type.USER) goto L6;
        r0.setType(com.ss.android.lark.chat.entity.chatter.Chatter.ChatterType.USER);
    L9:
        return r0;
    L6:
        if (r5 != Chatter.Type.AI) goto L8;
        r0.setType(com.ss.android.lark.chat.entity.chatter.Chatter.ChatterType.AI);
        goto L9
    L8:
        r0.setType(com.ss.android.lark.chat.entity.chatter.Chatter.ChatterType.BOT);
        goto L9
    }
}
