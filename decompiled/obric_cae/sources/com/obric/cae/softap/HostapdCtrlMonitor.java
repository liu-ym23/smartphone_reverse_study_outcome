package com.obric.cae.softap;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Handler;
import android.os.SystemClock;
import com.obric.cae.log.CaeLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class HostapdCtrlMonitor {
    private static final String CTRL_DIR = "/data/vendor/wifi/hostapd/ctrl";
    private static final String TAG = "HostapdCtrlMonitor";
    private final Object mLock;
    private volatile boolean mStop;
    private Thread mThread;

    public interface Listener {
        void onError(String r8);

        void onEventLine(String r8);
    }

    public HostapdCtrlMonitor() {
        this.mLock = new Object();
        this.mStop = false;
    }

    public static /* synthetic */ void a(Listener r8, String r10) {
        lambda$monitorOne$2(r8, r10);
    }

    public static /* synthetic */ void b(Listener r8, String r10) {
        lambda$runLoop$1(r8, r10);
    }

    public static /* synthetic */ void c(HostapdCtrlMonitor r8, Handler r10, Listener r11) {
        r8.lambda$start$0(r10, r11);
    }

    private static List<String> getSocketCandidates() {
        ArrayList r8 = new ArrayList();
        File[] r10 = new File(CTRL_DIR).listFiles();     // Catch: Throwable -> L19
        if (r10 == null) goto L17;
        int r11 = r10.length;     // Catch: Throwable -> L19
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L17;
        String r13 = r10[r12].getName();     // Catch: Throwable -> L19
        if ("".equals(r13) == true) goto L16;
        if (r13.startsWith(".") == true) goto L16;
        if (r13.contains("global") == true) goto L16;
        r8.add("/data/vendor/wifi/hostapd/ctrl/" + r13);     // Catch: Throwable -> L19
    L16:
        r12 = r12 + 1;
    L17:
        r8.add("/data/vendor/wifi/hostapd/ctrl/wlan0");
        r8.add("/data/vendor/wifi/hostapd/ctrl/ap0");
        r8.add("/data/vendor/wifi/hostapd/ctrl/wlan1");
        r8.add("/data/vendor/wifi/hostapd/ctrl/softap0");
        return r8;
    }

    private static /* synthetic */ void lambda$monitorOne$2(Listener r8, String r10) {
        r8.onEventLine(r10);
    }

    private static /* synthetic */ void lambda$runLoop$1(Listener r8, String r10) {
        r8.onError(r10);
    }

    private /* synthetic */ void lambda$start$0(Handler r8, Listener r10) {
        runLoop(r8, r10);
    }

    private void monitorOne(Handler r8, final Listener r10, String r11) {
        LocalSocket r12 = new LocalSocket();
        r12.connect(new LocalSocketAddress(r11, LocalSocketAddress.Namespace.FILESYSTEM));     // Catch: Throwable -> L13
        OutputStream r13 = r12.getOutputStream();     // Catch: Throwable -> L13
        r13.write("ATTACH\n".getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L13
        r13.flush();     // Catch: Throwable -> L13
        BufferedReader r14 = new BufferedReader(new InputStreamReader(r12.getInputStream(), StandardCharsets.UTF_8));     // Catch: Throwable -> L13
    L5:
        if (this.mStop == true) goto L22;
        String r15 = r14.readLine();     // Catch: Throwable -> L13
        if (r15 == null) goto L22;
        final String r16 = stripWpaCtrlPriority(r15);     // Catch: Throwable -> L13
        r8.post(new e(r10, r16));     // Catch: Throwable -> L13
    L22:
        r12.close();     // Catch: IOException -> L16
    L11:
        SystemClock.sleep(200);
        throw new IOException(defpackage.b.c("hostapd ctrl disconnected: ", r11));
    L13:
        th = move-exception;
        r12.close();     // Catch: IOException -> L17
    L15:
        throw th;
    }

    private void runLoop(Handler r8, Listener r10) {
        Iterator<String> r11 = getSocketCandidates().iterator();
        Object r12 = null;
    L4:
        if (r11.hasNext() == false) goto L12;
        String r13 = r11.next();
        if (this.mStop == true) goto L7;
        monitorOne(r8, r10, r13);     // Catch: IOException -> L10
        return;
    L10:
        e = move-exception;
        CaeLog.w(TAG, "connect failed: " + r13 + ", e=" + e);
        r12 = e;
        goto L4
    L7:
        return;
    L12:
        StringBuilder r14 = new StringBuilder("hostapd ctrl connect failed, last=");
        if (r12 != null) goto L15;
        r12 = "null";
    L15:
        r14.append(r12);
        r8.post(new f(0, r10, r14.toString()));
    }

    private static String stripWpaCtrlPriority(String r8) {
        if (r8 != null) goto L4;
    L13:
        if (r8 != null) goto L16;
        return "";
    L16:
        return r8.trim();
    L4:
        if (r8.length() <= 3) goto L13;
        if (r8.charAt(0) != '<') goto L13;
        int r10 = r8.indexOf(62);
        if (r10 <= 0) goto L13;
        if (r10 >= 6) goto L13;
        return r8.substring(r10 + 1).trim();
    }

    public void start(final Handler r8, final Listener r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        stop();     // Catch: Throwable -> L7
        this.mStop = false;     // Catch: Throwable -> L7
        Thread r12 = new Thread(new d(this, r8, r10), "CaeHostapdCtrl");     // Catch: Throwable -> L7
        this.mThread = r12;     // Catch: Throwable -> L7
        r12.start();     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void stop() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        this.mStop = true;     // Catch: Throwable -> L10
        Thread r10 = this.mThread;     // Catch: Throwable -> L10
        if (r10 == null) goto L8;
        r10.interrupt();     // Catch: Throwable -> L10
        this.mThread = null;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
