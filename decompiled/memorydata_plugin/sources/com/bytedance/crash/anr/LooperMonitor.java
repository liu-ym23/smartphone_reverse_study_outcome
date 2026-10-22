package com.bytedance.crash.anr;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class LooperMonitor {
    private static MessageQueue mMainQueue;
    private static Field mMessagesField;
    private static Field mNextMessageField;

    public LooperMonitor() {
    }

    public static List<Message> dumpPendingMessages(int r5) {
        MessageQueue r0 = getMainMessageQueue();
        if (r0 != null) goto L5;
        return null;
    L5:
        ArrayList r2 = new ArrayList();
        int r3 = 0;
        monitor-enter(r0);
        Message r4 = getMessageObject(r0);     // Catch: Throwable -> L17
        if (r4 != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    L11:
        if (r4 == null) goto L15;
        int r1 = r3 + 1;     // Catch: Throwable -> L17
        if (r3 >= r5) goto L15;
        r2.add(r4);     // Catch: Throwable -> L17
        r4 = getNextMessage(r4);     // Catch: Throwable -> L17
        r3 = r1;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r2;
    L17:
        th = move-exception;
        throw th;
    }

    public static MessageQueue getMainMessageQueue() {
        if (mMainQueue != null) goto L18;
        if (Looper.getMainLooper() == null) goto L18;
        Looper r0 = Looper.getMainLooper();
        if (r0 != Looper.myLooper()) goto L11;
        MessageQueue r1 = Looper.myQueue();
    L9:
        mMainQueue = r1;
        goto L18
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        r1 = r0.getQueue();
        goto L9
    L19:
        Field r2 = r0.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L15
        r2.setAccessible(true);     // Catch: Throwable -> L15
        mMainQueue = (MessageQueue) ZeusTransformUtils.preCheckCast(r2.get(r0), MessageQueue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
    L18:
        return mMainQueue;
    }

    private static Message getMessageObject(MessageQueue r4) {
        Field r0 = mMessagesField;
        if (r0 != null) goto L12;
        Field r1 = ZeusTransformUtils.forName("android.os.MessageQueue", "com.obric.memorydata.plugin").getDeclaredField("mMessages");     // Catch: Exception -> L6
        mMessagesField = r1;     // Catch: Exception -> L6
        r1.setAccessible(true);     // Catch: Exception -> L6
        return (Message) ZeusTransformUtils.preCheckCast(mMessagesField.get(r4), Message.class, "com.obric.memorydata.plugin");
    L6:
        return null;
    L12:
        return (Message) ZeusTransformUtils.preCheckCast(r0.get(r4), Message.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    private static Message getNextMessage(Message r4) {
        Field r0 = mNextMessageField;
        if (r0 != null) goto L12;
        Field r1 = ZeusTransformUtils.forName("android.os.Message", "com.obric.memorydata.plugin").getDeclaredField("next");     // Catch: Exception -> L6
        mNextMessageField = r1;     // Catch: Exception -> L6
        r1.setAccessible(true);     // Catch: Exception -> L6
        return (Message) ZeusTransformUtils.preCheckCast(mNextMessageField.get(r4), Message.class, "com.obric.memorydata.plugin");
    L6:
        return null;
    L12:
        return (Message) ZeusTransformUtils.preCheckCast(r0.get(r4), Message.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }
}
