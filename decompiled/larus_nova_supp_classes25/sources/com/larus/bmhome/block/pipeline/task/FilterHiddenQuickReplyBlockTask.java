package com.larus.bmhome.block.pipeline.task;

import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask$a;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.InteractionAskContent;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyBlockStatus;
import com.larus.im.bean.message.block.QuickReplyScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc8.a;
import kc8.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qm8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0014\u0010\u0010\u001a\u00020\t*\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/block/pipeline/task/FilterHiddenQuickReplyBlockTask;", "Lcom/larus/bmhome/block/pipeline/api/IBlockPipelineTask;", "<init>", "()V", "priority", "", "getPriority", "()I", "supports", "", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "processBizModels", "", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "bizModelList", "isHiddenQuickReplyBlock", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FilterHiddenQuickReplyBlockTask implements IBlockPipelineTask {
    public final int b;

    public FilterHiddenQuickReplyBlockTask() {
        this.b = 100;
    }

    public final int getPriority() {
        return this.b;
    }

    public final boolean n1(f r2) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        if (r2.a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final List<Block> d3(f r1, List<Block> r2) {
        IBlockPipelineTask$a.c(r1, r2);
        return r2;
    }

    public final List<a> k2(f r8, List<? extends a> r9) {
        Intrinsics.checkNotNullParameter(r8, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r9, "bizModelList");
        ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L42;
        Object r1 = r10.next();
        a r2 = (a) r1;
        boolean r4 = false;
        if ((r2 instanceof c) == false) goto L40;
        BlockContent r3 = r2.a.getContent();
        if (r3 == null) goto L18;
        QuickReplyBlock r5 = r3.getQuickReplyBlock();
        if (r5 == null) goto L18;
        Integer r6 = r5.getScene();
        int r7 = QuickReplyScene.SCENE_ABOVE_INPUT_BOX_OPTION.getValue();
        if (r6 == null) goto L18;
        if (r6.intValue() != r7) goto L18;
        boolean r11 = true;
    L19:
        if (r11 == false) goto L30;
        BlockContent r12 = r2.a.getContent();
        if (r12 == null) goto L25;
        QuickReplyBlock r13 = r12.getQuickReplyBlock();
        if (r13 == null) goto L25;
        InteractionAskContent r14 = r13.getThinkingContent();
    L26:
        if (r14 == null) goto L30;
        if (Intrinsics.areEqual(r8.f, "input_supplement") == true) goto L30;
    L25:
        r14 = null;
    L30:
        BlockContent r15 = r2.a.getContent();
        if (r15 == null) goto L40;
        QuickReplyBlock r16 = r15.getQuickReplyBlock();
        if (r16 == null) goto L40;
        Integer r17 = r16.getStatus();
        int r18 = QuickReplyBlockStatus.STATUS_HIDDEN.getValue();
        if (r17 == null) goto L40;
        if (r17.intValue() != r18) goto L40;
        r4 = true;
    L18:
        r11 = false;
    L40:
        if (r4 == true) goto L4;
        r0.add(r1);
        goto L4
    L42:
        return r0;
    }

    public final void m2(f r1, List<Block> r2, List<? extends a> r3) {
        IBlockPipelineTask$a.a(r1, r2, r3);
    }
}
