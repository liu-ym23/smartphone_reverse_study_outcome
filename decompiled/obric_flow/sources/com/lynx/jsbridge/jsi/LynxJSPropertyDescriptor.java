package com.lynx.jsbridge.jsi;

import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LynxJSPropertyDescriptor {
    public final String fieldJNIDescriptor;
    public final String fieldName;

    public LynxJSPropertyDescriptor(String r5, String r10) {
        this.fieldName = r5;
        this.fieldJNIDescriptor = r10;
    }
}
