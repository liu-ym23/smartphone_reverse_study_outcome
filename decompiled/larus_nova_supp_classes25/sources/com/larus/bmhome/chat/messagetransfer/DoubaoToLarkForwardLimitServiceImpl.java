package com.larus.bmhome.chat.messagetransfer;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import t19.s;
import tx9.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/messagetransfer/DoubaoToLarkForwardLimitServiceImpl;", "Lcom/larus/bmhome/chat/messagetransfer/IDoubaoToLarkForwardLimitService;", "<init>", "()V", "interceptIfNeeded", "", "context", "Landroid/content/Context;", "messages", "", "Lcom/larus/im/bean/message/Message;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoubaoToLarkForwardLimitServiceImpl implements IDoubaoToLarkForwardLimitService {

    public static final class a {
    }

    static {
    }

    public DoubaoToLarkForwardLimitServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.messagetransfer.IDoubaoToLarkForwardLimitService
    public final boolean a(Context r21, List<Message> r22) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "messages");
        int r3 = ta9.a.a;
        b r4 = new b(0);
        AtomicReference r5 = ga9.a.a;
        ga9.e.a.getClass();
        b r6 = (b) ga9.e.a(ga9.a.c("merge_forward_limit", ga9.e.c(r4)), b.class, r4);
        ArrayList r7 = new ArrayList();
        Iterator<T> r0 = r22.iterator();
    L3:
        Object r8 = null;
        long r9 = 0;
        if (r0.hasNext() == false) goto L47;
        Message r10 = (Message) r0.next();
        String r11 = r10.getMessageId();
        if (r11 == null) goto L44;
        Long r12 = StringsKt.toLongOrNull(r11);
        if (r12 == null) goto L44;
        long r13 = r12.longValue();
        List r14 = r10.getContentBlock();
        if (r14 != null) goto L12;
    L18:
        String r15 = r10.getContent();
    L19:
        int r16 = c.a;
        if (r15 != null) goto L22;
        r15 = "";
    L22:
        int r17 = 0;
    L24:
        if (r17 >= r15.length()) goto L43;
        char r18 = r15.charAt(r17);
        if (r18 >= 128) goto L29;
    L40:
        long r19 = 1;
    L42:
        r9 = r9 + r19;
        r17 = r17 + 1;
        goto L24
    L29:
        if (r18 >= 2048) goto L32;
        r19 = 2;
        goto L42
    L32:
        if (Character.isHighSurrogate(r18) == false) goto L39;
        int r110 = r17 + 1;
        if (r110 >= r15.length()) goto L39;
        if (Character.isLowSurrogate(r15.charAt(r110)) == false) goto L39;
        r17 = r110;
        r19 = 4;
    L39:
        if (CharsKt.isSurrogate(r18) == true) goto L40;
        r19 = 3;
        goto L42
    L43:
        r8 = new i(r13, r9);
        goto L44
    L12:
        if ((!r14.isEmpty()) == false) goto L14;
        r8 = r14;
    L14:
        if (r8 == null) goto L18;
        r15 = zd9.i.c(r8, kuc.a.b(Block.Companion.serializer()));
        if (r15 == null) goto L18;
    L44:
        if (r8 == null) goto L3;
        r7.add(r8);
        goto L3
    L47:
        int r1 = c.a;
        Intrinsics.checkNotNullParameter(r7, "messages");
        HashSet r2 = new HashSet();
        ArrayList r20 = new ArrayList();
        Iterator r23 = r7.iterator();
    L49:
        if (r23.hasNext() == false) goto L53;
        Object r24 = r23.next();
        if (r2.add(Long.valueOf(((i) r24).a)) == false) goto L49;
        r20.add(r24);
        goto L49
    L53:
        int r25 = r20.size();
        Iterator r26 = r20.iterator();
        long r27 = 0;
    L55:
        if (r26.hasNext() == false) goto L60;
        long r111 = ((i) r26.next()).b;
        if (r27 > (Long.MAX_VALUE - r111)) goto L58;
        r27 = r27 + r111;
        goto L55
    L58:
        r27 = Long.MAX_VALUE;
        goto L55
    L60:
        h r28 = new h(r25, r27);
        Integer r29 = Integer.valueOf(r6.a());
        if (r29.intValue() <= 0) goto L63;
        boolean r112 = true;
    L64:
        if (r112 == true) goto L67;
        r29 = null;
    L67:
        int r113 = 20;
        if (r29 == null) goto L70;
        int r30 = r29.intValue();
    L71:
        Long r31 = Long.valueOf(r6.b());
        if (r31.longValue() <= 0) goto L74;
        boolean r114 = true;
    L75:
        if (r114 == true) goto L78;
        r31 = null;
    L78:
        long r115 = 1000000;
        if (r31 == null) goto L81;
        long r116 = r31.longValue();
    L82:
        int r32 = c.a;
        Intrinsics.checkNotNullParameter(r28, "selectionStats");
        Integer r33 = Integer.valueOf(r30);
        if (r33.intValue() <= 0) goto L85;
        boolean r34 = true;
    L86:
        if (r34 == true) goto L89;
        r33 = null;
    L89:
        if (r33 == null) goto L91;
        r113 = r33.intValue();
    L91:
        if (r25 <= r113) goto L93;
        g r35 = new g.a(r25);
    L107:
        if (r35 != null) goto L110;
        String r117 = "allowed";
    L115:
        FLogger r118 = FLogger.a;
        StringBuilder r119 = new StringBuilder("doubao to lark forward attempt, stage=limit_check, intercepted=");
        if (r35 == null) goto L118;
        boolean r120 = true;
    L119:
        r119.append(r120);
        r119.append(", reason=");
        r119.append(r117);
        r119.append(", messageCount=");
        r119.append(r25);
        r119.append(", totalContentSizeBytes=");
        r119.append(r27);
        r119.append(", selectCountLimit=");
        r119.append(r30);
        r119.append(", sizeLimitBytes=");
        r119.append(r116);
        r118.i("DoubaoToLarkForwardLimit", r119.toString());
        if (r35 != null) goto L124;
        return false;
    L124:
        if ((r35 instanceof g.a) == false) goto L128;
        ConcurrentHashMap r36 = v0.a;
        v0.g("select_count_limit", Integer.valueOf(((g.a) r35).a), null, 4);
        String r37 = r21.getString(2131898131, new Object[]{Integer.valueOf(r30)});
    L126:
        String r38 = r37;
        Intrinsics.checkNotNull(r38);
        s.j(s.a, r21, r38, null, false, 28);
        return true;
    L128:
        if ((r35 instanceof g.b) == false) goto L133;
        ConcurrentHashMap r39 = v0.a;
        v0.g("size_limit", null, Long.valueOf(((g.b) r35).a), 2);
        r37 = r21.getString(2131898132);
        goto L126
    L133:
        throw new NoWhenBranchMatchedException();
    L118:
        r120 = false;
        goto L119
    L110:
        if ((r35 instanceof g.a) == false) goto L113;
        r117 = "select_count_limit";
        goto L115
    L113:
        if ((r35 instanceof g.b) == false) goto L135;
        r117 = "size_limit";
        goto L115
    L135:
        throw new NoWhenBranchMatchedException();
    L93:
        Long r40 = Long.valueOf(r116);
        if (r40.longValue() <= 0) goto L96;
        boolean r41 = true;
    L97:
        if (r41 == true) goto L100;
        r40 = null;
    L100:
        if (r40 == null) goto L103;
        r115 = r40.longValue();
    L103:
        if (r27 <= r115) goto L105;
        r35 = new g.b(r27);
        goto L107
    L105:
        r35 = null;
        goto L107
    L96:
        r41 = false;
        goto L97
    L85:
        r34 = false;
        goto L86
    L81:
        r116 = 1000000;
        goto L82
    L74:
        r114 = false;
        goto L75
    L70:
        r30 = 20;
        goto L71
    L63:
        r112 = false;
        goto L64
    }
}
