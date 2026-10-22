package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AttributeArrayOwner<K, T> extends AbstractArrayMapOwner<K, T> {
    private ArrayMap<T> arrayMap;

    public AttributeArrayOwner(ArrayMap<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "arrayMap");
        this.arrayMap = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public final ArrayMap<T> getArrayMap() {
        return this.arrayMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public final void registerComponent(KClass<? extends K> r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "tClass");
        Intrinsics.checkNotNullParameter(r10, "value");
        int r11 = getTypeRegistry().getId(r5);
        int r12 = this.arrayMap.getSize();
        if (r12 != 0) goto L5;
        this.arrayMap = new OneElementArrayMap(r10, r11);
        return;
    L5:
        if (r12 != 1) goto L12;
        ArrayMap<T> r13 = this.arrayMap;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        OneElementArrayMap r14 = (OneElementArrayMap) r13;
        if (r14.getIndex() != r11) goto L11;
        this.arrayMap = new OneElementArrayMap(r10, r11);
        return;
    L11:
        ArrayMapImpl r15 = new ArrayMapImpl();
        this.arrayMap = r15;
        r15.set(r14.getIndex(), r14.getValue());
    L12:
        this.arrayMap.set(r11, r10);
    }

    public AttributeArrayOwner() {
        EmptyArrayMap r5 = EmptyArrayMap.INSTANCE;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(r5);
    }
}
