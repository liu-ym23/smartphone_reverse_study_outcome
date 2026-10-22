package com.bytedance.android.live.browser.jsbridge;

import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.browser.jsbridge.newmethods.d2;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeMethodFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements IJsBridgeMethodFactory {
    public l() {
    }

    public final com.bytedance.ies.web.jsbridge2.g<?, ?> provideCloseMethod(DialogFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "dialogFragment");
        return new d2(r2);
    }
}
