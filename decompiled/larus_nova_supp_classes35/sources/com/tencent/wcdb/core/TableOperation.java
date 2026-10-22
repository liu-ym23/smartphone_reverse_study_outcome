package com.tencent.wcdb.core;

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
public class TableOperation {
    Database database;
    String tableName;

    public void deleteValue() throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(this.tableName));
    }

    public TableOperation() {
        this.tableName = null;
        this.database = null;
    }

    public Database getDatabase() {
        return this.database;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void deleteValue(Expression r3) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(this.tableName).where(r3));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r4) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r4).from(new String[]{this.tableName}));
    }

    public List<Value[]> getAllRowsFromStatement(Statement r3) throws WCDBException {
        Handle r0 = this.database.getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L9
        List<Value[]> r1 = r4.getMultiRows();     // Catch: Throwable -> L7
        r4.finalizeStatement();
        r0.invalidate();
        return r1;
    L7:
        th = th;
    L11:
        if (r4 == null) goto L13;
        r4.finalizeStatement();
    L13:
        r0.invalidate();
        throw th;
    L9:
        th = th;
        r4 = null;
        goto L11
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}));
    }

    public List<byte[]> getOneColumnBLOBFromStatement(Statement r3) throws WCDBException {
        Handle r0 = this.database.getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L9
        List<byte[]> r1 = r4.getOneColumnBLOB();     // Catch: Throwable -> L7
        r4.finalizeStatement();
        r0.invalidate();
        return r1;
    L7:
        th = th;
    L11:
        if (r4 == null) goto L13;
        r4.finalizeStatement();
    L13:
        r0.invalidate();
        throw th;
    L9:
        th = th;
        r4 = null;
        goto L11
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}));
    }

    public List<Double> getOneColumnDoubleFromStatement(Statement r3) throws WCDBException {
        Handle r0 = this.database.getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L9
        List<Double> r1 = r4.getOneColumnDouble();     // Catch: Throwable -> L7
        r4.finalizeStatement();
        r0.invalidate();
        return r1;
    L7:
        th = th;
    L11:
        if (r4 == null) goto L13;
        r4.finalizeStatement();
    L13:
        r0.invalidate();
        throw th;
    L9:
        th = th;
        r4 = null;
        goto L11
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}));
    }

    public List<Float> getOneColumnFloatFromStatement(Statement r3) throws WCDBException {
        Handle r0 = this.database.getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L9
        List<Float> r1 = r4.getOneColumnFloat();     // Catch: Throwable -> L7
        r4.finalizeStatement();
        r0.invalidate();
        return r1;
    L7:
        th = th;
    L11:
        if (r4 == null) goto L13;
        r4.finalizeStatement();
    L13:
        r0.invalidate();
        throw th;
    L9:
        th = th;
        r4 = null;
        goto L11
    }

    public List<Value> getOneColumnFromStatement(Statement r3) throws WCDBException {
        Handle r0 = this.database.getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L9
        List<Value> r1 = r4.getOneColumn();     // Catch: Throwable -> L7
        r4.finalizeStatement();
        r0.invalidate();
        return r1;
    L7:
        th = th;
    L11:
        if (r4 == null) goto L13;
        r4.finalizeStatement();
    L13:
        r0.invalidate();
        throw th;
    L9:
        th = th;
        r4 = null;
        goto L11
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}));
    }

    public List<Integer> getOneColumnIntFromStatement(Statement r3) throws WCDBException {
        Handle r0 = this.database.getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L9
        List<Integer> r1 = r4.getOneColumnInt();     // Catch: Throwable -> L7
        r4.finalizeStatement();
        r0.invalidate();
        return r1;
    L7:
        th = th;
    L11:
        if (r4 == null) goto L13;
        r4.finalizeStatement();
    L13:
        r0.invalidate();
        throw th;
    L9:
        th = th;
        r4 = null;
        goto L11
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}));
    }

    public List<Long> getOneColumnLongFromStatement(Statement r3) throws WCDBException {
        Handle r0 = this.database.getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L9
        List<Long> r1 = r4.getOneColumnLong();     // Catch: Throwable -> L7
        r4.finalizeStatement();
        r0.invalidate();
        return r1;
    L7:
        th = th;
    L11:
        if (r4 == null) goto L13;
        r4.finalizeStatement();
    L13:
        r0.invalidate();
        throw th;
    L9:
        th = th;
        r4 = null;
        goto L11
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}));
    }

    public List<String> getOneColumnStringFromStatement(Statement r3) throws WCDBException {
        Handle r0 = this.database.getHandle(false);
        PreparedStatement r4 = r0.preparedWithMainStatement(r3);     // Catch: Throwable -> L9
        List<String> r1 = r4.getOneColumnString();     // Catch: Throwable -> L7
        r4.finalizeStatement();
        r0.invalidate();
        return r1;
    L7:
        th = th;
    L11:
        if (r4 == null) goto L13;
        r4.finalizeStatement();
    L13:
        r0.invalidate();
        throw th;
    L9:
        th = th;
        r4 = null;
        goto L11
    }

    public Value[] getOneRow(ResultColumnConvertible[] r4) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r4).from(new String[]{this.tableName}));
    }

    public Value[] getOneRowFromStatement(Statement r5) throws WCDBException {
        Handle r0 = this.database.getHandle(false);
        Value[] r1 = null;
        PreparedStatement r6 = r0.preparedWithMainStatement(r5);     // Catch: Throwable -> L11
        r6.step();     // Catch: Throwable -> L9
        if (r6.isDone() == true) goto L7;
        r1 = r6.getOneRow();     // Catch: Throwable -> L9
    L7:
        r6.finalizeStatement();
        r0.invalidate();
        return r1;
    L9:
        Throwable th = th;
    L13:
        if (r6 == null) goto L15;
        r6.finalizeStatement();
    L15:
        r0.invalidate();
        throw th;
    L11:
        th = move-exception;
        th = th;
        r6 = null;
        goto L13
    }

    public Value getValue(ResultColumnConvertible r5) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}));
    }

    public Value getValueFromStatement(Statement r5) throws WCDBException {
        Handle r0 = this.database.getHandle(false);
        Value r2 = null;
        Value r6 = r0.preparedWithMainStatement(r5);     // Catch: Throwable -> L11
        r6.step();     // Catch: Throwable -> L9
        if (r6.isDone() == true) goto L7;
        r2 = r6.getValue(0);     // Catch: Throwable -> L9
    L7:
        r6.finalizeStatement();
        r0.invalidate();
        return r2;
    L9:
        th = th;
        r2 = r6;
    L12:
        if (r2 == null) goto L14;
        r2.finalizeStatement();
    L14:
        r0.invalidate();
        throw th;
    L11:
        th = th;
        goto L12
    }

    private void deleteValue(StatementDelete r3) throws WCDBException {
        Handle r0 = this.database.getHandle(true);
        r0.execute(r3);     // Catch: Throwable -> L6
        r0.invalidate();
        return;
    L6:
        th = move-exception;
        r0.invalidate();
        throw th;
    }

    private void updateRow(Value[] r3, StatementUpdate r4) throws WCDBException {
        Handle r0 = this.database.getHandle(true);
        PreparedStatement r5 = r0.preparedWithMainStatement(r4);     // Catch: Throwable -> L9
        r5.bindRow(r3);     // Catch: Throwable -> L7
        r5.step();     // Catch: Throwable -> L7
        r5.finalizeStatement();
        r0.invalidate();
        return;
    L7:
        th = th;
    L11:
        if (r5 == null) goto L13;
        r5.finalizeStatement();
    L13:
        r0.invalidate();
        throw th;
    L9:
        th = th;
        r5 = null;
        goto L11
    }

    public void deleteValue(OrderingTerm r4, int r5) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(this.tableName).orderBy(new OrderingTerm[]{r4}).limit(r5));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r5, OrderingTerm r6) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r5).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, OrderingTerm r6) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, OrderingTerm r6) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, OrderingTerm r6) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, OrderingTerm r6) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, OrderingTerm r6) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, OrderingTerm r6) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, OrderingTerm r6) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r5, OrderingTerm r6) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r5).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}));
    }

    public Value getValue(ResultColumnConvertible r5, OrderingTerm r6) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}));
    }

    public void insertOrIgnoreRow(Value[] r1, Column[] r2) throws WCDBException {
        insertOrIgnoreRows(Collections.singleton(r1), r2);
    }

    public void insertOrIgnoreRows(Collection<Value[]> r2, Column[] r3) throws WCDBException {
        insertRows(r2, r3, ConflictAction.Ignore);
    }

    public void insertOrReplaceRow(Value[] r1, Column[] r2) throws WCDBException {
        insertOrReplaceRows(Collections.singleton(r1), r2);
    }

    public void insertOrReplaceRows(Collection<Value[]> r2, Column[] r3) throws WCDBException {
        insertRows(r2, r3, ConflictAction.Replace);
    }

    public void insertRow(Value[] r1, Column[] r2) throws WCDBException {
        insertRows(Collections.singleton(r1), r2);
    }

    public void insertRows(Collection<Value[]> r2, Column[] r3) throws WCDBException {
        insertRows(r2, r3, ConflictAction.None);
    }

    public void updateValue(double r4, Column r6) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r6});
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r4, Expression r5) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r4).from(new String[]{this.tableName}).where(r5));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, Expression r6) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, Expression r6) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, Expression r6) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, Expression r6) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, Expression r6) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, Expression r6) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, Expression r6) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r4, Expression r5) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r4).from(new String[]{this.tableName}).where(r5));
    }

    public Value getValue(ResultColumnConvertible r5, Expression r6) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6));
    }

    public void updateRow(Value[] r3, Column[] r4) throws WCDBException {
        updateRow(r3, new StatementUpdate().update(this.tableName).setColumnsToBindParameters(r4));
    }

    public void updateValue(float r4, Column r5) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5});
    }

    public void updateValue(int r4, Column r5) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5});
    }

    public void updateValue(long r4, Column r6) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r6});
    }

    public void updateValue(String r4, Column r5) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5});
    }

    public void updateValue(byte[] r4, Column r5) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5});
    }

    public void updateValue(Value r4, Column r5) throws WCDBException {
        updateRow(new Value[]{r4}, new Column[]{r5});
    }

    private void insertRows(final Collection<Value[]> r3, Column[] r4, ConflictAction r5) throws WCDBException {
        final StatementInsert r6 = new StatementInsert().insertInto(this.tableName).columns(r4).valuesWithBindParameters(r4.length);
        if (r5 != ConflictAction.Replace) goto L6;
        r6.orReplace();
    L8:
        Handle r7 = this.database.getHandle(true);
    L15:
        th = move-exception;
        r7.invalidate();
        throw th;
    L10:
        if (r3.size() <= 1) goto L12;
        r7.runTransaction(new AnonymousClass1(this, r3, r6));     // Catch: Throwable -> L15
    L13:
        r7.invalidate();
        return;
    L12:
        insertRows(r3, r6, r7);     // Catch: Throwable -> L15
        goto L13
    L6:
        if (r5 != ConflictAction.Ignore) goto L8;
        r6.orIgnore();
        goto L8
    }

    public void deleteValue(OrderingTerm r4, int r5, int r6) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(this.tableName).orderBy(new OrderingTerm[]{r4}).limit(r5).offset(r6));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r5, OrderingTerm r6, int r7) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r5).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, OrderingTerm r6, int r7) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, OrderingTerm r6, int r7) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, OrderingTerm r6, int r7) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, OrderingTerm r6, int r7) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, OrderingTerm r6, int r7) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, OrderingTerm r6, int r7) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, OrderingTerm r6, int r7) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r5, OrderingTerm r6, int r7) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r5).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(1).offset(r7));
    }

    public Value getValue(ResultColumnConvertible r5, OrderingTerm r6, int r7) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(1).offset(r7));
    }

    public void updateRow(Value[] r3, Column[] r4, Expression r5) throws WCDBException {
        updateRow(r3, new StatementUpdate().update(this.tableName).setColumnsToBindParameters(r4).where(r5));
    }

    public void updateValue(double r4, Column r6, Expression r7) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r6}, r7);
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

    public void deleteValue(Expression r3, OrderingTerm r4, int r5) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(this.tableName).where(r3).orderBy(new OrderingTerm[]{r4}).limit(r5));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r5, Expression r6, OrderingTerm r7) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r5).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, Expression r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, Expression r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, Expression r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, Expression r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, Expression r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, Expression r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, Expression r6, OrderingTerm r7) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r5, Expression r6, OrderingTerm r7) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r5).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}));
    }

    public Value getValue(ResultColumnConvertible r5, Expression r6, OrderingTerm r7) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}));
    }

    public void updateValue(float r4, Column r5, Expression r6) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6);
    }

    public void updateValue(int r4, Column r5, Expression r6) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6);
    }

    public void updateValue(long r4, Column r6, Expression r7) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r6}, r7);
    }

    public void updateValue(String r4, Column r5, Expression r6) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6);
    }

    public void updateValue(byte[] r4, Column r5, Expression r6) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6);
    }

    public void updateValue(Value r4, Column r5, Expression r6) throws WCDBException {
        updateRow(new Value[]{r4}, new Column[]{r5}, r6);
    }

    public static /* synthetic */ void access$000(TableOperation r0, Collection r1, StatementInsert r2, Handle r3) throws WCDBException {
        r0.insertRows(r1, r2, r3);
    }

    public void deleteValue(Expression r3, OrderingTerm r4, int r5, int r6) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(this.tableName).where(r3).orderBy(new OrderingTerm[]{r4}).limit(r5).offset(r6));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r5, OrderingTerm r6, int r7, int r8) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r5).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7).offset(r8));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, OrderingTerm r6, int r7, int r8) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7).offset(r8));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, OrderingTerm r6, int r7, int r8) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7).offset(r8));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, OrderingTerm r6, int r7, int r8) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7).offset(r8));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, OrderingTerm r6, int r7, int r8) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7).offset(r8));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, OrderingTerm r6, int r7, int r8) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7).offset(r8));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, OrderingTerm r6, int r7, int r8) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7).offset(r8));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, OrderingTerm r6, int r7, int r8) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r6}).limit(r7).offset(r8));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r5, Expression r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r5).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(1).offset(r8));
    }

    public Value getValue(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(1).offset(r8));
    }

    public void updateRow(Value[] r3, Column[] r4, OrderingTerm r5, int r6) throws WCDBException {
        updateRow(r3, new StatementUpdate().update(this.tableName).setColumnsToBindParameters(r4).orderBy(new OrderingTerm[]{r5}).limit(r6));
    }

    public void updateValue(double r4, Column r6, OrderingTerm r7, int r8) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r6}, r7, r8);
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r5, Expression r6, OrderingTerm r7, int r8) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r5).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8));
    }

    public void updateValue(float r4, Column r5, OrderingTerm r6, int r7) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6, r7);
    }

    public void updateValue(int r4, Column r5, OrderingTerm r6, int r7) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6, r7);
    }

    public void updateValue(long r4, Column r6, OrderingTerm r7, int r8) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r6}, r7, r8);
    }

    public void updateValue(String r4, Column r5, OrderingTerm r6, int r7) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6, r7);
    }

    public void updateValue(byte[] r4, Column r5, OrderingTerm r6, int r7) throws WCDBException {
        updateRow(new Value[]{new Value(r4)}, new Column[]{r5}, r6, r7);
    }

    public void updateValue(Value r4, Column r5, OrderingTerm r6, int r7) throws WCDBException {
        updateRow(new Value[]{r4}, new Column[]{r5}, r6, r7);
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r5, Expression r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r5).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r5, Expression r6, OrderingTerm r7, int r8, int r9) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r5}).from(new String[]{this.tableName}).where(r6).orderBy(new OrderingTerm[]{r7}).limit(r8).offset(r9));
    }

    public void updateRow(Value[] r3, Column[] r4, OrderingTerm r5, int r6, int r7) throws WCDBException {
        updateRow(r3, new StatementUpdate().update(this.tableName).setColumnsToBindParameters(r4).orderBy(new OrderingTerm[]{r5}).limit(r6).offset(r7));
    }

    public void updateValue(double r8, Column r10, Expression r11, OrderingTerm r12, int r13) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r10}, r11, r12, r13);
    }

    public void updateRow(Value[] r3, Column[] r4, Expression r5, OrderingTerm r6, int r7) throws WCDBException {
        updateRow(r3, new StatementUpdate().update(this.tableName).setColumnsToBindParameters(r4).where(r5).orderBy(new OrderingTerm[]{r6}).limit(r7));
    }

    public void updateValue(double r8, Column r10, OrderingTerm r11, int r12, int r13) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r10}, r11, r12, r13);
    }

    public void updateValue(float r8, Column r9, Expression r10, OrderingTerm r11, int r12) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r9}, r10, r11, r12);
    }

    public void updateValue(float r8, Column r9, OrderingTerm r10, int r11, int r12) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r9}, r10, r11, r12);
    }

    public void updateValue(int r8, Column r9, Expression r10, OrderingTerm r11, int r12) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r9}, r10, r11, r12);
    }

    public void updateValue(int r8, Column r9, OrderingTerm r10, int r11, int r12) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r9}, r10, r11, r12);
    }

    public void updateValue(long r8, Column r10, Expression r11, OrderingTerm r12, int r13) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r10}, r11, r12, r13);
    }

    public void updateValue(long r8, Column r10, OrderingTerm r11, int r12, int r13) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r10}, r11, r12, r13);
    }

    public void updateValue(String r8, Column r9, Expression r10, OrderingTerm r11, int r12) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r9}, r10, r11, r12);
    }

    public void updateValue(String r8, Column r9, OrderingTerm r10, int r11, int r12) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r9}, r10, r11, r12);
    }

    public void updateValue(byte[] r8, Column r9, Expression r10, OrderingTerm r11, int r12) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r9}, r10, r11, r12);
    }

    public void updateValue(byte[] r8, Column r9, OrderingTerm r10, int r11, int r12) throws WCDBException {
        updateRow(new Value[]{new Value(r8)}, new Column[]{r9}, r10, r11, r12);
    }

    public void updateValue(Value r8, Column r9, Expression r10, OrderingTerm r11, int r12) throws WCDBException {
        updateRow(new Value[]{r8}, new Column[]{r9}, r10, r11, r12);
    }

    public void updateValue(Value r8, Column r9, OrderingTerm r10, int r11, int r12) throws WCDBException {
        updateRow(new Value[]{r8}, new Column[]{r9}, r10, r11, r12);
    }

    public void updateRow(Value[] r3, Column[] r4, Expression r5, OrderingTerm r6, int r7, int r8) throws WCDBException {
        updateRow(r3, new StatementUpdate().update(this.tableName).setColumnsToBindParameters(r4).where(r5).orderBy(new OrderingTerm[]{r6}).limit(r7).offset(r8));
    }

    public void updateValue(double r9, Column r11, Expression r12, OrderingTerm r13, int r14, int r15) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r11}, r12, r13, r14, r15);
    }

    public void updateValue(float r9, Column r10, Expression r11, OrderingTerm r12, int r13, int r14) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r10}, r11, r12, r13, r14);
    }

    public void updateValue(int r9, Column r10, Expression r11, OrderingTerm r12, int r13, int r14) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r10}, r11, r12, r13, r14);
    }

    public void updateValue(long r9, Column r11, Expression r12, OrderingTerm r13, int r14, int r15) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r11}, r12, r13, r14, r15);
    }

    public void updateValue(String r9, Column r10, Expression r11, OrderingTerm r12, int r13, int r14) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r10}, r11, r12, r13, r14);
    }

    public void updateValue(byte[] r9, Column r10, Expression r11, OrderingTerm r12, int r13, int r14) throws WCDBException {
        updateRow(new Value[]{new Value(r9)}, new Column[]{r10}, r11, r12, r13, r14);
    }

    public void updateValue(Value r9, Column r10, Expression r11, OrderingTerm r12, int r13, int r14) throws WCDBException {
        updateRow(new Value[]{r9}, new Column[]{r10}, r11, r12, r13, r14);
    }
}
