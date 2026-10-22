package com.bytedance.reparo;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.core.exception.PatchDownloadException;
import com.bytedance.reparo.core.o;
import com.bytedance.reparo.model.PatchFetchInfo;
import com.bytedance.reparo.secondary.Logger;
import com.bytedance.reparo.secondary.c;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class f implements Runnable {
    public final PatchFetchInfo a;
    public final d b;
    public long c;

    public final void a() {
        String r0 = this.a.getHostAppVersion() + "-" + this.a.getVersionCode() + "-" + System.currentTimeMillis() + "-" + this.a.getMd5() + ".patch";
        d r1 = this.b;
        String r2 = String.valueOf(this.a.getVersionCode());
        r1.getClass();
        File r3 = new PolarisFileWrapper(new PolarisFileWrapper(new PolarisFileWrapper(r1.a.getFilesDir(), "reparo-root"), r2), "download" + File.separator + r0);
        OkHttpClient.Builder r4 = new OkHttpClient.Builder();
        TimeUnit r5 = TimeUnit.MILLISECONDS;
        r4.connectTimeout(60000, r5);
        r4.readTimeout(60000, r5);
        r4.followRedirects(true);
        OkHttpClient r6 = r4.build();
        String r7 = this.a.getUrl();
        if (TextUtils.isEmpty(r7) == true) goto L28;
        r3.getAbsolutePath();
        Logger.c();
        Response r8 = r6.newCall(new Request.Builder().url(r7).build()).execute();     // Catch: IOException -> L21
        if (r8.isSuccessful() == true) goto L9;
        b(new PatchDownloadException(r8.body().string()), r3);     // Catch: IOException -> L21
    L24:
        return;
    L9:
        w87.b.i(r8.body().byteStream(), r3);     // Catch: IOException -> L21
        if (TextUtils.equals(this.a.getMd5(), w87.a.a(r3)) == true) goto L13;
        r7 = "md5 not match, update skipped.";
        b(new PatchDownloadException("md5 not match, update skipped.", 1), r3);
        goto L24
    L13:
        r3.getAbsolutePath();
        Logger.c();
        PatchFetchInfo r9 = this.a;
        long r10 = this.c;
        r7 = c.a(r9, true);
        ((Event) r7).j = String.format("download %s success.", new Object[]{r9.toString()});
        if (w87.b.g(r3) == true) goto L16;
        long r11 = 0;
    L17:
        Long r12 = Long.valueOf(r11);
        if (((Event) r7).k != null) goto L20;
        ((Event) r7).k = new HashMap();
    L20:
        ((Event) r7).k.put("patch_size", r12);
        ((Event) r7).d = r10;
        ((Event) r7).f = true;
        r7.j();
        o.c().update(this.a.convertToUpdateRequest(r3));
        goto L24
    L16:
        r11 = r3.length();
    L21:
        e = move-exception;
        e.printStackTrace();
        b(new PatchDownloadException("down load " + r7 + " failed.", e), r3);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        a();     // Catch: Throwable -> L5
    L13:
        return;
    L5:
        th = move-exception;
        Logger.b("PatchUpdateTask", "something wrong", th);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }

    public f(PatchFetchInfo r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(PatchDownloadException r5, File r6) {
        PatchFetchInfo r0 = this.a;
        long r1 = this.c;
        Event r2 = c.a(r0, false);
        r2.e(r5);
        r2.d = r1;
        r2.j();
        Logger.b("PatchUpdateTask", "download failed. ", r5);
        w87.b.delete(r6);
    }
}
