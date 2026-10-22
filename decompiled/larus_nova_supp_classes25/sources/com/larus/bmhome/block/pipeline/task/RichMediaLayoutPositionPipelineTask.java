package com.larus.bmhome.block.pipeline.task;

import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask$a;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.block.Block;
import java.util.Iterator;
import java.util.List;
import jc8.a;
import kc8.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import qb8.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J&\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/block/pipeline/task/RichMediaLayoutPositionPipelineTask;", "Lcom/larus/bmhome/block/pipeline/api/IBlockPipelineTask;", "<init>", "()V", "priority", "", "getPriority", "()I", "supports", "", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "processBizModels", "", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "bizModelList", "forEachRichMediaLayoutBlock", "", "action", "Lkotlin/Function1;", "Lcom/larus/bmhome/chat/standarduikit/richmedia/blockadapter/RichMediaLayoutBlockBizModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RichMediaLayoutPositionPipelineTask implements IBlockPipelineTask {
    public final int b;

    public RichMediaLayoutPositionPipelineTask() {
        this.b = 550;
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

    public static void u(List r2, g r3) {
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        a r0 = (a) r4.next();
        if ((r0 instanceof en8.a) == false) goto L8;
        r3.invoke(r0);
    L8:
        u(r0.i(), r3);
        goto L4
    }

    public final List<Block> d3(f r1, List<Block> r2) {
        IBlockPipelineTask$a.c(r1, r2);
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<a> k2(f r2, List<? extends a> r3) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r3, "bizModelList");
        Ref.IntRef r4 = new Ref.IntRef();
        r4.element = 1;
        u(r3, new g(r4));
        return r3;
    }

    public final void m2(f r1, List<Block> r2, List<? extends a> r3) {
        IBlockPipelineTask$a.a(r1, r2, r3);
    }
}
