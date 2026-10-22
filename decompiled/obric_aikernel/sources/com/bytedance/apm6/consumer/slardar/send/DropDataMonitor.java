package com.bytedance.apm6.consumer.slardar.send;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class DropDataMonitor {
    private static final String KEY_DROP_BYTES = "drop_data_bytes";
    private static final String KEY_DROP_COUNT = "drop_data_count";
    private static final String KEY_DROP_DATA_REASON = "drop_reason";
    private static final String KEY_DROP_ITEMS = "drop_data_items";
    private static final String KEY_DROP_LOG_ID = "x-tt-logid";
    private static final String KEY_DROP_SERVER_TIME = "drop_timestamp";
    private static final String KEY_DROP_TIME = "timestamp";
    private static final String KEY_LOG_TYPE = "log_type";
    private static final String KEY_SP_NAME = "drop_message";
    private static final String LOG_TYPE = "server_drop_data";
    private static final int MAX_LENGTH = 10;
    private volatile boolean init;
    private JSONArray items;
    private long serverDropTime;
    private String serverLogId;
    private SharedPreferences sharedPreferences;

    private static final class InnerHolder {
        private static final DropDataMonitor instance = null;

        static {
            instance = new DropDataMonitor();
        }

        private InnerHolder() {
        }

        static /* synthetic */ DropDataMonitor access$000() {
            return instance;
        }
    }

    static final enum Reason extends Enum<Reason> {
        private static final /* synthetic */ Reason[] $VALUES = null;
        public static final Reason FULL_DISK = null;
        public static final Reason SERVER_DROP = null;
        private String reason;

        static {
            Reason r10 = new Reason("SERVER_DROP", 0, "server drop message");
            SERVER_DROP = r10;
            Reason r11 = new Reason("FULL_DISK", 1, "disk is full");
            FULL_DISK = r11;
            $VALUES = new Reason[]{r10, r11};
        }

        private Reason(String r10, int r11, String r12) {
            super(r10, r11);
            this.reason = r12;
        }

        public static Reason valueOf(String r10) {
            return (Reason) Enum.valueOf(Reason.class, r10);
        }

        public static Reason[] values() {
            return (Reason[]) $VALUES.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.reason;
        }
    }

    DropDataMonitor() {
        this.items = new JSONArray();
    }

    private synchronized void ensureInit() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.init == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.init = true;     // Catch: Throwable -> L13
        SharedPreferences r10 = ApmBaseContext.getContext().getSharedPreferences(ApmContext.getCurrentProcessName() + "_" + KEY_SP_NAME, 0);     // Catch: Throwable -> L13
        this.sharedPreferences = r10;     // Catch: Throwable -> L13
        String r11 = r10.getString(KEY_DROP_ITEMS, "");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r11) == false) goto L19;
    L11:
        monitor-exit(this);
        return;
    L19:
        this.items = new JSONArray(r11);     // Catch: Exception -> L16 Throwable -> L13
        goto L11
    }

    static DropDataMonitor getInstance() {
        return InnerHolder.access$000();
    }

    JSONArray getItems() {
        ensureInit();
        JSONArray r10 = new JSONArray();
        JSONArray r11 = new JSONArray();
        int r12 = 0;
    L13:
        if (r12 >= this.items.length()) goto L10;
        if (r12 >= 10) goto L8;
        r10.put(this.items.get(r12));     // Catch: Exception -> L12
    L9:
        r12 = r12 + 1;
        goto L13
    L8:
        r11.put(this.items.get(r12));     // Catch: Exception -> L12
    L10:
        this.items = r11;
        this.sharedPreferences.edit().putString(KEY_DROP_ITEMS, this.items.toString()).commit();
        return r10;
    }

    void monitorDropLog(long r10, long r11, long r12, Reason r13) {
        ensureInit();
        JSONObject r14 = new JSONObject();
        r14.put("log_type", LOG_TYPE);     // Catch: Exception -> L13
        r14.put("timestamp", r12);     // Catch: Exception -> L13
        r14.put(KEY_DROP_COUNT, r10);     // Catch: Exception -> L13
        r14.put(KEY_DROP_BYTES, r11);     // Catch: Exception -> L13
        if (r13 != Reason.SERVER_DROP) goto L6;
        r14.put(KEY_DROP_LOG_ID, this.serverLogId);     // Catch: Exception -> L13
        r14.put(KEY_DROP_SERVER_TIME, this.serverDropTime);     // Catch: Exception -> L13
    L6:
        if (r13 == null) goto L8;
        r14.put(KEY_DROP_DATA_REASON, r13);     // Catch: Exception -> L13
    L8:
        this.items.put(r14);     // Catch: Exception -> L13
        if (ApmBaseContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "monitorDropLog:" + this.items.toString());     // Catch: Exception -> L13
    L11:
        this.sharedPreferences.edit().putString(KEY_DROP_ITEMS, this.items.toString()).commit();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        Logger.e(Constants.TAG, "monitorDropLog:", e);
    }

    void setServerLogId(String r10) {
        this.serverLogId = r10;
    }

    void setServerTimeStamp(long r10) {
        this.serverDropTime = r10;
    }
}
