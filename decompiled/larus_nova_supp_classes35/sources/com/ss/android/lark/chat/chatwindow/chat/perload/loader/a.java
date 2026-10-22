package com.ss.android.lark.chat.chatwindow.chat.perload.loader;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.GetTopicGroupsRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.api.service.impl.t1;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.thread.TopicGroup;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.team.TeamUtils;
import h7b.j;
import h7b.k;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import u3b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements c<u3b.b, e<i7b.a>> {
    public ErrorResult a;
    public final ImSdkChatService b;
    public final p c;

    /* JADX WARN: Type inference failed for: r0v20, types: [T, i7b.a] */
    @Override // com.ss.android.lark.chat.chatwindow.chat.perload.loader.c
    public final e a(u3b.a r21) {
        final u3b.b r2 = (u3b.b) r21;
        ChatWindowPrepareData r3 = null;
        this.a = null;
        boolean r4 = true;
        ChatCoreModule.a().getPerfEnterChatMonitor().h(true);
        String r0 = r2.d;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L16:
        String r1 = r2.c;
        if (TextUtils.isEmpty(r1) == true) goto L22;
        Message r5 = (Message) this.c.ta(Collections.singletonList(r1)).get(r1);
        if (r5 == null) goto L21;
        int r6 = r5.getPosition();
        r2.e.r(r6);
        Log.i("ChatDataPreLoadTask", "setShowPosition:" + r6);
        goto L22
    L21:
        Log.e("chatwindow", "load init message position failed: " + r1);
    L22:
        k r7 = k.b.a;
        String r8 = r2.b;
        String r9 = r7.b.getUserId();
        com.ss.android.lark.chat.entity.chat.a r10 = r7.a.f(r8);
        if (r10 != null) goto L25;
        Log.e("prepare botChat in ChatWindow , but cannot get botChat" + r8);
    L80:
        if (r3 != null) goto L83;
        Log.e("chatwindow", "getChatLauncherInfo failed, chatId is:" + r2.b);
    L83:
        if (this.a != null) goto L100;
        if (r3 == null) goto L99;
        Chat r11 = r3.chat;
        if (r11 == null) goto L99;
        if (r11.getRole() == Chat.Role.MEMBER) goto L92;
        r4 = false;
    L92:
        boolean r12 = r3.chat.getHasVCChatPermission();
        if (r4 == true) goto L100;
        if (r12 == true) goto L100;
        TeamUtils.b(r3.chat);
        com.ss.android.lark.chat.entity.chat.b r13 = this.b.I0(r2.b);
        if (r13 == null) goto L98;
        this.a = new ErrorResult(4, r13.b);
        goto L100
    L98:
        this.a = new ErrorResult(3);
    L99:
        this.a = new ErrorResult(1);
    L100:
        ?? r14 = i7b.a.b(r2.e, r3);
        ChatCoreModule.a().getPerfEnterChatMonitor().h(false);
        e r15 = new e();
        r15.a = r14;
        r15.b = this.a;
        return r15;
    L25:
        Chat r16 = r10.a;
        if (r16 == null) goto L29;
        r7.d.put(r8, r16);
    L29:
        if (r7.e.a(r8, r9) != null) goto L31;
        r7.e.b(r8, r9, ImSdkService.d().He(r8, r9));
    L31:
        if (r16 != null) goto L33;
        Log.e("prepare chat in ChatWindow , but cannot get chat" + r8);
        goto L80
    L33:
        Chat.Type r17 = r16.getType();
        Chat.Type r18 = Chat.Type.P2P;
        if (r17 != r18) goto L54;
        ChatService r19 = r7.a;
        r19.getClass();
        if (r16.getType() == r18) goto L39;
        String r110 = null;
    L49:
        if (r7.e.a(r8, r110) != null) goto L54;
        Chatter r111 = r10.c;
        if (r111 == null) goto L53;
        r7.e.b(r8, r110, new ChatChatter(r111));
        goto L54
    L53:
        r7.e.b(r8, r110, ImSdkService.d().He(r8, r110));
        goto L54
    L39:
        if (TextUtils.isEmpty(r16.getP2pChatterId()) == true) goto L41;
        r110 = r16.getP2pChatterId();
        goto L49
    L41:
        String[] r112 = r16.getKey().split(":");
        String r113 = r19.a.getCurrentUserId();
        Iterator r114 = Arrays.asList(r112).iterator();
    L43:
        if (r114.hasNext() == false) goto L47;
        String r115 = (String) r114.next();
        if (r115.equals(r113) == true) goto L43;
        r110 = r115;
        goto L49
    L47:
        r110 = r112[0];
    L54:
        OpenApp r116 = r10.b;
        ChatThemeInfo r20 = r10.d;
        ChatChatter r22 = (ChatChatter) r7.e.a(r8, r9);
        Chat r117 = r7.d.get(r8);
        if (r117.getType() != Chat.Type.P2P) goto L68;
        j.a r23 = new j(r117, ImSdkService.d()).a();
        if (r23 == null) goto L66;
        ChatChatter r118 = r23.a;
        if (r118 == null) goto L66;
        OpenApp r24 = r23.b;
        if (r24 != null) goto L64;
        OpenApp r119 = r116;
    L65:
        r3 = new ChatWindowPrepareData(r117, r118, r22, r119, null, r20);
        goto L80
    L64:
        r119 = r24;
    L66:
        Log.e("opening p2p chat in ChatWindow , but cannot get chatter");
        goto L80
    L68:
        if (r117.getChatMode() != Chat.ChatMode.THREAD_V2) goto L79;
        r7.c.getClass();
        if (TextUtils.isEmpty(r8) == true) goto L73;
        GetTopicGroupsRequest.Builder r25 = new GetTopicGroupsRequest.Builder();
        GetTopicGroupsRequest.Builder r26 = r25.group_ids(Collections.singletonList(r8));
        Boolean r120 = Boolean.FALSE;
        r26.sync_data(r120).need_sync_unsubscribe_groups(r120);
        r3 = (TopicGroup) SdkSender.sendRequest(Command.GET_TOPIC_GROUPS, r25, new t1(r8));
    L73:
        ChatWindowPrepareData r121 = r3;
        if (r121 != null) goto L76;
    L78:
        Log.i("prepare chat from cache chat");
        r3 = new ChatWindowPrepareData(r117, null, r22, r116, r121, r20);
        goto L80
    L76:
        if (r121.getChat() == null) goto L78;
        Log.i("prepare chat from topGroup");
        r3 = new ChatWindowPrepareData(r121.getChat(), null, r22, r116, r121, r20);
        goto L80
    L79:
        r3 = new ChatWindowPrepareData(r117, null, r22, r116, null, r20);
        goto L80
    L5:
        if (TextUtils.isEmpty(r2.b) == false) goto L16;
        final IGetDataCallback<Chat> r27 = new ChatDataPreLoader$1(this, r2);
        Chat r28 = this.b.xc(r0);
        if (r28 == null) goto L9;
        r27.onSuccess(r28);
        goto L16
    L9:
        final CountDownLatch r29 = new CountDownLatch(1);
        this.b.X5(r0, null, new ChatDataPreLoader$2(this, r29, r27));
    L14:
        e = move-exception;
        r27.onSuccess(null);
        e.printStackTrace();
        goto L16
    L11:
        if (r29.await(30000, TimeUnit.MILLISECONDS) == true) goto L16;
        r27.onSuccess(null);     // Catch: InterruptedException -> L14
        goto L16
    }

    public a(ImSdkChatService r1, p r2) {
        this.b = r1;
        this.c = r2;
    }
}
