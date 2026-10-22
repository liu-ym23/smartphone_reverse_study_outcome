package com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.InconImg;
import com.larus.im.bean.message.block.LocalFileBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a implements jc8.j {
    public final int i;

    public final String c() {
        return "";
    }

    public final String g() {
        return "LocalFileBlockBizModel";
    }

    public final int l() {
        return this.i;
    }

    public final String a(boolean r4) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        String r1 = null;
        if (r0 == null) goto L7;
        LocalFileBlock r2 = r0.getLocalFileBlock();
        if (r2 == null) goto L7;
        InconImg r3 = r2.icon;
    L9:
        if (r4 == false) goto L14;
        if (r3 == null) goto L12;
        r1 = r3.iconUrlDark;
    L12:
        if (r1 != null) goto L19;
        return "";
    L19:
        return r1;
    L14:
        if (r3 == null) goto L16;
        r1 = r3.iconUrl;
    L16:
        if (r1 != null) goto L19;
        return "";
    L7:
        r3 = null;
        goto L9
    }

    public final boolean e(jc8.a r3) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        Integer r1 = null;
        if (r0 == null) goto L7;
        LocalFileBlock r2 = r0.getLocalFileBlock();
        if (r2 == null) goto L7;
        Integer r4 = Integer.valueOf(r2.hashCode());
    L8:
        if (r3 == null) goto L17;
        Block r5 = r3.a;
        if (r5 == null) goto L17;
        BlockContent r6 = r5.getContent();
        if (r6 == null) goto L17;
        LocalFileBlock r7 = r6.getLocalFileBlock();
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
        this.i = com.larus.bmhome.chat.deepresearch.view.j.i0;
    }
}
