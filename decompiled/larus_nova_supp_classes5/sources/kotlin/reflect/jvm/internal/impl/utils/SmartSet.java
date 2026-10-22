package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.AbstractMutableSet;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class SmartSet<T> extends AbstractMutableSet<T> {
    public static final Companion Companion = null;
    private Object data;
    private int size;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final <T> SmartSet<T> create() {
            return new SmartSet(null);
        }

        @JvmStatic
        public final <T> SmartSet<T> create(Collection<? extends T> r3) {
            Intrinsics.checkNotNullParameter(r3, "set");
            SmartSet<T> r0 = new SmartSet(null);
            r0.addAll(r3);
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ SmartSet(DefaultConstructorMarker r1) {
        this();
    }

    @JvmStatic
    public static final <T> SmartSet<T> create() {
        return Companion.create();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.data = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() != 0) goto L6;
        return Collections.emptySet().iterator();
    L6:
        if (size() != 1) goto L9;
        return new SingletonIterator(this.data);
    L9:
        if (size() >= 5) goto L11;
        Object r1 = this.data;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        return new ArrayIterator((Object[]) r1);
    L11:
        Object r0 = this.data;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return TypeIntrinsics.asMutableSet(r0).iterator();
    }

    private SmartSet() {
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T r5) {
        if (size() != 0) goto L6;
        this.data = r5;
    L24:
        setSize(size() + 1);
        return true;
    L6:
        if (size() != 1) goto L12;
        if (Intrinsics.areEqual(this.data, r5) == false) goto L10;
        return false;
    L10:
        this.data = new Object[]{this.data, r5};
        goto L24
    L12:
        if (size() >= 5) goto L21;
        Object r0 = this.data;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        Object[] r1 = (Object[]) r0;
        if (ArraysKt.contains(r1, r5) == false) goto L17;
        return false;
    L17:
        if (size() != 4) goto L19;
        LinkedHashSet r2 = SetsKt.linkedSetOf(Arrays.copyOf(r1, r1.length));
        r2.add(r5);
        Object r3 = r2;
    L20:
        this.data = r3;
        goto L24
    L19:
        Object[] r4 = Arrays.copyOf(r1, size() + 1);
        r4[r4.length - 1] = r5;
        r3 = r4;
        goto L20
    L21:
        Object r6 = this.data;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        if (TypeIntrinsics.asMutableSet(r6).add(r5) == true) goto L24;
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r3) {
        if (size() != 0) goto L6;
        return false;
    L6:
        if (size() != 1) goto L9;
        return Intrinsics.areEqual(this.data, r3);
    L9:
        if (size() >= 5) goto L11;
        Object r0 = this.data;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ArraysKt.contains((Object[]) r0, r3);
    L11:
        Object r1 = this.data;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) r1).contains(r3);
    }

    public void setSize(int r1) {
        this.size = r1;
    }
}
