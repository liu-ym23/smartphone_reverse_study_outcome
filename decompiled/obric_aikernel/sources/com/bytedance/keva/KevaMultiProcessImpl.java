package com.bytedance.keva;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class KevaMultiProcessImpl extends KevaImpl {
    KevaMultiProcessImpl(String r10, int r11) {
        super(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Map buildNewMap(Map r10) {
        return super.buildNewMap(r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r10) {
        monitor-enter(this);
        KevaImpl.KevaValueWrapper r11 = this.mValueMap.get(r10);     // Catch: Throwable -> L10
        long r12 = this.mHandle;     // Catch: Throwable -> L10
        if (r11 != null) goto L6;
        long r13 = 0;
    L7:
        boolean r14 = contains(r12, r10, r13);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L14
        return r14;
    L6:
        r13 = r11.offset;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        KevaImpl.sMonitor.reportThrowable(2, name(), r10, null, th);     // Catch: Throwable -> L14
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        monitor-enter(this);
        this.mValueMap.clear();     // Catch: Throwable -> L11
        rebuildValueMap(this.mHandle);     // Catch: Throwable -> L7
        KevaImpl.checkReportException(this.mHandle);     // Catch: Throwable -> L7
        int r10 = this.mValueMap.size();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L11
        return r10;
    L7:
        th = move-exception;
        KevaImpl.sMonitor.reportThrowable(2, name(), null, null, th);     // Catch: Throwable -> L11
        return 0;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void dump() {
        super.dump();
    }

    @Override // com.bytedance.keva.KevaImpl
    public /* bridge */ /* synthetic */ void dumpNative() {
        super.dumpNative();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void erase(String r10) {
        super.erase(r10);
    }

    @Override // com.bytedance.keva.KevaImpl
    protected boolean fetchBoolean(String r10, boolean r11) {
        KevaImpl.KevaValueWrapper r12 = this.mValueMap.get(r10);
        long r13 = this.mHandle;
        if (r12 != null) goto L5;
        long r14 = 0;
    L7:
        return fetchBoolean(r13, r10, r14, r11);
    L5:
        r14 = r12.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    protected byte[] fetchBytes(String r10, byte[] r11, int r12, boolean r13) {
        KevaImpl.KevaValueWrapper r14 = this.mValueMap.get(r10);
        long r15 = this.mHandle;
        if (r14 != null) goto L5;
        long r16 = 0;
    L7:
        return fetchBytes(r15, r10, r16, r11, r12);
    L5:
        r16 = r14.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    protected double fetchDouble(String r10, double r11) {
        KevaImpl.KevaValueWrapper r12 = this.mValueMap.get(r10);
        long r13 = this.mHandle;
        if (r12 != null) goto L5;
        long r14 = 0;
    L7:
        return fetchDouble(r13, r10, r14, r11);
    L5:
        r14 = r12.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    protected float fetchFloat(String r10, float r11) {
        KevaImpl.KevaValueWrapper r12 = this.mValueMap.get(r10);
        long r13 = this.mHandle;
        if (r12 != null) goto L5;
        long r14 = 0;
    L7:
        return fetchFloat(r13, r10, r14, r11);
    L5:
        r14 = r12.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    protected int fetchInt(String r10, int r11) {
        KevaImpl.KevaValueWrapper r12 = this.mValueMap.get(r10);
        long r13 = this.mHandle;
        if (r12 != null) goto L5;
        long r14 = 0;
    L7:
        return fetchInt(r13, r10, r14, r11);
    L5:
        r14 = r12.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    protected long fetchLong(String r10, long r11) {
        KevaImpl.KevaValueWrapper r12 = this.mValueMap.get(r10);
        long r13 = this.mHandle;
        if (r12 != null) goto L5;
        long r14 = 0;
    L7:
        return fetchLong(r13, r10, r14, r11);
    L5:
        r14 = r12.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    protected String fetchString(String r10, String r11, boolean r12) {
        KevaImpl.KevaValueWrapper r13 = this.mValueMap.get(r10);
        long r14 = this.mHandle;
        if (r13 != null) goto L5;
        long r15 = 0;
    L7:
        return fetchString(r14, r10, r15, r11);
    L5:
        r15 = r13.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    protected String[] fetchStringArray(String r10, String[] r11, boolean r12) {
        KevaImpl.KevaValueWrapper r13 = this.mValueMap.get(r10);
        long r14 = this.mHandle;
        if (r13 != null) goto L5;
        long r15 = 0;
    L7:
        return fetchStringArray(r14, r10, r15, r11, 3);
    L5:
        r15 = r13.offset;
        goto L7
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        monitor-enter(this);
        this.mValueMap.clear();     // Catch: Throwable -> L12
        rebuildValueMap(this.mHandle);     // Catch: Throwable -> L6
        KevaImpl.checkReportException(this.mHandle);     // Catch: Throwable -> L6
    L9:
        Map<String, ?> r10 = buildNewMap(new HashMap());     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r10;
    L6:
        th = move-exception;
        KevaImpl.sMonitor.reportThrowable(2, name(), null, null, th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ boolean getBoolean(String r10, boolean r11) {
        return super.getBoolean(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytes(String r10, byte[] r11) {
        return super.getBytes(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytesJustDisk(String r10, byte[] r11) {
        return super.getBytesJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ double getDouble(String r10, double r11) {
        return super.getDouble(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ float getFloat(String r10, float r11) {
        return super.getFloat(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ int getInt(String r10, int r11) {
        return super.getInt(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ long getLong(String r10, long r11) {
        return super.getLong(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getString(String r10, String r11) {
        return super.getString(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArray(String r10, String[] r11) {
        return super.getStringArray(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArrayJustDisk(String r10, String[] r11) {
        return super.getStringArrayJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getStringJustDisk(String r10, String r11) {
        return super.getStringJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSet(String r10, Set r11) {
        return super.getStringSet(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSetJustDisk(String r10, Set r11) {
        return super.getStringSetJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String name() {
        return super.name();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void registerChangeListener(Keva.OnChangeListener r10) {
        super.registerChangeListener(r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBoolean(String r10, boolean r11) {
        super.storeBoolean(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytes(String r10, byte[] r11) {
        super.storeBytes(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytesJustDisk(String r10, byte[] r11) {
        super.storeBytesJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeDouble(String r10, double r11) {
        super.storeDouble(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeFloat(String r10, float r11) {
        super.storeFloat(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeInt(String r10, int r11) {
        super.storeInt(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeLong(String r10, long r11) {
        super.storeLong(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeString(String r10, String r11) {
        super.storeString(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArray(String r10, String[] r11) {
        super.storeStringArray(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArrayJustDisk(String r10, String[] r11) {
        super.storeStringArrayJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringJustDisk(String r10, String r11) {
        super.storeStringJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSet(String r10, Set r11) {
        super.storeStringSet(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSetJustDisk(String r10, Set r11) {
        super.storeStringSetJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void unRegisterChangeListener(Keva.OnChangeListener r10) {
        super.unRegisterChangeListener(r10);
    }
}
