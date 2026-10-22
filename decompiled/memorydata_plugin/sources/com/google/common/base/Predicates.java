package com.google.common.base;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Predicates {

    /* JADX INFO: renamed from: com.google.common.base.Predicates$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AndPredicate<T> implements o<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends o<? super T>> components;

        private AndPredicate(List<? extends o<? super T>> r3) {
            this.components = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ AndPredicate(List r2, AnonymousClass1 r3) {
            this((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.base.o
        public boolean apply(T r6) {
            int r1 = 0;
        L4:
            if (r1 >= this.components.size()) goto L9;
            if (((o) ZeusTransformUtils.preCheckCast(this.components.get(r1), o.class, "com.obric.memorydata.plugin")).apply(r6) == false) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return false;
        L9:
            return true;
        }

        @Override // com.google.common.base.o
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, AndPredicate.class) == false) goto L6;
            AndPredicate r4 = (AndPredicate) ZeusTransformUtils.preCheckCast(r3, AndPredicate.class, "com.obric.memorydata.plugin");
            return this.components.equals(r4.components);
        L6:
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.a("and", this.components);
        }
    }

    private static class CompositionPredicate<A, B> implements o<A>, Serializable {
        private static final long serialVersionUID = 0;
        final g<A, ? extends B> f;
        final o<B> p;

        private CompositionPredicate(o<B> r3, g<A, ? extends B> r4) {
            o r5 = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin");
            g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
            this.p = (o) ZeusTransformUtils.preCheckCast(n.a(r5), o.class, "com.obric.memorydata.plugin");
            this.f = (g) ZeusTransformUtils.preCheckCast(n.a(r6), g.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ CompositionPredicate(o r2, g r3, AnonymousClass1 r4) {
            this((o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.memorydata.plugin"), (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.base.o
        public boolean apply(A r2) {
            return this.p.apply(this.f.apply(r2));
        }

        @Override // com.google.common.base.o
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, CompositionPredicate.class) == false) goto L10;
            CompositionPredicate r5 = (CompositionPredicate) ZeusTransformUtils.preCheckCast(r4, CompositionPredicate.class, "com.obric.memorydata.plugin");
            if (this.f.equals(r5.f) == true) goto L7;
            return false;
        L7:
            if (this.p.equals(r5.p) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = this.f.hashCode();
            return this.p.hashCode() ^ r0;
        }

        public String toString() {
            return this.p + "(" + this.f + ")";
        }
    }

    private static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        ContainsPatternFromStringPredicate(String r1) {
            super(m.c(r1));
        }

        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public String toString() {
            return "Predicates.containsPattern(" + this.pattern.pattern() + ")";
        }
    }

    private static class ContainsPatternPredicate implements o<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        final e pattern;

        ContainsPatternPredicate(e r3) {
            this.pattern = (e) ZeusTransformUtils.preCheckCast(n.a(r3), e.class, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public boolean apply2(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this.pattern.matcher(r4).a();
        }

        @Override // com.google.common.base.o
        public /* synthetic */ boolean apply(CharSequence r3) {
            return apply2((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.base.o
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, ContainsPatternPredicate.class) == false) goto L10;
            ContainsPatternPredicate r5 = (ContainsPatternPredicate) ZeusTransformUtils.preCheckCast(r4, ContainsPatternPredicate.class, "com.obric.memorydata.plugin");
            if (k.a(this.pattern.pattern(), r5.pattern.pattern()) == true) goto L7;
            return false;
        L7:
            if (this.pattern.flags() != r5.pattern.flags()) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return k.a(new Object[]{this.pattern.pattern(), Integer.valueOf(this.pattern.flags())});
        }

        public String toString() {
            return "Predicates.contains(" + i.a(this.pattern).a(XSDatatype.FACET_PATTERN, this.pattern.pattern()).a("pattern.flags", this.pattern.flags()).toString() + ")";
        }
    }

    private static class InPredicate<T> implements o<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        private InPredicate(Collection<?> r3) {
            this.target = (Collection) ZeusTransformUtils.preCheckCast(n.a((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ InPredicate(Collection r2, AnonymousClass1 r3) {
            this((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.base.o
        public boolean apply(T r1) {
            return this.target.contains(r1);
        L4:
            return false;
        }

        @Override // com.google.common.base.o
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, InPredicate.class) == false) goto L6;
            InPredicate r4 = (InPredicate) ZeusTransformUtils.preCheckCast(r3, InPredicate.class, "com.obric.memorydata.plugin");
            return this.target.equals(r4.target);
        L6:
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }
    }

    private static class InstanceOfPredicate<T> implements o<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        private InstanceOfPredicate(Class<?> r3) {
            this.clazz = (Class) ZeusTransformUtils.preCheckCast(n.a(r3), Class.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ InstanceOfPredicate(Class r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.base.o
        public boolean apply(T r1) {
            return ZeusTransformUtils.instanceOf(this.clazz, r1);
        }

        @Override // com.google.common.base.o
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, InstanceOfPredicate.class) == false) goto L8;
            InstanceOfPredicate r5 = (InstanceOfPredicate) ZeusTransformUtils.preCheckCast(r4, InstanceOfPredicate.class, "com.obric.memorydata.plugin");
            if (this.clazz != r5.clazz) goto L9;
            return true;
        L9:
            return false;
        L8:
            return false;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.clazz.getName() + ")";
        }
    }

    private static class IsEqualToPredicate implements o<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Object target;

        private IsEqualToPredicate(Object r1) {
            this.target = r1;
        }

        /* synthetic */ IsEqualToPredicate(Object r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.base.o
        public boolean apply(Object r1) {
            return this.target.equals(r1);
        }

        @Override // com.google.common.base.o
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, IsEqualToPredicate.class) == false) goto L6;
            IsEqualToPredicate r4 = (IsEqualToPredicate) ZeusTransformUtils.preCheckCast(r3, IsEqualToPredicate.class, "com.obric.memorydata.plugin");
            return this.target.equals(r4.target);
        L6:
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }

        <T> o<T> withNarrowedType() {
            return this;
        }
    }

    private static class NotPredicate<T> implements o<T>, Serializable {
        private static final long serialVersionUID = 0;
        final o<T> predicate;

        NotPredicate(o<T> r3) {
            this.predicate = (o) ZeusTransformUtils.preCheckCast(n.a((o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin")), o.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.o
        public boolean apply(T r1) {
            return !this.predicate.apply(r1);
        }

        @Override // com.google.common.base.o
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, NotPredicate.class) == false) goto L6;
            NotPredicate r4 = (NotPredicate) ZeusTransformUtils.preCheckCast(r3, NotPredicate.class, "com.obric.memorydata.plugin");
            return this.predicate.equals(r4.predicate);
        L6:
            return false;
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }
    }

    static abstract enum ObjectPredicate extends Enum<ObjectPredicate> implements o<Object> {
        private static final /* synthetic */ ObjectPredicate[] $VALUES = null;
        public static final ObjectPredicate ALWAYS_FALSE = null;
        public static final ObjectPredicate ALWAYS_TRUE = null;
        public static final ObjectPredicate IS_NULL = null;
        public static final ObjectPredicate NOT_NULL = null;

        private static /* synthetic */ ObjectPredicate[] $values() {
            return new ObjectPredicate[]{ALWAYS_TRUE, ALWAYS_FALSE, IS_NULL, NOT_NULL};
        }

        static {
            final String r1 = "ALWAYS_TRUE";
            final int r2 = 0;
            ALWAYS_TRUE = new AnonymousClass1(r1, r2);
            final String r3 = "ALWAYS_FALSE";
            final int r4 = 1;
            ALWAYS_FALSE = new AnonymousClass2(r3, r4);
            final String r5 = "IS_NULL";
            final int r6 = 2;
            IS_NULL = new AnonymousClass3(r5, r6);
            final String r7 = "NOT_NULL";
            final int r8 = 3;
            NOT_NULL = new AnonymousClass4(r7, r8);
            $VALUES = $values();
        }

        private ObjectPredicate(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ ObjectPredicate(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static ObjectPredicate valueOf(String r2) {
            return (ObjectPredicate) ZeusTransformUtils.preCheckCast(Enum.valueOf(ObjectPredicate.class, r2), ObjectPredicate.class, "com.obric.memorydata.plugin");
        }

        public static ObjectPredicate[] values() {
            return (ObjectPredicate[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ObjectPredicate[].class, "com.obric.memorydata.plugin");
        }

        <T> o<T> withNarrowedType() {
            return this;
        }
    }

    private static class OrPredicate<T> implements o<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends o<? super T>> components;

        private OrPredicate(List<? extends o<? super T>> r3) {
            this.components = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ OrPredicate(List r2, AnonymousClass1 r3) {
            this((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.base.o
        public boolean apply(T r6) {
            int r1 = 0;
        L4:
            if (r1 >= this.components.size()) goto L10;
            if (((o) ZeusTransformUtils.preCheckCast(this.components.get(r1), o.class, "com.obric.memorydata.plugin")).apply(r6) == true) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        @Override // com.google.common.base.o
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, OrPredicate.class) == false) goto L6;
            OrPredicate r4 = (OrPredicate) ZeusTransformUtils.preCheckCast(r3, OrPredicate.class, "com.obric.memorydata.plugin");
            return this.components.equals(r4.components);
        L6:
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        public String toString() {
            return Predicates.a("or", this.components);
        }
    }

    private static class SubtypeOfPredicate implements o<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        private SubtypeOfPredicate(Class<?> r3) {
            this.clazz = (Class) ZeusTransformUtils.preCheckCast(n.a(r3), Class.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ SubtypeOfPredicate(Class r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public boolean apply2(Class<?> r1) {
            return this.clazz.isAssignableFrom(r1);
        }

        @Override // com.google.common.base.o
        public /* synthetic */ boolean apply(Class<?> r3) {
            return apply2((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.base.o
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, SubtypeOfPredicate.class) == false) goto L8;
            SubtypeOfPredicate r5 = (SubtypeOfPredicate) ZeusTransformUtils.preCheckCast(r4, SubtypeOfPredicate.class, "com.obric.memorydata.plugin");
            if (this.clazz != r5.clazz) goto L9;
            return true;
        L9:
            return false;
        L8:
            return false;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.clazz.getName() + ")";
        }
    }

    public static <T> o<T> a() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <T> o<T> a(o<T> r2) {
        return new NotPredicate((o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.memorydata.plugin"));
    }

    public static <A, B> o<A> a(o<B> r2, g<A, ? extends B> r3) {
        return new CompositionPredicate((o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.memorydata.plugin"), (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"), null);
    }

    public static <T> o<T> a(o<? super T> r3, o<? super T> r4) {
        o r5 = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin");
        o r6 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
        return new AndPredicate(b((o) ZeusTransformUtils.preCheckCast(n.a(r5), o.class, "com.obric.memorydata.plugin"), (o) ZeusTransformUtils.preCheckCast(n.a(r6), o.class, "com.obric.memorydata.plugin")), null);
    }

    public static <T> o<T> a(Class<?> r2) {
        return new InstanceOfPredicate(r2, null);
    }

    public static <T> o<T> a(T r2) {
        if (r2 != null) goto L5;
        return b();
    L5:
        return new IsEqualToPredicate(r2, null).withNarrowedType();
    }

    public static <T> o<T> a(Collection<? extends T> r2) {
        return new InPredicate((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"), null);
    }

    static /* synthetic */ String a(String r2, Iterable r3) {
        return b(r2, (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static <T> o<T> b() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    private static String b(String r2, Iterable<?> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        StringBuilder r5 = new StringBuilder("Predicates.").append(r2).append('(');
        Iterator r6 = r4.iterator();
        boolean r0 = true;
    L4:
        if (r6.hasNext() == false) goto L10;
        Object r1 = r6.next();
        if (r0 == true) goto L8;
        r5.append(',');
    L8:
        r5.append(r1);
        r0 = false;
        goto L4
    L10:
        return r5.append(')').toString();
    }

    private static <T> List<o<? super T>> b(o<? super T> r2, o<? super T> r3) {
        return Arrays.asList(new o[]{(o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.memorydata.plugin"), (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin")});
    }
}
