package com.tencent.wcdb;

import android.database.CharArrayBuffer;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b extends a {
    protected CursorWindow g;

    public b() {
    }

    @Override // com.tencent.wcdb.a
    public void a() {
        super.a();
        c();
    }

    public void a(String r2) {
        CursorWindow r0 = this.g;
        if (r0 != null) goto L5;
        this.g = new CursorWindow(r2);
        return;
    L5:
        r0.clear();
    }

    @Override // com.tencent.wcdb.a
    public void b() {
        super.b();
        if (this.g == null) goto L6;
        return;
    L6:
        throw new StaleDataException("Attempting to access a closed CursorWindow.Most probable cause: cursor is deactivated prior to calling this method.");
    }

    public void c() {
        CursorWindow r0 = this.g;
        if (r0 == null) goto L6;
        r0.close();
        this.g = null;
        return;
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public void copyStringToBuffer(int r2, CharArrayBuffer r3) {
        b();
        this.g.copyStringToBuffer(this.f15821b, r2, r3);
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public byte[] getBlob(int r2) {
        b();
        return this.g.getBlob(this.f15821b, r2);
    }

    @Override // com.tencent.wcdb.f, android.database.Cursor
    public double getDouble(int r2) {
        b();
        return this.g.getDouble(this.f15821b, r2);
    }

    @Override // android.database.Cursor
    public float getFloat(int r2) {
        b();
        return this.g.getFloat(this.f15821b, r2);
    }

    @Override // android.database.Cursor
    public int getInt(int r2) {
        b();
        return this.g.getInt(this.f15821b, r2);
    }

    @Override // com.tencent.wcdb.a, com.tencent.wcdb.f, android.database.Cursor
    public long getLong(int r2) {
        b();
        return this.g.getLong(this.f15821b, r2);
    }

    @Override // android.database.Cursor
    public short getShort(int r2) {
        b();
        return this.g.getShort(this.f15821b, r2);
    }

    @Override // com.tencent.wcdb.a, com.tencent.wcdb.f, android.database.Cursor
    public String getString(int r2) {
        b();
        return this.g.getString(this.f15821b, r2);
    }

    @Override // com.tencent.wcdb.a, com.tencent.wcdb.f, android.database.Cursor
    public int getType(int r2) {
        b();
        return this.g.getType(this.f15821b, r2);
    }

    @Override // android.database.Cursor
    public boolean isNull(int r2) {
        b();
        if (this.g.getType(this.f15821b, r2) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
