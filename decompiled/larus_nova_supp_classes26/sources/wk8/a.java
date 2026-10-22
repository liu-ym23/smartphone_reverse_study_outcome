package wk8;

import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.FileBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {
    public final FileCardVMData i;
    public final int j;

    public final String g() {
        return "FileBlockBizModel";
    }

    public final int l() {
        return this.j;
    }

    public final boolean e(jc8.a r4) {
        if ((r4 instanceof a) == false) goto L20;
        BlockContent r0 = ((jc8.a) this).a.getContent();
        Integer r1 = null;
        if (r0 == null) goto L9;
        FileBlock r2 = r0.getFileBlock();
        if (r2 == null) goto L9;
        Integer r3 = Integer.valueOf(r2.hashCode());
    L10:
        a r5 = (a) r4;
        BlockContent r6 = ((jc8.a) r5).a.getContent();
        if (r6 == null) goto L16;
        FileBlock r7 = r6.getFileBlock();
        if (r7 == null) goto L16;
        r1 = Integer.valueOf(r7.hashCode());
    L16:
        if (Intrinsics.areEqual(r3, r1) == false) goto L20;
        if (Intrinsics.areEqual(this.i, r5.i) == false) goto L20;
        return true;
    L9:
        r3 = null;
    L20:
        return false;
    }

    public a(Message r2, Block r3, FileCardVMData r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
        this.i = r4;
        this.j = j.h0;
    }
}
