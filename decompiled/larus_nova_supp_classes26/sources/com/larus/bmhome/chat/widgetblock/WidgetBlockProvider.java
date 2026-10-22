package com.larus.bmhome.chat.widgetblock;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.AppletBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.utils.logger.FLogger;
import jc8.b;
import kc8.f;
import kc8.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ro8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/widgetblock/WidgetBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockBizModel", "transformBlockBizModel", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetBlockProvider implements IBlockProvider {
    public final BlockProviderType b;

    public static final class a {
    }

    static {
    }

    public WidgetBlockProvider() {
        this.b = BlockProviderType.WIDGET_BLOCK;
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final b<? extends jc8.a> t0(jc8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        return new e();
    }

    public final jc8.a W1(f r5, jc8.a r6, Block r7) {
        Intrinsics.checkNotNullParameter(r5, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r7, "sourceData");
        Message r8 = g.a(r5);
        BlockContent r9 = r7.getContent();
        Integer r0 = null;
        if (r9 == null) goto L5;
        AppletBlock r10 = r9.getAppletBlock();
    L6:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("transformBlockBizModel, messageId=");
        r2.append(r8.getMessageId());
        r2.append(", blockId=");
        r2.append(r7.getBlockId());
        r2.append(", strategy=");
        if (r10 == null) goto L9;
        r0 = r10.renderDataUpdateStrategy;
    L9:
        r2.append(r0);
        r2.append(", renderDataLength=");
        if (r10 == null) goto L14;
        String r11 = r10.renderData;
        if (r11 == null) goto L14;
        int r12 = r11.length();
    L15:
        r2.append(r12);
        r1.i("AppletRenderUpdate", r2.toString());
        return new ro8.a(r8, r7);
    L14:
        r12 = 0;
        goto L15
    L5:
        r10 = null;
        goto L6
    }
}
