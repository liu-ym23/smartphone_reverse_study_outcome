package ce;

import he.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends a {
    private final ae.f _context;
    private transient ae.d<Object> intercepted;

    public c(ae.d<Object> r8) {
        if (r8 == null) goto L4;
        ae.f r10 = r8.getContext();
    L5:
        this(r8, r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    @Override // ae.d
    public ae.f getContext() {
        ae.f r8 = this._context;
        i.c(r8);
        return r8;
    }

    public final ae.d<Object> intercepted() {
        ae.d<Object> r8 = this.intercepted;
        if (r8 != null) goto L10;
        ae.e r10 = (ae.e) getContext().q0(ae.e.b.f352a);
        if (r10 == null) goto L8;
        r8 = r10.f0(this);
        if (r8 == null) goto L8;
    L9:
        this.intercepted = r8;
    L8:
        r8 = this;
    L10:
        return r8;
    }

    @Override // ce.a
    public void releaseIntercepted() {
        ae.d<?> r8 = this.intercepted;
        if (r8 == null) goto L6;
        if (r8 == this) goto L6;
        ae.f r10 = getContext();
        int r11 = ae.e.f351c;
        ae.f.b r12 = r10.q0(ae.e.b.f352a);
        i.c(r12);
        ((ae.e) r12).z(r8);
    L6:
        this.intercepted = b.f3444a;
    }

    public c(ae.d<Object> r8, ae.f r10) {
        super(r8);
        this._context = r10;
    }
}
