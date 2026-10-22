package bib;

import android.text.TextUtils;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.utils.e0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.threaddetail.model.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends com.ss.android.lark.chat.core.model.a<MessageInfo, x4b.a<MessageInfo>> {
    public final Message c;
    public final String d;

    /* JADX INFO: renamed from: bib.a$a, reason: collision with other inner class name */
    public static final class C0010a {
    }

    static {
    }

    public final String d() {
        return "CardVisitorThreadPageLo";
    }

    public final String b() {
        return this.d;
    }

    public final int c(f5b.b r1) {
        MessageInfo r2 = (MessageInfo) r1;
        if (r2 == null) goto L7;
        Message r3 = r2.getMessage();
        if (r3 == null) goto L7;
        return r3.getThreadPosition();
    L7:
        return -1;
    }

    public a(Message r2, String r3, Executor r4) {
        Intrinsics.checkNotNullParameter(r2, "mergeForwardMessage");
        Intrinsics.checkNotNullParameter(r3, "threadId");
        Intrinsics.checkNotNullParameter(r4, "loadExecutor");
        super(r4);
        this.c = r2;
        this.d = r3;
    }

    public final x4b.a f(MessageFetchScene r7, int r8, int r9, int r10, int r11, ChannelDataFetcherStrategy r12, String r13) {
        MergeForwardContent r14 = this.c.getContent();
        List r15 = r14.getMessages();
        Map r16 = r14.getChatters();
        Map r17 = r14.getReactionChatterMap();
        Map r18 = r14.getReactionMap();
        List r19 = r15;
        boolean r110 = false;
        if (r19 != null) goto L5;
    L8:
        boolean r111 = true;
    L10:
        if (r111 == true) goto L52;
        if (r16 != null) goto L13;
    L16:
        boolean r112 = true;
    L17:
        if (r112 == true) goto L52;
        HashMap r113 = new HashMap();
        ArrayList r1 = new ArrayList();
        Iterator r20 = r15.iterator();
    L21:
        if (r20.hasNext() == false) goto L41;
        Message r2 = (Message) r20.next();
        Chatter r3 = (Chatter) r17.get(r2.getFromId());
        if (r3 != null) goto L27;
        ChatterInfo r4 = (ChatterInfo) r16.get(r2.getFromId());
        if (r4 == null) goto L27;
        r3 = new Chatter();
        r3.setId(r4.getId());
        r3.setName(r4.getName());
        r3.setType(r4.getType());
        r3.setAvatarKey(r4.getAvatarKey());
        r3.setAnonymous(r4.isAnonymous());
        r3.setProfileEnable(true);
    L27:
        r2.setPosition(-3);
        if (r3 != null) goto L29;
        Log.e("CardVisitorThreadPageLo", "Failed to find chatterInfo, message id is:" + r2.getId());
        goto L21
    L29:
        MessageInfo r5 = new MessageInfo(r2, new ChatChatter(r3));
        r5.setReactionInfoList(e0.a((List) r18.get(r2.getId()), r17));
        r1.add(r5);
        r113.put(r2.getId(), r5);
        Message r6 = r5.getMessage();
        String r21 = r6.getParentId();
        if (TextUtils.isEmpty(r21) == false) goto L32;
    L34:
        String r22 = r6.getRootId();
        if (TextUtils.isEmpty(r22) == true) goto L21;
        if (r113.containsKey(r22) == false) goto L21;
        r5.setRootMessageInfo((MessageInfo) r113.get(r22));
        goto L21
    L32:
        if (r113.containsKey(r21) == false) goto L34;
        r5.setParentMessageInfo((MessageInfo) r113.get(r21));
        goto L34
    L41:
        if ((!r1.isEmpty()) == false) goto L53;
        Iterator r23 = r1.iterator();
        int r24 = 0;
    L44:
        if (r23.hasNext() == false) goto L53;
        Object r25 = r23.next();
        int r114 = r24 + 1;
        if (r24 >= 0) goto L48;
        CollectionsKt.throwIndexOverflow();
    L48:
        MessageInfo r26 = (MessageInfo) r25;
        r26.getMessage().setThreadId(this.d);
        r26.getMessage().setThreadPosition(r24 - 1);
        if (r24 == 0) goto L51;
        r26.getMessage().setRootId(this.d);
    L51:
        r24 = r114;
    L53:
        if (r1 != null) goto L55;
    L56:
        r110 = true;
    L57:
        if (r110 == false) goto L59;
        return null;
    L59:
        return new e(r1, CollectionsKt.emptyList(), CollectionsKt.emptyList());
    L55:
        if (r1.isEmpty() == false) goto L57;
    L13:
        if (r16.isEmpty() == true) goto L16;
        r112 = false;
    L52:
        r1 = null;
        goto L53
    L5:
        if (r19.isEmpty() == true) goto L8;
        r111 = false;
        goto L10
    }
}
