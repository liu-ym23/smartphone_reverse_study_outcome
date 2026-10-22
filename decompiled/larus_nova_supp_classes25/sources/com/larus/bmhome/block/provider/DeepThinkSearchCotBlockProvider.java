package com.larus.bmhome.block.provider;

import com.larus.bmhome.block.holder.deepthink.SearchCotBlockHolder;
import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.SearchQueryResultBlock;
import com.larus.im.bean.message.block.SearchQueryResultScene;
import com.larus.im.bean.message.block.SearchType;
import gb8.h;
import jc8.a;
import jc8.b;
import kc8.f;
import kc8.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/block/provider/DeepThinkSearchCotBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "isSearchCotType", "", "type", "", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepThinkSearchCotBlockProvider implements IBlockProvider {
    public final BlockProviderType b;

    public DeepThinkSearchCotBlockProvider() {
        this.b = BlockProviderType.SEARCH_QUERY_RESULT_BLOCK;
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final b<? extends a> t0(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof h) == true) goto L7;
        return null;
    L7:
        return new SearchCotBlockHolder();
    }

    public final a W1(f r5, a r6, Block r7) {
        Intrinsics.checkNotNullParameter(r5, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r7, "sourceData");
        BlockContent r8 = r7.getContent();
        boolean r0 = false;
        if (r8 == null) goto L12;
        SearchQueryResultBlock r9 = r8.getSearchQueryResultBlock();
        if (r9 == null) goto L12;
        Integer r10 = r9.scene;
        int r2 = SearchQueryResultScene.SearchReference.getValue();
        if (r10 == null) goto L12;
        if (r10.intValue() != r2) goto L12;
        boolean r11 = true;
    L14:
        if (r11 == false) goto L16;
        return null;
    L16:
        BlockContent r12 = r7.getContent();
        if (r12 == null) goto L23;
        SearchQueryResultBlock r13 = r12.getSearchQueryResultBlock();
        if (r13 == null) goto L23;
        Integer r14 = r13.searchType;
        if (r14 == null) goto L23;
        int r15 = r14.intValue();
    L25:
        if (r15 != SearchType.WebSearch.getValue()) goto L27;
    L28:
        r0 = true;
    L29:
        if (r0 == true) goto L31;
        return null;
    L31:
        return new h(g.a(r5), r7);
    L27:
        if (r15 != SearchType.ScholarSearch.getValue()) goto L29;
    L23:
        r15 = SearchType.Default.getValue();
    L12:
        r11 = false;
        goto L14
    }
}
