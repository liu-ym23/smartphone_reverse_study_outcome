package com.ttnet.org.chromium.base.compat;

import android.annotation.TargetApi;
import android.view.Window;
import com.ttnet.org.chromium.base.annotations.DoNotInline;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(27)
@DoNotInline
public final class ApiHelperForOMR1 {
    private ApiHelperForOMR1() {
    }

    public static boolean isWideColorGamut(Window r8) {
        return r8.isWideColorGamut();
    }
}
