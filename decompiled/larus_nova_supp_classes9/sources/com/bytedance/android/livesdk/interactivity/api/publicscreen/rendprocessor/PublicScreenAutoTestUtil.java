package com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.b4;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PublicScreenAutoTestUtil {
    public static final boolean a = false;
    public static final Lazy b = null;

    static {
        if (((Boolean) b4.a.getValue()).booleanValue() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        a = r0;
        b = LazyKt.lazy(PublicScreenAutoTestUtil$publicScreenUrlList$2.INSTANCE);
        return;
    L5:
        if (v.a() == false) goto L7;
        r0 = true;
        goto L8
    }
}
