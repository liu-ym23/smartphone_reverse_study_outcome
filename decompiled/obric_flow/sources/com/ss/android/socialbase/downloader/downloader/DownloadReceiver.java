package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadReceiver extends BroadcastReceiver {
    public DownloadReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context r10, Intent r11) {
        if (r10 == null) goto L37;
        if (r11 == null) goto L39;
        final String r12 = r11.getAction();
        if (TextUtils.isEmpty(r12) == false) goto L9;
        return;
    L9:
        if (Logger.b() == false) goto L12;
        Logger.b("DownloadReceiver", "onReceive", "Action:" + r12);
    L12:
        if (r12.equals("android.net.conn.CONNECTIVITY_CHANGE") == false) goto L23;
        if (DownloadComponentManager.F == false) goto L41;
        long r5 = 2000;
        long r13 = DownloadSetting.f.a("delay_refresh_unsuccess_task_ms", 2000);
        if (r13 <= 0) goto L20;
        r5 = r13;
    L20:
        DownloadComponentManager.a(new AnonymousClass2(r10, r12), r5, TimeUnit.MILLISECONDS);
        return;
    L41:
        return;
    L23:
        if (r12.equals("android.intent.action.MEDIA_UNMOUNTED") == false) goto L25;
    L35:
        ((ThreadPoolExecutor) DownloadComponentManager.c()).execute(new AnonymousClass3(r10, r12));
        return;
    L25:
        if (r12.equals("android.intent.action.MEDIA_REMOVED") == true) goto L35;
        if (r12.equals("android.intent.action.MEDIA_BAD_REMOVAL") == true) goto L35;
        if (r12.equals("android.intent.action.MEDIA_EJECT") == true) goto L35;
        if (r12.equals("android.intent.action.MEDIA_MOUNTED") == false) goto L38;
        ((ThreadPoolExecutor) DownloadComponentManager.c()).execute(new AnonymousClass1(r10));
        return;
    L38:
        return;
    L39:
        return;
    }
}
