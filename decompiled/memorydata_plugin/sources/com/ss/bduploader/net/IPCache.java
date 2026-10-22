package com.ss.bduploader.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes6.dex */
public class IPCache {
    private static IPCache mInstance = null;
    private static String mNetExtraInfo = null;
    private static int mNetType = -1;
    private Lock lock;
    private ConcurrentHashMap<String, BDUploadDNSInfo> mDNSRecord;

    static {
    }

    private IPCache() {
        this.mDNSRecord = new ConcurrentHashMap();
        this.lock = new ReentrantLock();
    }

    public static IPCache getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(IPCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new IPCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(IPCache.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void clear() {
        this.lock.lock();
        ConcurrentHashMap<String, BDUploadDNSInfo> r0 = this.mDNSRecord;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.clear();     // Catch: Throwable -> L8
    L6:
        this.lock.unlock();
        return;
    L8:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public BDUploadDNSInfo get(String r3) {
        this.lock.lock();
        ConcurrentHashMap<String, BDUploadDNSInfo> r0 = this.mDNSRecord;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        BDUploadDNSInfo r4 = (BDUploadDNSInfo) ZeusTransformUtils.preCheckCast(r0.get(r3), BDUploadDNSInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L8:
        this.lock.unlock();
        return r4;
    L7:
        r4 = null;
    L10:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public String getCurNetExtraInfo() {
        return mNetExtraInfo;
    }

    public int getCurNetType() {
        return mNetType;
    }

    public int getRecordSize() {
        this.lock.lock();
        ConcurrentHashMap<String, BDUploadDNSInfo> r0 = this.mDNSRecord;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        int r1 = r0.size();     // Catch: Throwable -> L10
    L8:
        this.lock.unlock();
        return r1;
    L7:
        r1 = -1;
    L10:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void put(String r2, BDUploadDNSInfo r3) {
        this.lock.lock();
        ConcurrentHashMap<String, BDUploadDNSInfo> r0 = this.mDNSRecord;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.put(r2, r3);     // Catch: Throwable -> L8
    L6:
        this.lock.unlock();
        return;
    L8:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void setCurNetExtraInfo(String r1) {
        mNetExtraInfo = r1;
    }

    public void setCurNetType(int r1) {
        mNetType = r1;
    }
}
