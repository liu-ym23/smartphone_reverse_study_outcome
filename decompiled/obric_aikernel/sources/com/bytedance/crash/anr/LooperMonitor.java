package com.bytedance.crash.anr;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class LooperMonitor {
    private static MessageQueue mMainQueue;
    private static Field mMessagesField;
    private static Field mNextMessageField;

    public LooperMonitor() {
    }

    public static List<Message> dumpPendingMessages(int r10) {
        MessageQueue r11 = getMainMessageQueue();
        if (r11 != null) goto L5;
        return null;
    L5:
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        monitor-enter(r11);
        Message r14 = getMessageObject(r11);     // Catch: Throwable -> L17
        if (r14 != null) goto L11;
        monitor-exit(r11);     // Catch: Throwable -> L17
        return null;
    L11:
        if (r14 == null) goto L15;
        int r15 = r13 + 1;     // Catch: Throwable -> L17
        if (r13 >= r10) goto L15;
        r12.add(r14);     // Catch: Throwable -> L17
        r14 = getNextMessage(r14);     // Catch: Throwable -> L17
        r13 = r15;
    L15:
        monitor-exit(r11);     // Catch: Throwable -> L17
        return r12;
    L17:
        th = move-exception;
        throw th;
    }

    public static MessageQueue getMainMessageQueue() {
        if (mMainQueue != null) goto L18;
        if (Looper.getMainLooper() == null) goto L18;
        Looper r10 = Looper.getMainLooper();
        if (r10 != Looper.myLooper()) goto L11;
        MessageQueue r11 = Looper.myQueue();
    L9:
        mMainQueue = r11;
        goto L18
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        r11 = r10.getQueue();
        goto L9
    L19:
        Field r12 = r10.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L15
        r12.setAccessible(true);     // Catch: Throwable -> L15
        mMainQueue = (MessageQueue) r12.get(r10);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
    L18:
        return mMainQueue;
    }

    private static Message getMessageObject(MessageQueue r10) {
        Field r11 = mMessagesField;
        if (r11 != null) goto L12;
        Field r12 = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");     // Catch: Exception -> L6
        mMessagesField = r12;     // Catch: Exception -> L6
        r12.setAccessible(true);     // Catch: Exception -> L6
        return (Message) mMessagesField.get(r10);
    L6:
        return null;
    L12:
        return (Message) r11.get(r10);
    L9:
        return null;
    }

    private static Message getNextMessage(Message r10) {
        Field r11 = mNextMessageField;
        if (r11 != null) goto L12;
        Field r12 = Class.forName("android.os.Message").getDeclaredField("next");     // Catch: Exception -> L6
        mNextMessageField = r12;     // Catch: Exception -> L6
        r12.setAccessible(true);     // Catch: Exception -> L6
        return (Message) mNextMessageField.get(r10);
    L6:
        return null;
    L12:
        return (Message) r11.get(r10);
    L9:
        return null;
    }
}
