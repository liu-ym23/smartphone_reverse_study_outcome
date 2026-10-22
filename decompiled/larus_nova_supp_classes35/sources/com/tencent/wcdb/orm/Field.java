package com.tencent.wcdb.orm;

import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.winq.Column;
import com.tencent.wcdb.winq.Schema;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Field<T> extends Column {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected TableBinding<T> binding;
    private int fieldId;
    private boolean isAutoIncrement;
    private boolean isPrimaryKey;
    private String name;

    public Field<T> copySelf() {
        Field<T> r0 = new Field();
        ((CppObject) r0).cppObj = copy(((CppObject) this).cppObj);
        r0.name = this.name;
        r0.fieldId = this.fieldId;
        r0.isAutoIncrement = this.isAutoIncrement;
        r0.isPrimaryKey = this.isPrimaryKey;
        r0.binding = this.binding;
        return r0;
    }

    public Field() {
        this.binding = null;
        this.fieldId = 0;
        this.isAutoIncrement = false;
        this.isPrimaryKey = false;
    }

    static {
    }

    public int getFieldId() {
        return this.fieldId;
    }

    public String getName() {
        return this.name;
    }

    public TableBinding<T> getTableBinding() {
        return this.binding;
    }

    public boolean isAutoIncrement() {
        return this.isAutoIncrement;
    }

    public boolean isPrimaryKey() {
        return this.isPrimaryKey;
    }

    @SafeVarargs
    public static <T> Class<T> getBindClass(Field<T>... r1) {
        return r1[0].binding.bindingType();
    }

    @SafeVarargs
    public static <T> TableBinding<T> getBinding(Field<T>... r1) {
        return getBinding(r1[0]);
    }

    public Field<T> of(Schema r2) {
        Field<T> r0 = copySelf();
        r0.ofSchema(r2);
        return r0;
    }

    public Field<T> table(String r4) {
        Field<T> r0 = copySelf();
        r0.inTable(((CppObject) r0).cppObj, r4);
        return r0;
    }

    public static <T> TableBinding<T> getBinding(Field<T> r0) {
        return r0.getTableBinding();
    }

    public Field<T> of(String r2) {
        Field<T> r0 = copySelf();
        r0.ofSchema(r2);
        return r0;
    }

    /* JADX INFO: renamed from: table, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Column m1245table(String r1) {
        return table(r1);
    }

    /* JADX INFO: renamed from: of, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Column m1243of(Schema r1) {
        return of(r1);
    }

    /* JADX INFO: renamed from: of, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Column m1244of(String r1) {
        return of(r1);
    }

    public Field(String r3, TableBinding<T> r4, int r5, boolean r6, boolean r7) {
        super(r3, r4.baseBinding().getBaseBinding());
        this.name = r3;
        this.binding = r4;
        this.fieldId = r5;
        this.isAutoIncrement = r6;
        this.isPrimaryKey = r7;
    }
}
