package com.bytedance.keva;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class KevaPrivateImpl extends KevaImpl {
    public KevaPrivateImpl(String r8, String r10, int r11) {
        super(r8, r10, r11);
    }

    private Object fetchObject(String r8, Object r10) {
        KevaImpl.KevaValueWrapper r11 = this.mValueMap.get(r8);
        if (r11 != null) goto L5;
        return r10;
    L5:
        if (r11.offset != 0) goto L8;
        return r10;
    L8:
        return r11.value;
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
        KevaImpl.KevaValueWrapper r10 = this.mValueMap.get(r8);     // Catch: Throwable -> L11
        if (r10 != null) goto L6;
    L8:
        boolean r11 = false;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r11;
    L6:
        if (r10.offset == 0) goto L8;
        r11 = true;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        monitor-enter(this);
        Iterator<Map.Entry<String, KevaImpl.KevaValueWrapper>> r8 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L11
        int r10 = 0;
    L5:
        if (r8.hasNext() == false) goto L9;
        if (r8.next().getValue().offset == 0) goto L5;
        r10 = r10 + 1;     // Catch: Throwable -> L11
        goto L5
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r10;
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
    public /* bridge */ /* synthetic */ void erase(String r8) {
        super.erase(r8);
    }

    @Override // com.bytedance.keva.KevaImpl
    public boolean fetchBoolean(String r8, boolean r10) {
        return ((Boolean) fetchObject(r8, Boolean.valueOf(r10))).booleanValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public byte[] fetchBytes(String r11, byte[] r12, int r13, boolean r14) {
        KevaImpl.KevaValueWrapper r8 = this.mValueMap.get(r11);
        if (r8 != null) goto L5;
    L18:
        return r12;
    L5:
        if (r8.offset == 0) goto L18;
        if (r8.loaded == true) goto L17;
        byte[] r10 = fetchBytes(this.mHandle, r11, r8.offset, r12, r13);
        if (r14 == true) goto L13;
        if (r10 == r12) goto L15;
        r8.value = r10;
        boolean r15 = true;
    L14:
        r8.loaded = r15;
    L15:
        return r10;
    L13:
        r8.value = null;
        r15 = false;
        goto L14
    L17:
        return (byte[]) r8.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public double fetchDouble(String r8, double r10) {
        return ((Double) fetchObject(r8, Double.valueOf(r10))).doubleValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public float fetchFloat(String r8, float r10) {
        return ((Float) fetchObject(r8, Float.valueOf(r10))).floatValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public int fetchInt(String r8, int r10) {
        return ((Integer) fetchObject(r8, Integer.valueOf(r10))).intValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public long fetchLong(String r8, long r10) {
        return ((Long) fetchObject(r8, Long.valueOf(r10))).longValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public String fetchString(String r10, String r11, boolean r12) {
        KevaImpl.KevaValueWrapper r8 = this.mValueMap.get(r10);
        if (r8 != null) goto L5;
    L18:
        return r11;
    L5:
        if (r8.offset == 0) goto L18;
        if (r8.loaded == true) goto L17;
        String r13 = fetchString(this.mHandle, r10, r8.offset, r11);
        if (r12 == true) goto L13;
        if (r13 == r11) goto L15;
        r8.value = r13;
        boolean r14 = true;
    L14:
        r8.loaded = r14;
    L15:
        return r13;
    L13:
        r8.value = null;
        r14 = false;
        goto L14
    L17:
        return (String) r8.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public String[] fetchStringArray(String r11, String[] r12, boolean r13) {
        KevaImpl.KevaValueWrapper r8 = this.mValueMap.get(r11);
        if (r8 != null) goto L5;
    L18:
        return r12;
    L5:
        if (r8.offset == 0) goto L18;
        if (r8.loaded == true) goto L17;
        String[] r10 = fetchStringArray(this.mHandle, r11, r8.offset, r12, 3);
        if (r13 == true) goto L13;
        if (r10 == r12) goto L15;
        r8.value = r10;
        boolean r14 = true;
    L14:
        r8.loaded = r14;
    L15:
        return r10;
    L13:
        r8.value = null;
        r14 = false;
        goto L14
    L17:
        return (String[]) r8.value;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        monitor-enter(this);
        Map<String, ?> r8 = buildNewMap(new HashMap());     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r8;
    L6:
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
