package com.ss.android.lark.im.sdk.statistics;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.usergroup.UserGroupHitPoint;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.o;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ Message a;
    public final /* synthetic */ String b;

    public c(Message r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Message r0 = this.a;
        String r1 = this.b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isFromMe() == true) goto L58;
        String r2 = r0.getChatId();
        int r3 = UserGroupHitPoint.a;
        Map r4 = UserGroupHitPoint.a(ChatParamUtils.g(r0), r0);
        Lazy r5 = ImSdkChatHitPointV2.a;
        Intrinsics.checkNotNullParameter("msg_read", "click");
        Intrinsics.checkNotNullParameter("none", "target");
        Map r6 = ChatParamUtils.f(r2);
        if (r6 == null) goto L12;
        ImSdkChatHitPointV2.a("msg_read", "none", r6, r4);
    L12:
        Chat r7 = ChatService.c.a.getLocalChat(r0.getChatId());
        if (r7 != null) goto L16;
        return;
    L16:
        if (r7.getChatMode() != Chat.ChatMode.THREAD_V2) goto L19;
    L21:
        ChatChatter r8 = null;
    L23:
        if (r7.isP2PChat() == false) goto L29;
        if (r8 == null) goto L26;
        boolean r9 = r8.isBot();
    L27:
        if (r9 == false) goto L29;
        boolean r10 = true;
    L31:
        if (r0.getType() == Message.Type.CARD) goto L51;
    L39:
        Message.Type r11 = r0.getType();
        if (r11 != null) goto L42;
        int r12 = -1;
    L44:
        switch(r12) {
            case 1: goto L49;
            case 2: goto L48;
            case 3: goto L47;
            case 4: goto L47;
            case 5: goto L47;
            case 6: goto L47;
            case 7: goto L47;
            case 8: goto L47;
            case 9: goto L47;
            case 10: goto L46;
            default: goto L45;
        };
    L45:
        b.c(r0.getType().getNumber(), "none", r7, r0.getId(), r10);
        return;
    L46:
        b.c(r0.getType().getNumber(), "none", r7, r0.getId(), r10);
        return;
    L47:
        b.c(r0.getType().getNumber(), "none", r7, r0.getId(), r10);
        return;
    L48:
        RichText r13 = r0.getContent().getRichText();
        int r14 = r0.getType().getNumber();
        boolean r15 = com.ss.android.lark.widget.richtext.d.f(r13, false).contains(r1);
        boolean r16 = com.ss.android.lark.widget.richtext.d.k(r13);
        ArrayList r17 = com.ss.android.lark.widget.richtext.d.f(r13, true);
        Pattern r18 = o.a;
        b.c(r14, b.a(r15, r16, r17.contains("all")), r7, r0.getId(), r10);
        return;
    L49:
        RichText r19 = r0.getContent().getRichText();
        int r20 = r0.getType().getNumber();
        boolean r21 = com.ss.android.lark.widget.richtext.d.f(r19, false).contains(r1);
        boolean r22 = com.ss.android.lark.widget.richtext.d.k(r19);
        ArrayList r23 = com.ss.android.lark.widget.richtext.d.f(r19, true);
        Pattern r24 = o.a;
        b.c(r20, b.a(r21, r22, r23.contains("all")), r7, r0.getId(), r10);
        return;
    L42:
        r12 = b.d.a[r11.ordinal()];
        goto L44
    L51:
        CardContent.ExtraInfo r25 = r0.getContent().getExtraInfo();     // Catch: Throwable -> L38
        if (r25 == null) goto L39;
        String r26 = r25.getAnalyticsData();     // Catch: Throwable -> L38
        if (r26 == null) goto L39;
        b.e(r26);     // Catch: Throwable -> L38
    L38:
        Log.e("MessageHitPoint", "card content is null");
        goto L39
    L26:
        r9 = false;
    L29:
        r10 = false;
        goto L31
    L19:
        if (r7.getType() != Chat.Type.P2P) goto L21;
        r8 = ImSdkService.d().He(r7.getId(), r7.getP2pChatterId());
        goto L23
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
