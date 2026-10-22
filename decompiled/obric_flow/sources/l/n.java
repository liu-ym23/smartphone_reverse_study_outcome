package l;

import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class n extends d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f19510i;

    public n(v.c r5, Object r10) {
        super(Collections.emptyList());
        j(r5);
        this.f19510i = r10;
    }

    @Override // l.d
    public final float c() {
        return 1.0f;
    }

    @Override // l.d
    public final Object f() {
        v.c r5 = this.e;
        Object r10 = this.f19510i;
        return r5.a(r10, r10);
    }

    @Override // l.d
    public final Object g(v.a r5, float r10) {
        return f();
    }

    @Override // l.d
    public final void h() {
        if (this.e == null) goto L6;
        super.h();
        return;
    }
}
