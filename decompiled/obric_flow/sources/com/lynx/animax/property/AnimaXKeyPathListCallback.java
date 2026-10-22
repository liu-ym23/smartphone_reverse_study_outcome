package com.lynx.animax.property;

import androidx.annotation.RestrictTo;
import com.lynx.animax.base.CalledByNative;
import com.lynx.animax.base.bridge.JavaOnlyArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public interface AnimaXKeyPathListCallback {
    void a();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @CalledByNative
    default void onKeyPathListCallback(JavaOnlyArray r5) {
        if (r5 == null) goto L12;
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L5:
        if (r11 >= r5.size()) goto L10;
        if ((r5.get(r11) instanceof JavaOnlyArray) == false) goto L9;
        r10.add(new AnimaXKeyPath((JavaOnlyArray) r5.get(r11)));
    L9:
        r11 = r11 + 1;
        goto L5
    L10:
        a();
        return;
    L12:
        new ArrayList();
        a();
    }
}
