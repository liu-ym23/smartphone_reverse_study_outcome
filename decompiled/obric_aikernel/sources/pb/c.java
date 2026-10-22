package pb;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f12362b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<a> f12363a;

    static {
    }

    private c() {
        new SparseArray();
        this.f12363a = new SparseArray();
    }

    public static c c() {
        if (f12362b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12362b != null) goto L9;
        f12362b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f12362b;
    }

    public void a(int r10) {
        Context r11 = com.ss.android.socialbase.downloader.downloader.a.h();
        if (r11 == null) goto L16;
        if (r10 == 0) goto L18;
        Intent r12 = new Intent(r11, DownloadNotificationService.class);
        r12.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");     // Catch: Throwable -> L9
        r12.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", r10);     // Catch: Throwable -> L9
        r11.startService(r12);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        lb.a.h("DownloadNotificationManagerImpl", r10, "cancel", "Error:" + th);
        th.printStackTrace();
        if (rb.a.j().k("fix_background_notification") == false) goto L17;
        d.f().g(r12);
        return;
    L17:
        return;
    L18:
        return;
    }

    public void b(int r10) {
        d(r10);
        if (r10 == 0) goto L6;
        b.b().a(r10);
        return;
    }

    public a d(int r10) {
        if (r10 != 0) goto L5;
        return null;
    L5:
        SparseArray<a> r11 = this.f12363a;
        monitor-enter(r11);
        a r12 = this.f12363a.get(r10);     // Catch: Throwable -> L12
        if (r12 == null) goto L10;
        this.f12363a.remove(r10);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r12;
    L12:
        th = move-exception;
        throw th;
    }
}
