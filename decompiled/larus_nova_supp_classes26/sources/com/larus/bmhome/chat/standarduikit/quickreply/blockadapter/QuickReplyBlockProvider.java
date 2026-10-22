package com.larus.bmhome.chat.standarduikit.quickreply.blockadapter;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.im.bean.message.block.QuickReplyScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc8.b;
import kc8.f;
import kc8.g;
import kc8.h;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mi8.c;
import qm8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001f\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/quickreply/blockadapter/QuickReplyBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "shouldShowAnswerPostOptionBlock", "", "message", "Lcom/larus/im/bean/message/Message;", "assignQuickReplyTrackIndex", "", "scene", "", "(Lcom/larus/im/bean/message/Message;Ljava/lang/Integer;)V", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickReplyBlockProvider implements IBlockProvider {
    public final BlockProviderType b;

    public QuickReplyBlockProvider() {
        this.b = BlockProviderType.QUICK_REPLY;
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final b<? extends jc8.a> t0(jc8.a r4) {
        Intrinsics.checkNotNullParameter(r4, "blockBizModel");
        BlockContent r5 = r4.a.getContent();
        if (r5 == null) goto L5;
        QuickReplyBlock r6 = r5.getQuickReplyBlock();
    L6:
        boolean r0 = true;
        if (r6 == null) goto L14;
        Integer r7 = r6.getScene();
        int r2 = QuickReplyScene.SCENE_MOA_APPLET_GRANTING.getValue();
        if (r7 == null) goto L14;
        if (r7.intValue() != r2) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L23;
        int r9 = a.j;
        if (c.a() != null) goto L20;
        r0 = false;
    L20:
        if (r0 == false) goto L23;
        return new a();
    L23:
        return new d();
    L14:
        r8 = false;
        goto L15
    L5:
        r6 = null;
        goto L6
    }

    public final jc8.a W1(f r10, jc8.a r11, Block r12) {
        Intrinsics.checkNotNullParameter(r10, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r12, "sourceData");
        Message r13 = g.a(r10);
        BlockContent r0 = r12.getContent();
        if (r0 == null) goto L99;
        QuickReplyBlock r1 = r0.getQuickReplyBlock();
        if (r1 == null) goto L99;
        Integer r2 = r1.getScene();
        int r3 = QuickReplyScene.SCENE_ABOVE_INPUT_BOX_OPTION.getValue();
        if (r2 == null) goto L13;
        if (r2.intValue() == r3) goto L99;
    L13:
        if (Intrinsics.areEqual(r10.f, "input_supplement") == true) goto L99;
        Integer r4 = r1.getScene();
        int r5 = QuickReplyScene.SCENE_MOA_APPLET_GRANTING.getValue();
        boolean r6 = true;
        if (r4 != null) goto L19;
    L26:
        Integer r7 = r1.getScene();
        List r8 = r13.getContentBlock();
        if (r8 == null) goto L50;
        ArrayList r9 = new ArrayList();
        Iterator r14 = r8.iterator();
    L30:
        if (r14.hasNext() == false) goto L37;
        BlockContent r15 = ((Block) r14.next()).getContent();
        if (r15 == null) goto L34;
        QuickReplyBlock r16 = r15.getQuickReplyBlock();
    L35:
        if (r16 == null) goto L30;
        r9.add(r16);
        goto L30
    L34:
        r16 = null;
        goto L35
    L37:
        ArrayList r17 = new ArrayList();
        Iterator r18 = r9.iterator();
    L39:
        if (r18.hasNext() == false) goto L43;
        Object r19 = r18.next();
        if (Intrinsics.areEqual(((QuickReplyBlock) r19).getScene(), r7) == false) goto L39;
        r17.add(r19);
        goto L39
    L43:
        List r20 = new ArrayList();
        Iterator r21 = r17.iterator();
    L45:
        if (r21.hasNext() == false) goto L51;
        List r22 = ((QuickReplyBlock) r21.next()).getItems();
        if (r22 != null) goto L49;
        r22 = CollectionsKt.emptyList();
    L49:
        CollectionsKt.addAll(r20, r22);
    L51:
        if (r20 != null) goto L53;
        r20 = CollectionsKt.emptyList();
    L53:
        Iterator r23 = r20.iterator();
        int r24 = 0;
    L55:
        if (r23.hasNext() == false) goto L60;
        Object r25 = r23.next();
        int r26 = r24 + 1;
        if (r24 >= 0) goto L59;
        CollectionsKt.throwIndexOverflow();
    L59:
        ((QuickReplyItem) r25).setTrackIndex(r26);
        r24 = r26;
        goto L55
    L60:
        Integer r27 = r1.getScene();
        int r28 = QuickReplyScene.SCENE_ANSWER_POST_OPTION.getValue();
        if (r27 == null) goto L98;
        if (r27.intValue() != r28) goto L98;
        h r110 = r10.e;
        if (r110 == null) goto L93;
        String r29 = r13.getMessageId();
        if (r29 != null) goto L72;
        r29 = "";
    L72:
        if (r110.c(r29) != 0) goto L74;
        boolean r30 = true;
    L76:
        if (r110.i0() == false) goto L79;
    L94:
        r6 = r30;
    L95:
        if (r6 == true) goto L98;
        return null;
    L79:
        if (r110.a() == false) goto L94;
        String r111 = r110.b();
        if (r111 != null) goto L83;
    L86:
        boolean r31 = true;
    L87:
        if (r31 == true) goto L93;
        if (Intrinsics.areEqual(r13.getSectionId(), r111) == false) goto L93;
        if (r30 == false) goto L93;
    L83:
        if (r111.length() == 0) goto L86;
        r31 = false;
        goto L87
    L74:
        r30 = false;
    L93:
        r6 = false;
    L98:
        return new qm8.c(r13, r12);
    L50:
        r20 = null;
        goto L51
    L19:
        if (r4.intValue() != r5) goto L26;
        int r32 = a.j;
        if (c.a() == null) goto L23;
        boolean r33 = true;
    L24:
        if (r33 == true) goto L26;
        return null;
    L23:
        r33 = false;
    L99:
        return null;
    }
}
