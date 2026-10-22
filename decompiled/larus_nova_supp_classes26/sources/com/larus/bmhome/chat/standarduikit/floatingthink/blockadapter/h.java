package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockControlInfo;
import com.larus.im.bean.message.block.TextBlock;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final boolean a(g r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        List r4 = r3.i();
        if ((r4 instanceof Collection) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if ((!b((jc8.a) r5.next())) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r4.isEmpty() == false) goto L7;
        return false;
    }

    public static final boolean b(jc8.a r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((!r4.i().isEmpty()) == false) goto L5;
        return false;
    L5:
        int r0 = r4.a.getBlockType();
        int r3 = com.larus.bmhome.chat.deepresearch.view.j.a;
        if (r0 != com.larus.bmhome.chat.deepresearch.view.j.e) goto L26;
        BlockContent r1 = r4.a.getContent();
        if (r1 == null) goto L12;
        TextBlock r2 = r1.getTextBlock();
        if (r2 == null) goto L12;
        String r5 = r2.text;
    L13:
        if (r5 != null) goto L15;
    L18:
        boolean r6 = true;
    L19:
        if (r6 == true) goto L28;
        BlockControlInfo r7 = r4.a.getControlInfo();
        if (r7 == null) goto L23;
        boolean r8 = Intrinsics.areEqual(r7.isVisible(), Boolean.FALSE);
    L24:
        if (r8 == false) goto L26;
        return true;
    L23:
        r8 = false;
        goto L24
    L28:
        return true;
    L15:
        if (r5.length() == 0) goto L18;
        r6 = false;
    L12:
        r5 = null;
    L26:
        return false;
    }
}
