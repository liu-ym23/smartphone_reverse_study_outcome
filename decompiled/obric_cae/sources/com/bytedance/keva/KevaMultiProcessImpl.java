package com.bytedance.keva;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class KevaMultiProcessImpl extends KevaImpl {
    public KevaMultiProcessImpl(String r8, String r10, int r11) {
        super(r8, r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Map buildNewMap(Map r8) {
        return super.buildNewMap(r8);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r8) {
        monitor-enter(this);
        KevaImpl.KevaValueWrapper r10 = this.mValueMap.get(r8);     // Catch: Throwable -> L10
        long r11 = this.mHandle;     // Catch: Throwable -> L10
        if (r10 != null) goto L6;
        long r12 = 0;
    L7:
        boolean r13 = contains(r11, r8, r12);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L15
        return r13;
    L6:
        r12 = r10.offset;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        KevaImpl.sMonitor.reportThrowable(2, name(), r8, null, th);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        monitor-enter(this);
        this.mValueMap.clear();     // Catch: Throwable -> L12
        rebuildValueMap(this.mHandle);     // Catch: Throwable -> L7
        KevaImpl.checkReportException(this.mHandle);     // Catch: Throwable -> L7
        int r8 = this.mValueMap.size();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L12
        return r8;
    L7:
        th = move-exception;
        KevaImpl.sMonitor.reportThrowable(2, name(), null, null, th);     // Catch: Throwable -> L12
        return 0;
    L12:
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
    public /* bridge */ /* synthetic */ void erase(String r8) {
        super.erase(r8);
    }

    @Override // com.bytedance.keva.KevaImpl
    public boolean fetchBoolean(String r10, boolean r11) {
        KevaImpl.KevaValueWrapper r8 = this.mValueMap.get(r10);
        long r12 = this.mHandle;
        if (r8 != null) goto L5;
        long r13 = 0;
    L7:
        return fetchBoolean(r12, r10, r13, r11);
    L5:
        r13 = r8.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public byte[] fetchBytes(String r10, byte[] r11, int r12, boolean r13) {
        KevaImpl.KevaValueWrapper r14 = this.mValueMap.get(r10);
        long r8 = this.mHandle;
        if (r14 != null) goto L5;
        long r15 = 0;
    L7:
        return fetchBytes(r8, r10, r15, r11, r12);
    L5:
        r15 = r14.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public double fetchDouble(String r10, double r11) {
        KevaImpl.KevaValueWrapper r8 = this.mValueMap.get(r10);
        long r12 = this.mHandle;
        if (r8 != null) goto L5;
        long r13 = 0;
    L7:
        return fetchDouble(r12, r10, r13, r11);
    L5:
        r13 = r8.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public float fetchFloat(String r10, float r11) {
        KevaImpl.KevaValueWrapper r8 = this.mValueMap.get(r10);
        long r12 = this.mHandle;
        if (r8 != null) goto L5;
        long r13 = 0;
    L7:
        return fetchFloat(r12, r10, r13, r11);
    L5:
        r13 = r8.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public int fetchInt(String r10, int r11) {
        KevaImpl.KevaValueWrapper r8 = this.mValueMap.get(r10);
        long r12 = this.mHandle;
        if (r8 != null) goto L5;
        long r13 = 0;
    L7:
        return fetchInt(r12, r10, r13, r11);
    L5:
        r13 = r8.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public long fetchLong(String r10, long r11) {
        KevaImpl.KevaValueWrapper r8 = this.mValueMap.get(r10);
        long r12 = this.mHandle;
        if (r8 != null) goto L5;
        long r13 = 0;
    L7:
        return fetchLong(r12, r10, r13, r11);
    L5:
        r13 = r8.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public String fetchString(String r8, String r10, boolean r11) {
        KevaImpl.KevaValueWrapper r12 = this.mValueMap.get(r8);
        long r13 = this.mHandle;
        if (r12 != null) goto L5;
        long r14 = 0;
    L7:
        return fetchString(r13, r8, r14, r10);
    L5:
        r14 = r12.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public String[] fetchStringArray(String r10, String[] r11, boolean r12) {
        KevaImpl.KevaValueWrapper r13 = this.mValueMap.get(r10);
        long r8 = this.mHandle;
        if (r13 != null) goto L5;
        long r14 = 0;
    L7:
        return fetchStringArray(r8, r10, r14, r11, 3);
    L5:
        r14 = r13.offset;
        goto L7
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        monitor-enter(this);
        this.mValueMap.clear();     // Catch: Throwable -> L12
        rebuildValueMap(this.mHandle);     // Catch: Throwable -> L6
        KevaImpl.checkReportException(this.mHandle);     // Catch: Throwable -> L6
    L9:
        Map<String, ?> r8 = buildNewMap(new HashMap());     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r8;
    L6:
        th = move-exception;
        KevaImpl.sMonitor.reportThrowable(2, name(), null, null, th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ boolean getBoolean(String r8, boolean r10) {
        return super.getBoolean(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytes(String r8, byte[] r10) {
        return super.getBytes(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytesJustDisk(String r8, byte[] r10) {
        return super.getBytesJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ double getDouble(String r8, double r10) {
        return super.getDouble(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ float getFloat(String r8, float r10) {
        return super.getFloat(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ int getInt(String r8, int r10) {
        return super.getInt(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ long getLong(String r8, long r10) {
        return super.getLong(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getString(String r8, String r10) {
        return super.getString(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArray(String r8, String[] r10) {
        return super.getStringArray(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArrayJustDisk(String r8, String[] r10) {
        return super.getStringArrayJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getStringJustDisk(String r8, String r10) {
        return super.getStringJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSet(String r8, Set r10) {
        return super.getStringSet(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSetJustDisk(String r8, Set r10) {
        return super.getStringSetJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String name() {
        return super.name();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void registerChangeListener(Keva.OnChangeListener r8) {
        super.registerChangeListener(r8);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBoolean(String r8, boolean r10) {
        super.storeBoolean(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytes(String r8, byte[] r10) {
        super.storeBytes(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytesJustDisk(String r8, byte[] r10) {
        super.storeBytesJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeDouble(String r8, double r10) {
        super.storeDouble(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeFloat(String r8, float r10) {
        super.storeFloat(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeInt(String r8, int r10) {
        super.storeInt(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeLong(String r8, long r10) {
        super.storeLong(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeString(String r8, String r10) {
        super.storeString(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArray(String r8, String[] r10) {
        super.storeStringArray(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArrayJustDisk(String r8, String[] r10) {
        super.storeStringArrayJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringJustDisk(String r8, String r10) {
        super.storeStringJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSet(String r8, Set r10) {
        super.storeStringSet(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSetJustDisk(String r8, Set r10) {
        super.storeStringSetJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void unRegisterChangeListener(Keva.OnChangeListener r8) {
        super.unRegisterChangeListener(r8);
    }
}
