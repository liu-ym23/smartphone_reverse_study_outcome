package com.bytedance.vmsdk.jsbridge;

import com.bytedance.vmsdk.jsbridge.utils.CalledByNative;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;

/* JADX INFO: loaded from: classes2.dex */
public class AttributeDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JavaOnlyArray f7545b;

    @CalledByNative
    public String getName() {
        return this.f7544a;
    }

    @CalledByNative
    public JavaOnlyArray getValue() {
        return this.f7545b;
    }
}
