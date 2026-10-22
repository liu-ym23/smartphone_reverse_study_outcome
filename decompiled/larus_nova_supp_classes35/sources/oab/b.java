package oab;

import android.os.SystemClock;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class b implements View.OnClickListener {
    public long a;

    public abstract void a(View r1);

    public b() {
        this.a = 0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.a) <= 1000) goto L6;
        a(r8);
        this.a = r0;
        return;
    }
}
