package com.larus.bmhome.chat.standarduikit.clarification.blockadapter;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.InteractionAskBlock;
import com.larus.utils.logger.FLogger;
import hj8.e;
import jc8.b;
import kc8.f;
import kc8.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/clarification/blockadapter/InteractionAskBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionAskBlockProvider implements IBlockProvider {

    public static final class a {
    }

    static {
    }

    public InteractionAskBlockProvider() {
    }

    public final BlockProviderType N0() {
        return BlockProviderType.INTERACTION_ASK_BLOCK;
    }

    public final b<? extends jc8.a> t0(jc8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof hj8.a) == true) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(((hj8.a) r2).q, "input_supplement") == false) goto L9;
        return new hj8.b();
    L9:
        return new e();
    }

    public final jc8.a W1(f r3, jc8.a r4, Block r5) {
        Intrinsics.checkNotNullParameter(r3, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r5, "sourceData");
        if (r5.getBlockType() == j.q0) goto L5;
        return null;
    L5:
        BlockContent r6 = r5.getContent();
        if (r6 == null) goto L8;
        InteractionAskBlock r7 = r6.getInteractionAskBlock();
    L9:
        if (r7 != null) goto L13;
        FLogger.a.w("InteractionAskBlockProvider", "interaction ask block missing, blockId=" + r5.getBlockId());
        return null;
    L13:
        return new hj8.a(g.a(r3), r5, r7, r3.f);
    L8:
        r7 = null;
        goto L9
    }
}
