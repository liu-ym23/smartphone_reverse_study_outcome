package com.obric.audio.enroll;

import android.view.View;
import android.view.ViewTreeObserver;
import com.obric.audio.enroll.view.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function0<Unit> b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.b.invoke();
    }

    public e(View r1, n r2) {
        this.a = r1;
        this.b = r2;
    }
}
