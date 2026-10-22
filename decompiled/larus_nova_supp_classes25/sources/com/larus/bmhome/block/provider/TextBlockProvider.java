package com.larus.bmhome.block.provider;

import com.larus.bmhome.block.holder.deepthink.a0;
import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.bean.message.block.TextBlockScene;
import eb8.i0;
import eb8.j0;
import eb8.z;
import fb8.c;
import fb8.f;
import fb8.l;
import fb8.m;
import gb8.i;
import jc8.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sb8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/block/provider/TextBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "enableTextBlock", "", "getEnableTextBlock", "()Z", "enableTextBlock$delegate", "Lkotlin/Lazy;", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TextBlockProvider implements IBlockProvider {
    public final Lazy b;
    public final BlockProviderType c;

    public TextBlockProvider() {
        this.b = LazyKt.lazy(new a());
        this.c = BlockProviderType.TEXT_BLOCK;
    }

    public final BlockProviderType N0() {
        return this.c;
    }

    public final b<? extends jc8.a> t0(jc8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof i) == false) goto L6;
        return new a0();
    L6:
        if ((r2 instanceof m) == false) goto L9;
        return new j0();
    L9:
        if ((r2 instanceof f) == false) goto L12;
        return new z();
    L12:
        if ((r2 instanceof l) == true) goto L19;
        return null;
    L19:
        return new i0();
    }

    public final jc8.a W1(kc8.f r10, jc8.a r11, Block r12) {
        Intrinsics.checkNotNullParameter(r10, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r12, "sourceData");
        Message r2 = r10.a;
        Integer r0 = null;
        if (r2 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r10.f, "cot_floatation") == false) goto L8;
        r0 = Integer.valueOf(r2.getMessageStatusLocal());
    L8:
        Integer r8 = r0;
        if (r11 != null) goto L11;
    L20:
        BlockContent r1 = r12.getContent();
        if (r1 == null) goto L27;
        TextBlock r3 = r1.getTextBlock();
        if (r3 == null) goto L27;
        if (r3.scene != TextBlockScene.TEXT_BLOCK_AIDOC.getType()) goto L27;
        boolean r4 = true;
    L28:
        if (r4 == false) goto L31;
        return new f(r2, r12);
    L31:
        if (r10.c == false) goto L33;
    L36:
        String r5 = r2.getMessageId();
        r2.getSenderId();
        r2.getConversationId();
        m r6 = new m(r2, r12, new c(r5, r2), r10.b, false, r11, r8);
    L38:
        return r6;
    L33:
        if (((Boolean) this.b.getValue()).booleanValue() == true) goto L36;
        return new l(r2, r12);
    L27:
        r4 = false;
        goto L28
    L11:
        if (r11.a.getBlockType() != j.A) goto L20;
        if (r10.c == false) goto L15;
    L18:
        String r7 = r2.getMessageId();
        r2.getSenderId();
        r2.getConversationId();
        r6 = new m(r2, r12, new c(r7, r2), r10.b, true, r11, r8);
        goto L38
    L15:
        if (((Boolean) this.b.getValue()).booleanValue() == true) goto L18;
        return new i(r2, r12);
    }
}
