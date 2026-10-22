package j9;

import android.os.SystemClock;
import com.bytedance.crash.npth_fd_track.FDNativeTools;
import com.bytedance.crash.util.NativeTools;
import java.io.File;
import zm.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f18289b;

    public a(b r5, int r10) {
        this.f18288a = r10;
        switch(r10) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f18289b = r5;
        super("npthFdTracker");
        return;
    L6:
        this.f18289b = r5;
        super("fd_track_dumper");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        switch(this.f18288a) {
            case 0: goto L44;
            default: goto L4;
        };
    L4:
        io.reactivex.exceptions.a.d("[NpthFdTracker]: ", "dumper begin");
        b r12 = this.f18289b;
        r12.getClass();
        int r5 = FDNativeTools.b(3);
        if (r5 == 0) goto L7;
        io.reactivex.exceptions.a.d("[NpthFdTracker]: ", "dumper fail, errno: " + r5);
        return;
    L7:
        File r10 = new File(r12.f18294i);
        if (r10.exists() == true) goto L87;
        io.reactivex.exceptions.a.d("[NpthFdTracker]: ", "dumper dir doesn't exist");
        return;
    L87:
        File r13 = new File(r10, "maps.txt");     // Catch: Throwable -> L85
        String r11 = null;
        if (r13.exists() == true) goto L13;
        String r14 = r13.getAbsolutePath();     // Catch: Throwable -> L85
    L14:
        File r15 = new File(r10, "smaps.txt");     // Catch: Throwable -> L85
        if (r15.exists() == true) goto L17;
        String r16 = r15.getAbsolutePath();     // Catch: Throwable -> L85
    L18:
        File r17 = new File(r10, "meminfo.txt");     // Catch: Throwable -> L85
        if (r17.exists() == true) goto L21;
        String r18 = r17.getAbsolutePath();     // Catch: Throwable -> L85
    L22:
        File r19 = new File(r10, "fds.txt");     // Catch: Throwable -> L85
        if (r19.exists() == true) goto L25;
        String r20 = r19.getAbsolutePath();     // Catch: Throwable -> L85
    L26:
        File r21 = new File(r10, "threads.txt");     // Catch: Throwable -> L85
        if (r21.exists() == true) goto L29;
        r11 = r21.getAbsolutePath();     // Catch: Throwable -> L85
    L29:
        NativeTools.k().getClass();     // Catch: Throwable -> L85
        NativeTools.f(r20, r14, r16, r11, r18);     // Catch: Throwable -> L85
        File r110 = new File(r10, "logcat.txt");     // Catch: Throwable -> L85
        File r22 = new File(r10, "logerr.txt");     // Catch: Throwable -> L85
        if (r110.exists() == true) goto L32;
    L34:
        r110.getParentFile().mkdirs();     // Catch: Throwable -> L85
        p.i(r110.getAbsolutePath(), r22.getAbsolutePath(), false);     // Catch: Throwable -> L85
    L35:
        File r111 = new File(r10, "pthreads.txt");     // Catch: Throwable -> L85
        if (r111.exists() == true) goto L39;
        File r23 = new File(r10, "rountines.txt");     // Catch: Throwable -> L85
        r111.getParentFile().mkdirs();     // Catch: Throwable -> L85
        NativeTools.k().m(r111.getAbsolutePath(), r23.getAbsolutePath());     // Catch: Throwable -> L85
    L39:
        File r112 = new File(r10, "malloc.txt");     // Catch: Throwable -> L85
        if (r112.exists() == true) goto L96;
        r112.getParentFile().mkdirs();     // Catch: Throwable -> L85
        NativeTools.k().t(r112.getAbsolutePath());     // Catch: Throwable -> L85
        return;
    L96:
        return;
    L32:
        if (r110.length() <= 0) goto L34;
    L25:
        r20 = null;
        goto L26
    L21:
        r18 = null;
        goto L22
    L17:
        r16 = null;
        goto L18
    L13:
        r14 = null;
    L97:
        return;
    L44:
        b r113 = this.f18289b;
        int r24 = r113.f;
        int r25 = r24;
    L45:
        int r26 = r113.f18291b;
        if (r26 == 5) goto L83;
        if (r26 > 2) goto L50;
        int r27 = NativeTools.k().r();
    L51:
        io.reactivex.exceptions.a.d("[NpthFdTracker]: ", "state: " + r113.f18291b + " === fd count: " + r27);
        int r28 = r113.f18291b;
        if (r28 == 1) goto L77;
        int r29 = r113.e;
        if (r28 == 2) goto L70;
        int r114 = r113.d;
        if (r28 == 3) goto L64;
        if (r28 != 4) goto L80;
        if (r27 <= r114) goto L61;
        new a(r113, 1).start();
        r113.f18291b = 5;
        r113.f18292c = false;
        goto L80
    L61:
        FDNativeTools.b(1);
        r113.f18291b = 3;
        if (r27 >= r29) goto L80;
    L74:
        r25 = r25 * 4;
    L80:
        r25 = Math.max(1000, r25);
        SystemClock.sleep(r25);     // Catch: Throwable -> L86
        goto L45
    L64:
        if (r27 <= r114) goto L68;
        FDNativeTools.b(2);
        r113.f18291b = 4;
    L66:
        r25 = r24;
        goto L80
    L68:
        if (r27 >= (r114 / 4)) goto L80;
    L70:
        if (r27 <= r29) goto L73;
        FDNativeTools.b(1);
        r113.f18291b = 3;
        goto L66
    L73:
        if (r27 < (r29 / 4)) goto L74;
        r25 = r25 / 4;
        goto L80
    L77:
        if (FDNativeTools.b(0) == 0) goto L79;
        r113.f18291b = 5;
        goto L80
    L79:
        r113.f18291b = 2;
        goto L80
    L50:
        r27 = FDNativeTools.a();
        goto L51
    L83:
        FDNativeTools.b(4);
    }
}
