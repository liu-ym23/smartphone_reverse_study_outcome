package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import android.text.TextUtils;
import com.lynx.jsbridge.a;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadNetworkService implements IDownloadNetworkService {
    public DownloadNetworkService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetworkService
    public final IDownloadHttpConnection a(boolean r17, int r18, String r19, String r20, ArrayList r21, int r22, boolean r23, DownloadInfo r24) {
        if (TextUtils.isEmpty(r20) == true) goto L13;
        r21.add(new HttpHeader("ss_d_request_host_ip_114", r20));
        if (r24 == null) goto L11;
        JSONObject r5 = DownloadSetting.a(r24.l(), null).d("segment_config");
        if (r5 == null) goto L11;
        if (r5.optInt("enable_ttnet_ip_request", 0) <= 0) goto L11;
    L15:
        int r10 = r22;
    L16:
        if (r10 == 1) goto L27;
        if (r10 != 2) goto L19;
        int[] r11 = {1};
    L23:
        int[] r13 = r11;
        int r14 = r13.length;
        int r15 = 0;
        Exception e = null;
    L29:
        if (r15 >= r14) goto L40;
        IDownloadHttpConnection r12 = a(r18, r19, r20, r21, r13[r15], r23, r24);     // Catch: Exception -> L34
        if (r12 == null) goto L39;
        return r12;
    L39:
        r15 = r15 + 1;
    L34:
        e = e;
        if (r24 == null) goto L39;
        if (r24.R == false) goto L39;
        char[] r16 = DownloadUtils.f16142a;
        ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).a().getClass();
        goto L39
    L40:
        if (e != null) goto L42;
        return null;
    L42:
        throw e;
    L19:
        if (r10 != 3) goto L21;
        r11 = new int[]{0, 1};
        goto L23
    L21:
        if (r10 == 5) goto L24;
        r11 = new int[]{1, 0};
        goto L23
    L24:
        r11 = new int[]{2};
        goto L23
    L27:
        r11 = new int[]{0};
    L11:
        r10 = 1;
        goto L16
    L13:
        if (r17 == true) goto L15;
        r10 = 2;
        goto L16
    }

    public static IDownloadHttpConnection a(int r10, String r11, String r12, ArrayList r13, int r14, boolean r15, DownloadInfo r16) {
        if (2 != r14) goto L6;
        IDownloadHttpService r5 = DownloadComponentManager.g();
    L9:
        if (r5 == null) goto L28;
        IOException r17 = null;
        long r18 = 0;
        if (r15 == true) goto L31;
    L17:
        IDownloadHttpConnection r19 = ((DefaultDownloadHttpService) r5).a(r11, r13);     // Catch: Throwable -> L13 IOException -> L15
        if (r15 == false) goto L20;
        DownloadMonitorHelper.a(r19, r11, r12, System.currentTimeMillis() - r18, r14, null, r16);
    L20:
        return r19;
    L15:
        e = move-exception;
        long r20 = r18;
        throw e;     // Catch: Throwable -> L22
    L22:
        th = th;
        r17 = e;
        r18 = r20;
    L24:
        if (r15 == false) goto L26;
        DownloadMonitorHelper.a(null, r11, r12, System.currentTimeMillis() - r18, r14, r17, r16);
    L26:
        throw th;
    L13:
        th = th;
        goto L24
    L31:
        r18 = System.currentTimeMillis();     // Catch: Throwable -> L13 IOException -> L15
        goto L17
    L28:
        throw new BaseException(1022, DownloadUtils.a(new IOException(a.d(r14, "httpService not exist, netLib = "))));
    L6:
        if (r14 != 1) goto L8;
        Context r21 = DownloadComponentManager.f15515a;
        r5 = null;
        goto L9
    L8:
        r5 = DownloadComponentManager.g();
        goto L9
    }
}
