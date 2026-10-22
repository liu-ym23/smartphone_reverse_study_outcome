package bg8;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.collection.o;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.list.cell.sticker.StickerImageCell;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ StickerImageCell a;

    public /* synthetic */ g(StickerImageCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        StickerImageCell r0 = this.a;
        Message r11 = (Message) r10;
        y r1 = (y) r0.f.getValue();
        String r2 = null;
        if (r1 == null) goto L5;
        BotModel r3 = r1.j0();
    L6:
        y r4 = (y) r0.f.getValue();
        if (r4 == null) goto L9;
        wc9.e r5 = r4.h();
    L10:
        Pair[] r6 = new Pair[9];
        boolean r7 = false;
        r6[0] = TuplesKt.to("user_type", "bot");
        String r8 = "chat";
        r6[1] = TuplesKt.to("enter_picture_method", "chat");
        o r9 = (o) r0.g.getValue();
        if (r9 != null) goto L13;
    L15:
        if (r7 == false) goto L17;
        r8 = "temporary_chat";
    L17:
        r6[2] = TuplesKt.to("enter_from", r8);
        String r12 = "";
        if (r11 == null) goto L21;
        String r13 = r11.getMessageId();
        if (r13 == null) goto L21;
    L22:
        r6[3] = TuplesKt.to("message_id", r13);
        if (r11 == null) goto L26;
        String r14 = r11.getConversationId();
        if (r14 == null) goto L26;
    L27:
        r6[4] = TuplesKt.to("conversation_id", r14);
        if (r3 == null) goto L31;
        String r15 = r3.getBotId();
        if (r15 == null) goto L31;
    L32:
        r6[5] = TuplesKt.to("bot_id", r15);
        ChatControlTrace r16 = ChatControlTrace.b;
        if (r5 == null) goto L35;
        Integer r17 = r5.v;
    L36:
        if (r3 == null) goto L38;
        Integer r18 = r3.getBotType();
    L39:
        if (r3 == null) goto L43;
        BotCreatorInfo r19 = r3.getBotCreatorInfo();
        if (r19 == null) goto L43;
        r2 = r19.getId();
    L43:
        r6[6] = TuplesKt.to("chat_type", r16.g(r17, r18, Intrinsics.areEqual(r2, AccountService.a.getUserId())));
        ChatParam r110 = (ChatParam) r0.j.getValue();
        if (r110 == null) goto L47;
        String r111 = r110.d;
        if (r111 == null) goto L47;
    L48:
        r6[7] = TuplesKt.to("current_page", r111);
        ChatParam r112 = (ChatParam) r0.j.getValue();
        if (r112 == null) goto L54;
        String r113 = r112.c;
        if (r113 == null) goto L54;
        r12 = r113;
    L54:
        r6[8] = TuplesKt.to("previous_page", r12);
        return MapsKt.mapOf(r6);
    L47:
        r111 = "";
        goto L48
    L38:
        r18 = null;
        goto L39
    L35:
        r17 = null;
    L31:
        r15 = "";
    L26:
        r14 = "";
    L21:
        r13 = "";
        goto L22
    L13:
        if (r9.i0() != true) goto L15;
        r7 = true;
        goto L15
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
