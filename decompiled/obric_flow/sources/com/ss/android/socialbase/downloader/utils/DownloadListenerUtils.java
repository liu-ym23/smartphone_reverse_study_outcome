package com.ss.android.socialbase.downloader.utils;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadExtListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadListenerUtils {
    public static void a(int r5, ConcurrentHashMap r10, boolean r11, DownloadInfo r12, BaseException r13, ListenerType r14, DownloadTask r15) {
        if (r11 == false) goto L120;
        if (r10 == null) goto L121;
    L40:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r10.size() <= 0) goto L122;
        Iterator r16 = r10.values().iterator();     // Catch: Throwable -> L40
    L8:
        if (r16.hasNext() == false) goto L123;
        IDownloadListener r17 = (IDownloadListener) r16.next();     // Catch: Throwable -> L40
        if (r5 != (-7)) goto L13;
    L21:
        ((IDownloadGlobalThrottleService) DownloadServiceManager.a(IDownloadGlobalThrottleService.class)).b(r15);     // Catch: Throwable -> L40
    L22:
        if (r17 == null) goto L8;
        if (r5 != 1) goto L26;
        r17.i(r12);     // Catch: Throwable -> L40
        goto L8
    L26:
        if (r5 != 2) goto L28;
        r17.m(r12);     // Catch: Throwable -> L40
        goto L8
    L28:
        if (r5 != 4) goto L30;
        r17.n(r12);     // Catch: Throwable -> L40
        goto L8
    L30:
        if (r5 != 5) goto L32;
        r17.b(r12, r13);     // Catch: Throwable -> L40
        goto L8
    L32:
        if (r5 != 6) goto L34;
        r17.f(r12);     // Catch: Throwable -> L40
        goto L8
    L34:
        if (r5 != 11) goto L35;
        if ((r17 instanceof IDownloadExtListener) == false) goto L8;
        ((IPCUtils.AnonymousClass27) ((IDownloadExtListener) r17)).a(r12);     // Catch: Throwable -> L40
        goto L8
    L35:
        switch(r5) {
            case -7: goto L53;
            case -6: goto L51;
            case -5: goto L48;
            case -4: goto L45;
            case -3: goto L42;
            case -2: goto L48;
            case -1: goto L37;
            default: goto L8;
        };     // Catch: Throwable -> L40
    L37:
        r17.a(r12, r13);     // Catch: Throwable -> L40
        if (r15 == null) goto L8;
        r15.a(r14, r17);     // Catch: Throwable -> L40
        goto L8
    L42:
        r17.l(r12);     // Catch: Throwable -> L40
        if (r15 == null) goto L8;
        r15.a(r14, r17);     // Catch: Throwable -> L40
        goto L8
    L45:
        r17.g(r12);     // Catch: Throwable -> L40
        if (r15 == null) goto L8;
        r15.a(r14, r17);     // Catch: Throwable -> L40
        goto L8
    L48:
        r17.d(r12);     // Catch: Throwable -> L40
        if (r15 == null) goto L8;
        r15.a(r14, r17);     // Catch: Throwable -> L40
        goto L8
    L51:
        r17.j(r12);     // Catch: Throwable -> L40
        goto L8
    L53:
        if ((r17 instanceof AbsDownloadListener) == false) goto L8;
        ((AbsDownloadListener) r17).a(r12);     // Catch: Throwable -> L40
        if (r15 == null) goto L8;
        r15.a(r14, r17);     // Catch: Throwable -> L40
        goto L8
    L13:
        if (r5 == (-4)) goto L21;
        if (r5 == (-3)) goto L21;
        if (r5 == (-2)) goto L21;
        if (r5 == (-1)) goto L21;
    L123:
        return;
    L122:
        return;
    L121:
        return;
    }

    public static void a(int r5, Map r10, DownloadInfo r11, int r12, ArrayList r13, String r14) {
        if (r10 == null) goto L46;
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (r10.size() <= 0) goto L47;
        Iterator r15 = r10.values().iterator();     // Catch: Throwable -> L21
    L7:
        if (r15.hasNext() == false) goto L48;
        IDownloadListener r16 = (IDownloadListener) r15.next();     // Catch: Throwable -> L21
        if (r16 == null) goto L7;
        if ((r16 instanceof AbsDownloadListener) == false) goto L7;
        if (r5 != 1) goto L16;
        AbsDownloadListener r17 = (AbsDownloadListener) r16;     // Catch: Throwable -> L21
        AbsDownloadListener.a(r11, r12);     // Catch: Throwable -> L21
        goto L7
    L16:
        if (r5 != 2) goto L18;
        AbsDownloadListener r18 = (AbsDownloadListener) r16;     // Catch: Throwable -> L21
        AbsDownloadListener.a(r11, r13);     // Catch: Throwable -> L21
        goto L7
    L18:
        if (r5 != 3) goto L7;
        AbsDownloadListener r19 = (AbsDownloadListener) r16;     // Catch: Throwable -> L21
        AbsDownloadListener.a(r11, r14);     // Catch: Throwable -> L21
        goto L7
    L48:
        return;
    L47:
        return;
    }

    public static void a(DownloadTask r5, DownloadInfo r10, ConcurrentHashMap r11, ListenerType r12, boolean r13) {
        if (r13 == false) goto L10;
        Iterator r14 = r11.values().iterator();
    L5:
        if (r14.hasNext() == false) goto L9;
        IDownloadListener r15 = (IDownloadListener) r14.next();
        if (r15 == null) goto L5;
        r15.g(r10);
        r5.a(r12, r15);
        goto L5
    L9:
        return;
    L10:
        monitor-enter(r11);
        Iterator r16 = r11.values().iterator();     // Catch: Throwable -> L17
    L13:
        if (r16.hasNext() == false) goto L19;
        IDownloadListener r17 = (IDownloadListener) r16.next();     // Catch: Throwable -> L17
        if (r17 == null) goto L13;
        r17.g(r10);     // Catch: Throwable -> L17
        r5.a(r12, r17);     // Catch: Throwable -> L17
        goto L13
    L19:
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
