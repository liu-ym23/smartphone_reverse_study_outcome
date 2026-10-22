package com.larus.bmhome.block.provider;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.g;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.l;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.HashMap;
import jc8.b;
import kc8.e;
import kc8.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/block/provider/DeepThinkBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepThinkBlockProvider implements IBlockProvider {
    public final BlockProviderType b;

    public static final class a {
    }

    static {
    }

    public DeepThinkBlockProvider() {
        this.b = BlockProviderType.DEEP_THINK_BLOCK;
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final b<? extends jc8.a> t0(jc8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof g) == false) goto L7;
        return new l();
    L7:
        if ((r2 instanceof gb8.b) == true) goto L9;
        return null;
    L9:
        return new com.larus.bmhome.block.holder.deepthink.l();
    }

    public final jc8.a W1(f r2, jc8.a r3, Block r4) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r4, "sourceData");
        Message r5 = kc8.g.a(r2);
        String r0 = r4.getBlockId();
        if (r0 == null) goto L13;
        e r6 = r2.g;
        if (r6 == null) goto L9;
        HashMap<String, Boolean> r7 = r6.a;
        if (r7 == null) goto L9;
        Boolean r8 = r7.get(r0);
    L10:
        if (r8 == null) goto L13;
        r8.booleanValue();
    L9:
        r8 = null;
    L13:
        return new g(r5, r4);
    }
}
