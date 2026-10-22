package jb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9811a = null;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f9812c;

        a(d r10, Context r11) {
            this.f9812c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.utils.a.a(this.f9812c);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f9813c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9814g;

        b(d r10, Context r11, String r12) {
            this.f9813c = r11;
            this.f9814g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent r10 = new Intent(this.f9813c, DownloadNotificationService.class);     // Catch: Throwable -> L4
            r10.setAction(this.f9814g);     // Catch: Throwable -> L4
            this.f9813c.startService(r10);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f9815c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9816g;

        c(d r10, Context r11, String r12) {
            this.f9815c = r11;
            this.f9816g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.utils.a.a(this.f9815c);
            Intent r10 = new Intent(this.f9815c, DownloadNotificationService.class);     // Catch: Throwable -> L5
            r10.setAction(this.f9816g);     // Catch: Throwable -> L5
            this.f9815c.startService(r10);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            th.printStackTrace();
        }
    }

    static {
        f9811a = d.class.getSimpleName();
    }

    public d() {
    }

    private void a(Context r10, String r11) {
        if (com.ss.android.socialbase.downloader.downloader.a.e0() == true) goto L5;
        return;
    L5:
        long r12 = 2000;
        long r13 = rb.a.j().s("delay_refresh_unsuccess_task_ms", 2000);
        if (r13 <= 0) goto L9;
        r12 = r13;
    L9:
        com.ss.android.socialbase.downloader.downloader.a.L0(new b(this, r10, r11), r12, TimeUnit.MILLISECONDS);
    }

    private void b(Context r10, String r11) {
        com.ss.android.socialbase.downloader.downloader.a.G0(new c(this, r10, r11));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r10 == null) goto L28;
        if (r11 == null) goto L32;
        String r12 = r11.getAction();
        if (TextUtils.isEmpty(r12) == false) goto L9;
        return;
    L9:
        if (lb.a.a() == false) goto L12;
        lb.a.b(f9811a, "onReceive", "Action:" + r12);
    L12:
        if (r12.equals("android.net.conn.CONNECTIVITY_CHANGE") == false) goto L15;
        a(r10, r12);
        return;
    L15:
        if (r12.equals("android.intent.action.MEDIA_UNMOUNTED") == false) goto L17;
    L26:
        b(r10, r12);
        return;
    L17:
        if (r12.equals("android.intent.action.MEDIA_REMOVED") == true) goto L26;
        if (r12.equals("android.intent.action.MEDIA_BAD_REMOVAL") == true) goto L26;
        if (r12.equals("android.intent.action.MEDIA_EJECT") == true) goto L26;
        if (r12.equals("android.intent.action.MEDIA_MOUNTED") == false) goto L30;
        com.ss.android.socialbase.downloader.downloader.a.G0(new a(this, r10));
        return;
    L30:
        return;
    L32:
        return;
    }
}
