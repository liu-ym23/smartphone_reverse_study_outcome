package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class ca extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8930c;
    public Cut d;
    public final /* synthetic */ j5 e;
    public final /* synthetic */ da f;

    public /* synthetic */ ca(da r5, Cut r10, j5 r11, int r12) {
        this.f8930c = r12;
        this.f = r5;
        this.e = r11;
        this.d = r10;
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
    @Override // com.google.common.collect.g
    public final Object a() {
        switch(this.f8930c) {
            case 0: goto L18;
            default: goto L5;
        };
    L5:
        if (this.d != Cut.belowAll()) goto L7;
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L7:
        j5 r5 = this.e;
        boolean r10 = r5.hasNext();
        da r11 = this.f;
        if (r10 == false) goto L13;
        Range r12 = (Range) r5.next();
        Range r13 = Range.create(r12.upperBound, this.d);
        this.d = r12.lowerBound;
        if (r11.f8948c.lowerBound.isLessThan(r13.lowerBound) == true) goto L30;
    L15:
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L30:
        return new ImmutableEntry(r13.lowerBound, r13);
    L13:
        if (r11.f8948c.lowerBound.isLessThan(Cut.belowAll()) == false) goto L15;
        Range r14 = Range.create(Cut.belowAll(), this.d);
        this.d = Cut.belowAll();
        return new ImmutableEntry(Cut.belowAll(), r14);
    L18:
        if (this.f.f8948c.upperBound.isLessThan(this.d) == false) goto L20;
    L27:
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L20:
        if (this.d == Cut.aboveAll()) goto L27;
        j5 r15 = this.e;
        if (r15.hasNext() == false) goto L25;
        Range r16 = (Range) r15.next();
        Range r17 = Range.create(this.d, r16.lowerBound);
        this.d = r16.upperBound;
    L32:
        return new ImmutableEntry(r17.lowerBound, r17);
    L25:
        r17 = Range.create(this.d, Cut.aboveAll());
        this.d = Cut.aboveAll();
        goto L32
    }
}
