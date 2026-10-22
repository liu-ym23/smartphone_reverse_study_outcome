package com.larus.contextwindow.impl.component;

import com.larus.im.bean.message.Message;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class h implements Function1 {
    public /* synthetic */ h() {
    }

    public final Object invoke(Object r7) {
        IndexedValue r8 = (IndexedValue) r7;
        int r0 = ContextWindowEntryFeature.z;
        Intrinsics.checkNotNullParameter(r8, "<destruct>");
        Message r9 = (Message) r8.component2();
        Long r1 = Long.valueOf(r9.getServerIndex());
        if (r1.longValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return Long.valueOf(r9.getLocalIndex());
    L5:
        r2 = false;
        goto L6
    }
}
