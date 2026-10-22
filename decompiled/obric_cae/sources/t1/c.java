package t1;

/* JADX INFO: loaded from: classes.dex */
public final class c<V> extends a<V> {
    @Override // t1.a
    public final boolean i(ga.a<? extends V> r8) {
        return super.i(r8);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean j(V r8) {
        if (r8 != null) goto L5;
        r8 = (V) a.f12215q;
    L5:
        if (a.f12214p.b(this, null, r8) == false) goto L7;
        a.c(this);
        return true;
    L7:
        return false;
    }

    public final boolean k(Throwable r8) {
        r8.getClass();
        a.c r10 = new a.c(r8);
        if (a.f12214p.b(this, null, r10) == false) goto L5;
        a.c(this);
        return true;
    L5:
        return false;
    }
}
