package com.obric.assistant.block.lark.knowledge_authorized;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OLarkKnowledgeBlock;
import kc8.f;
import kc8.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends jc8.a {
    public final f i;

    public final String g() {
        return "LarkKnowledgeAuthorizedBlockBizModel";
    }

    public final int l() {
        int r0 = j.a;
        return j.U;
    }

    public final boolean e(jc8.a r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        BlockContent r0 = ((jc8.a) this).a.getContent();
        OLarkKnowledgeBlock r1 = null;
        if (r0 == null) goto L8;
        OLarkKnowledgeBlock r2 = r0.getOLarkKnowledgeBlock();
    L9:
        Block r4 = r3.a;
        if (r4 == null) goto L15;
        BlockContent r5 = r4.getContent();
        if (r5 == null) goto L15;
        r1 = r5.getOLarkKnowledgeBlock();
    L15:
        return Intrinsics.areEqual(r2, r1);
    L8:
        r2 = null;
        goto L9
    }

    public a(f r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(g.a(r2), r3);
        this.i = r2;
    }
}
