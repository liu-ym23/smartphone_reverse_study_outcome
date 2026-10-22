package v19;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.graphics.Insets;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k7 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Function2<Insets, Boolean, Unit> c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Rect r0 = new Rect();
        boolean r1 = z5.a;
        if (z5.c(this.a, r0) == true) goto L5;
        return;
    L5:
        int r2 = Math.abs(this.b.getBottom() - r0.bottom);
        if (r2 <= 0) goto L8;
        boolean r3 = true;
    L9:
        Insets r4 = Insets.of(0, 0, 0, r2);
        Function2<Insets, Boolean, Unit> r5 = this.c;
        if (r5 == null) goto L13;
        r5.invoke(r4, Boolean.valueOf(r3));
        return;
    L13:
        return;
    L8:
        r3 = false;
        goto L9
    }

    public k7(View r1, View r2, Function2<? super Insets, ? super Boolean, Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
