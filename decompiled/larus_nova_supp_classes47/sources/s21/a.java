package s21;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ Runnable b;

    public a(b r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        long r0 = System.currentTimeMillis();
        b r7 = this.a;
        if ((r0 - r7.F) <= 500) goto L8;
        r7.F = System.currentTimeMillis();
        Runnable r8 = this.b;
        if (r8 == null) goto L9;
        r8.run();
        return;
    L9:
        return;
    }
}
