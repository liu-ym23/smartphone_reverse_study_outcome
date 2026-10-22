package com.larus.bmhome.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a2 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ c2 b;
    public final /* synthetic */ FragmentActivity c;
    public final /* synthetic */ Function1 d;

    public /* synthetic */ a2(View r1, c2 r2, FragmentActivity r3, com.larus.bmhome.chat.z3 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View r0 = this.a;
        c2 r1 = this.b;
        FragmentActivity r2 = this.c;
        Function1 r3 = this.d;
        r0.getWindowVisibleDisplayFrame(r1.a);
        int r4 = com.larus.utils.w0.a;
        int r5 = (com.larus.utils.w0.c(r2) - r1.a.bottom) - com.larus.utils.u.b(r2);
        if (r5 >= 150) goto L6;
        r5 = 0;
    L6:
        if (r1.b == r5) goto L9;
        r1.b = r5;
        r3.invoke(Integer.valueOf(r5));
        return;
    }
}
