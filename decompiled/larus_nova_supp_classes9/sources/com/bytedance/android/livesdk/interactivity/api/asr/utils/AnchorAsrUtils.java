package com.bytedance.android.livesdk.interactivity.api.asr.utils;

import com.bytedance.android.livesdk.interactivity.api.f;
import com.bytedance.android.livesdk.interactivity.api.o;
import com.bytedance.live.datacontext.j;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AnchorAsrUtils {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final l22.e b() {
        f r0 = o.b();
        if (r0 == null) goto L9;
        j<l22.a> r1 = r0.getAnchorAsrContext();
        if (r1 == null) goto L9;
        l22.a r2 = (l22.a) r1.getValue();
        if (r2 == null) goto L9;
        return r2.getUserActionCollector();
    L9:
        return null;
    }

    static {
    }

    @JvmStatic
    @CheckReturnValue
    public static final Disposable a(final Function1<? super l22.c, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        f r0 = o.b();
        if (r0 == null) goto L7;
        j<l22.a> r1 = r0.getAnchorAsrContext();
        if (r1 == null) goto L7;
        return n32.a.a(r1, new AnchorAsrUtils$useAsrManager$1(r2));
    L7:
        return null;
    }
}
