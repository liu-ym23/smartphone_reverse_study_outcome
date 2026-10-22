package com.larus.bmhome.chat.detail.code;

import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h0 {
    public final String a;
    public long b;
    public n0 c;
    public com.larus.im.internal.research.d.a d;
    public final Lazy e;

    public static final class a {
    }

    static {
    }

    public static String a(List r3) {
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        Object r0 = r4.next();
        if (((Block) r0).getBlockType() != com.larus.bmhome.chat.deepresearch.view.j.e) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
    L12:
        Block r2 = (Block) r0;
        if (r2 == null) goto L21;
        BlockContent r5 = r2.getContent();
        if (r5 == null) goto L21;
        TextBlock r6 = r5.getTextBlock();
        if (r6 == null) goto L21;
        String r7 = r6.text;
        if (r7 == null) goto L21;
        return r7;
    L21:
        return "";
    L8:
        r1 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    public h0(String r2, CodeBlockDetailFragment.c r3) {
        Intrinsics.checkNotNullParameter(r2, "resourceId");
        this.a = r2;
        this.c = r3;
        this.e = LazyKt.lazy(new g0());
    }
}
