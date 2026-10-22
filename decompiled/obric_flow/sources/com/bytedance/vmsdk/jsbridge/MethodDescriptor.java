package com.bytedance.vmsdk.jsbridge;

import com.bytedance.vmsdk.jsbridge.utils.CalledByNative;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class MethodDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f7552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7554c;

    @CalledByNative
    public Method getMethod() {
        return this.f7552a;
    }

    @CalledByNative
    public String getName() {
        return this.f7554c;
    }

    @CalledByNative
    public String getSignature() {
        return this.f7553b;
    }
}
