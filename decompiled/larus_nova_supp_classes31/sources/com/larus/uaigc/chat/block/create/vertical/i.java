package com.larus.uaigc.chat.block.create.vertical;

import android.view.ViewGroup;
import com.larus.uaigc.chat.block.create.AbsCreationBlockView;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i extends com.larus.uaigc.chat.block.create.l<h> {
    public final String c() {
        return "LocalCreationVerticalBlockHolder";
    }

    public i() {
    }

    public final jc8.d f(jc8.a r5) {
        h r6 = (h) r5;
        Intrinsics.checkNotNullParameter(r6, "blockModel");
        boolean r0 = r6.m();
        boolean r7 = r6.n();
        if (r0 == false) goto L7;
        if (r7 == false) goto L7;
        return new jc8.d(0, c7.b(12), 0, c7.b(12));
    L7:
        if (r0 == true) goto L14;
        if (r7 == false) goto L12;
        return new jc8.d(0, c7.b(6), 0, c7.b(12));
    L12:
        return new jc8.d(0, c7.b(6), 0, c7.b(6));
    L14:
        return new jc8.d(0, c7.b(12), 0, c7.b(6));
    }

    @Override // com.larus.uaigc.chat.block.create.BaseCreationHolder
    public final AbsCreationBlockView j(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        return new LocalCreationVerticalGroup(r2.getContext());
    }
}
