package com.bytedance.android.ec.core.utils;

import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s0 {
    public static void a(Object r1) {
        EventBus.getDefault().post(r1);
    }

    public static void b(Object r1) {
        EventBus.getDefault().postSticky(r1);
    }

    public static void c(Object r1) {
        if (EventBus.getDefault().isRegistered(r1) == true) goto L6;
        EventBus.getDefault().register(r1);
        return;
    }

    public static <T> void d(Class<T> r1) {
        Object r10 = EventBus.getDefault().getStickyEvent(r1);
        if (r10 == null) goto L6;
        EventBus.getDefault().removeStickyEvent(r10);
        return;
    }

    public static void e(Object r1) {
        if (EventBus.getDefault().isRegistered(r1) == false) goto L6;
        EventBus.getDefault().unregister(r1);
        return;
    }
}
