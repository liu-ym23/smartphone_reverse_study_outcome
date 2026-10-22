package com.obric.aiagent.messenger;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.block.AppletBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockMetaInfo;
import com.larus.im.bean.message.block.TextBlock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final IMMessage a(Message r31, Map<String, String> r32) {
        Intrinsics.checkNotNullParameter(r31, "<this>");
        String r3 = r31.getConversationId();
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 != null) goto L5;
        String r6 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        String r5 = r31.getSenderId();
        if (r5 != null) goto L9;
        String r7 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        int r8 = r31.getUserType();
        int r9 = r31.getMessageStatusLocal();
        MessageStatus r10 = r31.getMessageStatus();
        if (r10 == null) goto L13;
        int r11 = r10.value;
    L14:
        int r12 = r31.getContentType();
        boolean r13 = r31.isNewBlockType();
        String r14 = r31.getContent();
        List r15 = r31.getContentBlock();
        if (r15 == null) goto L41;
        List r16 = r15;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L18:
        if (r18.hasNext() == false) goto L40;
        Block r19 = (Block) r18.next();
        Intrinsics.checkNotNullParameter(r19, "<this>");
        int r110 = r19.getBlockType();
        String r111 = r19.getBlockId();
        String r20 = r19.getParentId();
        BlockContent r112 = r19.getContent();
        if (r112 == null) goto L30;
        Intrinsics.checkNotNullParameter(r112, "<this>");
        TextBlock r21 = r112.getTextBlock();
        if (r21 == null) goto L24;
        Intrinsics.checkNotNullParameter(r21, "<this>");
        com.obric.aiagent.assistant.idl.bean.TextBlock r22 = new com.obric.aiagent.assistant.idl.bean.TextBlock(r21.text, r21.iconUrl, r21.iconUrlDark, r21.summary);
    L25:
        AppletBlock r23 = r112.getAppletBlock();
        if (r23 == null) goto L28;
        Intrinsics.checkNotNullParameter(r23, "<this>");
        com.obric.aiagent.assistant.idl.bean.AppletBlock r113 = new com.obric.aiagent.assistant.idl.bean.AppletBlock(r23.renderData, r23.isFullWidth, r23.appletType);
    L29:
        com.obric.aiagent.assistant.idl.bean.BlockContent r24 = new com.obric.aiagent.assistant.idl.bean.BlockContent(r22, r113);
    L31:
        boolean r25 = r19.isFinish();
        List r26 = r19.getAppendFields();
        List r2 = r19.getMetaInfo();
        if (r2 == null) goto L38;
        List r27 = r2;
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r29 = r27.iterator();
    L35:
        if (r29.hasNext() == false) goto L37;
        BlockMetaInfo r30 = (BlockMetaInfo) r29.next();
        Intrinsics.checkNotNullParameter(r30, "<this>");
        r28.add(new com.obric.aiagent.assistant.idl.bean.BlockMetaInfo(r30.type, r30.info, r30.infoV2));
        goto L35
    L37:
        ArrayList r210 = r28;
    L39:
        r17.add(new com.obric.aiagent.assistant.idl.bean.Block(r110, r111, r20, r24, r25, r26, r210));
        r18 = r18;
        r4 = r4;
        r14 = r14;
        r13 = r13;
        r12 = r12;
        goto L18
    L38:
        r210 = null;
        goto L39
    L28:
        r113 = null;
        goto L29
    L24:
        r22 = null;
        goto L25
    L30:
        r4 = r4;
        r12 = r12;
        r13 = r13;
        r14 = r14;
        r24 = null;
        goto L31
    L40:
        String r211 = r4;
        int r33 = r12;
        boolean r212 = r13;
        String r213 = r14;
    L42:
        if (r32 == null) goto L57;
        String r0 = r32.get("dora_sub_biz");
        if (r0 == null) goto L57;
        Map r34 = r31.getExt();
        if (r34 == null) goto L49;
        String r35 = (String) r34.get("dora_sub_biz");
    L51:
        if (Intrinsics.areEqual(r35, r0) == false) goto L53;
        Map r1 = r31.getExt();
    L58:
        Map r114 = r1;
        String r36 = r31.getLocalMessageId();
        if (r36 != null) goto L61;
        String r115 = r211;
    L62:
        String r37 = r31.getMessageId();
        if (r37 != null) goto L65;
        String r116 = r211;
    L66:
        long r117 = r31.getLocalIndex();
        long r214 = r31.getServerIndex();
        String r215 = r31.getSectionId();
        Map r38 = r31.getBusinessExt();
        if (r38 != null) goto L69;
        r38 = new LinkedHashMap();
    L69:
        int r118 = r33;
        boolean r119 = r212;
        String r120 = r213;
        return new IMMessage(r6, r7, r8, r9, r11, r118, r119, r120, r17, r114, r115, r116, r117, r214, r215, r38, r31.getReplyId(), r31.getBizContentType(), r31.getCreateTime());
    L65:
        r116 = r37;
        goto L66
    L61:
        r115 = r36;
        goto L62
    L53:
        Map r39 = r31.getExt();
        if (r39 != null) goto L56;
        r39 = MapsKt.emptyMap();
    L56:
        r1 = MapsKt.plus(r39, TuplesKt.to("dora_sub_biz", r0));
        goto L58
    L49:
        r35 = null;
    L57:
        r1 = r31.getExt();
        goto L58
    L41:
        r211 = NameKeys.UnloadStrategy_No_Strategy;
        r33 = r12;
        r212 = r13;
        r213 = r14;
        r17 = null;
        goto L42
    L13:
        r11 = -1;
        goto L14
    L9:
        r7 = r5;
        goto L10
    L5:
        r6 = r3;
        goto L6
    }
}
