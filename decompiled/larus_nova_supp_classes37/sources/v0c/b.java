package v0c;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.player.widget.SuperContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class b implements o, t {
    public final Context a;
    public q b;
    public t c;

    @Override // v0c.o
    public void a(int r1, Bundle r2) {
    }

    @Override // v0c.o
    public void d(int r1) {
    }

    @Override // v0c.o
    public void h(int r1, Bundle r2) {
    }

    @Override // v0c.t
    public final r i() {
        t r0 = this.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.i();
    }

    public final Context getContext() {
        return this.a;
    }

    public b(Context r1) {
        this.a = r1;
    }

    @Override // v0c.o
    public final void b(SuperContainer.a r1) {
        this.b = r1;
    }

    @Override // v0c.o
    public final void c(t r1) {
        this.c = r1;
    }

    public final void j(int r2, Bundle r3) {
        q r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }
}
