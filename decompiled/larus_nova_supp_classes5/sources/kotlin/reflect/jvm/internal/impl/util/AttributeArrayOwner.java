package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AttributeArrayOwner<K, T> extends AbstractArrayMapOwner<K, T> {
    private ArrayMap<T> arrayMap;

    public AttributeArrayOwner() {
        EmptyArrayMap r0 = EmptyArrayMap.INSTANCE;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public final ArrayMap<T> getArrayMap() {
        return this.arrayMap;
    }

    public AttributeArrayOwner(ArrayMap<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "arrayMap");
        this.arrayMap = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public final void registerComponent(String r4, T r5) {
        Intrinsics.checkNotNullParameter(r4, "keyQualifiedName");
        Intrinsics.checkNotNullParameter(r5, "value");
        int r6 = getTypeRegistry().getId(r4);
        int r0 = this.arrayMap.getSize();
        if (r0 != 0) goto L5;
        this.arrayMap = new OneElementArrayMap(r5, r6);
        return;
    L5:
        if (r0 != 1) goto L12;
        OneElementArrayMap r1 = this.arrayMap;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        OneElementArrayMap r2 = r1;
        if (r2.getIndex() != r6) goto L11;
        this.arrayMap = new OneElementArrayMap(r5, r6);
        return;
    L11:
        EmptyArrayMap r3 = (ArrayMap<T>) new ArrayMapImpl();
        this.arrayMap = r3;
        r3.set(r2.getIndex(), r2.getValue());
    L12:
        this.arrayMap.set(r6, r5);
    }
}
