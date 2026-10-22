package com.larus.bmhome.block.provider;

import com.larus.bmhome.block.holder.deepthink.r;
import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.block.Block;
import gb8.c;
import java.util.HashMap;
import jc8.a;
import jc8.b;
import kc8.e;
import kc8.f;
import kc8.g;
import kc8.i0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/block/provider/DeepThinkCodeBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepThinkCodeBlockProvider implements IBlockProvider {
    public final BlockProviderType b;

    public DeepThinkCodeBlockProvider() {
        this.b = BlockProviderType.CODE_BLOCK;
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final b<? extends a> t0(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof c) == true) goto L7;
        return null;
    L7:
        return new r();
    }

    public final a W1(f r4, a r5, Block r6) {
        Intrinsics.checkNotNullParameter(r4, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r6, "sourceData");
        if (r5 == null) goto L7;
        Block r7 = r5.a;
        if (r7 == null) goto L7;
        Integer r8 = Integer.valueOf(r7.getBlockType());
    L8:
        String r1 = r6.getBlockId();
        if (r1 == null) goto L18;
        e r2 = r4.g;
        if (r2 == null) goto L15;
        HashMap<String, i0> r3 = r2.b;
        if (r3 == null) goto L15;
        i0 r9 = r3.get(r1);
    L16:
        if (r9 == null) goto L18;
        Integer r10 = Integer.valueOf(r9.b);
    L19:
        int r11 = j.A;
        if (r8 != null) goto L23;
    L24:
        if (r10 != null) goto L27;
    L28:
        return null;
    L27:
        if (r10.intValue() != r11) goto L28;
    L30:
        return new c(g.a(r4), r6);
    L23:
        if (r8.intValue() == r11) goto L30;
    L15:
        r9 = null;
    L18:
        r10 = null;
    L7:
        r8 = null;
        goto L8
    }
}
