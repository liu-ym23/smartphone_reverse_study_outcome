package com.bytedance.keva;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public class KevaFuture extends Keva implements Keva.ClearMemory {
    private KevaImpl mFallBackInstance;
    private FutureTask<KevaImpl> mFuture;
    private int mMode;
    private String mName;

    KevaFuture(String r3, int r4, Callable<KevaImpl> r5) {
        Callable r6 = (Callable) ZeusTransformUtils.wrapperContextForParams(r5, Callable.class, "com.obric.memorydata.plugin");
        this.mName = r3;
        this.mMode = r4;
        this.mFuture = new FutureTask(r6);
        KevaImpl.sExecutor.execute(this.mFuture);
    }

    private KevaImpl obtain() {
        return (KevaImpl) ZeusTransformUtils.preCheckCast(this.mFuture.get(), KevaImpl.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        KevaImpl.sMonitor.logDebug("fail to obtain keva future instance");
        KevaImpl.sMonitor.reportThrowable(5, this.mName, null, null, e);
        if (this.mFallBackInstance != null) goto L9;
        KevaImpl r0 = KevaImpl.getEmptyRepoImpl(this.mName, null, this.mMode);
        this.mFallBackInstance = r0;
        r0.init(false);
    L9:
        return this.mFallBackInstance;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> r3) {
        Map<String, Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return obtain().buildNewMap(r4);
    }

    void checkMode(int r2) {
        if (this.mFuture.isDone() == false) goto L6;
        obtain().checkMode(r2);
        return;
    }

    @Override // com.bytedance.keva.Keva
    public void clear() {
        obtain().clear();
    }

    @Override // com.bytedance.keva.Keva.ClearMemory
    public void clearMemory(int r2) {
        if (this.mFuture.isDone() == false) goto L6;
        obtain().clearMemory(r2);
        return;
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r1) {
        return obtain().contains(r1);
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
    public void erase(String r1) {
        obtain().erase(r1);
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        return obtain().getAll();
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r1, boolean r2) {
        return obtain().getBoolean(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r1, byte[] r2) {
        return obtain().getBytes(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r1, byte[] r2) {
        return obtain().getBytesJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r1, double r2) {
        return obtain().getDouble(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r1, float r2) {
        return obtain().getFloat(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r1, int r2) {
        return obtain().getInt(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r1, long r2) {
        return obtain().getLong(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r1, String r2) {
        return obtain().getString(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r1, String[] r2) {
        return obtain().getStringArray(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r1, String[] r2) {
        return obtain().getStringArrayJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r1, String r2) {
        return obtain().getStringJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        return obtain().getStringSet(r3, r5);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        return obtain().getStringSetJustDisk(r3, r5);
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return obtain().name();
    }

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r3) {
        Keva.OnChangeListener r4 = (Keva.OnChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, Keva.OnChangeListener.class, "com.obric.memorydata.plugin");
        obtain().registerChangeListener(r4);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r1, boolean r2) {
        obtain().storeBoolean(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r1, byte[] r2) {
        obtain().storeBytes(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r1, byte[] r2) {
        obtain().storeBytesJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r1, double r2) {
        obtain().storeDouble(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r1, float r2) {
        obtain().storeFloat(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r1, int r2) {
        obtain().storeInt(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r1, long r2) {
        obtain().storeLong(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r1, String r2) {
        obtain().storeString(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r1, String[] r2) {
        obtain().storeStringArray(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r1, String[] r2) {
        obtain().storeStringArrayJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r1, String r2) {
        obtain().storeStringJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        obtain().storeStringSet(r3, r5);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        obtain().storeStringSetJustDisk(r3, r5);
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r3) {
        Keva.OnChangeListener r4 = (Keva.OnChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, Keva.OnChangeListener.class, "com.obric.memorydata.plugin");
        obtain().unRegisterChangeListener(r4);
    }
}
