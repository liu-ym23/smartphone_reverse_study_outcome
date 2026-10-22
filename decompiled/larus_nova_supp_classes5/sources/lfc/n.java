package lfc;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n implements kfc.a {
    public static final String[] b = null;
    public final d a;

    static {
        b = new String[]{DBDefinition.ID, "class"};
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.sec.android.app.launcher", "com.sec.android.app.twlauncher"});
    }

    public n() {
        this.a = new d();
    }

    public static void c(ContentResolver r18, Uri r19, ContentValues r20) throws RedBadgerException {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L20;
        Uri r5 = (Uri) r4.b;
        return;
    L20:
        r18.insert(r19, r20);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static ContentValues f(ComponentName r2, int r3, boolean r4) {
        ContentValues r0 = new ContentValues();
        if (r4 == false) goto L5;
        r0.put("package", r2.getPackageName());
        r0.put("class", r2.getClassName());
    L5:
        r0.put("badgecount", Integer.valueOf(r3));
        return r0;
    }

    @Override // kfc.a
    public final void a(Context r10, ComponentName r11, int r12) throws RedBadgerException {
        if (r10 == null) goto L38;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r12 >= 0) goto L9;
        r12 = 0;
    L9:
        if (this.a != null) goto L11;
    L13:
        Uri r1 = UriProtector.parse("content://com.sec.badge/apps?notify=true");
        ContentResolver r13 = r10.getContentResolver();
        Cursor r2 = null;
        r2 = d(r13, r1, b, new String[]{r11.getPackageName()});     // Catch: Throwable -> L29
        if (r2 == null) goto L24;
        String r3 = r11.getClassName();     // Catch: Throwable -> L29
        boolean r5 = false;
    L18:
        if (r2.moveToNext() == false) goto L22;
        int r6 = r2.getInt(0);     // Catch: Throwable -> L29
        e(r13, r1, f(r11, r12, false), new String[]{String.valueOf(r6)});     // Catch: Throwable -> L29
        if (r3.equals(r2.getString(r2.getColumnIndex("class"))) == false) goto L18;
        r5 = true;
        goto L18
    L22:
        if (r5 == true) goto L24;
        c(r13, r1, f(r11, r12, true));     // Catch: Throwable -> L29
    L24:
        if (r2 != null) goto L26;
        return;
    L26:
        if (r2.isClosed() == true) goto L50;
        r2.close();
        return;
    L50:
        return;
    L29:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L32
        throw new RedBadgerException(th.getMessage());     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        if (r2 != null) goto L35;
    L37:
        throw th;
    L35:
        if (r2.isClosed() == true) goto L37;
        r2.close();
        goto L37
    L11:
        if (nfc.a.a(r10, new Intent("android.intent.action.BADGE_COUNT_UPDATE")) == false) goto L13;
        this.a.a(r10, r11, r12);
        return;
    }

    public static Cursor d(ContentResolver r15, Uri r16, String[] r17, String[] r18) throws RedBadgerException {
        f06.c r12 = new f06.c();
        Object[] r13 = {r16, r17, "package=?", r18, null};
        f06.b r14 = new f06.b();
        f06.d r0 = r12.b(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r15, r13, "android.database.Cursor", r14);
        if (r0.a == false) goto L6;
        r12.a(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r15, r13, null, r14, false);
        return (Cursor) r0.b;
    L6:
        Cursor r1 = r15.query(r16, r17, "package=?", r18, null);
        r12.a(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r15, r13, r1, r14, true);
        return r1;
    }

    public static void e(ContentResolver r22, Uri r23, ContentValues r24, String[] r25) throws RedBadgerException {
        ArrayList r3 = new ArrayList();
        Object[] r4 = {r23, r24, "_id=?", r25};
        f06.b r15 = new f06.b();
        g06.a r5 = (g06.a) ApiHookConfig.b.get(240018);
        if (r5 == null) goto L5;
        f06.a[] r6 = r5.i;
    L6:
        f06.a[] r12 = r6;
        int r11 = r12.length;
        int r10 = 0;
    L8:
        if (r10 >= r11) goto L15;
        f06.a r9 = r12[r10];
        int r19 = r10;
        int r20 = r11;
        f06.a[] r21 = r12;
        f06.d r7 = r9.preInvoke(240018, "android/content/ContentResolver", "update", r22, r4, "int", r15);     // Catch: Exception -> L22
        if (r7.a == true) goto L17;
        r3.add(r9);     // Catch: Exception -> L22
    L17:
        if (r7.a == false) goto L20;
        ((Integer) r7.b).intValue();
        return;
    L20:
        r22.update(r23, r24, "_id=?", r25);
        return;
    L14:
        r10 = r19 + 1;
        r11 = r20;
        r12 = r21;
        goto L8
    L15:
        r7 = new f06.d(false, null);
        goto L17
    L5:
        r6 = ApiHookConfig.d;
        goto L6
    }
}
