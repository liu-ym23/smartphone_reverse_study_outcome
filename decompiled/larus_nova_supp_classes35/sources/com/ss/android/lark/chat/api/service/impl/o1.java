package com.ss.android.lark.chat.api.service.impl;

import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o1 implements Comparator<n5b.a> {
    public o1() {
    }

    @Override // java.util.Comparator
    public final int compare(n5b.a r3, n5b.a r4) {
        n5b.a r5 = r3;
        n5b.a r6 = r4;
        if (r5.b.getPosition() != r6.b.getPosition()) goto L11;
        if (r5.isPreMessage() == r6.isPreMessage()) goto L11;
        if (r5.isPreMessage() == false) goto L9;
        return 1;
    L9:
        return -1;
    L11:
        return r5.b.getPosition() - r6.b.getPosition();
    }
}
