package com.larus.uaigc.chat.block.create.vertical;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a extends com.larus.uaigc.chat.block.create.i {
    public final String g() {
        return "CreationVerticalBizModel";
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
