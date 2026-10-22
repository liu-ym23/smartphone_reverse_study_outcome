package com.larus.uaigc.chat.block.create;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class i extends jc8.a {
    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.d;
    }

    public boolean e(jc8.a r10) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        if (r0 == null) goto L7;
        CreationBlock r1 = r0.getCreationBlock();
        if (r1 == null) goto L7;
        List r2 = r1.creations;
    L8:
        if (r10 == null) goto L16;
        Block r11 = r10.a;
        if (r11 == null) goto L16;
        BlockContent r12 = r11.getContent();
        if (r12 == null) goto L16;
        CreationBlock r13 = r12.getCreationBlock();
        if (r13 == null) goto L16;
        List r14 = r13.creations;
    L17:
        if (r2 == null) goto L69;
        if (r14 == null) goto L69;
        if (r2.size() == r14.size()) goto L23;
        return false;
    L23:
        Collection r3 = CollectionsKt.getIndices(r14);
        if ((r3 instanceof Collection) == true) goto L26;
    L28:
        IntIterator r4 = r3.iterator();
    L30:
        if (r4.hasNext() == false) goto L27;
        int r5 = r4.nextInt();
        CreationItem r6 = (CreationItem) ListProtector.get(r2, r5);
        CreationItem r7 = (CreationItem) ListProtector.get(r14, r5);
        if (Intrinsics.areEqual(r7.id, r6.id) == true) goto L34;
    L65:
        boolean r8 = false;
    L66:
        if (r8 == true) goto L30;
        return false;
    L34:
        if (Intrinsics.areEqual(r7.type, r6.type) == false) goto L65;
        Integer r9 = r7.type;
        if (r9 != null) goto L39;
    L49:
        if (r9 != null) goto L52;
    L62:
        boolean r15 = true;
    L63:
        if (r15 == false) goto L65;
        r8 = true;
        goto L66
    L52:
        if (r9.intValue() != 2) goto L62;
        VideoData r16 = r7.video;
        if (r16 == null) goto L56;
        Integer r17 = r16.status;
    L57:
        VideoData r18 = r6.video;
        if (r18 == null) goto L60;
        Integer r19 = r18.status;
    L61:
        r15 = Intrinsics.areEqual(r17, r19);
        goto L63
    L60:
        r19 = null;
        goto L61
    L56:
        r17 = null;
        goto L57
    L39:
        if (r9.intValue() != 1) goto L49;
        ImageData r20 = r7.image;
        if (r20 == null) goto L43;
        Integer r21 = r20.status;
    L44:
        ImageData r22 = r6.image;
        if (r22 == null) goto L47;
        Integer r23 = r22.status;
    L48:
        r15 = Intrinsics.areEqual(r21, r23);
        goto L63
    L47:
        r23 = null;
        goto L48
    L43:
        r21 = null;
    L27:
        return true;
    L26:
        if (r3.isEmpty() == false) goto L28;
    L69:
        return Intrinsics.areEqual(r2, r14);
    L16:
        r14 = null;
    L7:
        r2 = null;
        goto L8
    }

    public i(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
