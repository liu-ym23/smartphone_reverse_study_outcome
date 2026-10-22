package com.tencent.wcdb.core;

import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.Value;
import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.orm.Field;
import com.tencent.wcdb.orm.TableBinding;
import com.tencent.wcdb.winq.ColumnType;
import com.tencent.wcdb.winq.Statement;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PreparedStatement extends CppObject {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    boolean autoFinalize;
    int columnCount;

    /* JADX INFO: renamed from: com.tencent.wcdb.core.PreparedStatement$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$wcdb$winq$ColumnType = null;

        static {
            int[] r0 = new int[ColumnType.values().length];
            $SwitchMap$com$tencent$wcdb$winq$ColumnType = r0;
            r0[ColumnType.Integer.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Float.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Text.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.BLOB.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Null.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private static native void bindBLOB(long r0, byte[] r2, int r3);

    private static native void bindDouble(long r0, double r2, int r4);

    private static native void bindInteger(long r0, long r2, int r4);

    private static native void bindNull(long r0, int r2);

    private static native int bindParameterIndex(long r0, String r2);

    private static native void bindText(long r0, String r2, int r3);

    private static native boolean checkPrepared(long r0);

    private static native void clearBindings(long r0);

    private static native void finalize(long r0);

    private static native byte[] getBLOB(long r0, int r2);

    private static native int getColumnCount(long r0);

    private static native String getColumnName(long r0, int r2);

    private static native String getColumnTableName(long r0, int r2);

    private static native int getColumnType(long r0, int r2);

    private static native double getDouble(long r0, int r2);

    private static native long getError(long r0);

    private static native long getInteger(long r0, int r2);

    private static native String getOriginalColumnName(long r0, int r2);

    private static native String getText(long r0, int r2);

    private static native boolean isDone(long r0);

    private static native boolean isReadOnly(long r0);

    private static native boolean prepare(long r0, long r2);

    private static native boolean prepareSQL(long r0, String r2);

    private static native void reset(long r0);

    private static native boolean step(long r0);

    private WCDBException createException() {
        return WCDBException.createException(getError(((CppObject) this).cppObj));
    }

    public boolean checkPrepared() {
        return checkPrepared(((CppObject) this).cppObj);
    }

    public void clearBindings() {
        clearBindings(((CppObject) this).cppObj);
    }

    public void finalizeStatement() {
        finalize(((CppObject) this).cppObj);
    }

    public int getColumnCount() {
        if (this.columnCount != (-1)) goto L6;
        this.columnCount = getColumnCount(((CppObject) this).cppObj);
    L6:
        return this.columnCount;
    }

    public List<Value[]> getMultiRows() throws WCDBException {
        ArrayList r0 = new ArrayList();
        step();
    L4:
        if (isDone(((CppObject) this).cppObj) == true) goto L6;
        r0.add(getOneRow());
        step();
        goto L4
    L6:
        return r0;
    }

    public List<Value> getOneColumn() throws WCDBException {
        ArrayList r0 = new ArrayList();
        step();
    L4:
        if (isDone(((CppObject) this).cppObj) == true) goto L6;
        r0.add(getValue(0));
        step();
        goto L4
    L6:
        return r0;
    }

    public List<byte[]> getOneColumnBLOB() throws WCDBException {
        ArrayList r0 = new ArrayList();
        step();
    L4:
        if (isDone(((CppObject) this).cppObj) == true) goto L6;
        r0.add(getBLOB(0));
        step();
        goto L4
    L6:
        return r0;
    }

    public List<Double> getOneColumnDouble() throws WCDBException {
        ArrayList r0 = new ArrayList();
        step();
    L4:
        if (isDone(((CppObject) this).cppObj) == true) goto L6;
        r0.add(Double.valueOf(getDouble(0)));
        step();
        goto L4
    L6:
        return r0;
    }

    public List<Float> getOneColumnFloat() throws WCDBException {
        ArrayList r0 = new ArrayList();
        step();
    L4:
        if (isDone(((CppObject) this).cppObj) == true) goto L6;
        r0.add(Float.valueOf((float) getDouble(0)));
        step();
        goto L4
    L6:
        return r0;
    }

    public List<Integer> getOneColumnInt() throws WCDBException {
        ArrayList r0 = new ArrayList();
        step();
    L4:
        if (isDone(((CppObject) this).cppObj) == true) goto L6;
        r0.add(Integer.valueOf((int) getLong(0)));
        step();
        goto L4
    L6:
        return r0;
    }

    public List<Long> getOneColumnLong() throws WCDBException {
        ArrayList r0 = new ArrayList();
        step();
    L4:
        if (isDone(((CppObject) this).cppObj) == true) goto L6;
        r0.add(Long.valueOf(getLong(0)));
        step();
        goto L4
    L6:
        return r0;
    }

    public List<String> getOneColumnString() throws WCDBException {
        ArrayList r0 = new ArrayList();
        step();
    L4:
        if (isDone(((CppObject) this).cppObj) == true) goto L6;
        r0.add(getText(0));
        step();
        goto L4
    L6:
        return r0;
    }

    public boolean isDone() {
        return isDone(((CppObject) this).cppObj);
    }

    public boolean isReadOnly() {
        return isReadOnly(((CppObject) this).cppObj);
    }

    public void reset() {
        reset(((CppObject) this).cppObj);
    }

    public void step() throws WCDBException {
        if (step(((CppObject) this).cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public Value[] getOneRow() {
        int r0 = getColumnCount();
        int r1 = 0;
        if (r0 == 0) goto L5;
        Value[] r2 = new Value[r0];
    L7:
        if (r1 >= r0) goto L9;
        r2[r1] = getValue(r1);
        r1 = r1 + 1;
        goto L7
    L9:
        return r2;
    L5:
        return new Value[0];
    }

    static {
    }

    public PreparedStatement(long r2) {
        this.autoFinalize = false;
        this.columnCount = -1;
        ((CppObject) this).cppObj = r2;
    }

    public void bindNull(int r3) {
        bindNull(((CppObject) this).cppObj, r3);
    }

    public int bindParameterIndex(String r3) {
        return bindParameterIndex(((CppObject) this).cppObj, r3);
    }

    public void bindRow(Value[] r6) {
        int r0 = r6.length;
        int r2 = 0;
        int r3 = 1;
    L3:
        if (r2 >= r0) goto L5;
        bindValue(r6[r2], r3);
        r3 = r3 + 1;
        r2 = r2 + 1;
        goto L3
    }

    public <T> List<T> getAllObjects(Field<T>[] r2) throws WCDBException {
        return getAllObjects(r2, Field.getBindClass(r2));
    }

    public byte[] getBLOB(int r3) {
        return getBLOB(((CppObject) this).cppObj, r3);
    }

    public boolean getBool(int r5) {
        if (getInteger(((CppObject) this).cppObj, r5) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public byte getByte(int r3) {
        return (byte) getInteger(((CppObject) this).cppObj, r3);
    }

    public String getColumnName(int r3) {
        return getColumnName(((CppObject) this).cppObj, r3);
    }

    public String getColumnTableName(int r3) {
        return getColumnTableName(((CppObject) this).cppObj, r3);
    }

    public ColumnType getColumnType(int r3) {
        return ColumnType.valueOf(getColumnType(((CppObject) this).cppObj, r3));
    }

    public double getDouble(int r3) {
        return getDouble(((CppObject) this).cppObj, r3);
    }

    public float getFloat(int r3) {
        return (float) getDouble(((CppObject) this).cppObj, r3);
    }

    public int getInt(int r3) {
        return (int) getInteger(((CppObject) this).cppObj, r3);
    }

    public long getLong(int r3) {
        return getInteger(((CppObject) this).cppObj, r3);
    }

    public <T> T getOneObject(Field<T>[] r2) {
        return (T) getOneObject(r2, Field.getBindClass(r2));
    }

    public String getOriginalColumnName(int r3) {
        return getOriginalColumnName(((CppObject) this).cppObj, r3);
    }

    public short getShort(int r3) {
        return (short) getInteger(((CppObject) this).cppObj, r3);
    }

    public String getText(int r3) {
        return getText(((CppObject) this).cppObj, r3);
    }

    public Value getValue(int r4) {
        int r0 = getColumnType(((CppObject) this).cppObj, r4);
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 == 4) goto L13;
        return new Value();
    L13:
        return new Value(getBLOB(((CppObject) this).cppObj, r4));
    L15:
        return new Value(getText(((CppObject) this).cppObj, r4));
    L17:
        return new Value(getDouble(((CppObject) this).cppObj, r4));
    L19:
        return new Value(getInteger(((CppObject) this).cppObj, r4));
    }

    public void prepare(Statement r5) throws WCDBException {
        if (prepare(((CppObject) this).cppObj, CppObject.get(r5)) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void prepare(String r3) throws WCDBException {
        if (prepareSQL(((CppObject) this).cppObj, r3) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void bindBLOB(byte[] r3, int r4) {
        if (r3 != null) goto L5;
        bindNull(r4);
        return;
    L5:
        bindBLOB(((CppObject) this).cppObj, r3, r4);
    }

    public void bindBool(Boolean r5, int r6) {
        if (r5 == null) goto L8;
        long r0 = ((CppObject) this).cppObj;
        if (r5.booleanValue() == false) goto L6;
        long r2 = 1;
    L7:
        bindInteger(r0, r2, r6);
        return;
    L6:
        r2 = 0;
        goto L7
    L8:
        bindNull(r6);
    }

    public void bindDouble(Float r5, int r6) {
        if (r5 == null) goto L4;
        bindDouble(((CppObject) this).cppObj, r5.floatValue(), r6);
        return;
    L4:
        bindNull(r6);
    }

    public void bindInteger(Byte r5, int r6) {
        if (r5 == null) goto L4;
        bindInteger(((CppObject) this).cppObj, r5.byteValue(), r6);
        return;
    L4:
        bindNull(r6);
    }

    public <T> void bindObject(T r7, Field<T>[] r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r8.length == 0) goto L11;
        int r0 = 0;
        TableBinding<T> r1 = r8[0].getTableBinding();
        int r2 = r8.length;
        int r4 = 1;
    L7:
        if (r0 >= r2) goto L12;
        r1.bindField(r7, r8[r0], r4, this);
        r4 = r4 + 1;
        r0 = r0 + 1;
        goto L7
    L12:
        return;
    }

    public void bindText(String r3, int r4) {
        if (r3 != null) goto L5;
        bindNull(r4);
        return;
    L5:
        bindText(((CppObject) this).cppObj, r3, r4);
    }

    public void bindValue(Value r3, int r4) {
        if (r3 != null) goto L5;
        bindNull(r4);
        return;
    L5:
        int r0 = AnonymousClass1.$SwitchMap$com$tencent$wcdb$winq$ColumnType[r3.getType().ordinal()];
        if (r0 != 1) goto L8;
        bindInteger(r3.getLong(), r4);
        return;
    L8:
        if (r0 != 2) goto L10;
        bindDouble(r3.getDouble(), r4);
        return;
    L10:
        if (r0 != 3) goto L12;
        bindText(r3.getText(), r4);
        return;
    L12:
        if (r0 != 4) goto L14;
        bindBLOB(r3.getBLOB(), r4);
        return;
    L14:
        if (r0 != 5) goto L26;
        bindNull(r4);
        return;
    }

    public <T, R extends T> List<R> getAllObjects(Field<T>[] r5, Class<R> r6) throws WCDBException {
        TableBinding<T> r0 = r5[0].getTableBinding();
        ArrayList r1 = new ArrayList();
        step();
    L11:
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (isDone(((CppObject) this).cppObj) == true) goto L7;
        r1.add(r0.extractObject(r5, this, r6));     // Catch: ReflectiveOperationException -> L8
        step();     // Catch: ReflectiveOperationException -> L8
        goto L11
    L7:
        return r1;
    }

    public <T, R extends T> R getOneObject(Field<T>[] r2, Class<R> r3) {
        return (R) r2[0].getTableBinding().extractObject(r2, this, r3);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void bindBool(boolean r5, int r6) {
        long r0 = ((CppObject) this).cppObj;
        if (r5 == false) goto L5;
        long r2 = 1;
    L6:
        bindInteger(r0, r2, r6);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void bindDouble(Double r5, int r6) {
        if (r5 == null) goto L4;
        bindDouble(((CppObject) this).cppObj, r5.doubleValue(), r6);
        return;
    L4:
        bindNull(r6);
    }

    public void bindInteger(Integer r5, int r6) {
        if (r5 == null) goto L4;
        bindInteger(((CppObject) this).cppObj, r5.intValue(), r6);
        return;
    L4:
        bindNull(r6);
    }

    public <T> void bindObject(T r7, TableBinding<T> r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        Field<T>[] r0 = r8.allBindingFields();
        int r1 = r0.length;
        int r3 = 0;
        int r4 = 1;
    L5:
        if (r3 >= r1) goto L7;
        r8.bindField(r7, r0[r3], r4, this);
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L5
    }

    public void bindDouble(float r5, int r6) {
        bindDouble(((CppObject) this).cppObj, r5, r6);
    }

    public void bindInteger(Short r5, int r6) {
        if (r5 == null) goto L4;
        bindInteger(((CppObject) this).cppObj, r5.shortValue(), r6);
        return;
    L4:
        bindNull(r6);
    }

    public void bindDouble(double r3, int r5) {
        bindDouble(((CppObject) this).cppObj, r3, r5);
    }

    public void bindInteger(Long r5, int r6) {
        if (r5 == null) goto L4;
        bindInteger(((CppObject) this).cppObj, r5.longValue(), r6);
        return;
    L4:
        bindNull(r6);
    }

    public void bindInteger(byte r5, int r6) {
        bindInteger(((CppObject) this).cppObj, r5, r6);
    }

    public void bindInteger(int r5, int r6) {
        bindInteger(((CppObject) this).cppObj, r5, r6);
    }

    public void bindInteger(short r5, int r6) {
        bindInteger(((CppObject) this).cppObj, r5, r6);
    }

    public void bindInteger(long r3, int r5) {
        bindInteger(((CppObject) this).cppObj, r3, r5);
    }

    public <T> void bindObject(T r2, Field<T> r3, int r4) {
        if (r2 != null) goto L5;
        bindNull(r4);
        return;
    L5:
        r3.getTableBinding().bindField(r2, r3, r4, this);
    }
}
