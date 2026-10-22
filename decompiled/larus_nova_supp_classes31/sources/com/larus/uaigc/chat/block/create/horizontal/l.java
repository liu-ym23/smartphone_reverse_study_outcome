package com.larus.uaigc.chat.block.create.horizontal;

import android.view.ViewGroup;
import com.larus.uaigc.chat.block.create.AbsCreationBlockView;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l extends com.larus.uaigc.chat.block.create.l<k> {
    public final String c() {
        return "LocalCreationHorizontalBlockHolder";
    }

    public l() {
    }

    public final jc8.d f(jc8.a r5) {
        k r6 = (k) r5;
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
        return new LocalCreationHorizontalGroup(r2.getContext());
    }
}
