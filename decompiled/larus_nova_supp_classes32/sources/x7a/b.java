package x7a;

import com.lynx.tasm.LynxView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements j {
    public final /* synthetic */ h a;
    public final /* synthetic */ d b;

    @Override // x7a.j
    public final void onFailed() {
    }

    @Override // x7a.j
    public final void a(LynxView r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.b.b.isEmpty() == true) goto L6;
        h r0 = this.b.b.pop();
        LynxView r1 = this.b.d.remove(r0);
        this.b.c(r1);
    L7:
        this.b.b.push(this.a);
        f r2 = this.b.b();
        if (r2 == null) goto L12;
        r2.a(r3);
        return;
    L12:
        return;
    L6:
        this.b.getClass();
        goto L7
    }

    public b(d r1, h r2, String r3) {
        this.b = r1;
        this.a = r2;
    }
}
