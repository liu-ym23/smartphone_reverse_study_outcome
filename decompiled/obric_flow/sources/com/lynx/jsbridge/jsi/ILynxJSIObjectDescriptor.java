package com.lynx.jsbridge.jsi;

import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;
import com.lynx.tasm.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ILynxJSIObjectDescriptor {
    String getClassName();

    String[] getFields();

    @CalledByNative
    String[] getLynxObjectDescriptorInfo(String r5);

    void warmUp();
}
