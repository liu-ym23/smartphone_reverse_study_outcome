package com.larus.bmhome.view;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class k1 implements View.OnLongClickListener {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ k1(Function0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        Function0 r3 = this.a;
        int r0 = ChatTitleAlignLeftStyle.T;
        r3.invoke();
        return true;
    }
}
