package com.lynx.animax.property;

import androidx.annotation.RestrictTo;
import com.lynx.animax.base.CalledByNative;
import com.lynx.animax.base.bridge.JavaOnlyArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public interface AnimaXPropertyCallback {
    void a();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @CalledByNative
    default void onPropertyCallback(JavaOnlyArray r5) {
        if (r5 != null) goto L4;
    L15:
        onSuccess();
        return;
    L4:
        if (r5.isEmpty() == true) goto L15;
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L8:
        if (r11 >= r5.size()) goto L13;
        Object r12 = r5.get(r11);
        if ((r12 instanceof String) == false) goto L12;
        r10.add((String) r12);
    L12:
        r11 = r11 + 1;
        goto L8
    L13:
        a();
    }

    void onSuccess();
}
