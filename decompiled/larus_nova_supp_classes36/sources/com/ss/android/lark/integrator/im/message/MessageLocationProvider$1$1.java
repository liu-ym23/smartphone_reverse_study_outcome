package com.ss.android.lark.integrator.im.message;

import com.bytedance.lark.pb.basic.v1.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.LocationContent;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MessageLocationProvider$1$1 {
    public MessageLocationProvider$1$1() {
    }

    public final void a(String r3, String r4, String r5, Message.PartialReplyInfo r6, LocationContent r7, final String r8, int r9, int r10) {
        p r0 = ImSdkService.f();
        b2b.a.a r1 = new b2b.a.a();
        ((MessageParams.a) r1).c = r3;
        ((MessageParams.a) r1).a = r4;
        ((MessageParams.a) r1).b = r5;
        ((MessageParams.a) r1).s = r6;
        r1.A = r7;
        r1.B = r8;
        r1.C = r9;
        r1.D = r10;
        ((MessageParams.a) r1).h = com.ss.android.lark.chat.entity.message.Message.Type.LOCATION;
        r0.sendMessage(new b2b.a(r1), new AnonymousClass1(this, r8));
    }
}
