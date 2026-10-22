package com.bytedance.memory.test;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.Storage;
import java.util.ArrayList;
import p3.d;
import s3.a;

/* JADX INFO: loaded from: classes.dex */
public class OOMMaker {
    private static ArrayList<Byte[]> sArrayList;

    static {
        sArrayList = new ArrayList();
    }

    public OOMMaker() {
    }

    public static void createOOM() {
        new a().onCrash(CrashType.JAVA, new OutOfMemoryError("test"), Thread.currentThread(), System.currentTimeMillis());
    }

    public static void createReachTop(int r10) {
    L3:
        if (d.c() >= r10) goto L9;
        encreaseMem(Storage.UNIT);
        Thread.sleep(500);     // Catch: InterruptedException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L3
    }

    public static void encreaseMem() {
        encreaseMem(15728640);
    }

    private static void encreaseMem(int r10) {
        sArrayList.add(new Byte[r10]);
    }
}
