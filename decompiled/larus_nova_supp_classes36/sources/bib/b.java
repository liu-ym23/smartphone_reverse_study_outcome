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
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.utils.e0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.threaddetail.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends com.ss.android.lark.chat.core.model.a<MessageInfo, x4b.a<MessageInfo>> {
    public final MergeForwardContent c;
    public final String d;

    public static final class a {
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

    public b(MergeForwardContent r2, String r3, Executor r4) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "threadId");
        Intrinsics.checkNotNullParameter(r4, "loadExecutor");
        super(r4);
        this.c = r2;
        this.d = r3;
    }

    public final void g(Message r3, List<MessageInfo> r4, Map<String, MessageInfo> r5, Map<String, ? extends ChatterInfo> r6, Map<String, ? extends Chatter> r7, Map<String, ? extends List<? extends Reaction>> r8) {
        Chatter r0 = r7.get(r3.getFromId());
        if (r0 != null) goto L7;
        ChatterInfo r9 = r6.get(r3.getFromId());
        if (r9 == null) goto L7;
        r0 = new Chatter();
        r0.setId(r9.getId());
        r0.setName(r9.getName());
        r0.setType(r9.getType());
        r0.setAvatarKey(r9.getAvatarKey());
        r0.setAnonymous(r9.isAnonymous());
        r0.setProfileEnable(true);
    L7:
        if (r0 == null) goto L18;
        r3.setPosition(-3);
        MessageInfo r10 = new MessageInfo(r3, new ChatChatter(r0));
        r10.setReactionInfoList(e0.a(r8.get(r3.getId()), r7));
        ((ArrayList) r4).add(r10);
        r5.put(r3.getId(), r10);
        Message r11 = r10.getMessage();
        String r12 = r11.getParentId();
        if (TextUtils.isEmpty(r12) == false) goto L11;
    L13:
        String r13 = r11.getRootId();
        if (TextUtils.isEmpty(r13) == false) goto L16;
        return;
    L16:
        if (r5.containsKey(r13) == false) goto L21;
        r10.setRootMessageInfo((MessageInfo) ((LinkedHashMap) r5).get(r13));
        return;
    L21:
        return;
    L11:
        if (r5.containsKey(r12) == false) goto L13;
        r10.setParentMessageInfo((MessageInfo) ((LinkedHashMap) r5).get(r12));
        goto L13
    L18:
        Log.e("CardVisitorThreadPageLo", "Failed to find chatterInfo, message id is:" + r3.getId());
    }

    public final x4b.a f(MessageFetchScene r14, int r15, int r16, int r17, int r18, ChannelDataFetcherStrategy r19, String r20) {
        List r1 = this.c.getMessages();
        if (r1 == null) goto L11;
        ArrayList r3 = new ArrayList();
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r4 = r2.next();
        if (Intrinsics.areEqual(((Message) r4).getId(), this.d) == false) goto L6;
        r3.add(r4);
        goto L6
    L10:
        Message r5 = (Message) CollectionsKt.firstOrNull(r3);
    L12:
        boolean r6 = false;
        if (r5 == null) goto L62;
        Map<String, ? extends ChatterInfo> r7 = this.c.getChatters();
        Map<String, ? extends Chatter> r8 = this.c.getReactionChatterMap();
        if (r7 != null) goto L18;
    L21:
        boolean r9 = true;
    L22:
        if (r9 == false) goto L31;
        if (r8 != null) goto L25;
    L28:
        boolean r10 = true;
    L29:
        if (r10 == false) goto L31;
    L25:
        if (r8.isEmpty() == true) goto L28;
        r10 = false;
    L31:
        MergeForwardContent.MessageThread r11 = (MergeForwardContent.MessageThread) this.c.getMessageThreadMap().get(this.d);
        if (r11 == null) goto L62;
        List r12 = r11.getChildMessages();
        if (r12 != null) goto L36;
    L39:
        boolean r13 = true;
    L40:
        if (r13 == true) goto L62;
        LinkedHashMap r21 = new LinkedHashMap();
        ArrayList r22 = new ArrayList();
        if (r7 != null) goto L45;
        Map<String, ? extends ChatterInfo> r110 = new LinkedHashMap();
    L46:
        g(r5, r22, r21, r110, r8, this.c.getReactionMap());
        Map<String, ? extends List<? extends Reaction>> r23 = r11.getReactionMap();
        if (r23 != null) goto L49;
        r23 = new LinkedHashMap();
    L49:
        List r24 = r11.getChildMessages();
        if (r24 == null) goto L63;
        Iterator r25 = r24.iterator();
    L53:
        if (r25.hasNext() == false) goto L63;
        Message r111 = (Message) r25.next();
        if (Intrinsics.areEqual(r111.getId(), this.d) == true) goto L53;
        if (Intrinsics.areEqual(r111.getId(), this.d) == true) goto L53;
        if (r7 != null) goto L60;
        Map<String, ? extends ChatterInfo> r112 = new LinkedHashMap();
    L61:
        g(r111, r22, r21, r112, r8, r23);
        goto L53
    L60:
        r112 = r7;
    L63:
        if (r22 != null) goto L65;
    L66:
        r6 = true;
    L67:
        if (r6 == false) goto L69;
        return null;
    L69:
        return new e(r22, CollectionsKt.emptyList(), CollectionsKt.emptyList());
    L65:
        if (r22.isEmpty() == false) goto L67;
    L45:
        r110 = r7;
        goto L46
    L36:
        if (r12.isEmpty() == true) goto L39;
        r13 = false;
        goto L40
    L18:
        if (r7.isEmpty() == true) goto L21;
        r9 = false;
    L62:
        r22 = null;
        goto L63
    L11:
        r5 = null;
        goto L12
    }
}
