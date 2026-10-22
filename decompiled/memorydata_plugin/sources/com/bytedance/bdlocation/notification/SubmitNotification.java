package com.bytedance.bdlocation.notification;

import com.bytedance.bdlocation.callback.LightLocationSubmitNotification;
import com.bytedance.bdlocation.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SubmitNotification {
    private static volatile SubmitNotification mInstance;
    private List<LightLocationSubmitNotification> mLightSubmitNotifications;

    public SubmitNotification() {
        this.mLightSubmitNotifications = new CopyOnWriteArrayList();
    }

    public static SubmitNotification getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(SubmitNotification.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new SubmitNotification();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SubmitNotification.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void addLightLocationSubmitNotification(LightLocationSubmitNotification r3) {
        LightLocationSubmitNotification r4 = (LightLocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r3, LightLocationSubmitNotification.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L9;
        return;
    L9:
        this.mLightSubmitNotifications.add(r4);     // Catch: IndexOutOfBoundsException -> L7
        return;
    L7:
        Logger.i("add IndexOutOfBoundsException");
    }

    public void executeLightLocationSubmitNotification() {
        if (this.mLightSubmitNotifications.size() != 0) goto L5;
        return;
    L5:
        Iterator<LightLocationSubmitNotification> r3 = this.mLightSubmitNotifications.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        LightLocationSubmitNotification r0 = (LightLocationSubmitNotification) ZeusTransformUtils.preCheckCast(r3.next(), LightLocationSubmitNotification.class, "com.obric.memorydata.plugin");
        Logger.i("LightLocationSubmitNotification#onSubmitListener");
        r0.onSubmitListener();
        goto L7
    }

    public List<LightLocationSubmitNotification> getLightLocationSubmitNotification() {
        return this.mLightSubmitNotifications;
    }

    public void removeLightLocationSubmitNotification(LightLocationSubmitNotification r3) {
        LightLocationSubmitNotification r4 = (LightLocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r3, LightLocationSubmitNotification.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L9;
        return;
    L9:
        this.mLightSubmitNotifications.remove(r4);     // Catch: IndexOutOfBoundsException -> L7
        return;
    L7:
        Logger.i(" remove IndexOutOfBoundsException");
    }
}
