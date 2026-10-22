package com.obric.assistant.block.common.tip;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OTipBlock;
import com.larus.utils.logger.FLogger;
import jc8.b;
import kc8.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/block/common/tip/TipBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TipBlockProvider implements IBlockProvider {

    public static final class a {
    }

    static {
    }

    public TipBlockProvider() {
    }

    public final BlockProviderType N0() {
        return BlockProviderType.O_TIP_BLOCK_BLOCK;
    }

    public final b<? extends jc8.a> t0(jc8.a r4) {
        Intrinsics.checkNotNullParameter(r4, "blockBizModel");
        if ((r4 instanceof zba.a) == true) goto L7;
        FLogger.a.i("TipBlockProvider", "unknown tip biz model: " + r4 + ", use common holder");
        return new zba.b();
    L7:
        return new zba.b();
    }

    public final jc8.a W1(f r4, jc8.a r5, Block r6) {
        Intrinsics.checkNotNullParameter(r4, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r6, "sourceData");
        BlockContent r7 = r6.getContent();
        if (r7 == null) goto L7;
        OTipBlock r8 = r7.getOTipBlock();
        if (r8 == null) goto L7;
        String r9 = r8.style;
    L9:
        if (Intrinsics.areEqual(r9, "common") == true) goto L13;
        FLogger.a.i("TipBlockProvider", "unknown tip style: " + r9);
        return new zba.a(r4, r6);
    L13:
        return new zba.a(r4, r6);
    L7:
        r9 = null;
        goto L9
    }
}
