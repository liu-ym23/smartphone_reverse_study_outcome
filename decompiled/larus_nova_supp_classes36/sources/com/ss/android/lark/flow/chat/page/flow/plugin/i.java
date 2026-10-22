package com.ss.android.lark.flow.chat.page.flow.plugin;

import android.text.TextUtils;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.statistics.chat.q;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ i7b.a a;
        public final /* synthetic */ Chat b;

        public b(i7b.a r1, Chat r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ChatChatter r0 = this.a.g;
            String r1 = q.a;
            q.b.a r2 = new q.b.a();
            r2.a = this.b.getId();
            r2.j = this.a.a;
            r2.b = this.b.isRemind();
            r2.g = TextUtils.equals(this.a.a, "notification");
            boolean r4 = false;
            if (com.ss.android.lark.chat.utils.k.c(this.b) != Chat.MessagePosition.RECENT_LEFT) goto L5;
            boolean r3 = true;
        L6:
            r2.f = r3;
            r2.d = this.b.isGroup();
            r2.h = this.b.isSecret();
            if (r0 != null) goto L9;
        L11:
            r2.e = r4;
            r2.c = this.b.isMeeting();
            q.b r5 = new q.b(r2);
            Intrinsics.checkNotNullParameter(r5, "params");
            if (r5.d == false) goto L20;
            Intrinsics.checkNotNullParameter(INotificationHitPoint.ChatType.CHAT_TYPE_GROUP, "<set-?>");
            q.a = INotificationHitPoint.ChatType.CHAT_TYPE_GROUP;
            if (r5.c == false) goto L17;
            Intrinsics.checkNotNullParameter("meeting", "<set-?>");
            q.a = "meeting";
        L17:
            if (r5.h == false) goto L27;
            Intrinsics.checkNotNullParameter("group_secret", "<set-?>");
            q.a = "group_secret";
        L27:
            Intrinsics.checkNotNullParameter("main_input", "location");
            if ("main_input" != "thread_input") goto L30;
            Statistics.sendEvent("thread_view");
        L30:
            q.b = !r5.b;
            q.c = q.c;
            int r6 = com.ss.android.lark.im.sdk.statistics.a.a;
            Intrinsics.checkNotNullParameter(r5, "params");
            if (r5.b == false) goto L33;
            String r7 = "notice";
        L35:
            if (r5.f == false) goto L37;
            String r8 = "first";
        L39:
            if (TextUtils.isEmpty(r5.j) == true) goto L41;
            String r9 = r5.j;
        L42:
            JSONObject r10 = new JSONObject().put("chat_id", r5.a).put("from", r9).put("notice_setting", r7).put("unread_start", r8);
            if (r5.d == false) goto L45;
            int r11 = Chat.Type.GROUP.getNumber();
        L46:
            JSONObject r12 = r10.put("chat_type", r11).put("thread_id", r5.k);
            String r13 = "true";
            if (r5.e == false) goto L49;
            Object r14 = "true";
        L50:
            JSONObject r15 = r12.put("is_bot_chat", r14);
            if (r5.c == true) goto L54;
            r13 = "false";
        L54:
            Statistics.sendEvent("chat_view", r15.put("is_meeting_chat", r13));
            boolean r16 = r5.g;
            String r17 = r5.a;
            String r18 = r5.i;
            if (r16 == false) goto L57;
            Statistics.sendEvent("push_chat_click", new JSONObject().put("chat_type", q.a).put("chat_id", r17).put("message_id", r18));
        L57:
            Intrinsics.checkNotNullParameter("main", "location");
            Map<String, String> r19 = com.ss.android.lark.im.sdk.statistics.b.a;
            Intrinsics.checkNotNullParameter("main", "<set-?>");
            com.ss.android.lark.im.sdk.statistics.b.b = "main";
            return;
        L49:
            r14 = "false";
            goto L50
        L45:
            r11 = Chat.Type.P2P.getNumber();
            goto L46
        L41:
            r9 = INotificationHitPoint.NoticeType.OTHER;
            goto L42
        L37:
            r8 = "last";
            goto L39
        L33:
            r7 = "mute";
            goto L35
        L20:
            if (r5.e == false) goto L23;
            String r20 = INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE_BOT;
        L26:
            Intrinsics.checkNotNullParameter(r20, "<set-?>");
            q.a = r20;
            goto L27
        L23:
            if (r5.h == false) goto L25;
            r20 = "single_secret";
            goto L26
        L25:
            r20 = INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE;
            goto L26
        L9:
            if (r0.isBot() == false) goto L11;
            r4 = true;
            goto L11
        L5:
            r3 = false;
            goto L6
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

    static {
    }

    public i() {
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r7, i7b.a r8) {
        Intrinsics.checkNotNullParameter(r7, "chatApp");
        Intrinsics.checkNotNullParameter(r8, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r7, r8);
        Chat r9 = r8.f;
        if (r9 != null) goto L6;
        Log.w("FlowEnterChatHitPointPlugin", "chat = null");
        return;
    L6:
        OpenApp r0 = r8.i;
        if (r0 == null) goto L9;
        String r1 = r0.getBotId();
    L10:
        ChatChatter r2 = r8.g;
        Map r3 = MapsKt.mapOf(TuplesKt.to("from_source", r8.a));
        Lazy r4 = ChatHitPointNew.a;
        Intrinsics.checkNotNullParameter(r9, "chat");
        JSONObject r5 = new JSONObject(ChatParamUtils.a(r9, ChatCoreModule.a().getLoginDependency().getUserId(), r2));
        if (r1 != null) goto L13;
        r1 = "none";
    L13:
        JSONObject r6 = r5.put("bot_id", r1);
        if (CollectionUtils.isEmpty(null) == false) goto L16;
        r6.put("have_tab", false);
        r6.put("is_enabled_red_dot", false);
        r6.put("is_doc_list_tab_included", false);
        r6.put("doc_page_count", 0);
    L16:
        if (r3 == null) goto L21;
        Iterator r10 = r3.entrySet().iterator();
    L19:
        if (r10.hasNext() == false) goto L21;
        Map.Entry r11 = (Map.Entry) r10.next();
        r6.put((String) r11.getKey(), r11.getValue());
    L21:
        Log.d("ChatHitPointNew", "IM_CHAT_MAIN_VIEW, params:" + r6);
        ChatHitPointNew.d().sendEvent("im_chat_main_view", r6);
        CoreThreadPool.getSerialTaskHandler().post(new b(r8, r9));
        return;
    L9:
        r1 = null;
        goto L10
    }
}
