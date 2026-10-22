package com.larus.uaigc.chat.block.createloading;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LoadingBlock;
import com.tencent.open.log.TraceLevel;
import jc8.a;
import jc8.b;
import kc8.f;
import kc8.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/chat/block/createloading/CreationLoadingBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationLoadingBlockProvider implements IBlockProvider {
    public final BlockProviderType b;

    public CreationLoadingBlockProvider() {
        this.b = BlockProviderType.CREATION_LOADING_BLOCK;
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final b<? extends a> t0(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof az9.a) == true) goto L7;
        return null;
    L7:
        return new az9.b();
    }

    public final a W1(f r2, a r3, Block r4) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r4, "sourceData");
        BlockContent r5 = r4.getContent();
        if (r5 == null) goto L12;
        LoadingBlock r6 = r5.getLoadingBlock();
        if (r6 == null) goto L12;
        Integer r7 = r6.scene;
        if (r7 == null) goto L12;
        boolean r0 = true;
        if (r7.intValue() != 1) goto L12;
    L13:
        if (r0 == true) goto L17;
        return null;
    L17:
        return new az9.a(g.a(r2), r4);
    L12:
        r0 = false;
        goto L13
    }
}
