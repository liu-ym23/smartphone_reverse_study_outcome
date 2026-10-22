package zba;

import com.larus.im.bean.message.block.Block;
import kc8.f;
import kc8.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends jc8.a {
    public final String g() {
        return "CommonTipBlockBizModel";
    }

    public a(f r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(g.a(r2), r3);
    }
}
