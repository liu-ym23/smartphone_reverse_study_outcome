package com.tencent.wcdb;

import android.content.OperationApplicationException;
import android.os.Parcel;
import com.tencent.wcdb.database.SQLiteAbortException;
import com.tencent.wcdb.database.SQLiteConstraintException;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteFullException;
import com.tencent.wcdb.database.m;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.text.Collator;

/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f15870a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Collator f15871b;

    static {
        f15870a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f15871b = null;
    }

    public static int a(int r0, int r1) {
        return Math.max(r0 - (r1 / 3), 0);
    }

    public static int a(Object r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        if ((r1 instanceof byte[]) == false) goto L10;
        return 4;
    L10:
        if (ZeusTransformUtils.instanceOf(r1, Float.class) == false) goto L12;
        return 2;
    L12:
        if (ZeusTransformUtils.instanceOf(r1, Double.class) == false) goto L15;
        return 2;
    L15:
        if (ZeusTransformUtils.instanceOf(r1, Long.class) == false) goto L17;
        return 1;
    L17:
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L19;
        return 1;
    L19:
        if (ZeusTransformUtils.instanceOf(r1, Short.class) == false) goto L21;
        return 1;
    L21:
        if (ZeusTransformUtils.instanceOf(r1, Byte.class) == true) goto L31;
        return 3;
    L31:
        return 1;
    }

    public static int a(String r3) {
        String r4 = r3.trim();
        if (r4.length() >= 3) goto L6;
        return 99;
    L6:
        switch(b(r4)) {
            case 4279873: goto L23;
            case 4280912: goto L21;
            case 4476485: goto L19;
            case 4477013: goto L17;
            case 4543043: goto L15;
            case 4670786: goto L13;
            case 4998468: goto L17;
            case 4998483: goto L11;
            case 5001042: goto L9;
            case 5066563: goto L19;
            case 5198404: goto L15;
            case 5260626: goto L17;
            case 5459529: goto L17;
            case 5522756: goto L23;
            case 5524545: goto L15;
            case 5526593: goto L8;
            default: goto L7;
        };
    L7:
        return 99;
    L8:
        return 3;
    L9:
        return 6;
    L11:
        return 1;
    L13:
        return 4;
    L15:
        return 8;
    L17:
        return 2;
    L19:
        return 5;
    L21:
        return 7;
    L23:
        return 9;
    }

    public static int a(String[] r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r4[r1].equals("_id") == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    public static long a(SQLiteDatabase r0, String r1, String[] r2) {
        m r3 = r0.b(r1);
        long r4 = a(r3, r2);     // Catch: Throwable -> L6
        r3.close();
        return r4;
    L6:
        th = move-exception;
        r3.close();
        throw th;
    }

    public static long a(m r0, String[] r1) {
        r0.a(r1);
        return r0.k();
    }

    public static final void a(Parcel r2) {
        int r0 = b(r2);
        if (r0 != 0) goto L5;
        return;
    L5:
        a(r2, r2.readString(), r0);
    }

    public static final void a(Parcel r6, Exception r7) {
        if (ZeusTransformUtils.instanceOf(r7, FileNotFoundException.class) == false) goto L6;
        boolean r5 = false;
        int r0 = 1;
    L36:
        r6.writeInt(r0);
        r6.writeString(r7.getMessage());
        if (r5 == false) goto L42;
        Log.a("WCDB.DatabaseUtils", "Writing exception to parcel", new Object[]{r7});
        return;
    L42:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, IllegalArgumentException.class) == false) goto L10;
        r0 = 2;
    L8:
        r5 = true;
        goto L36
    L10:
        if (ZeusTransformUtils.instanceOf(r7, UnsupportedOperationException.class) == false) goto L13;
        r0 = 3;
        goto L8
    L13:
        if (ZeusTransformUtils.instanceOf(r7, SQLiteAbortException.class) == false) goto L16;
        r0 = 4;
        goto L8
    L16:
        if (ZeusTransformUtils.instanceOf(r7, SQLiteConstraintException.class) == false) goto L19;
        r0 = 5;
        goto L8
    L19:
        if (ZeusTransformUtils.instanceOf(r7, SQLiteDatabaseCorruptException.class) == false) goto L22;
        r0 = 6;
        goto L8
    L22:
        if (ZeusTransformUtils.instanceOf(r7, SQLiteFullException.class) == false) goto L25;
        r0 = 7;
        goto L8
    L25:
        if (ZeusTransformUtils.instanceOf(r7, SQLiteDiskIOException.class) == false) goto L28;
        r0 = 8;
        goto L8
    L28:
        if (ZeusTransformUtils.instanceOf(r7, SQLiteException.class) == false) goto L31;
        r0 = 9;
        goto L8
    L31:
        if (ZeusTransformUtils.instanceOf(r7, OperationApplicationException.class) == false) goto L34;
        r0 = 10;
        goto L8
    L34:
        if (ZeusTransformUtils.instanceOf(r7, OperationCanceledException.class) == false) goto L40;
        r0 = 11;
        r5 = false;
        goto L36
    L40:
        r6.writeException(r7);
        Log.a("WCDB.DatabaseUtils", "Writing exception to parcel", new Object[]{r7});
    }

    private static final void a(Parcel r0, String r1, int r2) {
        switch(r2) {
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L18;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L8;
            case 10: goto L3;
            case 11: goto L6;
            default: goto L3;
        };
    L3:
        r0.readException(r2, r1);
        return;
    L6:
        throw new OperationCanceledException(r1);
    L8:
        throw new SQLiteException(r1);
    L10:
        throw new SQLiteDiskIOException(r1);
    L12:
        throw new SQLiteFullException(r1);
    L14:
        throw new SQLiteDatabaseCorruptException(r1);
    L16:
        throw new SQLiteConstraintException(r1);
    L18:
        throw new SQLiteAbortException(r1);
    L20:
        throw new UnsupportedOperationException(r1);
    L22:
        throw new IllegalArgumentException(r1);
    }

    public static boolean a(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    private static final int b(Parcel r2) {
        int r0 = r2.readInt();
        if (r0 == (-128)) goto L5;
        return r0;
    L5:
        if (r2.readInt() != 0) goto L10;
        Log.a("WCDB.DatabaseUtils", "Unexpected zero-sized Parcel reply header.");
        return 0;
    L10:
        return 0;
    }

    private static int b(String r5) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= 3) goto L14;
        int r3 = r5.charAt(r1);
        if (r3 < 97) goto L11;
        if (r3 > 122) goto L11;
        r3 = (r3 - 97) + 65;
    L13:
        r2 = r2 | ((r3 & 127) << (r1 * 8));
        r1 = r1 + 1;
    L11:
        if (r3 < 128) goto L13;
        return 0;
    L14:
        return r2;
    }
}
