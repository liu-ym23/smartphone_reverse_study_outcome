package q3b;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n extends com.ss.android.lark.chat.core.model.a<MessageInfo, x4b.a<MessageInfo>> {
    public final com.ss.android.lark.im.sdk.service.p c;
    public final String d;

    @Override // com.ss.android.lark.chat.core.model.a
    public final String d() {
        return "ChatWindow";
    }

    @Override // com.ss.android.lark.chat.core.model.a
    public final String b() {
        return this.d;
    }

    public static int g(List<MessageInfo> r3) {
        int r1 = 0;
        if (idb.f.a().isCurrentEnable("openplatform.universal_card.enter_chat_monitor") == true) goto L5;
        return 0;
    L5:
        Iterator<MessageInfo> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        if (r4.next().getMessage().getType() != Message.Type.CARD) goto L7;
        r1 = r1 + 1;
        goto L7
    L11:
        return r1;
    }

    @Override // com.ss.android.lark.chat.core.model.a
    public final int c(f5b.b r1) {
        return ((MessageInfo) r1).getMessage().getPosition();
    }

    public n(com.ss.android.lark.im.sdk.service.p r1, Executor r2, String r3) {
        super(r2);
        this.c = r1;
        this.d = r3;
    }

    @Override // com.ss.android.lark.chat.core.model.a
    public final x4b.a f(MessageFetchScene r10, int r11, int r12, int r13, int r14, ChannelDataFetcherStrategy r15, String r16) {
        com.ss.android.lark.im.sdk.service.a.a r3 = new com.ss.android.lark.im.sdk.service.a.a();
        r3.a(this.d);
        r3.b(r10);
        r3.c = r11;
        r3.d = r12;
        r3.e = r13;
        r3.f = r14;
        r3.g = true;
        r3.c(r15);
        Intrinsics.checkNotNullParameter(r16, "contextId");
        r3.i = r16;
        ChatMessageResponse r2 = this.c.x2(new com.ss.android.lark.im.sdk.service.a(r3));
        if (r2 == null) goto L13;
        g(r2.messageInfoList);
        ChatCoreModule.a().getPerfEnterChatMonitor().b(r2.sdkCost, r2.clientDataCost, r2.netCosts);
        e r4 = new e(r2.messageInfoList, r2.invisiblePositions, r2.missingPositions, r2.showExpiredPeriod, r2.messagesSyncPipeFinished);
        List<MessageInfo> r5 = r2.messageInfoList;
        if (r10 != MessageFetchScene.FIRST_SCREEN) goto L7;
    L9:
        Log.i("ChatWindow", "print first page data begin, scene:" + r10.getDesc());
        Iterator<MessageInfo> r1 = r5.iterator();
    L11:
        if (r1.hasNext() == false) goto L17;
        Log.i("ChatWindow", "load message:" + r1.next().getMessage());
        goto L11
    L17:
        return r4;
    L7:
        if (r10 == MessageFetchScene.SPECIFIED_POSITION) goto L9;
        return r4;
    L13:
        return null;
    }
}
