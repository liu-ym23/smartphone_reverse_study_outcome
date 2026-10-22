package com.larus.bmhome.utils;

import com.larus.bmhome.share.panel.ShareType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int b(String r7) {
        Intrinsics.checkNotNullParameter(r7, ShareType.TEXT);
        Regex r0 = new Regex("\\s|[一-鿿。、《》【】「」]");
        ArrayList r1 = new ArrayList();
        Iterator r2 = Regex.findAll$default(r0, r7, 0, 2, null).iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L13;
        MatchResult r4 = (MatchResult) r2.next();
        String r5 = r7.substring(r3, r4.getRange().getFirst());
        if (r5.length() <= 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        a(r1, r5);
    L11:
        a(r1, r4.getValue());
        r3 = r4.getRange().getLast() + 1;
        goto L4
    L8:
        r6 = false;
        goto L9
    L13:
        if (r3 >= r7.length()) goto L16;
        a(r1, r7.substring(r3));
    L16:
        return r1.size();
    }

    public static void a(List r2, String r3) {
        if (new Regex("\\s|——").matches(r3) == true) goto L6;
        ((ArrayList) r2).add(r3);
        return;
    }
}
