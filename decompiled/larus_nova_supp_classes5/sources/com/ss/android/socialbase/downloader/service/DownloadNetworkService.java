package com.ss.android.socialbase.downloader.service;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadNetworkService implements IDownloadNetworkService {
    public DownloadNetworkService() {
    }

    private boolean enableTTNetIpRequest(DownloadInfo r3) {
        if (r3 == null) goto L10;
        JSONObject r4 = DownloadSetting.obtain(r3.getId()).optJSONObject("segment_config");
        if (r4 != null) goto L7;
        return false;
    L7:
        if (r4.optInt("enable_ttnet_ip_request", 0) <= 0) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private int[] getDownloadNetLibs(int r5) {
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L15;
        if (r5 == 5) goto L13;
        return new int[]{1, 0};
    L13:
        return new int[]{2};
    L15:
        return new int[]{0, 1};
    L17:
        return new int[]{1};
    L19:
        return new int[]{0};
    }

    private IDownloadHttpService getHttpServiceInternal(int r2) {
        if (2 != r2) goto L10;
        IDownloadHttpService r3 = DownloadComponentManager.getHttpService();
        if (r3 == null) goto L8;
        return r3;
    L8:
        return DownloadComponentManager.getDefaultHttpService();
    L10:
        if (r2 != 1) goto L13;
        return DownloadComponentManager.getHttpService();
    L13:
        return DownloadComponentManager.getDefaultHttpService();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetworkService
    public IDownloadHttpConnection downloadWithConnection(boolean r10, int r11, String r12, List<HttpHeader> r13) throws Exception {
        return downloadWithConnection(r10, r11, r12, null, r13, 0, false, null);
    }

    private IDownloadHttpConnection downloadWithConnectionImpl(int r14, String r15, String r16, List<HttpHeader> r17, int r18, boolean r19, DownloadInfo r20) throws BaseException, IOException {
        IDownloadHttpService r0 = getHttpServiceInternal(r18);
        if (r0 == null) goto L28;
        IOException r8 = null;
        long r2 = 0;
        if (r19 == false) goto L31;
        r2 = System.currentTimeMillis();     // Catch: Throwable -> L8 IOException -> L10
    L10:
        e = e;
    L20:
        IOException r4 = e;
        throw r4;     // Catch: Throwable -> L22
    L22:
        th = th;
        r8 = r4;
    L24:
        if (r19 == false) goto L26;
        DownloadMonitorHelper.monitorDownloadConnect(null, r15, r16, System.currentTimeMillis() - r2, "get", r18, r8, r20);
    L26:
        throw th;
    L8:
        th = th;
    L31:
        IDownloadHttpConnection r1 = r0.downloadWithConnection(r14, r15, r17);     // Catch: Throwable -> L17 IOException -> L19
        if (r19 == false) goto L16;
        DownloadMonitorHelper.monitorDownloadConnect(r1, r15, r16, System.currentTimeMillis() - r2, "get", r18, null, r20);
    L16:
        return r1;
    L19:
        e = e;
    L17:
        th = th;
        goto L24
    L28:
        throw new BaseException(1022, new IOException("httpService not exist, netLib = " + r18));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetworkService
    public IDownloadHttpConnection downloadWithConnection(boolean r18, int r19, String r20, String r21, List<HttpHeader> r22, int r23, boolean r24, DownloadInfo r25) throws Exception {
        if (TextUtils.isEmpty(r21) == true) goto L12;
        if (r22 != null) goto L6;
        List<HttpHeader> r0 = new ArrayList();
    L7:
        r0.add(new HttpHeader(DownloadConstants.EXTRA_REQUEST_HOST_IP, r21));
        if (enableTTNetIpRequest(r25) == true) goto L10;
        List<HttpHeader> r12 = r0;
        int r1 = 1;
    L16:
        int[] r13 = getDownloadNetLibs(r1);
        int r14 = r13.length;
        Exception r2 = null;
        int r8 = 0;
    L17:
        if (r8 >= r14) goto L35;
        int r16 = r8;
        IDownloadHttpConnection r3 = downloadWithConnectionImpl(r19, r20, r21, r12, r13[r8], r24, r25);     // Catch: Exception -> L22
        if (r3 == null) goto L34;
        return r3;
    L34:
        r8 = r16 + 1;
    L22:
        e = move-exception;
        if (r25 != null) goto L26;
    L33:
        r2 = e;
        goto L34
    L26:
        if (r25.isExpiredRedownload() == false) goto L33;
        if (DownloadUtils.isResponseCode304Error(e) == false) goto L33;
        if (DownloadUtils.hasDownloadCacheHeader(r12) == false) goto L33;
        throw e;
    L35:
        if (r2 != null) goto L37;
        return null;
    L37:
        throw r2;
    L10:
        r12 = r0;
    L15:
        r1 = r23;
        goto L16
    L6:
        r0 = r22;
        goto L7
    L12:
        if (r18 == true) goto L14;
        r1 = 2;
        r12 = r22;
        goto L16
    L14:
        r12 = r22;
        goto L15
    }
}
