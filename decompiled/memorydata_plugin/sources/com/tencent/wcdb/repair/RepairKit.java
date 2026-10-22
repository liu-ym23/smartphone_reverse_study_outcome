package com.tencent.wcdb.repair;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteCipherSpec;

/* JADX INFO: loaded from: classes6.dex */
public class RepairKit implements com.tencent.wcdb.support.a.InterfaceC0846a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f15878b;
    private a c;
    private RepairCursor d;

    /* JADX INFO: renamed from: com.tencent.wcdb.repair.RepairKit$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class RepairCursor extends com.tencent.wcdb.a {
        long g;

        private RepairCursor() {
        }

        /* synthetic */ RepairCursor(AnonymousClass1 r1) {
            this();
        }

        private static native byte[] nativeGetBlob(long r0, int r2);

        private static native int nativeGetColumnCount(long r0);

        private static native double nativeGetDouble(long r0, int r2);

        private static native long nativeGetLong(long r0, int r2);

        private static native String nativeGetString(long r0, int r2);

        private static native int nativeGetType(long r0, int r2);

        @Override // com.tencent.wcdb.a, android.database.Cursor
        public byte[] getBlob(int r3) {
            return nativeGetBlob(this.g, r3);
        }

        @Override // com.tencent.wcdb.a, android.database.Cursor
        public int getColumnCount() {
            return nativeGetColumnCount(this.g);
        }

        @Override // com.tencent.wcdb.a, android.database.Cursor
        public String[] getColumnNames() {
            throw new UnsupportedOperationException();
        }

        @Override // com.tencent.wcdb.a, com.tencent.wcdb.f, android.database.Cursor
        public int getCount() {
            throw new UnsupportedOperationException();
        }

        @Override // com.tencent.wcdb.f, android.database.Cursor
        public double getDouble(int r3) {
            return nativeGetDouble(this.g, r3);
        }

        @Override // android.database.Cursor
        public float getFloat(int r1) {
            return (float) getDouble(r1);
        }

        @Override // android.database.Cursor
        public int getInt(int r1) {
            return (int) getLong(r1);
        }

        @Override // com.tencent.wcdb.a, com.tencent.wcdb.f, android.database.Cursor
        public long getLong(int r3) {
            return nativeGetLong(this.g, r3);
        }

        @Override // android.database.Cursor
        public short getShort(int r1) {
            return (short) getLong(r1);
        }

        @Override // com.tencent.wcdb.a, com.tencent.wcdb.f, android.database.Cursor
        public String getString(int r3) {
            return nativeGetString(this.g, r3);
        }

        @Override // com.tencent.wcdb.a, com.tencent.wcdb.f, android.database.Cursor
        public int getType(int r3) {
            return nativeGetType(this.g, r3);
        }

        @Override // android.database.Cursor
        public boolean isNull(int r1) {
            if (getType(r1) != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public interface a {
        int a(String r1, int r2, Cursor r3);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f15879a;

        public void a() {
            long r0 = this.f15879a;
            if (r0 != 0) goto L5;
            return;
        L5:
            RepairKit.a(r0);
            this.f15879a = 0;
        }

        public void finalize() {
            a();
            super.finalize();
        }
    }

    static /* synthetic */ void a(long r0) {
        nativeFreeMaster(r0);
    }

    private static native void nativeCancel(long r0);

    private static native void nativeFini(long r0);

    private static native void nativeFreeMaster(long r0);

    private static native long nativeInit(String r0, byte[] r1, SQLiteCipherSpec r2, byte[] r3);

    private static native int nativeIntegrityFlags(long r0);

    private static native String nativeLastError();

    private static native long nativeLoadMaster(String r0, byte[] r1, String[] r2, byte[] r3);

    private static native long nativeMakeMaster(String[] r0);

    private native int nativeOutput(long r1, long r3, long r5, int r7);

    private static native boolean nativeSaveMaster(long r0, String r2, byte[] r3);

    private int onProgress(String r3, int r4, long r5) {
        if (this.c != null) goto L7;
        return 0;
    L7:
        if (this.d != null) goto L9;
        this.d = new RepairCursor(null);
    L9:
        this.d.g = r5;
        return this.c.a(r3, r4, this.d);
    }

    public void a() {
        b r0 = this.f15878b;
        if (r0 == null) goto L5;
        r0.a();
        this.f15878b = null;
    L5:
        long r1 = this.f15877a;
        if (r1 == 0) goto L9;
        nativeFini(r1);
        this.f15877a = 0;
        return;
    }

    @Override // com.tencent.wcdb.support.a.InterfaceC0846a
    public void c() {
        long r0 = this.f15877a;
        if (r0 != 0) goto L5;
        return;
    L5:
        nativeCancel(r0);
    }

    public void finalize() {
        a();
        super.finalize();
    }
}
