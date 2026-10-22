package com.bytedance.bdinstall.dtrait.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.bytedance.bdinstall.dtrait.utils.DTraitTraceUtil;
import com.bytedance.bdinstall.dtrait.utils.Utils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class DTraitCacheManager {
    private final Map<String, String> cache;
    private final Condition condition;
    private final SharedPreferences.Editor editor;
    private volatile boolean isUpdated;
    private final ReentrantLock lock;
    private final SharedPreferences sp;

    private static class CacheEntry {
        private final long expireAt;
        private final String value;

        public CacheEntry(String r1, long r2) {
            this.value = r1;
            this.expireAt = r2;
        }

        public long getExpireAt() {
            return this.expireAt;
        }

        public String getValue() {
            return this.value;
        }
    }

    public DTraitCacheManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.isUpdated = false;
        ReentrantLock r0 = new ReentrantLock();
        this.lock = r0;
        this.condition = r0.newCondition();
        this.cache = new HashMap();
        SharedPreferences r5 = Utils.getCommonSp(r4);
        this.sp = r5;
        this.editor = r5.edit();
    }

    private boolean isExpired(CacheEntry r3) {
        if (System.currentTimeMillis() <= r3.getExpireAt()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean awaitUpdate(long r3, TimeUnit r5) {
        this.lock.lock();
    L18:
    L15:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L5:
        if (this.isUpdated == true) goto L12;
        if (this.condition.await(r3, r5) == true) goto L18;
    L8:
        this.lock.unlock();
        return false;
    L10:
        e = move-exception;
        DTLog.e("[dt] awaitUpdate# await error " + e.getMessage());     // Catch: Throwable -> L15
        goto L8
    L12:
        this.isUpdated = false;     // Catch: Throwable -> L15
        DTLog.d("[dt] awaitUpdate# await done.");     // Catch: Throwable -> L15
        this.lock.unlock();
        return true;
    }

    public String getCache(String r5) {
        this.lock.lock();
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.cache.get(r5), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        String r2 = "";
        if (TextUtils.isEmpty(r0) == false) goto L9;
        r0 = this.sp.getString(r5, "");     // Catch: Throwable -> L13
        if (DTLog.debug() == false) goto L9;
        DTLog.d("[dt] getCacheOrFromDisk# check cache: " + r5 + " is empty, read from sp and update cache.");     // Catch: Throwable -> L13
    L9:
        if (r0 == null) goto L11;
        r2 = r0;
    L11:
        this.lock.unlock();
        return r2;
    L13:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public String getCacheOrFromDisk(String r5) {
        this.lock.lock();
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.cache.get(r5), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        String r2 = "";
        if (TextUtils.isEmpty(r0) == false) goto L11;
        r0 = this.sp.getString(r5, "");     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r0) == true) goto L11;
        this.cache.put(r5, r0);     // Catch: Throwable -> L15
        if (DTLog.debug() == false) goto L11;
        DTLog.d("[dt] getCacheOrFromDisk# check cache: " + r5 + " is empty, read from sp and update cache.");     // Catch: Throwable -> L15
    L11:
        if (r0 == null) goto L13;
        r2 = r0;
    L13:
        this.lock.unlock();
        return r2;
    L15:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public String getValueFromSp(String r2) {
        return this.sp.getString(r2, "");
    }

    public void updateDiskCache(String r2, String r3) {
        this.editor.putString(r2, r3);     // Catch: Exception -> L4
        this.editor.commit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        DTLog.e("[dt] updateDiskCache# error " + e.getMessage());
    }

    public void updateDiskCache(Map<String, String> r7) {
        Iterator r8 = ((Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();     // Catch: Throwable -> L11
    L5:
        if (r8.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        this.editor.putString((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        if (DTLog.debug() == false) goto L5;
        DTLog.d("[dt] updateDiskCache# update disk success, key: " + ((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L11
        goto L5
    L9:
        this.editor.commit();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        DTraitTraceUtil.log(DTraitLogLevel.ERROR, DTraitConstant.BUSINESS_TAG_DEVICE, DTraitConstant.METHOD_CACHE_DTRAIT_INFO, String.format("updateDiskCache# write error: %s", new Object[]{th.getMessage()}), th);
    }

    public void updateMemoryCache(String r2, String r3) {
        this.lock.lock();
        this.cache.put(r2, r3);     // Catch: Throwable -> L6
        DTLog.d("[dt] updateMemoryCacheBySync# update mem success, key: " + r2);     // Catch: Throwable -> L6
        this.lock.unlock();
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void updateMemoryCache(Map<String, String> r3) {
        Map<? extends String, ? extends String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.lock.lock();
    L10:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L4:
        if (r4.isEmpty() == false) goto L7;
        this.lock.unlock();
        return;
    L7:
        this.cache.putAll(r4);     // Catch: Throwable -> L10
        this.isUpdated = true;     // Catch: Throwable -> L10
        this.condition.signalAll();     // Catch: Throwable -> L10
        DTLog.d("[dt] updateMemoryCacheBySync# update mem map success, wake up the waiting thread......");     // Catch: Throwable -> L10
        this.lock.unlock();
    }
}
