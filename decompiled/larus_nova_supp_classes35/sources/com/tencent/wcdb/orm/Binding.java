package com.tencent.wcdb.orm;

import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.core.Handle;
import com.tencent.wcdb.winq.ColumnDef;
import com.tencent.wcdb.winq.StatementCreateIndex;
import com.tencent.wcdb.winq.TableConstraint;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Binding extends CppObject {
    private long baseBinding;

    private static native void addColumnDef(long r0, long r2);

    private static native void addIndex(long r0, String r2, boolean r3, long r4);

    private static native void addTableConstraint(long r0, long r2);

    private static native void configVirtualModule(long r0, String r2);

    private static native void configVirtualModuleArgument(long r0, String r2);

    private static native void configWithoutRowId(long r0);

    private static native long createCppObj();

    private static native boolean createTable(long r0, String r2, long r3);

    private static native boolean createVirtualTable(long r0, String r2, long r3);

    private static native void enableAutoIncrementForExistingTable(long r0);

    private static native long getBaseBinding(long r0);

    public void configWithoutRowId() {
        configWithoutRowId(((CppObject) this).cppObj);
    }

    public void enableAutoIncrementForExistingTable() {
        enableAutoIncrementForExistingTable(((CppObject) this).cppObj);
    }

    public long getBaseBinding() {
        if (this.baseBinding != 0) goto L6;
        this.baseBinding = getBaseBinding(((CppObject) this).cppObj);
    L6:
        return this.baseBinding;
    }

    public Binding() {
        this.baseBinding = 0;
        ((CppObject) this).cppObj = createCppObj();
    }

    public void addColumnDef(ColumnDef r5) {
        addColumnDef(((CppObject) this).cppObj, CppObject.get(r5));
    }

    public void addTableConstraint(TableConstraint r5) {
        addTableConstraint(((CppObject) this).cppObj, CppObject.get(r5));
    }

    public Binding configVirtualModule(String r3) {
        configVirtualModule(((CppObject) this).cppObj, r3);
        return this;
    }

    public void configVirtualModuleArgument(String r3) {
        configVirtualModuleArgument(((CppObject) this).cppObj, r3);
    }

    public boolean createTable(String r5, Handle r6) throws WCDBException {
        return createTable(((CppObject) this).cppObj, r5, r6.getCppHandle());
    }

    public boolean createVirtualTable(String r5, Handle r6) throws WCDBException {
        return createVirtualTable(((CppObject) this).cppObj, r5, r6.getCppHandle());
    }

    public void addIndex(String r7, boolean r8, StatementCreateIndex r9) {
        addIndex(((CppObject) this).cppObj, r7, r8, CppObject.get(r9));
    }
}
