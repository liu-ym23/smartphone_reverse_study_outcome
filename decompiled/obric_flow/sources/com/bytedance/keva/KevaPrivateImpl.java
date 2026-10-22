package com.bytedance.keva;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class KevaPrivateImpl extends KevaImpl {
    public KevaPrivateImpl(String r5, int r10) {
        super(r5, r10);
    }

    private Object fetchObject(String r5, Object r10) {
        KevaImpl.KevaValueWrapper r11 = this.mValueMap.get(r5);
        if (r11 != null) goto L5;
        return r10;
    L5:
        if (r11.offset != 0) goto L8;
        return r10;
    L8:
        return r11.value;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r5) {
        monitor-enter(this);
        KevaImpl.KevaValueWrapper r10 = this.mValueMap.get(r5);     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
    L10:
        boolean r11 = false;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r11;
    L6:
        if (r10.offset == 0) goto L10;
        r11 = true;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        monitor-enter(this);
        Iterator<Map.Entry<String, KevaImpl.KevaValueWrapper>> r5 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L9
        int r10 = 0;
    L5:
        if (r5.hasNext() == false) goto L11;
        if (r5.next().getValue().offset == 0) goto L5;
        r10 = r10 + 1;     // Catch: Throwable -> L9
        goto L5
    L11:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r10;
    L9:
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
    public boolean fetchBoolean(String r5, boolean r10) {
        return ((Boolean) fetchObject(r5, Boolean.valueOf(r10))).booleanValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public byte[] fetchBytes(String r11, byte[] r12, int r13, boolean r14) {
        KevaImpl.KevaValueWrapper r5 = this.mValueMap.get(r11);
        if (r5 != null) goto L5;
    L17:
        return r12;
    L5:
        if (r5.offset == 0) goto L17;
        if (r5.loaded == true) goto L16;
        byte[] r10 = fetchBytes(this.mHandle, r11, r5.offset, r12, r13);
        if (r14 == true) goto L13;
        if (r10 == r12) goto L14;
        r5.value = r10;
        r5.loaded = true;
    L14:
        return r10;
    L13:
        r5.value = null;
        r5.loaded = false;
        goto L14
    L16:
        return (byte[]) r5.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public double fetchDouble(String r5, double r10) {
        return ((Double) fetchObject(r5, Double.valueOf(r10))).doubleValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public float fetchFloat(String r5, float r10) {
        return ((Float) fetchObject(r5, Float.valueOf(r10))).floatValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public int fetchInt(String r5, int r10) {
        return ((Integer) fetchObject(r5, Integer.valueOf(r10))).intValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public long fetchLong(String r5, long r10) {
        return ((Long) fetchObject(r5, Long.valueOf(r10))).longValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public String fetchString(String r10, String r11, boolean r12) {
        KevaImpl.KevaValueWrapper r5 = this.mValueMap.get(r10);
        if (r5 != null) goto L5;
    L17:
        return r11;
    L5:
        if (r5.offset == 0) goto L17;
        if (r5.loaded == true) goto L16;
        String r13 = fetchString(this.mHandle, r10, r5.offset, r11);
        if (r12 == true) goto L13;
        if (r13 == r11) goto L14;
        r5.value = r13;
        r5.loaded = true;
    L14:
        return r13;
    L13:
        r5.value = null;
        r5.loaded = false;
        goto L14
    L16:
        return (String) r5.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public String[] fetchStringArray(String r11, String[] r12, boolean r13) {
        KevaImpl.KevaValueWrapper r5 = this.mValueMap.get(r11);
        if (r5 != null) goto L5;
    L17:
        return r12;
    L5:
        if (r5.offset == 0) goto L17;
        if (r5.loaded == true) goto L16;
        String[] r10 = fetchStringArray(this.mHandle, r11, r5.offset, r12, 3);
        if (r13 == true) goto L13;
        if (r10 == r12) goto L14;
        r5.value = r10;
        r5.loaded = true;
    L14:
        return r10;
    L13:
        r5.value = null;
        r5.loaded = false;
        goto L14
    L16:
        return (String[]) r5.value;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        monitor-enter(this);
        Map<String, ?> r5 = generateOutMap();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r5;
    L6:
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
