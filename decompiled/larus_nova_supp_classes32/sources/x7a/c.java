package x7a;

import com.lynx.tasm.LynxView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements j {
    public final /* synthetic */ h a;
    public final /* synthetic */ j b;
    public final /* synthetic */ d c;

    @Override // x7a.j
    public final void onFailed() {
        this.b.onFailed();
    }

    @Override // x7a.j
    public final void a(LynxView r3) {
        if (r3 == null) goto L5;
        this.c.d.put(this.a, r3);
        this.b.a(r3);
        return;
    }

    public c(d r1, h r2, j r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
