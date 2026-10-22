package com.bytedance.android.livesdk.interactivity.interactive;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g1<T> implements Consumer {
    public final /* synthetic */ Function2 a;

    public g1(Function2 r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        Function2 r0 = this.a;
        pm1.h r1 = pm1.h.d;
        yq1.d r2 = (yq1.d) r1.c(yq1.d.class);
        if (r2 == null) goto L5;
        int r3 = r2.g(r7);
    L6:
        r0.invoke(Integer.valueOf(r3), r7.getMessage());
        if ((r7 instanceof ApiServerException) == false) goto L36;
        yq1.d r4 = (yq1.d) r1.c(yq1.d.class);
        if (r4 == null) goto L11;
        Integer r5 = Integer.valueOf(r4.g(r7));
    L12:
        if (r5 != null) goto L15;
    L17:
        if (r5 != null) goto L20;
    L22:
        if (r5 != null) goto L25;
    L27:
        if (r5 != null) goto L30;
    L32:
        String r8 = BuildConfig.FLAVOR;
    L34:
        if (TextUtils.isEmpty(r8) == true) goto L36;
        f2.c(r8, 0);
        goto L36
    L30:
        if (r5.intValue() != 4008147) goto L32;
        r8 = s1.B(2131922562);
        goto L34
    L25:
        if (r5.intValue() != 4008146) goto L27;
        r8 = s1.B(2131922560);
        goto L34
    L20:
        if (r5.intValue() != 4008145) goto L22;
        r8 = s1.B(2131922563);
        goto L34
    L15:
        if (r5.intValue() != 4008144) goto L17;
        r8 = s1.B(2131922561);
        goto L34
    L11:
        r5 = null;
    L36:
        int r9 = h1.a;
        String r10 = "send comment failed, " + r7.getMessage();
        Intrinsics.checkNotNullParameter(r10, "msg");
        ALogger.i("VSMsgBoard", r10);
        return;
    L5:
        r3 = 0;
        goto L6
    }
}
