package kotlin.reflect.jvm.internal.impl.util;

import com.bytedance.crash.entity.EventBody;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ArrayMapImpl<T> extends ArrayMap<T> {
    public static final Companion Companion = null;
    private Object[] data;
    private int size;

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

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }

    private ArrayMapImpl(Object[] r10, int r11) {
        super(null);
        this.data = r10;
        this.size = r11;
    }

    public static final /* synthetic */ Object[] access$getData$p(ArrayMapImpl r10) {
        return r10.data;
    }

    private final void ensureCapacity(int r10) {
        Object[] r11 = this.data;
        if (r11.length > r10) goto L6;
        Object[] r12 = Arrays.copyOf(r11, r11.length * 2);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        this.data = r12;
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public T get(int r10) {
        return (T) ArraysKt.getOrNull(this.data, r10);
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
    public void set(int r10, T r11) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        ensureCapacity(r10);
        if (this.data[r10] != null) goto L5;
        this.size = getSize() + 1;
    L5:
        this.data[r10] = r11;
    }
}
