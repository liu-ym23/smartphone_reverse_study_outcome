package com.obric.cae.location.cell;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.obric.cae.location.database.StarCellDbManager;
import com.obric.cae.log.CommSenseLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class CellPoiDbManager {
    private static final String COL_CID = "cid";
    private static final String COL_LAC = "lac";
    private static final String COL_TYPE = "type";
    private static final int PRINT_LIMIT = 0;
    private static final File RFS_DEST_DIR = null;
    private static final String TABLE_NAME_CELLS_INFO = "cells_info";
    private static final String TAG = "StarLocation-cellpoi-db";
    private static final ExecutorService sExecutor = null;
    private static final AtomicBoolean sRefreshScheduled = null;

    static {
        RFS_DEST_DIR = new File("/data/vendor/tombstones/rfs/lpass/caecellpoi");
        if (isUserDebugOrEngBuild() == false) goto L5;
        int r8 = 5;
    L6:
        PRINT_LIMIT = r8;
        sExecutor = Executors.newSingleThreadExecutor();
        sRefreshScheduled = new AtomicBoolean(false);
        return;
    L5:
        r8 = 0;
        goto L6
    }

    private CellPoiDbManager() {
    }

    public static /* synthetic */ void a(Context r8) {
        lambda$refreshToRfsAsync$0(r8);
    }

    private static boolean copyFileAtomically(File r21, File r22) {
        File r8 = r22.getParentFile();
        if (r8 == null) goto L10;
        if (r8.exists() == true) goto L10;
        if (r8.mkdirs() == true) goto L10;
        return false;
    L10:
        if (r22.exists() == true) goto L12;
        File r10 = new File(r22.getAbsolutePath() + ".tmp");
        FileInputStream r11 = new FileInputStream(r21);     // Catch: Throwable -> L89
        FileOutputStream r12 = new FileOutputStream(r10);     // Catch: Throwable -> L78
        FileChannel r13 = r11.getChannel();     // Catch: Throwable -> L67
        FileChannel r14 = r12.getChannel();     // Catch: Throwable -> L55
        long r15 = r13.size();     // Catch: Throwable -> L44
        long r19 = 0;
    L22:
        if (r19 >= r15) goto L27;
        long r16 = r13.transferTo(r19, r15 - r19, r14);     // Catch: Throwable -> L44
        if (r16 <= 0) goto L27;
        r19 = r19 + r16;     // Catch: Throwable -> L44
    L27:
        r12.getFD().sync();     // Catch: Throwable -> L44
        if (r14 == null) goto L30;
        r14.close();     // Catch: Throwable -> L55
    L30:
        r13.close();     // Catch: Throwable -> L67
        r12.close();     // Catch: Throwable -> L78
        r11.close();     // Catch: Throwable -> L89
    L40:
        th = move-exception;
        CommSenseLog.e(TAG, "copyFileAtomically finalize failed: dest=" + r22.getAbsolutePath(), th);
        r10.delete();     // Catch: Throwable -> L97
    L43:
        return false;
    L35:
        if (r10.renameTo(r22) == true) goto L38;
        CommSenseLog.w(TAG, "copyFileAtomically: rename failed tmp=" + r10.getAbsolutePath() + " dest=" + r22.getAbsolutePath());     // Catch: Throwable -> L40
        r10.delete();     // Catch: Throwable -> L40
        return false;
    L38:
        return true;
    L44:
        th = move-exception;
        if (r14 == null) goto L131;
        r14.close();     // Catch: Throwable -> L49
    L132:
        throw th;     // Catch: Throwable -> L53
    L49:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L53
        throw th;     // Catch: Throwable -> L53
    L53:
        th = th;
    L57:
        Throwable r17 = th;
        if (r13 == null) goto L133;
        r13.close();     // Catch: Throwable -> L61
    L134:
        throw r17;     // Catch: Throwable -> L65
    L61:
        th = move-exception;
        r17.addSuppressed(th);     // Catch: Throwable -> L65
        throw r17;     // Catch: Throwable -> L65
    L65:
        th = th;
    L69:
        Throwable r18 = th;
        r12.close();     // Catch: Throwable -> L72
    L135:
        throw r18;     // Catch: Throwable -> L76
    L76:
        th = th;
    L80:
        Throwable r20 = th;
        r11.close();     // Catch: Throwable -> L83
    L136:
        throw r20;     // Catch: Throwable -> L87
    L83:
        th = move-exception;
        r20.addSuppressed(th);     // Catch: Throwable -> L87
        throw r20;     // Catch: Throwable -> L87
    L87:
        th = th;
    L94:
        CommSenseLog.e(TAG, "copyFileAtomically failed: " + r21.getAbsolutePath() + " -> " + r22.getAbsolutePath(), th);
        r10.delete();     // Catch: Throwable -> L98
    L96:
        return false;
    L72:
        th = move-exception;
        r18.addSuppressed(th);     // Catch: Throwable -> L76
        throw r18;     // Catch: Throwable -> L76
    L133:
        throw r17;     // Catch: Throwable -> L65
    L131:
        throw th;     // Catch: Throwable -> L53
    L55:
        th = th;
    L67:
        th = th;
    L78:
        th = th;
    L89:
        th = th;
    L91:
        th = th;
        goto L94
    L12:
        return copyFileOverwrite(r21, r22);
    }

    private static boolean copyFileOverwrite(File r20, File r21) {
        FileInputStream r8 = new FileInputStream(r20);     // Catch: Throwable -> L65
        FileOutputStream r10 = new FileOutputStream(r21, false);     // Catch: Throwable -> L52
        FileChannel r12 = r8.getChannel();     // Catch: Throwable -> L44
        FileChannel r13 = r10.getChannel();     // Catch: Throwable -> L35
        r13.truncate(0);     // Catch: Throwable -> L26
        long r16 = r12.size();     // Catch: Throwable -> L26
        long r18 = 0;
    L14:
        if (r18 >= r16) goto L19;
        long r11 = r12.transferTo(r18, r16 - r18, r13);     // Catch: Throwable -> L26
        if (r11 <= 0) goto L19;
        r18 = r18 + r11;     // Catch: Throwable -> L26
    L19:
        r10.getFD().sync();     // Catch: Throwable -> L26
        r13.close();     // Catch: Throwable -> L35
        r12.close();     // Catch: Throwable -> L44
        r10.close();     // Catch: Throwable -> L52
        r8.close();     // Catch: Throwable -> L63
        return true;
    L26:
        th = move-exception;
        if (r13 == null) goto L93;
        r13.close();     // Catch: Throwable -> L31
    L94:
        throw th;     // Catch: Throwable -> L35
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L93:
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        if (r12 == null) goto L95;
        r12.close();     // Catch: Throwable -> L40
    L96:
        throw th;     // Catch: Throwable -> L44
    L40:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L44
        throw th;     // Catch: Throwable -> L44
    L95:
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L48
    L97:
        throw th;     // Catch: Throwable -> L52
    L48:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L52:
        th = th;
    L56:
        Throwable r14 = th;
        r8.close();     // Catch: Throwable -> L59
    L98:
        throw r14;     // Catch: Throwable -> L63
    L59:
        th = move-exception;
        r14.addSuppressed(th);     // Catch: Throwable -> L63
        throw r14;     // Catch: Throwable -> L63
    L54:
        th = th;
    L63:
        th = th;
    L70:
        CommSenseLog.e(TAG, "copyFileOverwrite failed: " + r20.getAbsolutePath() + " -> " + r21.getAbsolutePath(), th);
        return false;
    L65:
        th = th;
    L67:
        th = th;
        goto L70
    }

    public static boolean exportStoreCellIdToRfs(Context r19) {
        File r8 = r19.getDatabasePath(StarCellDbManager.NEAR_CELL_DB_NAME);
        int r10 = 0;
        if (r8 != null) goto L5;
    L64:
        StringBuilder r11 = new StringBuilder("exportStoreCellIdToRfs: src db missing: ");
        if (r8 != null) goto L67;
        String r12 = "null";
    L68:
        r11.append(r12);
        CommSenseLog.w(TAG, r11.toString());
        return false;
    L67:
        r12 = r8.getAbsolutePath();
        goto L68
    L5:
        if (r8.exists() == false) goto L64;
        File r13 = RFS_DEST_DIR;
        if (r13.exists() == true) goto L11;
        CommSenseLog.e(TAG, "exportStoreCellIdToRfs: destDir missing: " + r13.getAbsolutePath());
        return false;
    L11:
        HashSet r14 = new HashSet();
        long[] r15 = new long[1024];
        File r16 = r19.getDatabasePath("store_cellid.bin");
        SQLiteDatabase r17 = SQLiteDatabase.openDatabase(r8.getAbsolutePath(), null, 1);     // Catch: Throwable -> L62
        Cursor r18 = r17.query("cells_info", new String[]{"type", "lac", "cid"}, null, null, null, null, null);     // Catch: Throwable -> L53
        int r20 = r18.getColumnIndexOrThrow("type");     // Catch: Throwable -> L44
        int r21 = r18.getColumnIndexOrThrow("lac");     // Catch: Throwable -> L44
        int r22 = r18.getColumnIndexOrThrow("cid");     // Catch: Throwable -> L44
        long[] r110 = r15;
        int r23 = 0;
    L15:
        if (r18.moveToNext() == false) goto L33;
        String r111 = r18.getString(r20);     // Catch: Throwable -> L44
        long r112 = r18.getLong(r21);     // Catch: Throwable -> L44
        long r113 = r18.getLong(r22);     // Catch: Throwable -> L44
        r22 = r22;
        if (r10 >= PRINT_LIMIT) goto L21;
        CommSenseLog.i(TAG, "near_cell member: type=" + r111 + ", lac=" + r112 + ", cid=" + r113);     // Catch: Throwable -> L44
        r10 = r10 + 1;     // Catch: Throwable -> L44
    L21:
        int r24 = StoreCellIdBloomFilterWriter.typeToRat(r111);     // Catch: Throwable -> L44
        if (r24 <= 0) goto L27;
        long r25 = StoreCellIdBloomFilterWriter.makeKeyU64(r113, r112, r24);     // Catch: Throwable -> L44
        if (r14.add(Long.valueOf(r25)) == false) goto L27;
        if (r23 < r110.length) goto L31;
        long[] r114 = new long[r110.length * 2];     // Catch: Throwable -> L44
        System.arraycopy(r110, 0, r114, 0, r110.length);     // Catch: Throwable -> L44
        r110 = r114;
    L31:
        int r115 = r23 + 1;     // Catch: Throwable -> L44
        r110[r23] = r25;     // Catch: Throwable -> L44
        r23 = r115;
    L27:
        r21 = r21;
        goto L15
    L33:
        r18.close();     // Catch: Throwable -> L53
        r17.close();     // Catch: Throwable -> L62
        StringBuilder r26 = defpackage.a.g("exportStoreCellIdToRfs: printed=", r10, ", bloom_key_count=", r23, ", bloom_out=");
        r26.append(r16.getAbsolutePath());
        CommSenseLog.i(TAG, r26.toString());
        if (StoreCellIdBloomFilterWriter.writeBloomBin(r16, r110, r23) == true) goto L39;
        return false;
    L39:
        File r27 = new File(RFS_DEST_DIR, r16.getName());
        if (r27.exists() == true) goto L42;
        r11 = new StringBuilder("exportStoreCellIdToRfs: skip store_cellid.bin copy because dest missing: ");
        r12 = r27.getAbsolutePath();
        goto L68
    L42:
        boolean r28 = copyFileAtomically(r16, r27);
        CommSenseLog.i(TAG, "exportStoreCellIdToRfs: store_cellid.bin copy " + r16.getAbsolutePath() + " -> " + r27.getAbsolutePath() + ", success=" + r28);
        return r28;
    L44:
        th = move-exception;
        if (r18 == null) goto L82;
        r18.close();     // Catch: Throwable -> L49
    L83:
        throw th;     // Catch: Throwable -> L53
    L49:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L53
        throw th;     // Catch: Throwable -> L53
    L82:
        throw th;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        if (r17 == null) goto L84;
        r17.close();     // Catch: Throwable -> L58
    L85:
        throw th;     // Catch: Throwable -> L62
    L58:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L62
        throw th;     // Catch: Throwable -> L62
    L84:
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        CommSenseLog.e(TAG, "exportStoreCellIdToRfs failed", th);
        return false;
    }

    private static boolean isUserDebugOrEngBuild() {
        String r8 = Build.TYPE;
        if ("userdebug".equals(r8) == false) goto L5;
    L8:
        return true;
    L5:
        if ("eng".equals(r8) == true) goto L8;
        return false;
    }

    private static /* synthetic */ void lambda$refreshToRfsAsync$0(Context r8) {
        refreshToRfs(r8);     // Catch: Throwable -> L6
        sRefreshScheduled.set(false);
        return;
    L6:
        th = move-exception;
        sRefreshScheduled.set(false);
        throw th;
    }

    public static boolean refreshToRfs(Context r8) {
        return exportStoreCellIdToRfs(r8);
    }

    public static boolean refreshToRfsAsync(Context r8) {
        final Context r10 = r8.getApplicationContext();
        if (sRefreshScheduled.compareAndSet(false, true) == true) goto L10;
        return true;
    L10:
        sExecutor.execute(new a(r10));     // Catch: Throwable -> L7
        return true;
    L7:
        th = move-exception;
        sRefreshScheduled.set(false);
        CommSenseLog.e(TAG, "refreshToRfsAsync schedule failed", th);
        return false;
    }
}
