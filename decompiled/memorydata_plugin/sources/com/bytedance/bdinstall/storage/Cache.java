package com.bytedance.bdinstall.storage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class Cache implements ICache {
    private Cache mSuccessor;

    interface ICacheAgent<L> {
        boolean checkValid(L r1);

        L getCache();

        boolean isValueEqual(L r1, L r2);

        L load(L r1, L r2, Cache r3);

        void restoreCache(L r1);
    }

    public Cache() {
    }

    private Cache getSuccessor() {
        return this.mSuccessor;
    }

    private <T> T load(T r4, T r5, ICacheAgent<T> r6) {
        ICacheAgent r7 = (ICacheAgent) ZeusTransformUtils.wrapperContextForParams(r6, ICacheAgent.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L27;
        Cache r3 = getSuccessor();
        Object r0 = r7.getCache();
        boolean r1 = r7.checkValid(r4);
        boolean r2 = r7.checkValid(r0);
        if (r1 == true) goto L8;
        if (r2 == false) goto L8;
        r4 = (T) r0;
    L8:
        if (r3 == null) goto L13;
        T r8 = (T) r7.load(r4, r5, r3);
        if (r7.isValueEqual(r8, r0) == true) goto L12;
        r7.restoreCache(r8);
    L12:
        return r8;
    L13:
        boolean r9 = false;
        if (r1 == true) goto L17;
        if (r2 == true) goto L17;
        r9 = true;
    L18:
        if (r9 == true) goto L20;
    L21:
        if (r1 == true) goto L23;
    L25:
        return r5;
    L23:
        if (r7.isValueEqual(r5, r0) == true) goto L25;
    L24:
        r7.restoreCache(r5);
        goto L25
    L20:
        if (r7.checkValid(r5) == true) goto L24;
    L17:
        r5 = r4;
        goto L18
    L27:
        throw new IllegalArgumentException("agent == null");
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public abstract void cacheString(String r1, String r2);

    public abstract void cacheStringArray(String r1, String[] r2);

    @Override // com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Cache r2 = getSuccessor();
        if (r2 == null) goto L6;
        r2.clear(r4);
        return;
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public abstract String getCachedString(String r1);

    public abstract String[] getCachedStringArray(String r1);

    @Override // com.bytedance.bdinstall.storage.ICache
    public String[] loadAccId(String[] r2, String[] r3) {
        return (String[]) ZeusTransformUtils.preCheckCast(load(r2, r3, new AnonymousClass4(this)), String[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadClientUdid(String r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(load(r2, r3, new AnonymousClass2(this)), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadDeviceId(String r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(load(r2, r3, new AnonymousClass6(this)), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadOpenUdid(String r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(load(r2, r3, new AnonymousClass1(this)), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadSerialNumber(String r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(load(r2, r3, new AnonymousClass3(this)), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadUdid(String r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(load(r2, r3, new AnonymousClass5(this)), String.class, "com.obric.memorydata.plugin");
    }

    void setSuccessor(Cache r1) {
        this.mSuccessor = r1;
    }
}
