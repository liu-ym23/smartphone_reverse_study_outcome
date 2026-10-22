package com.ss.android.lark.librabridge.appsetting;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LibraAppConfigExternalSource implements awa.a {
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    @Inject
    public LibraAppConfigExternalSource() {
        this.a = LazyKt.lazy(LibraAppConfigExternalSource$libraProxy$2.INSTANCE);
    }

    public final Object a(String r4, Class r5, Class r6) {
        Intrinsics.checkNotNullParameter(r4, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r5, "configClass");
        Intrinsics.checkNotNullParameter(r6, "valueClass");
        zpb.a r7 = (zpb.a) this.a.getValue();
        if (r7 != null) goto L11;
        return null;
    L11:
        return r7.getConfig(r4, r6, true);
    L8:
        th = move-exception;
        Log.e("LibraAppConfigExternalSource", "libra getConfig failed, key=" + r4 + " valueClass=" + r6.getName(), th);
        return null;
    }
}
