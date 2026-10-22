package com.ss.android.lark.im.sdk.statistics;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.statistics.Statistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ Chat a;
    public final /* synthetic */ ChatChatter b;
    public final /* synthetic */ Message c;
    public final /* synthetic */ Message d;

    public d(Chat r1, ChatChatter r2, Message r3, Message r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        Map<String, String> r0 = b.a;
        Chat r1 = this.a;
        ChatChatter r2 = this.b;
        Message r3 = this.c;
        Message r4 = this.d;
        if (r3 == null) goto L29;
        if (r4 == null) goto L30;
        if (r1 != null) goto L11;
        r1 = ChatService.c.a.getLocalChat(r3.getChatId());
        if (r1 != null) goto L11;
        return;
    L11:
        if (r2 == null) goto L13;
    L19:
        int r5 = r3.getPosition();
        int r6 = r4.getPosition();
        String r7 = INotificationHitPoint.NoticeType.OTHER;
        if (r5 != r6) goto L22;
        String r8 = "first";
    L23:
        String r9 = (String) ((HashMap) b.a).get(r4.getType().toString());
        if (r9 == null) goto L27;
        r7 = r9;
    L27:
        b.C0088b.a r10 = new b.C0088b.a();
        String r11 = r4.getId();
        Intrinsics.checkNotNullParameter(r11, "replyMessageId");
        r10.n = r11;
        r10.o = r3.getCreateTime();
        Intrinsics.checkNotNullParameter(r8, "replyOrder");
        r10.p = r8;
        Intrinsics.checkNotNullParameter(r7, "messageAimType");
        r10.q = r7;
        b.a r12 = b.b(r1, r3, r2);
        Intrinsics.checkNotNullParameter(r12, "commonParam");
        r10.a = r12.a;
        String r13 = r12.b;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r10.b = r13;
        String r14 = r12.c;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r10.c = r14;
        String r15 = r12.d;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r10.d = r15;
        r10.e = r12.e;
        String r16 = r12.f;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r10.f = r16;
        List<String> r17 = r12.g;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r10.g = r17;
        r10.h = r12.h;
        r10.i = r12.i;
        r10.j = r12.j;
        r10.k = r12.k;
        r10.l = r12.l;
        r10.m = r12.m;
        JSONObject r18 = r10.a().a();
        Log.d("MessageHitPoint", "message reply json = " + r18);
        Statistics.sendEvent("message_reply", r18);
        return;
    L22:
        r8 = INotificationHitPoint.NoticeType.OTHER;
        goto L23
    L13:
        if (r1.getChatMode() != Chat.ChatMode.THREAD_V2) goto L16;
    L18:
        r2 = null;
        goto L19
    L16:
        if (r1.getType() != Chat.Type.P2P) goto L18;
        r2 = ImSdkService.d().He(r1.getId(), r1.getP2pChatterId());
        goto L19
    L30:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
