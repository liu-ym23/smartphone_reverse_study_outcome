package elb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public final /* synthetic */ ImageUploadTask a;

    public a(ImageUploadTask r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = com.ss.android.lark.image.uploader.utils.c.a;     // Catch: Throwable -> L4
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "startUploadTask async: " + this.a);     // Catch: Throwable -> L4
        ExecutorService r1 = b.a;     // Catch: Throwable -> L4
        b.a(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
