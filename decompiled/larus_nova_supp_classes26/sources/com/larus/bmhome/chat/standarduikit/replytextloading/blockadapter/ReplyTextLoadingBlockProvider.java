package com.larus.bmhome.chat.standarduikit.replytextloading.blockadapter;

import an8.d;
import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LoadingBlock;
import jc8.a;
import jc8.b;
import kc8.f;
import kc8.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/replytextloading/blockadapter/ReplyTextLoadingBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReplyTextLoadingBlockProvider implements IBlockProvider {
    public final BlockProviderType b;

    public ReplyTextLoadingBlockProvider() {
        this.b = BlockProviderType.REPLY_TEXT_LOADING_BLOCK;
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final b<? extends a> t0(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof an8.a) == true) goto L7;
        return null;
    L7:
        return new d();
    }

    public final a W1(f r4, a r5, Block r6) {
        Intrinsics.checkNotNullParameter(r4, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r6, "sourceData");
        BlockContent r7 = r6.getContent();
        boolean r0 = false;
        if (r7 == null) goto L12;
        LoadingBlock r8 = r7.getLoadingBlock();
        if (r8 == null) goto L12;
        Integer r9 = r8.scene;
        if (r9 == null) goto L12;
        if (r9.intValue() != 2) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == true) goto L28;
        BlockContent r11 = r6.getContent();
        if (r11 == null) goto L24;
        LoadingBlock r12 = r11.getLoadingBlock();
        if (r12 == null) goto L24;
        Integer r13 = r12.scene;
        if (r13 == null) goto L24;
        if (r13.intValue() != 4) goto L24;
        r0 = true;
    L24:
        if (r0 == true) goto L28;
        return null;
    L28:
        return new an8.a(g.a(r4), r6);
    L12:
        r10 = false;
        goto L13
    }
}
