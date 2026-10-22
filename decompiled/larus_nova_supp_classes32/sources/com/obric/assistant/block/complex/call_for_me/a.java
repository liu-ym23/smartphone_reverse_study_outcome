package com.obric.assistant.block.complex.call_for_me;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OComplexCallForMeBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends jc8.a {
    public final String g() {
        return "ComplexCallForMeBizModel";
    }

    public final int l() {
        int r0 = j.a;
        return j.M;
    }

    public final boolean e(jc8.a r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        BlockContent r0 = ((jc8.a) this).a.getContent();
        OComplexCallForMeBlock r1 = null;
        if (r0 == null) goto L8;
        OComplexCallForMeBlock r2 = r0.getOComplexCallForMeBlock();
    L9:
        Block r4 = r3.a;
        if (r4 == null) goto L15;
        BlockContent r5 = r4.getContent();
        if (r5 == null) goto L15;
        r1 = r5.getOComplexCallForMeBlock();
    L15:
        return !Intrinsics.areEqual(r2, r1);
    L8:
        r2 = null;
        goto L9
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
