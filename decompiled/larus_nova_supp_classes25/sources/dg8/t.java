package dg8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.helper.n0;
import com.larus.bmhome.utils.w2;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.CommonButtonV2Block;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t {
    public static final boolean a(Message r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r3 = false;
        if (r1 == null) goto L7;
        r1.a();
        if (com.larus.home.impl.sdk.o.a.r() != true) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        return false;
    L10:
        List r4 = r10.getContentBlock();
        String r5 = null;
        if (r4 == null) goto L31;
        Iterator r6 = r4.iterator();
    L14:
        if (r6.hasNext() == false) goto L29;
        Object r7 = r6.next();
        Block r8 = (Block) r7;
        if (r8.getBlockType() != BlockType.BLOCK_TYPE_COMMON_BUTTON_V2.getValue()) goto L26;
        BlockContent r9 = r8.getContent();
        if (r9 == null) goto L22;
        CommonButtonV2Block r11 = r9.getCommonButtonBlock();
        if (r11 == null) goto L22;
        String r12 = r11.getScene();
    L24:
        if (Intrinsics.areEqual(r12, "document_apply_permission") == false) goto L26;
        boolean r13 = true;
    L27:
        if (r13 == false) goto L14;
    L30:
        Block r14 = (Block) r7;
    L32:
        if (r14 == null) goto L34;
        r3 = true;
    L34:
        if (r3 == false) goto L36;
        JSONObject r15 = new JSONObject();
        r15.put("scene", "document_apply_permission");
        r15.put("ban_scene", "long_click");
        by7.a r16 = new by7.a("doc_permission_apply_button_ban_ability");
        r16.a.merge(new TrackParams().merge(r15));
        r16.b();
    L36:
        if (r3 == false) goto L38;
        return true;
    L38:
        Regex r17 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Map r18 = r10.getBusinessExt();
        if (r18 == null) goto L42;
        r5 = (String) r18.get("is_smart_reply_message");
    L42:
        return Intrinsics.areEqual(r5, "1");
    L22:
        r12 = null;
    L26:
        r13 = false;
        goto L27
    L29:
        r7 = null;
        goto L30
    L31:
        r14 = null;
    L7:
        r2 = false;
        goto L8
    }

    public static final boolean b(List<AnswerAction> r4) {
        List<AnswerAction> r0 = r4;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        Iterator<T> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(((AnswerAction) r5.next()).getKey(), "user_break") == false) goto L13;
        return true;
    L17:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final Message c(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (com.larus.bmhome.chat.bean.d.x0(r3) == false) goto L14;
        n0 r0 = n0.a;
        String r1 = r3.getMessageId();
        r0.getClass();
        int r2 = w2.a(r1);
        List r4 = r3.getSubList();
        if (r4 == null) goto L10;
        if (r2 < 0) goto L10;
        if (r2 >= r4.size()) goto L10;
        Object r5 = ListProtector.get(r4, r2);
    L11:
        Message r6 = (Message) r5;
        if (r6 == null) goto L14;
        return r6;
    L10:
        r5 = null;
    L14:
        return r3;
    }

    public static final BotModel d(y r2) {
        BotModel r0 = null;
        if (r2 == null) goto L5;
        BotModel r1 = r2.j0();
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        if (r2 == null) goto L11;
        String r3 = r2.Y1();
        if (r3 == null) goto L11;
    L12:
        BotModel r4 = BotInfoCache.INSTANCE.get(r3);
        if (r4 == null) goto L17;
        r0 = r4;
    L17:
        return r0;
    L11:
        r3 = "";
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static final Message e(q0 r7) {
        Object r0 = null;
        if (r7 == null) goto L17;
        List r8 = r7.getCurrentList();
        if (r8 == null) goto L18;
        Iterator r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L13;
        Object r1 = r9.next();
        if (ArraysKt.contains(new Integer[]{1, 6, 1001, 9999}, Integer.valueOf(((Message) r1).getContentType())) == false) goto L8;
        r0 = r1;
    L13:
        return (Message) r0;
    L18:
        return null;
    L17:
        return null;
    }

    public static final boolean h(y r2) {
        if (r2 == null) goto L10;
        wc9.e r3 = r2.h();
        if (r3 != null) goto L7;
        return false;
    L7:
        if (ic8.n.d(r3) != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public static final boolean f(q0 r1, Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (r1 == null) goto L7;
        Message r3 = e(r1);
        if (r3 == null) goto L7;
        String r4 = r3.getMessageId();
    L9:
        if (com.larus.bmhome.chat.bean.d.G0(r2) == false) goto L11;
    L17:
        return false;
    L11:
        if (o0.d(r2.getMessageId()) == false) goto L17;
        if (Intrinsics.areEqual(r2.getMessageId(), r4) == false) goto L17;
        if (Intrinsics.areEqual(r2.getMessageId(), IAIChatService.a.e7(r2.getConversationId())) == false) goto L17;
        return true;
    L7:
        r4 = null;
        goto L9
    }

    public static final boolean i(List<AnswerAction> r1, Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (b(r1) == true) goto L5;
    L13:
        return false;
    L5:
        if (r2.getMessageStatusLocal() != 20) goto L7;
    L8:
        int r3 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r2, "message");
        if (com.larus.im.bean.message.a.r0(r2) == true) goto L13;
        if (r2.getMessageStatusLocal() == 24) goto L13;
        return true;
    L7:
        if (com.larus.bmhome.chat.bean.d.Q0(r2) == false) goto L13;
        goto L8
    }

    public static final boolean g(q0 r4, Message r5, List<AnswerAction> r6) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (b(r6) == true) goto L5;
        return false;
    L5:
        if (r4 == null) goto L9;
        Message r7 = e(r4);
        if (r7 == null) goto L9;
        String r8 = r7.getMessageId();
    L10:
        FLogger r9 = FLogger.a;
        StringBuilder r1 = new StringBuilder("isLastMsgUserBreak isSelf=");
        r1.append(com.larus.bmhome.chat.bean.d.G0(r5));
        r1.append(" lastActionMsgId=");
        r1.append(r8);
        r1.append(" msgId=");
        r1.append(r5.getMessageId());
        r1.append(" userBreakMsgId=");
        IAIChatService.Companion r2 = IAIChatService.a;
        r1.append(r2.e7(r5.getConversationId()));
        r9.i("ActionbarComponent", r1.toString());
        if (com.larus.bmhome.chat.bean.d.G0(r5) == true) goto L19;
        if (r8 != null) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(r5.getMessageId(), r8) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(r5.getMessageId(), r2.e7(r5.getConversationId())) == false) goto L22;
        return true;
    L22:
        return false;
    L19:
        return false;
    L9:
        r8 = null;
        goto L10
    }
}
