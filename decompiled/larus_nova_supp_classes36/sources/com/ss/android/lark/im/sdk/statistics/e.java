package com.ss.android.lark.im.sdk.statistics;

import android.util.Patterns;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {
    public final /* synthetic */ Chat a;
    public final /* synthetic */ ChatChatter b;
    public final /* synthetic */ Message c;

    public e(Chat r1, ChatChatter r2, Message r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        Map<String, String> r0 = b.a;
        Chat r1 = this.a;
        ChatChatter r2 = this.b;
        Message r3 = this.c;
        if (r3 == null) goto L30;
        if (r1 != null) goto L9;
        r1 = ChatService.c.a.getLocalChat(r3.getChatId());
        if (r1 != null) goto L9;
        return;
    L9:
        if (r2 == null) goto L11;
    L17:
        boolean r5 = false;
        if (r3.getType() != Message.Type.TEXT) goto L25;
        String r4 = ImSdkMessageUtils.a(r3);
        if (r4 == null) goto L25;
        okb.e r6 = com.ss.android.lark.statistics.message.b.a;
        Intrinsics.checkNotNullParameter(r4, "textContent");
        Matcher r7 = Patterns.WEB_URL.matcher(r4);
        if (r7.find() == false) goto L25;
        r7.group(0);
        com.ss.android.lark.statistics.message.b.a.b();
    L25:
        b.a r8 = b.b(r1, r3, r2);
        b.c.a r9 = new b.c.a();
        if (r8.j <= 0) goto L28;
        r5 = true;
    L28:
        r9.n = r5;
        Intrinsics.checkNotNullParameter("", "fileId");
        r9.p = "";
        Intrinsics.checkNotNullParameter("", "fileType");
        r9.o = "";
        Intrinsics.checkNotNullParameter(r8, "commonParam");
        r9.a = r8.a;
        String r10 = r8.b;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.b = r10;
        String r11 = r8.c;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r9.c = r11;
        String r12 = r8.d;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r9.d = r12;
        r9.e = r8.e;
        String r13 = r8.f;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r9.f = r13;
        List<String> r14 = r8.g;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r9.g = r14;
        r9.h = r8.h;
        r9.i = r8.i;
        r9.j = r8.j;
        r9.k = r8.k;
        r9.l = r8.l;
        r9.m = r8.m;
        JSONObject r15 = r9.a().a();
        Log.d("MessageHitPoint", "message sent json = " + r15);
        Statistics.sendEvent("message_sent", r15);
        return;
    L11:
        if (r1.getChatMode() != Chat.ChatMode.THREAD_V2) goto L14;
    L16:
        r2 = null;
        goto L17
    L14:
        if (r1.getType() != Chat.Type.P2P) goto L16;
        r2 = ImSdkService.d().He(r1.getId(), r1.getP2pChatterId());
        goto L17
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
