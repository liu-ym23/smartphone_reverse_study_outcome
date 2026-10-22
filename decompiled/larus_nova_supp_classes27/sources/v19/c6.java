package v19;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class c6 implements View.OnClickListener {
    public final long a;
    public long b;

    public abstract void a(View r1);

    public c6() {
        this.a = 500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        Intrinsics.checkNotNullParameter(r8, "v");
        long r0 = System.currentTimeMillis();
        if ((r0 - this.b) <= this.a) goto L6;
        a(r8);
        this.b = r0;
        return;
    }
}
