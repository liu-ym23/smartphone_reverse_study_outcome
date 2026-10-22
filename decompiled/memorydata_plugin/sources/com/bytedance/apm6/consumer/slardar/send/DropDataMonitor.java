package com.bytedance.apm6.consumer.slardar.send;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
            Reason r0 = new Reason("SERVER_DROP", 0, "server drop message");
            SERVER_DROP = r0;
            Reason r1 = new Reason("FULL_DISK", 1, "disk is full");
            FULL_DISK = r1;
            $VALUES = new Reason[]{r0, r1};
        }

        private Reason(String r1, int r2, String r3) {
            super(r1, r2);
            this.reason = r3;
        }

        public static Reason valueOf(String r2) {
            return (Reason) ZeusTransformUtils.preCheckCast(Enum.valueOf(Reason.class, r2), Reason.class, "com.obric.memorydata.plugin");
        }

        public static Reason[] values() {
            return (Reason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Reason[].class, "com.obric.memorydata.plugin");
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
        SharedPreferences r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSharedPreferences(ApmContext.getCurrentProcessName() + "_" + KEY_SP_NAME, 0);     // Catch: Throwable -> L13
        this.sharedPreferences = r0;     // Catch: Throwable -> L13
        String r1 = r0.getString(KEY_DROP_ITEMS, "");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r1) == false) goto L17;
    L11:
        monitor-exit(this);
        return;
    L17:
        this.items = new JSONArray(r1);     // Catch: Exception -> L16 Throwable -> L13
        goto L11
    }

    static DropDataMonitor getInstance() {
        return InnerHolder.access$000();
    }

    JSONArray getItems() {
        ensureInit();
        JSONArray r0 = new JSONArray();
        JSONArray r1 = new JSONArray();
        int r2 = 0;
    L13:
        if (r2 >= this.items.length()) goto L10;
        if (r2 >= 10) goto L8;
        r0.put(this.items.get(r2));     // Catch: Exception -> L12
    L9:
        r2 = r2 + 1;
        goto L13
    L8:
        r1.put(this.items.get(r2));     // Catch: Exception -> L12
    L10:
        this.items = r1;
        this.sharedPreferences.edit().putString(KEY_DROP_ITEMS, this.items.toString()).commit();
        return r0;
    }

    void monitorDropLog(long r5, long r7, long r9, Reason r11) {
        ensureInit();
        JSONObject r1 = new JSONObject();
        r1.put("log_type", LOG_TYPE);     // Catch: Exception -> L13
        r1.put("timestamp", r9);     // Catch: Exception -> L13
        r1.put(KEY_DROP_COUNT, r5);     // Catch: Exception -> L13
        r1.put(KEY_DROP_BYTES, r7);     // Catch: Exception -> L13
        if (r11 != Reason.SERVER_DROP) goto L6;
        r1.put(KEY_DROP_LOG_ID, this.serverLogId);     // Catch: Exception -> L13
        r1.put(KEY_DROP_SERVER_TIME, this.serverDropTime);     // Catch: Exception -> L13
    L6:
        if (r11 == null) goto L8;
        r1.put(KEY_DROP_DATA_REASON, r11);     // Catch: Exception -> L13
    L8:
        this.items.put(r1);     // Catch: Exception -> L13
        if (ApmContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "monitorDropLog:" + this.items.toString());     // Catch: Exception -> L13
    L11:
        this.sharedPreferences.edit().putString(KEY_DROP_ITEMS, this.items.toString()).commit();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        Logger.e(Constants.TAG, "monitorDropLog:", e);
    }

    void setServerLogId(String r1) {
        this.serverLogId = r1;
    }

    void setServerTimeStamp(long r1) {
        this.serverDropTime = r1;
    }
}
