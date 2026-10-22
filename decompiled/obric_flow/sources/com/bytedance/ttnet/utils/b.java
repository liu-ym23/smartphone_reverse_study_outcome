package com.bytedance.ttnet.utils;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f7537a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ArrayList f7538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReentrantReadWriteLock.ReadLock f7539c = null;
    public static final ReentrantReadWriteLock.WriteLock d = null;

    static {
        f7538b = new ArrayList();
        ReentrantReadWriteLock r5 = new ReentrantReadWriteLock();
        f7539c = r5.readLock();
        d = r5.writeLock();
    }
}
