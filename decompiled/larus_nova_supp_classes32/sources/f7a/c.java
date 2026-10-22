package f7a;

import android.view.Choreographer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class c {
    public boolean a;
    public int b;
    public boolean c;
    public b d;

    public abstract boolean a(int r1);

    public final void b() {
        if (this.d == null) goto L6;
        Choreographer.getInstance().removeFrameCallback(this.d);
        this.d = null;
        return;
    }

    public c() {
        this.a = false;
        this.b = 0;
        this.c = true;
        this.d = null;
    }
}
