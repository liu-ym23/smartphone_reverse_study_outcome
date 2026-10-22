package com.obric.cae.location.cell;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final File f7028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7029b = 0;
    public static final ExecutorService c = null;
    public static final AtomicBoolean d = null;

    static {
        f7028a = new File("/data/vendor/tombstones/rfs/lpass/caecellpoi");
        String r0 = Build.TYPE;
        if ("userdebug".equals(r0) == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        int r2 = 5;
    L12:
        f7029b = r2;
        c = Executors.newSingleThreadExecutor();
        d = new AtomicBoolean(false);
        return;
    L11:
        r2 = 0;
        goto L12
    L5:
        if ("eng".equals(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean a(Context r4) {
        final Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (d.compareAndSet(false, true) == true) goto L10;
        return true;
    L10:
        c.execute(new $$Lambda$IrZRFcI_OdAn6pG6nZCeB5lkjwI(r5));     // Catch: Throwable -> L7
        return true;
    L7:
        th = move-exception;
        d.set(false);
        com.obric.cae.log.a.a("StarLocation-cellpoi-db", "refreshToRfsAsync schedule failed", th);
        return false;
    }

    public static boolean a(File r24, File r25) {
        File r0 = r25.getParentFile();
        if (r0 == null) goto L10;
        if (r0.exists() == true) goto L10;
        if (r0.mkdirs() == true) goto L10;
        return false;
    L10:
        if (r25.exists() == true) goto L151;
        File r9 = new File(r25.getAbsolutePath() + ".tmp");
        FileInputStream r10 = new FileInputStream(r24);     // Catch: Throwable -> L132
        FileOutputStream r11 = new FileOutputStream(r9);     // Catch: Throwable -> L124
        FileChannel r18 = r10.getChannel();     // Catch: Throwable -> L116
        FileChannel r19 = r11.getChannel();     // Catch: Throwable -> L107
        long r20 = r18.size();     // Catch: Throwable -> L98
        long r22 = 0;
    L78:
        if (r22 >= r20) goto L83;
        long r12 = r18.transferTo(r22, r20 - r22, r19);     // Catch: Throwable -> L98
        if (r12 <= 0) goto L83;
        r22 = r22 + r12;     // Catch: Throwable -> L98
    L83:
        r11.getFD().sync();     // Catch: Throwable -> L98
        if (r19 == null) goto L86;
        r19.close();     // Catch: Throwable -> L107
    L86:
        r18.close();     // Catch: Throwable -> L116
        r11.close();     // Catch: Throwable -> L124
        r10.close();     // Catch: Throwable -> L132
    L94:
        th = move-exception;
        com.obric.cae.log.a.a("StarLocation-cellpoi-db", "copyFileAtomically finalize failed: dest=" + r25.getAbsolutePath(), th);
        r9.delete();     // Catch: Throwable -> L136
    L97:
        return false;
    L90:
        if (r9.renameTo(r25) == true) goto L93;
        com.obric.cae.log.a.g("StarLocation-cellpoi-db", "copyFileAtomically: rename failed tmp=" + r9.getAbsolutePath() + " dest=" + r25.getAbsolutePath());     // Catch: Throwable -> L94
        r9.delete();     // Catch: Throwable -> L94
        return false;
    L93:
        return true;
    L98:
        th = move-exception;
        if (r19 == null) goto L185;
        r19.close();     // Catch: Throwable -> L103
    L186:
        throw th;     // Catch: Throwable -> L107
    L103:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L107
        throw th;     // Catch: Throwable -> L107
    L185:
        throw th;     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        if (r18 == null) goto L187;
        r18.close();     // Catch: Throwable -> L112
    L188:
        throw th;     // Catch: Throwable -> L116
    L112:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L116
        throw th;     // Catch: Throwable -> L116
    L187:
        throw th;     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L120
    L189:
        throw th;     // Catch: Throwable -> L124
    L120:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L124
        throw th;     // Catch: Throwable -> L124
    L124:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L128
    L190:
        throw th;     // Catch: Throwable -> L132
    L128:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L132
        throw th;     // Catch: Throwable -> L132
    L132:
        th = move-exception;
        com.obric.cae.log.a.a("StarLocation-cellpoi-db", "copyFileAtomically failed: " + r24.getAbsolutePath() + " -> " + r25.getAbsolutePath(), th);
        r9.delete();     // Catch: Throwable -> L137
    L135:
        return false;
    L151:
        FileInputStream r13 = new FileInputStream(r24);     // Catch: Throwable -> L68
        FileOutputStream r14 = new FileOutputStream(r25, false);     // Catch: Throwable -> L60
        FileChannel r17 = r13.getChannel();     // Catch: Throwable -> L52
        FileChannel r15 = r14.getChannel();     // Catch: Throwable -> L43
        r15.truncate(0);     // Catch: Throwable -> L33
        long r110 = r17.size();     // Catch: Throwable -> L33
        long r21 = 0;
    L18:
        if (r21 >= r110) goto L24;
        FileChannel r23 = r15;
        long r16 = r17.transferTo(r21, r110 - r21, r23);     // Catch: Throwable -> L31
        if (r16 <= 0) goto L25;
        r21 = r21 + r16;     // Catch: Throwable -> L31
        r15 = r23;
    L25:
        r14.getFD().sync();     // Catch: Throwable -> L31
        r23.close();     // Catch: Throwable -> L43
        r17.close();     // Catch: Throwable -> L52
        r14.close();     // Catch: Throwable -> L60
        r13.close();     // Catch: Throwable -> L68
        return true;
    L31:
        th = th;
    L35:
        Throwable r4 = th;
        if (r23 == null) goto L178;
        r23.close();     // Catch: Throwable -> L39
    L179:
        throw r4;     // Catch: Throwable -> L43
    L39:
        th = move-exception;
        r4.addSuppressed(th);     // Catch: Throwable -> L43
        throw r4;     // Catch: Throwable -> L43
    L178:
        throw r4;     // Catch: Throwable -> L43
    L24:
        r23 = r15;
    L33:
        th = th;
        r23 = r15;
    L43:
        th = move-exception;
        if (r17 == null) goto L180;
        r17.close();     // Catch: Throwable -> L48
    L181:
        throw th;     // Catch: Throwable -> L52
    L48:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L180:
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L56
    L182:
        throw th;     // Catch: Throwable -> L60
    L56:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L60
        throw th;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L64
    L183:
        throw th;     // Catch: Throwable -> L68
    L64:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L68
        throw th;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        com.obric.cae.log.a.a("StarLocation-cellpoi-db", "copyFileOverwrite failed: " + r24.getAbsolutePath() + " -> " + r25.getAbsolutePath(), th);
        return false;
    }

    public static boolean b(Context r2) {
        return c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public static boolean c(Context r19) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        File r4 = r3.getDatabasePath("near_cell.db");
        if (r4 != null) goto L5;
    L65:
        StringBuilder r0 = new StringBuilder("exportStoreCellIdToRfs: src db missing: ");
        if (r4 != null) goto L68;
        String r1 = "null";
    L69:
        com.obric.cae.log.a.g("StarLocation-cellpoi-db", r0.append(r1).toString());
        return false;
    L68:
        r1 = r4.getAbsolutePath();
        goto L69
    L5:
        if (r4.exists() == false) goto L65;
        File r7 = f7028a;
        if (r7.exists() == true) goto L11;
        com.obric.cae.log.a.i("StarLocation-cellpoi-db", "exportStoreCellIdToRfs: destDir missing: " + r7.getAbsolutePath());
        return false;
    L11:
        HashSet r8 = new HashSet();
        long[] r9 = new long[1024];
        File r5 = r3.getDatabasePath("store_cellid.bin");
        SQLiteDatabase r6 = SQLiteDatabase.openDatabase(r4.getAbsolutePath(), null, 1);     // Catch: Throwable -> L62
        Cursor r10 = r6.query("cells_info", new String[]{"type", "lac", "cid"}, null, null, null, null, null);     // Catch: Throwable -> L53
        int r2 = r10.getColumnIndexOrThrow("type");     // Catch: Throwable -> L44
        int r11 = r10.getColumnIndexOrThrow("lac");     // Catch: Throwable -> L44
        int r12 = r10.getColumnIndexOrThrow("cid");     // Catch: Throwable -> L44
        int r13 = 0;
        int r14 = 0;
    L15:
        if (r10.moveToNext() == false) goto L32;
        String r15 = r10.getString(r2);     // Catch: Throwable -> L44
        long r16 = r10.getLong(r11);     // Catch: Throwable -> L44
        HashSet r17 = r8;
        long r18 = r10.getLong(r12);     // Catch: Throwable -> L44
        int r110 = r12;
        if (r13 >= f7029b) goto L21;
        com.obric.cae.log.a.e("StarLocation-cellpoi-db", "near_cell member: type=" + r15 + ", lac=" + r16 + ", cid=" + r18);     // Catch: Throwable -> L44
        r13 = r13 + 1;     // Catch: Throwable -> L44
    L21:
        int r20 = d.a(r15);     // Catch: Throwable -> L44
        if (r20 > 0) goto L24;
        r8 = r17;
    L26:
        r12 = r110;
        r11 = r11;
        goto L15
    L24:
        long r21 = d.a(r18, r16, r20);     // Catch: Throwable -> L44
        r8 = r17;
        if (r8.add(Long.valueOf(r21)) == false) goto L26;
        if (r14 < r9.length) goto L30;
        long[] r22 = new long[r9.length * 2];     // Catch: Throwable -> L44
        System.arraycopy(r9, 0, r22, 0, r9.length);     // Catch: Throwable -> L44
        r9 = r22;
    L30:
        int r23 = r14 + 1;     // Catch: Throwable -> L44
        r9[r14] = r21;     // Catch: Throwable -> L44
        r14 = r23;
        goto L26
    L32:
        r10.close();     // Catch: Throwable -> L53
        r6.close();     // Catch: Throwable -> L62
        com.obric.cae.log.a.e("StarLocation-cellpoi-db", com.obric.cae.location.b.a("exportStoreCellIdToRfs: printed=", r13, ", bloom_key_count=", r14, ", bloom_out=").append(r5.getAbsolutePath()).toString());
        if (d.a(r5, r9, r14) == true) goto L38;
        return false;
    L38:
        File r24 = new File(f7028a, r5.getName());
        if (r24.exists() == true) goto L42;
        com.obric.cae.log.a.g("StarLocation-cellpoi-db", "exportStoreCellIdToRfs: skip store_cellid.bin copy because dest missing: " + r24.getAbsolutePath());
        return false;
    L42:
        boolean r25 = a(r5, r24);
        com.obric.cae.log.a.e("StarLocation-cellpoi-db", "exportStoreCellIdToRfs: store_cellid.bin copy " + r5.getAbsolutePath() + " -> " + r24.getAbsolutePath() + ", success=" + r25);
        return r25;
    L44:
        th = move-exception;
        if (r10 == null) goto L83;
        r10.close();     // Catch: Throwable -> L49
    L84:
        throw th;     // Catch: Throwable -> L53
    L49:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L53
        throw th;     // Catch: Throwable -> L53
    L83:
        throw th;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        if (r6 == null) goto L85;
        r6.close();     // Catch: Throwable -> L58
    L86:
        throw th;     // Catch: Throwable -> L62
    L58:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L62
        throw th;     // Catch: Throwable -> L62
    L85:
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        com.obric.cae.log.a.a("StarLocation-cellpoi-db", "exportStoreCellIdToRfs failed", th);
        return false;
    }

    public static /* synthetic */ void d(Context r2) {
        b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        d.set(false);
        return;
    L6:
        th = move-exception;
        d.set(false);
        throw th;
    }
}
