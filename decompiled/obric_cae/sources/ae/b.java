package ae;

import ae.f.b;
import ge.l;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<B extends f.b, E extends B> implements f.c<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l<f.b, E> f346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f.c<?> f347b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [ae.f$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [ge.l<? super ae.f$b, ? extends E extends B>, ge.l<ae.f$b, E extends B>, java.lang.Object] */
    public b(f.c<B> r8, l<? super f.b, ? extends E> r10) {
        i.f(r8, "baseKey");
        i.f(r10, "safeCast");
        this.f346a = r10;
        boolean r11 = r8 instanceof b;
        ?? r12 = r8;
        if (r11 == false) goto L5;
        r12 = (f.c<B>) ((b) r8).f347b;
    L5:
        this.f347b = r12;
    }

    public final boolean a(f.c<?> r8) {
        i.f(r8, "key");
        if (r8 != this) goto L5;
    L8:
        return true;
    L5:
        if (this.f347b == r8) goto L8;
        return false;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lae/f$b;)TE; */
    public final f.b b(f.b r8) {
        i.f(r8, "element");
        return (f.b) this.f346a.invoke(r8);
    }
}
