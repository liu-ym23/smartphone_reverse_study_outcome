package com.larus.bmhome.block.pipeline.task;

import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask$a;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.c;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc8.m;
import kc8.f;
import kc8.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\f\u0010\u0012\u001a\u00020\t*\u00020\u000eH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/block/pipeline/task/BlockPipelineDeepThinkTaskModeTask;", "Lcom/larus/bmhome/block/pipeline/api/IBlockPipelineTask;", "<init>", "()V", "priority", "", "getPriority", "()I", "supports", "", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "processBizModels", "", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "bizModelList", "useFileBlockStyle", "", "isTargetBlockModel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BlockPipelineDeepThinkTaskModeTask implements IBlockPipelineTask {
    public final int b;

    public static final class a {
    }

    static {
    }

    public BlockPipelineDeepThinkTaskModeTask() {
        this.b = 500;
    }

    public final int getPriority() {
        return this.b;
    }

    public static void u(List r2) {
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r0 = (jc8.a) r3.next();
        if ((r0 instanceof m) == false) goto L4;
        ((m) r0).d();
        goto L4
    }

    public final boolean n1(f r2) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        if (r2.a != null) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.f, "smart_reply_nested_container") == true) goto L7;
        return true;
    }

    public final List<Block> d3(f r1, List<Block> r2) {
        IBlockPipelineTask$a.c(r1, r2);
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<jc8.a> k2(f r5, List<? extends jc8.a> r6) {
        Intrinsics.checkNotNullParameter(r5, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r6, "bizModelList");
        Message r7 = g.a(r5);
        Map r0 = r7.getExt();
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("is_biz_merged_sub_msg");
    L7:
        if (Intrinsics.areEqual(r1, "1") == false) goto L10;
        u(r6);
    L10:
        if (o0.d(com.larus.im.bean.message.a.r(r7)) == false) goto L34;
        Iterator r8 = r6.iterator();
        int r2 = 0;
    L13:
        if (r8.hasNext() == false) goto L32;
        jc8.a r3 = (jc8.a) r8.next();
        if ((r3 instanceof wk8.a) == false) goto L17;
    L28:
        boolean r4 = true;
    L29:
        if (r4 == false) goto L13;
        r2 = r2 + 1;
        goto L13
    L17:
        if ((r3 instanceof com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.a) == true) goto L28;
        if ((r3 instanceof c) == true) goto L28;
        if ((r3 instanceof lj8.a) == true) goto L28;
        if ((r3 instanceof m) == true) goto L28;
        if ((r3 instanceof tl8.a) == true) goto L28;
        r4 = false;
        goto L29
    L32:
        if (r2 < 2) goto L34;
        u(r6);
    L34:
        return r6;
    L5:
        r1 = null;
        goto L7
    }

    public final void m2(f r1, List<Block> r2, List<? extends jc8.a> r3) {
        IBlockPipelineTask$a.a(r1, r2, r3);
    }
}
