package androidx.activity;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.a.C0027a f482b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity.a f483m;

    public h(ComponentActivity.a r8, int r10, b.a.C0027a r11) {
        this.f483m = r8;
        this.f481a = r10;
        this.f482b = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // java.lang.Runnable
    public final void run() {
        T r8 = this.f482b.f2967a;
        ComponentActivity.a r10 = this.f483m;
        String r11 = (String) r10.f522a.get(Integer.valueOf(this.f481a));
        if (r11 == null) goto L17;
        androidx.activity.result.e.a r12 = (androidx.activity.result.e.a) r10.f526e.get(r11);
        if (r12 == null) goto L13;
        androidx.activity.result.a<O> r13 = r12.f529a;
        if (r13 == 0) goto L13;
        if (r10.f525d.remove(r11) == false) goto L15;
        r13.a(r8);
        return;
    L15:
        return;
    L13:
        r10.f528g.remove(r11);
        r10.f527f.put(r11, r8);
        return;
    }
}
