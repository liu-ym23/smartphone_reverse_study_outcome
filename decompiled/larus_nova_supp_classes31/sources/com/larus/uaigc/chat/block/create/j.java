package com.larus.uaigc.chat.block.create;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class j extends i {
    @Override // com.larus.uaigc.chat.block.create.i
    public final boolean e(jc8.a r9) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        List r1 = null;
        if (r0 == null) goto L7;
        CreationBlock r2 = r0.getCreationBlock();
        if (r2 == null) goto L7;
        List r3 = r2.creations;
    L8:
        if (r3 != null) goto L10;
        r3 = CollectionsKt.emptyList();
    L10:
        if (r9 == null) goto L18;
        Block r10 = r9.a;
        if (r10 == null) goto L18;
        BlockContent r11 = r10.getContent();
        if (r11 == null) goto L18;
        CreationBlock r12 = r11.getCreationBlock();
        if (r12 == null) goto L18;
        r1 = r12.creations;
    L18:
        if (r1 != null) goto L21;
        r1 = CollectionsKt.emptyList();
    L21:
        if (r3.size() == r1.size()) goto L23;
        return false;
    L23:
        Collection r13 = CollectionsKt.getIndices(r1);
        if ((r13 instanceof Collection) == true) goto L26;
    L28:
        IntIterator r14 = r13.iterator();
    L30:
        if (r14.hasNext() == false) goto L27;
        int r4 = r14.nextInt();
        CreationItem r5 = (CreationItem) ListProtector.get(r3, r4);
        CreationItem r6 = (CreationItem) ListProtector.get(r1, r4);
        if (Intrinsics.areEqual(r5.id, r6.id) == true) goto L34;
    L36:
        boolean r7 = false;
    L37:
        if (r7 == true) goto L30;
        return false;
    L34:
        if (bz9.c.d(r5, r6) == false) goto L36;
        r7 = true;
    L27:
        return true;
    L26:
        if (r13.isEmpty() == false) goto L28;
    L7:
        r3 = null;
        goto L8
    }

    public j(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
