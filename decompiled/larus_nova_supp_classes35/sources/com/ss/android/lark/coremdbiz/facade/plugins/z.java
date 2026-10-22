package com.ss.android.lark.coremdbiz.facade.plugins;

import android.content.Context;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.widget.table.entity.TableInfo;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public z() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        LarkContextExtend.a r0 = LarkContextExtend.s;
        com.ss.android.lark.coremdbiz.facade.table.a r1 = (com.ss.android.lark.coremdbiz.facade.table.a) r0.b(new TablePlugin$configureSpanFactory$1$tableParseFactory$1(r7));
        if (r1 != null) goto L5;
        return null;
    L5:
        eab.h r2 = (eab.h) r7.d;
        Context r3 = r7.getContext();
        final com.ss.android.lark.coremd.impl.parse.m r4 = r7.c();
        final Function1 r5 = (Function1) r0.b(new TablePlugin$configureSpanFactory$1$longPressHandler$1(r7));
        final TableInfo r6 = com.ss.android.lark.coremdbiz.facade.table.d.a(r3, r1, r2);
        return com.ss.android.lark.coremd.ext.b.a(new TablePlugin$configureSpanFactory$1$span$1(r6, r5, r7, r4), new Object[]{r4});
    }
}
