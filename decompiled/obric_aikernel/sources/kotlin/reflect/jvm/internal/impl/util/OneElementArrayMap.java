package kotlin.reflect.jvm.internal.impl.util;

import com.bytedance.crash.entity.EventBody;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class OneElementArrayMap<T> extends ArrayMap<T> {
    private final int index;
    private final T value;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.util.OneElementArrayMap$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private boolean notVisited;
        final /* synthetic */ OneElementArrayMap<T> this$0;

        AnonymousClass1(OneElementArrayMap<T> r10) {
            this.this$0 = r10;
            this.notVisited = true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.notVisited;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.notVisited == false) goto L7;
            this.notVisited = false;
            return this.this$0.getValue();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public OneElementArrayMap(T r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        super(null);
        this.value = r10;
        this.index = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public T get(int r10) {
        if (r10 == this.index) goto L7;
        return null;
    L7:
        return this.value;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return 1;
    }

    public final T getValue() {
        return this.value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int r10, T r11) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        throw new IllegalStateException();
    }
}
