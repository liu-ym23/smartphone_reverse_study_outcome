package com.tencent.wcdb.orm;

import com.tencent.wcdb.core.PreparedStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface TableBinding<T> {
    Field<T>[] allBindingFields();

    Binding baseBinding();

    void bindField(T r1, Field<T> r2, int r3, PreparedStatement r4);

    Class<T> bindingType();

    <R extends T> R extractObject(Field<T>[] r1, PreparedStatement r2, Class<R> r3) throws ReflectiveOperationException;

    boolean isAutoIncrement(T r1);

    void setLastInsertRowId(T r1, long r2);
}
