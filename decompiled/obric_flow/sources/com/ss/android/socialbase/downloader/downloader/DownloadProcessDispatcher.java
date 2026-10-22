package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.cleaner.Cleaner;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadProcessDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile DownloadProcessDispatcher f15537c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile SparseArray f15538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile ArrayList f15539b;

    public DownloadProcessDispatcher() {
        this.f15538a = new SparseArray();
        this.f15539b = new ArrayList();
    }

    public static DownloadProcessDispatcher a() {
        if (f15537c != null) goto L13;
        monitor-enter(DownloadProcessDispatcher.class);
        f15537c = new DownloadProcessDispatcher();     // Catch: Throwable -> L9
        monitor-exit(DownloadProcessDispatcher.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f15537c;
    }

    public final void b(int r5, boolean r10) {
        if (DownloadUtils.b() == true) goto L36;
        a(r5, r10);
        if (DownloadComponentManager.f == null) goto L13;
        if (DownloadHelper.a() == true) goto L13;
        if (DownloadProxy.a(true).d() == false) goto L13;
        DownloadProxy.a(true).a(r5, r10);
    L13:
        monitor-enter(DownloadComponentManager.class);
        boolean r11 = DownloadComponentManager.s;     // Catch: Throwable -> L26
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L26
        if (r11 == false) goto L18;
        return;
    L18:
        if (DownloadHelper.a() == false) goto L20;
        return;
    L20:
        if (DownloadHelper.b() == true) goto L35;
        Intent r12 = new Intent(DownloadComponentManager.b(), DownloadHandleService.class);     // Catch: Throwable -> L23
        r12.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");     // Catch: Throwable -> L23
        r12.putExtra("extra_download_id", r5);     // Catch: Throwable -> L23
        DownloadComponentManager.b().startService(r12);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        th.printStackTrace();
        return;
    L35:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public final synchronized int c(int r5) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f15538a.get(r5) != null) goto L8;
        monitor-exit(this);
        return -1;
    L8:
        boolean r10 = ((Boolean) this.f15538a.get(r5)).booleanValue();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r10 ? 1 : 0;
    }

    public final void a(final DownloadTask r10) {
        DownloadInfo r5 = r10.f15878a;
        int r11 = 0;
        if (r5 != null) goto L6;
        final IDownloadProxy r12 = null;
    L40:
        if (r12 != null) goto L45;
        IDownloadMonitorDepend r13 = r10.f15883j;
        DownloadInfo r14 = r10.f15878a;
        BaseException r15 = new BaseException(PointerIconCompat.TYPE_HELP, "tryDownload but getDownloadHandler failed");
        DownloadInfo r16 = r10.f15878a;
        if (r16 == null) goto L44;
        r11 = r16.o();
    L44:
        DownloadMonitorHelper.a(r13, r14, r15, r11);
        return;
    L45:
        Cleaner r17 = Cleaner.a();
        r17.f15223a.b(r10.e());
        if (r10.f15888o == false) goto L48;
        DownloadComponentManager.a(new AnonymousClass1(r12, r10), 500, TimeUnit.MILLISECONDS);
        return;
    L48:
        r12.a(r10);
        return;
    L6:
        if (r5.b1 == false) goto L8;
    L39:
        r12 = DownloadProxy.a();
        goto L40
    L8:
        if (r5.K == true) goto L39;
        if (DownloadUtils.b() == true) goto L39;
        boolean r18 = r5.J;
        boolean r19 = true;
        if (DownloadHelper.a() == false) goto L15;
    L16:
        r18 = true;
    L17:
        int r20 = b(r5.l());
        if (r20 < 0) goto L30;
        if (r20 == r18) goto L30;
        if (r20 != 1) goto L27;
        if (DownloadHelper.b() == false) goto L51;
        DownloadProxy.a(true).b(r5.l(), true);     // Catch: Throwable -> L50
        DownloadInfo r21 = DownloadProxy.a(true).a(r5.l());     // Catch: Throwable -> L50
        if (r21 == null) goto L51;
        DownloadProxy.a(false).b(r21);     // Catch: Throwable -> L50
    L51:
        goto L30
    L27:
        if (DownloadHelper.b() == false) goto L29;
        DownloadProxy.a(false).b(r5.l(), true);     // Catch: Throwable -> L50
        goto L51
    L29:
        r10.f15888o = true;     // Catch: Throwable -> L50
        DownloadProxy.a(true).b(1, r5.l());     // Catch: Throwable -> L50
    L30:
        int r22 = r5.l();
        if (r18 != true) goto L33;
        boolean r23 = true;
    L34:
        b(r22, r23);
        if (r18 == true) goto L38;
        r19 = false;
    L38:
        r12 = DownloadProxy.a(r19);
        goto L40
    L33:
        r23 = false;
        goto L34
    L15:
        if (DownloadHelper.b() == true) goto L17;
        goto L16
    }

    public final int b(int r5) {
        if (DownloadComponentManager.f != null) goto L5;
        return -1;
    L5:
        if (DownloadUtils.b() == false) goto L8;
        return -1;
    L8:
        if (DownloadHelper.a() == true) goto L14;
        if (DownloadProxy.a(true).d() == false) goto L14;
        return DownloadProxy.a(true).i(r5);
    L14:
        return c(r5);
    }

    public final synchronized void a(int r5, boolean r10) {
        monitor-enter(this);
        SparseArray r11 = this.f15538a;     // Catch: Throwable -> L6
        if (r10 == false) goto L8;
        Boolean r12 = Boolean.TRUE;     // Catch: Throwable -> L6
    L9:
        r11.put(r5, r12);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L8:
        r12 = Boolean.FALSE;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final IDownloadProxy a(int r5) {
        int r10 = b(r5);
        boolean r11 = true;
        if (r10 == 1) goto L5;
    L7:
        r11 = false;
    L9:
        return DownloadProxy.a(r11);
    L5:
        if (DownloadHelper.a() == true) goto L7;
        goto L7
    }
}
