package com.larus.bmhome.view;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b4 implements View.OnClickListener {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ String b;

    public /* synthetic */ b4(z3 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Function1 r4 = this.a;
        String r0 = this.b;
        int r1 = ReplySuggestList$SuggestHolder.a;
        r4.invoke(r0);
    }
}
