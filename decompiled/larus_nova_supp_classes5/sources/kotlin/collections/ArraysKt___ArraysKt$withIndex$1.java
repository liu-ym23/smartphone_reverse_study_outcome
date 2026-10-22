package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ArraysKt___ArraysKt$withIndex$1<T> extends Lambda implements Function0<Iterator<? extends T>> {
    final /* synthetic */ T[] $this_withIndex;

    public ArraysKt___ArraysKt$withIndex$1(T[] r1) {
        this.$this_withIndex = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Iterator<T> m356invoke() {
        return ArrayIteratorKt.iterator(this.$this_withIndex);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m356invoke();
    }
}
