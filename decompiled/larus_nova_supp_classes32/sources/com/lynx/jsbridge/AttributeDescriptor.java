package com.lynx.jsbridge;

import com.lynx.react.bridge.JavaOnlyArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AttributeDescriptor {
    public final String a;
    public final JavaOnlyArray b;

    public String getName() {
        return this.a;
    }

    public JavaOnlyArray getValue() {
        return this.b;
    }

    public AttributeDescriptor(String r1, JavaOnlyArray r2) {
        this.a = r1;
        this.b = r2;
    }
}
