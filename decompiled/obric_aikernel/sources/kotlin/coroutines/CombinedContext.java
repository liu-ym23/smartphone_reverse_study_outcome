package kotlin.coroutines;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
@SourceDebugExtension({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n1#2:197\n*E\n"})
public final class CombinedContext implements CoroutineContext, Serializable {
    private final CoroutineContext.Element element;
    private final CoroutineContext left;

    @SourceDebugExtension({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,196:1\n12720#2,3:197\n*S KotlinDebug\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n*L\n193#1:197,3\n*E\n"})
    private static final class Serialized implements Serializable {
        public static final Companion Companion = null;
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] elements;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Serialized(CoroutineContext[] r10) {
            Intrinsics.checkNotNullParameter(r10, "elements");
            this.elements = r10;
        }

        private final Object readResolve() {
            CoroutineContext[] r10 = this.elements;
            CoroutineContext r11 = EmptyCoroutineContext.INSTANCE;
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r11 = r11.plus(r10[r13]);
            r13 = r13 + 1;
            goto L3
        L5:
            return r11;
        }

        public final CoroutineContext[] getElements() {
            return this.elements;
        }
    }

    public CombinedContext(CoroutineContext r10, CoroutineContext.Element r11) {
        Intrinsics.checkNotNullParameter(r10, "left");
        Intrinsics.checkNotNullParameter(r11, "element");
        this.left = r10;
        this.element = r11;
    }

    private final boolean contains(CoroutineContext.Element r10) {
        return Intrinsics.areEqual(get(r10.getKey()), r10);
    }

    private final boolean containsAll(CombinedContext r10) {
    L3:
        if (contains(r10.element) == false) goto L4;
        CoroutineContext r11 = r10.left;
        if ((r11 instanceof CombinedContext) == false) goto L9;
        r10 = (CombinedContext) r11;
        goto L3
    L9:
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        return contains((CoroutineContext.Element) r11);
    L4:
        return false;
    }

    private final int size() {
        int r10 = 2;
    L3:
        CoroutineContext r11 = this.left;
        if ((r11 instanceof CombinedContext) == false) goto L6;
        CombinedContext this = (CombinedContext) r11;
    L7:
        if (this == null) goto L8;
        r10 = r10 + 1;
        goto L3
    L8:
        return r10;
    L6:
        this = null;
        goto L7
    }

    private final Object writeReplace() {
        int r10 = size();
        final CoroutineContext[] r11 = new CoroutineContext[r10];
        final Ref.IntRef r12 = new Ref.IntRef();
        fold(Unit.INSTANCE, new C04061(r11, r12));
        if (r12.element != r10) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L10;
        return new Serialized(r11);
    L10:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r13 = false;
        goto L6
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
    L11:
        return true;
    L4:
        if ((r10 instanceof CombinedContext) == false) goto L10;
        CombinedContext r11 = (CombinedContext) r10;
        if (r11.size() != size()) goto L10;
        if (r11.containsAll(this) == true) goto L11;
    L10:
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "operation");
        return r11.invoke((Object) this.left.fold(r10, r11), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
    L3:
        E r11 = (E) this.element.get(r10);
        if (r11 != null) goto L5;
        CoroutineContext r12 = this.left;
        if ((r12 instanceof CombinedContext) == false) goto L10;
        CombinedContext this = (CombinedContext) r12;
        goto L3
    L10:
        return (E) r12.get(r10);
    L5:
        return r11;
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (this.element.get(r10) != null) goto L5;
        CoroutineContext r11 = this.left.minusKey(r10);
        if (r11 != this.left) goto L10;
        return this;
    L10:
        if (r11 != EmptyCoroutineContext.INSTANCE) goto L13;
        return this.element;
    L13:
        return new CombinedContext(r11, this.element);
    L5:
        return this.left;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r10) {
        return CoroutineContext.DefaultImpls.plus(this, r10);
    }

    public String toString() {
        return '[' + ((String) fold("", AnonymousClass1.INSTANCE)) + ']';
    }
}
