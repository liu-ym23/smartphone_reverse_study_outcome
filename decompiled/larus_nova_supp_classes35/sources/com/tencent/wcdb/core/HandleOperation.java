package com.tencent.wcdb.core;

import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.Value;
import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.winq.Column;
import com.tencent.wcdb.winq.ConflictAction;
import com.tencent.wcdb.winq.Expression;
import com.tencent.wcdb.winq.OrderingTerm;
import com.tencent.wcdb.winq.ResultColumnConvertible;
import com.tencent.wcdb.winq.Statement;
import com.tencent.wcdb.winq.StatementDelete;
import com.tencent.wcdb.winq.StatementInsert;
import com.tencent.wcdb.winq.StatementSelect;
import com.tencent.wcdb.winq.StatementUpdate;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class HandleOperation extends CppObject {
    public abstract boolean autoInvalidateHandle();

    public void beginTransaction() throws WCDBException {
        Handle r0 = getHandle(true);
    L14:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L4:
        if (Handle.beginTransaction(r0.getCppHandle()) == true) goto L7;
        WCDBException r1 = r0.createException();     // Catch: Throwable -> L14
    L9:
        if (autoInvalidateHandle() == false) goto L11;
        r0.invalidate();
    L11:
        if (r1 != null) goto L13;
        return;
    L13:
        throw r1;
    L7:
        r1 = null;
        goto L9
    }

    public void commitTransaction() throws WCDBException {
        Handle r0 = getHandle(true);
    L14:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L4:
        if (Handle.commitTransaction(r0.getCppHandle()) == true) goto L7;
        WCDBException r1 = r0.createException();     // Catch: Throwable -> L14
    L9:
        if (autoInvalidateHandle() == false) goto L11;
        r0.invalidate();
    L11:
        if (r1 != null) goto L13;
        return;
    L13:
        throw r1;
    L7:
        r1 = null;
        goto L9
    }

    public abstract Handle getHandle(boolean r1);

    public boolean isInTransaction() throws WCDBException {
        Handle r0 = getHandle(false);     // Catch: Throwable -> L11
        boolean r1 = Handle.isInTransaction(r0.getCppHandle());     // Catch: Throwable -> L9
        if (autoInvalidateHandle() == false) goto L8;
        r0.invalidate();
    L8:
        return r1;
    L9:
        th = th;
    L13:
        if (r0 != null) goto L15;
    L17:
        throw th;
    L15:
        if (autoInvalidateHandle() == false) goto L17;
        r0.invalidate();
    L11:
        th = th;
        r0 = null;
        goto L13
    }

    public void rollbackTransaction() throws WCDBException {
        Handle r0 = getHandle(true);
        Handle.rollbackTransaction(r0.getCppHandle());     // Catch: Throwable -> L8
        if (autoInvalidateHandle() == false) goto L16;
        r0.invalidate();
        return;
    L16:
        return;
    L8:
        th = move-exception;
        if (r0 != null) goto L11;
    L13:
        throw th;
    L11:
        if (autoInvalidateHandle() == false) goto L13;
        r0.invalidate();
        goto L13
    }

    public HandleOperation() {
    }

    private void deleteValue(StatementDelete r3) throws WCDBException {
        Handle r0 = getHandle(true);
        r0.execute(r3);     // Catch: Throwable -> L8
        if (autoInvalidateHandle() == false) goto L15;
        r0.invalidate();
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L12;
        r0.invalidate();
    L12:
        throw th;
    }

    public void execute(Statement r6) throws WCDBException {
        Handle r0 = getHandle(r6.isWriteStatement());
    L14:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L4:
        if (Handle.execute(r0.getCppHandle(), CppObject.get(r6)) == true) goto L7;
        WCDBException r7 = r0.createException();     // Catch: Throwable -> L14
    L9:
        if (autoInvalidateHandle() == false) goto L11;
        r0.invalidate();
    L11:
        if (r7 != null) goto L13;
        return;
    L13:
        throw r7;
    L7:
        r7 = null;
        goto L9
    }

    public List<Value[]> getAllRowsFromSQL(String r3) throws WCDBException {
        Handle r0 = getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L11
        List<Value[]> r1 = r4.getMultiRows();     // Catch: Throwable -> L9
        r4.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r0.invalidate();
    L8:
        return r1;
    L9:
        th = th;
    L13:
        if (r4 == null) goto L16;
        r4.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r4 = null;
        goto L13
    }

    public List<Value[]> getAllRowsFromStatement(Statement r3) throws WCDBException {
        Handle r0 = getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L11
        List<Value[]> r1 = r4.getMultiRows();     // Catch: Throwable -> L9
        r4.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r0.invalidate();
    L8:
        return r1;
    L9:
        th = th;
    L13:
        if (r4 == null) goto L16;
        r4.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r4 = null;
        goto L13
    }

    public List<byte[]> getOneColumnBLOBFromStatement(Statement r3) throws WCDBException {
        Handle r0 = getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L11
        List<byte[]> r1 = r4.getOneColumnBLOB();     // Catch: Throwable -> L9
        r4.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r0.invalidate();
    L8:
        return r1;
    L9:
        th = th;
    L13:
        if (r4 == null) goto L16;
        r4.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r4 = null;
        goto L13
    }

    public List<Double> getOneColumnDoubleFromStatement(Statement r3) throws WCDBException {
        Handle r0 = getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L11
        List<Double> r1 = r4.getOneColumnDouble();     // Catch: Throwable -> L9
        r4.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r0.invalidate();
    L8:
        return r1;
    L9:
        th = th;
    L13:
        if (r4 == null) goto L16;
        r4.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r4 = null;
        goto L13
    }

    public List<Float> getOneColumnFloatFromStatement(Statement r3) throws WCDBException {
        Handle r0 = getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L11
        List<Float> r1 = r4.getOneColumnFloat();     // Catch: Throwable -> L9
        r4.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r0.invalidate();
    L8:
        return r1;
    L9:
        th = th;
    L13:
        if (r4 == null) goto L16;
        r4.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r4 = null;
        goto L13
    }

    public List<Value> getOneColumnFromSQL(String r3) throws WCDBException {
        Handle r0 = getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L11
        List<Value> r1 = r4.getOneColumn();     // Catch: Throwable -> L9
        r4.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r0.invalidate();
    L8:
        return r1;
    L9:
        th = th;
    L13:
        if (r4 == null) goto L16;
        r4.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r4 = null;
        goto L13
    }

    public List<Value> getOneColumnFromStatement(Statement r3) throws WCDBException {
        Handle r0 = getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L11
        List<Value> r1 = r4.getOneColumn();     // Catch: Throwable -> L9
        r4.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r0.invalidate();
    L8:
        return r1;
    L9:
        th = th;
    L13:
        if (r4 == null) goto L16;
        r4.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r4 = null;
        goto L13
    }

    public List<Integer> getOneColumnIntFromStatement(Statement r3) throws WCDBException {
        Handle r0 = getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L11
        List<Integer> r1 = r4.getOneColumnInt();     // Catch: Throwable -> L9
        r4.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r0.invalidate();
    L8:
        return r1;
    L9:
        th = th;
    L13:
        if (r4 == null) goto L16;
        r4.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r4 = null;
        goto L13
    }

    public List<Long> getOneColumnLongFromStatement(Statement r3) throws WCDBException {
        Handle r0 = getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L11
        List<Long> r1 = r4.getOneColumnLong();     // Catch: Throwable -> L9
        r4.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r0.invalidate();
    L8:
        return r1;
    L9:
        th = th;
    L13:
        if (r4 == null) goto L16;
        r4.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r4 = null;
        goto L13
    }

    public List<String> getOneColumnStringFromStatement(Statement r3) throws WCDBException {
        Handle r0 = getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L11
        List<String> r1 = r4.getOneColumnString();     // Catch: Throwable -> L9
        r4.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r0.invalidate();
    L8:
        return r1;
    L9:
        th = th;
    L13:
        if (r4 == null) goto L16;
        r4.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r4 = null;
        goto L13
    }

    public Value[] getOneRowFromSQL(String r5) throws WCDBException {
        Handle r0 = getHandle(false);
        Value[] r1 = null;
        PreparedStatement r6 = r0.preparedWithMainStatement(r5);     // Catch: Throwable -> L13
        r6.step();     // Catch: Throwable -> L11
        if (r6.isDone() == true) goto L7;
        r1 = r6.getOneRow();     // Catch: Throwable -> L11
    L7:
        r6.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L10;
        r0.invalidate();
    L10:
        return r1;
    L11:
        Throwable th = th;
    L15:
        if (r6 == null) goto L18;
        r6.finalizeStatement();
    L18:
        if (autoInvalidateHandle() == false) goto L20;
        r0.invalidate();
    L20:
        throw th;
    L13:
        th = move-exception;
        th = th;
        r6 = null;
        goto L15
    }

    public Value[] getOneRowFromStatement(Statement r5) throws WCDBException {
        Handle r0 = getHandle(false);
        Value[] r1 = null;
        PreparedStatement r6 = r0.preparedWithMainStatement(r5);     // Catch: Throwable -> L13
        r6.step();     // Catch: Throwable -> L11
        if (r6.isDone() == true) goto L7;
        r1 = r6.getOneRow();     // Catch: Throwable -> L11
    L7:
        r6.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L10;
        r0.invalidate();
    L10:
        return r1;
    L11:
        Throwable th = th;
    L15:
        if (r6 == null) goto L18;
        r6.finalizeStatement();
    L18:
        if (autoInvalidateHandle() == false) goto L20;
        r0.invalidate();
    L20:
        throw th;
    L13:
        th = move-exception;
        th = th;
        r6 = null;
        goto L15
    }

    public Value getValueFromSQL(String r5) throws WCDBException {
        Handle r1 = getHandle(false);
        Value r2 = null;
        Value r6 = r1.preparedWithMainStatement(r5);     // Catch: Throwable -> L13
        r6.step();     // Catch: Throwable -> L11
        if (r6.isDone() == true) goto L7;
        r2 = r6.getValue(0);     // Catch: Throwable -> L11
    L7:
        r6.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L10;
        r1.invalidate();
    L10:
        return r2;
    L11:
        th = th;
        r2 = r6;
    L14:
        if (r2 == null) goto L17;
        r2.finalizeStatement();
    L17:
        if (autoInvalidateHandle() == false) goto L19;
        r1.invalidate();
    L19:
        throw th;
    L13:
        th = th;
        goto L14
    }

    public Value getValueFromStatement(Statement r5) throws WCDBException {
        Handle r1 = getHandle(false);
        Value r2 = null;
        Value r6 = r1.preparedWithMainStatement(r5);     // Catch: Throwable -> L13
        r6.step();     // Catch: Throwable -> L11
        if (r6.isDone() == true) goto L7;
        r2 = r6.getValue(0);     // Catch: Throwable -> L11
    L7:
        r6.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L10;
        r1.invalidate();
    L10:
        return r2;
    L11:
        th = th;
        r2 = r6;
    L14:
        if (r2 == null) goto L17;
        r2.finalizeStatement();
    L17:
        if (autoInvalidateHandle() == false) goto L19;
        r1.invalidate();
    L19:
        throw th;
    L13:
        th = th;
        goto L14
    }

    public void runPausableTransaction(PausableTransaction r4) throws WCDBException {
        Handle r0 = getHandle(true);
    L14:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L4:
        if (r0.runPausableTransaction(r0.getCppHandle(), r4) == true) goto L7;
        WCDBException r5 = r0.createException();     // Catch: Throwable -> L14
    L9:
        if (autoInvalidateHandle() == false) goto L11;
        r0.invalidate();
    L11:
        if (r5 != null) goto L13;
        return;
    L13:
        throw r5;
    L7:
        r5 = null;
        goto L9
    }

    public void runTransaction(Transaction r4) throws WCDBException {
        Handle r0 = getHandle(true);
    L14:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L4:
        if (r0.runTransaction(r0.getCppHandle(), r4) == true) goto L7;
        WCDBException r5 = r0.createException();     // Catch: Throwable -> L14
    L9:
        if (autoInvalidateHandle() == false) goto L11;
        r0.invalidate();
    L11:
        if (r5 != null) goto L13;
        return;
    L13:
        throw r5;
    L7:
        r5 = null;
        goto L9
    }

    public void deleteValue(String r2) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(r2));
    }

    public void execute(String r4) throws WCDBException {
        Handle r0 = getHandle(false);
    L14:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L4:
        if (Handle.executeSQL(r0.getCppHandle(), r4) == true) goto L7;
        WCDBException r5 = r0.createException();     // Catch: Throwable -> L14
    L9:
        if (autoInvalidateHandle() == false) goto L11;
        r0.invalidate();
    L11:
        if (r5 != null) goto L13;
        return;
    L13:
        throw r5;
    L7:
        r5 = null;
        goto L9
    }

    private void updateRow(Value[] r2, StatementUpdate r3) throws WCDBException {
        Handle r0 = getHandle(true);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L11
        r4.bindRow(r2);     // Catch: Throwable -> L9
        r4.step();     // Catch: Throwable -> L9
        r4.finalizeStatement();     // Catch: Throwable -> L9
        r4.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L23;
        r0.invalidate();
        return;
    L23:
        return;
    L9:
        th = th;
    L13:
        if (r4 == null) goto L16;
        r4.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r0.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r4 = null;
        goto L13
    }

    public void deleteValue(String r2, Expression r3) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(r2).where(r3));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r3, String r4) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r3).from(new String[]{r4}));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, String r6) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, String r6) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, String r6) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, String r6) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, String r6) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, String r6) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, String r6) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r3, String r4) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r3).from(new String[]{r4}));
    }

    public Value getValue(ResultColumnConvertible r5, String r6) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}));
    }

    private void insertRows(Collection<Value[]> r1, StatementInsert r2, Handle r3) throws WCDBException {
        PreparedStatement r4 = r3.preparedWithMainStatement(r2);
        Iterator<Value[]> r5 = r1.iterator();     // Catch: Throwable -> L10
    L5:
        if (r5.hasNext() == false) goto L8;
        Value[] r6 = r5.next();     // Catch: Throwable -> L10
        r4.reset();     // Catch: Throwable -> L10
        r4.bindRow(r6);     // Catch: Throwable -> L10
        r4.step();     // Catch: Throwable -> L10
        goto L5
    L8:
        r4.finalizeStatement();
        return;
    L10:
        th = move-exception;
        r4.finalizeStatement();
        throw th;
    }

    public void deleteValue(String r3, OrderingTerm r4, int r5) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(r3).orderBy(new OrderingTerm[]{r4}).limit(r5));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r4, String r5, OrderingTerm r6) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r4).from(new String[]{r5}).orderBy(new OrderingTerm[]{r6}));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, String r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, String r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, String r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, String r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, String r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, String r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, String r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r4, String r5, OrderingTerm r6) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r4).from(new String[]{r5}).orderBy(new OrderingTerm[]{r6}));
    }

    public Value getValue(ResultColumnConvertible r5, String r6, OrderingTerm r7) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}));
    }

    public void insertOrIgnoreRow(Value[] r1, Column[] r2, String r3) throws WCDBException {
        insertOrIgnoreRows(Collections.singleton(r1), r2, r3);
    }

    public void insertOrIgnoreRows(Collection<Value[]> r2, Column[] r3, String r4) throws WCDBException {
        insertRows(r2, r3, r4, ConflictAction.Ignore);
    }

    public void insertOrReplaceRow(Value[] r1, Column[] r2, String r3) throws WCDBException {
        insertOrReplaceRows(Collections.singleton(r1), r2, r3);
    }

    public void insertOrReplaceRows(Collection<Value[]> r2, Column[] r3, String r4) throws WCDBException {
        insertRows(r2, r3, r4, ConflictAction.Replace);
    }

    public void insertRow(Value[] r1, Column[] r2, String r3) throws WCDBException {
        insertRows(Collections.singleton(r1), r2, r3);
    }

    public void updateRow(Value[] r2, Column[] r3, String r4) throws WCDBException {
        updateRow(r2, new StatementUpdate().update(r4).setColumnsToBindParameters(r3));
    }

    public void updateValue(Value r4, Column r5, String r6) throws WCDBException {
        if (r4 != null) goto L4;
        r4 = new Value();
    L4:
        updateRow(new Value[]{r4}, new Column[]{r5}, r6);
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r3, String r4, Expression r5) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r3).from(new String[]{r4}).where(r5));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, String r6, Expression r7) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, String r6, Expression r7) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, String r6, Expression r7) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, String r6, Expression r7) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, String r6, Expression r7) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, String r6, Expression r7) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, String r6, Expression r7) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r3, String r4, Expression r5) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r3).from(new String[]{r4}).where(r5));
    }

    public Value getValue(ResultColumnConvertible r5, String r6, Expression r7) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7));
    }

    public void insertRows(Collection<Value[]> r2, Column[] r3, String r4) throws WCDBException {
        insertRows(r2, r3, r4, ConflictAction.None);
    }

    public void updateValue(int r4, Column r5, String r6) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6);
    }

    public void updateValue(long r4, Column r6, String r7) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r6}, r7);
    }

    public void updateValue(String r4, Column r5, String r6) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6);
    }

    public void updateValue(byte[] r4, Column r5, String r6) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6);
    }

    public static /* synthetic */ void access$000(HandleOperation r0, Collection r1, StatementInsert r2, Handle r3) throws WCDBException {
        r0.insertRows(r1, r2, r3);
    }

    private void insertRows(final Collection<Value[]> r2, Column[] r3, String r4, ConflictAction r5) throws WCDBException {
        final StatementInsert r6 = new StatementInsert().insertInto(r4).columns(r3).valuesWithBindParameters(r3.length);
        if (r5 != ConflictAction.Replace) goto L6;
        r6.orReplace();
    L8:
        Handle r7 = getHandle(true);
    L17:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L21;
        r7.invalidate();
    L21:
        throw th;
    L10:
        if (r2.size() <= 1) goto L12;
        r7.runTransaction(new AnonymousClass1(this, r2, r6));     // Catch: Throwable -> L17
    L14:
        if (autoInvalidateHandle() == false) goto L23;
        r7.invalidate();
        return;
    L23:
        return;
    L12:
        insertRows(r2, r6, r7);     // Catch: Throwable -> L17
        goto L14
    L6:
        if (r5 != ConflictAction.Ignore) goto L8;
        r6.orIgnore();
        goto L8
    }

    public void deleteValue(String r3, OrderingTerm r4, int r5, int r6) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(r3).orderBy(new OrderingTerm[]{r4}).limit(r5).offset(r6));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r4, String r5, OrderingTerm r6, int r7) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r4).from(new String[]{r5}).orderBy(new OrderingTerm[]{r6}).limit(r7));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r4, String r5, OrderingTerm r6, int r7) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r4).from(new String[]{r5}).orderBy(new OrderingTerm[]{r6}).limit(1).offset(r7));
    }

    public Value getValue(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(1).offset(r8));
    }

    public void updateRow(Value[] r2, Column[] r3, String r4, Expression r5) throws WCDBException {
        updateRow(r2, new StatementUpdate().update(r4).setColumnsToBindParameters(r3).where(r5));
    }

    public void updateValue(Value r4, Column r5, String r6, Expression r7) throws WCDBException {
        if (r4 != null) goto L4;
        r4 = new Value();
    L4:
        updateRow(new Value[]{r4}, new Column[]{r5}, r6, r7);
    }

    public void deleteValue(String r2, Expression r3, OrderingTerm r4, int r5) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(r2).where(r3).orderBy(new OrderingTerm[]{r4}).limit(r5));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r4, String r5, Expression r6, OrderingTerm r7) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r4).from(new String[]{r5}).where(r6).orderBy(new OrderingTerm[]{r7}));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r4, String r5, Expression r6, OrderingTerm r7) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r4).from(new String[]{r5}).where(r6).orderBy(new OrderingTerm[]{r7}));
    }

    public Value getValue(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}));
    }

    public void updateValue(double r4, Column r6, String r7, Expression r8) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r6}, r7, r8);
    }

    public void updateValue(int r4, Column r5, String r6, Expression r7) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6, r7);
    }

    public void updateValue(String r4, Column r5, String r6, Expression r7) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6, r7);
    }

    public void updateValue(byte[] r4, Column r5, String r6, Expression r7) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6, r7);
    }

    public void deleteValue(String r2, Expression r3, OrderingTerm r4, int r5, int r6) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(r2).where(r3).orderBy(new OrderingTerm[]{r4}).limit(r5).offset(r6));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r4, String r5, OrderingTerm r6, int r7, int r8) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r4).from(new String[]{r5}).orderBy(new OrderingTerm[]{r6}).limit(r7).offset(r8));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, String r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r4, String r5, Expression r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r4).from(new String[]{r5}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(1).offset(r8));
    }

    public Value getValue(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(1).offset(r9));
    }

    public void updateRow(Value[] r2, Column[] r3, String r4, OrderingTerm r5, int r6) throws WCDBException {
        updateRow(r2, new StatementUpdate().update(r4).setColumnsToBindParameters(r3).orderBy(new OrderingTerm[]{r5}).limit(r6));
    }

    public void updateValue(Value r8, Column r9, String r10, OrderingTerm r11, int r12) throws WCDBException {
        if (r8 != null) goto L4;
        r8 = new Value();
    L4:
        updateRow(new Value[]{r8}, new Column[]{r9}, r10, r11, r12);
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r4, String r5, Expression r6, OrderingTerm r7, int r8) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r4).from(new String[]{r5}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9));
    }

    public void updateValue(double r8, Column r10, String r11, OrderingTerm r12, int r13) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r10}, r11, r12, r13);
    }

    public void updateValue(int r8, Column r9, String r10, OrderingTerm r11, int r12) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r9}, r10, r11, r12);
    }

    public void updateValue(String r8, Column r9, String r10, OrderingTerm r11, int r12) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r9}, r10, r11, r12);
    }

    public void updateValue(byte[] r8, Column r9, String r10, OrderingTerm r11, int r12) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r9}, r10, r11, r12);
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r4, String r5, Expression r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r4).from(new String[]{r5}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9, int r10) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9).offset(r10));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9, int r10) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9).offset(r10));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9, int r10) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9).offset(r10));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9, int r10) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9).offset(r10));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9, int r10) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9).offset(r10));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9, int r10) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9).offset(r10));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, String r6, Expression r7, OrderingTerm r8, int r9, int r10) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{r6}).where(r7).orderBy(new OrderingTerm[]{r8}).limit(r9).offset(r10));
    }

    public void updateRow(Value[] r2, Column[] r3, String r4, OrderingTerm r5, int r6, int r7) throws WCDBException {
        updateRow(r2, new StatementUpdate().update(r4).setColumnsToBindParameters(r3).orderBy(new OrderingTerm[]{r5}).limit(r6).offset(r7));
    }

    public void updateValue(Value r9, Column r10, String r11, Expression r12, OrderingTerm r13, int r14) throws WCDBException {
        if (r9 != null) goto L4;
        r9 = new Value();
    L4:
        updateRow(new Value[]{r9}, new Column[]{r10}, r11, r12, r13, r14);
    }

    public void updateRow(Value[] r2, Column[] r3, String r4, Expression r5, OrderingTerm r6, int r7) throws WCDBException {
        updateRow(r2, new StatementUpdate().update(r4).setColumnsToBindParameters(r3).where(r5).orderBy(new OrderingTerm[]{r6}).limit(r7));
    }

    public void updateValue(double r9, Column r11, String r12, Expression r13, OrderingTerm r14, int r15) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r11}, r12, r13, r14, r15);
    }

    public void updateValue(double r9, Column r11, String r12, OrderingTerm r13, int r14, int r15) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r11}, r12, r13, r14, r15);
    }

    public void updateValue(int r9, Column r10, String r11, Expression r12, OrderingTerm r13, int r14) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r10}, r11, r12, r13, r14);
    }

    public void updateValue(int r9, Column r10, String r11, OrderingTerm r12, int r13, int r14) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r10}, r11, r12, r13, r14);
    }

    public void updateValue(String r9, Column r10, String r11, Expression r12, OrderingTerm r13, int r14) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r10}, r11, r12, r13, r14);
    }

    public void updateValue(String r9, Column r10, String r11, OrderingTerm r12, int r13, int r14) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r10}, r11, r12, r13, r14);
    }

    public void updateValue(byte[] r9, Column r10, String r11, Expression r12, OrderingTerm r13, int r14) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r10}, r11, r12, r13, r14);
    }

    public void updateValue(byte[] r9, Column r10, String r11, OrderingTerm r12, int r13, int r14) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r10}, r11, r12, r13, r14);
    }

    public void updateValue(Value r9, Column r10, String r11, OrderingTerm r12, int r13, int r14) throws WCDBException {
        updateRow(new Value[]{r9}, new Column[]{r10}, r11, r12, r13, r14);
    }

    public void updateRow(Value[] r2, Column[] r3, String r4, Expression r5, OrderingTerm r6, int r7, int r8) throws WCDBException {
        updateRow(r2, new StatementUpdate().update(r4).setColumnsToBindParameters(r3).where(r5).orderBy(new OrderingTerm[]{r6}).limit(r7).offset(r8));
    }

    public void updateValue(double r10, Column r12, String r13, Expression r14, OrderingTerm r15, int r16, int r17) throws WCDBException {
        updateRow(new Value[]{new Value(r10)}, new Column[]{r12}, r13, r14, r15, r16, r17);
    }

    public void updateValue(int r10, Column r11, String r12, Expression r13, OrderingTerm r14, int r15, int r16) throws WCDBException {
        updateRow(new Value[]{new Value(r10)}, new Column[]{r11}, r12, r13, r14, r15, r16);
    }

    public void updateValue(String r10, Column r11, String r12, Expression r13, OrderingTerm r14, int r15, int r16) throws WCDBException {
        updateRow(new Value[]{new Value(r10)}, new Column[]{r11}, r12, r13, r14, r15, r16);
    }

    public void updateValue(byte[] r10, Column r11, String r12, Expression r13, OrderingTerm r14, int r15, int r16) throws WCDBException {
        updateRow(new Value[]{new Value(r10)}, new Column[]{r11}, r12, r13, r14, r15, r16);
    }

    public void updateValue(Value r10, Column r11, String r12, Expression r13, OrderingTerm r14, int r15, int r16) throws WCDBException {
        updateRow(new Value[]{r10}, new Column[]{r11}, r12, r13, r14, r15, r16);
    }
}
