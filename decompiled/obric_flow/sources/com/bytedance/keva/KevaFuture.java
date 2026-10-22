package com.bytedance.keva;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public class KevaFuture extends Keva {
    private KevaImpl mFallBackInstance;
    private FutureTask<KevaImpl> mFuture;
    private int mMode;
    private String mName;

    public KevaFuture(String r5, int r10, Callable<KevaImpl> r11) {
        this.mName = r5;
        this.mMode = r10;
        FutureTask<KevaImpl> r12 = new FutureTask(r11);
        this.mFuture = r12;
        KevaImpl.sExecutor.execute(r12);
    }

    private KevaImpl obtain() {
        return this.mFuture.get();
    L4:
        e = move-exception;
        KevaMonitor r5 = KevaImpl.sMonitor;
        r5.logDebug("fail to obtain keva future instance");
        r5.reportThrowable(5, this.mName, null, null, e);
        if (this.mFallBackInstance != null) goto L9;
        KevaImpl r10 = KevaImpl.getEmptyRepoImpl(this.mName, this.mMode);
        this.mFallBackInstance = r10;
        r10.init(false);
    L9:
        return this.mFallBackInstance;
    }

    public void checkMode(int r5) {
        if (this.mFuture.isDone() == false) goto L6;
        obtain().checkMode(r5);
        return;
    }

    @Override // com.bytedance.keva.Keva
    public void clear() {
        obtain().clear();
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r5) {
        return obtain().contains(r5);
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
    public void erase(String r5) {
        obtain().erase(r5);
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        return obtain().getAll();
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r5, boolean r10) {
        return obtain().getBoolean(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r5, byte[] r10) {
        return obtain().getBytes(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r5, byte[] r10) {
        return obtain().getBytesJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r5, double r10) {
        return obtain().getDouble(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r5, float r10) {
        return obtain().getFloat(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r5, int r10) {
        return obtain().getInt(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r5, long r10) {
        return obtain().getLong(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r5, String r10) {
        return obtain().getString(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r5, String[] r10) {
        return obtain().getStringArray(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r5, String[] r10) {
        return obtain().getStringArrayJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r5, String r10) {
        return obtain().getStringJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r5, Set<String> r10) {
        return obtain().getStringSet(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r5, Set<String> r10) {
        return obtain().getStringSetJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return obtain().name();
    }

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r5) {
        obtain().registerChangeListener(r5);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r5, boolean r10) {
        obtain().storeBoolean(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r5, byte[] r10) {
        obtain().storeBytes(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r5, byte[] r10) {
        obtain().storeBytesJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r5, double r10) {
        obtain().storeDouble(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r5, float r10) {
        obtain().storeFloat(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r5, int r10) {
        obtain().storeInt(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r5, long r10) {
        obtain().storeLong(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r5, String r10) {
        obtain().storeString(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r5, String[] r10) {
        obtain().storeStringArray(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r5, String[] r10) {
        obtain().storeStringArrayJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r5, String r10) {
        obtain().storeStringJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r5, Set<String> r10) {
        obtain().storeStringSet(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r5, Set<String> r10) {
        obtain().storeStringSetJustDisk(r5, r10);
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r5) {
        obtain().unRegisterChangeListener(r5);
    }
}
