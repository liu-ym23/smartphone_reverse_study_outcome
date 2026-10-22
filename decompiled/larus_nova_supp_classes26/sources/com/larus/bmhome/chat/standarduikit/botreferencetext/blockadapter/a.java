package com.larus.bmhome.chat.standarduikit.botreferencetext.blockadapter;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ReferenceBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {
    public final int i;

    public final String g() {
        return "BotReferenceTextBlockBizModel";
    }

    public final int l() {
        return this.i;
    }

    public final boolean e(jc8.a r3) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        Integer r1 = null;
        if (r0 == null) goto L7;
        ReferenceBlock r2 = r0.getReferenceBlock();
        if (r2 == null) goto L7;
        Integer r4 = Integer.valueOf(r2.hashCode());
    L8:
        if (r3 == null) goto L17;
        Block r5 = r3.a;
        if (r5 == null) goto L17;
        BlockContent r6 = r5.getContent();
        if (r6 == null) goto L17;
        ReferenceBlock r7 = r6.getReferenceBlock();
        if (r7 == null) goto L17;
        r1 = Integer.valueOf(r7.hashCode());
    L17:
        return Intrinsics.areEqual(r4, r1);
    L7:
        r4 = null;
        goto L8
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
        this.i = j.J;
    }
}
