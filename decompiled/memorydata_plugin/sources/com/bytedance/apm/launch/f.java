package com.bytedance.apm.launch;

import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static Intent a() {
        MessageQueue r0 = (MessageQueue) ZeusTransformUtils.preCheckCast(com.bytedance.monitor.util.b.a(Looper.getMainLooper(), "mQueue"), MessageQueue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        monitor-enter(r0);     // Catch: Throwable -> L39
        Message r1 = (Message) ZeusTransformUtils.preCheckCast(com.bytedance.monitor.util.b.a(r0, "mMessages"), Message.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        if (r1 != null) goto L7;
    L18:
        Field r4 = com.bytedance.monitor.util.b.a(Message.class, "next");     // Catch: Throwable -> L36
        r4.setAccessible(true);     // Catch: Throwable -> L36
    L19:
        if (r1 == null) goto L34;
        r1 = (Message) ZeusTransformUtils.preCheckCast(com.bytedance.monitor.util.b.a(r4, r1), Message.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        if (r1 == null) goto L19;
        if (r1.getTarget() != com.bytedance.monitor.util.a.d()) goto L19;
        if (com.bytedance.monitor.util.a.a(r1) == false) goto L19;
        int r5 = r1.what;     // Catch: Throwable -> L36
        if (r5 == 100) goto L30;
        if (r5 != 159) goto L19;
    L30:
        Intent r6 = d(r1);     // Catch: Throwable -> L36
        if (r6 == null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L36
        return r6;
    L34:
        monitor-exit(r0);     // Catch: Throwable -> L36
        return null;
    L7:
        if (r1.getTarget() != com.bytedance.monitor.util.a.d()) goto L18;
        if (com.bytedance.monitor.util.a.a(r1) == false) goto L18;
        int r7 = r1.what;     // Catch: Throwable -> L36
        if (r7 == 100) goto L14;
        if (r7 != 159) goto L18;
    L14:
        Intent r8 = d(r1);     // Catch: Throwable -> L36
        if (r8 == null) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L36
        return r8;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    static Intent a(Message r5) {
        Object r0 = r5.obj;
        if (Build.VERSION.SDK_INT >= 28) goto L11;
        if (r5.what != 100) goto L11;
        return (Intent) ZeusTransformUtils.preCheckCast(com.bytedance.monitor.util.b.a(r0, MemorySourceLinkType.INTENT), Intent.class, "com.obric.memorydata.plugin");
    L11:
        if (Build.VERSION.SDK_INT >= 28) goto L13;
        return null;
    L13:
        if (r5.what != 159) goto L33;
        List r6 = (List) ZeusTransformUtils.preCheckCast(com.bytedance.monitor.util.b.a(r0, "mActivityCallbacks"), List.class, "com.obric.memorydata.plugin");     // Catch: IllegalAccessException -> L8
        if (r6 == null) goto L34;
        int r1 = 0;
    L18:
        if (r1 >= r6.size()) goto L35;
        Object r2 = r6.get(r1);     // Catch: IllegalAccessException -> L8
        if (r2 == null) goto L24;
        Intent r3 = (Intent) ZeusTransformUtils.preCheckCast(com.bytedance.monitor.util.b.a(r2, "mIntent"), Intent.class, "com.obric.memorydata.plugin");     // Catch: IllegalAccessException -> L8
        if (r3 == null) goto L24;
        return r3;
    L24:
        r1 = r1 + 1;
        goto L18
    L35:
        return null;
    L34:
        return null;
    L33:
        return null;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    static Intent b(Message r2) {
        if (r2.what != 114) goto L5;
    L11:
        String r0 = MemorySourceLinkType.INTENT;
    L13:
        if (r0.isEmpty() == false) goto L15;
        return null;
    L15:
        if (r2.obj == null) goto L25;
        return (Intent) ZeusTransformUtils.preCheckCast(com.bytedance.monitor.util.b.a(r2.obj, r0), Intent.class, "com.obric.memorydata.plugin");
    L18:
        th = move-exception;
        th.printStackTrace();
        return null;
    L25:
        return null;
    L5:
        if (r2.what == 121) goto L11;
        if (r2.what != 115) goto L10;
        r0 = "args";
        goto L13
    L10:
        r0 = "";
        goto L13
    }

    static Intent c(Message r2) {
        if (r2.what != 113) goto L5;
        String r0 = MemorySourceLinkType.INTENT;
    L7:
        if (r0.isEmpty() == false) goto L9;
        return null;
    L9:
        if (r2.obj == null) goto L19;
        return (Intent) ZeusTransformUtils.preCheckCast(com.bytedance.monitor.util.b.a(r2.obj, r0), Intent.class, "com.obric.memorydata.plugin");
    L12:
        th = move-exception;
        th.printStackTrace();
        return null;
    L19:
        return null;
    L5:
        r0 = "";
        goto L7
    }

    private static Intent d(Message r2) {
        int r0 = r2.what;
        if (r0 == 100) goto L16;
        if (r0 == 121) goto L14;
        if (r0 == 159) goto L16;
        switch(r0) {
            case 113: goto L12;
            case 114: goto L14;
            case 115: goto L14;
            default: goto L9;
        };
    L9:
        return null;
    L12:
        return c(r2);
    L14:
        return b(r2);
    L16:
        return a(r2);
    }
}
