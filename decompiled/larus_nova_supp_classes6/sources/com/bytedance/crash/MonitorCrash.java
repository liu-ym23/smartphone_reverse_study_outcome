package com.bytedance.crash;

import android.content.Context;
import com.bytedance.crash.monitor.d;
import com.bytedance.crash.monitor.j;
import com.bytedance.crash.monitor.k;
import org.json.JSONObject;
import wh4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class MonitorCrash {
    private final Config mConfig;
    private final d mCrashListener;

    public class Config {
        private final MonitorCrash mMonitorCrash;
        final /* synthetic */ MonitorCrash this$0;

        public Config setChannel(String r2) {
            this.mMonitorCrash.setChannel(r2);
            return this;
        }

        public Config setDeviceId(String r2) {
            this.mMonitorCrash.setDeviceId(r2);
            return this;
        }

        public Config setPackageName(String r2) {
            this.mMonitorCrash.setPackageName(r2);
            return this;
        }

        public Config setSoList(String[] r2) {
            this.mMonitorCrash.setSoList(r2);
            return this;
        }

        public Config setUID(long r2) {
            this.mMonitorCrash.setUserId(r2);
            return this;
        }

        public Config(MonitorCrash r1, MonitorCrash r2) {
            this.this$0 = r1;
            this.mMonitorCrash = r2;
        }
    }

    public m0 getUserDataCenter() {
        return ((com.bytedance.crash.monitor.f) this.mCrashListener).c;
    }

    public Config config() {
        return this.mConfig;
    }

    private MonitorCrash(d r1) {
        this.mCrashListener = r1;
        this.mConfig = new Config(this, this);
    }

    public void setChannel(String r2) {
        this.mCrashListener.o(r2);
    }

    public void setDeviceId(String r2) {
        this.mCrashListener.p(r2);
    }

    public void setPackageName(String r2) {
        k r3 = this.mCrashListener;
        if ((r3 instanceof k) == false) goto L6;
        r3.getClass();
        return;
    }

    public void setSoList(String[] r2) {
        k r3 = this.mCrashListener;
        if ((r3 instanceof k) == false) goto L6;
        r3.getClass();
        return;
    }

    public void setUserId(long r2) {
        this.mCrashListener.q(r2);
    }

    public void reportCustomErr(String r4, Throwable r5) {
        this.mCrashListener.e().g(r4, null, r5, "core_exception_monitor");
    }

    public void reportCustomErr(String r3, String r4, Throwable r5) {
        this.mCrashListener.e().g(r3, null, r5, "core_exception_monitor");
    }

    public static MonitorCrash init(Context r0, String r1, long r2, String r4) {
        return initApp(r0, r1, r2, r4);
    }

    public static MonitorCrash initApp(Context r2, String r3, long r4, String r6) {
        i.g(r2);
        monitor-enter(com.bytedance.crash.monitor.a.class);
        d r1 = j.a;     // Catch: Throwable -> L16
        if (r1 == null) goto L8;
        monitor-exit(com.bytedance.crash.monitor.a.class);     // Catch: Throwable -> L16
    L15:
        return new MonitorCrash(r1);
    L8:
        com.bytedance.crash.monitor.a r5 = new com.bytedance.crash.monitor.a(r3, r6, r4);     // Catch: Throwable -> L16
        j.a = r5;     // Catch: Throwable -> L16
        monitor-exit(com.bytedance.crash.monitor.a.class);     // Catch: Throwable -> L16
        fh4.f r7 = j.b;
        if (r7 == null) goto L13;
        r7.d = r5;
    L13:
        d0.b(r2, i.d());
        b.post(new e(r5));
        r1 = j.a;
    L16:
        th = move-exception;
        throw th;
    }

    public void reportEvent(String r2, int r3, JSONObject r4, JSONObject r5) {
        this.mCrashListener.k(r2, r3, r4, r5);
    }

    public static MonitorCrash initSDK(Context r7, String r8, long r9, String r11, String r12) {
        return initSDK(r7, r8, r9, r11, r12, null);
    }

    public static MonitorCrash initSDK(Context r0, String r1, long r2, String r4, String r5, String[] r6) {
        i.g(r0);
        k r7 = new k(r1, r4, r2);
        d0.b(r0, i.d());
        b.post(new f(r7));
        return new MonitorCrash(r7);
    }
}
