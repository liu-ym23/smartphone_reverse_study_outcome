package ce;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends a {
    public g(ae.d<Object> r8) {
        super(r8);
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.getContext() != ae.g.f354a) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
    L7:
        r10 = false;
        goto L8
    }

    @Override // ae.d
    public final ae.f getContext() {
        return ae.g.f354a;
    }
}
