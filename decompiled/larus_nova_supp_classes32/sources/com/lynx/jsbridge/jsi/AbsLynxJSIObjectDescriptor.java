package com.lynx.jsbridge.jsi;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class AbsLynxJSIObjectDescriptor implements ILynxJSIObjectDescriptor {
    private volatile ConcurrentHashMap<String, LynxJSPropertyDescriptor> mFieldInfos;
    private volatile String[] mFields;

    public abstract ConcurrentHashMap<String, LynxJSPropertyDescriptor> createFieldInfos();

    @Override // com.lynx.jsbridge.jsi.ILynxJSIObjectDescriptor
    public abstract String getClassName();

    private void ensureFieldInfos() {
        if (this.mFieldInfos == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mFieldInfos == null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L10:
        this.mFieldInfos = createFieldInfos();     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    public AbsLynxJSIObjectDescriptor() {
        this.mFields = null;
        this.mFieldInfos = null;
    }

    @Override // com.lynx.jsbridge.jsi.ILynxJSIObjectDescriptor
    public String[] getFields() {
        ensureFieldInfos();
        if (this.mFields != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.mFields != null) goto L10;
        this.mFields = (String[]) this.mFieldInfos.keySet().toArray(new String[0]);     // Catch: Throwable -> L13
    L10:
        String[] r0 = this.mFields;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.mFields;
    }

    @Override // com.lynx.jsbridge.jsi.ILynxJSIObjectDescriptor
    public void warmUp() {
        ensureFieldInfos();
    }

    @Override // com.lynx.jsbridge.jsi.ILynxJSIObjectDescriptor
    public String[] getLynxObjectDescriptorInfo(String r4) {
        ensureFieldInfos();
        LynxJSPropertyDescriptor r5 = this.mFieldInfos.get(r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new String[]{r5.fieldName, r5.fieldJNIDescriptor};
    }
}
