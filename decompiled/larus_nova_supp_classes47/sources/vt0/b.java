package vt0;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b implements View.OnClickListener {
    public static boolean b = true;
    public static final a c = null;
    public final long a;

    public abstract void a(View r1);

    /* JADX WARN: Type inference failed for: r0v0, types: [vt0.a] */
    static {
        c = new a();
    }

    public b() {
        this.a = 500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (b == false) goto L6;
        b = false;
        r4.postDelayed(c, this.a);
        a(r4);
        return;
    }
}
