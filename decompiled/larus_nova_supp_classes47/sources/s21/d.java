package s21;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ Runnable b;

    public d(e r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        long r0 = System.currentTimeMillis();
        e r7 = this.a;
        if ((r0 - r7.C) <= 500) goto L8;
        r7.C = System.currentTimeMillis();
        Runnable r8 = this.b;
        if (r8 == null) goto L9;
        r8.run();
        return;
    L9:
        return;
    }
}
