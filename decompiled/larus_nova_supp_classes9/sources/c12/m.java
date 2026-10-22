package c12;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.core.z;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.WriteStorageException;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class m extends c {
    public com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> c;
    public volatile float d;
    public volatile int e;
    public volatile float f;

    public m(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r1) {
        super(r1);
    }

    public final String d(String r3) {
        int r0 = r3.lastIndexOf("/");
        if (r0 != (-1)) goto L5;
        return null;
    L5:
        return r3.substring(0, r0);
    }

    public final void e(DownloadInfo r5) {
        if (z.a() == false) goto L11;
        monitor-enter(this);
        this.d = (float) (((double) this.d) + r5.getDownloadSpeed());     // Catch: Throwable -> L8
        this.e++;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r3, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r4) {
        if (r3 != null) goto L6;
        jy0.b.a("TTDownloadProducer", "GetResourceRequest is null.");
        return;
    L6:
        this.c = r4;
        String r5 = b(r3);
        if (r5 != null) goto L9;
    L22:
        WriteStorageException r6 = new WriteStorageException("write storage failed.", new IOException("mkdirs return false"), r3);
        this.c.l(r3, r6);
        return;
    L9:
        if (r5.isEmpty() == true) goto L22;
        if (com.bytedance.android.livesdk.gift.platform.core.h.g().f() == false) goto L18;
        if (d12.a.a == false) goto L16;
        jy0.b.a("TTDownloadProducer", "ttNetFastDownload");
    L16:
        r3.h = true;
        f(r5, r3).fastDownload().download();
        return;
    L18:
        if (d12.a.a == false) goto L20;
        jy0.b.a("TTDownloadProducer", "ttNetNormalDownload");
    L20:
        f(r5, r3).download();
    }

    public final DownloadTask f(String r10, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r11) {
        long r4 = System.currentTimeMillis();
        String r6 = r11.b();
        DownloadTask r0 = Downloader.with(s1.getContext()).url(r6);
        int r1 = r10.lastIndexOf("/");
        if (r1 == (-1)) goto L5;
        String r2 = r10.substring(r1);
    L7:
        return r0.name(r2).monitorScene("gift_asset").savePath(d(r10)).subThreadListener(new l(this, r11, r10, r4, r6));
    L5:
        r2 = null;
        goto L7
    }
}
