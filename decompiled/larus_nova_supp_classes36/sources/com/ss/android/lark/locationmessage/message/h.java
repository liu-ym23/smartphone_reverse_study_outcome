package com.ss.android.lark.locationmessage.message;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.LocationContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements v5b.b<LocationContentVO> {
    public h() {
    }

    public final MessageType a() {
        return MessageType.LOCATION;
    }

    public final CharSequence b(p5b.c r3) {
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        return UIHelper.mustacheFormat(2131890400, "title", r3.getMessage().getContent().getName());
    }

    public final v5b.a c(p5b.c r4) {
        Intrinsics.checkNotNullParameter(r4, "messageInfo");
        LocationContent r0 = r4.getMessage().getContent();
        Message r5 = r4.getMessage();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.Message");
        return new LocationContentVO(r0, r5);
    }
}
