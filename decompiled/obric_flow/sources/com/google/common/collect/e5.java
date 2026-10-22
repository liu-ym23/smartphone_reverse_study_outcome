package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e5 extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8954c;
    public final Iterator d;
    public final /* synthetic */ Object e;

    public /* synthetic */ e5(l0 r5, Iterator r10, int r11) {
        this.f8954c = r11;
        this.e = r5;
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
        switch(this.f8954c) {
            case 0: goto L38;
            case 1: goto L31;
            case 2: goto L23;
            case 3: goto L15;
            default: goto L4;
        };
    L4:
        Iterator r5 = this.d;
        if (r5.hasNext() == true) goto L7;
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L7:
        Range r10 = (Range) r5.next();
        fa r11 = (fa) this.e;
        if (r11.f8979b.lowerBound.compareTo(r10.upperBound) < 0) goto L10;
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L10:
        Range r12 = r10.intersection(r11.f8979b);
        Object r13 = r12.lowerBound;
        if (r11.f8978a.contains(r13) == true) goto L53;
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L53:
        return new ImmutableEntry(r12.lowerBound, r12);
    L15:
        j5 r14 = (j5) this.d;
        if (r14.hasNext() == true) goto L18;
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L18:
        Range r15 = (Range) r14.next();
        if (((ea) this.e).f8962b.lowerBound.isLessThan(r15.upperBound) == true) goto L55;
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L55:
        return new ImmutableEntry(r15.upperBound, r15);
    L23:
        Iterator r16 = this.d;
        if (r16.hasNext() == true) goto L26;
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L26:
        Range r17 = (Range) r16.next();
        if (((ea) this.e).f8962b.upperBound.isLessThan(r17.upperBound) == false) goto L30;
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L30:
        return new ImmutableEntry(r17.upperBound, r17);
    L31:
        Iterator r18 = this.d;
        if (r18.hasNext() == false) goto L36;
        Map.Entry r19 = (Map.Entry) r18.next();
        if (((Map) r19.getValue()).containsKey(((b9) this.e).d) == false) goto L31;
        return new b7(this, r19);
    L36:
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L38:
        Iterator r20 = this.d;
        if (r20.hasNext() == false) goto L43;
        Object r21 = r20.next();
        if (((com.google.common.base.z) this.e).apply(r21) == false) goto L38;
        return r21;
    L43:
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    }

    public e5(b9 r5) {
        this.f8954c = 1;
        this.e = r5;
        this.d = r5.e.backingMap.entrySet().iterator();
    }

    public e5(Iterator r5, com.google.common.base.z r10) {
        this.f8954c = 0;
        this.d = r5;
        this.e = r10;
    }
}
