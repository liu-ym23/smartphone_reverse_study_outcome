package com.lynx.jsbridge;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class MethodDescriptor {
    public Method a;
    public String b;
    public String c;

    public MethodDescriptor() {
    }

    public Method getMethod() {
        return this.a;
    }

    public String getName() {
        return this.c;
    }

    public String getSignature() {
        return this.b;
    }
}
