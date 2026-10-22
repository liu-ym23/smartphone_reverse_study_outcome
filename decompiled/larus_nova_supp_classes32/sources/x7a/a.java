package x7a;

import com.lynx.tasm.LynxView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements j {
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
        h r0 = this.b.b.peek();
        LynxView r1 = this.b.d.get(r0);
        d.a(this.b, r1);
    L7:
        this.b.b.push(this.a);
        f r2 = this.b.b();
        if (r2 == null) goto L12;
        r2.a(r3);
        return;
    L12:
        return;
    L6:
        d r4 = this.b;
        r4.getClass();
        d.a(r4, null);
        goto L7
    }

    public a(d r1, h r2, String r3) {
        this.b = r1;
        this.a = r2;
    }
}
