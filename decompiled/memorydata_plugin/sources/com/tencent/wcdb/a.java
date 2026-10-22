package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.wcdb.support.Log;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    protected HashMap<Long, Map<String, Object>> f15820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f15821b;

    @Deprecated
    protected int c;

    @Deprecated
    protected Long d;
    protected boolean e;
    protected ContentResolver f;
    private Uri g;
    private final Object h;
    private ContentObserver i;
    private boolean j;
    private final DataSetObservable k;
    private final ContentObservable l;
    private Bundle m;

    /* JADX INFO: renamed from: com.tencent.wcdb.a$a, reason: collision with other inner class name */
    protected static class C0844a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<a> f15822a;

        public C0844a(a r2) {
            super(null);
            this.f15822a = new WeakReference(r2);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return false;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r2) {
            a r1 = (a) ZeusTransformUtils.preCheckCast(this.f15822a.get(), a.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L6;
            r1.a(false);
            return;
        }
    }

    public a() {
        this.h = new Object();
        this.k = new DataSetObservable();
        this.l = new ContentObservable();
        this.m = Bundle.EMPTY;
        this.f15821b = -1;
        this.c = -1;
        this.d = null;
        this.f15820a = new HashMap();
    }

    public void a() {
        ContentObserver r0 = this.i;
        if (r0 == null) goto L5;
        ZeusProviderTransform.unregisterContentObserver(this.f, r0, "com.obric.memorydata.plugin");
        this.j = false;
    L5:
        this.k.notifyInvalidated();
    }

    public void a(boolean r4) {
        Object r0 = this.h;
        monitor-enter(r0);
        this.l.dispatchChange(r4);     // Catch: Throwable -> L10
        Uri r1 = this.g;     // Catch: Throwable -> L10
        if (r1 == null) goto L8;
        if (r4 == false) goto L8;
        ZeusProviderTransform.notifyChange(this.f, r1, this.i, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean a(int r1, int r2) {
        return true;
    }

    public void b() {
        if ((-1) == this.f15821b) goto L8;
        if (getCount() == this.f15821b) goto L8;
        return;
    L8:
        throw new CursorIndexOutOfBoundsException(this.f15821b, getCount());
    }

    @Override // com.tencent.wcdb.f, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e = true;
        this.l.unregisterAll();
        a();
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int r4, CharArrayBuffer r5) {
        String r3 = getString(r4);
        if (r3 == null) goto L12;
        char[] r0 = r5.data;
        if (r0 != null) goto L7;
    L10:
        r5.data = r3.toCharArray();
    L11:
        r5.sizeCopied = r3.length();
        return;
    L7:
        if (r0.length < r3.length()) goto L10;
        r3.getChars(0, r3.length(), r0, 0);
        goto L11
    L12:
        r5.sizeCopied = 0;
    }

    @Override // android.database.Cursor
    public void deactivate() {
        a();
    }

    public void finalize() {
        ContentObserver r0 = this.i;
        if (r0 != null) goto L5;
    L12:
        if (this.e == true) goto L14;
        close();     // Catch: Exception -> L11
        return;
    L14:
        return;
    L15:
        return;
    L5:
        if (this.j != true) goto L12;
        ZeusProviderTransform.unregisterContentObserver(this.f, r0, "com.obric.memorydata.plugin");
        goto L12
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int r1) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        return getColumnNames().length;
    }

    @Override // com.tencent.wcdb.f, android.database.Cursor
    public int getColumnIndex(String r8) {
        int r0 = r8.lastIndexOf(46);
        int r1 = 0;
        if (r0 == (-1)) goto L5;
        Log.a("Cursor", "requesting column name with table name -- " + r8, new Object[]{new Exception()});
        r8 = r8.substring(r0 + 1);
    L5:
        String[] r7 = getColumnNames();
        int r2 = r7.length;
    L6:
        if (r1 >= r2) goto L11;
        if (r7[r1].equalsIgnoreCase(r8) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return r1;
    L11:
        return -1;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String r3) {
        int r2 = getColumnIndex(r3);
        if (r2 < 0) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("column '" + r3 + "' does not exist");
    }

    @Override // android.database.Cursor
    public String getColumnName(int r1) {
        return getColumnNames()[r1];
    }

    @Override // android.database.Cursor
    public abstract String[] getColumnNames();

    @Override // com.tencent.wcdb.f, android.database.Cursor
    public abstract int getCount();

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return this.m;
    }

    @Override // com.tencent.wcdb.f, android.database.Cursor
    public abstract long getLong(int r1);

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return this.g;
    }

    @Override // android.database.Cursor
    public final int getPosition() {
        return this.f15821b;
    }

    @Override // com.tencent.wcdb.f, android.database.Cursor
    public abstract String getString(int r1);

    @Override // com.tencent.wcdb.f, android.database.Cursor
    public int getType(int r1) {
        return 3;
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @Override // com.tencent.wcdb.f, android.database.Cursor
    public final boolean isAfterLast() {
        if (getCount() != 0) goto L6;
        return true;
    L6:
        if (this.f15821b == getCount()) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // android.database.Cursor
    public final boolean isBeforeFirst() {
        if (getCount() != 0) goto L6;
        return true;
    L6:
        if (this.f15821b == (-1)) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return this.e;
    }

    @Override // android.database.Cursor
    public final boolean isFirst() {
        if (this.f15821b == 0) goto L5;
    L7:
        return false;
    L5:
        if (getCount() == 0) goto L7;
        return true;
    }

    @Override // com.tencent.wcdb.f, android.database.Cursor
    public final boolean isLast() {
        int r0 = getCount();
        if (this.f15821b != (r0 - 1)) goto L6;
        if (r0 == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // android.database.Cursor
    public final boolean move(int r2) {
        return moveToPosition(this.f15821b + r2);
    }

    @Override // android.database.Cursor
    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    @Override // android.database.Cursor
    public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    @Override // com.tencent.wcdb.f, android.database.Cursor
    public final boolean moveToNext() {
        return moveToPosition(this.f15821b + 1);
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int r5) {
        int r0 = getCount();
        if (r5 < r0) goto L7;
        this.f15821b = r0;
        return false;
    L7:
        if (r5 >= 0) goto L10;
        this.f15821b = -1;
        return false;
    L10:
        int r1 = this.f15821b;
        if (r5 != r1) goto L14;
        return true;
    L14:
        boolean r2 = a(r1, r5);
        if (r2 == true) goto L17;
        this.f15821b = -1;
    L20:
        return r2;
    L17:
        this.f15821b = r5;
        int r6 = this.c;
        if (r6 == (-1)) goto L20;
        this.d = Long.valueOf(getLong(r6));
        goto L20
    }

    @Override // android.database.Cursor
    public final boolean moveToPrevious() {
        return moveToPosition(this.f15821b - 1);
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver r1) {
        this.l.registerObserver(r1);
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver r1) {
        this.k.registerObserver(r1);
    }

    @Override // android.database.Cursor
    public boolean requery() {
        ContentObserver r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        this.k.notifyChanged();
        return true;
    L5:
        if (this.j == true) goto L7;
        ZeusProviderTransform.registerContentObserver(this.f, this.g, true, r0, "com.obric.memorydata.plugin");
        this.j = true;
        goto L7
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle r1) {
        return Bundle.EMPTY;
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle r1) {
        if (r1 != null) goto L4;
        r1 = Bundle.EMPTY;
    L4:
        this.m = r1;
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver r5, Uri r6) {
        Object r0 = this.h;
        monitor-enter(r0);
        this.g = r6;     // Catch: Throwable -> L10
        this.f = r5;     // Catch: Throwable -> L10
        ContentObserver r7 = this.i;     // Catch: Throwable -> L10
        if (r7 == null) goto L7;
        ZeusProviderTransform.unregisterContentObserver(r5, r7, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        C0844a r8 = new C0844a(this);     // Catch: Throwable -> L10
        this.i = r8;     // Catch: Throwable -> L10
        ZeusProviderTransform.registerContentObserver(this.f, this.g, true, r8, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        this.j = true;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver r2) {
        if (this.e == true) goto L6;
        this.l.unregisterObserver(r2);
        return;
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver r1) {
        this.k.unregisterObserver(r1);
    }
}
