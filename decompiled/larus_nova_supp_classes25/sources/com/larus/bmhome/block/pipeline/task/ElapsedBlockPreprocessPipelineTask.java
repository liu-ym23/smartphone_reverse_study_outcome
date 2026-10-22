package com.larus.bmhome.block.pipeline.task;

import com.bytedance.keva.Keva;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask$a;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockControlInfo;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.ElapsedBlock;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jc8.a;
import kc8.f;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\f\u0010\u0010\u001a\u00020\t*\u00020\u000eH\u0002J\f\u0010\u0011\u001a\u00020\t*\u00020\u000eH\u0002J\f\u0010\u0012\u001a\u00020\t*\u00020\u000eH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/block/pipeline/task/ElapsedBlockPreprocessPipelineTask;", "Lcom/larus/bmhome/block/pipeline/api/IBlockPipelineTask;", "<init>", "()V", "priority", "", "getPriority", "()I", "supports", "", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "processBlocks", "", "Lcom/larus/im/bean/message/block/Block;", "blockList", "isElapsedBlock", "isHiddenElapsedBlock", "isVisibleCollapsedElapsedBlock", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ElapsedBlockPreprocessPipelineTask implements IBlockPipelineTask {
    public final int b;

    public ElapsedBlockPreprocessPipelineTask() {
        this.b = 375;
    }

    public final int getPriority() {
        return this.b;
    }

    public static boolean u(Block r1) {
        if (r1.getBlockType() != BlockType.BLOCK_TYPE_ELAPSED.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean n1(f r3) {
        Intrinsics.checkNotNullParameter(r3, "blockPipelineConfig");
        Lazy r4 = b.a;
        return !((Keva) b.a.getValue()).getBoolean("disable_elapsed_block_preprocess", false);
    }

    public final List<Block> d3(f r19, List<Block> r20) {
        Intrinsics.checkNotNullParameter(r19, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r20, "blockList");
        List<Block> r1 = r20;
        boolean r2 = r1 instanceof Collection;
        if (r2 == true) goto L5;
    L7:
        Iterator<T> r5 = r1.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        if (u((Block) r5.next()) == false) goto L9;
        boolean r6 = false;
    L14:
        if (r6 == false) goto L16;
        return r20;
    L16:
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r1.iterator();
    L18:
        if (r7.hasNext() == false) goto L33;
        Object r8 = r7.next();
        Block r9 = (Block) r8;
        if (u(r9) == false) goto L29;
        BlockContent r10 = r9.getContent();
        if (r10 == null) goto L26;
        ElapsedBlock r11 = r10.getElapsedBlock();
        if (r11 == null) goto L26;
        boolean r12 = Intrinsics.areEqual(r11.getVisible(), Boolean.FALSE);
    L27:
        if (r12 == false) goto L29;
        boolean r13 = true;
    L30:
        if (r13 == true) goto L18;
        r0.add(r8);
    L26:
        r12 = false;
    L29:
        r13 = false;
        goto L30
    L33:
        if (r0.isEmpty() == true) goto L56;
        Iterator r14 = r0.iterator();
    L37:
        if (r14.hasNext() == false) goto L56;
        Block r15 = (Block) r14.next();
        if (u(r15) == false) goto L53;
        BlockContent r16 = r15.getContent();
        if (r16 == null) goto L45;
        ElapsedBlock r17 = r16.getElapsedBlock();
        if (r17 == null) goto L45;
        boolean r18 = Intrinsics.areEqual(r17.getVisible(), Boolean.TRUE);
    L46:
        if (r18 == false) goto L53;
        BlockControlInfo r21 = r15.getControlInfo();
        if (r21 == null) goto L50;
        boolean r22 = Intrinsics.areEqual(r21.isCollapsed(), Boolean.TRUE);
    L51:
        if (r22 == false) goto L53;
        boolean r23 = true;
    L54:
        if (r23 == false) goto L37;
        boolean r24 = true;
    L58:
        if (r2 == true) goto L60;
    L62:
        Iterator<T> r3 = r1.iterator();
    L64:
        if (r3.hasNext() == false) goto L82;
        Block r4 = (Block) r3.next();
        if (u(r4) == true) goto L79;
        BlockControlInfo r25 = r4.getControlInfo();
        if (r25 == null) goto L70;
        String r26 = r25.getCollapseBlockId();
    L71:
        if (r26 != null) goto L73;
    L76:
        boolean r27 = true;
    L77:
        if (r27 == false) goto L79;
        boolean r28 = true;
    L80:
        if (r28 == false) goto L64;
        boolean r29 = true;
    L83:
        if (r24 == false) goto L106;
        if (r29 == false) goto L106;
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r31 = r0.iterator();
    L88:
        if (r31.hasNext() == false) goto L105;
        Block r32 = (Block) r31.next();
        BlockControlInfo r33 = r32.getControlInfo();
        if (r33 == null) goto L92;
        String r110 = r33.getCollapseBlockId();
    L94:
        if (o0.d(r110) == false) goto L104;
        String r34 = r32.getParentId();
        if (r34 != null) goto L98;
    L101:
        boolean r35 = true;
    L102:
        if (r35 == false) goto L104;
        r32 = Block.copy$default(r32, 0, null, r110, null, false, null, null, null, 251, null);
        goto L104
    L98:
        if (r34.length() == 0) goto L101;
        r35 = false;
    L104:
        r30.add(r32);
        goto L88
    L92:
        r110 = null;
        goto L94
    L105:
        return r30;
    L106:
        return r0;
    L73:
        if (r26.length() == 0) goto L76;
        r27 = false;
        goto L77
    L70:
        r26 = null;
    L79:
        r28 = false;
    L82:
        r29 = false;
        goto L83
    L60:
        if (r1.isEmpty() == false) goto L62;
    L50:
        r22 = false;
    L45:
        r18 = false;
    L53:
        r23 = false;
    L56:
        r24 = false;
    L13:
        r6 = true;
        goto L14
    L5:
        if (r1.isEmpty() == false) goto L7;
        goto L7
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
