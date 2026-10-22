package wba;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OLoadingBlock;
import kc8.f;
import kc8.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends jc8.a {
    public final String g() {
        return "LoadingBlockBizModel";
    }

    public final int l() {
        int r0 = j.a;
        return j.T;
    }

    public final boolean e(jc8.a r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        BlockContent r0 = ((jc8.a) this).a.getContent();
        OLoadingBlock r1 = null;
        if (r0 == null) goto L8;
        OLoadingBlock r2 = r0.getOLoadingBlock();
    L9:
        BlockContent r4 = r3.a.getContent();
        if (r4 == null) goto L13;
        r1 = r4.getOLoadingBlock();
    L13:
        return Intrinsics.areEqual(r2, r1);
    L8:
        r2 = null;
        goto L9
    }

    public a(f r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(g.a(r2), r3);
    }
}
