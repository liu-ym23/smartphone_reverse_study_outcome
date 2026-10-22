package en8;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.RichMediaLayoutBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {
    public final int i;
    public int j;

    public final int l() {
        return this.i;
    }

    public final boolean e(jc8.a r4) {
        if ((r4 instanceof a) == false) goto L16;
        BlockContent r0 = ((jc8.a) this).a.getContent();
        RichMediaLayoutBlock r1 = null;
        if (r0 == null) goto L7;
        RichMediaLayoutBlock r2 = r0.getRichMediaLayoutBlock();
    L8:
        a r5 = (a) r4;
        BlockContent r3 = ((jc8.a) r5).a.getContent();
        if (r3 == null) goto L12;
        r1 = r3.getRichMediaLayoutBlock();
    L12:
        if (Intrinsics.areEqual(r2, r1) == false) goto L16;
        if (this.j != r5.j) goto L16;
        return true;
    L7:
        r2 = null;
    L16:
        return false;
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
        this.i = j.g;
        this.j = 1;
    }
}
