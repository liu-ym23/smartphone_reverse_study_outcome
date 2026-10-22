package org.msgpack.value;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface ArrayValue extends Iterable<Value>, Value {
    Value get(int r1);

    Value getOrNilValue(int r1);

    @Override // java.lang.Iterable
    Iterator<Value> iterator();

    List<Value> list();

    int size();
}
