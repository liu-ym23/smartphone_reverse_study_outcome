package com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.inputpanel;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyBlockStatus;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.im.bean.message.block.QuickReplyScene;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jc8.a;
import jc8.b;
import kc8.f;
import kc8.g;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001f\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/quickreply/blockadapter/inputpanel/QuickReplyInputPanelBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "assignQuickReplyTrackIndex", "", "message", "Lcom/larus/im/bean/message/Message;", "scene", "", "(Lcom/larus/im/bean/message/Message;Ljava/lang/Integer;)V", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickReplyInputPanelBlockProvider implements IBlockProvider {
    public final BlockProviderType b;

    public QuickReplyInputPanelBlockProvider() {
        this.b = BlockProviderType.QUICK_REPLY_INPUT_PANEL;
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final b<? extends a> t0(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof rm8.a) == true) goto L7;
        return null;
    L7:
        return new rm8.b();
    }

    public final a W1(f r6, a r7, Block r8) {
        Intrinsics.checkNotNullParameter(r6, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r8, "sourceData");
        Message r9 = g.a(r6);
        BlockContent r0 = r8.getContent();
        List r1 = null;
        if (r0 == null) goto L79;
        QuickReplyBlock r2 = r0.getQuickReplyBlock();
        if (r2 == null) goto L79;
        Integer r3 = r2.getScene();
        int r4 = QuickReplyScene.SCENE_ABOVE_INPUT_BOX_OPTION.getValue();
        if (r3 == null) goto L79;
        if (r3.intValue() != r4) goto L79;
        if (Intrinsics.areEqual(r6.f, "input_supplement") == false) goto L79;
        Integer r10 = r2.getStatus();
        int r5 = QuickReplyBlockStatus.STATUS_HIDDEN.getValue();
        if (r10 != null) goto L19;
    L21:
        List r11 = r2.getItems();
        if (r11 != null) goto L24;
        r11 = CollectionsKt.emptyList();
    L24:
        List r12 = r11;
        boolean r13 = true;
        int r14 = 0;
        if ((r12 instanceof Collection) == true) goto L27;
    L29:
        Iterator r15 = r12.iterator();
    L31:
        if (r15.hasNext() == false) goto L42;
        String r16 = ((QuickReplyItem) r15.next()).getText();
        if (r16 != null) goto L35;
    L38:
        boolean r17 = true;
    L40:
        if ((!r17) == false) goto L31;
        r13 = false;
        goto L42
    L35:
        if (StringsKt.isBlank(r16) == true) goto L38;
        r17 = false;
    L42:
        if (r13 == false) goto L44;
        return null;
    L44:
        Integer r18 = r2.getScene();
        List r19 = r9.getContentBlock();
        if (r19 == null) goto L68;
        ArrayList r20 = new ArrayList();
        Iterator r21 = r19.iterator();
    L48:
        if (r21.hasNext() == false) goto L55;
        BlockContent r22 = ((Block) r21.next()).getContent();
        if (r22 == null) goto L52;
        QuickReplyBlock r23 = r22.getQuickReplyBlock();
    L53:
        if (r23 == null) goto L48;
        r20.add(r23);
        goto L48
    L52:
        r23 = null;
        goto L53
    L55:
        ArrayList r24 = new ArrayList();
        Iterator r25 = r20.iterator();
    L57:
        if (r25.hasNext() == false) goto L61;
        Object r26 = r25.next();
        if (Intrinsics.areEqual(((QuickReplyBlock) r26).getScene(), r18) == false) goto L57;
        r24.add(r26);
        goto L57
    L61:
        r1 = new ArrayList();
        Iterator r27 = r24.iterator();
    L63:
        if (r27.hasNext() == false) goto L68;
        List r28 = ((QuickReplyBlock) r27.next()).getItems();
        if (r28 != null) goto L67;
        r28 = CollectionsKt.emptyList();
    L67:
        CollectionsKt.addAll(r1, r28);
    L68:
        if (r1 != null) goto L70;
        r1 = CollectionsKt.emptyList();
    L70:
        Iterator r29 = r1.iterator();
    L72:
        if (r29.hasNext() == false) goto L78;
        Object r30 = r29.next();
        int r31 = r14 + 1;
        if (r14 >= 0) goto L76;
        CollectionsKt.throwIndexOverflow();
    L76:
        ((QuickReplyItem) r30).setTrackIndex(r31);
        r14 = r31;
        goto L72
    L78:
        return new rm8.a(r9, r8);
    L27:
        if (r12.isEmpty() == false) goto L29;
    L19:
        if (r10.intValue() != r5) goto L21;
        return null;
    L79:
        return null;
    }
}
