package com.bytedance.keva;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class KevaMultiProcessImpl extends KevaImpl {
    public KevaMultiProcessImpl(String r5, int r10) {
        super(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r10) {
        monitor-enter(this);
        KevaImpl.KevaValueWrapper r5 = this.mValueMap.get(r10);     // Catch: Throwable -> L13
        long r11 = this.mHandle;     // Catch: Throwable -> L13
        if (r5 != null) goto L7;
        long r12 = 0;
    L8:
        boolean r13 = contains(r11, r10, r12);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r13;
    L7:
        r12 = r5.offset;     // Catch: Throwable -> L13
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        KevaImpl.sMonitor.reportThrowable(2, name(), r10, null, th);     // Catch: Throwable -> L11
        return false;
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        monitor-enter(this);
        this.mValueMap.clear();     // Catch: Throwable -> L7
        rebuildValueMap(this.mHandle);     // Catch: Throwable -> L9
        KevaImpl.checkReportException(this.mHandle);     // Catch: Throwable -> L9
        int r5 = this.mValueMap.size();     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L7
        return r5;
    L9:
        th = move-exception;
        KevaImpl.sMonitor.reportThrowable(2, name(), null, null, th);     // Catch: Throwable -> L7
        return 0;
    L7:
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
    public /* bridge */ /* synthetic */ void erase(String r5) {
        super.erase(r5);
    }

    @Override // com.bytedance.keva.KevaImpl
    public boolean fetchBoolean(String r10, boolean r11) {
        KevaImpl.KevaValueWrapper r5 = this.mValueMap.get(r10);
        long r12 = this.mHandle;
        if (r5 != null) goto L6;
        long r13 = 0;
    L8:
        return fetchBoolean(r12, r10, r13, r11);
    L6:
        r13 = r5.offset;
        goto L8
    }

    @Override // com.bytedance.keva.KevaImpl
    public byte[] fetchBytes(String r10, byte[] r11, int r12, boolean r13) {
        KevaImpl.KevaValueWrapper r14 = this.mValueMap.get(r10);
        long r5 = this.mHandle;
        if (r14 != null) goto L6;
        long r15 = 0;
    L8:
        return fetchBytes(r5, r10, r15, r11, r12);
    L6:
        r15 = r14.offset;
        goto L8
    }

    @Override // com.bytedance.keva.KevaImpl
    public double fetchDouble(String r10, double r11) {
        KevaImpl.KevaValueWrapper r5 = this.mValueMap.get(r10);
        long r12 = this.mHandle;
        if (r5 != null) goto L6;
        long r13 = 0;
    L8:
        return fetchDouble(r12, r10, r13, r11);
    L6:
        r13 = r5.offset;
        goto L8
    }

    @Override // com.bytedance.keva.KevaImpl
    public float fetchFloat(String r10, float r11) {
        KevaImpl.KevaValueWrapper r5 = this.mValueMap.get(r10);
        long r12 = this.mHandle;
        if (r5 != null) goto L6;
        long r13 = 0;
    L8:
        return fetchFloat(r12, r10, r13, r11);
    L6:
        r13 = r5.offset;
        goto L8
    }

    @Override // com.bytedance.keva.KevaImpl
    public int fetchInt(String r10, int r11) {
        KevaImpl.KevaValueWrapper r5 = this.mValueMap.get(r10);
        long r12 = this.mHandle;
        if (r5 != null) goto L6;
        long r13 = 0;
    L8:
        return fetchInt(r12, r10, r13, r11);
    L6:
        r13 = r5.offset;
        goto L8
    }

    @Override // com.bytedance.keva.KevaImpl
    public long fetchLong(String r10, long r11) {
        KevaImpl.KevaValueWrapper r5 = this.mValueMap.get(r10);
        long r12 = this.mHandle;
        if (r5 != null) goto L6;
        long r13 = 0;
    L8:
        return fetchLong(r12, r10, r13, r11);
    L6:
        r13 = r5.offset;
        goto L8
    }

    @Override // com.bytedance.keva.KevaImpl
    public String fetchString(String r10, String r11, boolean r12) {
        KevaImpl.KevaValueWrapper r13 = this.mValueMap.get(r10);
        long r5 = this.mHandle;
        if (r13 != null) goto L6;
        long r14 = 0;
    L8:
        return fetchString(r5, r10, r14, r11);
    L6:
        r14 = r13.offset;
        goto L8
    }

    @Override // com.bytedance.keva.KevaImpl
    public String[] fetchStringArray(String r10, String[] r11, boolean r12) {
        KevaImpl.KevaValueWrapper r13 = this.mValueMap.get(r10);
        long r5 = this.mHandle;
        if (r13 != null) goto L6;
        long r14 = 0;
    L8:
        return fetchStringArray(r5, r10, r14, r11, 3);
    L6:
        r14 = r13.offset;
        goto L8
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        monitor-enter(this);
        this.mValueMap.clear();     // Catch: Throwable -> L12
        rebuildValueMap(this.mHandle);     // Catch: Throwable -> L6
        KevaImpl.checkReportException(this.mHandle);     // Catch: Throwable -> L6
    L9:
        Map<String, ?> r5 = generateOutMap();     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r5;
    L6:
        th = move-exception;
        KevaImpl.sMonitor.reportThrowable(2, name(), null, null, th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ boolean getBoolean(String r5, boolean r10) {
        return super.getBoolean(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytes(String r5, byte[] r10) {
        return super.getBytes(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytesJustDisk(String r5, byte[] r10) {
        return super.getBytesJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ double getDouble(String r5, double r10) {
        return super.getDouble(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ float getFloat(String r5, float r10) {
        return super.getFloat(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ int getInt(String r5, int r10) {
        return super.getInt(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ long getLong(String r5, long r10) {
        return super.getLong(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getString(String r5, String r10) {
        return super.getString(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArray(String r5, String[] r10) {
        return super.getStringArray(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArrayJustDisk(String r5, String[] r10) {
        return super.getStringArrayJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getStringJustDisk(String r5, String r10) {
        return super.getStringJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSet(String r5, Set r10) {
        return super.getStringSet(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSetJustDisk(String r5, Set r10) {
        return super.getStringSetJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String name() {
        return super.name();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void registerChangeListener(Keva.OnChangeListener r5) {
        super.registerChangeListener(r5);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBoolean(String r5, boolean r10) {
        super.storeBoolean(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytes(String r5, byte[] r10) {
        super.storeBytes(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytesJustDisk(String r5, byte[] r10) {
        super.storeBytesJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeDouble(String r5, double r10) {
        super.storeDouble(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeFloat(String r5, float r10) {
        super.storeFloat(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeInt(String r5, int r10) {
        super.storeInt(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeLong(String r5, long r10) {
        super.storeLong(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeString(String r5, String r10) {
        super.storeString(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArray(String r5, String[] r10) {
        super.storeStringArray(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArrayJustDisk(String r5, String[] r10) {
        super.storeStringArrayJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringJustDisk(String r5, String r10) {
        super.storeStringJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSet(String r5, Set r10) {
        super.storeStringSet(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSetJustDisk(String r5, Set r10) {
        super.storeStringSetJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void unRegisterChangeListener(Keva.OnChangeListener r5) {
        super.unRegisterChangeListener(r5);
    }
}
