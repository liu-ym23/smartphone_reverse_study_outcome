package com.lynx.animax.property;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.lynx.animax.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public interface AnimaXValueCallback {
    AnimaXValueParam getValue();

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @CalledByNative
    default Object getValueInternal(float r5, float r10, AnimaXValueParam r11, AnimaXValueParam r12, float r13, float r14, float r15) {
        return getValue();
    }
}
