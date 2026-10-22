package com.tencent.wcdb.core;

import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.winq.Statement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Handle extends HandleORMOperation implements AutoCloseable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Database database;
    private PreparedStatement mainStatement;
    private boolean writeHint;

    public static class CancellationSignal extends CppObject {
        public void cancel() {
            Handle.access$100(((CppObject) this).cppObj);
        }

        public CancellationSignal() {
            ((CppObject) this).cppObj = Handle.access$000();
        }
    }

    private static native void attachCancellationSignal(long r0, long r2);

    public static native boolean beginTransaction(long r0);

    private static native void cancelSignal(long r0);

    public static native boolean commitTransaction(long r0);

    private static native long createCancellationSignal();

    private static native void detachCancellationSignal(long r0);

    public static native boolean execute(long r0, long r2);

    public static native boolean executeSQL(long r0, String r2);

    public static native void finalizeAllStatements(long r0);

    public static native int getChanges(long r0);

    public static native long getError(long r0);

    public static native long getLastInsertedRowId(long r0);

    public static native long getMainStatement(long r0);

    public static native long getOrCreatePreparedStatement(long r0, long r2);

    public static native long getOrCreatePreparedStatementWithSQL(long r0, String r2);

    public static native int getTotalChanges(long r0);

    public static native boolean isInTransaction(long r0);

    public static native void rollbackTransaction(long r0);

    public static native int tableExist(long r0, String r2);

    @Override // com.tencent.wcdb.core.HandleOperation
    public boolean autoInvalidateHandle() {
        return false;
    }

    @Override // com.tencent.wcdb.core.HandleOperation
    public Handle getHandle(boolean r1) {
        return this;
    }

    public void invalidate() {
        this.mainStatement = null;
        long r0 = ((CppObject) this).cppObj;
        if (r0 == 0) goto L6;
        ((CppObject) this).cppObj = 0;
        CppObject.releaseCPPObject(r0);
        this.writeHint = false;
        return;
    }

    public native boolean runPausableTransaction(long r1, PausableTransaction r3);

    public native boolean runTransaction(long r1, Transaction r3);

    public WCDBException createException() {
        return WCDBException.createException(getError(((CppObject) this).cppObj));
    }

    public void detachCancellationSignal() {
        long r0 = ((CppObject) this).cppObj;
        if (r0 == 0) goto L6;
        detachCancellationSignal(r0);
        return;
    }

    public void finalizeAllStatements() {
        long r0 = ((CppObject) this).cppObj;
        if (r0 <= 0) goto L6;
        finalizeAllStatements(r0);
        return;
    }

    public long getCppHandle() throws WCDBException {
        if (((CppObject) this).cppObj != 0) goto L10;
        long r0 = Database.getHandle(CppObject.get(this.database), this.writeHint);
        ((CppObject) this).cppObj = r0;
        if (r0 != 0) goto L10;
        throw this.database.createException();
    L10:
        return ((CppObject) this).cppObj;
    }

    public static /* synthetic */ long access$000() {
        return createCancellationSignal();
    }

    public int getChanges() throws WCDBException {
        return getChanges(getCppHandle());
    }

    public long getLastInsertedRowId() throws WCDBException {
        return getLastInsertedRowId(getCppHandle());
    }

    public int getTotalChanges() throws WCDBException {
        return getTotalChanges(getCppHandle());
    }

    static {
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        invalidate();
    }

    @Override // com.tencent.wcdb.core.HandleORMOperation
    public Database getDatabase() {
        return this.database;
    }

    public static /* synthetic */ void access$100(long r0) {
        cancelSignal(r0);
    }

    public void attachCancellationSignal(CancellationSignal r5) throws WCDBException {
        attachCancellationSignal(getCppHandle(), CppObject.get(r5));
    }

    public PreparedStatement getOrCreatePreparedStatement(Statement r5) throws WCDBException {
        long r0 = getOrCreatePreparedStatement(getCppHandle(), CppObject.get(r5));
        if (r0 == 0) goto L7;
        return new PreparedStatement(r0);
    L7:
        throw createException();
    }

    public PreparedStatement preparedWithMainStatement(Statement r4) throws WCDBException {
        if (this.mainStatement != null) goto L5;
        PreparedStatement r0 = new PreparedStatement(getMainStatement(getCppHandle()));
        this.mainStatement = r0;
        r0.autoFinalize = true;
    L5:
        this.mainStatement.prepare(r4);
        return this.mainStatement;
    }

    public PreparedStatement getOrCreatePreparedStatement(String r5) throws WCDBException {
        long r0 = getOrCreatePreparedStatementWithSQL(getCppHandle(), r5);
        if (r0 == 0) goto L7;
        return new PreparedStatement(r0);
    L7:
        throw createException();
    }

    public PreparedStatement preparedWithMainStatement(String r4) throws WCDBException {
        if (this.mainStatement != null) goto L5;
        PreparedStatement r0 = new PreparedStatement(getMainStatement(getCppHandle()));
        this.mainStatement = r0;
        r0.autoFinalize = true;
    L5:
        this.mainStatement.prepare(r4);
        return this.mainStatement;
    }

    public Handle(long r2, Database r4) {
        this.mainStatement = null;
        this.writeHint = false;
        ((CppObject) this).cppObj = r2;
        this.database = r4;
    }

    private boolean onTransaction(long r3, Transaction r5) {
        return r5.insideTransaction(new Handle(r3, this.database));
    L5:
        return false;
    }

    public Handle(Database r2, boolean r3) {
        this.mainStatement = null;
        this.database = r2;
        this.writeHint = r3;
    }

    private int onPausableTransaction(long r3, PausableTransaction r5, boolean r6) {
        return r5.insideTransaction(new Handle(r3, this.database), r6) ? 1 : 0;
    L5:
        return 2;
    }
}
