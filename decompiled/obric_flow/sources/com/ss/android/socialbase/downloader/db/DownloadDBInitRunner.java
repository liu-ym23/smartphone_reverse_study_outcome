package com.ss.android.socialbase.downloader.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadDBInitInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import td.c;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadDBInitRunner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f15386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DownloadDBInitInfo f15387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f15388c;
    public final HashMap d;
    public final List e;
    public final List f;
    public final SqlCacheLoadCompleteCallback g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ISqlCacheLoadCompleteCallbackAidl f15389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f15390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f15391j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15392k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashSet f15393l;

    public DownloadDBInitRunner(SQLiteDatabase r5, DownloadDBInitInfo r10, SparseArray r11, HashMap r12, List r13, List r14, SqlCacheLoadCompleteCallback r15, ISqlCacheLoadCompleteCallbackAidl r16, int r17, long r18) {
        this.f15392k = -1;
        this.f15386a = r5;
        this.f15387b = r10;
        this.f15388c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f15389h = r16;
        this.f15390i = r17;
        this.f15391j = r18;
    }

    public static void a(StringBuilder r5, String r10, HashSet r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == false) goto L7;
        return;
    L7:
        if (r5.indexOf(" WHERE ") >= 0) goto L9;
        r5.append(" WHERE " + r10 + " IN (");
    L10:
        Iterator r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        String r13 = (String) r12.next();
        r5.append("\"");
        r5.append(r13);
        r5.append("\",");
        goto L12
    L14:
        r5.deleteCharAt(r5.length() - 1);
        r5.append(")");
        return;
    L9:
        r5.append(" OR " + r10 + " IN (");
        goto L10
    }

    public final void b() {
        this.f15387b.f15803b = -1;
        if (this.d == null) goto L5;
        this.f15392k = SqlDownloadCache.f15401k;
        this.f15393l = new HashSet();
    L5:
        int r5 = this.f15392k;
        StringBuilder r10 = new StringBuilder("SELECT * FROM downloader");
        SparseArray r11 = DownloadHelper.f16133a;
        DownloadSetting r12 = DownloadSetting.f;
        a(r10, "monitorScene", DownloadHelper.a(r12.c("db_init_monitor_scene_list")));
        a(r10, "mimeType", DownloadHelper.a(r12.c("skip_db_init_expect_mime_type")));
        if (r5 <= 0) goto L8;
        r10.append(" LIMIT ");
        r10.append(r5);
    L8:
        String r13 = r10.toString();
        if (Logger.b() == false) goto L11;
        Logger.b("DownloadDBInitRunner", "loadNormalData", "Run sql:" + r13);
    L11:
        Cursor r14 = null;
        Cursor r15 = this.f15386a.rawQuery(r13, null);     // Catch: Throwable -> L59
        int r16 = r15.getCount();     // Catch: Throwable -> L16
        if (Logger.a() == false) goto L18;
        Logger.b("DownloadDBInitRunner", "handleDownloadInfoData", "Count:" + r16);     // Catch: Throwable -> L16
    L18:
        SqlDownloadHelper.a(r15);     // Catch: Throwable -> L16
        DownloadInfo.f15804e1 = true;     // Catch: Throwable -> L16
    L19:
        int r17 = 0;
    L20:
        if (r15.moveToNext() == false) goto L58;
        DownloadInfo r18 = SqlDownloadHelper.b(r15);     // Catch: Throwable -> L16
        SqlDownloadHelper.a(r15, r18);     // Catch: Throwable -> L16
        if (r18.s() == false) goto L26;
        r18.o();     // Catch: Throwable -> L16
        r18.a(-5);     // Catch: Throwable -> L16
    L26:
        if (r18.o() == (-3)) goto L33;
        if (r18.o() == 11) goto L33;
        if (r18.v() == true) goto L33;
        r18.z();     // Catch: Throwable -> L16
    L35:
        HashSet r19 = this.f15393l;     // Catch: Throwable -> L16
        if (r19 == null) goto L52;
        r19.add(Integer.valueOf(r18.l()));     // Catch: Throwable -> L16
        if (this.e == null) goto L52;
        List r20 = this.f;     // Catch: Throwable -> L16
        if (r20 == null) goto L52;
        if (r20.isEmpty() == true) goto L52;
        if (this.f.contains(r18.f15839u) == false) goto L52;
        if (DownloadSetting.a(r18.l(), r18).a("enable_notification_ui", 0) < 2) goto L48;
    L51:
        this.e.add(r18);     // Catch: Throwable -> L16
        goto L52
    L48:
        if (r18.n() != (-2)) goto L51;
        if (r18.x() == true) goto L51;
    L52:
        this.f15388c.put(r18.l(), r18);     // Catch: Throwable -> L16
        int r21 = this.f15390i;     // Catch: Throwable -> L16
        if (r21 <= 0) goto L20;
        r17 = r17 + 1;     // Catch: Throwable -> L16
        if (r17 < r21) goto L20;
        a(false);     // Catch: Throwable -> L16
    L33:
        if (r18.o() != 11) goto L35;
        r18.a(-5);     // Catch: Throwable -> L16
        goto L35
    L58:
        DownloadUtils.a(new Cursor[]{r15});
    L63:
        HashSet r22 = this.f15393l;
        if (r22 != null) goto L66;
        return;
    L66:
        if (r22.size() < this.f15392k) goto L125;
        StringBuilder r23 = new StringBuilder("SELECT _id FROM downloader");
        SparseArray r24 = DownloadHelper.f16133a;
        DownloadSetting r25 = DownloadSetting.f;
        a(r23, "monitorScene", DownloadHelper.a(r25.c("db_init_monitor_scene_list")));
        a(r23, "mimeType", DownloadHelper.a(r25.c("skip_db_init_expect_mime_type")));
        String r26 = r23.toString();
        if (Logger.b() == false) goto L105;
        Logger.b("DownloadDBInitRunner", "loadLruUnreadDBData", "Run sql:" + r26);
    L105:
        r14 = this.f15386a.rawQuery(r26, null);     // Catch: Throwable -> L75
        if (Logger.a() == false) goto L78;
        Logger.b("DownloadDBInitRunner", "handleUnreadDBIdData", "Count:" + r14.getCount());     // Catch: Throwable -> L75
    L78:
        if (r14.moveToNext() == false) goto L89;
        int r27 = r14.getInt(SqlDownloadHelper.f15456a);     // Catch: Throwable -> L75
        if (this.f15393l.contains(Integer.valueOf(r27)) == true) goto L78;
        HashMap r28 = this.d;     // Catch: Throwable -> L75
        monitor-enter(r28);     // Catch: Throwable -> L75
        this.d.put(Integer.valueOf(r27), 0);     // Catch: Throwable -> L86
        monitor-exit(r28);     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        throw th;     // Catch: Throwable -> L75
    L89:
        DownloadUtils.a(new Cursor[]{r14});
        return;
    L75:
        th = move-exception;
        Logger.c("DownloadDBInitRunner", "handleUnreadDBIdData", "Error:" + th);     // Catch: Throwable -> L92
        DownloadUtils.a(new Cursor[]{r14});
        return;
    L92:
        th = move-exception;
        DownloadUtils.a(new Cursor[]{r14});
        throw th;
    L125:
        return;
    L16:
        th = th;
    L107:
        Logger.c("DownloadDBInitRunner", "handleDownloadInfoData", "Error:" + th);     // Catch: Throwable -> L96
        DownloadUtils.a(new Cursor[]{r15});
    L96:
        th = move-exception;
        DownloadUtils.a(new Cursor[]{r15});
        throw th;
    L59:
        th = th;
        r15 = null;
        goto L107
    }

    public final void a(boolean r10) {
        SqlCacheLoadCompleteCallback r5 = this.g;
        if (r5 == null) goto L6;
        r5.a(r10);
    L6:
        if (this.f15389h == null) goto L24;
        SparseArray r11 = this.f15388c;
        SparseArray r12 = DownloadHelper.f16133a;
        HashMap r13 = new HashMap();
        int r14 = r11.size();
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L10;
        int r16 = r11.keyAt(r15);
        r13.put(Integer.valueOf(r16), r11.valueAt(r15));
        r15 = r15 + 1;
        goto L8
    L10:
        List r17 = this.e;
        if (r17 != null) goto L13;
        HashMap r18 = null;
    L46:
        this.f15389h.a(r13, this.d, r18, r10);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        c.e("Error:", th, "DownloadDBInitRunner", "callbackDownloadInfo");
        goto L24
    L13:
        HashMap r19 = new HashMap();
        Iterator r20 = r17.iterator();
    L15:
        if (r20.hasNext() == false) goto L19;
        DownloadInfo r21 = (DownloadInfo) r20.next();
        if (r21.l() == 0) goto L15;
        r19.put(Integer.valueOf(r21.l()), r21);
        goto L15
    L19:
        r18 = r19;
    L24:
        this.f15388c.clear();
        if (r10 == false) goto L39;
        if (Logger.b() == false) goto L29;
        Logger.b("DownloadDBInitRunner", "callbackDownloadInfo", "Finish");
    L29:
        List r22 = this.e;
        if (r22 == null) goto L32;
        r22.clear();
    L32:
        List r23 = this.f;
        if (r23 == null) goto L35;
        r23.clear();
    L35:
        HashMap r24 = this.d;
        if (r24 == null) goto L56;
        r24.clear();
        return;
    L56:
        return;
    L39:
        if (this.f15391j > 0) goto L41;
        return;
    L41:
        if (Logger.b() == false) goto L48;
        Logger.b("DownloadDBInitRunner", "callbackDownloadInfo", "Sleep:" + this.f15391j);
    L48:
        Thread.sleep(this.f15391j);     // Catch: Throwable -> L45
        return;
    }

    public static void a() {
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L15
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L15
        if (r5 != null) goto L8;
        return;
    L8:
        if (DownloadHelper.b() == false) goto L21;
        final int r10 = DownloadSetting.f.a("run_cleaner_background_delay_time_s", 0);
        if (r10 <= 0) goto L22;
        AppStatusManager.b().a(DownloadComponentManager.b());
        AppStatusManager.b().a(new AnonymousClass1(r10));
        return;
    L22:
        return;
    L21:
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
