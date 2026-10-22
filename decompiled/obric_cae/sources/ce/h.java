package ce;

import he.i;
import he.p;
import he.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends c implements he.f<Object> {
    private final int arity;

    public h(int r8) {
        this(r8, null);
    }

    @Override // he.f
    public int getArity() {
        return this.arity;
    }

    @Override // ce.a
    public String toString() {
        if (getCompletion() != null) goto L6;
        p.f8065a.getClass();
        String r8 = q.a(this);
        i.e(r8, "renderLambdaToString(this)");
        return r8;
    L6:
        return super.toString();
    }

    public h(int r8, ae.d<Object> r10) {
        super(r10);
        this.arity = r8;
    }
}
