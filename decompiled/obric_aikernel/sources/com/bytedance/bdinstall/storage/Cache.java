package com.bytedance.bdinstall.storage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class Cache implements ICache {
    private Cache mSuccessor;

    interface ICacheAgent<L> {
        boolean checkValid(L r10);

        L getCache();

        boolean isValueEqual(L r10, L r11);

        L load(L r10, L r11, Cache r12);

        void restoreCache(L r10);
    }

    public Cache() {
    }

    private Cache getSuccessor() {
        return this.mSuccessor;
    }

    private <T> T load(T r10, T r11, ICacheAgent<T> r12) {
        if (r12 == null) goto L26;
        Cache r13 = getSuccessor();
        T r14 = r12.getCache();
        boolean r15 = r12.checkValid(r10);
        boolean r16 = r12.checkValid(r14);
        if (r15 == true) goto L7;
        if (r16 == false) goto L7;
        r10 = r14;
    L7:
        if (r13 == null) goto L12;
        T r17 = r12.load(r10, r11, r13);
        if (r12.isValueEqual(r17, r14) == true) goto L11;
        r12.restoreCache(r17);
    L11:
        return r17;
    L12:
        boolean r18 = false;
        if (r15 == true) goto L16;
        if (r16 == true) goto L16;
        r18 = true;
    L17:
        if (r18 == true) goto L19;
    L20:
        if (r15 == true) goto L22;
    L24:
        return r11;
    L22:
        if (r12.isValueEqual(r11, r14) == true) goto L24;
    L23:
        r12.restoreCache(r11);
        goto L24
    L19:
        if (r12.checkValid(r11) == true) goto L23;
    L16:
        r11 = r10;
        goto L17
    L26:
        throw new IllegalArgumentException("agent == null");
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public abstract void cacheString(String r10, String r11);

    protected abstract void cacheStringArray(String r10, String[] r11);

    @Override // com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> r10) {
        Cache r11 = getSuccessor();
        if (r11 == null) goto L6;
        r11.clear(r10);
        return;
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public abstract String getCachedString(String r10);

    protected abstract String[] getCachedStringArray(String r10);

    @Override // com.bytedance.bdinstall.storage.ICache
    public String[] loadAccId(String[] r10, String[] r11) {
        return (String[]) load(r10, r11, new AnonymousClass4(this));
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadClientUdid(String r10, String r11) {
        return (String) load(r10, r11, new AnonymousClass2(this));
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadDeviceId(String r10, String r11) {
        return (String) load(r10, r11, new AnonymousClass6(this));
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadOpenUdid(String r10, String r11) {
        return (String) load(r10, r11, new AnonymousClass1(this));
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadSerialNumber(String r10, String r11) {
        return (String) load(r10, r11, new AnonymousClass3(this));
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadUdid(String r10, String r11) {
        return (String) load(r10, r11, new AnonymousClass5(this));
    }

    void setSuccessor(Cache r10) {
        this.mSuccessor = r10;
    }
}
