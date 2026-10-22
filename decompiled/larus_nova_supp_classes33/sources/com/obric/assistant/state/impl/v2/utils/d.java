package com.obric.assistant.state.impl.v2.utils;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.obric.aiagent.assistant.idl.bean.Block;
import com.obric.aiagent.assistant.idl.bean.BlockContent;
import com.obric.aiagent.assistant.idl.bean.BlockMetaInfo;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.TextBlock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public static final Message a(IMMessage r94) {
        String r0 = "<this>";
        Intrinsics.checkNotNullParameter(r94, "<this>");
        String r3 = r94.getConversationId();
        String r5 = r94.getSenderId();
        int r6 = r94.getUserType();
        int r7 = r94.getMessageStatusLocal();
        MessageStatus.a r2 = MessageStatus.Companion;
        int r4 = r94.getMessageStatus();
        r2.getClass();
        MessageStatus r8 = MessageStatus.a.a(r4);
        int r9 = r94.getContentType();
        boolean r10 = r94.isNewBlockType();
        String r12 = r94.getContent();
        List r11 = r94.getContentBlock();
        if (r11 == null) goto L25;
        List r13 = r11;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L6:
        if (r15.hasNext() == false) goto L24;
        Block r16 = (Block) r15.next();
        Intrinsics.checkNotNullParameter(r16, r0);
        int r17 = r16.getBlockType();
        String r18 = r16.getBlockId();
        String r19 = r16.getParentId();
        BlockContent r110 = r16.getContent();
        if (r110 == null) goto L14;
        Intrinsics.checkNotNullParameter(r110, r0);
        TextBlock r111 = r110.getTextBlock();
        if (r111 == null) goto L12;
        Intrinsics.checkNotNullParameter(r111, r0);
        com.larus.im.bean.message.block.TextBlock r20 = new com.larus.im.bean.message.block.TextBlock(r111.text, r111.iconUrl, r111.iconUrlDark, r111.summary, 0, 16, null);
    L13:
        com.larus.im.bean.message.block.BlockContent r112 = new com.larus.im.bean.message.block.BlockContent(r20, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null);
    L15:
        boolean r21 = r16.isFinish();
        List r22 = r16.getAppendFields();
        List r1 = r16.getMetaInfo();
        if (r1 == null) goto L22;
        List r23 = r1;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r25 = r23.iterator();
    L19:
        if (r25.hasNext() == false) goto L21;
        BlockMetaInfo r113 = (BlockMetaInfo) r25.next();
        Intrinsics.checkNotNullParameter(r113, r0);
        String r26 = r0;
        r24.add(new com.larus.im.bean.message.block.BlockMetaInfo(r113.type, r113.info, r113.infoV2));
        r0 = r26;
        goto L19
    L21:
        String r27 = r0;
        ArrayList r28 = r24;
    L23:
        r14.add(new com.larus.im.bean.message.block.Block(r17, r18, r19, r112, r21, null, r22, r28, 32, null));
        r0 = r27;
        goto L6
    L22:
        r27 = r0;
        r28 = null;
        goto L23
    L12:
        r20 = null;
        goto L13
    L14:
        r112 = null;
        goto L15
    L24:
        ArrayList r114 = r14;
    L27:
        return new Message(r3, null, r5, r6, r7, r8, r9, r10, null, r12, r114, null, null, r94.getExt(), r94.getLocalMessageId(), r94.getMessageId(), r94.getLocalIndex(), r94.getServerIndex(), false, r94.getSectionId(), null, null, r94.getBusinessExt(), null, null, 0, false, 0, r94.getReplyId(), null, false, r94.getBizContentType(), null, r94.getCreateTime(), null, null, null, 1874073858, 29, null);
    L25:
        r114 = null;
        goto L27
    }
}
