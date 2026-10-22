package ak8;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ComplexTaskBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {
    public final String g() {
        return "ComplexTaskBlockBizModel";
    }

    public final int l() {
        int r0 = j.a;
        return j.Z;
    }

    public final boolean e(jc8.a r3) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        ComplexTaskBlock r1 = null;
        if (r0 == null) goto L5;
        ComplexTaskBlock r2 = r0.getComplexTaskBlock();
    L6:
        if (r3 == null) goto L13;
        Block r4 = r3.a;
        if (r4 == null) goto L13;
        BlockContent r5 = r4.getContent();
        if (r5 == null) goto L13;
        r1 = r5.getComplexTaskBlock();
    L13:
        if (r2 == null) goto L15;
        int r6 = r2.hashCode();
    L16:
        if (r1 == null) goto L18;
        int r7 = r1.hashCode();
    L19:
        if (r6 != r7) goto L22;
        return true;
    L22:
        return false;
    L18:
        r7 = 0;
        goto L19
    L15:
        r6 = 0;
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
