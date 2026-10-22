package com.obric.assistant.block.common.loading;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.im.bean.message.block.Block;
import jc8.a;
import jc8.b;
import kc8.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0016J$\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/block/common/loading/LoadingBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockBizModel", "transformBlockBizModel", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadingBlockProvider implements IBlockProvider {
    public LoadingBlockProvider() {
    }

    public final BlockProviderType N0() {
        return BlockProviderType.O_LOADING_BLOCK;
    }

    public final b<? extends a> t0(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        return new wba.b();
    }

    public final a W1(f r1, a r2, Block r3) {
        Intrinsics.checkNotNullParameter(r1, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r3, "sourceData");
        return new wba.a(r1, r3);
    }
}
