package zd;

import he.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c<K, V> extends yd.b<Map.Entry<Object, Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<K, V> f14363a;

    public c(b<K, V> r8) {
        i.f(r8, "backing");
        this.f14363a = r8;
    }

    @Override // yd.b
    public final int a() {
        return this.f14363a.f14353r;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object r8) {
        i.f((Map.Entry) r8, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends Map.Entry<K, V>> r8) {
        i.f(r8, "elements");
        throw new UnsupportedOperationException();
    }

    public final boolean b(Object r8) {
        if ((r8 instanceof Map.Entry) == true) goto L6;
        return false;
    L6:
        Map.Entry<? extends K, ? extends V> r10 = (Map.Entry) r8;
        i.f(r10, "element");
        return this.f14363a.e(r10);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean c(Object r8) {
        if ((r8 instanceof Map.Entry) == true) goto L5;
        return false;
    L5:
        Map.Entry r10 = (Map.Entry) r8;
        i.f(r10, "element");
        b<K, V> r11 = this.f14363a;
        r11.getClass();
        r11.c();
        int r12 = r11.g((K) r10.getKey());
        if (r12 < 0) goto L13;
        V[] r13 = r11.f14347b;
        i.c(r13);
        if (i.a(r13[r12], r10.getValue()) == false) goto L14;
        r11.j(r12);
        return true;
    L14:
        return false;
    L13:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f14363a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ boolean contains(Object r8) {
        return b(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<? extends Object> r8) {
        i.f(r8, "elements");
        return this.f14363a.d(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f14363a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        b<K, V> r8 = this.f14363a;
        r8.getClass();
        return new b.C0208b(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ boolean remove(Object r8) {
        return c(r8);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<? extends Object> r8) {
        i.f(r8, "elements");
        this.f14363a.c();
        return super.removeAll(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<? extends Object> r8) {
        i.f(r8, "elements");
        this.f14363a.c();
        return super.retainAll(r8);
    }
}
