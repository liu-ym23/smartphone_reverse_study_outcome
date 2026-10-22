package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nArrayMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayMap.kt\norg/jetbrains/kotlin/util/ArrayMapImpl\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,142:1\n11515#2,11:143\n13644#2,2:154\n13646#2:157\n11526#2:158\n1#3:156\n*S KotlinDebug\n*F\n+ 1 ArrayMap.kt\norg/jetbrains/kotlin/util/ArrayMapImpl\n*L\n137#1:143,11\n137#1:154,2\n137#1:157\n137#1:158\n137#1:156\n*E\n"})
public final class ArrayMapImpl<T> extends ArrayMap<T> {
    public static final Companion Companion = null;
    private Object[] data;
    private int size;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    private ArrayMapImpl(Object[] r5, int r10) {
        super(null);
        this.data = r5;
        this.size = r10;
    }

    public static final /* synthetic */ Object[] access$getData$p(ArrayMapImpl r5) {
        return r5.data;
    }

    private final void ensureCapacity(int r5) {
        Object[] r10 = this.data;
        if (r10.length > r5) goto L6;
        this.data = Arrays.copyOf(r10, r10.length * 2);
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public T get(int r5) {
        return (T) ArraysKt.getOrNull(this.data, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int r5, T r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        ensureCapacity(r5);
        if (this.data[r5] != null) goto L5;
        this.size = getSize() + 1;
    L5:
        this.data[r5] = r10;
    }

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }
}
