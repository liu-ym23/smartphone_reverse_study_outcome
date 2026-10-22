package com.tencent.wcdb.core;

import com.tencent.wcdb.orm.TableBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Table<T> extends TableORMOperation<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    public Table(String r1, TableBinding<T> r2, Database r3) {
        this.tableName = r1;
        this.binding = r2;
        this.database = r3;
    }
}
