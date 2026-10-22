package com.larus.bmhome.chat.standarduikit.taskcard.blockadapter;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TaskCardBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {
    public final String g() {
        return "TaskCardBlockBizModel";
    }

    public final int l() {
        int r0 = j.a;
        return j.w;
    }

    public final boolean e(jc8.a r3) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        TaskCardBlock r1 = null;
        if (r0 == null) goto L5;
        TaskCardBlock r2 = r0.getTaskCardBlock();
    L6:
        if (r3 == null) goto L13;
        Block r4 = r3.a;
        if (r4 == null) goto L13;
        BlockContent r5 = r4.getContent();
        if (r5 == null) goto L13;
        r1 = r5.getTaskCardBlock();
    L13:
        return Intrinsics.areEqual(r2, r1);
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
