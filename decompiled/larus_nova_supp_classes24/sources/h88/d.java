package h88;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class d {
    public View a;
    public boolean b;
    public boolean c;
    public Function0<? extends b> d;

    public void c() {
    }

    public abstract void d(boolean r1);

    public abstract String getType();

    public d() {
        this.b = true;
    }

    public void a(boolean r2) {
        this.b = r2;
        View r0 = this.a;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        float r3 = 1.0f;
    L7:
        r0.setAlpha(r3);
        return;
    L6:
        r3 = 0.4f;
        goto L7
    }

    public void b(boolean r2) {
        this.c = r2;
        View r0 = this.a;
        if (r0 == null) goto L6;
        r0.setSelected(r2);
        return;
    }
}
