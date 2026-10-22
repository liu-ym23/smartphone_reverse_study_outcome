package com.bytedance.news.common.settings.bytesync;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.api.model.SettingsByteSyncModel;
import java.util.Iterator;
import pg.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        SettingsByteSyncModel r5 = new SettingsByteSyncModel();
        r5.callerName = SettingsByteSyncManager.access$000();
        r5.taskData = SettingsByteSyncManager.access$100();
        r5.taskId = SettingsByteSyncManager.access$200();
        r5.taskType = SettingsByteSyncManager.access$300();
        r5.timeStamp = SettingsByteSyncManager.access$400() * 1000;
        SettingsByteSyncManager.access$102(SettingsByteSyncManager.access$202(""));
        if (TextUtils.isEmpty(SettingsByteSyncManager.access$000()) == false) goto L21;
        Handler r10 = e.f21353a;
        if (r5.timeStamp >= Math.max(0, 0)) goto L8;
        Log.e("SettingsManager", "settingsByteSyncModel.timeStamp = " + r5.timeStamp + " initTime = 0 requestTime = 0");
    L28:
        SettingsByteSyncManager.access$602(0);
        return;
    L8:
        monitor-enter(e.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (og.a.a(SettingsConfigProvider.class) != null) goto L17;
        monitor-exit(e.class);     // Catch: Throwable -> L14
        throw new IllegalStateException("SettingsManager尚未被配置");
    L17:
        throw new ClassCastException();     // Catch: Throwable -> L14
    L21:
        if (SettingsByteSyncManager.access$500() == null) goto L28;
        Iterator r11 = SettingsByteSyncManager.access$500().iterator();
    L24:
        if (r11.hasNext() == false) goto L28;
        SettingsByteSyncManager.SettingsByteSyncListener r12 = (SettingsByteSyncManager.SettingsByteSyncListener) r11.next();
        if (r12 == null) goto L24;
        r12.onSettingsSyncRequest(r5);
        goto L24
    }
}
