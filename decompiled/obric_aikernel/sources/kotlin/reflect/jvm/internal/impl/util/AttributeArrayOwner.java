package kotlin.reflect.jvm.internal.impl.util;

import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AttributeArrayOwner<K, T> extends AbstractArrayMapOwner<K, T> {
    private ArrayMap<T> arrayMap;

    public AttributeArrayOwner() {
        EmptyArrayMap r10 = EmptyArrayMap.INSTANCE;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(r10);
    }

    protected AttributeArrayOwner(ArrayMap<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "arrayMap");
        this.arrayMap = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    protected final ArrayMap<T> getArrayMap() {
        return this.arrayMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    protected final void registerComponent(KClass<? extends K> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "tClass");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        int r12 = getTypeRegistry().getId(r10);
        int r13 = this.arrayMap.getSize();
        if (r13 != 0) goto L5;
        this.arrayMap = new OneElementArrayMap(r11, r12);
        return;
    L5:
        if (r13 != 1) goto L12;
        ArrayMap<T> r14 = this.arrayMap;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        OneElementArrayMap r15 = (OneElementArrayMap) r14;
        if (r15.getIndex() != r12) goto L11;
        this.arrayMap = new OneElementArrayMap(r11, r12);
        return;
    L11:
        ArrayMapImpl r16 = new ArrayMapImpl();
        this.arrayMap = r16;
        r16.set(r15.getIndex(), r15.getValue());
    L12:
        this.arrayMap.set(r12, r11);
    }
}
