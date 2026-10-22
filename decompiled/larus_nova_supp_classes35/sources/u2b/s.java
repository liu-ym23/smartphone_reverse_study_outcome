package u2b;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.n0;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.utils.g0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s implements y6b.d<ThreadForwardContentVOV2> {

    public static final class a {
    }

    static {
    }

    public s() {
    }

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.MERGE_FORWARD;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List f(MergeForwardContent r18) {
        List<Message> r0 = r18.getMessages();
        String r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        ArrayList r2 = new ArrayList();
        Context r3 = ChatCoreModule.a().getContext();
        int r4 = UIUtils.getColor(r3, 2131106607);
        int r5 = Math.max(r0.size() - 5, 1);
        int r7 = r0.size();
    L6:
        if (r5 >= r7) goto L61;
        Message r8 = (Message) ListProtector.get(r0, r5);
        CharSequence r9 = g0.b(r3, r8, r4);
        String r10 = BuildConfig.FLAVOR;
        if (r9 != null) goto L10;
        r9 = BuildConfig.FLAVOR;
    L10:
        y6b.f.a r11 = new y6b.f.a();
        String r12 = r8.getId();
        Intrinsics.checkNotNullParameter(r12, "messageId");
        ((n0.a) r11).a = r12;
        Intrinsics.checkNotNullParameter(r9, "content");
        ((n0.a) r11).e = r9;
        ((n0.a) r11).f = r8.getThreadPosition();
        String r13 = r8.getFromId();
        boolean r14 = false;
        if (r13.length() != 0) goto L13;
        boolean r15 = true;
    L15:
        if (r15 == false) goto L17;
        Log.e("NewThreadForwardMsgConverter", "getSimplifiedThreadReplyList, message id = " + r8.getId() + ", sender id is empty");
    L60:
        r5 = r5 + 1;
        r1 = null;
        goto L6
    L17:
        Map<String, ChatterInfo> r16 = r18.getChatters();
        if (r16 == null) goto L20;
        ChatterInfo r17 = r16.get(r13);
    L21:
        Chatter r19 = r18.getReactionChatterMap().get(r13);
        if (r17 == 0) goto L25;
        String r110 = r17.getName();
        if (r110 == null) goto L25;
    L30:
        String r111 = r110;
    L31:
        if (r17 == 0) goto L36;
        String r112 = r17.getAvatarKey();
        if (r112 == null) goto L36;
    L35:
        r10 = r112;
    L41:
        if (r111.length() <= 0) goto L43;
        boolean r113 = true;
    L44:
        if (r113 == true) goto L46;
    L51:
        StringBuilder r114 = new StringBuilder("getSimplifiedThreadReplyList failed: message is ");
        r114.append(r8.getId());
        r114.append(", senderId is ");
        r114.append(r13);
        r114.append(",sender name is empty = ");
        if (r111.length() != 0) goto L54;
        boolean r6 = true;
    L55:
        r114.append(r6);
        r114.append(", avatar key is empty = ");
        if (r10.length() != 0) goto L58;
        r14 = true;
    L58:
        r114.append(r14);
        Log.e("NewThreadForwardMsgConverter", r114.toString());
    L59:
        y6b.f r20 = new y6b.f(r11);
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.SimplifiedThreadReply");
        r2.add(r20);
        goto L60
    L54:
        r6 = false;
        goto L55
    L46:
        if (r10.length() <= 0) goto L48;
        boolean r115 = true;
    L49:
        if (r115 == false) goto L51;
        Intrinsics.checkNotNullParameter(r13, "senderId");
        ((n0.a) r11).b = r13;
        String r116 = r111;
        Intrinsics.checkNotNullParameter(r116, IPortraitService.NAME);
        ((n0.a) r11).d = r116;
        Intrinsics.checkNotNullParameter(r10, "avatarKey");
        ((n0.a) r11).c = r10;
        goto L59
    L48:
        r115 = false;
        goto L49
    L43:
        r113 = false;
    L36:
        if (r19 == null) goto L38;
        r112 = r19.getAvatarKey();
    L39:
        if (r112 != null) goto L35;
    L38:
        r112 = r1;
    L25:
        if (r19 == null) goto L27;
        r110 = r19.getNameWithAnotherName();
    L28:
        if (r110 != null) goto L30;
        r111 = BuildConfig.FLAVOR;
        goto L31
    L27:
        r110 = r1;
        goto L28
    L20:
        r17 = r1;
        goto L21
    L13:
        r15 = false;
        goto L15
    L61:
        return r2;
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    @Override // y6b.d
    public final CharSequence d(f5b.b r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return UIHelper.getString(2131891921);
    }

    public static Message e(MergeForwardContent r6, Thread r7) {
        List<Message> r8 = r6.getMessages();
        List<Message> r0 = r8;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Object r3 = null;
        if (r2 == false) goto L14;
        Log.e("NewThreadForwardMsgConverter", "getRootMessage failed: messages is empty, threadId is " + r7.id);
        return null;
    L14:
        if (r7.id.length() == 0) goto L17;
        r1 = false;
    L17:
        if (r1 == true) goto L19;
        Iterator<T> r4 = r8.iterator();
    L22:
        if (r4.hasNext() == false) goto L26;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((Message) r5).getId(), r7.id) == false) goto L22;
        r3 = r5;
    L26:
        Message r9 = (Message) r3;
        if (r9 == null) goto L29;
        return r9;
    L29:
        return (Message) ListProtector.get(r8, 0);
    L19:
        return (Message) ListProtector.get(r8, 0);
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // y6b.d
    public final v5b.a c(v r14, f5b.b r15) {
        Intrinsics.checkNotNullParameter(r14, "containerOwner");
        Intrinsics.checkNotNullParameter(r15, "messageInfo");
        Message r0 = r15.getMessage();
        MergeForwardContent r1 = (MergeForwardContent) r0.getContent();
        Thread r2 = r1.getThread();
        if (r2 == null) goto L83;
        Chat r4 = r1.getOriginChat();
        ThreadForwardContentVOV2 r5 = new ThreadForwardContentVOV2(r1);
        r5.f = r0.getTranslateDisplayRule();
        r5.c = r15.isTranslating();
        r5.d = r0.isTranslatedManually();
        r5.b = r0.getTranslateLanguage();
        Message r3 = e(r1, r2);
        if (r3 == null) goto L84;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r5.h = r3;
        String r7 = r3.getFromId();
        boolean r8 = false;
        if (r7 != null) goto L11;
    L14:
        boolean r10 = true;
    L16:
        if (r10 == false) goto L18;
        Log.e("NewThreadForwardMsgConverter", "getSender failed: root message from id is empty, root message id is " + r3.getId());
    L33:
        ChatterInfo r6 = null;
    L34:
        if (r6 == null) goto L85;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.i = r6;
        String r9 = BuildConfig.FLAVOR;
        if (r4 == null) goto L40;
        String r11 = r4.getId();
        if (r11 == null) goto L40;
    L41:
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r5.k = r11;
        if (r4 == null) goto L45;
        String r12 = r4.getAvatarKey();
        if (r12 == null) goto L45;
    L46:
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r5.l = r12;
        if (r4 != null) goto L50;
    L62:
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r5.j = r9;
        if (r4 != null) goto L65;
    L71:
        r5.m = r8;
        r5.n = r2.reply_count.intValue();
        r5.o = f(r1);
        r5.h.setThreadForwardRootMessage(true);
        TranslateInfo r16 = r15.getTranslateInfo();
        if (w.a(r14).C().isEnable("messenger.message.threadforward_supports_translation") == false) goto L82;
        if (r16 == null) goto L75;
        MergeForwardContent r17 = (MergeForwardContent) r16.getTranslateContent();
    L76:
        if (r17 == null) goto L82;
        ThreadForwardContentVOV2 r18 = new ThreadForwardContentVOV2((MergeForwardContent) r16.getTranslateContent());
        r18.b = r16.getLanguage();
        r5.g = r18;
        Message r13 = e((MergeForwardContent) r16.getTranslateContent(), r2);
        if (r13 == null) goto L86;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r18.h = r13;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r18.i = r6;
        String r19 = r5.k;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r18.k = r19;
        String r20 = r5.l;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r18.l = r20;
        String r21 = r5.j;
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r18.j = r21;
        r18.m = r5.m;
        r18.n = r5.n;
        r18.o = f((MergeForwardContent) r16.getTranslateContent());
        goto L82
    L86:
        return null;
    L75:
        r17 = null;
    L82:
        return r5;
    L65:
        if (r4.isGroup() == false) goto L71;
        if (r4.isMember() == false) goto L69;
    L70:
        r8 = true;
        goto L71
    L69:
        if (r4.isPublic() == false) goto L71;
    L50:
        if (r4.isPublic() == false) goto L53;
        r9 = r4.getName();
        goto L62
    L53:
        if (r4.isMember() == false) goto L62;
        if (r4.isSoloChat() == false) goto L59;
        String r22 = UIHelper.getString(2131891127);
        ICUUtils.FormatArgsBuilder r110 = new ICUUtils.FormatArgsBuilder();
        r110.b("user", r4.getName());
        r9 = ICUUtils.icuFormat(r22, r110.a);
        Intrinsics.checkNotNull(r9);
        goto L62
    L59:
        if (r4.isP2PChat() == false) goto L61;
        String r23 = UIHelper.getString(2131891128);
        ICUUtils.FormatArgsBuilder r111 = new ICUUtils.FormatArgsBuilder();
        r111.b("user1", r1.getP2pThreadCreatorName());
        r111.b("user2", r1.getP2pThreadPartnerName());
        r9 = ICUUtils.icuFormat(r23, r111.a);
        Intrinsics.checkNotNull(r9);
        goto L62
    L61:
        r9 = r4.getName();
    L45:
        r12 = BuildConfig.FLAVOR;
    L40:
        r11 = BuildConfig.FLAVOR;
        goto L41
    L85:
        return null;
    L18:
        Map<String, ChatterInfo> r112 = r1.getChatters();
        if (r112 == null) goto L21;
        ChatterInfo r113 = r112.get(r7);
    L22:
        if (r113 == null) goto L27;
        Map<String, ChatterInfo> r24 = r1.getChatters();
        if (r24 == null) goto L33;
        r6 = r24.get(r7);
        goto L34
    L27:
        if (r1.getReactionChatterMap().get(r7) == null) goto L32;
        Chatter r25 = r1.getReactionChatterMap().get(r7);
        if (r25 == null) goto L33;
        ChatterInfo r26 = new ChatterInfo();
        r26.setId(r25.getId());
        r26.setName(r25.getNameWithAnotherName());
        r26.setAvatarKey(r25.getAvatarKey());
        r26.setAnonymous(r25.isAnonymous());
        r26.setType(r25.getType());
        r6 = r26;
        goto L34
    L32:
        Log.e("NewThreadForwardMsgConverter", "getSender failed: chatters is empty, root message id is " + r3.getId());
        goto L33
    L21:
        r113 = null;
        goto L22
    L11:
        if (r7.length() == 0) goto L14;
        r10 = false;
        goto L16
    L84:
        return null;
    L83:
        return null;
    }
}
