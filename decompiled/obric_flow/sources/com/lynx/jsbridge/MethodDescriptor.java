package com.lynx.jsbridge;

import com.lynx.tasm.base.CalledByNative;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class MethodDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f9898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9900c;

    @CalledByNative
    public Method getMethod() {
        return this.f9898a;
    }

    @CalledByNative
    public String getName() {
        return this.f9900c;
    }

    @CalledByNative
    public String getSignature() {
        return this.f9899b;
    }
}
