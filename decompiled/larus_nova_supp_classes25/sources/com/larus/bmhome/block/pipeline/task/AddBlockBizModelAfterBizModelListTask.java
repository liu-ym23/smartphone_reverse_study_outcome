package com.larus.bmhome.block.pipeline.task;

import com.google.gson.Gson;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask$a;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.ButtonBlock;
import com.larus.network.http.HttpExtKt;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import jc8.a;
import kc8.f;
import kc8.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pf8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/block/pipeline/task/AddBlockBizModelAfterBizModelListTask;", "Lcom/larus/bmhome/block/pipeline/api/IBlockPipelineTask;", "<init>", "()V", "priority", "", "getPriority", "()I", "supports", "", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "processBizModels", "", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "bizModelList", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AddBlockBizModelAfterBizModelListTask implements IBlockPipelineTask {
    public final int b;

    public AddBlockBizModelAfterBizModelListTask() {
        this.b = DoraCallStateCode.DORA_OB_USER_END;
    }

    public final int getPriority() {
        return this.b;
    }

    public final boolean n1(f r3) {
        Intrinsics.checkNotNullParameter(r3, "blockPipelineConfig");
        if (r3.a != null) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r3.f, "smart_reply_nested_container") == true) goto L9;
        if (Intrinsics.areEqual(r3.f, "input_supplement") == true) goto L9;
        return true;
    }

    public final List<Block> d3(f r1, List<Block> r2) {
        IBlockPipelineTask$a.c(r1, r2);
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<a> k2(f r17, List<? extends a> r18) {
        Intrinsics.checkNotNullParameter(r17, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r18, "bizModelList");
        Message r2 = g.a(r17);
        if (d.Q0(r2) == false) goto L5;
    L28:
        return r18;
    L5:
        if (com.larus.im.bean.message.a.o0(r2) == true) goto L28;
        int r0 = b.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Map r1 = r2.getExt();
        ButtonBlock r3 = null;
        if (r1 == null) goto L24;
        String r4 = (String) r1.get("end_button");
        if (r4 == null) goto L24;
        Gson r5 = HttpExtKt.f;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
        Object r7 = Result.constructor-impl((ButtonBlock) r5.fromJson(r4, new pf8.a().getType()));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r7) == false) goto L20;
        r7 = null;
    L20:
        ButtonBlock r8 = (ButtonBlock) r7;
        if (r8 == null) goto L24;
        r3 = r8;
    L15:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        if (r3 != null) goto L26;
        return r18;
    L26:
        List<a> r10 = CollectionsKt.toMutableList(r18);
        r10.add(new tj8.a(r3, r2, new Block(0, UUID.randomUUID().toString(), null, null, false, null, null, null, 253, null)));
        return r10;
    }

    public final void m2(f r1, List<Block> r2, List<? extends a> r3) {
        IBlockPipelineTask$a.a(r1, r2, r3);
    }
}
