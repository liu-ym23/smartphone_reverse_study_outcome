package org.msgpack.value;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ArrayValue extends Value, Iterable<Value> {
    Value get(int r10);

    Value getOrNilValue(int r10);

    @Override // java.lang.Iterable
    Iterator<Value> iterator();

    List<Value> list();

    int size();
}
