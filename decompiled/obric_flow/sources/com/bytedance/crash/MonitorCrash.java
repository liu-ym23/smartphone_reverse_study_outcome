package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorCrash {
    private static volatile boolean sAppMonitorCrashInit;
    Config mConfig;
    AttachUserData mCustomData;
    AttachUserData mCustomLongData;
    HeaderParams mParams;
    HashMap<String, String> mTagMap;

    public class Config {
        public String mAid;
        String mChannel;
        String mDeviceId;
        String mPackageName;
        String[] mSoList;
        long mUID;
        long mVersionInt;
        String mVersionStr;
        boolean test;
        final /* synthetic */ MonitorCrash this$0;

        public Config(MonitorCrash r5) {
            this.this$0 = r5;
            this.mVersionInt = -1;
        }

        public Config setChannel(String r5) {
            this.mChannel = r5;
            o9.a.a();
            return this;
        }

        public Config setDeviceId(String r5) {
            this.mDeviceId = r5;
            o9.a.a();
            return this;
        }

        public Config setPackageName(String r5) {
            this.mPackageName = r5;
            o9.a.a();
            return this;
        }

        public Config setSoList(String[] r5) {
            this.mSoList = r5;
            o9.a.a();
            return this;
        }

        public Config setUID(long r5) {
            this.mUID = r5;
            o9.a.a();
            return this;
        }
    }

    public interface HeaderParams {
        Map<String, Object> getCommonParams();
    }

    private MonitorCrash(Context r5, String r10, long r11, String r12) {
        this.mTagMap = new HashMap();
        Config r13 = new Config(this);
        this.mConfig = r13;
        r13.mAid = r10;
        r13.mVersionInt = r11;
        r13.mVersionStr = r12;
        j r14 = new j(this);
        j.f4054b = this;
        Application r15 = (Application) r5.getApplicationContext();
        i r16 = new i(r14, this);
        if (n.f4072u == false) goto L6;
        return;
    L6:
        if (n.f4058b != null) goto L8;
    L9:
        n.f4059c = System.currentTimeMillis();
        n.d = SystemClock.uptimeMillis();
        n.f4057a = r5;
        n.f4058b = r15;
        n.f4067o = n.f();
    L10:
        n.f4061i = new i4.a(n.f4057a, r16, n.d());
        n.f4072u = true;
        return;
    L8:
        if (n.f4057a != null) goto L10;
        goto L9
    }

    @Nullable
    public static MonitorCrash init(Context r10, String r11, long r12, String r13) {
        if (sAppMonitorCrashInit == false) goto L5;
        return null;
    L5:
        monitor-enter(MonitorCrash.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sAppMonitorCrashInit == true) goto L13;
        sAppMonitorCrashInit = true;     // Catch: Throwable -> L11
        p.c(r10);     // Catch: Throwable -> L11
        MonitorCrash r5 = new MonitorCrash(r10, r11, r12, r13);     // Catch: Throwable -> L11
        monitor-exit(MonitorCrash.class);     // Catch: Throwable -> L11
        return r5;
    L13:
        monitor-exit(MonitorCrash.class);     // Catch: Throwable -> L11
        return null;
    }

    public static MonitorCrash initSDK(Context r10, String r11, long r12, String r13, String r14, String[] r15) {
        p.c(r10);
        MonitorCrash r16 = new MonitorCrash(r11, r12, r13, r14);
        r16.config().setPackageName(r14).setSoList(r15);
        return r16;
    }

    public MonitorCrash addTags(String r5, String r10) {
        this.mTagMap.put(r5, r10);
        return this;
    }

    @NonNull
    public Config config() {
        return this.mConfig;
    }

    public void reportCustomErr(String r10, String r11, Throwable r12) {
        com.bytedance.crash.upload.b.j(this, r12, null, 0, r10, Thread.currentThread(), r11);     // Catch: Throwable -> L4
        return;
    }

    public void reportEvent(String r5, int r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        z8.e r14 = new z8.e();
        JSONObject r15 = r14.f23416a;
        mh.e.g("exception", "event_type", r15);
        mh.e.g("service_monitor", "log_type", r15);
        mh.e.g(Long.valueOf(System.currentTimeMillis()), "timestamp", r15);
        mh.e.g(Long.valueOf(System.currentTimeMillis()), "crash_time", r15);
        mh.e.g(ym.m.o(n.f4057a), "process_name", r15);
        mh.e.g(Thread.currentThread().getName(), "crash_thread_name", r15);
        mh.e.g(r5, NotificationCompat.CATEGORY_SERVICE, r15);
        mh.e.g(Integer.valueOf(r10), NotificationCompat.CATEGORY_STATUS, r15);
        if (r11 == null) goto L5;
        mh.e.g(r11, "category", r15);
    L5:
        if (r12 == null) goto L7;
        mh.e.g(r12, LynxMonitorService.KEY_METRIC, r15);
    L7:
        mh.e.g(Long.valueOf(n.f4059c), WsConstants.KEY_SESSION_ID, r15);
        com.bytedance.crash.upload.n.c(this, r14);
    }

    public MonitorCrash setCustomDataCallback(AttachUserData r5) {
        this.mCustomData = r5;
        return this;
    }

    public MonitorCrash withOtherHeaders(@Nullable HeaderParams r5) {
        this.mParams = r5;
        return this;
    }

    public static MonitorCrash initSDK(Context r10, String r11, long r12, String r13, String r14) {
        p.c(r10);
        MonitorCrash r15 = new MonitorCrash(r11, r12, r13, r14);
        r15.config().setPackageName(r14);
        return r15;
    }

    private MonitorCrash(String r5, long r10, String r11, String r12) {
        this.mTagMap = new HashMap();
        Config r13 = new Config(this);
        this.mConfig = r13;
        r13.mAid = r5;
        r13.mVersionInt = r10;
        r13.mVersionStr = r11;
        r13.mPackageName = r12;
        new j(this);
    }
}
