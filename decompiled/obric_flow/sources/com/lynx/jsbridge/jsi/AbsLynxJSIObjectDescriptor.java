package com.lynx.jsbridge.jsi;

import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class AbsLynxJSIObjectDescriptor implements ILynxJSIObjectDescriptor {
    private volatile ConcurrentHashMap<String, LynxJSPropertyDescriptor> mFieldInfos;
    private volatile String[] mFields;

    public AbsLynxJSIObjectDescriptor() {
        this.mFields = null;
        this.mFieldInfos = null;
    }

    private void ensureFieldInfos() {
        if (this.mFieldInfos == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.mFieldInfos == null) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L12:
        this.mFieldInfos = createFieldInfos();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    public abstract ConcurrentHashMap<String, LynxJSPropertyDescriptor> createFieldInfos();

    @Override // com.lynx.jsbridge.jsi.ILynxJSIObjectDescriptor
    public abstract String getClassName();

    @Override // com.lynx.jsbridge.jsi.ILynxJSIObjectDescriptor
    public String[] getFields() {
        ensureFieldInfos();
        if (this.mFields != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mFields != null) goto L12;
        this.mFields = (String[]) this.mFieldInfos.keySet().toArray(new String[0]);     // Catch: Throwable -> L10
    L12:
        String[] r5 = this.mFields;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r5;
    L5:
        return this.mFields;
    }

    @Override // com.lynx.jsbridge.jsi.ILynxJSIObjectDescriptor
    public String[] getLynxObjectDescriptorInfo(String r5) {
        ensureFieldInfos();
        LynxJSPropertyDescriptor r10 = this.mFieldInfos.get(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        return new String[]{r10.fieldName, r10.fieldJNIDescriptor};
    }

    @Override // com.lynx.jsbridge.jsi.ILynxJSIObjectDescriptor
    public void warmUp() {
        ensureFieldInfos();
    }
}
