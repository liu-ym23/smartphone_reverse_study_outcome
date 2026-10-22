package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.content.Context;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DowngradeController {
    public static final String FIELD_LOG_TYPE = "log_type";
    public static final String FIELD_SERVICE = "service";
    private DowngradeDataStorage mDataStorage;
    public volatile DowngradeInfo mInfo;

    private static class SINGLETON {
        private static final DowngradeController sInstance = null;

        static {
            sInstance = new DowngradeController();
        }

        private SINGLETON() {
        }

        static /* synthetic */ DowngradeController access$000() {
            return sInstance;
        }
    }

    public DowngradeController() {
    }

    public static DowngradeController getInstance() {
        return SINGLETON.access$000();
    }

    public void init(Context r10) {
        DowngradeDataStorage r11 = new DowngradeDataStorage(r10);
        this.mDataStorage = r11;
        setDowngradeInfo(r11.loadFromSp(), false);
    }

    public void setDowngradeInfo(@Nullable DowngradeInfo r10, boolean r11) {
        if (r10 == null) goto L13;
        monitor-enter(this);
        this.mInfo = r10;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        if (r11 == false) goto L16;
        DowngradeDataStorage r12 = this.mDataStorage;
        if (r12 == null) goto L17;
        r12.save(r10);
        return;
    L17:
        return;
    L16:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean uploadEnabled(JSONObject r10, int r11) {
        boolean r12 = true;
        if (this.mInfo != null) goto L5;
    L46:
        return true;
    L5:
        if (System.currentTimeMillis() > this.mInfo.expireTime) goto L46;
        String r13 = String.valueOf(r11);
        String r14 = r10.optString("log_type");
        monitor-enter(this);
        DowngradeInfo.LogType r15 = DowngradeInfo.LogType.SERVICE_MONITOR;     // Catch: Throwable -> L43
        if (r15.logType.equals(r14) == false) goto L26;
        String r16 = r10.optString("service");     // Catch: Throwable -> L43
        DowngradeInfo.SubInfo r17 = this.mInfo.mEventMap.get(r15);     // Catch: Throwable -> L43
        if (r17 == null) goto L41;
        JSONObject r18 = r17.aidMap.get(r13);     // Catch: Throwable -> L43
        if (r18 != null) goto L16;
    L23:
        boolean r19 = r17.defaultRate;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return r19;
    L16:
        if (r18.optInt(r16, -1) == (-1)) goto L23;
        if (r18.optInt(r16, -1) == 1) goto L21;
        r12 = false;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L43
        return r12;
    L41:
        monitor-exit(this);     // Catch: Throwable -> L43
        return true;
    L26:
        DowngradeInfo.SubInfo r20 = this.mInfo.mEventMap.get(DowngradeInfo.LogType.OTHER_LOG_TYPE);     // Catch: Throwable -> L43
        if (r20 == null) goto L41;
        JSONObject r21 = r20.aidMap.get(r13);     // Catch: Throwable -> L43
        if (r21 != null) goto L31;
    L38:
        boolean r22 = r20.defaultRate;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return r22;
    L31:
        if (r21.optInt(r14, -1) == (-1)) goto L38;
        if (r21.optInt(r14, -1) == 1) goto L36;
        r12 = false;
    L36:
        monitor-exit(this);     // Catch: Throwable -> L43
        return r12;
    L43:
        th = move-exception;
        throw th;
    }
}
