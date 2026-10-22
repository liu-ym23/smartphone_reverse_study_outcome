package jb;

import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public interface o<T extends DownloadService> {
    boolean A();

    void B();

    void C(com.ss.android.socialbase.downloader.model.d r10);

    void a(n r10);

    void b();

    void c(WeakReference<T> r10);

    void d();

    void e(Intent r10, int r11, int r12);

    IBinder onBind(Intent r10);

    void x(int r10);

    void y(com.ss.android.socialbase.downloader.model.d r10);
}
