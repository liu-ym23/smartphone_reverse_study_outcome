package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test;

import com.bytedance.android.live.core.utils.v;
import kotlin.Lazy;
import kotlin.LazyKt;
import r52.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CarnivalAutoTestUtil {
    public static final boolean a = false;
    public static final Lazy b = null;

    static {
        if (((Boolean) r.a.getValue()).booleanValue() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        a = r0;
        b = LazyKt.lazy(CarnivalAutoTestUtil$bean$2.INSTANCE);
        return;
    L5:
        if (v.a() == false) goto L7;
        r0 = true;
        goto L8
    }

    public static a a() {
        if (v.a() == true) goto L7;
        return null;
    L7:
        return (a) b.getValue();
    }
}
