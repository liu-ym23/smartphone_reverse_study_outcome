package com.ss.android.lark.chat.api.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.ChannelDataIncompleteStrategy;
import com.bytedance.lark.pb.basic.v1.ChannelDataScene;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.lark.pb.basic.v1.QuasiMessage;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.lark.pb.im.v1.ChannelDataType;
import com.bytedance.lark.pb.im.v1.DeleteMessageNoTraceRequest;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesV2Request;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesV2Response;
import com.bytedance.lark.pb.im.v1.MGetThreadsRequest;
import com.bytedance.lark.pb.im.v1.MGetThreadsResponse;
import com.bytedance.lark.pb.im.v1.UpdateThreadRequest;
import com.bytedance.lark.pb.im.v1.UpdateThreadsMeReadRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ThreadStateInfo;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadTitleBarPlugin;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class q1 implements com.ss.android.lark.biz.im.api.o0 {
    public final a2b.m a;

    public class a implements Function1<GetThreadMessagesV2Response, l5b.a> {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ q1 c;

        public final Object invoke(Object r21) {
            GetThreadMessagesV2Response r1 = (GetThreadMessagesV2Response) r21;
            q1 r2 = this.c;
            String r3 = this.a;
            Long r4 = Long.valueOf(this.b);
            r2.getClass();
            ArrayList r5 = new ArrayList();
            long r6 = System.currentTimeMillis();
            l5b.a r7 = new l5b.a();
            r7.f = System.currentTimeMillis() - r4.longValue();
            if (CollectionUtils.isNotEmpty(r1.invalid_positions) == false) goto L6;
            r7.c.addAll(r1.invalid_positions);
        L6:
            if (CollectionUtils.isNotEmpty(r1.missing_positions) == false) goto L8;
            r7.d.addAll(r1.missing_positions);
        L8:
            Entity r8 = r1.entity;
            com.ss.android.lark.chat.entity.chatter.a r15 = com.ss.android.lark.parser.internal.b.d(r8, true);
            Map r16 = ModelParserMessage.h(r8);
            HashMap r14 = new HashMap();
            boolean r17 = !FeatureGatingModule.getFeatureGatingService().isEnable("im.thread.loading_opt.reverse", false);
            Iterator r9 = r1.message_items.iterator();
        L9:
            n5b.a r10 = null;
            if (r9.hasNext() == false) goto L49;
            GetThreadMessagesV2Response.MessageItem r11 = (GetThreadMessagesV2Response.MessageItem) r9.next();
            String r13 = r11.item_id;
            ChannelDataType r12 = r11.item_type;
            if (r12 != ChannelDataType.NORMAL_DATA) goto L31;
            Message r18 = (Message) r8.messages.get(r13);
            com.ss.android.lark.chat.entity.message.Message r19 = (com.ss.android.lark.chat.entity.message.Message) ((LinkedHashMap) r16).get(r13);
            if (r19 == null) goto L30;
            if (r18 == null) goto L9;
            if (r17 == false) goto L19;
            Map r110 = r16;
        L20:
            HashMap r111 = r14;
            HashMap r0 = r14;
            Map r112 = r110;
            Iterator r113 = r9;
            com.ss.android.lark.chat.entity.chatter.a r20 = r15;
            MessageInfo r22 = com.ss.android.lark.parser.internal.a.l(r19, r18, r8, r15, r111, r112, true);
            r5.add(r22);
            r22.setOriginalSender(com.ss.android.lark.parser.internal.a.g(r22.getMessage(), r20));
            r0.put(r13, r22);
            MessageInfo r23 = r22.getParentMessageInfo();
            if (r23 != null) goto L23;
        L25:
            MessageInfo r24 = r22.getRootMessageInfo();
            if (r24 != null) goto L28;
        L48:
            r14 = r0;
            r15 = r20;
            r9 = r113;
            goto L9
        L28:
            if (r0.containsKey(r24.getMessage().getId()) == true) goto L48;
            r0.put(r24.getMessage().getId(), r24);
            goto L48
        L23:
            if (r0.containsKey(r23.getMessage().getId()) == true) goto L25;
            r0.put(r23.getMessage().getId(), r23);
            goto L25
        L19:
            r110 = null;
            goto L20
        L30:
            r113 = r9;
            r0 = r14;
            r20 = r15;
            goto L48
        L31:
            r113 = r9;
            r0 = r14;
            r20 = r15;
            if (r12 != ChannelDataType.QUASI_DATA) goto L48;
            QuasiMessage r25 = (QuasiMessage) r8.quasi_messages.get(r13);
            if (r25 == null) goto L48;
            MessageInfo r26 = ModelParserMessage.k(ModelParserMessage.d(r8, r25), r8, r20, r0);
            if (r26 == null) goto L48;
            r5.add(r26);
            MessageInfo r27 = r26.getParentMessageInfo();
            if (r27 != null) goto L41;
        L43:
            MessageInfo r28 = r26.getRootMessageInfo();
            if (r28 == null) goto L48;
            if (r0.containsKey(r28.getMessage().getId()) == true) goto L48;
            r0.put(r28.getMessage().getId(), r27);
            goto L48
        L41:
            if (r0.containsKey(r27.getMessage().getId()) == true) goto L43;
            r0.put(r27.getMessage().getId(), r27);
            goto L43
        L49:
            com.ss.android.lark.chat.entity.chatter.a r29 = r15;
            r7.a.addAll(r5);
            Thread r30 = (Thread) r8.threads.get(r3);
            com.ss.android.lark.chat.entity.message.Message r31 = (com.ss.android.lark.chat.entity.message.Message) ((LinkedHashMap) r16).get(r3);
            Message r32 = (Message) r8.messages.get(r3);
            ThreadTopic r33 = com.ss.android.lark.parser.internal.b0.a(r30);
            if (r31 == null) goto L60;
            if (r33 == null) goto L60;
            ChatChatter r34 = r29.b(r31.getChatId(), r32.from_id);
            if (r34 == null) goto L60;
            List<ReactionInfo> r35 = com.ss.android.lark.parser.internal.a.e(r29, r34.getChatId(), com.ss.android.lark.parser.internal.x.b(r32.reactions));
            n5b.a r114 = new n5b.a(r34, r33, r31);
            r114.i = com.ss.android.lark.parser.internal.a.g(r31, r29);
            r114.d = r35;
            r114.g = com.ss.android.lark.parser.internal.a.h(r32.pin, r31.getChatId(), r29);
            com.ss.android.lark.parser.internal.a.m(r32, r114, r29);
            String r36 = r31.getRecallerId();
            if (TextUtils.isEmpty(r36) == true) goto L59;
            r114.o = r29.b(r31.getChatId(), r36);
        L59:
            r114.h = com.ss.android.lark.parser.internal.d0.e(r31, r8, true);
            r114.l = com.ss.android.lark.parser.internal.h.a((Chat) r8.chats.get(r31.getChatId()), null);
            r10 = r114;
        L60:
            r7.b = r10;
            r7.e = System.currentTimeMillis() - r6;
            return r7;
        }

        public a(q1 r1, String r2, long r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b implements SdkSender.IParser<ThreadTopic> {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        public final Object parse(byte[] r2) throws IOException {
            MGetThreadsResponse r3 = (MGetThreadsResponse) MGetThreadsResponse.ADAPTER.decode(r2);
            Entity r0 = r3.entity;
            if (r0 != null) goto L5;
        L7:
            return null;
        L5:
            if (CollectionUtils.isNotEmpty(r0.threads) == false) goto L7;
            return com.ss.android.lark.parser.internal.b0.a((Thread) r3.entity.threads.get(this.a));
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[MessageFetchScene.values().length];
            c = r0;
            r0[MessageFetchScene.FIRST_SCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L30:
            c[MessageFetchScene.SPECIFIED_POSITION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L36:
            c[MessageFetchScene.NEXT_PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L46:
            c[MessageFetchScene.PREVIOUS_PAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L9:
            int[] r3 = new int[ThreadStateInfo.ThreadState.values().length];
            b = r3;
            r3[ThreadStateInfo.ThreadState.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L32:
            b[ThreadStateInfo.ThreadState.CLOSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L34:
            b[ThreadStateInfo.ThreadState.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L13:
            int[] r4 = new int[ChannelDataFetcherStrategy.values().length];
            a = r4;
            r4[ChannelDataFetcherStrategy.IGNORE_LOCAL_DATA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L44:
            a[ChannelDataFetcherStrategy.RETURN_LOCAL_DATA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L28:
            a[ChannelDataFetcherStrategy.SYNC_SERVER_DATA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public static final class d {
        public static final q1 a = null;

        static {
            a = new q1(new k1());
        }
    }

    @Inject
    public q1(a2b.m r1) {
        this.a = r1;
    }

    public static ChannelDataScene b(MessageFetchScene r1) {
        int r2 = c.c[r1.ordinal()];
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L17;
        if (r2 == 3) goto L15;
        if (r2 == 4) goto L13;
        return ChannelDataScene.FIRST_SCREEN;
    L13:
        return ChannelDataScene.PREVIOUS_PAGE;
    L15:
        return ChannelDataScene.NEXT_PAGE;
    L17:
        return ChannelDataScene.SPECIFIED_POSITION;
    L19:
        return ChannelDataScene.FIRST_SCREEN;
    }

    public static ChannelDataIncompleteStrategy c(ChannelDataFetcherStrategy r1) {
        int r2 = c.a[r1.ordinal()];
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L13;
        if (r2 == 3) goto L11;
        return ChannelDataIncompleteStrategy.SYNC_SERVER_DATA;
    L11:
        return ChannelDataIncompleteStrategy.SYNC_SERVER_DATA;
    L13:
        return ChannelDataIncompleteStrategy.RETURN_LOCAL_DATA;
    L15:
        return ChannelDataIncompleteStrategy.IGNORE_LOCAL_DATA;
    }

    public final ThreadTopic Vd(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        MGetThreadsRequest.Builder r0 = new MGetThreadsRequest.Builder();
        r0.thread_ids(Collections.singletonList(r4)).strategy(SyncDataStrategy.FORCE_SERVER);
        return (ThreadTopic) SdkSender.sendRequest(Command.MGET_THREADS, r0, new b(r4));
    }

    public final void Dd(String r3, UIGetDataCallback r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        r4.onError(new ErrorResult("thread id is empty"));
    L5:
        DeleteMessageNoTraceRequest.Builder r0 = new DeleteMessageNoTraceRequest.Builder();
        r0.message_id(r3);
        SdkSender.asynSendRequestNonWrap(Command.DELETE_MESSAEG_NO_TRACE, r0, r4, new com.bytedance.ee.bear.middleground.drive.rustsdk.init.a());
    }

    public final void J7(String r2, boolean r3, ReplyInThreadTitleBarPlugin.showMoreOperationMenu.1.2 r4) {
        UpdateThreadRequest.Builder r0 = new UpdateThreadRequest.Builder();
        r0.thread_id(r2).is_follow(Boolean.valueOf(r3));
        this.a.c(r0, r4);
    }

    public final void N6(final String r4, SyncDataStrategy r5, IGetDataCallback r6) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        if (r6 == null) goto L9;
        r6.onError(new ErrorResult("thread id is empty"));
        return;
    L9:
        return;
    L7:
        MGetThreadsRequest.Builder r0 = new MGetThreadsRequest.Builder();
        r0.thread_ids(Collections.singletonList(r4)).for_normal_chat_message(Boolean.TRUE).strategy(r5);
        SdkSender.asynSendRequestNonWrap(Command.MGET_THREADS, r0, r6, new n1(r4));
    }

    public final void ja(String r2, boolean r3, ReplyInThreadTitleBarPlugin.showMoreOperationMenu.2.1 r4) {
        UpdateThreadRequest.Builder r0 = new UpdateThreadRequest.Builder();
        r0.thread_id(r2).is_remind(Boolean.valueOf(r3));
        this.a.c(r0, r4);
    }

    public final void q5(List r11, int r12, int r13) {
        if (CollectionUtils.isEmpty(r11) == false) goto L6;
        Log.i("ThreadService", "readThread, intervalThreads is empty");
        return;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator r2 = r11.iterator();
        int r3 = PluginList.LEVEL_NOT_SET;
        int r4 = PluginList.LEVEL_NOT_SET;
        int r5 = PluginList.LEVEL_NOT_SET;
    L7:
        boolean r7 = false;
        if (r2.hasNext() == false) goto L20;
        n5b.a r6 = (n5b.a) r2.next();
        ThreadTopic r8 = r6.b;
        com.ss.android.lark.chat.entity.message.Message r9 = r6.c;
        if (r9.isPreMessage() == true) goto L7;
        r3 = Math.max(r8.getPosition(), r3);
        r4 = Math.max(r8.getBadgeCount(), r4);
        r5 = Math.max(r8.getOriginBadgeCount(), r5);
        Lazy r10 = ImSdkMessageUtils.a;
        Intrinsics.checkNotNullParameter(r9, "message");
        if (r9.getType() == com.ss.android.lark.chat.entity.message.Message.Type.AUDIO) goto L14;
        r7 = true;
    L14:
        if (r7 == false) goto L7;
        if (r9.isFromMe() == true) goto L7;
        if (r9.getMeReadType() > 0) goto L7;
        r0.add(r9.getId());
        goto L7
    L20:
        Log.i("ThreadService", "readThread, maxPosition:" + r3 + ", lastReadPosition:" + r12 + ", maxBadgeCount:" + r4 + ", lastReadBadgeCount:" + r13);
        if (CollectionUtils.isNotEmpty(r0) == true) goto L25;
        if (r3 > r12) goto L25;
        if (r4 > r13) goto L25;
        Log.i("ThreadService", "needReadThreadIds is empty, maxPosition:" + r3 + ", lastReadPosition:" + r12 + ", maxBadgeCount:" + r4 + ", lastReadBadgeCount:" + r13);
        return;
    L25:
        Channel r14 = ((n5b.a) ListProtector.get(r11, 0)).c.getChannel();
        Log.i("ThreadService", "readThreadInner max:" + r3 + ", maxBadgeCount:" + r5);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_THREADS_ME_READ, new UpdateThreadsMeReadRequest.Builder().channel(com.ss.android.lark.parser.internal.g.b(r14)).thread_ids(r0).read_position(Integer.valueOf(r3)).read_position_badge_count(Integer.valueOf(r5)), null, new com.bytedance.ee.bear.middleground.drive.rustsdk.init.a());
    }

    public static List<MessageInfo> a(Entity r2, ThreadTopic r3, com.ss.android.lark.chat.entity.chatter.a r4, Map<String, com.ss.android.lark.chat.entity.message.Message> r5) {
        ArrayList r0 = new ArrayList();
        if (r3 != null) goto L6;
        return r0;
    L6:
        if (CollectionUtils.isEmpty(r3.getLatestAtMessageIds()) == false) goto L9;
        return r0;
    L9:
        return d(r2, r4, r5, r3.getLatestAtMessageIds());
    }

    public static List<MessageInfo> d(Entity r6, com.ss.android.lark.chat.entity.chatter.a r7, Map<String, com.ss.android.lark.chat.entity.message.Message> r8, List<String> r9) {
        ArrayList r0 = new ArrayList();
        Iterator<String> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        String r1 = r10.next();
        com.ss.android.lark.chat.entity.message.Message r2 = (com.ss.android.lark.chat.entity.message.Message) ((LinkedHashMap) r8).get(r1);
        if (r2 == null) goto L7;
        ChatChatter r4 = r7.b(r2.getChatId(), r2.getFromId());
        if (r4 == null) goto L10;
        MessageInfo r3 = new MessageInfo(r2, r4);
        r3.setTranslateInfo(com.ss.android.lark.parser.internal.d0.e(r2, r6, true));
        r3.setOriginalSender(com.ss.android.lark.parser.internal.a.g(r2, r7));
        r0.add(r3);
        goto L4
    L10:
        Log.e("ThreadService", "last at message sender is null: Id: " + r1);
        goto L4
    L7:
        Log.e("ThreadService", "last at message is null; Id: " + r1);
        goto L4
    L12:
        return r0;
    }

    public final l5b.a Qb(String r4, MessageFetchScene r5, int r6, int r7, int r8, ChannelDataFetcherStrategy r9, int r10, boolean r11) {
        if (TextUtils.isEmpty(r4) == true) goto L9;
        if (r6 < 0) goto L9;
        a r2 = new a(this, r4, System.currentTimeMillis());
        GetThreadMessagesV2Request.Builder r0 = new GetThreadMessagesV2Request.Builder();
        r0.thread_id(r4).scene(b(r5)).redundancy_count(Integer.valueOf(r8)).position(Integer.valueOf(r6)).count(Integer.valueOf(r7)).strategy(c(r9)).preload_count(Integer.valueOf(r10)).need_response(Boolean.valueOf(r11));
        return this.a.d(r0, r2);
    L9:
        return new l5b.a();
    }
}
