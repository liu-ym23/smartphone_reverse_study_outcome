package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import r2.i;

/* JADX INFO: loaded from: classes.dex */
public class TTMultiNetwork {
    public static final int STATE_COUNT = 8;
    public static final int STATE_DEFAULT_CELLULAR = 1;
    public static final int STATE_DEFAULT_WIFI_WITH_CELLULAR_DOWN = 2;
    public static final int STATE_DEFAULT_WIFI_WITH_CELLULAR_UP = 3;
    public static final int STATE_EVALUATE_CELLULAR = 7;
    public static final int STATE_NO_NETWORK = 0;
    public static final int STATE_STOPPED = -1;
    public static final int STATE_WAIT_CELLULAR_ALWAYS_UP = 4;
    public static final int STATE_WAIT_USER_ENABLE = 5;
    public static final int STATE_WIFI_WITH_CELLULAR_TRANS_DATA = 6;
    private static final String TAG = "TTMultiNetwork";
    private static Map<MultiNetStateObserver, Handler> sObservers;

    public interface MultiNetStateObserver {
        void onMultiNetStateChanged(int r10, int r11, long r12);

        void onUserSpecifiedNetworkEnabled(boolean r10, long r11);
    }

    static {
        sObservers = new HashMap();
    }

    public TTMultiNetwork() {
    }

    private static i getCronetHttpClient() {
        if (c.c() == false) goto L7;
        return i.w(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }

    private static void notifyMultiNetState(final int r12, final int r13) {
        final long r10 = System.currentTimeMillis();
        monitor-enter(TTMultiNetwork.class);
        Iterator<Map.Entry<MultiNetStateObserver, Handler>> r11 = sObservers.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r11.hasNext() == false) goto L10;
        Map.Entry<MultiNetStateObserver, Handler> r14 = r11.next();     // Catch: Throwable -> L12
        final MultiNetStateObserver r15 = r14.getKey();     // Catch: Throwable -> L12
        Handler r16 = r14.getValue();     // Catch: Throwable -> L12
        if (r16 == null) goto L6;
        r16.post(new AnonymousClass1(r15, r12, r13, r10));     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static boolean notifySwitchToMultiNetwork(boolean r10) {
        i r11 = getCronetHttpClient();     // Catch: Exception -> L6
        if (r11 == null) goto L12;
        return r11.B(r10);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static synchronized void notifyUserSpecifiedNetworkEnabled(final boolean r10) {
        monitor-enter(TTMultiNetwork.class);
        final long r11 = System.currentTimeMillis();     // Catch: Throwable -> L18
        monitor-enter(TTMultiNetwork.class);     // Catch: Throwable -> L18
        Iterator<Map.Entry<MultiNetStateObserver, Handler>> r12 = sObservers.entrySet().iterator();     // Catch: Throwable -> L15
    L8:
        if (r12.hasNext() == false) goto L12;
        Map.Entry<MultiNetStateObserver, Handler> r13 = r12.next();     // Catch: Throwable -> L15
        final MultiNetStateObserver r14 = r13.getKey();     // Catch: Throwable -> L15
        Handler r15 = r13.getValue();     // Catch: Throwable -> L15
        if (r15 == null) goto L8;
        r15.post(new AnonymousClass2(r14, r10, r11));     // Catch: Throwable -> L15
        goto L8
    L12:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L15
        monitor-exit(TTMultiNetwork.class);
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static void registerMultiNetObserver(MultiNetStateObserver r10, Handler r11) {
        Objects.requireNonNull(r10, "observer == null");
        monitor-enter(TTMultiNetwork.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sObservers.containsKey(r10) == true) goto L9;
        if (r11 != null) goto L8;
        sObservers.put(r10, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L11
        goto L9
    L8:
        sObservers.put(r10, r11);     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L11
    }

    public static void triggerSwitchingToCellular() {
        i r10 = getCronetHttpClient();     // Catch: Exception -> L6
        if (r10 == null) goto L11;
        r10.Y();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static void unregisterMultiNetObserver(MultiNetStateObserver r10) {
        Objects.requireNonNull(r10, "observer == null");
        monitor-enter(TTMultiNetwork.class);
        sObservers.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
