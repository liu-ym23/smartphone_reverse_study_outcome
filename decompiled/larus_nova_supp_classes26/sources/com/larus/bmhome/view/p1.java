package com.larus.bmhome.view;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class p1 implements View.OnLongClickListener {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ p1(Function1 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        Function1 r0 = this.a;
        int r1 = ChatTitleAlignLeftStyle.T;
        Intrinsics.checkNotNull(r3);
        r0.invoke(r3);
        return true;
    }
}
