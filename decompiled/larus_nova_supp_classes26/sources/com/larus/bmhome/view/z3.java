package com.larus.bmhome.view;

import com.larus.bmhome.share.panel.ShareType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class z3 implements Function1 {
    public final /* synthetic */ ReplySuggestList.SuggestAdapter a;
    public final /* synthetic */ int b;

    public /* synthetic */ z3(ReplySuggestList.SuggestAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        ReplySuggestList.SuggestAdapter r0 = this.a;
        int r1 = this.b;
        String r5 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, ShareType.TEXT);
        r0.c.invoke(r5, Integer.valueOf(r1));
        return Unit.INSTANCE;
    }
}
