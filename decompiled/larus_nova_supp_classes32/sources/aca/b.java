package aca;

import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OUserSelectBlock;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Deprecated(message = "use OmniButtonGroupBlockBizModel instead")
public final class b extends jc8.a {
    public final kc8.f i;

    public final String g() {
        return "UserSelectBlockBizModel";
    }

    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.O;
    }

    public final boolean e(jc8.a r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        BlockContent r0 = ((jc8.a) this).a.getContent();
        OUserSelectBlock r1 = null;
        if (r0 == null) goto L8;
        OUserSelectBlock r2 = r0.getOUserSelectBlock();
    L9:
        Block r4 = r3.a;
        if (r4 == null) goto L15;
        BlockContent r5 = r4.getContent();
        if (r5 == null) goto L15;
        r1 = r5.getOUserSelectBlock();
    L15:
        return Intrinsics.areEqual(r2, r1);
    L8:
        r2 = null;
        goto L9
    }

    public b(kc8.f r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(kc8.g.a(r2), r3);
        this.i = r2;
    }
}
