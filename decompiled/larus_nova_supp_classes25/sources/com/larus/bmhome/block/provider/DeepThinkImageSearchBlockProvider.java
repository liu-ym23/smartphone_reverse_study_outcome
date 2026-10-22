package com.larus.bmhome.block.provider;

import com.larus.bmhome.block.holder.deepthink.z;
import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.SearchQueryResultBlock;
import com.larus.im.bean.message.block.SearchQueryResultScene;
import com.larus.im.bean.message.block.SearchType;
import gb8.f;
import java.util.Set;
import jc8.a;
import jc8.b;
import kc8.g;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u001a\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/block/provider/DeepThinkImageSearchBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "imageSearchTypes", "", "", "isImageSearchType", "", "type", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepThinkImageSearchBlockProvider implements IBlockProvider {
    public final BlockProviderType b;
    public final Set<Integer> c;

    public DeepThinkImageSearchBlockProvider() {
        this.b = BlockProviderType.SEARCH_QUERY_RESULT_BLOCK;
        this.c = SetsKt.setOf(new Integer[]{Integer.valueOf(SearchType.TextSearchImage.getValue()), Integer.valueOf(SearchType.ImageSearchImage.getValue())});
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final b<? extends a> t0(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof f) == true) goto L7;
        return null;
    L7:
        return new z();
    }

    public final a W1(kc8.f r3, a r4, Block r5) {
        Intrinsics.checkNotNullParameter(r3, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r5, "sourceData");
        BlockContent r6 = r5.getContent();
        if (r6 == null) goto L12;
        SearchQueryResultBlock r7 = r6.getSearchQueryResultBlock();
        if (r7 == null) goto L12;
        Integer r8 = r7.scene;
        int r0 = SearchQueryResultScene.SearchReference.getValue();
        if (r8 == null) goto L12;
        if (r8.intValue() != r0) goto L12;
        boolean r9 = true;
    L14:
        if (r9 == false) goto L16;
        return null;
    L16:
        BlockContent r10 = r5.getContent();
        if (r10 == null) goto L30;
        SearchQueryResultBlock r11 = r10.getSearchQueryResultBlock();
        if (r11 == null) goto L31;
        Integer r12 = r11.searchType;
        if (r12 == null) goto L24;
        int r13 = r12.intValue();
    L26:
        if (this.c.contains(Integer.valueOf(r13)) == true) goto L29;
        return null;
    L29:
        return new f(g.a(r3), r5);
    L24:
        r13 = SearchType.Default.getValue();
        goto L26
    L31:
        return null;
    L30:
        return null;
    L12:
        r9 = false;
        goto L14
    }
}
