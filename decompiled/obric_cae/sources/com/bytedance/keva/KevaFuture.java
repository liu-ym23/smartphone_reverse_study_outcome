package com.bytedance.keva;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class KevaFuture extends Keva {
    private KevaImpl mFallBackInstance;
    private FutureTask<KevaImpl> mFuture;
    private int mMode;
    private String mName;

    public KevaFuture(String r8, int r10, Callable<KevaImpl> r11) {
        this.mName = r8;
        this.mMode = r10;
        FutureTask<KevaImpl> r12 = new FutureTask(r11);
        this.mFuture = r12;
        KevaImpl.sExecutor.execute(r12);
    }

    private KevaImpl obtain() {
        return this.mFuture.get();
    L4:
        e = move-exception;
        KevaMonitor r8 = KevaImpl.sMonitor;
        r8.logDebug("fail to obtain keva future instance");
        r8.reportThrowable(5, this.mName, null, null, e);
        if (this.mFallBackInstance != null) goto L9;
        KevaImpl r10 = KevaImpl.getEmptyRepoImpl(this.mName, null, this.mMode);
        this.mFallBackInstance = r10;
        r10.init(false);
    L9:
        return this.mFallBackInstance;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> r8) {
        return obtain().buildNewMap(r8);
    }

    public void checkMode(int r8) {
        if (this.mFuture.isDone() == false) goto L6;
        obtain().checkMode(r8);
        return;
    }

    @Override // com.bytedance.keva.Keva
    public void clear() {
        obtain().clear();
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r8) {
        return obtain().contains(r8);
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        return obtain().count();
    }

    @Override // com.bytedance.keva.Keva
    public void dump() {
        obtain().dump();
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String r8) {
        obtain().erase(r8);
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        return obtain().getAll();
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r8, boolean r10) {
        return obtain().getBoolean(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r8, byte[] r10) {
        return obtain().getBytes(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r8, byte[] r10) {
        return obtain().getBytesJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r8, double r10) {
        return obtain().getDouble(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r8, float r10) {
        return obtain().getFloat(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r8, int r10) {
        return obtain().getInt(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r8, long r10) {
        return obtain().getLong(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r8, String r10) {
        return obtain().getString(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r8, String[] r10) {
        return obtain().getStringArray(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r8, String[] r10) {
        return obtain().getStringArrayJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r8, String r10) {
        return obtain().getStringJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r8, Set<String> r10) {
        return obtain().getStringSet(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r8, Set<String> r10) {
        return obtain().getStringSetJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return obtain().name();
    }

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r8) {
        obtain().registerChangeListener(r8);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r8, boolean r10) {
        obtain().storeBoolean(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r8, byte[] r10) {
        obtain().storeBytes(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r8, byte[] r10) {
        obtain().storeBytesJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r8, double r10) {
        obtain().storeDouble(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r8, float r10) {
        obtain().storeFloat(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r8, int r10) {
        obtain().storeInt(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r8, long r10) {
        obtain().storeLong(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r8, String r10) {
        obtain().storeString(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r8, String[] r10) {
        obtain().storeStringArray(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r8, String[] r10) {
        obtain().storeStringArrayJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r8, String r10) {
        obtain().storeStringJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r8, Set<String> r10) {
        obtain().storeStringSet(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r8, Set<String> r10) {
        obtain().storeStringSetJustDisk(r8, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r8) {
        obtain().unRegisterChangeListener(r8);
    }
}
