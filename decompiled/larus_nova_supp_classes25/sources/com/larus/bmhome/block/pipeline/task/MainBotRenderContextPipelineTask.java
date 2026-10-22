package com.larus.bmhome.block.pipeline.task;

import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask$a;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.List;
import jc8.a;
import kc8.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ra8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/block/pipeline/task/MainBotRenderContextPipelineTask;", "Lcom/larus/bmhome/block/pipeline/api/IBlockPipelineTask;", "<init>", "()V", "priority", "", "getPriority", "()I", "supports", "", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "processBlocks", "", "Lcom/larus/im/bean/message/block/Block;", "blockList", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MainBotRenderContextPipelineTask implements IBlockPipelineTask {
    public final int b;

    public MainBotRenderContextPipelineTask() {
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

    public final List<Block> d3(f r13, List<Block> r14) {
        Intrinsics.checkNotNullParameter(r13, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r14, "blockList");
        Intrinsics.checkNotNullParameter(r13, "<this>");
        b r0 = r13.h;
        Boolean r1 = r13.b;
        if (r1 != null) goto L5;
        r1 = r0.e;
    L5:
        b r2 = b.a(r0, r1, r13.f, 79);
        Message r3 = r13.a;
        if ((r3 instanceof Message) == true) goto L10;
        r3 = null;
    L10:
        if (r3 != null) goto L12;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r13.h = r2;
    L17:
        return r14;
    L12:
        String r4 = r3.getMessageId();
        String r5 = r3.getSenderId();
        String r6 = r3.getConversationId();
        boolean r7 = d.Q0(r3);
        Boolean r8 = r2.e;
        if (r8 == null) goto L15;
        boolean r9 = r8.booleanValue();
    L16:
        b r11 = new b(r4, r5, r6, r7, Boolean.valueOf(r9), r13.f, Integer.valueOf(r3.getMessageStatusLocal()));
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r13.h = r11;
        goto L17
    L15:
        r9 = d.j0(r3);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<a> k2(f r1, List<? extends a> r2) {
        IBlockPipelineTask$a.b(r1, r2);
        return r2;
    }

    public final void m2(f r1, List<Block> r2, List<? extends a> r3) {
        IBlockPipelineTask$a.a(r1, r2, r3);
    }
}
