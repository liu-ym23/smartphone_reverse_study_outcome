package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CombinedContext implements Serializable, CoroutineContext {
    private final CoroutineContext.Element element;
    private final CoroutineContext left;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Serialized implements Serializable {
        public static final Companion Companion = null;
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] elements;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Serialized(CoroutineContext[] r2) {
            Intrinsics.checkNotNullParameter(r2, "elements");
            this.elements = r2;
        }

        private final Object readResolve() {
            CoroutineContext[] r6 = this.elements;
            CoroutineContext r0 = EmptyCoroutineContext.INSTANCE;
            int r1 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            CoroutineContext r3 = r6[r2];
            r0 = ((CoroutineContext) ZeusTransformUtils.preCheckCast(r0, CoroutineContext.class, "com.obric.memorydata.plugin")).plus(r3);
            r2 = r2 + 1;
            goto L3
        L5:
            return r0;
        }

        public final CoroutineContext[] getElements() {
            return this.elements;
        }
    }

    public CombinedContext(CoroutineContext r3, CoroutineContext.Element r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        CoroutineContext.Element r6 = (CoroutineContext.Element) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "left");
        Intrinsics.checkNotNullParameter(r6, "element");
        this.left = r5;
        this.element = r6;
    }

    private final boolean contains(CoroutineContext.Element r3) {
        CoroutineContext.Element r4 = (CoroutineContext.Element) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        return Intrinsics.areEqual(get(r4.getKey()), r4);
    }

    private final boolean containsAll(CombinedContext r4) {
    L4:
        if (contains(r4.element) == false) goto L5;
        CoroutineContext r5 = r4.left;
        if (ZeusTransformUtils.instanceOf(r5, CombinedContext.class) == false) goto L10;
        r4 = (CombinedContext) ZeusTransformUtils.preCheckCast(r5, CombinedContext.class, "com.obric.memorydata.plugin");
        goto L4
    L10:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        return contains((CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r5, CoroutineContext.Element.class, "com.obric.memorydata.plugin"));
    L5:
        return false;
    }

    private final int size() {
        int r1 = 2;
    L3:
        CoroutineContext r3 = this.left;
        if (ZeusTransformUtils.instanceOf(r3, CombinedContext.class) == false) goto L6;
        CombinedContext this = (CombinedContext) ZeusTransformUtils.preCheckCast(r3, CombinedContext.class, "com.obric.memorydata.plugin");
    L7:
        if (this == null) goto L8;
        r1 = r1 + 1;
        goto L3
    L8:
        return r1;
    L6:
        this = null;
        goto L7
    }

    private final Object writeReplace() {
        int r0 = size();
        final CoroutineContext[] r1 = new CoroutineContext[r0];
        final Ref.IntRef r2 = new Ref.IntRef();
        fold(Unit.INSTANCE, (Function2) ZeusTransformUtils.preCheckCast(new C12511(r1, r2), Function2.class, "com.obric.memorydata.plugin"));
        if (r2.element != r0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L10;
        return new Serialized(r1);
    L10:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r7 = false;
        goto L6
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
    L12:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, CombinedContext.class) == true) goto L7;
    L11:
        return false;
    L7:
        if (((CombinedContext) ZeusTransformUtils.preCheckCast(r5, CombinedContext.class, "com.obric.memorydata.plugin")).size() != size()) goto L11;
        if (((CombinedContext) ZeusTransformUtils.preCheckCast(r5, CombinedContext.class, "com.obric.memorydata.plugin")).containsAll(this) == false) goto L11;
        goto L11
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r3, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r4) {
        Function2<? super R, ? super CoroutineContext.Element, ? extends R> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "operation");
        return r5.invoke((Object) this.left.fold(r3, r5), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r4) {
        CoroutineContext.Key<E> r5 = (CoroutineContext.Key) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.Key.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "key");
    L3:
        E r1 = (E) this.element.get(r5);
        if (r1 != null) goto L5;
        CoroutineContext r3 = this.left;
        if (ZeusTransformUtils.instanceOf(r3, CombinedContext.class) == false) goto L10;
        CombinedContext this = (CombinedContext) ZeusTransformUtils.preCheckCast(r3, CombinedContext.class, "com.obric.memorydata.plugin");
        goto L3
    L10:
        return (E) r3.get(r5);
    L5:
        return r1;
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r3) {
        CoroutineContext.Key<?> r4 = (CoroutineContext.Key) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.Key.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "key");
        if (this.element.get(r4) != null) goto L5;
        CoroutineContext r5 = this.left.minusKey(r4);
        CoroutineContext r0 = this.left;
        Object r2 = this;
        if (r5 != r0) goto L11;
    L8:
        Object r6 = ZeusTransformUtils.preCheckCast(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
    L14:
        return (CoroutineContext) r6;
    L11:
        if (r5 != EmptyCoroutineContext.INSTANCE) goto L13;
        r2 = this.element;
        goto L8
    L13:
        r6 = ZeusTransformUtils.preCheckCast(new CombinedContext(r5, this.element), CoroutineContext.class, "com.obric.memorydata.plugin");
        goto L14
    L5:
        return this.left;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r3) {
        return CoroutineContext.DefaultImpls.plus(this, (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public String toString() {
        return '[' + ((String) ZeusTransformUtils.preCheckCast(fold("", (Function2) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function2.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin")) + ']';
    }
}
