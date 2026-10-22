package kotlin.collections;

import java.util.Iterator;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.1")
public interface Grouping<T, K> {
    K keyOf(T r10);

    Iterator<T> sourceIterator();
}
