package com.ss.android.lark.forwardv3.doubao;

import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.messageforward.MergeMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.OneByOneMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final int a(IForwardContent r3) {
        if ((r3 instanceof SingleMessageForwardContent) == true) goto L56;
        int r2 = 0;
        if ((r3 instanceof MergeMessageForwardContent) == false) goto L24;
        MergeMessageForwardContent r4 = (MergeMessageForwardContent) r3;
        if (r4.e == true) goto L57;
        ArrayList<String> r5 = r4.c;
        if ((r5 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r6 = r5.iterator();
    L17:
        if (r6.hasNext() == false) goto L55;
        if ((!StringsKt.isBlank((String) r6.next())) == false) goto L17;
        r2 = r2 + 1;
        if (r2 >= 0) goto L17;
        CollectionsKt.throwCountOverflow();
    L55:
        return r2;
    L13:
        if (r5.isEmpty() == false) goto L15;
    L39:
        return 0;
    L57:
        return 1;
    L24:
        if ((r3 instanceof OneByOneMessageForwardContent) == false) goto L39;
        ArrayList<String> r7 = ((OneByOneMessageForwardContent) r3).c;
        if ((r7 instanceof Collection) == true) goto L28;
    L30:
        Iterator<T> r8 = r7.iterator();
    L32:
        if (r8.hasNext() == false) goto L55;
        if ((!StringsKt.isBlank((String) r8.next())) == false) goto L32;
        r2 = r2 + 1;
        if (r2 >= 0) goto L32;
        CollectionsKt.throwCountOverflow();
        goto L32
    L28:
        if (r7.isEmpty() == false) goto L30;
    L56:
        return 1;
    }
}
