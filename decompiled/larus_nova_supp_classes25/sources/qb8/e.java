package qb8;

import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask$a;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kc8.f;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements IBlockPipelineTask {
    public final int getPriority() {
        return 300;
    }

    public e() {
    }

    public final boolean n1(f r2) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        return true;
    }

    public final List<Block> d3(f r8, List<Block> r9) {
        Intrinsics.checkNotNullParameter(r8, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r9, "blockList");
        List<Block> r10 = r9;
        final LinkedHashSet r11 = new LinkedHashSet();
        Iterator<T> r0 = r10.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = ((Block) r0.next()).getParentId();
        if (r1 == null) goto L4;
        r11.add(r1);
        goto L4
    L8:
        Set r12 = SequencesKt.toSet(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r10), new c(r11)), new d()));
        HashSet r2 = new HashSet();
        ArrayList r3 = new ArrayList();
        Iterator<T> r13 = r10.iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        Object r4 = r13.next();
        if (r2.add(((Block) r4).getBlockId()) == false) goto L10;
        r3.add(r4);
        goto L10
    L14:
        ArrayList r14 = new ArrayList();
        Iterator r5 = r3.iterator();
    L16:
        if (r5.hasNext() == false) goto L50;
        Object r6 = r5.next();
        Block r7 = (Block) r6;
        boolean r15 = false;
        if (r7.getBlockType() != j.e) goto L48;
        BlockContent r16 = r7.getContent();
        String r17 = null;
        if (r16 == null) goto L24;
        TextBlock r18 = r16.getTextBlock();
        if (r18 == null) goto L24;
        String r19 = r18.text;
    L26:
        if (r19 != null) goto L28;
    L31:
        boolean r20 = true;
    L32:
        if (r20 == false) goto L48;
        BlockContent r21 = r7.getContent();
        if (r21 == null) goto L38;
        TextBlock r22 = r21.getTextBlock();
        if (r22 == null) goto L38;
        r17 = r22.summary;
    L38:
        if (r17 != null) goto L40;
    L43:
        boolean r23 = true;
    L44:
        if (r23 == false) goto L48;
        if (CollectionsKt.contains(r12, r7.getBlockId()) == true) goto L48;
        r15 = true;
        goto L48
    L40:
        if (r17.length() == 0) goto L43;
        r23 = false;
        goto L44
    L28:
        if (r19.length() == 0) goto L31;
        r20 = false;
    L24:
        r19 = null;
    L48:
        if (r15 == true) goto L16;
        r14.add(r6);
        goto L16
    L50:
        return r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<jc8.a> k2(f r1, List<? extends jc8.a> r2) {
        IBlockPipelineTask$a.b(r1, r2);
        return r2;
    }

    public final void m2(f r1, List<Block> r2, List<? extends jc8.a> r3) {
        IBlockPipelineTask$a.a(r1, r2, r3);
    }
}
