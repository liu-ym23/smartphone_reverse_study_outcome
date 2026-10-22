package com.lynx.jsbridge;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class AttributeDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JavaOnlyArray f9891b;

    public AttributeDescriptor(String r5, JavaOnlyArray r10) {
        this.f9890a = r5;
        this.f9891b = r10;
    }

    @CalledByNative
    public String getName() {
        return this.f9890a;
    }

    @CalledByNative
    public JavaOnlyArray getValue() {
        return this.f9891b;
    }
}
