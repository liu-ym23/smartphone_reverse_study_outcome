package kqb;

import android.os.SystemClock;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a implements View.OnClickListener {
    public long a;

    public abstract void a();

    public a() {
        this.a = 0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.a) <= 1000) goto L6;
        a();
        this.a = r0;
        return;
    }
}
