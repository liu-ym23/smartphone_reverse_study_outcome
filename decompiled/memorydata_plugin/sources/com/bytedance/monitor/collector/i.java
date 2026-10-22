package com.bytedance.monitor.collector;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MessageQueue f2861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f2862b;
    private static Field c;

    static {
    }

    public static Message a(Message r4) {
        Field r0 = c;
        if (r0 != null) goto L12;
        Field r1 = ZeusTransformUtils.forName("android.os.Message", "com.obric.memorydata.plugin").getDeclaredField("next");     // Catch: Exception -> L6
        c = r1;     // Catch: Exception -> L6
        r1.setAccessible(true);     // Catch: Exception -> L6
        return (Message) ZeusTransformUtils.preCheckCast(c.get(r4), Message.class, "com.obric.memorydata.plugin");
    L6:
        return null;
    L12:
        return (Message) ZeusTransformUtils.preCheckCast(r0.get(r4), Message.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    public static Message a(MessageQueue r4) {
        Field r0 = f2862b;
        if (r0 != null) goto L12;
        Field r1 = ZeusTransformUtils.forName("android.os.MessageQueue", "com.obric.memorydata.plugin").getDeclaredField("mMessages");     // Catch: Exception -> L6
        f2862b = r1;     // Catch: Exception -> L6
        r1.setAccessible(true);     // Catch: Exception -> L6
        return (Message) ZeusTransformUtils.preCheckCast(f2862b.get(r4), Message.class, "com.obric.memorydata.plugin");
    L6:
        return null;
    L12:
        return (Message) ZeusTransformUtils.preCheckCast(r0.get(r4), Message.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    public static MessageQueue a() {
        if (f2861a != null) goto L18;
        if (Looper.getMainLooper() == null) goto L18;
        Looper r0 = Looper.getMainLooper();
        if (r0 != Looper.myLooper()) goto L11;
        MessageQueue r1 = Looper.myQueue();
    L9:
        f2861a = r1;
        goto L18
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        r1 = r0.getQueue();
        goto L9
    L19:
        Field r2 = r0.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L15
        r2.setAccessible(true);     // Catch: Throwable -> L15
        f2861a = (MessageQueue) ZeusTransformUtils.preCheckCast(r2.get(r0), MessageQueue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
    L18:
        return f2861a;
    }
}
