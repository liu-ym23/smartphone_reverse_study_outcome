package com.larus.avlink.update;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import lq9.o;
import lq9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final h a = null;
    public static boolean b;
    public static boolean c;
    public static final Lazy d = null;

    public static final class a implements IDownloadListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public final void onCanceled(DownloadInfo r2) {
            h.b = false;
            n1.d("TemporaryDoraGUpdateManager", "onCanceled");
        }

        public final void onFirstStart(DownloadInfo r2) {
            n1.d("TemporaryDoraGUpdateManager", "onFirstStart");
        }

        public final void onFirstSuccess(DownloadInfo r2) {
            n1.d("TemporaryDoraGUpdateManager", "onFirstSuccess");
        }

        public final void onPause(DownloadInfo r2) {
            n1.d("TemporaryDoraGUpdateManager", "onPause");
        }

        public final void onPrepare(DownloadInfo r2) {
            n1.d("TemporaryDoraGUpdateManager", "onPrepare");
        }

        public final void onProgress(DownloadInfo r2) {
            n1.d("TemporaryDoraGUpdateManager", "onProgress");
        }

        public final void onStart(DownloadInfo r2) {
            n1.d("TemporaryDoraGUpdateManager", "onStart");
        }

        public final void onSuccessed(DownloadInfo r6) {
            n1.d("TemporaryDoraGUpdateManager", "onSucceed");
            h.b = false;
            h r7 = h.a;
            PolarisFileWrapper r8 = new PolarisFileWrapper(this.a, this.b);
            StringBuilder r1 = new StringBuilder();
            AppHost.Companion r2 = AppHost.a;
            r1.append(r2.getApplication().getPackageName());
            r1.append(".g.update");
            String r3 = r1.toString();
            ContextWrapper r4 = r2.a().getCurrentActivity();
            if (r4 != null) goto L5;
            r4 = r2.getApplication();
        L5:
            n1.a("TemporaryDoraGUpdateManager", "auto install apk context:" + r4 + ",file:" + r8);
            int r0 = Build.VERSION.SDK_INT;
            if (r0 < 24) goto L8;
            Uri r9 = FileProvider.getUriForFile(r4, r3, r8);
        L9:
            Intent r5 = new Intent("android.intent.action.VIEW");
            r5.setDataAndType(r9, "application/vnd.android.package-archive");
            if (r0 < 24) goto L12;
            int r10 = 268435457;
        L13:
            r5.addFlags(r10);
            r4.startActivity(r5);
            return;
        L12:
            r10 = 268435456;
            goto L13
        L8:
            r9 = Uri.fromFile(r8);
            goto L9
        }

        public a(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFailed(DownloadInfo r2, BaseException r3) {
            h.b = false;
            StringBuilder r4 = new StringBuilder("onFailed, error:");
            if (r3 == null) goto L5;
            String r5 = r3.getMessage();
        L6:
            r4.append(r5);
            n1.d("TemporaryDoraGUpdateManager", r4.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }

        public final void onRetry(DownloadInfo r1, BaseException r2) {
            n1.d("TemporaryDoraGUpdateManager", "onRetry");
        }

        @Deprecated(message = "Deprecated in Java")
        public final void onRetryDelay(DownloadInfo r1, BaseException r2) {
            n1.d("TemporaryDoraGUpdateManager", "onRetryDelay");
        }
    }

    public h() {
    }

    static {
        a = new h();
        d = LazyKt.lazy(new d());
    }

    public static o c() {
        return (o) d.getValue();
    }

    private final void update() {
        AppHost.Companion r0 = AppHost.a;
        Context r1 = r0.getApplication().getApplicationContext();
        String r2 = null;
        File[] r3 = ContextCompat.getExternalFilesDirs(r1, null);
        if (r3.length != 0) goto L5;
        boolean r4 = true;
    L7:
        if ((!r4) == false) goto L9;
        String r5 = new PolarisFileWrapper(r3[0], "g_update").getAbsolutePath();
    L10:
        if (r5 != null) goto L19;
        File r6 = r1.getExternalCacheDir();
        if (r6 != null) goto L14;
        r6 = r1.getFilesDir();
    L14:
        if (r6 != null) goto L16;
        r6 = r1.getCacheDir();
    L16:
        if (r6 == null) goto L19;
        r5 = new PolarisFileWrapper(r6, "g_update").getAbsolutePath();
    L19:
        if (r5 != null) goto L22;
        n1.d("TemporaryDoraGUpdateManager", "update fail due to saveFileDir is null");
        return;
    L22:
        t r7 = c().b;
        if (r7 == null) goto L25;
        r2 = r7.f;
    L25:
        if (r2 != null) goto L27;
    L30:
        boolean r8 = true;
    L31:
        if (r8 == false) goto L34;
        n1.d("TemporaryDoraGUpdateManager", "update fail due to urlPath is null");
        return;
    L34:
        String r9 = UriProtector.parse(r2).getPath();
        if (r9 != null) goto L37;
    L40:
        boolean r10 = true;
    L41:
        if (r10 == true) goto L49;
        int r11 = StringsKt.lastIndexOf$default(r9, File.separatorChar, 0, false, 6, null);
        if (r11 < 0) goto L49;
        int r12 = r11 + 1;
        if (r12 > r9.length()) goto L49;
        String r13 = r9.substring(r12);
    L50:
        n1.d("TemporaryDoraGUpdateManager", "saveFileDir is >>>> " + r5 + ", fileName is >>>" + r13);
        a r14 = new a(r5, r13);
        Application r15 = r0.getApplication();
        b = true;
        AppDownloader.getInstance().addDownloadTask(new AppTaskBuilder(r15, r2).saveName(r13).savePath(r5).taskKey(r2 + ':' + r5 + ':' + r13).needWifi(false).showNotification(false).needDefaultHttpServiceBackUp(true).ignoreInterceptor(true).retryCount(3).mainThreadListener(r14));
        return;
    L49:
        r13 = "";
        goto L50
    L37:
        if (r9.length() == 0) goto L40;
        r10 = false;
        goto L41
    L27:
        if (r2.length() == 0) goto L30;
        r8 = false;
        goto L31
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = false;
        goto L7
    }

    public static final void a(int r2) {
        a.update();
        n1.d("TemporaryDoraGUpdateManager", "user click confirm from " + r2);
    }

    public static void b(int r15) {
        UpdateSource r0 = UpdateSource.SETTING;
        long r2 = 0;
        if (r15 == r0.getValue()) goto L15;
        long r5 = DoraConfig.a.getLong("key_g_update_cancel_time", 0);
        if (r5 == 0) goto L15;
        long r7 = System.currentTimeMillis();
        Long r1 = c().c;
        if (r1 == null) goto L9;
        long r9 = r1.longValue();
    L11:
        if (((r7 - r5) / ((long) 1000)) >= r9) goto L15;
        n1.d("TemporaryDoraGUpdateManager", "no check update within the " + r9 + " range, lastCancelTime is " + r5 + ", currentTime is " + r7);
        return;
    L9:
        r9 = 21600;
    L15:
        if (b == true) goto L17;
    L20:
        int r3 = AppHost.a.getUpdateVersionCode();
        t r6 = c().b;
        if (r6 == null) goto L26;
        Long r8 = r6.e;
        if (r8 == null) goto L26;
        r2 = r8.longValue();
    L26:
        if (r2 <= r3) goto L42;
        t r4 = c().b;
        boolean r10 = false;
        if (r4 == null) goto L37;
        String r11 = r4.f;
        if (r11 == null) goto L37;
        if (r11.length() <= 0) goto L34;
        boolean r12 = true;
    L35:
        if (r12 != true) goto L37;
        r10 = true;
        goto L37
    L34:
        r12 = false;
    L37:
        if (r10 == false) goto L39;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new TemporaryDoraGUpdateManager$showUpdateDialog$1(r15, null), 3, null);
        n1.d("TemporaryDoraGUpdateManager", "show update dialog in " + r15 + ", currentVersion is " + r3 + ", latestVersion is " + r2);
        return;
    L39:
        n1.d("TemporaryDoraGUpdateManager", "no show dialog due to url is empty");
        return;
    L42:
        if (r15 != r0.getValue()) goto L44;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new TemporaryDoraGUpdateManager$showNoUpdateToast$1(null), 3, null);
    L44:
        n1.d("TemporaryDoraGUpdateManager", "current is latest version, currentVersion is " + r3 + ", latestVersion is " + r2);
        return;
    L17:
        if (r15 != r0.getValue()) goto L20;
        n1.d("TemporaryDoraGUpdateManager", "isDownloading....");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new TemporaryDoraGUpdateManager$showRepeatUpdateToast$1(null), 3, null);
    }
}
