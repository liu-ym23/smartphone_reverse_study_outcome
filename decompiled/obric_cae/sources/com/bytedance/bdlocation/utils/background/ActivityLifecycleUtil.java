package com.bytedance.bdlocation.utils.background;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.lifecycle.m;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class ActivityLifecycleUtil implements k {
    private static List<ActivityNotification> sNotifications;

    public interface ActivityNotification {
        void onAppBackgroundNotify(boolean r8);
    }

    static {
        sNotifications = new ArrayList();
    }

    private ActivityLifecycleUtil() {
    }

    public /* synthetic */ ActivityLifecycleUtil(AnonymousClass1 r8) {
        this();
    }

    public static void init() {
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1());
    }

    private static void notifySwitch(boolean r8) {
        monitor-enter(ActivityLifecycleUtil.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (CollectionUtil.isEmpty(sNotifications) == true) goto L10;
        Iterator<ActivityNotification> r10 = sNotifications.iterator();     // Catch: Throwable -> L12
    L8:
        if (r10.hasNext() == false) goto L10;
        r10.next().onAppBackgroundNotify(r8);     // Catch: Throwable -> L12
    L10:
        monitor-exit(ActivityLifecycleUtil.class);     // Catch: Throwable -> L12
    }

    public static void register(ActivityNotification r8) {
        monitor-enter(ActivityLifecycleUtil.class);
        sNotifications.add(r8);     // Catch: Throwable -> L7
        monitor-exit(ActivityLifecycleUtil.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void unregister(ActivityNotification r8) {
        monitor-enter(ActivityNotification.class);
        sNotifications.remove(r8);     // Catch: Throwable -> L7
        monitor-exit(ActivityNotification.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.lifecycle.k
    public void onStateChanged(m r8, h.a r10) {
        Logger.d("onStateChanged", "onStateChanged: event =" + r10);
        if (r10 != h.a.ON_START) goto L7;
        Logger.i("LifecycleObserver onAppForeground");
        boolean r11 = false;
    L5:
        notifySwitch(r11);
        return;
    L7:
        if (r10 != h.a.ON_STOP) goto L10;
        Logger.i("LifecycleObserver onAppBackground");
        r11 = true;
        goto L5
    }
}
