package v0c;

import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements p.a {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ int b;

    @Override // v0c.p.a
    public final void a(o r6) {
        if ((r6 instanceof com.ss.android.lark.player.player.o) == false) goto L7;
        Bundle r0 = this.a;
        if (r0 == null) goto L7;
        ((com.ss.android.lark.player.player.o) r6).e(r0.getInt("int_arg1"), this.a.getInt("int_arg2"), this.a.getInt("int_arg3"));
    L7:
        r6.a(this.b, this.a);
    }

    public h(Bundle r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
