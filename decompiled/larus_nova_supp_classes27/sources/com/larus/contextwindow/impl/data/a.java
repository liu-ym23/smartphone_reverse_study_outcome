package com.larus.contextwindow.impl.data;

import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.s0;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.u0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.contextwindow.api.ContextWindowContainer;
import com.larus.contextwindow.api.ContextWindowMessageSnapshot;
import com.larus.contextwindow.api.ContextWindowMode;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.GenericToolBlock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static v29.a a(boolean r25, ContextWindowContainer r26, String r27, String r28, List r210, ReplyOption r30, List r31) {
        Intrinsics.checkNotNullParameter(r26, "container");
        Intrinsics.checkNotNullParameter(r27, "conversationId");
        Intrinsics.checkNotNullParameter(r210, "messages");
        Intrinsics.checkNotNullParameter(r31, "actionBarItems");
        int r3 = d.a;
        Intrinsics.checkNotNullParameter(r31, "actionBarItems");
        if (r30 == null) goto L90;
        ModelItemIdentity r9 = r30.getModel();
        if (r9 == null) goto L90;
        Iterator r1 = r31.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        Object r10 = r1.next();
        if (Intrinsics.areEqual(((z0) r10).b, "coco_deep_thinking") == false) goto L9;
    L14:
        z0 r11 = (z0) r10;
        if (r11 == null) goto L17;
        p0 r2 = r11.o;
    L18:
        if (r2 == null) goto L20;
        boolean r12 = Intrinsics.areEqual(r2.k, Boolean.TRUE);
    L21:
        if (r12 == false) goto L53;
        s0 r13 = r2.j;
        if (r13 == null) goto L38;
        u0 r14 = r13.a;
        if (r14 == null) goto L38;
        ArrayList r15 = r14.a;
        if (r15 == null) goto L38;
        Iterator r16 = r15.iterator();
    L30:
        if (r16.hasNext() == false) goto L34;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((t0) r17).a, r30.getModeId()) == false) goto L30;
    L35:
        t0 r18 = (t0) r17;
        if (r18 == null) goto L38;
        Integer r110 = r18.j;
    L39:
        int r111 = AgentMode.MOA.getValue();
        if (r110 != null) goto L43;
    L45:
        int r112 = AgentMode.CHAT.getValue();
        if (r110 != null) goto L49;
    L51:
        ContextWindowMode r113 = ContextWindowMode.UNKNOWN;
    L60:
        if (r113 == ContextWindowMode.SUPPORTED) goto L62;
        c r4 = new c(r113, null);
    L91:
        ContextWindowMode r20 = r4.a;
        Long r5 = r4.b;
        List r0 = r210;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r6 = r0.iterator();
    L93:
        if (r6.hasNext() == false) goto L181;
        Message r115 = (Message) r6.next();
        boolean r21 = com.larus.im.bean.message.a.w0(r115);
        String r116 = r115.getConversationId();
        if (r116 != null) goto L97;
        String r117 = "";
    L98:
        String r118 = r115.getMessageId();
        if (r118 != null) goto L101;
    L105:
        r118 = r115.getLocalMessageId();
        if (r118 != null) goto L108;
        String r119 = "";
    L109:
        Long r120 = Long.valueOf(r115.getServerIndex());
        if (r120.longValue() <= 0) goto L112;
        boolean r121 = true;
    L113:
        if (r121 == true) goto L116;
        r120 = null;
    L116:
        if (r120 == null) goto L118;
        long r122 = r120.longValue();
    L119:
        long r123 = r122;
        boolean r124 = com.larus.bmhome.chat.bean.d.G0(r115);
        boolean r125 = com.larus.bmhome.chat.bean.d.U(r115);
        if (com.larus.bmhome.chat.bean.d.i0(r115) == false) goto L125;
        if (com.larus.bmhome.chat.bean.d.w(r115) == true) goto L125;
    L144:
        boolean r22 = false;
    L145:
        String r23 = r115.getReplyId();
        Map r126 = r115.getExt();
        if (r126 == null) goto L148;
        String r24 = (String) r126.get("context_window_usage");
    L149:
        int r127 = b.a;
        List r128 = r115.getContentBlock();
        if (r21 == false) goto L178;
        if (r128 != null) goto L154;
        r128 = CollectionsKt.emptyList();
    L154:
        List r129 = CollectionsKt.asReversed(r128);
        if ((r129 instanceof Collection) == true) goto L157;
    L159:
        Iterator r130 = r129.iterator();
    L161:
        if (r130.hasNext() == false) goto L178;
        Block r131 = (Block) r130.next();
        if (r131.getBlockType() != BlockType.BLOCK_TYPE_GENERIC_TOOL.getValue()) goto L175;
        BlockContent r7 = r131.getContent();
        if (r7 == null) goto L169;
        GenericToolBlock r8 = r7.getGenericToolBlock();
        if (r8 == null) goto L169;
        String r32 = r8.toolName;
    L171:
        if (Intrinsics.areEqual(r32, "MemoryEventTool") == false) goto L175;
        if (r131.isFinish() == true) goto L175;
        boolean r33 = true;
    L176:
        if (r33 == false) goto L161;
        boolean r34 = true;
    L179:
        r114.add(new ContextWindowMessageSnapshot(r117, r119, r123, r124, r125, r22, r21, r23, r24, r34));
    L169:
        r32 = null;
    L175:
        r33 = false;
        goto L176
    L157:
        if (r129.isEmpty() == false) goto L159;
    L178:
        r34 = false;
        goto L179
    L148:
        r24 = null;
    L125:
        if (com.larus.bmhome.chat.bean.d.T(r115) == true) goto L144;
        if (com.larus.bmhome.chat.bean.d.p0(r115) == true) goto L144;
        if (com.larus.bmhome.chat.bean.d.C0(r115) == true) goto L132;
    L134:
        MessageStatus r132 = r115.getMessageStatus();
        if (r132 != null) goto L137;
    L139:
        boolean r133 = false;
    L140:
        if (r133 == false) goto L142;
    L143:
        r22 = true;
        goto L145
    L142:
        if (b0.f(r115) == false) goto L144;
    L137:
        if (r132.isVisible() != true) goto L139;
        r133 = true;
        goto L140
    L132:
        if (r115.getRegenVisible() == true) goto L134;
    L118:
        r122 = r115.getLocalIndex();
        goto L119
    L112:
        r121 = false;
    L108:
        r119 = r118;
        goto L109
    L101:
        if ((!StringsKt.isBlank(r118)) == true) goto L104;
        r118 = null;
    L104:
        if (r118 != null) goto L108;
    L97:
        r117 = r116;
        goto L98
    L181:
        return new v29.a(r25, r27, r28, r26, r20, r5, r114);
    L62:
        if (r2 == null) goto L88;
        a2 r35 = r2.d();
        if (r35 == null) goto L88;
        ArrayList r36 = r35.a;
        if (r36 == null) goto L88;
        Iterator r37 = r36.iterator();
    L69:
        if (r37.hasNext() == false) goto L73;
        Object r134 = r37.next();
        if (Intrinsics.areEqual(((b2) r134).b(), r9) == false) goto L69;
    L74:
        b2 r135 = (b2) r134;
        if (r135 == null) goto L88;
        Map r38 = r135.p;
        if (r38 == null) goto L88;
        String r40 = (String) r38.get("total_window_size");
        if (r40 == null) goto L88;
        Long r41 = StringsKt.toLongOrNull(r40);
        if (r41 == null) goto L88;
        if (r41.longValue() <= 0) goto L85;
        boolean r42 = true;
    L86:
        if (r42 == false) goto L88;
    L89:
        r4 = new c(r113, r41);
        goto L91
    L85:
        r42 = false;
        goto L86
    L73:
        r134 = null;
    L88:
        r41 = null;
        goto L89
    L49:
        if (r110.intValue() != r112) goto L51;
        r113 = ContextWindowMode.PRO;
        goto L60
    L43:
        if (r110.intValue() != r111) goto L45;
        r113 = ContextWindowMode.SUPPORTED;
        goto L60
    L34:
        r17 = null;
    L38:
        r110 = null;
        goto L39
    L53:
        if (Intrinsics.areEqual(r9, wa8.t0.a) == false) goto L56;
        r113 = ContextWindowMode.CLOSE;
        goto L60
    L56:
        if (Intrinsics.areEqual(r9, wa8.t0.d) == false) goto L58;
        r113 = ContextWindowMode.PRO;
        goto L60
    L58:
        r113 = ContextWindowMode.SUPPORTED;
        goto L60
    L20:
        r12 = false;
        goto L21
    L17:
        r2 = null;
        goto L18
    L13:
        r10 = null;
    L90:
        r4 = new c(ContextWindowMode.UNKNOWN, null);
        goto L91
    }
}
