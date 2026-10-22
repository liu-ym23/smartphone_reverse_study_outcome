package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o implements Runnable {
    public final /* synthetic */ p a;
    public final /* synthetic */ Bitmap b;

    public o(p r1, Bitmap r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView r0 = this.a.b;     // Catch: Throwable -> L4
        r0.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(r0.getContext().getResources(), this.b), null, null, null);     // Catch: Throwable -> L4
        r0.setCompoundDrawablePadding(vf4.a.b(4));     // Catch: Throwable -> L4
        this.a.a.requestLayout();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
