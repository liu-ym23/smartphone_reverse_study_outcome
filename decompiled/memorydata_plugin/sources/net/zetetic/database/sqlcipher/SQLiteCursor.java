package net.zetetic.database.sqlcipher;

import android.database.AbstractWindowedCursor;
import android.database.CursorWindow;
import android.os.Build;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import net.zetetic.database.DatabaseUtils;

/* JADX INFO: loaded from: classes6.dex */
public class SQLiteCursor extends AbstractWindowedCursor {
    private static final int CURSOR_WINDOW_EXTRA = 512;
    private static boolean CURSOR_WINDOW_NEEDS_RECREATED = false;
    private static final int DEFAULT_CURSOR_WINDOW_SIZE = 0;
    static final int NO_COUNT = -1;
    public static int PREFERRED_CURSOR_WINDOW_SIZE = 0;
    static final String TAG = "SQLiteCursor";
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount;
    private int mCursorWindowCapacity;
    private final SQLiteCursorDriver mDriver;
    private final String mEditTable;
    private final SQLiteQuery mQuery;

    static {
        int r0 = (int) (Math.pow(1024.0d, 2.0d) * 8.0d);
        DEFAULT_CURSOR_WINDOW_SIZE = r0;
        PREFERRED_CURSOR_WINDOW_SIZE = r0;
    }

    public SQLiteCursor(SQLiteCursorDriver r3, String r4, SQLiteQuery r5) {
        SQLiteCursorDriver r6 = (SQLiteCursorDriver) ZeusTransformUtils.wrapperContextForParams(r3, SQLiteCursorDriver.class, "com.obric.memorydata.plugin");
        this.mCount = -1;
        if (r5 == null) goto L7;
        this.mDriver = r6;
        this.mEditTable = r4;
        this.mColumnNameMap = null;
        this.mQuery = r5;
        this.mColumns = r5.getColumnNames();
        return;
    L7:
        throw new IllegalArgumentException("query object cannot be null");
    }

    @Deprecated
    public SQLiteCursor(SQLiteDatabase r2, SQLiteCursorDriver r3, String r4, SQLiteQuery r5) {
        this((SQLiteCursorDriver) ZeusTransformUtils.wrapperContextForParams(r3, SQLiteCursorDriver.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    private void awc_clearOrCreateWindow(String r8) {
        int r1 = PREFERRED_CURSOR_WINDOW_SIZE + 512;
        if (CURSOR_WINDOW_NEEDS_RECREATED == false) goto L5;
        awc_closeWindow();
        CURSOR_WINDOW_NEEDS_RECREATED = false;
    L5:
        CursorWindow r2 = getWindow();
        if (r2 == null) goto L8;
        r2.clear();
        return;
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L20;
        CursorWindow r0 = new CursorWindow(r8, r1);
    L17:
        setWindow(r0);
        return;
    L20:
        Field r3 = CursorWindow.class.getDeclaredField("sCursorWindowSize");     // Catch: Exception -> L14
        if (r3 == null) goto L16;
        r3.setAccessible(true);     // Catch: Exception -> L14
        r3.set(null, Integer.valueOf(r1));     // Catch: Exception -> L14
        Log.i(TAG, String.format("Set CursorWindow allocation size to %s", new Object[]{Integer.valueOf(r1)}));     // Catch: Exception -> L14
    L16:
        r0 = new CursorWindow(r8);
    L14:
        e = move-exception;
        Log.e(TAG, "Failed to override CursorWindow allocation size", e);
        goto L16
    }

    private void awc_closeWindow() {
        setWindow(null);
    }

    private void fillWindow(int r6) {
        awc_clearOrCreateWindow(getDatabase().getPath());
    L10:
        e = move-exception;
        awc_closeWindow();
        throw e;
    L4:
        if (this.mCount != (-1)) goto L8;
        this.mCount = this.mQuery.fillWindow(this.mWindow, DatabaseUtils.a(r6, 0), r6, true);     // Catch: RuntimeException -> L10
        this.mCursorWindowCapacity = this.mWindow.getNumRows();     // Catch: RuntimeException -> L10
        if (Log.isLoggable(TAG, 3) == false) goto L14;
        Log.d(TAG, "received count(*) from native_fill_window: " + this.mCount);     // Catch: RuntimeException -> L10
        return;
    L14:
        return;
    L8:
        this.mQuery.fillWindow(this.mWindow, DatabaseUtils.a(r6, this.mCursorWindowCapacity), r6, false);     // Catch: RuntimeException -> L10
    }

    public static void resetCursorWindowSize() {
        PREFERRED_CURSOR_WINDOW_SIZE = DEFAULT_CURSOR_WINDOW_SIZE;
        CURSOR_WINDOW_NEEDS_RECREATED = true;
    }

    public static void setCursorWindowSize(int r0) {
        PREFERRED_CURSOR_WINDOW_SIZE = r0;
        CURSOR_WINDOW_NEEDS_RECREATED = true;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        monitor-enter(this);
        this.mQuery.close();     // Catch: Throwable -> L7
        this.mDriver.cursorClosed();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        this.mDriver.cursorDeactivated();
    }

    @Override // android.database.AbstractCursor
    public void finalize() {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.mWindow == null) goto L5;
        close();     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getColumnIndex(String r7) {
        if (this.mColumnNameMap != null) goto L8;
        String[] r0 = this.mColumns;
        int r1 = r0.length;
        HashMap r2 = new HashMap(r1, 1.0f);
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L7;
        r2.put(r0[r3], Integer.valueOf(r3));
        r3 = r3 + 1;
        goto L5
    L7:
        this.mColumnNameMap = r2;
    L8:
        int r4 = r7.lastIndexOf(46);
        if (r4 == (-1)) goto L11;
        Log.e(TAG, "requesting column name with table name -- " + r7, new Exception());
        r7 = r7.substring(r4 + 1);
    L11:
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(this.mColumnNameMap.get(r7), Integer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L14;
        return -1;
    L14:
        return r6.intValue();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        if (this.mCount != (-1)) goto L6;
        fillWindow(0);
    L6:
        return this.mCount;
    }

    public SQLiteDatabase getDatabase() {
        return this.mQuery.getDatabase();
    }

    @Override // android.database.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int r2, int r3) {
        if (this.mWindow != null) goto L5;
    L8:
        fillWindow(r3);
        return true;
    L5:
        if (r3 < this.mWindow.getStartPosition()) goto L8;
        if (r3 >= (this.mWindow.getStartPosition() + this.mWindow.getNumRows())) goto L8;
        return true;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean requery() {
        if (isClosed() == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.mQuery.getDatabase().isOpen() == true) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L11:
        if (this.mWindow == null) goto L13;
        this.mWindow.clear();     // Catch: Throwable -> L20
    L13:
        this.mPos = -1;     // Catch: Throwable -> L20
        this.mCount = -1;     // Catch: Throwable -> L20
        this.mDriver.cursorRequeried(this);     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return super.requery();
    L17:
        e = move-exception;
        Log.w(TAG, "requery() failed " + e.getMessage(), e);
        return false;
    }

    public void setSelectionArguments(String[] r1) {
        this.mDriver.setBindArguments(r1);
    }

    @Override // android.database.AbstractWindowedCursor
    public void setWindow(CursorWindow r1) {
        super.setWindow(r1);
        this.mCount = -1;
    }
}
