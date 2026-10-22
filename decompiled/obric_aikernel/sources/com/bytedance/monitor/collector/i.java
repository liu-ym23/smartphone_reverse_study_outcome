package com.bytedance.monitor.collector;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MessageQueue f2333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f2334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f2335c;

    static {
    }

    public static MessageQueue a() {
        if (f2333a != null) goto L18;
        if (Looper.getMainLooper() == null) goto L18;
        Looper r10 = Looper.getMainLooper();
        if (r10 != Looper.myLooper()) goto L11;
        MessageQueue r11 = Looper.myQueue();
    L9:
        f2333a = r11;
        goto L18
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        r11 = r10.getQueue();
        goto L9
    L19:
        Field r12 = r10.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L15
        r12.setAccessible(true);     // Catch: Throwable -> L15
        f2333a = (MessageQueue) r12.get(r10);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
    L18:
        return f2333a;
    }

    public static Message b(MessageQueue r10) {
        Field r11 = f2334b;
        if (r11 != null) goto L12;
        Field r12 = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");     // Catch: Exception -> L6
        f2334b = r12;     // Catch: Exception -> L6
        r12.setAccessible(true);     // Catch: Exception -> L6
        return (Message) f2334b.get(r10);
    L6:
        return null;
    L12:
        return (Message) r11.get(r10);
    L9:
        return null;
    }

    protected static Message c(Message r10) {
        Field r11 = f2335c;
        if (r11 != null) goto L12;
        Field r12 = Class.forName("android.os.Message").getDeclaredField("next");     // Catch: Exception -> L6
        f2335c = r12;     // Catch: Exception -> L6
        r12.setAccessible(true);     // Catch: Exception -> L6
        return (Message) f2335c.get(r10);
    L6:
        return null;
    L12:
        return (Message) r11.get(r10);
    L9:
        return null;
    }
}
