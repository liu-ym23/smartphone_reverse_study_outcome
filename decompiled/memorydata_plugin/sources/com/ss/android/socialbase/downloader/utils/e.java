package com.ss.android.socialbase.downloader.utils;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.service.k;
import com.ss.android.socialbase.downloader.service.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class e {
    private static void a(int r3, Map<Integer, IDownloadListener> r4, DownloadInfo r5, byte[] r6, int r7, List<Pair<String, String>> r8, String r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        List<Pair<String, String>> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L46;
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r10.size() <= 0) goto L47;
        Iterator r12 = r10.values().iterator();     // Catch: Throwable -> L25
    L8:
        if (r12.hasNext() == false) goto L48;
        IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.preCheckCast(r12.next(), IDownloadListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r0 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r0, AbsDownloadListener.class) == false) goto L8;
        if (r3 != 1) goto L17;
        ((AbsDownloadListener) ZeusTransformUtils.preCheckCast(r0, AbsDownloadListener.class, "com.obric.memorydata.plugin")).onReceiveData(r5, r6, r7);     // Catch: Throwable -> L25
        goto L8
    L17:
        if (r3 != 2) goto L19;
        ((AbsDownloadListener) ZeusTransformUtils.preCheckCast(r0, AbsDownloadListener.class, "com.obric.memorydata.plugin")).onReceiveHeader(r5, r11);     // Catch: Throwable -> L25
        goto L8
    L19:
        if (r3 != 3) goto L8;
        ((AbsDownloadListener) ZeusTransformUtils.preCheckCast(r0, AbsDownloadListener.class, "com.obric.memorydata.plugin")).onReceiveRequestLog(r5, r9);     // Catch: Throwable -> L25
        goto L8
    L48:
        return;
    L47:
        return;
    }

    public static void a(int r3, Map<Integer, IDownloadListener> r4, boolean r5, DownloadInfo r6, BaseException r7, ListenerType r8, DownloadTask r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L97;
        if (r10 == null) goto L98;
    L56:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (r10.size() <= 0) goto L99;
        Iterator r11 = r10.values().iterator();     // Catch: Throwable -> L56
    L9:
        if (r11.hasNext() == false) goto L100;
        IDownloadListener r12 = (IDownloadListener) ZeusTransformUtils.preCheckCast(r11.next(), IDownloadListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        if (r3 != (-7)) goto L14;
    L22:
        ((m) ZeusTransformUtils.preCheckCast(k.a(m.class), m.class, "com.obric.memorydata.plugin")).b(r9);     // Catch: Throwable -> L56
    L23:
        if (r12 == null) goto L9;
        if (r3 != 1) goto L27;
        r12.onPrepare(r6);     // Catch: Throwable -> L56
        goto L9
    L27:
        if (r3 != 2) goto L29;
        r12.onStart(r6);     // Catch: Throwable -> L56
        goto L9
    L29:
        if (r3 != 4) goto L31;
        r12.onProgress(r6);     // Catch: Throwable -> L56
        goto L9
    L31:
        if (r3 != 5) goto L33;
        r12.onRetry(r6, r7);     // Catch: Throwable -> L56
        goto L9
    L33:
        if (r3 != 6) goto L35;
        r12.onFirstStart(r6);     // Catch: Throwable -> L56
        goto L9
    L35:
        if (r3 != 11) goto L36;
        if (ZeusTransformUtils.instanceOf(r12, s.class) == false) goto L9;
        ((s) ZeusTransformUtils.preCheckCast(r12, s.class, "com.obric.memorydata.plugin")).a(r6);     // Catch: Throwable -> L56
        goto L9
    L36:
        switch(r3) {
            case -7: goto L45;
            case -6: goto L43;
            case -5: goto L42;
            case -4: goto L41;
            case -3: goto L40;
            case -2: goto L42;
            case -1: goto L38;
            default: goto L9;
        };     // Catch: Throwable -> L56
    L38:
        r12.onFailed(r6, r7);     // Catch: Throwable -> L56
    L39:
        a(r9, r8, r12);     // Catch: Throwable -> L56
        goto L9
    L40:
        r12.onSuccessed(r6);     // Catch: Throwable -> L56
        goto L39
    L41:
        r12.onCanceled(r6);     // Catch: Throwable -> L56
        goto L39
    L42:
        r12.onPause(r6);     // Catch: Throwable -> L56
        goto L39
    L43:
        r12.onFirstSuccess(r6);     // Catch: Throwable -> L56
        goto L9
    L45:
        if (ZeusTransformUtils.instanceOf(r12, AbsDownloadListener.class) == false) goto L9;
        ((AbsDownloadListener) ZeusTransformUtils.preCheckCast(r12, AbsDownloadListener.class, "com.obric.memorydata.plugin")).onIntercept(r6);     // Catch: Throwable -> L56
        goto L39
    L14:
        if (r3 == (-4)) goto L22;
        if (r3 == (-3)) goto L22;
        if (r3 == (-2)) goto L22;
        if (r3 == (-1)) goto L22;
    L100:
        return;
    L99:
        return;
    L98:
        return;
    }

    private static void a(DownloadTask r2, ListenerType r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.removeCallback(r3, r5);
        return;
    }

    public static void a(Map<Integer, IDownloadListener> r7, DownloadInfo r8, String r9) {
        a(3, (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin"), r8, null, 0, null, r9);
    }

    public static void a(Map<Integer, IDownloadListener> r9, DownloadInfo r10, List<Pair<String, String>> r11) {
        a(2, (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin"), r10, null, 0, (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), null);
    }

    public static void a(Map<Integer, IDownloadListener> r7, DownloadInfo r8, byte[] r9, int r10) {
        a(1, (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin"), r8, r9, r10, null, null);
    }
}
