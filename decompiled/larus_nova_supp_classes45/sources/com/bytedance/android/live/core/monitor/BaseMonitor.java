package com.bytedance.android.live.core.monitor;

import com.bytedance.common.utility.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class BaseMonitor {
    public static final int STATUS_CANCEL = 2;
    public static final int STATUS_FAIL = 1;
    public static final int STATUS_LEAVE = 3;
    public static final int STATUS_SUCCESS = 0;
    private static final String TAG = "BaseMonitor";

    public static final enum MonitorEventModule extends Enum<MonitorEventModule> {
        public static final MonitorEventModule BROADCAST = null;
        public static final MonitorEventModule COMMON = null;
        public static final MonitorEventModule ENTER_ROOM = null;
        public static final MonitorEventModule HYBRID = null;
        public static final MonitorEventModule PAY = null;
        public static final /* synthetic */ MonitorEventModule[] a = null;
        private String name;

        static {
            MonitorEventModule r0 = new MonitorEventModule("COMMON", 0, "common");
            COMMON = r0;
            MonitorEventModule r1 = new MonitorEventModule("ENTER_ROOM", 1, "enter_room");
            ENTER_ROOM = r1;
            MonitorEventModule r2 = new MonitorEventModule("BROADCAST", 2, "broadcast");
            BROADCAST = r2;
            MonitorEventModule r4 = new MonitorEventModule("HYBRID", 3, "hybrid");
            HYBRID = r4;
            MonitorEventModule r6 = new MonitorEventModule("PAY", 4, "pay");
            PAY = r6;
            a = new MonitorEventModule[]{r0, r1, r2, r4, r6};
        }

        public static MonitorEventModule[] values() {
            return (MonitorEventModule[]) a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static MonitorEventModule valueOf(String r1) {
            return (MonitorEventModule) a.a(MonitorEventModule.class, r1);
        }

        public MonitorEventModule(String r1, int r2, String r3) {
            super(r1, r2);
            this.name = r3;
        }
    }

    public BaseMonitor() {
    }

    public static void add(JSONObject r2, String r3, float r4) {
        r2.put(r3, r4);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        Logger.e(TAG, "", e);
    }

    public static void add(JSONObject r0, String r1, int r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "", e);
    }

    public static void add(JSONObject r0, String r1, long r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "", e);
    }

    public static void add(JSONObject r0, String r1, String r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "", e);
    }

    public static void add(JSONObject r0, String r1, JSONObject r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "", e);
    }

    public static void add(JSONObject r0, String r1, boolean r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "", e);
    }
}
