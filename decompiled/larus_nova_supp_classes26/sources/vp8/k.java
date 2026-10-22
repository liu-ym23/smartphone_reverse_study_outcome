package vp8;

import android.view.ViewGroup;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.share.panel.ShareType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k implements i {
    public final List<g> a;

    @Override // vp8.i
    public final Boolean P0() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((((g) r1) instanceof wy9.c) == false) goto L4;
    L9:
        wy9.c r2 = (g) r1;
        if (r2 != null) goto L12;
        return null;
    L12:
        if ((r2 instanceof wy9.c) == false) goto L14;
        wy9.c r3 = r2;
    L15:
        if (r3 == null) goto L24;
        com.larus.bmhome.music.instructions.g r4 = r3.b();
        if (r4 != null) goto L19;
        return null;
    L19:
        return Boolean.valueOf(r4.i);
    L24:
        return null;
    L14:
        r3 = null;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    @Override // vp8.i
    public final Integer X1() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((((g) r1) instanceof wy9.c) == false) goto L4;
    L9:
        wy9.c r2 = (g) r1;
        if (r2 != null) goto L12;
        return null;
    L12:
        if ((r2 instanceof wy9.c) == false) goto L14;
        wy9.c r3 = r2;
    L15:
        if (r3 == null) goto L24;
        com.larus.bmhome.music.instructions.g r4 = r3.b();
        if (r4 != null) goto L19;
        return null;
    L19:
        return Integer.valueOf(r4.j);
    L24:
        return null;
    L14:
        r3 = null;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    @Override // vp8.i
    public final String c0() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((((g) r1) instanceof wy9.c) == false) goto L4;
    L9:
        wy9.c r2 = (g) r1;
        if (r2 != null) goto L12;
        return null;
    L12:
        if ((r2 instanceof wy9.c) == false) goto L14;
        wy9.c r3 = r2;
    L15:
        if (r3 == null) goto L24;
        com.larus.bmhome.music.instructions.g r4 = r3.b();
        if (r4 != null) goto L19;
        return null;
    L19:
        return r4.h;
    L24:
        return null;
    L14:
        r3 = null;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    @Override // vp8.i
    public final void e() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).i();
        goto L4
    }

    @Override // vp8.i
    public final void onAttach() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).d();
        goto L4
    }

    @Override // vp8.i
    public final void onDestroy() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).p();
        goto L4
    }

    public k() {
        this.a = new ArrayList();
    }

    @Override // vp8.i
    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        ((ArrayList) this.a).add(r2);
    }

    @Override // vp8.i
    public final void b(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).u(r3);
        goto L4
    }

    @Override // vp8.i
    public final boolean c(z0 r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((g) r0.next()).f(r3) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // vp8.i
    public final void d(com.larus.bmhome.view.actionbar.edit.c r3) {
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).t(r3);
        goto L4
    }

    @Override // vp8.i
    public final void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).r(r3);
        goto L4
    }

    @Override // vp8.i
    public final boolean g(r r3) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((g) r0.next()).q(r3) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // vp8.i
    public final boolean x(String r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Iterator<T> r0 = this.a.iterator();
    L3:
        wy9.c r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((((g) r1) instanceof wy9.c) == false) goto L3;
    L9:
        g r3 = (g) r1;
        if (r3 != null) goto L12;
        return false;
    L12:
        if ((r3 instanceof wy9.c) == false) goto L14;
        r2 = (wy9.c) r3;
    L14:
        if (r2 != null) goto L16;
        return false;
    L16:
        return r2.x(r5);
    L8:
        r1 = null;
        goto L9
    }
}
