package com.bytedance.android.btm.impl.util;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static MessageQueue a;

    public static final class a implements MessageQueue.IdleHandler {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            this.a.invoke();
            return false;
        }
    }

    static {
    }

    public static void a(Function0 r10) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L17:
        r10.invoke();
        return;
    L5:
        if (BtmSetting.d.c().d().o() != 1) goto L17;
        if (a != null) goto L13;
        Looper r0 = Looper.getMainLooper();
        if (r0 == null) goto L11;
        MessageQueue r1 = r0.getQueue();
    L12:
        a = r1;
        goto L13
    L11:
        r1 = null;
    L13:
        MessageQueue r11 = a;
        if (r11 == null) goto L16;
        r11.addIdleHandler(new a(r10));
        return;
    L16:
        r10.invoke();
    }
}
