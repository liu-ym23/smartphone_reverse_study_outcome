package he;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j<R> implements f<R>, Serializable {
    private final int arity;

    public j(int r8) {
        this.arity = r8;
    }

    @Override // he.f
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        p.f8065a.getClass();
        String r8 = q.a(this);
        i.e(r8, "renderLambdaToString(this)");
        return r8;
    }
}
