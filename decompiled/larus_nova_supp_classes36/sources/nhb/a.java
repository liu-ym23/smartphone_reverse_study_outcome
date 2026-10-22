package nhb;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.y0;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.utils.e0;
import com.ss.android.lark.chat.utils.g0;
import com.ss.android.lark.chat.utils.h0;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.flow.mergeforward.page.FlowMergeForwardViewModel;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.message.lynxcard.message.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q3b.q;
import x4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements y0 {
    public final v a;
    public final FlowMergeForwardViewModel b;
    public final d c;
    public final String d;

    /* JADX INFO: renamed from: nhb.a$a, reason: collision with other inner class name */
    public static final class C0300a {
    }

    public static final class b implements Comparator<Message> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Message r2, Message r3) {
            Message r4 = r2;
            Message r5 = r3;
            Intrinsics.checkNotNullParameter(r4, "message1");
            Intrinsics.checkNotNullParameter(r5, "message2");
            return r5.getPosition() - r4.getPosition();
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ IGetDataCallback<ChatMessageResponse> b;

        public c(a r1, IGetDataCallback<ChatMessageResponse> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            a r1 = this.a;
            IGetDataCallback<ChatMessageResponse> r2 = this.b;
            MergeForwardContent r3 = r1.b.getMessageContent();
            MergeForwardContent r4 = r1.b.getTranslatedMessageContent();
            int r5 = r1.b.getFromType();
            if (r3 != null) goto L5;
            r2.onError(new ErrorResult("content is null"));
            return;
        L5:
            List r6 = r3.getMessages();
            Map r7 = r3.getChatters();
            List r8 = r6;
            if (r8 != null) goto L8;
        L11:
            boolean r9 = true;
        L12:
            if (r9 == true) goto L122;
            if (r7 != null) goto L15;
        L18:
            boolean r10 = true;
        L19:
            if (r10 == true) goto L122;
            String r11 = r1.d;
            int r12 = com.ss.android.lark.chat.mergeforward.a.a;
            Intrinsics.checkNotNullParameter(r11, "chatId");
            Intrinsics.checkNotNullParameter(r3, "mergeForwardContent");
            Map r13 = r3.getChatters();
            Map r14 = r3.getReactionChatterMap();
            ArrayList r15 = new ArrayList();
            if (r13 == null) goto L27;
            Iterator r16 = r13.entrySet().iterator();
        L25:
            if (r16.hasNext() == false) goto L27;
            r15.add(((Map.Entry) r16.next()).getKey());
        L27:
            Iterator r17 = r14.entrySet().iterator();
        L29:
            if (r17.hasNext() == false) goto L31;
            r15.add(((Map.Entry) r17.next()).getKey());
            goto L29
        L31:
            HashMap r18 = new HashMap();
            Map<String, ChatChatter> r19 = ImSdkService.d().A2(r11, r15);
            if (r13 == null) goto L39;
            Iterator r20 = r13.entrySet().iterator();
        L35:
            if (r20.hasNext() == false) goto L39;
            Map.Entry r110 = (Map.Entry) r20.next();
            if (r19.keySet().contains(r110.getKey()) == true) goto L35;
            Object r111 = r110.getKey();
            ChatterInfo r112 = (ChatterInfo) r110.getValue();
            Chatter r21 = new Chatter();
            r21.setId(r112.getId());
            r21.setName(r112.getName());
            r21.setType(r112.getType());
            r21.setAvatarKey(r112.getAvatarKey());
            r21.setAnonymous(r112.isAnonymous());
            r21.setProfileEnable(true);
            r18.put(r111, new ChatChatter(r21));
        L39:
            Iterator r22 = r14.entrySet().iterator();
        L41:
            if (r22.hasNext() == false) goto L45;
            Map.Entry r23 = (Map.Entry) r22.next();
            if (r19.keySet().contains(r23.getKey()) == true) goto L41;
            r18.put(r23.getKey(), new ChatChatter((Chatter) r23.getValue()));
            goto L41
        L45:
            r18.putAll(r19);
            HashMap r24 = new HashMap();
            if (r4 == null) goto L55;
            List r25 = r4.getMessages();
            if (r25 == null) goto L55;
            Iterator r26 = r25.iterator();
        L51:
            if (r26.hasNext() == false) goto L55;
            Message r27 = (Message) r26.next();
            if (h0.m(r27) == false) goto L51;
            r24.put(r27.getId(), r27);
        L55:
            ArrayList r28 = new ArrayList();
            HashMap r29 = new HashMap();
            Iterator r30 = r6.iterator();
        L57:
            if (r30.hasNext() == false) goto L121;
            Message r113 = (Message) r30.next();
            ChatterInfo r114 = (ChatterInfo) r7.get(r113.getFromId());
            if (r114 == null) goto L119;
            MessageInfo r115 = new MessageInfo(r113, (ChatChatter) r18.get(r114.getId()));
            List r116 = (List) r3.getReactionMap().get(r113.getId());
            int r117 = e0.a;
            Intrinsics.checkNotNullParameter(r18, "chatterMap");
            ArrayList r118 = new ArrayList();
            if (r116 == null) goto L73;
            Iterator r119 = r116.iterator();
        L64:
            if (r119.hasNext() == false) goto L73;
            Reaction r120 = (Reaction) r119.next();
            List r121 = r120.getChatterIds();
            HashMap r0 = new HashMap();
            Intrinsics.checkNotNull(r121);
            Iterator r122 = r121.iterator();
        L67:
            if (r122.hasNext() == false) goto L72;
            Map r123 = r7;
            String r31 = (String) r122.next();
            Iterator r124 = r30;
            ChatChatter r32 = (ChatChatter) r18.get(r31);
            if (r32 == null) goto L71;
            r0.put(r31, r32);
        L71:
            r7 = r123;
            r30 = r124;
            goto L67
        L72:
            r118.add(new ReactionInfo(r120, r0));
            r7 = r7;
        L73:
            Map r125 = r7;
            Iterator r126 = r30;
            r115.setReactionInfoList(r118);
            MergeForwardContent.MessageThread r33 = (MergeForwardContent.MessageThread) r3.getMessageThreadMap().get(r113.getThreadId());
            if (r33 == null) goto L80;
            List r34 = r33.getChildMessages();
            if (r34 == null) goto L80;
            if (r34.isEmpty() == true) goto L80;
            boolean r35 = true;
        L81:
            if (r35 == false) goto L95;
            r115.setReplyInThreadCount(r33.getReplyCount());
            r115.setLastReplyInThreadTime(r33.getLatestReplyTime());
            r115.setChildMessageInThread(r33.getChildMessages());
            ArrayList r36 = new ArrayList(r33.getChildMessages());
            Collections.sort(r36, new b());
            int r37 = r36.size();
            List r38 = r36;
            if (r37 <= 5) goto L85;
            r38 = r36.subList(r36.size() - 5, r36.size());
        L85:
            Intrinsics.checkNotNull(r38);
            Context r39 = ChatCoreModule.a().getContext();
            int r40 = UIUtils.getColor(r39, 2131106607);
            ArrayList r127 = new ArrayList();
            Iterator r41 = r38.iterator();
        L87:
            if (r41.hasNext() == false) goto L94;
            Message r128 = (Message) r41.next();
            ChatChatter r129 = (ChatChatter) r18.get(r128.getFromId());
            if (r129 == null) goto L87;
            CharSequence r130 = g0.b(r39, r128, r40);
            if (r130 != null) goto L93;
            r130 = "";
        L93:
            Context r131 = r39;
            CharSequence r42 = r130;
            MergeForwardContent r132 = r3;
            e5b.a.a r43 = new e5b.a.a();
            Iterator r210 = r41;
            String r44 = r128.getId();
            Intrinsics.checkNotNullParameter(r44, "messageId");
            r43.a = r44;
            Intrinsics.checkNotNullParameter(r42, "content");
            r43.e = r42;
            r43.f = r128.getThreadPosition();
            String r45 = r129.getId();
            Intrinsics.checkNotNullParameter(r45, "senderId");
            r43.b = r45;
            String r46 = r129.getName();
            Intrinsics.checkNotNullParameter(r46, "name");
            r43.d = r46;
            String r47 = r129.getAvatarKey();
            Intrinsics.checkNotNullParameter(r47, "avatarKey");
            r43.c = r47;
            r127.add(new e5b.a(r43));
            r3 = r132;
            r39 = r131;
            r41 = r210;
            r40 = r40;
            goto L87
        L94:
            MergeForwardContent r133 = r3;
            r115.setThreadMergeForwardSimplifyReplies(r127);
        L96:
            long r134 = r113.getSyncToChatThreadRootId();
            MergeForwardContent r48 = null;
            if (r134 == 0) goto L99;
            MessageInfo r49 = ImSdkService.f().p(String.valueOf(r134));
        L100:
            r115.setThreadParentMessageInfo(r49);
            Content r50 = r115.getMessage().getContent();
            if ((r50 instanceof MergeForwardContent) == false) goto L103;
            r48 = (MergeForwardContent) r50;
        L103:
            if (r48 == null) goto L105;
            r48.setFromType(r5);
        L105:
            r28.add(r115);
            r29.put(r113.getId(), r115);
            Message r51 = (Message) r24.get(r115.getId());
            if (r51 == null) goto L109;
            r115.setTranslateInfo(new TranslateInfo(r51.getId(), r51.getTranslateLanguage(), r51.getContent()));
            r115.getMessage().setTranslateLanguage(r51.getTranslateLanguage());
            r115.getMessage().setTranslateDisplayRule(r51.getTranslateDisplayRule());
            r115.getMessage().setTranslatedManually(r51.isTranslatedManually());
            r115.getMessage().setIsUnTranslatable(r51.isUntranslatable());
        L109:
            Message r52 = r115.getMessage();
            String r53 = r52.getParentId();
            if (r.a(r53) == true) goto L112;
        L114:
            String r54 = r52.getRootId();
            if (r.a(r54) == false) goto L120;
            if (r29.containsKey(r54) == false) goto L120;
            r115.setRootMessageInfo((MessageInfo) r29.get(r54));
        L120:
            r3 = r133;
            r7 = r125;
            r30 = r126;
            goto L57
        L112:
            if (r29.containsKey(r53) == false) goto L114;
            r115.setParentMessageInfo((MessageInfo) r29.get(r53));
            goto L114
        L99:
            r49 = null;
            goto L100
        L95:
            r133 = r3;
        L80:
            r35 = false;
            goto L81
        L119:
            r133 = r3;
            r125 = r7;
            r126 = r30;
            goto L120
        L121:
            com.ss.android.lark.chat.mergeforward.c.a(r6, true);
            r2.onSuccess(new ChatMessageResponse(r28, CollectionsKt.emptyList()));
            return;
        L15:
            if (r7.isEmpty() == true) goto L18;
            r10 = false;
        L122:
            r2.onError(new ErrorResult("Message or chatterInfo is empty"));
            return;
        L8:
            if (r8.isEmpty() == true) goto L11;
            r9 = false;
            goto L12
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

    public final void a(q<x4b.a<MessageInfo>, MessageInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
    }

    public final boolean canLoadMore() {
        return false;
    }

    public final boolean canLoadPre() {
        return false;
    }

    public final void e(q<x4b.a<MessageInfo>, MessageInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
    }

    public final void c(IGetDataCallback<ChatMessageResponse> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.c.execute(new c(this, r3));
    }

    public final void d(List<Integer> r2, IGetDataCallback<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "missingPositions");
        Intrinsics.checkNotNullParameter(r3, "callback");
        y0.a.a(r2, r3);
    }

    public final void b(int r1, boolean r2, q<x4b.a<MessageInfo>, MessageInfo> r3) {
        Intrinsics.checkNotNullParameter(r3, "receiver");
        Intrinsics.checkNotNullParameter(r3, "receiver");
    }

    public a(BasePageStore r2, v r3, FlowMergeForwardViewModel r4, d r5, d r6, CallbackManager r7, String r8, MutableLiveData r9) {
        Intrinsics.checkNotNullParameter(r2, "pageStore");
        Intrinsics.checkNotNullParameter(r3, "chatAppContainer");
        Intrinsics.checkNotNullParameter(r4, "mergeForwardViewModel");
        Intrinsics.checkNotNullParameter(r5, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(r6, "workExecutor");
        Intrinsics.checkNotNullParameter(r7, "callbackManager");
        Intrinsics.checkNotNullParameter(r8, "chatId");
        Intrinsics.checkNotNullParameter(r9, "currentChatLiveData");
        this.a = r3;
        this.b = r4;
        this.c = r6;
        this.d = r8;
    }
}
