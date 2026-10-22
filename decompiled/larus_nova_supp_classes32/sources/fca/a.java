package fca;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OSearchQueryResultBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends jc8.a {
    public final String g() {
        return "LocalSearchBizModel";
    }

    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.N;
    }

    public final boolean e(jc8.a r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        BlockContent r1 = ((jc8.a) this).a.getContent();
        OSearchQueryResultBlock r2 = null;
        if (r1 == null) goto L8;
        OSearchQueryResultBlock r3 = r1.getOSearchQueryResultBlock();
    L9:
        if (r3 == null) goto L11;
        int r5 = r3.hashCode();
    L12:
        Block r6 = r4.a;
        if (r6 == null) goto L17;
        BlockContent r7 = r6.getContent();
        if (r7 == null) goto L17;
        r2 = r7.getOSearchQueryResultBlock();
    L17:
        if (r2 == null) goto L19;
        int r8 = r2.hashCode();
    L20:
        if (r5 != r8) goto L23;
        return true;
    L23:
        return false;
    L19:
        r8 = 0;
        goto L20
    L11:
        r5 = 0;
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
