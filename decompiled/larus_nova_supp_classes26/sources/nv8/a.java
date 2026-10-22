package nv8;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements com.bytedance.android.accessibilityLib_Core.config.remote.subjob.b {

    /* JADX INFO: renamed from: nv8.a$a, reason: collision with other inner class name */
    public static final class C0121a implements IDownloadListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ Function1<String, Unit> b;

        public final void onCanceled(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("AccessibilityDownloadJob", "[onCanceled]");
            this.b.invoke(null);
        }

        public final void onFirstStart(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("AccessibilityDownloadJob", "[onFirstStart]");
        }

        public final void onFirstSuccess(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("AccessibilityDownloadJob", "[onFirstSuccess]");
        }

        public final void onPause(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("AccessibilityDownloadJob", "[onPause]");
        }

        public final void onPrepare(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("AccessibilityDownloadJob", "[onPrepare]");
        }

        public final void onProgress(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("AccessibilityDownloadJob", "[onProgress]");
        }

        public final void onStart(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("AccessibilityDownloadJob", "[onStart]");
        }

        public final void onSuccessed(DownloadInfo r4) {
            FLogger r0 = FLogger.a;
            this.a.getClass();
            r0.i("AccessibilityDownloadJob", "[onSuccessed] entity:" + r4);
            Function1<String, Unit> r1 = this.b;
            if (r4 == null) goto L5;
            String r5 = r4.getTargetFilePath();
        L6:
            r1.invoke(r5);
            return;
        L5:
            r5 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0121a(a r1, Function1<? super String, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFailed(DownloadInfo r3, BaseException r4) {
            FLogger r5 = FLogger.a;
            this.a.getClass();
            StringBuilder r0 = new StringBuilder("[onFailed] error:");
            if (r4 == null) goto L5;
            String r6 = r4.getMessage();
        L6:
            r0.append(r6);
            r5.i("AccessibilityDownloadJob", r0.toString());
            this.b.invoke(null);
            return;
        L5:
            r6 = null;
            goto L6
        }

        public final void onRetry(DownloadInfo r2, BaseException r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("AccessibilityDownloadJob", "[onRetry]");
        }

        public final void onRetryDelay(DownloadInfo r2, BaseException r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("AccessibilityDownloadJob", "[onRetryDelay]");
        }
    }

    public a() {
    }

    public final void a(com.bytedance.android.accessibilityLib_Core.config.remote.subjob.a r6, Function1<? super String, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "param");
        Intrinsics.checkNotNullParameter(r7, "callback");
        FLogger.a.i("AccessibilityDownloadJob", "[download] begin, param:" + r6);
        Context r0 = AppHost.a.getApplication().getApplicationContext();
        String r1 = r6.a;
        String r2 = r6.b;
        String r3 = r6.d;
        String r8 = r6.e;
        AppDownloader.getInstance().addDownloadTask(new AppTaskBuilder(r0, r1).saveName(r3).savePath(r2).mimeType(r8).taskKey(r1 + ':' + r2 + ':' + r3).needWifi(false).showNotification(false).needDefaultHttpServiceBackUp(true).ignoreInterceptor(true).retryCount(3).mainThreadListener(new C0121a(this, r7)));
    }
}
