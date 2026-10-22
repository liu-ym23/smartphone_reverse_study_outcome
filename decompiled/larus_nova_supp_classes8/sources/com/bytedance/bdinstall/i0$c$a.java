package com.bytedance.bdinstall;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class i0$c$a implements i0$d.a {
    public final /* synthetic */ i0.c a;

    @Override // com.bytedance.bdinstall.i0$d.a
    public final void onNetworkReady() {
        i0.c r0 = this.a;
        if (r0.b.c.hasMessages(1235, r0.a) == false) goto L5;
        i0.c r1 = this.a;
        r1.b.c.removeMessages(1235, r1.a);
        i0.c r2 = this.a;
        r2.b.c.obtainMessage(1235, r2.a).sendToTarget();
        int r3 = t.a;
    L5:
        i0.c r4 = this.a;
        r4.a.g = null;
        ((i0$d) i0.k.b(new Object[]{r4.b.a.getContext()})).b(this);
        t.d("remove observer " + this.a.a + ", " + this);
    }

    public i0$c$a(i0.c r1) {
        this.a = r1;
    }
}
